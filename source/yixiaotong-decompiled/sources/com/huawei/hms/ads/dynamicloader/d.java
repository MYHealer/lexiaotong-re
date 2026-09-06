package com.huawei.hms.ads.dynamicloader;

import com.huawei.hms.ads.uiengineloader.af;
import dalvik.system.PathClassLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends PathClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3840a = "d";

    public d(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    public d(String str, String str2, ClassLoader classLoader) {
        super(str, str2, classLoader);
    }

    private static void a(List list, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.startsWith("java.") || str.startsWith("com.huawei.hms.ads.uiengine.common") || str.startsWith("com.huawei.openalliance.ad.download.app.AppStatus");
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        URL resource;
        ClassLoader systemClassLoader = getSystemClassLoader();
        if (systemClassLoader == null) {
            af.c("DelegateLastPathClssLdr", "Failed to get SystemClassLoader");
            resource = null;
        } else {
            resource = systemClassLoader.getResource(str);
        }
        return resource == null ? findResource(str) : resource;
    }

    @Override // java.lang.ClassLoader
    public final Enumeration getResources(String str) {
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        ClassLoader systemClassLoader = getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                a(arrayList, systemClassLoader.getResources(str));
            } catch (IOException unused) {
                str2 = f3840a;
                str3 = "Add Enumeration failed.";
                af.c(str2, str3);
            }
            a(arrayList, findResources(str));
            return Collections.enumeration(arrayList);
        }
        str2 = f3840a;
        str3 = "Failed to get SystemClassLoader";
        af.c(str2, str3);
        a(arrayList, findResources(str));
        return Collections.enumeration(arrayList);
    }

    @Override // java.lang.ClassLoader
    protected final Class loadClass(String str, boolean z) throws ClassNotFoundException {
        if (str != null && !str.isEmpty() && (str.startsWith("java.") || str.startsWith("com.huawei.hms.ads.uiengine.common") || str.startsWith("com.huawei.openalliance.ad.download.app.AppStatus"))) {
            try {
                return super.loadClass(str, z);
            } catch (ClassNotFoundException unused) {
                af.c(f3840a, "Load class failed.");
            }
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException unused2) {
            return super.loadClass(str, z);
        }
    }
}
