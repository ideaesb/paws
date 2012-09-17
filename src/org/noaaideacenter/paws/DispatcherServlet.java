package org.noaaideacenter.paws;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This mock Spring paradigm servlet takes all the if-then logic 
 * discovered in AddProject and keeps it out of list servlet.   
 * Bottom line, this should be where all requests originate.  
 * @author kariu
 *
 */
public class DispatcherServlet 
{

	static final long serialVersionUID = 971L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	 throws ServletException, IOException 
	{
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	 throws ServletException, IOException 
	{
      
	}
}
