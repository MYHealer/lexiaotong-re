package com.hihonor.adsdk.common.video.exo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ActionState {
    public static final int ACTION_GET_BUFFER = 9;
    public static final int ACTION_INIT = 0;
    public static final int ACTION_PAUSE = 2;
    public static final int ACTION_PLAY = 1;
    public static final int ACTION_PLAY_CHANGED = 7;
    public static final int ACTION_RELEASE = 4;
    public static final int ACTION_REPLAY = 5;
    public static final int ACTION_RESUME = 3;
    public static final int ACTION_SET_MUTE = 6;
    public static final int ACTION_SET_SURFACE = 8;
}
