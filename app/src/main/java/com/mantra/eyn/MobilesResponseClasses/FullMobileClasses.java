package com.mantra.eyn.MobilesResponseClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class FullMobileClasses implements Serializable {

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	@SerializedName("url")
	private String url;

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public String getUrl(){
		return url;
	}
}