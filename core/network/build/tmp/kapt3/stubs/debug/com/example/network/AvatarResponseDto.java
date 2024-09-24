package com.example.network;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;

@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/example/network/AvatarResponseDto;", "", "login", "", "url", "name", "company", "bio", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBio", "()Ljava/lang/String;", "getCompany", "getLogin", "getName", "getUrl", "network_debug"})
public final class AvatarResponseDto {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String login = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String url = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String company = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String bio = null;
    
    public AvatarResponseDto(@com.squareup.moshi.Json(name = "login")
    @org.jetbrains.annotations.NotNull
    java.lang.String login, @com.squareup.moshi.Json(name = "avatar_url")
    @org.jetbrains.annotations.NotNull
    java.lang.String url, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.Nullable
    java.lang.String name, @com.squareup.moshi.Json(name = "company")
    @org.jetbrains.annotations.Nullable
    java.lang.String company, @com.squareup.moshi.Json(name = "bio")
    @org.jetbrains.annotations.Nullable
    java.lang.String bio) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLogin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCompany() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBio() {
        return null;
    }
}