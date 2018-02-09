package com.figengungor.githubsearch_archcomponents;

import retrofit2.Callback;

/**
 * Created by figengungor on 2/9/2018.
 */

public class GitHubDataManager {

    private static GitHubDataManager instance;

    private GitHubService gitHubService;

    private GitHubDataManager() {
        this.gitHubService = GitHubServiceFactory.createGitHubService();
    }

    public static GitHubDataManager getInstance() {
        if (instance == null) {
            instance = new GitHubDataManager();
        }
        return instance;
    }

    public void getRepositories(String query, String sort, String order, Callback<SearchResponse> callback) {
        gitHubService.getRepositories(query, sort, order)
                .enqueue(callback);
    }

}
