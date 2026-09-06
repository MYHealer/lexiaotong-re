package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PermissionUtils {
    public static List<Boolean> checkPermissions(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(packageManager.checkPermission(it.next(), packageName) != -1));
        }
        return arrayList;
    }

    public static boolean checkPermission(Context context, String str) {
        return checkPermissions(context, Arrays.asList(str)).get(0).booleanValue();
    }
}
