package com.mitt.restthreepages.DAO;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.mitt.restthreepages.VO.BankVO;

@Repository
public class BankDAOImpl implements BankDAO {

	public static SessionFactory getSessionFactory() {
		System.out.println("get seesion factory");
		Configuration configuration = new Configuration().configure("resources/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public void addBankInfo(BankVO bvo) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bvo);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + bvo.toString());

	}

	public ArrayList<BankVO> getAllBankInfo() {
		System.out.println("DAO");
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BankVO.class);
		ArrayList<BankVO> data = (ArrayList<BankVO>) criteria.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully featched ");
		return data;

	}

	@Override
	public ArrayList<BankVO> editBankInfo(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBankInfo(int id) {
		Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        BankVO bvo = new BankVO();
        bvo.setId(id);
        session.delete(bvo);
        tx.commit();
        session.close();
        return 1;
	}
}
