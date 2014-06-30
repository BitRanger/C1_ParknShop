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
package com.bitranger.parknshop.seller.dao;

import java.util.List;

import com.bitranger.parknshop.seller.model.PsRecipient;

public interface IPsRecipientDAO {
	public abstract void save(PsRecipient transientInstance);
	public abstract void delete(PsRecipient persistentInstance);
	public abstract void update(PsRecipient detachedInstance);
	
	public abstract List<PsRecipient> findByCustomId(Integer id);
	public abstract PsRecipient findById(Integer psRecipientId);
}
