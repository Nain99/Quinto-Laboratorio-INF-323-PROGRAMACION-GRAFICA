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

public class Farol {

    /*--------------CUBO--------------------*/
    private float verticesCubo[] = new float[] {
            // FRENTE
            -1, -1,  1, // 4   0
             1, -1,  1, // 5   1
             1,  1,  1, // 6   2
            -1,  1,  1, // 7   3
            // ATRAS
            -1,  1, -1, // 3   4
             1,  1, -1, // 2   5
             1, -1, -1, // 1   6
            -1, -1, -1, // 0   7
            // IZQUIERDA
            -1, -1, -1, // 0   8
            -1, -1,  1, // 4   9
            -1,  1,  1, // 7  10
            -1,  1, -1, // 3  11
            // DERECHA
             1, -1,  1, // 5  12
             1, -1, -1, // 1  13
             1,  1, -1, // 2  14
             1,  1,  1, // 6  15
            // ABAJO
            -1, -1, -1, // 0  16
             1, -1, -1, // 1  17
             1, -1,  1, // 5  18
            -1, -1,  1, // 4  19
            // ARRIBA
            -1,  1,  1, // 7  20
             1,  1,  1, // 6  21
             1,  1, -1, // 2  22
            -1,  1, -1  // 3  23
    };

    byte maxColor = (byte)255;
    private byte coloresCubo[] = new byte[] {
            // FRENTE
            80, 80, 80, maxColor, // 4   0
            80, 80, 80, maxColor, // 5   1
            80, 80, 80, maxColor, // 6   2
            80, 80, 80, maxColor, // 7   3
            // ATRAS
            80, 80, 80, maxColor, // 3   4
            80, 80, 80, maxColor, // 2   5
            80, 80, 80, maxColor, // 1   6
            80, 80, 80, maxColor, // 0   7
            //IZQUIERDA
            0, 0, 0, maxColor, // 0   8
            0, 0, 0, maxColor, // 4   9
            0, 0, 0, maxColor, // 7  10
            0, 0, 0, maxColor, // 3  11
            // DERECHA
            0, 0, 0, maxColor, // 5  12
            0, 0, 0, maxColor, // 1  13
            0, 0, 0, maxColor, // 2  14
            0, 0, 0, maxColor, // 6  15
            // ABAJO
            0, 0, 0, maxColor, // 0  16
            0, 0, 0, maxColor, // 1  17
            0, 0, 0, maxColor, // 5  18
            0, 0, 0, maxColor, // 4  19
            // ARRIBA
            56, 56, 56, maxColor, // 7  20
            56, 56, 56, maxColor, // 6  21
            56, 56, 56, maxColor, // 2  22
            56, 56, 56, maxColor  // 3  23
    };

    private byte coloresCubo2[] = new byte[] {
            // FRENTE
            maxColor, maxColor, 0, maxColor, // 4   0
            maxColor, maxColor, 0, maxColor, // 5   1
            maxColor, maxColor, 0, maxColor, // 6   2
            maxColor, maxColor, 0, maxColor, // 7   3
            // ATRAS
            maxColor, maxColor, 0, maxColor, // 3   4
            maxColor, maxColor, 0, maxColor, // 2   5
            maxColor, maxColor, 0, maxColor, // 1   6
            maxColor, maxColor, 0, maxColor, // 0   7
            // IZQUIERDA
            (byte) 249, (byte)152, 6, maxColor, // 0   8
            (byte)249, (byte)152, 6, maxColor, // 4   9
            (byte)249, (byte)152, 6, maxColor, // 7  10
            (byte)249, (byte)152, 6, maxColor, // 3  11
            // DERECHA
            (byte)249, (byte)152, 0, maxColor, // 5  12
            (byte)249, (byte)152, 0, maxColor, // 1  13
            (byte)249, (byte)152, 0, maxColor, // 2  14
            (byte)249, (byte)152, 0, maxColor, // 6  15
            // ABAJO
            maxColor, maxColor, 0, maxColor, // 0  16
            maxColor, maxColor, 0, maxColor, // 1  17
            maxColor, maxColor, 0, maxColor, // 5  18
            maxColor, maxColor, 0, maxColor, // 4  19
            // ARRIBA
            maxColor, maxColor, 0, maxColor, // 7  20
            maxColor, maxColor, 0, maxColor, // 6  21
            maxColor, maxColor, 0, maxColor, // 2  22
            maxColor, maxColor, 0, maxColor  // 3  23
    };

    private short indicesCubo[] = new short [] {
             0,  1,  2,  0,  2,  3, // Frente
             4,  5,  6,  4,  6,  7, // Atrás
             8,  9, 10,  8, 10, 11, // Izquierda
            12, 13, 14, 12, 14, 15, // Derecha
            16, 17, 18, 16, 18, 19, // Abajo
            20, 21, 22, 20, 22, 23  // Arriba
    };

    private FloatBuffer bufVerticesCubo;
    private ByteBuffer bufColoresCubo;
    private ByteBuffer bufColoresCubo2;
    private ShortBuffer bufIndicesCubo;
    /*----------------ESFERA---------------*/
    int segmentosH;
    int segmentosV;

    private short indices[];
    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;

    public Farol(float radio, int segmentosH, int segmentosV){

        /*-------------------------CUBO-----------------------*/
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

        /*------------------------ESFERA-------------------------*/
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
    }
    public void dibuja(GL10 gl, float angulo) {

        /*-------------RENDERIZA BASE-----------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo);
        gl.glPushMatrix();
        gl.glTranslatef(0,-1,0);
        gl.glScalef(0.125f,0.125f,0.125f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*---------RENDERIZA POSTE---------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo);
        gl.glPushMatrix();
        gl.glScalef(0.031255f,1.5f,0.03125f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*---------RENDERIZA FUEGO---------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo2);
        gl.glPushMatrix();
        gl.glTranslatef(0,1.6f,0);
        gl.glRotatef(angulo,0,1,0);
        gl.glScalef(0.031255f,0.125f,0.03125f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*----------------CONTENEDOR DEL FUEGO---------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glColor4f(0,0,0,1);
        gl.glLineWidth(4f);
        gl.glTranslatef(0,1.7f,0);
        gl.glScalef(0.25f,0.25f,0.25f);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

}
