package org.noaaideacenter.paws;

import org.apache.commons.lang.StringUtils;



public class Contact
{
	
	public final int  MAX_NAME_LENGTH = 50;
	public final int  MAX_EMAIL_LENGTH = 50;

	private int id = 0;
	private String name = "";
	private String email = "";
	
	private String [] projects = new String [0];
	private String [] agencies = new String [0];
	
	
	
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String nombre)
	{
		this.name = StringUtils.left(StringUtils.trimToEmpty(nombre), this.MAX_NAME_LENGTH);
	}
	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String emailAddress)
	{
		this.email = StringUtils.left(StringUtils.trimToEmpty(emailAddress), this.MAX_EMAIL_LENGTH);
	}
	/**
	 * @return the projects
	 */
	public String[] getProjects()
	{
		return projects;
	}
	/**
	 * @param projects the projects to set
	 */
	public void setProjects(String[] projects)
	{
		this.projects = projects;
	}
	/**
	 * @return the agencies
	 */
	public String[] getAgencies()
	{
		return agencies;
	}
	/**
	 * @param agencies the agencies to set
	 */
	public void setAgencies(String[] agencies)
	{
		this.agencies = agencies;
	}
	
	
	public String toString()
	{
		if (StringUtils.isBlank(this.getName()))  return "";
		return name + " (" + email + ")";
	}
	
	public String toEmailLinkString()
	{
		if (StringUtils.isBlank(this.getName()))  return "";
		return "<a href=\"mailto:"+ email +"\" target=\"_blank\">" + this.getName() + "</a>";
	}
	
	public String toEmailLinkString(String searchString)
	{
		if (StringUtils.isBlank(this.getName()))  return "";
		//else if (StringUtils.isBlank(searchString)) return this.toEmailLinkString();
		else return "<a href=\"mailto:"+ email +"\" target=\"_blank\">" + ParameterDAO.highlightHTML(this.getName(),searchString) + "</a>";
	}
}
