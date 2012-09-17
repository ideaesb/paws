package org.noaaideacenter.paws;

import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;


public class Agency
{
	private int org = 0;
	private String acronym = "";
	private String description = "";
	private String url = "";
	
	public Agency()
	{
	}
	/**
	 * @return the org
	 */
	public int getOrg()
	{
		return org;
	}
	/**
	 * @param org the org to set
	 */
	public void setOrg(int org)
	{
		this.org = org;
	}
	/**
	 * @param org the org to set
	 */
	public void setOrg(String org)
	{
		this.org = NumberUtils.toInt(org);
	}
	/**
	 * @return the acronym
	 */
	public String getAcronym()
	{
		return StringUtils.trimToEmpty(acronym);
	}
	/**
	 * @param acronym the acronym to set
	 */
	public void setAcronym(String acronym)
	{
		this.acronym = StringUtils.trimToEmpty(acronym);
	}
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return StringUtils.trimToEmpty(description);
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = StringUtils.trimToEmpty(description);
	}
	
	public String toString()
	{
      return acronym + ": " + description;
	}
	public boolean isOther()
	{
		return StringUtils.equalsIgnoreCase(this.getAcronym(), "Other");
	}
	
	public boolean isOtherLeader()
	{
		return StringUtils.equalsIgnoreCase(this.getAcronym(), "Other") && StringUtils.containsIgnoreCase(this.getDescription(), "Lead");
	}
	public boolean isOtherPartner()
	{
		return StringUtils.equalsIgnoreCase(this.getAcronym(), "Other") && StringUtils.containsIgnoreCase(this.getDescription(), "Part");
	}
	public boolean contains(String str)
	{
		if (StringUtils.containsIgnoreCase(this.getAcronym(), str) ||
			StringUtils.containsIgnoreCase(this.getDescription(), str))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getSearchDecoratedAcronym(String tok)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<div style=\"background-color: #C2F670; display:inline;\">");
		sb.append(this.getAcronym());
		sb.append("</div><!-- !!!_FOUND_"+ StringUtils.trimToEmpty(tok) +"_!!! -->");
		return sb.toString();
	}
	
	public String toGoogleString(String searchStr)
	{
	  StringBuffer sb = new StringBuffer();
	  sb.append("<a href=\"");
	  if (this.isOther())
	  {
		  sb.append("addAgencies.jsp");
	  }
	  else
	  {
		  sb.append("http://www.google.com/#q=");

		  try
		  {
		    sb.append(URLEncoder.encode(this.getAcronym() + " " + this.getDescription(), "UTF-8"));
		  }
		  catch (Exception e)
		  {
			System.out.println("Error encoding the Google link for " + this.toString());  
			System.out.println(e);  
		  }
	  }
	  sb.append("\" target=\"_blank\">");
	  if (StringUtils.isBlank(searchStr))
	  {
		  sb.append(this.getAcronym()); 
	  }
	  else if (this.contains(searchStr))
	  {
	    sb.append(this.getSearchDecoratedAcronym(searchStr));
	  }
	  else
	  {
		  sb.append(this.getAcronym()); 
	  }
	  sb.append("</a>");
      return sb.toString();
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
