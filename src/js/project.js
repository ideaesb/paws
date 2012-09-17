

    /////////////////////////////////////////////////////
    //
    // onclick event handler for children of Variability

    
    // this flag will be set if and only if the variability checkbox has been touched
    // this makes a subtle difference between 
    // 1.  variability box is checked because it was clicked directly
    // 2.  variability box is checked because (and only because) its children were clicked
    // 3.  this is also a big help in avoid the ambiguity whether onclicked checked or not


    var checkedVariability = false; 

    function checkVariability()
    {
     
      // alert('Entered checkVariability()');


      if(anyVariabilityChildrenChecked())
      {
        if (checkedVariability) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }

        document.project.variability.checked = true; 
        checkedVariability = true;
      }
      else if(checkedVariability)
      {
        document.project.variability.checked = false; 
        checkedVariability = false;
        // alert('variability set to FALSE');
      }
      else
      {
        document.project.variability.checked = true; 
        checkedVariability = true;
        // alert('variability set to TRUE');
      }      
    }

   function alsoCheckVariability()
   {
     // alert('Entered alsoCheckVariability()');

   
     if(anyVariabilityChildrenChecked())
     {
       // alert('at least one children of variability was checked!');

       if (checkedVariability)
       {
         // nothing to do: the variability parent box was not only checked, but done so directly
       }
       else if (document.project.variability.checked)
       {
         // nothing to do: the variability parent box was already checked by another child
       }
       else
       {
         document.project.variability.checked = true;
       }
     }
     else if (checkedVariability)
     {
       // nothing to do: the variability parent box was not only checked, but done so directly
     }
     else
     {
       // this will happen only if the variability parent was checked only due to its children
       // in this case we uncheck it - owing to fact that none of its children where checked. 
       document.project.variability.checked = false; 
     }
  
   }

   function anyVariabilityChildrenChecked()
   {
     if      (document.project.operational.checked) return true;
     else if (document.project.research.checked) return true;
     else if (document.project.vhistorical.checked) return true;
     else if (document.project.vprojections.checked) return true;
     else if (document.project.asurface.checked) return true;
     else if (document.project.upperair.checked) return true;
     else if (document.project.composition.checked) return true;
     else if (document.project.osurface.checked) return true;
     else if (document.project.subsurface.checked) return true;
     else if (document.project.terrestrial.checked) return true;
     else if (document.project.seasonal.checked) return true;
     else if (document.project.annual.checked) return true;
     else if (document.project.decadal.checked) return true;
     else return false; 

    
   }





    /////////////////////////////////////////////////////
    //
    // onclick event handler for children of effects


    var checkedEffect = false; 

    function checkEffect()
    {
      if(anyEffectChildrenChecked())
      {
        if (checkedEffect) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }

        document.project.effect.checked = true; 
        checkedEffect = true;
      }
      else if(checkedEffect)
      {
        document.project.effect.checked = false; 
        checkedEffect = false;
      }
      else
      {
        document.project.effect.checked = true; 
        checkedEffect = true;
      }      
    }


   function alsoCheckEffect()
   {
   
     if(anyEffectChildrenChecked())
     {

       if (checkedEffect)
       {
         // nothing to do: the effect parent box was not only checked, but done so directly
       }
       else if (document.project.effect.checked)
       {
         // nothing to do: the effect parent box was already checked by another child
       }
       else
       {
         document.project.effect.checked = true;
       }
     }
     else if (checkedEffect)
     {
       // nothing to do: the effect parent box was not only checked, but done so directly
     }
     else
     {
       document.project.effect.checked = false; 
     }
  
   }


   function anyEffectChildrenChecked()
   {
     if      (document.project.impacts.checked) return true;
     else if (document.project.adaptation.checked) return true;
     else if (document.project.ehistorical.checked) return true;
     else if (document.project.eprojections.checked) return true;
     else if (document.project.phs.checked) return true;
     else if (document.project.fwr.checked) return true;
     else if (document.project.ene.checked) return true;
     else if (document.project.tcc.checked) return true;
     else if (document.project.cpd.checked) return true;
     else if (document.project.scr.checked) return true;
     else if (document.project.afi.checked) return true;
     else if (document.project.rat.checked) return true;
     else if (document.project.eco.checked) return true;
     else if (document.project.oth.checked) return true;
     else return false; 
   }





    // onclick event handler for children of guidance


    var checkedGuidance = false; 

    function checkGuidance()
    {
      if(anyGuidanceChildrenChecked())
      {
        if (checkedGuidance) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }
        document.project.guidance.checked = true; 
        checkedGuidance = true;
      }
      else if(checkedGuidance)
      {
        document.project.guidance.checked = false; 
        checkedGuidance = false;
      }
      else
      {
        document.project.guidance.checked = true; 
        checkedGuidance = true;
      }      
    }


   function alsoCheckGuidance()
   {
     if(anyGuidanceChildrenChecked())
     {
       if (checkedGuidance)
       {
         // nothing to do: the guidance parent box was not only checked, but done so directly
       }
       else if (document.project.guidance.checked)
       {
         // nothing to do: the guidance parent box was already checked by another child
       }
       else
       {
         document.project.guidance.checked = true;
       }
     }
     else if (checkedGuidance)
     {
       // nothing to do: the guidance parent box was not only checked, but done so directly
     }
     else
     {
       // this will happen only if the parent was checked only due to its children
       // in this case we uncheck it - owing to fact that none of its children where checked. 
       document.project.guidance.checked = false; 
     }
  
   }


   function anyGuidanceChildrenChecked()
   {
     if      (document.project.gvariability.checked) return true;
     else if (document.project.geffects.checked) return true;
     else return false; 
   }



    // onclick event handler for children of applications


    var checkedApps = false; 

    function checkApps()
    {
      if(anyAppsChildrenChecked())
      {
        if (checkedApps) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }
        document.project.apps.checked = true; 
        checkedApps = true;
      }
      else if(checkedApps)
      {
        document.project.apps.checked = false; 
        checkedApps = false;
      }
      else
      {
        document.project.apps.checked = true; 
        checkedApps = true;
      }      
    }


   function alsoCheckApps()
   {
     if(anyAppsChildrenChecked())
     {
       if (checkedApps)
       {
         // nothing to do: the Apps parent box was not only checked, but done so directly
       }
       else if (document.project.apps.checked)
       {
         // nothing to do: the apps parent box was already checked by another child
       }
       else
       {
         document.project.apps.checked = true;
       }
     }
     else if (checkedApps)
     {
       // nothing to do: the apps parent box was not only checked, but done so directly
     }
     else
     {
       // this will happen only if the parent was checked only due to its children
       // in this case we uncheck it - owing to fact that none of its children where checked. 
       document.project.apps.checked = false; 
     }
  
   }


   function anyAppsChildrenChecked()
   {
     if      (document.project.avariability.checked) return true;
     else if (document.project.aeffects.checked) return true;
     else return false; 
   }



    // onclick event handler for children of Central North Pacific


    var checkedCNP = false; 

    function checkCNP()
    {
      if(anyCNPChildrenChecked())
      {
        if (checkedCNP) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }
        document.project.central.checked = true; 
        checkedCNP = true;
      }
      else if(checkedCNP)
      {
        document.project.central.checked = false; 
        checkedCNP = false;
      }
      else
      {
        document.project.central.checked = true; 
        checkedCNP = true;
      }      
    }


   function alsoCheckCNP()
   {
     if(anyCNPChildrenChecked())
     {
       if (checkedCNP)
       {
         // nothing to do: 
       }
       else if (document.project.central.checked)
       {
         // nothing to do: 
       }
       else
       {
         document.project.central.checked = true;
       }
     }
     else if (checkedCNP)
     {
       // nothing to do: 
     }
     else
     {
       document.project.central.checked = false; 
     }
  
   }


   function anyCNPChildrenChecked()
   {
     if      (document.project.hawaii.checked) return true;
     else if (anyHawaiiChildrenChecked()) return true;
     else if (document.project.hother.checked) return true;
     else return false; 
   }

    // onclick event handler for children of Central North Pacific


    var checkedHawaii = false; 

    function checkHawaii()
    {
      if(anyHawaiiChildrenChecked())
      {
        if (checkedHawaii) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }
        document.project.hawaii.checked = true; 
        checkedHawaii = true;
      }
      else if(checkedHawaii)
      {
        document.project.hawaii.checked = false; 
        checkedHawaii = false;
      }
      else
      {
        document.project.hawaii.checked = true; 
        checkedHawaii = true;
      }

      // call Hawaii parent CNP
      alsoCheckCNP();
      
    }


   function alsoCheckHawaii()
   {
     if(anyHawaiiChildrenChecked())
     {
       if (checkedHawaii)
       {
         // nothing to do: 
       }
       else if (document.project.hawaii.checked)
       {
         // nothing to do: 
       }
       else
       {
         document.project.hawaii.checked = true;
       }
     }
     else if (checkedHawaii)
     {
       // nothing to do: 
     }
     else
     {
       document.project.hawaii.checked = false; 
     }

     // overload CNP
     alsoCheckCNP();
  
   }


   function anyHawaiiChildrenChecked()
   {
     if       (document.project.big.checked) return true;
     else if (document.project.maui.checked) return true;
     else if (document.project.oahu.checked) return true;
     else if (document.project.kauai.checked) return true;
     else return false; 
   }




    // onclick event handler for children of Western North Pacific


    var checkedWNP = false; 

    function checkWNP()
    {
      if(anyWNPChildrenChecked())
      {
        if (checkedWNP) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }
        document.project.western.checked = true; 
        checkedWNP = true;
      }
      else if(checkedWNP)
      {
        document.project.western.checked = false; 
        checkedWNP = false;
      }
      else
      {
        document.project.western.checked = true; 
        checkedWNP = true;
      }      
    }


   function alsoCheckWNP()
   {
     if(anyWNPChildrenChecked())
     {
       if (checkedWNP)
       {
         // nothing to do: 
       }
       else if (document.project.western.checked)
       {
         // nothing to do: 
       }
       else
       {
         document.project.western.checked = true;
       }
     }
     else if (checkedWNP)
     {
       // nothing to do: 
     }
     else
     {
       document.project.western.checked = false; 
     }
  
   }


   function anyWNPChildrenChecked()
   {
     if      (document.project.guam.checked) return true;
     else if (document.project.cnmi.checked) return true;
     else if (document.project.fsm.checked) return true;
     else if (document.project.rmi.checked) return true;
     else if (document.project.palau.checked) return true;
     else if (document.project.wother.checked) return true;
     else return false; 
   }

    // onclick event handler for children of Western North Pacific


    var checkedSP = false; 

    function checkSP()
    {
      if(anySPChildrenChecked())
      {
        if (checkedSP) 
        {
          alert('Cannot uncheck unless items within are unchecked'); 
        }
        document.project.south.checked = true; 
        checkedSP = true;
      }
      else if(checkedSP)
      {
        document.project.south.checked = false; 
        checkedSP = false;
      }
      else
      {
        document.project.south.checked = true; 
        checkedSP = true;
      }      
    }


   function alsoCheckSP()
   {
     if(anySPChildrenChecked())
     {
       if (checkedSP)
       {
         // nothing to do: 
       }
       else if (document.project.south.checked)
       {
         // nothing to do: 
       }
       else
       {
         document.project.south.checked = true;
       }
     }
     else if (checkedSP)
     {
       // nothing to do: 
     }
     else
     {
       document.project.south.checked = false; 
     }
  
   }


   function anySPChildrenChecked()
   {
     if      (document.project.asam.checked) return true;
     else if (document.project.samoa.checked) return true;
     else if (document.project.tonga.checked) return true;
     else if (document.project.fiji.checked) return true;
     else if (document.project.oz.checked) return true;
     else if (document.project.nz.checked) return true;
     else if (document.project.fp.checked) return true;
     else if (document.project.sother.checked) return true;
     else return false; 
   }




   // any region selected
   function anyRegionChecked()
   {
     if       (anyCNPChildrenChecked()) return true;
     else if  (anyWNPChildrenChecked()) return true;
     else if  (anySPChildrenChecked())  return true;
     else return false; 
   }


   // any focus selected
   function anyFocusAreaChecked()
   {
     if      (document.project.fresh.checked)   return true;
     else if (document.project.coastal.checked) return true;
     else if (document.project.marine.checked)  return true;
     else return false; 
   }



   // disablePartners()

   function disablePartners()
   {
     // alert('Entered disablePartners()');

     // allow the Other organization to selected for both leaders and partners 
     for (var i=0; i < document.project.leadagencies.options.length-1; i++)
     {
        if (document.project.leadagencies.options[i].selected) 
        {
          // alert('lead agency ' + i + ' = ' + document.project.leadagencies.options[i].text + ' was selected');
          document.project.partneragencies.options[i].disabled = true;
          // alert('partner agency ' + i + ' = ' + document.project.partneragencies.options[i].text + ' was DISABLED');
        }
        else
        {
          document.project.partneragencies.options[i].disabled = false;
        }
     }
   }


   function disableLeaders()
   {
     for (var i=0; i < document.project.leadagencies.options.length-1; i++)
     {
        if (document.project.partneragencies.options[i].selected) 
        {
          document.project.leadagencies.options[i].disabled = true;
        }
        else
        {
          document.project.leadagencies.options[i].disabled = false;
        }
     }
   }


  function checkform()
  {
     /*
     if (isEmpty(document.project.projectname.value))        alert('Project must have Name/Title');
     if (isEmpty(document.project.projectdescription.value)) alert('Project must have description');
     if (isEmpty(document.project.contact1.value))           alert('Project must have lead contact info');
     if (isEmpty(document.project.email1.value))             alert('Project must have lead contact EMAIL');
     if (isEmpty(document.project.worksheetfilename.value))  alert('Project must have Worksheet Filename');

 
     if (noLeadAgencySelected())                             alert('Project must have a lead agency'); 

     alert('Under Construction');  
     */

     //return false;
     return true;
  }



  function isEmpty(whatever)
  {
     if (whatever == null) return true;
     else if (whatever == "") return true;
     else return false;
  }

  function noLeadAgencySelected()
  {
    var aSelected = true;


     for (var i=0; i < document.project.leadagencies.options.length; i++)
     {
        if (document.project.leadagencies.options[i].selected) 
        {
          if (i > 0)
          {
            aSelected =  false;
            break;
          }
        }
     }



    return aSelected;
  }


