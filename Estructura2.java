package com.example.laboratorio5;

import javax.microedition.khronos.opengles.GL10;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * @author Nain Perez
 * @version 17.7.2020 v1
 */

public class Estructura2 {

    /*----------PIRAMIDE-----------------*/
    private float verticesPiramide[] = new float[] {
            // Frente
            -1, -1, 1,   // 0 0  A
             1, -1, 1,   // 1 1  B
             0,  1, 0,   // 2 2  C
            // Atrás
            -1, -1, -1,  // 4 3  E
             1, -1, -1,  // 3 4  D
             0,  1,  0,  // 2 5  C
            // Izquierda
            -1, -1, -1,  // 4 6  E
            -1, -1,  1,  // 0 7  A
             0,  1,  0,  // 2 8  C
            // Derecha
             1, -1, -1,  // 3 9  D
             1, -1,  1,  // 1 10 B
             0,  1,  0,  // 2 11 C
            // Abajo
            -1, -1,  1,  // 0 12 A
             1, -1,  1,  // 1 13 B
             1, -1, -1,  // 3 14 D
            -1, -1, -1,  // 4 15 E
    };

    byte maxColor = (byte)255;
    private byte coloresPiramide[] = new byte[] {
            // Frente
            (byte) (64), (byte) (0), 0, maxColor, // 0 0
            (byte) (64), (byte) (0), 0, maxColor, // 1 1
            (byte) (64), (byte) (0), 0, maxColor, // 2 2
            // Atrás
            (byte) (145), (byte) (0), 0, maxColor, // 4 3
            (byte) (145), (byte) (0), 0, maxColor, // 3 4
            (byte) (145), (byte) (0), 0, maxColor, // 2 5
            // Izquierda
            (byte) (64), (byte) (0), 0, maxColor, // 4 6
            (byte) (64), (byte) (0), 0, maxColor, // 0 7
            (byte) (64), (byte) (0), 0, maxColor, // 2 8
            // Derecha
            (byte) (145), (byte) (0), 0, maxColor, // 3 9
            (byte) (145), (byte) (0), 0, maxColor, // 1 10
            (byte) (145), (byte) (0), 0, maxColor, // 2 11
            // Abajo
            (byte) (45), (byte) (0), 0, maxColor, // 0 12
            (byte) (45), (byte) (0), 0, maxColor, // 1 13
            (byte) (45), (byte) (0), 0, maxColor, // 3 14
            (byte) (45), (byte) (0), 0, maxColor, // 4 15
    };

    private short indicesPiramide[] = new short [] {
            0, 1, 2,                // Frente
            3, 4, 5,                // Atrás
            6, 7, 8,                // Izquierda
            9, 10, 11,              // Derecha
            12, 13, 14, 12, 14, 15, // Abajo
    };
    private FloatBuffer bufVerticesPiramide;
    private ByteBuffer bufColoresPiramide;
    private ShortBuffer bufIndicesPiramide;

    /*----------------ESFERA-------------------*/
    int segmentosH;
    int segmentosV;

    private short indices[];
    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;

    public Estructura2(float radio, int segmentosH, int segmentosV){

        /*------------------------ESFERA-----------------------*/
        this.segmentosH = segmentosH;
        this.segmentosV = segmentosV;
        float[] vertices = new float[segmentosH * segmentosV * 4 * 3];
        float[] normales = new float[segmentosH * segmentosV * 4 * 3];
        indices = new short[segmentosH * segmentosV * 12];
        int i = 0;
        float inc_phi = 360f / segmentosH;
        for (float phi = 0; phi < 360; phi += inc_phi) {
            float sp = (float) Math.sin(Math.toRadians(phi));
            float cp = (float) Math.cos(Math.toRadians(phi));
            float sp1 = (float) Math.sin(Math.toRadians(phi + inc_phi));
            float cp1 = (float) Math.cos(Math.toRadians(phi + inc_phi));
            float inc_theta = 180f / segmentosV;
            for (float theta = 0; theta < 180; theta += inc_theta) {
                float st = (float) Math.sin(Math.toRadians(theta));
                float ct = (float) Math.cos(Math.toRadians(theta));
                float st1 = (float) Math.sin(Math.toRadians(theta + inc_theta));
                float ct1 = (float) Math.cos(Math.toRadians(theta + inc_theta));
                vertices[i] = radio * st * sp;
                vertices[i + 1] = radio * ct;
                vertices[i + 2] = radio * st * cp;
                vertices[i + 3] = radio * st1 * sp;
                vertices[i + 4] = radio * ct1;
                vertices[i + 5] = radio * st1 * cp;
                vertices[i + 6] = radio * st1 * sp1;
                vertices[i + 7] = radio * ct1;
                vertices[i + 8] = radio * st1 * cp1;
                vertices[i + 9] = radio * st * sp1;
                vertices[i + 10] = radio * ct;
                vertices[i + 11] = radio * st * cp1;
                i = i + 12;
            }
        }
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();
        bufVertices.put(vertices).rewind();

        bufByte = ByteBuffer.allocateDirect(normales.length * 4);
        bufByte.order(ByteOrder.nativeOrder());

        for (int k = 0, j = 0; k < segmentosH * segmentosV * 12; k += 12, j += 4) {
            indices[k]      = (short)       j;
            indices[k + 1]  = (short) (j + 1);
            indices[k + 2]  = (short) (j + 1);
            indices[k + 3]  = (short) (j + 2);
            indices[k + 4]  = (short) (j + 2);
            indices[k + 5]  = (short)       j;
            indices[k + 6]  = (short)       j;
            indices[k + 7]  = (short) (j + 2);
            indices[k + 8]  = (short) (j + 2);
            indices[k + 9]  = (short) (j + 3);
            indices[k + 10] = (short) (j + 3);
            indices[k + 11] = (short)       j;
        }

        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder());
        bufIndices = bufByte.asShortBuffer();
        bufIndices.put(indices).rewind();


        /*------------PIRAMIDE-------------*/
        ByteBuffer bufBytePiramide = ByteBuffer.allocateDirect(verticesPiramide.length * 4);
        bufBytePiramide.order(ByteOrder.nativeOrder());
        bufVerticesPiramide = bufBytePiramide.asFloatBuffer();
        bufVerticesPiramide.put(verticesPiramide);
        bufVerticesPiramide.rewind();

        bufColoresPiramide = ByteBuffer.allocateDirect(coloresPiramide.length);
        bufColoresPiramide.put(coloresPiramide);
        bufColoresPiramide.position(0);

        bufBytePiramide = ByteBuffer.allocateDirect(indices.length * 2);
        bufBytePiramide.order(ByteOrder.nativeOrder());
        bufIndicesPiramide = bufBytePiramide.asShortBuffer();
        bufIndicesPiramide.put(indicesPiramide);
        bufIndicesPiramide.rewind();
    }
    public void dibuja(GL10 gl,float angulo){
        /*------------RENDERIZA DIAMANTE--------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glColor4f(0,185f/255f,185f/255f,1);
        gl.glLineWidth(3f);
        gl.glTranslatef(0,2.5f,0);
        gl.glRotatef(angulo,1,1,1);
        gl.glScalef(0.5f,0.5f,0.5f);
        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*------------RENDERIZA BASE---------------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesPiramide);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresPiramide);
        gl.glPushMatrix();
        gl.glRotatef(135,0,1,0);
        gl.glScalef(0.5f,2,0.5f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesPiramide.length, GL10.GL_UNSIGNED_SHORT, bufIndicesPiramide);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
