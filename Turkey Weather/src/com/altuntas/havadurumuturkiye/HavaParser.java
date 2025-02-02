package com.altuntas.havadurumuturkiye;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.SyncStatusObserver;

public class HavaParser {
	
	public static Hava getHava(String data) throws JSONException
	{
		Hava hava = new Hava();
		
		//We created a new Json Object to keep all data
		JSONObject jObj = new JSONObject(data);
		
		//Lets Start with assigning data
		Bolge blg = new Bolge();
		
		JSONObject coordObj = getSubObject("coord", jObj);
		blg.setLongitude(getFloat("lon",coordObj));
		blg.setLatitude(getFloat("lat",coordObj));
		
		JSONObject sysObj = getSubObject("sys", jObj);
		blg.setCity(getString("name", jObj));
		blg.setCountry(getString("country", sysObj));	
		
		JSONObject mainObj = getSubObject("main", jObj);
		hava.sicaklik.setTemp(getFloat("temp", mainObj));
		
		//get all the weather array data
		JSONArray jArr = jObj.getJSONArray("weather");
		JSONObject JSONWeather = jArr.getJSONObject(0);
		hava.anlikhava.setDescription(getString("main", JSONWeather));
		
		
		
		hava.bolge = blg; 

		
		return hava;
	}
	
	private static JSONObject getSubObject(String tagName, JSONObject jObj) throws JSONException {
		
		JSONObject subObj = jObj.getJSONObject(tagName);
		return subObj;
	}

	private static String getString(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getString(tagName);
	}

	private static Float getFloat(String tagName, JSONObject jObj) throws JSONException {
		
		return (float) jObj.getDouble(tagName);
	}



}
