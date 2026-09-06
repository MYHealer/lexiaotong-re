package com.huawei.openalliance.ad.download.app;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.download.DownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AppDownloadTask extends DownloadTask {
    private static final String TAG = "AppDownloadTask";

    @com.huawei.openalliance.ad.annotations.d
    private AdContentData adContentData;
    private Integer agdDownloadSource;
    private int apiVer;

    @com.huawei.openalliance.ad.annotations.d
    private AppInfo appInfo;
    private String apptaskInfo;
    private boolean autoOpenInLandingPage;
    private String contentId;
    private String curInstallWay;
    private String customData;
    private Integer downloadSource;
    private Integer downloadSourceMutable;

    @com.huawei.openalliance.ad.annotations.d
    private int installResult;

    @com.huawei.openalliance.ad.annotations.d
    private Queue<String> installWayQueue = new ConcurrentLinkedQueue();
    private String requestId;
    private String showId;
    private String slotId;

    @com.huawei.openalliance.ad.annotations.d
    private long startTime;
    private String templateId;
    private String userId;

    public static class a {
        private AppInfo Code;
        private boolean V;

        public a Code(AppInfo appInfo) {
            this.Code = appInfo;
            return this;
        }

        public a Code(boolean z) {
            this.V = z;
            return this;
        }

        public AppDownloadTask Code() {
            if (this.Code == null) {
                return null;
            }
            AppDownloadTask appDownloadTask = new AppDownloadTask();
            appDownloadTask.Code(this.V);
            appDownloadTask.Code(this.Code);
            appDownloadTask.Code(this.Code.Z());
            appDownloadTask.V(this.Code.C());
            appDownloadTask.Code(this.Code.B());
            appDownloadTask.V(0);
            appDownloadTask.V(this.Code);
            return appDownloadTask;
        }
    }

    private boolean I(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.S() && TextUtils.isEmpty(appInfo.C());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(AppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        try {
            this.installWayQueue.clear();
            String strI = appInfo.i();
            if (!TextUtils.isEmpty(strI)) {
                this.installWayQueue.offer(strI);
            }
            a(appInfo.x());
        } catch (Throwable th) {
            try {
                fh.I(TAG, "parse install way exception: %s", th.getClass().getSimpleName());
            } finally {
                this.curInstallWay = appInfo.i();
            }
        }
    }

    private boolean c(String str) {
        AppInfo appInfo;
        return (!"7".equals(str) || (appInfo = this.appInfo) == null || TextUtils.isEmpty(appInfo.j())) ? false : true;
    }

    private boolean d(String str) {
        return !TextUtils.isEmpty(str) && (str.equals("8") || str.equals("6") || str.equals("5"));
    }

    private boolean r() {
        AdContentData adContentData;
        AppInfo appInfo = this.appInfo;
        return (appInfo == null || TextUtils.isEmpty(appInfo.e()) || (adContentData = this.adContentData) == null || TextUtils.isEmpty(adContentData.aa())) ? false : true;
    }

    private boolean s() {
        AppInfo appInfo = this.appInfo;
        if (appInfo == null) {
            return true;
        }
        if ("11".equals(appInfo.i())) {
            return false;
        }
        return TextUtils.isEmpty(this.appInfo.Code()) || TextUtils.isEmpty(this.appInfo.Z()) || I(this.appInfo) || this.appInfo.B() <= 0;
    }

    public void B(int i) {
        this.installResult = i;
    }

    public void B(String str) {
        this.apptaskInfo = str;
    }

    public void C(int i) {
        this.apiVer = i;
    }

    public void C(String str) {
        this.contentId = str;
    }

    public void Code(AdContentData adContentData) {
        this.adContentData = adContentData;
    }

    public void Code(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public void Code(Integer num) {
        if (this.downloadSource == null) {
            this.downloadSource = num;
        }
        this.downloadSourceMutable = num;
    }

    public void D(String str) {
        this.requestId = str;
    }

    @Override // com.huawei.openalliance.ad.download.DownloadTask
    public String F() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.Code();
        }
        return null;
    }

    public void F(String str) {
        this.userId = str;
    }

    public void I(long j) {
        this.startTime = j;
    }

    public void I(Integer num) {
        this.agdDownloadSource = num;
    }

    public void I(String str) {
        this.showId = str;
    }

    public AppInfo L() {
        AppInfo appInfo;
        String string;
        AppInfo appInfo2 = this.appInfo;
        if (appInfo2 != null && TextUtils.isEmpty(appInfo2.e())) {
            AdContentData adContentData = this.adContentData;
            if (adContentData == null || TextUtils.isEmpty(adContentData.aa())) {
                appInfo = this.appInfo;
                string = UUID.randomUUID().toString();
            } else {
                appInfo = this.appInfo;
                string = this.adContentData.aa();
            }
            appInfo.V(string);
        }
        if (r() && !this.appInfo.e().equals(this.adContentData.aa())) {
            this.appInfo.V(this.adContentData.aa());
        }
        return this.appInfo;
    }

    public void L(String str) {
        this.curInstallWay = str;
    }

    public void S(String str) {
        this.customData = str;
    }

    public void V(Integer num) {
        this.downloadSourceMutable = num;
    }

    public void V(boolean z) {
        this.autoOpenInLandingPage = z;
    }

    public void Z(String str) {
        this.slotId = str;
    }

    public Integer a() {
        return this.downloadSourceMutable;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (d(str2) || c(str2) || !s()) {
                    this.installWayQueue.offer(str2);
                }
            }
        }
    }

    public Integer b() {
        return this.downloadSource;
    }

    public void b(String str) {
        this.templateId = str;
    }

    public Integer c() {
        return this.agdDownloadSource;
    }

    public String d() {
        return this.showId;
    }

    public String e() {
        return this.contentId;
    }

    @Override // com.huawei.openalliance.ad.download.DownloadTask
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public AdContentData f() {
        return this.adContentData;
    }

    public String g() {
        return this.customData;
    }

    public String h() {
        return this.userId;
    }

    @Override // com.huawei.openalliance.ad.download.DownloadTask
    public int hashCode() {
        return super.hashCode();
    }

    public String i() {
        return this.requestId;
    }

    public String j() {
        if (!TextUtils.isEmpty(this.curInstallWay)) {
            return this.curInstallWay;
        }
        AppInfo appInfo = this.appInfo;
        return appInfo != null ? appInfo.i() : "4";
    }

    public boolean k() {
        return "7".equals(j());
    }

    public boolean l() {
        boolean z = false;
        if (!m()) {
            return false;
        }
        if (this.installWayQueue.poll() != null && !this.installWayQueue.isEmpty()) {
            z = true;
        }
        L(this.installWayQueue.peek());
        return z;
    }

    public boolean m() {
        Integer num;
        return this.installWayQueue.size() > 1 && ((num = this.agdDownloadSource) == null || num.intValue() == 2);
    }

    public boolean n() {
        AppInfo appInfo = this.appInfo;
        return (appInfo == null || TextUtils.isEmpty(appInfo.Code()) || !d(j())) ? false : true;
    }

    public int o() {
        return this.installResult;
    }

    public long p() {
        return this.startTime;
    }

    public boolean q() {
        return this.autoOpenInLandingPage;
    }
}
