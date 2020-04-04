package com.kaiburr.restapi;

public class Server
{
	private String name;
	private int id;
	private String language;
	private String framework;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getFramework() {
		return framework;
	}
	public void setFramework(String framework) {
		this.framework = framework;
	}
	@Override
	public String toString() {
		return "Server [name=" + name + ", id=" + id + ", language=" + language + ", framework=" + framework + "]";
	}
}
