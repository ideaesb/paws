package org.noaaideacenter.paws;

import java.sql.SQLException;

public class SouthPacific 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project, String allsouth, String americansamoa, String samoa, String tonga, 
                             String fiji, String australia, String newzealand, String frenchpoly,
                             String other) throws SQLException
  {

	String [] columns = new String [9];
	String [] values  = new String [9];
	
	
	columns[0]="americansamoa";  values[0]=americansamoa;
	columns[1]="samoa";          values[1]=samoa;
	columns[2]="tonga";          values[2]=tonga;
	columns[3]="fiji";           values[3]=fiji;
	columns[4]="australia";      values[4]=australia;
	columns[5]="newzealand";     values[5]=newzealand;
	columns[6]="frenchpoly";     values[6]=frenchpoly;
	columns[7]="other";          values[7]=other;
	columns[8]="allsouth";       values[8]=allsouth;
	
	parameterDAO.insert("SOUTHPACIFIC", project, columns, values);
  }

  public void insert (int project, String allsouth, String americansamoa, String samoa, String tonga, 
          String fiji, String australia, String newzealand, String frenchpoly,
          String other) throws SQLException
  {
    insert(project+"", allsouth, americansamoa, samoa, tonga, fiji, australia, newzealand, frenchpoly, other);	  
  }
  
  public void delete(String project) throws SQLException 
  {
    parameterDAO.delete("SOUTHPACIFIC", project);
  }

  public void delete(int project) throws SQLException 
  {
    parameterDAO.delete("SOUTHPACIFIC", project);
  }
	
	
	
}
