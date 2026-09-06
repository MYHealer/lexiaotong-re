package com.hihonor.adsdk.base.permission;

import android.content.Context;
import android.content.Intent;
import com.hihonor.adsdk.common.f.f;
import com.hihonor.adsdk.common.f.r;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsb = "a";
    public static final String hnadsc = "PERMISSION_ACTIVITY_KEY";
    private final CopyOnWriteArrayList<String> hnadsa;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.permission.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0449a {
    }

    private static class b {
        private static final a hnadsa = new a(null);

        private b() {
        }
    }

    /* synthetic */ a(C0449a c0449a) {
        this();
    }

    public static a hnadsa() {
        return b.hnadsa;
    }

    private void hnadsb() {
        hnadsa(new String[]{g.h, "android.permission.ACCESS_FINE_LOCATION"});
    }

    private a() {
        this.hnadsa = new CopyOnWriteArrayList<>();
        hnadsb();
    }

    private void hnadsa(String str) {
        this.hnadsa.add(str);
    }

    public void hnadsb(Context context) {
        String str = hnadsb;
        com.hihonor.adsdk.common.b.b.hnadsc(str, "request permissions from context.", new Object[0]);
        ArrayList<String> arrayListHnadsa = hnadsa(context);
        if (f.hnadsa((Collection<?>) arrayListHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(str, "notGrantPermissions is empty.", new Object[0]);
        } else {
            hnadsa(context, hnadsa(arrayListHnadsa));
        }
    }

    private void hnadsa(String[] strArr) {
        for (String str : strArr) {
            hnadsa(str);
        }
    }

    private ArrayList<String> hnadsa(Context context) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "get permissions.", new Object[0]);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.hnadsa) {
            if (r.hnadsa(context, str)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "GrantPermission: " + str, new Object[0]);
            } else {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private void hnadsa(Context context, String[] strArr) {
        try {
            String str = hnadsb;
            com.hihonor.adsdk.common.b.b.hnadsc(str, "request permissions reserve start.", new Object[0]);
            Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(hnadsc, strArr);
            context.startActivity(intent);
            com.hihonor.adsdk.common.b.b.hnadsc(str, "request permissions reserve finish.", new Object[0]);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "request permissions reserve exception. msg is " + e.getMessage(), new Object[0]);
        }
    }

    private String[] hnadsa(ArrayList<String> arrayList) {
        String str = hnadsb;
        com.hihonor.adsdk.common.b.b.hnadsc(str, "get request permissions string arr.", new Object[0]);
        if (f.hnadsa((Collection<?>) arrayList)) {
            com.hihonor.adsdk.common.b.b.hnadsc(str, "finalPermissions is empty.", new Object[0]);
            return new String[0];
        }
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            String str2 = arrayList.get(i);
            if (str2 != null) {
                strArr[i] = str2;
            }
        }
        return strArr;
    }
}
