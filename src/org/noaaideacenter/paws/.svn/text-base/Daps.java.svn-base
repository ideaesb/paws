package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Daps 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
   public void insert (String project) throws SQLException
   {
      parameterDAO.insert("DAPS", project);
   }
		
   public void delete (String project) throws SQLException
   {
 	 parameterDAO.delete("DAPS", project);
   }
	

   public void insert (int project) throws SQLException
   {
      insert(project+"");
   }
   public void delete(int project) throws SQLException 
   {
 	   delete(project+"");
   }
}