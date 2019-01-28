package com.example.mobile_guide.Manager.http;

import com.example.mobile_guide.DAO.Mobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class ApiService {

    @GET("api/mobiles/")
    Call<List<Mobile>> getAllMobile();
}
