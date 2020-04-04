#REST API # 
###Maven based REST-Api using MongoDB ###
An application in java which provides a REST API with endpoints for searching, creating and deleting “server” objects: 
* ####@GET#### servers :-
	 Should return all the servers if no parameters are passed. When server id is passed as a parameter - return a single server or 404 if there’s no such a server.

	 ![GitHub get_all](src/images/get_all.png)
	 
* ####@PUT#### a server :-
	 The server object is passed as a json-encoded message body. Here’s an example:
		{ “name”: ”my centos”,
		 “id”: “123”,
		  “language”:”java”,
		   “framework”:”django” } 

* ####@DELETE#### a server:-
	 The parameter is a server ID. 

* ####@GET#### (find) servers by name :-
	 The parameter is a string. Must check if a server name contains this string and return one or more servers found. Return 404 if nothing is found.

The “Server” objects are stored in ###MongoDB### database.


