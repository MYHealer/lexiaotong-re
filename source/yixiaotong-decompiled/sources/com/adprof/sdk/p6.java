package com.adprof.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f1358a = new o6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f552a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List f553b = new ArrayList(64);
    public int b = 0;

    public p6(int i) {
        this.f551a = i;
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f551a) {
                this.f552a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f553b, bArr, f1358a);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f553b.add(iBinarySearch, bArr);
                this.b += bArr.length;
                synchronized (this) {
                    while (this.b > this.f551a) {
                        byte[] bArr2 = (byte[]) this.f552a.remove(0);
                        this.f553b.remove(bArr2);
                        this.b -= bArr2.length;
                    }
                }
            }
        }
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f553b.size(); i2++) {
            byte[] bArr = (byte[]) this.f553b.get(i2);
            if (bArr.length >= i) {
                this.b -= bArr.length;
                this.f553b.remove(i2);
                this.f552a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
