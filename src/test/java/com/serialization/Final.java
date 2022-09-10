package com.serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Final {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\APIOne\\src\\test\\resources\\SimpleJSON\\NK.JSON");
		ObjectMapper om = new ObjectMapper();

		ArrayList<String> li = new ArrayList<String>();
		li.add("Mersal");
		li.add("NK");
		li.add("KN");

		ArrayList<Two> li1 = new ArrayList<Two>();
		Two t = new Two("Erode", "TN", "India");
		Two t1 = new Two("PalaKolu", "AP", "India");

		li1.add(t);
		li1.add(t1);

		One o = new One("Mersal", 2153, "QA", li, li1);

		om.writeValue(f, o);

	}
}
