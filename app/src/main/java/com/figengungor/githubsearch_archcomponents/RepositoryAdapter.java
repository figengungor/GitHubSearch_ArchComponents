package com.figengungor.githubsearch_archcomponents;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by figengungor on 2/9/2018.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private ArrayList<Item> items;

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        Item item = items.get(position);
        holder.binding.setVariable(com.figengungor.githubsearch_archcomponents.BR.item, item);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        else return 0;
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding binding;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
