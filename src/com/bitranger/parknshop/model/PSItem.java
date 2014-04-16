package com.bitranger.parknshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * @author BowenCai
 *
 */
@Entity
@Table(name="ps_item")
public class PSItem implements Serializable {

	private static final long serialVersionUID = -2684972399517135416L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int 			id;
	
	@ManyToOne
	@JoinColumn(name="id")
	int				id_shop;

	@ManyToOne
	@JoinColumn(name="id")
	int				id_category;
	
	@Column(name="price", precision=15, scale=2)
	BigDecimal		price;
	
	@Column
	String			name;
	
	@Column
	String			introduction;
	
	@Column(name="time_created")
	Date			timeCreated;

	@Column
	String			extra_1;
	@Column
	String			extra_2;
	@Column
	String			extra_3;
	
	
}
