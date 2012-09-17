package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Guidance
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String variability, String adaptation) throws SQLException
  {

    String [] columns = new String [2];
    String [] values  = new String [2];
    
    
    columns[0]="variability"; values[0]=variability;
    columns[1]="adaptation";  values[1]=adaptation;
    
    parameterDAO.insert("GUIDANCE", project, columns, values);
  }

  public void delete(String project) throws SQLException 
  {
      parameterDAO.delete("GUIDANCE", project);
  }

  public void insert (int project, String variability, String adaptation) throws SQLException
  {
    insert(project+"", variability, adaptation);    
  }
  
  public void delete(int project) throws SQLException 
  {
      parameterDAO.delete("GUIDANCE", project);
  }
}
