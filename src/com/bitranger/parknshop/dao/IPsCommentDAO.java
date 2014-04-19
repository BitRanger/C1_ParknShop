package org.example.model.dao;

import java.util.List;

import org.example.model.PsComment;

public interface IPsCommentDAO {
	public abstract void save(PsComment transientInstance);
	public abstract void delete(PsComment persistentInstance);
	public abstract List<PsComment> findByCustomerId(Integer customerId, Integer limit, Integer offset);
	public abstract List<PsComment> findByItemId(Integer itemId, Integer limit, Integer offset);
}