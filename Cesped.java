package com.example.laboratorio5;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author Nain Perez
 * @version 17.7.2020 v1
 */

public class Cesped {

    /*----------PLANO------------*/
    private float vertices[] = new float[42 * 6];
    private byte colores[] = new byte[42 * 8];
    private FloatBuffer bufVertices;
    private ByteBuffer bufColores;

    public Cesped() {

        /*---------PLANO----------*/
        vertices[0] = -40; vertices[1] = -1.009f; vertices[2] =  -40;
        vertices[3] = -40; vertices[4] = -1.009f; vertices[5] =   40;
        colores[0] = (byte)0; colores[1] = (byte)138; colores[2] = (byte)0; colores[3] = 1;
        colores[4] = (byte)0; colores[5] = (byte)138; colores[6] = (byte)0; colores[7] = 1;

        vertices[6] =  40; vertices[7]  = -1.009f; vertices[8]  =   40;
        vertices[9] =  40; vertices[10] = -1.009f; vertices[11] =  -40;
        colores[8]  = (byte)0; colores[9]  = (byte)138; colores[10] = (byte)0; colores[11] = 1;
        colores[12] = (byte)0; colores[13] = (byte)138; colores[14] = (byte)0; colores[15] = 1;

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

        /*-------------RENDERIZA CESPED---------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

    }
}
