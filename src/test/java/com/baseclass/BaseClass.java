package com.baseclass;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	static RequestSpecification specification;
	static Response response;

	public static void addHeader(String key, String value) {
		RequestSpecification given = RestAssured.given();
		specification = given.header(key, value);

	}

	public static void quaryParameter(String key, String value) {
		specification = specification.queryParam(key, value);
	}

	public static void pathParameter(String key, String value) {
		specification = specification.pathParam(key, value);
	}

	public static void addBody(Object value) {
		specification = specification.body(value);
	}

	public static Response reqType(String Type, String end) {
		switch (Type) {
		case "GET":
			response = specification.log().all().get(end);
			break;
		case "POST":
			response = specification.log().all().post(end);
			break;
		case "PUT":
			response = specification.log().all().put(end);

			break;
		case "DELETE":
			response = specification.log().all().put(end);
			break;

		default:

			break;
		}
		return response;
	}

	public static int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public static String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;

	}

	public static String getResBodyAsprettyString(Response response) {
		String prettyString = response.asPrettyString();
		return prettyString;
	}

	public static void basicAuth(String key, String value) {
		specification.auth().preemptive().basic(key, value);

	}

	public static void addHeaders() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("", "");
		Header h2 = new Header("", "");
		Header h3 = new Header("", "");
		header.add(h1);
		header.add(h2);
		header.add(h3);
		Headers headers = new Headers(header);
		RestAssured.given().headers(headers);

	}

}
