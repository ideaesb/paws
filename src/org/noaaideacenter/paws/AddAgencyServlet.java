package org.noaaideacenter.paws;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;



public class AddAgencyServlet extends HttpServlet
{
	static final long serialVersionUID = 131L; 
		
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
		
  	  dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");
      parameterDAO.setDataSource(dataSource);
      
      String [] acronyms = new String [10];
      String [] descriptions = new String [10];
      
      acronyms[0] = StringUtils.trimToEmpty(request.getParameter("acronym1")); descriptions[0] = StringUtils.trimToEmpty(request.getParameter("description1"));  
      acronyms[1] = StringUtils.trimToEmpty(request.getParameter("acronym2")); descriptions[1] = StringUtils.trimToEmpty(request.getParameter("description2"));  
      acronyms[2] = StringUtils.trimToEmpty(request.getParameter("acronym3")); descriptions[2] = StringUtils.trimToEmpty(request.getParameter("description3"));  
      acronyms[3] = StringUtils.trimToEmpty(request.getParameter("acronym4")); descriptions[3] = StringUtils.trimToEmpty(request.getParameter("description4"));  
      acronyms[4] = StringUtils.trimToEmpty(request.getParameter("acronym5")); descriptions[4] = StringUtils.trimToEmpty(request.getParameter("description5"));  
      acronyms[5] = StringUtils.trimToEmpty(request.getParameter("acronym6")); descriptions[5] = StringUtils.trimToEmpty(request.getParameter("description6"));  
      acronyms[6] = StringUtils.trimToEmpty(request.getParameter("acronym7")); descriptions[6] = StringUtils.trimToEmpty(request.getParameter("description7"));  
      acronyms[7] = StringUtils.trimToEmpty(request.getParameter("acronym8")); descriptions[7] = StringUtils.trimToEmpty(request.getParameter("description8"));  
      acronyms[8] = StringUtils.trimToEmpty(request.getParameter("acronym9")); descriptions[8] = StringUtils.trimToEmpty(request.getParameter("description9"));  
      acronyms[9] = StringUtils.trimToEmpty(request.getParameter("acronym10")); descriptions[9] = StringUtils.trimToEmpty(request.getParameter("description10"));  
      
      try
      {
    	  parameterDAO.addAgencies(acronyms, descriptions);
      }
 	  catch (Exception e)
      {
   	    msg.append("A B O R T.  The following database error has occured:<br />");
   	    msg.append("<strong><span style=\"background-color: #FFFF00\">" +e+"</span></strong><br />");
   	  }
   	  finally
   	  {
 		// success or failure
   		msg.append("Add Agencies Completed<br />");
      }
      
   		// @TO DO pass this message along go to projects listing, where the upper-most projects should be the new one
   		request.setAttribute("msg", msg.toString());
   		request.setAttribute("addagencies", "true");
   		request.getRequestDispatcher("projects").include(request, response);
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
