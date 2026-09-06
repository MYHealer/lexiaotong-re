package com.byazt.yf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 66})
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f2885a;
    public boolean c;
    public String i;
    public int[] n;
    public String sp;
    public int tt;
    public boolean uj;
    public boolean ve;
    public Map<String, String> x;

    /* JADX INFO: renamed from: com.byazt.yf.t$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 167})
    static /* synthetic */ class AnonymousClass1 {
    }

    public String[] a() {
        return this.f2885a;
    }

    public boolean c() {
        return this.c;
    }

    public String i() {
        return this.i;
    }

    public int[] n() {
        return this.n;
    }

    public String sp() {
        return this.sp;
    }

    public int tt() {
        return this.tt;
    }

    public boolean uj() {
        return this.uj;
    }

    public boolean ve() {
        return this.ve;
    }

    public Map<String, String> x() {
        return this.x;
    }

    public /* synthetic */ t(c cVar, AnonymousClass1 anonymousClass1) {
        this(cVar);
    }

    private t(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f2885a = cVar.f2886a;
        this.sp = cVar.sp;
        this.x = cVar.x;
        this.i = cVar.i;
    }

    @com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, AppTypeIdUtil.NewDevice4GDrinkOTA_2})
    public static class c {
        public boolean c = false;
        public int tt = 0;
        public boolean ve = true;
        public boolean uj = false;
        public int[] n = {4, 3, 5};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f2886a = new String[0];
        public String sp = "";
        public final Map<String, String> x = new HashMap();
        public String i = "";

        public c c(int i) {
            this.tt = i;
            return this;
        }

        public c c(String str) {
            this.sp = str;
            return this;
        }

        public c c(boolean z) {
            this.c = z;
            return this;
        }

        public c c(int... iArr) {
            this.n = iArr;
            return this;
        }

        public c tt(String str) {
            this.i = str;
            return this;
        }

        public c tt(boolean z) {
            this.ve = z;
            return this;
        }

        public c c(Map<String, String> map) {
            this.x.putAll(map);
            return this;
        }

        public t c() {
            return new t(this, null);
        }
    }
}
