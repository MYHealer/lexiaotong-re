package com.kwad.components.core.offline.b.a;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class e implements IEnvironment {
    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getKpf() {
        return "ANDROID_PHONE";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getKpn() {
        return "UNIVERSE.AD.LIVE";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDebug() {
        return false;
    }

    e() {
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final Context getContext() {
        return ServiceProvider.getContext();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppId() {
        return ServiceProvider.getAppId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getApiVersion() {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getOsVersion() {
        return bt.getOsVersion();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getProcessName(Context context) {
        return SystemUtil.getProcessName(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isInMainProcess(Context context) {
        return SystemUtil.isInMainProcess(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getDeviceId() {
        return bt.getDeviceId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getUserAgent() {
        return com.kwad.sdk.core.network.p.getUserAgent();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDevelopEnable() {
        return com.kwad.components.core.a.pe.booleanValue();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String localIpAddress() {
        if (!com.kwad.components.core.a.pe.booleanValue()) {
            return "10.88.32.40";
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return "10.88.32.40";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isArm64(Context context) {
        return AbiUtil.isArm64(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getOperator(Context context) {
        return String.valueOf(aq.dB(context));
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final double getLatitude(Context context) {
        com.kwad.sdk.utils.d.a aVarDg = bf.dg(context);
        if (aVarDg == null || aVarDg.bsT == null) {
            return 0.0d;
        }
        return aVarDg.bsT.getLatitude();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final double getLongitude(Context context) {
        com.kwad.sdk.utils.d.a aVarDg = bf.dg(context);
        if (aVarDg == null || aVarDg.bsT == null) {
            return 0.0d;
        }
        return aVarDg.bsT.getLongitude();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getBiz() {
        return com.kwad.sdk.j.aGb;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final int getStatusBarHeight(Context context) {
        return com.kwad.sdk.c.a.a.getStatusBarHeight(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean requestAudioFocus(Context context, boolean z) {
        return com.kwad.components.core.t.a.aO(context).bd(z);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final void addOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        if (context == null || offlineOnAudioConflictListener == null) {
            return;
        }
        com.kwad.components.core.t.a.aO(context).a(offlineOnAudioConflictListener);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final void removeOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        if (context == null || offlineOnAudioConflictListener == null) {
            return;
        }
        com.kwad.components.core.t.a.aO(context).b(offlineOnAudioConflictListener);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isTKCrashCollectEnable() {
        return com.kwad.sdk.core.config.c.aPR.getValue().booleanValue();
    }
}
