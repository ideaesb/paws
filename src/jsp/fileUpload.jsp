<%@ page import="org.apache.commons.lang.math.NumberUtils" %>
<%@ page import="org.noaaideacenter.paws.ParameterDAO" %>
<%
	int id = NumberUtils.toInt(request.getParameter("id"));
	boolean dap = ParameterDAO.parse(request.getParameter("dap"));
	if (id > 0)
	{
  
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
 

        <h2>File Upload</h2><br /><br />

        <FORM METHOD=POST ENCTYPE="multipart/form-data" ACTION="upload">
         <input type="hidden" name="id" value="<%= id %>"></input><!-- this MUST precede file input otherwise file will be uploaded to empty project -->
         <input type="hidden" name="dap" value="<%= dap %>"></input>
         <INPUT TYPE=FILE size="50" NAME="upfile"><BR />
         <INPUT TYPE=SUBMIT VALUE="Submit">
       </FORM>


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

<%
}
else
{
   if (dap)
   {
     response.sendRedirect("dataproducts");
   }
   else
   {
     response.sendRedirect("projects");
   } 
}
%>