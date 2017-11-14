package com.bridgelabz.one_to_many_ByList;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.model.Answers;
import com.bridgelabz.model.Questions;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	Transaction transaction=session.beginTransaction();
	
	Answers ans1=new Answers();
	ans1.setAnswerName("Java is programming language");
	ans1.setPostedBY("sham");
	
	Answers ans2=new Answers();
	ans2.setAnswerName("Java is platform");
	ans2.setPostedBY("ram");
	
	
	Answers ans3=new Answers();
	ans3.setAnswerName("Servlet is an interface");
	ans3.setPostedBY("sham");
	
	Answers ans4=new Answers();
	ans4.setAnswerName("Servlet is an API");
	ans4.setPostedBY("raju");
	
	
	
	ArrayList<Answers> list1=new ArrayList<Answers>();
	list1.add(ans1);
	list1.add(ans2);
	
	ArrayList<Answers> list2=new ArrayList<Answers>();
	list2.add(ans3);
	list2.add(ans4);
	
	
	
	Questions question1=new Questions();
	question1.setQname("What is java ?");
	question1.setAnswer(list1);
	
	Questions question2=new Questions();
	question2.setQname("What is Servlet ?");
	question2.setAnswer(list2);
	
	session.save(question1);
	session.save(question2);
	transaction.commit();
	session.close();
	System.out.println("Success");

	}

}
