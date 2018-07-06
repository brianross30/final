package com.byrsolutions.hemofiliapp;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * Created by 43446720 on 23/4/2018.
 */

public class IngresoInfusion2 extends Fragment implements View.OnClickListener {

    Date Fecha;
    String Observaciones;
    String Marca;
    int Unidades;
    String Profilaxis;
    String Motivo;
    EditText Lote;
    EditText FechaVencimiento;
    EditText Potencia;
    String lote;
    Date fechaVencimiento;
    int potencia;
    Button Enviar;
    TextView Cargo;

    RequestQueue requestQueue;

    public View onCreateView(LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos) {
        Log.d("IngresoInfusion2", "Entro");
        View VistaDevolver;
        VistaDevolver = InfladorDeLayouts.inflate(R.layout.ingreso_infusion2, GrupoDeLaVista, false);

        Log.d("IngresoInfusion2", "Mande la vista");




        Log.d("IngresoInfusion2", "Conecto con el layout y la activity principal");




        Log.d("IngresoInfusion2", "Conecto los datos viejos");

        //hasta aca recibe todos los datos que ingresó en el primer fragment

        Lote = (EditText) VistaDevolver.findViewById(R.id.Lote);
        Potencia = (EditText) VistaDevolver.findViewById(R.id.Potencia);
        FechaVencimiento = (EditText) VistaDevolver.findViewById(R.id.FechaVencimiento);
        //fechaVencimiento = FechaVencimiento.getText().toString();
        Cargo = (TextView) VistaDevolver.findViewById(R.id.CargoDatos);
        Enviar = (Button) VistaDevolver.findViewById(R.id.BotonEnviar);
        Enviar.setOnClickListener(this);

        Log.d("IngresoInfusion2", "Conecto los datos nuevos");

        // le doy valores previos a los datos para ejecutar mas rapido xd
        String lot = "abcd1234";
        Lote.setText(lot);
        String pot = "184";
        Potencia.setText(pot);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        String fechaActual = dateFormat.format(date);
        FechaVencimiento.setText(fechaActual);



        Log.d("IngresoInfusion2", "Muestro los datos a ingresar, ahora devuelvo la vista");
        return VistaDevolver;

    }

    public void onClick(View VistaRecibida) {
        Log.d("IngresoInfusion2", "Entro al boton");

        //VALIDAR LA FECHA
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        fechaVencimiento=new Date();
        try {
            fechaVencimiento=format.parse(FechaVencimiento.getText().toString());
            System.out.println(fechaVencimiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("IngresoInfusion2", "La fecha es:" +fechaVencimiento);
        Cargo.setText("Cargo los datos");
        lote = (Lote.getText().toString());
        potencia = Integer.parseInt(Potencia.getText().toString());

        Log.d("IngresoInfusion2", "El lote es: " +lote);
        Log.d("IngresoInfusion2", "La potencia es: " +potencia);
        Log.d("IngresoInfusion2", "La fecha de vencimiento es: " +fechaVencimiento.toString());


        Log.d("IngresoInfusion2", "Declaro datos del gson");

        ActivityPrincipal ActividadAnfitriona;
        ActividadAnfitriona = (ActivityPrincipal) getActivity();

        Fecha = ActividadAnfitriona.GetFecha();
        Observaciones = ActividadAnfitriona.GetObservaciones();
        Marca = ActividadAnfitriona.GetMarca();
        Unidades = ActividadAnfitriona.GetUnidades();
        Profilaxis = ActividadAnfitriona.GetProfilaxis();
        Motivo = ActividadAnfitriona.GetMotivo();

        Dato d;
        String insertUrl = "http://192.168.0.23/InsertarLibretaVirtual.php";
        // PUSE EL NUMERO DE MI COMPUTADORA, CAMBIARLO


        d = new Dato();
        //d.setId(Integer.valueOf(id_vw.getText().toString()));
        d.setPotencia1(potencia);
        String pot = "" + d.getPotencia1();
        //Log.d("IngresoInfusion2", pot);

        d.setFechaVencimiento1(fechaVencimiento);
        //Log.d("IngresoInfusion2", ""+d.getFechaVencimiento1());

        d.setLote1(lote);
        //Log.d("IngresoInfusion2", d.getLote1());

        d.setPotencia2(0);

        d.setFechaVencimiento2(fechaVencimiento);

        d.setLote2(lote);

        d.setUnidades(Unidades);
        String unid = ""+d.getUnidades();
        //Log.d("IngresoInfusion2", unid);

        d.setFechaInfusion(Fecha);
        //Log.d("IngresoInfusion2", ""+d.getFechaInfusion());

        d.setMarca(Marca);
        //Log.d("IngresoInfusion2", d.getMarca());

        d.setProfilaxisDemanda(Profilaxis);
        //Log.d("IngresoInfusion2", d.getProfilaxis());

        d.setMotivo(Motivo);
        //Log.d("IngresoInfusion2", d.getMotivo());

        d.setObservaciones(Observaciones);
        //Log.d("IngresoInfusion2", d.getObservaciones());


        Context Contexto = ActividadAnfitriona.getApplicationContext();
        requestQueue = Volley.newRequestQueue(Contexto);

        //JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, );

        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> parameters = new HashMap<String, String>();
                String json = "{\"FechaInfusion\":\""+ Fecha +"\",\"FechaVencimiento1\":\""+fechaVencimiento+"\",\"FechaVencimiento2\":\""+fechaVencimiento+"\" ,\"Lote1\":\""+lote+"\",\"Lote2\":\""+lote+"\",\"Marca\":\""+Marca+"\",\"Motivo\":\""+Motivo+"\",\"Observaciones\":\""+Observaciones+"\",\"ProfilaxisDemanda\":\""+Profilaxis+"\",\"Potencia1\":"+potencia+",\"Potencia2\":"+potencia+",\"Unidades\":"+Unidades+"}";
                parameters.put("Json", json);
                return parameters;
            }
        };
        requestQueue.add(request);
        Log.d("IngresoInfusion2", "Cree el objeto de tipo dato y le asigne sus valores");

    }
}
