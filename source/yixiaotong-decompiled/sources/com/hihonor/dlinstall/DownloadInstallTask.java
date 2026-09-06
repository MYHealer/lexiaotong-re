package com.hihonor.dlinstall;

import android.content.Context;
import com.hihonor.dlinstall.ability.syncapp.AdAppReport;
import com.hihonor.dlinstall.ipc.g;
import com.hihonor.dlinstall.ipc.h;
import com.hihonor.dlinstall.ipc.i;
import com.hihonor.dlinstall.ipc.m;
import com.hihonor.dlinstall.report.DlInstallReportConfig;
import com.hihonor.dlinstall.util.a;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DownloadInstallTask {
    private static final String TAG = "DownloadInstallTask";
    private final AdAppReport adAppReport;
    private final String apkSign;
    private String authSign;
    private String callerApkVer;
    private final int channel;
    private long clickTime;
    private final Context context;
    private int detailType;
    private int downloadType;
    private final String extraData;
    private final int launcherInstallType;
    private String partner;
    private final String pkgName;
    private String referrer;
    private final DlInstallReportConfig reportConfig;
    private String requestId;
    private String sceneType;
    private String subChannel;
    private String ts;
    private final boolean useDialogTip;
    private String version;
    private final boolean wifiRequired;

    public static class Builder {
        private AdAppReport adAppReport;
        private String apkSign;
        private String authSign;
        private String callerApkVer;
        private long clickTime;
        private final Context context;
        private int detailType;
        private int downloadType;
        private String extraData;
        private String partner;
        private final String pkgName;
        private String referrer;
        private DlInstallReportConfig reportConfig;
        private String sceneType;
        private String ts;
        private boolean useDialogTip;
        private String version;
        private int channel = -1;
        private String subChannel = "";
        private boolean wifiRequired = false;
        private int launcherInstallType = 0;

        public Builder(Context context, String str) {
            this.context = context;
            this.pkgName = str;
        }

        public DownloadInstallTask build() {
            Context origApplicationContext = this.context;
            if (StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext()) != null) {
                origApplicationContext = StubApp.getOrigApplicationContext(this.context.getApplicationContext());
            }
            Context context = origApplicationContext;
            if (this.clickTime <= 0) {
                this.clickTime = System.currentTimeMillis() / 1000;
            }
            return new DownloadInstallTask(context, this.channel, this.subChannel, this.adAppReport, this.pkgName, this.wifiRequired, this.reportConfig, this.launcherInstallType, this.extraData, this.apkSign, this.useDialogTip, this.partner, this.authSign, this.referrer, this.ts, this.version, this.clickTime, this.detailType, this.downloadType, this.sceneType, this.callerApkVer);
        }

        public Builder setAdAppReport(AdAppReport adAppReport) {
            this.adAppReport = adAppReport;
            return this;
        }

        public Builder setApkSign(String str) {
            this.apkSign = str;
            return this;
        }

        public Builder setAuthSign(String str) {
            this.authSign = str;
            return this;
        }

        public Builder setCallerApkVer(String str) {
            this.callerApkVer = str;
            return this;
        }

        public Builder setChannel(int i) {
            this.channel = i;
            return this;
        }

        public Builder setClickTime(Long l) {
            this.clickTime = l.longValue();
            return this;
        }

        public Builder setDetailType(int i) {
            this.detailType = i;
            return this;
        }

        public Builder setDownloadType(int i) {
            this.downloadType = i;
            return this;
        }

        public Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        public Builder setLauncherInstallType(int i) {
            this.launcherInstallType = i;
            return this;
        }

        public Builder setPartner(String str) {
            this.partner = str;
            return this;
        }

        public Builder setReferrer(String str) {
            this.referrer = str;
            return this;
        }

        public Builder setReportConfig(DlInstallReportConfig dlInstallReportConfig) {
            this.reportConfig = dlInstallReportConfig;
            return this;
        }

        public Builder setSceneType(String str) {
            this.sceneType = str;
            return this;
        }

        public Builder setSubChannel(String str) {
            this.subChannel = str;
            return this;
        }

        public Builder setTs(String str) {
            this.ts = str;
            return this;
        }

        public Builder setUseDialogTip(boolean z) {
            this.useDialogTip = z;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }

        public Builder setWifiRequired(boolean z) {
            this.wifiRequired = z;
            return this;
        }
    }

    public DownloadInstallTask(Context context, int i, String str, AdAppReport adAppReport, String str2, boolean z, DlInstallReportConfig dlInstallReportConfig, int i2, String str3, String str4, boolean z2, String str5, String str6, String str7, String str8, String str9, long j, int i3, int i4, String str10, String str11) {
        this.context = context;
        this.channel = i;
        this.subChannel = str;
        this.adAppReport = adAppReport;
        this.pkgName = str2;
        this.wifiRequired = z;
        this.reportConfig = dlInstallReportConfig;
        this.launcherInstallType = i2;
        this.extraData = str3;
        this.requestId = a.a(context, str2, -1);
        this.apkSign = str4;
        this.useDialogTip = z2;
        this.partner = str5;
        this.authSign = str6;
        this.referrer = str7;
        this.ts = str8;
        this.version = str9;
        this.clickTime = j;
        this.detailType = i3;
        this.downloadType = i4;
        this.sceneType = str10;
        this.callerApkVer = str11;
    }

    public void cancel() {
        m mVarC = m.c();
        mVarC.getClass();
        if (a.b(getContext())) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "cancelDownloadInstall: task is " + this);
            mVarC.a(getContext());
            mVarC.a(getContext(), new m.b(new i(mVarC), this, 600000L, "cancelDownloadInstall"));
        } else {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "cancelDownloadInstall: isInstalled is false");
        }
        this.requestId = a.a(this.context, this.pkgName, -1);
    }

    public AdAppReport getAdAppReport() {
        return this.adAppReport;
    }

    public String getApkSign() {
        return this.apkSign;
    }

    public String getAuthSign() {
        return this.authSign;
    }

    public String getCallerApkVer() {
        return this.callerApkVer;
    }

    public int getChannel() {
        return this.channel;
    }

    public long getClickTime() {
        return this.clickTime;
    }

    public Context getContext() {
        return this.context;
    }

    public int getDetailType() {
        return this.detailType;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public int getLauncherInstallType() {
        return this.launcherInstallType;
    }

    public String getPartner() {
        return this.partner;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public DlInstallReportConfig getReportConfig() {
        return this.reportConfig;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSceneType() {
        return this.sceneType;
    }

    public String getSubChannel() {
        String str = this.subChannel;
        return str == null ? "" : str.trim();
    }

    public String getTs() {
        return this.ts;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isUseDialogTip() {
        return this.useDialogTip;
    }

    public boolean isWifiRequired() {
        return this.wifiRequired;
    }

    public void pause() {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(getContext())) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "pauseDownloadInstall: isInstalled is false");
            return;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "pauseDownloadInstall: task is " + this);
        mVarC.a(getContext());
        mVarC.a(getContext(), new m.b(new h(mVarC), this, 600000L, "pauseDownloadInstall"));
    }

    public void start() {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(getContext())) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "startDownloadInstall: isInstalled is false");
            return;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "startDownloadInstall: task is " + this);
        mVarC.a(getContext());
        mVarC.a(getContext(), new m.b(new g(mVarC), this, 600000L, "startDownloadInstall"));
    }

    public String toString() {
        return "DownloadInstallTaskV2{channel=" + this.channel + ",subChannel=" + this.subChannel + ",adAppReport=" + this.adAppReport + ", pkgName='" + this.pkgName + "', wifiRequired=" + this.wifiRequired + ", launcherInstallType=" + this.launcherInstallType + ", extraData='" + this.extraData + "', useDialogTip=" + this.useDialogTip + ", detailType=" + this.detailType + ", downloadType=" + this.downloadType + ", partner=" + this.partner + ", authSign=" + this.authSign + ", referrer=" + this.referrer + ", ts=" + this.ts + ", version=" + this.version + ", callerApkVer=" + this.callerApkVer + ", sceneType=" + this.sceneType + ", clickTime=" + this.clickTime + '}';
    }
}
