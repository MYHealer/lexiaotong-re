package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.module.config.HiAnalyticsAutoConfig;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class h {
    public static int a(String str, int i) {
        z0 z0VarC = c(str, i);
        if (z0VarC != null) {
            return z0VarC.b();
        }
        j2.c("InstanceDataAccess", "getCacheExpiryTime tag=" + str + ",type=" + i + " not exist");
        return 7;
    }

    public static String a(String str) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.a();
        }
        j2.c("InstanceDataAccess", "getAccountBrandId tag=" + str + " not exist");
        return "";
    }

    public static String a(String str, int i, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            String strA = com.hihonor.hianalytics.util.g.a(i);
            i1 i1VarA = p1.a(null, str, strA, null, jSONObject);
            i1VarA.b(str2);
            jSONObject3.put("header", i1VarA.a());
            f1 f1VarA = p1.a(str, strA, (List<e1>) null);
            f1VarA.a(jSONObject2);
            j1 j1VarA = p1.a(str, strA, (String) null);
            JSONObject jSONObjectA = f1VarA.a();
            jSONObjectA.put("properties", j1VarA.a());
            String strC = c(str, strA);
            if (TextUtils.isEmpty(strC)) {
                jSONObjectA.put("events_global_properties", "");
            } else {
                jSONObjectA.put("events_global_properties", new JSONObject(strC));
            }
            jSONObject3.put("events_common", jSONObjectA);
        } catch (Throwable th) {
            j2.c("InstanceDataAccess", "getCommonIdAttrs tag=" + str + ",type=" + i + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
        return jSONObject3.toString();
    }

    public static String a(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.a();
        }
        j2.c("InstanceDataAccess", "getAAID tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static void a(long j) {
        z0 z0VarD = d("_default_config_tag", "oper");
        z0 z0VarD2 = d("_default_config_tag", "maint");
        z0 z0VarD3 = d("_default_config_tag", "preins");
        z0 z0VarD4 = d("_default_config_tag", "diffprivacy");
        if (z0VarD != null) {
            z0VarD.a(j);
        } else {
            j2.a("InstanceDataAccess", "setLastAutoReportTimeOfSingleInstance defaultOper null");
        }
        if (z0VarD2 != null) {
            z0VarD2.a(j);
        } else {
            j2.a("InstanceDataAccess", "setLastAutoReportTimeOfSingleInstance defaultMaint null");
        }
        if (z0VarD3 != null) {
            z0VarD3.a(j);
        } else {
            j2.a("InstanceDataAccess", "setLastAutoReportTimeOfSingleInstance defaultPre null");
        }
        if (z0VarD4 != null) {
            z0VarD4.a(j);
        } else {
            j2.a("InstanceDataAccess", "setLastAutoReportTimeOfSingleInstance defaultDiff null");
        }
    }

    public static void a(long j, String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD == null) {
            j2.c("InstanceDataAccess", "setLastAutoReportTime tag=" + str + ",type=" + str2 + " not exist");
        } else {
            z0VarD.a(j);
        }
    }

    public static void a(String str, String str2, String str3) {
        z0 z0VarD = d(str2, str3);
        if (z0VarD == null) {
            j2.c("InstanceDataAccess", "setInstanceUUID tag=" + str2 + ",type=" + str3 + " not exist");
        } else {
            z0VarD.e(str);
        }
    }

    public static String b(String str) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.b();
        }
        j2.c("InstanceDataAccess", "getAppBrandId tag=" + str + " not exist");
        return "";
    }

    public static String b(String str, int i) {
        z0 z0VarC = c(str, i);
        if (z0VarC != null) {
            return z0VarC.d();
        }
        j2.c("InstanceDataAccess", "getCollectURL tag=" + str + ",type=" + i + " not exist");
        return "";
    }

    public static String b(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.c();
        }
        j2.c("InstanceDataAccess", "getChannelCustom tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static z0 c(String str, int i) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.a(i);
        }
        j2.c("InstanceDataAccess", "getConfig tag=" + str + ",type=" + i + " not exist");
        return null;
    }

    public static String c(String str) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.c();
        }
        j2.c("InstanceDataAccess", "getAppid tag=" + str + " not exist");
        return "";
    }

    public static String c(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.k();
        }
        j2.c("InstanceDataAccess", "getCommonProp tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static int d(String str, int i) {
        z0 z0VarC = c(str, i);
        if (z0VarC != null) {
            return z0VarC.g();
        }
        j2.c("InstanceDataAccess", "getIdPriority tag=" + str + ",type=" + i + " not exist");
        return 0;
    }

    public static z0 d(String str, String str2) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.a(str2);
        }
        j2.c("InstanceDataAccess", "getConfig tag=" + str + ",type=" + str2 + " not exist");
        return null;
    }

    public static HiAnalyticsAutoConfig d(String str) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.d();
        }
        j2.c("InstanceDataAccess", "getAutoConfig tag=" + str + " not exist");
        return null;
    }

    public static int e(String str, int i) {
        int iF = p2.b().f(str);
        if (iF != -1) {
            return iF;
        }
        z0 z0VarC = c(str, i);
        if (z0VarC != null) {
            return z0VarC.j();
        }
        j2.c("InstanceDataAccess", "getLimitSize tag=" + str + ",type=" + i + " not exist");
        return 10;
    }

    public static String e(String str) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.f();
        }
        j2.c("InstanceDataAccess", "getHandsetManufacturer tag=" + str + " not exist");
        return "";
    }

    public static String e(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.f();
        }
        j2.c("InstanceDataAccess", "getHonorOaid tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static String f(String str) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.g();
        }
        j2.c("InstanceDataAccess", "getHansetBrandId tag=" + str + " not exist");
        return "";
    }

    public static String f(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.h();
        }
        j2.c("InstanceDataAccess", "getInstanceUUID tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static boolean f(String str, int i) {
        return c(str, i) != null;
    }

    public static long g(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.i();
        }
        j2.c("InstanceDataAccess", "getLastAutoReportTime tag=" + str + ",type=" + str2 + " not exist");
        return 0L;
    }

    public static com.hihonor.hianalytics.process.d g(String str) {
        return com.hihonor.hianalytics.process.a.c().c(str);
    }

    public static int h(String str) {
        int iE = p2.b().e(str);
        return iE != -1 ? iE : g.e();
    }

    public static String h(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.l();
        }
        j2.c("InstanceDataAccess", "getOAID tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static String i(String str) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA != null) {
            return c1VarA.k();
        }
        j2.a(TextUtils.isEmpty(str) ? 3 : 4, "InstanceDataAccess", "getSelfDataId tag=" + str + " not exist");
        return null;
    }

    public static String i(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.n();
        }
        j2.c("InstanceDataAccess", "getOAIDTrackingFlag tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static String j(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.m();
        }
        j2.c("InstanceDataAccess", "getUpid tag=" + str + ",type=" + str2 + " not exist");
        return "";
    }

    public static boolean k(String str, String str2) {
        z0 z0VarD = d(str, str2);
        if (z0VarD != null) {
            return z0VarD.s();
        }
        j2.c("InstanceDataAccess", "isUUIDEnabled tag=" + str + ",type=" + str2 + " not exist");
        return true;
    }

    public static void l(String str, String str2) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null) {
            j2.c("InstanceDataAccess", "setAccountBrandId tag=" + str + " not exist");
        } else {
            c1VarA.b(str2);
        }
    }

    public static void m(String str, String str2) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null) {
            j2.c("InstanceDataAccess", "setAppBrandId tag=" + str + " not exist");
        } else {
            c1VarA.c(str2);
        }
    }

    public static void n(String str, String str2) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null) {
            j2.c("InstanceDataAccess", "setAppid tag=" + str + " not exist");
        } else {
            c1VarA.d(str2);
        }
    }

    public static void o(String str, String str2) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null) {
            j2.c("InstanceDataAccess", "setHandsetManufacturer tag=" + str + " not exist");
        } else {
            c1VarA.e(str2);
        }
    }

    public static void p(String str, String str2) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null) {
            j2.c("InstanceDataAccess", "setHansetBrandId tag=" + str + " not exist");
        } else {
            c1VarA.f(str2);
        }
    }

    public static void q(String str, String str2) {
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null) {
            j2.a(TextUtils.isEmpty(str) ? 3 : 4, "InstanceDataAccess", "setSelfDataId tag=" + str + " not exist");
        } else {
            c1VarA.h(str2);
        }
    }
}
