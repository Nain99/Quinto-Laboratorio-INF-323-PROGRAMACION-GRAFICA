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

public class Casa {

    /*----------PIRAMIDE--------------*/
    private float verticesTecho[] = new float[] {
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
    private byte coloresTecho[] = new byte[] {
            // FRENTE
            (byte) (145), (byte) (72), 0, maxColor, // 0 0
            (byte) (145), (byte) (72), 0, maxColor, // 1 1
            (byte) (145), (byte) (72), 0, maxColor, // 2 2
            // ATRAS
            (byte) (145), (byte) (72), 0, maxColor, // 4 3
            (byte) (145), (byte) (72), 0, maxColor, // 3 4
            (byte) (145), (byte) (72), 0, maxColor, // 2 5
            // IZQUIERDA
            (byte) (74), (byte) (37), 0, maxColor, // 4 6
            (byte) (74), (byte) (37), 0, maxColor, // 0 7
            (byte) (74), (byte) (37), 0, maxColor, // 2 8
            // DERECHA
            (byte) (74), (byte) (37), 0, maxColor, // 3 9
            (byte) (74), (byte) (37), 0, maxColor, // 1 10
            (byte) (74), (byte) (37), 0, maxColor, // 2 11
            // ABAJO
            (byte) (36), (byte) (18), 0, maxColor, // 0 12
            (byte) (36), (byte) (18), 0, maxColor, // 1 13
            (byte) (36), (byte) (18), 0, maxColor, // 3 14
            (byte) (36), (byte) (18), 0, maxColor, // 4 15
    };

    private short indicesTecho[] = new short [] {
            0, 1, 2,                // FRENTE
            3, 4, 5,                // ATRAS
            6, 7, 8,                // IZQUIERDA
            9, 10, 11,              // DERECHA
            12, 13, 14, 12, 14, 15, // ABAJO
    };
    private FloatBuffer bufVerticesTecho;
    private ByteBuffer bufColoresTecho;
    private ShortBuffer bufIndicesTecho;

    /*--------------CUBO-------------------*/
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
            (byte)183, 91, 0, maxColor, // 4   0
            (byte)183, 91, 0, maxColor, // 5   1
            (byte)183, 91, 0, maxColor, // 6   2
            (byte)183, 91, 0, maxColor, // 7   3
            // ATRAS
            (byte)183, 91, 0, maxColor, // 3   4
            (byte)183, 91, 0, maxColor, // 2   5
            (byte)183, 91, 0, maxColor, // 1   6
            (byte)183, 91, 0, maxColor, // 0   7
            // IZQUIERDA
            (byte)130, 65, 0, maxColor, // 0   8
            (byte)130, 65, 0, maxColor, // 4   9
            (byte)130, 65, 0, maxColor, // 7  10
            (byte)130, 65, 0, maxColor, // 3  11
            // DERECHA
            (byte)130, 65, 0, maxColor, // 5  12
            (byte)130, 65, 0, maxColor, // 1  13
            (byte)130, 65, 0, maxColor, // 2  14
            (byte)130, 65, 0, maxColor, // 6  15
            // ABAJO
            0, 0, 0, maxColor, // 0  16
            0, 0, 0, maxColor, // 1  17
            0, 0, 0, maxColor, // 5  18
            0, 0, 0, maxColor, // 4  19
            // ARRIBA
            0, 0, 0, maxColor, // 7  20
            0, 0, 0, maxColor, // 6  21
            0, 0, 0, maxColor, // 2  22
            0, 0, 0, maxColor  // 3  23
    };

    private byte coloresCubo2[] = new byte[] {
            // FRENTE
            64, 32, 0, maxColor, // 4   0
            64, 32, 0, maxColor, // 5   1
            64, 32, 0, maxColor, // 6   2
            64, 32, 0, maxColor, // 7   3
            // ATRAS
            0, 0, 0, maxColor, // 3   4
            0, 0, 0, maxColor, // 2   5
            0, 0, 0, maxColor, // 1   6
            0, 0, 0, maxColor, // 0   7
            // IZQUIERDA
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
            0, 0, 0, maxColor, // 7  20
            0, 0, 0, maxColor, // 6  21
            0, 0, 0, maxColor, // 2  22
            0, 0, 0, maxColor  // 3  23
    };
    private short indicesCubo[] = new short [] {
            0,  1,  2,  0,  2,  3,  // Frente
            4,  5,  6,  4,  6,  7,  // Atrás
            8,  9, 10,  8, 10, 11,  // Izquierda
            12, 13, 14, 12, 14, 15, // Derecha
            16, 17, 18, 16, 18, 19, // Abajo
            20, 21, 22, 20, 22, 23  // Arriba
    };

    private FloatBuffer bufVerticesCubo;
    private ByteBuffer bufColoresCubo;
    private ByteBuffer bufColoresCubo2;
    private ShortBuffer bufIndicesCubo;

    public Casa(){
        /*--------------------CUBO---------------------------*/
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

        /*------------------------PIRAMIDE------------------------*/

        ByteBuffer bufByteTecho = ByteBuffer.allocateDirect(verticesTecho.length * 4);
        bufByteTecho.order(ByteOrder.nativeOrder());
        bufVerticesTecho = bufByteTecho.asFloatBuffer();
        bufVerticesTecho.put(verticesTecho);
        bufVerticesTecho.rewind();

        bufColoresTecho = ByteBuffer.allocateDirect(coloresTecho.length);
        bufColoresTecho.put(coloresTecho);
        bufColoresTecho.position(0);

        bufByteTecho = ByteBuffer.allocateDirect(indicesTecho.length * 2);
        bufByteTecho.order(ByteOrder.nativeOrder());
        bufIndicesTecho = bufByteTecho.asShortBuffer();
        bufIndicesTecho.put(indicesTecho);
        bufIndicesTecho.rewind();

    }
    public void dibuja(GL10 gl){
        /*-------------RENDERIZA TECHO-------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesTecho);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresTecho);
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.62f,0);
        gl.glScalef(0.165f,0.150f,0.165f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesTecho.length, GL10.GL_UNSIGNED_SHORT, bufIndicesTecho);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*-------------RENDERIZA BASE-----------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo);
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.87f,0);
        gl.glScalef(0.125f,0.125f,0.125f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*----------------RENDERIZA PUERTA-----------------*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesCubo);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresCubo2);
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.9f,0.11f);
        gl.glScalef(0.0625f,0.1f,0.015625f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesCubo.length, GL10.GL_UNSIGNED_SHORT, bufIndicesCubo);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
