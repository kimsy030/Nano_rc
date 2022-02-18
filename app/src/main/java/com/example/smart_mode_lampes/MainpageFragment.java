package com.example.smart_mode_lampes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainpageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainpage, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.link_button).setOnClickListener(this::onClickButtonSend8);
        //view.findViewById(R.id.link_button2).setOnClickListener(this::onClickButtonSend9);
    }

    public void onClickButtonSend8(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafe.naver.com/creativethon/7158"));
        startActivity(intent);
    }
/*
    public void onClickButtonSend9(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafe.naver.com/creativethon?iframe_url=/MyCafeIntro.nhn%3Fclubid=28591379"));
        startActivity(intent);
    }*/

}