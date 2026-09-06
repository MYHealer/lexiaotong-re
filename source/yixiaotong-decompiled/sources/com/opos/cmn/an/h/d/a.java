package com.opos.cmn.an.h.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PackageManager f5933a;
    private static final String b = "com." + com.opos.cmn.an.b.a.c + ".feature.screen.heteromorphism";

    public static PackageManager a(Context context) {
        if (f5933a == null && context != null) {
            f5933a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
        }
        return f5933a;
    }

    public static boolean a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return false;
        }
        try {
            return a(context).resolveActivity(intent, 65536) != null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
            return false;
        }
    }

    public static boolean a(Context context, View view) {
        WindowInsets rootWindowInsets;
        boolean zHasSystemFeature = false;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (view != null && (rootWindowInsets = view.getRootWindowInsets()) != null && rootWindowInsets.getDisplayCutout() != null) {
                    zHasSystemFeature = true;
                }
            } else if (context != null) {
                zHasSystemFeature = a(context).hasSystemFeature(b);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
        }
        return zHasSystemFeature;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return !com.opos.cmn.an.d.a.a(str) && context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
            return false;
        }
    }

    public static int b(Context context, String str) {
        int i = -1;
        try {
            PackageManager packageManagerA = a(context);
            if (packageManagerA != null && !com.opos.cmn.an.d.a.a(str)) {
                try {
                    i = packageManagerA.getPackageInfo(str, 0).versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    com.opos.cmn.an.f.a.c("PkgMgrTool", "getAppVerCode", e);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
        }
        return i;
    }

    @Deprecated
    public static List<String> b(Context context) {
        return null;
    }

    public static String c(Context context, String str) {
        String str2;
        try {
            PackageManager packageManagerA = a(context);
            if (packageManagerA == null || com.opos.cmn.an.d.a.a(str)) {
                str2 = "";
            } else {
                try {
                    str2 = packageManagerA.getPackageInfo(str, 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    com.opos.cmn.an.f.a.c("PkgMgrTool", "getAppVerCode", e);
                    str2 = "";
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
        }
        return str2 != null ? str2 : "";
    }

    public static boolean d(Context context, String str) {
        PackageManager packageManagerA;
        if (context == null) {
            return false;
        }
        try {
            if (com.opos.cmn.an.d.a.a(str) || (packageManagerA = a(context)) == null) {
                return false;
            }
            try {
                return packageManagerA.getApplicationInfo(str, 128) != null;
            } catch (Exception unused) {
                return false;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
            return false;
        }
    }

    public static boolean e(Context context, String str) {
        PackageManager packageManagerA;
        boolean z = false;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.a.a(str) && (packageManagerA = a(context)) != null) {
                    try {
                        Intent launchIntentForPackage = packageManagerA.getLaunchIntentForPackage(str);
                        if (launchIntentForPackage != null) {
                            launchIntentForPackage.addFlags(268435456);
                            context.startActivity(launchIntentForPackage);
                            z = true;
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
            }
        }
        return z;
    }

    public static Drawable f(Context context, String str) throws PackageManager.NameNotFoundException {
        Drawable applicationIcon = null;
        try {
            PackageManager packageManagerA = a(context);
            if (packageManagerA != null && !com.opos.cmn.an.d.a.a(str)) {
                try {
                    applicationIcon = packageManagerA.getApplicationIcon(str);
                } catch (PackageManager.NameNotFoundException e) {
                    com.opos.cmn.an.f.a.c("PkgMgrTool", "getAppVerCode", e);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
        }
        return applicationIcon;
    }

    public static String g(Context context, String str) {
        PackageManager packageManagerA;
        String string = "";
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.a.a(str) && (packageManagerA = a(context)) != null) {
                    try {
                        ApplicationInfo applicationInfo = packageManagerA.getApplicationInfo(str, 128);
                        if (applicationInfo != null) {
                            string = applicationInfo.loadLabel(packageManagerA).toString();
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("PkgMgrTool", string, e2);
            }
        }
        return string;
    }

    public static ApplicationInfo h(Context context, String str) {
        PackageManager packageManagerA;
        if (context == null) {
            return null;
        }
        try {
            if (com.opos.cmn.an.d.a.a(str) || (packageManagerA = a(context)) == null) {
                return null;
            }
            try {
                return packageManagerA.getApplicationInfo(str, 128);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
            return null;
        }
    }
}
