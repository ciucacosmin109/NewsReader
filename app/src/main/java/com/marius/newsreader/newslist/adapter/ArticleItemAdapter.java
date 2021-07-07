package com.marius.newsreader.newslist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marius.data.model.Article;
import com.marius.newsreader.common.handler.ArticleItemHandler;
import com.marius.newsreader.databinding.ArticleItemBinding;
import com.marius.newsreader.newslist.model.ArticleItemViewModel;
import com.marius.newsreader.newslist.model.mapper.ArticlesToArticleItemsVmMapper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ArticleItemAdapter extends RecyclerView.Adapter<ArticleItemAdapter.ArticleItemViewHolder> {
    private List<ArticleItemViewModel> list;
    private ArticleItemHandler handler;

    public ArticleItemAdapter() {
        this.list = new ArrayList<>();
    }

    @Override @NotNull
    public ArticleItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
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
        holder.binding.setHandler(handler);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setItems(List<ArticleItemViewModel> items, ArticleItemHandler handler) {
        this.list = items;
        this.handler = handler;
        notifyDataSetChanged();
    }

    public static class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        final ArticleItemBinding binding;
        
        public ArticleItemViewHolder(ArticleItemBinding binding){
            super(binding.getRoot()); 
            this.binding = binding;
        }
    }
}
