package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdSnapshot.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements av<b, e>, Serializable, Cloneable {
    public static final Map<e, bh> d;
    private static final long e = -6496538196005191531L;
    private static final bz f = new bz("IdSnapshot");
    private static final bp g = new bp(HTTP.IDENTITY_CODING, (byte) 11, 1);
    private static final bp h = new bp("ts", (byte) 10, 2);
    private static final bp i = new bp("version", (byte) 8, 3);
    private static final Map<Class<? extends cc>, cd> j;
    private static final int k = 0;
    private static final int l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9283a;
    public long b;
    public int c;
    private byte m;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: IdSnapshot.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    public b a(String str) {
        this.f9283a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f9283a = null;
    }

    public String b() {
        return this.f9283a;
    }

    public void c() {
        this.f9283a = null;
    }

    public boolean d() {
        return this.f9283a != null;
    }

    public long e() {
        return this.b;
    }

    public int h() {
        return this.c;
    }

    static {
        HashMap map = new HashMap();
        j = map;
        AnonymousClass1 anonymousClass1 = null;
        map.put(ce.class, new C1155b(anonymousClass1));
        map.put(cf.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new bh(HTTP.IDENTITY_CODING, (byte) 1, new bi((byte) 11)));
        enumMap.put(e.TS, new bh("ts", (byte) 1, new bi((byte) 10)));
        enumMap.put(e.VERSION, new bh("version", (byte) 1, new bi((byte) 8)));
        Map<e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bh.a(b.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    public enum e implements bc {
        IDENTITY(1, HTTP.IDENTITY_CODING),
        TS(2, "ts"),
        VERSION(3, "version");

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        public static e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f;
        }

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return d.get(str);
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }
    }

    public b() {
        this.m = (byte) 0;
    }

    public b(String str, long j2, int i2) {
        this();
        this.f9283a = str;
        this.b = j2;
        b(true);
        this.c = i2;
        c(true);
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f9283a = bVar.f9283a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f9283a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.c = 0;
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.m = as.b(this.m, 0);
    }

    public boolean g() {
        return as.a(this.m, 0);
    }

    public void b(boolean z) {
        this.m = as.a(this.m, 0, z);
    }

    public b a(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    public void i() {
        this.m = as.b(this.m, 1);
    }

    public boolean j() {
        return as.a(this.m, 1);
    }

    public void c(boolean z) {
        this.m = as.a(this.m, 1, z);
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        j.get(buVar.D()).b().b(buVar, this);
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        j.get(buVar.D()).b().a(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(identity:");
        String str = this.f9283a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }

    public void k() throws bb {
        if (this.f9283a == null) {
            throw new bv("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class C1155b implements cd {
        private C1155b() {
        }

        /* synthetic */ C1155b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(null);
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class a extends ce<b> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, b bVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                if (bpVarL.b == 0) {
                    break;
                }
                short s = bpVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3) {
                            if (bpVarL.b == 8) {
                                bVar.c = buVar.w();
                                bVar.c(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                        } else {
                            bx.a(buVar, bpVarL.b);
                        }
                    } else if (bpVarL.b == 10) {
                        bVar.b = buVar.x();
                        bVar.b(true);
                    } else {
                        bx.a(buVar, bpVarL.b);
                    }
                } else if (bpVarL.b == 11) {
                    bVar.f9283a = buVar.z();
                    bVar.a(true);
                } else {
                    bx.a(buVar, bpVarL.b);
                }
                buVar.m();
            }
            buVar.k();
            if (!bVar.g()) {
                throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (!bVar.j()) {
                throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            bVar.k();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, b bVar) throws bb {
            bVar.k();
            buVar.a(b.f);
            if (bVar.f9283a != null) {
                buVar.a(b.g);
                buVar.a(bVar.f9283a);
                buVar.c();
            }
            buVar.a(b.h);
            buVar.a(bVar.b);
            buVar.c();
            buVar.a(b.i);
            buVar.a(bVar.c);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class d implements cd {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c(null);
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class c extends cf<b> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(bVar.f9283a);
            caVar.a(bVar.b);
            caVar.a(bVar.c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            bVar.f9283a = caVar.z();
            bVar.a(true);
            bVar.b = caVar.x();
            bVar.b(true);
            bVar.c = caVar.w();
            bVar.c(true);
        }
    }
}
