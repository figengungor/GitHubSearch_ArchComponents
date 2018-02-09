package com.figengungor.githubsearch_archcomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by figengungor on 2/9/2018.
 */

public class SearchActivityViewModel extends ViewModel {

    MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    MutableLiveData<Throwable> error = new MutableLiveData<>();

    GitHubDataManager dataManager;

    public SearchActivityViewModel(GitHubDataManager dataManager) {
        this.dataManager = dataManager;
        this.isLoading.setValue(false);
    }

    public void search(String query) {
        search(query, "stars", "asc");
    }

    public void search(String query, String sort, String order) {
        isLoading.setValue(true);
        dataManager.getRepositories(query, sort, order, new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                isLoading.setValue(false);
                if (response.isSuccessful()) searchResponse.setValue(response.body());
                else error.setValue(new Throwable("Server error"));
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                isLoading.setValue(false);
                error.setValue(t);
            }
        });
    }

    public MutableLiveData<SearchResponse> getSearchResponse() {
        return searchResponse;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<Throwable> getError() {
        return error;
    }
}
