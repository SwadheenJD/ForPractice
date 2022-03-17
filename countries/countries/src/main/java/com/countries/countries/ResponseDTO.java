package com.countries.countries;

import java.util.ArrayList;

public class ResponseDTO 
{
String message;
ArrayList<String> al;
public ResponseDTO(String message, ArrayList<String> al) {
	super();
	this.message = message;
	this.al = al;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public ArrayList<String> getAl() {
	return al;
}
public void setAl(ArrayList<String> al) {
	this.al = al;
}
}
