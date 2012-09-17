package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Variability
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String operational, String research, String historical, String projections) 
  throws SQLException
  {
  
    String [] columns = new String [4];
    String [] values  = new String [4];
    
    
    columns[0]="operational";    values[0]=operational;
    columns[1]="research";       values[1]=research;
    columns[2]="historical";     values[2]=historical;
    columns[3]="projections";    values[3]=projections;
    
    parameterDAO.insert("VARIABILITY", project, columns, values);
  }

  public void delete(String project) throws SQLException 
  {
    parameterDAO.delete("VARIABILITY", project);
  }
  
  
  public void insert (int project, String operational, String research, String historical, String projections) 
  throws SQLException
  {
  	insert(project+"", operational,  research,  historical,  projections);
  }

  public void delete(int project) throws SQLException 
  {
    delete(""+project);
  }
  
}
