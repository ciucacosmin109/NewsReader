package com.marius.newsreader.newslist.model.mapper;

import com.marius.data.model.Article;
import com.marius.newsreader.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesToArticleItemsVmMapper implements Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(List<Article> dataItems) {
        List<ArticleItemViewModel> vmItems = new ArrayList<>();

        for (Article dataItem : dataItems) {
            ArticleItemViewModel viewModelItem = new ArticleItemViewModel();

            viewModelItem.id.set(dataItem.id);
            viewModelItem.imageUrl.set(dataItem.imageUrl);
            viewModelItem.title.set(dataItem.title);
            viewModelItem.description.set(dataItem.description);

            vmItems.add(viewModelItem);
        }

        return vmItems;
    }
}
