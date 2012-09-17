<%@ page import="org.apache.commons.lang.StringUtils" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" type="text/css" href="css/home.css" />
<link href='http://fonts.googleapis.com/css?family=Rosario:400,400italic' rel='stylesheet' type='text/css'>


<script src="js/jquery.js" type="text/javascript"></script>

<script src="js/jquery.hoverIntent.js" type="text/javascript"></script> <!-- optional -->
<script src="js/jquery.cluetip.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/jquery.cluetip.css" type="text/css" />

<script type="text/javascript">
$(document).ready(function() {
$('.maphover').cluetip({
  sticky: true,
  mouseOutClose: true,
  closePosition: 'title',
  closeText: 'Close',
showTitle:false, 
  local:true

});

});
</script>

</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Contact</title>

<body>

<div id="mainContainer"> <!--keeps everything in one box -->
  
<div id="header">
  <img src="images/pikogreenlogo.jpg" />
</div>
<%
   String frompage = StringUtils.trimToEmpty(request.getParameter("frompage"));
   
   if (StringUtils.isBlank(frompage))
   {
      // default menu
%>
  <ul id="nav">
    <li id="nav-1"><a href="home.jsp"><span>&nbsp; H O M E </span></a></li>
    <li><a href="dataproducts3.jsp" title="dnp"><span>Data &amp; Products</span></a></li>
    <li><a href="projects3.jsp" title="paws"><span>Projects &amp; Activities</span></a></li>
    <li><a href="assessments3.jsp" title="asses"><span>Assessments</span></a></li>
    <li><a href="programs3.jsp" title="progs"><span>Partners &amp; Programs</span></a></li>
  </ul>
<%
   }
   else
   {
     // for now home drives either paws 2 or paws 3 ... but tihs could be expanded using else if to render all sorts of home page menus 
%>
  <ul id="nav">
    <li id="nav-1"><a href="home.jsp"><span>&nbsp; H O M E </span></a></li>
    <li><a href="projects2.jsp" title="paws"><span>Projects &amp; Activities</span></a></li>
    <li><a href="assessments2.jsp" title="asses"><span>Assessments</span></a></li>
    <li><a href="programs2.jsp" title="progs"><span>Partners &amp; Programs</span></a></li>
  </ul>
<%
   }
%>
  

<div id = "leftColumn"> <!--code taken from NOAA website for left menu-->
	<div id="leftNav"> <!--code taken from NOAA website for left menu-->

		<ul id="leftNavElements">
  	  	<li id="leftNavAlerts"><a href="home.html">Home</a></li>
 		<li id="leftNavOrganizations"><a href="http://www.pacificcis.org" target="_blank"><font style="text-transform:none">PaCIS</font></a></li>
 		<li id="leftNavOrganizations"><a href="javascript:alert('Under Construction');">Focus Area:<br /> Water Resources</a></li>
 		<li id="leftNavOrganizations"><a href="javascript:alert('Under Construction');">Focus Area:<br /> Coastal Inundation</a></li>
 		<li id="leftNavOrganizations"><a href="javascript:alert('Under Construction');">Focus Area:<br /> Ecosystems</a></li>
 		<li id="leftNavOrganizations"><a href="dataproducts3.jsp"><strong>Data and Products</strong></a></li>
 		<li id="leftNavOrganizations"><a href="projects3.jsp"><strong>Projects and Activities</strong></a></li>
		<li id="leftNavOrganizations"><a href="assessments3.jsp">Assessments</a></li>
 		<li id="leftNavOrganizations"><a href="programs3.jsp">Partners &amp; Programs</a></li>
	 	<li id="leftNavOrganizations"><a href="contactus.jsp">Contact Us</a></li>
   		</ul>

   		 <img id="canyon" src="images/KaaawabeachMarch2010.jpg" /><br>

		<div id ="pikoDefinition">
 
        	<b>piko <i> n.</i></b> <i>in Hawaiian</i> navel. Figuratively, the point of connection, the center, the place around which related objects or entities are joined.

		</div><!--end pikoDefinition-->
    
	</div><!--end leftNav-->
        
</div><!--end leftColumn-->
  
  
 
<div id = "container" > <!--container that holds main text and map -->

<ul>

<li>
John Marra, NOAA Regional Climate Services Director, Pacific Region<br />
1601 East-West Road, JAB 4092, Honolulu, Hawaii  96848<br />
Phone: 808-944-7453 | Fax: 808-944-7499<br />
Email: <a href="mailto:john.marra@noaa.gov">John.Marra@noaa.gov</a><br />
<a target="_blank" href="http://www.pacificcis.org">climate.gov/pacific</a>
</li>

<br />

<li>
Deana Spooner, Coordinator, Pacific Islands Climate Change Cooperative<br />
677 Ala Moana Blvd, Suite 320, Honolulu, Hawaii 96813<br />
Phone: 808-687-6175 | Fax: 808-664-8510<br />
Email: <a href="mailto:deanna.spooner@piccc.net">Deanna.Spooner@piccc.net</a><br />
<a target="_blank" href="http://piccc.net">piccc.net</a>
</li>

<br />

<li>
Melissa Finucane, Principal Investigator, Pacific Regional Integrated Sciences and Assessments Program (Pacific RISA) <br /> 
1601 East-West Road, Honolulu, Hawaii 96848<br />
Phone: 808-944-7254 | Fax: 808-944-7298<br /> 
Email: <a href="mailto:Finucanm@EastWestCenter.org">FinucanM@EastWestCenter.org</a><br />
<a target="_blank" href="http://www.pacificrisa.org">pacificrisa.org</a>
</li>

<br />

<li>
Penny Larin, Coordinator, Pacific Risk Management Ohana  (PRiMO)<br />
NOAA Pacific Services Center, 737 Bishop St, Suite 1550, Honolulu, Hawaii 96813<br />
Phone: 808-525-5354  | Fax: 808-532-3224<br />
Email: <a href="mailto:Penny.Larin@noaa.gov">Penny.Larin@noaa.gov</a><br />
<a target="_blank" href="http://www.primohui.org">primohui.org</a>
</li>

</ul>



</div><!--ends container-->

	<div id="top-footer">


	</div>
<%@ include file="marquee.jsp" %>

	<div id="bottom">


	</div> <!--ends footer-->
   
   
</div><!--ends mainContainer-->
  
</body>
</html>