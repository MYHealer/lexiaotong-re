package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.br;
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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Imprint.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements av<d, e>, Serializable, Cloneable {
    public static final Map<e, bh> d;
    private static final long e = 2846460275012375038L;
    private static final bz f = new bz("Imprint");
    private static final bp g = new bp("property", (byte) 13, 1);
    private static final bp h = new bp("version", (byte) 8, 2);
    private static final bp i = new bp("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cc>, cd> j;
    private static final int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f9287a;
    public int b;
    public String c;
    private byte l;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: Imprint.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f9287a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f9287a = null;
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f9287a;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    public void d() {
        this.f9287a = null;
    }

    public boolean e() {
        return this.f9287a != null;
    }

    public int f() {
        return this.b;
    }

    public String i() {
        return this.c;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    static {
        HashMap map = new HashMap();
        j = map;
        AnonymousClass1 anonymousClass1 = null;
        map.put(ce.class, new b(anonymousClass1));
        map.put(cf.class, new C1157d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new bh("property", (byte) 1, new bk((byte) 13, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new bh("version", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.CHECKSUM, new bh("checksum", (byte) 1, new bi((byte) 11)));
        Map<e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bh.a(d.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: Imprint.java */
    public enum e implements bc {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        public static e a(int i) {
            if (i == 1) {
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
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

    public d() {
        this.l = (byte) 0;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f9287a = map;
        this.b = i2;
        b(true);
        this.c = str;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f9287a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f9287a = map;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f9287a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f9287a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f9287a == null) {
            this.f9287a = new HashMap();
        }
        this.f9287a.put(str, eVar);
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public void g() {
        this.l = as.b(this.l, 0);
    }

    public boolean h() {
        return as.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = as.a(this.l, 0, z);
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
        StringBuilder sb = new StringBuilder("Imprint(property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f9287a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    public void l() throws bb {
        if (this.f9287a == null) {
            throw new bv("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new bv("Required field 'checksum' was not present! Struct: " + toString());
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
            this.l = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class b implements cd {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(null);
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class a extends ce<d> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, d dVar) throws bb {
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
                            if (bpVarL.b == 11) {
                                dVar.c = buVar.z();
                                dVar.c(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                        } else {
                            bx.a(buVar, bpVarL.b);
                        }
                    } else if (bpVarL.b == 8) {
                        dVar.b = buVar.w();
                        dVar.b(true);
                    } else {
                        bx.a(buVar, bpVarL.b);
                    }
                } else if (bpVarL.b == 13) {
                    br brVarN = buVar.n();
                    dVar.f9287a = new HashMap(brVarN.c * 2);
                    for (int i = 0; i < brVarN.c; i++) {
                        String strZ = buVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(buVar);
                        dVar.f9287a.put(strZ, eVar);
                    }
                    buVar.o();
                    dVar.a(true);
                } else {
                    bx.a(buVar, bpVarL.b);
                }
                buVar.m();
            }
            buVar.k();
            if (!dVar.h()) {
                throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            dVar.l();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, d dVar) throws bb {
            dVar.l();
            buVar.a(d.f);
            if (dVar.f9287a != null) {
                buVar.a(d.g);
                buVar.a(new br((byte) 11, (byte) 12, dVar.f9287a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f9287a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            buVar.a(d.h);
            buVar.a(dVar.b);
            buVar.c();
            if (dVar.c != null) {
                buVar.a(d.i);
                buVar.a(dVar.c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Imprint.java */
    private static class C1157d implements cd {
        private C1157d() {
        }

        /* synthetic */ C1157d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c(null);
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class c extends cf<d> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(dVar.f9287a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f9287a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            caVar.a(dVar.b);
            caVar.a(dVar.c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            dVar.f9287a = new HashMap(brVar.c * 2);
            for (int i = 0; i < brVar.c; i++) {
                String strZ = caVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(caVar);
                dVar.f9287a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.b = caVar.w();
            dVar.b(true);
            dVar.c = caVar.z();
            dVar.c(true);
        }
    }
}
