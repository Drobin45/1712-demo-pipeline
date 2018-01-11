package com.revature.model;

public class Reimbursement {

	private int Rid;
	private double Ramount;
	private String author;
	private String resolver;
	private boolean resolved;	
	
	public Reimbursement() {}
	
	public Reimbursement(int rid, double ramount, String author, String resolver, boolean resolved) {
		super();
		Rid = rid;
		Ramount = ramount;
		this.author = author;
		this.resolver = resolver;
		this.resolved = resolved;
	}
	public int getRid() {
		return Rid;
	}
	public void setRid(int rid) {
		Rid = rid;
	}
	public double getRamount() {
		return Ramount;
	}
	public void setRamount(double ramount) {
		Ramount = ramount;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	public boolean isResolved() {
		return resolved;
	}
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	@Override
	public String toString() {
		return "Reimbursement [Rid=" + Rid + ", Ramount=" + Ramount + ", author=" + author + ", resolver=" + resolver
				+ ", resolved=" + resolved + "]";
	}
	
	
}
