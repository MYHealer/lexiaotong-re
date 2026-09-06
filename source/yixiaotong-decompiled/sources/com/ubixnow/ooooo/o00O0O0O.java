package com.ubixnow.ooooo;

import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00O0O0O {
    public long OooO00o;
    public boolean OooO0O0;
    public int OooO0OO;
    public o00O000 OooO0Oo;

    public List getActivityStatus() {
        return null;
    }

    public void getAdsMap(HashMap<String, String> map, o00O000 o00o000) {
        map.put(o0OO000o.oooo00o, o00o000.OooO00o.OooO0OO + "");
        map.put(o0OO000o.o000o0O, o00o000.OooO00o.OooO0o0);
        map.put(o0OO000o.o000ooo0, getVersion());
        if (o00o000.OooO > 0) {
            map.put(o0OO000o.o000oo0, o00o000.OooO + "");
        }
        map.put(o0OO000o.o000o0o, o00o000.OooO00o.OooOO0O + "");
    }

    public List getMetaValutStatus() {
        return null;
    }

    public String getNetworkSDKClass() {
        return "";
    }

    public List getProviderStatus() {
        return null;
    }

    public List getServiceStatus() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public void initSDK(Context context, o00O000 o00o000) {
        this.OooO0Oo = o00o000;
    }

    public void initSDK(Context context, o00O000 o00o000, o00O0OO0 o00o0oo0) {
        this.OooO0Oo = o00o000;
    }

    public boolean isNeedInit(o00O000 o00o000) {
        oOO00O ooo00o;
        return (!this.OooO0O0 || ((ooo00o = o00o000.OooOOO0) != null && ooo00o.OooOooo == oO00000o.o00O0O.OooOOO0)) && o00o000.OooOOO0.OooOooo != 0;
    }

    public synchronized void trackRedirectStart() {
        o00O000 o00o000 = this.OooO0Oo;
        if (o00o000.OooO0Oo == 2) {
            return;
        }
        oo0oO0 oo0oo0 = o00o000.OooOO0o;
        ooooO000.OooO0O0(o0oOO.OooO00o, "----trackRedirectStart ");
        oo0oo0.OooOo.OooO0o0.put(this.OooO0Oo.OooO00o.OooO0Oo + this.OooO0Oo.OooO00o.OooO0o0, Long.valueOf(SystemClock.elapsedRealtime()));
        HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o00Ooo);
        getAdsMap(mapOooO00o, this.OooO0Oo);
        mapOooO00o.put("duration", (System.currentTimeMillis() - oo0oo0.OooOo.OooO0O0) + "");
        if (this.OooO0Oo.OooO00o.OooOO0O == 0) {
            mapOooO00o.put(o0OO000o.o000o0Oo, this.OooO0Oo.OooO00o.OooOOO + "");
        }
        o0OO000.OooO00o(o0OO000o.o00Oo0, mapOooO00o, new Object[0]);
    }

    public synchronized void trackRedirectStart(o00O000 o00o000) {
        if (o00o000.OooO0Oo == 2) {
            return;
        }
        oo0oO0 oo0oo0 = o00o000.OooOO0o;
        ooooO000.OooO0O0(o0oOO.OooO00o, "----trackRedirectStart mBaseAdConfig ");
        oo0oo0.OooOo.OooO0o0.put(o00o000.OooO00o.OooO0Oo + o00o000.OooO00o.OooO0o0, Long.valueOf(SystemClock.elapsedRealtime()));
        HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o00Ooo);
        getAdsMap(mapOooO00o, o00o000);
        mapOooO00o.put("duration", (System.currentTimeMillis() - oo0oo0.OooOo.OooO0O0) + "");
        if (o00o000.OooO00o.OooOO0O == 0) {
            mapOooO00o.put(o0OO000o.o000o0Oo, o00o000.OooO00o.OooOOO + "");
        }
        o0OO000.OooO00o(o0OO000o.o00Oo0, mapOooO00o, new Object[0]);
    }

    public void trackSdkInitStart(o00O000 o00o000) {
        this.OooO00o = System.currentTimeMillis();
        HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o000.OooOO0o, o0OO000o.Oooooo0);
        getAdsMap(mapOooO00o, o00o000);
        o0OO000.OooO00o(o0OO000o.OooooOo, mapOooO00o, new Object[0]);
    }

    public void trackingAdsInitFail(o00O000 o00o000, String str, String str2) {
        StringBuilder sbAppend;
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o000.OooOO0o, o0OO000o.o0OoOo0);
            getAdsMap(mapOooO00o, o00o000);
            mapOooO00o.put(o0OO000o.o000oo0o, o0OO000o.ooOO);
            mapOooO00o.put(o0OO000o.o000o0oo, "500041");
            new JSONObject();
            if ("-1".equals(str)) {
                mapOooO00o.put(o0OO000o.o000ooO, "-1");
                sbAppend = new StringBuilder().append(str2);
            } else {
                mapOooO00o.put(o0OO000o.o000ooO, str);
                sbAppend = new StringBuilder().append(str2);
            }
            mapOooO00o.put(o0OO000o.o000ooOO, sbAppend.append("").toString());
            o0OO000.OooO00o(o0OO000o.Ooooooo, mapOooO00o, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void trackingAdsInitSucc(o00O000 o00o000) {
        HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o000.OooOO0o, o0OO000o.OoooooO);
        getAdsMap(mapOooO00o, o00o000);
        mapOooO00o.put("duration", (System.currentTimeMillis() - this.OooO00o) + "");
        o0OO000.OooO00o(o0OO000o.Oooooo, mapOooO00o, new Object[0]);
    }
}
