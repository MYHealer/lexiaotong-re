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
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdJournal.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements av<a, e>, Serializable, Cloneable {
    public static final Map<e, bh> e;
    private static final long f = 9132678615281394583L;
    private static final bz g = new bz("IdJournal");
    private static final bp h = new bp(ClientCookie.DOMAIN_ATTR, (byte) 11, 1);
    private static final bp i = new bp("old_id", (byte) 11, 2);
    private static final bp j = new bp("new_id", (byte) 11, 3);
    private static final bp k = new bp("ts", (byte) 10, 4);
    private static final Map<Class<? extends cc>, cd> l;
    private static final int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9281a;
    public String b;
    public String c;
    public long d;
    private byte n;
    private e[] o;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: IdJournal.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    public a a(String str) {
        this.f9281a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f9281a = null;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public String b() {
        return this.f9281a;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public a c(String str) {
        this.c = str;
        return this;
    }

    public void c() {
        this.f9281a = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    public boolean d() {
        return this.f9281a != null;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public long k() {
        return this.d;
    }

    static {
        HashMap map = new HashMap();
        l = map;
        AnonymousClass1 anonymousClass1 = null;
        map.put(ce.class, new b(anonymousClass1));
        map.put(cf.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new bh(ClientCookie.DOMAIN_ATTR, (byte) 1, new bi((byte) 11)));
        enumMap.put(e.OLD_ID, new bh("old_id", (byte) 2, new bi((byte) 11)));
        enumMap.put(e.NEW_ID, new bh("new_id", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.TS, new bh("ts", (byte) 1, new bi((byte) 10)));
        Map<e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        e = mapUnmodifiableMap;
        bh.a(a.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public enum e implements bc {
        DOMAIN(1, ClientCookie.DOMAIN_ATTR),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");

        private static final Map<String, e> e = new HashMap();
        private final short f;
        private final String g;

        public static e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f;
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.g;
        }

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                e.put(eVar.b(), eVar);
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
            return e.get(str);
        }

        e(short s, String str) {
            this.f = s;
            this.g = str;
        }
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    public a(String str, String str2, long j2) {
        this();
        this.f9281a = str;
        this.c = str2;
        this.d = j2;
        d(true);
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f9281a = aVar.f9281a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.c = aVar.c;
        }
        this.d = aVar.d;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f9281a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0L;
    }

    public a a(long j2) {
        this.d = j2;
        d(true);
        return this;
    }

    public void l() {
        this.n = as.b(this.n, 0);
    }

    public boolean m() {
        return as.a(this.n, 0);
    }

    public void d(boolean z) {
        this.n = as.a(this.n, 0, z);
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        l.get(buVar.D()).b().b(buVar, this);
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        l.get(buVar.D()).b().a(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(domain:");
        String str = this.f9281a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    public void n() throws bb {
        if (this.f9281a == null) {
            throw new bv("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new bv("Required field 'new_id' was not present! Struct: " + toString());
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
            this.n = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class b implements cd {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1154a b() {
            return new C1154a(null);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdJournal.java */
    private static class C1154a extends ce<a> {
        private C1154a() {
        }

        /* synthetic */ C1154a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, a aVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                if (bpVarL.b == 0) {
                    break;
                }
                short s = bpVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s == 4) {
                                if (bpVarL.b == 10) {
                                    aVar.d = buVar.x();
                                    aVar.d(true);
                                } else {
                                    bx.a(buVar, bpVarL.b);
                                }
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                        } else if (bpVarL.b == 11) {
                            aVar.c = buVar.z();
                            aVar.c(true);
                        } else {
                            bx.a(buVar, bpVarL.b);
                        }
                    } else if (bpVarL.b == 11) {
                        aVar.b = buVar.z();
                        aVar.b(true);
                    } else {
                        bx.a(buVar, bpVarL.b);
                    }
                } else if (bpVarL.b == 11) {
                    aVar.f9281a = buVar.z();
                    aVar.a(true);
                } else {
                    bx.a(buVar, bpVarL.b);
                }
                buVar.m();
            }
            buVar.k();
            if (!aVar.m()) {
                throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            aVar.n();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, a aVar) throws bb {
            aVar.n();
            buVar.a(a.g);
            if (aVar.f9281a != null) {
                buVar.a(a.h);
                buVar.a(aVar.f9281a);
                buVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                buVar.a(a.i);
                buVar.a(aVar.b);
                buVar.c();
            }
            if (aVar.c != null) {
                buVar.a(a.j);
                buVar.a(aVar.c);
                buVar.c();
            }
            buVar.a(a.k);
            buVar.a(aVar.d);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
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

    /* JADX INFO: compiled from: IdJournal.java */
    private static class c extends cf<a> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(aVar.f9281a);
            caVar.a(aVar.c);
            caVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (aVar.g()) {
                caVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            aVar.f9281a = caVar.z();
            aVar.a(true);
            aVar.c = caVar.z();
            aVar.c(true);
            aVar.d = caVar.x();
            aVar.d(true);
            if (caVar.b(1).get(0)) {
                aVar.b = caVar.z();
                aVar.b(true);
            }
        }
    }
}
