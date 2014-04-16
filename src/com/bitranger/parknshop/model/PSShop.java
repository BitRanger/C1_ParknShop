package com.bitranger.parknshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author BowenCai
 *
 */
@Entity
@Table(name="ps_shop")
public class PSShop implements Serializable{
	
	private static final long serialVersionUID = 1263220955842205882L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int 		id;
	
}
