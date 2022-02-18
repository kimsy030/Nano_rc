package com.example.smart_mode_lampes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class LightControlFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_light_control, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.stop).setOnClickListener(this::onClickButtonSend1);
        view.findViewById(R.id.front).setOnClickListener(this::onClickButtonSend2);
        view.findViewById(R.id.back).setOnClickListener(this::onClickButtonSend3);
        view.findViewById(R.id.right).setOnClickListener(this::onClickButtonSend4);
        view.findViewById(R.id.left).setOnClickListener(this::onClickButtonSend5);
    }

    public void onClickButtonSend1(View view) {
        ConnectedThread connectedThread = getConnectedThread();
        if (connectedThread != null) {
            connectedThread.write("s");
        }
    }

    public void onClickButtonSend2(View view) {
        ConnectedThread connectedThread = getConnectedThread();
        if (connectedThread != null) {
            connectedThread.write("f");
        }
    }

    public void onClickButtonSend3(View view) {
        ConnectedThread connectedThread = getConnectedThread();
        if (connectedThread != null) {
            connectedThread.write("b");
        }
    }

    public void onClickButtonSend4(View view) {
        ConnectedThread connectedThread = getConnectedThread();
        if (connectedThread != null) {
            connectedThread.write("r");
        }
    }

    public void onClickButtonSend5(View view) {
        ConnectedThread connectedThread = getConnectedThread();
        if (connectedThread != null) {
            connectedThread.write("l");
        }
    }
}
