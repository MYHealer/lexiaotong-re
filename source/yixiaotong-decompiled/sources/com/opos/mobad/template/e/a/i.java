package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i f7545a;

    /* JADX INFO: renamed from: com.opos.mobad.template.e.a.i$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7546a;

        static {
            int[] iArr = new int[com.opos.mobad.template.e.a.values().length];
            f7546a = iArr;
            try {
                iArr[com.opos.mobad.template.e.a.SHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7546a[com.opos.mobad.template.e.a.FORWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7546a[com.opos.mobad.template.e.a.TILT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7546a[com.opos.mobad.template.e.a.UP_SLIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7546a[com.opos.mobad.template.e.a.FULLSCREEN_SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7546a[com.opos.mobad.template.e.a.SHAKE_AND_UP_SLIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7546a[com.opos.mobad.template.e.a.SLIDE_LAYER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private i() {
    }

    private a a(com.opos.mobad.template.e.a aVar) {
        switch (AnonymousClass1.f7546a[aVar.ordinal()]) {
            case 1:
                return e.a();
            case 2:
                return b.a();
            case 3:
                return g.a();
            case 4:
                return h.a();
            case 5:
                return c.a();
            case 6:
                return d.a();
            case 7:
                return f.a();
            default:
                return null;
        }
    }

    public static i a() {
        if (f7545a == null) {
            synchronized (i.class) {
                if (f7545a == null) {
                    f7545a = new i();
                }
            }
        }
        return f7545a;
    }

    public com.opos.mobad.template.e.c.a a(Context context, int i, com.opos.mobad.template.e.a aVar) {
        a aVarA = a(aVar);
        if (aVarA != null) {
            return aVarA.a(context, i);
        }
        return null;
    }
}
