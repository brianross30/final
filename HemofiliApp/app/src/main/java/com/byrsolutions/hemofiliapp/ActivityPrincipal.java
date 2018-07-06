package com.byrsolutions.hemofiliapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.byrsolutions.hemofiliapp.R.id.Unidades;
import static com.byrsolutions.hemofiliapp.R.id.contenido;
import static com.byrsolutions.hemofiliapp.R.id.tabmenu;

public class ActivityPrincipal extends Activity {
    FragmentManager AdministradorDeFragments;
    FragmentTransaction TransaccionesDeFragment;
    Date Fecha;
    String Observaciones;
    String Marca;
    int Unidades;
    String Profilaxis;
    String Motivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels; // ancho absoluto en pixels
        int height = metrics.heightPixels; // alto absoluto en pixels

        int AnchoBoton = ((width-20)-128)/3;
        int AltoBoton = height/100*10;
        //int Yinicial = height-AltoBoton-100;

        final LinearLayout toolbar;
        toolbar=(LinearLayout)findViewById(R.id.toolbar);
        float AltoToolbar = toolbar.getHeight();

        toolbar.post(new Runnable(){
            public void run(){
                float AltoToolbar = toolbar.getHeight();
            }
        });

        FrameLayout Contenido;
        Contenido=(FrameLayout)findViewById(R.id.contenido);
        float AltoFrame = Contenido.getHeight();

        //tt-yf-ab=margin
        float aux= height-AltoToolbar-AltoFrame-AltoBoton;
        int padding=(int)aux;

        LinearLayout tabmenu;
        tabmenu=(LinearLayout)findViewById(R.id.tabmenu);
        tabmenu.setPadding(0, 100, 0, 0);

        Button BotonIngreso;
        BotonIngreso=(Button)findViewById(R.id.BotonIngreso);
        BotonIngreso.setWidth(AnchoBoton);
        BotonIngreso.setHeight(AltoBoton);
        //BotonIngreso.setTranslationY(10);


        Button BotonLibreta;
        BotonLibreta=(Button)findViewById(R.id.BotonLibreta);
        BotonLibreta.setWidth(AnchoBoton);
        BotonLibreta.setHeight(AltoBoton);

        Button BotonAyuda;
        BotonAyuda=(Button)findViewById(R.id.BotonAyuda);
        BotonAyuda.setWidth(AnchoBoton);
        BotonAyuda.setHeight(AltoBoton);


        ImageButton BotonConfiguraciones;
        BotonConfiguraciones=(ImageButton)findViewById(R.id.BotonConfiguraciones);
        BotonConfiguraciones.setAdjustViewBounds(true);
        BotonConfiguraciones.setMaxWidth(128);
        BotonConfiguraciones.setMaxHeight(128);


        /*
        Timer Reloj;
        TimerTask Tarea;
        Reloj=new Timer();

        Tarea=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        };*/


        Fragment Ingreso;
        Ingreso=new IngresoInfusion();

        AdministradorDeFragments=getFragmentManager();
        TransaccionesDeFragment=AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragment.replace(R.id.contenido, Ingreso);
        TransaccionesDeFragment.commit();
    }

    public void IngresoInfusion(View VistaRecibida){

        Fragment Ingreso;
        Ingreso=new IngresoInfusion();

        AdministradorDeFragments=getFragmentManager();
        TransaccionesDeFragment=AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragment.replace(R.id.contenido, Ingreso);
        TransaccionesDeFragment.commit();

    }

    public void SlideDeAyuda(View VistaRecibida){
    }

    public void LibretaVirtual(View VistaRecibida){

    }

    public void IngresoInf(Date Fecha1, String Marca1, int Unidades1, String Profilaxis1, String Motivo1, String Observaciones1){
        Log.d("ActivityPrincipal", "Llegaron los datos");

        Fecha=Fecha1;
        Marca=Marca1;
        Unidades=Unidades1;
        Profilaxis=Profilaxis1;
        Motivo=Motivo1;
        Observaciones=Observaciones1;


        Fragment Ingreso2;
        Ingreso2=new IngresoInfusion2();


        AdministradorDeFragments=getFragmentManager();
        TransaccionesDeFragment=AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragment.replace(R.id.contenido, Ingreso2);
        TransaccionesDeFragment.commit();

        Log.d("ActivityPrincipal", "Pase al fragment Ingreso infusion 2 llevando el dato");
    }

    public Date GetFecha(){
        Log.d("ActivityPrincipal", "Mando fecha para el fragment ingreso infusion 2");
        return Fecha;
    }

    public String GetMarca(){
        Log.d("ActivityPrincipal", "Mando marca para el fragment ingreso infusion 2");
        return Marca;
    }

    public int GetUnidades(){
        Log.d("ActivityPrincipal", "Mando unidades para el fragment ingreso infusion 2");
        return Unidades;
    }

    public String GetProfilaxis(){
        Log.d("ActivityPrincipal", "Mando profilaxis para el fragment ingreso infusion 2");
        return Profilaxis;
    }

    public String GetMotivo(){
        Log.d("ActivityPrincipal", "Mando motivo para el fragment ingreso infusion 2");
        return Motivo;
    }

    public String GetObservaciones(){
        Log.d("ActivityPrincipal", "Mando observaciones para el fragment ingreso infusion 2");
        return Observaciones;
    }

}
