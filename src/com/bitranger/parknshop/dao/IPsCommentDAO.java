/*******************************************************************************
 * Copyright (c) 2014 BitRanger.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     BitRanger - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsComment;

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
