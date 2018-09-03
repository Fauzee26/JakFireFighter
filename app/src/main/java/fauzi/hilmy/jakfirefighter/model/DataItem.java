package fauzi.hilmy.jakfirefighter.model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("lng")
	private double lng;

	@SerializedName("phone")
	private String phone;

	@SerializedName("login_terakhir")
	private String loginTerakhir;

	@SerializedName("jabatan")
	private String jabatan;

	@SerializedName("wilayah")
	private String wilayah;

	@SerializedName("userid")
	private int userid;

	@SerializedName("lat")
	private double lat;

	@SerializedName("alamat")
	private String alamat;

	public String getNama(){
		return nama;
	}

	public double getLng(){
		return lng;
	}

	public String getPhone(){
		return phone;
	}

	public String getLoginTerakhir(){
		return loginTerakhir;
	}

	public String getJabatan(){
		return jabatan;
	}

	public String getWilayah(){
		return wilayah;
	}

	public int getUserid(){
		return userid;
	}

	public double getLat(){
		return lat;
	}

	public String getAlamat(){
		return alamat;
	}
}