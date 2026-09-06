package com.kwad.sdk.api.core;

import com.kwad.sdk.api.loader.Loader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SpeedLimitApiHolder {
    private static volatile SpeedLimitApi instance;

    public static SpeedLimitApi getInstance() {
        if (instance == null) {
            synchronized (SpeedLimitApiHolder.class) {
                if (instance == null) {
                    instance = (SpeedLimitApi) Loader.get().newInstance(SpeedLimitApi.class);
                }
            }
        }
        return instance;
    }
}
