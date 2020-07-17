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

public class Montania {

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
            (byte) 165, 93, 1, maxColor, // 4   0
            (byte) 165, 93, 1, maxColor, // 5   1
            (byte) 165, 93, 1, maxColor, // 6   2
            (byte) 165, 96, 1, maxColor, // 7   3
            // ATRAS
            (byte) 165, 93, 1, maxColor, // 3   4
            (byte) 165, 93, 1, maxColor, // 2   5
            (byte) 165, 93, 1, maxColor, // 1   6
            (byte) 165, 93, 1, maxColor, // 0   7
            // IZQUIERDA
            (byte) 165, 93, 1, maxColor, // 0   8
            (byte) 165, 93, 1, maxColor, // 4   9
            (byte) 165, 93, 1, maxColor, // 7  10
            (byte) 165, 93, 1, maxColor, // 3  11
            // DERECHA
            (byte) 165, 93, 1, maxColor, // 5  12
            (byte) 165, 93, 1, maxColor, // 1  13
            (byte) 165, 93, 1, maxColor, // 2  14
            (byte) 165, 93, 1, maxColor, // 6  15
            // ABAJO
            (byte) 165, 93, 1, maxColor, // 0  16
            (byte) 165, 93, 1, maxColor, // 1  17
            (byte) 165, 93, 1, maxColor, // 5  18
            (byte) 165, 93, 1, maxColor, // 4  19
            // ARRIBA
            (byte) 165, 93, 1, maxColor, // 7  20
            (byte) 165, 93, 1, maxColor, // 6  21
            (byte) 165, 93, 1, maxColor, // 2  22
            (byte) 165, 93, 1, maxColor  // 3  23
    };

    private byte coloresCubo2[] = new byte[] {
            // FRENTE
            (byte) 198, 111, 1, maxColor, // 4   0
            (byte) 198, 111, 1, maxColor, // 5   1
            (byte) 198, 111, 1, maxColor, // 6   2
            (byte) 198, 111, 1, maxColor, // 7   3
            // ATRAS
            (byte) 198, 111, 1, maxColor, // 3   4
            (byte) 198, 111, 1, maxColor, // 2   5
            (byte) 198, 111, 1, maxColor, // 1   6
            (byte) 198, 111, 1, maxColor, // 0   7
            // IZQUIERDA
            (byte) 198, 111, 1, maxColor, // 0   8
            (byte) 198, 111, 1, maxColor, // 4   9
            (byte) 198, 111, 1, maxColor, // 7  10
            (byte) 198, 111, 1, maxColor, // 3  11
            // DERECHA
            (byte) 198, 111, 1, maxColor, // 5  12
            (byte) 198, 111, 1, maxColor, // 1  13
            (byte) 198, 111, 1, maxColor, // 2  14
            (byte) 198, 111, 1, maxColor, // 6  15
            // ABAJO
            (byte) 198, 111, 1, maxColor, // 0  16
            (byte) 198, 111, 1, maxColor, // 1  17
            (byte) 198, 111, 1, maxColor, // 5  18
            (byte) 198, 111, 1, maxColor, // 4  19
            // ARRIBA
            (byte) 198, 111, 1, maxColor, // 7  20
            (byte) 198, 111, 1, maxColor, // 6  21
            (byte) 198, 111, 1, maxColor, // 2  22
            (byte) 198, 111, 1, maxColor  // 3  23
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

    public Montania() {

        /*--------------CUBO--------------------*/
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

    public void dibuja(GL10 gl) {

        /*--------RENDERIZA MONTANIA PRIMER COLOR-----------*/
        float altura = 0f;
        for (int i = 25; i >= 3; i--) {
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
            gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo);
            gl.glPushMatrix();
            gl.glTranslatef(0,altura,0);
            gl.glScalef(i,0.25f,i);
            gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
            gl.glPopMatrix();
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
            altura = altura + 0.5f;
        }
    }

    public void dibuja2(GL10 gl) {
        /*--------RENDERIZA MONTANIA SEGUNDO COLOR-------------*/
        float altura = 0f;
        for (int i = 25; i >= 3; i--) {
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
            gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo2);
            gl.glPushMatrix();
            gl.glTranslatef(0,altura,0);
            gl.glScalef(i,0.25f,i);
            gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
            gl.glPopMatrix();
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
            altura = altura + 0.5f;
        }
    }
}