package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsComment;

public interface IPsCommentDAO {
	public abstract void save(PsComment transientInstance);
	public abstract void delete(PsComment persistentInstance);
	public abstract List<PsComment> findByCustomerId(Integer customerId, Integer limit, Integer offset);
	public abstract List<PsComment> findByItemId(Integer itemId, Integer limit, Integer offset);
}