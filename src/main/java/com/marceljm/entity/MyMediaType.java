package com.marceljm.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyMediaType {

	private String type;

	private String message;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
