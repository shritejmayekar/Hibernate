package com.bridgelabz.one_to_many_ByList;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bridgelabz.model.Answers;
import com.bridgelabz.model.Questions;

public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		 Query query=session.createQuery("from Questions");  
		 List<Questions> qlist=query.list();
		 
		 Iterator<Questions> iterator=qlist.iterator();
		 while(iterator.hasNext()) {
			 Questions q=iterator.next();
			 System.out.println(q.getQname());
			 
			 List<Answers> ansList=q.getAnswer();
			 Iterator<Answers> iterator2=ansList.iterator();
			 while (iterator2.hasNext()) {
				 Answers ans=iterator2.next();
				System.out.println(ans.getAnswerName());
				System.out.println(ans.getPostedBY());
			}
		 }
		 session.close();
		 System.out.println("Success");
		 
	}

}
