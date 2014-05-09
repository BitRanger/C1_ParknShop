package com.bitranger.parknshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author BowenCai
 *
 */
@Entity
@Table(name="ps_map")
public class Entry {

	private static final long serialVersionUID = 4298774913028106988L;
	private static final int serialID32 = (int) (serialVersionUID ^ (serialVersionUID >>> 32));

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer		id = null;
	
	@Column
	public String		ref = null;
	
	@Column
	public Object		obj = null;
	
	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		} else if (o instanceof Entry) {
			return ((Entry) o).id == this.id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.id * 31 + serialID32;
	}
	
}
