package com.kaiburr.restapi;

public class Server_repository_mysql {

}



/***********************************edit this ***********************
 * package com.telusko.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class AliensRepository_objects 
{
	Connection con = null;

	public AliensRepository_objects()
	 {
		 String url ="jdbc:mysql://127.0.0.1:3306/restdb";
		 String username = "root";
		 String password = "INDIA";
		 try
		 {
			 // 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url, username, password);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
	 
	 public List<Aliens> getAliens()
	 {
		 List<Aliens> aliens = new ArrayList<>();
		 String sql = "select * from aliens";
		 try 
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql); 
			 while(rs.next())
			 {
				  Aliens  a = new Aliens();
				  
				  a.setName(rs.getString(1));
				  a.setPoints(rs.getInt(2));
				  a.setId(rs.getInt(3));
				  
				  aliens.add(a);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 return aliens;
	 }
	 
	 public Aliens getAlien(int id)
	 {
		 String sql = "select * from aliens where id ="+ id;
		 Aliens  a = new Aliens();
		 try 
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql); 
			 if(rs.next())
			 {
				 
				  a.setName(rs.getString(1));
				  a.setPoints(rs.getInt(2));
				  a.setId(rs.getInt(3));
				
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 return a;
	 }

	public void create(Aliens a) 
	{
		 String sql = "insert into aliens values(?,?,?)";
		 try 
		 {
			 PreparedStatement st = con.prepareStatement(sql);
			 st.setString(1 , a.getName());
			 st.setInt(2 , a.getPoints());
			 st.setInt(3 , a.getId());
			 st.executeUpdate();
		 }
		 catch(Exception e)
		 { 
			 System.out.println(e);
		 }
	}
	
	public void delete(int id)
	 {
		 String sql = "delete from aliens where id =?";
		 try 
		 {
			 PreparedStatement st = con.prepareStatement(sql);
			 st.setInt(1 , id);
			 st.executeUpdate();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
}

***************************************************/
