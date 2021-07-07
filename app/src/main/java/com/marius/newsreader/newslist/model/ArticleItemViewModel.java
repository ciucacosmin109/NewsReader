package com.marius.newsreader.newslist.model;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel {
    public final ObservableField<Integer> id;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> description;

    public ArticleItemViewModel() {
        id = new ObservableField<>();
        imageUrl = new ObservableField<>();
        title = new ObservableField<>();
        description = new ObservableField<>();
    }

}
