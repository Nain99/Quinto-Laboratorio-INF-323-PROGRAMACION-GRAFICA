package com.example.laboratorio5;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author Nain Perez
 * @version 17.7.2020 v1
 */

public class Camino {

    /*---------PLANO------------*/
    private float vertices[] = new float[42 * 6];
    private byte colores[] = new byte[42 * 8];
    private FloatBuffer bufVertices;
    private ByteBuffer bufColores;
    private int inicio;
    private int cantidad;

    public Camino() {

        /*-----------PLANO-------------*/
        vertices[0] = -6; vertices[1] = -1; vertices[2] =  -9;
        vertices[3] = -6; vertices[4] = -1; vertices[5] =   15;
        colores[0] = (byte)85; colores[1] = (byte)85; colores[2] = (byte)85; colores[3] = 1;
        colores[4] = (byte)85; colores[5] = (byte)85; colores[6] = (byte)85; colores[7] = 1;

        vertices[6] =  6; vertices[7] = -1; vertices[8] =   15;
        vertices[9] =  6; vertices[10] = -1;   vertices[11] =  -9;
        colores[8] = (byte)85; colores[9] = (byte)85; colores[10] = (byte)85; colores[11] = 1;
        colores[12] = (byte)85; colores[13] = (byte)85; colores[14] = (byte)85; colores[15] = 1;

        this.inicio = 4;
        this.cantidad = 0;
        int i = 12;
        int j = 16;
        for (int k = -9; k <= 9; k = k+6) {
            vertices[i] =  -0.3f; vertices[i+1] = -0.99f; vertices[i+2] =   k;
            vertices[i+3] =   0.3f; vertices[i+4] = -0.99f; vertices[i+5] =  k;
            colores[j]   = (byte)255; colores[j+1] = (byte)255; colores[j+2] = (byte)0; colores[j+3] = 1;
            colores[j+4] = (byte)255; colores[j+5] = (byte)255; colores[j+6] = (byte)0; colores[j+7] = 1;

            vertices[i+6] =  0.3f; vertices[i+7]  = -0.99f; vertices[i+8]  =  k+3;
            vertices[i+9] = -0.3f; vertices[i+10] = -0.99f; vertices[i+11] =  k+3;
            colores[j+8]  = (byte)255; colores[j+9]  = (byte)255; colores[j+10] = (byte)0; colores[j+11] = 1;
            colores[j+12] = (byte)255; colores[j+13] = (byte)255; colores[j+14] = (byte)0; colores[j+15] = 1;

            this.cantidad++;
            i = i + 12;
            j = j + 16;
        }

        vertices[i]   = -6; vertices[i+1] = -0.99f; vertices[i+2] =  15;
        vertices[i+3] =  6; vertices[i+4] = -0.99f; vertices[i+5] =  15;
        colores[j]   = (byte)255; colores[j+1] = (byte)255; colores[j+2] = (byte)255; colores[j+3] = 1;
        colores[j+4] = (byte)255; colores[j+5] = (byte)255; colores[j+6] = (byte)255; colores[j+7] = 1;

        vertices[i+6] =   6; vertices[i+7]  = -0.99f; vertices[i+8]  =  15.6f;
        vertices[i+9] =  -6; vertices[i+10] = -0.99f; vertices[i+11] =  15.6f;
        colores[j+8]  = (byte)255; colores[j+9]  = (byte)255; colores[j+10] = (byte)255; colores[j+11] = 1;
        colores[j+12] = (byte)255; colores[j+13] = (byte)255; colores[j+14] = (byte)255; colores[j+15] = 1;

        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();
        bufVertices.put(vertices);
        bufVertices.rewind();

        bufColores = ByteBuffer.allocateDirect(colores.length);
        bufColores.put(colores);
        bufColores.position(0);
    }

    public void dibuja(GL10 gl) {

        /*---------RENDERIZA CAMINO---------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        int variable = this.inicio;

        for (int l = 1; l <= cantidad ; l++) {
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
            gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
            gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,variable,4);
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
            variable = variable + 4;
        }
    }
    public void dibujaPasoPeatonal(GL10 gl){

        /*-----------RENDERIZA CAMINO CON PASO PEATONAL-------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        int variable = this.inicio;

        for (int l = 1; l <= cantidad ; l++) {
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
            gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
            gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,variable,4);
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
            variable = variable + 4;
        }

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, variable, 4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glPushMatrix();

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
        gl.glTranslatef(0,0,8.5f);
        gl.glScalef(1,1,0.40f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, variable, 4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glPopMatrix();
    }
}
