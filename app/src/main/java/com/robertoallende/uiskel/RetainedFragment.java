package com.robertoallende.uiskel;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.List;

/*
    Following
    http://developer.android.com/guide/topics/resources/runtime-changes.html
 */
public class RetainedFragment extends Fragment {

    private List<?> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public List<?> getData() {
        return data;
    }
}
