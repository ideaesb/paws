package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Otherregions 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
   public void insert (String project, String otherRegion) throws SQLException
   {
	    String [] columns = new String [1];
	    String [] values  = new String [1];
    
	    columns[0]="other"; values[0]=otherRegion;
	    
      parameterDAO.insert("OTHERREGIONS", project, columns, values);
   }
		
   public void delete (String project) throws SQLException
   {
 	 parameterDAO.delete("OTHERREGIONS", project);
   }
	
   public void insert(int project, String otherRegion) throws SQLException 
   {
	   insert(project+"", otherRegion);
   }

   public void delete(int project) throws SQLException 
   {
 	   delete(project+"");
   }
}