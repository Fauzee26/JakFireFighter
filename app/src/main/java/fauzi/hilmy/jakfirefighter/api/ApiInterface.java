package fauzi.hilmy.jakfirefighter.api;

import fauzi.hilmy.jakfirefighter.model.ResponsePemadam;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {
    @GET("v1/emergency/petugaspemadam/")
    Call<ResponsePemadam> getPemadamStaf();
}
