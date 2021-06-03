package com.marius.newsreader.model;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel {
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> content;

    public ArticleItemViewModel() {
        imageUrl = new ObservableField<>();
        title = new ObservableField<>();
        content = new ObservableField<>();
    }

    public ArticleItemViewModel(String imageUrl, String title, String content) {
        this.imageUrl = new ObservableField<>(imageUrl);
        this.title = new ObservableField<>(title);
        this.content = new ObservableField<>(content);
    }
}
