package com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.bangunanbersejarah.masyarakat.bangunanbersejarah.R;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.adapter.BangunanAdapter;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.api.UtilsApi;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.NoteHelper;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.model.Bangunan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritFragment extends Fragment {

    private RecyclerView rvBangunan;
    private BangunanAdapter adapter;
    List<Bangunan> listBangunan = new ArrayList<>();

    private NoteHelper bangunanHelper;

    ProgressDialog loading;

    public FavoritFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorit, container, false);

        rvBangunan = (RecyclerView) view.findViewById(R.id.rv_bangunan);

        adapter = new BangunanAdapter(getContext(), listBangunan, 0);

        rvBangunan.setHasFixedSize(true);
        rvBangunan.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvBangunan.setAdapter(adapter);

        bangunanHelper = new NoteHelper(getContext());
        bangunanHelper.open();

        getAllFavorit();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Bangunan Terfavorit");
    }

    private void getAllFavorit() {
        if (listBangunan.size() > 0){
            listBangunan.clear();
        }
        //here
        listBangunan = bangunanHelper.query();

        rvBangunan.setAdapter(new BangunanAdapter(getContext(), listBangunan, 0));
        adapter.notifyDataSetChanged();
    }

}
