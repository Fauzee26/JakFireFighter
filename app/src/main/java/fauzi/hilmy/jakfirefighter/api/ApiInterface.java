package fauzi.hilmy.jakfirefighter.api;

import fauzi.hilmy.jakfirefighter.model.ResponsePemadam;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {
    @GET("petugaspemadam")
    Call<ResponsePemadam> getPemadamStaf(
            @Header("Authorization") String authorization
    );
}
