package com.example.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/network/RetrofitBuilder;", "", "()V", "BASE_URL", "", "apiService", "Lcom/example/network/IApiService;", "getApiService", "()Lcom/example/network/IApiService;", "getRetrofit", "Lretrofit2/Retrofit;", "network_debug"})
public final class RetrofitBuilder {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_URL = "https://api.github.com";
    @org.jetbrains.annotations.NotNull
    private static final com.example.network.IApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.network.RetrofitBuilder INSTANCE = null;
    
    private RetrofitBuilder() {
        super();
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.network.IApiService getApiService() {
        return null;
    }
}