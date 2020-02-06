package com.example.fragmentview.Retrofit;
import com.example.fragmentview.ModelClass;
import com.example.fragmentview.ModelClassLoad;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("getStatus")
    Call<ModelClass> getModelclass(@Body JsonObject getModelclass);
    @POST("createStatus")
    Call<JsonObject> getCreateStatus(@Body JsonObject getCreateStatus);
    @POST("loadStatus")
    Call<ModelClassLoad> getModelclassLoad(@Body JsonObject getModelclassLoad);




    
}
