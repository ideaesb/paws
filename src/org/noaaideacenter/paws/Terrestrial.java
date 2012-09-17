package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Terrestrial
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String terrestrial) throws SQLException
  {
    String [] columns = new String [1];
    String [] values  = new String [1];
  
    columns[0]="surface"; values[0]=terrestrial;
    
    parameterDAO.insert("TERRESTRIAL", project, columns, values);
  }
		
  public void delete (String project) throws SQLException
  {
	 parameterDAO.delete("TERRESTRIAL", project);
  }
	
  public void insert(int project, String terrestrial) throws SQLException 
  {
	 insert(project+"", terrestrial);
  }

  public void delete(int project) throws SQLException 
  {
	 delete(project+"");
  }
}
