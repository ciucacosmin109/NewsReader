package com.marius.newsreader.common.navigator;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;

import com.marius.data.store.remote.exception.ApiException;
import com.marius.data.store.remote.exception.ConnectivityException;

import io.reactivex.annotations.NonNull;

public class AlertNavigator {
    private final Context context;

    public AlertNavigator(@NonNull FragmentManager fragmentManager, @NonNull Context context) {
        this.context = context;
    }

    public void showErrorFor(@NonNull Throwable throwable) {
        if (throwable instanceof ConnectivityException || throwable instanceof ApiException) {
            //showAlert(context.getString(R.string.network_error, throwable.getMessage()));
            showAlert("Network error" + throwable.getMessage());
        }
    }

    public void showAlert(@NonNull String message) {
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("Ok", (dialogInterface, i) -> {

                })
                .show();
    }
}
