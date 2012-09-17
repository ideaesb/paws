package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Timeframes
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String seasonal, String annual, String decadal) throws SQLException
  {

    String [] columns = new String [3];
    String [] values  = new String [3];
    
    
    columns[0]="seasonal"; values[0]=seasonal;
    columns[1]="annual";   values[1]=annual;
    columns[2]="decadal";  values[2]=decadal;
    
    parameterDAO.insert("TIMEFRAMES", project, columns, values);
  }

  public void delete(String project) throws SQLException 
  {
      parameterDAO.delete("TIMEFRAMES", project);
  }

  public void insert (int project, String seasonal, String annual, String decadal) throws SQLException
  {
    insert(project+"", seasonal, annual, decadal);    
  }
  
  public void delete(int project) throws SQLException 
  {
      parameterDAO.delete("TIMEFRAMES", project);
  }
}
