package com.kaiburr.restapi;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class server_repository 
{
	MongoClient mongo = null;
	DBCollection table = null;
	
	public server_repository()
	 {
		 
		 try
		 {
			 mongo = new MongoClient( "localhost" , 27017 );
			 //connect to database
			 DB db = mongo.getDB("server_db");
			 table = db.getCollection("server_collection");
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
//-------------------------------------------------------------------
	 public List<Server> getServers()
	 {
		 List<Server> servers = new ArrayList<>();
		 try 
		 {
			
			DBCursor cursor = table.find();
			System.out.println(":DB:getting Servers");
			//System.out.println(cursor);
			while (cursor.hasNext())
			{
				Server  s = new Server();
				
				DBObject obj1 = cursor.next();
				System.out.print(" here::  ->>");
				System.out.print(obj1.get("name"));
				//System.out.println(cursor.next());
				
				String name = (String)obj1.get("name");
				int id = (Integer)obj1.get("id");
				String language = (String)obj1.get("language");
				String framework = (String)obj1.get("framework");
				  
				  s.setName(name);
				  s.setId(id);
				  s.setLanguage(language);
				  s.setFramework(framework);
				  
				 servers.add(s);
				System.out.print(s.getName());
			}
			System.out.println(servers);

		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 return servers;
	 }
	 
	public void create(Server s) 
	{		
		try 
		{
			//represent json document inside a java prog.
			BasicDBObject document = new BasicDBObject();
			document.put("name", s.getName());
			document.put("id", s.getId());
			document.put("language",s.getLanguage() );
			document.put("framework",s.getFramework() );
			table.insert(document);
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}
	}

//-------------------------------------------------------------------
	 public List<Server> get_server(int id)
	 {
		 Server s = new Server();
		 List<Server> servers = new ArrayList<>();
		 try 
		 {
			 BasicDBObject searchQuery = new BasicDBObject();
				searchQuery.put("id", id);
				DBCursor cursor = table.find(searchQuery);
				
				DBCursor cursor1 = table.find(searchQuery);
				System.out.println(cursor1.length());
				
				while (cursor.hasNext())
				{
					//System.out.println(cursor.next());
					DBObject obj1 = cursor.next();
					System.out.print("here::  ->>");
					System.out.println(obj1.get("name"));
					//System.out.println(cursor.next());
					  
					String name = (String)obj1.get("name");
					int id1 = (Integer)obj1.get("id");
					String language = (String)obj1.get("language");
					String framework = (String)obj1.get("framework");
		  
					s.setName(name);
					s.setId(id1);
					s.setLanguage(language);
					s.setFramework(framework);
					
					servers.add(s);
				}
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 return servers;
	 }

//--------------------------------------------------------------------------
		public void delete(int id)
		 {
			 try 
			 { 
				 BasicDBObject searchQuery = new BasicDBObject();
				 searchQuery.put("id", id);
				 table.remove(searchQuery);
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
		 }
		public DBCursor get_total() 
		{
			 //BasicDBObject searchQuery = new BasicDBObject();
				//searchQuery.put("id", id);
				DBCursor cursor = table.find(/*searchQuery*/);
				
				//DBCursor cursor1 = table.find(searchQuery);

				
			return cursor;
		}
	}

/**************************edit this ********************
	 
 ********************************************************/