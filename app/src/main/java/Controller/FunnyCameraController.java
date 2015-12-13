package Controller;

import android.app.Activity;
import android.hardware.Camera;
import android.view.SurfaceView;

import Model.FunnyCamera;

/**
 * Created by Carlos on 12/12/2015.
 */
public class FunnyCameraController {
    private Activity act;
    private FunnyCamera camera;
    //constructor
    public FunnyCameraController(Activity a){
        this.act=a;
        camera=new FunnyCamera(a);
    }



    //methods
    public Camera getCamera(){
        return camera.getCamera();
    }

    public SurfaceView getSurfaceView(){
        return camera.getSurfaceView();
    }

}
