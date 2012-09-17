package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Ecv 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
    public void insert (String project, String atmospheric, String oceanic, String terrestrial) throws SQLException  
    {

    	String [] columns = new String [3];
    	String [] values  = new String [3];
    	
    	columns[0]="atmospheric";  values[0]=atmospheric;
    	columns[1]="oceanic";      values[1]=oceanic;
    	columns[2]="terrestrial";  values[2]=terrestrial;

    	parameterDAO.insert("ECV", project, columns, values);
    	
    }
    
    public void insert (int project, String atmospheric, String oceanic, String terrestrial) throws SQLException  
    {
    	insert(project+"", atmospheric, oceanic, terrestrial);
    }
    
    public void delete(String project) throws SQLException 
    {
      parameterDAO.delete("ECV", project);
    }

    public void delete(int project) throws SQLException 
    {
      parameterDAO.delete("ECV", project);
    }

    
}
