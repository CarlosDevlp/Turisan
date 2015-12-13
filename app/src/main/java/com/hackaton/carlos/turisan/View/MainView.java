package com.hackaton.carlos.turisan.View;

import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hackaton.carlos.turisan.R;
import com.hackaton.carlos.turisan.View.FunnyCameraView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import Controller.Control;
import Model.Browser;
import Model.Function;

public class MainView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<ArrayList<String>> lstActividadesCulturales, lstTurism;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        //picasso
        //turism
        Picasso.with(this).load(R.drawable.bosque_el_olivar).into((ImageView) findViewById(R.id.Turism_img_1));
        Picasso.with(this).load(R.drawable.observacion_de_aves).into((ImageView) findViewById(R.id.Turism_img_2));
        Picasso.with(this).load(R.drawable.huaca_huallamarca_nw).into((ImageView) findViewById(R.id.Turism_img_3));
        Picasso.with(this).load(R.drawable.iglesia_virgen_del_pilar).into((ImageView) findViewById(R.id.Turism_img_4));
        //cultural
        Picasso.with(this).load(R.drawable.teatro).into((ImageView) findViewById(R.id.Cultural_img_1));
        Picasso.with(this).load(R.drawable.teatro).into((ImageView) findViewById(R.id.Cultural_img_2));
        Picasso.with(this).load(R.drawable.teatro).into((ImageView) findViewById(R.id.Cultural_img_3));
        Picasso.with(this).load(R.drawable.teatro).into((ImageView) findViewById(R.id.Cultural_img_4));
        Picasso.with(this).load(R.drawable.teatro).into((ImageView) findViewById(R.id.Cultural_img_5));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //boton flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //evento de hacer click al boton flotante
            /*fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainView.this, FunnyCameraView.class);
                    //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        //Tabhost principal


        Resources res = getResources();

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        //tab 1
        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Turismo");
        //res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);
        //tab2
        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Actividades culturales");
        //res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        //camara 1
        //Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        //startActivityForResult(intent, 0);
        init();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void init() {
        lstActividadesCulturales = new ArrayList();
        initActividadesCulturales();

        TextView[] txts = new TextView[5];
        txts[0] = (TextView) findViewById(R.id.cultural_txt_1);
        txts[1] = (TextView) findViewById(R.id.cultural_txt_2);
        txts[2] = (TextView) findViewById(R.id.cultural_txt_3);
        txts[3] = (TextView) findViewById(R.id.cultural_txt_4);
        txts[4] = (TextView) findViewById(R.id.cultural_txt_5);

        TextView[] txtsSubA = new TextView[5];
        txtsSubA[0] = (TextView) findViewById(R.id.cultural_txtSubA_1);
        txtsSubA[1] = (TextView) findViewById(R.id.cultural_txtSubA_2);
        txtsSubA[2] = (TextView) findViewById(R.id.cultural_txtSubA_3);
        txtsSubA[3] = (TextView) findViewById(R.id.cultural_txtSubA_4);
        txtsSubA[4] = (TextView) findViewById(R.id.cultural_txtSubA_5);


        TextView[] txtsSubB = new TextView[5];
        txtsSubB[0] = (TextView) findViewById(R.id.cultural_txtSubB_1);
        txtsSubB[1] = (TextView) findViewById(R.id.cultural_txtSubB_2);
        txtsSubB[2] = (TextView) findViewById(R.id.cultural_txtSubB_3);
        txtsSubB[3] = (TextView) findViewById(R.id.cultural_txtSubB_4);
        txtsSubB[4] = (TextView) findViewById(R.id.cultural_txtSubB_5);

        for (int i = 0; i < txts.length; i++)
            txts[i].setText(lstActividadesCulturales.get(i).get(5));

        for (int i = 0; i < txtsSubA.length; i++)
            txtsSubA[i].setText(lstActividadesCulturales.get(i).get(1) + " " + lstActividadesCulturales.get(i).get(2) + "   (" + lstActividadesCulturales.get(i).get(4) + ") ");

        for (int i = 0; i < txtsSubB.length; i++)
            txtsSubB[i].setText(lstActividadesCulturales.get(i).get(0));


        //turismo
        lstTurism = new ArrayList();
        initTurism();


        TextView[] txts2 = new TextView[4];
        txts2[0] = (TextView) findViewById(R.id.Turism_txt_1);
        txts2[1] = (TextView) findViewById(R.id.Turism_txt_2);
        txts2[2] = (TextView) findViewById(R.id.Turism_txt_3);
        txts2[3] = (TextView) findViewById(R.id.Turism_txt_4);


        TextView[] txts2SubA = new TextView[4];
        txts2SubA[0] = (TextView) findViewById(R.id.Turism_txtSubA_1);
        txts2SubA[1] = (TextView) findViewById(R.id.Turism_txtSubA_2);
        txts2SubA[2] = (TextView) findViewById(R.id.Turism_txtSubA_3);
        txts2SubA[3] = (TextView) findViewById(R.id.Turism_txtSubA_4);


        TextView[] txts2SubB = new TextView[4];
        txts2SubB[0] = (TextView) findViewById(R.id.Turism_txtSubB_1);
        txts2SubB[1] = (TextView) findViewById(R.id.Turism_txtSubB_2);
        txts2SubB[2] = (TextView) findViewById(R.id.Turism_txtSubB_3);
        txts2SubB[3] = (TextView) findViewById(R.id.Turism_txtSubB_4);

        for (int i = 0; i < txts2.length; i++)
            txts2[i].setText(lstTurism.get(i).get(0));

        for (int i = 0; i < txts2SubA.length; i++)
            txts2SubA[i].setText(lstTurism.get(i).get(2));

        //for(int i=0;i<txts2SubB.length;i++)
        //  txts2SubB[i].setText(lstTurism.get(i).get(0));



    }


    public void initActividadesCulturales() {
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"29-Nov-15", "CC EL OLIVAR", "AUDITORIO", "4:00 PM", "TEATRO", "El cuco cuquito" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"29-Nov-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "TEATRO", "Asi de simple" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"30-Nov-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "ESPECTÁCULO", "Peruano con Poderes" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"4-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "DANZA", "Espectáculo de Flamenco" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"5-Dec-15", "CC EL OLIVAR", "AUDITORIO", "4:00 PM", "TEATRO", "El cuco cuquito" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"5-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "TEATRO", "Asi de simple" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"6-Dec-15", "CC EL OLIVAR", "AUDITORIO", "4:00 PM", "TEATRO", "El cuco cuquito" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"6-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "TEATRO", "Asi de simple" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"9-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "CONCIERTO", "Coro MSI" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"10-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "DANZA", "Espectáculo de Flamenco" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"12-Dec-15", "CC EL OLIVAR", "AUDITORIO", "4:00 PM", "TEATRO", "El cuco cuquito" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"12-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "TEATRO", "Asi de simple" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"13-Dec-15", "CC EL OLIVAR", "AUDITORIO", "4:00 PM", "TEATRO", "El cuco cuquito" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"13-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "TEATRO", "Asi de simple" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"14-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "ESPECTÁCULO", "El Mago George" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"15-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "ESPECTÁCULO", "El Mago George" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"19-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "TEATRO", "Asi de simple" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"20-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "TEATRO", "Asi de simple" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"21-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "ESPECTÁCULO", "El Mago George" })));
        lstActividadesCulturales.add(new ArrayList<String>(Arrays.asList(new String[]{"22-Dec-15", "CC EL OLIVAR", "AUDITORIO", "8:00 PM", "ESPECTÁCULO", "El Mago George" })));
    }


    public void initTurism() {
        lstTurism.add(new ArrayList<String>(Arrays.asList(new String[]{
                "Bosque El Olivar", "-12.101128,-77.035735", "  ", "Sin ninguna duda el atractivo más resaltante de San Isidro es el Bosque El Olivar, que constituye no solo un recuerdo vivo de la historia limeña, sino un gran pulmón para la ciudad. El Olivar, que fuera parte del fundo del Conde de San Isidro, está ubicado a 8 km. de la Plaza Mayor de Lima, cuya extensión es de 87 mil metros cuadrados de áreas verdes, siendo el centro y elemento característico del distrito.                En 1559, Don Antonio de Ribera trajo al Perú, desde Sevilla, numerosos olivos que fueron plantados en la Huerta Perdida, y posteriormente, algunos brotes fueron traídos al actual Olivar. En la actualidad, se cuenta con 1700 olivos aproximadamente, propagados por toda su extensión." })));


        lstTurism.add(new ArrayList<String>(Arrays.asList(new String[]{
                "Observando Aves en el Olivar", "-12.101128,-77.035735", "  ", "El pasatiempo de observación aves, también conocido como birdwatching o birding, cuenta con más adeptos en la capital, pues el Perú es el 3er país con mayor diversidad de aves en el mundo contando con 1835 especies. El Bosque “El Olivar” de San Isidro ofrece la fabulosa oportunidad de disfrutar esta actividad (ya sea por la mañana o la tarde), pues se cuenta con 25 – 30 especies de aves ubicados en diferentes partes alrededor del bosque." })));


        lstTurism.add(new ArrayList<String>(Arrays.asList(new String[]{
                "Huaca Huallamarca",
                "-12.09664,-77.040624",
                "El Museo de Sitio Huallamarca está ubicado en Av. Nicolás de Ribera 201 con esquina de Av. El Rosario.",
                "Este monumento arqueológico se encuentra debidamente preservado, ya que contrasta con los edificios modernos que hay a su alrededor siendo un claro testimonio del gran legado dejado por antiguas sociedades. Los trabajos arqueológicos han demostrado que el edificio muestra una larga y continúa secuencia cultural. Se han reconocido 3 distintos momentos de ocupación caracterizados por una función en particular (Centro Ceremonial, Cementerio y Edificio Público), y por el desarrollo de sociedades que abarcan desde el 200 A.C. hasta 1532 D.C." })));


        lstTurism.add(new ArrayList<String>(Arrays.asList(new String[]{
                "Iglesia Virgen del Pilar",
                "-12.095977,-77.035847",
                "Dirección: Av. Víctor Andrés Belaúnde 160. Teléfono:  440-2230 / 422-3110",
                "La parroquia Nuestra Señora del Pilar es hito distintivo de San Isidro." })));

    }


    //iniciar otros activities
    public void startQR(){
        try {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
            startActivity(marketIntent);
        }
    }

    public void startFunnyCameraActivity() {
        startActivity(new Intent(this, FunnyCameraView.class));
    }

    public void startFunnyCameraActivity(View v) {
        startActivity(new Intent(this, FunnyCameraView.class));
    }


    public void startDescriptionActivity(View v) {
        startActivity(new Intent(this, DescriptionView.class));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            String result = data.toURI();
            // ...
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            this.startFunnyCameraActivity();
        } else if (id == R.id.nav_gallery) {
            this.startQR();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainView Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.hackaton.carlos.turisan.View/http/host/path")
        );
       // AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainView Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.hackaton.carlos.turisan.View/http/host/path")
        );
        //AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
