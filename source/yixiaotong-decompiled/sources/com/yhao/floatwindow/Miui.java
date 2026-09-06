package com.yhao.floatwindow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import com.unionpay.tsmservice.mi.data.Constant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class Miui {
    private static PermissionListener mPermissionListener = null;
    private static List<PermissionListener> mPermissionListenerList = null;
    private static final String miui = "ro.miui.ui.version.name";
    private static final String miui5 = "V5";
    private static final String miui6 = "V6";
    private static final String miui7 = "V7";
    private static final String miui8 = "V8";
    private static final String miui9 = "V9";

    Miui() {
    }

    static boolean rom() {
        LogUtil.d(" Miui  : " + getProp());
        return Build.MANUFACTURER.equals(Constant.DEVICE_XIAOMI);
    }

    private static String getProp() {
        return Rom.getProp(miui);
    }

    static void req(Context context, PermissionListener permissionListener) {
        if (PermissionUtil.hasPermission(context)) {
            permissionListener.onSuccess();
            return;
        }
        if (mPermissionListenerList == null) {
            mPermissionListenerList = new ArrayList();
            mPermissionListener = new PermissionListener() { // from class: com.yhao.floatwindow.Miui.1
                @Override // com.yhao.floatwindow.PermissionListener
                public void onSuccess() {
                    Iterator it = Miui.mPermissionListenerList.iterator();
                    while (it.hasNext()) {
                        ((PermissionListener) it.next()).onSuccess();
                    }
                    Miui.mPermissionListenerList.clear();
                }

                @Override // com.yhao.floatwindow.PermissionListener
                public void onFail() {
                    Iterator it = Miui.mPermissionListenerList.iterator();
                    while (it.hasNext()) {
                        ((PermissionListener) it.next()).onFail();
                    }
                    Miui.mPermissionListenerList.clear();
                }
            };
            req_(context);
        }
        mPermissionListenerList.add(permissionListener);
    }

    private static void req_(final Context context) {
        String prop = getProp();
        prop.hashCode();
        switch (prop) {
            case "V5":
                reqForMiui5(context);
                break;
            case "V6":
            case "V7":
                reqForMiui67(context);
                break;
            case "V8":
            case "V9":
                reqForMiui89(context);
                break;
        }
        FloatLifecycle.setResumedListener(new ResumedListener() { // from class: com.yhao.floatwindow.Miui.2
            @Override // com.yhao.floatwindow.ResumedListener
            public void onResumed() {
                if (PermissionUtil.hasPermission(context)) {
                    Miui.mPermissionListener.onSuccess();
                } else {
                    Miui.mPermissionListener.onFail();
                }
            }
        });
    }

    private static void reqForMiui5(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, null));
        intent.setFlags(268435456);
        if (Rom.isIntentAvailable(intent, context)) {
            context.startActivity(intent);
        } else {
            LogUtil.e("intent is not available!");
        }
    }

    private static void reqForMiui67(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (Rom.isIntentAvailable(intent, context)) {
            context.startActivity(intent);
        } else {
            LogUtil.e("intent is not available!");
        }
    }

    private static void reqForMiui89(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (Rom.isIntentAvailable(intent, context)) {
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        intent2.setFlags(268435456);
        if (Rom.isIntentAvailable(intent2, context)) {
            context.startActivity(intent2);
        } else {
            LogUtil.e("intent is not available!");
        }
    }

    private static void addViewToWindow(WindowManager windowManager, View view, WindowManager.LayoutParams layoutParams) {
        setMiUI_International(true);
        windowManager.addView(view, layoutParams);
        setMiUI_International(false);
    }

    private static void setMiUI_International(boolean z) {
        try {
            Field declaredField = Class.forName("miui.os.Build").getDeclaredField("IS_INTERNATIONAL_BUILD");
            declaredField.setAccessible(true);
            declaredField.setBoolean(null, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
