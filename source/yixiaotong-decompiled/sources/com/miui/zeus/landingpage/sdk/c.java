package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {
    public static void a(Intent intent, Context context) {
        ResolveInfo resolveInfoB;
        if (intent == null || intent.getScheme() == null || (resolveInfoB = b(intent, context)) == null) {
            return;
        }
        intent.setPackage(resolveInfoB.activityInfo.packageName);
    }

    public static boolean a(Intent intent, ResolveInfo resolveInfo) {
        Uri data = intent.getData();
        if (data != null && resolveInfo.filter.hasDataAuthority(data)) {
            Iterator<IntentFilter.AuthorityEntry> itAuthoritiesIterator = resolveInfo.filter.authoritiesIterator();
            while (itAuthoritiesIterator != null && itAuthoritiesIterator.hasNext()) {
                if (TextUtils.equals(itAuthoritiesIterator.next().getHost(), data.getHost())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ResolveInfo b(Intent intent, Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        if (listQueryIntentActivities.size() != 1) {
            ResolveInfo resolveInfo = null;
            if (listQueryIntentActivities.size() <= 1) {
                return null;
            }
            Collections.sort(listQueryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
            ResolveInfo resolveInfo2 = null;
            ResolveInfo resolveInfo3 = null;
            for (ResolveInfo resolveInfo4 : listQueryIntentActivities) {
                if (TextUtils.equals(resolveInfo4.activityInfo.packageName, s.d(new byte[]{5, 11, 88, Ascii.US, 0, 12, 5, Ascii.SYN, 9, 11, 85, 75, 4, Ascii.SYN, 90, 70, Ascii.DC2, 7, 19}, "fd51ab"))) {
                    resolveInfo3 = resolveInfo4;
                } else if (TextUtils.equals(resolveInfo4.activityInfo.packageName, s.d(new byte[]{82, 14, 94, Ascii.GS, 78, 94, 0, 11, 11, 11, Ascii.US, 8, 80, 19, 88, 86, 66}, "1a3367"))) {
                    resolveInfo2 = resolveInfo4;
                }
            }
            if (resolveInfo2 != null) {
                return resolveInfo2;
            }
            for (ResolveInfo resolveInfo5 : listQueryIntentActivities) {
                if (a(intent, resolveInfo5)) {
                    resolveInfo = resolveInfo5;
                    break;
                }
            }
            if (resolveInfo != null) {
                return resolveInfo;
            }
            if (resolveInfo3 != null) {
                return resolveInfo3;
            }
        }
        return listQueryIntentActivities.get(0);
    }
}
