package com.mantra.eyn.MumbaiResponseClasses.MobilesInMumbai;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class AppliedFiltersMobileMumbaiClasses implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("description")
	private String description;

	@SerializedName("display_order")
	private int displayOrder;

	@SerializedName("type")
	private String type;

	@SerializedName("render_as")
	private String renderAs;

	@SerializedName("values")
	private List<ValuesMobileMumbaiClasses> values;

	public String getId(){
		return id;
	}

	public String getDescription(){
		return description;
	}

	public int getDisplayOrder(){
		return displayOrder;
	}

	public String getType(){
		return type;
	}

	public String getRenderAs(){
		return renderAs;
	}

	public List<ValuesMobileMumbaiClasses> getValues(){
		return values;
	}
}