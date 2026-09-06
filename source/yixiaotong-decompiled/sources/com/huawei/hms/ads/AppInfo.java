package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AppInfo implements b {
    private static final String TAG = "AppInfo";
    private String appDesc;
    private String appDetailsUrl;
    private String appIconUrl;
    private String appName;
    private boolean checkSha256;
    private String developerName;
    private String downloadText;
    private String downloadUrl;
    private long fileSize;
    private String intentUri;
    private String openText;
    private boolean permPromptForCard;
    private boolean permPromptForLanding;
    private List<AppPermision> permisions;
    private String permissionUrl;
    private String pkgName;
    private String privacyUrl;
    private String realPkgName;
    private String safeDownloadUrl;
    private String sha256;
    private String uniqueId;
    private String versionName;

    public AppInfo(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        if (appInfo != null) {
            this.pkgName = appInfo.Code();
            this.realPkgName = appInfo.R();
            this.appName = appInfo.L();
            this.appIconUrl = appInfo.I();
            this.downloadUrl = appInfo.Z();
            this.appDetailsUrl = appInfo.u();
            this.permissionUrl = appInfo.t();
            this.privacyUrl = appInfo.r();
            this.developerName = com.huawei.openalliance.ad.utils.bc.V(appInfo.f());
            this.versionName = appInfo.g();
            this.safeDownloadUrl = appInfo.F();
            this.fileSize = appInfo.B();
            this.sha256 = appInfo.C();
            this.checkSha256 = appInfo.S();
            this.intentUri = appInfo.D();
            this.permPromptForCard = appInfo.c();
            this.permPromptForLanding = appInfo.d();
            this.uniqueId = appInfo.e();
            this.appDesc = appInfo.a();
            this.downloadText = appInfo.l();
            this.openText = appInfo.m();
            if (com.huawei.openalliance.ad.utils.ag.Code(appInfo.b())) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<PermissionEntity> it = appInfo.b().iterator();
            while (it.hasNext()) {
                arrayList.add(new AppPermision(it.next()));
            }
            this.permisions = arrayList;
        }
    }

    public String Code() {
        return this.privacyUrl;
    }

    public void Code(String str) {
        this.privacyUrl = str;
    }

    public String getAppDesc() {
        return this.appDesc;
    }

    @Override // com.huawei.hms.ads.b
    public String getAppDetailUrl() {
        return this.appDetailsUrl;
    }

    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    public String getAppName() {
        return this.appName;
    }

    public List<AppPermision> getAppPermissions() {
        return this.permisions;
    }

    public String getCta(boolean z) {
        return z ? this.openText : this.downloadText;
    }

    public String getDeveloperName() {
        String str = this.developerName;
        return str == null ? "" : str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getIntentUri() {
        return this.intentUri;
    }

    @Override // com.huawei.hms.ads.b
    public String getPermissionUrl() {
        return this.permissionUrl;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    @Override // com.huawei.hms.ads.b
    public String getPrivacyLink() {
        return this.privacyUrl;
    }

    public String getRealPkgName() {
        return this.realPkgName;
    }

    public String getSafeDownloadUrl() {
        return this.safeDownloadUrl;
    }

    public String getSha256() {
        return this.sha256;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public String getVersionName() {
        String str = this.versionName;
        return str == null ? "" : str;
    }

    public boolean isCheckSha256() {
        return this.checkSha256;
    }

    public boolean isPermPromptForCard() {
        return this.permPromptForCard;
    }

    public boolean isPermPromptForLanding() {
        return this.permPromptForLanding;
    }

    @Override // com.huawei.hms.ads.b
    public void showPermissionPage(final Context context) {
        if (TextUtils.isEmpty(this.permissionUrl)) {
            fh.V(TAG, "load privacy link is empty.");
        } else {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.AppInfo.2
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.utils.z.Code(context, AppInfo.this.permissionUrl);
                }
            });
        }
    }

    @Override // com.huawei.hms.ads.b
    public void showPrivacyPolicy(final Context context) {
        if (TextUtils.isEmpty(this.privacyUrl)) {
            fh.V(TAG, "load privacy link is empty.");
        } else {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.AppInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.utils.z.Code(context, AppInfo.this.privacyUrl);
                }
            });
        }
    }
}
