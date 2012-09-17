package org.noaaideacenter.paws;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.math.NumberUtils;

public class Projects 
{

	public Projects()
	{
		
	}
	
	
	 public  List<ProjectBean> getList(DataSource d)
	 {
		 ProjectBean filter = new ProjectBean(); 
		 return getList(d, "nametitle", "ASC", filter);
	 }
	 
	 public List<ProjectBean> getList(DataSource d, String text)
	 {
		 // later implement filter
		 System.out.println("Came into search TEXT = " + text);
		 ProjectBean filter = new ProjectBean(); filter.setSearchString(text);
		 return getList(d, "nametitle", "ASC", filter);
	 }
	
	 public List<ProjectBean> getList(DataSource d, String [] capabilities, String [] focus, String [] regions)
	 {
		 System.out.println("Came into browse by getList");
		 // filter
		 ProjectBean filter = new ProjectBean(); 
		 if (capabilities != null && capabilities.length > 0)
		 {
            for (int i = 0; i < capabilities.length; i++)
            {
            	int capability = NumberUtils.toInt(capabilities[i]);
            	
            	if (capability == 0)
            	{
            		break;
            	}
            	else if (capability == 1)
            	{
            		filter.setOutreach("1");
            	}
            	else if (capability == 2)
            	{
            		filter.setObserving("1");
            	}
            	else if (capability == 3)
            	{
            		filter.setVariability("1");
            	}
            	else if (capability == 4)
            	{
            		filter.setAdaptation("1");
            	}
            	else if (capability == 5)
            	{
            		filter.setPolicies("1");
            	}
            	else if (capability == 6)
            	{
            		filter.setAssessment("1");
            	}
            	else
            	{
                   // do nothing
            	}
            	
            }
		 }
         else
         {
            	System.out.println("NO Capabilities");
         }
            
            if (focus != null && focus.length > 0)
            {
            	for (int i = 0; i < focus.length; i++)
            	{
            		int theFocus =  NumberUtils.toInt(focus[i]);
            		
            		if (theFocus == 0)
            		{
            			break;
            		}
            		else if (theFocus == 1)
            		{
            			filter.setFresh("1");
            		}
            		else if (theFocus == 2)
            		{
            			filter.setCoastal("1");
            		}
               		else if (theFocus == 3)
               		{
            			filter.setMarine("1");
            			System.out.println("Setting Marine in filter Bean...");
            		}
            		else
            		{
            			
            		}
            		
            	}
            }
            else
            {
               	System.out.println("NO Fociii");
            }
            
            if (regions != null && regions.length > 0)
            {
            	for (int i = 0; i < regions.length; i++)
            	{
            		int region =  NumberUtils.toInt(regions[i]);
            		
            		if (region == 0)
            		{
            			break;
            		}
            		else if (region == 1)
            		{
            			filter.setCentral("1");
            		}
            		else if (region == 2)
            		{
            			filter.setWestern("1");
            		}
            		else if (region == 3)
            		{
            			filter.setSouth("1");
            		}
            		else if (region == 4)
            		{
            			filter.setOtherregions("1");
            		}
            		else
            		{
            			
            		}
            		
            	}
            }
            else
            {
               	System.out.println("NO Regions");
            }
		 
		 
		 
		 return getList(d, "nametitle", "ASC", filter);
	 }
	 
	 public List<ProjectBean> getList(DataSource d, String column, String order, ProjectBean filter)
	 {
		 List <ProjectBean> list = null; 
		 try
		 {
			 ParameterDAO p = new ParameterDAO(); p.setDataSource(d);
			 filter.setParameterDAO(p);
			 list = p.getProjects(column, order, filter);
		 }
		 catch (SQLException e)
		 {
			 System.out.println("Database error while retrieving Projects List");
			 System.out.println(e);
		 }
		 return list;
	 }
}
