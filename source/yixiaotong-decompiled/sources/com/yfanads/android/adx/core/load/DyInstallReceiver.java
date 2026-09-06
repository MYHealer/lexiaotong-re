package com.yfanads.android.adx.core.load;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.yfanads.android.adx.download.infs.b;
import com.yfanads.android.adx.utils.a;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DyInstallReceiver extends BroadcastReceiver {
    private final AtomicBoolean HAS_REGISTER = new AtomicBoolean(false);
    private SoftReference<b> callListener;
    private IntentFilter filterInstall;

    public static class DyInstallReceiverHolder {
        private static final DyInstallReceiver INSTANCE = new DyInstallReceiver();

        private DyInstallReceiverHolder() {
        }
    }

    public static DyInstallReceiver getInstance() {
        return DyInstallReceiverHolder.INSTANCE;
    }

    private void report(Context context, Uri uri) {
        if (uri != null) {
            StringBuilder sbAppend = new StringBuilder("install  ").append(uri.getSchemeSpecificPart()).append(" , ");
            SoftReference<b> softReference = this.callListener;
            a.a(sbAppend.append(softReference != null ? Integer.valueOf(softReference.hashCode()) : "").toString());
            SoftReference<b> softReference2 = this.callListener;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.callListener.get().a(6);
        }
    }

    public void checkAppOpen(Context context, String str) {
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<UsageStats> listQueryUsageStats = usageStatsManager.queryUsageStats(0, jCurrentTimeMillis - 300000, jCurrentTimeMillis);
        if (listQueryUsageStats != null) {
            Iterator<UsageStats> it = listQueryUsageStats.iterator();
            while (it.hasNext()) {
                if (it.next().getPackageName().equals(str)) {
                    a.a("App " + str + " is opened.");
                    return;
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        a.a("onReceive " + action);
        if (TextUtils.isEmpty(action)) {
            return;
        }
        Uri data = intent.getData();
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            report(context, data);
        }
    }

    public void registerToApp(Context context) {
        if (context != null) {
            try {
                if (this.HAS_REGISTER.get()) {
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                this.filterInstall = intentFilter;
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                this.filterInstall.addDataScheme("package");
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(this, this.filterInstall, 1);
                } else {
                    context.registerReceiver(this, this.filterInstall);
                }
                this.HAS_REGISTER.set(true);
                a.a("registerToApp ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setReportCallListener(b bVar) {
        this.callListener = new SoftReference<>(bVar);
    }

    public void unregisterInstallReceiver(Context context) {
        try {
            if (this.filterInstall == null || !this.HAS_REGISTER.get()) {
                return;
            }
            context.unregisterReceiver(this);
            this.filterInstall = null;
            this.HAS_REGISTER.set(false);
            this.callListener = null;
            a.a("unregisterInstallReceiver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
