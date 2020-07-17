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

public class Elefante {

    /*-------------ESFERA---------------*/
    int segmentosH;
    int segmentosV;

    private short indices[];
    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;

   /*--------------PLANO------------------*/
    private float verticesOreja[] = new float[42 * 6];
    private byte coloresOreja[] = new byte[42 * 8];
    private FloatBuffer bufVerticesOreja;
    private ByteBuffer bufColoresOreja;

    /*-------------PIRAMIDE----------------*/
    private float verticesPiramide[] = new float[] {
            // FRENTE
            -1, -1, 1,   // 0 0  A
             1, -1, 1,   // 1 1  B
             0,  1, 0,   // 2 2  C
            // ATRAS
            -1, -1, -1,  // 4 3  E
             1, -1, -1,  // 3 4  D
             0,  1,  0,  // 2 5  C
            // IZQUIERDA
            -1, -1, -1,  // 4 6  E
            -1, -1,  1,  // 0 7  A
             0,  1,  0,  // 2 8  C
            // DERECHA
             1, -1, -1,  // 3 9  D
             1, -1,  1,  // 1 10 B
             0,  1,  0,  // 2 11 C
            // ABAJO
            -1, -1,  1,  // 0 12 A
             1, -1,  1,  // 1 13 B
             1, -1, -1,  // 3 14 D
            -1, -1, -1,  // 4 15 E
    };
    byte maxColor = (byte)255;
    private byte coloresPiramide[] = new byte[] {
            // FRENTE
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 0 0
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 1 1
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 2 2
            // ATRAS
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 4 3
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 3 4
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 2 5
            // IZQUIERDA
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 4 6
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 0 7
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 2 8
            // DERECHA
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 3 9
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 1 10
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 2 11
            // ABAJO
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 0 12
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 1 13
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 3 14
            (byte) (255), (byte) (255), (byte) (255), maxColor, // 4 15
    };

    private short indicesPiramide[] = new short [] {
            0, 1, 2,                // FRENTE
            3, 4, 5,                // ATRAS
            6, 7, 8,                // IZQUIERDA
            9, 10, 11,              // DERECHA
            12, 13, 14, 12, 14, 15, // ABAJO
    };
    private FloatBuffer bufVerticesPiramide;
    private ByteBuffer bufColoresPiramide;
    private ShortBuffer bufIndicesPiramide;

    /*---------------CUBO--------------------*/
    private float verticesCubo[] = new float[] {
            // Frente
            -1, -1,  1, // 4   0
             1, -1,  1, // 5   1
             1,  1,  1, // 6   2
            -1,  1,  1, // 7   3
            // Atrás
            -1,  1, -1, // 3   4
             1,  1, -1, // 2   5
             1, -1, -1, // 1   6
            -1, -1, -1, // 0   7
            // Izquierda
            -1, -1, -1, // 0   8
            -1, -1,  1, // 4   9
            -1,  1,  1, // 7  10
            -1,  1, -1, // 3  11
            // Derecha
             1, -1,  1, // 5  12
             1, -1, -1, // 1  13
             1,  1, -1, // 2  14
             1,  1,  1, // 6  15
            // Abajo
            -1, -1, -1, // 0  16
             1, -1, -1, // 1  17
             1, -1,  1, // 5  18
            -1, -1,  1, // 4  19
            // Arriba
            -1,  1,  1, // 7  20
             1,  1,  1, // 6  21
             1,  1, -1, // 2  22
            -1,  1, -1  // 3  23
    };

    private byte coloresCubo[] = new byte[] {
            // FRENTE
            110, 110, 110, maxColor, // 4   0
            110, 110, 110, maxColor, // 5   1
            110, 110, 110, maxColor, // 6   2
            110, 110, 110, maxColor, // 7   3
            // ATRAS
            110, 110, 110, maxColor, // 3   4
            110, 110, 110, maxColor, // 2   5
            110, 110, 110, maxColor, // 1   6
            110, 110, 110, maxColor, // 0   7
            // IZQUIERDA
            110, 110, 110, maxColor, // 0   8
            110, 110, 110, maxColor, // 4   9
            110, 110, 110, maxColor, // 7  10
            110, 110, 110, maxColor, // 3  11
            // DERECHA
            110, 110, 110, maxColor, // 5  12
            110, 110, 110, maxColor, // 1  13
            110, 110, 110, maxColor, // 2  14
            110, 110, 110, maxColor, // 6  15
            // ABAJO
            110, 110, 110, maxColor, // 0  16
            110, 110, 110, maxColor, // 1  17
            110, 110, 110, maxColor, // 5  18
            110, 110, 110, maxColor, // 4  19
            // ARRIBA
            110, 110, 110, maxColor, // 7  20
            110, 110, 110, maxColor, // 6  21
            110, 110, 110, maxColor, // 2  22
            110, 110, 110, maxColor  // 3  23
    };
    private byte coloresCubo2[] = new byte[] {
            // FRENTE
            (byte)130, (byte)130, (byte) 130, maxColor, // 4   0
            (byte)130, (byte)130, (byte)130, maxColor, // 5   1
            (byte)130, (byte)130, (byte)130, maxColor, // 6   2
            (byte)130, (byte)130, (byte)130, maxColor, // 7   3
            // ATRAS
            (byte)130, (byte)130, (byte)130, maxColor, // 3   4
            (byte)130, (byte)130, (byte)130, maxColor, // 2   5
            (byte)130, (byte)130, (byte)130, maxColor, // 1   6
            (byte)130, (byte)130, (byte)130, maxColor, // 0   7
            // IZQUIERDA
            (byte)130, (byte)130, (byte)130, maxColor, // 0   8
            (byte)130, (byte)130, (byte)130, maxColor, // 4   9
            (byte)130, (byte)130, (byte)130, maxColor, // 7  10
            (byte)130, (byte)130, (byte)130, maxColor, // 3  11
            // DERECHA
            (byte)130, (byte)130, (byte)130, maxColor, // 5  12
            (byte)130, (byte)130, (byte)130, maxColor, // 1  13
            (byte)130, (byte)130, (byte)130, maxColor, // 2  14
            (byte)130, (byte)130, (byte)130, maxColor, // 6  15
            // ABAJO
            (byte)130, (byte)130, (byte)130, maxColor, // 0  16
            (byte)130, (byte)130, (byte)130, maxColor, // 1  17
            (byte)130, (byte)130, (byte)130, maxColor, // 5  18
            (byte)130, (byte)130, (byte)130, maxColor, // 4  19
            // ARRIBA
            (byte)130, (byte)130, (byte)130, maxColor, // 7  20
            (byte)130, (byte)130, (byte)130, maxColor, // 6  21
            (byte)130, (byte)130, (byte)130, maxColor, // 2  22
            (byte)130, (byte)130, (byte)130, maxColor  // 3  23
    };

    private short indicesCubo[] = new short [] {
            0,  1,  2,  0,  2,  3, // FRENTE
            4,  5,  6,  4,  6,  7, // ATRAS
            8,  9, 10,  8, 10, 11, // IZQUIERDA
            12, 13, 14, 12, 14, 15, // DERECHA
            16, 17, 18, 16, 18, 19, // ABAJO
            20, 21, 22, 20, 22, 23  // ARRIBA
    };

    private FloatBuffer bufVerticesCubo;
    private ByteBuffer bufColoresCubo;
    private ByteBuffer bufColoresCubo2;
    private ShortBuffer bufIndicesCubo;

    public  Elefante(float radio, int segmentosH, int segmentosV){

        /*-------------ESFERA-----------------*/
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
            indices[k] = (short) j;
            indices[k + 1] = (short) (j + 1);
            indices[k + 2] = (short) (j + 1);
            indices[k + 3] = (short) (j + 2);
            indices[k + 4] = (short) (j + 2);
            indices[k + 5] = (short) j;
            indices[k + 6] = (short) j;
            indices[k + 7] = (short) (j + 2);
            indices[k + 8] = (short) (j + 2);
            indices[k + 9] = (short) (j + 3);
            indices[k + 10] = (short) (j + 3);
            indices[k + 11] = (short) j;
        }

        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder());
        bufIndices = bufByte.asShortBuffer();
        bufIndices.put(indices).rewind();

        /*------------------PLANO----------------------*/
        verticesOreja[0] = -0.4f; verticesOreja[1] = 0f; verticesOreja[2] =  -0.4f;
        verticesOreja[3] = -0.4f; verticesOreja[4] = 0f; verticesOreja[5] =   0.4f;
        coloresOreja[0] = (byte)100; coloresOreja[1] = (byte)100; coloresOreja[2] = (byte)100; coloresOreja[3] = 1;
        coloresOreja[4] = (byte)100; coloresOreja[5] = (byte)100; coloresOreja[6] = (byte)100; coloresOreja[7] = 1;

        verticesOreja[6] =  0.4f; verticesOreja[7]  = 0f; verticesOreja[8]  =   0.4f;
        verticesOreja[9] =  0.4f; verticesOreja[10] = 0f; verticesOreja[11] =  -0.4f;
        coloresOreja[8]  = (byte)100; coloresOreja[9]  = (byte)100; coloresOreja[10] = (byte)100; coloresOreja[11] = 1;
        coloresOreja[12] = (byte)100; coloresOreja[13] = (byte)100; coloresOreja[14] = (byte)100; coloresOreja[15] = 1;

        ByteBuffer bufByteOreja = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByteOreja.order(ByteOrder.nativeOrder());
        bufVerticesOreja = bufByteOreja.asFloatBuffer();
        bufVerticesOreja.put(verticesOreja);
        bufVerticesOreja.rewind();

        bufColoresOreja = ByteBuffer.allocateDirect(coloresOreja.length);
        bufColoresOreja.put(coloresOreja);
        bufColoresOreja.position(0);

        /*---------------PIRAMIDE---------------*/
        ByteBuffer bufByteTronco = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByteTronco.order(ByteOrder.nativeOrder());
        bufVerticesPiramide = bufByteTronco.asFloatBuffer();
        bufVerticesPiramide.put(verticesPiramide);
        bufVerticesPiramide.rewind();

        bufColoresPiramide = ByteBuffer.allocateDirect(coloresPiramide.length);
        bufColoresPiramide.put(coloresPiramide);
        bufColoresPiramide.position(0);

        bufByteTronco = ByteBuffer.allocateDirect(indices.length * 2);
        bufByteTronco.order(ByteOrder.nativeOrder());
        bufIndicesPiramide = bufByteTronco.asShortBuffer();
        bufIndicesPiramide.put(indicesPiramide);
        bufIndicesPiramide.rewind();

        /*---------------CUBO-------------------*/
        ByteBuffer bufByteCubo = ByteBuffer.allocateDirect(verticesCubo.length * 4);
        bufByteCubo.order(ByteOrder.nativeOrder());
        bufVerticesCubo = bufByteCubo.asFloatBuffer();
        bufVerticesCubo.put(verticesCubo);
        bufVerticesCubo.rewind();

        bufColoresCubo = ByteBuffer.allocateDirect(coloresCubo.length);
        bufColoresCubo.put(coloresCubo);
        bufColoresCubo.position(0);

        bufColoresCubo2 = ByteBuffer.allocateDirect(coloresCubo2.length);
        bufColoresCubo2.put(coloresCubo2);
        bufColoresCubo2.position(0);

        bufByteCubo = ByteBuffer.allocateDirect(indicesCubo.length * 2);
        bufByteCubo.order(ByteOrder.nativeOrder());
        bufIndicesCubo = bufByteCubo.asShortBuffer();
        bufIndicesCubo.put(indicesCubo);
        bufIndicesCubo.rewind();

    }
    public void dibuja(GL10 gl){

        /*--------------RENDERIZA CABEZA---------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(0.14f,-0.7f,0);
        gl.glScalef(0.75f,0.75f,0.75f);
        gl.glColor4f(159f/255f,159f/255f,159f/255f,1);
        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*--------------RENDERIZA TROMPA-----------------*/
        /*------1------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(0.80f,-1f,0);
        gl.glScalef(0.27f,0.27f,0.27f);
        gl.glColor4f(139f/255f,139f/255f,139f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*-------2-------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(0.75f,-1.5f,0);
        gl.glScalef(0.25f,0.25f,0.25f);
        gl.glColor4f(139f/255f,139f/255f,139f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*--------3-------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(0.87f,-1.9f,0);
        gl.glScalef(0.20f,0.20f,0.20f);
        gl.glColor4f(139f/255f,139f/255f,139f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*--------4-------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(1.20f,-1.9f,0);
        gl.glScalef(0.15f,0.15f,0.15f);
        gl.glColor4f(139f/255f,139f/255f,139f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*--------5-------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(1.34f,-1.8f,0);
        gl.glScalef(0.10f,0.10f,0.10f);
        gl.glColor4f(139f/255f,139f/255f,139f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*--------6-------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(1.39f,-1.69f,0);
        gl.glScalef(0.05f,0.05f,0.05f);
        gl.glColor4f(139f/255f,139f/255f,139f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*--------7-------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(1.41f,-1.65f,0);
        gl.glScalef(0.025f,0.025f,0.025f);
        gl.glColor4f(139f/255f,139f/255f,139f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*------------RENDERIZA OJOS------------*/
        /*-------1--------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(0.7f,-0.4f,0.4f);
        gl.glScalef(0.050f,0.050f,0.050f);
        gl.glColor4f(0f/255f,0f/255f,0f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*--------2---------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(0.7f,-0.4f,-0.4f);
        gl.glScalef(0.050f,0.050f,0.050f);
        gl.glColor4f(0f/255f,0f/255f,0f/255f,1);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*---------------RENDERIZA OREJA------------------*/
        /*---------1----------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesOreja);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresOreja);
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.2f,-0.73f);
        gl.glScalef(0.85f,1,1.25f);
        gl.glRotatef(90,1,0,0);
        gl.glRotatef(45,0,1,0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        /*---------2-------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesOreja);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresOreja);
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.2f,0.73f);
        gl.glScalef(0.85f,1,1.25f);
        gl.glRotatef(90,1,0,0);
        gl.glRotatef(45,0,1,0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*-------------RENDERIZA CUERPO------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glTranslatef(-0.90f,-2f,0f);
        gl.glScalef(1.35f,0.85f,1f);
        gl.glColor4f(131f/255f,131f/255f,131f/255f,1);
        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        /*--------------RENDERIZA COLNILLO-----------------*/
        /*--------1------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesPiramide);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresPiramide);
        gl.glPushMatrix();
        gl.glTranslatef(1f,-0.9f,0.4f);
        gl.glRotatef(-100,0,0,1);
        gl.glScalef(0.10f,0.5f,0.10f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesPiramide.length, GL10.GL_UNSIGNED_SHORT, bufIndicesPiramide);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        /*-----------2--------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesPiramide);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresPiramide);
        gl.glPushMatrix();
        gl.glTranslatef(1f,-0.9f,-0.4f);
        gl.glRotatef(-100,0,0,1);
        gl.glScalef(0.10f,0.5f,0.10f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesPiramide.length, GL10.GL_UNSIGNED_SHORT, bufIndicesPiramide);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*----------------RENDERIZA PATAS--------------------*/
        /*-----------1---------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo2);
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f,-3.2f,0.3f);
        gl.glScalef(0.30f,0.5f,0.28f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        /*------------2----------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo);
        gl.glPushMatrix();
        gl.glTranslatef(-0.825f,-3.2f,-0.3f);
        gl.glScalef(0.30f,0.5f,0.28f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        /*-------------3-----------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo2);
        gl.glPushMatrix();
        gl.glTranslatef(-1.65f,-3.2f,-0.3f);
        gl.glRotatef(-10,0,0,1);
        gl.glScalef(0.30f,0.5f,0.28f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        /*-------------4---------------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo);
        gl.glPushMatrix();
        gl.glTranslatef(-1.65f,-3.2f,0.3f);
        gl.glScalef(0.30f,0.5f,0.28f);
        gl.glColor4f(0,0,0,1);
        gl.glLineWidth(3f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
