package com.hackaton.carlos.turisan.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackaton.carlos.turisan.R;

import Controller.FunnyCameraController;

/**
 * Created by Carlos on 12/12/2015.
 */
public class MaskCameraView extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //crear el controlador
        FunnyCameraController ctrl=new FunnyCameraController(this.getActivity());

        return inflater.inflate(R.layout.fragment_mask_camera, container, false);
    }
}
