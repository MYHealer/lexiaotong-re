package com.huawei.hms.scankit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.e1;
import com.huawei.hms.scankit.p.f1;
import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.z5;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: DecodeThread.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4194a;
    private final g0 b;
    private final Map<f1, Object> c;
    private Handler d;
    private a e;
    private Rect g;
    private boolean h = true;
    private final CountDownLatch f = new CountDownLatch(1);

    d(Context context, g0 g0Var, a aVar, Collection<BarcodeFormat> collection, Map<f1, ?> map, String str, z5 z5Var) {
        this.f4194a = context;
        this.b = g0Var;
        this.e = aVar;
        EnumMap enumMap = new EnumMap(f1.class);
        this.c = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(e1.f4236a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(e1.b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(e1.d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(e1.e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(e1.f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(e1.g);
            }
        }
        enumMap.put(f1.POSSIBLE_FORMATS, collection);
        if (str != null) {
            enumMap.put(f1.CHARACTER_SET, str);
        }
        enumMap.put(f1.NEED_RESULT_POINT_CALLBACK, z5Var);
        x3.c("DecodeThread", "Hints: " + enumMap);
    }

    public void a(Rect rect) {
        this.g = rect;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b() {
        this.f4194a = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.d = new c(this.f4194a, this.b, this.e, this.c, this.g, this.h);
        this.f.countDown();
        Looper.loop();
    }

    Handler a() {
        try {
            this.f.await();
        } catch (InterruptedException unused) {
            x3.b("exception", "InterruptedException");
        }
        return this.d;
    }
}
