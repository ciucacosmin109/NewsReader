package com.marius.newsreader.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marius.newsreader.databinding.NewsListFragmentBinding;
import com.marius.newsreader.model.NewsListViewModel;

public class NewsListFragment extends Fragment {

    private NewsListViewModel mViewModel;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new NewsListViewModel();

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

}