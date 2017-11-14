package com.bridgelabz.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bridgelabz.model.Answers;
import com.bridgelabz.model.Questions;

public class OneToManyDao {
	public static Scanner scanner=new Scanner(System.in);
	public void insertData() {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		ArrayList<Answers> list1=new ArrayList<Answers>();
		Answers ans1=new Answers();
		
		
		Questions question1=new Questions();
		System.out.println("Enter the Question:");
		question1.setQname(scanner.nextLine());
		question1.setAnswer(list1);
		
		System.out.println("Enter the Answer:");
		ans1.setAnswerName(scanner.nextLine());
		System.out.println("Enter your name:");
		ans1.setPostedBY(scanner.nextLine());
	
		list1.add(ans1);
		session.save(question1);
		
		transaction.commit();
		session.close();
		System.out.println("Success");

		

	}
	public void updateData() {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		System.out.println("Please enter the id to update answer");
		int id=new Scanner(System.in).nextInt();
		Transaction transaction=session.beginTransaction();
		Answers ans=new Answers();
		ans=session.get(Answers.class, id);
		System.out.println("Enter the update answer");
		ans.setAnswerName(new Scanner(System.in).nextLine());
		session.update(ans);
		transaction.commit();
		session.close();
		System.out.println("Success");

	}
	public void displayData() {
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
	public void deleteData() {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		System.out.println("Enter question id to delete");
		Scanner scanner=new Scanner(System.in);
		int id=scanner.nextInt();
		Transaction transaction=session.beginTransaction();
		Questions q=session.get(Questions.class, id);
		session.delete(q);
		transaction.commit();
		session.close();
		System.out.println("sucess");
	}

}
