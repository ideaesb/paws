<%@ include file="noCache.jsp" %>
<%
	// initialize the tab index
	int atab = 1;
	int dtab = 2;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
   <title>Pacific  Climate Information System (PaCIS) Projects and Activities Worksheet</title>
   	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
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
 


        <form name="project" action="addagencies" method="post">


        <h2>Add New Agencies:</h2><br />
        <table border="1" cellpadding="0" cellspacing="0">
         <tr>
           <td><h2>Acronym</h2></td>
           <td><h2>Description</h2></td>
         </tr>
         <tr>
           <td>
            1<input name="acronym1" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++ ; %>
            2<input name="acronym2" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            3<input name="acronym3" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            4<input name="acronym4" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            5<input name="acronym5" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            6<input name="acronym6" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            7<input name="acronym7" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            8<input name="acronym8" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            9<input name="acronym9" type="text" size="20" tabindex="<%= atab++ %>" /> <br /><% atab++; %>
            10<input name="acronym10" type="text" size="20" tabindex="<%= atab++ %>" /> <br />
           </td>
           <td>
            <input name="description1" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description2" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description3" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description4" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description5" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description6" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description7" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description8" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description9" type="text" size="80" tabindex="<%= dtab++ %>" /> <br /><% dtab++; %>
            <input name="description10" type="text" size="80" tabindex="<%= dtab++ %>" /> <br />
           </td>
         </tr>
        </table><br /><br />
        
        
     <input type="submit" value="Add Agencies"></input>
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

