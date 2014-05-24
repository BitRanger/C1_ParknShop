package com.bitranger.parknshop.common.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.common.dao.IPsAdministatorDAO;
import com.bitranger.parknshop.common.model.PsAdministator;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsAdministator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.common.model.PsAdministator
 * @author MyEclipse Persistence Tools
 */
public class PsAdministatorDAO extends HibernateDaoSupport implements IPsAdministatorDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PsAdministatorDAO.class);
	

	/**
	 * 

public Object get(String entityName,
                  Serializable id)
           throws DataAccessException
Description copied from interface: HibernateOperations 
Return the persistent instance of the given entity class with the given identifier, or null if not found. 
This method is a thin wrapper around Session.get(String, java.io.Serializable) for convenience. For an explanation of the exact semantics of this method, please do refer to the Hibernate API documentation in the first instance. 


Specified by:
get in interface HibernateOperations
Parameters:
entityName - the name of the persistent entity
id - the identifier of the persistent instance 
Returns:
the persistent instance, or null if not found 
Throws: 
DataAccessException - in case of Hibernate errors
See Also:
Session.get(Class, java.io.Serializable)
--------------------------------------------------------------------------------


	@Override
	public PsAdministator findByName(String name) {
		log.debug("getting PsAdministator instance with name: " + name);
		try {
			PsAdministator instance = (PsAdministator) getHibernateTemplate()
					.get("com.bitranger.PsAdministator", name);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		
	}
	 */
	
	@Override
	public PsAdministator findByEmail(String email) {
		log.debug("getting PsAdministator instance with email: " + email);
		try {
			PsAdministator instance = 
					(PsAdministator) getHibernateTemplate()
						.find(
					"FROM com.bitranger.PsAdministator WHERE email = ?"
					, email)
					.get(0);
			
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	

}