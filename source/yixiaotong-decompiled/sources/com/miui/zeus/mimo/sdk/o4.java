package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5548a = ijiami_1011.s.s.s.d(new byte[]{10, 5}, "e13668");

    public boolean a(Context context, Intent intent) {
        boolean z;
        if (context == null || intent == null) {
            m.b(f5548a, ijiami_1011.s.s.s.d(new byte[]{5, 13, 92, 65, 4, 77, Ascii.NAK, 68, 9, 16, 17, 12, 8, Ascii.SYN, 87, 91, Ascii.NAK, Ascii.NAK, 2, 5, 8, 66, 95, 10, Ascii.DC2, 66, 80, 80, 65, 91, Ascii.DC4, 8, 10}, "fb25a5"));
            return false;
        }
        if (TextUtils.isEmpty(intent.getPackage())) {
            Intent intent2 = new Intent(intent);
            if (intent2.getScheme() != null) {
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent2, 64);
                ResolveInfo resolveInfo = null;
                if (listQueryIntentActivities != null) {
                    if (listQueryIntentActivities.size() == 1) {
                        resolveInfo = listQueryIntentActivities.get(0);
                    } else if (listQueryIntentActivities.size() > 1) {
                        Collections.sort(listQueryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
                        ResolveInfo resolveInfo2 = null;
                        ResolveInfo resolveInfo3 = null;
                        for (ResolveInfo resolveInfo4 : listQueryIntentActivities) {
                            if (TextUtils.equals(resolveInfo4.activityInfo.packageName, ijiami_1011.s.s.s.d(new byte[]{2, 91, 91, 75, 81, 94, 5, Ascii.SYN, 9, 11, 85, 75, 3, 70, 89, Ascii.DC2, 67, 85, 19}, "a46e00"))) {
                                resolveInfo3 = resolveInfo4;
                            } else if (TextUtils.equals(resolveInfo4.activityInfo.packageName, ijiami_1011.s.s.s.d(new byte[]{82, 9, 15, Ascii.SYN, Ascii.RS, 12, 0, 11, 11, 11, Ascii.US, 8, 80, Ascii.DC4, 9, 93, Ascii.DC2}, "1fb8fe"))) {
                                resolveInfo2 = resolveInfo4;
                            }
                        }
                        if (resolveInfo2 != null) {
                            resolveInfo = resolveInfo2;
                        } else {
                            loop1: for (ResolveInfo resolveInfo5 : listQueryIntentActivities) {
                                Uri data = intent2.getData();
                                if (data != null && resolveInfo5.filter.hasDataAuthority(data)) {
                                    Iterator<IntentFilter.AuthorityEntry> itAuthoritiesIterator = resolveInfo5.filter.authoritiesIterator();
                                    while (itAuthoritiesIterator != null && itAuthoritiesIterator.hasNext()) {
                                        if (TextUtils.equals(itAuthoritiesIterator.next().getHost(), data.getHost())) {
                                            resolveInfo = resolveInfo5;
                                            break loop1;
                                        }
                                    }
                                }
                            }
                            if (resolveInfo == null) {
                                resolveInfo = resolveInfo3 != null ? resolveInfo3 : listQueryIntentActivities.get(0);
                            }
                        }
                    }
                }
                if (resolveInfo != null) {
                    intent2.setPackage(resolveInfo.activityInfo.packageName);
                }
            }
            try {
                context.startActivity(intent2);
                z = true;
            } catch (Exception unused) {
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            return z;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }
}
