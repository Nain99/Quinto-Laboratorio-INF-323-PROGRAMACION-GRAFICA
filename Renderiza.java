package com.example.laboratorio5;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

/**
 * @author Nain Perez
 * @version 17.7.2020 v1
 */

public class Renderiza extends GLSurfaceView implements Renderer{

    /* OBJETOS */
    private Cesped cesped;
    private Camino camino;
    private Arbol arbol;
    private Elefante elefante;
    private Montania montania;
    private Estructura2 estructura2;
    private Estructura1 estructura1;
    private Farol farol;
    private Casa casa;
    private Semaforo semaforo;
    private Banca banca;
    private Ave ave;

    private int i;
    private int j;

    private int angulo;

    public Renderiza(Context contexto) {
        super(contexto);
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

        this.cesped = new Cesped();
        this.camino = new Camino();
        this.arbol = new Arbol(1,15,15);
        this.elefante = new Elefante(1,20,20);
        this.montania = new Montania();
        this.estructura2 = new Estructura2(1,8,4);
        this.estructura1 = new Estructura1(4,9,9);
        this.farol = new Farol(1,4,2);
        this.casa = new Casa();
        this.semaforo = new Semaforo(1,39,39);
        this.banca = new Banca();
        this.ave = new Ave();
        this.j = 0;
        this.i = 0;
        this.angulo = 0;

        gl.glShadeModel(GL10.GL_FLAT);

        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glClearColor(179f/255f, 1, 1, 1);

    }

    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();

        gl.glRotatef(j, 0, 1, 0);
        gl.glTranslatef(0, -0.3f, this.i);


        gl.glPushMatrix();
        gl.glTranslatef(0,0,0);
        gl.glScalef(2f,1,2f);
        cesped.dibuja(gl);
        gl.glPopMatrix();

        /*------------RENDERIZA CAMINOS--------------*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-39);
        gl.glScalef(0.5f,1,1);
        camino.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0,0,-54);
        gl.glScalef(0.5f,1,1);
        camino.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0,0,-15);
        gl.glScalef(0.5f,1,1);
        camino.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0,0,9);
        gl.glScalef(0.5f,1,1);
        camino.dibujaPasoPeatonal(gl);
        gl.glPopMatrix();

        float m = -7.5f;
        for(int p = 0; p <= 5; p++) {
            gl.glPushMatrix();
            gl.glTranslatef(m, 0, -30);
            gl.glScalef(0.5f, 1, 1);
            gl.glRotatef(-90, 0, 1, 0);
            camino.dibuja(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(-m,0,-30);
            gl.glScalef(0.5f,1,1);
            gl.glRotatef(90,0,1,0);
            camino.dibuja(gl);
            gl.glPopMatrix();

            m = m-12f;

        }
        /*------------RENDERIZA ARBOLES-------------*/
        gl.glPushMatrix();
        gl.glTranslatef(-15,5,-21);
        gl.glScalef(0.69f,1.5f,0.69f);
        gl.glColor4f(0,170f/255f,0,1);
        gl.glLineWidth(3f);
        arbol.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(8,5,-21);
        gl.glScalef(0.69f,1.5f,0.69f);
        gl.glColor4f(0,200f/255f,0,1);
        gl.glLineWidth(3f);
        arbol.dibuja(gl);
        gl.glPopMatrix();

        int pos = -50;
        int pos2 = -75;
        for (int k = 0; k < 20; k++) {
            gl.glPushMatrix();
            gl.glTranslatef(pos,5,-65);
            gl.glScalef(0.69f,1.5f,0.69f);
            gl.glColor4f(0,1,0,1);
            gl.glLineWidth(3f);
            arbol.dibuja(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(pos2,6,-62);
            gl.glScalef(0.69f,1.5f,0.69f);
            gl.glColor4f(0,102f/255f,0,1);
            gl.glLineWidth(3f);
            arbol.dibuja(gl);
            gl.glPopMatrix();

            pos2 = pos2 + 8;
            pos = pos +5;
        }
        /*--------RENDERIZA ELEFANTES----------*/
        gl.glPushMatrix();
        gl.glTranslatef(-8,3f,-21);
        gl.glRotatef(45,0,1,0);
        elefante.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(8,2f,-38);
        gl.glRotatef(180,0,1,0);
        gl.glScalef(0.75f,0.75f,0.75f);
        elefante.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(8,3f,-15);
        gl.glRotatef(190,0,1,0);
        elefante.dibuja(gl);
        gl.glPopMatrix();
        /*--------RENDERIZA MONTANIAS-----------*/
        gl.glPushMatrix();
        gl.glTranslatef(-50,-1,-85);
        montania.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0,-1,-86);
        montania.dibuja2(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(50,-1,-85);
        montania.dibuja(gl);
        gl.glPopMatrix();
        /*--------RENDERIZA ESTRUCTURA 2------------*/
        gl.glPushMatrix();
        gl.glTranslatef(4,0,-37);
        estructura2.dibuja(gl,angulo);
        gl.glPopMatrix();
        /*---------RENDERIZA ESTRUCTURA 1---------------*/
        gl.glPushMatrix();
        gl.glTranslatef(-7,-0.9f,-40);
        gl.glColor4f(1,1,1,1);
        estructura1.dibuja(gl,angulo);
        gl.glPopMatrix();
        /*-----------RENDERIZA FAROLES----------------*/
        int posicion = -22;
        for (int k = 0; k <= 7; k++) {
            gl.glPushMatrix();
            gl.glTranslatef(-4,0,posicion);
            gl.glRotatef(45,0,1,0);
            farol.dibuja(gl,angulo);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(4,0,posicion);
            gl.glRotatef(180,0,1,0);
            farol.dibuja(gl, angulo);
            gl.glPopMatrix();

            posicion = posicion + 2;
        }
        /*-----------RENDERIZA CASAS--------------*/
        gl.glPushMatrix();
        gl.glTranslatef(-25,3.9f,-13);
        gl.glRotatef(90,0,1,0);
        gl.glScalef(5,5,7);
        casa.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-22,3.9f,-15);
        gl.glScalef(5,5,7);
        casa.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-22,3.9f,-10);
        gl.glRotatef(135,0,1,0);
        gl.glScalef(5,5,7);
        casa.dibuja(gl);
        gl.glPopMatrix();

        float espacio = -50;
        for (int k = 0; k <= 12; k++) {
            gl.glPushMatrix();
            gl.glTranslatef(espacio,3.9f,-60);
            gl.glScalef(5,5,7);
            casa.dibuja(gl);
            gl.glPopMatrix();

            espacio = espacio + 5;

            gl.glPushMatrix();
            gl.glTranslatef(espacio,3.9f,-60);
            gl.glScalef(9,5,7);
            casa.dibuja(gl);
            gl.glPopMatrix();

            espacio = espacio + 5;
        }
        /*---------REDNERIZA SEMAFORO-----------*/
        gl.glPushMatrix();
        gl.glTranslatef(-3.5f,0,-23);
        semaforo.dibuja(gl);
        gl.glPopMatrix();
        /*-------REDNERIZA BANCAS-------------*/
        gl.glPushMatrix();
        gl.glTranslatef(-3.4f,-0.7f,-5);
        gl.glRotatef(90,0,1,0);
        gl.glScalef(0.7f,0.7f,0.7f);
        banca.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(3.4f,-0.7f,-5);
        gl.glRotatef(-90,0,1,0);
        gl.glScalef(0.7f,0.7f,0.7f);
        banca.dibuja(gl);
        gl.glPopMatrix();
        /*------RENDERIZA AVES--------*/
        gl.glPushMatrix();
        gl.glTranslatef(-6*7,30,-30*3);
        gl.glScalef(0.5f,0.5f,0.5f);
        ave.dibuja(gl);
        gl.glPopMatrix();
        int posicionx = -6;
        int posicionz =  -30;
        for (int k = 1; k <= 6; k++) {
            int repuesto = posicionx;
            int repuesto2 = posicionz;

            posicionx = 7*(posicionx + k);
            posicionz = 3*(posicionz +k);

            gl.glPushMatrix();
            gl.glTranslatef(posicionx,30,posicionz);
            gl.glScalef(0.5f,0.5f,0.5f);
            ave.dibuja(gl);
            gl.glPopMatrix();

            posicionx = repuesto;
            posicionz = repuesto2;

            posicionx = 7*(posicionx + k);
            posicionz = 3*(posicionz - k);

            gl.glPushMatrix();
            gl.glTranslatef(posicionx,30,posicionz);
            gl.glScalef(0.5f,0.5f,0.5f);
            ave.dibuja(gl);
            gl.glPopMatrix();

            posicionx = repuesto;
            posicionz = repuesto2;
        }
        gl.glPushMatrix();
        gl.glTranslatef(-6,10,-20);
        gl.glRotatef(70,1,0,0);
        gl.glScalef(0.5f,0.5f,0.5f);
        ave.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(45,20,-70);
        gl.glScalef(0.5f,0.5f,0.5f);
        ave.dibuja(gl);
        gl.glPopMatrix();


        gl.glPopMatrix();

        gl.glFlush();

        angulo = angulo + 5;

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {

        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 60, w / (float)h, 1, 200);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    /*AVANZA*/
    public void opcion_atras(){
        this.i = this.i - 5;
        this.angulo = this.angulo + 5;
    }
    /*GIRA A LA IZQUIERDA */
    public void opcion_izquierda(){
        this.j = this.j - 5;
        this.angulo = this.angulo + 5;
    }
    /*GIRA A LA DERECHA*/
    public void opcion_derecha(){
        this.j = this.j + 5;
        this.angulo = this.angulo + 5;
    }
    /*RETROCEDE*/
    public void opcion_adelante(){
        this.i = this.i + 5;
        this.angulo = this.angulo + 1;
    }

}
