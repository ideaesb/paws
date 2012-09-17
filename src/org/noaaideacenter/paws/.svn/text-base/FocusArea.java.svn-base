package org.noaaideacenter.paws;

import java.sql.SQLException;

public class FocusArea
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String freshwater, String coastal, String ecosystems) 
  throws SQLException
  {

    String [] columns = new String [3];
    String [] values  = new String [3];
    
    
    columns[0]="freshwater"; values[0]=freshwater;
    columns[1]="coastal";    values[1]=coastal;
    columns[2]="ecosystems"; values[2]=ecosystems;
    
    parameterDAO.insert("FOCUSAREA", project, columns, values);
  }

  public void delete(String project) throws SQLException 
  {
      parameterDAO.delete("FOCUSAREA", project);
  }

  public void insert (int project, String freshwater, String coastal, String ecosystems) 
  throws SQLException
  {
  	insert(project+"", freshwater,  coastal,  ecosystems);
  }

  public void delete(int project) throws SQLException 
  {
      parameterDAO.delete("FOCUSAREA", project);
  }

  
}
