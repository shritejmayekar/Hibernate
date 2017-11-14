package com.bridgelabz.cacheLevelOne;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bridgelabz.model.Answers;

public class CacheLevelOne {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		System.out.println("Please enter the id to get answer");
		int id=new Scanner(System.in).nextInt();
		Transaction transaction=session.beginTransaction();
		Answers ans=new Answers();
		ans=session.get(Answers.class, id);
		System.out.println(" answer");
		printData(ans);
		
		Thread.sleep(1000);
		Answers ans1=session.get(Answers.class, id);
		printData(ans1);
		
		session.evict(ans1);
		//Session newSession=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Answers ans2=session.get(Answers.class, id);
		printData(ans2);
		
		Thread.sleep(1000);
		Answers ans3=session.get(Answers.class, id);
		printData(ans3);
		
		session.evict(ans3);
		Answers ans4=session.get(Answers.class, id);
		printData(ans4);
		
		
		transaction.commit();
		
		//newSession.close();
		System.out.println("Success");

	}
	private static void printData(Answers ans) {
		System.out.println("id:"+ans.getId()+" name:"+ans.getAnswerName());
	}
}
