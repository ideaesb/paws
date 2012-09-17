package org.noaaideacenter.paws;


import java.sql.SQLException;


public class CentralPacific 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
    public void insert (String project, String allcentral, String hawaii, String other) throws SQLException
    {

	    String [] columns = new String [3];
	    String [] values  = new String [3];
	    
	    columns[0]="allcentral"; values[0]=allcentral;
	    columns[1]="hawaii"; values[1]=hawaii;
	    columns[2]="other";values[2]=other;
	    
	    parameterDAO.insert("CENTRALPACIFIC", project, columns, values);
    }

    public void delete(String project) throws SQLException 
    {
        parameterDAO.delete("CENTRALPACIFIC", project);
    }
    
	
    public void insert (int project, String allcentral, String hawaii, String other) throws SQLException
    {
        insert(project+"", allcentral, hawaii, other);
    }


    public void delete(int project) throws SQLException 
    {
        delete(project+"");
    }
}
