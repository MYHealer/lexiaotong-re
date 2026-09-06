package com.umeng.commonsdk.statistics.proto;

import com.ubixnow.ooooo.oOOOoo00;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements av<e, EnumC1158e>, Serializable, Cloneable {
    public static final Map<EnumC1158e, bh> d;
    private static final long e = 7501688097813630241L;
    private static final bz f = new bz("ImprintValue");
    private static final bp g = new bp(oOOOoo00.OooOo0o, (byte) 11, 1);
    private static final bp h = new bp("ts", (byte) 10, 2);
    private static final bp i = new bp("guid", (byte) 11, 3);
    private static final Map<Class<? extends cc>, cd> j;
    private static final int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9289a;
    public long b;
    public String c;
    private byte l;
    private EnumC1158e[] m;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImprintValue.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    public e a(String str) {
        this.f9289a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f9289a = null;
    }

    public e b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.f9289a;
    }

    public void c() {
        this.f9289a = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    public boolean d() {
        return this.f9289a != null;
    }

    public long e() {
        return this.b;
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

    public void k() throws bb {
    }

    static {
        HashMap map = new HashMap();
        j = map;
        AnonymousClass1 anonymousClass1 = null;
        map.put(ce.class, new b(anonymousClass1));
        map.put(cf.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(EnumC1158e.class);
        enumMap.put(EnumC1158e.VALUE, new bh(oOOOoo00.OooOo0o, (byte) 2, new bi((byte) 11)));
        enumMap.put(EnumC1158e.TS, new bh("ts", (byte) 2, new bi((byte) 10)));
        enumMap.put(EnumC1158e.GUID, new bh("guid", (byte) 2, new bi((byte) 11)));
        Map<EnumC1158e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bh.a(e.class, mapUnmodifiableMap);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC1158e implements bc {
        VALUE(1, oOOOoo00.OooOo0o),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final Map<String, EnumC1158e> d = new HashMap();
        private final short e;
        private final String f;

        public static EnumC1158e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
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
            for (EnumC1158e enumC1158e : EnumSet.allOf(EnumC1158e.class)) {
                d.put(enumC1158e.b(), enumC1158e);
            }
        }

        public static EnumC1158e b(int i) {
            EnumC1158e enumC1158eA = a(i);
            if (enumC1158eA != null) {
                return enumC1158eA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static EnumC1158e a(String str) {
            return d.get(str);
        }

        EnumC1158e(short s, String str) {
            this.e = s;
            this.f = str;
        }
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC1158e[]{EnumC1158e.VALUE, EnumC1158e.TS, EnumC1158e.GUID};
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC1158e[]{EnumC1158e.VALUE, EnumC1158e.TS, EnumC1158e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f9289a = eVar.f9289a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.f9289a = null;
        b(false);
        this.b = 0L;
        this.c = null;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.l = as.b(this.l, 0);
    }

    public boolean g() {
        return as.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = as.a(this.l, 0, z);
    }

    @Override // com.umeng.analytics.pro.av
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC1158e fieldForId(int i2) {
        return EnumC1158e.a(i2);
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
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f9289a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
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

    /* JADX INFO: compiled from: ImprintValue.java */
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

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class a extends ce<e> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, e eVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                if (bpVarL.b != 0) {
                    short s = bpVarL.c;
                    if (s != 1) {
                        if (s != 2) {
                            if (s == 3) {
                                if (bpVarL.b == 11) {
                                    eVar.c = buVar.z();
                                    eVar.c(true);
                                } else {
                                    bx.a(buVar, bpVarL.b);
                                }
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                        } else if (bpVarL.b == 10) {
                            eVar.b = buVar.x();
                            eVar.b(true);
                        } else {
                            bx.a(buVar, bpVarL.b);
                        }
                    } else if (bpVarL.b == 11) {
                        eVar.f9289a = buVar.z();
                        eVar.a(true);
                    } else {
                        bx.a(buVar, bpVarL.b);
                    }
                    buVar.m();
                } else {
                    buVar.k();
                    eVar.k();
                    return;
                }
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, e eVar) throws bb {
            eVar.k();
            buVar.a(e.f);
            if (eVar.f9289a != null && eVar.d()) {
                buVar.a(e.g);
                buVar.a(eVar.f9289a);
                buVar.c();
            }
            if (eVar.g()) {
                buVar.a(e.h);
                buVar.a(eVar.b);
                buVar.c();
            }
            if (eVar.c != null && eVar.j()) {
                buVar.a(e.i);
                buVar.a(eVar.c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
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

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class c extends cf<e> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            caVar.a(bitSet, 3);
            if (eVar.d()) {
                caVar.a(eVar.f9289a);
            }
            if (eVar.g()) {
                caVar.a(eVar.b);
            }
            if (eVar.j()) {
                caVar.a(eVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet bitSetB = caVar.b(3);
            if (bitSetB.get(0)) {
                eVar.f9289a = caVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.b = caVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.c = caVar.z();
                eVar.c(true);
            }
        }
    }
}
