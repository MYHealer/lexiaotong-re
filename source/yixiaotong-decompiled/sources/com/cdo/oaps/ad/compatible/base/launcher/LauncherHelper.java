package com.cdo.oaps.ad.compatible.base.launcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsParser;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.a;
import com.cdo.oaps.ad.ad;
import com.cdo.oaps.ad.af;
import com.cdo.oaps.ad.m;
import com.cdo.oaps.ad.p;
import com.cdo.oaps.ad.s;
import com.cdo.oaps.ad.v;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class LauncherHelper {
    private static String a(Context context, String str) {
        if (TextUtils.isEmpty(str) || !(Launcher.Host.MK.equals(str) || Launcher.Host.MK_OP.equals(str))) {
            return str;
        }
        return (p.b(context, a.b()) || p.b(context, af.e) || !p.b(context, a.a())) ? Launcher.Host.MK : Launcher.Host.MK_OP;
    }

    public static boolean launchActivity(Context context, String str) {
        return launchActivity(context, OapsParser.decode(str));
    }

    public static boolean launchActivity(Context context, Map<String, Object> map) {
        BaseWrapper.wrapper(map).setHost(a(context, BaseWrapper.wrapper(map).getHost()));
        return m.a(OapsWrapper.wrapper(map).getHost()).a(context, map);
    }

    public static boolean launchService(Context context, String str) {
        return launchService(context, OapsParser.decode(str));
    }

    public static boolean launchService(Context context, Map<String, Object> map) {
        BaseWrapper.wrapper(map).setHost(a(context, BaseWrapper.wrapper(map).getHost()));
        return m.a(OapsWrapper.wrapper(map).getHost()).b(context, map);
    }

    public static boolean support(Context context, String str) {
        String host;
        String path = null;
        try {
            Uri uri = Uri.parse(str);
            host = uri.getHost();
            try {
                path = uri.getPath();
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            host = null;
        }
        return support(context, host, path);
    }

    public static boolean support(Context context, String str, String str2) {
        if (Launcher.Host.GC.equals(str)) {
            return v.a(context, str2);
        }
        String strA = a(context, str);
        if (Launcher.Host.MK.equals(strA)) {
            return ad.a(context, str2);
        }
        if (Launcher.Host.MK_OP.equals(strA)) {
            return s.a(context, str2);
        }
        return false;
    }
}
