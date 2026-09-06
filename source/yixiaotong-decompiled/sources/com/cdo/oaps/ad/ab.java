package com.cdo.oaps.ad;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class ab {
    public static boolean a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(a.b(y.f3137a));
        intent.setFlags(268435456);
        intent.setPackage(af.b(context));
        intent.setDataAndType(Uri.parse(str), a.b(y.b));
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
            return false;
        }
        ResolveInfo resolveInfo = listQueryIntentActivities.get(0);
        ComponentName componentName = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent2, 1000);
            return true;
        }
        context.startActivity(intent2);
        return true;
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(a.b(y.f3137a));
        intent.setPackage(af.b(context));
        intent.setDataAndType(Uri.parse(str), a.b(y.b));
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
        if (listQueryIntentServices == null || listQueryIntentServices.size() <= 0) {
            return false;
        }
        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        context.startService(intent2);
        return true;
    }
}
