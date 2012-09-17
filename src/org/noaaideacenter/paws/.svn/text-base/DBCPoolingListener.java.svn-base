package org.noaaideacenter.paws;

import javax.naming.*;
import javax.servlet.*;
import javax.sql.*;

public class DBCPoolingListener	implements ServletContextListener
{
	 public void contextInitialized (ServletContextEvent sce)
	 {

  	  try 
  	  {
	       // Obtain our environment naming context
	        Context envCtx = (Context) new InitialContext().
	        lookup("java:comp/env");

	       //  Look up our data source
	        DataSource  ds = (DataSource) envCtx.lookup ("jdbc/pawsdb");

	      sce.getServletContext().setAttribute("DBCPool", ds);
	   } 
  	  catch(NamingException e)
	   { 
	  	 e.printStackTrace();
	    }
	 }
	 
	 public void contextDestroyed(ServletContextEvent	 sce)
	 {
		 System.out.println("DBCPPoolingListner Destroyed " + sce.toString());
	 }

}
