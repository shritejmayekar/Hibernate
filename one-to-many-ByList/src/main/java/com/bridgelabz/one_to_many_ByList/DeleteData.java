package com.bridgelabz.one_to_many_ByList;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.model.Questions;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
