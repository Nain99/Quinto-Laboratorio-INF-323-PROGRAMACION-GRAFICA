package com.example.laboratorio5;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * @author Nain Perez
 * @version 17.7.2020 v1
 */

public class MainActivity extends Activity {

    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    Renderiza renderiza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RelativeLayout pantalla = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        GLSurfaceView superficie = new GLSurfaceView(this);
        pantalla.addView(superficie);

        boton1 = (Button) pantalla.findViewById(R.id.boton1);
        boton1.bringToFront();
        boton2 = (Button) pantalla.findViewById(R.id.boton2);
        boton2.bringToFront();
        boton3 = (Button) pantalla.findViewById(R.id.boton3);
        boton3.bringToFront();
        boton4 = (Button) pantalla.findViewById(R.id.boton4);
        boton4.bringToFront();

        renderiza = new Renderiza(this);

        superficie.setRenderer(renderiza);
        setContentView(pantalla);
    }
    /* BOTONES*/
    public void boton_adelante(View v) { renderiza.opcion_adelante(); }
    public void boton_atras(View v) { renderiza.opcion_atras(); }
    public void boton_izquierda(View v) { renderiza.opcion_izquierda(); }
    public void boton_derecha(View v) { renderiza.opcion_derecha(); }

}





