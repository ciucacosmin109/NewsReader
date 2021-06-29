package com.marius.newsreader.newslist.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marius.newsreader.databinding.NewsListFragmentBinding;
import com.marius.newsreader.newslist.model.NewsListViewModel;
import com.marius.newsreader.common.ViewModelFactory;
import com.marius.newsreader.common.navigator.AlertNavigator;

public class NewsListFragment extends Fragment {

    private NewsListViewModel mViewModel;
    private AlertNavigator alertNavigator;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertNavigator = new AlertNavigator(getChildFragmentManager(), requireContext());

        ViewModelFactory factory = new ViewModelFactory(requireActivity().getApplication());
        mViewModel = new ViewModelProvider(requireActivity(), factory).get(NewsListViewModel.class);

        mViewModel.error.observe(this, alertNavigator::showErrorFor);
        mViewModel.openLink.observe(this, this::openLink);

        //for those lifecycle callbacks in view model, like ON_CREATE
        getLifecycle().addObserver(mViewModel);
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }
}