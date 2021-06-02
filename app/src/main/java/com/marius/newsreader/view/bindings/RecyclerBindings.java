package com.marius.newsreader.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marius.newsreader.adapter.ArticleItemAdapter;
import com.marius.newsreader.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {
    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> tasks) {
        ArticleItemAdapter adapter = (ArticleItemAdapter) recyclerView.getAdapter();

        if (adapter == null) {
            adapter = new ArticleItemAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(adapter);
        }

        adapter.setItems(tasks);
    }
}
