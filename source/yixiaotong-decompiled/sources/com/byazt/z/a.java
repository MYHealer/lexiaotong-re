package com.byazt.z;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.alipay.sdk.util.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 34})
public final class a {
    public static int c(String str) {
        if (ve(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.byazt.zz.ve.ic().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.x.c.n("AppUtils", "getAppVersionCode:" + e.getMessage());
            return -1;
        }
    }

    public static c tt(String str) {
        try {
            PackageManager packageManager = com.byazt.zz.ve.ic().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return c(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.x.c.n("AppUtils", "getAppInfo:" + e.getMessage());
            return null;
        }
    }

    private static c c(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawableLoadIcon = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String string = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new c(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 464})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2908a;
        public String c;
        public String n;
        public boolean sp;
        public String tt;
        public String uj;
        public Drawable ve;

        public int a() {
            return this.f2908a;
        }

        public Drawable c() {
            return this.ve;
        }

        public void c(int i) {
            this.f2908a = i;
        }

        public void c(Drawable drawable) {
            this.ve = drawable;
        }

        public void c(String str) {
            this.c = str;
        }

        public void c(boolean z) {
            this.sp = z;
        }

        public String n() {
            return this.uj;
        }

        public String sp() {
            return this.n;
        }

        public void tt(String str) {
            this.tt = str;
        }

        public boolean tt() {
            return this.sp;
        }

        public String uj() {
            return this.tt;
        }

        public void uj(String str) {
            this.n = str;
        }

        public String ve() {
            return this.c;
        }

        public void ve(String str) {
            this.uj = str;
        }

        public c(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            tt(str2);
            c(drawable);
            c(str);
            ve(str3);
            uj(str4);
            c(i);
            c(z);
        }

        public String toString() {
            return "{\n  pkg name: " + ve() + "\n  app icon: " + c() + "\n  app name: " + uj() + "\n  app path: " + n() + "\n  app v name: " + sp() + "\n  app v code: " + a() + "\n  is system: " + tt() + i.d;
        }
    }

    private static boolean ve(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
