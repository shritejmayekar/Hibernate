package com.bridgelabz.one_to_many_ByList;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.model.Answers;

public class UpdateData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

}
