package com.marius.newsreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.marius.newsreader.common.ViewModelFactory;
import com.marius.newsreader.common.navigator.ArticleDetailsNavigator;
import com.marius.newsreader.newslist.fragment.NewsListFragment;
import com.marius.newsreader.newslist.model.ArticleItemViewModel;
import com.marius.newsreader.newslist.model.NewsListViewModel;

import io.reactivex.disposables.Disposable;

public class NewsReaderActivity extends AppCompatActivity {
    private Disposable disposable;
    private ArticleDetailsNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }

        navigator = new ArticleDetailsNavigator(getSupportFragmentManager());

        ViewModelFactory factory = new ViewModelFactory(this.getApplication());
        NewsListViewModel viewModel = new ViewModelProvider(this, factory).get(NewsListViewModel.class);

        disposable = viewModel.events.subscribe(
                this::goToArticleDetails,
                throwable -> { }
        );
    }

    private void goToArticleDetails(ArticleItemViewModel article){
        Integer id = article.id.get();
        if(id != null){
            navigator.showArticleDetails(id);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (disposable != null) {
            disposable.dispose();
        }
    }
}