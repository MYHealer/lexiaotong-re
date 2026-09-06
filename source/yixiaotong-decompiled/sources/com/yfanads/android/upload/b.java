package com.yfanads.android.upload;

import android.os.HandlerThread;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.EventData;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.utils.YFAdsConst;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ReportManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b {
    public static boolean e;
    public static final HandlerThread f = new HandlerThread("Thread");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f9684a;
    public int b = 20;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final Gson d = new Gson();

    /* JADX INFO: compiled from: ReportManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9685a = new b();
    }

    public final void b() {
        try {
            if (!this.c.get() || this.f9684a == null) {
                HandlerThread handlerThread = f;
                handlerThread.start();
                d dVar = new d(handlerThread.getLooper(), this.b);
                this.f9684a = dVar;
                dVar.sendMessage(dVar.obtainMessage(1));
                this.c.set(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, int i, String str2) {
        if (a(i)) {
            return;
        }
        EventData eventData = new EventData();
        eventData.rId = str;
        eventData.eId = Util.getRandomUuid();
        eventData.eType = i;
        eventData.adId = str2;
        eventData.adnId = 0;
        eventData.adnAdId = "";
        eventData.t = Util.getCurrentTime();
        a(eventData);
    }

    public final void a(EventData eventData) {
        try {
            b();
            this.f9684a.c(eventData);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a() {
        Util.EXECUTOR.submit(new Runnable() { // from class: com.yfanads.android.upload.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a.a();
            }
        });
    }

    public final void a(int i, String str) {
        if (a(i)) {
            return;
        }
        EventData eventData = new EventData();
        eventData.eId = Util.getRandomUuid();
        eventData.rId = str;
        eventData.eType = i;
        eventData.t = Util.getCurrentTime();
        a(eventData);
    }

    public final void a(int i, int i2, String str, String str2) {
        if (a(i)) {
            return;
        }
        EventData eventData = new EventData();
        eventData.rId = str;
        eventData.eId = Util.getRandomUuid();
        eventData.eType = i;
        eventData.adnId = i2;
        eventData.adnAppId = str2;
        eventData.t = Util.getCurrentTime();
        a(eventData);
    }

    public final void a(SdkSupplier sdkSupplier, int i, String str) {
        if (a(i) || sdkSupplier == null) {
            return;
        }
        EventData eventData = new EventData();
        eventData.eId = Util.getRandomUuid();
        eventData.msg = str;
        eventData.t = Util.getCurrentTime();
        eventData.eType = i;
        sdkSupplier.getReport(eventData);
        a(eventData);
    }

    public final void a(SdkSupplier sdkSupplier, int i, int i2) {
        if (a(i) || sdkSupplier == null) {
            return;
        }
        EventData eventData = new EventData();
        eventData.eId = Util.getRandomUuid();
        eventData.t = Util.getCurrentTime();
        eventData.tCost = i2;
        eventData.eType = i;
        sdkSupplier.getReport(eventData);
        a(eventData);
    }

    public static boolean a(int i) {
        return !e && i >= YFAdsConst.ReportETypeValue.NEW_EVENT_TYPE.getValue();
    }
}
