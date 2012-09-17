package org.noaaideacenter.paws;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.math.NumberUtils;


public class AddProjectServlet extends HttpServlet
{
	static final long serialVersionUID = 171L; 
		
	ProjectBean pb = new ProjectBean();	int project = 0;
	ProjectBean filter = new ProjectBean(); 
	StringBuffer msg = new StringBuffer();
	ParameterDAO parameterDAO = new ParameterDAO();
	String baseurl = ""; String lookfor = ""; 
	
  DataSource dataSource;
 
	ServletConfig config ;
	
	  public void init(ServletConfig config)throws ServletException 
	  {
		    this.config = config;
		    super.init(config);
	  }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("AddProjectServlet.doPost Entered...");
		
		init(response); 		PrintWriter out = response.getWriter();
        dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");
        baseurl = config.getServletContext().getInitParameter("baseurl");  // filesystem web-root
        parameterDAO.setDataSource(dataSource);
        pb.setParameterDAO(parameterDAO);
        filter.setParameterDAO(parameterDAO);

		System.out.println("AddProjectServlet.doPost done inits pb.set, filter.set...");

        
		if (ParameterDAO.parse(request.getParameter("clearmsgs")))
		{
			msg = new StringBuffer();
		}
    		
		String [] deleted   = request.getParameterValues("delete");
		String    addnew    = request.getParameter("addnew");
		String    updated   = request.getParameter("updated");
		String    undelete  = request.getParameter("undelete");
		String    searchbyx = request.getParameter("searchbyx");
		
		          filter.setSearchString(StringUtils.trimToEmpty(request.getParameter("search")));
		String    sortby   = StringUtils.trimToEmpty(request.getParameter("sortby"));
		
		String    order    =  "DESC";
		if (!ParameterDAO.parse(request.getParameter("order"))) order = "ASC";
		
		// if coming from addContacts, success or failure...
		if (ParameterDAO.parse(request.getAttribute("addcontacts")) || 
			ParameterDAO.parse(request.getAttribute("addagencies")) ||
			ParameterDAO.parse(request.getAttribute("uploadedfile"))			)
		{
		  msg.append(StringUtils.trimToEmpty((String) request.getAttribute("msg")));
		}
		else if (StringUtils.isNotBlank(filter.getSearchString()))
		{
		  // triggers the simple search exclusive of any other action (safe from delete, by preceding in if-then )
		  // do absolutely nothing the search field will be populated just fine as expected.  Later, may be add X number of projects
		}
		else if (deleted == null)
		{
			//System.out.println("AddProjectServlet.doPost Entered else if deleted == null");

			// coming from index.jsp
			if (ParameterDAO.parse(updated))
			{
				addProject(request, response, true);
			}
			else if (ParameterDAO.parse(undelete))
			{
				parameterDAO.unDeleteAllProjects();
			}
			else if (ParameterDAO.parse(addnew))
			{
				addProject(request, response, false);
			}
			else if (ParameterDAO.parse(searchbyx))
			{
				//we are just setting filter
				setProjectBean(request);
				filter = pb; 
                System.out.println("Filter STARTS LIFE as = " + filter.toFilterString());
                //System.out.println("Filter Training INIT parsed as = " + ParameterDAO.parse(filter.getTraining()));
                //System.out.println("Filter Capability Area(s) INIT as = " + filter.getCapabilityAreas());
                
        		msg.append("Advanced Search Parameters = ");
        		msg.append("<div style=\"font-family: 'trebuchet ms', sans-serif;  font-size: 9px; font-style: italic; text-transform: lowercase; display: inline; \">");
        		msg.append(filter.toFilterString() );  
        		msg.append("</div><br />");
                
                
			}
		}
		else if (deleted.length == 0)
		{
			// came from projects list but nothing to do...later when table cells are editable, we may @TO DO capture all edits/updates here 
		}
		else
		{
			parameterDAO.deleteProject(deleted);
			int count = 0;
			for (int i = 0; i < deleted.length; i++)
			{
				  count++;
				  
				  if (count == 1)
				  {
					  msg.append("Project(s) <strong><span style=\"background-color: #FFFF00\">"); 
				  }
				  else
				  {
					  msg.append(",&nbsp;<strong><span style=\"background-color: #FFFF00\">");  
				  }
			      msg.append(StringEscapeUtils.escapeHtml(parameterDAO.getJustOneProject(deleted[i]).getProjectname()));
				  msg.append("</span></strong>");
			}
			if (count > 0) msg.append(" D E L E T E D<BR />");
		}
		
		/////////////////////////////////////////////
		//  Draw the projects list table
		//
		out.println(getHeader());
		out.println(getMessageTable(msg));
		//System.out.println("AddProjectServlet.doPost drawing projects table " + filter.toString());
		
		if (StringUtils.isBlank(sortby))
		{ 
			out.println(getProjectsListHTML());
		}
		else if (StringUtils.equalsIgnoreCase(sortby, "code"))
		{
			out.println(getProjectsListHTML("code",order));
		}
		else if (StringUtils.equalsIgnoreCase(sortby, "name"))
		{
			out.println(getProjectsListHTML("nametitle",order));
		}
		else if (StringUtils.equalsIgnoreCase(sortby, "description"))
		{
			out.println(getProjectsListHTML("description",order));
		}
		else if (StringUtils.equalsIgnoreCase(sortby, "status"))
		{
			out.println(getProjectsListHTML("status",order));
		}
		else
		{
			out.println(getProjectsListHTML());
		}
		

	  
	  
	  out.println(getFooter());
	  filter = new ProjectBean();
		//System.out.println("AddProjectServlet.doPost DONE");

		
	}
	
	private void addProject(HttpServletRequest request, HttpServletResponse response, boolean updateFlag) 
	  throws ServletException, IOException
	{
		// First order of business is to capture the form parameters into the project bean
		setProjectBean(request);
		// execute the insert
		String id = request.getParameter("id");
		try
		{
			if (updateFlag)	parameterDAO.deleteProject(id);
		  project = pb.insert();
		}
		catch (Exception e)
		{
	    msg.append("A B O R T.  The following database error has occured:<br />");
	    msg.append("<strong><span style=\"background-color: #FFFF00\">" +e+"</span></strong><br />");
		}
		finally
		{
			if (project > 0)
			{
				// success 
				msg.append("Project <strong><span style=\"background-color: #FFFF00\">" + pb.getProjectname());
			  if (updateFlag)
			  {
			  	msg.append("</span></strong> was U P D A T E D <br />");
			  }
			  else
			  {
			  	msg.append("</span></strong> was I N S E R T E D<br />");
			  }
			  
			}
			else
			{
				msg.append("F A I L E D to Insert/Update Project " + pb.getProjectname() + 
						        " into database!!!!!!!!!!!<br />");
			}
		}
	}

	
	private void setProjectBean(HttpServletRequest request)
	{
		pb.setProjectname(request.getParameter("projectname"));
		pb.setTraining(request.getParameter("training"));
		pb.setEducation(request.getParameter("education"));
		pb.setOutreach(request.getParameter("outreach"));
		pb.setObserving(request.getParameter("observing"));
		pb.setDataservices(request.getParameter("dataservices"));
		pb.setVariability(request.getParameter("variability"));
		pb.setOperational(request.getParameter("operational"));
		pb.setResearch(request.getParameter("research"));
		pb.setVhistorical(request.getParameter("vhistorical"));
		pb.setVprojections(request.getParameter("vprojections"));
		pb.setAsurface(request.getParameter("asurface"));
		pb.setUpperair(request.getParameter("upperair"));
		pb.setComposition(request.getParameter("composition"));
		pb.setOsurface(request.getParameter("osurface"));
		pb.setSubsurface(request.getParameter("subsurface"));
		pb.setTerrestrial(request.getParameter("terrestrial"));
		pb.setSeasonal(request.getParameter("seasonal"));
		pb.setAnnual(request.getParameter("annual"));
		pb.setDecadal(request.getParameter("decadal"));
		pb.setEffect(request.getParameter("effect"));
		pb.setImpacts(request.getParameter("impacts"));
		pb.setEhistorical(request.getParameter("ehistorical"));
		pb.setEprojections(request.getParameter("eprojections"));
		pb.setAdaptation(request.getParameter("adaptation"));
		pb.setPhs(request.getParameter("phs"));
		pb.setFwr(request.getParameter("fwr"));
		pb.setEne(request.getParameter("ene"));
		pb.setTcc(request.getParameter("tcc"));
		pb.setCpd(request.getParameter("cpd"));
		pb.setScr(request.getParameter("scr"));
		pb.setAfi(request.getParameter("afi"));
		pb.setRat(request.getParameter("rat"));
		pb.setEco(request.getParameter("eco"));
		pb.setOth(request.getParameter("oth"));
		pb.setGuidance(request.getParameter("guidance"));
		pb.setGvariability(request.getParameter("gvariability"));
		pb.setGeffects(request.getParameter("geffects"));
		pb.setApps(request.getParameter("apps"));
		pb.setAvariability(request.getParameter("avariability"));
		pb.setAeffects(request.getParameter("aeffects"));
		pb.setPolicies(request.getParameter("policies"));
		pb.setAssessment(request.getParameter("assessment"));
		pb.setFresh(request.getParameter("fresh"));
		pb.setCoastal(request.getParameter("coastal"));
		pb.setMarine(request.getParameter("marine"));
		pb.setCentral(request.getParameter("central"));
		pb.setHawaii(request.getParameter("hawaii"));
		pb.setBig(request.getParameter("big"));
		pb.setMaui(request.getParameter("maui"));
		pb.setOahu(request.getParameter("oahu"));
		pb.setKauai(request.getParameter("kauai"));
		pb.setHother(request.getParameter("hother"));
		pb.setWestern(request.getParameter("western"));
		pb.setGuam(request.getParameter("guam"));
		pb.setCnmi(request.getParameter("cnmi"));
		pb.setFsm(request.getParameter("fsm"));
		pb.setRmi(request.getParameter("rmi"));
		pb.setPalau(request.getParameter("palau"));
		pb.setWother(request.getParameter("wother"));
		pb.setSouth(request.getParameter("south"));
		pb.setAsam(request.getParameter("asam"));
		pb.setSamoa(request.getParameter("samoa"));
		pb.setTonga(request.getParameter("tonga"));
		pb.setFiji(request.getParameter("fiji"));
		pb.setOz(request.getParameter("oz"));
		pb.setNz(request.getParameter("nz"));
		pb.setFp(request.getParameter("fp"));
		pb.setSother(request.getParameter("sother"));
		pb.setOtherregions(request.getParameter("otherregions"));		
		pb.setStatus(request.getParameter("status"));
		pb.setLeadagencies(request.getParameterValues("leadagencies"));
		pb.setPartneragencies(request.getParameterValues("partneragencies"));
		pb.setProjectdescription(request.getParameter("projectdescription"));
		pb.setWorksheetfilename(request.getParameter("worksheetfilename"));
		pb.setTag(request.getParameter("tag"));
		pb.setCode(request.getParameter("code"));
		
		// separately handle contacts, email until figure out a better more efficient 
		// way of passing names, emails as arrays to be picked up by request.getParameterValues...
		
		String [] contacts = new String [3]; String [] emails = new String [3];
		
		contacts[0] = StringUtils.trimToEmpty(request.getParameter("contact1"));
    //System.out.println("AddProjectServlet.setProjectBean contacts[0] set to " + contacts[0] );		
		contacts[1] = StringUtils.trimToEmpty(request.getParameter("contact2"));
    //System.out.println("AddProjectServlet.setProjectBean contacts[1] set to " + contacts[1] );		
		contacts[2] = StringUtils.trimToEmpty(request.getParameter("contact3"));
    //System.out.println("AddProjectServlet.setProjectBean contacts[2] set to " + contacts[2] );		
		
		emails[0] = StringUtils.trimToEmpty(request.getParameter("email1"));
    //System.out.println("AddProjectServlet.setProjectBean emails[0] set to " + emails[0] );		
		emails[1] = StringUtils.trimToEmpty(request.getParameter("email2"));
    //System.out.println("AddProjectServlet.setProjectBean emails[1] set to " + emails[1] );		
		emails[2] = StringUtils.trimToEmpty(request.getParameter("email3"));
    //System.out.println("AddProjectServlet.setProjectBean emails[2] set to " + emails[2] );		

		pb.setContactName(contacts);  pb.setEmailsAddress(emails); pb.setContactList();
    //System.out.println("Project " + pb.getProjectnumber() + ", " + pb.getProjectname() + " contacts and emails have been set from request parameters " );
    //System.out.println("Contacts = " + pb.getContacts(""));
		
	}
	private void init(HttpServletResponse response)
	{
	  response.setHeader("Pragma","no-cache"); //HTTP 1.0
	  response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
	  response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	  response.setHeader("Cache-Control", "private"); // HTTP 1.1 
	  response.setHeader("Cache-Control", "no-store"); // HTTP 1.1 
	  response.setHeader("Cache-Control", "max-stale=0"); // HTTP 1.1 
		response.setContentType("text/html");
	}
	
	private String getHeader()
	{
		StringBuffer sb = new StringBuffer();
		
		
		   
		sb.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" ");
		sb.append("http://www.w3.org/TR/html4/loose.dtd\">");
		//sb.append("transitional.dtd\">");
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Pacific  Climate Information System (PaCIS) Projects and Activities Worksheet Summaries</title>");
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/projects.css\" />");
		sb.append("<script type=\"text/javascript\" src=\"js/projects.js\"></script>");
		sb.append("</head>");
		sb.append("<body>");
		
		sb.append("<div id=\"pageContainer\">");
		sb.append("<div id=\"header\">");
	    sb.append("<div id=\"topNav\">");
	    sb.append("<ul id=\"topNavElements\">");
	    sb.append("<li id=\"topNavHome\"><a href=\"http://www.noaa.gov/index.html\" target=\"_blank\">NOAA HOME</a></li>");
		sb.append("<li id=\"topNavWeather\"><a href=\"http://www.noaa.gov/wx.html\" target=\"_blank\">WEATHER</a></li>");
		sb.append("<li id=\"topNavOceans\"><a href=\"http://www.noaa.gov/ocean.html\" target=\"_blank\">OCEANS</a></li>");
	    sb.append("<li id=\"topNavFisheries\"><a href=\"http://www.noaa.gov/fisheries.html\" target=\"_blank\">FISHERIES</a></li>");
        sb.append("<li id=\"topNavCharting\"><a href=\"http://www.noaa.gov/charts.html\" target=\"_blank\">CHARTING</a></li>");
	    sb.append("<li id=\"topNavSatellites\"><a href=\"http://www.noaa.gov/satellites.html\" target=\"_blank\">SATELLITES</a></li>");
	    sb.append("<li id=\"topNavClimate\"><a href=\"http://www.noaa.gov/climate.html\" target=\"_blank\">CLIMATE</a></li>");
	    sb.append("<li id=\"topNavResearch\"><a href=\"http://www.noaa.gov/research.html\" target=\"_blank\">RESEARCH</a></li>");
	    sb.append("<li id=\"topNavCoasts\"><a href=\"http://www.noaa.gov/coasts.html\" target=\"_blank\">COASTS</a></li>");
	    sb.append("<li id=\"topNavCareers\"><a href=\"http://www.careers.noaa.gov\" target=\"_blank\">CAREERS</a></li>");
	    sb.append("</ul>");
	    sb.append("</div>");
	    sb.append("<div id=\"headTitle\">");
	    sb.append("<a href=\"http://www.noaaideacenter.org/\" target=\"_blank\">");
	    sb.append("<img height=\"72\" width=\"611\" alt=\"Pacific Climate Information System (PaCIS)\" title=\"PaCIS\" src=\"images/noaapacislogo.jpg\"/>");
	    sb.append("</a>");
	    sb.append("<div style=\"position:absolute;top:15px;left:660px;font-size:1.4em;font-weight: bold;\">");
	    sb.append("<a href=\"projects\" style=\"text-decoration: none;color:red;\">Projects &amp; Activities Database</a>");
	    sb.append("<div style=\"font-size:.7em;font-weight:lighter;font-style:italic;font-variant:small-caps;color:red\">");
	    sb.append("Under active construction, <a href=\"javascript:window.location.reload()\">press F5</a><br />to refresh and see latest.");
	    sb.append("</div><!-- closes red coloring -->");
	    sb.append("</div><!-- Closes PADB Title -->");     
	    sb.append("</div><!-- Closes headitle -->");
	    sb.append("</div><!-- Closes div id=header -->");    
		 
	   sb.append("<!-- All open HTML elements below and above and including the div=pageContainer are closed in the common footer.jsp -->");


	   sb.append("<div id=\"contentArea\">");
	   sb.append("<table id=\"footerSiteMap\">");
       sb.append("<!-- This header can changed by request dispatcher servlet based on which jsp it is choosing to render  -->");
   	   sb.append("<tr>");
	   sb.append("<th class=\"boxHeader\" colspan=\"5\">PaCIS 2010 Projects and Activities</th>");
	   sb.append("</tr>");
 	   sb.append("<tr>");
	   sb.append("<td>");

	   sb.append("<div style=\"background-color: #C2F670;\">");
	   sb.append("The following projects in the Pacific region support NOAA climate services.");
	   sb.append("For further information, please contact the <a href=\"mailto:john.marra@noaa.gov\" title=\"National Oceanic and Atmospheric Administration (NOAA) Region Climate Services Director (RCSD)\">NOAA RCSD</a>.");
	   sb.append(" [Placeholder introduction]</div>");   

	  return sb.toString();
	}

	private String getFooter()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table><!-- end of table id=\"footerSiteMap\" -->");
		sb.append("<table id=\"footer\">");
		sb.append("<tr>");
		sb.append("<td align=\"center\">");
		sb.append("<img src=\"images/NOAA_climate_services_logo_footer.png\" title=\"climate.gov\"");
		sb.append("onmouseover=\"document.body.style.cursor='pointer';\" onmouseout=\"document.body.style.cursor='auto';\"");
		sb.append("alt=\"NOAA Climate Services logo\" onclick=\"javascript:window.open('http://www.climate.gov');\"/>");
		sb.append("</td>");
		sb.append("<td align=\"right\">");
		sb.append("<a href=\"http://www.noaa.gov/privacy.html\" title=\"Privacy Policy\" target=\"_blank\">Privacy");
		sb.append("Policy</a> |");
		sb.append("<a href=\"http://www.rdc.noaa.gov/~foia/\" title=\"FOIA\" target=\"_blank\">FOIA</a> |");
		sb.append("<a href=\"http://www.cio.noaa.gov/Policy_Programs/info_quality.html\" title=\"Information");
		sb.append("Quality\" target=\"_blank\">Information Quality</a> |");
		sb.append("<a href=\"http://www.noaa.gov/disclaimer.html\" title=\"Disclaimer\"");
		sb.append("target=\"_blank\">Disclaimer</a> |");
		sb.append("<a href=\"http://www.usa.gov\" title=\"USA.gov\" target=\"_blank\">USA.gov</a>  |");
		sb.append("<a href=\"http://www.ready.gov\" title=\"Ready.gov\" target=\"_blank\">Ready.gov</a> |");
		sb.append("<a href=\"mailto:ukari@noaa.gov\" title=\"Contact Webmaster\">Contact Webmaster</a>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table><!-- end of table id=footer -->");
		sb.append("</div><!-- End of Content Area -->");
		sb.append("</div><!-- End of Page Container -->");
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();
	}
	
	private String getMessageTable(StringBuffer msg)
	{
		StringBuffer sb = new StringBuffer();
		
		if (msg.length() > 0)
		{
			//sb.append("<a href=\"javascript:clearmsgs()\">Clear Messages</a>");
			sb.append("<table class=\"msgbox\">");
			//sb.append("<tr><th>");
  		//sb.append("<input type=\"submit\" value=\"Clear Messages\" onclick=\"clearmsgs()\"></input>");
			//sb.append("</th></tr>");
			sb.append("<tr><td>");
			sb.append(msg.toString());
			sb.append("</td></tr>");
			sb.append("</table>");
			
		}
		return sb.toString();
	}
	
	private String getProjectsListHTML()
	{
		//System.out.println("AddProjectServlet getProjectsListHTML()....");
		return getProjectsListHTML("project", "DESC");
	}
	private String getProjectsListHTML(String column, String order)
	{
		//System.out.println("AddProjectServlet.getPrjectsHTML filter = " + filter.toString());
		String html = parameterDAO.getProjectsListHTML(column, order, baseurl, filter);
		

		
        System.out.println("Filter FINISHED as = " + filter.toFilterString());
        //System.out.println("Filter Training FINISHED as, ParameterDAO.(Training) = " + ParameterDAO.parse(filter.getTraining()));
        //System.out.println("Filter Capability Area(s) FINISHED as = " + filter.getCapabilityAreas());

        //filter=new ProjectBean(); 
		return html;
	}
}
