package org.example.model.dao;

import java.util.List;

import org.example.model.PsAdministator;

public interface IPsAdministatorDAO {
	public abstract PsAdministator findByName(String name);

}