package org.noaaideacenter.paws;

import java.sql.SQLException;

public class CapabilityArea
{
	private ParameterDAO parameterDAO  = new ParameterDAO();
	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO p)
	{
		this.parameterDAO = p;
	}
	
  public void insert (String project,   String training, String education, String outreach,  
                             String observing, String dataservices, String variability, String impacts,   
                             String guidance, String applications, String policies, String assessment) 
    throws SQLException
  {
  
    String [] columns = new String [11];
    String [] values  = new String [11];
    
    
    columns[0] ="training";       values[0] =training;
    columns[1] ="education";      values[1] =education;
    columns[2] ="outreach";       values[2] =outreach;
    columns[3] ="observing";      values[3] =observing;
    columns[4] ="dataservices";   values[4] =dataservices;
    columns[5] ="variability";    values[5] =variability;
    columns[6] ="impacts";        values[6] =impacts;
    columns[7] ="guidance";       values[7] =guidance;
    columns[8] ="applications";   values[8] =applications;
    columns[9] ="policies";       values[9] =policies;
    columns[10]="assessment";     values[10]=assessment;
    
    parameterDAO.insert("CAPABILITYAREA", project, columns, values);
  }
  
  public void insert (int project, String training, String education, String outreach,  
      String observing, String dataservices, String variability, String impacts,   
      String guidance, String applications, String policies, String assessment) 
  throws SQLException
  {
  	insert(project+"",  training,  education,  outreach,  
         observing,  dataservices,  variability,  impacts,   
         guidance,  applications,  policies,  assessment);
  }
  
  public void delete(String project) throws SQLException 
  {
    parameterDAO.delete("CAPABILITYAREA", project);
  }

  public void delete(int project) throws SQLException 
  {
    parameterDAO.delete("CAPABILITYAREA", project);
  }
	
}
