package org.oursight.jersey.hello;

public class Hello {
	
	private int id;
	
	private String name;
	
	// the constractor is a MUST for jersey client
	public Hello() {
		
	}
	
	public Hello(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id:" + id +"; name: "+name;
	}
	
	

}
