package com.fskroes.ikpmd.services;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users/{user}/repos")
    Call<List<TimeUnit>> listRepos(@Path("user") String user);
}
