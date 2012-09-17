<%@ include file="noCache.jsp" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="org.noaaideacenter.paws.ProjectBean" %>
<%@ page import="org.noaaideacenter.paws.ParameterDAO" %>


<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" %>

   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>Pacific  Climate Information System (PaCIS) Data and Products Worksheet Summaries</title>
  <link rel="stylesheet" type="text/css" href="css/projects.css" />
  <script>
  function sortby(column, order)
{
  document.projectlist.sortby.value = column;
  document.projectlist.order.value = order;
  document.projectlist.submit();
}
function addnew()
{
  document.projectlist.action = 'dnp.jsp';
  document.projectlist.submit();
}
function searchbyx()
{
  document.projectlist.action = 'dnp.jsp?x=1';
  document.projectlist.submit();
}
function resetAllDeletes()
{
  turnAllDeletes(false);
}
function setAllDeletes()
{
  turnAllDeletes(true);
}
function turnAllDeletes(torf)
{
  //alert('got into turnAllDelets');
  var dels = document.getElementsByName('delete');
  if (torf) alert('All ' + dels.length + ' projects can be deleted by clicking the DELETE button');
  
  for (var i=0; i < dels.length; i++)
  {
    dels[i].checked = torf;
  }
  
}
function toggleDeleteColumn()
{
   var tbody = document.getElementById('ptable').getElementsByTagName('TBODY');
   var rows  = tbody[0].getElementsByTagName('TR');


  if (document.getElementById('chkQueen').checked)
  {
      var answer = confirm('Delete ALL Projects ?!');
     if (answer)
     { 
       setAllDeletes();
       // bloody RED every row for emphasis !!!
       for (var i=0;i<rows.length;i++)
       {
         rows[i].style.backgroundColor = "red";
         rows[i].style.color = "#FFF";
       }
     }
     else
     {
       // just to be super-safe
       document.getElementById('chkQueen').checked = false;
       resetmsgsbox();
     }
  }
  else
  {
    resetmsgsbox();
  }
}
// deprecate in favor of cleaner resetmsgbox
function toggleDeleteColumnOff(maxRowId)
{
   var tbody = document.getElementById('ptable').getElementsByTagName('TBODY');
   var rows  = tbody[0].getElementsByTagName('TR');
   //alert('maxRowId = ' + maxRowId);
   var maxRow = document.getElementById(maxRowId);

    resetAllDeletes();
    
    for (var i=0;i<rows.length;i++)
    {
      rows[i].style.backgroundColor = "transparent";
      rows[i].style.color = "inherit";
    }
    // set the maxRow back to yellow...remember maxRow may not be part of a search (or, generally, partial result)
    if (maxRow)
    {
      maxRow.style.backgroundColor = "#FFFF00";
      //maxRow.style.color = "#FFF";
    }
    // yeah might as well refresh...to reset all styles which are lost...and, if so, why bother with all the above...LOL
    resetmsgsbox();
}
function resetmsgsbox()
{
  resetAllDeletes();
  document.projectlist.search.value = '';
  document.projectlist.clearmsgs.value = 'true';
  document.projectlist.action = 'dataproducts';
  document.projectlist.submit();
}
function searchbox()
{
  //alert('Begin Search for ' + document.projectlist.search.value);
  resetAllDeletes();
  document.projectlist.clearmsgs.value = 'true';
  document.projectlist.action = 'dataproducts';
  document.projectlist.submit();
}
function openworksheet()
{
  alert('This will open worksheet file');
}
function clickrow(id)
{
  
  var clickedCheckBox = document.getElementById('chk' + id);
  var clickedTableRow = document.getElementById('row' + id);
  
  // toggle row
  if (clickedCheckBox.checked)
  {
    //alert('Turning Row Red');
    clickedTableRow.style.backgroundColor = "transparent";
    clickedTableRow.style.color = "inherit";
    clickedCheckBox.checked = false;
  }
  else
  {
    //alert('Turning Row Transparent');
    clickedTableRow.style.backgroundColor = "red";
    clickedTableRow.style.color = "#fff";
    clickedCheckBox.checked = true;
  }
  
}
function clickchk(id)
{
  
  var clickedCheckBox = document.getElementById('chk' + id);
  var clickedTableRow = document.getElementById('row' + id);
  
  
  if (clickedCheckBox.checked)
  {
    //alert('Turning Row Red');
    clickedTableRow.style.backgroundColor = "red";
    clickedTableRow.style.color = "#fff";
  }
  else
  {
    //alert('Turning Row Transparent');
    clickedTableRow.style.backgroundColor = "transparent";
    clickedTableRow.style.color = "inherit";
  }
  
}

  
  </script>
 </head>
 <body>
  <div id="pageContainer">
   <div id="header">
    <div id="topNav">
     <ul id="topNavElements">
      <li id="topNavHome"><a href="http://www.noaa.gov/index.html" target="_blank">NOAA HOME</a></li>
      <li id="topNavWeather"><a href="http://www.noaa.gov/wx.html" target="_blank">WEATHER</a></li>
      <li id="topNavOceans"><a href="http://www.noaa.gov/ocean.html" target="_blank">OCEANS</a></li>
      <li id="topNavFisheries"><a href="http://www.noaa.gov/fisheries.html" target="_blank">FISHERIES</a></li>
      <li id="topNavCharting"><a href="http://www.noaa.gov/charts.html" target="_blank">CHARTING</a></li>
      <li id="topNavSatellites"><a href="http://www.noaa.gov/satellites.html" target="_blank">SATELLITES</a></li>
      <li id="topNavClimate"><a href="http://www.noaa.gov/climate.html" target="_blank">CLIMATE</a></li>
      <li id="topNavResearch"><a href="http://www.noaa.gov/research.html" target="_blank">RESEARCH</a></li>
      <li id="topNavCoasts"><a href="http://www.noaa.gov/coasts.html" target="_blank">COASTS</a></li>
      <li id="topNavCareers"><a href="http://www.careers.noaa.gov" target="_blank">CAREERS</a></li>
     </ul>
    </div>
    <div id="headTitle">
     <a href="http://www.noaaideacenter.org/" target="_blank"><img height="72" width="611" alt="Pacific Climate Information System (PaCIS)" title="PaCIS" src="images/noaapacislogo.jpg"/></a>
     <div style="position:absolute;top:15px;left:660px;font-size:1.4em;font-weight: bold;"><a href="projects" style="text-decoration: none;color:red;">Data &amp; Products Summaries</a>
      <div style="font-size:.7em;font-weight:lighter;font-style:italic;font-variant:small-caps;color:red">Under active construction, <a href="javascript:window.location.reload()">press F5</a><br />to refresh and see lates      </div><!-- closes red coloring -->
     </div><!-- Closes PADB Title -->
    </div><!-- Closes headitle -->
   </div><!-- Closes div id=header -->
   <!-- All open HTML elements below and the div=pageContainer (above) are closed in the common footer.jsp -->
   <!-- This header can be changed by request dispatcher servlet a la Spring based on which jsp it is choosing to render  -->
   <div id="contentArea">
   <table id="footerSiteMap">
    <tr>
     <th class="boxHeader" colspan="5">PaCIS 2011 Data and Products Summaries</th>
    </tr>
    <tr>
     <td>
      </div>
<%
   String baseurl = (String) request.getSession().getServletContext().getInitParameter("baseurl");  // filesystem web-root
   	ParameterDAO parameterDAO = new ParameterDAO();
    DataSource dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");
    parameterDAO.setDataSource(dataSource);
   List <ProjectBean> projects = parameterDAO.getDaps();
   int size = projects.size();
   
   if (size > 0) 
   {
%>
      
      <!-- Form Project List BEGIN -->
      <form name="projectlist" action="dataproducts" method="post">
       <input type="button" value="Add New" onclick="addnew()"></input>
       <input type="submit" value="Delete"></input>
       
       <table class="projects" id="ptable">
        <thead>
         <tr>
          <td><input type="checkbox" name="deleteKing" id="chkQueen" title="Select Or Unselect All Projects" onclick="toggleDeleteColumn()" /></td>
          <td>ID</td>
          <td>Name</td>
          <td>Description</td>
          <td>Capability Area</td>
          <td>Focus Area</td>
          <td>Region/Locale</td>
          <td>Lead Agencies</td>
          <td>Contacts</td>
         </tr>
        </thead>
        <tbody>
        <%
		   for (Iterator<ProjectBean>iter = projects.listIterator(); iter.hasNext();)
  		   {
    		  ProjectBean project = (ProjectBean) iter.next();
    		  int pid = project.getProjectnumber();
    	%>		
          <tr id="row<%=pid %>">
           <td><input type="checkbox" name="delete" id="chk<%=pid %>" value="<%=pid %>"  onclick="clickchk('<%=pid %>')" /></td>
           <td><%= project.getCode() %></td>
           <td class="nameCol"><%= project.getProjectNameStripURL() %>(<a href="dnp.jsp?id=<%=pid%>">Update</a>)</td>
           <td class="descriptionCol"><%= project.getProjectdescription() %>&nbsp;<%= project.getWorksheetURL(baseurl) %></td>
           <td class="capabilityCol"><%= project.getCapabilityAreas() %></td>
           <td class="focusCol"><%= project.getFocusAreas() %></td>
           <td class="regionCol"><%= project.getRegionLocale() %></td>
           <td class="agencyCol"><%= project.getLeadAgenciesAsString("") %></td>
           <td class="contactCol"><%= project.getContacts("") %></td>
          </tr>
        <%
		    }
		%>  
        </tbody>
       </table>
          
          
       <input type="hidden" name="sortby" value="project"></input>
       <input type="hidden" name="order" value="1"></input>
       <input type="hidden" name="clearmsgs" value="0"></input>

       <input type="button" value="Add New" onclick="addnew()"></input>
       <input type="submit" value="Delete"></input>

      </form>
      <!-- Form Project List END -->
<%
}
else
{
%>
 		<form name="projectlist" action="dataproducts" method="post">
    	 <input type="button" value="Add New Project" onclick="addnew()"></input>
         <input type="hidden" name="clearmsgs" value="0"></input>
    	 <br /><div style="background-color: #FFFF00;">NO PROJECTS FOUND...</div>
        </form>

<%
}
%>      
      <!-- Footer -->
     </td></tr></table><!-- end of table id="footerSiteMap" -->
     <table id="footer"><tr><td align="center"><img src="images/NOAA_climate_services_logo_footer.png" title="climate.gov"onmouseover="document.body.style.cursor='pointer';" onmouseout="document.body.style.cursor='auto';"alt="NOAA Climate Services logo" onclick="javascript:window.open('http://www.climate.gov');"/></td><td align="right"><a href="http://www.noaa.gov/privacy.html" title="Privacy Policy" target="_blank">PrivacyPolicy</a> |<a href="http://www.rdc.noaa.gov/~foia/" title="FOIA" target="_blank">FOIA</a> |<a href="http://www.cio.noaa.gov/Policy_Programs/info_quality.html" title="InformationQuality" target="_blank">Information Quality</a> |<a href="http://www.noaa.gov/disclaimer.html" title="Disclaimer"target="_blank">Disclaimer</a> |<a href="http://www.usa.gov" title="USA.gov" target="_blank">USA.gov</a>  |<a href="http://www.ready.gov" title="Ready.gov" target="_blank">Ready.gov</a> |<a href="mailto:ukari@noaa.gov" title="Contact Webmaster">Contact Webmaster</a></td></tr></table><!-- end of table id=footer --></div><!-- End of Content Area --></div><!-- End of Page Container --></body></html>
