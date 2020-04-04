package com.kaiburr.restapi;

public class Server_repository_objects {

}


/* *************************** edit this **************************************
/// database nakli haha
package com.telusko.demorest;

import java.util.ArrayList;
import java.util.List;
public class AliensRepository_mysql 
{
	 List<Aliens> aliens;
	 @Override
	public String toString() {
		return "AliensRepository [aliens=" + aliens + ", getAliens()=" + getAliens() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public AliensRepository_mysql()
	 {
		 aliens = new ArrayList<>();
		 
		 Aliens a1 = new Aliens();
			a1.setName("Aman");
			a1.setPoints(60);
			a1.setId(1);
			
			Aliens a2 = new Aliens();
			a2.setName("Shman");
			a2.setPoints(70);
			a2.setId(2);
			
			aliens.add(a1);
			aliens.add(a2);
	 }
	 
	 public List<Aliens> getAliens()
	 {
		 return aliens;
	 }
	 
	 public Aliens getAlien(int id)
	 {
		// Aliens a1 = null;
		 
		 for(Aliens a : aliens)
		 {
			 if(a.getId() == id)
			 {
				 return a;
			 }
		 }
		 return null;
	 }

	public void create(Aliens a) 
	{
		aliens.add(a);
	}
}
*********************************************************/