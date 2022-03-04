package com.example.security.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	private int oid;
	private int cakeid;
	private String name;
	private int price;
	private int id;
	public Orders() {
		
	}
	public Orders(int cakeid, String name, int price,int id) {
		this.cakeid = cakeid;
		this.name = name;
		this.price = price;
		this.id=id;
	}

	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Orders [cakeid=" + cakeid + ", name=" + name + ", price=" + price + ", id=" + id + "]";
	}
	
	
}
