package com.hackaton.carlos.turisan.View;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackaton.carlos.turisan.R;
import com.squareup.picasso.Picasso;

public class DescriptionView extends AppCompatActivity {
    public MediaPlayer mp;
    public AudioManager audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Descripción");
        setSupportActionBar(toolbar);

        String []info=new String[]{"Iglesia Virgen del Pilar",
                                    "-12.095977,-77.035847",
                                    "Dirección: Av. Víctor Andrés Belaúnde 160. Teléfono:  440-2230 / 422-3110",
                                    "Sin ninguna duda el atractivo más resaltante de San Isidro es el Bosque El Olivar, que constituye no solo un recuerdo vivo de la historia limeña, sino un gran pulmón para la ciudad. El Olivar, que fuera parte del fundo del Conde de San Isidro, está ubicado a 8 km. de la Plaza Mayor de Lima, cuya extensión es de 87 mil metros cuadrados de áreas verdes, siendo el centro y elemento característico del distrito.\n" +
                                            "\n"};

        Picasso.with(this).load(R.drawable.iglesia_virgen_del_pilar).into((ImageView) findViewById(R.id.Descp_photo));

        TextView title=(TextView) findViewById(R.id.Descp_txt);
        title.setText(info[0]);

        TextView schedule=(TextView) findViewById(R.id.Descp_txtSubA);
        schedule.setText(info[2]);

        TextView descp=(TextView) findViewById(R.id.Descp_txtSubB);
        descp.setText(info[3]);
        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        mp = MediaPlayer.create(this, R.raw.santuarioaudioguia);
        //mp.start();
    }

    public void reproduceAudio(View v){
        if(!mp.isPlaying()){

            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            mp = MediaPlayer.create(this, R.raw.santuarioaudioguia);
            mp.start();

        }
    }

    public void startCardBoard(View v){

        if(mp.isPlaying())
            mp.pause();
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.visita.sanisidro");
        startActivity(launchIntent);

    }


}
