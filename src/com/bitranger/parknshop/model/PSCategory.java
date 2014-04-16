package com.bitranger.parknshop.model;

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
@Table(name="ps_category")
public class PSCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int 		id;
	
}
