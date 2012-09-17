function sortby(column, order)
{
  document.projectlist.sortby.value = column;
  document.projectlist.order.value = order;
  document.projectlist.submit();
}
function addnew()
{
  document.projectlist.action = 'index.jsp';
  document.projectlist.submit();
}
function searchbyx()
{
  document.projectlist.action = 'index.jsp?x=1';
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
  document.projectlist.action = 'projects';
  document.projectlist.submit();
}
function searchbox()
{
  //alert('Begin Search for ' + document.projectlist.search.value);
  resetAllDeletes();
  document.projectlist.clearmsgs.value = 'true';
  document.projectlist.action = 'projects';
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
