package org.noaaideacenter.paws;

import java.io.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;

public class CodeGenerator
{
	 /**
	  * Fetch the entire contents of a text file, and return it in a String.
	  * This style of implementation does not throw Exceptions to the caller.
	  *
	  * @param aFile is a file which already exists and can be read.
	  */
	  static public String getSelectBoxCode(File aFile) {
	    //...checks on aFile are elided
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        int counter=1;
	        while (( line = input.readLine()) != null)
	        {
	        	String [] tokens = StringUtils.split(line);
	        	
	          contents.append("                                                             ");
            contents.append("<option VALUE=\"");
	          contents.append(counter);
	          contents.append("\">");
	          contents.append(StringUtils.trim(tokens[0]));
	          contents.append(": ");
	          StringBuffer sb = new StringBuffer();
	          for (int i=1 ; i < tokens.length; i++)
	          {
	          	if (i > 1) sb.append(" ");
	          	sb.append(StringUtils.trim(tokens[i]));
	          }
	          
	          contents.append(sb.toString());
	          //contents.append(StringUtils.left(sb.toString(),50));
	          contents.append(System.getProperty("line.separator"));
	          counter++;
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }
	  static public String getSelectBoxCodeByComma(File aFile) {
	    //...checks on aFile are elided
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        int counter=1;
	        while (( line = input.readLine()) != null)
	        {
	        	String [] tokens = StringUtils.split(line, ',');

	        	if (tokens == null)
	        	{
	        		// do nothing...split is allowed to return null
	        	}
	        	else if (tokens.length < 2)
	        	{
	        		// do nothing: must have at least two tokens, comma-separated
	        	}
	        	else if (StringUtils.isNotBlank(tokens[0]))
	        	{
  	          contents.append("                                                             ");
              contents.append("<option VALUE=\"");
  	          contents.append(counter);
  	          contents.append("\">");
  	          contents.append(tokens[0]);  // acronym
  	          contents.append(": ");
  	          contents.append(StringUtils.trim(StringUtils.remove(tokens[1],"\""))); // name with quotes removed
  	          contents.append("</OPTION>");
  	          contents.append(System.getProperty("line.separator"));
  	          counter++;
	        	}
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }

	  static public String getCheckedList(File aFile) 
	  {
	    //...checks on aFile are elided
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        while (( line = input.readLine()) != null)
	        {
	        	  String beanProperty = StringUtils.trimToEmpty(line);
	        	  
	        	  contents.append("String ");
  	          contents.append(beanProperty);
              contents.append(" = ");
              contents.append("ParameterDAO.getCheckedStatus(");
  	          contents.append("pb.get");
  	          contents.append(StringUtils.capitalize(beanProperty));
  	          contents.append("());");
  	          contents.append(System.getProperty("line.separator"));
	        }
	      }
	      finally 
	      {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }

	  static public String getSQL(File aFile) {
	    //...checks on aFile are elided
	    StringBuilder contents = new StringBuilder();
	    // System.out.println("Got past StringBuilder contents = new StringBuilder();");
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        int counter=1;
	  	    //System.out.println("counter = " + counter);
	        while (( line = input.readLine()) != null)
	        {
	        	//System.out.println("line # " + counter + " = " + line);
	        	String [] tokens = StringUtils.split(line,',');
	        	if (tokens == null)
	        	{
	        		// do nothing...split is allowed to return null
	        	}
	        	else if (tokens.length < 2)
	        	{
	        		// do nothing: must have at least two tokens, comma-separated
	        	}
	        	else if (StringUtils.isNotBlank(tokens[0]))
	        	{
  	          contents.append("INSERT INTO ORGANIZATIONS (acronym, description) VALUES ('");
  	          contents.append(StringUtils.trim(tokens[0]));
  	          contents.append("','");
  	          contents.append(StringUtils.trim(tokens[1]));
  	          contents.append("');");
  	          contents.append(System.getProperty("line.separator"));
	        	}
	          counter++;
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }

	  static public String getJSPTags(File aFile) {
	    //...checks on aFile are elided
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        while (( line = input.readLine()) != null)
	        {
	        	  String property = StringUtils.trim(line);
	        	  
  	          contents.append("<jsp:setProperty name=\"ProjectBean\" property=\"");
              contents.append(property);
  	          contents.append("\"  value='<%= request.getParameter(\"");               
  	          contents.append(property);
              contents.append("\") %>'/>");
  	          contents.append(System.getProperty("line.separator"));
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }

	  static public String getRequests(File aFile) {
	    //...checks on aFile are elided
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        while (( line = input.readLine()) != null)
	        {
	        	  String property = StringUtils.trim(line);
	        	  String beanMethod = "pb.set" + StringUtils.capitalize(property) + "";
	        	  contents.append(beanMethod+"(request.getParameter(\"" + property + "\"));");
  	          contents.append(System.getProperty("line.separator"));
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }

	  
	  static public String getHeader(File aFile) {
		    //...checks on aFile are elided
		    StringBuilder contents = new StringBuilder();
		    
		    try {
		      //use buffering, reading one line at a time
		      //FileReader always assumes default encoding is OK!
		      BufferedReader input =  new BufferedReader(new FileReader(aFile));
		      try {
		        String line = null; //not declared within while loop
		        /*
		        * readLine is a bit quirky :
		        * it returns the content of a line MINUS the newline.
		        * it returns null only for the END of the stream.
		        * it returns an empty String if two newlines appear in a row.
		        */
		        while (( line = input.readLine()) != null)
		        {
		        	if (StringUtils.isNotBlank(line))
		        	{
		        		String trimmed = StringUtils.trimToEmpty(line);
		        		String replacedQuotes = StringEscapeUtils.escapeJava(trimmed);
		        		contents.append("sb.append(\"" + replacedQuotes + "\");");
		        		contents.append(System.getProperty("line.separator"));
		        	}
		        }
		      }
		      finally {
		        input.close();
		      }
		    }
		    catch (IOException ex){
		      ex.printStackTrace();
		    }
		    
		    return contents.toString();
		  }

	  
	  
	  /**
	 * @param args
	 */
	public static void main(String[] args)
	{
	  //System.out.print(CodeGenerator.getSelectBoxCodeByComma(new File("c:/users/uday/documents/work/PaCIS PNA_acronyms_11.11.10.csv")));		
	  //System.out.print(CodeGenerator.getSQL(new File("c:/users/uday/documents/work/PaCIS PNA_acronyms_11.11.10.csv")));
		//System.out.println(CodeGenerator.getJSPTags(new File("c:/users/uday/documents/work/varlist.txt")));
		//System.out.println(CodeGenerator.getRequests(new File("c:/users/uday/documents/work/varlist.txt")));
		//System.out.println(CodeGenerator.getCheckedList(new File("c:/users/uday/documents/work/varlist.txt")));
		System.out.println(CodeGenerator.getHeader(new File("c:/jwork/paws/src/jsp/footer.jsp")));
	}
	
}
