package org.example.model.dao;

import java.util.List;

import org.example.model.PsCategory;

public interface IPsCategoryDAO {

	public abstract void save(PsCategory transientInstance);

	public abstract void delete(PsCategory persistentInstance);

	public abstract List<PsCategory> findAll(Integer limit, Integer offset);

	public abstract void update(PsCategory detachedInstance);
}