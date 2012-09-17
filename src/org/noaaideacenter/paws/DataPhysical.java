package org.noaaideacenter.paws;

import java.sql.SQLException;

public class DataPhysical 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	public void setParameterDAO(ParameterDAO p)
	{
	  this.parameterDAO = p;
	}

	public void insert (String project, String insitu, String satellite, String model, String reanalysis, String bathymetry, String imagery) 
	   throws SQLException  
    {
    	String [] columns = new String [6];
    	String [] values  = new String [6];
    	
    	columns[0]="insitu";     values[0]=insitu;
    	columns[1]="satellite";  values[1]=satellite;
    	columns[2]="model";      values[2]=model;
    	columns[3]="reanalysis"; values[3]=reanalysis;
    	columns[4]="bathymetry"; values[4]=bathymetry;
    	columns[5]="imagery";    values[5]=imagery;
    	
    	parameterDAO.insert("DATAPHYSICAL", project, columns, values);

    }
	
	public void insert (int project, String insitu, String satellite, String model, String reanalysis, String bathymetry, String imagery) 
	   throws SQLException  
    {
	  insert(project+"", insitu, satellite, model, reanalysis, bathymetry, imagery);	
    }
	
      public void delete(String project) throws SQLException 
	  {
	    parameterDAO.delete("DATAPHYSICAL", project);
	  }

	  public void delete(int project) throws SQLException 
	  {
	    parameterDAO.delete("DATAPHYSICAL", project);
	  }

	
}
