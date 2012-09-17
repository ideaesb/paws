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


  String [] capabilities = request.getParameterValues("capabilities");
  String [] focus        = request.getParameterValues("focus");
  String [] regions      = request.getParameterValues("regions");

  String text         = StringUtils.trimToEmpty(request.getParameter("textSrch"));

  
  List <ProjectBean> list = null; 
  
  if (browse == 1)
  {
    list = daps.getList(dataSource, capabilities, focus, regions);
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
	<meta name="keywords" content="NOAA PaCIS PICCC RISA DOI Oceanic Atmospheric Pacific Climate Information System Change Research Assessment " />
	<meta name="robots" content="index, follow" />
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" media="screen" />
	
	
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
	  document.bb.action = 'dataproducts.jsp';
	  
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
	  document.bb.action = 'dataproducts.jsp?textSrch=';
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

<div id="header">
    <table width="100%" style="padding: 0 1em;">
     <tr>
       <td nowrap="nowrap">
         <img src="images/NOAA-Transparent-Logo.png" height="72" onclick="javascript:window.open('http://www.noaa.gov')" />
         <img src="images/pacislogo.jpg" height="72"  onclick="javascript:window.open('http://www.noaaclimatepacis.org')"  />
         <img src="images/Primo.jpg" height="72"  onclick="javascript:window.open('http://collaborate.csc.noaa.gov/PRiMO')" />
         <img src="images/Pacific Risa.jpg" height="72" onclick="javascript:window.open('http://www.pacificrisa.org')" />
         <img src="images/piccc.png" height="72" width="284" onclick="javascript:window.open('http://www.piccc.net')" />
         <img src="images/DOI-Logo-Color-98.jpg" height="72" style="padding:3px;" onclick="javascript:window.open('http://www.doi.gov')" /><br />
       </td>
     </tr>
     <tr>
     
     
      <!-- th class="boxHeader">Projects and Activities</th -->
      
      
 

      
      
      
     </tr>
    </table>
</div>

 <ul id="nav">
  <li><a href="projects.jsp" title="paws"><span>P R O J E C T S&nbsp;&nbsp;&nbsp;&amp;&nbsp;&nbsp;&nbsp;A C T I V I T I E S</span></a></li>
  <li id="nav-1"><a href="dataproducts.jsp" title="dnps"><span>D A T A&nbsp;&nbsp;&nbsp;&amp;&nbsp;&nbsp;&nbsp;P R O D U C T S</span></a></li>
  <li><a href="assessments.jsp" title="asses"><span>Assessments</span></a></li>
  <li><a href="programs.jsp" title="progs"><span>Partners &amp; Programs</span></a></li>
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
<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Column 1 start -->
			
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
// DEBUG

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


while (projectsListIterator.hasNext())
{
    ProjectBean project = projectsListIterator.next();
%>  

			
   <table class="project-box">
    <colgroup>
     <col class="first-blue" />
    </colgroup>
    <tr>
     <td width="80" style="width: 80px">Name</td>
     <td><%= project.getProjectnameWithWorkSheetLink(application.getInitParameter("baseurl") ) %></a></td>
    </tr>
    <tr>
     <td>Description</td>
     <td><%= StringEscapeUtils.escapeHtml(project.getProjectdescriptionLimited())  %></td>
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
   <br />
<%
} // End of Projects Listing ~ while (Project Bean project = list.iterator().hasNext())
%>
			<!-- Column 1 end -->
		</div>
		<div class="col2">
			<!-- Column 2 start -->
   <form name="bb" method="post" action="dataproducts.jsp">
    <table width="150">
     <tr>
      <td class="title-blue">Browse By</td>
     </tr>      
    </table>
    <table id="browse-box">
     <tr>
      <td>
      By Capability:<br />
       <select id="capabilities" name="capabilities" multiple="multiple" size="7" width="350" style="width: 350px;font-size:11px;overflow: auto;">
        <option value="0" <% if (capability0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (capability1) out.print ("SELECTED"); %>>Outreach, Education, Training and Capacity Building</option>
        <option value="2" <% if (capability2) out.print ("SELECTED"); %>>Observing Systems, Data Stewardship, and Data Services</option>
        <option value="3" <% if (capability3) out.print ("SELECTED"); %>>Understanding and Predicting Climate Change and Variability</option>
        <option value="4" <% if (capability4) out.print ("SELECTED"); %>>Understanding Climate Impacts and Informing Adaptation</option>
        <option value="5" <% if (capability5) out.print ("SELECTED"); %>>Policies and Legislation</option>
        <option value="6" <% if (capability6) out.print ("SELECTED"); %>>Assessment and Evaluation</option>
       </select>
      </td>
     </tr>
     <tr>
      <td>
      By Focus Area:<br />
       <select id="focii" name="focus" multiple="multiple" size="4" width="350" style="width: 350px;font-size:11px;overflow: auto;">
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
       <select id="regions" name="regions" multiple="multiple" size="5" width="350" style="width: 350px;font-size:11px;overflow: auto;">
        <option value="0" <% if (region0) out.print ("SELECTED"); %>>All</option>
        <option value="1" <% if (region1) out.print ("SELECTED"); %>>Central North Pacific (Hawaiian Islands)</option>
        <option value="2" <% if (region2) out.print ("SELECTED"); %>>Western North Pacific (Guam, CNMI, FSM, RMS, Palau)</option>
        <option value="3" <% if (region3) out.print ("SELECTED"); %>>South Pacific (American Samoa, Samoa, Tonga, Fiji, etc.)</option>
        <option value="4" <% if (region4) out.print ("SELECTED"); %>>Other</option>
       </select>
      </td>
     </tr>
     <tr>
      <td>
        <input type="button" value="Browse" onclick="javascript:browseBy();">
        <input type="button" value="Clear"  onclick="javascript:resetBrowse();">
      </td>
     </tr>
    </table>
    <br /><br />
    <table width="150">
     <tr>
      <td class="title-blue">Text Search</td>
     </tr>      
    </table>
    <input type="text" name="textSrch" size="30" value="<%= StringEscapeUtils.escapeHtml(text) %>" />
    <input type="button" value="Go" onclick="javascript:searchBy();">
    <input type="button" value="Clear"  onclick="javascript:resetText();">
    <br /><br />
    <table width="200">
     <tr>
      <td width="150" class="title-blue">Advanced Search</td><td><input type="button" value="Go" onclick="javascript:advancedSearch();"></td>
     </tr>      
    </table>
    <br /><br />
    <table width="200">
     <tr>
      <td width="150"  class="title-blue">Help</td><td><input type="button" value="Go" onclick="javascript:help();"></td>
     </tr>      
    </table>
    <br /><br />
    <table width="200">
     <tr>
      <td  width="150" class="title-blue">Submit Information</td><td><input type="button" value="Go" onclick="javascript:infoSubmit();"></td>
     </tr>      
    </table>
    <input type="hidden" name="browse" value="0" />
    <input type="hidden" name="search" value="0" />
   </form>
			<!-- Column 2 end -->
		</div>
	</div>
</div>
<div id="footer">

</div>

</body>
</html>
