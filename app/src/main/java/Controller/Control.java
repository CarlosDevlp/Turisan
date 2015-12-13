package Controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


import Model.Browser;
import Model.Function;
import Model.GPS;
import Model.Place;

/**
 * Main Entity for every process
 * Created by carlos on 28/07/15.
 */
abstract public class Control {
//Structures
    public interface Ssystem{
        void init(Context ctxt);
        Context getSelf();
        void setWallpaper(Bitmap img);
    }
    public interface ActivityPointer{
        void point(Context _other);
        Context get();
        Object getLocationService();
    }
//Properties
    //pointer to activities
    public static ActivityPointer actPointer=new ActivityPointer(){
        private Context _self;
        public void point(Context _other){
            this._self=_other;
        }
        public Context get(){
            return this._self;
        }
        //Services
        public Object getLocationService(){
            return this._self.getSystemService(Context.LOCATION_SERVICE);
        }
    };
    //funciones dentro del contexto del sistema android
    public static Ssystem Android= new Ssystem(){
        private Context _Self;

        public void init(Context ctxt){
            this._Self=ctxt;
        }
        public Context getSelf(){
            return this._Self;
        }
        //
        public void setWallpaper(Bitmap img){
                try {
                    this._Self.setWallpaper(img);
                }catch(Exception err){
                }
        }

    };



    private static Browser _browser;
    //protected static GPS _gps;

    private static Switch _swtStart;

    private static Place _city;
    private static Boolean _stop;//stop app

//Functions
    public static void init(Context android,Context mainActivity, WebView wb,String url){
        //initialization
        Control.Android.init(android);//System
        //Control._browser=new Browser(wb,url);//browser
        Control.actPointer.point(mainActivity);//activity


        //Control._gps=new GPS(Control.actPointer.getLocationService());
        Control._swtStart=_swtStart;
        Control._city=new Place();

        Control._stop=false;
        //start process
        //Control.findCityInfo();


    }



}


