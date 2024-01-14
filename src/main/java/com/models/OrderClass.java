package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderTable")
public class OrderClass {

	@Id
	@GeneratedValue
	private int oId;
	private int cId;
	private int pId;
	private String pName;
	private String pDesc;
	private int price;
	private int pQty;
	private int totalPrice;
	private boolean isConfirm;
	private boolean isDelivered;

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isConfirm() {
		return isConfirm;
	}

	public void setConfirm(boolean isConfirm) {
		this.isConfirm = isConfirm;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	@Override
	public String toString() {
		return "OrderClass [oId=" + oId + ", cId=" + cId + ", pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc
				+ ", price=" + price + ", pQty=" + pQty + ", totalPrice=" + totalPrice + ", isConfirm=" + isConfirm
				+ ", isDelivered=" + isDelivered + "]";
	}

}
