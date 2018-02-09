package com.figengungor.githubsearch_archcomponents;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by figengungor on 2/9/2018.
 */

public interface GitHubService {

    @GET("search/repositories")
    Call<SearchResponse> getRepositories(@Query("q") String query,
                                         @Query("sort") String sort,
                                         @Query("order") String order);

}
