<%@ include file="noCache.jsp" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="org.noaaideacenter.paws.ProjectBean" %>
<%@ page import="org.noaaideacenter.paws.ParameterDAO" %>


<jsp:useBean id="daps" class="org.noaaideacenter.paws.DataProducts" scope="session" />

<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" %>


<%

  DataSource dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");

  int browse = NumberUtils.toInt(request.getParameter("browse"));
  int search = NumberUtils.toInt(request.getParameter("search"));

  boolean debug = ParameterDAO.parse(request.getParameter("debug"));


  String [] ecv          = request.getParameterValues("ecv");
  String [] dps          = request.getParameterValues("dps");
  String [] regions      = request.getParameterValues("regions");

  String text            = StringUtils.trimToEmpty(request.getParameter("textSrch"));


  List <ProjectBean> list = null;

  if (browse == 1)
  {
    list = daps.getList(dataSource, ecv, dps, regions);
  }
  else if (search == 1)
  {
    list = daps.getList(dataSource, text);
  }
  else
  {
    list = daps.getList(dataSource);
  }

  Iterator <ProjectBean> projectsListIterator = list.iterator();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
<head>
<title>Data and Products</title>
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
  document.bb.action = 'dataproducts3.jsp';

  var ecv = document.getElementById("ecv");
  for (var i=0; i<ecv.options.length; i++) ecv.options[i].selected = false ;

  var dps = document.getElementById("dps");
  for (var i=0; i<dps.options.length; i++) dps.options[i].selected = false ;

  var regions = document.getElementById("regions");
  for (var i=0; i<regions.options.length; i++) regions.options[i].selected = false ;


  document.bb.submit();
}

function resetText()
{
  document.bb.action = 'dataproducts3.jsp?textSrch=';
  document.bb.submit();
}

function advancedSearch()
{
  alert('Advanced Search leads to Admin interface...leaving daps listing');
  document.bb.action = 'dnp.jsp?x=1';
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
  alert('Advanced Search leads to Admin interface...leaving this daps listing');
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
	  <li id="nav-1"><a href="dataproducts3.jsp"><span>D A T A &nbsp;&nbsp;&nbsp;&amp;&nbsp;&nbsp;&nbsp;P R O D U C T S</span></a></li>
      <li><a href="projects3.jsp" title="paws"><span>Projects &amp; Activities</span></a></li>
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

  if (ecv != null && ecv.length > 0)
  {
    for (int i = 0; i < ecv.length; i++)
    {
      int e = NumberUtils.toInt(ecv[i]);
      out.print("<br />ECV[" + i + "] = " + e);
    }
  }
  else
  {
    out.print("<br />NO ECV");
  }

  if (dps != null && dps.length > 0)
  {
    for (int i = 0; i < dps.length; i++)
    {
      int d =  NumberUtils.toInt(dps[i]);
      out.print("<br />DataProducts[" + i + "] = " + d);
    }
  }
  else
  {
    out.print("<br />NO Data Products");
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
boolean ecv0 = false;
boolean ecv1 = false;
boolean ecv2 = false;
boolean ecv3 = false;

if (ecv != null && ecv.length > 0)
{
  for (int i = 0; i < ecv.length; i++)
  {
    int e = NumberUtils.toInt(ecv[i]);
    switch (e)
    {
      case 0: ecv0 = true;  break;
      case 1: ecv1 = true;  break;
      case 2: ecv2 = true;  break;
      case 3: ecv3 = true;  break;
    }
  }
}

boolean dp0 = false;  // all
boolean dp1 = false;  // data-physical
boolean dp2 = false;  // hindcasts
boolean dp3 = false;  // outlooks
boolean dp4 = false;  // projections
boolean dp5 = false;  // guidance
boolean dp6 = false;  // applications
boolean dp7 = false;  // non-physical


if (dps != null && dps.length > 0)
{
  for (int i = 0; i < dps.length; i++)
  {
    int dp =  NumberUtils.toInt(dps[i]);
    switch (dp)
    {
      case 0: dp0 = true;  break;
      case 1: dp1 = true;  break;
      case 2: dp2 = true;  break;
      case 3: dp3 = true;  break;
      case 4: dp4 = true;  break;
      case 5: dp5 = true;  break;
      case 6: dp6 = true;  break;
      case 7: dp7 = true;  break;
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

<form name="bb" method="post" action="dataproducts3.jsp">
   <table width="750">
   <tr>
   <td width="245">
      By Essential Climate Variable:<br />
       <select id="ecv" name="ecv" width="245" onchange="javascript:browseBy();" style="width:245px;font-size:11px;overflow: auto;">
        <option value="0" <% if (ecv0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (ecv1) out.print ("SELECTED"); %>>Atmospheric (e.g., Air Temperature, Rainfall, Wind speed and direction)</option>
        <option value="2" <% if (ecv2) out.print ("SELECTED"); %>>Oceanic (e.g., Water Temperature, Salinity, Acidity, Sea Level, Wave Height)</option>
        <option value="3" <% if (ecv3) out.print ("SELECTED"); %>>Terrestrial (e.g., Groundwater, Soil Moisture)</option>
       </select>
   </td>
   <td width="245">
      By Data and Product Type:<br />
       <select id="dps" name="dps"  width="245" onchange="javascript:browseBy();"  style="width:245px;font-size:11px;overflow: auto;">
        <option value="0" <% if (dp0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (dp1) out.print ("SELECTED"); %>>Data&nbsp;&#45;&nbsp;Physical</option>
        <option value="2" <% if (dp2) out.print ("SELECTED"); %>>Products&nbsp;&#45;&nbsp;Hindcasts (climatologies)</option>
        <option value="3" <% if (dp3) out.print ("SELECTED"); %>>Products&nbsp;&#45;&nbsp;Outlooks (monthly to annual)</option>
        <option value="4" <% if (dp4) out.print ("SELECTED"); %>>Products&nbsp;&#45;&nbsp;Projections (inter&#45;annual to multi&#45;decadal)</option>
        <option value="5" <% if (dp5) out.print ("SELECTED"); %>>Products&nbsp;&#45;&nbsp;Guidance, including &quot;Best Practices&quot; Manuals, Toolkits, and Guides</option>
        <option value="6" <% if (dp6) out.print ("SELECTED"); %>>Products&nbsp;&#45;&nbsp;Applications, including Visualization and Decision Support Tools</option>
        <option value="7" <% if (dp7) out.print ("SELECTED"); %>>Data, Products, and Tools - Non-physical</option>
       </select>
      </td>
      <td width="245">
        By Region:<br />
        <select id="regions" name="regions" width="245" onchange="javascript:browseBy();" style="width:245px;font-size:11px;overflow: auto;">
          <option value="0" <% if (region0) out.print ("SELECTED"); %>>All</option>
          <option value="1" <% if (region1) out.print ("SELECTED"); %>>Central North Pacific (Hawaiian Islands)</option>
          <option value="2" <% if (region2) out.print ("SELECTED"); %>>Western North Pacific (Guam, CNMI, FSM, RMI, Palau)</option>
          <option value="3" <% if (region3) out.print ("SELECTED"); %>>South Pacific (American Samoa, Samoa, Tonga, Fiji, etc.)</option>
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
     <td>Type</td>
     <td><%= project.getDapChoices() %></td>
    </tr>
    <tr>
     <td>Essential Climate Variables</td>
     <td><%= project.getEcvChoices() %></td>
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

