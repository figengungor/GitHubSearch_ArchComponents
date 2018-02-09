package com.figengungor.githubsearch_archcomponents;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by figengungor on 2/9/2018.
 */

public class GitHubServiceFactory {

    public static GitHubService createGitHubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GitHubService.class);
    }

}
