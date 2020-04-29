package com.dicoding.picodiploma.vespa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dicoding.picodiploma.vespa.adapter.ListVespaAdapter;

import java.util.ArrayList;
import com.dicoding.picodiploma.vespa.Vespa;
import com.dicoding.picodiploma.vespa.VespasData;

public class MoveActivity extends AppCompatActivity {
    public static  String vespaNames = "vespa_names";
    public static  String vespaDetails = "vespa_details";
    public static  String vespaImage = "vespa_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        TextView vespaNames = findViewById(R.id.tv_item_name);
        TextView vespaDetails = findViewById(R.id.tv_item_detail);
        ImageView vespaImages = findViewById(R.id.img_item_photo);

    }

}
