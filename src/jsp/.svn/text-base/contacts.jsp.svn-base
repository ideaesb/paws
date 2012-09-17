<%@ include file="noCache.jsp" %>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>


<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>

<%@ page import="org.noaaideacenter.paws.ParameterDAO" %>
<%@ page import="org.noaaideacenter.paws.ProjectBean" %>

<%
	String id = request.getParameter("id");
	if (NumberUtils.toInt(id) == 0)
	{
      response.sendRedirect("index.jsp");
	}

	ParameterDAO parameterDAO = new ParameterDAO();
    DataSource dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");
    parameterDAO.setDataSource(dataSource);

	ProjectBean pb = new ProjectBean();
	pb.setParameterDAO(parameterDAO);
	
	
	
	
	pb = parameterDAO.getJustOneProject(id);
	// this will at minimum get an empty pb with project number set to id, even if it is zero
	
	String projectname = pb.getProjectname();
	String projectdescription = pb.getProjectdescription();
	
	String contact1 = StringEscapeUtils.escapeHtml(pb.getContact(1));
	String contact2 = StringEscapeUtils.escapeHtml(pb.getContact(2));
	String contact3 = StringEscapeUtils.escapeHtml(pb.getContact(3));
	String contact4 = StringEscapeUtils.escapeHtml(pb.getContact(4));
	String contact5 = StringEscapeUtils.escapeHtml(pb.getContact(5));
	String contact6 = StringEscapeUtils.escapeHtml(pb.getContact(6));
	String contact7 = StringEscapeUtils.escapeHtml(pb.getContact(7));
	String contact8 = StringEscapeUtils.escapeHtml(pb.getContact(8));
	String contact9 = StringEscapeUtils.escapeHtml(pb.getContact(9));
	String contact10 = StringEscapeUtils.escapeHtml(pb.getContact(10));
	String contact11 = StringEscapeUtils.escapeHtml(pb.getContact(11));
	String contact12 = StringEscapeUtils.escapeHtml(pb.getContact(12));
	String contact13 = StringEscapeUtils.escapeHtml(pb.getContact(13));
	String contact14 = StringEscapeUtils.escapeHtml(pb.getContact(14));
	String contact15 = StringEscapeUtils.escapeHtml(pb.getContact(15));
	String contact16 = StringEscapeUtils.escapeHtml(pb.getContact(16));
	String contact17 = StringEscapeUtils.escapeHtml(pb.getContact(17));
	String contact18 = StringEscapeUtils.escapeHtml(pb.getContact(18));
	String contact19 = StringEscapeUtils.escapeHtml(pb.getContact(19));
	String contact20 = StringEscapeUtils.escapeHtml(pb.getContact(20));
	String contact21 = StringEscapeUtils.escapeHtml(pb.getContact(21));
	String contact22 = StringEscapeUtils.escapeHtml(pb.getContact(22));
	String contact23 = StringEscapeUtils.escapeHtml(pb.getContact(23));
	String contact24 = StringEscapeUtils.escapeHtml(pb.getContact(24));
	String contact25 = StringEscapeUtils.escapeHtml(pb.getContact(25));
	String contact26 = StringEscapeUtils.escapeHtml(pb.getContact(26));
	String contact27 = StringEscapeUtils.escapeHtml(pb.getContact(27));
	String contact28 = StringEscapeUtils.escapeHtml(pb.getContact(28));
	String contact29 = StringEscapeUtils.escapeHtml(pb.getContact(29));
	String contact30 = StringEscapeUtils.escapeHtml(pb.getContact(30));


	String email1 = StringEscapeUtils.escapeHtml(pb.getEmail(1));
	String email2 = StringEscapeUtils.escapeHtml(pb.getEmail(2));
	String email3 = StringEscapeUtils.escapeHtml(pb.getEmail(3));
	String email4 = StringEscapeUtils.escapeHtml(pb.getEmail(4));
	String email5 = StringEscapeUtils.escapeHtml(pb.getEmail(5));
	String email6 = StringEscapeUtils.escapeHtml(pb.getEmail(6));
	String email7 = StringEscapeUtils.escapeHtml(pb.getEmail(7));
	String email8 = StringEscapeUtils.escapeHtml(pb.getEmail(8));
	String email9 = StringEscapeUtils.escapeHtml(pb.getEmail(9));
	String email10 = StringEscapeUtils.escapeHtml(pb.getEmail(10));
	String email11 = StringEscapeUtils.escapeHtml(pb.getEmail(11));
	String email12 = StringEscapeUtils.escapeHtml(pb.getEmail(12));
	String email13 = StringEscapeUtils.escapeHtml(pb.getEmail(13));
	String email14 = StringEscapeUtils.escapeHtml(pb.getEmail(14));
	String email15 = StringEscapeUtils.escapeHtml(pb.getEmail(15));
	String email16 = StringEscapeUtils.escapeHtml(pb.getEmail(16));
	String email17 = StringEscapeUtils.escapeHtml(pb.getEmail(17));
	String email18 = StringEscapeUtils.escapeHtml(pb.getEmail(18));
	String email19 = StringEscapeUtils.escapeHtml(pb.getEmail(19));
	String email20 = StringEscapeUtils.escapeHtml(pb.getEmail(20));
	String email21 = StringEscapeUtils.escapeHtml(pb.getEmail(21));
	String email22 = StringEscapeUtils.escapeHtml(pb.getEmail(22));
	String email23 = StringEscapeUtils.escapeHtml(pb.getEmail(23));
	String email24 = StringEscapeUtils.escapeHtml(pb.getEmail(24));
	String email25 = StringEscapeUtils.escapeHtml(pb.getEmail(25));
	String email26 = StringEscapeUtils.escapeHtml(pb.getEmail(26));
	String email27 = StringEscapeUtils.escapeHtml(pb.getEmail(27));
	String email28 = StringEscapeUtils.escapeHtml(pb.getEmail(28));
	String email29 = StringEscapeUtils.escapeHtml(pb.getEmail(29));
	String email30 = StringEscapeUtils.escapeHtml(pb.getEmail(30));
	
	// initialize the tab index
	int ctab = 1;
	int etab = 2;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd">
<html>
  <head>
   <title>Pacific  Climate Information System (PaCIS) Projects and Activities Worksheet</title>
   	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <script type="text/javascript" src="js/project.js"></script>
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
        <a href="http://www.noaaclimatepacis.org/" onclick="setAnchor('climate_watch'); return false;" 

target="_blank">
            <img height="72" width="611" alt="Pacific Climate Information System (PaCIS)" title="PaCIS" 

src="images/pacislogo.jpg"/></a>
               <div style="position:absolute;top:15px;left:660px;font-size:1.4em;font-weight: bold;">
             	<a href="about.html" style="text-decoration: none;color:red;">Projects &amp; Activities 

Database<!-- img src="images/external_link.gif" alt=""/ --></a><!-- br / -->
                 <div style="font-size:.7em;font-weight:lighter;font-style:italic;font-variant:small-

caps;color:red">
                   Under active construction, <a href="padb.php">press F5</a><br />to refresh and see 

latest.
                 </div>
               </div>     
      </div>
     </div>    

  <!--
  

   /************ End of Header ******************/
  
  -->


    <div id="contentArea">

    <table id="footerSiteMap">


     <tr>
      <th class="boxHeader" colspan="5">PaCIS 2010 Project and Activity Worksheet (Version 11.08.10)</th>
     </tr>

     <tr>
       <td>
 


        <form name="project" action="contacts" method="post">


        <h2>Contact(s):</h2><br />
        <table border="1" cellpadding="0" cellspacing="0">
         <tr>
           <td><h2>Names</h2></td>
           <td><h2>Emails</h2></td>
         </tr>
         <tr>
           <td>
            1<input name="contact1" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact1 %>" /> <br /><% ctab++ ; %>
            2<input name="contact2" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact2 %>" /> <br /><% ctab++; %>
            3<input name="contact3" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact3 %>" /> <br /><% ctab++; %>
            4<input name="contact4" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact4 %>" /> <br /><% ctab++; %>
            5<input name="contact5" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact5 %>" /> <br /><% ctab++; %>
            6<input name="contact6" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact6 %>" /> <br /><% ctab++; %>
            7<input name="contact7" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact7 %>" /> <br /><% ctab++; %>
            8<input name="contact8" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact8 %>" /> <br /><% ctab++; %>
            9<input name="contact9" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact9 %>" /> <br /><% ctab++; %>
            10<input name="contact10" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact10 %>" /> <br /><% ctab++; %>
            11<input name="contact11" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact11 %>" /> <br /><% ctab++; %>
            12<input name="contact12" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact12 %>" /> <br /><% ctab++; %>
            13<input name="contact13" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact13 %>" /> <br /><% ctab++; %>
            14<input name="contact14" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact14 %>" /> <br /><% ctab++; %>
            15<input name="contact15" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact15 %>" /> <br /><% ctab++; %>
            16<input name="contact16" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact16 %>" /> <br /><% ctab++; %>
            17<input name="contact17" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact17 %>" /> <br /><% ctab++; %>
            18<input name="contact18" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact18 %>" /> <br /><% ctab++; %>
            19<input name="contact19" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact19 %>" /> <br /><% ctab++; %>
            20<input name="contact20" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact20 %>" /> <br /><% ctab++; %>
            21<input name="contact21" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact21 %>" /> <br /><% ctab++; %>
            22<input name="contact22" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact22 %>" /> <br /><% ctab++; %>
            23<input name="contact23" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact23 %>" /> <br /><% ctab++; %>
            24<input name="contact24" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact24 %>" /> <br /><% ctab++; %>
            25<input name="contact25" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact25 %>" /> <br /><% ctab++; %>
            26<input name="contact26" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact26 %>" /> <br /><% ctab++; %>
            27<input name="contact27" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact27 %>" /> <br /><% ctab++; %>
            28<input name="contact28" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact28 %>" /> <br /><% ctab++; %>
            29<input name="contact29" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact29 %>" /> <br /><% ctab++; %>
            30<input name="contact30" type="text" size="50" tabindex="<%= ctab++ %>" value="<%= contact30 %>" /> <br />
           </td>
           <td>
            <input name="email1" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email1 %>" /> <br /><% etab++; %>
            <input name="email2" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email2 %>" /> <br /><% etab++; %>
            <input name="email3" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email3 %>" /> <br /><% etab++; %>
            <input name="email4" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email4 %>" /> <br /><% etab++; %>
            <input name="email5" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email5 %>" /> <br /><% etab++; %>
            <input name="email6" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email6 %>" /> <br /><% etab++; %>
            <input name="email7" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email7 %>" /> <br /><% etab++; %>
            <input name="email8" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email8 %>" /> <br /><% etab++; %>
            <input name="email9" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email9 %>" /> <br /><% etab++; %>
            <input name="email10" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email10 %>" /> <br /><% etab++; %>
            <input name="email11" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email11 %>" /> <br /><% etab++; %>
            <input name="email12" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email12 %>" /> <br /><% etab++; %>
            <input name="email13" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email13 %>" /> <br /><% etab++; %>
            <input name="email14" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email14 %>" /> <br /><% etab++; %>
            <input name="email15" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email15 %>" /> <br /><% etab++; %>
            <input name="email16" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email16 %>" /> <br /><% etab++; %>
            <input name="email17" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email17 %>" /> <br /><% etab++; %>
            <input name="email18" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email18 %>" /> <br /><% etab++; %>
            <input name="email19" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email19 %>" /> <br /><% etab++; %>
            <input name="email20" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email20 %>" /> <br /><% etab++; %>
            <input name="email21" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email21 %>" /> <br /><% etab++; %>
            <input name="email22" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email22 %>" /> <br /><% etab++; %>
            <input name="email23" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email23 %>" /> <br /><% etab++; %>
            <input name="email24" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email24 %>" /> <br /><% etab++; %>
            <input name="email25" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email25 %>" /> <br /><% etab++; %>
            <input name="email26" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email26 %>" /> <br /><% etab++; %>
            <input name="email27" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email27 %>" /> <br /><% etab++; %>
            <input name="email28" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email28 %>" /> <br /><% etab++; %>
            <input name="email29" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email29 %>" /> <br /><% etab++; %>
            <input name="email30" type="text" size="50" tabindex="<%= etab++ %>" value="<%= email30 %>" /> <br />
           </td>
         </tr>
        </table><br /><br />
        
        
     <input type="hidden" name="id" value="<%= NumberUtils.toInt(id) %>"></input>
     <input type="hidden" name="pname" value="<%= projectname %>"></input>
     <input type="hidden" name="pdesc" value="<%= projectdescription %>"></input>
     <input type="hidden" name="updated" value="true"></input>
     <input type="submit" value="Update Project"></input>
     <input type="reset" />


        </form>

     </td>
    </tr>

</table><!-- end of table id="footerSiteMap" -->



<table id="footer">
<tr>
    <td align="center">
        <img src="images/NOAA_climate_services_logo_footer.png" title="climate.gov" 

onmouseover="document.body.style.cursor='pointer';" onmouseout="document.body.style.cursor='auto';" 
            alt="NOAA Climate Services logo" onclick="javascript:window.open('http://www.climate.gov');"/>
    </td>
    <td align="right"> 
        <a href="http://www.noaa.gov/privacy.html" title="Privacy Policy" target="_blank">Privacy 

Policy</a> | 
		<a href="http://www.rdc.noaa.gov/~foia/" title="FOIA" target="_blank">FOIA</a> | 
		<a href="http://www.cio.noaa.gov/Policy_Programs/info_quality.html" title="Information 

Quality" target="_blank">Information Quality</a> |  
		<a href="http://www.noaa.gov/disclaimer.html" title="Disclaimer" 

target="_blank">Disclaimer</a> | 
		<a href="http://www.usa.gov" title="USA.gov" target="_blank">USA.gov</a>  |
		<a href="http://www.ready.gov" title="Ready.gov" target="_blank">Ready.gov</a> | 
		<a href="mailto:ukari@noaa.gov" title="Contact Webmaster">Contact Webmaster</a>
    </td>
</tr>
</table><!-- end of table id=footer -->









   </div><!-- End of Content Area -->
  </div><!-- End of Page Container -->









  </body>
</html>

