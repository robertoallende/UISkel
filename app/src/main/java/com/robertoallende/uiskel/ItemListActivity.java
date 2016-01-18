package com.robertoallende.uiskel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.robertoallende.uiskel.dummy.DummyContent;

import java.util.List;

public class ItemListActivity extends AppCompatActivity implements
        ItemListFragment.OnListFragmentInteractionListener {

    private String FRAGMENT_TAG = "ItemListFragment";
    private ItemListFragment itemListDataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        itemListDataFragment = (ItemListFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);

        if (itemListDataFragment == null) {
            ItemListFragment itemListFragment = new ItemListFragment();
            fragmentTransaction.add(R.id.activity_item_list_content, itemListFragment);
            fragmentTransaction.commit();
        } else {
            List<DummyContent> dummyContent = (List<DummyContent>) itemListDataFragment.getData();
            ItemListFragment itemListFragment =
                    (ItemListFragment) fragmentManager.findFragmentById(R.id.activity_item_list_content);
            itemListFragment.setData(dummyContent);
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
