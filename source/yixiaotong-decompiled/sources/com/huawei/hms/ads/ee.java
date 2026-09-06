package com.huawei.hms.ads;

import android.opengl.Matrix;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ee {
    private static final float[] Code;
    private float B;
    private float C;
    private float S;
    private final ed V;
    private float Z;
    private int I = -1;
    private final float[] F = new float[16];
    private boolean D = false;
    private final float[] L = new float[16];

    static {
        float[] fArr = new float[16];
        Code = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public ee(ed edVar) {
        this.V = edVar;
    }

    private void Code() {
        float[] fArr = this.F;
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, this.C, this.S, 0.0f);
        Matrix.scaleM(fArr, 0, this.Z, this.B, 1.0f);
        this.D = true;
    }

    private float[] V() {
        if (!this.D) {
            Code();
        }
        return this.F;
    }

    public void Code(float f, float f2) {
        this.Z = f;
        this.B = f2;
        this.D = false;
    }

    public void Code(int i) {
        this.I = i;
    }

    public void Code(ef efVar, float[] fArr) {
        Matrix.multiplyMM(this.L, 0, fArr, 0, V(), 0);
        efVar.Code(new eg(this.L, this.V.Code(), 0, this.V.I(), this.V.C(), this.V.Z(), Code, this.V.V(), this.I, this.V.B()));
    }

    public void V(float f, float f2) {
        this.C = f;
        this.S = f2;
        this.D = false;
    }
}
