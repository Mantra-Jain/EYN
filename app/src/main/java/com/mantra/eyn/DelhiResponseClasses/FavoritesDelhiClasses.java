package com.mantra.eyn.DelhiResponseClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class FavoritesDelhiClasses implements Serializable {

	@SerializedName("count")
	private int count;

	@SerializedName("count_label_next")
	private String countLabelNext;

	public int getCount(){
		return count;
	}

	public String getCountLabelNext(){
		return countLabelNext;
	}
}