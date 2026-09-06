package com.meishu.sdk.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.bv.BaseConstants;
import com.google.gson.Gson;
import com.meishu.sdk.activity.MeishuWebviewActivity;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.loader.ShareInteractionListener;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.view.DownLoadDialogActivity;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClickHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f {

    /* JADX INFO: compiled from: ClickHandler.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoftReference f4902a;
        public final /* synthetic */ AdSlot b;
        public final /* synthetic */ SoftReference c;
        public final /* synthetic */ l0 d;
        public final /* synthetic */ List e;
        public final /* synthetic */ boolean f;

        public a(SoftReference softReference, AdSlot adSlot, SoftReference softReference2, l0 l0Var, List list, boolean z) {
            this.f4902a = softReference;
            this.b = adSlot;
            this.c = softReference2;
            this.d = l0Var;
            this.e = list;
            this.f = z;
        }

        /* JADX INFO: Removed unreachable split cross block B:110:0x0263 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            String str;
            String[] eventUrl;
            String str2;
            String[] eventUrl2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Gson gson = new Gson();
            int i = q0.k;
            int i2 = i > 0 ? i * 1000 : 2000;
            Object[] objArr = false;
            Object[] objArr2 = false;
            while (System.currentTimeMillis() - jCurrentTimeMillis <= 5000) {
                try {
                    PackageBean.AdBean adBean = q0.m;
                    if (adBean != null && adBean.getCrdpf() == 1 && !this.e.isEmpty() && !((Boolean) this.e.get(0)).booleanValue()) {
                        LogUtil.d("ClickHandler", "open deeplink fail. break");
                        f.a((Context) this.f4902a.get(), this.b, (com.meishu.sdk.platform.ms.c) this.c.get(), this.d.e ? 1 : 0);
                        return;
                    }
                } catch (Exception unused) {
                }
                if (!f.a(this.f4902a) || !f.a(this.c)) {
                    LogUtil.d("ClickHandler", "reference invalid. break");
                    f.a((Context) this.f4902a.get(), this.b, (com.meishu.sdk.platform.ms.c) this.c.get(), this.d.e ? 1 : 0);
                    return;
                }
                try {
                    Thread.sleep(500L);
                    try {
                        try {
                            if (!com.meishu.sdk.core.service.d.a()) {
                                try {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                    if (com.meishu.sdk.core.service.d.a()) {
                                        if (objArr2 == false && f.a(this.b, (com.meishu.sdk.platform.ms.c) this.c.get())) {
                                            PackageBean.HappyBean happyBean = q0.j;
                                            if (happyBean != null) {
                                                happyBean.setLastTime(System.currentTimeMillis());
                                                q.a().b("happybean", gson.toJson(q0.j));
                                                AdSdk.getSharedPreferences().edit().putString("happybean", gson.toJson(q0.j)).apply();
                                            }
                                            AdSlot adSlot = this.b;
                                            if (adSlot instanceof BaseAdSlot) {
                                                String dpsign = ((BaseAdSlot) adSlot).getDPSIGN();
                                                eventUrl2 = ((BaseAdSlot) this.b).getEventUrl();
                                                str2 = dpsign;
                                            } else {
                                                str2 = null;
                                                eventUrl2 = null;
                                            }
                                            o0.a((Context) this.f4902a.get(), this.b.getDeep_link(), this.b.getDpSign(), this.b.getDp_start(), str2, eventUrl2, this.f);
                                            try {
                                                Thread.sleep(i2);
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                            }
                                            if (com.meishu.sdk.core.service.d.a()) {
                                                return;
                                            }
                                            f.a(this.b, (Context) this.f4902a.get(), (com.meishu.sdk.platform.ms.c) this.c.get(), this.d.e);
                                            return;
                                        }
                                    } else if (jCurrentTimeMillis2 >= i2) {
                                        f.a(this.b, (Context) this.f4902a.get(), (com.meishu.sdk.platform.ms.c) this.c.get(), this.d.e);
                                        return;
                                    }
                                    objArr = true;
                                } catch (Throwable th) {
                                    th = th;
                                    objArr = true;
                                    th.printStackTrace();
                                }
                            } else if (objArr != false && objArr2 == false && f.a(this.b, (com.meishu.sdk.platform.ms.c) this.c.get())) {
                                PackageBean.HappyBean happyBean2 = q0.j;
                                if (happyBean2 != null) {
                                    happyBean2.setLastTime(System.currentTimeMillis());
                                    q.a().b("happybean", gson.toJson(q0.j));
                                    AdSdk.getSharedPreferences().edit().putString("happybean", gson.toJson(q0.j)).apply();
                                }
                                AdSlot adSlot2 = this.b;
                                if (adSlot2 instanceof BaseAdSlot) {
                                    String dpsign2 = ((BaseAdSlot) adSlot2).getDPSIGN();
                                    eventUrl = ((BaseAdSlot) this.b).getEventUrl();
                                    str = dpsign2;
                                } else {
                                    str = null;
                                    eventUrl = null;
                                }
                                o0.a((Context) this.f4902a.get(), this.b.getDeep_link(), this.b.getDpSign(), this.b.getDp_start(), str, eventUrl, this.f);
                                try {
                                    Thread.sleep(i2);
                                } catch (InterruptedException e3) {
                                    e3.printStackTrace();
                                }
                                if (com.meishu.sdk.core.service.d.a()) {
                                    return;
                                }
                                f.a(this.b, (Context) this.f4902a.get(), (com.meishu.sdk.platform.ms.c) this.c.get(), this.d.e);
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objArr = false;
                            objArr2 = true;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th.printStackTrace();
                    }
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
            }
            LogUtil.d("ClickHandler", "check self background timeout");
            f.a((Context) this.f4902a.get(), this.b, (com.meishu.sdk.platform.ms.c) this.c.get(), this.d.e ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: ClickHandler.java */
    public class b extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f4903a;
        public final /* synthetic */ com.meishu.sdk.platform.ms.c b;
        public final /* synthetic */ boolean c;

        public b(Method method, com.meishu.sdk.platform.ms.c cVar, boolean z) {
            this.f4903a = method;
            this.b = cVar;
            this.c = z;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                this.f4903a.setAccessible(true);
                this.f4903a.invoke(this.b.getInteractionListener(), Boolean.valueOf(this.c));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x011c A[PHI: r6 r7 r8
  0x011c: PHI (r6v4 java.lang.String) = 
  (r6v3 java.lang.String)
  (r6v2 java.lang.String)
  (r6v2 java.lang.String)
  (r6v2 java.lang.String)
  (r6v6 java.lang.String)
 binds: [B:85:0x0124, B:65:0x00ea, B:67:0x00f4, B:69:0x00fc, B:80:0x0117] A[DONT_GENERATE, DONT_INLINE]
  0x011c: PHI (r7v4 java.lang.String) = 
  (r7v3 java.lang.String)
  (r7v2 java.lang.String)
  (r7v2 java.lang.String)
  (r7v2 java.lang.String)
  (r7v6 java.lang.String)
 binds: [B:85:0x0124, B:65:0x00ea, B:67:0x00f4, B:69:0x00fc, B:80:0x0117] A[DONT_GENERATE, DONT_INLINE]
  0x011c: PHI (r8v6 java.lang.String) = 
  (r8v5 java.lang.String)
  (r8v4 java.lang.String)
  (r8v4 java.lang.String)
  (r8v4 java.lang.String)
  (r8v8 java.lang.String)
 binds: [B:85:0x0124, B:65:0x00ea, B:67:0x00f4, B:69:0x00fc, B:80:0x0117] A[DONT_GENERATE, DONT_INLINE]] */
    public static String a(String str, IAd iAd) {
        String str2;
        String default_coord;
        TouchPositionListener.TouchPosition touchPosition = iAd.getTouchData().getTouchPosition();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int upY = -999;
        String strValueOf = String.valueOf((touchPosition == null || touchPosition.getDownX() == 0) ? -999 : touchPosition.getDownX());
        String strValueOf2 = String.valueOf((touchPosition == null || touchPosition.getDownY() == 0) ? -999 : touchPosition.getDownY());
        String strValueOf3 = String.valueOf((touchPosition == null || touchPosition.getUpX() == 0) ? -999 : touchPosition.getUpX());
        if (touchPosition != null && touchPosition.getUpY() != 0) {
            upY = touchPosition.getUpY();
        }
        String strValueOf4 = String.valueOf(upY);
        String strValueOf5 = String.valueOf((touchPosition == null || touchPosition.getTouchTime() == null) ? jCurrentTimeMillis / 1000 : touchPosition.getTouchTime().getTime() / 1000);
        if (touchPosition != null && touchPosition.getTouchTime() != null) {
            jCurrentTimeMillis = touchPosition.getTouchTime().getTime();
        }
        String strValueOf6 = String.valueOf(jCurrentTimeMillis);
        String strValueOf7 = String.valueOf((touchPosition == null || touchPosition.getDownTime() == null) ? "__M_DOWN_TIME__" : Long.valueOf(touchPosition.getDownTime().getTime()));
        String strValueOf8 = String.valueOf((touchPosition == null || touchPosition.getUpTime() == null) ? "__M_UP_TIME__" : Long.valueOf(touchPosition.getUpTime().getTime()));
        int iB = (int) m.b(AdSdk.getContext(), Integer.MIN_VALUE);
        if (String.valueOf(iB).equals(strValueOf3)) {
            strValueOf3 = "0";
        }
        if (String.valueOf(iB).equals(strValueOf4)) {
            strValueOf4 = "0";
        }
        try {
            if (iAd instanceof com.meishu.sdk.platform.ms.c) {
                AdSlot adSlotA = ((com.meishu.sdk.platform.ms.c) iAd).a();
                if (!(adSlotA instanceof BaseAdSlot) || (default_coord = ((BaseAdSlot) adSlotA).getDefault_coord()) == null) {
                    str2 = strValueOf4;
                } else {
                    if ("-999".equals(strValueOf)) {
                        strValueOf = default_coord;
                    }
                    if ("-999".equals(strValueOf2)) {
                        strValueOf2 = default_coord;
                    }
                    if ("-999".equals(strValueOf3)) {
                        strValueOf3 = default_coord;
                    }
                    if ("-999".equals(strValueOf4)) {
                        str2 = default_coord;
                    } else {
                        str2 = strValueOf4;
                    }
                }
            } else {
                str2 = strValueOf4;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return a(str, strValueOf, strValueOf2, strValueOf3, str2, strValueOf5, strValueOf6, strValueOf7, strValueOf8);
    }

    public static void b(com.meishu.sdk.platform.ms.c cVar, Context context, AdSlot adSlot, boolean z) {
        if (adSlot != null) {
            try {
                if (adSlot.getdUrl() == null || adSlot.getdUrl().length <= 0) {
                    return;
                }
                boolean isRewardUseBrowser = cVar.a() instanceof BaseAdSlot ? ((BaseAdSlot) cVar.a()).getIsRewardUseBrowser() : false;
                if (!z && !isRewardUseBrowser) {
                    if (cVar.getInteractionListener() instanceof ShareInteractionListener) {
                        try {
                            Class<? extends Activity> clsWebViewActivity = AdSdk.adConfig() != null ? AdSdk.adConfig().webViewActivity() : null;
                            if (clsWebViewActivity == null) {
                                clsWebViewActivity = MeishuWebviewActivity.class;
                            }
                            clsWebViewActivity.getDeclaredMethod("setShareListener", ShareInteractionListener.class).invoke(null, (ShareInteractionListener) cVar.getInteractionListener());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    com.meishu.sdk.core.uri.c.c.a(context, a(adSlot.getdUrl()[0], (IAd) cVar), adSlot);
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(adSlot.getdUrl()[0]));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void c(Context context, com.meishu.sdk.platform.ms.c cVar) {
        try {
            if (AdSdk.adConfig() != null && (AdSdk.adConfig().downloadConfirm() == 1 || (AdSdk.adConfig().downloadConfirm() == 0 && !b(context)))) {
                DownLoadDialogActivity.y = cVar;
                Intent intent = new Intent(context, (Class<?>) DownLoadDialogActivity.class);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return;
            }
            String[] strArrA = a(cVar.a().getDn_start(), cVar);
            String[] strArrA2 = a(cVar.a().getDn_succ(), cVar);
            String[] strArrA3 = a(cVar.a().getDn_inst_start(), cVar);
            String[] strArrA4 = a(cVar.a().getDn_inst_succ(), cVar);
            String str = cVar.a().getdUrl()[0];
            String appName = cVar.a().getAppName();
            String packageName = cVar.a().getPackageName();
            String str2 = appName == null ? "" : appName;
            try {
                Map<Integer, k0> map = DownloadUtils.h;
                DownloadUtils.c.f4872a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, str2, packageName, strArrA, strArrA2, strArrA3, strArrA4);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "开始下载", 0).show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(AdSlot adSlot, com.meishu.sdk.platform.ms.c cVar) {
        try {
            String[] dp_start = adSlot.getDp_start();
            if (dp_start != null) {
                LogUtil.d("ClickHandler", "send dp_start");
                for (int i = 0; i < dp_start.length; i++) {
                    if (!TextUtils.isEmpty(dp_start[i])) {
                        dp_start[i] = a(dp_start[i], cVar);
                    }
                }
                adSlot.setDp_start(dp_start);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return TextUtils.replace(str, new String[]{com.hihonor.adsdk.base.g.j.e.c.hnadsc, com.hihonor.adsdk.base.g.j.e.c.hnadsd, com.hihonor.adsdk.base.g.j.e.c.hnadse, com.hihonor.adsdk.base.g.j.e.c.hnadsf, "__MS_EVENT_SEC__", "__MS_EVENT_MSEC__", "__M_DOWN_TIME__", "__M_UP_TIME__"}, new String[]{String.valueOf(str2), String.valueOf(str3), String.valueOf(str4), String.valueOf(str5), String.valueOf(str6), String.valueOf(str7), String.valueOf(str8), String.valueOf(str9)}).toString();
    }

    public static void b(Context context, com.meishu.sdk.platform.ms.c cVar) {
        try {
            if (!a(context)) {
                Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "请检查网络连接", 0).show();
                return;
            }
            AdSlot adSlotA = cVar.a();
            if (adSlotA.getdUrl() == null || adSlotA.getdUrl().length <= 0) {
                return;
            }
            adSlotA.getdUrl();
            String str = com.meishu.sdk.core.download.a.C0793a.f4782a.c;
            String strReplace = adSlotA.getdUrl()[0].substring(adSlotA.getdUrl()[0].lastIndexOf("/")).replace("/", "");
            try {
                strReplace = l1.a(MessageDigest.getInstance("MD5").digest(adSlotA.getdUrl()[0].getBytes())).toLowerCase() + ".apk";
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            File file = new File(str, strReplace);
            if (file.exists()) {
                LogUtil.e("ClickHandler", "file install");
                String[] strArrA = a(cVar.a().getDn_start(), cVar);
                String[] strArrA2 = a(cVar.a().getDn_succ(), cVar);
                String[] strArrA3 = a(cVar.a().getDn_inst_start(), cVar);
                String[] strArrA4 = a(cVar.a().getDn_inst_succ(), cVar);
                String appName = cVar.a().getAppName();
                String packageName = cVar.a().getPackageName();
                Map<Integer, k0> map = DownloadUtils.h;
                k0 k0Var = new k0();
                k0Var.b = appName;
                k0Var.c = packageName;
                k0Var.d = strArrA;
                k0Var.e = strArrA2;
                k0Var.f = strArrA3;
                k0Var.g = strArrA4;
                DownloadUtils.a(context);
                DownloadUtils.a(context, file, k0Var);
                return;
            }
            LogUtil.e("ClickHandler", "file not exists");
            c(context, cVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str, com.meishu.sdk.platform.ms.c cVar) {
        Throwable th;
        String strA;
        String clickid = "__CLICK_ID__";
        try {
            AdSlot adSlotA = cVar.a();
            if (adSlotA instanceof BaseAdSlot) {
                try {
                    int clkActType = ((BaseAdSlot) adSlotA).getClkActType();
                    if (clkActType != 4 && clkActType != 8 && clkActType != 64 && clkActType != 256) {
                        strA = a(str, (IAd) cVar);
                    } else {
                        String default_coord = ((BaseAdSlot) adSlotA).getDefault_coord();
                        if (default_coord != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            strA = a(str, default_coord, default_coord, default_coord, default_coord, String.valueOf(jCurrentTimeMillis / 1000), String.valueOf(jCurrentTimeMillis), "__M_DOWN_TIME__", "__M_UP_TIME__");
                        } else {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            strA = a(str, "-999", "-999", "-999", "-999", String.valueOf(jCurrentTimeMillis2 / 1000), String.valueOf(jCurrentTimeMillis2), "__M_DOWN_TIME__", "__M_UP_TIME__");
                        }
                    }
                    try {
                        strA = a(strA, (BaseAdSlot) adSlotA);
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    strA = str;
                }
            } else {
                strA = str;
            }
            String[] strArr = {"__CLICK_ID__"};
            String[] strArr2 = new String[1];
            if (!TextUtils.isEmpty(adSlotA.getClickid())) {
                clickid = adSlotA.getClickid();
            }
            strArr2[0] = clickid;
            return TextUtils.replace(strA, strArr, strArr2).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String a(String str, BaseAdSlot baseAdSlot) {
        BaseAdSlot.ClickExtInfo clickExtInfo;
        try {
            return (TextUtils.isEmpty(str) || baseAdSlot == null || baseAdSlot.getAppendInfo() == null || (clickExtInfo = baseAdSlot.getAppendInfo().getClickExtInfo()) == null) ? str : TextUtils.replace(str, new String[]{"__REWARD_TMP_ID__", "__WEB_TEMP_ID__"}, new String[]{String.valueOf(clickExtInfo.getRewardTempId()), String.valueOf(clickExtInfo.getWebTempId())}).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static void b(com.meishu.sdk.platform.ms.c cVar, boolean z) {
        Method declaredMethod;
        try {
            if ((cVar instanceof com.meishu.sdk.core.ad.splash.c) && (cVar.a() instanceof BaseAdSlot) && ((BaseAdSlot) cVar.a()).getCbc() == 0) {
                String str = new String(f1.a("ZHI="));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    declaredMethod = cVar.getInteractionListener().getClass().getDeclaredMethod(str, Boolean.TYPE);
                } catch (Throwable unused) {
                    declaredMethod = null;
                }
                if (declaredMethod == null) {
                    try {
                        declaredMethod = cVar.getInteractionListener().getClass().getDeclaredMethod(str, Boolean.class);
                    } catch (Throwable unused2) {
                    }
                }
                if (declaredMethod == null) {
                    return;
                }
                SdkHandler.getInstance().postDelay(new b(declaredMethod, cVar, z), 0L);
            }
        } catch (Throwable unused3) {
        }
    }

    public static void a(com.meishu.sdk.platform.ms.c cVar, boolean z) {
        try {
            LogUtil.d("ClickHandler", "handleClick");
            AdSlot adSlotA = cVar.a();
            a(cVar, adSlotA);
            try {
                if (cVar.a() instanceof BaseAdSlot) {
                    ((BaseAdSlot) cVar.a()).getAppendInfo().setHasClicked(true);
                }
            } catch (Exception unused) {
            }
            Context context = cVar.getContext();
            if (cVar.getAdType() == AdType.FEED && (cVar instanceof com.meishu.sdk.meishu_ad.nativ.d) && ((com.meishu.sdk.meishu_ad.nativ.d) cVar).b == 2 && ((com.meishu.sdk.meishu_ad.nativ.d) cVar).g && (cVar.getAdView() instanceof NormalMediaView)) {
                ((NormalMediaView) cVar.getAdView()).a(z);
                return;
            }
            if (!TextUtils.isEmpty(adSlotA.getWx_username())) {
                try {
                    String[] wx_start = adSlotA.getWx_start();
                    if (wx_start != null) {
                        LogUtil.d("ClickHandler", "send wx_start");
                        for (String str : wx_start) {
                            if (!TextUtils.isEmpty(str)) {
                                z.a(context, a(h0.a(str), cVar), new i());
                            }
                        }
                    }
                    String wx_appid = (!(adSlotA instanceof BaseAdSlot) || TextUtils.isEmpty(((BaseAdSlot) adSlotA).getWx_appid())) ? null : ((BaseAdSlot) adSlotA).getWx_appid();
                    if (wx_appid == null) {
                        wx_appid = AdSdk.getSharedPreferences().getString("wx_appid", null);
                    }
                    if (wx_appid == null) {
                        wx_appid = AdSdk.adConfig() != null ? AdSdk.adConfig().getWxAppid() : null;
                    }
                    Object objA = a(context, wx_appid, adSlotA);
                    if (objA instanceof Boolean) {
                        if (((Boolean) objA).booleanValue()) {
                            String[] wx_succ = adSlotA.getWx_succ();
                            if (wx_succ != null) {
                                LogUtil.d("ClickHandler", "send wx_success");
                                for (String str2 : wx_succ) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        z.a(context, a(h0.a(str2), cVar), new i());
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        String[] wx_fail = adSlotA.getWx_fail();
                        if (wx_fail != null) {
                            LogUtil.d("ClickHandler", "send wx_fail");
                            for (String str3 : wx_fail) {
                                if (!TextUtils.isEmpty(str3)) {
                                    z.a(context, a(h0.a(str3), cVar), new i());
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                    String[] wx_fail2 = adSlotA.getWx_fail();
                    if (wx_fail2 != null) {
                        LogUtil.d("ClickHandler", "send wx_start");
                        for (String str4 : wx_fail2) {
                            if (!TextUtils.isEmpty(str4)) {
                                z.a(context, a(h0.a(str4), cVar), new i());
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(adSlotA.getDeep_link())) {
                try {
                    Intent uri = Intent.parseUri(adSlotA.getDeep_link(), 0);
                    uri.addCategory("android.intent.category.BROWSABLE");
                    uri.setComponent(null);
                    uri.setSelector(null);
                    if (uri.resolveActivity(AdSdk.getContext().getPackageManager()) != null) {
                        if (a(context != null ? context : AdSdk.getContext(), adSlotA, cVar, true, z, null)) {
                            return;
                        }
                    } else {
                        b(cVar, false);
                        a(context, adSlotA, cVar, 3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            a(cVar, context, adSlotA, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean b(String str) {
        try {
            HashMap<String, Integer> map = q0.h;
            if (!TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
                String scheme = Uri.parse(str).getScheme();
                if (TextUtils.isEmpty(scheme)) {
                    return false;
                }
                Iterator<String> it = map.keySet().iterator();
                while (it.hasNext()) {
                    if (scheme.equalsIgnoreCase(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            LogUtil.e("ClickHandler", com.meishu.sdk.activity.a.a("isDeepLinkLimited error: ").append(th.getMessage()).toString());
            return false;
        }
    }

    public static void a(com.meishu.sdk.platform.ms.c cVar, AdSlot adSlot) {
        boolean z;
        int i = 0;
        String str = null;
        try {
            if (adSlot instanceof BaseAdSlot) {
                str = ((BaseAdSlot) adSlot).getPower_index() + "," + ((BaseAdSlot) adSlot).getClkPower();
                ((BaseAdSlot) adSlot).getLoadedTime();
                String posId = ((BaseAdSlot) adSlot).getPosId();
                u0.a(posId, 4);
                u0.a aVar = u0.f4949a.get(posId + ((BaseAdSlot) adSlot).getLoadedTime());
                if (aVar == null) {
                    aVar = new u0.a();
                }
                z = !aVar.b ? aVar.f4950a : false;
                if (!z) {
                    try {
                        u0.a(posId, 8);
                    } catch (Exception e) {
                        e = e;
                        try {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                }
                aVar.b = true;
                u0.f4949a.put(posId + ((BaseAdSlot) adSlot).getLoadedTime(), aVar);
            } else {
                z = false;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        String[] clickUrl = adSlot.getClickUrl();
        if (clickUrl != null) {
            LogUtil.d("ClickHandler", "send handleClick");
            for (String strA : clickUrl) {
                if (!TextUtils.isEmpty(strA)) {
                    if (cVar.getAdView() != null) {
                        strA = h0.a(strA, cVar.getAdView().getWidth(), cVar.getAdView().getHeight());
                    }
                    if (z) {
                        if (((BaseAdSlot) adSlot).getDclk() != null) {
                            str = ((BaseAdSlot) adSlot).getDclk().getPower() + "," + ((BaseAdSlot) adSlot).getClkPower();
                        }
                        strA = strA.replace("__MS_DCLK_S__", "1");
                    }
                    if (adSlot instanceof BaseAdSlot) {
                        int clkActType = ((BaseAdSlot) adSlot).getClkActType();
                        String strReplace = strA.replace("__MS_CT__", String.valueOf(clkActType));
                        if (clkActType == 4 || clkActType == 8 || clkActType == 64 || clkActType == 256) {
                            if (TextUtils.isEmpty(str)) {
                                str = ((BaseAdSlot) adSlot).getPower_index() + "," + ((BaseAdSlot) adSlot).getClkPower();
                            }
                            strReplace = strReplace.replace("__MS_CP__", h0.b(str));
                        }
                        strA = a(strReplace, clkActType, ((BaseAdSlot) adSlot).getShakeResult());
                    }
                    z.a(cVar.getAdView().getContext(), a(strA, cVar), new i());
                }
            }
        }
        String[] strArr = adSlot.getdUrl();
        if (strArr != null) {
            String[] strArr2 = new String[strArr.length];
            int length = strArr.length;
            int i2 = 0;
            while (i < length) {
                strArr2[i2] = a(strArr[i], cVar);
                i++;
                i2++;
            }
            adSlot.setdUrl(strArr2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    public static void a(com.meishu.sdk.platform.ms.c cVar, Context context, AdSlot adSlot, boolean z) {
        try {
            boolean z2 = true;
            if (cVar.getInteractionType() == 1) {
                if (cVar.a().getDirect_market() == 1 && !TextUtils.isEmpty(cVar.a().getPackageName())) {
                    a(context, cVar);
                    return;
                } else {
                    b(context, cVar);
                    return;
                }
            }
            if (cVar.getInteractionType() == 0) {
                if (z) {
                    boolean z3 = q0.o == 1;
                    if (adSlot instanceof BaseAdSlot) {
                        BaseAdSlot baseAdSlot = (BaseAdSlot) adSlot;
                        if (baseAdSlot.getUob() == null) {
                            z2 = z3;
                        } else if (baseAdSlot.getUob().intValue() != 1) {
                            z2 = false;
                        }
                    } else {
                        z2 = z3;
                    }
                    b(cVar, context, adSlot, z2);
                    return;
                }
                try {
                    o1.a(((BaseAdSlot) adSlot).getEventUrl());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str, int i, ShakeResult shakeResult) {
        int i2;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i3 = 1;
            if (2 == i || 1 == i || 512 == i) {
                i2 = 1;
                i3 = 0;
            } else {
                if (4 == i || 64 == i) {
                    if (shakeResult != null) {
                        str = TextUtils.replace(str, new String[]{"__M_XMAX_ACC__", "__M_YMAX_ACC__", "__M_ZMAX_ACC__"}, new String[]{String.valueOf((int) (shakeResult.getShakeX() * 100.0f)), String.valueOf((int) (shakeResult.getShakeY() * 100.0f)), String.valueOf((int) (shakeResult.getShakeZ() * 100.0f))}).toString();
                    }
                    i2 = 2;
                } else if (8 == i || 256 == i) {
                    i2 = 5;
                    if (shakeResult != null) {
                        str = TextUtils.replace(str, new String[]{"__M_TURN_X__", "__M_TURN_Y__", "__M_TURN_Z__", "__M_TURN_TIME__"}, new String[]{String.valueOf((int) shakeResult.getTurnX()), String.valueOf((int) shakeResult.getTurnY()), String.valueOf((int) shakeResult.getTurnZ()), String.valueOf(shakeResult.getTotalTurnTime())}).toString();
                    }
                } else if (128 == i || 32 == i) {
                    i2 = 3;
                } else {
                    i2 = 0;
                }
                i3 = i2;
            }
            return str.replace("__M_SLD__", String.valueOf(i3)).replace("__M_SLD2__", String.valueOf(i2)).replace("__M_DENSITY__", String.valueOf(AdSdk.getContext().getResources().getDisplayMetrics().density));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object a(Context context, String str, AdSlot adSlot) throws Exception {
        Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.BaseWXApiImplV10");
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class, String.class, Boolean.TYPE, Integer.TYPE);
        declaredConstructor.setAccessible(true);
        Object objNewInstance = declaredConstructor.newInstance(context, str, Boolean.TRUE, 2);
        Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
        Object objNewInstance2 = cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
        Field declaredField = cls2.getDeclaredField("userName");
        declaredField.setAccessible(true);
        declaredField.set(objNewInstance2, adSlot.getWx_username());
        Field declaredField2 = cls2.getDeclaredField("path");
        declaredField2.setAccessible(true);
        declaredField2.set(objNewInstance2, adSlot.getWx_path());
        Method declaredMethod = cls.getDeclaredMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq"));
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(objNewInstance, objNewInstance2);
    }

    public static void a(String str, Intent intent) {
        for (int i = 0; i < q0.f.size(); i++) {
            try {
                PackageBean.DpFlagBean dpFlagBean = q0.f.get(i);
                if (dpFlagBean.getScheme() != null && str.startsWith(dpFlagBean.getScheme())) {
                    List<String> flag = dpFlagBean.getFlag();
                    for (int i2 = 0; i2 < flag.size(); i2++) {
                        String str2 = flag.get(i2);
                        if ("FLAG_ACTIVITY_SINGLE_TOP".equals(str2)) {
                            intent.addFlags(536870912);
                        }
                        if ("FLAG_ACTIVITY_CLEAR_TASK".equals(str2)) {
                            intent.addFlags(32768);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    public static void a(Context context, com.meishu.sdk.platform.ms.c cVar) {
        try {
            AdSlot adSlotA = cVar.a();
            String packageName = adSlotA.getPackageName();
            String[] dn_succ = adSlotA.getDn_succ();
            String[] dn_inst_start = adSlotA.getDn_inst_start();
            String[] dn_inst_succ = adSlotA.getDn_inst_succ();
            AppStoreUtil.f4862a = packageName;
            AppStoreUtil.b = dn_succ;
            AppStoreUtil.c = dn_inst_start;
            AppStoreUtil.d = dn_inst_succ;
            String[] strArrA = a(adSlotA.getDn_start(), cVar);
            if (strArrA != null) {
                LogUtil.d("ClickHandler", "Report send dn_start");
                for (String str : strArrA) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(context, str, new i());
                    }
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + adSlotA.getPackageName()));
            intent.addFlags(268435456);
            if (Build.MANUFACTURER.equalsIgnoreCase("honor")) {
                intent.setPackage("com.hihonor.appmarket");
            }
            context.startActivity(intent);
        } catch (Throwable th) {
            LogUtil.e("ClickHandler", "downloadInAppStore error.", th);
        }
    }

    public static boolean a(String str) {
        try {
            Intent uri = Intent.parseUri(str, 0);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            return uri.resolveActivity(AdSdk.getContext().getPackageManager()) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(final Context context, final AdSlot adSlot, final com.meishu.sdk.platform.ms.c cVar, final boolean z, final boolean z2, final o0.a aVar) {
        String dpsign;
        String[] eventUrl;
        try {
            if (q0.t != 1 && b(adSlot.getDeep_link())) {
                LogUtil.d("ClickHandler", "limit dp");
                if (aVar != null) {
                    aVar.a(false);
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        b(adSlot, cVar);
        try {
            final boolean z3 = (adSlot instanceof BaseAdSlot) && ((BaseAdSlot) adSlot).getNop() == 1;
            boolean z4 = !z3;
            if (q0.q == 1) {
                z4 = false;
            }
            final ArrayList arrayList = new ArrayList();
            o0.b.f4927a.f4926a = new o0.a() { // from class: com.meishu.sdk.core.utils.f$$ExternalSyntheticLambda0
                @Override // com.meishu.sdk.core.utils.o0.a
                public final void a(boolean z5) {
                    f.a(arrayList, aVar, cVar, z, z3, z2, context, adSlot, z5);
                }
            };
            l0 l0Var = new l0(-1L, false);
            com.meishu.sdk.core.service.d.a(l0Var);
            if (adSlot instanceof BaseAdSlot) {
                dpsign = ((BaseAdSlot) adSlot).getDPSIGN();
                eventUrl = ((BaseAdSlot) adSlot).getEventUrl();
            } else {
                dpsign = null;
                eventUrl = null;
            }
            o0.a(context, adSlot.getDeep_link(), adSlot.getDpSign(), adSlot.getDp_start(), dpsign, eventUrl, z4);
            new Thread(new a(new SoftReference(context), adSlot, new SoftReference(cVar), l0Var, arrayList, z4)).start();
            return true;
        } catch (Exception e2) {
            a(context, adSlot, cVar, 4);
            e2.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ void a(List list, o0.a aVar, com.meishu.sdk.platform.ms.c cVar, boolean z, boolean z2, boolean z3, Context context, AdSlot adSlot, boolean z4) {
        list.add(Boolean.valueOf(z4));
        if (aVar != null) {
            aVar.a(z4);
        }
        b(cVar, z4);
        if (z4 || !z) {
            return;
        }
        LogUtil.d("ClickHandler", "openDeepLink error. call defaultInteraction");
        boolean z5 = q0.q != 1 ? !z2 || z3 : false;
        if (cVar.getInteractionType() == 0) {
            a(cVar, context, adSlot, z5);
        }
    }

    public static boolean a(Reference reference) {
        if (reference != null) {
            try {
                if (reference.get() != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void a(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.meishu.sdk.core.loader.a.a(AdSdk.getContext(), str);
                }
            }
        }
    }

    public static void a(AdSlot adSlot, Context context, com.meishu.sdk.platform.ms.c cVar, boolean z) {
        try {
            String[] dp_succ = adSlot.getDp_succ();
            h0.a(dp_succ, z ? 1 : 0);
            if (dp_succ != null) {
                for (String str : dp_succ) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(context, a(str, cVar), new i());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, AdSlot adSlot, com.meishu.sdk.platform.ms.c cVar, int i) {
        try {
            String[] dp_fail = adSlot.getDp_fail();
            h0.a(dp_fail, i);
            if (dp_fail != null) {
                LogUtil.d("ClickHandler", "send dp_fail");
                for (String str : dp_fail) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(context, a(str, cVar), new i());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(AdSlot adSlot, com.meishu.sdk.platform.ms.c cVar) {
        HashMap<String, String> dynamicMap;
        String str;
        Object obj;
        try {
            if (q0.j == null) {
                return false;
            }
            Gson gson = new Gson();
            Map map = null;
            if (adSlot instanceof BaseAdSlot) {
                dynamicMap = ((BaseAdSlot) adSlot).getDynamicMap();
                if (cVar != null && cVar.getAdType() == AdType.SPLASH && AdSdk.adConfig() != null && AdSdk.adConfig().isSplashClickToClosed()) {
                    ((BaseAdSlot) adSlot).setAdClosed(true);
                }
                if (((BaseAdSlot) adSlot).getIsAdClosed() && q0.j.getX() == 0) {
                    return false;
                }
            } else {
                dynamicMap = null;
            }
            if (System.currentTimeMillis() - q0.j.getLastTime() <= q0.j.getI() * 1000) {
                return false;
            }
            List<String> k = q0.j.getK();
            if (k != null) {
                str = "";
                for (int i = 0; i < k.size(); i++) {
                    try {
                        String str2 = k.get(i);
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                Field declaredField = BaseAdSlot.class.getDeclaredField(str2);
                                declaredField.setAccessible(true);
                                obj = declaredField.get(adSlot);
                            } catch (Exception e) {
                                e.printStackTrace();
                                obj = null;
                            }
                            try {
                                if ("scheme".equals(str2) && obj == null && (adSlot instanceof BaseAdSlot)) {
                                    if (((BaseAdSlot) adSlot).getScheme() != null) {
                                        str = str + "_" + ((BaseAdSlot) adSlot).getScheme();
                                    } else {
                                        str = str + "_" + Uri.parse(adSlot.getDeep_link()).getScheme();
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (obj != null) {
                                if (i == 0) {
                                    str = str + obj;
                                } else {
                                    str = str + "_" + obj;
                                }
                            } else if (dynamicMap == null || !dynamicMap.containsKey(str2)) {
                                if (i < k.size() - 1) {
                                    str = str + "_";
                                }
                            } else if (i == 0) {
                                str = str + dynamicMap.get(str2);
                            } else {
                                str = str + "_" + dynamicMap.get(str2);
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                str = "";
            }
            Map<String, Integer> r = q0.j.getR();
            long jLongValue = 0;
            try {
                String string = AdSdk.getSharedPreferences().getString("queryKeyLastTimeMap", "");
                if (!TextUtils.isEmpty(string)) {
                    Map map2 = (Map) gson.fromJson(string, new g().getType());
                    if (map2 != null) {
                        try {
                            if (map2.containsKey(str)) {
                                jLongValue = ((Long) map2.get(str)).longValue();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            map = map2;
                            e.printStackTrace();
                        }
                    }
                    map = map2;
                }
            } catch (Exception e5) {
                e = e5;
            }
            if (r == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (System.currentTimeMillis() - jLongValue <= r.get(str).intValue() * 1000) {
                return false;
            }
            if (map == null) {
                map = new HashMap();
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
            AdSdk.getSharedPreferences().edit().putString("queryKeyLastTimeMap", gson.toJson(map)).apply();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] a(String[] strArr, com.meishu.sdk.platform.ms.c cVar) {
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = a(strArr[i], cVar);
            }
        }
        return strArr;
    }
}
