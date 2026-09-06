package com.yfanads.android.adx.core.impl;

import android.content.Context;
import com.stub.StubApp;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.api.IAdxSDK;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.annotate.AdSdkDynamicImpl;
import com.yfanads.android.adx.core.load.AdxIFManager;
import com.yfanads.android.adx.download.DownloaderMgr;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloader;
import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadUrlConnection;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkDynamicImpl(IAdxSDK.class)
public class AdxSDKImpl implements IAdxSDK {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private LoadManager mAdRequestManager;
    private volatile boolean mIsSdkInit;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AdxSDKImpl f9585a = new AdxSDKImpl(null);
    }

    public /* synthetic */ AdxSDKImpl(a aVar) {
        this();
    }

    @AdSdkDynamicImpl(IAdxSDK.class)
    public static AdxSDKImpl get() {
        return b.f9585a;
    }

    private void initDownload(Context context) {
        ConcurrentHashMap concurrentHashMap = DownloaderMgr.b;
        FileDownloadLog.NEED_LOG = true;
        FileDownloader.setupOnApplicationOnCreate(StubApp.getOrigApplicationContext(context.getApplicationContext())).connectionCreator(new FileDownloadUrlConnection.Creator(new FileDownloadUrlConnection.Configuration().connectTimeout(15000).readTimeout(15000))).commit();
    }

    private void initLottie(Context context) {
    }

    private void initSDKModule(Context context, AdxSdkConfig adxSdkConfig) {
        initServiceProvider(context, adxSdkConfig);
        initLottie(context);
        initDownload(context);
        this.mIsSdkInit = true;
    }

    private void initServiceProvider(Context context, AdxSdkConfig adxSdkConfig) {
        com.yfanads.android.adx.service.d.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.yfanads.android.adx.service.d.c = adxSdkConfig;
        com.yfanads.android.adx.service.d.d = new g(adxSdkConfig);
    }

    public boolean hasInitFinish() {
        return this.mIsSdkInit;
    }

    @Override // com.yfanads.android.adx.api.IAdxSDK
    public <T> T newInstance(Class<T> cls) {
        try {
            return (T) AdxIFManager.getClass(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private AdxSDKImpl() {
        this.mIsSdkInit = false;
    }

    @Override // com.yfanads.android.adx.api.IAdxSDK
    public LoadManager getAdManager() {
        if (this.mAdRequestManager == null) {
            this.mAdRequestManager = new e();
        }
        return this.mAdRequestManager;
    }

    @Override // com.yfanads.android.adx.api.IAdxSDK
    public void init(Context context, AdxSdkConfig adxSdkConfig) {
        com.yfanads.android.adx.utils.a.f9621a = adxSdkConfig.enableDebug;
        initSDKModule(context, adxSdkConfig);
    }
}
