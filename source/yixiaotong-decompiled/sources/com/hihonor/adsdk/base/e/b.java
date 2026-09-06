package com.hihonor.adsdk.base.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.t;
import com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b extends com.hihonor.adsdk.base.e.a {
    private static final String hnadse = "ChannelInfoProvider";
    private static final String hnadsf = "com.hihonor.android.mms.CHANNEL_SERVICE";
    private static final String hnadsg = "com.hihonor.id";
    private static final String hnadsh = "sp_cache_channel_info_time";
    private static final String hnadsi = "sp_cache_channel_info";
    private static final int hnadsj = 0;
    private static final int hnadsk = 1;
    private static final int hnadsl = 2;
    private static final long hnadsm = 600000;
    private static final int hnadsn = 10025;
    private IPPSChannelInfoService hnadsa;
    private volatile String hnadsb;
    private final AtomicInteger hnadsc;
    private final ServiceConnection hnadsd;

    class a implements ServiceConnection {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa(IBinder iBinder) {
            b.this.hnadsa = IPPSChannelInfoService.Stub.asInterface(iBinder);
            if (b.this.hnadsa == null) {
                b.this.hnadsa(ErrorCode.AD_MMS_CHANNEL_INFO_FAIL_BINDER_NULL, ErrorCode.AD_MMS_CHANNEL_INFO_FAIL_BINDER_NULL_MSG);
                return;
            }
            b.this.hnadsc.set(2);
            b.this.hnadsj();
            b.this.hnadsk();
            b.this.hnadsd();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadse, "onServiceConnected", new Object[0]);
            a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.e.b$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(iBinder);
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadse, "onServiceDisconnected", new Object[0]);
            b.this.hnadsc.set(0);
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.e.b$b, reason: collision with other inner class name */
    private static class C0432b {
        private static final b hnadsa = new b(null);

        private C0432b() {
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    private synchronized boolean hnadsi() {
        return this.hnadsc.get() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hnadsj() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "call loadChannelInfo", new Object[0]);
        IPPSChannelInfoService iPPSChannelInfoService = this.hnadsa;
        if (iPPSChannelInfoService == null) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadse, (Object) "call loadChannelInfo fail.cause by channelInfoService is null .");
            hnadsa(ErrorCode.AD_MMS_CHANNEL_INFO_FAIL_BINDER_NULL, ErrorCode.AD_MMS_CHANNEL_INFO_FAIL_BINDER_NULL_MSG);
            return;
        }
        try {
            this.hnadsb = iPPSChannelInfoService.getChannelInfo(hnadsn);
            if (TextUtils.isEmpty(this.hnadsb)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "get mms channelInfo is empty don't save.", new Object[0]);
                hnadsa(ErrorCode.AD_MMS_CHANNEL_INFO_FAIL, ErrorCode.AD_MMS_CHANNEL_INFO_FAIL_MSG);
            } else {
                hnadsa(0, "success");
                t.hnadsc().hnadsb(hnadsi, this.hnadsb);
                com.hihonor.adsdk.common.b.b.hnadsa(hnadse, (Object) ("get mms channelInfo=" + this.hnadsb));
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "getChannelInfoByPkgName error. exception is " + e.getMessage(), new Object[0]);
            hnadsa(ErrorCode.AD_MMS_GET_CHANNEL_INFO_REMOTE_ERROR, ErrorCode.AD_MMS_GET_CHANNEL_INFO_REMOTE_ERROR_MSG + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hnadsk() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        t.hnadsc().hnadsb(hnadsh, jCurrentTimeMillis);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "saveCacheChannelInfoTime lastCacheChannelInfoTime=" + jCurrentTimeMillis, new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.e.a
    public int hnadsa() {
        return 1;
    }

    public synchronized String hnadsf() {
        String str;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getChannelInfo", new Object[0]);
        if (TextUtils.isEmpty(this.hnadsb)) {
            this.hnadsb = t.hnadsc().hnadsg(hnadsi);
        }
        str = this.hnadsb;
        hnadsb();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadse, (Object) ("channelInfo=" + str));
        return str;
    }

    public synchronized void hnadsg() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "channel Info client init.", new Object[0]);
        hnadsb();
    }

    public synchronized boolean hnadsh() {
        return this.hnadsc.get() == 2;
    }

    private b() {
        this.hnadsb = "";
        this.hnadsc = new AtomicInteger(0);
        this.hnadsd = new a();
    }

    private void hnadsb() {
        long jHnadsa = t.hnadsc().hnadsa(hnadsh, 0L);
        if (TextUtils.isEmpty(this.hnadsb)) {
            this.hnadsb = t.hnadsc().hnadsg(hnadsi);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jHnadsa;
        if ((jHnadsa == 0 || jCurrentTimeMillis >= 600000) && TextUtils.isEmpty(this.hnadsb) && !hnadsi()) {
            a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.e.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsc();
                }
            });
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "checkChannelInfoValid lastCacheChannelInfoTime=" + jHnadsa + ", interval=" + jCurrentTimeMillis, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "connect", new Object[0]);
        if (hnadsi()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "current connect state is " + this.hnadsc.get(), new Object[0]);
            return;
        }
        Context context = HnAds.get().getContext();
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "call connect,but context is null. ", new Object[0]);
            this.hnadsc.set(0);
            hnadsa(ErrorCode.AD_MMS_CHANNEL_INFO_FAIL_CONTEXT_NULL, ErrorCode.AD_MMS_CHANNEL_INFO_FAIL_CONTEXT_NULL_MSG);
            return;
        }
        try {
            this.hnadsc.set(1);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "start bind mms service", new Object[0]);
            Intent intent = new Intent();
            intent.setAction(hnadsf);
            intent.setPackage(hnadsg);
            if (!context.bindService(intent, this.hnadsd, 1)) {
                this.hnadsc.set(0);
                hnadsa(ErrorCode.AD_MMS_CHANNEL_INFO_BIND_FAIL, ErrorCode.AD_MMS_CHANNEL_INFO_BIND_FAIL_MSG);
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "connect channel service error. exception is " + e.getMessage(), new Object[0]);
            this.hnadsc.set(0);
            hnadsa(ErrorCode.AD_MMS_CHANNEL_INFO_BIND_ERROR, ErrorCode.AD_MMS_CHANNEL_INFO_BIND_ERROR_MSG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "disconnect", new Object[0]);
        Context context = HnAds.get().getContext();
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "call disconnect,but context is null. ", new Object[0]);
            return;
        }
        try {
            try {
                context.unbindService(this.hnadsd);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "unbind service error.exception is " + e.getMessage(), new Object[0]);
            }
            this.hnadsc.set(0);
        } catch (Throwable th) {
            this.hnadsc.set(0);
            throw th;
        }
    }

    public static b hnadse() {
        return C0432b.hnadsa;
    }
}
