package com.huawei.hms.scankit.p;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class y5 implements Parcelable {
    public static final Parcelable.Creator<y5> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4381a;
    private final float b;
    private int c;
    private boolean d;

    /* JADX INFO: compiled from: ResultPoint.java */
    class a implements Parcelable.Creator<y5> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public y5 createFromParcel(Parcel parcel) {
            return new y5(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public y5[] newArray(int i) {
            return new y5[i];
        }
    }

    public y5(float f, float f2, int i) {
        this.d = false;
        this.f4381a = f;
        this.b = f2;
        this.c = i;
    }

    private static int[] a(float f, float f2, float f3) {
        int i;
        int i2 = 1;
        int i3 = 0;
        int i4 = 2;
        if (f < f2 || f < f3) {
            if (f3 < f || f3 < f2) {
                if (f > f) {
                    i = 2;
                    i4 = 1;
                    i2 = i;
                } else {
                    i3 = 1;
                    i2 = 2;
                    i4 = 0;
                }
            } else if (f <= f2) {
                i4 = 0;
                i3 = 2;
            }
        } else if (f2 > f3) {
            i4 = 1;
            i2 = 0;
            i3 = 2;
        } else {
            i = 0;
            i3 = 1;
            i2 = i;
        }
        return new int[]{i2, i3, i4};
    }

    public int a() {
        return this.c;
    }

    public final float b() {
        return this.f4381a;
    }

    public final float c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y5)) {
            return false;
        }
        y5 y5Var = (y5) obj;
        return ((double) Math.abs(this.f4381a - y5Var.f4381a)) < 1.0E-4d && ((double) Math.abs(this.b - y5Var.b)) < 1.0E-4d;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f4381a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.f4381a + ',' + this.b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f4381a);
        parcel.writeFloat(this.b);
    }

    public static void a(y5[] y5VarArr) {
        float fA = a(y5VarArr[0], y5VarArr[1]);
        float fA2 = a(y5VarArr[1], y5VarArr[2]);
        float fA3 = a(y5VarArr[0], y5VarArr[2]);
        int[] iArrA = a(fA2, fA, fA3);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int i3 = iArrA[2];
        y5 y5Var = y5VarArr[i];
        y5 y5Var2 = y5VarArr[i2];
        y5 y5Var3 = y5VarArr[i3];
        float[] fArr = {fA2, fA3, fA};
        if (b3.f % 2 == 0 && fArr[i2] / fArr[i] < 1.1d) {
            y5Var = y5VarArr[i];
            y5Var2 = y5VarArr[i2];
            y5Var3 = y5VarArr[i3];
        }
        if (a(y5Var2, y5Var, y5Var3) < 0.0f) {
            y5 y5Var4 = y5Var3;
            y5Var3 = y5Var2;
            y5Var2 = y5Var4;
        }
        y5VarArr[0] = y5Var2;
        y5VarArr[1] = y5Var;
        y5VarArr[2] = y5Var3;
    }

    public y5(float f, float f2) {
        this.c = 0;
        this.d = false;
        this.f4381a = f;
        this.b = f2;
    }

    public y5(float f, float f2, boolean z) {
        this.c = 0;
        this.f4381a = f;
        this.b = f2;
        this.d = z;
    }

    public static float a(y5 y5Var, y5 y5Var2) {
        return b4.a(y5Var.f4381a, y5Var.b, y5Var2.f4381a, y5Var2.b);
    }

    private static float a(y5 y5Var, y5 y5Var2, y5 y5Var3) {
        float f = y5Var2.f4381a;
        float f2 = y5Var2.b;
        return ((y5Var3.f4381a - f) * (y5Var.b - f2)) - ((y5Var3.b - f2) * (y5Var.f4381a - f));
    }

    protected y5(Parcel parcel) {
        this.c = 0;
        this.d = false;
        this.f4381a = parcel.readFloat();
        this.b = parcel.readFloat();
    }
}
