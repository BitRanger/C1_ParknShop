package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PsAdministator;

public interface IPsAdministatorDAO {
	public abstract PsAdministator findByName(String name);

}