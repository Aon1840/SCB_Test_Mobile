package com.example.mobile_guide.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobile_guide.Activity.MobileDetailActivity;
import com.example.mobile_guide.Adapter.MobileListAdapter;
import com.example.mobile_guide.DAO.Mobile;
import com.example.mobile_guide.Manager.HttpManager;
import com.example.mobile_guide.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ListMobileFragment extends Fragment {

    ListView listView;
    List<Mobile> mobiles;
    Parcelable state;

    public ListMobileFragment() {
        super();
    }

    public static ListMobileFragment newInstance() {
        ListMobileFragment fragment = new ListMobileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_mobile_fragment, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        //TODO: Sorting

        listView = (ListView) rootView.findViewById(R.id.listView);

        Call<List<Mobile>> call = HttpManager.getInstance()
                .getService()
                .getAllMobile();
        call.enqueue(new Callback<List<Mobile>>() {
            @Override
            public void onResponse(Call<List<Mobile>> call, Response<List<Mobile>> response) {
                mobiles = response.body();
                listView.setAdapter(new MobileListAdapter(getContext(), mobiles));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getContext(), MobileDetailActivity.class);
                        intent.putExtra("name", mobiles.get(i).getName());
                        intent.putExtra("description", mobiles.get(i).getDescription());
                        intent.putExtra("price",mobiles.get(i).getPrice());
                        intent.putExtra("rating",mobiles.get(i).getRating());
                        intent.putExtra("image",mobiles.get(i).getThumbImageURL());

                        Log.d("Data---------","Price is: "+mobiles.get(i).getPrice());
                        Log.d("Data---------","Rating is: "+mobiles.get(i).getRating());
                        startActivity(intent);
                    }
                });
                if (state  != null) {
                    listView.onRestoreInstanceState(state);
                }
            }

            @Override
            public void onFailure(Call<List<Mobile>> call, Throwable t) {
                Log.d("TEST---------","Error is: "+t.getMessage());
                Toast.makeText(getContext(),"Error is: "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onPause() {
        state = listView.onSaveInstanceState();
        super.onPause();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        if (state  != null) {
            listView.onRestoreInstanceState(state);
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        if (state  != null) {
            listView.onRestoreInstanceState(state);
        }
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
