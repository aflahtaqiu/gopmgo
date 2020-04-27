package com.gopmgo.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    protected ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getContext());
    }

    protected void onShowLoading(String message) {
        progressDialog.setMessage(message);

        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    protected void onHideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}