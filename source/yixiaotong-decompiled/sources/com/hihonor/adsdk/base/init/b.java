package com.hihonor.adsdk.base.init;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.hihonor.ads.identifier.AdvertisingIdClient;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.g.j.d.g0;
import com.hihonor.adsdk.common.f.a0;
import com.unionpay.tsmservice.data.Constant;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {
    private static final String hnadsg = "IdInfoManager";
    private static final int hnadsh = 0;
    private static final int hnadsi = 1;
    private static final int hnadsj = 2;
    private static final long hnadsk = 28800000;
    private C0440b hnadsa;
    private long hnadsb;
    private AtomicInteger hnadsc;
    private AtomicBoolean hnadsd;
    private CopyOnWriteArrayList<InitCallback> hnadse;
    private final Handler hnadsf;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.init.b$b, reason: collision with other inner class name */
    public static class C0440b {
        private String hnadsa;
        private boolean hnadsb;

        public boolean hnadsb() {
            return this.hnadsb;
        }

        public String hnadsa() {
            if (TextUtils.isEmpty(this.hnadsa)) {
                this.hnadsa = "";
            }
            return this.hnadsa;
        }
    }

    private class c extends ContentObserver {
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsg, "SettingsObserver oaid changed -> selfChange : " + z, new Object[0]);
            b.this.hnadsa(HnAds.get().getContext());
        }

        public c(Handler handler) {
            super(handler);
        }
    }

    private static class d {
        private static final b hnadsa = new b(null);

        private d() {
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b hnadsc() {
        return d.hnadsa;
    }

    private void hnadsd(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            C0440b c0440b = new C0440b();
            c0440b.hnadsa = advertisingIdInfo.id;
            c0440b.hnadsb = advertisingIdInfo.isLimit;
            hnadsa(c0440b);
        } catch (Exception e) {
            hnadsa(ErrorCode.AD_OAID_INFO_NULL, e.getMessage());
            com.hihonor.adsdk.common.b.b.hnadsb("HonorOAIDService", "getHonorOaid, getAdid error, Exception: " + e.getMessage(), new Object[0]);
        }
    }

    private void hnadsj() {
        try {
            Uri uriFor = Settings.Secure.getUriFor("oaid");
            Uri uriFor2 = Settings.Global.getUriFor("oaid");
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsg, (Object) ("registerOaidChangeObserver globalUri = " + uriFor2 + System.lineSeparator() + "secUri = " + uriFor));
            HnAds.get().getContext().getContentResolver().registerContentObserver(uriFor, true, new c(this.hnadsf));
            HnAds.get().getContext().getContentResolver().registerContentObserver(uriFor2, true, new c(this.hnadsf));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "registerOaidChangeObserver error : " + e.getMessage(), new Object[0]);
        }
    }

    public void hnadsa(final Context context) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsg, (Object) "start initIdInfo();");
        a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.init.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsc(context);
            }
        });
    }

    /* JADX INFO: renamed from: hnadsb, reason: merged with bridge method [inline-methods] */
    public void hnadsc(Context context) {
        if (1 == this.hnadsc.get()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "return: mInitState is:" + this.hnadsc.get(), new Object[0]);
            return;
        }
        hnadsa(1);
        hnadsd(context);
        hnadsa(2);
        com.hihonor.adsdk.base.g.j.b.hnadsa().hnadsa(true);
        this.hnadsd.set(true);
        this.hnadsf.post(new Runnable() { // from class: com.hihonor.adsdk.base.init.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb();
            }
        });
    }

    public String hnadse() {
        C0440b c0440bHnadsf = hnadsf();
        if (c0440bHnadsf != null) {
            return c0440bHnadsf.hnadsa();
        }
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "getHnOaid() hnInfo is null", new Object[0]);
        return "";
    }

    public boolean hnadsg() {
        return this.hnadsd.get() || !TextUtils.isEmpty(hnadse());
    }

    public void hnadsi() {
        if (!hnadsa()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "mayRefreshOaid() checkNeedInit is false", new Object[0]);
            com.hihonor.adsdk.base.g.j.b.hnadsa().hnadsb();
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "mayRefreshOaid() checkNeedInit is true", new Object[0]);
            if (2 == this.hnadsc.get()) {
                hnadsa(0);
            }
            hnadsa(HnAds.get().getContext());
        }
    }

    private b() {
        this.hnadsb = 0L;
        this.hnadsc = new AtomicInteger(0);
        this.hnadsd = new AtomicBoolean(false);
        this.hnadse = new CopyOnWriteArrayList<>();
        this.hnadsf = new Handler(Looper.getMainLooper());
        this.hnadsb = System.currentTimeMillis();
        hnadsj();
    }

    private boolean hnadsh() {
        C0440b c0440b = this.hnadsa;
        if (c0440b == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "isOaidValidate() checkNeedInit is false::isOaidValidate，info is null ", new Object[0]);
            return true;
        }
        if (!TextUtils.isEmpty(c0440b.hnadsa) && !this.hnadsa.hnadsa.startsWith(Constant.DEFAULT_CVN2)) {
            return false;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "isOaidValidate() checkNeedInit is false::isOaidValidate，info is null", new Object[0]);
        return true;
    }

    private void hnadsa(int i) {
        this.hnadsc.set(i);
    }

    public void hnadsa(InitCallback initCallback) {
        if (hnadsg()) {
            initCallback.onResult();
        } else {
            synchronized (b.class) {
                this.hnadse.add(initCallback);
            }
        }
    }

    public C0440b hnadsf() {
        C0440b c0440b = this.hnadsa;
        if (c0440b != null) {
            return c0440b;
        }
        String strHnadsb = com.hihonor.adsdk.base.init.c.hnadsb();
        if (TextUtils.isEmpty(strHnadsb)) {
            return null;
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsg, (Object) "getIdInfo() from sp cache");
        C0440b c0440b2 = new C0440b();
        c0440b2.hnadsa = strHnadsb;
        c0440b2.hnadsb = com.hihonor.adsdk.base.init.c.hnadsa();
        return c0440b2;
    }

    public int hnadsd() {
        C0440b c0440bHnadsf = hnadsf();
        if (c0440bHnadsf != null) {
            return c0440bHnadsf.hnadsb() ? 1 : 0;
        }
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "getHnLmt() hnInfo is null", new Object[0]);
        return 1;
    }

    private boolean hnadsa() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.hnadsa == null) {
            return true;
        }
        long j = this.hnadsb;
        if (jCurrentTimeMillis - j > hnadsk) {
            this.hnadsb = jCurrentTimeMillis;
            return true;
        }
        if (jCurrentTimeMillis < j) {
            this.hnadsb = jCurrentTimeMillis;
        }
        return hnadsh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsb() {
        synchronized (b.class) {
            if (this.hnadse.isEmpty()) {
                return;
            }
            Iterator<InitCallback> it = this.hnadse.iterator();
            while (it.hasNext()) {
                it.next().onResult();
            }
            this.hnadse.clear();
        }
    }

    private void hnadsa(C0440b c0440b) {
        if (c0440b != null) {
            if (!TextUtils.isEmpty(c0440b.hnadsa) || c0440b.hnadsb) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsg, (Object) ("cacheIdInfo() mIdInfo id=" + c0440b.hnadsa + "  isLimit=" + c0440b.hnadsb));
                this.hnadsa = c0440b;
                com.hihonor.adsdk.base.init.c.hnadsa(c0440b.hnadsb);
                com.hihonor.adsdk.base.init.c.hnadsa(c0440b.hnadsa());
                return;
            }
            hnadsa(ErrorCode.AD_OAID_INFO_NULL, "oaid is empty and lmt  false");
            com.hihonor.adsdk.common.b.b.hnadse(hnadsg, "cacheIdInfo() oaid is empty and lmt  false", new Object[0]);
            return;
        }
        hnadsa(ErrorCode.AD_OAID_INFO_NULL, "oaid info is null");
        com.hihonor.adsdk.common.b.b.hnadse(hnadsg, "cacheIdInfo() #Ad info is null", new Object[0]);
    }

    private void hnadsa(int i, String str) {
        new g0(String.valueOf(i), str).hnadse();
    }
}
