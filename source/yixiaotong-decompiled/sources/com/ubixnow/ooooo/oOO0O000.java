package com.ubixnow.ooooo;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class oOO0O000 implements oOO0O0O0 {
    public static final String OooO00o = "---埋点";
    public static final String OooO0O0 = null;
    public static String OooO0o;
    public static oOO0OO0O OooO0o0;
    public oOO0O00O OooO;
    public Context OooO0oo;
    public boolean OooOO0;
    public d OooOO0O;
    public boolean OooOO0o;
    public boolean OooOOO;
    public boolean OooOOO0;
    public boolean OooOOOO;
    public oOO0Oo00 OooOOOo;
    public SimpleDateFormat OooOOo;
    public oOO0OoO0 OooOOo0;
    public oOOO00 OooOOoo;
    public List<O0O0> OooOo0;
    public List<O0000000> OooOo00;
    public static final Map<Context, ooooO0O0> OooO0OO = new HashMap();
    public static boolean OooO0Oo = false;
    public static boolean OooO0oO = false;

    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.OooO0OO(oOO0O000.this.OooO0oo);
        }
    }

    public class OooO0O0 implements Runnable {
        public OooO0O0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.OooO0Oo(oOO0O000.this.OooO0oo);
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ Runnable OooO00o;

        public OooO0OO(Runnable runnable) {
            this.OooO00o = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            oOO0O000.this.OooOOOo.OooO0O0(this.OooO00o);
        }
    }

    public oOO0O000() {
        this.OooOO0o = true;
        this.OooOOO0 = false;
        this.OooOOO = false;
        this.OooOOOO = false;
        this.OooO0oo = null;
        this.OooO = null;
    }

    public oOO0O000(Context context, oOO0OO0O ooo0oo0o) {
        this.OooOO0o = true;
        this.OooOOO0 = false;
        this.OooOOO = false;
        this.OooOOOO = false;
        this.OooO0oo = context;
        try {
            String str = context.getPackageName() + ".mediation.now";
            OooO0o0 = ooo0oo0o.clone();
            this.OooOOOo = oOO0Oo00.OooO00o();
            this.OooOOo0 = new oOO0OoO0();
            new Thread(this.OooOOo0, oOO0OOO.OooO00o).start();
            oOOO000o.OooO0O0();
            OooO00o(OooO0o0.OooO00o, str);
            this.OooOO0O = new d(this.OooO0oo, this.OooOOOO);
            this.OooO = oOO0O00O.OooO00o(this.OooO0oo, (ooooO0O0) this);
            OooOOoo();
            oOO0O0O.OooO00o();
        } catch (Throwable th) {
            oOO0O0O.OooO00o(OooO00o, th.getMessage());
        }
    }

    private void OooO0O0(oOO0O0 ooo0o0, String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(str, jSONObject);
        this.OooO.OooO00o(ooo0o0.OooO00o(), jSONObject2);
    }

    public static oOO0OO0O OooOOO0() {
        return OooO0o0;
    }

    public static boolean OooOOo() {
        return OooOOo0();
    }

    private static boolean OooOOo0() {
        oOO0OO0O ooo0oo0o = OooO0o0;
        if (ooo0oo0o != null) {
            return ooo0oo0o.OooOO0O;
        }
        oOO0O0O.OooO0O0(OooO00o, "SAConfigOptions is null");
        return true;
    }

    private void OooOo00() {
    }

    public void OooO00o(O0O0 o0o0) {
        try {
            if (this.OooOo0 == null) {
                this.OooOo0 = new ArrayList();
            }
            if (o0o0 == null || this.OooOo0.contains(o0o0)) {
                return;
            }
            this.OooOo0.add(o0o0);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO00o(oOO0O0 ooo0o0, String str, JSONObject jSONObject) {
        try {
            OooO0O0(ooo0o0, str, jSONObject);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO00o(Runnable runnable) {
        if (OooO0o0.OooO0oo) {
            this.OooOOOo.OooO00o(runnable);
        } else {
            this.OooOOOo.OooO00o(new OooO0OO(runnable));
        }
    }

    public void OooO00o(String str, String str2) {
        if (OooO0o0 == null) {
            this.OooOO0 = false;
            OooO0o0 = new oOO0OO0O(str);
        } else {
            this.OooOO0 = true;
        }
        oOOO0OOO.OooO00o(this.OooO0oo, str2);
        this.OooOOOo.OooO00o(OooO0o0.OooO0oo);
        oOO0OO0O ooo0oo0o = OooO0o0;
        if (ooo0oo0o.OooOO0o) {
            OooO00o(ooo0oo0o.OooO);
        }
        oOO0O0O.OooO0O0(OooO0o0.OooOO0O);
        OooO00o(str);
        if (OooO0o0.OooO0O0) {
            oOOO000o.OooO00o();
        }
        oOO0OO0O ooo0oo0o2 = OooO0o0;
        if (ooo0oo0o2.OooO0oO == 0) {
            ooo0oo0o2.OooO00o(33554432L);
        }
        if (OooO0o0.OooOO0O) {
            this.OooOO0o = false;
            OooO0oO = true;
        }
    }

    public void OooO00o(String str, JSONObject jSONObject) {
        OooO00o(oOO0O0.TRACK, str, jSONObject);
    }

    public void OooO0O0(O0O0 o0o0) {
        try {
            List<O0O0> list = this.OooOo0;
            if (list == null || o0o0 == null) {
                return;
            }
            list.remove(o0o0);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooOO0o() {
        if (OooO0o0.OooO0O0) {
            oOOO000o.OooO00o();
        }
        oOO0OO0O ooo0oo0o = OooO0o0;
        if (ooo0oo0o.OooOO0o) {
            OooO00o(ooo0oo0o.OooO);
        }
    }

    public Context OooOOO() {
        return this.OooO0oo;
    }

    public d OooOOOO() {
        return this.OooOO0O;
    }

    public boolean OooOOOo() {
        return this.OooOOO;
    }

    public void OooOOoo() {
        this.OooOOOo.OooO00o(new OooO00o());
    }

    public void OooOo0() {
        this.OooOOOo.OooO00o(new OooO0O0());
    }
}
