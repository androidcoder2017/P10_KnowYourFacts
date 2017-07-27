package com.example.a15056112.p10_knowyourfacts;


import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag3 extends Fragment {

    Button btnChange;
    boolean colorChange = true;
    ImageView iv;
    public Frag3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_frag3, container, false);

        btnChange = (Button)view.findViewById(R.id.btnChange);
        iv = (ImageView)view.findViewById(R.id.iv);
        final LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.linearlayout);


        String imageUrl = "http://68.media.tumblr.com/d59dc0240d4bd43ccb0edde4da8332ab/tumblr_otpzte6lTq1roqv59o1_500.png";
        Picasso.with(getContext()).load(imageUrl).into(iv);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (colorChange) {
                   Random random = new Random();
                   int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                   linearLayout.setBackgroundColor(color);
               }

            }
        });

        return view;

    }

}
