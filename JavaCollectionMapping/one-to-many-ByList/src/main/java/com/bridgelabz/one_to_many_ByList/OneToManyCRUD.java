package com.bridgelabz.one_to_many_ByList;

import java.util.Scanner;

import com.bridgelabz.dao.OneToManyDao;

public class OneToManyCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		OneToManyDao oneToManyDao = new OneToManyDao();

		boolean flag = true;
		while (flag) {
			System.out.println("\nMenu\n1.Insert\n2.Update\n3.Delete\n4.Display" + "\n5.Exit\n");
			switch (scanner.nextInt()) {
			case 1:
				oneToManyDao.insertData();
				break;
			case 2:
				oneToManyDao.updateData();
				break;
			case 3:
				oneToManyDao.deleteData();
				break;
			case 4:
				oneToManyDao.displayData();
				break;
			case 5:
				flag = false;
				break;

			default:
				System.out.println("Invalid input");
				break;
			}

		}

	}

}
