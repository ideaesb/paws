package org.noaaideacenter.paws;

import java.sql.SQLException;

public class Products 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
	
	  public void insert (String project, String hindcasts, String outlooks, String projections, String guidance, 
                          String applications) throws SQLException
	 {
		
		String [] columns = new String [5];
		String [] values  = new String [5];
		
		
		columns[0]="hindcasts";    values[0]=hindcasts;
		columns[1]="outlooks";     values[1]=outlooks;
		columns[2]="projections";  values[2]=projections;
		columns[3]="guidance";     values[3]=guidance;
		columns[4]="applications"; values[4]=applications;
		
		parameterDAO.insert("PRODUCTS", project, columns, values);
	}

  public void insert (int project, String hindcasts, String outlooks, String projections, String guidance, 
              String applications) throws SQLException
  {
	  insert(project+"", hindcasts, outlooks, projections, guidance, applications);
  }
	  
  public void delete(String project) throws SQLException 
  {
    parameterDAO.delete("PRODUCTS", project);
  }

  public void delete(int project) throws SQLException 
  {
    parameterDAO.delete("PRODUCTS", project);
  }

}
