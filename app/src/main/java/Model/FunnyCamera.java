package Model;

import android.app.Activity;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;

import com.hackaton.carlos.turisan.R;

import java.io.IOException;
import java.util.zip.Inflater;

/**
 * Objeto Camara Funny
 * Created by Carlos on 12/12/2015.
 */
public class FunnyCamera {


    private SurfaceView surface_view;
    private Camera mCamera;
    SurfaceHolder.Callback sh_ob = null;
    SurfaceHolder surface_holder        = null;
    SurfaceHolder.Callback sh_callback  = null;
    private Activity act=null;
    public  FunnyCamera(Activity a){
        this.act=a;
        surface_view = new SurfaceView(a.getApplicationContext());


        a.addContentView(surface_view, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT));


        mCamera = Camera.open();

        if (surface_holder == null)
            surface_holder = surface_view.getHolder();
        sh_callback = my_callback();
        surface_holder.addCallback(sh_callback);




    }

    public void takePicture(){

    }
    public Camera getCamera(){
        return mCamera;
    }

    SurfaceHolder.Callback my_callback() {


        SurfaceHolder.Callback ob1 = new SurfaceHolder.Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //mCamera = Camera.open();

                try {
                    mCamera.setPreviewDisplay(holder);
                } catch (IOException exception) {
                    mCamera.release();
                    mCamera = null;
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {
                mCamera.startPreview();
            }
        };
        return ob1;
    }

    public SurfaceView getSurfaceView(){
        return surface_view;
    }


}
