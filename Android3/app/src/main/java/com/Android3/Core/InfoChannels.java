
package com.mypackage;

public enum InfoChannels
{


	GPS("GPS_LOC");


	private String name; 

	InfoChannels(String name) {
		this.name = name;

	}

	public String getName(){
		return this.name;
	}
}
