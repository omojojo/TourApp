package com.example.ayanbadejo.tourapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragTwo extends Fragment {

    /**
     *set variables for the recyclerView
     *The view to inflate the fragment
     *And variable for the adapter
     */
    ArrayList<Tour> tour;
    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;
    View v;

    public FragTwo() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        v =inflater.inflate (R.layout.fragment_recycler, container, false);
         /*
         bind the recyclerView in the activity layout
         Attach the adapter to the recyclerView to populate items
         Set layout manager to position the items
         set the recyclerView with a fixed size
         set animation of the view to default
         */
        recyclerView =v. findViewById (R.id.recycler_view);
        mAdapter = new RecyclerViewAdapter (tour);
        recyclerView.setLayoutManager (new LinearLayoutManager (getContext ()));
        recyclerView.setItemAnimator (new DefaultItemAnimator ());
        recyclerView.hasFixedSize ();
        recyclerView.setAdapter (mAdapter);
        return v;
    }

    /**
     * Called to do initial creation of a fragment.  This is called after
     *  and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * <p>
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>Any restored child fragments will be created before the base
     * <code>Fragment.onCreate</code> method returns.</p>
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        tour = new ArrayList<> ();
        tour.add (new Tour (getString(R.string.eyo_festival), R.drawable.eyo));
    }
}
