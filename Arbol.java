package com.example.laboratorio5;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author Nain Perez
 * @version 17.7.2020 v1
 */
public class Arbol {

    /*----------PIRAMIDE--------------*/
    private float verticesTronco[] = new float[] {
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
    private byte coloresTronco[] = new byte[] {
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

    private short indicesTronco[] = new short [] {
            0, 1, 2,                // FRENTE
            3, 4, 5,                // ATRAS
            6, 7, 8,                // IZQUIERDA
            9, 10, 11,              // DERECHA
            12, 13, 14, 12, 14, 15, // ABAJO
    };
    private FloatBuffer bufVerticesTronco;
    private ByteBuffer bufColoresTronco;
    private ShortBuffer bufIndicesTronco;

    /*--------------ESFERA-----------------*/
    int segmentosH;
    int segmentosV;

    private short indices[];
    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;

    public Arbol(float radio, int segmentosH, int segmentosV) {

        /*------------ESFERA-----------------*/
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

        /*----------------PIRAMIDE------------------*/
        ByteBuffer bufByteTronco = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByteTronco.order(ByteOrder.nativeOrder());
        bufVerticesTronco = bufByteTronco.asFloatBuffer();
        bufVerticesTronco.put(verticesTronco);
        bufVerticesTronco.rewind();

        bufColoresTronco = ByteBuffer.allocateDirect(coloresTronco.length);
        bufColoresTronco.put(coloresTronco);
        bufColoresTronco.position(0);

        bufByteTronco = ByteBuffer.allocateDirect(indices.length * 2);
        bufByteTronco.order(ByteOrder.nativeOrder());
        bufIndicesTronco = bufByteTronco.asShortBuffer();
        bufIndicesTronco.put(indicesTronco);
        bufIndicesTronco.rewind();
    }

    public void dibuja(GL10 gl) {

        /*RENDERIZA TRONCO*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVerticesTronco);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColoresTronco);
        gl.glPushMatrix();
        gl.glTranslatef(0,-2,0);
        gl.glScalef(0.5f,2,0.5f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indicesTronco.length, GL10.GL_UNSIGNED_SHORT, bufIndicesTronco);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 1*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 2*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(1,0,0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 3*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(-1,0,0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 4*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(0.6f,0,0.6f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 5*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(-0.6f,0,-0.6f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 6*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(0,1,0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 7*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(0,0,1);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 8*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-1);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 9*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(1,-1,1);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 10*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(-1,-1,1);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 11*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(1,-1,-1);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        /*RENDERIZA ARBUSTO DE HOJAS ARBOL 12*/
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();
        gl.glTranslatef(-1,-1,-1);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}