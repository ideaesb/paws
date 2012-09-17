 <div id="footer">
<%!
 private String getLogoUrl(String url, String img, String alt)
 {
   if (StringUtils.startsWith(url, "http://"))
   {
     return "<a href=\"" + url + "\"  target=\"_blank\">" + 
            "<img src=\"marquee/" + img + "\" alt=\"" + alt + "\" style=\"border-style: none\" /></a>";
   }
   else
   {  
 
     return "<a href=\"http://www." + url + "\"  target=\"_blank\">" + 
            "<img src=\"marquee/" + img + "\" alt=\"" + alt + "\" style=\"border-style: none\" /></a>";
   }  
 }
 %>
  
 <marquee behavior="scroll" direction="left"><!-- scrollamount="10" scrolldelay="500" -->
<%= getLogoUrl("pacificcis.org", "pacislogo.jpg", "PaCIS") %>
<%= getLogoUrl("piccc.net", "picccHorizontal.jpg", "PICCC") %>
<%= getLogoUrl("pacificrisa.org", "risa.jpg", "PacificRISA") %>
<%= getLogoUrl("primohui.org", "Primo.jpg", "PRiMO") %>
<%= getLogoUrl("bom.gov.au/climate/", "image001.jpg", "BOM") %>
<%= getLogoUrl("csiro.au", "image002.jpg", "CSIRO") %>
<%= getLogoUrl("eastwestcenter.org", "image007.jpg", "EWC") %>
<%= getLogoUrl("http://iprc.soest.hawaii.edu/", "image055.jpg", "IPRC") %>
<%= getLogoUrl("meteo.pf", "image010.jpg", "Mateo France") %>
<%= getLogoUrl("metservice.com", "image011.jpg", "New Zealand Met Service") %>
<%= getLogoUrl("niwa.co.nz", "image012.jpg", "NIWA") %>
<%= getLogoUrl("climate.noaa.gov", "image028.jpg", "CPO") %>
<%= getLogoUrl("cpc.ncep.noaa.gov", "image021.jpg", "CPC") %>
<%= getLogoUrl("pifsc.noaa.gov", "image016.jpg", "PIFSC") %>
<%= getLogoUrl("fpir.noaa.gov", "image017.jpg", "PIRO") %>
<%= getLogoUrl("prh.noaa.gov/peac/", "image030.jpg", "PEAC") %>
<%= getLogoUrl("climate.gov", "image019.jpg", "NCS") %>
<%= getLogoUrl("csc.noaa.gov/psc/", "image020.jpg", "PSC") %>
<%= getLogoUrl("pacioos.org", "image057.jpg", "PacIOOS") %>
<%= getLogoUrl("pi-gcos.org", "image035.jpg", "PI-GCOS") %>
<%= getLogoUrl("sopac.org", "image041.jpg", "SoPAC") %>
<%= getLogoUrl("sprep.org", "image042.jpg", "SPREP") %>
<%= getLogoUrl("prel.org", "image039.jpg", "PREL") %>
<%= getLogoUrl("http://seagrant.soest.hawaii.edu/", "image059.jpg", "UH Seagrant") %>
<%= getLogoUrl("ssri.hawaii.edu", "image061.jpg", "SSRI") %>
<%= getLogoUrl("pacom.mil", "image049.jpg", "PaCOM") %>
<%= getLogoUrl("uog.edu/dynamicdata/CenterforIslandSustainability.aspx", "image050.jpg", "Guam") %>
<%= getLogoUrl("soest.hawaii.edu/", "image058.jpg", "SOEST") %>
<%= getLogoUrl("soest.hawaii.edu/jimar/", "image056.jpg", "JIMAR") %>
<%= getLogoUrl("fema.gov", "image046.jpg", "FEMA") %>
<%= getLogoUrl("fws.gov/pacificislands/", "image044.jpg", "PIFWO") %>
<%= getLogoUrl("http://hi.water.usgs.gov/", "image045.jpg", "USGS") %>
<%= getLogoUrl("http://science.nature.nps.gov/im/", "image047.jpg", "NPS Monitoring") %>
<%= getLogoUrl("http://science.nature.nps.gov/im/units/pacn/", "image048.jpg", "PACN") %>
<%= getLogoUrl("http://wrcc.dri.edu/", "image063.jpg", "WRCC") %>
<%= getLogoUrl("http://www.adaptationpartnership.org/", "adaptation.jpg", "Adaptation Partnership") %>
  </marquee>
</div> 