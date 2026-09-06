package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface u {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6359a;
        public final int b;
        public final byte[] c;

        public a(String str, int i, byte[] bArr) {
            this.f6359a = str;
            this.b = i;
            this.c = bArr;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6360a;
        public final String b;
        public final List<a> c;
        public final byte[] d;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.f6360a = i;
            this.b = str;
            this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.d = bArr;
        }
    }

    public interface c {
        SparseArray<u> a();

        u a(int i, b bVar);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6361a;
        private final int b;
        private final int c;
        private int d;
        private String e;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.f6361a = i != Integer.MIN_VALUE ? i + "/" : "";
            this.b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
        }

        private void d() {
            if (this.d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.e = this.f6361a + this.d;
        }

        public int b() {
            d();
            return this.d;
        }

        public String c() {
            d();
            return this.e;
        }
    }

    void a();

    void a(com.opos.exoplayer.core.i.p pVar, boolean z);

    void a(com.opos.exoplayer.core.i.w wVar, com.opos.exoplayer.core.c.g gVar, d dVar);
}
