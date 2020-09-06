package com.dhathri.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mytransactions")
public class User{
	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public  int transactionamount;
	public int balance;
	
	
	public int getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(int transactionamount) {
		this.transactionamount = transactionamount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", transactionamount=" + transactionamount + ", balance=" + balance + "]";
	}
	
	public User(int transactionamount, int balance) {
		super();
		this.transactionamount = transactionamount;
		this.balance = balance;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}