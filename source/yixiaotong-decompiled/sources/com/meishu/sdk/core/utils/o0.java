package com.meishu.sdk.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meishu.sdk.activity.MeishuOpenDeepLinkActivity;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: OpenDeepLinkUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f4926a;

    /* JADX INFO: compiled from: OpenDeepLinkUtil.java */
    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: OpenDeepLinkUtil.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o0 f4927a = new o0();
    }

    public static void a(boolean z) {
        try {
            o0 o0Var = b.f4927a;
            a aVar = o0Var.f4926a;
            if (aVar != null) {
                aVar.a(z);
                o0Var.f4926a = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, String[] strArr, String str3, String[] strArr2, boolean z) {
        Intent intentA;
        if (z) {
            MeishuOpenDeepLinkActivity.startOpenDeepLinkActivity(context, str, str2, strArr, str3);
            return;
        }
        com.meishu.sdk.core.service.d.a(new l0(-1L));
        try {
            try {
                if (TextUtils.isEmpty(str3)) {
                    intentA = null;
                } else {
                    String strA = v1.a(str3, str);
                    if (TextUtils.isEmpty(strA)) {
                        strA = str;
                    }
                    intentA = Intent.parseUri(strA, 0);
                }
            } catch (Throwable th) {
                o1.a(strArr2, str, th);
                th.printStackTrace();
            }
            if (intentA != null && intentA.resolveActivity(AdSdk.getContext().getPackageManager()) != null) {
                a(strArr, 1);
            } else {
                intentA = a(context, str, str2, strArr, strArr2);
            }
            if (q0.f != null) {
                f.a(str, intentA);
            }
            context.startActivity(intentA);
        } catch (Throwable th2) {
            LogUtil.d("ClickHandler", "jumpDeepLink2 error");
            o1.a(strArr2, str, th2);
            th2.printStackTrace();
            a(false);
        }
    }

    public static Intent a(Context context, String str, String str2, String[] strArr, String[] strArr2) {
        byte[] bArrDigest;
        try {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    byte[] bArrA = f1.a(str2);
                    if (bArrA != null && bArrA.length > 0) {
                        StringBuilder sbAppend = new StringBuilder().append(str);
                        AdSdk.adConfig();
                        try {
                            bArrDigest = MessageDigest.getInstance("SHA-256").digest(sbAppend.append(MSAdConfig.initUUID()).toString().getBytes("UTF-8"));
                        } catch (Exception unused) {
                            bArrDigest = null;
                        }
                        if (Arrays.equals(bArrA, bArrDigest)) {
                            Intent intentA = u1.a(str, context);
                            if (intentA != null && intentA.resolveActivity(AdSdk.getContext().getPackageManager()) != null) {
                                a(strArr, 1);
                                return intentA;
                            }
                            a(strArr, 3);
                            return a(str);
                        }
                    }
                    a(strArr, 2);
                    Intent intentA2 = u1.a(str, context);
                    return (intentA2 == null || intentA2.resolveActivity(AdSdk.getContext().getPackageManager()) == null) ? a(str) : intentA2;
                } catch (Throwable unused2) {
                    a(strArr, 3);
                    return a(str);
                }
            }
            a(strArr, 4);
            return a(str);
        } catch (Throwable th) {
            o1.a(strArr2, str, th);
            try {
                a(strArr, 3);
                return a(str);
            } catch (Throwable th2) {
                th2.printStackTrace();
                th.printStackTrace();
                return null;
            }
        }
    }

    public static void a(String[] strArr, int i) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        f.a(h0.b(strArr, i));
    }

    public static Intent a(String str) throws URISyntaxException {
        Intent uri = Intent.parseUri(str, 0);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.setComponent(null);
        uri.setSelector(null);
        uri.setFlags(268435456);
        return uri;
    }
}
