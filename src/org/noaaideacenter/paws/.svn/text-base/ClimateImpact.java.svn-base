package org.noaaideacenter.paws;

import java.sql.SQLException;

public class ClimateImpact
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String impact, String historical,
  		                       String projections, String adaptation) 
  throws SQLException
  {
  
    String [] columns = new String [4];
    String [] values  = new String [4];
    
    
    columns[0]="impact";         values[0]=impact;
    columns[1]="adaptation";     values[1]=adaptation;
    columns[2]="historical";     values[2]=historical;
    columns[3]="projections";    values[3]=projections;
    
    parameterDAO.insert("CLIMATEIMPACT", project, columns, values);
  }

  public void delete(String project) throws SQLException 
  {
    parameterDAO.delete("CLIMATEIMPACT", project);
  }
  
  
  public void insert (int project, String impact, String research, String historical, String adaptation) 
  throws SQLException
  {
  	insert(project+"", impact,  research,  historical,  adaptation);
  }

  public void delete(int project) throws SQLException 
  {
    delete(""+project);
  }
  
}
