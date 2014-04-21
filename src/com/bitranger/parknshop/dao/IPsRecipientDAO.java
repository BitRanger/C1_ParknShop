package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsRecipient;

public interface IPsRecipientDAO {
	public abstract void save(PsRecipient transientInstance);
	public abstract void delete(PsRecipient persistentInstance);
	public abstract void update(PsRecipient detachedInstance);
	public abstract PsRecipient findByRecipientId(Integer id);
	public abstract List<PsRecipient> findByCustomId(Integer id);
}