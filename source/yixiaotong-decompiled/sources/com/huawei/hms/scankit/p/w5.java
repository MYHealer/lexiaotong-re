package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class w5 implements Parcelable {
    public static final Parcelable.Creator<w5> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4369a;
    private final byte[] b;
    private final int c;
    private y5[] d;
    private BarcodeFormat e;
    private final long f;
    private boolean g;
    private final boolean h;
    private final float i;
    private int j;
    private List<Rect> k;
    private boolean l;
    private int m;
    private List<Rect> n;
    private long o;
    private long p;
    private boolean q;

    /* JADX INFO: compiled from: Result.java */
    class a implements Parcelable.Creator<w5> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public w5 createFromParcel(Parcel parcel) {
            return new w5(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public w5[] newArray(int i) {
            return new w5[i];
        }
    }

    public w5(float f) {
        this.g = false;
        this.q = false;
        this.i = f;
        this.f4369a = null;
        this.b = new byte[0];
        this.c = 0;
        this.d = new y5[0];
        this.e = BarcodeFormat.NONE;
        this.f = 0L;
        this.h = false;
        this.j = 0;
        this.l = false;
        this.m = 0;
        this.k = new ArrayList();
        this.n = new ArrayList();
    }

    public void a() {
        this.d = new y5[0];
    }

    public void a(float f) {
        if (f < 20.0f) {
            this.j = 0;
            return;
        }
        if (f < 50.0f) {
            this.j = 2;
            return;
        }
        if (f < 90.0f) {
            this.j = 1;
            return;
        }
        if (f < 140.0f) {
            this.j = 0;
        } else if (f < 190.0f) {
            this.j = -1;
        } else if (f <= 255.0f) {
            this.j = -2;
        }
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(long j) {
        this.p = j;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public long b() {
        return this.p;
    }

    public void b(float f) {
        if (f < 50.0f) {
            this.m = 2;
            return;
        }
        if (f < 90.0f) {
            this.m = 1;
            return;
        }
        if (f < 140.0f) {
            this.m = 0;
        } else if (f < 190.0f) {
            this.m = -1;
        } else if (f <= 255.0f) {
            this.m = -2;
        }
    }

    public void b(long j) {
        this.o = j;
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void b(y5[] y5VarArr) {
        this.d = y5VarArr;
    }

    public BarcodeFormat c() {
        return this.e;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public List<Rect> d() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.o;
    }

    public int f() {
        return this.j;
    }

    public List<Rect> g() {
        return this.n;
    }

    public int h() {
        return this.m;
    }

    public byte[] i() {
        return this.b;
    }

    public y5[] j() {
        return this.d;
    }

    public String k() {
        return this.f4369a;
    }

    public float l() {
        return this.i;
    }

    public boolean m() {
        return this.q;
    }

    public boolean n() {
        return this.l;
    }

    public String toString() {
        return this.f4369a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4369a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
        parcel.writeTypedArray(this.d, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeFloat(this.i);
        parcel.writeInt(this.j);
        parcel.writeList(this.k);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
        parcel.writeInt(this.q ? 1 : 0);
    }

    public void b(y1 y1Var) {
        int iD = (int) y1Var.d();
        int iE = (int) y1Var.e();
        this.n.add(new Rect(iD, iE, ((int) y1Var.f()) + iD, ((int) y1Var.c()) + iE));
    }

    public void a(y1 y1Var) {
        int iD = (int) y1Var.d();
        int iE = (int) y1Var.e();
        this.k.add(new Rect(iD, iE, ((int) y1Var.f()) + iD, ((int) y1Var.c()) + iE));
    }

    public void a(y5[] y5VarArr) {
        y5[] y5VarArr2 = this.d;
        if (y5VarArr2 == null) {
            this.d = y5VarArr;
            return;
        }
        if (y5VarArr == null || y5VarArr.length <= 0) {
            return;
        }
        y5[] y5VarArr3 = new y5[y5VarArr2.length + y5VarArr.length];
        System.arraycopy(y5VarArr2, 0, y5VarArr3, 0, y5VarArr2.length);
        System.arraycopy(y5VarArr, 0, y5VarArr3, y5VarArr2.length, y5VarArr.length);
        this.d = y5VarArr3;
    }

    public w5(String str, byte[] bArr, y5[] y5VarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, y5VarArr, barcodeFormat, System.currentTimeMillis());
    }

    public w5(String str, byte[] bArr, y5[] y5VarArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, y5VarArr, barcodeFormat, j);
    }

    public w5(String str, byte[] bArr, int i, y5[] y5VarArr, BarcodeFormat barcodeFormat, long j) {
        this.g = false;
        this.q = false;
        this.f4369a = str;
        this.b = bArr;
        this.c = i;
        this.d = y5VarArr;
        this.e = barcodeFormat;
        this.f = j;
        this.i = 1.0f;
        this.h = false;
    }

    protected w5(Parcel parcel) {
        this.g = false;
        this.q = false;
        this.f4369a = parcel.readString();
        this.b = parcel.createByteArray();
        this.c = parcel.readInt();
        this.d = (y5[]) parcel.createTypedArray(y5.CREATOR);
        this.e = (BarcodeFormat) parcel.readParcelable(w5.class.getClassLoader());
        this.f = parcel.readLong();
        this.g = parcel.readInt() == 1;
        this.h = parcel.readInt() == 1;
        this.i = parcel.readFloat();
        this.j = parcel.readInt();
        if (this.k == null) {
            this.k = new ArrayList();
        }
        parcel.readList(this.k, w5.class.getClassLoader());
        this.o = parcel.readLong();
        this.p = parcel.readLong();
        this.q = parcel.readInt() == 1;
    }
}
