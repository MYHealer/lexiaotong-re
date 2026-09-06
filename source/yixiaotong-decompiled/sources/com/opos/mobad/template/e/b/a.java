package com.opos.mobad.template.e.b;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static int c = 100;
    public static int d = 2;
    public static int e = 1000;
    public static int f = 5000;
    public static int g = 10;
    public static int h = 1000;
    public static int i = 10;
    public static int j = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.mobad.template.e.a f7547a;
    public final String b;

    /* JADX INFO: renamed from: com.opos.mobad.template.e.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7548a;

        static {
            int[] iArr = new int[com.opos.mobad.template.e.a.values().length];
            f7548a = iArr;
            try {
                iArr[com.opos.mobad.template.e.a.SHAKE_AND_UP_SLIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7548a[com.opos.mobad.template.e.a.SHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7548a[com.opos.mobad.template.e.a.TILT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7548a[com.opos.mobad.template.e.a.FORWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7548a[com.opos.mobad.template.e.a.UP_SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7548a[com.opos.mobad.template.e.a.FULLSCREEN_SLIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7548a[com.opos.mobad.template.e.a.SLIDE_LAYER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(com.opos.mobad.template.d.b bVar) {
        String str;
        if (bVar == null) {
            this.f7547a = com.opos.mobad.template.e.a.UNKNOWN;
            str = "";
        } else {
            this.f7547a = bVar.L;
            str = bVar.j;
        }
        this.b = str;
    }

    public static a a(com.opos.mobad.template.d.b bVar) {
        if (bVar == null) {
            return new a(bVar);
        }
        switch (AnonymousClass1.f7548a[bVar.L.ordinal()]) {
            case 1:
                return new d(bVar);
            case 2:
                return new e(bVar);
            case 3:
                return new g(bVar);
            case 4:
                return new b(bVar);
            case 5:
                return new h(bVar);
            case 6:
                return new c(bVar);
            case 7:
                return new f(bVar);
            default:
                return new a(bVar);
        }
    }

    protected String a(com.opos.mobad.template.d.b bVar, String str) {
        if (bVar != null && bVar.J != null) {
            try {
                Map<String, String> map = bVar.J;
                if (map.containsKey(str)) {
                    return map.get(str);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("BaseInteractiveInfo", "getValueSafe", e2);
            }
        }
        return null;
    }
}
