package com.marius.newsreader.common.navigator;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.marius.data.model.Article;
import com.marius.newsreader.R;
import com.marius.newsreader.articledetails.fragment.ArticleDetailsFragment;
import com.marius.newsreader.articledetails.model.ArticleDetailsViewModel;
import com.marius.newsreader.common.ViewModelFactory;

public class ArticleDetailsNavigator {
    private final FragmentManager fragmentManager;

    public ArticleDetailsNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void showArticleDetails(int id) {
        ArticleDetailsFragment fragment = new ArticleDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ArticleDetailsFragment.EXTRA_ARTICLE_ID, id);
        fragment.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }
}
