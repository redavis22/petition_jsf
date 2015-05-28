package com.iprosonic.master.location.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.pjcommons.domains.Location;
import com.iprosonic.pjcommons.domains.LocationChild;
import com.iprosonic.pjcommons.utils.HibernateSessionFactory;

public class LocationService {
	public List<Location> getAllLocationsList() {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		List<Location> list = null;
		Criteria criteria = null;
		try {
			criteria = sessionHibernate.createCriteria(Location.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Location> getLocationsList(String location) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		List<Location> list = null;
		Criteria criteria = null;
		try {
			criteria = sessionHibernate.createCriteria(Location.class);
			if (!location.equalsIgnoreCase("SP_JALORE")) {
				criteria.add(Restrictions.eq("petitionSource", location));
			}
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}

		return list;
	}

	public static List<Location> getLocationChilds(int locationId) {
		List<LocationChild> locationChild = null;
		List<Location> childLocation = new ArrayList<Location>();
		Session sessionHibernate = HibernateSessionFactory.getSession();

		try {
			locationChild = sessionHibernate.createCriteria(LocationChild.class).add(Restrictions.eq("id.parentLocation", locationId)).list();
			for (Iterator iterator = locationChild.iterator(); iterator.hasNext();) {
				LocationChild locationChild2 = (LocationChild) iterator.next();
				childLocation.add(locationChild2.getLocationByChildLocation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
		return childLocation;
	}

//	public static void main(String args[]) {
//		Location root = new Location();
//		root.setId(1);
//		List<Location> completeList = buildList(root);
//		for (Iterator iterator = completeList.iterator(); iterator.hasNext();) {
//			Location location = (Location) iterator.next();
//		}
//		System.out.println(completeList);
//	}

	public static List<Location> buildList(Location location) {
		List<Location> childLocatoins = getLocationChilds(location.getId());
		if (childLocatoins.size() == 0) {
			return childLocatoins;
		} else {
			for (Iterator iterator = childLocatoins.iterator(); iterator.hasNext();) {
				Location childLocation = (Location) iterator.next();
				if (childLocation != null) {
					childLocatoins.addAll(buildList(childLocation));
				}
			}
			return childLocatoins;
		}
	}
}
