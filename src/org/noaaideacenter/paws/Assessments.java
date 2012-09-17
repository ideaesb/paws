package org.noaaideacenter.paws;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.math.NumberUtils;



public class Assessments 
{
	
	private List<Assessment>m_assessments = null; 

	
	 public List<Assessment> getList(String [] assessments, String [] applicabilities, String [] focii, String [] regions)
	 {
		 Assessment filter = new Assessment();
		 
		 
		 if (assessments != null && assessments.length > 0)
		 {
			 for (int i = 0; i < assessments.length; i++)
			 {
				 int assessment = NumberUtils.toInt(assessments[i]);
				 
				 if (assessment == 0)
				 {
					 break;
				 }
				 else if (assessment == 1)
				 {
					 filter.setScience(true);
				 }
				 else if (assessment == 2)
				 {
					 filter.setNeedsCapabilities(true);
				 }
				 else if (assessment == 3)
				 {
					 filter.setRisk(true);
				 }
			 }
		 }
		 
		 
		 
		 if (applicabilities != null && applicabilities.length > 0)
		 {
			 for (int i = 0; i < applicabilities.length; i++)
			 {
				 int applicability = NumberUtils.toInt(applicabilities[i]);

				 if (applicability == 0)
				 {
					 break;
				 }
				 else if (applicability == 1)
				 {
					 filter.setInternational(true);
				 }
				 else if (applicability == 2)
				 {
					 filter.setRegional(true);
				 }
				 else if (applicability == 3)
				 {
					 filter.setLocal(true);
				 }
			 }
		 }
		 
		 
		 
		 
		 if (focii != null && focii.length > 0)
		 {
			 for (int i = 0; i < focii.length; i++)
			 {
				 int focus = NumberUtils.toInt(focii[i]);

				 if (focus == 0)
				 {
					 break;
				 }
				 else if (focus == 1)
				 {
					 filter.setFresh(true);
				 }
				 else if (focus == 2)
				 {
					 filter.setCoastal(true);
				 }
				 else if (focus == 3)
				 {
					 filter.setMarine(true);
				 }
			 }
		 }

		 
         if (regions != null && regions.length > 0)
         {
         	for (int i = 0; i < regions.length; i++)
         	{
         		int region =  NumberUtils.toInt(regions[i]);
         		
         		if (region == 0)
         		{
         			break;
         		}
         		else if (region == 1)
         		{
         			filter.setCnp(true);
         		}
         		else if (region == 2)
         		{
         			filter.setWnp(true);
         		}
         		else if (region == 3)
         		{
         			filter.setSp(true);
         		}
         		else if (region == 4)
         		{
         			filter.setOtherRegion(true);
         		}
         		else
         		{
         			
         		}
         		
         	}
         }
		 
         
         Vector<Assessment> v = new Vector<Assessment>();
         
         Iterator <Assessment> assIterator = this.m_assessments.iterator();
         while (assIterator.hasNext())
         {
             Assessment a = assIterator.next();
             if (filter.filterTest(a))
             {
            	 v.addElement(a);
             }
         }
         
         return v;
         
	 }
	
	
	 ///////////////////////////////////////////////////////////////////////////////////////
	 //  Popoulate the assessments 
	 //  

	 /**
	  *  As soon as the assessments.jsp is called, this empty constructor will have all the assessments needed and 
	  *  populate the member variable assessments list  
	  */
		public Assessments()
		{
		     Vector<Assessment> v = new Vector<Assessment>(); 
		     Vector<String> regions = new Vector<String>();
		     
		     
		     Assessment a = new Assessment();
		     
		     a.setName("IPRC Climate Science International");
		     a.setWorksheet("PaCIS%20Assessment-IPRC_Climate Science_International.doc");
		     
		     StringBuffer sb = new StringBuffer();
		     sb.append("Research activities at the IPRC include a wide range of climate studies for the region.");
		     sb.append("  These include climate model assessment/analysis, regional modeling, and analysis of observations.");
		     a.setDescription(sb.toString()); 
		     
		     
             a.setStatus(a.ONGOING);
             
             a.setScience(true);
             
             a.setInternational(true);
             
             a.setFresh(true);
             a.setCoastal(true);
             a.setMarine(true);
		     
		     a.setCnp(true); a.setWnp(true); a.setSp(true);
		     regions.addElement("Central North Pacific");
		     regions.addElement("Western North Pacific");
		     regions.addElement("South Pacific");
		     a.setRegion(regions); regions.removeAllElements();
		     
		     a.setAgency("SOEST/IPRC");
		     a.setAgencyUrl("http://iprc.soest.hawaii.edu/");
		     
		     a.setContact("Jim Potemra");
		     a.setEmail("jimp@hawaii.edu");
		     
		     v.addElement(a); 
		     
		     
		     Assessment b = new Assessment();
		     b.setName("IPRC Climate Science National");
		     b.setWorksheet("PaCIS%20Assessment-IPRC_Climate Science_National.doc");

		     sb = new StringBuffer();
		     sb.append("Research activities in the regional Ocean Observing System (PacIOOS) include all components of the marine environment,");
		     sb.append(" and extends to the terrestrial as it impacts the near-shore (e.g., precipitation and stream runoff).");
		     b.setDescription(sb.toString());
		     
		     
             b.setStatus(a.ONGOING);
             
             b.setScience(true);
             
             b.setRegional(true);
             
             b.setFresh(true);
             b.setCoastal(true);
             b.setMarine(true);
		     
		     b.setCnp(true);
		     b.setWnp(true);
		     b.setSp(true);
		     regions.addElement("Central North Pacific - State of Hawai`i");
		     regions.addElement("Western North Pacific - Guam, CNMI, FSM, RMI, Palau");
		     regions.addElement("South Pacific - American Samoa");
		     b.setRegion(regions); regions.removeAllElements();
		     
		     b.setAgency("SOEST/IPRC");
		     b.setAgencyUrl("http://iprc.soest.hawaii.edu/");
		     
		     b.setContact("Jim Potemra");
		     b.setEmail("jimp@hawaii.edu");
		     
		     v.addElement(b); 
		     

		     Assessment c = new Assessment();
		     c.setName("IPRC Climate Science State");
		     c.setWorksheet("PaCIS%20Assessment-IPRC_Climate Science_State.doc");

		     sb = new StringBuffer();
		     sb.append("Similar to PacIOOS, research activities in the sub-regional Ocean Observing System (HIOOS) include all components of the marine environment,");
		     sb.append(" and extends to the terrestrial as it impacts the near-shore (e.g., precipitation and stream runoff).  At present HIOOS is primarily focused on Oahu.");
		     c.setDescription(sb.toString());
		     
		     
             c.setStatus(a.ONGOING);
             
             c.setScience(true);
             
             c.setLocal(true);
             
             c.setFresh(true);
             c.setCoastal(true);
             c.setMarine(true);
		     
		     c.setCnp(true);
		     regions.addElement("Central North Pacific - State of Hawai`i - Island of Oahu");
		     c.setRegion(regions); regions.removeAllElements();
		     
		     c.setAgency("SOEST/IPRC");
		     c.setAgencyUrl("http://iprc.soest.hawaii.edu/");
		     
		     c.setContact("Jim Potemra");
		     c.setEmail("jimp@hawaii.edu");
		     
		     v.addElement(c); 

		     Assessment d = new Assessment();
		     d.setName("IPRC Products International");
		     d.setWorksheet("PaCIS%20Assessment-IPRC_Products_International.doc");

		     sb = new StringBuffer();
		     sb.append("The APDRC works closely with both PI-GOOS and PacIOOS (all three running data services) to provide data and data products to the Pacific.");
		     d.setDescription(sb.toString());
		     
		     
             d.setStatus(a.ONGOING);
             
             d.setCapabilities(true);
             
             d.setInternational(true);
             
             d.setFresh(true);
             d.setCoastal(true);
             d.setMarine(true);
		     
		     d.setCnp(true); d.setWnp(true); d.setSp(true); 
		     regions.addElement("Central North Pacific");
		     regions.addElement("Western North Pacific");
		     regions.addElement("South Pacific");
		     d.setRegion(regions); regions.removeAllElements();
		     
		     d.setAgency("SOEST/IPRC/APDRC");
		     d.setAgencyUrl("http://apdrc.soest.hawaii.edu ");
		     
		     d.setContact("Jim Potemra");
		     d.setEmail("jimp@hawaii.edu");
		     
		     v.addElement(d); 
		     

		     Assessment e = new Assessment();
		     e.setName("IPRC Products State");
		     e.setWorksheet("PaCIS%20Assessment-IPRC_Products_State.doc");

		     sb = new StringBuffer();
		     sb.append("PacIOOS data services are being developed to supply data and information to end users in the Pacific.");
		     e.setDescription(sb.toString());
		     
		     
             e.setStatus(a.ONGOING);
             
             e.setCapabilities(true);
             
             e.setRegional(true);
             
             e.setFresh(true);
             e.setCoastal(true);
             e.setMarine(true);
		     
		     e.setCnp(true); e.setWnp(true); e.setSp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii");
		     regions.addElement("Western North Pacific - Guam, CNMI, FSM, RMI, Palau");
		     regions.addElement("South Pacific - American Samoa");
		     e.setRegion(regions); regions.removeAllElements();
		     
		     e.setAgency("PacIOOS");
		     e.setAgencyUrl("http://pacioos.org/");
		     
		     e.setContact("Jim Potemra");
		     e.setEmail("jimp@hawaii.edu");
		     
		     v.addElement(e); 
		     
		     

		     Assessment f = new Assessment();
		     f.setName("National Disaster Preparedness Training Center (NDPTC)");
		     f.setWorksheet("PaCIS%20Assessment-NDPTC.doc");

		     sb = new StringBuffer();
		     sb.append("<p><strong>Disaster Management and Humanitarian Assistance Graduate Certificate Program</strong></p>");
		     sb.append("<p>In Fall 2009 the NDPTC, in partnership with the Department of Urban and Regional Planning at the "); 
		     sb.append("UH Manoa, conducted a training needs assessment in the development of its programs and services.  ");  
		     sb.append("With an initial focus on natural disasters (including climate impacts) and coastal and island "); 
		     sb.append("communities, the needs assessment targeted respondents in Hawaii, Oregon, Washington, Guam, ");  
		     sb.append("Commonwealth of the Northern Mariana Islands (CNMI), Republic of the Marshall Islands (RMI), ");  
		     sb.append("Federated States of Micronesia (FSM) and American Samoa. One of the key findings was that there are "); 
		     sb.append("significant unmet training needs in the area of natural disasters. The frequency and high profile of "); 
		     sb.append("recent natural disasters have resulted in a growing concern about natural disaster preparedness, "); 
		     sb.append("response and recovery among agencies, organizations and the public. A number of respondents noted that ");  
		     sb.append("the first responders were, in reality, the citizens who were often ill equipped to deal with the disaster.  ");  
		     sb.append("The top three general unmet training needs were related to natural disaster response, recovery and protection "); 
		     sb.append("and encompassed a broad spectrum, ranging from awareness, risk assessment, and mitigation to response and recovery.");  
		     sb.append("Many advocated the inclusion of non-governmental organizations and the general public in trainings, ");
		     sb.append("and to increase training for public communication and awareness of natural disasters.</p>"); 
		     f.setDescription(sb.toString());
		     
		     
             f.setStatus(f.COMPLETED);
             
             f.setNeeds(true); f.setCapacity(true);f.setCapabilities(true);
             
             f.setInternational(true); f.setRegional(true); f.setLocal(true);
             
             f.setFresh(true); f.setCoastal(true);
		     
		     f.setCnp(true); f.setWnp(true); f.setSp(true); f.setOtherRegion(true); 
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Hawaii, Island of Kauai, Island of Oahu");
		     regions.addElement("Western North Pacific - Guam, CNMI, FSM, RMI");
		     regions.addElement("South Pacific - American Samoa");
		     regions.addElement("Other - State of Washington, Oregon");
		     f.setRegion(regions); regions.removeAllElements();
		     
		     f.setAgency("NDPTC");
		     f.setAgencyUrl("http://www.durp.hawaii.edu/Disaster%20Management.html");
		     
		     f.setContact("Karl Kim");
		     f.setEmail("karlk@hawaii.edu");
		     
		     v.addElement(f); 
		     
		     

		     Assessment g = new Assessment();
		     g.setName("Central Oahu Watershed Decision-Maker Assessment");
		     g.setWorksheet("PaCIS%20Assessment-Pacific%20RISA.doc");

		     sb = new StringBuffer();
		     sb.append("This project is conducted in support of the National Climate Assessment and aims to identify stakeholders, ");
		     sb.append("their climate-sensitive decisions, and climate information needs and usage related to fresh water management ");
		     sb.append("in the Central Oahu Watershed.");
		     g.setDescription(sb.toString());
		     
		     
             g.setStatus(g.ONGOING);
             
             g.setNeeds(true); g.setCapabilities(true); g.setRisk(true);
             
             g.setLocal(true);
             
             g.setFresh(true);
		     
		     g.setCnp(true);
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Oahu");
		     g.setRegion(regions); regions.removeAllElements();
		     
		     g.setAgency("Pacific RISA");
		     g.setAgencyUrl("http://www.pacificrisa.org/");
		     
		     g.setContact("Melissa Finucane");
		     g.setEmail("FinucanM@EastWestCenter.org");
		     
		     v.addElement(g); 
		     
		     

		     Assessment h = new Assessment();
		     h.setName("National Park Service Pacific Island Inventory and Monitoring Network");
		     h.setWorksheet("PaCIS%20Assessment-PACN_NPS.doc");

		     sb = new StringBuffer();
		     sb.append("Primarily operating within Pacific Islands National Parks, this program initially undertook an assessment");
		     sb.append("of inventory and monitoring needs to identify baselines inventories necessary and also the ecological ");
		     sb.append("indicators (Vital Signs).  Systematically measure long-term to evaluate trends in resource conditions. ");
		     sb.append("One such inventory was weather/climate, which is guiding the planned establishment of 10 new weather stations. ");
		     sb.append("Other Vital signs are biological or physical and integrated as well as possible. ");
		     sb.append("Contribute to park condition assessments and other park planning/management activities.");
		     h.setDescription(sb.toString());
		     
		     
             h.setStatus(h.ONGOING);
             
             h.setScience(true); h.setRisk(true);
             
             h.setLocal(true);
             
             h.setFresh(true); h.setMarine(true);
		     
		     h.setCnp(true); h.setWnp(true); h.setSp(true);
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Hawaii, Island of Molokai");
		     regions.addElement("Western North Pacific - Guam");
		     regions.addElement("South Pacific - American Samoa");
		     h.setRegion(regions); regions.removeAllElements();
		     
		     h.setAgency("National Park Service (NPS) Inventory &amp; Monitoring Pacific Island Network (PACN)");
		     h.setAgencyUrl("http://science.nature.nps.gov/im/units/pacn/index.cfm");
		     
		     h.setContact("Greg Kudray");
		     h.setEmail("Greg_Kudray@nps.gov");
		     
		     v.addElement(h); 
		     
		     


		     Assessment i = new Assessment();
		     i.setName("Saipan Aquifers Conservation");
		     i.setWorksheet("PaCIS%20Assessment-Saipan%20Aquifer%20Conservation.doc");

		     sb = new StringBuffer();
		     sb.append("Leak detection, repair and replacement of water utility replacement lines.  ");
		     sb.append("CUC is the only utility on U.S. soil that cannot provide 24/7 water service to all customers.  ");
		     sb.append("Quality of water is brackish for most customers.   Reducing demand and leaks conserves aquifers "); 
		     sb.append("and improves drinking water quality.");
		     i.setDescription(sb.toString());
		     
		     
             i.setStatus(h.ONGOING);
             
             i.setNeeds(true);
             
             i.setLocal(true);
             
             i.setFresh(true);
		     
		     i.setWnp(true); 
		     regions.addElement("Western North Pacific - CNMI");
		     i.setRegion(regions); regions.removeAllElements();
		     
		     i.setAgency("Commonwealth Utilities Corporation, CNMI");
		     i.setAgencyUrl("http://cuccnmi.net/");
		     
		     i.setContact("Abe Malae");
		     i.setEmail("abe_malae@cucgov.net");
		     
		     v.addElement(i); 
		     
		     


		     Assessment j = new Assessment();
		     j.setName("Storm Prep Typhoon Alley");
		     j.setWorksheet("PaCIS%20Assessment-Storm%20Prep%20Typhoon%20Alley.doc");

		     sb = new StringBuffer();
		     sb.append("Typhoon Alley (Guam-CNMI) boundaries appear to be shifting westward towards the Philippines.  ");
		     sb.append("CUC would like to stay on top of typhoon forecasting in order to better prepare power, water, and wastewater infrastructure.");
		     j.setDescription(sb.toString());
		     
		     
             j.setStatus(h.ONGOING);
             
             j.setScience(true);j.setNeeds(true);
             
             j.setLocal(true);
             
             j.setFresh(true);
		     
		     j.setWnp(true); 
		     regions.addElement("Western North Pacific - CNMI");
		     j.setRegion(regions); regions.removeAllElements();
		     
		     j.setAgency("Commonwealth Utilities Corporation, CNMI");
		     j.setAgencyUrl("http://cuccnmi.net/");
		     
		     j.setContact("Abe Malae");
		     j.setEmail("abe_malae@cucgov.net");
		     
		     v.addElement(j); 
		     


		     Assessment k = new Assessment();
		     k.setName("U.S. Army Corps of Engineers (USACE)");
		     k.setWorksheet("PaCIS%20Assessment-USACE.doc");

		     sb = new StringBuffer();
		     sb.append("The purpose of the USACE assessment is to identify the information and data gaps that the Corps needs ");
		     sb.append("to determine the potential impacts of climate change on the vulnerability of USACE projects and mission."); 
		     sb.append("The mission areas, for PaCIS assessment, include: Flood Control, Ecosystem Restoration, and Navigation, ");
		     sb.append("all of which have potential impacts from sea level rise, changes in storminess, and the ");
		     sb.append("habitat of sea life and terrestrial life in their respective ecosystem.  ");
		     sb.append("A preliminary assessment of climate change activities being undertaken by other agencies and how these ");
		     sb.append("relate to Corps&quot; projects and missions will also be developed.  ");
		     k.setDescription(sb.toString());
		     
		     
             k.setStatus(h.ONGOING);
             
             k.setNeeds(true); k.setRisk(true);
             
             k.setLocal(true);
             
             k.setCoastal(true);k.setMarine(true);
		     
		     k.setCnp(true);k.setWnp(true);k.setSp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii");
		     regions.addElement("Western North Pacific - Guam, CNMI, FSM");
		     regions.addElement("South Pacific - American Samoa");
		     k.setRegion(regions); regions.removeAllElements();
		     
		     k.setAgency("U.S. Army Corps of Engineers (USACE), Pacific Ocean Division (POD)");
		     k.setAgencyUrl("http://www.pod.usace.army.mil/");
		     
		     k.setContact("Deborah Solis");
		     k.setEmail("Deborah.A.Solis@usace.army.mil");
		     
		     v.addElement(k); 
		     
		     

		     Assessment l = new Assessment();
		     l.setName("Groundwater Availability in Central Maui, Hawaii");
		     l.setWorksheet("PaCIS%20Assessment-USGS_C%20Maui_Groundwater.doc");

		     sb = new StringBuffer();
		     sb.append("The objectives of this study were to: ");
		     sb.append("(1) obtain a better understanding of the regional groundwater flow system in the study area, ");
		     sb.append("(2) estimate groundwater recharge in the study area, and ");
		     sb.append("(3) estimate the effects of selected withdrawal scenarios, using a numerical groundwater flow and transport model, ");
		     sb.append("on water levels, the transition zone between freshwater and saltwater, ");
		     sb.append("and surface-water/groundwater interactions in the main area of interest."); 
		     l.setDescription(sb.toString());
		     
		     
             l.setStatus(l.COMPLETED);
             
             l.setNeeds(true); l.setCapacity(true);
             
             l.setLocal(true);
             
             l.setFresh(true);
		     
		     l.setCnp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Maui");
		     l.setRegion(regions); regions.removeAllElements();
		     
		     l.setAgency("USGS Pacific Islands Water Science Center");
		     l.setAgencyUrl("http://hi.water.usgs.gov/studies/groundwatermaui/");
		     
		     l.setContact("Stephen Gingerich");
		     l.setEmail("sbginger@usgs.gov");
		     
		     v.addElement(l); 
		     

		     Assessment m = new Assessment();
		     m.setName("Groundwater Recharge and Availability in Eastern Molokai, Hawaii");
		     m.setWorksheet("PaCIS%20Assessment-USGS_E Molokai_Groundwater.doc");

		     sb = new StringBuffer();
		     sb.append("The overall objective of this study is to estimate the hydrologic effects ");
		     sb.append("of additional groundwater-withdrawal scenarios on ");
		     sb.append("(1) salinity and water levels near existing wells and (2) coastal discharge");
		     m.setDescription(sb.toString());
		     
		     
             m.setStatus(m.ONGOING);
             
             m.setNeeds(true); m.setCapacity(true);
             
             m.setLocal(true);
             
             m.setFresh(true);
		     
		     m.setCnp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Molokai");
		     m.setRegion(regions); regions.removeAllElements();
		     
		     m.setAgency("USGS Pacific Islands Water Science Center");
		     m.setAgencyUrl("http://hi.water.usgs.gov/studies/molokai/");
		     
		     m.setContact("Delwyn Oki");
		     m.setEmail("dsoki@usgs.gov");
		     
		     v.addElement(m); 
		     
		     

		     Assessment n = new Assessment();
		     n.setName("Groundwater Availability in Guam");
		     n.setWorksheet("PaCIS%20Assessment-USGS_Guam_Groundwater.doc");

		     sb = new StringBuffer();
		     sb.append("The goals of this study are to ");
		     sb.append("(1) advance the understanding of regional groundwater dynamics in the Northern Guam Lens Aquifer, ");
		     sb.append("(2) provide a new estimate of groundwater recharge for the entire island, and ");
		     sb.append("(3) develop a numerical groundwater flow and transport model for northern Guam ");
		     sb.append("that will serve as a tool to assist water-resource managers in estimating ");
		     sb.append("the effects of selected groundwater-pumping and climate scenarios on the water supply.  ");
		     sb.append("Although the main area of interest is the Northern Guam Lens Aquifer, ");
		     sb.append("the study will also provide a new water-budget estimate of recharge for southern Guam.");
		     n.setDescription(sb.toString());
		     
		     
             n.setStatus(n.ONGOING);
             
             n.setNeeds(true); n.setCapacity(true);
             
             n.setLocal(true);
             
             n.setFresh(true);
		     
		     n.setWnp(true); 
		     regions.addElement("Western North Pacific - Guam");
		     n.setRegion(regions); regions.removeAllElements();
		     
		     n.setAgency("USGS Pacific Islands Water Science Center");
		     n.setAgencyUrl("http://hi.water.usgs.gov/studies/guam/");
		     
		     n.setContact("Stephen Gingerich");
		     n.setEmail("sbginger@usgs.gov");
		     
		     v.addElement(n); 
		     
		     
		     
		     

		     Assessment o = new Assessment();
		     o.setName("Trends in Streamflow Characteristics at Long-term Gaging Stations in Hawaii");
		     o.setWorksheet("PaCIS%20Assessment-USGS_Guam_Groundwater.doc");

		     sb = new StringBuffer();
		     sb.append("The objectives of this study are to obtain a better understanding of ");
		     sb.append("(1) long-term trends and variations in streamflow, and (2) impacts on groundwater availability.");
		     o.setDescription(sb.toString());
		     
		     
             o.setStatus(n.ONGOING);
             
             o.setScience(true);
             
             o.setLocal(true);
             
             o.setFresh(true);
		     
		     o.setCnp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii");
		     o.setRegion(regions); regions.removeAllElements();
		     
		     o.setAgency("USGS Pacific Islands Water Science Center");
		     o.setAgencyUrl("http://pubs.usgs.gov/sir/2004/5080/");
		     
		     o.setContact("Delwyn Oki");
		     o.setEmail("dsoki@usgs.gov");
		     
		     v.addElement(o); 
		     
		     
		     
		     
	     
		     

		     Assessment p = new Assessment();
		     p.setName("Effects of Groundwater Withdrawal, Injection, and Climate Change on Water Resources at Kaloko-Honokohau");
		     p.setWorksheet("PaCIS%20Assessment-USGS_Kaloko_Groundwater.doc");

		     sb = new StringBuffer();
		     sb.append("The Kaloko-Honokohau National Historical Park in the island of Hawaii supports a diversity of aquatic ");
		     sb.append("habitats. High-quality ground water is essential to maintain these habitats, which are immediately ");
		     sb.append("threatened by sudden and substantial urban development contiguously surrounding the Park.  ");
		     sb.append("The objective of this study is to evaluate the effects of selected anthropogenic and natural factors ");
		     sb.append("on Park resources.  These factors include, ");
		     sb.append("(1) ground-water withdrawals from and reverse osmosis concentrate injection into the aquifer in the immediate vicinity of the Park, ");
		     sb.append("(2) reduced regional ground-water flow caused by upgradient withdrawals or climate change, and ");
		     sb.append("(3) long-term sea-level change.");
		     p.setDescription(sb.toString());
		     
		     
             p.setStatus(n.ONGOING);
             
             p.setNeeds(true);p.setCapacity(true);
             
             p.setLocal(true);
             
             p.setFresh(true);
		     
		     p.setCnp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Hawaii");
		     p.setRegion(regions); regions.removeAllElements();
		     
		     p.setAgency("USGS Pacific Islands Water Science Center");
		     p.setAgencyUrl("http://hi.water.usgs.gov/");
		     
		     p.setContact("Delwyn Oki");
		     p.setEmail("dsoki@usgs.gov");
		     
		     v.addElement(p); 
		     
		     
		     
		     
		     
		     Assessment q = new Assessment();
		     q.setName("Groundwater Availability in Lahaina District, Maui, Hawaii");
		     q.setWorksheet("PaCIS%20Assessment-USGS_Lahaina_Groundwater.doc");

		     sb = new StringBuffer();
		     sb.append("The objectives of this study are to ");
		     sb.append("estimate the effects of selected withdrawal scenarios within the Lahaina area, ");
		     sb.append("using a numerical groundwater flow and transport model, on water levels, ");
		     sb.append("the transition zone between freshwater and saltwater, and surface-water/groundwater interactions.");
		     q.setDescription(sb.toString());
		     
		     
             q.setStatus(q.COMPLETED);
             
             
             q.setNeeds(true); q.setCapacity(true);
             
             q.setLocal(true);
             
             q.setFresh(true);
		     
		     q.setCnp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Maui");
		     q.setRegion(regions); regions.removeAllElements();
		     
		     q.setAgency("USGS Pacific Islands Water Science Center");
		     q.setAgencyUrl("http://hi.water.usgs.gov/studies/lahaina/");
		     
		     q.setContact("Stephen Gingerich");
		     q.setEmail("sbginger@usgs.gov");
		     
		     v.addElement(q); 
		     
		     
		     
	     
		     
		     Assessment r = new Assessment();
		     r.setName("Groundwater Recharge and Availability in the Pearl Harbor Aquifer, Oahu, Hawaii");
		     r.setWorksheet("PaCIS%20Assessment-USGS_Pearl%20Harbor_Groundwater.doc");

		     sb = new StringBuffer();
		     sb.append("The overall objective of this study is to ");
		     sb.append("develop a tool that can be used to ");
		     sb.append("(1) effectively manage ground-water pumping from the Pearl Harbor aquifer and ");
		     sb.append("(2) develop long-range plans for future development of resources in the ");
		     sb.append("Pearl Harbor aquifer as well as planning for alternate sources of fresh water.  ");
		     sb.append("The tool will be in the form of a three-dimensional numerical ground-water model ");
		     sb.append("capable of simulating the distribution of salinity in the aquifer and the ");
		     sb.append("response of the freshwater lens to user-specified pumping conditions. ");
		     r.setDescription(sb.toString());
		     
		     
             r.setStatus(r.ONGOING);
             
             
             r.setNeeds(true); r.setCapacity(true);
             
             r.setLocal(true);
             
             r.setFresh(true);
		     
		     r.setCnp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii - Island of Oahu");
		     r.setRegion(regions); regions.removeAllElements();
		     
		     r.setAgency("USGS Pacific Islands Water Science Center");
		     r.setAgencyUrl("http://hi.water.usgs.gov/");
		     
		     r.setContact("Delwyn Oki");
		     r.setEmail("dsoki@usgs.gov");
		     
		     v.addElement(r); 
		     
		     
		     Assessment s = new Assessment();
		     s.setName("Climate Change Assessment in Small Pacific Island States (CCASP)");
		     s.setWorksheet("PaCIS%20Assessment-CCASP.doc");

		     sb = new StringBuffer();
		     sb.append("Small Island Developing States (SIDS) are recognized under the United Nations Framework for Climate Change as being the most vulnerable parties to the adverse impacts of climate change. The key outcomes of this project are to enhance scientific, economic and human adaptive capacity of Pacific SIDS to climate change and related hazards risks, with specific focus on CCA to tropical cyclones, sea level rise and storm surges, vulnerability and impact assessments of climate sensitive sectors (tourism, fisheries and agriculture) through the application of participatory approaches, economic analysis of the implication of global climate change policies and measures on Pacific SIDS, in terms of their potential participation in the international carbon market and transfer and diffusion of clean technologies and to improve links between climate change science and policy communities.");
		     s.setDescription(sb.toString());
		     
		     
             s.setStatus(s.PLANNED);
             
             
             s.setCapacity(true);
             
             s.setRegional(true);
             
             s.setFresh(true); s.setCoastal(true); s.setMarine(true);
		     
		     s.setWnp(true);  s.setSp(true); 
		     regions.addElement("Western North Pacific - FSM, RMI, Palau, Other");
		     regions.addElement("South Pacific - Samoa, Tonga, Fiji, Other");
		     s.setRegion(regions); regions.removeAllElements();
		     
		     s.setAgency("Pacific SIDS CLIPAC Task Force");
		     
		     s.setContact("Penehuro Lefale");
		     s.setEmail("pene.lefale@metservice.com");

		     v.addElement(s); 

		     
		     
		     Assessment t = new Assessment();
		     t.setName("Pacific Islands Regional Climate Assessment (PIRCA)");
		     t.setWorksheet("PaCIS%20Assessment-PIRCA.doc");

		     sb = new StringBuffer();
		     sb.append("The PIRCA is a collaborative effort aimed at assessing the state of climate knowledge, impacts, and adaptive capacity in Hawaii and the U.S.-Affiliated Pacific Islands. The PIRCA engages federal, state, and local government agencies, non-government organizations, businesses, and community groups to inform and prioritize their activities in the face of a changing climate. The PIRCA will examine impacts and adaptive capacity of communities regarding climate change effects on the water-energy nexus; cultural resources and indigenous environmental knowledge; regional and community economies; adaptation policy; urbanization, transportation, and infrastructure vulnerabilities; ecosystem services; and ocean resource sustainability and coastal zone management.");
		     t.setDescription(sb.toString());
		     
		     
             t.setStatus(t.ONGOING);
             
             t.setCapacity(true);
             
             t.setRegional(true);
             
             t.setFresh(true); t.setCoastal(true); t.setMarine(true);
		     
		     t.setCnp(true); t.setWnp(true);  t.setSp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii");
		     regions.addElement("Western North Pacific - Guam, CNMI, FSM, RMI, Palau, Other");
		     regions.addElement("South Pacific - American Samoa");
		     t.setRegion(regions); regions.removeAllElements();
		     
		     t.setAgency("Pacific Islands Regional Climate Assessment (PIRCA)");
		     t.setAgencyUrl("http://www.eastwestcenter.org/PIRCA");
		     
		     t.setContact("John Marra");
		     t.setEmail("john.marra@noaa.gov");
             v.addElement(t); 

		     
		     
		     
		     Assessment u = new Assessment();
		     u.setName("The Resiliency Analysis and Coordination System (TRACS)");
		     u.setWorksheet("PaCIS%20Assessment-COEDMHA-TRACS.doc");

		     sb = new StringBuffer();
		     sb.append("The Center for Excellence in Disaster Management and Humanitarian Assistance is developing a system to conduct comprehensive front-end and operational assessments of the resiliency of communities/societies, and the sectors that comprise them, to natural and man-made disasters. The tool is being designed to support humanitarian assistance/disaster response decision-makers in selecting appropriate programs for given locales and monitoring their progress toward achieving goals.");
		     u.setDescription(sb.toString());
		     
		     
             u.setStatus(t.ONGOING);
             
             u.setLocal(true);
             
             u.setCoastal(true); 
		     
		     u.setCnp(true); u.setWnp(true);  u.setSp(true); u.setOtherRegion(true); 
		     regions.addElement("Central North Pacific");
		     regions.addElement("Western North Pacific");
		     regions.addElement("South Pacific");
		     regions.addElement("United States Pacific Command (USPACOM) Region, Globally");
		     u.setRegion(regions); regions.removeAllElements();
		     
		     u.setAgency("Center for Excellence DMHA");
		     u.setAgencyUrl("http://www.coe-dmha.org/");
		     
		     u.setContact("Jessica Wambach");
		     u.setEmail("jessica.wambach@coe-dmha.org");

             v.addElement(u); 

             Assessment v1 = new Assessment();
		     v1.setName("Kona Area Integrated Ecosystems Assessment (IEA)");
		     v1.setWorksheet("PaCIS%20Assessment-Kona%20IEA.doc");

		     sb = new StringBuffer();
		     sb.append("The purpose of an IEA is to perform a formal synthesis and quantitative analysis of information on relevant natural and socio-economic factors, specifically in relation to identified ecosystem management goals for a region. The Kona region was a natural choice for this pilot IEA project based on its dynamic ecology and the vast history of research done in this area. Work on several initial scientific research projects was begun in 2010. These include the construction of two ecosystem models for the reef and coastal areas of Kona, the construction of socio-economic indicators for the Kona region, and a project using a circulation model to understand how eddies on the Kona coast may influence larval fish transport and settlement. Another goal for 2011 is to finish the Kona IEA website and a multiyear plan for the PIFSC IEA program.");
		     v1.setDescription(sb.toString());
		     
		     
             v1.setStatus(v1.ONGOING);
             
             v1.setLocal(true);
             
             v1.setMarine(true); 
		     
		     v1.setCnp(true);  
		     regions.addElement("Central North Pacific: Island of Hawaii");
		     v1.setRegion(regions); regions.removeAllElements();
		     
		     v1.setAgency("NOAA/NMFS/Pacific Islands Fisheries Science Center (PIFSC)");
		     v1.setAgencyUrl("http://www.pifsc.noaa.gov/kona_iea/");
		     
		     v1.setContact("Evan Howell");
		     v1.setEmail("evan.howell@noaa.gov");

             v.addElement(v1); 
		     
		     Assessment z = new Assessment();
		     z.setName("University of Hawaii Sea Grant College Program (UH Sea Grant)");
		     z.setWorksheet("PaCIS_Assessment-UH_Sea_Grant.doc");

		     sb = new StringBuffer();
		     sb.append("Founded in 1968, UH Sea Grant is part of a national network of 32 programs ");
		     sb.append("that promote better understanding, conservation, and use of coastal resources. ");
		     sb.append("It supports an innovative program of research, extension, education, and ");
		     sb.append("communication services directed to the improved understanding and stewardship ");
		     sb.append("of coastal and marine resources.  Realizing the necessity of collaboration to ");
		     sb.append("address coastal resource issues, UH Sea Grant also provides links between academia, ");
		     sb.append("federal, state and local government agencies, industries, and local community members.");
		     z.setDescription(sb.toString());
		     
		     
             z.setStatus(z.ONGOING);
             
             
             z.setNeeds(true); z.setCapacity(true); z.setCapabilities(true);
             z.setRisk(true);
             
             z.setRegional(true);z.setLocal(true);
             
             z.setCoastal(true);
		     
		     z.setCnp(true);z.setWnp(true);z.setSp(true); 
		     regions.addElement("Central North Pacific - State of Hawaii");
		     regions.addElement("Western North Pacific - Guam, CNMI, RMI");
		     regions.addElement("South Pacific - American Samoa");
		     z.setRegion(regions); regions.removeAllElements();
		     
		     z.setAgency("University of Hawaii Sea Grant College Program");
		     z.setAgencyUrl("http://seagrant.soest.hawaii.edu/");
		     
		     z.setContact("Darren Okimoto");
		     z.setEmail("okimotod@hawaii.edu");
		     
		     v.addElement(z); 
		     
		     
		     
		     v.addElement(r); 

		     ///////////////////////
		     //  Store the above vector as list
		     //
		     AssessmentNameComparator theNameComparor = new AssessmentNameComparator();
             this.m_assessments = v.subList(0, v.size());			
             Collections.sort(this.m_assessments, theNameComparor);			
		}

	 
}
