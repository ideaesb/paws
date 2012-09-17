package org.noaaideacenter.paws;

import java.sql.SQLException;

public class NonPhysical 
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
   public void insert (String project, String enviro, String socio, String econo, String nonphysical) throws SQLException
   {
	    String [] columns = new String [4];
	    String [] values  = new String [4];
    
	    columns[0]="environmental"; values[0]=enviro;
	    columns[1]="sociocultural"; values[1]=socio;
	    columns[2]="economic"; values[2]=econo;
	    columns[3]="nonphysical"; values[3]=nonphysical;
	    
      parameterDAO.insert("NONPHYSICAL", project, columns, values);
   }
		
   public void delete (String project) throws SQLException
   {
 	 parameterDAO.delete("NONPHYSICAL", project);
   }
	
   public void insert(int project, String enviro, String socio, String econo, String nonphysical) throws SQLException 
   {
	   insert(project+"", enviro, socio, econo, nonphysical);
   }

   public void delete(int project) throws SQLException 
   {
 	   delete(project+"");
   }
}