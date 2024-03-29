package com.darmajaya.basiccomputer.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.darmajaya.basiccomputer.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView title = root.findViewById(R.id.title);
        final TextView content = root.findViewById(R.id.content);
        final TextView notelp = root.findViewById(R.id.notelp);

        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                title.setText(s);
            }
        });
        return root;
    }
}