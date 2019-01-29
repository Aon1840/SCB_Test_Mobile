package com.example.mobile_guide.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mobile_guide.R;

public class MobileDetailActivity extends AppCompatActivity {

    TextView tvName, tvDescription, tvPrice, tvRating;
    ImageView ivImg;
    String name, description, price, rating, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_detail);

        initInstance();
    }

    private void initInstance() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvRating = (TextView) findViewById(R.id.tvRating);
        ivImg = (ImageView) findViewById(R.id.ivImg);

        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        description = extras.getString("description");
        price = extras.getString("price");
        rating = extras.getString("rating");
        image = extras.getString("image");

        tvName.setText(name);
        tvDescription.setText(description);
        tvPrice.setText("Price: $"+price);
        tvRating.setText("Rating: "+rating);
        Glide.with(getApplicationContext())
                .load(image)
                .into(ivImg);

    }
}
