package com.kwad.components.core.video;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class k {
    private static Map<String, Integer> anV = new ConcurrentHashMap();

    public static boolean a(String str, String str2, com.kwad.sdk.core.network.a.a.C0746a c0746a) {
        String strMd5 = an.md5(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "start cache video key:" + strMd5 + "--url:" + str);
        boolean zB = com.kwad.sdk.core.diskcache.b.a.Lx().b(str, str2, c0746a);
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "finish cache video key:" + strMd5 + "--cache time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--success:" + zB);
        return zB;
    }

    public static boolean bh(AdTemplate adTemplate) {
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
        return fileCO != null && fileCO.exists();
    }

    public static String j(Context context, AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.helper.e.fe(adTemplate), com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
    }

    public static String k(Context context, String str) {
        return a(context, bq(str), str);
    }

    private static String a(Context context, int i, String str) {
        if (i >= 0) {
            return i > 0 ? com.kwad.sdk.core.videocache.c.a.cm(context).fx(str) : str;
        }
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(str);
        return (fileCO == null || !fileCO.exists()) ? str : fileCO.getAbsolutePath();
    }

    public static void n(String str, int i) {
        anV.put(str, Integer.valueOf(i));
    }

    private static int bq(String str) {
        Integer num = anV.get(str);
        if (num != null) {
            return num.intValue();
        }
        return com.kwad.sdk.core.config.e.Ga();
    }
}
