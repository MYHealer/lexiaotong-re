package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: RealTimeDebugSwitch.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9198a = "RealTimeDebugSwitch";
    private static int b;

    @Override // com.umeng.analytics.pro.ar
    public void a() {
    }

    @Override // com.umeng.analytics.pro.ar
    public void a(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.ar
    public void b() {
    }

    @Override // com.umeng.analytics.pro.ar
    public void b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.ar
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.ar
    public void c() {
    }

    @Override // com.umeng.analytics.pro.ar
    public void c(Activity activity) {
        b++;
    }

    @Override // com.umeng.analytics.pro.ar
    public void d(Activity activity) {
        b--;
    }

    @Override // com.umeng.analytics.pro.ar
    public void e(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.ar
    public void a(Activity activity, Bundle bundle) {
        long jLongValue;
        if (b == 0) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    String scheme = data.getScheme();
                    if (scheme != null && scheme.startsWith("um.")) {
                        String queryParameter = data.getQueryParameter(AnalyticsConfig.DEBUG_KEY);
                        String queryParameter2 = data.getQueryParameter(AnalyticsConfig.DEBUG_MODE_PERIOD);
                        if (TextUtils.isEmpty(queryParameter)) {
                            return;
                        }
                        if (TextUtils.isEmpty(queryParameter2)) {
                            jLongValue = 0;
                        } else {
                            try {
                                jLongValue = Long.valueOf(queryParameter2).longValue();
                            } catch (Throwable unused) {
                                jLongValue = 0;
                            }
                        }
                        HashMap map = new HashMap();
                        map.put(AnalyticsConfig.DEBUG_KEY, queryParameter);
                        if (jLongValue < 0) {
                            if (AnalyticsConfig.isRealTimeDebugMode()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> call turnOffRealTimeDebug because sendaging < 0");
                                AnalyticsConfig.turnOffRealTimeDebug();
                                Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                                UMWorkDispatch.sendEvent(origApplicationContext, o.a.E, CoreProtocol.getInstance(origApplicationContext), null);
                                return;
                            }
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Not currently in RealTimeDebug mode and doing nothing.");
                            return;
                        }
                        if (jLongValue > 0) {
                            AnalyticsConfig.turnOnRealTimeDebug(map);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("startTime", System.currentTimeMillis());
                                if (jLongValue < 60) {
                                    jLongValue = 60;
                                }
                                if (jLongValue > 240) {
                                    jLongValue = 240;
                                }
                                jSONObject.put("period", jLongValue);
                                jSONObject.put(AnalyticsConfig.DEBUG_KEY, queryParameter);
                            } catch (Throwable unused2) {
                            }
                            Context origApplicationContext2 = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                            UMWorkDispatch.sendEvent(origApplicationContext2, o.a.D, CoreProtocol.getInstance(origApplicationContext2), jSONObject);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[persistent] dk: " + queryParameter + "; period: " + jLongValue);
                            return;
                        }
                        AnalyticsConfig.turnOnRealTimeDebug(map);
                        Context origApplicationContext3 = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                        UMWorkDispatch.sendEvent(origApplicationContext3, o.a.E, CoreProtocol.getInstance(origApplicationContext3), null);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[non-persistent] dk: " + queryParameter);
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> scheme: " + scheme);
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> uri: " + data);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> intent: " + intent);
        }
    }
}
