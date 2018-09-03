package fauzi.hilmy.jakfirefighter.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponsePemadam{

	@SerializedName("Dinas")
	private String dinas;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("count")
	private int count;

	@SerializedName("status")
	private String status;

	public String getDinas(){
		return dinas;
	}

	public List<DataItem> getData(){
		return data;
	}

	public int getCount(){
		return count;
	}

	public String getStatus(){
		return status;
	}
}