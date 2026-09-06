package com.ubixnow.ooooo;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ooooO0O0 extends oOO0O000 {
    public static final String OooOo0O = "1.0.0.0";

    public class OooO implements Runnable {
        public OooO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO0O0.this.OooO.OooO00o();
        }
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ JSONObject OooO0O0;

        public OooO00o(String str, JSONObject jSONObject) {
            this.OooO00o = str;
            this.OooO0O0 = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO0O0.this.OooO00o(oOO0O0.TRACK, this.OooO00o, this.OooO0O0);
        }
    }

    public class OooO0O0 implements Runnable {
        public OooO0O0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ooooO0O0.this.OooO.OooO0O0();
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
            }
        }
    }

    public class OooO0OO implements Runnable {
        public OooO0OO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ooooO0O0.this.OooO.OooO0OO();
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
            }
        }
    }

    public class OooO0o implements Runnable {
        public OooO0o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!oOO0O000.OooO0o0.OooO0oo) {
                ooooO0O0.this.OooO0oo.getContentResolver().notifyChange(oOOOoo00.OooOO0O().OooO0o(), null);
            }
            oOO0O000.OooO0o0.OooO0oo = true;
            ooooO0O0.this.OooOOOo.OooO00o(true);
            try {
                List<O0O0> list = ooooO0O0.this.OooOo0;
                if (list != null) {
                    Iterator<O0O0> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().OooO00o("enableDataCollect", null);
                    }
                }
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
            }
        }
    }

    public final class OooOO0 {
        public static final int OooO00o = 0;
        public static final int OooO0O0 = 1;
        public static final int OooO0OO = 2;
        public static final int OooO0Oo = 4;
        public static final int OooO0o = 16;
        public static final int OooO0o0 = 8;
        public static final int OooO0oO = 255;

        public OooOO0() {
        }
    }

    public ooooO0O0() {
    }

    public ooooO0O0(Context context, oOO0OO0O ooo0oo0o) {
        super(context, ooo0oo0o);
    }

    public static ooooO0O0 OooO00o(Context context) {
        if (!oOO0O000.OooOOo() && context != null) {
            Map<Context, ooooO0O0> map = oOO0O000.OooO0OO;
            synchronized (map) {
                ooooO0O0 ooooo0o0 = map.get(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                if (ooooo0o0 != null) {
                    return ooooo0o0;
                }
                oOO0O0O.OooO0O0(oOO0O000.OooO00o, "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
                return new oOO();
            }
        }
        return new oOO();
    }

    private static ooooO0O0 OooO00o(Context context, oOO0OO0O ooo0oo0o) {
        ooooO0O0 ooooo0o0;
        if (context == null) {
            return new oOO();
        }
        Map<Context, ooooO0O0> map = oOO0O000.OooO0OO;
        synchronized (map) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            ooooo0o0 = map.get(origApplicationContext);
            if (ooooo0o0 == null) {
                ooooo0o0 = new ooooO0O0(origApplicationContext, ooo0oo0o);
                map.put(origApplicationContext, ooooo0o0);
            }
        }
        return ooooo0o0;
    }

    public static void OooO0O0(Context context, oOO0OO0O ooo0oo0o) {
        if (context == null || ooo0oo0o == null) {
            throw new NullPointerException("Context、UbixConfigOptions 不可以为 null");
        }
        ooooO0O0 ooooo0o0OooO00o = OooO00o(context, ooo0oo0o);
        if (ooooo0o0OooO00o.OooOO0) {
            return;
        }
        ooooo0o0OooO00o.OooOO0o();
    }

    private static ooooO0O0 OooOo() {
        Map<Context, ooooO0O0> map = oOO0O000.OooO0OO;
        synchronized (map) {
            if (map.size() > 0) {
                Iterator<ooooO0O0> it = map.values().iterator();
                if (it.hasNext()) {
                    return it.next();
                }
            }
            return new oOO();
        }
    }

    public static ooooO0O0 OooOoO() {
        return oOO0O000.OooOOo() ? new oOO() : OooOo();
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public int OooO() {
        return oOO0O000.OooO0o0.OooO0Oo;
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO00o() {
        oOO0OoO0 ooo0ooo0 = this.OooOOo0;
        if (ooo0ooo0 == null || ooo0ooo0.OooO0O0()) {
            this.OooOOo0 = new oOO0OoO0();
            new Thread(this.OooOOo0).start();
            oOO0O0O.OooO0O0(oOO0O000.OooO00o, "Data collection thread has been started");
        }
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO00o(int i) {
        if (i < 0) {
            oOO0O0O.OooO0O0(oOO0O000.OooO00o, "The value of flushBulkSize is invalid");
        }
        oOO0O000.OooO0o0.OooO00o(i);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO00o(long j) {
        try {
            this.OooO.OooO00o(j);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.oOO0O000
    public /* bridge */ /* synthetic */ void OooO00o(O0O0 o0o0) {
        super.OooO00o(o0o0);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO00o(oOOO00 oooo00) {
        this.OooOOoo = oooo00;
    }

    @Override // com.ubixnow.ooooo.oOO0O000
    public /* bridge */ /* synthetic */ void OooO00o(Runnable runnable) {
        super.OooO00o(runnable);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO00o(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                oOO0O000.OooO0o = str;
            } else {
                oOO0O000.OooO0o = str;
                oOO0O0O.OooO0O0(oOO0O000.OooO00o, "Server url is null or empty.");
            }
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.oOO0O000
    public /* bridge */ /* synthetic */ void OooO00o(String str, JSONObject jSONObject) {
        super.OooO00o(str, jSONObject);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO00o(boolean z) {
        oOO0O0O.OooO0OO(z);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    @Deprecated
    public void OooO0O0() {
        try {
            this.OooOOOo.OooO00o(new OooO0o());
            flush();
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0O0(int i) {
        oOO0O000.OooO0o0.OooO0O0(i);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0O0(long j) {
        oOO0O000.OooO0o0.OooO00o(j);
    }

    @Override // com.ubixnow.ooooo.oOO0O000
    public /* bridge */ /* synthetic */ void OooO0O0(O0O0 o0o0) {
        super.OooO0O0(o0o0);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0O0(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("md_event", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OooO0O0("SDKEvent", jSONObject);
    }

    public void OooO0O0(String str, JSONObject jSONObject) {
        try {
            this.OooOOOo.OooO00o(new OooO00o(str, jSONObject));
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0O0(boolean z) {
        this.OooOO0o = z;
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public long OooO0OO() {
        return oOO0O000.OooO0o0.OooO0oO;
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0OO(int i) {
        oOO0O000.OooO0o0.OooO0OO(i);
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0Oo() {
        flush();
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0o() {
        oOO0OoO0 ooo0ooo0 = this.OooOOo0;
        if (ooo0ooo0 == null || ooo0ooo0.OooO0O0()) {
            return;
        }
        this.OooOOo0.OooO0OO();
        oOO0O0O.OooO0O0(oOO0O000.OooO00o, "Data collection thread has been stopped");
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooO0o0() {
        this.OooOOOo.OooO00o(new OooO());
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public String OooO0oO() {
        return oOO0O000.OooO0o;
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public boolean OooO0oo() {
        return this.OooOO0o;
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void OooOO0() {
        try {
            this.OooO.OooO00o(-1L);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public int OooOO0O() {
        return oOO0O000.OooO0o0.OooO0OO;
    }

    @Override // com.ubixnow.ooooo.oOO0O000
    public /* bridge */ /* synthetic */ Context OooOOO() {
        return super.OooOOO();
    }

    @Override // com.ubixnow.ooooo.oOO0O000
    public /* bridge */ /* synthetic */ d OooOOOO() {
        return super.OooOOOO();
    }

    @Override // com.ubixnow.ooooo.oOO0O000
    public /* bridge */ /* synthetic */ boolean OooOOOo() {
        return super.OooOOOo();
    }

    public void OooOo0O() {
        this.OooOOOo.OooO00o(new OooO0OO());
    }

    public int OooOo0o() {
        return oOO0O000.OooO0o0.OooOO0;
    }

    public String OooOoO0() {
        return OooOo0O;
    }

    @Override // com.ubixnow.ooooo.oOO0O0O0
    public void flush() {
        this.OooOOOo.OooO00o(new OooO0O0());
    }
}
