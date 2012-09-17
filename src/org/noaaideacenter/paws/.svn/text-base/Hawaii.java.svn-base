package org.noaaideacenter.paws;

import java.sql.SQLException;


public class Hawaii 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
    public void insert (String project, String bigisland, String maui, String oahu, String kauai) 
           throws SQLException
    {

	    String [] columns = new String [4];
	    String [] values  = new String [4];
	    
	    
	    columns[0]="bigisland"; values[0]=bigisland;
	    columns[1]="maui";     values[1]=maui;
	    columns[2]="oahu";     values[2]=oahu;
	    columns[3]="kauai";    values[3]=kauai;
	    
	    parameterDAO.insert("HAWAII", project, columns, values);
    }

    public void delete(String project) throws SQLException 
    {
        parameterDAO.delete("HAWAII", project);
    }

    public void insert (int project, String bigisland, String maui, String oahu, String kauai) 
    throws SQLException
    {
        insert(project+"", bigisland+"", maui+"", oahu+"", kauai+"");
    }

    public void insert (int project, boolean bigisland, boolean maui, boolean oahu, boolean kauai) 
    throws SQLException
    {
        insert(project+"", bigisland+"", maui+"", oahu+"", kauai+"");
    }
    
    
    
    public void delete(int project) throws SQLException 
    {
        parameterDAO.delete("HAWAII", project);
    }

}
