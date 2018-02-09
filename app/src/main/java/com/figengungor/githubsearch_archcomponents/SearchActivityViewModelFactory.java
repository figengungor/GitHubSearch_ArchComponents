package com.figengungor.githubsearch_archcomponents;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by figengungor on 2/9/2018.
 */

public class SearchActivityViewModelFactory implements ViewModelProvider.Factory {

    private final GitHubDataManager dataManager;

    public SearchActivityViewModelFactory(GitHubDataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public SearchActivityViewModel create(Class modelClass) {
        return new SearchActivityViewModel(dataManager);
    }

}
