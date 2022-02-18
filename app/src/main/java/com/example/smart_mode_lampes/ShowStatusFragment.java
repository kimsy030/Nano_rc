package com.example.smart_mode_lampes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ShowStatusFragment extends BaseFragment {
    private TextView tvCount;
    private int count = 200;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_status, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCount = view.findViewById(R.id.tv_count);
        tvCount.setText(count+"");
        view.findViewById(R.id.up_button).setOnClickListener(this::onClickButtonSend6);
        view.findViewById(R.id.down_button).setOnClickListener(this::onClickButtonSend7);
    }

    public void onClickButtonSend6(View view) {
        ConnectedThread connectedThread = getConnectedThread();
        if (connectedThread != null) {
            connectedThread.write("u");
            count = count + 20;
            if (count > 255){
                count = 255;
            }
            tvCount.setText(count+"");
        }
    }

    public void onClickButtonSend7(View view) {
        ConnectedThread connectedThread = getConnectedThread();
        if (connectedThread != null) {
            connectedThread.write("d");
            if(count != 255){
                count = count - 20;
                if (count < 60){
                    count = 60;
                }
            }else {
                count = 240;
            }
            tvCount.setText(count+"");
        }
    }
}
