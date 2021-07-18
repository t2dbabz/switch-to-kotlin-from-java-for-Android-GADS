package com.sriyank.javatokotlindemo.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class SearchResponse extends RealmObject {

	@SerializedName("total_count")
	private int totalCount;

	private RealmList<Repository> items;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Repository> getItems() {
		return items;
	}

	public void setItems(RealmList<Repository> items) {
		this.items = items;
	}
}
