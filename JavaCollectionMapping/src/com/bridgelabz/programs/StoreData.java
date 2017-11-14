package com.bridgelabz.programs;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StoreData {
	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		Session session = annotationConfiguration.configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("java is programming language");
		list1.add("java is a platform");
		list1.add("java is object oriented");

		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Servlet is an Interface");
		list2.add("Servlet is an API");

		Question question1 = new Question();
		question1.setQname("What is Java ?");
		question1.setAnswers(list1);

		Question question2 = new Question();
		question2.setQname("What is Servlet ?");
		question2.setAnswers(list2);

		session.persist(question1);
		session.persist(question2);
		transaction.commit();
		session.close();
		System.out.println("Success Added");
	}
}
