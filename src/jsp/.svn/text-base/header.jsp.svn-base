<%--
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// header.jsp 
//  
//  Parameters:  1) stylesheet,  e.g.  "list.css"
//               2) scriptfile, e.g.  "list.js"
//         
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="noCache.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>

<%@ page import="org.noaaideacenter.paws.ParameterDAO" %>
<%@ page import="org.noaaideacenter.paws.ProjectBean" %>

<%

    String includedStyle  = StringUtils.trimToEmpty(request.getParameter("stylesheet"));
    String includedScript = StringUtils.trimToEmpty(request.getParameter("scriptfile"));
    String headerTitle    = StringUtils.trimToEmpty(request.getParameter("titlebar"));

%>
<%!
    /////////////////////////////////////////////////////////////////////////////
    // add as many HTML space tags (&nbsp;) between form elements like checkboxes 
    // as needed to make Projects Worksheet look like the one passed out at 
    // the September 2010 meeting

    public String addSpaceTags(int numberOfTags)
    {
      return ParameterDAO.getHTMLSpaceChar(numberOfTags);
    }

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
 <head>
  <title>Pacific  Climate Information System (PaCIS)</title>
  <link rel="stylesheet" type="text/css" href="css/<%= includedStyle %>" />
  <script type="text/javascript" src="js/<%= includedScript %>"></script>
 </head>
<body>
<div id="container">

 <div id="header">

   <div id="noaalogo">
    <a href="http://www.noaa.gov" target="_blank">
     <img alt="National Oceanic and Atmospheric Administration" title="NOAA" src="images/ncs_logo.png" />
    </a>
   </div>
   

  
  <div id="pacislogo">
   <div id="pacislogobufferLeft">&nbsp;</div> 
    <a href="http://www.noaaideacenter.org/" target="_blank">
     <img alt="Pacific Climate Information System (PaCIS)" title="PaCIS" src="images/pacislogo.jpg"/>
    </a>
  </div>


   <div id="rightelements">

     
   <div id="projectName">
    Projects &amp; Activities Database
    <div id="underConstruction">
     Under active construction, <a href="javascript:window.location.reload()">press F5</a><br />to refresh and see latest.
    </div>
   </div>
    

   <div id="doclogo">
    <a href="http://www.doc.gov" target="_blank">
     <img alt="Department of Commerce" title="DOC" src="images/commerce.png" />
    </a>
   </div>
    
   </div>

 </div>
  
 <div id="titleBar"><%= headerTitle %></div>

 
 <div id="content">

