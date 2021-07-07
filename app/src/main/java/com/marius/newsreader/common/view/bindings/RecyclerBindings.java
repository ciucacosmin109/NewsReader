package com.marius.newsreader.common.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marius.data.model.Article;
import com.marius.newsreader.common.handler.ArticleItemHandler;
import com.marius.newsreader.newslist.adapter.ArticleItemAdapter;
import com.marius.newsreader.newslist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {
    @BindingAdapter({"items", "itemHandler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> items, ArticleItemHandler handler) {
        ArticleItemAdapter adapter = (ArticleItemAdapter) recyclerView.getAdapter();

        if (adapter == null) {
            adapter = new ArticleItemAdapter();
            adapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(adapter);
        }

        adapter.setItems(items, handler);
    }
}
