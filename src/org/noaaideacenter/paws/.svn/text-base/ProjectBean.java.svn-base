package org.noaaideacenter.paws;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;


/**
 * This will be called from addproject/updateProject etc
 * @author Uday
 *
 */
public class ProjectBean
{
	
	// Status Codes
	public final int  ONGOING  = 1; 
	public final int  PLANNED  = 2; 
	public final int  PROPOSED = 3; 
	public final int  UNKNOWN  = 4;
	public final int  COMPLETED = 5;
	
	// Maximum text field lengths (from db.sql)
	public final int  MAX_TAG_LENGTH =  50;
	public final int  MAX_NAME_LENGTH = 150;
	public final int  MAX_DESCRIPTION_LENGTH = 1000;
	public final int  MAX_FILENAME_LENGTH = 50;
	
	
   private String searchString = "";
   private String filterTestString = "";
	
	
	private int    projectnumber         = 0;    

	private String projectname           = "";
	private int    code                  = 0;

  private String training              = "";
  private String education             = "";
  private String outreach              = "";

  private String observing             = "";
  private String dataservices          = "";

  private String variability           = "";
  private String operational           = "";
  
  private String research              = "";

  private String vhistorical           = "";
  private String vprojections          = "";

  private String asurface              = "";
  private String upperair              = "";
  private String composition           = "";
  
  
  private String osurface              = "";
  private String subsurface            = "";
  private String terrestrial           = "";


 
  private String seasonal              = "";      
  private String annual                = ""; 
  private String decadal               = "";

  private String effect                = "";
  private String impacts               = "";
  private String ehistorical           = "";
  private String eprojections          = "";
  
  private String projectURL            = "";


  private String adaptation           = "";

  // Sectors
  private String phs                  = ""; // Public Health Services
  private String fwr                  = ""; // Fresh Water Resources
  private String ene                  = ""; // Energy
  private String tcc                  = ""; // Transportation, Communication and Commerce
  private String cpd                  = ""; // Community Planning & Development
  private String scr                  = ""; // Social and Cultural Resources
  private String afi                  = ""; // Agriculture and Fisheries
  private String rat                  = ""; // Recreation and Tourism
  private String eco                  = ""; // Ecosystems
  private String oth                  = ""; // Other

  private String guidance             = "";
  private String gvariability         = "";
  private String geffects             = "";


  private String apps                 = "";
  private String avariability         = "";
  private String aeffects             = "";


  private String policies             = "";
  private String assessment           = "";


  private String fresh                = "";
  private String coastal              = "";
  private String marine               = "";

  private String central              = "";
  private String hawaii               = "";
  private String big                  = "";
  private String maui                 = "";
  private String oahu                 = "";
  private String kauai                = "";
  private String hother               = "";

  private String western              = "";
  private String guam                 = "";
  private String cnmi                 = "";
  private String fsm                  = "";
  private String rmi                  = "";
  private String palau                = "";
  private String wother               = "";

  private String south                = ""; 
  private String asam                 = "";
  private String samoa                = "";
  private String tonga                = "";
  private String fiji                 = "";
  private String oz                   = "";
  private String nz                   = "";
  private String fp                   = "";
  private String sother               = "";
  
  private String otherregions         = ""; 
  
  // dnp overloaded
  
  private boolean dap                = false;
  
  private String ecvAtmospheric      = "";
  private String ecvOceanic          = "";
  private String ecvTerrestrial      = "";
  
  private String phyInsitu           = "";
  private String phySatellite        = "";
  private String phyModel            = "";
  private String phyReanalysis       = "";
  private String phyBathymetry       = "";
  private String phyImagery          = "";
  private String anyPhysical         = "";
  
  private String prodHindcasts       = "";
  private String prodOutlooks        = "";
  private String prodProjections     = "";
  private String prodGuidance        = "";
  private String prodApplications    = "";

  private String nonPhysicalEnvironmental = "";
  private String nonPhysicalSocioCultural = "";
  private String nonPhysicalEconomic = "";
  private String nonPhysical         = "";
  private String anyNonPhysical      = "";

  private String status               = "";

  private String [] leadagencies      = new String[0];  
  private String [] partneragencies   = new String[0]; 
    
  private String projectdescription   = "";
  
  private String [] contactName      = new String[0];
  private String [] emailsAddress    = new String[0];


  private String worksheetfilename    = "";
  
  private String tag                  = "";
  private String deleted              = "false";
  private String url                  = "";
  
  private ParameterDAO parameterDAO  = new ParameterDAO();
  
  private List <Agency> leadList = null;
  private List <Agency> partnerList = null;
  private List <Contact> contactList = null;
	

	public ProjectBean()
	{
	}
  
	public boolean isDap()
	{
		return dap;
	}
	
	public void setDapFlag(boolean dpf)
	{
		this.dap = dpf;
	}
	
	public String getProjectnameWithWorkSheetLink(String baseurl)
	{
		 if (StringUtils.isBlank(this.getWorksheetfilename()))
		 {
              return this.getProjectname(); 
		 }
		 else
		 {
			   return "<a href=\"" + baseurl  + this.getWorksheetfilename() + "\" target=\"_blank\">" + this.getProjectname() + "</a>";
		 }
	}
	
	public String getProjectdescriptionLimited()
	{
		return this.getProjectdescription();
	}

	public String getSearchString() {
		return searchString;
	}


	public String getFocusImages()
	{
		StringBuffer sb = new StringBuffer();
		
		// freshwater image 
		String fresh   = "<img style=\"margin-left: 10px;\" src=\"images/fresh2.jpg\" alt=\"Fresh Water Resources and Drought\" title=\"Fresh Water Resources and Drought\" />";
		// coastal 
		String coastal = "<img style=\"margin-left: 10px;\" src=\"images/coastal2.jpg\" alt=\"Coastal Inundation/SLR Extreme Weather, and Community Resilience\" title=\"Coastal Inundation/SLR Extreme Weather, and Community Resilience\"/>";
		// marine
		String marine  = "<img style=\"margin-left: 10px;\" src=\"images/marine2.jpg\" alt=\"Marine and terrestrial ecosystems\" title=\"Marine and terrestrial ecosystems\"  />";
		
		
		if (ParameterDAO.parse(this.getFresh()))
		{
			sb.append(fresh);
		}
		if (ParameterDAO.parse(this.getCoastal()))
		{
			sb.append(coastal);
		}
		if (ParameterDAO.parse(this.getMarine()))
		{
			sb.append(marine);
		}
		
		if (sb.length() == 0) return "None";	
		
		return sb.toString();
	}
	
	public String getRegionLists()
	{
		StringBuffer sb = new StringBuffer();
		
		// CNP
		String central = "<li style=\"margin-left: 10px;\">Central North Pacific";
		
		// WNP
		String western = "<li style=\"margin-left: 10px;\">Western North Pacific";
		
		// South 
		String south =  "<li style=\"margin-left: 10px;\">South Pacific";
		
		sb.append("<ul style=\"display: inline;margin-left: 0;padding-left: 0;\">");

		if (ParameterDAO.parse(this.getCentral()))
		{
			sb.append(central);
			sb.append(this.getCentralPacificChoices());
			sb.append("</li>");
		}
		
		if (ParameterDAO.parse(this.getWestern()))
		{
			sb.append(western);
			sb.append(this.getWesternPacificChoices());
			sb.append("</li>");
		}
		
		if (ParameterDAO.parse(this.getSouth()))
		{
			sb.append(south);
			sb.append(this.getSouthPacificChoices());
			sb.append("</li>");
		}
		
		if (ParameterDAO.parse(this.getOtherregions()))
		{
			sb.append("<li  style=\"margin-left: 10px;\">Other (Outside Pacific Region)</li>" );
		}
		
		
		sb.append("</ul>");
		
		return sb.toString();
	}
	
	public String getDapChoices()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("<ul style=\"display: inline;margin-left: 0;padding-left: 0;\">");
		
		if (ParameterDAO.parse(this.anyPhysical)       ||
			ParameterDAO.parse(this.anyNonPhysical)    ||
			ParameterDAO.parse(this.prodHindcasts)     ||
			ParameterDAO.parse(this.prodOutlooks)      ||
			ParameterDAO.parse(this.prodProjections)   ||
			ParameterDAO.parse(this.prodGuidance)      ||
			ParameterDAO.parse(this.prodApplications))
		{
		
			if (ParameterDAO.parse(this.anyPhysical))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Data- Physical");
				sb.append(getPhysicalChoices());
				sb.append("</li>");
			}
			
			if (ParameterDAO.parse(this.prodHindcasts))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Products: Hindcasts (climatologies)");
				sb.append("</li>");
			}
			
			if (ParameterDAO.parse(this.prodOutlooks))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Products: Outloooks (monthly to annual)");
				sb.append("</li>");
			}
			
			if (ParameterDAO.parse(this.prodProjections))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Products: Projections (intrannual to multi-decadal)");
				sb.append("</li>");
			}
			
			if (ParameterDAO.parse(this.prodGuidance))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Products: Guidance, including &quot;Best Practices&quot; Manuals, Toolkits, and Guides");
				sb.append("</li>");
			}

			if (ParameterDAO.parse(this.prodApplications))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Products: Applications, including Visualization and Decision Support Tools");
				sb.append("</li>");
			}
			
			if (ParameterDAO.parse(this.anyNonPhysical))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Data, Products, and Tools- Non-physical");
				sb.append(getNonPhysicalChoices());
				sb.append("</li>");
			}
		}
		else
		{
			sb.append("<li style=\"margin-left: 10px;\">");
			sb.append("None");
			sb.append("</li>");
		}
		sb.append("</ul>");
		
		return sb.toString();
	}

	public String getEcvChoices()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("<ul style=\"display: inline;margin-left: 0;padding-left: 0;\">");
		
		if (ParameterDAO.parse(this.ecvAtmospheric) ||
			ParameterDAO.parse(this.ecvOceanic)     ||
			ParameterDAO.parse(this.ecvTerrestrial)	)
		{
		
			if (ParameterDAO.parse(this.ecvAtmospheric))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Atmospheric (e.g., Air Temperature, Rainfall, Wind speed and direction)");
				sb.append("</li>");
			}
			
			if (ParameterDAO.parse(this.ecvOceanic))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Oceanic (e.g., Water Temperature, Salinity, Acidity, Sea Level, Wave Height)");
				sb.append("</li>");
			}
			
			if (ParameterDAO.parse(this.ecvTerrestrial))
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append("Terrestrial (e.g., Groundwater, Soil Moisture)");
				sb.append("</li>");
			}
		}
		else
		{
			sb.append("<li style=\"margin-left: 10px;\">");
			sb.append("None");
			sb.append("</li>");
		}
		sb.append("</ul>");
		
		return sb.toString();
	}

	public String getLeadAgencyLinks()
	{
		StringBuffer sb = new StringBuffer();
		
		List <Agency> leads = this.getLeadList();
		Iterator <Agency> iterator = leads.iterator();
		int count = 0;
		while(iterator.hasNext())
		{
			Agency agency = iterator.next();
			
		    if (count > 0) sb.append(", ");
		    
		    if (StringUtils.isBlank(agency.getUrl()))
		    {
		    	sb.append(agency.getAcronym());
		    }
		    else
		    {
		      sb.append("<a href=\"");
		      sb.append(agency.getUrl());
		      sb.append("\" target=\"_blank\">");
		      sb.append(agency.getAcronym());
		      sb.append("</a>");
		    }
		    
			count++;
		}
		
		if (sb.length() == 0) return "None";	
		return sb.toString();
	}
	
	public String getContactsLinks()
	{
		StringBuffer sb = new StringBuffer();
		
		List <Contact> contacts = this.getContactList();
		Iterator <Contact> iterator = contacts.iterator();
		int count = 0;
		while(iterator.hasNext())
		{
			Contact contact = iterator.next();
			
		    if (count > 0) sb.append(", ");
		    
		    sb.append(contact.getName());
		    
		    if (StringUtils.isBlank(contact.getEmail()))
		    {
		    	// nada
		    }
		    else
		    {
		      sb.append("(<a href=\"mailto:");
		      sb.append(contact.getEmail());
		      sb.append("\">");
		      sb.append(contact.getEmail());
		      sb.append("</a>)");
		    }
		    
			count++;
		}
		
		if (sb.length() == 0) return "None";	
		return sb.toString();
	}

	public void setSearchString(String searchString) 
	{
		this.searchString = searchString;
	}



	public String getFilterTestString() {
		return filterTestString;
	}



	/**
	 * @return the leadList
	 */
	public List<Agency> getLeadList()
	{
		return leadList;
	}



	/**
	 * @param leadList the leadList to set
	 */
	public void setLeadList(List<Agency> aList)
	{
		this.leadList = aList;
		if (aList == null) 
		{
			this.setLeadagencies(new String[0]);
		}
		else if (aList.size() == 0)
		{
			this.setLeadagencies(new String[0]);
		}
		else
		{
  		String [] leads = new String[aList.size()];
  		
  		for (int i = 0; i < aList.size(); i++)
  		{
  			leads[i] = aList.get(i).getOrg() + "";
  		}
  		
  		this.leadagencies = leads;
		}
	}



	/**
	 * @return the partnerList
	 */
	public List<Agency> getPartnerList()
	{
		return partnerList;
	}



	/**
	 * @param partnerList the partnerList to set
	 */
	public void setPartnerList(List<Agency> pList)
	{
		this.partnerList = pList;
		if (pList == null) 
		{
			this.setPartneragencies(new String[0]);
		}
		else if (pList.size() == 0)
		{
			this.setPartneragencies(new String[0]);
		}
		else
		{
  		String [] pards = new String[pList.size()];
  		
  		for (int i = 0; i < pList.size(); i++)
  		{
  			pards[i] = pList.get(i).getOrg() + "";
  		}
  		
  		this.partneragencies = pards;
  		
		}
	}



	/**
	 * @return the parameterDAO
	 */
	public ParameterDAO getParameterDAO()
	{
		return parameterDAO;
	}


	/**
	 * @param parameterDAO the parameterDAO to set
	 */
	public void setParameterDAO(ParameterDAO parameterDAO)
	{
		this.parameterDAO = parameterDAO;
	}


	/**
	 * @return the projectname
	 */
	public String getProjectname()
	{
		return StringUtils.trimToEmpty(projectname);
	}

	/**
	 * @return the projectname
	 */
	public String getNameWithTag()
	{
		if (StringUtils.isNotBlank(this.getTag()))
		{
		  return StringUtils.trimToEmpty(projectname) + " (" + StringUtils.trimToEmpty(this.getTag()) + ")";
		}
		else
		{
			return this.getProjectname();
		}
	}
	
	/**
	 * used in thr table, senses url, strips it off 
	 * @return
	 */
	public String getProjectNameStripURL()
	{
	  
	  if (StringUtils.containsIgnoreCase(this.getProjectname(), "http://"))
	  {
		  StringBuffer sb = new StringBuffer();
		  sb.append(StringUtils.trimToEmpty(StringUtils.substringBefore(this.getProjectname(), "http://")));
		  if (StringUtils.isNotBlank(this.getTag()))
		  {
			 sb.append(" (" + StringUtils.trimToEmpty(this.getTag()) + ")");
	      }
		  return sb.toString();
	  }
	  else
	  {
		  return this.getNameWithTag();
	  }
	}

	public String getProjectURL() {
		return projectURL;
	}

	public String getFullyFormedProjectURLifExists()
	{
		  if (StringUtils.containsIgnoreCase(this.getProjectname(), "http://"))
		  {
		    return "[<a href=\"" + this.getProjectURL() + "\" target=\"_blank\">Link</a>]";
		  }
		  else
		  {
			  return "";
		  }
	}


    public void setProjectURL(String str) 
    {
      this.projectURL = "http://" + StringUtils.trimToEmpty(StringUtils.substringAfter(str, "http://"));
	}



	/**
	 * @param projectname the projectname to set
	 */
	public void setProjectname(String pname)
	{
		// first trim whitespace, then trim to max database field size
		this.projectname = StringUtils.left(StringUtils.trimToEmpty(pname), this.MAX_NAME_LENGTH);
		// extract the URL from the name
		this.setProjectURL(pname);
	}

	/**
	 * @return the training
	 */
	public String getTraining()
	{
		return StringUtils.trimToEmpty(training);
	}

	/**
	 * @return the training
	 */
	public boolean getTrainingBoolean()
	{
		return ParameterDAO.parse(this.getTraining());
	}


	/**
	 * @param training the training to set
	 */
	public void setTraining(String training)
	{
		this.training = StringUtils.trimToEmpty(training);
	}

	/**
	 * @return the education
	 */
	public String getEducation()
	{
		return StringUtils.trimToEmpty(education);
	}

	/**
	 * @return the education
	 */
	public boolean getEducationBoolean()
	{
		return ParameterDAO.parse(this.getEducation());
	}

	
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education)
	{
		this.education = StringUtils.trimToEmpty(education);
	}

	/**
	 * @return the outreach
	 */
	public String getOutreach()
	{
		return StringUtils.trimToEmpty(outreach);
	}

	/**
	 * @return the outreach boolean
	 */
	public boolean getOutreachBoolean()
	{
		return ParameterDAO.parse(this.getOutreach());
	}

	/**
	 * @param outreach the outreach to set
	 */
	public void setOutreach(String outreach)
	{
		this.outreach = StringUtils.trimToEmpty(outreach);
	}

	/**
	 * @return the observing
	 */
	public String getObserving()
	{
		return StringUtils.trimToEmpty(observing);
	}

	/**
	 * @param observing the observing to set
	 */
	public void setObserving(String observing)
	{
		this.observing = StringUtils.trimToEmpty(observing);
	}

	/**
	 * @return the dataservices
	 */
	public String getDataservices()
	{
		return StringUtils.trimToEmpty(dataservices);
	}

	/**
	 * @param dataservices the dataservices to set
	 */
	public void setDataservices(String dataservices)
	{
		this.dataservices = StringUtils.trimToEmpty(dataservices);
	}

	/**
	 * @return the variability
	 */
	public String getVariability()
	{
		return StringUtils.trimToEmpty(variability);
	}

	/**
	 * @param variability the variability to set
	 */
	public void setVariability(String variability)
	{
		this.variability = StringUtils.trimToEmpty(variability);
	}

	/**
	 * @return the operational
	 */
	public String getOperational()
	{
		return StringUtils.trimToEmpty(operational);
	}

	/**
	 * @param operational the operational to set
	 */
	public void setOperational(String operational)
	{
		this.operational = StringUtils.trimToEmpty(operational);
		if (ParameterDAO.parse(operational))  this.setVariability("true");
	}

	/**
	 * @return the research
	 */
	public String getResearch()
	{
		return StringUtils.trimToEmpty(research);
	}

	/**
	 * @param research the research to set
	 */
	public void setResearch(String research)
	{
		this.research = StringUtils.trimToEmpty(research);
		//System.out.println("Set research " + research + " for project " + this.getProjectnumber());
		if (ParameterDAO.parse(research))  this.setVariability("true");
	}

	/**
	 * @return the vhistorical
	 */
	public String getVhistorical()
	{
		return StringUtils.trimToEmpty(vhistorical);
	}

	/**
	 * @param vhistorical the vhistorical to set
	 */
	public void setVhistorical(String vhistorical)
	{
		this.vhistorical = StringUtils.trimToEmpty(vhistorical);
		if (ParameterDAO.parse(vhistorical))  this.setVariability("true");
	}

	/**
	 * @return the vprojections
	 */
	public String getVprojections()
	{
		return StringUtils.trimToEmpty(vprojections);
	}

	/**
	 * @param vprojections the vprojections to set
	 */
	public void setVprojections(String vprojections)
	{
		this.vprojections = StringUtils.trimToEmpty(vprojections);
		if (ParameterDAO.parse(vprojections))  this.setVariability("true");
	}

	/**
	 * @return the asurface
	 */
	public String getAsurface()
	{
		return StringUtils.trimToEmpty(asurface);
	}

	/**
	 * @param asurface the asurface to set
	 */
	public void setAsurface(String asurface)
	{
		this.asurface = StringUtils.trimToEmpty(asurface);
		if (ParameterDAO.parse(asurface)) this.setVariability("true");
	}

	/**
	 * @return the upperair
	 */
	public String getUpperair()
	{
		return StringUtils.trimToEmpty(upperair);
	}

	/**
	 * @param upperair the upperair to set
	 */
	public void setUpperair(String upperair)
	{
		this.upperair = StringUtils.trimToEmpty(upperair);
		if (ParameterDAO.parse(upperair)) this.setVariability("true");
	}

	/**
	 * @return the composition
	 */
	public String getComposition()
	{
		return StringUtils.trimToEmpty(composition);
	}

	/**
	 * @param composition the composition to set
	 */
	public void setComposition(String composition)
	{
		this.composition = StringUtils.trimToEmpty(composition);
		if (ParameterDAO.parse(composition)) this.setVariability("true");
	}

	/**
	 * @return the osurface
	 */
	public String getOsurface()
	{
		return StringUtils.trimToEmpty(osurface);
	}

	/**
	 * @param osurface the osurface to set
	 */
	public void setOsurface(String osurface)
	{
		this.osurface = StringUtils.trimToEmpty(osurface);
		if (ParameterDAO.parse(osurface)) this.setVariability("true");
	}

	/**
	 * @return the subsurface
	 */
	public String getSubsurface()
	{
		return StringUtils.trimToEmpty(subsurface);
	}

	/**
	 * @param subsurface the subsurface to set
	 */
	public void setSubsurface(String subsurface)
	{
		this.subsurface = StringUtils.trimToEmpty(subsurface);
		if (ParameterDAO.parse(subsurface)) this.setVariability("true");
	}

	/**
	 * @return the terrestrial
	 */
	public String getTerrestrial()
	{
		return StringUtils.trimToEmpty(terrestrial);
	}

	/**
	 * @param terrestrial the terrestrial to set
	 */
	public void setTerrestrial(String terrestrial)
	{
		this.terrestrial = terrestrial;
		if (ParameterDAO.parse(terrestrial)) this.setVariability("true");
	}

	/**
	 * @return the seasonal
	 */
	public String getSeasonal()
	{
		return StringUtils.trimToEmpty(seasonal);
	}

	/**
	 * @param seasonal the seasonal to set
	 */
	public void setSeasonal(String seasonal)
	{
		this.seasonal = StringUtils.trimToEmpty(seasonal);
		if (ParameterDAO.parse(seasonal)) this.setVariability("true");
	}

	/**
	 * @return the annual
	 */
	public String getAnnual()
	{
		return StringUtils.trimToEmpty(annual);
	}

	/**
	 * @param annual the annual to set
	 */
	public void setAnnual(String annual)
	{
		this.annual = StringUtils.trimToEmpty(annual);
		if (ParameterDAO.parse(annual)) this.setVariability("true");
	}

	/**
	 * @return the decadal
	 */
	public String getDecadal()
	{
		return StringUtils.trimToEmpty(decadal);
	}

	/**
	 * @param decadal the decadal to set
	 */
	public void setDecadal(String decadal)
	{
		this.decadal = StringUtils.trimToEmpty(decadal);
		if (ParameterDAO.parse(decadal)) this.setVariability("true");
	}

	/**
	 * @return the effect
	 */
	public String getEffect()
	{
		return StringUtils.trimToEmpty(effect);
	}

	/**
	 * @param effect the effect to set
	 */
	public void setEffect(String effect)
	{
		this.effect = StringUtils.trimToEmpty(effect);
	}

	/**
	 * @return the impacts
	 */
	public String getImpacts()
	{
		return StringUtils.trimToEmpty(impacts);
	}

	/**
	 * @param impacts the impacts to set
	 */
	public void setImpacts(String impacts)
	{
		this.impacts = StringUtils.trimToEmpty(impacts);
		if (ParameterDAO.parse(impacts)) this.setEffect("true");
	}

	/**
	 * @return the ehistorical
	 */
	public String getEhistorical()
	{
		return StringUtils.trimToEmpty(ehistorical);
	}

	/**
	 * @param ehistorical the ehistorical to set
	 */
	public void setEhistorical(String ehistorical)
	{
		this.ehistorical = StringUtils.trimToEmpty(ehistorical);
		if (ParameterDAO.parse(ehistorical)) this.setImpacts("true"); 
	}

	/**
	 * @return the eprojections
	 */
	public String getEprojections()
	{
		return StringUtils.trimToEmpty(eprojections);
	}

	/**
	 * @param eprojections the eprojections to set
	 */
	public void setEprojections(String eprojections)
	{
		this.eprojections = StringUtils.trimToEmpty(eprojections);
		if (ParameterDAO.parse(eprojections)) this.setImpacts("true");
	}

	/**
	 * @return the adaptation
	 */
	public String getAdaptation()
	{
		return StringUtils.trimToEmpty(adaptation);
	}

	/**
	 * @param adaptation the adaptation to set
	 */
	public void setAdaptation(String adaptation)
	{
		this.adaptation = StringUtils.trimToEmpty(adaptation);
		if (ParameterDAO.parse(adaptation)) this.setEffect("true");
	}

	/**
	 * @return the phs
	 */
	public String getPhs()
	{
		return StringUtils.trimToEmpty(phs);
	}

	/**
	 * @param phs the phs to set
	 */
	public void setPhs(String phs)
	{
		this.phs = StringUtils.trimToEmpty(phs);
		if (ParameterDAO.parse(phs)) this.setEffect("true");
	}

	/**
	 * @return the fwr
	 */
	public String getFwr()
	{
		return StringUtils.trimToEmpty(fwr);
	}

	/**
	 * @param fwr the fwr to set
	 */
	public void setFwr(String fwr)
	{
		this.fwr = StringUtils.trimToEmpty(fwr);
		if (ParameterDAO.parse(fwr)) this.setEffect("true");
	}

	/**
	 * @return the ene
	 */
	public String getEne()
	{
		return StringUtils.trimToEmpty(ene);
	}

	/**
	 * @param ene the ene to set
	 */
	public void setEne(String ene)
	{
		this.ene = StringUtils.trimToEmpty(ene);
		if (ParameterDAO.parse(ene)) this.setEffect("true");
	}

	/**
	 * @return the tcc
	 */
	public String getTcc()
	{
		return StringUtils.trimToEmpty(tcc);
	}

	/**
	 * @param tcc the tcc to set
	 */
	public void setTcc(String tcc)
	{
		this.tcc = StringUtils.trimToEmpty(tcc);
		if (ParameterDAO.parse(tcc)) this.setEffect("true");
	}

	/**
	 * @return the cpd
	 */
	public String getCpd()
	{
		return StringUtils.trimToEmpty(cpd);
	}

	/**
	 * @param cpd the cpd to set
	 */
	public void setCpd(String cpd)
	{
		this.cpd = StringUtils.trimToEmpty(cpd);
		if (ParameterDAO.parse(cpd)) this.setEffect("true");
	}

	/**
	 * @return the scr
	 */
	public String getScr()
	{
		return StringUtils.trimToEmpty(scr);
	}

	/**
	 * @param scr the scr to set
	 */
	public void setScr(String scr)
	{
		this.scr = StringUtils.trimToEmpty(scr);
		if (ParameterDAO.parse(scr)) this.setEffect("true");
	}

	/**
	 * @return the afi
	 */
	public String getAfi()
	{
		return StringUtils.trimToEmpty(afi);
	}

	/**
	 * @param afi the afi to set
	 */
	public void setAfi(String afi)
	{
		this.afi = StringUtils.trimToEmpty(afi);
		if (ParameterDAO.parse(afi)) this.setEffect("true");
	}

	/**
	 * @return the rat
	 */
	public String getRat()
	{
		return StringUtils.trimToEmpty(rat);
	}

	/**
	 * @param rat the rat to set
	 */
	public void setRat(String rat)
	{
		this.rat = StringUtils.trimToEmpty(rat);
		if (ParameterDAO.parse(rat)) this.setEffect("true");
	}

	/**
	 * @return the eco
	 */
	public String getEco()
	{
		return StringUtils.trimToEmpty(eco);
	}

	/**
	 * @param eco the eco to set
	 */
	public void setEco(String eco)
	{
		this.eco = StringUtils.trimToEmpty(eco);
		if (ParameterDAO.parse(eco)) this.setEffect("true");
	}

	/**
	 * @return the oth
	 */
	public String getOth()
	{
		return StringUtils.trimToEmpty(oth);
	}

	/**
	 * @param oth the oth to set
	 */
	public void setOth(String oth)
	{
		this.oth = StringUtils.trimToEmpty(oth);
		if (ParameterDAO.parse(oth)) this.setEffect("true");
	}

	/**
	 * @return the guidance
	 */
	public String getGuidance()
	{
		return StringUtils.trimToEmpty(guidance);
	}

	/**
	 * @param guidance the guidance to set
	 */
	public void setGuidance(String guidance)
	{
		this.guidance = StringUtils.trimToEmpty(guidance);
	}

	/**
	 * @return the gvariability
	 */
	public String getGvariability()
	{
		return StringUtils.trimToEmpty(gvariability);
	}

	/**
	 * @param gvariability the gvariability to set
	 */
	public void setGvariability(String gvariability)
	{
		this.gvariability = StringUtils.trimToEmpty(gvariability);
		if (ParameterDAO.parse(gvariability)) setGuidance("true");
	}

	/**
	 * @return the geffects
	 */
	public String getGeffects()
	{
		return StringUtils.trimToEmpty(geffects);
	}

	/**
	 * @param geffects the geffects to set
	 */
	public void setGeffects(String geffects)
	{
		this.geffects = StringUtils.trimToEmpty(geffects);
		if (ParameterDAO.parse(geffects)) setGuidance("true");
	}

	/**
	 * @return the apps
	 */
	public String getApps()
	{
		return StringUtils.trimToEmpty(apps);
	}

	/**
	 * @return the apps
	 */
	public String getApplications()
	{
		return this.getApps();
	}

	/**
	 * @param apps the apps to set
	 */
	public void setApps(String apps)
	{
		this.apps = StringUtils.trimToEmpty(apps);
	}

	/**
	 * @param apps the apps to set
	 */
	public void setApplications(String apps)
	{
		this.setApps(apps);
	}
	
	/**
	 * @return the avariability
	 */
	public String getAvariability()
	{
		return StringUtils.trimToEmpty(avariability);
	}

	/**
	 * @param avariability the avariability to set
	 */
	public void setAvariability(String avariability)
	{
		this.avariability = StringUtils.trimToEmpty(avariability);
		if (ParameterDAO.parse(avariability)) setApps("true");
	}

	/**
	 * @return the aeffects
	 */
	public String getAeffects()
	{
		return StringUtils.trimToEmpty(aeffects);
	}

	/**
	 * @param aeffects the aeffects to set
	 */
	public void setAeffects(String aeffects)
	{
		this.aeffects = StringUtils.trimToEmpty(aeffects);
		if (ParameterDAO.parse(aeffects)) setApps("true");
	}

	/**
	 * @return the policies
	 */
	public String getPolicies()
	{
		return StringUtils.trimToEmpty(policies);
	}

	/**
	 * @param policies the policies to set
	 */
	public void setPolicies(String policies)
	{
		this.policies = StringUtils.trimToEmpty(policies);
	}

	/**
	 * @return the assessment
	 */
	public String getAssessment()
	{
		return StringUtils.trimToEmpty(assessment);
	}

	/**
	 * @param assessment the assessment to set
	 */
	public void setAssessment(String assessment)
	{
		this.assessment = StringUtils.trimToEmpty(assessment);
	}

	/**
	 * @return the fresh
	 */
	public String getFresh()
	{
		return StringUtils.trimToEmpty(fresh);
	}

	/**
	 * @param fresh the fresh to set
	 */
	public void setFresh(String fresh)
	{
		this.fresh = StringUtils.trimToEmpty(fresh);
	}

	/**
	 * @return the coastal
	 */
	public String getCoastal()
	{
		return StringUtils.trimToEmpty(coastal);
	}

	/**
	 * @param coastal the coastal to set
	 */
	public void setCoastal(String coastal)
	{
		this.coastal = StringUtils.trimToEmpty(coastal);
	}

	/**
	 * @return the marine
	 */
	public String getMarine()
	{
		return StringUtils.trimToEmpty(marine);
	}

	/**
	 * @param marine the marine to set
	 */
	public void setMarine(String marine)
	{
		this.marine = StringUtils.trimToEmpty(marine);
	}

	/**
	 * @return the central
	 */
	public String getCentral()
	{
		return StringUtils.trimToEmpty(central);
	}

	/**
	 * @param central the central to set
	 */
	public void setCentral(String central)
	{
		this.central = StringUtils.trimToEmpty(central);
	}

	/**
	 * @return the hawaii
	 */
	public String getHawaii()
	{
		return StringUtils.trimToEmpty(hawaii);
	}

	/**
	 * @param hawaii the hawaii to set
	 */
	public void setHawaii(String hawaii)
	{
		this.hawaii = StringUtils.trimToEmpty(hawaii);
		if (ParameterDAO.parse(hawaii)) setCentral("true");
	}

	/**
	 * @return the big
	 */
	public String getBig()
	{
		return StringUtils.trimToEmpty(big);
	}

	/**
	 * @param big the big to set
	 */
	public void setBig(String big)
	{
		this.big = StringUtils.trimToEmpty(big);
		if (ParameterDAO.parse(big)) setHawaii("true");
	}

	/**
	 * @return the maui
	 */
	public String getMaui()
	{
		return StringUtils.trimToEmpty(maui);
	}

	/**
	 * @param maui the maui to set
	 */
	public void setMaui(String maui)
	{
		this.maui = StringUtils.trimToEmpty(maui);
		if (ParameterDAO.parse(maui)) setHawaii("true");
	}

	/**
	 * @return the oahu
	 */
	public String getOahu()
	{
		return StringUtils.trimToEmpty(oahu);
	}

	/**
	 * @param oahu the oahu to set
	 */
	public void setOahu(String oahu)
	{
		this.oahu = StringUtils.trimToEmpty(oahu);
		if (ParameterDAO.parse(oahu)) setHawaii("true");
	}

	/**
	 * @return the kauai
	 */
	public String getKauai()
	{
		return StringUtils.trimToEmpty(kauai);
	}

	/**
	 * @param kauai the kauai to set
	 */
	public void setKauai(String kauai)
	{
		this.kauai = StringUtils.trimToEmpty(kauai);
		if (ParameterDAO.parse(kauai)) setHawaii("true");
	}

	/**
	 * @return the hother
	 */
	public String getHother()
	{
		return StringUtils.trimToEmpty(hother);
	}

	/**
	 * @param hother the hother to set
	 */
	public void setHother(String hother)
	{
		this.hother = hother;
		if (ParameterDAO.parse(hother)) setCentral("true");
		/*
		else if (ParameterDAO.parse(this.getCentral()))
		{
			// someone selecetd CNP - but not Hawaii
			if (! ParameterDAO.parse(this.getHawaii()))
			{
				// they must mean "other" 
				this.hother = "true";
			}
		}
		*/
		
	}

	/**
	 * @return the western
	 */
	public String getWestern()
	{
		return StringUtils.trimToEmpty(western);
	}

	/**
	 * @param western the western to set
	 */
	public void setWestern(String western)
	{
		this.western = StringUtils.trimToEmpty(western);
	}

	/**
	 * @return the guam
	 */
	public String getGuam()
	{
		return StringUtils.trimToEmpty(guam);
	}

	/**
	 * @param guam the guam to set
	 */
	public void setGuam(String guam)
	{
		this.guam = StringUtils.trimToEmpty(guam);
		if (ParameterDAO.parse(guam)) setWestern("true");
	}

	/**
	 * @return the cnmi
	 */
	public String getCnmi()
	{
		return StringUtils.trimToEmpty(cnmi);
	}

	/**
	 * @param cnmi the cnmi to set
	 */
	public void setCnmi(String cnmi)
	{
		this.cnmi = StringUtils.trimToEmpty(cnmi);
		if (ParameterDAO.parse(cnmi)) setWestern("true");
	}

	/**
	 * @return the fsm
	 */
	public String getFsm()
	{
		return StringUtils.trimToEmpty(fsm);
	}

	/**
	 * @param fsm the fsm to set
	 */
	public void setFsm(String fsm)
	{
		this.fsm = StringUtils.trimToEmpty(fsm);
		if (ParameterDAO.parse(fsm)) setWestern("true");
	}

	/**
	 * @return the rmi
	 */
	public String getRmi()
	{
		return StringUtils.trimToEmpty(rmi);
	}

	/**
	 * @param rmi the rmi to set
	 */
	public void setRmi(String rmi)
	{
		this.rmi = StringUtils.trimToEmpty(rmi);
		if (ParameterDAO.parse(rmi)) setWestern("true");
	}

	/**
	 * @return the palau
	 */
	public String getPalau()
	{
		return StringUtils.trimToEmpty(palau);
	}

	/**
	 * @param palau the palau to set
	 */
	public void setPalau(String palau)
	{
		this.palau = StringUtils.trimToEmpty(palau);
		if (ParameterDAO.parse(palau)) setWestern("true");
	}

	/**
	 * @return the wother
	 */
	public String getWother()
	{
		return StringUtils.trimToEmpty(wother);
	}

	/**
	 * @param wother the wother to set
	 */
	public void setWother(String wother)
	{
		this.wother = StringUtils.trimToEmpty(wother);
		if (ParameterDAO.parse(wother)) setWestern("true");
		/*
		else if (ParameterDAO.parse(this.getWestern()))
		{
			if (ParameterDAO.parse(this.getGuam()) ||
					ParameterDAO.parse(this.getCnmi()) ||
					ParameterDAO.parse(this.getFsm())  ||
					ParameterDAO.parse(this.getRmi())  ||
					ParameterDAO.parse(this.getPalau()))
			{
				// cool...one of them was also checked
			}
			else
			{
				// can only mean this...
				this.wother = "true";
			}
			
		}
		*/

		
	}

	/**
	 * @return the south
	 */
	public String getSouth()
	{
		return StringUtils.trimToEmpty(south);
	}

	/**
	 * @param south the south to set
	 */
	public void setSouth(String south)
	{
		this.south = StringUtils.trimToEmpty(south);
	}

	/**
	 * @return the asam
	 */
	public String getAsam()
	{
		return StringUtils.trimToEmpty(asam);
	}

	/**
	 * @param asam the asam to set
	 */
	public void setAsam(String asam)
	{
		this.asam = StringUtils.trimToEmpty(asam);
		if (ParameterDAO.parse(asam)) setSouth("true");
	}

	/**
	 * @return the samoa
	 */
	public String getSamoa()
	{
		return StringUtils.trimToEmpty(samoa);
	}

	/**
	 * @param samoa the samoa to set
	 */
	public void setSamoa(String samoa)
	{
		this.samoa = StringUtils.trimToEmpty(samoa);
		if (ParameterDAO.parse(samoa)) setSouth("true");
	}

	/**
	 * @return the tonga
	 */
	public String getTonga()
	{
		return StringUtils.trimToEmpty(tonga);
	}

	/**
	 * @param tonga the tonga to set
	 */
	public void setTonga(String tonga)
	{
		this.tonga = StringUtils.trimToEmpty(tonga);
		if (ParameterDAO.parse(tonga)) setSouth("true");
	}

	/**
	 * @return the fiji
	 */
	public String getFiji()
	{
		return StringUtils.trimToEmpty(fiji);
	}

	/**
	 * @param fiji the fiji to set
	 */
	public void setFiji(String fiji)
	{
		this.fiji = StringUtils.trimToEmpty(fiji);
		if (ParameterDAO.parse(fiji)) setSouth("true");
	}

	/**
	 * @return the oz
	 */
	public String getOz()
	{
		return StringUtils.trimToEmpty(oz);
	}

	/**
	 * @param oz the oz to set
	 */
	public void setOz(String oz)
	{
		this.oz = StringUtils.trimToEmpty(oz);
		if (ParameterDAO.parse(oz)) setSouth("true");
	}

	/**
	 * @return the nz
	 */
	public String getNz()
	{
		return StringUtils.trimToEmpty(nz);
	}

	/**
	 * @param nz the nz to set
	 */
	public void setNz(String nz)
	{
		this.nz = nz;
		if (ParameterDAO.parse(nz)) setSouth("true");
	}

	/**
	 * @return the fp
	 */
	public String getFp()
	{
		return StringUtils.trimToEmpty(fp);
	}

	/**
	 * @param fp the fp to set
	 */
	public void setFp(String fp)
	{
		this.fp = StringUtils.trimToEmpty(fp);
		if (ParameterDAO.parse(fp)) setSouth("true");
	}

	/**
	 * @return the sother
	 */
	public String getSother()
	{
		return StringUtils.trimToEmpty(sother);
	}

	/**
	 * @param sother the sother to set
	 */
	public void setSother(String sother)
	{
		this.sother = StringUtils.trimToEmpty(sother);
		if (ParameterDAO.parse(sother)) setSouth("true");
		/*
		else if (ParameterDAO.parse(this.getSouth()))
		{
			if (ParameterDAO.parse(this.getAsam())   ||
					ParameterDAO.parse(this.getSamoa())  ||
					ParameterDAO.parse(this.getTonga())  ||
					ParameterDAO.parse(this.getFiji())   ||
					ParameterDAO.parse(this.getOz())     ||
					ParameterDAO.parse(this.getNz())     ||
					ParameterDAO.parse(this.getFp()) )
			{
				// cool...this makes sense
			}
			else
			{
		    this.sother = "true";		
			}
			
		}
		*/
		
		
	}

	/**
	 * @return the otherregions
	 */
	public String getOtherregions()
	{
		return StringUtils.trimToEmpty(otherregions);
	}


	/**
	 * @param otherregions the otherregions to set
	 */
	public void setOtherregions(String otherregions)
	{
		this.otherregions = StringUtils.trimToEmpty(otherregions);
	}


	public String getEcvAtmospheric() 
	{
		return StringUtils.trimToEmpty(ecvAtmospheric);
	}


	public void setEcvAtmospheric(String ecvAtmospheric) {
		this.ecvAtmospheric = StringUtils.trimToEmpty(ecvAtmospheric);
	}


	public String getEcvOceanic() 
	{
		return StringUtils.trimToEmpty(ecvOceanic);
	}


	public void setEcvOceanic(String ecvOceanic) 
	{
		this.ecvOceanic = StringUtils.trimToEmpty(ecvOceanic);
	}


	public String getEcvTerrestrial() 
	{
		return StringUtils.trimToEmpty(ecvTerrestrial);
	}


	public void setEcvTerrestrial(String ecvTerrestrial) 
	{
		this.ecvTerrestrial = StringUtils.trimToEmpty(ecvTerrestrial);
	}


	public String getAnyPhysical() 
	{
		return StringUtils.trimToEmpty(this.anyPhysical);
	}


	public void setAnyPhysical(String ap) 
	{
		this.anyPhysical = StringUtils.trimToEmpty(ap);
	}

	public String getPhyInsitu() 
	{
		return StringUtils.trimToEmpty(phyInsitu);
	}


	public void setPhyInsitu(String phyInsitu) 
	{
		this.phyInsitu = StringUtils.trimToEmpty(phyInsitu);
		if (ParameterDAO.parse(phyInsitu)) setAnyPhysical("true");
	}


	public String getPhySatellite() 
	{
		return StringUtils.trimToEmpty(phySatellite);
	}


	public void setPhySatellite(String satellite) 
	{
		this.phySatellite = StringUtils.trimToEmpty(satellite);
		if (ParameterDAO.parse(satellite)) setAnyPhysical("true");
	}


	public String getPhyModel() 
	{
		return StringUtils.trimToEmpty(phyModel);
	}


	public void setPhyModel(String model) 
	{
		this.phyModel = StringUtils.trimToEmpty(model);
		if (ParameterDAO.parse(model)) setAnyPhysical("true");
	}


	public String getPhyReanalysis() 
	{
		return StringUtils.trimToEmpty(phyReanalysis);
	}


	public void setPhyReanalysis(String reanal) 
	{
		this.phyReanalysis = StringUtils.trimToEmpty(reanal);
		if (ParameterDAO.parse(reanal)) setAnyPhysical("true");
	}

	public String getPhyBathymetry() 
	{
		return StringUtils.trimToEmpty(this.phyBathymetry);
	}


	public void setPhyBathymetry(String bathymetry) 
	{
		this.phyBathymetry = StringUtils.trimToEmpty(bathymetry);
		if (ParameterDAO.parse(bathymetry)) setAnyPhysical("true");
	}

	public String getPhyImagery() 
	{
		return StringUtils.trimToEmpty(phyImagery);
	}


	public void setPhyImagery(String imagery) 
	{
		this.phyImagery = StringUtils.trimToEmpty(imagery);
		if (ParameterDAO.parse(imagery)) setAnyPhysical("true");
	}


	public String getProdHindcasts() 
	{
		return StringUtils.trimToEmpty(prodHindcasts);
	}


	public void setProdHindcasts(String prodHindcasts) 
	{
		this.prodHindcasts = StringUtils.trimToEmpty(prodHindcasts);
	}


	public String getProdOutlooks() 
	{
		return StringUtils.trimToEmpty(prodOutlooks);
	}


	public void setProdOutlooks(String prodOutlooks) 
	{
		this.prodOutlooks = StringUtils.trimToEmpty(prodOutlooks);
	}


	public String getProdProjections() 
	{
		return StringUtils.trimToEmpty(prodProjections);
	}


	public void setProdProjections(String prodProjections) 
	{
		this.prodProjections = StringUtils.trimToEmpty(prodProjections);
	}


	public String getProdGuidance() 
	{
		return StringUtils.trimToEmpty(prodGuidance);
	}


	public void setProdGuidance(String prodGuidance) 
	{
		this.prodGuidance = StringUtils.trimToEmpty(prodGuidance);
	}


	public String getProdApplications() 
	{
		return StringUtils.trimToEmpty(prodApplications);
	}


	public void setProdApplications(String prodApplications) 
	{
		this.prodApplications = StringUtils.trimToEmpty(prodApplications);
	}

	public String getAnyNonPhysical() 
	{
		return StringUtils.trimToEmpty(anyNonPhysical);
	}


	public void setAnyNonPhysical(String anyNon) 
	{
		this.anyNonPhysical = StringUtils.trimToEmpty(anyNon);
	}

	public String getNonPhysical() 
	{
		return StringUtils.trimToEmpty(nonPhysical);
	}


	public void setNonPhysical(String n) 
	{
		this.nonPhysical = StringUtils.trimToEmpty(n);
		if (ParameterDAO.parse(n)) setAnyNonPhysical("true");
	}


	public String getNonPhysicalEnvironmental() 
	{
		return StringUtils.trimToEmpty(nonPhysicalEnvironmental);
	}


	public void setNonPhysicalEnvironmental(String npe) 
	{
		this.nonPhysicalEnvironmental = StringUtils.trimToEmpty(npe);
		if (ParameterDAO.parse(npe)) setAnyNonPhysical("true");
}


	public String getNonPhysicalSocioCultural() {
		return StringUtils.trimToEmpty(nonPhysicalSocioCultural);
	}


	public void setNonPhysicalSocioCultural(String npc) 
	{
		this.nonPhysicalSocioCultural = StringUtils.trimToEmpty(npc);
		if (ParameterDAO.parse(npc)) setAnyNonPhysical("true");
	}


	public String getNonPhysicalEconomic() {
		return StringUtils.trimToEmpty(nonPhysicalEconomic);
	}


	public void setNonPhysicalEconomic(String npe) 
	{
		this.nonPhysicalEconomic = StringUtils.trimToEmpty(npe);
		if (ParameterDAO.parse(npe)) setAnyNonPhysical("true");
}


	public int getONGOING() {
		return ONGOING;
	}


	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return StringUtils.trimToEmpty(this.status);
	}
	
	/**
	 * @return the status
	 */
	public String getStatusText()
	{
		int code = this.getStatusCode();
		
		if (code == this.ONGOING)
		{
			return "on-going";
		}
		else if (code == this.PLANNED)
		{
			return "planned";
		}
		else if (code == this.PROPOSED)
		{
			return "proposed";
		}
		else if (code == this.COMPLETED)
		{
			return "completed";
		}
		else
		{
			return "not available";
		}
	}

	/**
	 * returns the integer code of status
	 * @return the status
	 */
	public int getStatusCode()
	{
		if (NumberUtils.toInt(this.status) == this.ONGOING)
		{
			return this.ONGOING;
		}
		else if (NumberUtils.toInt(this.status) == this.PLANNED)
		{
			return this.PLANNED;
		}
		else if (NumberUtils.toInt(this.status) == this.PROPOSED)
		{
			return this.PROPOSED;
		}
		else if (NumberUtils.toInt(this.status) == this.COMPLETED)
		{
			return this.COMPLETED;
		}
		else
		{
			return this.UNKNOWN;
		}
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = StringUtils.trimToEmpty(status);
	}

	/**
	 * @return the leadagencies
	 */
	public String[] getLeadagencies()
	{
		return leadagencies;
	}

	/**
	 * @param leadagencies the leadagencies to set
	 */
	public void setLeadagencies(String[] leadagencies)
	{
		this.leadagencies = leadagencies;
		// avoid null pointer down the line
		if (leadagencies == null || leadagencies.length == 0)
		{
      String [] zeroStrArray = new String [0];
      this.leadagencies = zeroStrArray;
      System.out.println("WARNING: No lead agency selected for project " + projectname);
		}
	}

	/**
	 * @return the partneragencies
	 */
	public String[] getPartneragencies()
	{
		return partneragencies;
	}

	/**
	 * @param partneragencies the partneragencies to set
	 */
	public void setPartneragencies(String[] partneragencies)
	{
		this.partneragencies = partneragencies;
		// avoid null pointer down the line
		if (partneragencies == null || partneragencies.length == 0)
		{
      String [] zeroStrArray = new String [0];
      this.partneragencies = zeroStrArray;
		}
	}

	/**
	 * @return the projectdescription
	 */
	public String getProjectdescription()
	{
		return StringUtils.trimToEmpty(projectdescription);
	}

	/**
	 * @param projectdescription the projectdescription to set
	 */
	public void setProjectdescription(String desc)
	{
		this.projectdescription = StringUtils.left(StringUtils.trimToEmpty(desc), this.MAX_DESCRIPTION_LENGTH);
	}

	
	/**
	 * @return the contactName
	 */
	public String[] getContactName()
	{
		return contactName;
	}



	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String[] contacts)
	{
		this.contactName = contacts;
		// avoid null pointer down the line
		if (contacts == null || contacts.length == 0)
		{
          String [] zeroStrArray = new String [0];
          this.contactName  = zeroStrArray;
		}
	}



	/**
	 * @return the emailsAddress
	 */
	public String[] getEmailsAddress()
	{
		return emailsAddress;
	}



	/**
	 * @param emailsAddress the emailsAddress to set
	 */
	public void setEmailsAddress(String[] emails)
	{
		this.emailsAddress = emails;
		// avoid null pointer down the line
		if (emails == null || emails.length == 0)
		{
          String [] zeroStrArray = new String [0];
          this.emailsAddress  = zeroStrArray;
		}
	}



	/**
	 * @return the contactList
	 */
	public List<Contact> getContactList()
	{
		return contactList;
	}



	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(List<Contact> contactList)
	{
		this.contactList = contactList;
		
		String [] cs = new String [contactList.size()];
		String [] es = new String [contactList.size()];
		
		for (int i = 0; i < contactList.size(); i++)
		{
			cs[i] = contactList.get(i).getName();
			es[i] = contactList.get(i).getEmail();
		}
		
		this.contactName = cs; this.emailsAddress = es;
	}

	/**
	 * set the list using internal string list
	 */
	public void setContactList()
	{
		Vector<Contact>  cs = new Vector<Contact>();
		for (int i = 0; i < this.getContactName().length; i++)
		{
			if (StringUtils.isNotBlank(this.contactName[i]))
			{
			  Contact c = new Contact();
			  c.setName(this.contactName[i]);
			  c.setEmail(this.emailsAddress[i]);
			  cs.add(c);
			}
		}
		this.contactList = cs;
	}



	/**
	 * @return the worksheetfilename
	 */
	public String getWorksheetfilename()
	{
		return StringUtils.trimToEmpty(worksheetfilename);
	}

	/**
	 * @param worksheetfilename the worksheetfilename to set
	 */
	public void setWorksheetfilename(String filename)
	{
		this.worksheetfilename = StringUtils.left(StringUtils.trimToEmpty(filename), this.MAX_FILENAME_LENGTH);
	}
	
	/**
	 * generates link to the worksheet if uploaded
	 * baseurl is communicated to this as "http://www.noaaideacenter.org/paworksheets/"
	 * @return
	 */
	public String getWorksheetURL(String baseurl)
	{
	  if (StringUtils.isBlank(this.getWorksheetfilename()))
	  {
		  if (this.isDap())
		  {
			  return "(<a href=\"fileUpload.jsp?dap=1&id=" + this.getProjectnumber() + "\">More...</a>)";
		  }
		  else
		  {
		    return "(<a href=\"fileUpload.jsp?id=" + this.getProjectnumber() + "\">More...</a>)";
		  }
	  }
	  else
	  {
		  //try
		  //{
	      //  return "(<a href=\"worksheet?file=" + java.net.URLEncoder.encode(this.getWorksheetfilename(), "UTF-8") + "&id=" + this.getProjectnumber() + "\" target=\"_blank\">More...</a>)";
		  //}
		  //catch (Exception e)
		  //{
			// should never come here
		    return "(<a href=\"" + baseurl  + this.getWorksheetfilename() + "\" target=\"_blank\">More...</a>)"; 
		 // }
	  }
	}

	/**
	 * @return the projectnumber
	 */
	public int getProjectnumber()
	{
		return projectnumber;
	}

	/**
	 * @param projectnumber the projectnumber to set
	 */
	public void setProjectnumber(int projectnumber)
	{
		this.projectnumber = projectnumber;
	}

	/**
	 * @param projectnumber the projectnumber to set
	 */
	public void setProjectnumber(String projectnumber)
	{
		this.projectnumber = NumberUtils.toInt(projectnumber);
	}


	/**
	 * @return the code
	 */
	public int getCode()
	{
		return code;
	}



	/**
	 * @param code the code to set
	 */
	public void setCode(int code)
	{
		this.code = code;
	}


	/**
	 * @param projectnumber the projectnumber to set
	 */
	public void setCode(String codeStr)
	{
		this.setCode(NumberUtils.toInt(codeStr));
	}


	public String getTag()
	{
		return StringUtils.trimToEmpty(tag);
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String txtlabel)
	{
		this.tag = StringUtils.left(StringUtils.trimToEmpty(txtlabel), this.MAX_TAG_LENGTH);
	}



	/**
	 * @return the deleted
	 */
	public String getDeleted()
	{
		return StringUtils.trimToEmpty(deleted);
	}



	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(String deleted)
	{
		this.deleted = StringUtils.trimToEmpty(deleted);
	}


	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deletedFlag)
	{
		this.deleted = deletedFlag + ""; 
	}



	/**
	 * @param deleted the deleted to set
	 */
	public boolean isDeleted()
	{
		return ParameterDAO.parse(this.getDeleted()); 
	}
	
	
	
	
	public String getUrl() {
		return StringUtils.trimToEmpty(url);
	}


	public void setUrl(String url) {
		this.url = StringUtils.trimToEmpty(url);
	}


	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		
		sb.append("Project Number " + this.getProjectnumber() + ",");

		if (StringUtils.isNotBlank(this.getTag()))
		{
			sb.append(" Tag = " + StringUtils.trimToEmpty(this.getTag()) + ",");
		}

		if (StringUtils.isNotBlank(this.getProjectname()))
		{
			sb.append(" Name = " + StringUtils.trimToEmpty(this.getProjectname()) + ",");
		}
		
		if (StringUtils.isNotBlank(this.getProjectdescription()))
		{
   		   //sb.append(" Description = " + StringUtils.trimToEmpty(this.getProjectdescription()) + ",");
		}
		
		// status 
		sb.append(" Status = " + this.getStatus() +  ",");
		
		// list capabilities
		sb.append(" Capability Area = "); sb.append(this.getCapabilityAreas());
		
		// focus areas
		sb.append(" Focus Area = "); sb.append(this.getFocusAreas());

		// regions
		sb.append(" Region/Locale = "); sb.append(this.getRegionLocale());

		// agencies
		sb.append(" Lead Agencies = "); sb.append(this.getLeadAgenciesAsString(""));

		// contacts
		sb.append(" Contact  = "); sb.append(this.getContacts(""));
		
		return sb.toString();
	}
	
	public String toFilterString()
	{
		StringBuffer sb = new StringBuffer();
		
		if (this.getCode() > 0) 
		{
			sb.append(" Project Number = " + this.getCode() + ",");
		}

		if (StringUtils.isNotBlank(this.getTag())) 
		{
			sb.append(" Project Acronym= " + StringUtils.trimToEmpty(this.getTag()) + ",");
		}
		
		if (StringUtils.isNotBlank(this.getProjectname()))
		{
			sb.append(" Name Filter = " + StringUtils.trimToEmpty(this.getProjectname()) + ",");
		}
		
		if (StringUtils.isNotBlank(this.getProjectdescription()))
		{
   		   sb.append(" Description Filter = " + StringUtils.trimToEmpty(this.getProjectdescription()) + ",");
		}
		
		// status 
		if (this.getStatusCode() != this.UNKNOWN)
		{
		  sb.append(" Status Filter = " + this.getStatus() +  ",");
		} 
		
		// list capabilities
		if (!StringUtils.equals(this.getCapabilityAreas(), "None"))
		{
		  sb.append(" Capability Area Filter(s) = "); sb.append(this.getCapabilityAreas());
		}
		
		// focus areas
		if (!StringUtils.equals(this.getFocusAreas(), "None"))
		{
	    	sb.append(" Focus Area Filter(s) = "); sb.append(this.getFocusAreas());
		}

  		// regions
		if (!StringUtils.equals(this.getRegionLocale(), "None"))
		{
		  sb.append(" Region/Locale Filter(s) = "); sb.append(this.getRegionLocale());
		}

		// Leade agencies
		if (!StringUtils.equals(this.getLeadAgenciesAsSimpleString(), "None"))
		{
		  sb.append(" Lead Agency Filter(s)= "); sb.append(this.getLeadAgenciesAsSimpleString());
		}

		// Partner agencies
		if (!StringUtils.equals(this.getPartnerAgenciesAsSimpleString(), "None"))
		{
		  sb.append(" Partner Agency Filter(s)= "); sb.append(this.getPartnerAgenciesAsSimpleString());
		}

		// contacts
		if (!StringUtils.equals(this.getContactsWthoutDecorations(), "None"))
		{
		  sb.append(" Contact Filter(s) = "); sb.append(this.getContactsWthoutDecorations());
		}
		
		// search string
		if (! StringUtils.isBlank(this.getSearchString()))
		{
			sb.append(" Search String Filter = " + this.getSearchString() );
		}
		
		if (StringUtils.isBlank(sb.toString())) sb.append("EMPTY");
		return sb.toString();
	}
	
	
	public String getContact(int index)
	{
		String [] contacts = this.getContactName();
		if (contacts == null)
		{
			return "";
		}
		else if (contacts.length < index)
		{
			return "";
		}
		else
		{
			return StringUtils.trimToEmpty(contacts[index-1]);
		}
	}

	public String getEmail(int index)
	{
		String [] emails = this.getEmailsAddress();
		if (emails == null)
		{
			return "";
		}
		else if (emails.length < index)
		{
			return "";
		}
		else
		{
			return StringUtils.trimToEmpty(emails[index-1]);
		}
	}
	
	public String getContacts(String str)
	{
		
		StringBuffer sb = new StringBuffer();
		
		if (this.getContactList() == null)
		{
		}
		else
		{
  		  for (int i = 0; i < this.getContactList().size(); i++)
  		  {
  			sb.append("[" + this.getContactList().get(i).toEmailLinkString(str) + "]<br />");
  		  }
		}
		
	  if (sb.length() == 0) return "None";
		return sb.toString();
	}
	
	public String getContactsWthoutDecorations()
	{
		StringBuffer sb = new StringBuffer();
		
		if (this.getContactList() == null)
		{
		}
		else if (this.getContactList().size() == 0)
		{
		}
		else
		{
  		  for (int i = 0; i < this.getContactList().size(); i++)
  		  {
  			if (i > 0) sb.append(",");
  			sb.append("[" + this.getContactList().get(i).toString() + "]");
  		  }
		}
		
	  if (sb.length() == 0) return "None";
		return sb.toString();
	}
	
	public String getLeadAgenciesAsString(String str)
	{
		return this.getList(this.getLeadList(), str);
	}

	public String getPartnerAgenciesAsString(String srch)
	{
		return this.getList(this.getPartnerList(), srch);
	}

	public String getLeadAgenciesAsSimpleString()
	{
		if (this.getLeadList() == null || this.getLeadList().size() == 0 )
		{
		  // try just the string arrays
		  StringBuffer sb = new StringBuffer();
		  String [] agencies =  this.getLeadagencies();
		  if (agencies.length > 0)
		  {
				 sb.append("[");
			 for (int i = 0; i < agencies.length; i++)
			 {
				 if (i > 0) sb.append(", ");
				 sb.append(agencies[i]);
			 }
			 sb.append("]");
		  }
		  if (StringUtils.isBlank(sb.toString())) return "None"; 
		  return sb.toString();
		}
		else
		{
		  return this.getAgenciesAsSimpleString(this.getLeadList());
		}
	}

	public String getPartnerAgenciesAsSimpleString()
	{
		if (this.getPartnerList() == null || this.getPartnerList().size() == 0 )
		{
		  // try just the string arrays
		  StringBuffer sb = new StringBuffer();
		  String [] agencies =  this.getPartneragencies();
		  if (agencies.length > 0)
		  {
				 sb.append("[");
			 for (int i = 0; i < agencies.length; i++)
			 {
				 if (i > 0) sb.append(", ");
				 sb.append(agencies[i]);
			 }
			 sb.append("]");
		  }
		  if (StringUtils.isBlank(sb.toString())) return "None"; 
		  return sb.toString();
		}
		else
		{
		  return this.getAgenciesAsSimpleString(this.getPartnerList());
		}
	}
	
	public String getAgenciesAsSimpleString(List<Agency> list)
	{
		StringBuffer sb = new StringBuffer();
		
		if (list == null)
		{
		}
		else if (list.size() == 0)
		{
		}
		else
		{
  		  for (int i = 0; i < list.size(); i++)
  		  {
  			if (i > 0) sb.append(", ");
  			sb.append("[" + list.get(i).getAcronym() + "]");
  		  }
		}
		
	  if (sb.length() == 0) return "None";
		return sb.toString();
	}

	public String getList(List<Agency> list, String srchStr)
	{
		StringBuffer sb = new StringBuffer();
		
		if (list == null)
		{
		}
		else
		{
  		  for (int i = 0; i < list.size(); i++)
  		  {
  			sb.append("[" + list.get(i).toGoogleString(srchStr) + "]<br />");
  		  }
		}
		
	  if (sb.length() == 0) return "None";
		return sb.toString();
	}
	
	
	public String getRegionLocale()
	{
		StringBuffer sb = new StringBuffer();
		
		if (ParameterDAO.parse(this.getCentral()))
		{
			sb.append("[Central North Pacific (CNP) ");
			sb.append(getCentralPacificChoices());
			sb.append("]");
		}
		if (ParameterDAO.parse(this.getWestern()))
		{
			sb.append("[Western North Pacific (WNP) ");
			sb.append(getWesternPacificChoices());
			sb.append("]");
		}
		if (ParameterDAO.parse(this.getSouth()))
		{
			sb.append("[South Pacific (SP) ");
			sb.append(getSouthPacificChoices());
			sb.append("]");
		}
		if (ParameterDAO.parse(this.getOtherregions()))
		{
			sb.append("[Other Region (Outside Pacific)]");
		}
		
		if (sb.length() == 0) return "None";	
		return sb.toString();
	}
	
	public String getCentralPacificChoices()
	{
		StringBuffer sb = new StringBuffer();
		int count = 0;
		if (ParameterDAO.parse(this.getHawaii()))
		{
			count++;
			sb.append(" - State of Hawai`i");
			sb.append(getHawaiiChoices());
			sb.append("");
		}		
		if (ParameterDAO.parse(this.getHother()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - ");
			sb.append("Other Central North Pacific");
		}		
		return sb.toString();
	}
	
	public String getHawaiiChoices()
	{
		int count = 0;
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getBig()))
		{
			count++;
			sb.append(":  Island of Hawai`i");
		}		
		if (ParameterDAO.parse(this.getMaui()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Maui");
			count++;
		}		
		if (ParameterDAO.parse(this.getOahu()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Oahu");
			count++;
		}		
		if (ParameterDAO.parse(this.getKauai()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Kauai");
		}		
		return sb.toString();
	}

	public String getWesternPacificChoices()
	{
		int count = 0;
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getGuam()))
		{
			count++;
			sb.append(" - Guam");
		}		
		if (ParameterDAO.parse(this.getCnmi()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("CNMI");
		}		
		if (ParameterDAO.parse(this.getFsm()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("FSM");
		}		
		if (ParameterDAO.parse(this.getRmi()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("RMI");
		}		
		if (ParameterDAO.parse(this.getPalau()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("Palau");
		}		
		if (ParameterDAO.parse(this.getWother()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("Other Western North Pacific");
		}		
		return sb.toString();
	}

	public String getSouthPacificChoices()
	{
		int count = 0;
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getAsam()))
		{
			count++;
			sb.append(" - American S&#227;moa");
		}		
		if (ParameterDAO.parse(this.getSamoa()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("S&#227;moa");
		}		
		if (ParameterDAO.parse(this.getTonga()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("Tonga");
		}		
		if (ParameterDAO.parse(this.getFiji()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("Fiji");
		}		
		if (ParameterDAO.parse(this.getOz()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("Australia");
		}		
		if (ParameterDAO.parse(this.getNz()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("New Zealand");
		}		
		if (ParameterDAO.parse(this.getFp()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("French Polynesia");
		}		
		if (ParameterDAO.parse(this.getSother()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(" - "); count++;
			sb.append("Other South Pacific");
		}		
		return sb.toString();
	}
	
	
	public String getFocusAreas()
	{
		StringBuffer sb = new StringBuffer();
		
		if (ParameterDAO.parse(this.getFresh()))
		{
			sb.append("[Fresh Water Resources and Drought]");
		}
		if (ParameterDAO.parse(this.getCoastal()))
		{
			sb.append("[Coastal Inundation/SLR. Extreme Weather, and Community Resilience]");
		}
		if (ParameterDAO.parse(this.getMarine()))
		{
			sb.append("[Marine and Terrestrial Ecosystems]");
		}
		if (sb.length() == 0) return "None";	
		return sb.toString();
	}

	public String getPhysicalChoices()
	{
		int count = 0;
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getPhyInsitu()))
		{
			count++;
			sb.append(":  In-situ Observations");
		}		
		if (ParameterDAO.parse(this.getPhySatellite()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Satellite-Remote Observations ");
			count++;
		}		
		if (ParameterDAO.parse(this.getPhyModel()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Model Results");
			count++;
		}		
		if (ParameterDAO.parse(this.getPhyReanalysis()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Reanalysis Products");
		}		
		if (ParameterDAO.parse(this.getPhyBathymetry()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Bathymetry &amp; Topography");
		}		
		if (ParameterDAO.parse(this.getPhyImagery()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Imagery");
		}		
		return sb.toString();
	}
	
	public String getNonPhysicalChoices()
	{
		int count = 0;
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getNonPhysicalEnvironmental()))
		{
			count++;
			sb.append(":  Environmental");
		}		
		if (ParameterDAO.parse(this.getNonPhysicalSocioCultural()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Socio-Cultural");
			count++;
		}		
		if (ParameterDAO.parse(this.getNonPhysicalEconomic()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Economic");
			count++;
		}		
		if (ParameterDAO.parse(this.getNonPhysical()))
		{
			if (count > 0) sb.append(", ");
			else sb.append(":  ");
			sb.append("Other");
		}		
		return sb.toString();
	}

	
	public boolean ifSectors()
	{
		if (ParameterDAO.parse(this.getPhs()) || ParameterDAO.parse(this.getFwr()) || 
				ParameterDAO.parse(this.getEne()) || ParameterDAO.parse(this.getTcc()) || 
				ParameterDAO.parse(this.getCpd()) || ParameterDAO.parse(this.getScr()) || 
				ParameterDAO.parse(this.getAfi()) || ParameterDAO.parse(this.getRat()) || 
				ParameterDAO.parse(this.getEco()) || ParameterDAO.parse(this.getOth()))
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	
	public String getCapabilityAreas()
	{
		StringBuffer sb = new StringBuffer();
		
		if (ParameterDAO.parse(this.getTraining()))
		{
			sb.append("[Training and Capacity Building]");
		}

		if (ParameterDAO.parse(this.getEducation()))
		{
			sb.append("[Education]");
		}
		
		if (ParameterDAO.parse(this.getOutreach()))
		{
			sb.append("[Outreach]");
		}
		
		if (ParameterDAO.parse(this.getObserving()))
		{
			sb.append("[Observing Systems and Data Stewardship]");
		}
		
		if (ParameterDAO.parse(this.getDataservices()))
		{
			sb.append("[Data Services]");
		}
	   
		if (ParameterDAO.parse(this.getVariability()))
		{
			sb.append("[Understanding Climate Variability and Change ");
            sb.append(this.getVariabilities());
            sb.append("]");
		} 
		
		if (ParameterDAO.parse(this.getEffect()))
		{
			sb.append("[Understanding Climate Impacts and Informing Adaptation ");
			sb.append(this.getImpactsAdaptations());
			sb.append("[");
		}

		
		// Guidance and Apps Choices, if applicable 
		sb.append(this.getGuidanceChoices());
		sb.append(this.getAppsChoices());
		
		if (ParameterDAO.parse(this.getPolicies()))
		{
			sb.append("[Policies and Legislation]");
		}
		
		if (ParameterDAO.parse(this.getAssessment()))
		{
			sb.append("[Assessment and Evaluation]");
		}
		
    if (sb.length() == 0) return "None";
		return sb.toString();
		
	}
	
	public String getGuidanceChoices()
	{
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getGuidance()))
		{
			sb.append("[Guidance, including Best Practices ");
			
			if (ParameterDAO.parse(this.getGvariability()))
			{
			  sb.append("[Climate Variability and Change]");	
			}

			if (ParameterDAO.parse(this.getGeffects()))
			{
			  sb.append("[Climate Impacts and Informing Adaptation]");	
			}
		}
    if (sb.length() > 0) sb.append("]");
		return sb.toString();
	}
	
	public String getAppsChoices()
	{
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getGuidance()))
		{
			sb.append("[Applications, including Decision Support Tools ");
			
			if (ParameterDAO.parse(this.getGvariability()))
			{
			  sb.append("[Climate Variability and Change]");	
			}

			if (ParameterDAO.parse(this.getGeffects()))
			{
			  sb.append("[Climate Impacts and Informing Adaptation]");	
			}
		}
    if (sb.length() > 0) sb.append("]");
		return sb.toString();
	}

	
	public String getVariabilities()
	{
		StringBuffer sb = new StringBuffer();
		
		
		if (ParameterDAO.parse(this.getOperational()))
		{
			sb.append("[Operational Products and Services (including DST)]");
		}

		if (ParameterDAO.parse(this.getResearch()))
		{
			sb.append("[Research/Development]");
		}
		
		if (ParameterDAO.parse(this.getVhistorical()))
		{
			sb.append("[Historical Observations (hindcasts/climatologies)]");
		}
		
		if (ParameterDAO.parse(this.getVprojections()))
		{
			sb.append("[Projections (modeling and downscaling)]");
		}
		
		// parameters, if any
		sb.append(this.getParameters());

		// timeframes, if any
		sb.append(this.getTimeframes());

		return sb.toString();
	}
	
	public String getTimeframes()
	{
		StringBuffer sb = new StringBuffer();
		if (ParameterDAO.parse(this.getSeasonal()) || 
				ParameterDAO.parse(this.getAnnual())   ||
				ParameterDAO.parse(this.getDecadal()) )
		{
			sb.append("[Timeframe(s): ");
		  if (ParameterDAO.parse(this.getSeasonal()))
		  {
		    sb.append("[Seasonal (outlook)]"); 	
		  }
		  if (ParameterDAO.parse(this.getAnnual()))
		  {
		    sb.append("[intra-annual to decadal]"); 	
		  }
		  if (ParameterDAO.parse(this.getDecadal()))
		  {
		    sb.append("[multi-decadal (scenarios)]"); 	
		  }
		}
    if (sb.length() > 0) sb.append("]");
		return sb.toString();
	}
	
	public String getParameters()
	{
		StringBuffer sb = new StringBuffer();
		
		
		if (ParameterDAO.parse(this.getAsurface()) || 
				ParameterDAO.parse(this.getUpperair()) ||
				ParameterDAO.parse(this.getComposition()))
		{
		  sb.append("[Atmospheric Parameters: ");
		  
		  if (ParameterDAO.parse(this.getAsurface()))
		  {
		    sb.append("[Surface (e.g. temp, precip, wind)]"); 	
		  }
		  if (ParameterDAO.parse(this.getUpperair()))
		  {
		    sb.append("[Upper-Air]"); 	
		  }
		  if (ParameterDAO.parse(this.getComposition()))
		  {
		    sb.append("[Composition]"); 	
		  }
			sb.append("]");
		}  			

		if (ParameterDAO.parse(this.getOsurface()) || 
				ParameterDAO.parse(this.getSubsurface()))
		{
		  sb.append("[Oceanic Parameters: ");
			
		  if (ParameterDAO.parse(this.getOsurface()))
		  {
		    sb.append("[Surface (e.g. SST, SSH, salinity, ocean color)]"); 	
		  }
		  if (ParameterDAO.parse(this.getSubsurface()))
		  {
		    sb.append("[Sub-surface (e.g. temp, salinity, nutrients, Carbon, phytoplankton)]"); 	
		  }
		  
			sb.append("]");
		}
		
		if (ParameterDAO.parse(this.getTerrestrial()))
		{
			sb.append("[Terrestrial Parameters (e.g. surface water, glaciers and ice caps, land cover, biomass)]");
		}
		return sb.toString();
	}
	
	
	public String getImpactsAdaptations()
	{
		StringBuffer sb = new StringBuffer();
		
		if (ParameterDAO.parse(this.getImpacts()))
		{
			sb.append("[Climate Impacts]");
		}

		if (ParameterDAO.parse(this.getEhistorical()))
		{
			sb.append("[Historical Observations]");
		}
		
		if (ParameterDAO.parse(this.getEprojections()))
		{
			sb.append("[Projections]");
		}

		if (ParameterDAO.parse(this.getAdaptation()))
		{
			sb.append("[Climate Adaptation]");
		}
		
		if (ifSectors())
		{
			sb.append("[Sectors: ");
			sb.append(this.getSectors());
			sb.append("]");
		}

		return sb.toString();
	}
	
	public String getSectors()
	{
    StringBuffer sb = new StringBuffer();
    
		if (ParameterDAO.parse(this.getPhs()))
		{
			sb.append("[Public Health and Safety]");
		}
		if (ParameterDAO.parse(this.getFwr()))
		{
			sb.append("[Fresh Water Resources]");
		}
		if (ParameterDAO.parse(this.getEne()))
		{
			sb.append("[Energy]");
		}
		if (ParameterDAO.parse(this.getTcc()))
		{
			sb.append("[Transportation/Communication and Commerce]");
		}
		if (ParameterDAO.parse(this.getCpd()))
		{
			sb.append("[Community Planning and Development]");
		}
		if (ParameterDAO.parse(this.getScr()))
		{
			sb.append("[Social and Cultural Resources]");
		}
		if (ParameterDAO.parse(this.getAfi()))
		{
			sb.append("[Agriculture and Fisheries]");
		}
		if (ParameterDAO.parse(this.getRat()))
		{
			sb.append("[Recreation and Tourism]");
		}
		if (ParameterDAO.parse(this.getEco()))
		{
			sb.append("[Ecosystems]");
		}
		if (ParameterDAO.parse(this.getOth()))
		{
			sb.append("[Other Sector]");
		}
    return sb.toString();
    
	}
	
	public String getEcv()
	{
        StringBuffer sb = new StringBuffer();
    
		if (ParameterDAO.parse(this.getEcvAtmospheric()))
		{
			sb.append("[Atmospheric (e.g., Air Temperature, Rainfall, Wind speed and direction)]");
		}
		if (ParameterDAO.parse(this.getEcvOceanic()))
		{
			sb.append("[Oceanic (e.g., Water Temperature, Salinity, Acidity, Sea Level, Wave Height)]");
		}
		if (ParameterDAO.parse(this.getEcvTerrestrial()))
		{
			sb.append("[Terrestrial (e.g., Groundwater, Soil Moisture)]");
		}
		
        return sb.toString();
    
	}
	

	public String getDataPhysical()
	{
        StringBuffer sb = new StringBuffer();
        
		if (ParameterDAO.parse(this.getPhyInsitu()))
		{
			sb.append("[In-situ Observations]");
		}
		if (ParameterDAO.parse(this.getPhySatellite()))
		{
			sb.append("[Satellite-Remote Observations]");
		}
		if (ParameterDAO.parse(this.getPhyModel()))
		{
			sb.append("[Model Results]");
		}
		if (ParameterDAO.parse(this.getPhyReanalysis()))
		{
			sb.append("[Reanalysis Products]");
		}
		if (ParameterDAO.parse(this.getPhyBathymetry()))
		{
			sb.append("[Bathymetry & Topography]");
		}
		if (ParameterDAO.parse(this.getPhyImagery()))
		{
			sb.append("[Imagery]");
		}
		
        return sb.toString();
	}
	
	public String getProducts()
	{
        StringBuffer sb = new StringBuffer();
    
		if (ParameterDAO.parse(this.getProdHindcasts()))
		{
			sb.append("[Hindcasts (climatologies)]");
		}
		if (ParameterDAO.parse(this.getProdOutlooks()))
		{
			sb.append("[Outloooks (monthly to annual)]");
		}
		if (ParameterDAO.parse(this.getProdProjections()))
		{
			sb.append("[Projections (intrannual to multi-decadal)]");
		}
		if (ParameterDAO.parse(this.getProdGuidance()))
		{
			sb.append("[Guidance, including \"Best Practices\" Manuals, Toolkits, and Guides]");
		}
		if (ParameterDAO.parse(this.getProdApplications()))
		{
			sb.append("[Applications, including Visualization and Decision Support Tools]");
		}
		
        return sb.toString();
    
	}
	
	public String getNonPhysicalChoice()
	{
		if (ParameterDAO.parse(this.getNonPhysical()))
		{
			return "[Data, Products, and Tools - non-physical (biological, socio-economic, cultural, etc.)]";
		}
		else
		{
			return "";
		}
		
	}

	/**
	 * this supports searching the fields in the table - upon finding it highlights with dark blue 
	 * @return
	 */
	public boolean contains(String token)
	{
	  if (StringUtils.containsIgnoreCase(this.getTag(), token) || 
	      StringUtils.containsIgnoreCase(this.getCode()+"", token) ||
		  StringUtils.containsIgnoreCase(this.getProjectname(), token) ||
		  StringUtils.containsIgnoreCase(this.getProjectdescription(), token) ||
		  StringUtils.containsIgnoreCase(this.getStatus(), token) ||
		  StringUtils.containsIgnoreCase(this.getCapabilityAreas(), token) ||
		  StringUtils.containsIgnoreCase(this.getFocusAreas(), token) ||
		  StringUtils.containsIgnoreCase(this.getRegionLocale(), token) ||
		  StringUtils.containsIgnoreCase(this.getEcv(), token) ||
		  StringUtils.containsIgnoreCase(this.getDataPhysical(), token) ||
		  StringUtils.containsIgnoreCase(this.getProducts(), token) ||
		  StringUtils.containsIgnoreCase(this.getNonPhysicalChoice(), token) ||
		  StringUtils.containsIgnoreCase(this.getLeadAgenciesAsString(token), token) ||
		  StringUtils.containsIgnoreCase(this.getContacts(token), token))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
	}
	
	public void filterFailLog(ProjectBean pb, String msg)
	{
		System.out.println("Project " + pb.getProjectnumber() + ",  F A I L E D  to match " + msg );
	}
	/**
	 * this will act as filter that passes or fails the Proj Bean passed in.  More generally the search String parameter can be 
	 * used to overload simple search.  True means argumater passes the match, false means fails.  
	 * @param pb
	 * @return
	 */
	public boolean filterTest (ProjectBean pb)
	{
		boolean result = true;
		StringBuffer msg = new StringBuffer();
		
        //only look for equality on properties that are set in filter "this"
		
		if (this.getTrainingBoolean())
		{
			//System.out.println("Entering ParameterDAO.parse(getTrainingBoolean())"); 
			msg.append("[Training and Capacity Building]");
			if (!pb.getTrainingBoolean())
			{
				filterFailLog(pb,"[Training and Capacity Building]");
				return false;
			}
		}
		
		if (this.getEducationBoolean())
		{
			//System.out.println("Entering ParameterDAO.parse(getEducationBoolean())"); 
			msg.append("[Education]");
			if (!pb.getEducationBoolean())
            {
              filterFailLog(pb,"[Education]");
              return false;
            }
		}
		
		if (this.getOutreachBoolean())
		{
			//System.out.println("Entering ParameterDAO.parse(getEducationBoolean())"); 
			msg.append("[Outreach]");
           if (!pb.getOutreachBoolean())
            {
              filterFailLog(pb,"[Outreach]");
              return false;
            }
		}
		
		if (ParameterDAO.parse(this.getObserving()))
		{
			//System.out.println("Entering ParameterDAO.parse(OSDS())"); 
			msg.append("[Observing Systems and Data Stewardship]");
			if (! ParameterDAO.parse(pb.getObserving()))
          {
              filterFailLog(pb,"[Observing Systems and Data Stewardship]");
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getDataservices()))
		{
			//System.out.println("Entering ParameterDAO.parse(getDS())"); 
			msg.append("[Data Services]");
			if (! ParameterDAO.parse(pb.getDataservices()))
          {
              filterFailLog(pb,"[Data Services]");
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getVariability()))
		{
			//System.out.println("Entering ParameterDAO.parse(getVar())"); 
			msg.append("[Understanding Climate Variability and Change]");
			if (! ParameterDAO.parse(pb.getVariability()))
          {
              filterFailLog(pb,"[Understanding Climate Variability and Change]");
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getOperational()))
		{
			//System.out.println("Entering ParameterDAO.parse(getOper())"); 
			msg.append("[Operational Products and Services (including Decision Support Tools)]");
			if (! ParameterDAO.parse(pb.getOperational()))
          {
              filterFailLog(pb,"[Operational Products and Services (including Decision Support Tools)]");
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getResearch()))
		{
			//System.out.println("Entering ParameterDAO.parse(this.getResearch()) SHOULD NOT HAVE ");
			//System.out.println("Entering ParameterDAO.parse(this.getResearch()) (AGAIN FOCUS) this.research = " + this.getResearch() +  "??");
			//System.out.println("Entering ParameterDAO.parse(this.getResearch()) (AGAIN FOCUS) this.research = " + ParameterDAO.parse(this.getResearch()) +  "??!!!!!!!!!!!!!!");
			msg.append("[Research/Development]"); 
			if (! ParameterDAO.parse(pb.getResearch()))
          {
              filterFailLog(pb,StringUtils.upperCase("[Research/Development]"));
  			  //System.out.println("Logged the filterfail, but did not return false...does this cascade? BTW, pb.research = " + pb.getResearch() + "???");
              //return false;
          }
		}
		
		if (ParameterDAO.parse(this.getVhistorical()))
		{
			msg.append("[Historical Observations (hindcasts/climatologies)]");
			if (! ParameterDAO.parse(pb.getVhistorical()))
          {
              filterFailLog(pb,"[Historical Observations (hindcasts/climatologies)]");
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getVprojections()))
		{
			msg.append("Projections (modeling and downscaling)");
			if (! ParameterDAO.parse(pb.getVprojections()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getAsurface()))
		{
			msg.append("[Atmospheric Parameter: Surface (e.g., temperature, precipitation, wind)]");			
			if (! ParameterDAO.parse(pb.getAsurface()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getUpperair()))
		{
			msg.append("[Atmospheric Parameter: Upper-Air]");			
			if (! ParameterDAO.parse(pb.getUpperair()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getComposition()))
		{
			msg.append("[Atmospheric Parameter: Composition]");			
			if (! ParameterDAO.parse(pb.getComposition()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getOsurface()))
		{
			msg.append("[Oceanic Parameter: Surface (e.g., SST, SSH, salinity, ocean color)]");			
			if (! ParameterDAO.parse(pb.getOsurface()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getSubsurface()))
		{
			msg.append("[Oceanic Parameter: Sub-surface (e.g., temp, salinity, nutrients, carbon, phytoplankton)]");			
			if (! ParameterDAO.parse(pb.getSubsurface()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getTerrestrial()))
		{
			msg.append("[Terrestrial Parameter (e.g. surface water, glaciers and ice caps, land cover, biomass)]");
			if (! ParameterDAO.parse(pb.getTerrestrial()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getSeasonal()))
		{
			msg.append("[Time Frame: seasonal (outlook)]");
			if (! ParameterDAO.parse(pb.getSeasonal()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getAnnual()))
		{
			msg.append("[Time Frame: intra-annual to decadal]");
			if (! ParameterDAO.parse(pb.getAnnual()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getDecadal()))
		{
			msg.append("[Time Frame: muti-decadal (scenarios)]");
			if (! ParameterDAO.parse(pb.getDecadal()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getEffect()))
		{
			msg.append("[Understanding Climate Impacts and Informing Adaptation]");
			if (! ParameterDAO.parse(pb.getEffect()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getImpacts()))
		{
			msg.append("[Climate Impacts]");
			if (! ParameterDAO.parse(pb.getImpacts()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getEhistorical()))
		{
			msg.append("[Historical Observations]");
			if (! ParameterDAO.parse(pb.getEhistorical()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getEprojections()))
		{
			msg.append("[Projections]");
			if (! ParameterDAO.parse(pb.getEprojections()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getImpactsAdaptations()))
		{
			msg.append("[Climate Adaptation]");
			if (! ParameterDAO.parse(pb.getImpactsAdaptations()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getPhs()))
		{
			
			msg.append("[Public Health and Safety]");
			if (! ParameterDAO.parse(pb.getPhs()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getFwr()))
		{
			msg.append("[Fresh Water Resources]");
			if (! ParameterDAO.parse(pb.getFwr()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getEne()))
		{
			msg.append("[Energy]");
			if (! ParameterDAO.parse(pb.getEne()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getTcc()))
		{
			msg.append("[Transportation/Communication, and Commerce]");
			if (! ParameterDAO.parse(pb.getTcc()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getCpd()))
		{
			msg.append("[Community Planning and Development]");
			if (! ParameterDAO.parse(pb.getCpd()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getScr()))
		{
			msg.append("[Social and Cultural Resources]");
			if (! ParameterDAO.parse(pb.getScr()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getAfi()))
		{
			msg.append("[Agriculture and Fisheries]");
			if (! ParameterDAO.parse(pb.getAfi()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getRat()))
		{
			msg.append("[Recreation and Tourism]");
			if (! ParameterDAO.parse(pb.getRat()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getEco()))
		{
			msg.append("[Ecosystems]");
			if (! ParameterDAO.parse(pb.getEco()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getOth()))
		{
			msg.append("[Other Sector]");
			if (! ParameterDAO.parse(pb.getOth()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getGuidance()))
		{
			msg.append("[Guidance, including \"Best Practices\"]");
			if (! ParameterDAO.parse(pb.getGuidance()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getGvariability()))
		{
			msg.append("[Guidance: Climate Variability and Change]");
			if (! ParameterDAO.parse(pb.getGvariability()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getGeffects()))
		{
			msg.append("[Guidance: Climate Impacts and Informing Adaptation]");
			if (! ParameterDAO.parse(pb.getGeffects()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getApplications()))
		{
			msg.append("[Applications, including Decision-support Tools]");
			if (! ParameterDAO.parse(pb.getApplications()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getAvariability()))
		{
			msg.append("[Applications: Climate Variability and Change]");
			if (! ParameterDAO.parse(pb.getAvariability()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getAeffects()))
		{
			msg.append("[Applications: Climate Impacts and Informing Adaptation]");
			if (! ParameterDAO.parse(pb.getAeffects()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getPolicies()))
		{
			msg.append("[Policies and Legislation]");
			if (! ParameterDAO.parse(pb.getPolicies()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getAssessment()))
		{
			msg.append("[Assessment and Evaluation]");
			if (! ParameterDAO.parse(pb.getAssessment()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getFresh()))
		{
			msg.append("[Fresh Water Resources and Drought]");
			if (! ParameterDAO.parse(pb.getFresh()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getCoastal()))
		{
			msg.append("[Coastal Inundation/SLR, Extreme Weather, and Community Resilience]");
			if (! ParameterDAO.parse(pb.getCoastal()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getMarine()))
		{
			msg.append("[Marine and Terrestrial Ecosystems]");
			if (! ParameterDAO.parse(pb.getMarine()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		
		if (ParameterDAO.parse(this.getCentral()))
		{
			msg.append("[Central North Pacific]");
			if (! ParameterDAO.parse(pb.getCentral()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getHawaii()))
		{
			msg.append("[State of Hawaii]");
			if (! ParameterDAO.parse(pb.getHawaii()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getBig()))
		{
			msg.append("[Island of Hawaii]");
			if (! ParameterDAO.parse(pb.getBig()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getMaui()))
		{
			msg.append("[Maui]");
			if (! ParameterDAO.parse(pb.getMaui()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getOahu()))
		{
			msg.append("[Island of Oahu]");
			if (! ParameterDAO.parse(pb.getOahu()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getKauai()))
		{
			msg.append("[Kauai]");
			if (! ParameterDAO.parse(pb.getKauai()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getWestern()))
		{
			msg.append("[Western North Pacific]");
			if (! ParameterDAO.parse(pb.getWestern()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getGuam()))
		{
			msg.append("[Guam]");
			if (! ParameterDAO.parse(pb.getGuam()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getCnmi()))
		{
			msg.append("[CNMI]");
			if (! ParameterDAO.parse(pb.getCnmi()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getFsm()))
		{
			msg.append("[FSM]");
			if (! ParameterDAO.parse(pb.getFsm()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getRmi()))
		{
			msg.append("[RMI]");
			if (! ParameterDAO.parse(pb.getRmi()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getPalau()))
		{
			msg.append("[Palau]");
			if (! ParameterDAO.parse(pb.getPalau()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getSouth()))
		{
			msg.append("[South Pacific]");
			if (! ParameterDAO.parse(pb.getSouth()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		
		if (ParameterDAO.parse(this.getAsam()))
		{
			msg.append("[American Samoa]");
			if (! ParameterDAO.parse(pb.getAsam()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getSamoa()))
		{
			msg.append("[Samoa]");
			if (! ParameterDAO.parse(pb.getSamoa()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getTonga()))
		{
			msg.append("[Tonga]");
			if (! ParameterDAO.parse(pb.getTonga()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getFiji()))
		{
			msg.append("[Fiji]");
			if (! ParameterDAO.parse(pb.getFiji()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getOz()))
		{
			msg.append("[Australia]");
			if (! ParameterDAO.parse(pb.getOz()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getNz()))
		{
			msg.append("[New Zealand]");
			if (! ParameterDAO.parse(pb.getNz()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getFp()))
		{
			msg.append("[French Polynesia]");
			if (! ParameterDAO.parse(pb.getFp()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getHother()))
		{
			msg.append("[Other Central Pacific]");
			if (! ParameterDAO.parse(pb.getHother()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getWother()))
		{
			msg.append("[Other Wetern Pacific]");
			if (! ParameterDAO.parse(pb.getWother()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getSother()))
		{
			msg.append("[Other South Pacific]");
			if (! ParameterDAO.parse(pb.getSother()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getOtherregions()))
		{
			msg.append("[Other Region Outside Pacific]");
			if (! ParameterDAO.parse(pb.getOtherregions()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getEcvAtmospheric()))
		{
			msg.append("[ECV - Atmospheric]");
			if (! ParameterDAO.parse(pb.getEcvAtmospheric()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getEcvOceanic()))
		{
			msg.append("[ECV - Oceanic]");
			if (! ParameterDAO.parse(pb.getEcvOceanic()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getEcvTerrestrial()))
		{
			msg.append("[ECV - Terrestrial]");
			if (! ParameterDAO.parse(pb.getEcvTerrestrial()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getAnyPhysical()))
		{
			msg.append("[Data Physical - Any]");
			if (! ParameterDAO.parse(pb.getAnyPhysical()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (ParameterDAO.parse(this.getAnyNonPhysical()))
		{
			msg.append("[Data Non-Physical - Any]");
			if (! ParameterDAO.parse(pb.getAnyNonPhysical()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}

		
		if (ParameterDAO.parse(this.getPhyInsitu()))
		{
			msg.append("[Data Physical - Insitu]");
			if (! ParameterDAO.parse(pb.getPhyInsitu()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		
		if (ParameterDAO.parse(this.getPhySatellite()))
		{
			msg.append("[Data Physical - Satellite]");
			if (! ParameterDAO.parse(pb.getPhySatellite()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getPhyModel()))
		{
			msg.append("[Data Physical - Model]");
			if (! ParameterDAO.parse(pb.getPhyModel()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getPhyReanalysis()))
		{
			msg.append("[Data Physical - Reanalysis]");
			if (! ParameterDAO.parse(pb.getPhyReanalysis()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getPhyBathymetry()))
		{
			msg.append("[Data Physical - Bathymetry]");
			if (! ParameterDAO.parse(pb.getPhyBathymetry()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getPhyImagery()))
		{
			msg.append("[Data Physical - Imagery]");
			if (! ParameterDAO.parse(pb.getPhyImagery()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		

		if (ParameterDAO.parse(this.getProdHindcasts()))
		{
			msg.append("[Products - Hindcasts]");
			if (! ParameterDAO.parse(pb.getProdHindcasts()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getProdOutlooks()))
		{
			msg.append("[Products - Outlooks]");
			if (! ParameterDAO.parse(pb.getProdOutlooks()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getProdProjections()))
		{
			msg.append("[Products - Projections]");
			if (! ParameterDAO.parse(pb.getProdProjections()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getProdGuidance()))
		{
			msg.append("[Products - Guidance]");
			if (! ParameterDAO.parse(pb.getProdGuidance()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		if (ParameterDAO.parse(this.getProdApplications()))
		{
			msg.append("[Products - Applications]");
			if (! ParameterDAO.parse(pb.getProdApplications()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}

		if (ParameterDAO.parse(this.getNonPhysical()))
		{
			msg.append("[Products - Non Physical]");
			if (! ParameterDAO.parse(pb.getNonPhysical()))
          {
              filterFailLog(pb,msg.toString());
              return false;
          }
		}
		
		if (this.getStatusCode() != this.UNKNOWN)
		{
			msg.append("[Status Filter = " + this.getStatusText() + "]");
			// pb status must mtach
			if (this.getStatusCode() != pb.getStatusCode())
			{
                filterFailLog(pb,msg.toString());
				return false;
			}

		}
		
		// set lead organizations of this must be a subset of pb
		if (this.getLeadList() != null && this.getLeadList().size() > 0)
		{
			// ensure that each of the lead agency is in pb as well.
			msg.append("[Lead Agency Filter = " + this.getLeadAgenciesAsSimpleString() + "]");
			List<Agency> agencies = this.getLeadList();
			
			for (int i = 0; i < agencies.size(); i++)
			{
				if (pb.hasLeadAgency(agencies.get(i)))
				{
					System.out.println("[Lead Agency Filter PASSED on Project " + pb.getProjectnumber() + ", " + pb.getProjectname() + ", Agency = " +
							             agencies.get(i).getAcronym() + ": " + agencies.get(i).getDescription() + "]");
				}
				else
				{
                    filterFailLog(pb,"[Lead Agency = " + agencies.get(i).getAcronym() + ": " + agencies.get(i).getDescription() + "]");
					return false;
				}
			}
			
		}
		else if (this.getLeadagencies().length > 0)
		{
			msg.append("[Lead Agency Filter = " + this.getLeadAgenciesAsSimpleString() + "]");
			String [] agencies = this.getLeadagencies();
			for (int i = 0; i < agencies.length; i++)
			{
				if (pb.hasLeadAgency(agencies[i]))
				{
					System.out.println("[Lead Agency Filter PASSED on Project " + pb.getProjectnumber() + ", " + pb.getProjectname() + ", Agency ID = " +
							             agencies[i] +"]");
				}
				else
                {
                    filterFailLog(pb,"[Lead Agencies ID = " + agencies[i] + "]");
                    return false;
                }
			}
		}

		// set partner organizations of this must be a subset of pb
		if (this.getPartnerList() != null && this.getPartnerList().size() > 0)
		{
			msg.append("[Partner Agency filter = " + this.getPartnerAgenciesAsSimpleString() + "]");
			List<Agency> agencies = this.getPartnerList();
			
			for (int i = 0; i < agencies.size(); i++)
			{
				if (pb.hasPartnerAgency(agencies.get(i)))
				{
					System.out.println("[Partner Agency Filter PASSED on Project " + pb.getProjectnumber() + ", " + pb.getProjectname() + ", Agency = " +
				             agencies.get(i).getAcronym() + ": " + agencies.get(i).getDescription() + "]");
				}
				else
				{
                    filterFailLog(pb,"[Parnter Agency = " + agencies.get(i).getAcronym() + ": " + agencies.get(i).getDescription() + "]");
					return false;
				}
			}
			
		}
		else if (this.getPartneragencies().length > 0)
		{
			msg.append("[Partner Agency filter = " + this.getPartnerAgenciesAsSimpleString() + "]");
			String [] agencies = this.getPartneragencies();
			for (int i = 0; i < agencies.length; i++)
			{
				if (pb.hasPartnerAgency(agencies[i]))
				{
					System.out.println("[Partner Agency Filter PASSED on Project " + pb.getProjectnumber() + ", " + pb.getProjectname() + ", Agency ID = " +
				             agencies[i] +"]");
				}
				else
                {
                  filterFailLog(pb,msg.toString() + "[Partner Agency ID = " + agencies[i] + "]" );
                  return false;
                }
			}
		}
		

			
		if (this.getContactList() != null && this.getContactList().size() > 0)
		{
			msg.append("[Contact Filter = " + this.getContacts("") + "]");
          
			List<Contact> contacts = this.getContactList();
			boolean contactPatternFound = false;
			for (int i = 0; i < contacts.size(); i++)
			{
				String name  = StringUtils.trimToEmpty(contacts.get(i).getName());
				String email = StringUtils.trimToEmpty(contacts.get(i).getEmail());
				
				// are these in pb?
				if (name.length() > 0)
				{
					if (StringUtils.containsIgnoreCase(pb.getContactsWthoutDecorations(), name))
					{
						System.out.println("Filter Contact Name (Fragment) " + name + " contained in contact list " + pb.getContactsWthoutDecorations());
						contactPatternFound = true;
						break;
					}
					else
					{
						System.out.println("Filter Contact Name (Fragment) " + name + " NOT contained in contact list " + pb.getContactsWthoutDecorations());
					}
				}
				if (email.length() > 0)
				{
					if (StringUtils.containsIgnoreCase(pb.getContactsWthoutDecorations(), email))
					{
						System.out.println("Filter Contact Email (Fragment) " + email + " contained in contact list " + pb.getContactsWthoutDecorations());
						contactPatternFound = true;
						break;
					}
					else
					{
						System.out.println("Filter Contact Email (Fragment) " + email + " NOT contained in contact list " + pb.getContactsWthoutDecorations());
					}
				}
			}
			
			if (!contactPatternFound)
			{
				// this pb project did not contain any of filter strings in the filter's contact or email..
				filterFailLog(pb, "[Contact Filter = " + this.getContactsWthoutDecorations() + "]");
				return false;
			}
		}
		
		
		
		///////////////////////////////////////////////////////////////////////////////////
		// simple search is reduced to this little if block of filter test
		//
		if (StringUtils.isNotBlank(this.getSearchString()))
		{
			String srchStr = StringUtils.trimToEmpty(this.getSearchString());
			
			msg.append("[Simple Search = " + srchStr  +"]");
			
			if (pb.contains(srchStr))
			{
               System.out.println("Project " + pb.toString() + " CONTAINS " + srchStr);			  	
			}
			else
			{
				filterFailLog(pb, "[Simple Text Search Filter = " + srchStr + "]");
				return false;
			}
			
		}
		
		
		if (StringUtils.isNotBlank(this.getTag()))
		{
			msg.append("[Acronyms, Abberviations = " + this.getTag() + "]");
			return StringUtils.containsIgnoreCase(pb.getTag(), this.getTag());
		}
		
		
		if (this.getCode() > 0)
		{
			msg.append("[Project Number = " + this.getCode() + "]");
			if (this.getCode() == pb.getCode()) return true;
		}
		
		if (StringUtils.isNotBlank(this.getProjectname()))
		{
			msg.append("[Name match = " + this.getProjectNameStripURL() + "]");
			return StringUtils.containsIgnoreCase(pb.getProjectNameStripURL(), this.getProjectNameStripURL());
		}
		
		if (StringUtils.isNotBlank(this.getProjectdescription()))
		{
			msg.append("[Description match = " + this.getProjectdescription() + "]");
			return StringUtils.containsIgnoreCase(pb.getProjectdescription(), this.getProjectdescription());
			
		}
		this.filterTestString = msg.toString();
		
		return result;
	}
	
	
	public boolean hasLeadAgency(Agency agency)
	{
		int org = agency.getOrg();
        boolean result = false;		
		List<Agency> agencies= this.getLeadList();
		
		if (agencies == null) return false;
		else if (agencies.size()==0) return false;
		else if (org == 0) return false;
		
		for (int i = 0; i < agencies.size(); i++)
		{
			int id = agencies.get(i).getOrg();
			if (org == id) return true;
		}
		return result;
	}
	
	public boolean hasLeadAgency(String agency)
	{
		int org = NumberUtils.toInt(agency);
        boolean result = false;		
        
		String [] agencies= this.getLeadagencies();
		
		if (agencies == null) return false;
		else if (agencies.length==0) return false; 
		else if (org == 0) return false;
		
		for (int i = 0; i < agencies.length; i++)
		{
			int id = NumberUtils.toInt(agencies[i]);
			if (org == id) return true;
		}
		return result;
	}

	public boolean hasPartnerAgency(Agency agency)
	{
		int org = agency.getOrg();
        boolean result = false;		
		List<Agency> agencies= this.getPartnerList();
		
		if (agencies == null) return false;
		else if (agencies.size()==0) return false; 
		else if (org == 0) return false;
		
		for (int i = 0; i < agencies.size(); i++)
		{
			int id = agencies.get(i).getOrg();
			if (org == id) return true;
		}
		return result;
	}
	
	public boolean hasPartnerAgency(String agency)
	{
		int org = NumberUtils.toInt(agency);
        boolean result = false;		
        
		String [] agencies= this.getPartneragencies();
		
		if (agencies == null) return false;
		else if (agencies.length==0) return false; 
		else if (org == 0) return false;
		
		for (int i = 0; i < agencies.length; i++)
		{
			int id = NumberUtils.toInt(agencies[i]);
			if (org == id) return true;
		}
		return result;
	}
	
	/**
	 * does the pb contacts, passed in as parameter have anything in the email as well as name field that contains ignore case the filter contact?
	 * can be generalized to regex, peerhaps 
	 * @param contact
	 * @return
	 */
	public boolean anyFilterContactElementIsContainedInContact (Contact contact)
	{
		// empty contact return false
		if (StringUtils.isBlank(contact.getName()) && StringUtils.isBlank(contact.getEmail())) return false;

		// lay-out the contact as one string to be examined in its full glory
		String contactStr = StringUtils.stripToEmpty(contact.toString());
		System.out.println("FULL GLORY contact string to be run against all filters to see if it contains any one \"" + contactStr + "\"");

		// get all filter contacts, emails
		List<Contact> contacts = this.getContactList();
	
		// default is no match found 
		boolean result = false;
		
		
		// look at all the filter contacts and email
		for (int i = 0; i < contacts.size(); i++)
		{
			// these are the filters
			String filterName = StringUtils.stripToEmpty(contacts.get(i).getName());
			String filterEmail = StringUtils.stripToEmpty(contacts.get(i).getEmail());
			
			if (filterName.length() != 0 && filterEmail.length() == 0) continue; 
			
			// now look for all possible matches name within email, email within name etc
			if (filterName.length() > 0)
			{
			  if (StringUtils.containsIgnoreCase(contactStr, filterName))
			  {
				  System.out.println("Contact NAME filter \"" + filterName + "\" is contained in Contact Name = " + contact.getName() + ", Email = " + contact.getEmail());
				  return true;
			  }
			  else
			  {
				  System.out.println("Contact NAME filter \"" + filterName + "\" IS NOT ANYWHERE contained in Contact Name = " + contact.getName() + ", Email = " + contact.getEmail());
			  }
			}
			else if (filterEmail.length() > 0)
			{
			  if (StringUtils.containsIgnoreCase(contactStr, filterEmail))
			  {
				  System.out.println("Contact EMAIL filter \"" + filterEmail + "\" is contained in Contact Name = " + contact.getName() + ", Email = " + contact.getEmail());
                  return true;
			  }
			  else
			  {
				  System.out.println("Contact NAME filter \"" + filterEmail + "\" IS NOT ANYWHERE contained in Contact Name = " + contact.getName() + ", Email = " + contact.getEmail());
			  }
			}
		}
		return result;
	}
	
	/**
	 * insert() - just does static insert of this one project 
	 * @return project 
	 * @throws SQLException
	 */
	public int insert(boolean daps) throws SQLException
	{
		// main insert function, using this bean's own guts 
		
		// first and foremost add the project
		System.out.println("Entered PB.insert()...");
		
		System.out.println("Insert Step 1 ParameterDAO.addProject(" 
				                + this.projectname + ", " + projectdescription + 
				                ", status = " + this.getStatus()+ 
				                ", work sheet name = " + worksheetfilename +")");
		
		int project = 
		  parameterDAO.addProject(tag,code,projectname,projectdescription,getStatusCode(),worksheetfilename, url);
		
		if (project > 0)
		{
		  // use the key generated to put in all the tables 
			FocusArea f = new FocusArea(); f.setParameterDAO(getParameterDAO());
		  f.insert(project, fresh, coastal, marine);
		  
		  CapabilityArea c = new CapabilityArea(); c.setParameterDAO(getParameterDAO());
		  c.insert(project, training, education, outreach, observing, dataservices, 
		  		                  variability, effect, guidance, apps, policies, assessment);
		  
		  Variability v = new Variability(); v.setParameterDAO(getParameterDAO());
	  	v.insert(project, operational, research, vhistorical, vprojections);
	  	
	  	Atmospheric a = new Atmospheric(); a.setParameterDAO(getParameterDAO());
	  	a.insert(project, asurface, upperair, composition);
	  	
	  	Oceanic o = new Oceanic(); o.setParameterDAO(getParameterDAO());
	  	o.insert(project, osurface, subsurface);
	  	
	  	Terrestrial t = new Terrestrial(); t.setParameterDAO(getParameterDAO());
	  	t.insert(project, terrestrial);
	  	
	  	Timeframes tf = new Timeframes(); tf.setParameterDAO(getParameterDAO());
	  	tf.insert(project, seasonal, annual, decadal);
		  
	  	ClimateImpact ci = new ClimateImpact(); ci.setParameterDAO(getParameterDAO());
	  	ci.insert(project, impacts, ehistorical, eprojections, adaptation);

	  	// Sectors
	  	Sector s = new Sector(); s.setParameterDAO(getParameterDAO());
	  	s.insert(project, phs, fwr, ene, tcc, cpd, scr, afi, rat, eco, oth); 
	  	
	  	Guidance g = new Guidance(); g.setParameterDAO(getParameterDAO());
	  	g.insert(project, gvariability, geffects);
		  
	  	Applications ap = new Applications(); ap.setParameterDAO(getParameterDAO());
		  ap.insert(project, avariability, aeffects);
		  
		  Otherregions or = new Otherregions(); or.setParameterDAO(getParameterDAO());
		  or.insert(project, this.getOtherregions());
		  
		  CentralPacific cp = new CentralPacific(); cp.setParameterDAO(getParameterDAO());
		  cp.insert(project, central, hawaii, hother);
		  
		  Hawaii hi = new Hawaii(); hi.setParameterDAO(getParameterDAO());
		  hi.insert(project, this.getBig(), maui, oahu, kauai);
		  
		  WestPacific wp = new WestPacific(); wp.setParameterDAO(getParameterDAO());
		  wp.insert(project, western, guam, cnmi, fsm, rmi, palau, wother);
		  
		  SouthPacific sp = new SouthPacific(); sp.setParameterDAO(getParameterDAO());
		  sp.insert(project, south, asam, samoa, tonga, fiji, oz, nz, fp,sother);
		  
		  Ecv ecv = new Ecv(); ecv.setParameterDAO(getParameterDAO());
		  ecv.insert(project, ecvAtmospheric, ecvOceanic, ecvTerrestrial);
		  
		  DataPhysical dp = new DataPhysical(); dp.setParameterDAO(getParameterDAO());
		  dp.insert(project, phyInsitu, phySatellite, phyModel, phyReanalysis, phyBathymetry, phyImagery);
		  
		  Products p = new Products(); p.setParameterDAO(getParameterDAO());
		  p.insert(project, prodHindcasts, prodOutlooks, prodProjections, prodGuidance, prodApplications);
		  
		  NonPhysical np = new NonPhysical(); np.setParameterDAO(getParameterDAO());
		  np.insert(project, nonPhysicalEnvironmental, nonPhysicalSocioCultural, nonPhysicalEconomic, nonPhysical);
		  
		  if (daps)
		  {
			  Daps dps = new Daps(); dps.setParameterDAO(getParameterDAO());
			  dps.insert(project);
		  }
		  
		  parameterDAO.insertContact(project, this.getContactName(), this.getEmailsAddress());
		  parameterDAO.insertAgencies("leaders", project, this.leadagencies);
		  parameterDAO.insertAgencies("partners", project, this.partneragencies);
		  
		  
		}
		else
		{
			// means addProject failed for some reason
			System.out.println("Could not add project " + projectname);  
		}
		
		
		return project;
	}
	
	/**
	 * the od proect insert is now just a default case
	 * @return
	 * @throws SQLException
	 */
	public int insert() throws SQLException
	{
		return insert(false);
	}
}
 