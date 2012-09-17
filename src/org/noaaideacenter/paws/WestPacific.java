package org.noaaideacenter.paws;

import java.sql.SQLException;

public class WestPacific 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String allwest, String guam, String cnmi, String fsm, 
		                     String rmi, String palau, String other) throws SQLException
 {

     String [] columns = new String [7];
     String [] values  = new String [7];
 
 
     columns[0]="guam";  values[0]=guam;
     columns[1]="cnmi";  values[1]=cnmi;
     columns[2]="fsm";   values[2]=fsm;
     columns[3]="rmi";   values[3]=rmi;
     columns[4]="palau"; values[4]=palau;
     columns[5]="other"; values[5]=other;
     columns[6]="allwest"; values[6]=allwest;
 
     parameterDAO.insert("WESTPACIFIC", project, columns, values);
   }

  public void delete(String project) throws SQLException 
  {
      parameterDAO.delete("WESTPACIFIC", project);
  }
  
  public void insert (int project, String allwest, String guam, String cnmi, String fsm, 
          String rmi, String palau, String other) throws SQLException
  {
	  insert (project+"", allwest, guam, cnmi, fsm, rmi, palau, other); 	  
  }

  public void delete(int project) throws SQLException 
  {
      parameterDAO.delete("WESTPACIFIC", project);
  }
}
