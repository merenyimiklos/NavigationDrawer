package com.example.navigationdrawer_ikt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class SettingsFragment extends Fragment {

    private Button buttonSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        init(view);

        buttonSettings.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Megnyomtad a gombot", Toast.LENGTH_SHORT).show();
        });

        return view;
    }


    public void init(View view){

        buttonSettings = view.findViewById(R.id.settingsButton);
    }
}