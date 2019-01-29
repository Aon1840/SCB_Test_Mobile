package com.example.mobile_guide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mobile_guide.DAO.Mobile;
import com.example.mobile_guide.R;

import java.util.List;

public class MobileListAdapter extends BaseAdapter {

    private Context context;
    private List<Mobile> mobiles;

    public MobileListAdapter(Context context, List<Mobile> mobiles) {
        this.context = context;
        this.mobiles = mobiles;
    }

    @Override
    public int getCount() {
        return mobiles.size();
    }

    @Override
    public Object getItem(int i) {
        return mobiles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.list_item_mobile, parent, false);

        Mobile mobile = mobiles.get(i);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(mobile.getName());

        TextView tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
        tvDescription.setText(mobile.getDescription());

        TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        tvPrice.setText("Price: $"+mobile.getPrice());

        TextView tvRating = (TextView) convertView.findViewById(R.id.tvRating);
        tvRating.setText("Rating: "+mobile.getRating());

        ImageView ivImg = (ImageView) convertView.findViewById(R.id.ivImg);
        Glide.with(context)
                .load(mobile.getThumbImageURL())
                .into(ivImg);


        return convertView;
    }
}
