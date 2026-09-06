package com.kwad.sdk.api.proxy;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@KsAdSdkDynamicApi
public abstract class IFragmentActivityProxy extends IActivityProxy {
    private BaseProxyFragmentActivity mProxyFragmentActivity;

    @KsAdSdkDynamicApi
    public BaseProxyFragmentActivity getProxyFragmentActivity() {
        return this.mProxyFragmentActivity;
    }

    public void onAttachFragment(KsFragment ksFragment) {
    }

    void setProxyFragmentActivity(BaseProxyFragmentActivity baseProxyFragmentActivity) {
        this.mProxyFragmentActivity = baseProxyFragmentActivity;
    }

    @KsAdSdkDynamicApi
    public final KsFragmentManager getSupportFragmentManager() {
        return this.mProxyFragmentActivity.getSupportFragmentManager2();
    }

    @KsAdSdkDynamicApi
    public void startActivity(Intent intent) {
        this.mProxyFragmentActivity.startActivity(intent);
    }

    @KsAdSdkDynamicApi
    public void startActivityForResult(Intent intent, int i) {
        this.mProxyFragmentActivity.startActivityForResult(intent, i);
    }

    @KsAdSdkDynamicApi
    public Resources.Theme getTheme() {
        return this.mProxyFragmentActivity.getTheme();
    }

    @KsAdSdkDynamicApi
    public void setResult(int i, Intent intent) {
        this.mProxyFragmentActivity.setResult(i, intent);
    }

    @KsAdSdkDynamicApi
    public boolean isFinishing() {
        return this.mProxyFragmentActivity.isFinishing();
    }

    @KsAdSdkDynamicApi
    public void runOnUiThread(Runnable runnable) {
        this.mProxyFragmentActivity.runOnUiThread(runnable);
    }

    @KsAdSdkDynamicApi
    public TypedArray obtainStyledAttributes(int[] iArr) {
        return this.mProxyFragmentActivity.obtainStyledAttributes(iArr);
    }

    @KsAdSdkDynamicApi
    public ApplicationInfo getApplicationInfo() {
        return this.mProxyFragmentActivity.getApplicationInfo();
    }

    @KsAdSdkDynamicApi
    public int getRequestedOrientation() {
        return this.mProxyFragmentActivity.getRequestedOrientation();
    }

    @KsAdSdkDynamicApi
    public Resources getResources() {
        return this.mProxyFragmentActivity.getResources();
    }
}
