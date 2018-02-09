package com.figengungor.githubsearch_archcomponents;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.figengungor.githubsearch_archcomponents.databinding.ActivitySearchBinding;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchActivityViewModel viewModel;
    ActivitySearchBinding binding;
    RepositoryAdapter adapter;
    private static final String TAG = SearchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        adapter = new RepositoryAdapter();
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(
                this, new SearchActivityViewModelFactory(GitHubDataManager.getInstance())).get(SearchActivityViewModel.class);

        viewModel.getSearchResponse().observe(this,
                searchResponse -> {
                    Log.d(TAG, "searchResponse");
                    //TODO: Add empty view
                    adapter.setItems(searchResponse.getItems());
                }
        );

        viewModel.getIsLoading().observe(this,
                isLoading -> {
                    if (isLoading) {
                        binding.progressBar.setVisibility(View.VISIBLE);
                    } else {
                        binding.progressBar.setVisibility(View.GONE);
                    }
                });

        viewModel.getError().observe(this,
                error -> Toast.makeText(this, "oh mon dieu " + error.getMessage(), Toast.LENGTH_SHORT).show()

        );

        binding.searchBtn.setOnClickListener(view -> {
            String query = binding.searchEt.getText().toString();
            if (TextUtils.isEmpty(query))
                Toast.makeText(this, "No no no!", Toast.LENGTH_SHORT).show();
            else{
                Utils.hideKeyboard(this);
                adapter.setItems(null);
                viewModel.search(query);
            }

        });

    }
}
