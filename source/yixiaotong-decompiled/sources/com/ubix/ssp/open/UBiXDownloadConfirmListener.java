package com.ubix.ssp.open;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXDownloadConfirmListener {
    public static final String DOWNLOAD_APP_ICP_NUMBER_KEY = "APP_ICP_NUMBER";
    public static final String DOWNLOAD_APP_INTRODUCE_URL_KEY = "APP_INTRODUCE_URL";
    public static final String DOWNLOAD_APP_NAME_KEY = "APP_NAME";
    public static final String DOWNLOAD_APP_PERMISSION_URL_KEY = "APP_PERMISSION_URL";
    public static final String DOWNLOAD_APP_PRIVACY_URL_KEY = "APP_PRIVACY_URL";
    public static final String DOWNLOAD_APP_PUBLISHER_KEY = "APP_PUBLISHER";
    public static final String DOWNLOAD_APP_SIZE_KEY = "APP_SIZE";
    public static final String DOWNLOAD_APP_SUITABLE_AGE_KEY = "APP_SUITABLE_AGE";
    public static final String DOWNLOAD_APP_VERSION_KEY = "APP_VERSION";

    void onDownloadConfirm(Context context, Bundle bundle, UBiXDownloadConfirmCallback uBiXDownloadConfirmCallback);
}
