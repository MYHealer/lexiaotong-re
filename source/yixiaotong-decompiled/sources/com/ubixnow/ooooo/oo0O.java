package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oo0O {
    public static String OooO00o = "a1";

    private static o00OOO0 OooO00o(oo00o oo00oVar) {
        o0O0o0 o0o0o0 = oo00oVar.material;
        if (o0o0o0 == null || o0o0o0.OooO0O0 == null) {
            return null;
        }
        o00OOO0 o00ooo0 = new o00OOO0();
        o00ooo0.OooO00o = oo00oVar.material.OooO0O0.OooOO0();
        o00ooo0.OooO0O0 = oo00oVar.material.OooO0O0.OooOO0O();
        for (oo0OOoo oo0oooo : oo00oVar.material.OooO0O0.OooO0OO) {
            o00ooo0.OooO00o(oo0oooo.OooO0o0());
            o00ooo0.OooO00o(oo0oooo.OooO0oO());
        }
        return o00ooo0;
    }

    public static void OooO00o(o00O0 o00o0, o00OOO0O o00ooo0o, ConcurrentHashMap<String, o00OOO0O> concurrentHashMap, o00OO0OO o00oo0oo) {
        if (o00ooo0o == null || o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o.OooOOo0 != 2) {
            if ("a1".equals(OooO00o)) {
                OooO00o = ooooO000.OooO0OO(OooO00o);
            }
            o00O o00o = o00ooo0o.OooO0O0;
            o00O000 o00o000 = o00o.mBaseAdConfig;
            o00oo0oo.OooO0O0 = o00o000.OooO;
            o00OO o00oo = o00oo0oo.OooO0Oo;
            o00oo.OooO0O0 = o00o000.OooO00o.OooO0OO;
            o00oo.OooO00o = o00ooo0o.OooO00o;
            o00oo.OooO0OO = OooO00o(o00o.getUbixInfo());
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                OooO00o(o00o0, concurrentHashMap, o00oo0oo);
            }
            if (OooO00o(o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o.OooOOO0, true)) {
                oO0O0OoO oo0o0ooo = o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o;
                if (oo0o0ooo.OooO0OO == 6 || oo0o0ooo.OooOO0O == 1) {
                    ooooO000.OooO00o(OooO00o, ooooO000.OooO0OO("a3") + o00ooo0o.OooO0O0.mBaseAdConfig.OooO0o + ooooO000.OooO0OO("a4") + o00ooo0o.OooO0O0.mBaseAdConfig.OooO0OO + ooooO000.OooO0OO("a5") + o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o.OooO0OO + "【ads_slot_id】:" + o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o.OooO0o0 + ";【ad_slotId】:" + o00ooo0o.OooO0O0.mBaseAdConfig.OooO0O0);
                    o00ooo0o.OooO0O0.biddingWin(o00oo0oo);
                }
            }
        }
    }

    private static void OooO00o(o00O0 o00o0, ConcurrentHashMap<String, o00OOO0O> concurrentHashMap, o00OO0OO o00oo0oo) {
        try {
            if ("a1".equals(OooO00o)) {
                OooO00o = ooooO000.OooO0OO(OooO00o);
            }
            Iterator<Map.Entry<String, o00OOO0O>> it = concurrentHashMap.entrySet().iterator();
            String key = "";
            long j = 0;
            while (it.hasNext()) {
                Map.Entry<String, o00OOO0O> next = it.next();
                if (j < next.getValue().OooO00o || j == next.getValue().OooO00o) {
                    long j2 = next.getValue().OooO00o;
                    long j3 = j2;
                    key = next.getKey();
                    j = j3;
                }
                if (OooO00o(next.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooOOO0, false) && (next.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooO0OO == 3 || next.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooO0OO == 6 || next.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooOO0O == 1)) {
                    ooooO000.OooO00o(OooO00o, ooooO000.OooO0OO("a2") + next.getValue().OooO0O0.mBaseAdConfig.OooO0o + "【waterfall失败价格：】:" + next.getValue().OooO0O0.mBaseAdConfig.OooO0OO + "【广告平台：】" + next.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooO0OO + "【ads_slot_id】:" + next.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooO0o0 + ";【ad_slotId】:" + next.getValue().OooO0O0.mBaseAdConfig.OooO0O0);
                    next.getValue().OooO0O0.biddingLoss(o00oo0oo, o00o0.OooO00o);
                    if (next.getValue().OooO0O0.feedBackEventListener != null) {
                        o00o0.OooOOoo.add(next.getValue().OooO0O0.feedBackEventListener);
                    }
                }
            }
            o00OOO0O o00ooo0o = concurrentHashMap.get(key);
            if (o00ooo0o != null) {
                o00OO o00oo = o00oo0oo.OooO0o0;
                o00oo.OooO00o = o00ooo0o.OooO00o;
                o00oo.OooO0O0 = o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o.OooO0OO;
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public static void OooO00o(o00O o00o, long j, o00O0 o00o0) {
        if ("a1".equals(OooO00o)) {
            OooO00o = ooooO000.OooO0OO(OooO00o);
        }
        if (o00o == null || o00o.mBaseAdConfig.OooO00o.OooOO0O != 1) {
            return;
        }
        o00OO0OO o00oo0oo = new o00OO0OO();
        o00oo0oo.OooO00o = true;
        o00oo0oo.OooO0O0 = j;
        ooooO000.OooO00o(OooO00o, ooooO000.OooO0OO("a6") + o00o.mBaseAdConfig.OooO0o + ooooO000.OooO0OO("a5") + o00o.mBaseAdConfig.OooO00o.OooO0OO + "【ads_slot_id】:" + o00o.mBaseAdConfig.OooO00o.OooO0o0 + ";【ad_slotId】:" + o00o.mBaseAdConfig.OooO0O0);
        o00o.biddingLoss(o00oo0oo, o00o0.OooO00o);
    }

    private static boolean OooO00o(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("advCo");
            String strOptString = jSONObject.optString("bidding_win_feedback_switch");
            if (z) {
                if ("1".equals(strOptString)) {
                    return true;
                }
            } else if ("1".equals(jSONObject.optString("bidding_loss_feedback_switch"))) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
