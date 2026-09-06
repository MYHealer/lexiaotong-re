package com.meishu.sdk.core.utils;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.meishu.sdk.core.service.MeishuFileProvider;

/* JADX INFO: compiled from: FileProviderHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4937a;

    public static boolean a(Context context, String str) {
        try {
            boolean zA = a(context, context.getPackageName() + ".MeishuFileProvider", MeishuFileProvider.class);
            if (zA) {
                f4937a = context.getPackageName() + ".MeishuFileProvider";
            }
            if (!zA && !TextUtils.isEmpty(str) && (zA = a(context, str, FileProvider.class))) {
                f4937a = str;
            }
            if (!zA) {
                LogUtil.w(com.kuaishou.weapon.p0.t.k, a("cGxlYXNlIHNldHRpbmcgRmlsZVByb3ZpZGVy"));
            }
            return zA;
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtil.e(com.kuaishou.weapon.p0.t.k, "", th);
            return false;
        }
    }

    public static boolean a(Context context, String str, Class cls) {
        try {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
            if (providerInfoResolveContentProvider != null && cls.isAssignableFrom(Class.forName(providerInfoResolveContentProvider.name))) {
                try {
                    XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), a("YW5kcm9pZC5zdXBwb3J0LkZJTEVfUFJPVklERVJfUEFUSFM="));
                    if (xmlResourceParserLoadXmlMetaData == null) {
                        LogUtil.e(com.kuaishou.weapon.p0.t.k, a("TWlzc2luZyBhbmRyb2lkLnN1cHBvcnQuRklMRV9QUk9WSURFUl9QQVRIUyBtZXRhLWRhdGE="));
                        return true;
                    }
                    boolean z = false;
                    while (true) {
                        int next = xmlResourceParserLoadXmlMetaData.next();
                        if (next == 1) {
                            break;
                        }
                        if (next == 2) {
                            String name = xmlResourceParserLoadXmlMetaData.getName();
                            xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                            String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                            if ("root-path".equals(name)) {
                                if (".".equals(attributeValue)) {
                                    z = true;
                                }
                            } else if ("external-path".equals(name)) {
                                if (".".equals(attributeValue)) {
                                    z = true;
                                }
                            } else if ("external-files-path".equals(name) && (".".equals(attributeValue) || "Download".equalsIgnoreCase(attributeValue))) {
                                z = true;
                            }
                        }
                    }
                    xmlResourceParserLoadXmlMetaData.close();
                    if (!z) {
                        LogUtil.w(com.kuaishou.weapon.p0.t.k, a("cGxlYXNlIGFkZCA8ZXh0ZXJuYWwtZmlsZXMtcGF0aCBuYW1lPSJkb3dubG9hZCIgcGF0aD0iRG93bmxvYWQiLz4gaW4g") + "MeishuFileProvider");
                    }
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }

    public static String a(String str) {
        try {
            return new String(f1.a(str));
        } catch (Throwable unused) {
            return "";
        }
    }
}
