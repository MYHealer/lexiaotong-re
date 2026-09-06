package com.ubixnow.ooooo;

import com.ubixnow.core.api.UbixDefaultConstants;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0o0000 {
    public static ErrorInfo OooO00o(o00O0 o00o0) {
        try {
            oO0OOo0o oo0ooo0o = o00o0.OooOOOO;
            oO0OOo0o.OooO00o oooO00o = oo0ooo0o.OooO0o0[0];
            o00O00O o00o00o = o00o0.OooO0OO;
            o00o00o.OooO00o = oooO00o.OooO0oO;
            o00o00o.OooO0O0 = oooO00o.OooOO0;
            o00o00o.OooOOo0 = oo0ooo0o.OooO0oO;
            o00o00o.OooOOOo = oooO00o.OooOOoo;
            oo0oO0 oo0oo0 = o00o0.OooOOo0;
            oo0oo0.OooOOOO = oooO00o.OooOoO0;
            o00o00o.OooO0OO = oooO00o.OooOO0o;
            oo0oo0.OooOo0 = oooO00o.OooOo0o;
            oo0oo0.OooOo0O = oooO00o.OooOoo0;
            o00o00o.OooO = o00o0.OooO0Oo.OooO00o.slotId + o00o0.OooO0OO.OooO0O0 + oooO00o.OooOo0o;
            o00o0.OooO0OO.OooOOOO = o0O0OOO0.OooO00o(oooO00o.OooOOO0);
            o00O00O o00o00o2 = o00o0.OooO0OO;
            o00o00o2.OooOOO0 = o0o0Oo.OooO00o(o00o00o2.OooOOOO);
            o0o0Oo.OooO00o(o00o0, o00o0.OooO0OO.OooOOO0);
            String str = oooO00o.OooOoO;
            if (str != null) {
                o00o0.OooOOo0.OooOOo = str;
            }
            oo0oO0 oo0oo1 = o00o0.OooOOo0;
            o00O00O o00o00o3 = o00o0.OooO0OO;
            int i = oooO00o.OooOOOO;
            o00o00o3.OooOOo = i;
            oo0oo1.OooO = i;
            oo0oo1.OooOO0 = oooO00o.OooOOOo;
            oo0oo1.OooOO0O = oooO00o.OooOOo0;
            oo0oo1.OooOOO = oooO00o.OooOOo;
            if (oooO00o.OooOO0o > 0) {
                oo0oo1.OooO0o0 = oooO00o.OooOO0o + "";
            }
            o00O00O o00o00o4 = o00o0.OooO0OO;
            o00o00o4.OooOO0o = oooO00o.OooOOO.OooO0o;
            o00o00o4.OooOO0O = UbixDefaultConstants.cacheLimitTime;
            for (oO0O0OoO oo0o0ooo : oooO00o.OooO0Oo) {
                OooO00o(o00o0, oo0o0ooo);
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0("-----Request mubixAdType:", "服务端返回广告类型: " + oooO00o.OooO0o0 + " 请求广告类型： " + o00o0.OooOOo0.OooO0O0);
            }
            String str2 = o00o0.OooO0OO.OooOOO;
            oOO00O0.OooO00o oooO00o2 = oOO00O0.OooO00o.FILTER_WFTIMEOUT_IS0;
            if (str2.equals(oooO00o2.OooO00o())) {
                return new ErrorInfo(oooO00o2.OooO00o(), oooO00o2.OooO0O0());
            }
            if (!(oooO00o.OooO0o0 + "").equals(o00o0.OooOOo0.OooO0O0)) {
                return new ErrorInfo(o0OO000o.Oooo0oo, o0OO000o.OoooO);
            }
            if (oooO00o.OooOoO0 != o00o0.OooOOO) {
                return new ErrorInfo(o0OO000o.OoooO0, "sdk接入类型不一致");
            }
            if (o00o0.OooO0o > 0) {
                return null;
            }
            String str3 = o00o0.OooO0OO.OooOOO;
            oOO00O0.OooO00o oooO00o3 = oOO00O0.OooO00o.FILTER_FREQUENT;
            if (str3.equals(oooO00o3.OooO00o())) {
                return new ErrorInfo(oooO00o3.OooO00o(), oooO00o3.OooO0O0());
            }
            String str4 = o00o0.OooO0OO.OooOOO;
            oOO00O0.OooO00o oooO00o4 = oOO00O0.OooO00o.FILTER_RENDER_TYPE;
            if (str4.equals(oooO00o4.OooO00o())) {
                return new ErrorInfo(oooO00o4.OooO00o(), oooO00o4.OooO0O0());
            }
            if (oooO00o.OooO0Oo.length != 0) {
                return new ErrorInfo(o0OO000o.Oooo00o, oOO00O0.ubix_filter_msg);
            }
            oOO00O0.OooO00o oooO00o5 = oOO00O0.OooO00o.FILTER_NOCONFIG;
            return new ErrorInfo(oooO00o5.OooO00o(), oooO00o5.OooO0O0());
        } catch (Throwable th) {
            return new ErrorInfo(o0OO000o.Oooo0o, oOO00O0.ubix_pbparse_error_msg + th.getMessage());
        }
    }

    public static void OooO00o(o00O0 o00o0, oO0O0OoO oo0o0ooo) {
        o00O000 o00o000 = new o00O000(oo0o0ooo, o00o0.OooO0Oo.OooO00o, o00o0.OooO00o, oo0o0ooo.OooOOo0, o00o0);
        oO0OOo0o oo0ooo0o = o00o0.OooOOOO;
        if (oo0ooo0o != null && o00o0.OooOOO == 2 && oo0ooo0o.OooO0o0[0].OooOoO0 == 2 && oo0o0ooo.OooOOo0 == 2 && oo0o0ooo.OooOO0O == 1) {
            o00o0.OooO0OO.OooO0oO.OooO00o.add(o00o000);
            o00o0.OooO0oo++;
        } else if (oo0ooo0o != null && o00o0.OooOOO == 1 && oo0ooo0o.OooO0o0[0].OooOoO0 != 2 && oo0o0ooo.OooOOo0 != 2 && oo0o0ooo.OooOO0O == 1) {
            o00o0.OooO0OO.OooO0o.OooO00o.add(o00o000);
            o00o0.OooO0oO++;
        } else {
            if (oo0ooo0o == null || o00o0.OooOOO != 1 || oo0ooo0o.OooO0o0[0].OooOoO0 == 2 || oo0o0ooo.OooOOo0 == 2 || oo0o0ooo.OooOO0O != 0) {
                return;
            }
            o00O00O.OooO00o oooO00o = o00o0.OooO0OO.OooO0o0.get(Integer.valueOf(oo0o0ooo.OooOOO));
            if (oo0o0ooo.OooOOOo <= 0) {
                o00o0.OooO0OO.OooOOO = oOO00O0.OooO00o.FILTER_WFTIMEOUT_IS0.OooO00o();
                return;
            }
            if (oooO00o == null) {
                o00O00O.OooO00o oooO00o2 = new o00O00O.OooO00o();
                oooO00o2.OooO00o.add(o00o000);
                oooO00o2.OooO0Oo = (int) oo0o0ooo.OooO;
                oooO00o2.OooO0OO = oo0o0ooo.OooOOOo;
                o00o0.OooO0OO.OooO0o0.put(Integer.valueOf(oo0o0ooo.OooOOO), oooO00o2);
            } else {
                oooO00o.OooO0Oo = Math.max(oooO00o.OooO0Oo, (int) oo0o0ooo.OooO);
                oooO00o.OooO00o.add(o00o000);
            }
            o00o0.OooO++;
        }
        o00o0.OooO0o++;
    }

    public static void OooO00o(String str, boolean z, int i) {
        oOo00o00.OooO00o(oO00000o.o00000O0.Oooo000 + str, Boolean.valueOf(z));
        oOo00o00.OooO0O0(str + oO00000o.o00000O0.OooO0oo, i);
    }
}
