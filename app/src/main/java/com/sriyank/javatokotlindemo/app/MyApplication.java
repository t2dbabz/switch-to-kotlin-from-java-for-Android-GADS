package com.sriyank.javatokotlindemo.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Realm.init(this); // should only be done once when app starts

		RealmConfiguration config = new RealmConfiguration.Builder()
												.name("myrealm.realm")
												.build();

		Realm.setDefaultConfiguration(config);
	}
}
