package org.noaaideacenter.paws;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 Servlet that serves binary data, not text.
  
 <P>This servlet serves a static .pdf file, but the idea is the same with other 
 forms of data.
*/

public class ServeBinaryServlet extends HttpServlet 
{
	static final long serialVersionUID = 111L;
	
	ServletConfig config ;
	
	  public void init(ServletConfig config)throws ServletException 
	  {
		    this.config = config;
		    super.init(config);
	  }
	  
	  @Override protected void doGet(
	    HttpServletRequest aRequest, HttpServletResponse aResponse
	  ) throws ServletException, IOException {
	    serveBinary(aRequest, aResponse);
	  }
	   
	  @Override protected void doPost(
	    HttpServletRequest aRequest, HttpServletResponse aResponse
	  ) throws ServletException, IOException {
	    serveBinary(aRequest, aResponse);
	  }
	  
	  // PRIVATE //
	  
	  private void serveBinary(HttpServletRequest aRequest, HttpServletResponse aResponse)  
	  {
			int project = NumberUtils.toInt(aRequest.getParameter("id"));
			String filename = StringUtils.trimToEmpty(aRequest.getParameter("file"));
			String wwwroot = config.getServletContext().getInitParameter("wwwroot");  // filesystem web-root
			
	   
	    //IMPORTANT: set the MIME type of the response stream
	    aResponse.setContentType("application/pdf");
	    
	    ServletOutputStream output = null; 
	    InputStream input =  null;
	    try 
	    { 
	      //serve a fixed file, located in the root folder of this web app
	      output = aResponse.getOutputStream();
	      System.out.println("getServletContext().getResourceAsStream(" + wwwroot + filename + ")");
	      input =  getServletContext().getResourceAsStream(wwwroot + filename);
	      //if raw bytes are already available, use this instead :
	      //InputStream inputBytes = new ByteArrayInputStream(myBytes);
	      
	      //transfer input stream to output stream, via a buffer
	      byte[] buffer = new byte[2048];
	      int bytesRead;    
	      while ((bytesRead = input.read(buffer)) != -1) 
	      {
	         output.write(buffer, 0, bytesRead);
	      }
	    }
	    catch (IOException ioe)
	    {
	    	// just proceed to fileUpload jsp, better render the More link according to whether the worksheet filename 
	    	// exists or not.  This would then be true fail-over, and not the primary gateway into fileUpload
	    	System.out.println("Cannot open worksheet for project  " + project + ": " + ioe);
	    	System.out.println("Redirecting to fileUpload - fix that more link (in database)");
	    	try
	    	{
	    	  aResponse.sendRedirect("fileUpload.jsp?id=" + project);
	    	}
	    	catch (Exception s)
	    	{
		    	System.out.println("Could not redirect to fileUpload.jsp EITHER!!! " + s);
	    	}
	    }
	    finally 
	    {
	      //close all streams
	      try
	      {
	        if (output != null) output.close();
	        if (input != null) input.close();
	      }
	      catch (Exception e)
	      {
	    	  System.out.println("Error closing file resources in ServeBinary Servlet " + e);
	      }
	    }
	    
	    System.out.println("Done serving file");
	  }
	}

