package org.noaaideacenter.paws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * This class will handle the actual insert and delete functions for almost all tables that have 
 * project id followed by zero or more bits 
 * @author Uday
 *
 */
public class ParameterDAO 
{
	private DataSource ds;
	
	 public void setDataSource(DataSource dataSsrc)
	 {
		 this.ds = dataSsrc; 
	 }
	 public DataSource getDataSource()
	 {
		 return this.ds;
	 }

    public static boolean parse (String str)
    {
    	String trimmed = StringUtils.trimToEmpty(str);
    	
      if (StringUtils.isBlank(trimmed))
      {
    	  return false;
      }
      else if (StringUtils.equalsIgnoreCase(str, "y"))
      {
    	  return true;
      }
      else if (StringUtils.equalsIgnoreCase(str, "yes"))
      {
    	  return true;
      }
      else if (StringUtils.equalsIgnoreCase(str, "on"))
      {
    	  return true;
      }
      else if (StringUtils.equalsIgnoreCase(str, "1"))
      {
    	  return true;
      }
      else if (StringUtils.equalsIgnoreCase(str, "t"))
      {
    	  return true;
      }
      else if (StringUtils.equalsIgnoreCase(str, "true"))
      {
    	  return true;
      }
      else if (NumberUtils.toInt(str) == 1)
      {
    	  return true;
      }
      else
      {
    	  return false;
      }
    }

    public static boolean parse (Object obj)
    {
    	if (obj == null)
    	{
    		return false;
    	}
    	else
    	{
    	  return parse (obj.toString());
    	}
    }

	public  String paramlist (String [] columns)
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("(project");
		
		for (int i = 0; i < columns.length; i++)
		{
			sb.append(",");
			sb.append(columns[i]);
		}
		
		sb.append(")");
		
		
		return sb.toString();
	}

	public  String questions (int size)
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("(?"); // the first question mark is for project 
		
		for (int i = 0; i < size; i++)
		{
			sb.append(",?");
		}
		
		sb.append(")");
		
		
		return sb.toString();
	}

	 /**
	  * Core insert method.  Will only need to add project if any of the columns are checked.  
	  * @param tablename
	  * @param project
	  * @param columns
	  * @param values
	  * @throws SQLException
	  */
    public  void insert (String tablename, int project, String [] columns, boolean [] values) throws SQLException
    {
    	  System.out.println("inserting " +  project + " into " + tablename);

    	  Connection con = null;
        PreparedStatement insertStmt = null;
   		  
        String insertString = "INSERT INTO " + tablename + paramlist(columns) + " VALUES " 
        	                  + questions(columns.length);
   		
        if (anyValueisTrue(values))
        {
   		  
          try 
          {
            con = getConnection("insert");
            System.out.println("INSERT " + tablename + "...Successfully opened database connection to insert");
            System.out.println("insertString = " + insertString);
    
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertString);
  
            insertStmt.setInt(1, project);
            
            for (int i = 0; i < columns.length; i++)
            {
              insertStmt.setBoolean(i+2, values[i]);
            }
  
            delete(tablename,project);  //  this will always ensure over-write and no duplicates
            insertStmt.execute();
  
            con.commit();
          }
          catch (SQLException e)
          {
             System.out.println(e);
          }
          finally
          {
             insertStmt.close();
             con.setAutoCommit(true);
             System.out.println("Success...INSERTED Project # " + project + " INTO table " + tablename + " columns are as below:");
             for (int i = 0; i < columns.length; i++)
             {
           	  System.out.println(columns[i] + " = " + values[i]);
             }
             con.close();
          }
        }
        else
        {
        	// none of the values were true, so reject adding project
      	  System.out.println("Did NOT insert " +  project + " into " + tablename + " because all its columns were not set" );
        }
    }

    
    public  void insert (String tablename, int project, String [] columns, String [] values) throws SQLException
    {
      boolean [] bvalues = new boolean [values.length];
      for (int i = 0; i < values.length; i++) bvalues[i] = parse(values[i]);
      insert(tablename, project, columns, bvalues);
    }

    public  void insert (String tablename, String project, String [] columns, String [] values) throws SQLException
    {
      insert(tablename, NumberUtils.toInt(project), columns, values);
    }

    public  void insert (String tablename, int project) throws SQLException
    {
      String [] columns = new String [0];
      String [] values  = new String [0];
      insert(tablename, project, columns, values);
    }

    public  void insert (String tablename, String project) throws SQLException
    {
      insert(tablename, NumberUtils.toInt(project));
    }

    
    public  void delete(String tablename, String projectid) throws SQLException
    {
      delete (tablename, NumberUtils.toInt(projectid));
    }
    
    public  void delete(String tablename, int projectid) throws SQLException 
    {
      Connection con = null;
      PreparedStatement deleteStmt = null;
 		  
      String deleteSql = "DELETE FROM " + tablename + " WHERE project = ?";
 	  
 	  
      try 
      {
        con = getConnection("delete");
        System.out.println("DELETE FROM " + tablename + "...Successfully opened database connection to DELETE");
 			  
        con.setAutoCommit(false);
        deleteStmt = con.prepareStatement(deleteSql);
        deleteStmt.setInt(1, projectid);
        deleteStmt.execute();
        con.commit();
      }
      catch (SQLException e)
      {
        System.out.println(e);
      }
      finally
      {
        deleteStmt.close();
        con.setAutoCommit(true);
        System.out.println("Success...DELETED Project  " + projectid + " from table " + tablename);    
        con.close();
      }
    }

    public  void deleteAgency(String acronym) 
    {
      Connection con = null;
      PreparedStatement deleteStmt = null;
 		  
      String deleteSql = "DELETE FROM organizations WHERE acronym = ?";
 	  
 	  
      try 
      {
        con = getConnection("deleteAgency");
        System.out.println(deleteSql);
 			  
        con.setAutoCommit(false);
        deleteStmt = con.prepareStatement(deleteSql);
        deleteStmt.setString(1, StringUtils.trimToEmpty(acronym));
        deleteStmt.execute();
        con.commit();
      }
      catch (SQLException e)
      {
        System.out.println(e);
      }
      finally
      {
    	try
    	{
          deleteStmt.close();
          con.setAutoCommit(true);
          System.out.println("Success...DELETED Agency  " + acronym);    
          con.close();
    	}
    	catch (Exception e)
    	{
    		
    	}
      }
    }

    public  void insertContact (int project, String contact, String email)
    {
    	
    	ResultSet rs = null;
      Connection con = null;
      
      int key = -1;
      Statement stmt = null;
      
      PreparedStatement insertStmt1 = null;
      PreparedStatement insertStmt2 = null;
 		  
      String insertStr1 = "INSERT INTO contacts (naam, email)  VALUES (?,?)"; 
      String insertStr2 = "INSERT INTO poc  (project, contact)  VALUES (?,?)"; 
 		  
      try 
      {
        con = getConnection("insertContact");
        System.out.println("INSERT CONTACTS...Successfully opened database connection to insert");
        System.out.println("insertString = " + insertStr1);

        con.setAutoCommit(false);
        
        insertStmt1 = con.prepareStatement(insertStr1);
        insertStmt2 = con.prepareStatement(insertStr2);
        stmt        = con.createStatement();

        insertStmt1.setString(1, StringUtils.trimToEmpty(contact));
        insertStmt1.setString(2, StringUtils.trimToEmpty(email));
          
        if (StringUtils.isNotBlank(contact) || StringUtils.isNotBlank(email)) 
        {
         	// insert only if contact field or email field is non-empty.
          if (stmt.executeUpdate(insertStmt1.toString(), Statement.RETURN_GENERATED_KEYS) > 0)
          {
            System.out.println("Getting contact autogenerated key...");
            rs = stmt.getGeneratedKeys(); 
            while (rs.next()) 
            {
              key = rs.getInt("contact");     
              System.out.println("Got it contact autogenerated key = " + key+ " for " + contact);
              insertStmt2.setInt(1, project);
              insertStmt2.setInt(2, key);
              insertStmt2.execute();
           	}        
          }
          else
          {
           	System.out.println("execute " +  insertStmt1 + " returned FALSE...there are no results");
          }
        }
        con.commit();
        System.out.println("Inserted " + contact + ", " + email);
      }
      catch (SQLException e)
      {
         System.out.println(e);
         System.out.println("query 1 = " + insertStmt1);
         System.out.println("query 2 = " + insertStmt2);
      }
      finally
      {
      	 try
      	 {
            con.setAutoCommit(true);
            
      		  if (rs != null) rs.close();
      	    if (insertStmt1 != null) insertStmt1.close();
      	    if (insertStmt2 != null) insertStmt2.close();
      	    if (con != null ) con.close();
             if (key > 0)
             {
               System.out.println("Success...INSERTED contact " + contact + " for Project # " + project + " INTO table CONTACTS, POC");
             }
             else
             {
            	 System.out.println("FAILED...to INSERT contact " + contact + " for Project # " + project + " INTO table CONTACTS, POC");
             }
      	 }
      	 catch (Exception s)
      	 {
      		 System.out.println("insert Contact Err " + s);
      	 }
      }
    }

    public  void insertContact (int project, String [] contacts, String [] emails) 
    {
    	for (int i = 0; i < contacts.length; i++)
    	{
    		System.out.println("insertContact (" + project + ", " + contacts[i] + ", " +emails[i]);
        if (StringUtils.isNotBlank(contacts[i]) || StringUtils.isNotBlank(emails[i]))
        {
    	    insertContact (project, StringUtils.trimToEmpty(contacts[i]), StringUtils.trimToEmpty(emails[i]));
        }
    	}
    }
    

    public void addAgencies(String [] acronyms, String [] descriptions)
    {
    	// first delete the "other" agency
    	//this.deleteAgency("Other");
    	System.out.println("Entered ParaneterDAO Add Agencies " );
    	Connection con = null;
        PreparedStatement insertStmt = null;
    	String insertString = "INSERT INTO ORGANIZATIONS (acronym, description) VALUES (?,?)";
        try 
        {
          con = getConnection("addAgencies");
          System.out.println("insertString = " + insertString);

          con.setAutoCommit(false);
          insertStmt = con.prepareStatement(insertString);

          for (int i = 0; i < descriptions.length; i++)
          {
        	if (StringUtils.isNotBlank(acronyms[i]) && StringUtils.isNotBlank(descriptions[i]))
        	{
              insertStmt.setString(1, StringUtils.trimToEmpty(acronyms[i]));
              insertStmt.setString(2, StringUtils.trimToEmpty(descriptions[i]));
           	  insertStmt.execute();
        	}
        	else
        	{
        	  //System.out.println("Rejecting adding Agency " + StringUtils.trimToEmpty(acronyms[i]) + ", " + StringUtils.trimToEmpty(descriptions[i]) + ": one of them is EMPTY." );
        	}
          }
          
          // add the other agency back
          //insertStmt.setString(1, StringUtils.trimToEmpty("Other"));
          //insertStmt.setString(2, StringUtils.trimToEmpty("Organization Yet to be Added to PaCIS"));
       	  //insertStmt.execute();
          
          con.commit();
        }
        catch (SQLException e)
        {
           System.out.println(e);
        }
        finally
        {
           try
           {
             insertStmt.close();
             con.setAutoCommit(true);
             System.out.println("Success...INSERTED the following new Agencies: " );
             for (int i = 0; i < acronyms.length; i++)
             {
             	if (StringUtils.isNotBlank(acronyms[i]) && StringUtils.isNotBlank(descriptions[i]))
            	{
             		System.out.println(StringUtils.trimToEmpty(acronyms[i]) + ", " + StringUtils.trimToEmpty(descriptions[i]));
            	}
             }
             con.close();
           }
           catch (Exception e)
           {
        	   
           }
        }
    }
    
    public  void insertAgencies(String tablename, int project, int agencies []) throws SQLException
    {
      Connection con = null;
      PreparedStatement insertStmt = null;
 		  
      String insertString = "INSERT INTO " + tablename + "(project, agency)  VALUES (?,?)"; 
 		  
      try 
      {
        con = getConnection("insertAgencies");
        System.out.println("INSERT into  " + tablename + "...Successfully opened database connection to insert");
        System.out.println("insertString = " + insertString);

        con.setAutoCommit(false);
        insertStmt = con.prepareStatement(insertString);

        delete(tablename,project);
        for (int i = 0; i < agencies.length; i++)
        {
          insertStmt.setInt(1, project);
          insertStmt.setInt(2, agencies[i]);
          
          // if agency ID=0 is selected from any list it should be skipped
          if (agencies[i] > 0)
          {
          	insertStmt.execute();
          }
          else
          {
          	System.out.println("REJECTED insert agency=0 for Project " + project + " in " + tablename);
          }
        }
        con.commit();
      }
      catch (SQLException e)
      {
         System.out.println(e);
      }
      finally
      {
         insertStmt.close();
         con.setAutoCommit(true);
         System.out.println("Success...INSERTED Project # " + project + " INTO table " + tablename);
         for (int i = 0; i < agencies.length; i++)
         {
       	   if (agencies[i]>0) System.out.println("Agency = " + agencies[i]);
         }
         con.close();
      }
    }

    public  void insertAgencies(String tablename, String project, String agencies []) throws SQLException
    {
    	insertAgencies(tablename, NumberUtils.toInt(project), agencies);
    }

    public  void insertAgencies(String tablename, int project, String agencies []) throws SQLException
    {
    	int [] organizations = new int [agencies.length];
    	for (int i = 0; i < agencies.length; i++) organizations[i]=NumberUtils.toInt(agencies[i]);
    	insertAgencies(tablename, project, organizations);
    }
    
    public  int addProject(String tag, int code, String projectname, String projectdescription, 
                                             int status, String worksheet, String url) throws SQLException
    {
      Connection con = null;
      PreparedStatement insertStmt = null;
      Statement stmt = null; 
      int key = -1;
      
      String insertString = 
      	"INSERT INTO PROJECTS (tag, code, nametitle, description, status, worksheet, deleted, url)  " +
      	"   VALUES   (?,?,?,?,?,?,?,?)"; 
 		  
      try 
      {
        con = getConnection("addProject");
        System.out.println("adding PROJECT " + projectname + ", opened DB connection.");
        System.out.println("insertString = " + insertString);

        con.setAutoCommit(false);
        insertStmt = con.prepareStatement(insertString);
        stmt = con.createStatement();

        insertStmt.setString(1, StringUtils.trimToEmpty(tag));
        insertStmt.setInt(2, code);
        insertStmt.setString(3, StringUtils.trimToEmpty(projectname));
        insertStmt.setString(4, StringUtils.trimToEmpty(projectdescription));
        insertStmt.setInt(5, status);
        insertStmt.setString(6, StringUtils.trimToEmpty(worksheet));
        insertStmt.setBoolean(7, Boolean.FALSE);
        insertStmt.setString(8, StringUtils.trimToEmpty(url));

        System.out.println("Done with setting insertStmt parameters = " + insertStmt.toString());
        
        // String [] prcol = new String [1];  prcol[0] = "project";
        
        //if (stmt.executeUpdate(insertStmt.toString(), prcol) > 0)
        if (stmt.executeUpdate(insertStmt.toString(), Statement.RETURN_GENERATED_KEYS) > 0)
        {
        	System.out.println("Getting keys...");
        	ResultSet rs = stmt.getGeneratedKeys(); 
        	while (rs.next()) 
        	{
        	  key = rs.getInt("project");     
        	}        
        }
        else
        {
        	System.out.println("execute returned FALSE...there are no results");
        }
        System.out.println("autogenerated project number is =  " + key);
        con.commit();
      }
      catch (SQLException e)
      {
         System.out.println(e);
      }
      finally
      {
         insertStmt.close();
         con.setAutoCommit(true);
         if (key > -1) System.out.println("Success...INSERTED Project " + key + ", " + projectname);
         else System.out.println("FAILURE...could not INSERT Project");
         con.close();
      }
      
      return key;

    }

    
    public  void updateProject(int project, String name, String details, int status, String worksheetname, String tag) throws SQLException
    {
      Connection con = null;
      PreparedStatement updateStmt = null;
 		  
      String updateString = "UPDATE PROJECTS SET nametitle = ?, SET status = ?, SET description = ?, " + 
                            "SET worksheet = ?  SET tag = ? WHERE project = ?"; 
 		  
      try 
      {
        con = getConnection("updateProject");
        System.out.println("UPDATE PROJECTS...Successfully opened database connection to insert");
        System.out.println("updateString= " + updateString);

        con.setAutoCommit(false);
        updateStmt= con.prepareStatement(updateString);

        updateStmt.setString(1, StringUtils.trimToEmpty(name));
        updateStmt.setInt(2, status);
        updateStmt.setString(3, StringUtils.trimToEmpty(details));
        updateStmt.setString(4, StringUtils.trimToEmpty(worksheetname));
        updateStmt.setString(5, StringUtils.trimToEmpty(tag));
        updateStmt.setInt(6,project);
        
        updateStmt.executeUpdate();
        
        con.commit();
      }
      catch (SQLException e)
      {
         System.out.println(e);
      }
      finally
      {
      	 updateStmt.close();
         con.setAutoCommit(true);
         System.out.println("Success...UPDATED Project " + project + ", " + name);
         con.close();
      }
    }

    public  void updateProject(int project, String name, String details, String status, String worksheetname, String tag) throws SQLException
    {
    	updateProject(project, name, details, NumberUtils.toInt(status), worksheetname, tag);
    }
    public  void updateProject(String project, String name, String details, String status, String worksheetname, String tag) throws SQLException
    {
    	updateProject(NumberUtils.toInt(project), name, details, status, worksheetname, tag);
    }


  
    public  void deleteProject(int project, boolean deleteFlag) throws SQLException
    {
      Connection con = null;
      PreparedStatement updateStmt = null;
 		  
      String updateString = "UPDATE PROJECTS SET deleted = ? WHERE project = ?"; 
 		  
      try 
      {
        con = getConnection("deleteProject");
        System.out.println("UPDATE PROJECTS...Successfully opened database connection to DELETE " + project);
        System.out.println("updateString= " + updateString);

        con.setAutoCommit(false);
        updateStmt= con.prepareStatement(updateString);

        if (deleteFlag) updateStmt.setBoolean(1, Boolean.TRUE);
        else            updateStmt.setBoolean(1, Boolean.FALSE);
        updateStmt.setInt(2,project);
        
        updateStmt.executeUpdate();
        
        con.commit();
      }
      catch (SQLException e)
      {
         System.out.println(e);
      }
      finally
      {
      	 updateStmt.close();
         con.setAutoCommit(true);
         System.out.println("Success...Deleted Project " + project);
         con.close();
      }
    }
    
    /**
     * Delete Project
     * @param project
     * @throws SQLException
     */
    public  void deleteProject(String project)
    {
    	try
    	{
    	  deleteProject(NumberUtils.toInt(project), true);
    	}
    	catch (SQLException e)
    	{
    		System.out.println("Could not...Close the statement for Deleted Project " + project); 	
    	}
    }  

    public  void deleteProject(String [] projects) 
    {
    	if (projects == null)
    	{
    		// nothing to do
    	}
    	else if (projects.length == 0)
    	{
    		// nothing to do
    	}
    	else
    	{
    		for (int i = 0; i < projects.length; i++)
    		{
    	    deleteProject(projects[i]);
    		}
    	}
    }  
    
    
    /**
     * UnDelete Project
     * @param project
     * @throws SQLException
     */
    public  void unDeleteProject(String project) 
    {
    	try
    	{
    	  deleteProject(NumberUtils.toInt(project), false);
    	}
    	catch (SQLException e)
    	{
    		System.out.println("Swallowed stmt close exception when UNDELETING " + project);
    	}
    }    
    
    public  void unDeleteAllProjects() 
    {
      Connection con = null;
      PreparedStatement updateStmt = null;
 		  
      String updateString = "UPDATE PROJECTS SET DELETED = false"; 
 		  
      try 
      {
        con = getConnection("undeleteAllProjects");
        System.out.println("unDeleteAllProjects = " + updateString);
        con.setAutoCommit(false);
        updateStmt= con.prepareStatement(updateString);
        updateStmt.executeUpdate();
        con.commit();
      }
      catch (SQLException e)
      {
         System.out.println("unDeleteAllProjects " + e);
      }
      finally
      {
      	 try
      	 {
      	   updateStmt.close();
           con.setAutoCommit(true);
           con.close();
      	 }
      	 catch (Exception e)
      	 {
      		 System.out.println("unDeleteAllProjects finally " + e);
      	 }
      }
    }
    
  
  public static boolean anyValueisTrue (boolean values[])
  {
  	boolean result = false;
  	
  	// no judgment can be made if there are no values...  
  	if (values == null || values.length == 0) return true;
  	
  	for (int i = 0; i < values.length; i++)
  	{
  		if (values[i]) 
  		{
  			result = true;
  			break;
  		}
  	}
  	return result;
  }

  public ProjectBean getJustOneProject(String project)
  {
	System.out.println("Requesting Database retrieval of \"just one project\" (String) =  " + project);
    if (NumberUtils.toInt(project) > 0)
    {
    	 return getJustOneProject(NumberUtils.toInt(project));
    }    
    else
    {
    	System.out.println("Never even made it to the database: Empty project retrieved");
    	return new ProjectBean();
    }
  }
  
  public ProjectBean getJustOneProject(int project)
  {
  	ResultSet rs    = null;
    Connection con  = null;
    Statement  stmt = null;
    
    ProjectBean pb = new ProjectBean();
    boolean returningDummy = true;
    if (project > 0)
    {
    
      String queryString = "SELECT * FROM oj WHERE project = " + project; // can be any one project, so include deleted
      System.out.println("getting just one project " + queryString);
      
      try 
      {
        con = getConnection("getJustOneProject");
        stmt = con.createStatement();
        rs = stmt.executeQuery(queryString);
        while (rs.next()) 
        {
        	returningDummy = false;
        	setProjectBean(pb,rs); // set(map) pb = rs
        	setProjectBeanContacts(pb);
        	setProjectBeanLeadAgencies(pb); 
        	setProjectBeanPartnerAgencies(pb); 
        }
      } catch (SQLException e ) 
      {
        System.out.println("Database Query Error in getJustOneProject " + e);
      } 
      finally 
      {
      	try
      	{
      	  rs.close();	
          stmt.close();
      		con.close();
      	}
      	catch (Exception e)
      	{
      		System.out.println("Database connection error in getJustOneProject " + e);
      	}
      }
    }
    else
    {
        System.out.println("getJustOneProject:  Returning DUMMY (EMPTY) project ");
    	
    }
    
    if (returningDummy) System.out.println(" Empty Result SET Returning DUMMY project for id = " + project + " ????");
  	return pb;
  }

  public  int getHighestProjectNumber()
  {
  	int highest = 9999;

  	ResultSet rs = null;
  	Connection con  = null;
    Statement  stmt = null;
    
    try 
    {
      con = getConnection("getHighestProjectNumber");
      stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT MAX(PROJECT) from ACTIVEPROJECTS");
      while (rs.next()) 
      {
      	highest = rs.getInt(1);
      }
    } catch (SQLException e ) 
    {
      System.out.println("Database Query Error in getHighestProjectNumber " + e);
      System.out.println("Query String:  SELECT MAX(PROJECT) from PROJECTS");
    } 
    finally 
    {
    	try
    	{
    		if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (con != null) con.close();
    	}
    	catch (Exception e)
    	{
    		System.out.println("Database connection error in getHighestProjectNumber " + e);
    	}
    }
  	
    System.out.println("Highest Internal Project ID = " + highest);
  	return  highest;
  }
  
  public  int getNumberOfActiveProjects()
  {
  	int highest = 0;

  	ResultSet rs = null;
  	Connection con  = null;
    Statement  stmt = null;
    
    try 
    {
      con = getConnection("getNumberOfActiveProjects");
      stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT COUNT(*) from ACTIVEPROJECTS");
      while (rs.next()) 
      {
      	highest = rs.getInt(1);
      }
    } catch (SQLException e ) 
    {
      System.out.println("Database Query Error in getNumberOfActiveProjects " + e);
      System.out.println("Query String:  SELECT COUNT(*) from ACTIVEPROJECTS");
    } 
    finally 
    {
    	try
    	{
    		if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
    	}
    	catch (Exception e)
    	{
    		System.out.println("Database connection error in getNumberOfActiveProjects " + e);
    	}
    }
  	
    System.out.println("Number of Active Projects in Database = " + highest);
  	return  highest;
  }
  
  public  List<ProjectBean> getProjects(String column, String order, ProjectBean filter) throws SQLException
  {
  	ResultSet rs  = null;
    Connection con  = null;
    Statement  stmt = null;

    Vector<ProjectBean> list = new Vector<ProjectBean>();
    
    String queryString = "SELECT * FROM activeprojects ORDER BY " + column + " " + order;
    
    try 
    {
      con = getConnection("getProjects");
      stmt = con.createStatement();
      System.out.println("Executing getProjects(Column = " + column + ", Order = " + order + ", \nFilter " + filter.toFilterString() + ");");
      rs = stmt.executeQuery(queryString);
      while (rs.next()) 
      {
      	ProjectBean pb = new ProjectBean();
      	
      	setProjectBean(pb,rs); // set(map) pb = rs
      	setProjectBeanContacts(pb);
      	setProjectBeanLeadAgencies(pb); 
      	setProjectBeanPartnerAgencies(pb); 
      	
      	// very important - light up the soul of this project with this parameterDAO 
      	// so it can also make pooled datasource calls 
      	pb.setParameterDAO(this);
      	
      	//System.out.println("BEGIN FILTERING TEST PROJECT " + pb.getProjectnumber() + ", ID = " + pb.getCode() + ", \n" + pb.toString());
       	if (filter.filterTest(pb))
      	{
       		System.out.println("ADDING PROJECT " + pb.getProjectname());
      	  list.add(pb);
      	}
      }
    } catch (SQLException e ) 
    {
      System.out.println(e);
    } 
    finally 
    {
      if (rs != null) rs.close();
      if (stmt != null) stmt.close();
      if (con != null) con.close();
    }
  	
  	return list;
  }
  
  public List<ProjectBean> getDaps() throws SQLException
  {
	  return getDaps("project", "DESC", new ProjectBean());
  }
  
  public  List<ProjectBean> getDaps(String column, String order, ProjectBean filter) throws SQLException
  {
  	ResultSet rs  = null;
    Connection con  = null;
    Statement  stmt = null;

    Vector<ProjectBean> list = new Vector<ProjectBean>();
    
    String queryString = "SELECT * FROM activedaps ORDER BY " + column + " " + order;
    
    try 
    {
      con = getConnection("getDaps");
      stmt = con.createStatement();
      System.out.println("Executing getDaps(Column = " + column + ", Order = " + order + ", \nFilter " + filter.toFilterString() + ");");
      rs = stmt.executeQuery(queryString);
      while (rs.next()) 
      {
      	ProjectBean pb = new ProjectBean(); pb.setDapFlag(true);
      	
      	setProjectBean(pb,rs); // set(map) pb = rs
      	setProjectBeanContacts(pb);
      	setProjectBeanLeadAgencies(pb); 
      	setProjectBeanPartnerAgencies(pb); 
      	
      	// very important - light up the soul of this project with this parameterDAO 
      	// so it can also make pooled datasource calls 
      	pb.setParameterDAO(this);
      	
      	//System.out.println("BEGIN FILTERING TEST PROJECT " + pb.getProjectnumber() + ", ID = " + pb.getCode() + ", \n" + pb.toString());
       	if (filter.filterTest(pb))
      	{
       		System.out.println("ADDING DAP " + pb.getProjectname());
      	  list.add(pb);
      	}
      }
    } catch (SQLException e ) 
    {
      System.out.println(e);
    } 
    finally 
    {
      if (rs != null) rs.close();
      if (stmt != null) stmt.close();
      if (con != null) con.close();
    }
  	
  	return list;
  }

  public  String getAgencyAcronymName(int agency)
  {
  	StringBuffer sb = new StringBuffer();

  	ResultSet rs = null;
  	Connection con  = null;
    Statement  stmt = null;
  	
  	String queryString = "SELECT acronym, description FROM Organizations WHERE organization = " + agency;
  	
  	try
  	{
      con = getConnection("getAgencyAcronymName");
      stmt = con.createStatement();
      rs = stmt.executeQuery(queryString);
      while (rs.next()) 
      {
      	sb.append(rs.getString("acronym"));
      	sb.append(": ");
      	sb.append(rs.getString("description"));
      }
  	}
  	catch (SQLException s)
  	{
  		System.out.println("Error retrieving Agency name/acronym " + s);
  	}
  	finally
  	{
  		try
  		{
  			rs.close();
  			stmt.close();
  			con.close();
  		}
  		catch (Exception e)
  		{
  			System.out.println("Error retrieving Agency name/acronym...closing stmt ?? " + e);
  		}
  	}
  	
  	
  	return sb.toString();
  }
  
  public  List<Agency> getAgencies()
  {
  	
  	Vector<Agency> v = new Vector<Agency>();

  	ResultSet rs = null;
  	Connection con  = null;
    Statement  stmt = null;
  	
  	String queryString = "SELECT organization, acronym, description FROM Organizations ORDER BY acronym";
  	
  	try
  	{
      con = getConnection("getAgencies");
      stmt = con.createStatement();
      rs = stmt.executeQuery(queryString);
      while (rs.next()) 
      {
      	Agency a = new Agency();
      	a.setOrg(rs.getInt("organization"));
      	a.setAcronym(rs.getString("acronym"));
      	a.setDescription(rs.getString("description"));
      	v.addElement(a);
      }
  	}
  	catch (SQLException s)
  	{
  		System.out.println("Error retrieving Agencies " + s);
  	}
  	finally
  	{
  		try
  		{
  			if (rs != null) rs.close();
  			if (stmt != null) stmt.close();
  			if (con != null) con.close();
  		}
  		catch (Exception e)
  		{
  			System.out.println("Error retrieving Agency name/acronym...closing stmt ?? " + e);
  		}
  	}
  	
  	
  	return v;
  }

  public  List<Contact> getContacts(int projectNumber)
  {
  	
  	Vector<Contact> contacts = new Vector<Contact>();

  	ResultSet rs = null;
  	Connection con  = null;
    Statement  stmt = null;
  	
  	String queryString = "SELECT contact, naam, email FROM PointOfContacts WHERE project = " + projectNumber;
  	
  	try
  	{
      con = getConnection("getContacts");
      stmt = con.createStatement();
      rs = stmt.executeQuery(queryString);
      while (rs.next()) 
      {
        Contact c = new Contact();
        c.setId(rs.getInt("contact"));
        c.setName(rs.getString("naam"));
        c.setEmail(rs.getString("email"));
      	contacts.addElement(c);
      }
  	}
  	catch (SQLException s)
  	{
  		System.out.println("Error retrieving contacts " + s);
  	}
  	finally
  	{
  		try
  		{
  			if (rs != null) rs.close();
  			if (stmt != null) stmt.close();
  			if (con != null) con.close();
  		}
  		catch (Exception e)
  		{
  			System.out.println("Error retrieving contact...closing stmt ?? " + e);
  		}
  	}
  	
  	
  	return contacts;
  }

  private  synchronized  Connection getConnection(String method) throws SQLException
  {
  	if (getDataSource() == null)
  	{
  		// static calls for testing, locally ONLY without any container, when no container datasource
  		
    	// register the database driver, first...
    	try
    	{
    	  Class.forName("org.postgresql.Driver").newInstance();
    	}
    	catch (Exception e)
    	{
    		System.out.println("Possible F A T A L I T Y....no database driver found..." + e);
    	}
  		System.out.println(method + " making static call to database...YUCK!");
      return DriverManager.getConnection("jdbc:postgresql:paws","postgres", "admin123");
  	}
  	else
  	{
  		// production DBCP
  		//System.out.println(method + "  making pooled connection call to database...HOORAY!");
  		return ds.getConnection();
  	}
  }
  

  /**
   * maps the project bean into the resultset of above ACTIVEPROJECTS view
   * @param pb
   * @param rs
   * @return
   */
  private  final void setProjectBean(ProjectBean pb, ResultSet rs) throws SQLException
  {
  	// project number, name, description
  	pb.setProjectnumber(rs.getInt("project"));
  	pb.setCode(rs.getInt("code"));
  	pb.setTag(rs.getString("tag"));
  	pb.setProjectname(rs.getString("nametitle"));
  	pb.setProjectdescription(rs.getString("description"));
  	pb.setStatus(rs.getString("status"));
  	pb.setWorksheetfilename(rs.getString("worksheet"));
  	pb.setDeleted(rs.getBoolean("deleted"));
  	pb.setUrl(rs.getString("url"));
  	
  	// high-level capability areas 
  	pb.setTraining(rs.getString("training"));
  	pb.setEducation(rs.getString("education"));
  	pb.setOutreach(rs.getString("outreach"));
  	pb.setObserving(rs.getString("observing"));
  	pb.setDataservices(rs.getString("dataservices"));
  	pb.setVariability(rs.getString("variability"));
  	pb.setImpacts(rs.getString("impacts"));
  	pb.setGuidance(rs.getString("guidance"));
  	pb.setApps(rs.getString("applications"));
  	pb.setPolicies(rs.getString("policies"));
  	pb.setAssessment(rs.getString("assessment"));
  	
  	// focus areas
  	pb.setFresh(rs.getString("freshwater"));
  	pb.setCoastal(rs.getString("coastal"));
  	pb.setMarine(rs.getString("ecosystems"));
  	
  	// variability 
  	pb.setOperational(rs.getString("operational"));
  	pb.setResearch(rs.getString("research"));
  	
  	pb.setVhistorical(rs.getString("vhistorical"));
  	pb.setVprojections(rs.getString("vprojections"));
  	
  	//time frames
  	pb.setSeasonal(rs.getString("seasonal"));
  	pb.setAnnual(rs.getString("annual"));
  	pb.setDecadal(rs.getString("decadal"));
  	
  	//parameters
  	pb.setAsurface(rs.getString("asurface"));
  	pb.setUpperair(rs.getString("upperair"));
  	pb.setComposition(rs.getString("composition"));
  	
  	pb.setOsurface(rs.getString("osurface"));
  	pb.setSubsurface(rs.getString("subsurface"));
  	
  	pb.setTerrestrial(rs.getString("terrestrial"));
  	
  	//impacts
  	pb.setImpacts(rs.getString("impact"));
  	pb.setEhistorical(rs.getString("ihistorical"));
  	pb.setEprojections(rs.getString("iprojections"));
  	
  	pb.setAdaptation(rs.getString("adaptation"));
  	
  	// sectors
  	pb.setPhs(rs.getString("health"));
  	pb.setFwr(rs.getString("water"));
  	pb.setEne(rs.getString("energy"));
  	
  	pb.setTcc(rs.getString("commerce"));
  	pb.setCpd(rs.getString("planning"));
  	pb.setScr(rs.getString("cultural"));

  	pb.setAfi(rs.getString("agricultural"));
  	pb.setRat(rs.getString("tourism"));
  	pb.setEco(rs.getString("ecosystem"));
  	
  	pb.setOth(rs.getString("othersector"));  	

  	//guidance
  	pb.setGvariability(rs.getString("gvariability"));
  	pb.setGeffects(rs.getString("gadaptation"));
  	
  	//applications 
  	pb.setAvariability(rs.getString("appsvariability"));
  	pb.setAeffects(rs.getString("appsadaptation"));
  	
  	// regions
  	pb.setOtherregions(rs.getString("qregion"));
  	
  	// central north pacific
  	pb.setCentral(rs.getString("allcentral"));
  	pb.setHawaii(rs.getString("hawaii"));
  	pb.setHother(rs.getString("othercentral"));
  	
  	// hawaii
  	pb.setBig(rs.getString("bigisland"));
  	pb.setMaui(rs.getString("maui"));
  	pb.setOahu(rs.getString("oahu"));
  	pb.setKauai(rs.getString("kauai"));
  	
  	// western pacific
  	pb.setWestern(rs.getString("allwest"));
  	pb.setGuam(rs.getString("guam"));
  	pb.setCnmi(rs.getString("cnmi"));
  	pb.setFsm(rs.getString("fsm"));
  	pb.setRmi(rs.getString("rmi"));
  	pb.setPalau(rs.getString("palau"));
  	pb.setWother(rs.getString("otherwestern"));
  	
    // south pacific
  	pb.setSouth(rs.getString("allsouth"));
  	pb.setAsam(rs.getString("americansamoa"));
  	pb.setSamoa(rs.getString("samoa"));
  	pb.setTonga(rs.getString("tonga"));
  	pb.setFiji(rs.getString("fiji"));
  	pb.setOz(rs.getString("australia"));
  	pb.setNz(rs.getString("newzealand"));
  	pb.setFp(rs.getString("frenchpoly"));
  	pb.setSother(rs.getString("othersouth"));
  	
  	//ecv
  	pb.setEcvAtmospheric(rs.getString("ecvatmospheric"));
  	pb.setEcvOceanic(rs.getString("ecvoceanic"));
  	pb.setEcvTerrestrial(rs.getString("ecvterrestrial"));
  	
  	// data-physical
  	pb.setPhyInsitu(rs.getString("phyinsitu"));
  	pb.setPhySatellite(rs.getString("physatellite"));
  	pb.setPhyModel(rs.getString("phymodel"));
  	pb.setPhyReanalysis(rs.getString("phyreanalysis"));
  	pb.setPhyBathymetry(rs.getString("phybathymetry"));
  	pb.setPhyImagery(rs.getString("phyimagery"));
  	
  	//products
  	pb.setProdHindcasts(rs.getString("prodhindcasts"));
  	pb.setProdOutlooks(rs.getString("prodoutlooks"));
  	pb.setProdProjections(rs.getString("prodprojections"));
  	pb.setProdGuidance(rs.getString("prodguidance"));
  	pb.setProdApplications(rs.getString("prodapplications"));
  	
  	//non-physical
  	pb.setNonPhysicalEnvironmental(rs.getString("environmental"));
  	pb.setNonPhysicalSocioCultural(rs.getString("sociocultural"));
  	pb.setNonPhysicalEconomic(rs.getString("economic"));
  	pb.setNonPhysical(rs.getString("nonphysical"));
  	
  }

  public  void setProjectBeanContacts(ProjectBean pb) throws SQLException
  {
  	pb.setContactList(this.getContacts(pb.getProjectnumber()));
  }
  
  public List<Agency> getAgencies (String agencyTableName, int projectNumber)
  {
    ResultSet rs = null;
  	Connection con  = null;
    Statement  stmt = null;
  	
  	String queryString = "SELECT A.agency, O.acronym, O.description, O.url " + 
  	                     "FROM " + agencyTableName + " AS A " +
  	                     "LEFT OUTER JOIN Organizations AS O " + 
                         "ON A.agency = O.organization " +
                         "LEFT OUTER JOIN Projects AS P " +
                         "ON P.project = A.project " + 
  	                     "WHERE P.project = " + projectNumber;
  	
    Vector <Agency> agencies = new Vector <Agency>(); 
  	
    try
  	{
      con = getConnection("getAgencies (" + agencyTableName + ", " + projectNumber + ")");
      stmt = con.createStatement();
      rs = stmt.executeQuery(queryString);
  		//System.out.println("Executed " + queryString);
      while (rs.next()) 
      {
      	Agency a = new Agency();
      	a.setOrg(rs.getInt("agency"));
      	a.setAcronym(rs.getString("acronym"));
      	a.setDescription(rs.getString("description"));
      	a.setUrl(rs.getString("url"));
      	//System.out.println("Added Agency #" + a.getOrg() + ", " + a.getAcronym() + " : " + a.getDescription()); 
      	agencies.add(a);
      }
  	}
  	catch (SQLException s)
  	{
  		System.out.println("Error retrieving agencies " + s);
  	}
  	finally
  	{
  		try
  		{
  		  if (rs != null) rs.close();
  		  if (stmt != null) stmt.close();
  		  if (con != null) con.close();
  		}
  		catch (Exception e)
  		{
    		System.out.println("Error retrieving agencies " + e);
  		}
  	}
  	
  	return agencies;
  	
  	
  }
  public  void setProjectBeanLeadAgencies(ProjectBean pb) throws SQLException 
  {
  	pb.setLeadList(getAgencies("leaders", pb.getProjectnumber()));
  }

  public  void setProjectBeanPartnerAgencies(ProjectBean pb) 
  {
  	pb.setPartnerList(getAgencies("partners", pb.getProjectnumber()));
  }


  public  String getAgencyOptionsList(String selected[])
  {
  	StringBuffer sb = new StringBuffer(); // this will contain code for the simple table
  	List <Agency>agencies = getAgencies();
	
  	Agency agency        = new Agency();  
	Agency other   = new Agency();
	
	
	for (Iterator<Agency>iter = agencies.listIterator(); iter.hasNext();)
	{
       agency = (Agency) iter.next();
       
       if (agency.isOther())
       {
    	   // just capture the object
    	   other = agency;
       }
       else
       {
    	   sb.append(this.getAgencySelectionOptionHTML(agency, selected));
       }
	}

	// add the other agencies to the bottom
    sb.append(this.getAgencySelectionOptionHTML(other, selected));
  	return sb.toString();
  }  
  
  
  public String getAgencySelectionOptionHTML(Agency agency, String selected[])
  {
	  StringBuffer sb = new StringBuffer();
	  
      sb.append("                                                             ");
      sb.append("<option value=\"");
      sb.append(agency.getOrg());
      sb.append("\"");  // insert selected after value 
 
      for (int i = 0; i < selected.length; i++)
      {
        if (agency.getOrg() == NumberUtils.toInt(selected[i]))
        {
          sb.append(" selected ");
        }
     }
      sb.append(">");  
      
      if (agency.getAcronym().length() > 0)
      {
        sb.append(StringEscapeUtils.escapeHtml(agency.getAcronym()));
        sb.append(": ");
        sb.append(StringEscapeUtils.escapeHtml(agency.getDescription()));
      }
      else
      {
 	    sb.append("&nbsp");
      }
 
      sb.append("</option>");
      sb.append(System.getProperty("line.separator"));
	  
	  return sb.toString();
  }
  
  
 
  public  String getProjectsListHTML(String column, String order, String wwwroot, ProjectBean filter) 
  {
  	StringBuffer sb = new StringBuffer(); // this will contain code for the simple table 
  	String lookfor = filter.getSearchString();
  	try
  	{
  	  List <ProjectBean> projects = getProjects(column, order, filter);
  	  int size = projects.size();
  	
    	if (size > 0)
    	{
    		// rows - to highlight the latest project - this may not be in the search results !!!
    		// but it is OK for rowid of the delelte all checkbox.  
    		int highestProjectNumber = getHighestProjectNumber();
    		int numberOfActiveProjects = getNumberOfActiveProjects();
   	  	    System.out.println ("Rendering " + size + " of " + numberOfActiveProjects + " active projects.  Highest Internal ID = " + highestProjectNumber );
    		
    		sb.append("<form name=\"projectlist\" action=\"projects\" method=\"post\">");
    		sb.append("<input type=\"button\" value=\"Add New\" onclick=\"addnew()\"></input>");
    		sb.append("<input type=\"submit\" value=\"Delete\"></input>");
    		// sb.append("<input type=\"reset\" />");
    		sb.append("<input type=\"button\" value=\"Reset\" onclick=\"resetmsgsbox()\"></input>");
    		sb.append("<input name=\"search\"  size=\"30\" value=\"" + lookfor + "\" />");
    		sb.append("<input type=\"button\" value=\"Search\" onclick=\"searchbox()\"></input>");
    		sb.append("<input type=\"button\" value=\"Advanced Search\" onclick=\"searchbyx()\"></input>");
    		sb.append("SHOWING ");
    		sb.append("<select onclick=\"javascript:alert('Pagination Under Construction')\"><option>");
    		sb.append("1 - " + size);
    		sb.append("</option></select>");
    		sb.append("&nbsp; OF &nbsp;");
    		sb.append(numberOfActiveProjects);
    		//sb.append("&nbsp;&nbsp;PROJECTS");
    		sb.append(getSortedBy(column, order));
    		sb.append("<br />");
    		sb.append("<table class=\"projects\" id=\"ptable\">");
    		
    		// header
    		sb.append("<thead><tr>");
    		sb.append("<td>");
			  sb.append("<input type=\"checkbox\" name=\"deleteKing\" id=\"chkQueen\" title=\"Select Or Unselect All Projects\"" ); 
			  		sb.append(" onclick=\"toggleDeleteColumn()\" />");
    		sb.append("</td>");
    		
    		// tag column
    		sb.append("<td>");
    		if (StringUtils.equalsIgnoreCase(column, "code"))
    		{
    		  if(StringUtils.equalsIgnoreCase(order, "DESC"))
    		  {
    			// toggle to asc = 0
      		    sb.append("<a href=\"javascript:sortby('code','0')\">ID</a>");
    		  }
    		  else
    		  {
    			// default desc = 1
      		    sb.append("<a href=\"javascript:sortby('code', '1')\">ID</a>");
    		  }
    		}
    		else
    		{
     		    sb.append("<a href=\"javascript:sortby('code','0')\">ID</a>");
    		}
    		sb.append("</td>");
    		
    		
    		// name column
    		sb.append("<td>");
    		if (StringUtils.equalsIgnoreCase(column, "nametitle"))
    		{
    		  if(StringUtils.equalsIgnoreCase(order, "DESC"))
    		  {
    			// toggle to asc = false = 0
      		    sb.append("<a href=\"javascript:sortby('name','0')\">Name</a>");
    		   }
    		   else
    		   {
    			 // default
      		     sb.append("<a href=\"javascript:sortby('name', '1')\">Name</a>");
    		   }
    		}
    		else
    		{
      		    sb.append("<a href=\"javascript:sortby('name','0')\">Name</a>");
    		}
    		sb.append("</td>");
    		
    		
    		
    		sb.append("<td>");sb.append("Description");sb.append("</td>");
    		
    		
    		// status column
    		sb.append("<td>");
    		if (StringUtils.equalsIgnoreCase(column, "status"))
    		{
    		  if(StringUtils.equalsIgnoreCase(order, "DESC"))
    		  {
    			// toggle to asc = false = 0
      		    sb.append("<a href=\"javascript:sortby('status','0')\">Status</a>");
    		  }
    		  else
    		  {
    			// default
      		    sb.append("<a href=\"javascript:sortby('status', '1')\">Status</a>");
    		  }
    		}
    		else
    		{
      		    sb.append("<a href=\"javascript:sortby('status','0')\">Status</a>");
    		}
    		sb.append("</td>");
    		
    		
    		
    		sb.append("<td>");sb.append("Capability Area");sb.append("</td>");
    		sb.append("<td>");sb.append("Focus Area");sb.append("</td>");
    		sb.append("<td>");sb.append("Region/Locale");sb.append("</td>");
    		sb.append("<td>");sb.append("Lead Agencies");sb.append("</td>");
    		sb.append("<td>");sb.append("Contacts");sb.append("</td>");
    		sb.append("</tr></thead>");
  
    		
			sb.append("<tbody>");
    		for (Iterator<ProjectBean>iter = projects.listIterator(); iter.hasNext();)
  			{
    			ProjectBean project = (ProjectBean) iter.next();
    			int id = project.getProjectnumber();
    			
    			if (project.getProjectnumber() == highestProjectNumber)
    			{
    				// highlight the LATEST project added to database... 
    				sb.append("<tr id=\"row" + id + "\" bgcolor=\"#FFFF00\" >");
    			}
    			else
    			{
      			sb.append("<tr id=\"row" + id + "\" >");
    			}
    			sb.append("<td>");
    			  sb.append("<input type=\"checkbox\" title=\"DELETE: " + hiEscHtml(project.getProjectNameStripURL(),"") + "\"  ");
    			  		sb.append("name=\"delete\" id=\"chk" + id + "\" value=\"" + id + "\"  onclick=\"clickchk('" + id + "')\" />");
    			  //sb.append("<input type=\"hidden\" name=\"name\"  value=\""+ project.getProjectname() + "\"/>");
    			sb.append("</td>");
    			sb.append("<td>");sb.append(hiEscHtml(project.getCode()+"",lookfor));sb.append("</td>");
    			sb.append("<td class=\"nameCol\">");
    			  sb.append(hiEscHtml(project.getProjectNameStripURL(),lookfor));
    			  sb.append(project.getFullyFormedProjectURLifExists());
    			  sb.append("(<a href=\"index.jsp?id=" + id + "\">Update");sb.append("</a>)"); 
    			sb.append("</td>");
    			sb.append("<td class=\"descriptionCol\">");
    			 sb.append(hiEscHtml(project.getProjectdescription(),lookfor));
    			 sb.append("&nbsp;" + project.getWorksheetURL(wwwroot));
    			sb.append("</td>");
    			sb.append("<td>");
    			 sb.append(hiEscHtml(project.getStatusText(),lookfor));
    			sb.append("</td>");
    			sb.append("<td class=\"capabilityCol\">");
    			 sb.append(hiEscHtml(project.getCapabilityAreas(),lookfor));
    			sb.append("</td>");
    			sb.append("<td class=\"focusCol\">");
    			 sb.append(hiEscHtml(project.getFocusAreas(),lookfor));
    			sb.append("</td>");
    			sb.append("<td class=\"regionCol\">");
    			 sb.append(hiEscHtml(project.getRegionLocale(),lookfor));
    			sb.append("</td>");
    			sb.append("<td class=\"agencyCol\">");
    			 sb.append(project.getLeadAgenciesAsString(lookfor));
    			sb.append("</td>");
    			sb.append("<td class=\"contactCol\">");
    			 sb.append(project.getContacts(lookfor));
   			     sb.append("&nbsp;(<a href=\"contacts.jsp?id=" + id + "\">More...</a>)");
    			sb.append("</td>");
    			sb.append("</tr>");
    			
  			}
			sb.append("</tbody>");
  		
    		sb.append("</table>");
    		sb.append("<input type=\"hidden\" name=\"sortby\" value=\"project\"></input>");
    		sb.append("<input type=\"hidden\" name=\"order\" value=\"1\"></input>");
    		sb.append("<input type=\"hidden\" name=\"clearmsgs\" value=\"0\"></input>");
    		
    		
    		sb.append("<input type=\"button\" value=\"Add New\" onclick=\"addnew()\"></input>");
    		sb.append("<input type=\"submit\" value=\"Delete\"></input>");
    		// sb.append("<input type=\"reset\" />");
    		sb.append("<input type=\"button\" value=\"Reset\" onclick=\"resetmsgsbox()\"></input>");
    		sb.append("<input type=\"button\" value=\"Advanced Search\" onclick=\"searchbyx()\"></input>");
    		sb.append("SHOWING ");
    		sb.append("<select onclick=\"javascript:alert('Pagination Under Construction')\"><option>");
    		sb.append("1 - " + size);
    		sb.append("</option></select>");
    		sb.append(" OF ");
    		sb.append(numberOfActiveProjects);
    		sb.append("&nbsp;&nbsp;PROJECTS");
    		sb.append(getSortedBy(column, order));
    		
    		sb.append("</form>");
   
    		// drop off or set on-load type script variables THAT ARE in the head element (not embedded)
            //sb.append("<script type=\"javascript\">maxRowId = 'row" + highestProjectNumber + "';</script>");
    	}
    	else
    	{
    		// means there are no projects -- should be handled in servlet -- at least render the add button
    		sb.append("<form name=\"projectlist\" action=\"projects\" method=\"post\">");
    		sb.append("<input type=\"button\" value=\"Add New Project\" onclick=\"addnew()\"></input>");
    		sb.append("<input type=\"button\" value=\"Reset\" onclick=\"resetmsgsbox()\"></input>");
    		sb.append("<input name=\"search\"  size=\"50\" value=\"" + lookfor + "\" />");
    		sb.append("<input type=\"submit\" value=\"Search\" onclick=\"searchbox()\"></input>");
    		sb.append("<input type=\"button\" value=\"Advanced Search\" onclick=\"searchbyx()\"></input>");
    		sb.append("<input type=\"hidden\" name=\"clearmsgs\" value=\"0\"></input>");
    	    sb.append("<br /><br /><div style=\"background-color: #FFFF00;\">");
    	    sb.append("NO PROJECTS FOUND...");
    	    sb.append("</div><!-- closes red coloring -->");
    		sb.append("</form>");
    	}
  	}
  	catch (Exception e)
  	{
  		System.out.println("parameterDAO.getProjectsListHTML Could not generate Projects List " + e);
  	}
		
		return sb.toString();
	
  }
  
  public static String  getHTMLSpaceChar(int numberOfSpaces)
  {
  	StringBuffer sb = new StringBuffer();
    for(int i=0; i < numberOfSpaces; i++) sb.append("&nbsp;");
    return sb.toString();
  }
  
  public static String hiEscHtml(String str, String tok)
  {
	  return highlightHTML(StringEscapeUtils.escapeHtml(str), tok);
  }

  public String getSortedBy (String column, String order)
  {
	  StringBuffer sb = new StringBuffer();
      String col = ""; String ord = ""; 
	  
	  if (StringUtils.equalsIgnoreCase(column, "project"))
	  {
		 // say nothing
		 return "&nbsp; LAST ADD/UPDATE IS <div style=\"background-color: #FFFF00; display: inline; border-style: dotted;\">HIGHLIGHTED</div>, IF SHOWN.";
	  }
	  else if (StringUtils.equalsIgnoreCase(column, "code"))
	  {
		  col = "<div style=\"background-color: #fc9; display: inline; border-style: dotted;\">ID</div>";
	  }
	  else if (StringUtils.equalsIgnoreCase(column, "nametitle"))
	  {
		  col = "<div style=\"background-color: #fc9; display: inline; border-style: dotted;\">Name</div>";
	  }
	  else if (StringUtils.equalsIgnoreCase(column, "status"))
	  {
		  col = "<div style=\"background-color: #fc9; display: inline; border-style: dotted;\">Status Code</div>";
	  }

	  if (StringUtils.containsIgnoreCase(order, "ASC"))
	  {
	     ord = "Ascending";	  
	  }
	  else if (StringUtils.containsIgnoreCase(order, "DESC"))
	  {
		 ord = "Descending";
	  }
		  
	  
		sb.append("&nbsp;&nbsp;SORTED BY ");
		sb.append("&nbsp;&nbsp;" + col);
		sb.append("&nbsp;&nbsp;IN&nbsp;&nbsp;" + ord);
		sb.append("&nbsp;&nbsp;ORDER");

		return sb.toString();
  }
  /**
   * helper to search to highlight found term
   * @param token
   * @param inthis
   * @return
   */
	public static String highlightHTML (String str, String tok)
	{
		if (StringUtils.isBlank(tok))
		{
			return str;
		}
		else if (StringUtils.containsIgnoreCase(str, tok))
		{
            //get a count
			int matches = StringUtils.countMatches(StringUtils.lowerCase(str), StringUtils.lowerCase(tok));
			int [] left = new int [matches];  int [] right = new int [matches];
			String [] matchedOriginals = new String[matches];
			int pos = 0; 
			for (int i = 0; i < matches; i++)
			{
				left[i] = StringUtils.indexOfIgnoreCase(str, tok, pos);
				right[i] = left[i] + tok.length();
				matchedOriginals[i] = StringUtils.substring(str, left[i],right[i]);
				pos = right[i];
			}
			
			// now overlay
			StringBuffer sb = new StringBuffer();
		
			pos = 0;
			for (int i = 0; i < matches; i++)
			{
				sb.append(StringUtils.substring(str, pos, left[i]));
				sb.append("<div style=\"background-color: #C2F670; display:inline;\">" + matchedOriginals[i] + "</div><!-- !!!_FOUND_"+ tok +"_!!! -->");
				if (i == (matches - 1))
				{	
				  // append rest of string, for loop is done done
				  sb.append(StringUtils.substring(str, right[i]));
				}
				pos = right[i];
			}
		
			return sb.toString();
		}
		else
		{
			return str;
		}
	}

  /**
   * return "checked" if the str evaluates to true per parse method, meaning the bean property is set
   * @param str
   * @return
   */
  public static String getCheckedStatus (String str)
  {
  	String checked = "";
  	if (parse(str)) checked = "checked";
  	return checked;
  }

  /**
   * a more English readable function than "parse"
   * @param str
   * @return
   */
  public  boolean ifSet (String str)
  {
  	return parse(str);
  }

  
  /**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ParameterDAO pd = new ParameterDAO();
		String [] acronyms = new String [2];  String [] descriptions = new String [2];
		
		acronyms[0] = "ABC"; descriptions[0] = "A,B,C";
		acronyms[1] = "XYZ"; descriptions[1] = "X,Y,Z";
		
		try
		{
			pd.addAgencies(acronyms, descriptions);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
