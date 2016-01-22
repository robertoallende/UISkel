package com.robertoallende.uiskel;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.robertoallende.uiskel.dummy.DummyContent;

import java.util.Collections;
import java.util.List;

public class ItemListActivity extends AppCompatActivity implements
        ItemListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout)).setTitle("Eclairs");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null) {
            ItemListFragment itemListFragment = new ItemListFragment();
            fragmentTransaction.add(R.id.activity_item_list_content, itemListFragment);
            fragmentTransaction.commit();
        }

        final SwipeRefreshLayout mySwipeRefreshLayout =
                (SwipeRefreshLayout) findViewById(R.id.activity_item_list_content);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {

                    @Override
                    public void onRefresh() {
                        // TODO: Here goes the code to update list on swipe event
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        ItemListFragment itemListFragment =
                                   (ItemListFragment) fragmentManager.findFragmentById(R.id.activity_item_list_content);
                        List<DummyContent.DummyItem> items = DummyContent.ITEMS;
                        Collections.reverse(items);
                        itemListFragment.updateContent(items);
                        // Remove the progress indicator and update the view contents.
                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
