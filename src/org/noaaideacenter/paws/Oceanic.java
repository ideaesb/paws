package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Oceanic
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String surface, String subsurface) throws SQLException
  {

    String [] columns = new String [2];
    String [] values  = new String [2];
    
    
    columns[0]="surface"; values[0]=surface;
    columns[1]="subsurface";  values[1]=subsurface;
    
    parameterDAO.insert("OCEANIC", project, columns, values);
  }

  public void delete(String project) throws SQLException 
  {
      parameterDAO.delete("OCEANIC", project);
  }

  public void insert (int project, String surface, String subsurface) throws SQLException
  {
    insert(project+"", surface, subsurface);    
  }
  
  public void delete(int project) throws SQLException 
  {
      parameterDAO.delete("OCEANIC", project);
  }
}
