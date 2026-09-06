package com.alipay.sdk.app;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class EnvUtils {
    private static EnvEnum mEnv = EnvEnum.ONLINE;

    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    public static EnvEnum geEnv() {
        return mEnv;
    }

    public static void setEnv(EnvEnum envEnum) {
        mEnv = envEnum;
    }

    public static boolean isSandBox() {
        return mEnv == EnvEnum.SANDBOX;
    }
}
