#REST API  
###Maven based REST-Api using MongoDB 
An application in java which provides a REST API with endpoints for searching, creating and deleting “server” objects: 

* ####@GET servers :-
	 Should return all the servers if no parameters are passed. When server id is passed as a parameter - return a single server or 404 if there’s no such a server.

	 ![GitHub get_all](src/images/get_all.png)

* ####@PUT a server :-
	 The server object is passed as a json-encoded message body. Here’s an example:<br />
```bson
		{ 
			“name”: ”my centos”,
		 	“id”: “123”,
		  	“language”:”java”,
		   	“framework”:”django” 
		}
```
		 ![GitHub site_insert](src/images/site_insert.png)


* ####@DELETE a server:-<br />
	 The parameter is a server ID. 

	  ![GitHub deletebyid](src/images/deletebyid.png)

* ####@POST a server :-
	 The server object is passed as a json-encoded message body.
		 ![GitHub get_all](src/images/get_all.png)

* ####@GET (find) servers by name :-<br />
	 The parameter is a string. Must check if a server name contains this string and return one or more servers found. Return 404 if nothing is found.

	  ![GitHub post](src/images/post.png)

The “Server” objects are stored in ###MongoDB### database.
	![GitHub code2](src/images/code2.png)

