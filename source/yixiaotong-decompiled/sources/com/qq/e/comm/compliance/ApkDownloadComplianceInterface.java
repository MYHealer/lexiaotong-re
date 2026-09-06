package com.qq.e.comm.compliance;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface ApkDownloadComplianceInterface {
    public static final int INSTALL_BITS = 256;
    public static final int SCENES_AD_OR_NATIVE_LANDING_PAGE = 1;
    public static final int SCENES_WEB_LANDING_PAGE = 2;

    String getApkInfoUrl();

    void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener);
}
