package com.byrsolutions.hemofiliapp;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class IngresoInfusion extends Fragment implements View.OnClickListener{

    EditText Fecha;
    java.sql.Date fecha;
    ArrayList<String> Marca;
    Spinner SpnMarcas;
    String marca;
    EditText Unidades;
    int unidades;
    RadioButton Profilaxis;
    RadioButton Demanda;
    String profilaxis;
    ArrayList<String> Motivo;
    Spinner SpnMotivos;
    String motivo;
    EditText Observaciones;
    String observaciones;
    Button Siguiente;


    public View onCreateView(LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        Log.d("FragmentIngresoInfusion", "Entre");
        View VistaDevolver;
        VistaDevolver=InfladorDeLayouts.inflate(R.layout.ingreso_infusion, GrupoDeLaVista, false);

        Log.d("FragmentIngresoInfusion", "Cree la view");

        Fecha=(EditText)VistaDevolver.findViewById(R.id.Fecha);
        SpnMarcas = (Spinner)  VistaDevolver.findViewById(R.id.SpinnerMarcas);
        Unidades=(EditText)VistaDevolver.findViewById(R.id.Unidades);
        Profilaxis=(RadioButton)VistaDevolver.findViewById(R.id.Profilaxis);
        SpnMotivos = (Spinner)  VistaDevolver.findViewById(R.id.SpinnerMotivos);
        Demanda=(RadioButton)VistaDevolver.findViewById(R.id.Demanda);
        Observaciones=(EditText)VistaDevolver.findViewById(R.id.Observaciones);
        Siguiente=(Button)VistaDevolver.findViewById(R.id.Boton);
        Siguiente.setOnClickListener(this);

        // le doy valores previos a los datos para ejecutar mas rapido xd
        String unid = "455";
        Unidades.setText(unid);
        Profilaxis.setChecked(true);
        String obs = "Hoy es domingo";
        Observaciones.setText(obs);
        // listo


        Log.d("FragmentIngresoInfusion", "Conecte los datos");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        java.util.Date date = new java.util.Date();
        String fechaActual = dateFormat.format(date);
        Fecha.setText(fechaActual);

        Log.d("FragmentIngresoInfusion", "Precargue la fecha actual");



        Log.d("FragmentIngresoInfusion", "Conecte con las cosas con el layout");

        Marca=new ArrayList<>();
        Marca.add("Elija una Marca");
        Marca.add("Pfizer");
        Marca.add("Xyntha");
        Marca.add("Bayer");
        ArrayAdapter<String> Adaptador;


        Adaptador=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Marca);
        Adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        SpnMarcas.setAdapter(Adaptador);
        SpnMarcas.setSelection(0);
        Log.d("FragmentIngresoInfusion", "Hice el spinner marcas");

        Motivo=new ArrayList<>();
        Motivo.add("Elija una Motivo");
        Motivo.add("Motivo1");
        Motivo.add("Motivo2");
        Motivo.add("Motivo3");
        ArrayAdapter<String> AdaptadorMotivo;


        AdaptadorMotivo=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Motivo);
        AdaptadorMotivo.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        SpnMotivos.setAdapter(AdaptadorMotivo);
        SpnMotivos.setSelection(0);
        Log.d("FragmentIngresoInfusion", "Hice el spinner Motivos");



        Log.d("FragmentIngresoInfusion", "Ahora devuelvo la vista");
        return  VistaDevolver;
    }

    public void onClick (View VistaRecibida){
        Log.d("FragmentIngresoInfusion", "Entro al boton");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Log.d("FragmentIngresoInfusion", "fecha: "+fecha);
        Log.d("FragmentIngresoInfusion", "fecha: "+Fecha.getText().toString());
        //fecha=new java.util.Date();
        /*try {
            fecha = format.parse(Fecha.getText().toString());
            System.out.println(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        Log.d("FragmentIngresoInfusion", "fecha: "+fecha);
        Log.d("FragmentIngresoInfusion", "Valide la fecha");

        observaciones=Observaciones.getText().toString();

        // aca hay que validartodo
        unidades = Integer.parseInt(Unidades.getText().toString());

        Log.d("FragmentIngresoInfusion", "Las unidades son: " +unidades);

        if(Profilaxis.isChecked()){
            profilaxis="Profilaxis";
        }
        else{
            profilaxis="Demanda";
        }
        Log.d("FragmentIngresoInfusion", "El usuario eligio el modo " +profilaxis);

        int posicion;
        posicion=SpnMarcas.getSelectedItemPosition();
        marca=SpnMarcas.getItemAtPosition(posicion).toString();
        Log.d("FragmentIngresoInfusion", "El usuario eligio la marca " +marca);

        posicion=SpnMotivos.getSelectedItemPosition();
        motivo=SpnMotivos.getItemAtPosition(posicion).toString();
        Log.d("FragmentIngresoInfusion", "El usuario eligio la motivo " +motivo);

        Log.d("FragmentIngresoInfusion", "La fecha es: " +fecha);

        Log.d("FragmentIngresoInfusion", "Las observaciones son: " +observaciones);

        ActivityPrincipal ActividadAnfitriona;
        ActividadAnfitriona=(ActivityPrincipal)getActivity();
        ActividadAnfitriona.IngresoInf(fecha, marca, unidades, profilaxis, motivo, observaciones);
        Log.d("FragmentIngresoInfusion", "Conecte con la activity y mande los datos");

        // EL PROBLEMA ERA QUE ESTABAMOS PARSEANDO LAS COSAS EN LOS ON CRATE
        //ARREGLAR LA FECHA ACA Y TODOS LOS DATOS EN INGRESO2
    }



}
