package com.iprosonic.pjcommons.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.pjcommons.domains.Sequence;

public class SequenceNoUtil {
	public synchronized static String getLatestNoByCode(String seqType) {
		Long latestNo = 0L;
		Transaction tr = null;
		Long updateNo = 0L;
		Session sessionHibernate = HibernateSessionFactory.getSession();
		NumberFormat formatter = new DecimalFormat("0000");
		tr = sessionHibernate.beginTransaction();

		Sequence sequence = new Sequence();

		try {
			@SuppressWarnings("unchecked")
			List<Sequence> list = sessionHibernate.createCriteria(Sequence.class).add(Restrictions.eq("seqType", seqType)).list();
			Iterator<Sequence> itr = list.iterator();
			while (itr.hasNext()) {
				sequence = itr.next();
				latestNo = sequence.getLatestNo();
			}
			updateNo = latestNo + 1L;
			sequence.setSeqType(seqType);
			sequence.setLatestNo(updateNo);

			sessionHibernate.save(sequence);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			sessionHibernate.flush();
			sessionHibernate.close();

		}
		return formatter.format(Integer.parseInt(String.valueOf(updateNo)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getLatestNoByCode("pet");
	}
}
