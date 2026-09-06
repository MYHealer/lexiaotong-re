package com.adprof.sdk;

import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdprofSdkConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class oh {
    public static void a(String str, AdError adError, wd wdVar, d dVar) {
        try {
            int errorCode = adError.getErrorCode();
            String message = adError.getMessage();
            hh hhVar = new hh();
            ((mh) hhVar).f468b = "101";
            hhVar.a(str);
            hhVar.B = String.valueOf(errorCode);
            if (!TextUtils.isEmpty(message)) {
                hhVar.A = message;
            }
            a(wdVar, hhVar);
            a(dVar, hhVar);
            a(hhVar);
            hhVar.mo685a();
        } catch (Throwable th) {
            b(th);
            pk.d("AFError = " + Log.getStackTraceString(th));
        }
    }

    public static void a(String str, String str2, d dVar) {
        a(str, str2, dVar, null, null);
    }

    public static void b(Throwable th) {
        AdprofSdkConfig sdkConfig = AdprofSdk.getInstance().getSdkConfig();
        if (sdkConfig != null && sdkConfig.showLog && th != null) {
            th.printStackTrace();
        }
        a(Log.getStackTraceString(th));
    }

    public static void a(mh mhVar) {
        try {
            if (b8.f90a == null) {
                b8.f90a = Build.MODEL;
            }
            mhVar.e = b8.f90a;
            String str = "1";
            if (b8.f91b == null) {
                b8.f91b = (AdprofSdk.getInstance().getContext().getResources().getConfiguration().screenLayout & 15) >= 3 ? "0" : "1";
            }
            mhVar.f = b8.f91b;
            mhVar.f1308a = b8.m582a() ? 1 : 0;
            StringBuilder sb = new StringBuilder();
            if (b8.f88a == null) {
                b8.f88a = Float.valueOf(AdprofSdk.getInstance().getContext().getResources().getDisplayMetrics().density);
            }
            mhVar.g = sb.append(b8.f88a.floatValue()).append("").toString();
            if (b8.c == null) {
                int i = AdprofSdk.getInstance().getContext().getResources().getConfiguration().orientation;
                if (i == 2) {
                    str = "2";
                } else if (i != 1) {
                    str = "3";
                }
                b8.c = str;
            }
            mhVar.j = b8.c;
            if (b8.d == null) {
                b8.d = Build.BRAND;
            }
            mhVar.h = b8.d;
            if (b8.e == null) {
                b8.e = Build.MANUFACTURER;
            }
            mhVar.i = b8.e;
            if (b8.b == null) {
                DisplayMetrics displayMetrics = AdprofSdk.getInstance().getContext().getResources().getDisplayMetrics();
                b8.b = Integer.valueOf((int) (displayMetrics.widthPixels / displayMetrics.density));
            }
            mhVar.b = b8.b.intValue();
            if (b8.f89a == null) {
                DisplayMetrics displayMetrics2 = AdprofSdk.getInstance().getContext().getResources().getDisplayMetrics();
                b8.f89a = Integer.valueOf((int) (displayMetrics2.heightPixels / displayMetrics2.density));
            }
            mhVar.c = b8.f89a.intValue();
            mhVar.k = b8.a();
            mhVar.l = ig.a();
            u7 u7VarM721a = v7.a().m721a();
            Location locationA = u7VarM721a != null ? u7VarM721a.a() : he.m644a().m645a();
            if (locationA != null) {
                mhVar.m = locationA.getLatitude() + "";
                mhVar.n = locationA.getLongitude() + "";
            }
        } catch (Exception e) {
            b(e);
            pk.b("e = " + Log.getStackTraceString(e));
        }
    }

    public static void a(Throwable th) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String stackTraceString = Log.getStackTraceString(th);
            gh ghVar = new gh();
            ((mh) ghVar).f468b = "120";
            ghVar.a("crash");
            System.currentTimeMillis();
            ghVar.o = stackTraceString;
            if (TextUtils.isEmpty(((mh) ghVar).f470d)) {
                ((mh) ghVar).f470d = String.valueOf(System.currentTimeMillis());
            }
            ghVar.a((lh) null);
            pk.d("crash insert db cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th2) {
            pk.d("AFCrash = " + Log.getStackTraceString(th2));
        }
    }

    public static void a(String str) {
        try {
            gh ghVar = new gh();
            ((mh) ghVar).f468b = "103";
            ghVar.a("exception");
            System.currentTimeMillis();
            ghVar.o = str;
            ghVar.mo685a();
        } catch (Throwable th) {
            pk.d("AFCrash = " + Log.getStackTraceString(th));
        }
    }

    public static void a(String str, String str2, d dVar, wd wdVar, nh nhVar) {
        try {
            fh fhVar = new fh();
            ((mh) fhVar).f468b = "100";
            if (wdVar != null && wdVar.f793a > 0 && ("respond".equals(str) || "ready".equals(str))) {
                fhVar.f294a = System.currentTimeMillis() - wdVar.f793a;
                wdVar.f793a = System.currentTimeMillis();
            }
            fhVar.a(str);
            a(dVar, fhVar);
            a(wdVar, fhVar);
            a(fhVar);
            if (nhVar != null) {
                nhVar.a(fhVar);
            }
            fhVar.mo685a();
        } catch (Throwable th) {
            b(th);
            pk.d("sendPointEvent = " + Log.getStackTraceString(th));
        }
    }

    public static void a(d dVar, fh fhVar) {
        if (dVar != null) {
            try {
                fhVar.o = String.valueOf(dVar.f190a.f1499a);
                fhVar.s = dVar.k;
                fhVar.q = dVar.e();
                fhVar.p = dVar.m;
                fhVar.t = String.valueOf(dVar.b);
                fhVar.f = dVar.c;
                fhVar.e = dVar.m605f() ? 2 : 1;
                q0 q0Var = dVar.f188a;
                fhVar.g = q0Var != null ? q0Var.c : 1;
                fhVar.u = dVar.f206h;
                try {
                    wd wdVar = dVar.f190a;
                    fhVar.h = (wdVar.f1499a == 1 && wdVar.f794a.getIsExpressAd().booleanValue()) ? dVar.f180a : 0;
                } catch (Exception unused) {
                }
                try {
                    o1 o1Var = dVar.f188a.f639a;
                    fhVar.f1173a = o1Var != null ? o1Var.f1333a : 15.0d;
                } catch (Exception e) {
                    pk.d(Log.getStackTraceString(e));
                }
                try {
                    fhVar.b = dVar.f188a.f639a.f524a;
                } catch (Exception e2) {
                    pk.d(Log.getStackTraceString(e2));
                }
                try {
                    p0 p0Var = dVar.f188a.f640a;
                    fhVar.i = p0Var != null ? p0Var.f1353a : 0;
                } catch (Exception e3) {
                    pk.d(Log.getStackTraceString(e3));
                }
                try {
                    fhVar.j = dVar.f190a.b;
                } catch (Exception e4) {
                    pk.d(Log.getStackTraceString(e4));
                }
                fhVar.f295a = dVar.m600b();
                try {
                    fhVar.v = dVar.f188a.f641a.c;
                } catch (Exception unused2) {
                    fhVar.v = "";
                }
                try {
                    String strF = dVar.f();
                    if (strF != null && strF.length() > 25) {
                        strF = strF.substring(0, 25);
                    }
                    fhVar.w = strF;
                } catch (Exception e5) {
                    pk.d(Log.getStackTraceString(e5));
                }
                fhVar.x = dVar.i;
                fhVar.y = dVar.j;
            } catch (Throwable th) {
                b(th);
            }
        }
    }

    public static void a(wd wdVar, fh fhVar) {
        if (wdVar != null) {
            fhVar.q = wdVar.f795a;
            fhVar.p = wdVar.f797b;
            fhVar.j = wdVar.b;
            fhVar.o = String.valueOf(wdVar.f1499a);
            if (wdVar.f796a != null) {
                fhVar.r = new JSONObject(wdVar.f796a).toString();
            }
        }
    }
}
