package com.sriyank.javatokotlindemo.app;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sriyank.javatokotlindemo.models.ErrorResponse;

import java.io.IOException;

import okhttp3.ResponseBody;

public class Util {

	public static void showErrorMessage(Context context, ResponseBody errorBody) {

		Gson gson = new GsonBuilder().create();
		ErrorResponse errorResponse;
		try {
			errorResponse = gson.fromJson(errorBody.string(), ErrorResponse.class);
			showMessage(context, errorResponse.getMessage());
		} catch (IOException e) {
			Log.i("Exception ", e.toString());
		}
	}

	public static void showMessage(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
}
