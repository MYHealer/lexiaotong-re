package com.meishu.sdk.core.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.meishu.sdk.core.bquery.g;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.z;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ImageSourceHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.meishu.sdk.core.cache.image.a> f4778a = new ConcurrentHashMap<>();

    public static void a(String str, d dVar) {
        Bitmap bitmapDecodeByteArray;
        if (TextUtils.isEmpty(str)) {
            dVar.a(0);
            return;
        }
        try {
            File fileA = g.a(str, (String) null);
            if (fileA != null && fileA.exists() && fileA.length() > 0) {
                if (System.currentTimeMillis() - fileA.lastModified() < 86400000) {
                    byte[] bArrA = g.a(fileA.getAbsolutePath());
                    if (bArrA != null && bArrA.length > 0 && (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length)) != null) {
                        dVar.a(bitmapDecodeByteArray, bArrA, true);
                        return;
                    }
                } else {
                    try {
                        fileA.delete();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            String strB = g.b(str);
            ConcurrentHashMap<String, com.meishu.sdk.core.cache.image.a> concurrentHashMap = f4778a;
            if (concurrentHashMap.containsKey(strB)) {
                concurrentHashMap.get(strB).a(dVar);
                dVar.a();
            } else {
                com.meishu.sdk.core.cache.image.c cVarA = new com.meishu.sdk.core.cache.image.c(str, new b(str)).a(dVar);
                concurrentHashMap.put(strB, cVarA);
                z.a(cVarA.b, (x) new com.meishu.sdk.core.cache.image.b(cVarA), false);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            dVar.a(9);
        }
    }
}
