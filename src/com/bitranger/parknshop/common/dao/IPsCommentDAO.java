/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.common.dao;

import java.util.List;

import com.bitranger.parknshop.common.model.PsComment;

public interface IPsCommentDAO {
	
	
	public abstract void save(PsComment transientInstance);
	public abstract void delete(PsComment persistentInstance);

	public PsComment findById(java.lang.Integer id);
	
	/**
	 * sort by time_created
	 * @param customerId
	 * @param limit
	 * @param offset
	 * @return
	 */
	public abstract List<PsComment> findByCustomerId(Integer customerId, 
													FetchOption option);
	/**
	 * sort by time_created, in descending order
	 * @param itemId
	 * @param limit
	 * @param offset
	 * @return
	 */
	public abstract List<PsComment> findByItemId(Integer itemId, 
												FetchOption option);

	public List<PsComment> findByScore(Object score);

	public List<PsComment> findByContent(Object content);

	public List<PsComment> findAll();
}
