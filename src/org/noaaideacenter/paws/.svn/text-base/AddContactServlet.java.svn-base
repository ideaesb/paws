package org.noaaideacenter.paws;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;


public class AddContactServlet extends HttpServlet
{
	static final long serialVersionUID = 191L; 
		
	ProjectBean pb = new ProjectBean();  // dummy project to scrub request parameters
	StringBuffer msg = new StringBuffer();
	ParameterDAO parameterDAO = new ParameterDAO();
	
  DataSource dataSource;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		init(response); 		
		
  	int project = NumberUtils.toInt(request.getParameter("id"));
  	int newproj = -1;
  	
  	if (project > 0)
  	{
  	  dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");
      parameterDAO.setDataSource(dataSource);
      pb = parameterDAO.getJustOneProject(project);
      pb.setParameterDAO(parameterDAO);
      setProjectBean(request);
      try
      {
      	parameterDAO.deleteProject(project, true);
      	newproj = pb.insert();
      }
   		catch (Exception e)
   		{
   	    msg.append("A B O R T.  The following database error has occured:<br />");
   	    msg.append("<strong><span style=\"background-color: #FFFF00\">" +e+"</span></strong><br />");
   		}
   		finally
   		{
 				// success
   			if (newproj > project)
   			{
 				  msg.append("Project <strong><span style=\"background-color: #FFFF00\">" + pb.getProjectname());
		  	  msg.append("</span></strong> was U P D A T E D <br />");
    		}
    	  else
    		{
    				msg.append("F A I L E D to Update CONTACTS for Project " + pb.getProjectname()); 
    		}
    	}
      
   		// @TO DO pass this message along go to projects listing, where the upper-most projects should be the new one
   		request.setAttribute("msg", msg.toString());
   		request.setAttribute("addcontacts", "true");
   		request.getRequestDispatcher("projects").include(request, response);
  	}
  	else
  	{
  		response.sendRedirect("index.jsp");
  	}
 
	}
	private void setProjectBean(HttpServletRequest request)
	{
		
		String [] contacts = new String [30]; String [] emails = new String [30];
		
		contacts[0] = StringUtils.trimToEmpty(request.getParameter("contact1"));  
		contacts[1] = StringUtils.trimToEmpty(request.getParameter("contact2"));
		contacts[2] = StringUtils.trimToEmpty(request.getParameter("contact3"));
		contacts[3] = StringUtils.trimToEmpty(request.getParameter("contact4"));  
		contacts[4] = StringUtils.trimToEmpty(request.getParameter("contact5"));
		contacts[5] = StringUtils.trimToEmpty(request.getParameter("contact6"));
		contacts[6] = StringUtils.trimToEmpty(request.getParameter("contact7"));  
		contacts[7] = StringUtils.trimToEmpty(request.getParameter("contact8"));
		contacts[8] = StringUtils.trimToEmpty(request.getParameter("contact9"));
		contacts[9] = StringUtils.trimToEmpty(request.getParameter("contact10"));  
		contacts[10] = StringUtils.trimToEmpty(request.getParameter("contact11"));
		contacts[11] = StringUtils.trimToEmpty(request.getParameter("contact12"));
		contacts[12] = StringUtils.trimToEmpty(request.getParameter("contact13"));  
		contacts[13] = StringUtils.trimToEmpty(request.getParameter("contact14"));
		contacts[14] = StringUtils.trimToEmpty(request.getParameter("contact15"));
		contacts[15] = StringUtils.trimToEmpty(request.getParameter("contact16"));  
		contacts[16] = StringUtils.trimToEmpty(request.getParameter("contact17"));
		contacts[17] = StringUtils.trimToEmpty(request.getParameter("contact18"));
		contacts[18] = StringUtils.trimToEmpty(request.getParameter("contact19"));  
		contacts[19] = StringUtils.trimToEmpty(request.getParameter("contact20"));
		contacts[20] = StringUtils.trimToEmpty(request.getParameter("contact21"));
		contacts[21] = StringUtils.trimToEmpty(request.getParameter("contact22"));  
		contacts[22] = StringUtils.trimToEmpty(request.getParameter("contact23"));
		contacts[23] = StringUtils.trimToEmpty(request.getParameter("contact24"));
		contacts[24] = StringUtils.trimToEmpty(request.getParameter("contact25"));  
		contacts[25] = StringUtils.trimToEmpty(request.getParameter("contact26"));
		contacts[26] = StringUtils.trimToEmpty(request.getParameter("contact27"));
		contacts[27] = StringUtils.trimToEmpty(request.getParameter("contact28"));  
		contacts[28] = StringUtils.trimToEmpty(request.getParameter("contact29"));
		contacts[29] = StringUtils.trimToEmpty(request.getParameter("contact30"));
		
		emails[0] = StringUtils.trimToEmpty(request.getParameter("email1"));  
		emails[1] = StringUtils.trimToEmpty(request.getParameter("email2"));
		emails[2] = StringUtils.trimToEmpty(request.getParameter("email3"));
		emails[3] = StringUtils.trimToEmpty(request.getParameter("email4"));  
		emails[4] = StringUtils.trimToEmpty(request.getParameter("email5"));
		emails[5] = StringUtils.trimToEmpty(request.getParameter("email6"));
		emails[6] = StringUtils.trimToEmpty(request.getParameter("email7"));  
		emails[7] = StringUtils.trimToEmpty(request.getParameter("email8"));
		emails[8] = StringUtils.trimToEmpty(request.getParameter("email9"));
		emails[9] = StringUtils.trimToEmpty(request.getParameter("email10"));  
		emails[10] = StringUtils.trimToEmpty(request.getParameter("email11"));
		emails[11] = StringUtils.trimToEmpty(request.getParameter("email12"));
		emails[12] = StringUtils.trimToEmpty(request.getParameter("email13"));  
		emails[13] = StringUtils.trimToEmpty(request.getParameter("email14"));
		emails[14] = StringUtils.trimToEmpty(request.getParameter("email15"));
		emails[15] = StringUtils.trimToEmpty(request.getParameter("email16"));  
		emails[16] = StringUtils.trimToEmpty(request.getParameter("email17"));
		emails[17] = StringUtils.trimToEmpty(request.getParameter("email18"));
		emails[18] = StringUtils.trimToEmpty(request.getParameter("email19"));  
		emails[19] = StringUtils.trimToEmpty(request.getParameter("email20"));
		emails[20] = StringUtils.trimToEmpty(request.getParameter("email21"));
		emails[21] = StringUtils.trimToEmpty(request.getParameter("email22"));  
		emails[22] = StringUtils.trimToEmpty(request.getParameter("email23"));
		emails[23] = StringUtils.trimToEmpty(request.getParameter("email24"));
		emails[24] = StringUtils.trimToEmpty(request.getParameter("email25"));  
		emails[25] = StringUtils.trimToEmpty(request.getParameter("email26"));
		emails[26] = StringUtils.trimToEmpty(request.getParameter("email27"));
		emails[27] = StringUtils.trimToEmpty(request.getParameter("email28"));  
		emails[28] = StringUtils.trimToEmpty(request.getParameter("email29"));
		emails[29] = StringUtils.trimToEmpty(request.getParameter("email30"));
		
		pb.setContactName(contacts);  pb.setEmailsAddress(emails);
		pb.setContactList();
		
		
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
		msg.delete(0, msg.length());
	}

}
