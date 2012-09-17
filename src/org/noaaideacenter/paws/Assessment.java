package org.noaaideacenter.paws;

import java.util.Vector;

/**
 * contains boolean variable to assist search and string variables to assist rendering in jsp
 * @author Uday
 *
 */
public class Assessment 
{
	// Status Codes
	public final int  ONGOING  = 1; 
	public final int  PLANNED  = 2; 
	public final int  COMPLETED = 3; 
	public final int  UNKNOWN  = 4;
	
	// Assessment type
	private boolean science      = false;
	private boolean needs        = false;
	private boolean capacity     = false;
	private boolean capabilities = false; 
	private boolean risk         = false;
	
	private boolean needsCapabilities = false;
	
	// Area of Applicability
	private boolean international = false;
	private boolean regional      = false;
	private boolean local         = false;
	
	// Focus Area
	private boolean fresh    = false;
	private boolean coastal  = false;
	private boolean marine   = false; 
	
	// Region 
	private boolean cnp = false;
	private boolean wnp = false; 
	private boolean sp  = false;
	private boolean otherRegion = false; 
	
	
	// Rendering 
	private String name = "";
	private String worksheet = "";
	private String description = "";
	private int status = 4;
	private String url = "";
	private String region = "";
	private String agency = "";
	private String agencyUrl = "";
	private String contact = "";
	private String email = "";

	
	public boolean isScience() {
		return science;
	}
	public void setScience(boolean science) {
		this.science = science;
	}
	public boolean isNeeds() {
		return needs;
	}
	public void setNeeds(boolean needs) 
	{
		this.needs = needs;
		setNeedsCapabilitiesBasedOnChildren();
	}
	public boolean isCapacity() {
		return capacity;
	}
	public void setCapacity(boolean capacity) {
		this.capacity = capacity;
		setNeedsCapabilitiesBasedOnChildren();
	}
	public boolean isCapabilities() {
		return capabilities;
	}
	public void setCapabilities(boolean capabilities) {
		this.capabilities = capabilities;
		setNeedsCapabilitiesBasedOnChildren();
	}
	public boolean isRisk() {
		return risk;
	}
	public void setRisk(boolean risk) {
		this.risk = risk;
	}
	public boolean isNeedsCapabilities() {
		return needsCapabilities;
	}
	public void setNeedsCapabilities(boolean needsCapabilities) {
		this.needsCapabilities = needsCapabilities;
	}
    public void setNeedsCapabilitiesBasedOnChildren()
    {
		if (this.needs) 
		{
			this.needsCapabilities = true;
		}
		else if (this.capabilities)
		{
			this.needsCapabilities = true;
		}
		else if (this.capacity)
		{
			this.needsCapabilities = true;
		}
		else
		{
			this.needsCapabilities = false;
		}

    }
	
	public boolean isInternational() {
		return international;
	}
	public void setInternational(boolean international) {
		this.international = international;
	}
	public boolean isRegional() {
		return regional;
	}
	public void setRegional(boolean regional) {
		this.regional = regional;
	}
	public boolean isLocal() {
		return local;
	}
	public void setLocal(boolean local) {
		this.local = local;
	}
	public boolean isFresh() {
		return fresh;
	}
	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}
	public boolean isCoastal() {
		return coastal;
	}
	public void setCoastal(boolean coastal) {
		this.coastal = coastal;
	}
	public boolean isMarine() {
		return marine;
	}
	public void setMarine(boolean marine) {
		this.marine = marine;
	}
	public boolean isCnp() {
		return cnp;
	}
	public void setCnp(boolean cnp) {
		this.cnp = cnp;
	}
	public boolean isWnp() {
		return wnp;
	}
	public void setWnp(boolean wnp) {
		this.wnp = wnp;
	}
	public boolean isSp() {
		return sp;
	}
	public void setSp(boolean sp) {
		this.sp = sp;
	}
	public boolean isOtherRegion() {
		return otherRegion;
	}
	public void setOtherRegion(boolean otherRegion) {
		this.otherRegion = otherRegion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorksheet() {
		return worksheet;
	}
	public void setWorksheet(String worksheet) {
		this.worksheet = worksheet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * @return the status as string
	 */
	public String getStatusText()
	{
		int code = this.getStatus();
		
		if (code == this.ONGOING)
		{
			return "On-going";
		}
		else if (code == this.PLANNED)
		{
			return "Planned";
		}
		else if (code == this.COMPLETED)
		{
			return "Completed";
		}
		else
		{
			return "not available";
		}
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public void setRegion(Vector<String> regions) {
		if (regions.size() == 1)
		{
			this.region = regions.elementAt(0);
		}
		else
		{
			StringBuffer sb = new StringBuffer();
			sb.append("<ul style=\"display: inline;margin-left: 0;padding-left: 0;\">");
			for (int i = 0; i < regions.size(); i++)
			{
				sb.append("<li style=\"margin-left: 10px;\">");
				sb.append(regions.elementAt(i));
				sb.append("</li>");
			}
			sb.append("</ul>");
			
			this.region = sb.toString();
		}
	}
	
	
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getAgencyUrl() {
		return agencyUrl;
	}
	public void setAgencyUrl(String agencyUrl) {
		this.agencyUrl = agencyUrl;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		
		
		if (this.isFresh())
		{
			sb.append(fresh);
		}
		if (this.isCoastal())
		{
			sb.append(coastal);
		}
		if (this.isMarine())
		{
			sb.append(marine);
		}
		
		if (sb.length() == 0) return "None";	
		
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @return the rendering for types
	 */
	public String getTypes()
	{
		StringBuffer sb = new StringBuffer();
		
		// if just one no need for list
		
		int count = 0;
		if(this.isScience()) count++;
		if(this.isNeedsCapabilities()) count++;
		if(this.isRisk()) count++;
		
		if (count < 2)
		{
			// just one assessment type
			if(this.isScience()) sb.append("Climate Science");
			
			if(this.isNeedsCapabilities())
			{
				sb.append("Needs and Capabilities -");
				if (this.isNeeds()) sb.append(" Needs");
				if (this.isCapacity())
				{
					if (this.isNeeds()) sb.append(",");
					sb.append(" Capacity");
				}
				if (this.isCapabilities()) 
				{
					if (this.isNeeds() || this.isCapacity()) sb.append(",");
					sb.append(" Capabilities");
				}
			}
			
			if(this.isRisk()) sb.append("Risk and Vulnerability or Problem-Focused");
		}
		else
		{
		  // multiple choice, hence render as unordered list
			sb.append("<ul style=\"display: inline;margin-left: 0;padding-left: 0;\">");
	
			if(this.isScience()) sb.append("<li style=\"margin-left: 10px;\">Climate Science</li>");
			
			if(this.isNeedsCapabilities())
			{
				sb.append("<li style=\"margin-left: 10px;\">Needs and Capabilities -");
				if (this.isNeeds()) sb.append(" Needs");
				if (this.isCapacity())
				{
					if (this.isNeeds()) sb.append(",");
					sb.append(" Capacity");
				}
				if (this.isCapabilities()) 
				{
					if (this.isNeeds() || this.isCapacity()) sb.append(",");
					sb.append(" Capabilities");
				}
			    sb.append("</li>");
			}
			
			if(this.isRisk()) sb.append("<li style=\"margin-left: 10px;\">Risk and Vulnerability or Problem-Focused</li>");
			
            sb.append("</ul>");			
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @return the rendering for types
	 */
	public String getAreas()
	{
		StringBuffer sb = new StringBuffer();
		
		// if just one no need for list
		
		int count = 0;
		if(this.isInternational()) count++;
		if(this.isRegional()) count++;
		if(this.isLocal()) count++;
		
		if (count < 2)
		{
			// just one assessment type
			if(this.isInternational()) sb.append("International and National");
			if(this.isRegional())sb.append("National and Regional");
			if(this.isLocal()) sb.append("Regional/Local or Problem-focused");
		}
		else
		{
		  // multiple choice, hence render as unordered list
			sb.append("<ul style=\"display: inline;margin-left: 0;padding-left: 0;\">");
			if(this.isInternational()) sb.append("<li style=\"margin-left: 10px;\">International and National</li>");
			if(this.isRegional())sb.append("<li style=\"margin-left: 10px;\">National and Regional</li>");
			if(this.isLocal()) sb.append("<li style=\"margin-left: 10px;\">Regional/Local or Problem-focused</li>");
            sb.append("</ul>");			
		}
		
		return sb.toString();
	}
	
	
	/**
	 * pass if any of the filter assessment (this) boolean property is also in candidate assessment a 
	 * if all properties of assessment are false, then any candidate would pass...hence default result is true
	 * @param a
	 * @return
	 */
	public boolean filterTest (Assessment a)
	{
		boolean result = true;
		
		
		if(this.isScience())
		{
			if (!a.isScience())
			{
				return false;
			}
		}
		
		
		if (this.isNeedsCapabilities())
		{
			if (!a.isNeedsCapabilities())
			{
				return false; 
			}
		}
		
		
		if (this.isRisk())
		{
			if (!a.isRisk())
			{
				return false; 
			}
		}
		
		if (this.isInternational())
		{
			if (!a.isInternational())
			{
				return false; 
			}
		}
		
		if (this.isRegional())
		{
			if (!a.isRegional())
			{
				return false; 
			}
		}
		
		if (this.isLocal())
		{
			if (!a.isLocal())
			{
				return false; 
			}
		}
		
		if (this.isFresh())
		{
			if (!a.isFresh())
			{
				return false; 
			}
		}
		
		if (this.isCoastal())
		{
			if (!a.isCoastal())
			{
				return false; 
			}
		}
		
		if (this.isMarine())
		{
			if (!a.isMarine())
			{
				return false; 
			}
		}
		
		if (this.isCnp())
		{
			if (!a.isCnp())
			{
				return false; 
			}
		}

		if (this.isWnp())
		{
			if (!a.isWnp())
			{
				return false; 
			}
		}
		
		if (this.isSp())
		{
			if (!a.isSp())
			{
				return false; 
			}
		}
		
		if (this.isOtherRegion())
		{
			if (!a.isOtherRegion())
			{
				return false; 
			}
		}

		
		
		return result;
    }
}