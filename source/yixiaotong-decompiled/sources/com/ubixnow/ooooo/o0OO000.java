package com.ubixnow.ooooo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ubixnow.core.api.UMNConfigUserInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OO000 {

    public class OooO00o implements Runnable {
        public final /* synthetic */ Object[] OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ Map OooO0OO;

        public OooO00o(Object[] objArr, String str, Map map) {
            this.OooO00o = objArr;
            this.OooO0O0 = str;
            this.OooO0OO = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strReplace = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
                oO00Oo00 oo00oo00 = new oO00Oo00();
                o0OO000.OooO0O0(oo00oo00, this.OooO00o);
                oo00oo00.OooO0OO = System.currentTimeMillis();
                oo00oo00.OooO0Oo = strReplace;
                oo00oo00.OooO0o0 = this.OooO0O0;
                oo00oo00.OooO0o = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000OooO);
                oo00oo00.OooO0oO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, "ad_type");
                oo00oo00.OooO0oo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o00);
                oo00oo00.OooO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o0o);
                oo00oo00.OooOO0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.oooo00o);
                oo00oo00.OooOO0O = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o0O);
                oo00oo00.OooOO0o = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o0o0);
                oo00oo00.OooOOO0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oo0);
                oo00oo00.OooOOO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000ooO);
                oo00oo00.OooOOOO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000ooOO);
                oo00oo00.OooOOOo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000ooo0);
                oo00oo00.OooOOo0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o0oO);
                oo00oo00.OooOOo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o0oo);
                oo00oo00.OooOoO0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o00O);
                oo00oo00.OooOOoo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oo0o);
                oo00oo00.OooOo00 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, "duration");
                oo00oo00.OooOo0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o000);
                oo00oo00.OooOo0o = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oo);
                oo00oo00.OooOo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000ooO0);
                oo00oo00.OooOoO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000ooo);
                oo00oo00.OooOoOO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oooO);
                oo00oo00.OooOoo0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oooo);
                oo00oo00.OooOoo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00);
                oo00oo00.OoooO0O = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00O0000);
                oo00oo00.OooOooo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oo00);
                oo00oo00.Oooo000 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oOoo);
                oo00oo00.Oooo00O = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o0OO);
                oo00oo00.Oooo00o = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o0Oo);
                oo00oo00.Oooo0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00O00o);
                oo00oo00.Oooo0O0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000oo0O);
                oo00oo00.Oooo0OO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o000o00o);
                oo00oo00.Oooo0o0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00O00Oo);
                oo00oo00.Oooo0oO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00O00o0);
                oo00oo00.Oooo0oo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00OOooo);
                oo00oo00.OoooOOO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00Oo0oO);
                oo00oo00.OoooO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00Oo0oo);
                oo00oo00.Oooo = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00OoOoO);
                oo00oo00.OoooOO0 = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o0oOO);
                oo00oo00.o000oOoO = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, o0OO000o.o00Oo);
                oo00oo00.Oooo0o = o0OO000.OooO00o((Map<String, String>) this.OooO0OO, "extra");
                oo00oo00.OooOo0O = o0OO000.OooO0O0(this.OooO0OO);
                if (ooooO000.OooO00o) {
                    try {
                        String strOooO00o = oOo0o0oO.OooO00o("1001000010110000101000001000110110100000100011011010000010001101101000001000110110100000110101011010000011000010101000001100100110100000110110001010000011111111111101110110101111010000000110011001000010110001");
                        ooooO000.OooO0O0(strOooO00o + "---event", oO0000O.OooO00o(ooooO000.OooO0OO("b8"), new String[]{oo00oo00.OooO0o0, oo00oo00.OooOOo, oo00oo00.OooO0oo, oo00oo00.OooO0oO, oo00oo00.OooOo00, oo00oo00.OooO0o, oo00oo00.OooOo0, oo00oo00.Oooo000, oo00oo00.Oooo0, oo00oo00.OooOoo, oo00oo00.OooOoO0, oo00oo00.OooOO0, oo00oo00.OooOO0O, oo00oo00.OooOOOo, oo00oo00.OooO, oo00oo00.OooOO0o, oo00oo00.OooOOO0, oo00oo00.Oooo00O, oo00oo00.Oooo00o, oo00oo00.Oooo0O0, oo00oo00.Oooo0OO, oo00oo00.Oooo0o0, oo00oo00.OooOoo0, oo00oo00.OooOoOO, oo00oo00.OooOoO, oo00oo00.OooOooO, oo00oo00.OooOo0o, oo00oo00.OooOo, oo00oo00.OooOOO, oo00oo00.OooOOOO, oo00oo00.OooOOoo, oo00oo00.OooO0OO + "", oo00oo00.OooO0Oo, oo00oo00.OooOOo0, oo00oo00.Oooo0oO, oo00oo00.Oooo0oo, oo00oo00.Oooo, oo00oo00.OoooO0O, oO0O0O0o.OooO0OO(oo00oo00.OooOo0O), oO0O0O0o.OooO0OO(oo00oo00.Oooo0o), oo00oo00.OoooOOO, oo00oo00.OoooO, oo00oo00.OoooOO0, oo00oo00.o000oOoO}));
                        if (oo00oo00.OoooOoO != null) {
                            ooooO000.OooO0O0(strOooO00o + "---event:material", oo00oo00.OoooOoO.toString());
                        }
                        oO00OOOo[] oo00ooooArr = oo00oo00.OoooOo0;
                        if (oo00ooooArr != null && oo00ooooArr.length > 0) {
                            ooooO000.OooO0O0(strOooO00o + "---event:status:", Arrays.toString(oo00oo00.OoooOo0));
                        }
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                ooooO0O0.OooOoO().OooO0O0(oO0Oo0o0.OooO0O0().OooO0O0(oOo0000O.OooO00o(oo00oo00)));
            } catch (Exception e2) {
                ooooO000.OooO00o(e2);
            }
        }
    }

    public static String OooO00o(String str, String str2) {
        return TextUtils.isEmpty(str2) ? "" : String.format("【%s:%s】", str, str2);
    }

    public static String OooO00o(Map<String, String> map, String str) {
        try {
            return map.containsKey(str) ? map.get(str) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static HashMap<String, String> OooO00o(oo00o oo00oVar) {
        o0O0o00O o0o0o00oOooO0O0;
        HashMap<String, String> map = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(h1.OooO0O0().OooO0O0)) {
                    jSONObject.put("mubix_oaid", h1.OooO0O0().OooO0O0);
                }
                UMNConfigUserInfo uMNConfigUserInfo = o0O0ooO.OooO0o0;
                if (uMNConfigUserInfo != null && !TextUtils.isEmpty(uMNConfigUserInfo.getChannel())) {
                    jSONObject.put("mubix_channel", o0O0ooO.OooO0o0.getChannel());
                }
                UMNConfigUserInfo uMNConfigUserInfo2 = o0O0ooO.OooO0o0;
                if (uMNConfigUserInfo2 != null && !TextUtils.isEmpty(uMNConfigUserInfo2.getSubChannel())) {
                    jSONObject.put("mubix_sub_channel", o0O0ooO.OooO0o0.getSubChannel());
                }
                o0O0o0 o0o0o0 = oo00oVar.material;
                if (o0o0o0 != null && o0o0o0.OooO0O0 != null && (o0o0o00oOooO0O0 = o0o0o0.OooO0O0()) != null) {
                    if (!TextUtils.isEmpty(o0o0o00oOooO0O0.OooO00o)) {
                        jSONObject.put("mubix_ad_image_url", o0o0o00oOooO0O0.OooO00o);
                    }
                    if (!TextUtils.isEmpty(o0o0o00oOooO0O0.OooO0OO)) {
                        jSONObject.put("mubix_ad_video_cover_url", o0o0o00oOooO0O0.OooO0OO);
                    }
                    if (!TextUtils.isEmpty(o0o0o00oOooO0O0.OooO0O0)) {
                        jSONObject.put("mubix_ad_video_url", o0o0o00oOooO0O0.OooO0O0);
                    }
                }
                UMNConfigUserInfo uMNConfigUserInfo3 = o0O0ooO.OooO0o0;
                if (uMNConfigUserInfo3 != null && !TextUtils.isEmpty(uMNConfigUserInfo3.getUserId())) {
                    jSONObject.put("mubix_uid", o0O0ooO.OooO0o0.getUserId());
                }
                map.put(o0OO000o.o00O000, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            map.put(o0OO000o.o000o0oo, o0OO000o.o000OOoO);
            map.put(o0OO000o.o000o00, oo00oVar.getBaseAdConfig().OooOO0o.OooO0oO);
            map.put(o0OO000o.o000OooO, oo00oVar.getBaseAdConfig().OooOO0o.OooO00o);
            map.put("ad_type", oo00oVar.getBaseAdConfig().OooOO0o.OooO0O0);
            map.put(o0OO000o.o000o000, oo00oVar.getBaseAdConfig().OooOO0o.OooO0o);
            map.put(o0OO000o.o00OOooo, oo00oVar.getBaseAdConfig().OooOO0o.OooOOOO + "");
            oO0O0OoO oo0o0ooo = oo00oVar.getBaseAdConfig().OooO00o;
            map.put(o0OO000o.oooo00o, oo0o0ooo.OooO0OO + "");
            map.put(o0OO000o.o000o0O, oo0o0ooo.OooO0o0);
            map.put(o0OO000o.o000ooo0, oO0000O.OooO0O0(oo0o0ooo.OooO0OO));
            map.put(o0OO000o.o000o0OO, oo0o0ooo.OooOO0 + "");
            if (oo00oVar.getBaseAdConfig().OooOO0o.OooOOoo > 0) {
                map.put(o0OO000o.o00Oo0oo, oo00oVar.getBaseAdConfig().OooOO0o.OooOOoo + "");
            }
            map.put(o0OO000o.o000o0o0, (oo0o0ooo.OooOO0O == 1 ? new StringBuilder().append(oo00oVar.getBiddingEcpm()).append("") : new StringBuilder().append(oo0o0ooo.OooO).append("")).toString());
            map.put(o0OO000o.o000o0o, oo0o0ooo.OooOO0O + "");
            try {
                map.put(o0OO000o.o000o00o, new JSONObject(oo0o0ooo.OooOOO0).getJSONObject("advCo").getString(oOO00O.OooO00o));
            } catch (Exception unused) {
                map.put(o0OO000o.o000o00o, "0");
            }
            if (!TextUtils.isEmpty(oo00oVar.getBaseAdConfig().OooOO0o.OooOo0)) {
                map.put(o0OO000o.o0oOO, oo00oVar.getBaseAdConfig().OooOO0o.OooOo0 + "");
            }
            if (!TextUtils.isEmpty(oo00oVar.getBaseAdConfig().OooOO0o.OooOo0O)) {
                map.put(o0OO000o.o00Oo, oo00oVar.getBaseAdConfig().OooOO0o.OooOo0O + "");
            }
        } catch (Exception e2) {
            ooooO000.OooO00o(e2);
        }
        return map;
    }

    public static HashMap<String, String> OooO00o(oo0oO0 oo0oo0) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, o0OO000o.o00O0OOo);
        mapOooO0O0.remove(o0OO000o.o000oOoo);
        return mapOooO0O0;
    }

    public static HashMap<String, String> OooO00o(oo0oO0 oo0oo0, oO0O0OoO oo0o0ooo, ErrorInfo errorInfo) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, errorInfo.code);
        try {
            if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
                mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
            }
            if (!TextUtils.isEmpty(oo0oo0.OooO0Oo)) {
                mapOooO0O0.put(o0OO000o.o000oo00, oo0oo0.OooO0Oo);
            }
            if (!TextUtils.isEmpty(oo0oo0.OooO0o0)) {
                mapOooO0O0.put(o0OO000o.o000oo0, oo0oo0.OooO0o0);
            }
            mapOooO0O0.put(o0OO000o.o000o0o, oo0o0ooo.OooOO0O + "");
            mapOooO0O0.put(o0OO000o.oooo00o, oo0o0ooo.OooO0OO + "");
            mapOooO0O0.put(o0OO000o.o000o0O, oo0o0ooo.OooO0o0);
            mapOooO0O0.put(o0OO000o.o000oo0o, errorInfo.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapOooO0O0;
    }

    public static HashMap<String, String> OooO00o(oo0oO0 oo0oo0, String str) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, str);
        try {
            if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
                mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
            }
            if (!TextUtils.isEmpty(oo0oo0.OooO0Oo)) {
                mapOooO0O0.put(o0OO000o.o000oo00, oo0oo0.OooO0Oo);
            }
            mapOooO0O0.put(o0OO000o.o000oOoo, oo0oo0.OooO0oo + "");
            if (!TextUtils.isEmpty(oo0oo0.OooO0o0)) {
                mapOooO0O0.put(o0OO000o.o000oo0, oo0oo0.OooO0o0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapOooO0O0;
    }

    public static HashMap<String, String> OooO00o(oo0oO0 oo0oo0, String str, String str2) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, str);
        mapOooO0O0.put("duration", "" + (SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO0oo));
        mapOooO0O0.put(o0OO000o.o000o0o, "1");
        if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
            mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
        }
        if (!TextUtils.isEmpty(str2)) {
            mapOooO0O0.put(o0OO000o.o000oo0o, str2);
        }
        return mapOooO0O0;
    }

    public static HashMap<String, String> OooO00o(String str) {
        HashMap<String, String> map = new HashMap<>();
        try {
            map.put(o0OO000o.o000o0oo, str);
            JSONObject jSONObject = new JSONObject();
            String str2 = "1";
            jSONObject.put("location", j1.OooO00o ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoO0, j1.OooO0oo ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoO0o, j1.OooO0O0 ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoO, j1.OooO0oO ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoOO0, j1.OooO0o ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoOO, j1.OooO0Oo ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoOOO, j1.OooOOOO);
            jSONObject.put(o0OO000o.o00OoOOo, j1.OooO0OO ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoOo0, j1.OooOOO);
            jSONObject.put(o0OO000o.o00OoOo, j1.OooO0o0 ? "1" : "0");
            jSONObject.put(o0OO000o.o00OoOoo, j1.OooO ? "1" : "0");
            if (!j1.OooOO0) {
                str2 = "0";
            }
            jSONObject.put(o0OO000o.o00Ooo00, str2);
            jSONObject.put("sensor", o0O0ooO.OooO0oO);
            map.put(o0OO000o.o00O000, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static HashMap<String, String> OooO00o(String str, long j) {
        HashMap<String, String> map = new HashMap<>();
        try {
            map.put(o0OO000o.o000o0oo, str);
            map.put("duration", j + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static HashMap<String, String> OooO00o(String str, String str2, String str3) {
        HashMap<String, String> map = new HashMap<>();
        try {
            map.put(o0OO000o.o000o0oo, str);
            if (!TextUtils.isEmpty(str2)) {
                map.put(o0OO000o.o000oo0o, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put(o0OO000o.o00O00o0, str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static HashMap<String, String> OooO00o(HashMap<String, String> map, oo00o oo00oVar) {
        try {
            if (oo00oVar.getAbsBaseAdapter() instanceof o00OO000) {
                o00OO000 o00oo000 = (o00OO000) oo00oVar.getAbsBaseAdapter();
                if (o00oo000.isReportSucc) {
                    boolean z = o00oo000.isReportFail;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(o0OO000o.o00O0O0o, (z ? 1 : 0) + "");
                    jSONObject.put(o0OO000o.o00O0OO0, o00oo000.biddingLossWinPrice + "");
                    jSONObject.put(o0OO000o.oo0o0O0, o00oo000.biddingWinSecondPrice + "");
                    map.put(o0OO000o.o00O000, jSONObject.toString());
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return map;
    }

    public static void OooO00o(o00O0 o00o0) {
        if (o0O.OooO00o == null || o00o0.OooOo00.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        map.put(o0OO000o.o000o00, o00o0.OooO00o);
        map.put(o0OO000o.o000OooO, o00o0.OooO0Oo.OooO00o.slotId);
        map.put(o0OO000o.o000oo00, o00o0.OooOOo0.OooO0Oo);
        map.put(o0OO000o.o000o000, o00o0.OooOOo0.OooO0o);
        map.put("ad_type", o00o0.OooOOo0.OooO0O0);
        map.put(o0OO000o.o000oOoo, o00o0.OooOOo0.OooO0oo + "");
        map.put(o0OO000o.o000o0oo, o0OO000o.o0000OO);
        map.put(o0OO000o.o00O00o, o00o0.OooOOo0.OooOOo0 + "");
        OooO00o(o0OO000o.o0000OO0, map, o00o0.OooOo00);
    }

    public static void OooO00o(String str, Map<String, String> map, Object... objArr) {
        if (oO00000o.o00O0O.OooO0o0 != null) {
            String strOooO00o = OooO00o(map, o0OO000o.o000o0oo);
            if (oO00000o.o00O0O.OooO0o0.contains("none")) {
                return;
            }
            if (!oO00000o.o00O0O.OooO0o0.contains(TtmlNode.COMBINE_ALL) && !TextUtils.isEmpty(strOooO00o) && !oO00000o.o00O0O.OooO0o0.contains(strOooO00o)) {
                return;
            }
        }
        g1.OooO00o("ubixnow_track").OooO0OO(new OooO00o(objArr, str, map));
    }

    public static HashMap<String, String> OooO0O0(oo0oO0 oo0oo0, String str) {
        HashMap<String, String> map = new HashMap<>();
        try {
            map.put(o0OO000o.o000o0oo, str);
            map.put(o0OO000o.o000o00, oo0oo0.OooO0oO);
            map.put(o0OO000o.o000OooO, oo0oo0.OooO00o);
            map.put("ad_type", oo0oo0.OooO0O0);
            map.put(o0OO000o.o000oOoo, oo0oo0.OooO0oo + "");
            if (oo0oo0.OooOOoo > 0) {
                map.put(o0OO000o.o00Oo0oo, oo0oo0.OooOOoo + "");
            }
            if (oo0oo0.OooOOOO > 0) {
                map.put(o0OO000o.o00OOooo, oo0oo0.OooOOOO + "");
            }
            if (oo0oo0.OooOOo0 > 0) {
                map.put(o0OO000o.o00O00o, oo0oo0.OooOOo0 + "");
            }
            if (!TextUtils.isEmpty(oo0oo0.OooOOo)) {
                map.put(o0OO000o.o00OoOoO, oo0oo0.OooOOo + "");
            }
            if (!TextUtils.isEmpty(oo0oo0.OooOo0)) {
                map.put(o0OO000o.o0oOO, oo0oo0.OooOo0 + "");
            }
            if (!TextUtils.isEmpty(oo0oo0.OooOo0O)) {
                map.put(o0OO000o.o00Oo, oo0oo0.OooOo0O + "");
            }
        } catch (Exception e) {
            ooooO000.OooO0O0("-----buildLoadAdMap", "----e " + e.getMessage());
            e.printStackTrace();
        }
        return map;
    }

    public static HashMap<String, String> OooO0O0(oo0oO0 oo0oo0, String str, String str2) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, str);
        mapOooO0O0.put("duration", "" + (SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO0oo));
        if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
            mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
        }
        mapOooO0O0.put(o0OO000o.o000o0o, "1");
        if (!TextUtils.isEmpty(str2)) {
            mapOooO0O0.put(o0OO000o.o000oo0o, str2);
        }
        return mapOooO0O0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> OooO0O0(Map<String, String> map) {
        HashMap map2 = new HashMap();
        try {
            if (!TextUtils.isEmpty(map.get(o0OO000o.o00O000))) {
                JSONObject jSONObject = new JSONObject(map.get(o0OO000o.o00O000));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(jSONObject.getString(next))) {
                        map2.put(next, jSONObject.getString(next));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void OooO0O0(oO00Oo00 oo00oo00, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof CopyOnWriteArrayList) {
                        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) obj;
                        if (!copyOnWriteArrayList.isEmpty() && (copyOnWriteArrayList.get(0) instanceof oO00OOOo)) {
                            oo00oo00.OoooOo0 = (oO00OOOo[]) copyOnWriteArrayList.toArray(new oO00OOOo[0]);
                        }
                    } else if (obj instanceof oO00Oo0) {
                        oo00oo00.OoooOoO = (oO00Oo0) obj;
                    }
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public static HashMap<String, String> OooO0OO(oo0oO0 oo0oo0, String str) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, str);
        try {
            if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
                mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
            }
            mapOooO0O0.put("duration", oo0oo0.OooOo00);
            mapOooO0O0.put(o0OO000o.o00O00o0, "0");
            if (!TextUtils.isEmpty(oo0oo0.OooO0Oo)) {
                mapOooO0O0.put(o0OO000o.o000oo00, oo0oo0.OooO0Oo);
            }
            if (!TextUtils.isEmpty(oo0oo0.OooO0o0)) {
                mapOooO0O0.put(o0OO000o.o000oo0, oo0oo0.OooO0o0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapOooO0O0;
    }

    public static HashMap<String, String> OooO0OO(oo0oO0 oo0oo0, String str, String str2) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, str);
        try {
            if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
                mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
            }
            if (!TextUtils.isEmpty(oo0oo0.OooO0o0)) {
                mapOooO0O0.put(o0OO000o.o000oo0, oo0oo0.OooO0o0);
            }
            if (!TextUtils.isEmpty(str2)) {
                mapOooO0O0.put(o0OO000o.o000oo0o, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapOooO0O0;
    }

    public static HashMap<String, String> OooO0Oo(oo0oO0 oo0oo0, String str) {
        return OooO0O0(oo0oo0, str);
    }

    public static HashMap<String, String> OooO0Oo(oo0oO0 oo0oo0, String str, String str2) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, str);
        mapOooO0O0.put(o0OO000o.o000oo0, oo0oo0.OooO0o0 + "");
        mapOooO0O0.put(o0OO000o.o000oooO, oo0oo0.OooOO0 + "");
        mapOooO0O0.put(o0OO000o.o000ooo, oo0oo0.OooO + "");
        mapOooO0O0.put(o0OO000o.o000o0OO, oo0oo0.OooO0OO + "");
        mapOooO0O0.put(o0OO000o.o00O0000, oo0oo0.OooOO0o + "");
        if (!str.equals(o0OO000o.o00OO0OO) && !str.equals(o0OO000o.o00OO0o)) {
            mapOooO0O0.put(o0OO000o.o000o0o0, oo0oo0.OooOoO0.OooO00o + "");
            mapOooO0O0.put(o0OO000o.oooo00o, oo0oo0.OooOoO0.OooO0O0 + "");
            mapOooO0O0.put(o0OO000o.o000o0O, oo0oo0.OooOoO0.OooO0OO + "");
            mapOooO0O0.put(o0OO000o.o000ooo0, oo0oo0.OooOoO0.OooO0Oo + "");
            mapOooO0O0.put(o0OO000o.o00, oo0oo0.OooOO0O + "");
        }
        mapOooO0O0.put(o0OO000o.o000o0o, "1");
        mapOooO0O0.put(o0OO000o.o000oooo, oo0oo0.OooOOO + "");
        mapOooO0O0.put("duration", "" + (SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO));
        if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
            mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
        }
        if (!TextUtils.isEmpty(str2)) {
            mapOooO0O0.put(o0OO000o.o000oo0o, str2);
        }
        return mapOooO0O0;
    }

    public static HashMap<String, String> OooO0o0(oo0oO0 oo0oo0, String str) {
        return OooO0O0(oo0oo0, str);
    }

    public static HashMap<String, String> OooO0o0(oo0oO0 oo0oo0, String str, String str2) {
        HashMap<String, String> mapOooO0O0 = OooO0O0(oo0oo0, o0OO000o.o00O0OOO);
        if (!TextUtils.isEmpty(oo0oo0.OooO0o)) {
            mapOooO0O0.put(o0OO000o.o000o000, oo0oo0.OooO0o);
        }
        if (!TextUtils.isEmpty(str)) {
            mapOooO0O0.put(o0OO000o.oooo00o, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            mapOooO0O0.put(o0OO000o.o000o0O, str2);
        }
        mapOooO0O0.remove(o0OO000o.o000oOoo);
        return mapOooO0O0;
    }
}
