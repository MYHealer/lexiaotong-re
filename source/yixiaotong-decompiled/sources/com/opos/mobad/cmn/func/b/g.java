package com.opos.mobad.cmn.func.b;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.byazt.hv.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.google.common.base.Ascii;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.constant.z;
import com.oplus.instant.router.callback.Callback;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.umeng.analytics.pro.am;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.opos.cmn.an.e.d.a f6837a;
    private static WeakReference<com.opos.mobad.cmn.service.pkginstall.c.b> d;
    private static final byte[] b = new byte[0];
    private static final byte[] c = new byte[0];
    private static final String e = com.opos.cmn.an.b.b.a("aGV5dGFwX3VuaW9uX3Rva2Vu");

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.b.g$1, reason: invalid class name */
    static class AnonymousClass1 implements com.opos.mobad.cmn.func.adhandler.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6838a;
        final /* synthetic */ View b;
        private com.opos.cmn.module.ui.b.a c;

        AnonymousClass1(Context context, View view) {
            this.f6838a = context;
            this.b = view;
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.c
        public void a() {
            com.opos.cmn.module.ui.b.a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.c
        public void a(final com.opos.mobad.cmn.func.adhandler.a.b bVar) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.g.1.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.c = g.c(anonymousClass1.f6838a, AnonymousClass1.this.b);
                    if (AnonymousClass1.this.c == null) {
                        bVar.a();
                    } else {
                        AnonymousClass1.this.c.a("当前为非Wi-Fi环境，\n是否继续下载？", com.hihonor.adsdk.base.c.g1.hnadsa, "取消", new com.opos.cmn.module.ui.b.d.a() { // from class: com.opos.mobad.cmn.func.b.g.1.1.1
                            @Override // com.opos.cmn.module.ui.b.d.a
                            public void a(View view, int[] iArr) {
                                bVar.a();
                                AnonymousClass1.this.c.a();
                            }

                            @Override // com.opos.cmn.module.ui.b.d.a
                            public void b(View view, int[] iArr) {
                                bVar.b();
                                AnonymousClass1.this.c.a();
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.b.g$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6841a;

        static {
            int[] iArr = new int[a.values().length];
            f6841a = iArr;
            try {
                iArr[a.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6841a[a.OUT_COUPONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6841a[a.FLOAT_LAYER_INTERSTITIAL_RETAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6841a[a.SHAKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6841a[a.LIGHT_INTERACTIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6841a[a.CLICK_BT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6841a[a.NON_CLICK_BT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6841a[a.FLOAT_LAYER_CLICK_BT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6841a[a.FLOAT_LAYER_NON_CLICK_BT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        String strE = com.opos.cmn.an.h.e.a.e(context);
        strE.hashCode();
        switch (strE) {
            case "telecom":
                return 2;
            case "mobile":
                return 1;
            case "unicom":
                return 3;
            default:
                return 0;
        }
    }

    public static int a(File file) {
        File[] fileArrListFiles;
        int length = 0;
        if (file != null) {
            try {
                if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    length = fileArrListFiles.length;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getFolderFilesCount folderFile=" + (file != null ? file.getAbsolutePath() : "null") + ",count=" + length);
        return length;
    }

    private static Activity a(View view) {
        if (view != null) {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                com.opos.cmn.an.f.a.b("Utils", "context instanceof ContextWrapper");
                if (context instanceof Activity) {
                    com.opos.cmn.an.f.a.b("Utils", "context instanceof Activity");
                    return (Activity) context;
                }
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getActivity = null");
        return null;
    }

    public static final ActivityInfo a(Context context, Class cls) {
        if (context == null || cls == null) {
            return null;
        }
        try {
            return context.getPackageManager().getActivityInfo(new ComponentName(context, (Class<?>) cls), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            com.opos.cmn.an.f.a.c("Utils", "", e2);
            return null;
        }
    }

    public static com.opos.mobad.cmn.func.adhandler.a.c a(Context context, View view) {
        return new AnonymousClass1(context, view);
    }

    public static com.opos.mobad.model.c.c a(com.opos.mobad.b bVar, String str, int i, String str2, List<String> list) {
        return a(bVar, str, i, str2, (List<String>) null, false);
    }

    public static com.opos.mobad.model.c.c a(com.opos.mobad.b bVar, String str, int i, String str2, List<String> list, boolean z) {
        if (bVar == null || com.opos.cmn.an.d.a.a(str)) {
            return null;
        }
        com.opos.mobad.model.c.c cVar = new com.opos.mobad.model.c.c();
        cVar.b(str);
        cVar.c(i);
        int[] iArrA = a(bVar.b(), i);
        cVar.d(iArrA[1]);
        cVar.e(iArrA[0]);
        cVar.a(str2);
        cVar.b(e());
        cVar.c(bVar.g().c());
        cVar.e(bVar.g().b());
        cVar.d(bVar.g().a());
        cVar.a(list);
        cVar.a(z);
        cVar.g(bVar.g().d());
        cVar.h(bVar.g().e());
        cVar.i(bVar.g().f());
        return cVar;
    }

    public static MaterialFileData a(AdItemData adItemData) {
        List<MaterialData> listI;
        MaterialData materialData;
        List<MaterialFileData> listD;
        if (adItemData == null || (listI = adItemData.i()) == null || listI.size() <= 0 || (materialData = listI.get(0)) == null || (listD = materialData.D()) == null || listD.size() <= 0) {
            return null;
        }
        return listD.get(0);
    }

    public static String a(Context context, String str, int[] iArr, long j) {
        int iIndexOf;
        com.opos.cmn.an.f.a.b("Utils", "handleMacroInMonitorLinkUrl before=" + (str != null ? str : "null"));
        if (context != null && !com.opos.cmn.an.d.a.a(str) && str.length() > 0) {
            int iIndexOf2 = str.indexOf("$");
            StringBuilder sb = new StringBuilder();
            if (-1 != iIndexOf2) {
                int iIndexOf3 = 0;
                sb.append(str.substring(0, iIndexOf2));
                String strSubstring = str.substring(iIndexOf2);
                do {
                    int i = iIndexOf3 + 1;
                    iIndexOf = strSubstring.indexOf("$", i);
                    if (-1 != iIndexOf) {
                        String strB = b(context, strSubstring.substring(i, iIndexOf), iArr, j);
                        if (com.opos.cmn.an.d.a.a(strB)) {
                            strB = strSubstring.substring(iIndexOf3, iIndexOf + 1);
                        }
                        sb.append(strB);
                        int i2 = iIndexOf + 1;
                        iIndexOf3 = strSubstring.indexOf("$", i2);
                        sb.append((-1 == iIndexOf3 || iIndexOf3 < iIndexOf) ? strSubstring.substring(i2) : strSubstring.substring(i2, iIndexOf3));
                    } else {
                        sb.append(strSubstring);
                    }
                    if (-1 == iIndexOf3) {
                        break;
                    }
                } while (-1 != iIndexOf);
                str = sb.toString();
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "handleMacroInMonitorLinkUrl after=" + str);
        return str;
    }

    public static final String a(String str, String str2, String str3, String str4) {
        String strA = "";
        if (!com.opos.cmn.an.d.a.a(str3)) {
            try {
                String strD = d(str3);
                com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
                StringBuilder sbAppend = new StringBuilder().append(c0991aL != null ? c0991aL.f7355a : "").append(com.opos.cmn.an.b.d.a(strD)).append(str4);
                if (str == null) {
                    str = "";
                }
                StringBuilder sbAppend2 = sbAppend.append(str);
                if (str2 == null) {
                    str2 = "";
                }
                strA = com.opos.cmn.an.b.c.a(sbAppend2.append(str2).toString());
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "jsSign=" + strA);
        return strA;
    }

    public static void a() {
        b.b = true;
        com.opos.cmn.an.f.a.b("Utils", "setSdkInitSuccess");
    }

    public static void a(Context context, String str, long j) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.d.a.a(str)) {
                    return;
                }
                h(context).a(str, Long.valueOf(j));
                com.opos.cmn.an.f.a.b("Utils", "putRewardTime pkgName=" + str + ",timestamp=" + j);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, Callback callback, String str4) {
        try {
            c.a(context, str, str2, str3, callback, "10001", str4);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        c.a(context, str, str2, str3, "10001", str4);
    }

    public static void a(com.opos.mobad.cmn.service.pkginstall.c.b bVar) {
        try {
            com.opos.cmn.an.f.a.b("Utils", "setCacheInterBaseAd=" + (bVar != null ? bVar : "null"));
            if (bVar != null) {
                d = new WeakReference<>(bVar);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(String str) {
        b.f6805a = str;
        StringBuilder sb = new StringBuilder("setAppId=");
        if (str == null) {
            str = "";
        }
        com.opos.cmn.an.f.a.b("Utils", sb.append(str).toString());
    }

    public static void a(boolean z) {
        b.e = z;
    }

    private static boolean a(int i) {
        if (i == 1 || i == 5 || i == 7 || i == 8) {
            return true;
        }
        com.opos.cmn.an.f.a.b("Utils", "isLinkType result:false");
        return false;
    }

    public static boolean a(Activity activity) {
        boolean z = false;
        if (activity != null) {
            try {
                if ("".equals(d(activity)) || c(activity).equals(d(activity))) {
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isCurrentActivity=" + z);
        return z;
    }

    public static boolean a(Context context, String str) {
        boolean zE = false;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.a.a(str) && com.opos.cmn.an.h.d.a.d(context, str)) {
                    zE = com.opos.cmn.an.h.d.a.e(context, str);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder("launchAppHomePage pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.a("Utils", sb.append(str).append(",result=").append(zE).toString());
        return zE;
    }

    public static boolean a(com.opos.mobad.b bVar) {
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular before=" + b.e);
        boolean z = true;
        try {
            if (!b.e) {
                z = false;
            } else if (!bVar.n().e()) {
                b.e = false;
                z = false;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular=" + z);
        return z;
    }

    public static boolean a(com.opos.mobad.b bVar, AdItemData adItemData, a aVar) {
        return a(adItemData, aVar) && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(bVar.b())) && a(bVar);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    public static boolean a(com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, int[] iArr) {
        boolean z = false;
        if (bVar != null && adItemData != null && materialData != null) {
            String strQ = materialData.q();
            String strI = materialData.i();
            try {
                if (TextUtils.isEmpty(strQ) || !b(bVar.b(), strQ)) {
                    if (a(bVar.b(), strI)) {
                        e.a(bVar, adItemData, adItemData.i().get(0), true, iArr);
                    }
                    StringBuilder sb = new StringBuilder("launchAppPage url=");
                    if (strQ == null) {
                        strQ = "null";
                    }
                    StringBuilder sbAppend = sb.append(strQ).append(",pkgName=");
                    if (strI == null) {
                        strI = "null";
                    }
                    com.opos.cmn.an.f.a.a("Utils", sbAppend.append(strI).append(",result=").append(z).toString());
                } else {
                    e.c(bVar, adItemData.g(), adItemData, adItemData.i().get(0), true, iArr, null);
                }
                z = true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
            StringBuilder sb2 = new StringBuilder("launchAppPage url=");
            if (strQ == null) {
                strQ = "null";
            }
            StringBuilder sbAppend2 = sb2.append(strQ).append(",pkgName=");
            if (strI == null) {
                strI = "null";
            }
            com.opos.cmn.an.f.a.a("Utils", sbAppend2.append(strI).append(",result=").append(z).toString());
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c7  */
    public static boolean a(AdItemData adItemData, a aVar) {
        boolean z = false;
        if (adItemData != null && adItemData.i() != null && adItemData.i().size() > 0) {
            switch (AnonymousClass2.f6841a[aVar.ordinal()]) {
                case 1:
                    if (2 == adItemData.i().get(0).H() && 2 == adItemData.i().get(0).I()) {
                        z = true;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (2 == adItemData.i().get(0).d() && 2 == adItemData.i().get(0).I()) {
                        z = true;
                    }
                    break;
                case 7:
                    if (2 == adItemData.i().get(0).G() && 2 == adItemData.i().get(0).I()) {
                        z = true;
                    }
                    break;
                case 8:
                    if (2 == adItemData.i().get(0).S() && 2 == adItemData.i().get(0).I()) {
                        z = true;
                    }
                    break;
                case 9:
                    if (2 == adItemData.i().get(0).T() && 2 == adItemData.i().get(0).I()) {
                        z = true;
                    }
                    break;
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isDownloaderTypeAd=" + z);
        return z;
    }

    public static boolean a(AdItemData adItemData, MaterialData materialData) {
        if (adItemData != null && adItemData.F() == 1) {
            return true;
        }
        if (materialData == null) {
            return false;
        }
        String strP = materialData.p();
        if (!TextUtils.isEmpty(strP)) {
            try {
                String strOptString = new JSONObject(strP).optString("adCat");
                if (!TextUtils.isEmpty(strOptString) && "3".equals(strOptString)) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a(materialData.d()) || a(materialData.H()) || a(materialData.G());
    }

    public static boolean a(MaterialData materialData) {
        boolean z = false;
        if (materialData != null) {
            try {
                if ((3 == materialData.G() && 2 == materialData.I()) || ((3 == materialData.H() && 2 == materialData.I()) || (3 == materialData.d() && 2 == materialData.I()))) {
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isMiddleDownloader result:" + z);
        return z;
    }

    public static boolean a(Map<String, String> map) {
        return map != null && map.containsKey("isVisibleRect") && map.containsKey("isAttached");
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0024  */
    private static int[] a(Context context, int i) {
        int[] iArr = {0, 0};
        if (i == 1) {
            iArr[0] = 1080;
            iArr[1] = 171;
        } else if (i == 2) {
            iArr[0] = 720;
            iArr[1] = 600;
        } else if (i == 3) {
            iArr[0] = 1080;
            iArr[1] = c(context);
        } else if (i == 5) {
            iArr[0] = com.opos.cmn.an.h.f.a.b(context);
            iArr[1] = com.opos.cmn.an.h.f.a.c(context);
        } else if (i == 6) {
            iArr[0] = 1080;
            iArr[1] = c(context);
        }
        return iArr;
    }

    public static int b(String str) {
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return 0;
            }
            return a(new File(str));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            return 0;
        }
    }

    public static com.opos.mobad.cmn.func.adhandler.a.c b(Activity activity) {
        return a(activity, (View) null);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:91:0x0163  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static String b(Context context, String str, int[] iArr, long j) {
        byte b2;
        String strC;
        StringBuilder sbAppend;
        String str2 = null;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.a.a(str)) {
                    switch (str.hashCode()) {
                        case -1001078227:
                            if (!str.equals("progress")) {
                                b2 = -1;
                            } else {
                                b2 = 13;
                            }
                            break;
                        case z.k /* 99 */:
                            if (!str.equals("c")) {
                                b2 = -1;
                            } else {
                                b2 = 4;
                            }
                            break;
                        case 104:
                            if (!str.equals(IAdInterListener.AdReqParam.HEIGHT)) {
                                b2 = -1;
                            } else {
                                b2 = 6;
                            }
                            break;
                        case 109:
                            if (!str.equals("m")) {
                                b2 = -1;
                            } else {
                                b2 = 2;
                            }
                            break;
                        case 119:
                            if (!str.equals(IAdInterListener.AdReqParam.WIDTH)) {
                                b2 = -1;
                            } else {
                                b2 = 5;
                            }
                            break;
                        case 3125:
                            if (!str.equals(com.alipay.sdk.sys.a.k)) {
                                b2 = -1;
                            } else {
                                b2 = 8;
                            }
                            break;
                        case 3138:
                            if (!str.equals("bd")) {
                                b2 = -1;
                            } else {
                                b2 = 19;
                            }
                            break;
                        case 3166:
                            if (!str.equals("ca")) {
                                b2 = -1;
                            } else {
                                b2 = 10;
                            }
                            break;
                        case 3185:
                            if (!str.equals("ct")) {
                                b2 = -1;
                            } else {
                                b2 = 14;
                            }
                            break;
                        case 3220:
                            if (!str.equals("dx")) {
                                b2 = -1;
                            } else {
                                b2 = 15;
                            }
                            break;
                        case 3221:
                            if (!str.equals("dy")) {
                                b2 = -1;
                            } else {
                                b2 = 16;
                            }
                            break;
                        case 3526:
                            if (!str.equals("nt")) {
                                b2 = -1;
                            } else {
                                b2 = 9;
                            }
                            break;
                        case 3556:
                            if (!str.equals(am.x)) {
                                b2 = -1;
                            } else {
                                b2 = 0;
                            }
                            break;
                        case 3559:
                            if (!str.equals("ov")) {
                                b2 = -1;
                            } else {
                                b2 = 1;
                            }
                            break;
                        case 3636:
                            if (!str.equals(RedirectReqWrapper.KEY_REFER)) {
                                b2 = -1;
                            } else {
                                b2 = 12;
                            }
                            break;
                        case 3724:
                            if (!str.equals("ua")) {
                                b2 = -1;
                            } else {
                                b2 = 11;
                            }
                            break;
                        case 3747:
                            if (!str.equals("ux")) {
                                b2 = -1;
                            } else {
                                b2 = 17;
                            }
                            break;
                        case 3748:
                            if (!str.equals("uy")) {
                                b2 = -1;
                            } else {
                                b2 = Ascii.DC2;
                            }
                            break;
                        case 106905:
                            if (!str.equals("lan")) {
                                b2 = -1;
                            } else {
                                b2 = 3;
                            }
                            break;
                        case 111052:
                            if (!str.equals(OapsKey.KEY_PKG)) {
                                b2 = -1;
                            } else {
                                b2 = 7;
                            }
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        case 0:
                            strC = "android";
                            str2 = strC;
                            break;
                        case 1:
                            strC = com.opos.cmn.an.c.c.c();
                            str2 = strC;
                            break;
                        case 2:
                            strC = com.opos.cmn.an.c.c.a();
                            str2 = strC;
                            break;
                        case 3:
                            strC = com.opos.cmn.an.c.b.a();
                            str2 = strC;
                            break;
                        case 4:
                            strC = com.opos.cmn.an.c.b.b();
                            str2 = strC;
                            break;
                        case 5:
                            sbAppend = new StringBuilder().append(com.opos.cmn.an.h.f.a.b(context)).append("");
                            strC = sbAppend.toString();
                            str2 = strC;
                            break;
                        case 6:
                            sbAppend = new StringBuilder().append(com.opos.cmn.an.h.f.a.c(context)).append("");
                            strC = sbAppend.toString();
                            str2 = strC;
                            break;
                        case 7:
                            strC = context.getPackageName();
                            str2 = strC;
                            break;
                        case 8:
                            strC = com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
                            str2 = strC;
                            break;
                        case 9:
                            strC = com.opos.cmn.an.h.c.a.h(context);
                            str2 = strC;
                            break;
                        case 10:
                            sbAppend = new StringBuilder().append(a(context)).append("");
                            strC = sbAppend.toString();
                            str2 = strC;
                            break;
                        case 11:
                            strC = h();
                            str2 = strC;
                            break;
                        case 12:
                        case 14:
                            str2 = "";
                            break;
                        case 13:
                            sbAppend = new StringBuilder().append(j).append("");
                            strC = sbAppend.toString();
                            str2 = strC;
                            break;
                        case 15:
                            if (iArr != null && iArr.length == 4) {
                                sbAppend = new StringBuilder().append(iArr[0]).append("");
                                strC = sbAppend.toString();
                                str2 = strC;
                            } else {
                                str2 = "-999";
                            }
                            break;
                        case 16:
                            if (iArr != null && iArr.length == 4) {
                                sbAppend = new StringBuilder().append(iArr[1]).append("");
                                strC = sbAppend.toString();
                                str2 = strC;
                            } else {
                                str2 = "-999";
                            }
                            break;
                        case 17:
                            if (iArr != null && iArr.length == 4) {
                                sbAppend = new StringBuilder().append(iArr[2]).append("");
                                strC = sbAppend.toString();
                                str2 = strC;
                            } else {
                                str2 = "-999";
                            }
                            break;
                        case 18:
                            if (iArr != null && iArr.length == 4) {
                                sbAppend = new StringBuilder().append(iArr[3]).append("");
                                strC = sbAppend.toString();
                                str2 = strC;
                            } else {
                                str2 = "-999";
                            }
                            break;
                        case 19:
                            strC = com.opos.cmn.an.c.a.a(context);
                            str2 = strC;
                            break;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder("key=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("Utils", sb.append(str).append(",value=").append(str2 != null ? str2 : "null").toString());
        return str2 != null ? str2 : "";
    }

    public static Map<String, Long> b(Context context) {
        Map mapA = null;
        mapA = null;
        if (context != null) {
            try {
                mapA = h(context).a();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getAllRewardTime size=" + (mapA != null ? Integer.valueOf(mapA.size()) : "null"));
        return mapA;
    }

    public static boolean b() {
        return b.b;
    }

    public static boolean b(Context context, Class cls) {
        ActivityInfo activityInfoA = a(context, cls);
        if (activityInfoA == null) {
            return false;
        }
        com.opos.cmn.an.f.a.b("Utils", "is standard launch mode" + activityInfoA.launchMode);
        return activityInfoA.launchMode == 0;
    }

    public static boolean b(Context context, String str) {
        boolean z = false;
        if (context != null && !com.opos.cmn.an.d.a.a(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.addFlags(268435456);
                if (com.opos.cmn.an.h.d.a.a(context, intent)) {
                    context.startActivity(intent);
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder("launchAppDetailPage url=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.a("Utils", sb.append(str).append("result=").append(z).toString());
        return z;
    }

    private static int c(Context context) {
        com.opos.cmn.an.h.f.a.k(context);
        if (f(context) || e(context)) {
            return 1872;
        }
        return g(context) ? 1752 : 1512;
    }

    public static final int c(String str) {
        int iLastIndexOf = -1;
        try {
            if (!com.opos.cmn.an.d.a.a(str)) {
                iLastIndexOf = str.lastIndexOf(e);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "getJsSignParamIndex=" + iLastIndexOf);
        return iLastIndexOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.opos.cmn.module.ui.b.a c(Context context, View view) {
        Activity activityA;
        if (context instanceof Activity) {
            activityA = (Activity) context;
        } else {
            activityA = view != null ? a(view.getRootView().findViewById(R.id.content)) : null;
        }
        if (activityA == null) {
            return null;
        }
        return new com.opos.cmn.module.ui.b.a(activityA);
    }

    private static String c(Activity activity) {
        String name;
        try {
            name = activity.getClass().getName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            name = "";
        }
        com.opos.cmn.an.f.a.b("Utils", "getActivityClassName=" + (name != null ? name : "null"));
        return name;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00d0 A[PHI: r8
  0x00d0: PHI (r8v5 java.lang.String) = (r8v3 java.lang.String), (r8v3 java.lang.String), (r8v6 java.lang.String) binds: [B:8:0x001c, B:10:0x0022, B:23:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
    public static String c(Context context, String str) {
        String strG;
        String strSubstring = "";
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.a.a(str)) {
                    strG = com.opos.cmn.an.h.d.a.g(context, str);
                    try {
                        if (com.opos.cmn.an.d.a.a(strG) || strG.length() <= 0) {
                            strSubstring = strG;
                        } else {
                            int iIndexOf = strG.indexOf("(");
                            int iIndexOf2 = strG.indexOf(")");
                            com.opos.cmn.an.f.a.b("Utils", "english first=" + iIndexOf + ",english last=" + iIndexOf2);
                            if (-1 == iIndexOf || -1 == iIndexOf2) {
                                iIndexOf = strG.indexOf("（");
                                iIndexOf2 = strG.indexOf("）");
                                com.opos.cmn.an.f.a.b("Utils", "chinese first=" + iIndexOf + ",chinese last=" + iIndexOf2);
                            }
                            if (-1 != iIndexOf && -1 != iIndexOf2 && iIndexOf2 > iIndexOf) {
                                strG = strG.substring(0, iIndexOf) + strG.substring(iIndexOf2 + 1, strG.length());
                            }
                            int iIndexOf3 = strG.indexOf(x.A);
                            com.opos.cmn.an.f.a.b("Utils", "english - =" + iIndexOf3);
                            if (-1 == iIndexOf3) {
                                iIndexOf3 = strG.indexOf("—");
                                com.opos.cmn.an.f.a.b("Utils", "chinese — =" + iIndexOf3);
                            }
                            if (-1 != iIndexOf3) {
                                strSubstring = strG.substring(0, iIndexOf3);
                            } else {
                                strSubstring = strG;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                strG = "";
            }
        }
        strG = strSubstring;
        com.opos.cmn.an.f.a.b("Utils", "getAppDefaultTitle=" + strG);
        return strG;
    }

    public static boolean c() {
        return com.opos.cmn.an.c.c.b() >= 19;
    }

    public static long d(Context context, String str) {
        long jA = 0;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.a.a(str)) {
                    jA = h(context).a(str, 0L);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder("getRewardTime pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("Utils", sb.append(str).append(",timestamp=").append(jA).toString());
        return jA;
    }

    private static String d(Context context) {
        String className;
        try {
            className = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            className = "";
        }
        com.opos.cmn.an.f.a.b("Utils", "getCurrentActivityName=" + (className != null ? className : "null"));
        return className;
    }

    private static final String d(String str) {
        try {
            int iC = c(str);
            if (-1 != iC) {
                str = str.substring(0, iC - 1);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "result=" + str);
        return str;
    }

    public static boolean d() {
        String str;
        if (!c()) {
            str = "sdk not support android sdk version <19";
        } else {
            if (b()) {
                return true;
            }
            str = "init sdk failed!do nothing.";
        }
        com.opos.cmn.an.f.a.d("Utils", str);
        return false;
    }

    public static int e() {
        return 480;
    }

    public static void e(Context context, String str) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.d.a.a(str)) {
                    return;
                }
                h(context).a(str);
                com.opos.cmn.an.f.a.b("Utils", "removeRewardTime pkgName=" + str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    private static boolean e(Context context) {
        boolean z = 2.1666667f <= com.opos.cmn.an.h.f.a.k(context);
        com.opos.cmn.an.f.a.b("Utils", "isCurvedScreenAspectRatio=" + z);
        return z;
    }

    public static String f() {
        return "opos_mobad_v810004_2025_04_01_release";
    }

    private static boolean f(Context context) {
        boolean z = 2.1111112f == com.opos.cmn.an.h.f.a.k(context);
        com.opos.cmn.an.f.a.b("Utils", "isShapedScreenAspectRatio=" + z);
        return z;
    }

    public static boolean f(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                String strA = com.opos.cmn.biz.a.c.a(context);
                com.opos.cmn.an.f.a.b("Utils", "getMarketName=" + strA);
                if (!g(context, strA)) {
                    com.opos.cmn.an.f.a.a("Utils", " unsupport Market");
                    return false;
                }
                intent.setPackage(strA);
                if (context instanceof Activity) {
                    ((Activity) context).startActivity(intent);
                } else {
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                }
                z = true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.a("Utils", "executeDeeplinkDownloadApp result = " + z);
        return z;
    }

    public static int g() {
        return 810004;
    }

    private static boolean g(Context context) {
        float fK = com.opos.cmn.an.h.f.a.k(context);
        boolean z = 2.0f == fK || 2.0370371f == fK;
        com.opos.cmn.an.f.a.b("Utils", "isFullScreenAspectRatio=" + z);
        return z;
    }

    private static boolean g(Context context, String str) {
        boolean z = false;
        if (context != null) {
            try {
                if (com.opos.cmn.an.h.d.a.d(context, str) && h(context, str)) {
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "supportMarket=" + z);
        return z;
    }

    private static com.opos.cmn.an.e.d.a h(Context context) {
        com.opos.cmn.an.e.d.a aVar = f6837a;
        if (aVar == null) {
            synchronized (b) {
                aVar = f6837a;
                if (aVar == null) {
                    aVar = new com.opos.cmn.an.e.d.a(context, "mobad.reward.prefs", 0);
                    f6837a = aVar;
                }
            }
        }
        return aVar;
    }

    public static String h() {
        String property;
        try {
            property = System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            property = "";
        }
        com.opos.cmn.an.f.a.b("Utils", "getUserAgent=" + (property != null ? property : "null"));
        return property;
    }

    private static boolean h(Context context, String str) {
        boolean z = false;
        try {
            if (com.opos.cmn.an.h.d.a.h(context, str) != null && com.opos.cmn.an.h.d.a.h(context, str).enabled) {
                z = true;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "isPkgEnabled=" + z);
        return z;
    }

    public static com.opos.mobad.cmn.service.pkginstall.c.b i() {
        com.opos.mobad.cmn.service.pkginstall.c.b bVar = null;
        try {
            WeakReference<com.opos.mobad.cmn.service.pkginstall.c.b> weakReference = d;
            if (weakReference != null && weakReference.get() != null) {
                bVar = d.get();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "getCacheInterBaseAd=" + (bVar != null ? bVar : "null"));
        return bVar;
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT <= 29;
    }
}
