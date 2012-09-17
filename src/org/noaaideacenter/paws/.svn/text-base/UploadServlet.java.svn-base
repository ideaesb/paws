package org.noaaideacenter.paws;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FilenameUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.*; 
import java.io.File;
import java.io.IOException;
import java.lang.Exception; 

public class UploadServlet extends HttpServlet
{
	static final long serialVersionUID = 121L;
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
	
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		boolean isDap = false; 
		int project = 0; boolean dap = false;
		String wwwroot = config.getServletContext().getInitParameter("wwwroot");  // filesystem web-root
		StringBuffer msg = new StringBuffer();
		
		if (isMultipart)
		{
			// upload the file, that is, parse it out of the http request
			// place it in the directory in wwwroot/paworksheets (NOT paws or padb which are jk-mounted), 
			// reading web-root from web.xml or some properties file - different builds for local, test and prod.   
			// make sure youu close out all temporary resources
			// update the project work sheet file name field 
			// return an acknowledgment to the user...in the msg  
			// make sure to activate the More link to stream the filename if it exists or to lead to file-upload page
			System.out.println("isMultipart...");
			
			// Straight from the manual
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			try
			{
			  List <FileItem> items = upload.parseRequest(request);
			  
			  // Process the uploaded items
			  Iterator <FileItem>iter = items.iterator();
			  while (iter.hasNext()) 
			  {
			      FileItem item = (FileItem) iter.next();
	    	    String fieldName = item.getFieldName();

			      if (item.isFormField()) 
			      {
			         System.out.println("JOKE: What is a plain vanilla form field doing here???" + item.getFieldName() + " = " + item.getString());
			         if (StringUtils.equalsIgnoreCase(fieldName, "id"))
			         {
			           project = NumberUtils.toInt(item.getString());
			         }
			         else if (StringUtils.equalsIgnoreCase(fieldName, "dap"))
			         {
			           isDap = ParameterDAO.parse(item.getString());
			         }
			      } 
			      else 
			      {
			    	    String fileNombre = item.getName();
			    	    String contentType = item.getContentType();
			    	    boolean isInMemory = item.isInMemory();
			    	    String isNotInMemory = "is NOT in memory";
			    	    if (isInMemory) isNotInMemory = "is in memory";
			    	    long sizeInBytes = item.getSize();
			    	    
			    	    String purefilename =  FilenameUtils.getName(fileNombre); 

			    	    System.out.println("Received for upload from form field =" + fieldName + ", file = " + fileNombre + ", contentType = " + contentType + " (" + isNotInMemory + "), size(bytes) = " + sizeInBytes);
			    	    
			    	    System.out.println("Writing to " + wwwroot + purefilename);
			    	    
			    	    File uploadedFile = new File(wwwroot + purefilename);
			    	    item.write(uploadedFile);
			    	    System.out.println("Success...now updating project " + project);
			    	    
			    	    ParameterDAO parameterDAO = new ParameterDAO();
			    	    parameterDAO.setDataSource( (DataSource) request.getSession().getServletContext().getAttribute("DBCPool") );
			    	    
			    	    ProjectBean pb = parameterDAO.getJustOneProject(project);
			    	    int newproj = -1;
			    	    if (pb.getProjectnumber() == project)
			    	    {
			    	      pb.setParameterDAO(parameterDAO);
			    	      pb.setWorksheetfilename(purefilename);  
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
			    			  	      msg.append("</span></strong> was U P D A T E D  with new worksheet filename = " + purefilename + "<br />");
			    	    		}
			    	    	    else
			    	    		{
			    	    				msg.append("F A I L E D to Update WORKSHEET for Project " + pb.getProjectname()); 
			    	    		}
			    	   	  }
			    	    }
			    	    else
			    	    {
			    	    
			    		  msg.append(purefilename + " COULD NOT be added to Project " + pb.getProjectname() + "(???), could not retrieve project internal id " + project + "<br />");
			    		  
			    	    }

			      }
			  }
			}
			catch (FileUploadException f)
			{
			  System.err.println("Could not PARSE the file upload request " + f);
			  msg.append("Could not PARSE the file upload request " + f);
		    }
			catch (Exception e)
			{
				  System.err.println("Could not WRITE the file to disk " + e);
				  msg.append("Could not WRITE the file to disk " + e);
			}
			finally
			{

	    		request.setAttribute("msg", msg.toString());
				request.setAttribute("uploadedfile", "true");
				if (isDap)
				{
	       		  request.getRequestDispatcher("dataproducts").include(request, response);
				}
				else
				{
	       		  request.getRequestDispatcher("projects").include(request, response);
				}
				
				//response.getWriter().print(msg.toString());

			}
			
			
			
			
		}
		else if (project > 0)
		{
			// request if not multipart, the seervlet was accessed  came from the more link of description or even directly
			// meaning it came here with a project id but no file payload, simply forward to fileUpload.jsp
            response.sendRedirect("fileUpload.jsp?id=" + project);
		}
		else
		{
			// no file payload, no project id 
			// just go to the projects page
			response.sendRedirect("projects");
		}
		
	}

}
