package com.example.mobile_guide.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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
        // Init 'View' instance(s) with rootView.findViewById here
        listView = (ListView) rootView.findViewById(R.id.listView);

        Call<List<Mobile>> call = HttpManager.getInstance()
                .getService()
                .getAllMobile();
        call.enqueue(new Callback<List<Mobile>>() {
            @Override
            public void onResponse(Call<List<Mobile>> call, Response<List<Mobile>> response) {
                mobiles = response.body();
                listView.setAdapter(new MobileListAdapter(getContext(), mobiles));
            }

            @Override
            public void onFailure(Call<List<Mobile>> call, Throwable t) {
                Log.d("TEST---------","Error is: "+t.getMessage());
                Toast.makeText(getContext(),"Error is: "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onStart() {
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
        // Save Instance State here
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
