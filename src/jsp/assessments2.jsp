<%@ include file="noCache.jsp" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>
<%@ page import="org.noaaideacenter.paws.Assessment" %>

<jsp:useBean id="assessmentsBean" class="org.noaaideacenter.paws.Assessments" scope="session" />

<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%


  String [] assessments     = request.getParameterValues("assessments");
  String [] applicabilities = request.getParameterValues("applicabilities");
  String [] focii           = request.getParameterValues("focii");
  String [] regions         = request.getParameterValues("regions");

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
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" media="screen" />
	 
     
     <link href="js/SpryAccordion.css" rel="stylesheet" type="text/css" /> <!-- added by cameron -->
	 <script src="js/SpryAccordion.js" type="text/javascript"></script><!-- added by cameron -->
     
	
	
	<script type="text/javascript">
	
	function browseBy()
	{
	  document.bb.submit();
	}
	
	function resetBrowse()
	{
	  document.bb.action = 'assessments.jsp';
	  
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
	
	</script>
	
	
	
</head>

<body>

  
<div id="header">
  <img src="images/pikobanner.jpg" align="left" width="700" height="100"/>
</div>


<ul id="nav">
 <li><a href="home.jsp?frompage=assessments2.jsp" title="home"><span>Home</span></a></li>
  <li><a href="projects2.jsp" title="paws"><span>Projects &amp; Activities</span></a></li>
  <li id="nav-1"><a href="assessments2.jsp" title="asses"><span>A S S E S S M E N T S</span></a></li>
  <li><a href="programs2.jsp" title="progs"><span>Partners &amp; Programs</span></a></li>
</ul>
<br /><br />


<div id = "container"> <!--added by cameron-->
   
			<!--Right Column  start -->		
    
   
   
    <div id = "container3"><!--added by cameron-->
	
    <div id = "container2"><!--added by cameron-->

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
 
 			<!-- Column 1 end -->
	</div><!--container3-->
        
        
         
	<div id = "container1"><!--added by cameron-->
			<!-- Left Column  start -->
   <form name="bb" method="post" action="assessments.jsp">
    <table width="150">
     <tr>
      <td class="title-blue">Filter By</td>
     </tr>      
    </table>
    <table id="browse-box">
     <tr>
      <td>
      By Assessment Type:<br />
       <select id="assessments" name="assessments" multiple="multiple" size="4" width="350" onchange="javascript:browseBy();" style="width: 350px;font-size:11px;overflow: auto;">
        <option value="0" <% if (assessment0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (assessment1) out.print ("SELECTED"); %>>Climate Science</option>
        <option value="2" <% if (assessment2) out.print ("SELECTED"); %>>Needs and Capabilities</option>
        <option value="3" <% if (assessment3) out.print ("SELECTED"); %>>Risk and Vulnerability or Problem-Focused</option>
       </select>
      </td>
     </tr>
     <tr>
      <td>
      By Area of Applicability:<br />
       <select id="applicabilities" name="applicabilities" multiple="multiple" size="4" width="350" onchange="javascript:browseBy();"  style="width: 350px;font-size:11px;overflow: auto;">
        <option value="0" <% if (applicability0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (applicability1) out.print ("SELECTED"); %>>International and National</option>
        <option value="2" <% if (applicability2) out.print ("SELECTED"); %>>National and Regional</option>
        <option value="3" <% if (applicability3) out.print ("SELECTED"); %>>Regional/Local or Problem-focused</option>
       </select>
      </td>
     </tr>
     <tr>
      <td>
      By Focus Area:<br />
       <select id="focii" name="focii" multiple="multiple" size="4" width="350" onchange="javascript:browseBy();" style="width: 350px;font-size:11px;overflow: auto;">
        <option value="0" <% if (focus0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (focus1) out.print ("SELECTED"); %>>Fresh Water Resources and Drought</option>
        <option value="2" <% if (focus2) out.print ("SELECTED"); %>>SLR/Coastal Inundation and Extreme Weather</option>
        <option value="3" <% if (focus3) out.print ("SELECTED"); %>>Marine and Terrestrial Ecosystems</option>
       </select>
      </td>
     </tr>
     <tr>
      <td>
      By Region:<br />
       <select id="regions" name="regions" multiple="multiple" size="5" width="350" onchange="javascript:browseBy();" style="width: 350px;font-size:11px;overflow: auto;">
        <option value="0" <% if (region0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (region1) out.print ("SELECTED"); %>>Central North Pacific (Hawaiian Islands)</option>
        <option value="2" <% if (region2) out.print ("SELECTED"); %>>Western North Pacific (Guam, CNMI, FSM, RMS, Palau)</option>
        <option value="3" <% if (region3) out.print ("SELECTED"); %>>South Pacific (American Samoa, Samoa, Tonga, Fiji, etc.)</option>
        <option value="4" <% if (region4) out.print ("SELECTED"); %>>Other</option>
       </select>
      </td>
     </tr>
     
    </table>
    </form>
    <br /><br />
    
	</div><!--container1-->
</div><!--container-->
 
 <div id="footer">
 <marquee behavior="scroll" direction="left">
    <img src="images/NOAA-Transparent-Logo.png" width="50" height="50" onclick="javascript:window.open('http://www.noaa.gov')" />
    <img src="images/pacislogo.jpg" width="100" height="50" onclick="javascript:window.open('http://www.noaaclimatepacis.org')"/>
    <img src="images/Primo.jpg" width="100" height="50"/>
    <img src="images/Pacific Risa.jpg" width="125" height="50"/>
    <img src="images/piccc.png" width="125" height="50"/>
    <img src="images/DOI-Logo-Color-98.jpg" width="50" height="50"/>
    </marquee>
</div> 
   
 <script type="text/javascript"><!--added by cameron-->
<!--
var Accordion1 = new Spry.Widget.Accordion("Accordion1",{ useFixedPanelHeights: false, defaultPanel: -1 });
//-->
</script><!--added by cameron-->



</body>
</html>