package com.hihonor.hianalytics.hnha;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class d implements Runnable {
    public d(Context context) {
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, InvocationTargetException {
        j2.c("ABTest/ReadCacheDataTask", "read cache task running");
        try {
            b.b().c((String) s1.a(com.hihonor.hianalytics.util.p.a("abtest", "exp_data", ""), r1.c().b()).second);
        } catch (JSONException unused) {
            j2.g("ABTest/ReadCacheDataTask", "experiment data error");
        }
        b.b().a(true);
        b.b().b(false);
    }
}
