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
package com.bitranger.parknshop.seller.dao;

import java.util.List;

import com.bitranger.parknshop.seller.model.PsRecipient;

public interface IPsRecipientDAO {
	public abstract void save(PsRecipient transientInstance);
	public abstract void delete(PsRecipient persistentInstance);
	public abstract void update(PsRecipient detachedInstance);
	public abstract PsRecipient findByRecipientId(Integer id);
	public abstract List<PsRecipient> findByCustomId(Integer id);
}
