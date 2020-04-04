
package com.kaiburr.restapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/index")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	server_repository repo = new server_repository();
    @GET 
    @Produces("text/html")
    public String getIt() 
    {	
    	String page = "<!DOCTYPE html>\n";
    	page +=  "<html> <body>  total number of recorde are :: \n";
    	page += "<p id=\"demo\"></p>\n";
    	page += "<p id=\"demo1\"></p>\n";
    	page += "<p id=\"demo3\"></p>\n";
    	page += "<button type=\"button\" onclick=\"loadDoc()\">Request data</button>\n";
    	page +=  "<script>\r\n" + 
    			"function loadDoc() {\r\n" + 
    			"  var xhttp = new XMLHttpRequest();\r\n" + 
    			"  xhttp.onreadystatechange = function() {\r\n" + 
    			"    if (this.readyState == 4 && this.status == 200) {\r\n" + 
    			"      var myObj = JSON.parse(this.responseText);\r\n" + 
    			" 	   var obj = JSON.stringify(myObj[1]);"+		
    			"      document.getElementById(\"demo\").innerHTML = obj;"+
    			"      document.getElementById(\"demo1\").innerHTML = myObj[1].framework;"+
    			"		var string;"+
    			" 	   for (i in myObj)"+
    			" 		{\r\n  string = string + JSON.stringify(myObj[i])+ i+\"\\n\";} " + 
    			"  		document.getElementById(\"demo3\").innerHTML = string;"+
    			"		"+
    			"    }\r\n" + 
    			"  };\r\n" + 
    			"  xhttp.open(\"GET\", \"http://localhost:8011/restapi/get_servers\", true);\r\n" + 
    			"xhttp.setRequestHeader(\"Content-type\", \"application/json\");"+
    			"  xhttp.send();\r\n" + 
    			"}\r\n" + 
    			"</script>";
//-------------------------------------------------------------------------
//put request 
    	page += "<hr>\r\n" + 
    			"put_create_server ::<br>\r\n" + 
    			"<p id=\"demo4\"></p>\r\n" + 
    			" <div>\r\n" + 
    			"      <form name =\"url_input\">\r\n" + 
    			"        <label for=\"framework\" >Framework :</label><br>\r\n" + 
    			"        <input type=\"text\" name=\"framework\" placeholder=\"framework\" value=\"test\" autofocus required>\r\n" + 
    			"        <br>\r\n" + 
    			"        <label for=\"lanuage\">Language</label>\r\n" + 
    			"        <input type=\"text\" name=\"language\" placeholder=\"language\" value=\"test\">\r\n" + 
    			"        <br>\r\n" + 
    			"        <label for=\"id\">Id:</label>\r\n" + 
    			"        <input type=\"number\" name=\"id\" placeholder=\"id\" value=\"1\">\r\n" + 
    			"        <br>\r\n" + 
    			"        <label for=\"name\">Name</label>\r\n" + 
    			"        <input type=\"text\" name=\"name\" placeholder=\"name\" value=\"test\">\r\n" + 
    			"        <br>\r\n" + 
    			"      </form>\r\n" + 
    			"</div>\r\n" + 
    			"<button type=\"button\" onclick=\"putCreateServer()\">Input data</button>\r\n" + 
    			"<script>\r\n" + 
    			"function putCreateServer() \r\n" + 
    			"    {\r\n" + 
    			"      window.alert(\" Server Uploaded \");\r\n" + 
    			"       var xhttp = new XMLHttpRequest(); \r\n" + 
    			"        \r\n" + 
    			"          var url =   document.url_input.name.value + \"-\";\r\n" + 
    			"          url = url + document.url_input.id.value + \"-\";\r\n" + 
    			"          url = url + document.url_input.language.value + \"-\"; \r\n" + 
    			"          url = url + document.url_input.framework.value  ;\r\n" + 
    			"          document.getElementById(\"demo5\").innerHTML = url ;\r\n" + 
    			"        \r\n" + 
    			"        xhttp.open(\"PUT\", \"http://localhost:8011/restapi/get_servers/\"+ url, true);\r\n" + 
    			"        xhttp.send();\r\n" +
    			"		 loadDoc();	"+	
    			"    }\r\n" + 
    			"</script>\r\n" + 
    			"<p id=\"demo5\">xxx</p>";
//-----------------------------------------------------------------
    	page += "<hr> DELETE SERVER"+
    			"<p id =\"demo6\"></p>\r\n" + 
    			" <form name =\"delete\">\r\n" + 
    			"  <label for=\"id\" >ID :</label><br>\r\n" + 
    			"        <input type=\"number\" name=\"id\" placeholder=\"id\" value=\"1\" autofocus required>\r\n" + 
    			"</form>\r\n" + 
    			"<button type=\"button\" onclick=\"deleteServer()\">Delete Server</button>\r\n" + 
    			"<script>\r\n" + 
    			"function deleteServer() \r\n" + 
    			"    {\r\n" + 
    			"      window.alert(\" Server Deleted \");\r\n" + 
    			"       var xhttp = new XMLHttpRequest(); \r\n" + 
    			"        \r\n" + 
    			"          var id =   document.delete.id.value ;\r\n" + 
    			"          document.getElementById(\"demo7\").innerHTML = id ;\r\n" + 
    			"        \r\n" + 
    			"        xhttp.open(\"DELETE\", \"http://localhost:8011/restapi/get_servers/\"+ id, true);\r\n" + 
    			"        xhttp.send();\r\n" +
    			"		 loadDoc();	"+			
    			"    }\r\n" + 
    			"</script>\r\n" + 
    			"<p id=\"demo7\">xxx</p>\r\n" ;
        return page;
    }

//--------------------------------------------------------------------
@Path("/index1")
    @GET 
    @Produces("text/html")
    public String getIt_interactive() 
    {
    	String page = "<!DOCTYPE html>\r\n" + 
    			"<html>\r\n" + 
    			"<head>\r\n" + 
    			"	<title>resort management</title>\r\n" + 
    			"	<link rel=\"icon\" href=\"images/fev1.png\" sizes=\"16x16\" type=\"image/png\">\r\n" + 
    			"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
    			"	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
    			"	<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\r\n" + 
    			"	<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n" + 
    			"	<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n" + 
    			"	<script type=\"text/javascript\">\r\n" + 
    			"		function bodyLoaded()\r\n" + 
    			"		{\r\n" + 
    			"			 document.getElementById(\"main\").style.display = \"Block\";"+
    			"			 document.getElementById(\"Search_Block\").style.display = \"none\";\r\n" + 
    			"			 document.getElementById(\"Servers\").style.display = \"none\";\r\n" + 
    			"			 document.getElementById(\"input\").style.display = \"none\";\r\n" + 
    			"		}\r\n" + 
    			"		function Servers() \r\n" + 
    			"		{\r\n" + 
    			"			document.getElementById(\"main\").style.display = \"none\";"+
    			"			document.getElementById(\"Search_Block\").style.display = \"none\";\r\n" + 
    			"			document.getElementById(\"Servers\").style.display = \"inline-block\";\r\n" + 
    			"			document.getElementById(\"input\").style.display = \"none\";\r\n" + 
    			"           loadDoc(); "+
    			"		}\r\n" +
    			"		function showFind() \r\n" + 
    			"		{\r\n" + 
    			"			document.getElementById(\"main\").style.display = \"none\";"+
    			"		  	document.getElementById(\"input\").style.display = \"none\";\r\n" + 
    			"		  	document.getElementById(\"Search_Block\").style.display = \"\";\r\n" + 
    			"			document.getElementById(\"Servers\").style.display = \"none\";\r\n" + 
    			"	    }"+
    			"		function showForm() \r\n" + 
    			"		{\r\n" + 
    			"			document.getElementById(\"main\").style.display = \"none\";"+
    			"		  	document.getElementById(\"input\").style.display = \"\";\r\n" + 
    			"		  	document.getElementById(\"Search_Block\").style.display = \"none\";\r\n" + 
    			"			document.getElementById(\"Servers\").style.display = \"none\";\r\n" + 
    			"	    }\r\n" + 
    			"	    function loadDoc()\r\n" + 
    			"	    {\r\n" + 
    			"			"+
    			"	        var xhttp = new XMLHttpRequest();\r\n" + 
    			"	        xhttp.onreadystatechange = function() \r\n" + 
    			"	        {\r\n" + 
    			"	          if (this.readyState == 4 && this.status == 200) \r\n" + 
    			"	          {\r\n" + 
    			"	            var myObj = JSON.parse(this.responseText);\r\n" + 
    			"	            var obj = JSON.stringify(myObj[1]);\r\n" + 
    			"	            //document.getElementById(\"demo\").innerHTML = obj;\r\n" + 
    			"	            //document.getElementById(\"demo1\").innerHTML = myObj[1].framework;\r\n" + 
    			"	            var string;      \r\n" + 
    			"	            for (i in myObj)     \r\n" + 
    			"	            {\r\n" + 
    			"	              //string = string + JSON.stringify(myObj[i])+ i+\"\\n\";\r\n" + 
    			"				    string = string + \"<div class=\\\"card border-dark mb-3\\\" id=\\\"ServerImage\"\r\n" + 
    			"				    	+ myObj[i].id\r\n" + 
    			"				    	+\"\\\" style=\\\"width: 13rem; display: \"\r\n" + 
    			"				    	+\"inline-block;text-align: center; margin: 2rem;\\\";>\"\r\n" + 
    			"						+\"<div class=\\\"card-header\\\">\" \r\n" + 
    			"						+myObj[i].id\r\n" + 
    			"						+\"</div> <div class=\\\"card-body text-dark\\\"><h5 class=\\\"card-title\\\">\"\r\n" + 
    			"						+myObj[i].name\r\n" + 
    			"						+\"</h5><p class=\\\"card-text\\\">\"\r\n" + 
    			"						+myObj[i].language\r\n" + 
    			"						+\"</p><p class=\\\"card-text\\\">\"\r\n" + 
    			"						+myObj[i].framework\r\n" + 
    			"						+\"</p></div><a href=\\\"#\\\"><div class=\\\"card-footer bg-transparent border-success\" \r\n" + 
    			"						+\"style=\\\"background-color: green\\\">\"\r\n" + 
    			"						+\"<button type=\\\"button\\\" style=\\\"border: 0px; background-color: white;\\\" onclick=\\\"deleteServer(\"\r\n" + 
    			"						+myObj[i].id\r\n" + 
    			"						+\")\\\">\"\r\n" + 
    			"						+\"DELETE\""+
    			"						+\"<svg class=\\\"bi bi-trash\\\" width=\\\"1em\\\" height=\\\"1em\\\" viewBox=\\\"0 0 16 16\\\" fill=\\\"currentColor\\\" xmlns=\\\"http://www.w3.org/2000/svg\\\">\"\r\n" + 
    			"					  +\"<path d=\\\"M5.5 5.5A.5.5 0 016 6v6a.5.5 0 01-1 0V6a.5.5 0 01.5-.5zm2.5 0a.5.5 0 01.5.5v6a.5.5 0 01-1 0V6a.5.5 0 01.5-.5zm3 .5a.5.5 0 00-1 0v6a.5.5 0 001 0V6z\\\"/>\"\r\n" + 
    			"					  +\"<path fill-rule=\\\"evenodd\\\" d=\\\"M14.5 3a1 1 0 01-1 1H13v9a2 2 0 01-2 2H5a2 2 0 01-2-2V4h-.5a1 1 0 01-1-1V2a1 1 0 011-1H6a1 1 0 011-1h2a1 1 0 011 1h3.5a1 1 0 011 1v1zM4.118 4L4 4.059V13a1 1 0 001 1h6a1 1 0 001-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z\\\" clip-rule=\\\"evenodd\\\"/>\"\r\n" + 
    			"					+\"</svg>\" "+
    			"+\"</button></div></a></div>\";\r\n" + 
    			"	            }      \r\n" + 
    			"	            document.getElementById(\"Servers\").innerHTML = string;        \r\n" + 
    			"	          }\r\n" + 
    			"	        };\r\n" + 
    			"	        xhttp.open(\"GET\", \"http://localhost:8011/restapi/get_servers\", true);\r\n" + 
    			"	        xhttp.setRequestHeader(\"Content-type\", \"application/json\"); \r\n" + 
    			"	        xhttp.send();\r\n" + 
    			"document.getElementById(\"load\").style.display = \"none\";"+
    			"	      }\r\n" + 
    			"	      function deleteServer(id) \r\n" + 
    			"		    {\r\n		    	" + 
    			"		      window.alert(\" Server Deleted \");\r\n" + 
    			"		       var xhttp = new XMLHttpRequest(); \r\n" + 
    			"		          var string = \"ServerImage\"+id;\r\n" + 
    			"		        document.getElementById(string).style.display = \"none\";\r\n" + 
    			"		        xhttp.open(\"DELETE\", \"http://localhost:8011/restapi/get_servers/\"+id, true);\r\n" + 
    			"		        xhttp.send();\r\n" + 
    			"		    }\r\n" + 
    			"		  function putCreateServer() \r\n" + 
    			"		    {\r\n" + 
    			"		      window.alert(\" Server Uploaded \");\r\n" + 
    			"		       var xhttp = new XMLHttpRequest(); \r\n" + 
    			"		        \r\n" + 
    			"		          var url =   document.url_input.name.value + \"-\";\r\n" + 
    			"		          url = url + document.url_input.id.value + \"-\";\r\n" + 
    			"		          url = url + document.url_input.language.value + \"-\"; \r\n" + 
    			"		          url = url + document.url_input.framework.value  ;\r\n" + 
    			"		        \r\n" + 
    			"		        xhttp.open(\"PUT\", \"http://localhost:8011/restapi/get_servers/\"+url, true);\r\n" + 
    			"		        xhttp.send();\r\n" + 
    			"		    }\r\n" + 
    			""+
    			"	</script>\r\n" + 
    			"</head>\r\n" + 
    			"<body onload=\"bodyLoaded()\">\r\n" + 
    			"	<!-- header :: Cloud Services  -->\r\n" + 
    			"	<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\r\n" + 
    			"	  <a class=\"navbar-brand\" href=\"#\">Cloud Services</a>\r\n" + 
    			"	  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
    			"	    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
    			"	  </button>\r\n" + 
    			"	  <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n" + 
    			"	    <ul class=\"navbar-nav\">\r\n" + 
    			"	      <li class=\"nav-item active\">\r\n" + 
    			"	        <a class=\"nav-link\" href=\"#\" onclick=\"bodyLoaded()\">Home <span class=\"sr-only\">(current)</span></a>\r\n" + 
    			"	      </li>\r\n" + 
    			"	    </ul>\r\n" + 
    			"	  </div>\r\n" + 
    			"	</nav>\r\n" + 
    			"	<br>\r\n" + 
    			"<!---------------------------------------------------------------------------------------------------------------->\r\n" + 
    			"	<!-- big_blocks X 3 ::  MYServers  ::  Search Servers  ::  Create Server  ||:||  Delete Block-->\r\n" + 
    			"<div class=\"container\" id =\"main\">\r\n" + 
    			"\r\n" + 
    			"<div class=\"row\" style=\"margin-top: 100px;\" >\r\n" + 
    			"	\r\n" + 
    			"	<div class=\"col-md-4\">\r\n" + 
    			"		 <a onclick=\"Servers()\" onMouseOver=\"this.style.color='red'\">\r\n" + 
    			"		<div class=\"card\" style=\"width: 18rem; text-align: center;\">\r\n" + 
    			"			<div style=\"text-align: center; margin-top: 20px;\">\r\n" + 
    			"				<svg class=\"bi bi-server\" width=\"5em\" height=\"5em\" viewBox=\"0 0 16 16\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">\r\n" + 
    			"				  <path d=\"M13 2c0-1.105-2.239-2-5-2S3 .895 3 2s2.239 2 5 2 5-.895 5-2z\"/>\r\n" + 
    			"				  <path d=\"M13 3.75c-.322.24-.698.435-1.093.593C10.857 4.763 9.475 5 8 5s-2.857-.237-3.907-.657A4.881 4.881 0 013 3.75V6c0 1.105 2.239 2 5 2s5-.895 5-2V3.75z\"/>\r\n" + 
    			"				  <path d=\"M13 7.75c-.322.24-.698.435-1.093.593C10.857 8.763 9.475 9 8 9s-2.857-.237-3.907-.657A4.881 4.881 0 013 7.75V10c0 1.105 2.239 2 5 2s5-.895 5-2V7.75z\"/>\r\n" + 
    			"				  <path d=\"M13 11.75c-.322.24-.698.435-1.093.593-1.05.42-2.432.657-3.907.657s-2.857-.237-3.907-.657A4.883 4.883 0 013 11.75V14c0 1.105 2.239 2 5 2s5-.895 5-2v-2.25z\"/>\r\n" + 
    			"				</svg>\r\n" + 
    			"			</div>\r\n" + 
    			"		  <div class=\"card-body\">\r\n" + 
    			"		    <p class=\"card-text\">All Servers</p>\r\n" + 
    			"		  </div>\r\n" + 
    			"		</div>\r\n" + 
    			"	</a>\r\n" + 
    			"	</div>\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"	<div class=\"col-md-4\">\r\n" + 
    			"		 <a href=\"#Search_Block\" onclick=\"showFind()\">\r\n" + 
    			"		<div class=\"card\" style=\"width: 18rem; text-align: center;\">\r\n" + 
    			"		  	<div style=\"text-align: center; margin-top: 20px;\"\">\r\n" + 
    			"			  	<svg class=\"bi bi-search\" width=\"5em\" height=\"5em\" viewBox=\"0 0 16 16\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">\r\n" + 
    			"				  <path fill-rule=\"evenodd\" d=\"M10.442 10.442a1 1 0 011.415 0l3.85 3.85a1 1 0 01-1.414 1.415l-3.85-3.85a1 1 0 010-1.415z\" clip-rule=\"evenodd\"/>\r\n" + 
    			"				  <path fill-rule=\"evenodd\" d=\"M6.5 12a5.5 5.5 0 100-11 5.5 5.5 0 000 11zM13 6.5a6.5 6.5 0 11-13 0 6.5 6.5 0 0113 0z\" clip-rule=\"evenodd\"/>\r\n" + 
    			"				</svg>\r\n" + 
    			"			</div>\r\n" + 
    			"		  <div class=\"card-body\">\r\n" + 
    			"		    <p class=\"card-text\">Search Servers</p>\r\n" + 
    			"		  </div>\r\n" + 
    			"		</div>\r\n" + 
    			"	</a>\r\n" + 
    			"	</div>\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"	<div class=\"col-md-4\">\r\n" + 
    			"		 <a onclick=\"showForm()\">\r\n" + 
    			"		<div class=\"card\" style=\"width: 18rem; text-align: center;\">\r\n" + 
    			"			<div style=\"margin-top: 20px;\">\r\n" + 
    			"				<svg class=\"bi bi-plus-circle\" width=\"5em\" height=\"5em\" viewBox=\"0 0 16 16\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">\r\n" + 
    			"				  <path fill-rule=\"evenodd\" d=\"M8 3.5a.5.5 0 01.5.5v4a.5.5 0 01-.5.5H4a.5.5 0 010-1h3.5V4a.5.5 0 01.5-.5z\" clip-rule=\"evenodd\"/>\r\n" + 
    			"				  <path fill-rule=\"evenodd\" d=\"M7.5 8a.5.5 0 01.5-.5h4a.5.5 0 010 1H8.5V12a.5.5 0 01-1 0V8z\" clip-rule=\"evenodd\"/>\r\n" + 
    			"				  <path fill-rule=\"evenodd\" d=\"M8 15A7 7 0 108 1a7 7 0 000 14zm0 1A8 8 0 108 0a8 8 0 000 16z\" clip-rule=\"evenodd\"/>\r\n" + 
    			"				</svg>\r\n" + 
    			"			</div>\r\n" + 
    			"		  <div class=\"card-body\">\r\n" + 
    			"		    <p class=\"card-text\">Add Server</p>\r\n" + 
    			"		  </div>\r\n" + 
    			"		</div>\r\n" + 
    			"	</div>\r\n" + 
    			"	 </a>\r\n" + 
    			"</div>\r\n" + 
    			"\r\n" + 
    			"</div>\r\n" + 
    			"<br>\r\n" + 
    			"<div id =\"load\" style=\"margin: 100px; display: none; \">\r\n" + 
    			"	<div class=\"d-flex align-items-center\" >\r\n" + 
    			"	  <strong>Loading...</strong>\r\n" + 
    			"	  <div class=\"spinner-border ml-auto\" role=\"status\" aria-hidden=\"true\"></div>\r\n" + 
    			"	</div>\r\n" + 
    			"</div>\r\n" + 
    			"\n"+
    			"<!-- Search_Block  -->\r\n" + 
    			"<div class=\"input-group\" id =\"Search_Block\" style=\" padding: 50px;background-color: aqua;\">\r\n" + 
    			"  <input type=\"text\" class=\"form-control\" placeholder=\"Search.. Server ID or Name\" aria-label=\"\" aria-describedby=\"button-addon4\">\r\n" + 
    			"  <div class=\"input-group-append\" id=\"button-addon4\">\r\n" + 
    			"    <div class=\"btn-group\" role=\"group\" aria-label=\"Basic example\">\r\n" + 
    			"  <button type=\"button\" class=\"btn btn-secondary\">Search by ID</button>\r\n" + 
    			"  <button type=\"button\" class=\"btn btn-secondary\" disabled>Search by Name</button>\r\n" + 
    			"</div>\r\n" + 
    			"  </div>\r\n" + 
    			"</div>\r\n" + 
    			"<br>\r\n" + 
    			"<!-- list of small_blocks :: THE SERVER IMAGE/s -->\r\n" + 
    			"\r\n" + 
    			"<div class=\"container\" id =\"Servers\">\r\n" + 
    			"	<div class=\"card border-dark mb-3\" id=\"ServerImage\" style=\"max-width: 20rem; display: inline-block;text-align: center;\">\r\n" + 
    			"		  <div class=\"card-header\">ID</div>\r\n" + 
    			"		  <div class=\"card-body text-dark\">\r\n" + 
    			"		    <h5 class=\"card-title\">NAME</h5>\r\n" + 
    			"		    <p class=\"card-text\">LANGUAGE</p>\r\n" + 
    			"		    <p class=\"card-text\">FRAMEWORK</p>\r\n" + 
    			"		  </div>\r\n" + 
    			"		  <a href=\"#\">\r\n" + 
    			"		  	<div class=\"card-footer bg-transparent border-success\" style=\"background-color: green\">\r\n" + 
    			"		  		<button type=\"button\" style=\"border: 0px; background-color: white;\">DELETE</button>\r\n" + 
    			"		  	</div>\r\n" + 
    			"		  </a>\r\n" + 
    			"	</div>\r\n" + 
    			"</div>\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"<!-- form to enter -->\r\n" + 
    			"<div class=\"container\" id=\"input\">\r\n" + 
    			"	<form name =\"url_input\">\r\n" + 
    			"		<div class=\"input-group mb-3\">\r\n" + 
    			"		  <div class=\"input-group-prepend\">\r\n" + 
    			"		    <span class=\"input-group-text\" id=\"basic-addon1\" style=\"min-width: 120px;\" >ID</span>\r\n" + 
    			"		  </div>\r\n" + 
    			"		  <input type=\"number\" name=\"id\" placeholder=\"id\" value=\"1\" class=\"form-control\" aria-label=\"id\" aria-describedby=\"basic-addon1\">\r\n" + 
    			"		</div>\r\n" + 
    			"		<div class=\"input-group mb-3\">\r\n" + 
    			"		  <div class=\"input-group-prepend\">\r\n" + 
    			"		    <span class=\"input-group-text\" id=\"basic-addon1\" style=\"min-width: 120px;\">NAME</span>\r\n" + 
    			"		  </div>\r\n" + 
    			"		  <input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"name\" value=\"test\" aria-label=\"name\" aria-describedby=\"basic-addon1\">\r\n" + 
    			"		</div>\r\n" + 
    			"		<div class=\"input-group mb-3\">\r\n" + 
    			"		  <div class=\"input-group-prepend\">\r\n" + 
    			"		    <span class=\"input-group-text\" id=\"basic-addon1\" style=\"min-width: 120px;\">LANGUAGE</span>\r\n" + 
    			"		  </div>\r\n" + 
    			"		  <input type=\"text\" class=\"form-control\" aria-label=\"Username\" aria-describedby=\"basic-addon1\" name=\"language\" placeholder=\"language\" value=\"test\">\r\n" + 
    			"		</div>\r\n" + 
    			"		<div class=\"input-group mb-3\">\r\n" + 
    			"		  <div class=\"input-group-prepend\">\r\n" + 
    			"		    <span class=\"input-group-text\" id=\"basic-addon1\" style=\"min-width: 120px;\">FRAMEWORK</span>\r\n" + 
    			"		  </div>\r\n" + 
    			"		  <input type=\"text\" class=\"form-control\" name=\"framework\" placeholder=\"framework\" value=\"test\" aria-label=\"framework\" aria-describedby=\"basic-addon1\">\r\n" + 
    			"			  <div class=\"input-group-append\">\r\n" + 
    			"		    <button class=\"btn btn-outline-secondary\" type=\"button\" id=\"button-addon2\" onclick=\"putCreateServer()\">CREATE</button>\r\n" + 
    			"		  </div>\r\n" + 
    			"		</div> \r\n" + 
    			"	</form>\r\n" + 
    			"</div>\r\n" + 
    			"\r\n" + 
    			"</body>\r\n" + 
    			"</html>\r\n" + 
    			"\r\n" + 
    			"";
        return page;
    }
}