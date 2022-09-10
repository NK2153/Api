package org.sample;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Api {
	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jp = new JSONParser();
		FileReader fr = new FileReader(
				"C:\\Users\\ELCOT\\eclipse-workspace\\APIOne\\src\\test\\resources\\SimpleJSON\\simpleone.JSON");

		Object parse = jp.parse(fr);
		JSONObject jo = (JSONObject) parse;

		System.out.println((String) jo.get("name"));
		System.out.println(jo.get("id"));
		System.out.println(jo.get("role"));

		Object object = jo.get("Cources");
		JSONArray ja = (JSONArray) object;

		for (int i = 0; i < ja.size(); i++) {
			System.out.println((String) ja.get(i));

		}
		Object object2 = jo.get("Address");
		JSONArray ja1 = (JSONArray) object2;
		for (int i = 0; i < ja1.size(); i++) {
			Object object3 = ja1.get(i);
			JSONObject jo1 = (JSONObject) object3;
			System.out.println(
					(String) jo1.get("city") + " " + (String) jo1.get("state") + " " + (String) jo1.get("Country"));

		}

	}

}
