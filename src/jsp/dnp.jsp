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

	ParameterDAO parameterDAO = new ParameterDAO();
    DataSource dataSource = (DataSource) request.getSession().getServletContext().getAttribute("DBCPool");
    parameterDAO.setDataSource(dataSource);

	ProjectBean pb = new ProjectBean();
	pb.setParameterDAO(parameterDAO);
	
	
	
	
	pb = parameterDAO.getJustOneProject(id);
	// this will at minimum get an empty pb with project number set to id, even if it is zero
	
	String projectname = pb.getProjectname();
	String training = ParameterDAO.getCheckedStatus(pb.getTraining());
	String education = ParameterDAO.getCheckedStatus(pb.getEducation());
	String outreach = ParameterDAO.getCheckedStatus(pb.getOutreach());
	String observing = ParameterDAO.getCheckedStatus(pb.getObserving());
	String dataservices = ParameterDAO.getCheckedStatus(pb.getDataservices());
	String variability = ParameterDAO.getCheckedStatus(pb.getVariability());
	String operational = ParameterDAO.getCheckedStatus(pb.getOperational());
	String research = ParameterDAO.getCheckedStatus(pb.getResearch());
	String vhistorical = ParameterDAO.getCheckedStatus(pb.getVhistorical());
	String vprojections = ParameterDAO.getCheckedStatus(pb.getVprojections());
	String asurface = ParameterDAO.getCheckedStatus(pb.getAsurface());
	String upperair = ParameterDAO.getCheckedStatus(pb.getUpperair());
	String composition = ParameterDAO.getCheckedStatus(pb.getComposition());
	String osurface = ParameterDAO.getCheckedStatus(pb.getOsurface());
	String subsurface = ParameterDAO.getCheckedStatus(pb.getSubsurface());
	String terrestrial = ParameterDAO.getCheckedStatus(pb.getTerrestrial());
	String seasonal = ParameterDAO.getCheckedStatus(pb.getSeasonal());
	String annual = ParameterDAO.getCheckedStatus(pb.getAnnual());
	String decadal = ParameterDAO.getCheckedStatus(pb.getDecadal());
	String effect = ParameterDAO.getCheckedStatus(pb.getEffect());
	String impacts = ParameterDAO.getCheckedStatus(pb.getImpacts());
	String ehistorical = ParameterDAO.getCheckedStatus(pb.getEhistorical());
	String eprojections = ParameterDAO.getCheckedStatus(pb.getEprojections());
	String adaptation = ParameterDAO.getCheckedStatus(pb.getAdaptation());
	String phs = ParameterDAO.getCheckedStatus(pb.getPhs());
	String fwr = ParameterDAO.getCheckedStatus(pb.getFwr());
	String ene = ParameterDAO.getCheckedStatus(pb.getEne());
	String tcc = ParameterDAO.getCheckedStatus(pb.getTcc());
	String cpd = ParameterDAO.getCheckedStatus(pb.getCpd());
	String scr = ParameterDAO.getCheckedStatus(pb.getScr());
	String afi = ParameterDAO.getCheckedStatus(pb.getAfi());
	String rat = ParameterDAO.getCheckedStatus(pb.getRat());
	String eco = ParameterDAO.getCheckedStatus(pb.getEco());
	String oth = ParameterDAO.getCheckedStatus(pb.getOth());
	String guidance = ParameterDAO.getCheckedStatus(pb.getGuidance());
	String gvariability = ParameterDAO.getCheckedStatus(pb.getGvariability());
	String geffects = ParameterDAO.getCheckedStatus(pb.getGeffects());
	String apps = ParameterDAO.getCheckedStatus(pb.getApps());
	String avariability = ParameterDAO.getCheckedStatus(pb.getAvariability());
	String aeffects = ParameterDAO.getCheckedStatus(pb.getAeffects());
	String policies = ParameterDAO.getCheckedStatus(pb.getPolicies());
	String assessment = ParameterDAO.getCheckedStatus(pb.getAssessment());
	String fresh = ParameterDAO.getCheckedStatus(pb.getFresh());
	String coastal = ParameterDAO.getCheckedStatus(pb.getCoastal());
	String marine = ParameterDAO.getCheckedStatus(pb.getMarine());
	String central = ParameterDAO.getCheckedStatus(pb.getCentral());
	String hawaii = ParameterDAO.getCheckedStatus(pb.getHawaii());
	String big = ParameterDAO.getCheckedStatus(pb.getBig());
	String maui = ParameterDAO.getCheckedStatus(pb.getMaui());
	String oahu = ParameterDAO.getCheckedStatus(pb.getOahu());
	String kauai = ParameterDAO.getCheckedStatus(pb.getKauai());
	String hother = ParameterDAO.getCheckedStatus(pb.getHother());
	String western = ParameterDAO.getCheckedStatus(pb.getWestern());
	String guam = ParameterDAO.getCheckedStatus(pb.getGuam());
	String cnmi = ParameterDAO.getCheckedStatus(pb.getCnmi());
	String fsm = ParameterDAO.getCheckedStatus(pb.getFsm());
	String rmi = ParameterDAO.getCheckedStatus(pb.getRmi());
	String palau = ParameterDAO.getCheckedStatus(pb.getPalau());
	String wother = ParameterDAO.getCheckedStatus(pb.getWother());
	String south = ParameterDAO.getCheckedStatus(pb.getSouth());
	String asam = ParameterDAO.getCheckedStatus(pb.getAsam());
	String samoa = ParameterDAO.getCheckedStatus(pb.getSamoa());
	String tonga = ParameterDAO.getCheckedStatus(pb.getTonga());
	String fiji = ParameterDAO.getCheckedStatus(pb.getFiji());
	String oz = ParameterDAO.getCheckedStatus(pb.getOz());
	String nz = ParameterDAO.getCheckedStatus(pb.getNz());
	String fp = ParameterDAO.getCheckedStatus(pb.getFp());
	String sother = ParameterDAO.getCheckedStatus(pb.getSother());
	String otherregions = ParameterDAO.getCheckedStatus(pb.getOtherregions());

	String ecvAtmospheric = ParameterDAO.getCheckedStatus(pb.getEcvAtmospheric());
	String ecvOceanic     = ParameterDAO.getCheckedStatus(pb.getEcvOceanic());
	String ecvTerrestrial = ParameterDAO.getCheckedStatus(pb.getEcvTerrestrial());
	
	String phyInsitu     = ParameterDAO.getCheckedStatus(pb.getPhyInsitu());
	String phySatellite  = ParameterDAO.getCheckedStatus(pb.getPhySatellite());
	String phyModel      = ParameterDAO.getCheckedStatus(pb.getPhyModel());
	String phyReanalysis = ParameterDAO.getCheckedStatus(pb.getPhyReanalysis());
    String phyBathymetry = ParameterDAO.getCheckedStatus(pb.getPhyBathymetry());
    String phyImagery    = ParameterDAO.getCheckedStatus(pb.getPhyImagery());
  
    String prodHindcasts    = ParameterDAO.getCheckedStatus(pb.getProdHindcasts());
    String prodOutlooks     = ParameterDAO.getCheckedStatus(pb.getProdOutlooks());
    String prodProjections  = ParameterDAO.getCheckedStatus(pb.getProdProjections());
    String prodGuidance     = ParameterDAO.getCheckedStatus(pb.getProdGuidance());
    String prodApplications = ParameterDAO.getCheckedStatus(pb.getProdApplications());

    String enviro = ParameterDAO.getCheckedStatus(pb.getNonPhysicalEnvironmental());
    String socio = ParameterDAO.getCheckedStatus(pb.getNonPhysicalSocioCultural());
    String econo = ParameterDAO.getCheckedStatus(pb.getNonPhysicalEconomic());
    String nonPhysical = ParameterDAO.getCheckedStatus(pb.getNonPhysical());

	
	String projectdescription = pb.getProjectdescription();
	
	String contact1 = StringEscapeUtils.escapeHtml(pb.getContact(1));
	String contact2 = StringEscapeUtils.escapeHtml(pb.getContact(2));
	String contact3 = StringEscapeUtils.escapeHtml(pb.getContact(3));
	String email1 = StringEscapeUtils.escapeHtml(pb.getEmail(1));
	String email2 = StringEscapeUtils.escapeHtml(pb.getEmail(2));
	String email3 = StringEscapeUtils.escapeHtml(pb.getEmail(3));
	
	String worksheetfilename = pb.getWorksheetfilename();
	String url         = pb.getUrl();
	String tag = StringEscapeUtils.escapeHtml(pb.getTag());
	int code   = pb.getCode();
	
	boolean deleted = pb.isDeleted();
	
	String completed = "";
	String proposed = "";
	String ongoing = "";
	String planned = "";
	String unknown = "";
	
	int status = pb.getStatusCode();
	if (status == pb.ONGOING)
	{
	  ongoing = "checked";
	}
	else if (status == pb.PLANNED)
	{
	  planned = "checked";
	}
	else if (status == pb.PROPOSED)
	{
	  proposed = "checked";
	}
	else if (status == pb.COMPLETED)
	{
	  completed = "checked";
	}
	else
	{
	  unknown = "checked";
	}
	
    String leadagencyoptions = parameterDAO.getAgencyOptionsList(pb.getLeadagencies());
    String partneragencyoptions = parameterDAO.getAgencyOptionsList(pb.getPartneragencies());

%>
<%!
    /////////////////////////////////////////////////////////////////////////////
    // add as many HTML space tags (&nbsp;) between form elements like checkboxes 
    // as needed to make Projects Worksheet look like the one passed out at 
    // the September 2010 meeting

    public String addSpaceTags(int numberOfTags)
    {
      return ParameterDAO.getHTMLSpaceChar(numberOfTags);
    }

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>Pacific  Climate Information System (PaCIS)Summaries</title>
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
   <a href="http://www.noaaideacenter.org/" target="_blank">
    <img height="72" width="611" alt="Pacific Climate Information System (PaCIS)" title="PaCIS" src="images/noaapacislogo.jpg"/>
   </a>
   <div style="position:absolute;top:15px;left:660px;font-size:1.4em;font-weight: bold;">
    <a href="about.html" style="text-decoration: none;color:red;">Data &amp; Products Worksheet</a>
    <div style="font-size:.7em;font-weight:lighter;font-style:italic;font-variant:small-caps;color:red">
     Under active construction, <a href="javascript:window.location.reload()">press F5</a><br />to refresh and see latest.
    </div><!-- closes red coloring -->
   </div><!-- Closes PADB Title -->     
  </div><!-- Closes headitle -->
 </div><!-- Closes div id=header -->    
 
 <!-- All open HTML elements below and above and including the div=pageContainer are closed in the common footer.jsp -->


 <div id="contentArea">
  <table id="footerSiteMap">

     <!-- This header can changed by request dispatcher servlet based on which jsp it is choosing to render  -->
     <tr>
      <th class="boxHeader" colspan="5">
       PaCIS 2011 Data and Products Worksheet (Version 08.26.2011) 
       
<% 
   if (ParameterDAO.parse(request.getParameter("x"))) 
   {
%>
     <%= addSpaceTags(30) %> A D V A N C E D <%= addSpaceTags(5) %>S E A R C H<%= addSpaceTags(5) %> M O D E 
<%
   }
   else if (pb.getProjectnumber() == 0)
   {
%>
     <%= addSpaceTags(30) %> A D D <%= addSpaceTags(5) %> N E W <%= addSpaceTags(5) %>  R E C O R D 
<%
   }
   else
   {
 %>
     <%= addSpaceTags(30) %> U P D A T E <%= addSpaceTags(5) %>  R E C O R D 
<%
   }
%>        
      </th>
     </tr>

     <tr>
       <td>
       
       
       
       

        <form name="project" action="dataproducts" onsubmit="return checkform()" method="post">


        <br /><h2>Name/Title:</h2><br />
        
        <textarea name="projectname" rows="2" cols="80" tabindex="1"><%= projectname %></textarea><br /><br />



        <h2>Capability Area</h2>(select all that apply):<br />

        <input type="checkbox" name="variability"   tabindex="1"  value="y" <%= variability %> /> Understanding Climate Variability and Change<br />
        <input type="checkbox" name="effect"  <%= effect %> tabindex="1" value="y" /> Understanding Climate Impacts and Informing Adaptation<br /><br />

        <h2>Focus Area</h2>(select all that apply):<br />

        <input type="checkbox" name="fresh"    tabindex="1" <%= fresh %>  value="y" />  Fresh Water Resources and Drought <br />
        <input type="checkbox" name="coastal"  tabindex="1"  <%= coastal %>  value="y" />  Coastal Inundation/SLR, Extreme Weather, and Community Resilience <br />
        <input type="checkbox" name="marine"   tabindex="1" <%= marine %>  value="y" />  Marine and Terrestrial Ecosystems <br /><br />

        <h2>Region/Locale</h2>(select all that apply):<br />

        <input type="checkbox" name="central"  <%= central %> tabindex="1" onclick="checkCNP()" value="y" />  Central North Pacific:&nbsp;
         <input type="checkbox" name="hawaii"  <%= hawaii %> tabindex="1" onclick="checkHawaii()" value="y" />State of Hawai&#96;i:&nbsp;
         <input type="checkbox" name="big"  <%= big %>  tabindex="1" onclick="alsoCheckHawaii()" value="y" />Island of Hawai&#96;i,&nbsp;
         <input type="checkbox" name="maui" <%= maui %> tabindex="1" onclick="alsoCheckHawaii()" value="y" />Maui,&nbsp;
         <input type="checkbox" name="oahu" <%= oahu %> tabindex="1" onclick="alsoCheckHawaii()" value="y" />Oahu,&nbsp;
         <input type="checkbox" name="kauai" <%= kauai %> tabindex="1" onclick="alsoCheckHawaii()" value="y" />Kauai&nbsp;
         <input type="checkbox" name="hother" <%= hother %> tabindex="1" onclick="alsoCheckCNP()" value="y" />Other  (within Central North Pacific)<br />

         <input type="checkbox" name="western" <%= western %> tabindex="1" onclick="checkWNP()" value="y" />  Western North Pacific:
         <input type="checkbox" name="guam" <%= guam %> tabindex="1" onclick="alsoCheckWNP()" value="y" />Guam&nbsp;
         <input type="checkbox" name="cnmi" <%= cnmi %> tabindex="1" onclick="alsoCheckWNP()" value="y" />CNMI&nbsp;
         <input type="checkbox" name="fsm"  <%= fsm %> tabindex="1" onclick="alsoCheckWNP()" value="y" />FSM&nbsp;
         <input type="checkbox" name="rmi"  <%= rmi %> tabindex="1" onclick="alsoCheckWNP()" value="y" />RMI&nbsp;
         <input type="checkbox" name="palau" <%= palau %> tabindex="1" onclick="alsoCheckWNP()" value="y" />Palau&nbsp;
         <input type="checkbox" name="wother" <%= wother %> tabindex="1" onclick="alsoCheckWNP()" value="y" />Other (within Western North Pacific)<br />

        <input type="checkbox" name="south"  <%= south %>  tabindex="1" onclick="checkSP()" value="y" />  South Pacific: 
        <input type="checkbox" name="asam"   <%= asam %>  tabindex="1" onclick="alsoCheckSP()" value="y" />American S&#227;moa&nbsp;
        <input type="checkbox" name="samoa"  <%= samoa %>  tabindex="1" onclick="alsoCheckSP()" value="y" />S&#227;moa&nbsp;
        <input type="checkbox" name="tonga"  <%= tonga %> tabindex="1" onclick="alsoCheckSP()" value="y" />Tonga&nbsp;
        <input type="checkbox" name="fiji"   <%= fiji %> tabindex="1" onclick="alsoCheckSP()" value="y" />Fiji&nbsp;
        <input type="checkbox" name="oz"     <%= oz %> tabindex="1" onclick="alsoCheckSP()" value="y" />Australia&nbsp;
        <input type="checkbox" name="nz"     <%= nz %> tabindex="1" onclick="alsoCheckSP()" value="y" />New Zealand&nbsp;
        <input type="checkbox" name="fp"      <%= fp %>  tabindex="1" onclick="alsoCheckSP()" value="y" />French Polynesia&nbsp;
        <input type="checkbox" name="sother"  <%= sother %> tabindex="1" onclick="alsoCheckSP()" value="y" />Other (within South Pacific)<br />
        <input type="checkbox" name="otherregions"  <%= otherregions %>  tabindex="1" value="y" />  Other (Outside or Not Just Pertaining to Pacific Region)<br /><br /> 

        <h2>Essential Climate Variable (ECV class)</h2>(select all that apply):<br />

        <input type="checkbox" name="ecvatmospheric"    tabindex="1" <%= ecvAtmospheric %>  value="y" /> Atmospheric (e.g., Air Temperature, Rainfall, Wind speed and direction) <br />
        <input type="checkbox" name="ecvoceanic"  tabindex="1"  <%= ecvOceanic %>  value="y" /> Oceanic (e.g., Water Temperature, Salinity, Acidity, Sea Level, Wave Height) <br />
        <input type="checkbox" name="ecvterrestrial"   tabindex="1" <%= ecvTerrestrial %>  value="y" /> Terrestrial (e.g., Groundwater, Soil Moisture) <br /><br />

        <h2>Data- physical</h2>(select all that apply):<br />

        <input type="checkbox" name="phyinsitu"    tabindex="1" <%= phyInsitu %>  value="y" /> In-situ Observations <br />
        <input type="checkbox" name="physatellite"  tabindex="1"  <%= phySatellite %>  value="y" /> Satellite-Remote Observations <br />
        <input type="checkbox" name="phymodel"   tabindex="1" <%= phyModel %>  value="y" /> Model Results <br />
        <input type="checkbox" name="phyreanalysis"    tabindex="1" <%= phyReanalysis %>  value="y" /> Reanalysis Products <br />
        <input type="checkbox" name="phybathymetry"  tabindex="1"  <%= phyBathymetry %>  value="y" /> Bathymetry &amp; Topography <br />
        <input type="checkbox" name="phyimagery"   tabindex="1" <%= phyImagery %>  value="y" /> Imagery <br /><br />

        <h2>Products</h2>(select all that apply):<br />

        <input type="checkbox" name="prodhindcasts"    tabindex="1" <%= prodHindcasts %>  value="y" /> Hindcasts (climatologies) <br />
        <input type="checkbox" name="prodoutlooks"  tabindex="1"  <%= prodOutlooks %>  value="y" /> Outloooks (monthly to annual) <br />
        <input type="checkbox" name="prodprojections"   tabindex="1" <%= prodProjections %>  value="y" /> Projections (intrannual to multi-decadal) <br />
        <input type="checkbox" name="prodguidance"  tabindex="1"  <%= prodGuidance %>  value="y" /> Guidance, including “Best Practices” Manuals, Toolkits, and Guides <br />
        <input type="checkbox" name="prodapplications"   tabindex="1" <%= prodApplications %>  value="y" /> Applications, <strong>including Visualization and Decision Support Tools</strong> <br /><br />
        
        <h2>Data, Products, and Tools - Non-physical</h2>(select all that apply):<br />
        <input type="checkbox" name="enviro"    tabindex="1" <%= enviro %>  value="y" /> Environmental
        <input type="checkbox" name="socio"    tabindex="1" <%= socio %>  value="y" /> Socio-Cultural
        <input type="checkbox" name="econo"    tabindex="1" <%= econo %>  value="y" /> Economic
        <input type="checkbox" name="nonphysical"    tabindex="1" <%= nonPhysical %>  value="y" />Other <br /><br />
        
        <h2>Sector</h2>(select all that apply):<br />

        <input type="checkbox" name="phs"  <%= phs %> tabindex="1" value="y" />Public Health and Safety;
        <input type="checkbox" name="fwr"  <%= fwr %> tabindex="1" value="y" />Fresh Water Resources;
        <input type="checkbox" name="ene"  <%= ene %> tabindex="1" value="y" />Energy;<br/>
              
        <input type="checkbox" name="tcc"  <%= tcc %> tabindex="1" value="y" />Transportation/Communication, and Commerce;
        <input type="checkbox" name="cpd"  <%= cpd %> tabindex="1" value="y" />Community Planning &amp; Development;<br />
        
        <input type="checkbox" name="scr"  <%= scr %> tabindex="1" value="y" />Social and Cultural Resources;
        <input type="checkbox" name="afi"  <%= afi %> tabindex="1" value="y" />Agriculture and Fisheries;
        <input type="checkbox" name="rat"  <%= rat %> tabindex="1" value="y" />Recreation and Tourism;
        <input type="checkbox" name="eco"  <%= eco %> tabindex="1" value="y" />Ecosystems;<br />

        <input type="checkbox" name="oth"  <%= oth %> tabindex="1" value="y" />Other;<br /><br />
              

        <table border="1" cellpadding="0" cellspacing="0">
         <tr>
           <td>
             <h2>Lead Agencies, Institutions, Organizations:</h2><br />
             <select size="10" style="width:400px" name="leadagencies" 
                     onmouseout="disablePartners()"  tabindex="1" multiple="multiple">
              <%= leadagencyoptions %>
            </select><br/><br />
           </td>
           <td>
             <h2>Partner Agencies, Institutions, Organizations:</h2><br />
             <select size="10" style="width:400px;" name="partneragencies" 
                     onmouseout="disableLeaders()"  tabindex="1" multiple="multiple">
              <%= partneragencyoptions %>
             </select><br/><br />
           </td>
          </tr>
         </table><br /><br />


        <h2>Description:</h2><br />
        <textarea name="projectdescription" rows="5" cols="90" tabindex="1"><%= projectdescription %></textarea><br /><br />

        <h2>Contact(s):</h2><br />
        <table border="1" cellpadding="0" cellspacing="0">
         <tr>
           <td><h2>Names</h2></td>
           <td><h2>Emails</h2></td>
         </tr>
         <tr>
           <td>
            <input name="contact1"  tabindex="2" type="text" size="50" value="<%= contact1 %>" /> <br />
            <input name="contact2"  tabindex="4" type="text" size="50" value="<%= contact2 %>" /> <br />
            <input name="contact3"  tabindex="6" type="text" size="50" value="<%= contact3 %>" /> <br />
           </td>
           <td>
            <input name="email1"  tabindex="3" type="text" size="50" value="<%= email1 %>" /> <br />
            <input name="email2"  tabindex="5" type="text" size="50" value="<%= email2 %>" /> <br />
            <input name="email3"  tabindex="7" type="text" size="50" value="<%= email3 %>" /> <br />
           </td>
         </tr>
        </table><br /><br />

        <h2>Worksheet Filename:</h2><br />
        <input name="worksheetfilename"  tabindex="8" type="text" size="100" value="<%= worksheetfilename %>" />  <br /><br />
        
        <h2>URL:</h2><br />
        <input name="url"  tabindex="8" type="text" size="100" value="<%= url %>" />  <br /><br />
         <table border="1" cellpadding="0" cellspacing="0">
         <tr>
           <td nowrap="nowrap"><h2>Optional TEXT Label, Abbreviation etc:</h2></td>
           <td nowrap="nowrap"><h2>Optional NUMERIC, Code, List Sequence etc:</h2></td>
         </tr>
         <tr>
           <td>
            <input name="tag" type="text" size="30"  tabindex="9" value="<%= tag %>" />
           </td>
           <td>
            <input name="code" type="text" size="10"  tabindex="10" value="<%= code %>" />
           </td>
        </tr>
        </table>
        <br /><br />
        
<% 
   if (ParameterDAO.parse(request.getParameter("x"))) 
   {
%>
     <input type="hidden" name="searchbyx" value="true"></input>
     <input type="submit" value="Advanced Search"></input>
<%
   }
   else if (pb.getProjectnumber() == 0)
   {
%>
     <input type="hidden" name="addnew" value="true"></input>
     <input type="submit" value="Add Project"></input>
<%
   }
   else
   {
 %>  
     <input type="hidden" name="id" value="<%= NumberUtils.toInt(id) %>"></input>
     <input type="hidden" name="updated" value="true"></input>
     <input type="submit" value="Update Project"></input>
<%
   }
%>       
        <input type="reset" />


        </form>
   

<%@ include file="footer.jsp" %>