<%@ include file="noCache.jsp" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>
<%@ page import="org.noaaideacenter.paws.Assessment" %>
<%@ page import="org.noaaideacenter.paws.ParameterDAO" %>

<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>


<jsp:useBean id="assessmentsBean" class="org.noaaideacenter.paws.Assessments" scope="session" />

<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%

 int browse = NumberUtils.toInt(request.getParameter("browse"));
  int search = NumberUtils.toInt(request.getParameter("search"));
boolean debug = ParameterDAO.parse(request.getParameter("debug"));


  String [] assessments     = request.getParameterValues("assessments");
  String [] applicabilities = request.getParameterValues("applicabilities");
  String [] focii           = request.getParameterValues("focii");
  String [] regions         = request.getParameterValues("regions");
  
   String text            = StringUtils.trimToEmpty(request.getParameter("textSrch"));


  List <Assessment> list = assessmentsBean.getList(assessments, applicabilities, focii, regions); 

  Iterator <Assessment> assesmentsListIterator = list.iterator();

  // set the "SELECTED" flags
  boolean assessment0 = false;
  boolean assessment1 = false;
  boolean assessment2 = false;
  boolean assessment3 = false;

  if (assessments != null && assessments.length > 0)
  {
    for (int i = 0; i < assessments.length; i++)
    {
      int assessment = NumberUtils.toInt(assessments[i]);
      switch (assessment) 
      {
        case 0: assessment0 = true;  break;
        case 1: assessment1 = true;  break;
        case 2: assessment2 = true;  break;
        case 3: assessment3 = true;  break;
      }
    }
  }

  boolean applicability0 = false;
  boolean applicability1 = false;
  boolean applicability2 = false;
  boolean applicability3 = false;

  if (applicabilities != null && applicabilities.length > 0)
  {
    for (int i = 0; i < applicabilities.length; i++)
    {
      int applicability = NumberUtils.toInt(applicabilities[i]);
      switch (applicability) 
      {
        case 0: applicability0 = true;  break;
        case 1: applicability1 = true;  break;
        case 2: applicability2 = true;  break;
        case 3: applicability3 = true;  break;
      }
    }
  }

  boolean focus0 = false;
  boolean focus1 = false;
  boolean focus2 = false;
  boolean focus3 = false;

  if (focii != null && focii.length > 0)
  {
    for (int i = 0; i < focii.length; i++)
    {
      int theFocus =  NumberUtils.toInt(focii[i]);
      switch (theFocus) 
      {
        case 0: focus0 = true;  break;
        case 1: focus1 = true;  break;
        case 2: focus2 = true;  break;
        case 3: focus3 = true;  break;
      }
    }
  }            


  boolean region0 = false;
  boolean region1 = false;
  boolean region2 = false;
  boolean region3 = false;
  boolean region4 = false;
            
  if (regions != null && regions.length > 0)
  {
    for (int i = 0; i < regions.length; i++)
    {
      int region =  NumberUtils.toInt(regions[i]);
      switch (region) 
      {
        case 0: region0 = true;  break;
        case 1: region1 = true;  break;
        case 2: region2 = true;  break;
        case 3: region3 = true;  break;
        case 4: region4 = true;  break;
      }
    }
  }
  
  String baseurl = application.getInitParameter("baseurl");

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
<head>
	<title>Projects and Activities - Assessments</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="description" content="PaCIS 2010 Projects and Activities" />
	<meta name="keywords" content="NOAA PaCIS PICCC RISA DOI Oceanic Atmospheric Pacific Climate Information System Change Research Assessment " />
	<meta name="robots" content="index, follow" />
	<link href='http://fonts.googleapis.com/css?family=Rosario:400,400italic' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="css/home.css" media="screen" />
	 
     
     <link href="js/SpryAccordion.css" rel="stylesheet" type="text/css" /> <!-- added by cameron -->
	 <script src="js/SpryAccordion.js" type="text/javascript"></script><!-- added by cameron -->
     
	
	
	<script type="text/javascript">
	
	function browseBy()
	{
	  document.bb.submit();
	}
	function searchBy()
{
  document.bb.search.value = 1;
  document.bb.submit();
}

	function resetBrowse()
	{
	  document.bb.action = 'assessments-test.jsp';
	  
	  var assessments = document.getElementById("assessments");
	  for (var i=0; i<assessments.options.length; i++) assessments.options[i].selected = false ;

	  var applicabilities = document.getElementById("applicabilities");
	  for (var i=0; i<applicabilities.options.length; i++) applicabilities.options[i].selected = false ;

	  var focii = document.getElementById("focii");
	  for (var i=0; i<focii.options.length; i++) focii.options[i].selected = false ;

	  var regions = document.getElementById("regions");
	  for (var i=0; i<regions.options.length; i++) regions.options[i].selected = false ;
	  
	  
	  document.bb.submit();
	}
	
	function resetText()
{
  document.bb.action = 'assessments-test.jsp?textSrch=';
  document.bb.submit();
}

function advancedSearch()
{
  alert('Advanced Search leads to Admin interface...leaving projects listing');
  document.bb.action = 'index.jsp?x=1';
  document.bb.submit();
}

function help()
{
  window.open('help.pdf');
}

function infoSubmit()
{
  alert('Please contact Eric Wong 808-944-7429 eric.wong@noaa.gov');
  /*
  alert('Advanced Search leads to Admin interface...leaving this projects listing');
  document.bb.action = 'index.jsp';
  document.bb.submit();
  */
}
	
</script>
</head>

<body>

<div id="mainContainer"> <!--keeps everything in one box -->
  
  
	<div id="header"><img src="images/pikogreenlogo.jpg" /></div>

<ul id="nav">
 <li><a href="home.jsp" title="home"><span>Home</span></a></li>
 <li><a href="dataproducts3.jsp" title="dnp"><span>Data &amp; Products</span></a></li>
 <li><a href="projects3.jsp" title="paws"><span>Projects &amp; Activities</span></a></li>
 <li id="nav-1"><a href="assessments3.jsp"><span>A S S E S S M E N T S</span></a></li>
 <li><a href="programs3.jsp" title="progs"><span>Partners &amp; Programs</span></a></li>
</ul>



<div id = "bodyContainer"> <!--added by cameron. this keeps the meat and potatoes beneath navigation and before footer contained together -->

<%
// DEBUG
if (debug)
{
  out.print("<br />browse by flag = " + browse);
  out.print("<br />search by flag = " + search);

  if (assessments != null && assessments.length > 0)
  {
    for (int i = 0; i <assessments.length; i++)
    {
      int assessment = NumberUtils.toInt(assessments[i]);
      out.print("<br />assessments[" + i + "] = " + assessment);
    }
  }
  else
  {
    out.print("<br />NO assessments");
  }
  
  if (applicabilities != null && applicabilities.length > 0)
  {
    for (int i = 0; i <applicabilities.length; i++)
    {
      int applicability = NumberUtils.toInt(applicabilities[i]);
      out.print("<br />applicabilities[" + i + "] = " + applicability);
    }
  }
  else
  {
    out.print("<br />NO applicabilities");
  }

  if (focii != null && focii.length > 0)
  {
    for (int i = 0; i < focii.length; i++)
    {
      int theFocus =  NumberUtils.toInt(focii[i]);
      out.print("<br />Focus[" + i + "] = " + theFocus);
    }
  }
  else
  {
    out.print("<br />NO capabilities");
  }

  if (regions != null && regions.length > 0)
  {
    for (int i = 0; i < regions.length; i++)
    {
      int region =  NumberUtils.toInt(regions[i]);
      out.print("<br />Region[" + i + "] = " + region);
    }
  }
  else
  {
    out.print("<br />NO regions");
  }
}

// END DEBUG


%>

<div id ="searchContainer"><!--added by cameron. this keeps the filter and the additional search features contained together -->

   <form name="bb" method="post" action="assessments3.jsp">
    <table width="750">
     <tr>
      <td width="175">
      By Assessment Type:<br />
       <select id="assessments" name="assessments"  width="175" onchange="javascript:browseBy();" style="width: 175px;font-size:11px;overflow: auto;">
        <option value="0" <% if (assessment0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (assessment1) out.print ("SELECTED"); %>>Climate Science</option>
        <option value="2" <% if (assessment2) out.print ("SELECTED"); %>>Needs and Capabilities</option>
        <option value="3" <% if (assessment3) out.print ("SELECTED"); %>>Risk and Vulnerability or Problem-Focused</option>
       </select>
      </td>
      <td width="175">
      By Area of Applicability:<br />
       <select id="applicabilities" name="applicabilities" width="175" onchange="javascript:browseBy();"  style="width: 175px;font-size:11px;overflow: auto;">
        <option value="0" <% if (applicability0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (applicability1) out.print ("SELECTED"); %>>International and National</option>
        <option value="2" <% if (applicability2) out.print ("SELECTED"); %>>National and Regional</option>
        <option value="3" <% if (applicability3) out.print ("SELECTED"); %>>Regional/Local or Problem-focused</option>
       </select>
      </td>
    
      <td width="175">
      By Focus Area:<br />
       <select id="focii" name="focii"   width="175" onchange="javascript:browseBy();" style="width: 175px;font-size:11px;overflow: auto;">
        <option value="0" <% if (focus0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (focus1) out.print ("SELECTED"); %>>Fresh Water Resources and Drought</option>
        <option value="2" <% if (focus2) out.print ("SELECTED"); %>>SLR/Coastal Inundation and Extreme Weather</option>
        <option value="3" <% if (focus3) out.print ("SELECTED"); %>>Marine and Terrestrial Ecosystems</option>
       </select>
      </td>
    
      <td width="175">
      By Region:<br />
       <select id="regions" name="regions"  width="175" onchange="javascript:browseBy();" style="width: 175px;font-size:11px;overflow: auto;">
        <option value="0" <% if (region0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (region1) out.print ("SELECTED"); %>>Central North Pacific (Hawaiian Islands)</option>
        <option value="2" <% if (region2) out.print ("SELECTED"); %>>Western North Pacific (Guam, CNMI, FSM, RMI, Palau)</option>
        <option value="3" <% if (region3) out.print ("SELECTED"); %>>South Pacific (American Samoa, Samoa, Tonga, Fiji, etc.)</option>
        <option value="4" <% if (region4) out.print ("SELECTED"); %>>Other</option>
       </select>
      </td>
     </tr>
     
    </table>
    
    
    
    
    <table width="750">
     <tr>
      <td width="150" class="title-blue">Advanced Search <input type="button" value="Go" onclick="javascript:advancedSearch();"></td>
  
    
      <td width="130"  class="title-blue">Help<input type="button" value="Go" onclick="javascript:help();"></td>

      <td  width="150" class="title-blue">Submit Information<input type="button" value="Go" onclick="javascript:infoSubmit();"></td>

    
        <td  width="260" class="title-blue">Text Search
          <input type="text" name="textSrch" size="20" value="<%= StringEscapeUtils.escapeHtml(text) %>" />
          <input type="button" value="Go" onclick="javascript:searchBy();" />
          <input type="button" value="Clear"  onclick="javascript:resetText();" /></td>
      </tr>
    </table>
<input type="hidden" name="browse" value="0" />
    <input type="hidden" name="search" value="0" />
   </form>
     
     
</div><!-- End of "searchContainer" -->
  
  
<div id = "container3"><!--added by cameron. contains the accordion. allows for padding on the top of the accordion to fit and look better on page-->
  
	
    <div id = "container2"><!--added by cameron. This contains the scroll css code. -->

		<div id="Accordion1" class="Accordion" tabindex="0"><!--added by cameron-->
        		
		<%
			while (assesmentsListIterator.hasNext())
			{
    		Assessment assessment = assesmentsListIterator.next();
		%>
   
   
  <div class="AccordionPanel"><!--added by cameron-->
 
    <div class="AccordionPanelTab"><!--added by cameron-->  
            
   <table class="project-box">
    <colgroup>
     <col class="title-blue" />
    </colgroup>
    <tr>
     <td width="80" style="width: 80px">Name</td>
     <td><%= assessment.getName() %></td>
    </tr>
    </table>
    </div> <!--tab-->
    
    
    
    <div class="AccordionPanelContent"><!--added by cameron-->
     
    		<table class="project-box">
			<colgroup>
			<col class="title-blue" />
			</colgroup>         
    
    <tr>
     <td>Description</td>
     <td><%= assessment.getDescription() %>&nbsp;&nbsp;(<a href="<%= baseurl  + assessment.getWorksheet() %>" target="_blank">More&hellip;</a>)</td>
    </tr>
    <tr>
     <td>Status</td>
     <td><%= assessment.getStatusText() %></td>
    </tr>
    <tr>
     <td>Assessment Type</td>
     <td><%= assessment.getTypes() %></td>
    </tr>
    <tr>
     <td>Area of Applicability</td>
     <td><%= assessment.getAreas() %></td>
    </tr>
    <tr>
     <td>Focus Area</td>
     <td><%= assessment.getFocusImages() %></td>
    </tr>
    <tr>
     <td>Region/Locale</td>
     <td><%= assessment.getRegion() %></td>
    </tr>
    <tr>
     <td>Agency</td>
     <td><a href="<%= assessment.getAgencyUrl() %>" target="_blank"><%= assessment.getAgency() %></a></td>
    </tr>
    <tr>
     <td>Contacts</td>
     <td><a href="mailto:<%= assessment.getEmail() %>"><%= assessment.getContact() %></a></td>
    </tr>
   </table>
   </div> <!--content-->
   </div><!--panel-->
			
			<%
			}
			%>
               
   </div><!--accordion-->
  </div><!--container 2-->
 
 		
</div><!--container3-->
        
        
         
	

</div><!--end of bodyContainer-->

  
 <script type="text/javascript"><!--added by cameron-->
<!--
var Accordion1 = new Spry.Widget.Accordion("Accordion1",{ useFixedPanelHeights: false, defaultPanel: -1 });
//-->
</script><!--added by cameron-->



</body>
</html>