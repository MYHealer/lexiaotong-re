package com.yfanads.android.upload;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.lifecycle.BFLifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.EventData;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ScheduledTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d extends Handler implements BFLifecycleListener {
    public static int f = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f9687a;
    public boolean b;
    public double c;
    public boolean d;
    public final Gson e;

    /* JADX INFO: compiled from: ScheduledTask.java */
    public class a extends NetCallBack.NetCallBackString {
        public a(boolean z) {
            super(false, z);
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        /* JADX INFO: renamed from: onFailure */
        public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
            YFLog.high("ScheduledTask rtReport fail " + i);
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        /* JADX INFO: renamed from: onResponse */
        public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
            YFLog.high("ScheduledTask rtReport success " + Thread.currentThread().getName());
        }
    }

    public d(Looper looper, int i) {
        super(looper);
        this.f9687a = new AtomicInteger(-1);
        this.b = false;
        this.c = 0.0d;
        this.d = false;
        this.e = new Gson();
        if (i > 0) {
            f = i;
        }
        YFLog.high("ScheduledTask ScheduledTask max=" + i);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EventData eventData) {
        if (eventData == null) {
            YFLog.error("ScheduledTask event is null, return.");
            return;
        }
        eventData.sdkVer = YFAdsPhone.getInstance().getSDKVersion();
        boolean zA = com.yfanads.android.db.dao.b.a.f9645a.a(eventData);
        int i = this.f9687a.get();
        if (zA) {
            this.f9687a.set(i + 1);
        }
        if (!this.d || this.f9687a.get() <= f) {
            return;
        }
        YFLog.high("ScheduledTask wakeUpMessage from ".concat("report"));
        sendMessageAtFrontOfQueue(obtainMessage(1));
    }

    public final void b() {
        LifecycleObserver.getInstance().unRegisterLifecycleListener(this);
        LifecycleObserver.getInstance().registerLifecycleListener(this);
    }

    public final void c(final EventData eventData) {
        post(new Runnable() { // from class: com.yfanads.android.upload.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(eventData);
            }
        });
    }

    public final void d(final EventData eventData) {
        post(new Runnable() { // from class: com.yfanads.android.upload.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(eventData);
            }
        });
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
        if (message.what == 1) {
            synchronized (this) {
                if (a()) {
                    sendMessageDelayed(obtainMessage(1), 1000L);
                    return;
                }
                if (this.c >= 2.147483647E9d) {
                    this.c = 0.0d;
                }
                double d = this.c + 1000.0d;
                this.c = d;
                if (d % 10000.0d != 0.0d) {
                    if (this.f9687a.get() == -1) {
                        int iA = com.yfanads.android.db.dao.b.a.f9645a.a();
                        YFLog.debug("ScheduledTaskevent count init " + iA);
                        this.f9687a.set(iA);
                    }
                    if (this.f9687a.get() < f) {
                        if (!this.d) {
                            sendMessageDelayed(obtainMessage(1), 1000L);
                        } else if (this.f9687a.get() == 0) {
                            YFLog.high("ScheduledTask sleepMessage from action");
                            this.c = 0.0d;
                            removeMessages(1);
                        } else {
                            YFLog.high("ScheduledTask wakeUpMessage from ".concat("action"));
                            sendMessageAtFrontOfQueue(obtainMessage(1));
                        }
                    }
                }
                b(com.yfanads.android.db.dao.b.a.f9645a.a(f));
                sendMessageDelayed(obtainMessage(1), 1000L);
            }
        }
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public final void onBackToBackground() {
        this.d = true;
        YFLog.high("ScheduledTask onBackToBackground");
    }

    public final void b(ArrayList arrayList) {
        if (YFListUtils.isEmpty(arrayList)) {
            return;
        }
        synchronized (this) {
            this.b = true;
        }
        UrlHttpUtil.uploadJson(a(arrayList), UrlHttpUtil.IS_AES, new c(this, UrlHttpUtil.IS_AES, arrayList));
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public final void onBackToForeground() {
        this.d = false;
        YFLog.high("ScheduledTask onBackToForeground");
        YFLog.high("ScheduledTask wakeUpMessage from ".concat("onBackToForeground"));
        sendMessageAtFrontOfQueue(obtainMessage(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(EventData eventData) {
        eventData.sdkVer = YFAdsPhone.getInstance().getSDKVersion();
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventData);
        UrlHttpUtil.uploadJsonByTry(a(arrayList), UrlHttpUtil.IS_AES, new a(UrlHttpUtil.IS_AES));
    }

    public final String a(ArrayList arrayList) {
        YFLog.high("ScheduledTask uploadData start " + arrayList.size());
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        YFAdsPhone yFAdsPhone = YFAdsPhone.getInstance();
        HashMap map = new HashMap();
        map.put(YFAdsConst.REPORT_DEV_ID, yFAdsPhone.getDeviceId());
        map.put(YFAdsConst.REPORT_APPID, yFAdsConfig.getAppId());
        map.put(YFAdsConst.REPORT_DEV_TYPE, 0);
        map.put("at", Long.valueOf(yFAdsPhone.getActivationTime()));
        map.put(YFAdsConst.REPORT_DB, yFAdsPhone.brand);
        map.put("dm", yFAdsPhone.model);
        map.put(YFAdsConst.REPORT_DT, Integer.valueOf(yFAdsPhone.isTablet ? 2 : 1));
        map.put(YFAdsConst.REPORT_IDFA, 1);
        map.put("events", arrayList);
        map.put(YFAdsConst.REPORT_APP_VER, yFAdsConfig.getAppVer());
        map.put(YFAdsConst.REPORT_BULDLE, yFAdsConfig.getAppName());
        Map<String, Object> customDefine = yFAdsConfig.getCustomDefine();
        if (!YFListUtils.isMapEmpty(customDefine)) {
            map.put(YFAdsConst.REPORT_EX, customDefine);
        }
        Map<String, Object> userDefine = yFAdsConfig.getUserDefine();
        if (!YFListUtils.isMapEmpty(userDefine)) {
            map.put(YFAdsConst.REPORT_UD, userDefine);
        }
        return this.e.toJson(map);
    }

    public final synchronized boolean a() {
        return this.b;
    }
}
