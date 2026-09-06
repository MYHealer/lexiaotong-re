package com.yfanads.android.adx.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VideoStatus {
    public static final int COMPLETE = 3;
    public static final int DEFAULT = -1;
    public static final int PAUSE = 2;
    public static final int PLAYING = 1;
    public static final int READY = 0;
}
