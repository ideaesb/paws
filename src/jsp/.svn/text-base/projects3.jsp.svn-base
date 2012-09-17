<%@ include file="noCache.jsp" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="org.noaaideacenter.paws.ProjectBean" %>
<%@ page import="org.noaaideacenter.paws.ParameterDAO" %>


<jsp:useBean id="projects" class="org.noaaideacenter.paws.Projects" scope="session" />

<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" %>


<%

  DataSource dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");

  int browse = NumberUtils.toInt(request.getParameter("browse"));
  int search = NumberUtils.toInt(request.getParameter("search"));

  boolean debug = ParameterDAO.parse(request.getParameter("debug"));


  String [] capabilities = request.getParameterValues("capabilities");
  String [] focus        = request.getParameterValues("focus");
  String [] regions      = request.getParameterValues("regions");

  String text            = StringUtils.trimToEmpty(request.getParameter("textSrch"));


  List <ProjectBean> list = null;

  if (browse == 1)
  {
    list = projects.getList(dataSource, capabilities, focus, regions);
  }
  else if (search == 1)
  {
    list = projects.getList(dataSource, text);
  }
  else
  {
    list = projects.getList(dataSource);
  }

  Iterator <ProjectBean> projectsListIterator = list.iterator();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
<head>
<title>Projects and Activities</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="PaCIS 2010 Projects and Activities" />
<meta name="keywords" content="NOAA PaCIS PICCC RISA DOI Oceanic Atmospheric
Pacific Climate Information System Change Research Assessment " />
<meta name="robots" content="index, follow" />
<link href='http://fonts.googleapis.com/css?family=Rosario:400,400italic' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/home.css" media="screen" />
<link href="js/SpryAccordion.css" rel="stylesheet" type="text/css" />
<script src="js/SpryAccordion.js" type="text/javascript"></script>
<script type="text/javascript">

function browseBy()
{
  document.bb.browse.value = 1;
  document.bb.submit();
}

function searchBy()
{
  document.bb.search.value = 1;
  document.bb.submit();
}

function resetBrowse()
{
  document.bb.action = 'projects3.jsp';

  var capabilities = document.getElementById("capabilities");
  for (var i=0; i<capabilities.options.length; i++) capabilities.options[i].selected = false ;

  var focii = document.getElementById("focii");
  for (var i=0; i<focii.options.length; i++) focii.options[i].selected = false ;

  var regions = document.getElementById("regions");
  for (var i=0; i<regions.options.length; i++) regions.options[i].selected = false ;


  document.bb.submit();
}

function resetText()
{
  document.bb.action = 'projects3.jsp?textSrch=';
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
	  <li><a href="home.jsp" title="home"><span>&nbsp;Home</span></a></li>
      <li><a href="dataproducts3.jsp" title="dnp"><span>Data &amp; Products</span></a></li>
	  <li id="nav-1"><a href="projects3.jsp"><span>P R O J E C T S&nbsp;&amp;&nbsp;A C T I V I T I E S</span></a></li>
	  <li><a href="assessments3.jsp" title="asses"><span>Assessments</span></a></li>
	  <li><a href="programs3.jsp" title="progs"><span>Partners &amp; Programs</span></a></li>
	</ul>

<!--
<div class="animatedtabs">
<ul>
<li class="selected"><a href="projects.jsp" title="paws"><span>Projects &amp; Activities</span></a></li>
<li><a href="assessments.jsp" title="asses"><span>Assessments</span></a></li>
<li><a href="PaCIS%20Partners%20%26%20Programs.pdf" target="_blank" title="progs"><span>Partners &amp; Programs</span></a></li>
</ul>
</div>
-->

<div id = "bodyContainer"> <!--added by cameron. this keeps the meat and potatoes beneath navigation and before footer contained together -->


<%
// DEBUG
if (debug)
{
  out.print("<br />browse by flag = " + browse);
  out.print("<br />search by flag = " + search);

  if (capabilities != null && capabilities.length > 0)
  {
    for (int i = 0; i < capabilities.length; i++)
    {
      int capability = NumberUtils.toInt(capabilities[i]);
      out.print("<br />Capabilities[" + i + "] = " + capability);
    }
  }
  else
  {
    out.print("<br />NO capabilities");
  }

  if (focus != null && focus.length > 0)
  {
    for (int i = 0; i < focus.length; i++)
    {
      int theFocus =  NumberUtils.toInt(focus[i]);
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

// set the "SELECTED" flags
boolean capability0 = false;
boolean capability1 = false;
boolean capability2 = false;
boolean capability3 = false;
boolean capability4 = false;
boolean capability5 = false;
boolean capability6 = false;

if (capabilities != null && capabilities.length > 0)
{
  for (int i = 0; i < capabilities.length; i++)
  {
    int capability = NumberUtils.toInt(capabilities[i]);
    switch (capability)
    {
      case 0: capability0 = true;  break;
      case 1: capability1 = true;  break;
      case 2: capability2 = true;  break;
      case 3: capability3 = true;  break;
      case 4: capability4 = true;  break;
      case 5: capability5 = true;  break;
      case 6: capability6 = true;  break;
    }
  }
}

boolean focus0 = false;
boolean focus1 = false;
boolean focus2 = false;
boolean focus3 = false;

if (focus != null && focus.length > 0)
{
  for (int i = 0; i < focus.length; i++)
  {
    int theFocus =  NumberUtils.toInt(focus[i]);
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


<div id ="searchContainer"><!--added by cameron. this keeps the filter and the additional search features contained together -->

<form name="bb" method="post" action="projects3.jsp">
   <table width="750">
   <tr>
   <td width="245">
      By Capability:<br />
       <select id="capabilities" name="capabilities" width="245" onchange="javascript:browseBy();" style="width:245px;font-size:11px;overflow: auto;">
        <option value="0" <% if (capability0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (capability1) out.print ("SELECTED"); %>>Outreach, Education, Training and Capacity Building</option>
        <option value="2" <% if (capability2) out.print ("SELECTED"); %>>Observing Systems, Data Stewardship, and Data Services</option>
        <option value="3" <% if (capability3) out.print ("SELECTED"); %>>Understanding and Predicting Climate Change and Variability</option>
        <option value="4" <% if (capability4) out.print ("SELECTED"); %>>Understanding Climate Impacts and Informing Adaptation</option>
        <option value="5" <% if (capability5) out.print ("SELECTED"); %>>Policies and Legislation</option>
        <option value="6" <% if (capability6) out.print ("SELECTED"); %>>Assessment and Evaluation</option>
       </select>
   </td>
   <td width="245">
      By Focus Area:<br />
       <select id="focii" name="focus"  width="245" onchange="javascript:browseBy();"  style="width:245px;font-size:11px;overflow: auto;">
        <option value="0" <% if (focus0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (focus1) out.print ("SELECTED"); %>>Fresh Water Resources and Drought</option>
        <option value="2" <% if (focus2) out.print ("SELECTED"); %>>SLR/Coastal Inundation and Extreme Weather</option>
        <option value="3" <% if (focus3) out.print ("SELECTED"); %>>Marine and Terrestrial Ecosystems</option>
       </select>
      </td>
      <td width="245">
        By Region:<br />
        <select id="regions" name="regions" width="245" onchange="javascript:browseBy();" style="width:245px;font-size:11px;overflow: auto;">
          <option value="0" <% if (region0) out.print ("SELECTED"); %>>All</option>
          <option value="1" <% if (region1) out.print ("SELECTED"); %>>Central North Pacific (Hawaiian Islands)</option>
          <option value="2" <% if (region2) out.print ("SELECTED"); %>>Western North Pacific (Guam, CNMI, FSM, RMI, Palau)</option>
          <option value="3" <% if (region3) out.print ("SELECTED"); %>>South Pacific (American Samoa, Samoa, Tonga, Fiji, etc.)</option>
         <!-- <option value="4" <% if (region4) out.print ("SELECTED"); %>>Other</option> -->  <!--do we actually need this one??-->
          </select>
      </td>
      </tr>
    </table>  
     <!--   
     /////////
     //
     //  Remove Browse By 
     <tr>
      <td>
         <input type="button" value="Browse" onclick="javascript:browseBy();">
         <input type="button" value="Clear" onclick="javascript:resetBrowse();">
      </td>
     </tr> 
     -->
     
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
     
     
     
     
     
 <div id="container3"><!--added by cameron. contains the accordion. allows for padding on the top of the accordion to fit and look better on page-->
  
  <div id="container2"><!--added by cameron. This contains the scroll css code. -->
   <div id="Accordion1" class="Accordion" tabindex="0"><!--added by cameron-->

<%  
 while (projectsListIterator.hasNext())
 {
   ProjectBean project = projectsListIterator.next();
%>

     <div class="AccordionPanel"><!--added by cameron-->
      <div class="AccordionPanelTab"><!--added by cameron-->

       <table class="project-box">
        <colgroup>
          <col class="title-blue" />
        </colgroup>
        <tr>
         <td width="67" style="width: 67px">Name</td>
         <td><%= project.getProjectname() %></td>
        </tr>
       </table>

    </div><!-- End Accordion Panel Tab -->


    <div class="AccordionPanelContent"><!--added by cameron-->

    <table class="project-box">
     <colgroup>
      <col class="title-blue" />
     </colgroup>
     <tr>
      <td>Description</td>
     <td><%= StringEscapeUtils.escapeHtml(project.getProjectdescriptionLimited()) %>&nbsp;&nbsp;
            (<a href="<%= baseurl  + project.getWorksheetfilename() %>" target="_blank">More&hellip;</a>)</td>
    </tr>
    <tr>
      <td>Status</td>
      <td><%= project.getStatusText() %></td>
    </tr>
    <tr>
     <td>Focus Area</td>
     <td><%= project.getFocusImages() %></td>
    </tr>
    <tr>
     <td>Region/Locale</td>
     <td><%= project.getRegionLists() %></td>
    </tr>
    <tr>
     <td>Lead Agencies</td>
     <td><%= project.getLeadAgencyLinks() %></td>
    </tr>
    <tr>
     <td>Contacts</td>
     <td><%= project.getContactsLinks() %></td>
    </tr>
    </table>
        <!-- Column 1 end -->
    </div><!-- End of AccordionPanelContent -->
   </div><!-- End of AccordionPanel (both content and tab)  -->


<%
  }  // end loop while (projectsListIterator.hasNext())
%>
  </div><!-- End of Accordion 1 -->
 
  </div><!-- End of "container 2" -->

</div><!-- End of "container 3" -->


</div><!--end of bodyContainer-->


<script type="text/javascript"><!--added by cameron-->
var Accordion1 = new Spry.Widget.Accordion("Accordion1",{useFixedPanelHeights: false, defaultPanel: -1 });
</script><!--added by cameron (works only if loaded at end) -->


</div><!--end of mainContainer-->

</body>
</html>

