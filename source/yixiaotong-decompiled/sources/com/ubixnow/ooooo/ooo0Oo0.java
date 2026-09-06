package com.ubixnow.ooooo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.api.UbixDefaultConstants;
import com.ubixnow.core.utils.error.ErrorInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ooo0Oo0 {
    public static final String OooO00o = "----StrategyCacheHandler";
    public oO0OOo0o OooO0O0;

    private static void OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
        if (o00o0.OooO0Oo != null) {
            if (o00o0.OooO0OO.OooO00o > 0) {
                o00o0.OooOOo0.OooO0Oo = o00o0.OooO0OO.OooO00o + "";
            }
            if (o00o0.OooO0OO.OooO0O0 > 0) {
                o00o0.OooOOo0.OooO0o = o00o0.OooO0OO.OooO0O0 + "";
            }
        }
        HashMap<String, String> mapOooO0OO = o0OO000.OooO0OO(o00o0.OooOOo0, errorInfo.code, errorInfo.msg);
        mapOooO0OO.put(o0OO000o.o00O00o0, !TextUtils.isEmpty(errorInfo.platFormCode) ? errorInfo.platFormCode : "0");
        o0OO000.OooO00o(o0OO000o.OooOooO, mapOooO0OO, new Object[0]);
    }

    public static void OooO00o(o00O0 o00o0, ErrorInfo errorInfo, boolean z, o0oo0000 o0oo0000Var) {
        String str;
        if (z) {
            errorInfo.platFormCode = errorInfo.code;
            errorInfo.platFormMsg = errorInfo.msg;
            if (oOO00O0.OooO00o.FILTER_WFTIMEOUT_IS0.OooO00o().equals(errorInfo.code)) {
                str = o0OO000o.Oooo00O;
            } else {
                if (!oOO00O0.OooO00o.FILTER_RENDER_TYPE.OooO00o().equals(errorInfo.code)) {
                    if (oOO00O0.OooO00o.FILTER_NOCONFIG.OooO00o().equals(errorInfo.code)) {
                        str = o0OO000o.Oooo00o;
                    }
                    OooO00o(o00o0, errorInfo);
                    o0oo0000Var.OooO00o(errorInfo);
                }
                str = o0OO000o.Oooo0OO;
            }
            errorInfo.code = str;
            OooO00o(o00o0, errorInfo);
            o0oo0000Var.OooO00o(errorInfo);
        }
    }

    public static void OooO00o(o00O0 o00o0, boolean z) {
        if (z) {
            o00o0.OooOOo0.OooOo.OooO0O0 = System.currentTimeMillis();
            if (o00o0.OooO0OO.OooO00o > 0) {
                o00o0.OooOOo0.OooO0Oo = o00o0.OooO0OO.OooO00o + "";
            }
            if (o00o0.OooO0OO.OooO0O0 > 0) {
                o00o0.OooOOo0.OooO0o = o00o0.OooO0OO.OooO0O0 + "";
            }
            o00o0.OooOOo0.OooOo00 = (SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooO00o) + "";
            if (o00o0.OooO0OO.OooO0OO > 0) {
                o00o0.OooOOo0.OooO0o0 = o00o0.OooO0OO.OooO0OO + "";
            }
            o0OO000.OooO00o(o0OO000o.OooOoo0, o0OO000.OooO0OO(o00o0.OooOOo0, o0OO000o.OooOoo), new Object[0]);
        }
    }

    public static void OooO0O0(o00O0 o00o0, ErrorInfo errorInfo, boolean z, o0oo0000 o0oo0000Var) {
        ooooO000.OooO0O0("------StrategyHandler", "--onParseFail " + errorInfo.toString());
        if (z) {
            OooO00o(o00o0, errorInfo);
            o0oo0000Var.OooO00o(errorInfo);
        }
    }

    public oO0OOo0o OooO00o(String str) {
        byte[] bArrOooO0oo = oOo00o00.OooO0oo(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.OooOoO0 + str);
        if (bArrOooO0oo == null || bArrOooO0oo.length <= 0) {
            return null;
        }
        try {
            return oO0OOo0o.OooO00o(bArrOooO0oo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void OooO00o(o00O0 o00o0, oO0OOo0o oo0ooo0o, boolean z, o0oo0000 o0oo0000Var) {
        o00o0.OooOOOO = oo0ooo0o;
        ErrorInfo errorInfoOooO00o = o0o0000.OooO00o(o00o0);
        if (errorInfoOooO00o == null) {
            OooO00o(o00o0, z);
            o0oo0000Var.OooO00o(o00o0);
        } else {
            ooooO000.OooO0O0("-----Request error:", errorInfoOooO00o.toString());
            OooO00o(o00o0, errorInfoOooO00o, z, o0oo0000Var);
        }
    }

    public void OooO00o(o00O0 o00o0, boolean z, o0oo0000 o0oo0000Var) {
        o00o0.OooOOOO = this.OooO0O0;
        ErrorInfo errorInfoOooO00o = o0o0000.OooO00o(o00o0);
        if (errorInfoOooO00o == null) {
            OooO00o(o00o0, z);
            o0oo0000Var.OooO00o(o00o0);
        } else {
            ooooO000.OooO0O0("-----Request error:", errorInfoOooO00o.toString());
            OooO00o(o00o0, errorInfoOooO00o, z, o0oo0000Var);
        }
    }

    public boolean OooO00o(o00O0 o00o0, o0oo0000 o0oo0000Var) {
        try {
            boolean zBooleanValue = oOo00o00.OooO00o(oO00000o.o00000O0.Oooo000 + o00o0.OooO0Oo.OooO00o.slotId).booleanValue();
            boolean z = UbixDefaultConstants.strategyCacheExpireTime * 60000 < System.currentTimeMillis() - oOo00o00.OooO(new StringBuilder().append(o00o0.OooO0O0.appId).append(oO00000o.o00000O0.OooOoO0).append(o00o0.OooO0Oo.OooO00o.slotId).toString());
            byte[] bArrOooO0oo = oOo00o00.OooO0oo(o00o0.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + o00o0.OooO0Oo.OooO00o.slotId);
            ooooO000.OooO0O0(OooO00o, ooooO000.OooO0OO("i1") + z + ooooO000.OooO0OO("i2") + (bArrOooO0oo != null && bArrOooO0oo.length > 0) + ooooO000.OooO0OO("i3") + zBooleanValue);
            if (zBooleanValue && !z && bArrOooO0oo != null && bArrOooO0oo.length > 0) {
                this.OooO0O0 = oO0OOo0o.OooO00o(bArrOooO0oo);
                ooooO000.OooO0O0(OooO00o, ooooO000.OooO0OO("i4"));
                o00o0.OooOOo0.OooOOo0 = 1;
                return true;
            }
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, ooooO000.OooO0OO("i5") + e.getMessage());
            e.printStackTrace();
        }
        o00o0.OooOOo0.OooOOo0 = 2;
        ooooO000.OooO0O0(OooO00o, ooooO000.OooO0OO("i9"));
        return false;
    }

    public void OooO0O0(o00O0 o00o0, o0oo0000 o0oo0000Var) {
        oO0Oo oo0oo;
        boolean z = UbixDefaultConstants.requestStrategyInterval * 60000 < System.currentTimeMillis() - oOo00o00.OooO(new StringBuilder().append(o00o0.OooO0O0.appId).append(oO00000o.o00000O0.OooOoO0).append(o00o0.OooO0Oo.OooO00o.slotId).toString());
        if (!OooO00o(o00o0, o0oo0000Var) || this.OooO0O0 == null) {
            oo0oo = new oO0Oo(o00o0, o0oo0000Var);
        } else if (!z) {
            ooooO000.OooO0O0(OooO00o, "在间隔范围，使用缓存策略，不用更新实时策略");
            o00o0.OooOO0o = true;
            OooO00o(o00o0, true, o0oo0000Var);
            return;
        } else {
            ooooO000.OooO0O0(OooO00o, "不在间隔范围内，使用缓存策略，但要更新实时策略");
            o00o0.OooOO0o = true;
            OooO00o(o00o0, true, o0oo0000Var);
            oo0oo = new oO0Oo(o00o0, o0oo0000Var);
        }
        oo0oo.OooO0O0();
    }

    public void OooO0OO(o00O0 o00o0, o0oo0000 o0oo0000Var) {
        long jOooO = oOo00o00.OooO(o00o0.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + o00o0.OooO0Oo.OooO00o.slotId);
        if (o00o0.OooOOO == 2) {
            if (UbixDefaultConstants.s2sStrategyInterval * 60000 >= System.currentTimeMillis() - jOooO) {
                return;
            }
        } else if (UbixDefaultConstants.requestStrategyInterval * 60000 >= System.currentTimeMillis() - jOooO) {
            return;
        }
        o00o0.OooOO0o = true;
        new oO0Oo(o00o0, o0oo0000Var).OooO0O0();
    }
}
