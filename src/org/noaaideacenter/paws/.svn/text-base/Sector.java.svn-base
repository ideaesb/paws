package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Sector 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String health, String water, String energy,  
	  		                       String commerce,String planning, String cultural, 
	  		                       String agricultural, String tourism, String ecosystem, String other) 
	    throws SQLException
   {

    	String [] columns = new String [10];
    	String [] values  = new String [10];
    	
    	
    	columns[0]="health";         values[0]=health;  
    	columns[1]="water";          values[1]=water;
    	columns[2]="energy";         values[2]=energy;
    	columns[3]="commerce";       values[3]=commerce;
    	columns[4]="planning";       values[4]=planning;
    	columns[5]="cultural";       values[5]=cultural;
    	columns[6]="agricultural";   values[6]=agricultural;
    	columns[7]="tourism";        values[7]=tourism;
    	columns[8]="ecosystem";      values[8]=ecosystem;
    	columns[9]="other";          values[9]=other;
    	
    	
    	System.out.println("Doing Sector insert ");
    	for (int i=0; i<columns.length; i++)
    	{
      	System.out.println("columns[" + i + "] = " + columns[i] + ", " + "values[" + i + "] = " + values[i]);
    	}
    	
    	parameterDAO.insert("SECTOR", project, columns, values);
  }
	
  public void insert (int project,String health, String water, String energy,  
                             String commerce,String planning, String cultural, 
                             String agricultural, String tourism, String ecosystem, String other)
   throws SQLException
   {
  	  insert(project+"",health,water,energy,commerce,planning,cultural,
  	  		              agricultural,tourism,ecosystem,other);
   }

  public void delete(String project) throws SQLException 
  {
    parameterDAO.delete("SECTOR", project);
  }

  public void delete(int project) throws SQLException 
  {
    parameterDAO.delete("SECTOR", project);
  }
}
