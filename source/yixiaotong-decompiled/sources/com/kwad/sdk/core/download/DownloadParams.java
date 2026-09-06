package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownloadParams extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -4966891183505507851L;
    public boolean downloadEnablePause = false;
    public int downloadPlace = 1;
    public String filePath;
    public String mAppIcon;
    public String mAppName;
    public long mAppSize;
    public String mDownloadid;
    public String mFileMd5;
    public String mFileUrl;
    public String mPkgname;
    public String mShortDesc;
    public int mTaskId;
    public String mVersion;
    public String mVersionCode;
    public boolean requestInstallPermission;

    public static DownloadParams transform(AdInfo adInfo) {
        DownloadParams downloadParams = new DownloadParams();
        downloadParams.mDownloadid = adInfo.downloadId;
        downloadParams.mAppName = adInfo.adBaseInfo.appName;
        downloadParams.mPkgname = adInfo.adBaseInfo.appPackageName;
        downloadParams.mFileUrl = adInfo.adConversionInfo.appDownloadUrl;
        downloadParams.mAppIcon = adInfo.adBaseInfo.appIconUrl;
        downloadParams.mShortDesc = adInfo.adBaseInfo.adDescription;
        downloadParams.downloadEnablePause = adInfo.downloadSafeInfo.downloadPauseEnable;
        return downloadParams;
    }
}
