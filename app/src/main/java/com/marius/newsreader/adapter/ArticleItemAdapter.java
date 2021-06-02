package com.marius.newsreader.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marius.newsreader.databinding.ArticleItemBinding;
import com.marius.newsreader.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleItemAdapter extends RecyclerView.Adapter<ArticleItemAdapter.ArticleItemViewHolder> {
    private List<ArticleItemViewModel> list; 

    public ArticleItemAdapter() {
        this.list = new ArrayList<>();
    }

    @Override
    public ArticleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ArticleItemBinding binder = ArticleItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new ArticleItemViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleItemViewHolder holder, int position) {
        holder.binding.setViewModel(list.get(position)); 
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(List<ArticleItemViewModel> items) {
        this.list = items;
        notifyDataSetChanged();
    }

    public class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        final ArticleItemBinding binding;
        
        public ArticleItemViewHolder(ArticleItemBinding binding){
            super(binding.getRoot()); 
            this.binding = binding;
        }
    }
}
