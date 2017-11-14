package com.bridgelabz.programs;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration();
		Session session=configuration.configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Transaction transaction=session.beginTransaction();
		
		 Query query=session.createQuery("from Question");  
		 List<Question> list=query.list();
		 
		 Iterator<Question> itr=list.iterator();
		 while (itr.hasNext()) {
			 Question q=itr.next();
			 System.out.println("Question Name:"+q.getQname());
			List<String> list2=q.getAnswers();
			Iterator<String> itr2=list2.iterator();
			while (itr2.hasNext()) {
				System.out.println(itr2.next());
			}
			
		}
		 transaction.commit();
		 session.close();
		
		 System.out.println("Success");
	}

}
