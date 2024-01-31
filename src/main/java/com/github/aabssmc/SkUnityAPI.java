package com.github.aabssmc;

import com.github.aabssmc.docs.Docs;
import com.github.aabssmc.docs.Syntax;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("unused")
public class SkUnityAPI {

    public static void main(String[] args){
        login("c778d0defd0b51b9c8ff22d91e08a39a");
        System.out.println(Docs.getSyntaxesFromAddon("Skuishy"));
    }

    /**
     * The api url.
     */
    public static final String url = "https://api.skunity.com/v1/API_KEY/";

    /**
     * The api key.
     */
    public static String api_key;

    /**
     * @param url The main url.
     * @param endpoint The api endpoint (ex: servers).
     * @return The response body as a string.
     */
    @Nullable
    public static String request(@NotNull String url, @NotNull String endpoint){
        OkHttpClient client = new OkHttpClient();
        Request req;
        if (api_key != null) {
            req = new Request.Builder()
                    .url(url.replaceAll("API_KEY", api_key) + endpoint)
                    .build();
        }
        else{
            req = new Request.Builder()
                    .url(url + endpoint)
                    .build();
        }
        try (Response response = client.newCall(req).execute()){
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("An unknown error occurred! SkUnity servers are down?");
        return null;
    }

    /**
     * @param api_key The api key.
     * @return True if the api key is valid.
     */
    public static boolean login(String api_key){
        String req = request(url.replaceAll("API_KEY", api_key), "test");
        if (Objects.equals(req, "{\"response\":\"failed\",\"result\":\"Invalid API Key provided\"}")){
            return false;
        }
        SkUnityAPI.api_key = api_key;
        return true;
    }
}