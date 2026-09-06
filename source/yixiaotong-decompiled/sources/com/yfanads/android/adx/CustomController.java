package com.yfanads.android.adx;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class CustomController {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9563a;
        public long b;
    }

    public abstract boolean canBootMark();

    public abstract boolean canCloseAppReceiver();

    public abstract boolean canUseAndroidId();

    public abstract boolean canUseAppList();

    public abstract boolean canUseLocation();

    public abstract boolean canUseMacAddress();

    public abstract boolean canUseOaid();

    public abstract boolean canUsePhoneState();

    public abstract boolean canUseStoragePermission();

    public abstract boolean canUseWriteExternal();

    public String devAndroidId() {
        return "";
    }

    public List<String> devAppList() {
        return null;
    }

    public abstract String devImei();

    public String devMacAddress() {
        return "";
    }

    public abstract String devOaid();

    public abstract boolean limitPersonal();

    public abstract a location();
}
