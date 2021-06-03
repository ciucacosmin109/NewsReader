package com.marius.newsreader.model.mapper;

import com.marius.data.model.Article;
import com.marius.newsreader.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesToVmMapper implements Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(List<Article> dataItems) {
        List<ArticleItemViewModel> vmItems = new ArrayList<>();

        for (Article dataItem : dataItems) {
            ArticleItemViewModel viewModelItem = new ArticleItemViewModel();

            viewModelItem.imageUrl.set(dataItem.imageUrl);
            viewModelItem.title.set(dataItem.title);
            viewModelItem.content.set(dataItem.content);

            vmItems.add(viewModelItem);
        }

        return vmItems;
    }
}
