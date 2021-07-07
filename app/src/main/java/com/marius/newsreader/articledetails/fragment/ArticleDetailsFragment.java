package com.marius.newsreader.articledetails.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marius.newsreader.articledetails.model.ArticleDetailsViewModel;
import com.marius.newsreader.common.navigator.AlertNavigator;
import com.marius.newsreader.databinding.ArticleDetailsFragmentBinding;
import com.marius.newsreader.common.ViewModelFactory;

public class ArticleDetailsFragment extends Fragment {
    public final static String EXTRA_ARTICLE_ID = "EXTRA_ARTICLE_ID";

    private ArticleDetailsViewModel mViewModel;
    private AlertNavigator alertNavigator;

    public static ArticleDetailsFragment newInstance() {
        return new ArticleDetailsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertNavigator = new AlertNavigator(getChildFragmentManager(), requireContext());

        ViewModelFactory factory = new ViewModelFactory(requireActivity().getApplication());
        mViewModel = new ViewModelProvider(requireActivity(), factory).get(ArticleDetailsViewModel.class);
        if (getArguments() != null && getArguments().containsKey(EXTRA_ARTICLE_ID)) {
            mViewModel.initArticle(getArguments().getInt(EXTRA_ARTICLE_ID));
        }

        mViewModel.error.observe(this, alertNavigator::showErrorFor);
        mViewModel.openLink.observe(this, this::openLink);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArticleDetailsFragmentBinding binding = ArticleDetailsFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }
}