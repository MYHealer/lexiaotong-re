package com.hihonor.hianalytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.g;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.hnha.r3;
import com.hihonor.hianalytics.hnha.t3;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AnalyticsCloudConfigReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3711a = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Intent intent, Context context) {
        String action = intent == null ? null : intent.getAction();
        String str = intent != null ? intent.getPackage() : null;
        String strA = a.a(intent, "sendProcessName");
        String processName = SystemUtils.getProcessName();
        if (TextUtils.isEmpty(action) || !Objects.equals(g.p(), str)) {
            j2.b("AnalyticsCloudConfigReceiver", "onReceive notSamePkgName=" + str + ",action=" + action + ",sendPName=" + strA + ",nowProcessName=" + processName + ",context=" + context + ",intent=" + intent);
            return;
        }
        if (strA != null && strA.equals(processName)) {
            j2.a("AnalyticsCloudConfigReceiver", "onReceive sameProcessName=" + strA + ",action=" + action + ",pkgName=" + str + ",context=" + context + ",intent=" + intent);
        }
        j2.a("AnalyticsCloudConfigReceiver", "onReceive action=" + action + ",pkgName=" + str + ",sendPName=" + strA + ",nowProcessName=" + processName + ",context=" + context + ",intent=" + intent);
        action.hashCode();
        action.hashCode();
        switch (action) {
            case "com.hihonor.hianalytics.config.action.REPORT_SWITCH_CHANGED":
                p2.d().k();
                break;
            case "com.hihonor.hianalytics.config.action.REPORT_EXCLUDE_TAG_CHANGED":
                p2.d().g(false);
                break;
            case "com.hihonor.hianalytics.config.action.REPORT_EXCLUDE_APP_ID_CHANGED":
                p2.d().g(true);
                break;
            case "com.hihonor.hianalytics.config.action.LIMIT_REPORT_CHANGED":
                p2.d().m();
                break;
            case "com.hihonor.hianalytics.config.action.DATA_CHANGED":
                p2.b().n();
                p2.e().c();
                break;
            case "com.hihonor.hianalytics.config.action.OWN_REPORT_SWITCH_CHANGED":
                p2.d().l();
                break;
        }
    }

    public synchronized void a() {
        j2.a("AnalyticsCloudConfigReceiver", "start, isStarted:" + this.f3711a);
        if (this.f3711a) {
            return;
        }
        this.f3711a = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.hihonor.hianalytics.config.action.DATA_CHANGED");
        intentFilter.addAction("com.hihonor.hianalytics.config.action.REPORT_SWITCH_CHANGED");
        intentFilter.addAction("com.hihonor.hianalytics.config.action.REPORT_EXCLUDE_APP_ID_CHANGED");
        intentFilter.addAction("com.hihonor.hianalytics.config.action.REPORT_EXCLUDE_TAG_CHANGED");
        intentFilter.addAction("com.hihonor.hianalytics.config.action.OWN_REPORT_SWITCH_CHANGED");
        intentFilter.addAction("com.hihonor.hianalytics.config.action.LIMIT_REPORT_CHANGED");
        a.a(SystemUtils.getContext(), this, intentFilter, false);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        t3.f(new r3() { // from class: com.hihonor.hianalytics.receiver.AnalyticsCloudConfigReceiver$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsCloudConfigReceiver.a(intent, context);
            }
        });
    }
}
