package com.iprosonic.petiton.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.master.location.service.LocationService;
import com.iprosonic.pjcommons.domains.Location;
import com.iprosonic.pjcommons.domains.Petition;
import com.iprosonic.pjcommons.domains.PetitionAction;
import com.iprosonic.pjcommons.domains.PetitionStatus;
import com.iprosonic.pjcommons.domains.PetitionaAttachment;
import com.iprosonic.pjcommons.utils.GetCurrentDateUtil;
import com.iprosonic.pjcommons.utils.HibernateSessionFactory;

public class PetionService {

	public void savePetiton(Petition petition, PetitionAction petitionAction) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		Set<PetitionAction> petitionActionSet = new HashSet<PetitionAction>();
		Transaction tx = null;
		try {
			tx = sessionHibernate.beginTransaction();
			petition.setPetitionStatus("OPEN");
			petitionAction.setPetitionId(petition.getPetitionId());
			petitionAction.setActionDate(GetCurrentDateUtil.getDate());
			petitionActionSet.add(petitionAction);
			if (petitionAction.getActionTaken() != null || !petitionAction.getActionTaken().trim().equalsIgnoreCase("")) {
				petition.setPetitionActionSet(petitionActionSet);
			}
			sessionHibernate.save(petition);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
	}

	public void updatePetition(Petition petition, PetitionAction petitionAction) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		Set<PetitionAction> petitionActionSet = new HashSet<PetitionAction>();
		Transaction tx = null;
		try {
			tx = sessionHibernate.beginTransaction();
			petitionAction.setPetitionId(petition.getPetitionId());
			petitionAction.setActionDate(GetCurrentDateUtil.getDate());
			petitionActionSet.add(petitionAction);
			if (petitionAction.getActionTaken() != null || !petitionAction.getActionTaken().trim().equalsIgnoreCase("")) {
				petition.setPetitionActionSet(petitionActionSet);
			}
			sessionHibernate.saveOrUpdate(petition);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
	}

	public void closePetition(int petitionId) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		Transaction tr = null;
		String hql = "update Petition set petitionStatus=:petitionStatus where petitionId=:petitionId";
		try {
			tr = sessionHibernate.beginTransaction();
			Query query = sessionHibernate.createQuery(hql);
			query.setString("petitionStatus", "CLOSE");
			query.setInteger("petitionId", petitionId);
			query.executeUpdate();
			tr.commit();

		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();

		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
	}

	public void rejectPetition(int petitionId) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		Transaction tr = null;
		String hql = "update Petition set petitionStatus=:petitionStatus where petitionId=:petitionId";
		try {

			tr = sessionHibernate.beginTransaction();
			Query query = sessionHibernate.createQuery(hql);
			query.setString("petitionStatus", "REJECT");
			query.setInteger("petitionId", petitionId);
			query.executeUpdate();
			tr.commit();

		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();

		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Petition> getPetitionList(String location) {
		List<Petition> list = null;
		Session sessionHibernate = null;
		try {
			sessionHibernate = HibernateSessionFactory.getSession();
			Criteria criteria = null;
			if (!location.equalsIgnoreCase("SP_JALORE")) {
				criteria = sessionHibernate.createCriteria(Petition.class).add(Restrictions.like("petitionWith", location));
				list = criteria.list();
			} else {
				list = sessionHibernate.createCriteria(Petition.class).list();
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			sessionHibernate.flush();
			sessionHibernate.close();

		}
		return list;

	}

	@SuppressWarnings("unchecked")
	public List<Petition> getPetitionListByMobileNo(String mobileNo) {
		List<Petition> list = null;
		Session sessionHibernate = null;
		try {
			sessionHibernate = HibernateSessionFactory.getSession();
			list = sessionHibernate.createCriteria(Petition.class).add(Restrictions.eq("mobileNo", mobileNo)).list();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			sessionHibernate.flush();
			sessionHibernate.close();

		}
		return list;

	}

	@SuppressWarnings("unchecked")
	public List<Petition> getPetitionListByPhoneNo(String phoneNo) {
		List<Petition> list = null;
		Session sessionHibernate = null;
		try {
			sessionHibernate = HibernateSessionFactory.getSession();
			list = sessionHibernate.createCriteria(Petition.class).add(Restrictions.eq("phoneNo", phoneNo)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			sessionHibernate.flush();
			sessionHibernate.close();

		}
		return list;

	}

	@SuppressWarnings("unchecked")
	public List<PetitionAction> getPetitionActionList(Integer id) {
		List<PetitionAction> list = null;
		Session sessionHibernate = null;
		try {
			sessionHibernate = HibernateSessionFactory.getSession();
			Criteria criteria = sessionHibernate.createCriteria(PetitionAction.class);
			criteria.add(Restrictions.eq("petitionId", id));
			list = criteria.list();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			sessionHibernate.flush();
			sessionHibernate.close();

		}
		return list;
	}

	public Petition editPetition(int id) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		Petition petition = null;
		try {
			petition = (Petition) sessionHibernate.get(Petition.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
		return petition;
	}

	public PetitionAction editAction(int id) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		PetitionAction petition = null;
		try {
			petition = (PetitionAction) sessionHibernate.get(PetitionAction.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
		return petition;
	}

	public void saveFileAttachment(PetitionaAttachment petitionaAttachment) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = sessionHibernate.beginTransaction();
			sessionHibernate.save(petitionaAttachment);
			tx.commit();
			tx = null;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<PetitionaAttachment> getPetitionaAttachmentList(Integer id) {
		List<PetitionaAttachment> list = null;
		Session sessionHibernate = null;
		try {
			sessionHibernate = HibernateSessionFactory.getSession();
			Criteria criteria = sessionHibernate.createCriteria(PetitionaAttachment.class);
			criteria.add(Restrictions.eq("petitionId", id));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionHibernate.flush();
			sessionHibernate.close();

		}
		return list;
	}

	// REPORTS

	public List<PetitionStatus> getPetitionStatusReport(String location) {
		LocationService locationService = new LocationService();
		List<PetitionStatus> petitionStatusList = new ArrayList<PetitionStatus>();
		PetitionStatus petitionStatus = null;
		Long countOpenStatus = 0l;
		Long countCloseStatus = 0l;
		Long counTotal = 0l;
		List<Location> list = locationService.getLocationsList(location);
    	ListIterator<Location> locationItr = list.listIterator();
		while (locationItr.hasNext()) {
			String location1 = locationItr.next().getName();
			petitionStatus = new PetitionStatus();
			countOpenStatus = getPetitionListByLocation(location1, "OPEN");
			countCloseStatus = getPetitionListByLocation(location1, "CLOSE");
			counTotal = getPetitionListByLocation(location1, "TOTAL");
			petitionStatus.setLocation(location1);
			petitionStatus.setOpen(countOpenStatus);
			petitionStatus.setClose(countCloseStatus);
			petitionStatus.setTotal(counTotal);
			petitionStatusList.add(petitionStatus);
		}
		return petitionStatusList;
	}

	@SuppressWarnings("unchecked")
	public Long getPetitionListByLocation(String petitionSource, String petitionStatus) {

		Session sessionHibernate = null;
		Long countStatus = 0l;

		try {
			sessionHibernate = HibernateSessionFactory.getSession();
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.count("petitionId"));
			Criteria criteria = sessionHibernate.createCriteria(Petition.class);
			criteria.add(Restrictions.eq("petitionWith", petitionSource));
			if (!petitionStatus.equalsIgnoreCase("TOTAL")) {
				criteria.add(Restrictions.eq("petitionStatus", petitionStatus));
			}
			criteria.setProjection(projectionList);
			Iterator<Long> itr = criteria.list().iterator();
			while (itr.hasNext()) {
				countStatus = itr.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionHibernate.flush();
			sessionHibernate.close();
		}
		return countStatus;
	}

	public int getPetitionId() {
		Session sessionHibernate = null;
		int id = 1;
		Petition petition = null;
		try {
			sessionHibernate = HibernateSessionFactory.getSession();
			@SuppressWarnings("unchecked")
			List<Petition> list = sessionHibernate.createQuery("from Petition order by petitionId DESC LIMIT 1").list();
			if (!list.isEmpty()) {
				petition = list.get(0);
				id = petition.getPetitionId() + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
		return id;
	}
}
