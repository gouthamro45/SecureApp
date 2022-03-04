package com.example.security.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Cakes {
	
	@Id
	@GeneratedValue
	private int cakeid;
	private String name;
	private int price;
	
	
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
		return "Cakes [cakeid=" + cakeid + ", name=" + name + ", price=" + price + "]";
	}
	
}
