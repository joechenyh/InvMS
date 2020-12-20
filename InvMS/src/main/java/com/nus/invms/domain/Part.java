package com.nus.invms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Part {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int partId;
		
		@OneToOne
		private Product product;
		
//		private String partName;
		
//		private String partName;
		private Integer quantity;
		
		public Part() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		


		public Part(Product product, Integer quantity) {
			super();
			this.product = product;
			this.quantity = quantity;
		}




		public int getPartId() {
			return partId;
		}




		public void setPartId(int partId) {
			this.partId = partId;
		}


		



		public Integer getQuantity() {
			return quantity;
		}




		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}


		

		/*
		 * public String getPartName() { return partName; }
		 * 
		 * 
		 * 
		 * 
		 * public void setPartName(String partName) { this.partName = partName; }
		 */






		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + partId;
			return result;
		}




		public Product getProduct() {
			return product;
		}




		public void setProduct(Product product) {
			this.product = product;
		}




		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Part other = (Part) obj;
			if (partId != other.partId)
				return false;
			return true;
		}




		@Override
		public String toString() {
			return "Part [partId=" + partId + ", quantity=" + quantity + "]";
		}



		
	
		

}

	
	

