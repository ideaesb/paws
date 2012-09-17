package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Atmospheric
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	

  public void insert (String project, String surface, String upperair, String composition) throws SQLException
  {

    String [] columns = new String [3];
    String [] values  = new String [3];
    
    
    columns[0]="surface";     values[0]=surface;
    columns[1]="upperair";    values[1]=upperair;
    columns[2]="composition"; values[2]=composition;
    
    parameterDAO.insert("ATMOSPHERIC", project, columns, values);
  }

  public void delete(String project) throws SQLException 
  {
      parameterDAO.delete("ATMOSPHERIC", project);
  }

  public void insert (int project, String surface, String upperair, String composition) throws SQLException
  {
    insert(project+"", surface, upperair, composition);    
  }
  
  public void delete(int project) throws SQLException 
  {
      parameterDAO.delete("ATMOSPHERIC", project);
  }
}
