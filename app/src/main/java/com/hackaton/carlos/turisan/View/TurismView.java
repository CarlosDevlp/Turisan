package com.hackaton.carlos.turisan.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackaton.carlos.turisan.R;

import Controller.FunnyCameraController;

/**
 * Created by Carlos on 12/12/2015.
 */
public class TurismView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //FunnyCameraController ctrl = new  FunnyCameraController(this.getActivity());
        return inflater.inflate(R.layout.fragment_turism_view, container, false);
    }

}