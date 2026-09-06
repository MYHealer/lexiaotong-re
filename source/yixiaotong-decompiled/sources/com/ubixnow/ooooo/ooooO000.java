package com.ubixnow.ooooo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.ubixnow.utils.BaseUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ooooO000 {
    public static boolean OooO00o = false;
    public static String OooO0O0 = "----ubixdev---- ";
    public static String OooO0OO = "------C: ";
    public static int OooO0Oo;
    private static boolean OooO0o;
    public static JSONObject OooO0o0;
    private static boolean OooO0oO;

    public static String OooO00o(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", str);
            jSONObject.put("tag", str2);
            jSONObject.put(CrashHianalyticsData.MESSAGE, str3);
        } catch (Exception e) {
            System.err.println("JSONException: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    private static void OooO00o(Context context) {
        try {
            OooO00o("log.json", context);
            if (OooO0o0 == null) {
                OooO00o("log1.json", context);
                OooO0Oo++;
            }
        } catch (Throwable th) {
            OooO00o(th);
        }
    }

    public static void OooO00o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!OooO0O0()) {
            if (OooO0o) {
                Log.d(OooO0O0, str);
            }
        } else {
            if (OooO0Oo > 0) {
                System.out.println(OooO0O0 + "  :" + str);
            } else {
                Log.d(OooO0O0, str);
            }
            OooO0O0(OooO0O0, str, com.kuaishou.weapon.p0.t.t);
        }
    }

    private static void OooO00o(String str, Context context) {
        try {
            String strOooO00o = ooo0o.OooO00o(str, context);
            if (TextUtils.isEmpty(strOooO00o)) {
                strOooO00o = ooo0o.OooO0O0(str);
            }
            if (TextUtils.isEmpty(strOooO00o)) {
                return;
            }
            OooO0o0 = new JSONObject(new JSONTokener(strOooO00o));
        } catch (Throwable th) {
            OooO00o(th);
        }
    }

    public static void OooO00o(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && OooO0O0()) {
            if (OooO0Oo > 0) {
                System.out.println(str + "  :" + str2);
            } else {
                Log.d(str, str2);
            }
            OooO0O0(str, str2, com.kuaishou.weapon.p0.t.t);
        }
    }

    public static void OooO00o(Throwable th) {
        try {
            if (OooO0O0()) {
                if (OooO0Oo > 0) {
                    System.out.println(OooO0O0 + "  :" + th.getMessage());
                } else {
                    Log.w(OooO0O0, "", th);
                }
                OooO0O0(OooO0O0, th.getMessage(), "e");
            }
        } catch (Exception unused) {
        }
    }

    public static void OooO00o(boolean z) {
        if (!OooO0oO) {
            OooO00o(BaseUtils.getContext());
        }
        OooO0oO = true;
        OooO0o = z;
    }

    public static boolean OooO00o() {
        return (OooO0o0 == null || TextUtils.isEmpty(OooO0OO("a10")) || !oOo0o0oO.OooO00o(OooO0OO("a10")).equals("cropen")) ? false : true;
    }

    public static void OooO0O0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!OooO0O0()) {
            if (OooO0o) {
                Log.e(OooO0O0, str);
            }
        } else {
            if (OooO0Oo > 0) {
                System.out.println(OooO0O0 + "  :" + str);
            } else {
                Log.e(OooO0O0, str);
            }
            OooO0O0(OooO0O0, str, "e");
        }
    }

    public static void OooO0O0(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2) && OooO0O0()) {
                if (OooO0Oo > 0) {
                    System.out.println(str + "  :" + str2);
                } else {
                    Log.e(str, str2);
                }
                OooO0O0(str, str2, "e");
            }
        } catch (Exception e) {
            OooO00o(e);
        }
    }

    public static void OooO0O0(String str, String str2, String str3) {
        String strOooO0OO = OooO0OO("f11");
        if (TextUtils.isEmpty(strOooO0OO)) {
            return;
        }
        new o0OOOO0o(OooO00o(str3, str, str2), strOooO0OO).OooO0O0();
    }

    private static boolean OooO0O0() {
        boolean z = (OooO0o0 == null || TextUtils.isEmpty(OooO0OO("a0")) || !oOo0o0oO.OooO00o(OooO0OO("a0")).equals("logopen")) ? false : true;
        OooO00o = z;
        return z;
    }

    public static String OooO0OO(String str) {
        if (OooO0o0 == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return OooO0o0.getString(str);
        } catch (JSONException e) {
            System.err.println("JSONException: " + e.getMessage());
            return "";
        }
    }

    public static void OooO0OO(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && OooO0O0()) {
            if (OooO0Oo > 0) {
                System.out.println(str + "  :" + str2);
            } else {
                Log.i(str, str2);
            }
            OooO0O0(str, str2, "i");
        }
    }

    public static void OooO0Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!OooO0O0()) {
            if (OooO0o) {
                Log.i(OooO0O0, str);
            }
        } else {
            if (OooO0Oo > 0) {
                System.out.println(OooO0O0 + "  :" + str);
            } else {
                Log.i(OooO0O0, str);
            }
            OooO0O0(OooO0O0, str, "i");
        }
    }

    public static void OooO0Oo(String str, String str2) {
        try {
            if (OooO00o) {
                if (str2.length() <= 1000) {
                    Log.i(str, str2);
                    return;
                }
                int i = 0;
                while (i < str2.length()) {
                    int i2 = i + 1000;
                    Log.i(str, i2 < str2.length() ? str2.substring(i, i2) : str2.substring(i, str2.length()));
                    i = i2;
                }
            }
        } catch (Exception e) {
            OooO00o(e);
        }
    }
}
