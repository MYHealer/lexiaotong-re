package com.byazt.ete;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 350})
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2191a;
    public boolean c;
    public String n;
    public ir tt;
    public int uj;
    public c ve;

    public p(JSONObject jSONObject) {
        this.c = false;
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (jSONObjectOptJSONObject != null) {
            this.tt = new ir(jSONObjectOptJSONObject.optJSONObject("components"), 1);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("easy_playable");
        if (jSONObjectOptJSONObject2 != null) {
            this.ve = new c(jSONObjectOptJSONObject2.optJSONObject("components"), 2);
        }
        this.uj = jSONObject.optInt("style_category");
        this.n = jSONObject.optString("exp_id");
        this.f2191a = jSONObject.optString("group_id");
    }

    public static boolean c(ic icVar) {
        return tt(icVar) || ve(icVar);
    }

    public static boolean tt(ic icVar) {
        p pVarVt;
        ir irVar;
        return (icVar == null || (pVarVt = icVar.vt()) == null || (irVar = pVarVt.tt) == null || !irVar.t()) ? false : true;
    }

    public static boolean ve(ic icVar) {
        p pVarVt;
        c cVar;
        return (icVar == null || (pVarVt = icVar.vt()) == null || !pVarVt.c || (cVar = pVarVt.ve) == null || !cVar.a()) ? false : true;
    }

    public static int uj(ic icVar) {
        if (icVar == null) {
            return 0;
        }
        return icVar.vt().uj;
    }

    public static String n(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.vt().n;
    }

    public static String a(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.vt().f2191a;
    }

    public static boolean c() {
        return (com.byazt.omf.p.uj >= 6322 && com.byazt.omf.p.uj < 6400) || com.byazt.omf.p.uj >= 6406;
    }

    public static c sp(ic icVar) {
        p pVarVt;
        if (icVar == null || (pVarVt = icVar.vt()) == null) {
            return null;
        }
        return pVarVt.ve;
    }

    public static ir x(ic icVar) {
        p pVarVt;
        if (icVar == null || (pVarVt = icVar.vt()) == null) {
            return null;
        }
        return pVarVt.tt;
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 2191})
    public static class c extends u {
        public C0144c tt;
        public C0144c ve;

        @Override // com.byazt.ete.u
        public String n() {
            return "";
        }

        @Override // com.byazt.ete.u
        public int ve() {
            return 0;
        }

        public c(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                return;
            }
            this.tt = new C0144c(jSONObject.optJSONObject("vertical"));
            this.ve = new C0144c(jSONObject.optJSONObject("horizontal"));
            this.c = i;
        }

        public boolean a() {
            C0144c c0144c = this.ve;
            if (c0144c != null && c0144c.c()) {
                return true;
            }
            C0144c c0144c2 = this.tt;
            return c0144c2 != null && c0144c2.c();
        }

        public String c(boolean z) {
            C0144c c0144c;
            if (z && (c0144c = this.tt) != null && c0144c.c()) {
                return this.tt.c;
            }
            C0144c c0144c2 = this.ve;
            if (c0144c2 != null && c0144c2.c()) {
                return this.ve.c;
            }
            C0144c c0144c3 = this.tt;
            return (c0144c3 == null || !c0144c3.c()) ? "" : this.tt.c;
        }

        @Override // com.byazt.ete.u
        public int uj() {
            C0144c c0144c = this.tt;
            if (c0144c != null) {
                return c0144c.tt;
            }
            C0144c c0144c2 = this.ve;
            if (c0144c2 != null) {
                return c0144c2.tt;
            }
            return 0;
        }

        /* JADX INFO: renamed from: com.byazt.ete.p$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 8, 2291})
        public static class C0144c {
            public String c;
            public int tt;

            public C0144c(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.c = jSONObject.optString("entry");
                this.tt = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean c() {
                return !TextUtils.isEmpty(this.c);
            }
        }
    }
}
