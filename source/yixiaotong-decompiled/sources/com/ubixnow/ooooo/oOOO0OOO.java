package com.ubixnow.ooooo;

import android.content.Context;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOOO0OOO {
    private static oOOO0OOO OooO00o;
    private final oOOOoo00 OooO0O0;
    private oOOO0OO0 OooO0OO;

    private oOOO0OOO(Context context, String str) {
        this.OooO0O0 = oOOOoo00.OooO00o(str);
        this.OooO0OO = new oOOOOo0O(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static oOOO0OOO OooO00o(Context context, String str) {
        if (OooO00o == null) {
            OooO00o = new oOOO0OOO(context, str);
        }
        return OooO00o;
    }

    public static oOOO0OOO OooO0O0() {
        oOOO0OOO oooo0ooo = OooO00o;
        if (oooo0ooo != null) {
            return oooo0ooo;
        }
        throw new IllegalStateException("The static method getInstance(Context context, String packageName) should be called before calling getInstance()");
    }

    public int OooO00o(String str) {
        this.OooO0OO.OooO00o(this.OooO0O0.OooO(), str);
        return this.OooO0OO.OooO0O0(this.OooO0O0.OooO());
    }

    public int OooO00o(JSONObject jSONObject) {
        int iOooO00o = this.OooO0OO.OooO00o(this.OooO0O0.OooO(), jSONObject);
        return iOooO00o == 0 ? this.OooO0OO.OooO0O0(this.OooO0O0.OooO()) : iOooO00o;
    }

    public void OooO00o() {
        this.OooO0OO.OooO00o(this.OooO0O0.OooO(), oOOOoo00.OooOoO);
    }

    public String[] OooO00o(String str, int i) {
        try {
            return this.OooO0OO.OooO00o(this.OooO0O0.OooO(), i);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return null;
        }
    }

    public int OooO0OO() {
        return this.OooO0OO.OooO0O0(this.OooO0O0.OooO());
    }
}
