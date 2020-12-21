package com.nus.invms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@Entity
public class Fixset {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fixsetId;
	
	private String fixsetName;
	
	private String fixsetDescription;
	
	@ManyToMany
	@JoinTable(name="fixsets_parts",
			joinColumns = {@JoinColumn(name="fk_fixset")},
			inverseJoinColumns = {@JoinColumn(name="fk_parts")})
	private List<Part> parts = new ArrayList<Part>();
	
	public List<Part> getPart() {
		return parts;
	}



	public void setPart(List<Part> part) {
		this.parts = parts;
	}

	public Fixset() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Fixset(String fixsetName, String fixsetDescription, List<Part> parts) {
		super();
		this.fixsetName = fixsetName;
		this.fixsetDescription = fixsetDescription;
		this.parts = parts;
	}

	public int getFixsetId() {
		return fixsetId;
	}

	public void setFixsetId(int fixsetId) {
		this.fixsetId = fixsetId;
	}

	public String getFixsetName() {
		return fixsetName;
	}

	public void setFixsetName(String fixsetName) {
		this.fixsetName = fixsetName;
	}

	public String getFixsetDescription() {
		return fixsetDescription;
	}

	public void setFixsetDescription(String fixsetDescription) {
		this.fixsetDescription = fixsetDescription;
	}
	
	public void removePart(Part part) {
		parts.remove(part);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fixsetId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fixset other = (Fixset) obj;
		if (fixsetId != other.fixsetId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fixset [fixsetId=" + fixsetId + ", fixsetName=" + fixsetName + ", fixsetDescription="
				+ fixsetDescription + ", parts=" + parts + "]";
	}
	
	
	

}
