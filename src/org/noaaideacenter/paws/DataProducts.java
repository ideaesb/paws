package org.noaaideacenter.paws;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.math.NumberUtils;

public class DataProducts 
{
	public DataProducts()
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
	
	 public List<ProjectBean> getList(DataSource d, String [] ecv, String [] dps, String [] regions)
	 {
		 System.out.println("Came into browse by getList");
		 // filter
		 ProjectBean filter = new ProjectBean(); 
		 if (ecv != null && ecv.length > 0)
		 {
            for (int i = 0; i < ecv.length; i++)
            {
            	int e = NumberUtils.toInt(ecv[i]);
            	
            	if (e == 0)
            	{
            		break;
            	}
            	else if (e == 1)
            	{
            		filter.setEcvAtmospheric("1");
            	}
            	else if (e == 2)
            	{
            		filter.setEcvOceanic("1");
            	}
            	else if (e == 3)
            	{
            		filter.setEcvTerrestrial("1");
            	}
            	else
            	{
                   // do nothing
            	}
            	
            }
		 }
         else
         {
            	System.out.println("NO ECV Selected for Search");
         }
            
            if (dps != null && dps.length > 0)
            {
            	for (int i = 0; i < dps.length; i++)
            	{
            		int dp =  NumberUtils.toInt(dps[i]);
            		
            		if (dp == 0)
            		{
            			break;
            		}
            		else if (dp == 1)
            		{
            			filter.setAnyPhysical("1");
            		}
            		else if (dp == 2)
            		{
            			filter.setProdHindcasts("1");
            		}
               		else if (dp == 3)
               		{
            			filter.setProdOutlooks("1");
            		}
               		else if (dp == 3)
               		{
            			filter.setProdProjections("1");
            		}
               		else if (dp == 4)
               		{
            			filter.setProdProjections("1");
            		}
               		else if (dp == 5)
               		{
            			filter.setProdGuidance("1");
            		}
               		else if (dp == 6)
               		{
            			filter.setProdApplications("1");
            		}
               		else if (dp == 7)
               		{
            			filter.setAnyNonPhysical("1");
            		}
            		else
            		{
            			
            		}
            		
            	}
            }
            else
            {
               	System.out.println("NO Data & Product Type Selecetd for Search");
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
			 list = p.getDaps(column, order, filter);
		 }
		 catch (SQLException e)
		 {
			 System.out.println("Database error while retrieving Data Products List");
			 System.out.println(e);
		 }
		 return list;
	 }
}
