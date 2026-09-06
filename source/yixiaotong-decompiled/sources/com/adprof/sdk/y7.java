package com.adprof.sdk;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class y7 implements eb {
    /* JADX WARN: Code duplicated, block: B:103:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:104:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d6  */
    public static void a(Context context, eb ebVar) {
        jb vdVar;
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        jb ueVar = ng.f1325a;
        if (ueVar == null) {
            String str = Build.MANUFACTURER;
            if (str.equalsIgnoreCase("LENOVO")) {
                vdVar = new vd(context);
            } else {
                String str2 = Build.BRAND;
                if (str2.equalsIgnoreCase("LENOVO") || str2.equalsIgnoreCase("ZUK") || str.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA")) {
                    vdVar = new vd(context);
                } else if (str.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME")) {
                    vdVar = new ce(context);
                } else if (str.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA")) {
                    vdVar = new lg(context);
                } else if (str.equalsIgnoreCase("XIAOMI")) {
                    vdVar = new qp(context);
                } else {
                    String str3 = Build.BRAND;
                    if (str3.equalsIgnoreCase("XIAOMI") || str3.equalsIgnoreCase("REDMI") || (!TextUtils.isEmpty(og.a("ro.miui.ui.version.name", ""))) || str.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
                        vdVar = new qp(context);
                    } else if (str.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                        vdVar = new cl(context);
                    } else if (str.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(og.a("ro.vivo.os.version", ""))) {
                        vdVar = new ip(context);
                    } else if (str.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS")) {
                        vdVar = new v3(context);
                    } else if (og.a()) {
                        vdVar = new aa(context);
                        if (!vdVar.a()) {
                            vdVar = new ka(context);
                        }
                    } else if (str.equalsIgnoreCase("HUAWEI")) {
                        vdVar = new ka(context);
                    } else {
                        String str4 = Build.BRAND;
                        if (str4.equalsIgnoreCase("HUAWEI") || str4.equalsIgnoreCase("HONOR") || (!TextUtils.isEmpty(og.a("ro.build.version.emui", "")))) {
                            vdVar = new ka(context);
                        } else if (str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
                            vdVar = new dh(context);
                        } else {
                            String str5 = Build.BRAND;
                            if (str5.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) || str5.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(og.a("ro.build.version.opporom", "")) || str.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS")) {
                                vdVar = new dh(context);
                            } else {
                                try {
                                    context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
                                    vdVar = new b7(context);
                                } catch (Exception unused) {
                                    if (og.a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE")) {
                                        vdVar = new c7(context);
                                    } else {
                                        vdVar = TextUtils.isEmpty(og.a("ro.build.freeme.label", "")) ^ true ? new m9(context) : null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ng.f1325a = vdVar;
            if (vdVar == null || !vdVar.a()) {
                ueVar = new ue(context);
                if (!ueVar.a()) {
                    ueVar = new u9(context);
                    if (!ueVar.a()) {
                        ueVar = new p7();
                    }
                }
                ng.f1325a = ueVar;
            } else {
                ng.f1325a.getClass();
                ueVar = ng.f1325a;
            }
        }
        ueVar.a(ebVar);
    }
}
