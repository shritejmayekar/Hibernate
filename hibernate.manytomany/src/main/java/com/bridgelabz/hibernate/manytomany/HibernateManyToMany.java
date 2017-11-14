package com.bridgelabz.hibernate.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bridgelabz.model.Cart1;
import com.bridgelabz.model.Item1;
import com.bridgelabz.util.HibernateUtil;

/**
 * 
 * @author Shritej
 *
 *   |      CART	--->	|	CART_ITEM	|	<----	ITEMS 
 *   |   cart_id			|	cart_id		|			item_id	  
 *	 |	cart_total			|	item_id     |
 */
public class HibernateManyToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Item1 item1 = new Item1();
		item1.setDescription("samsung");
		item1.setPrice(300);

		Item1 item2 = new Item1();
		item2.setDescription("Nokia");
		item2.setPrice(200);

		Cart1 cart1 = new Cart1();
		cart1.setTotal(500);

		Set<Item1> items = new HashSet<Item1>();
		items.add(item1);
		items.add(item2);
		cart1.setItems(items);

		SessionFactory factory = null;

		try {
			factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(cart1);
			System.out.println("before commiting transaction");
			transaction.commit();
			factory.close();

			System.out.println("cart id:" + cart1.getId());
			System.out.println("item 1:" + item1.getId());
			System.out.println("item 2:" + item2.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (factory != null && !factory.isClosed())
				factory.close();
		}

	}

}
