package com.sriyank.javatokotlindemo.models;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Repository extends RealmObject {

	@PrimaryKey
	private int id;

	private String name;

	private String language;

	@SerializedName("html_url")
	private String htmlUrl;

	private String description;

	@SerializedName("stargazers_count")
	private Integer stars;

	@SerializedName("watchers_count")
	private Integer watchers;

	private Integer forks;

	private Owner owner;

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Integer getWatchers() {
		return watchers;
	}

	public void setWatchers(Integer watchers) {
		this.watchers = watchers;
	}

	public Integer getForks() {
		return forks;
	}

	public void setForks(Integer forks) {
		this.forks = forks;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
