package com.byazt.yf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f2883a;
    public String c;
    public Map<String, Object> da;
    public a i;
    public boolean n;
    public boolean sl;
    public x sp;
    public JSONObject t;
    public String tt;
    public Map<String, Object> u;
    public String uj;
    public boolean ve;
    public uj x;
    public PluginValueSet yp;
    public boolean z;

    /* JADX INFO: renamed from: com.byazt.yf.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    public t a() {
        return this.f2883a;
    }

    public String c() {
        return this.c;
    }

    public Map<String, Object> da() {
        return this.da;
    }

    public a i() {
        return this.i;
    }

    public boolean n() {
        return this.n;
    }

    public boolean sl() {
        return this.sl;
    }

    public x sp() {
        return this.sp;
    }

    public JSONObject t() {
        return this.t;
    }

    public String tt() {
        return this.tt;
    }

    public Map<String, Object> u() {
        return this.u;
    }

    public String uj() {
        return this.uj;
    }

    public boolean ve() {
        return this.ve;
    }

    public uj x() {
        return this.x;
    }

    public PluginValueSet yp() {
        return this.yp;
    }

    public boolean z() {
        return this.z;
    }

    public /* synthetic */ c(C0332c c0332c, AnonymousClass1 anonymousClass1) {
        this(c0332c);
    }

    private c(C0332c c0332c) {
        this.c = c0332c.c;
        this.tt = c0332c.tt;
        this.ve = c0332c.ve;
        this.uj = c0332c.uj;
        this.n = c0332c.n;
        if (c0332c.f2884a == null) {
            this.f2883a = new t.c().c();
        } else {
            this.f2883a = c0332c.f2884a;
        }
        if (c0332c.sp == null) {
            this.sp = new x.c().c();
        } else {
            this.sp = c0332c.sp;
        }
        if (c0332c.x == null) {
            this.x = new uj.c().c();
        } else {
            this.x = c0332c.x;
        }
        if (c0332c.i == null) {
            this.i = new a();
        } else {
            this.i = c0332c.i;
        }
        this.da = c0332c.da;
        this.sl = c0332c.sl;
        this.t = c0332c.t;
        this.u = c0332c.u;
        this.yp = c0332c.yp;
        this.z = c0332c.z;
    }

    /* JADX INFO: renamed from: com.byazt.yf.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 44})
    public static class C0332c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t f2884a;
        public String c;
        public Map<String, Object> da;
        public a i;
        public x sp;
        public JSONObject t;
        public String tt;
        public Map<String, Object> u;
        public uj x;
        public PluginValueSet yp;
        public boolean z;
        public boolean ve = false;
        public String uj = "";
        public boolean n = false;
        public boolean sl = false;

        public C0332c c(a aVar) {
            this.i = aVar;
            return this;
        }

        public C0332c c(t tVar) {
            this.f2884a = tVar;
            return this;
        }

        public C0332c c(x xVar) {
            this.sp = xVar;
            return this;
        }

        public C0332c c(PluginValueSet pluginValueSet) {
            this.yp = pluginValueSet;
            return this;
        }

        public C0332c c(String str) {
            this.c = str;
            return this;
        }

        public C0332c c(JSONObject jSONObject) {
            this.t = jSONObject;
            return this;
        }

        public C0332c c(boolean z) {
            this.ve = z;
            return this;
        }

        public C0332c tt(String str) {
            this.tt = str;
            return this;
        }

        public C0332c tt(boolean z) {
            this.n = z;
            return this;
        }

        public C0332c uj(boolean z) {
            this.z = z;
            return this;
        }

        public C0332c ve(String str) {
            this.uj = str;
            return this;
        }

        public C0332c ve(boolean z) {
            this.sl = z;
            return this;
        }

        public C0332c c(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                if (this.da == null) {
                    this.da = new HashMap();
                }
                this.da.putAll(map);
            }
            return this;
        }

        public c c() {
            return new c(this, null);
        }
    }
}
