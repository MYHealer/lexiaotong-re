package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UMEnvelope.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class an implements av<an, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, bh> k;
    private static final long l = 420342210744516016L;
    private static final bz m = new bz("UMEnvelope");
    private static final bp n = new bp("version", (byte) 11, 1);
    private static final bp o = new bp(com.hihonor.adsdk.base.g.j.e.a.G0, (byte) 11, 2);
    private static final bp p = new bp("signature", (byte) 11, 3);
    private static final bp q = new bp("serial_num", (byte) 8, 4);
    private static final bp r = new bp("ts_secs", (byte) 8, 5);
    private static final bp s = new bp("length", (byte) 8, 6);
    private static final bp t = new bp("entity", (byte) 11, 7);
    private static final bp u = new bp("guid", (byte) 11, 8);
    private static final bp v = new bp("checksum", (byte) 11, 9);
    private static final bp w = new bp("codex", (byte) 8, 10);
    private static final Map<Class<? extends cc>, cd> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9101a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    /* JADX INFO: renamed from: com.umeng.analytics.pro.an$1, reason: invalid class name */
    /* JADX INFO: compiled from: UMEnvelope.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    public String A() {
        return this.i;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public int D() {
        return this.j;
    }

    public an a(String str) {
        this.f9101a = str;
        return this;
    }

    public an a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f9101a = null;
    }

    public an b(String str) {
        this.b = str;
        return this;
    }

    public String b() {
        return this.f9101a;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.b = null;
    }

    public an c(String str) {
        this.c = str;
        return this;
    }

    public void c() {
        this.f9101a = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.c = null;
    }

    public an d(String str) {
        this.h = str;
        return this;
    }

    public boolean d() {
        return this.f9101a != null;
    }

    public an e(String str) {
        this.i = str;
        return this;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.g = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.c;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.h = null;
    }

    public void i() {
        this.c = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public int k() {
        return this.d;
    }

    public int n() {
        return this.e;
    }

    public int q() {
        return this.f;
    }

    public ByteBuffer u() {
        return this.g;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    public String x() {
        return this.h;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }

    static {
        HashMap map = new HashMap();
        x = map;
        AnonymousClass1 anonymousClass1 = null;
        map.put(ce.class, new b(anonymousClass1));
        map.put(cf.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new bh("version", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.ADDRESS, new bh(com.hihonor.adsdk.base.g.j.e.a.G0, (byte) 1, new bi((byte) 11)));
        enumMap.put(e.SIGNATURE, new bh("signature", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new bh("serial_num", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.TS_SECS, new bh("ts_secs", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.LENGTH, new bh("length", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.ENTITY, new bh("entity", (byte) 1, new bi((byte) 11, true)));
        enumMap.put(e.GUID, new bh("guid", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.CHECKSUM, new bh("checksum", (byte) 1, new bi((byte) 11)));
        enumMap.put(e.CODEX, new bh("codex", (byte) 2, new bi((byte) 8)));
        Map<e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        k = mapUnmodifiableMap;
        bh.a(an.class, mapUnmodifiableMap);
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    public enum e implements bc {
        VERSION(1, "version"),
        ADDRESS(2, com.hihonor.adsdk.base.g.j.e.a.G0),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");

        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.l;
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.m;
        }

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                k.put(eVar.b(), eVar);
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
            return k.get(str);
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }
    }

    public an() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public an(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f9101a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        d(true);
        this.e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public an(an anVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = anVar.C;
        if (anVar.d()) {
            this.f9101a = anVar.f9101a;
        }
        if (anVar.g()) {
            this.b = anVar.b;
        }
        if (anVar.j()) {
            this.c = anVar.c;
        }
        this.d = anVar.d;
        this.e = anVar.e;
        this.f = anVar.f;
        if (anVar.w()) {
            this.g = aw.d(anVar.g);
        }
        if (anVar.z()) {
            this.h = anVar.h;
        }
        if (anVar.C()) {
            this.i = anVar.i;
        }
        this.j = anVar.j;
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public an deepCopy() {
        return new an(this);
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f9101a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public an a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public void l() {
        this.C = as.b(this.C, 0);
    }

    public boolean m() {
        return as.a(this.C, 0);
    }

    public void d(boolean z2) {
        this.C = as.a(this.C, 0, z2);
    }

    public an b(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public void o() {
        this.C = as.b(this.C, 1);
    }

    public boolean p() {
        return as.a(this.C, 1);
    }

    public void e(boolean z2) {
        this.C = as.a(this.C, 1, z2);
    }

    public an c(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public void r() {
        this.C = as.b(this.C, 2);
    }

    public boolean s() {
        return as.a(this.C, 2);
    }

    public void f(boolean z2) {
        this.C = as.a(this.C, 2, z2);
    }

    public byte[] t() {
        a(aw.c(this.g));
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public an a(byte[] bArr) {
        ByteBuffer byteBufferWrap;
        if (bArr == null) {
            byteBufferWrap = null;
        } else {
            byteBufferWrap = ByteBuffer.wrap(bArr);
        }
        a(byteBufferWrap);
        return this;
    }

    public an d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public void E() {
        this.C = as.b(this.C, 3);
    }

    public boolean F() {
        return as.a(this.C, 3);
    }

    public void j(boolean z2) {
        this.C = as.a(this.C, 3, z2);
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i) {
        return e.a(i);
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        x.get(buVar.D()).b().b(buVar, this);
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        x.get(buVar.D()).b().a(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f9101a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            aw.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public void G() throws bb {
        if (this.f9101a == null) {
            throw new bv("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new bv("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new bv("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new bv("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.h == null) {
            throw new bv("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.i == null) {
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
            this.C = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
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

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class a extends ce<an> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, an anVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                if (bpVarL.b != 0) {
                    switch (bpVarL.c) {
                        case 1:
                            if (bpVarL.b == 11) {
                                anVar.f9101a = buVar.z();
                                anVar.a(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 2:
                            if (bpVarL.b == 11) {
                                anVar.b = buVar.z();
                                anVar.b(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 3:
                            if (bpVarL.b == 11) {
                                anVar.c = buVar.z();
                                anVar.c(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 4:
                            if (bpVarL.b == 8) {
                                anVar.d = buVar.w();
                                anVar.d(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 5:
                            if (bpVarL.b == 8) {
                                anVar.e = buVar.w();
                                anVar.e(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 6:
                            if (bpVarL.b == 8) {
                                anVar.f = buVar.w();
                                anVar.f(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 7:
                            if (bpVarL.b == 11) {
                                anVar.g = buVar.A();
                                anVar.g(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 8:
                            if (bpVarL.b == 11) {
                                anVar.h = buVar.z();
                                anVar.h(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 9:
                            if (bpVarL.b == 11) {
                                anVar.i = buVar.z();
                                anVar.i(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        case 10:
                            if (bpVarL.b == 8) {
                                anVar.j = buVar.w();
                                anVar.j(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                            break;
                        default:
                            bx.a(buVar, bpVarL.b);
                            break;
                    }
                    buVar.m();
                } else {
                    buVar.k();
                    if (!anVar.m()) {
                        throw new bv("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!anVar.p()) {
                        throw new bv("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (!anVar.s()) {
                        throw new bv("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                    anVar.G();
                    return;
                }
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, an anVar) throws bb {
            anVar.G();
            buVar.a(an.m);
            if (anVar.f9101a != null) {
                buVar.a(an.n);
                buVar.a(anVar.f9101a);
                buVar.c();
            }
            if (anVar.b != null) {
                buVar.a(an.o);
                buVar.a(anVar.b);
                buVar.c();
            }
            if (anVar.c != null) {
                buVar.a(an.p);
                buVar.a(anVar.c);
                buVar.c();
            }
            buVar.a(an.q);
            buVar.a(anVar.d);
            buVar.c();
            buVar.a(an.r);
            buVar.a(anVar.e);
            buVar.c();
            buVar.a(an.s);
            buVar.a(anVar.f);
            buVar.c();
            if (anVar.g != null) {
                buVar.a(an.t);
                buVar.a(anVar.g);
                buVar.c();
            }
            if (anVar.h != null) {
                buVar.a(an.u);
                buVar.a(anVar.h);
                buVar.c();
            }
            if (anVar.i != null) {
                buVar.a(an.v);
                buVar.a(anVar.i);
                buVar.c();
            }
            if (anVar.F()) {
                buVar.a(an.w);
                buVar.a(anVar.j);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
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

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class c extends cf<an> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(anVar.f9101a);
            caVar.a(anVar.b);
            caVar.a(anVar.c);
            caVar.a(anVar.d);
            caVar.a(anVar.e);
            caVar.a(anVar.f);
            caVar.a(anVar.g);
            caVar.a(anVar.h);
            caVar.a(anVar.i);
            BitSet bitSet = new BitSet();
            if (anVar.F()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (anVar.F()) {
                caVar.a(anVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            anVar.f9101a = caVar.z();
            anVar.a(true);
            anVar.b = caVar.z();
            anVar.b(true);
            anVar.c = caVar.z();
            anVar.c(true);
            anVar.d = caVar.w();
            anVar.d(true);
            anVar.e = caVar.w();
            anVar.e(true);
            anVar.f = caVar.w();
            anVar.f(true);
            anVar.g = caVar.A();
            anVar.g(true);
            anVar.h = caVar.z();
            anVar.h(true);
            anVar.i = caVar.z();
            anVar.i(true);
            if (caVar.b(1).get(0)) {
                anVar.j = caVar.w();
                anVar.j(true);
            }
        }
    }
}
