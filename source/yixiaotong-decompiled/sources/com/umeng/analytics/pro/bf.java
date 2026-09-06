package com.umeng.analytics.pro;

import com.huawei.openalliance.ad.views.PPSLabelView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bf;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TUnion.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class bf<T extends bf<?, ?>, F extends bc> implements av<T, F> {
    private static final Map<Class<? extends cc>, cd> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f9115a;
    protected F b;

    /* JADX INFO: renamed from: com.umeng.analytics.pro.bf$1, reason: invalid class name */
    /* JADX INFO: compiled from: TUnion.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    public F a() {
        return this.b;
    }

    protected abstract F a(short s);

    protected abstract Object a(bu buVar, bp bpVar) throws bb;

    protected abstract Object a(bu buVar, short s) throws bb;

    protected abstract void a(bu buVar) throws bb;

    public Object b() {
        return this.f9115a;
    }

    protected abstract void b(F f, Object obj) throws ClassCastException;

    protected abstract void b(bu buVar) throws bb;

    public boolean b(F f) {
        return this.b == f;
    }

    protected abstract bp c(F f);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.av
    public final void clear() {
        this.b = null;
        this.f9115a = null;
    }

    protected abstract bz d();

    protected bf() {
        this.b = null;
        this.f9115a = null;
    }

    static {
        HashMap map = new HashMap();
        c = map;
        AnonymousClass1 anonymousClass1 = null;
        map.put(ce.class, new b(anonymousClass1));
        map.put(cf.class, new d(anonymousClass1));
    }

    protected bf(F f, Object obj) {
        a(f, obj);
    }

    protected bf(bf<T, F> bfVar) {
        if (!bfVar.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.b = bfVar.b;
        this.f9115a = a(bfVar.f9115a);
    }

    private static Object a(Object obj) {
        if (obj instanceof av) {
            return ((av) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return aw.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public Object a(F f) {
        if (f != this.b) {
            throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
        }
        return b();
    }

    public Object a(int i) {
        return a(a((short) i));
    }

    public boolean b(int i) {
        return b(a((short) i));
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        c.get(buVar.D()).b().b(buVar, this);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.f9115a = obj;
    }

    public void a(int i, Object obj) {
        a(a((short) i), obj);
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        c.get(buVar.D()).b().a(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getClass().getSimpleName());
        sb.append(PPSLabelView.Code);
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).f9128a);
            sb.append(com.huawei.openalliance.ad.constant.x.bQ);
            if (objB instanceof ByteBuffer) {
                aw.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    /* JADX INFO: compiled from: TUnion.java */
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

    /* JADX INFO: compiled from: TUnion.java */
    private static class a extends ce<bf> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.f9115a = null;
            buVar.j();
            bp bpVarL = buVar.l();
            bfVar.f9115a = bfVar.a(buVar, bpVarL);
            if (bfVar.f9115a != null) {
                bfVar.b = (F) bfVar.a(bpVarL.c);
            }
            buVar.m();
            buVar.l();
            buVar.k();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.d());
            buVar.a(bfVar.c(bfVar.b));
            bfVar.a(buVar);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
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

    /* JADX INFO: compiled from: TUnion.java */
    private static class c extends cf<bf> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.f9115a = null;
            short sV = buVar.v();
            bfVar.f9115a = bfVar.a(buVar, sV);
            if (bfVar.f9115a != null) {
                bfVar.b = (F) bfVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.b.a());
            bfVar.b(buVar);
        }
    }
}
