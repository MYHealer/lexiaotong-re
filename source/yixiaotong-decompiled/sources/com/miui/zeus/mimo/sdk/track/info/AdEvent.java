package com.miui.zeus.mimo.sdk.track.info;

import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public enum AdEvent {
    VIEW(s.d(new byte[]{Ascii.NAK, 12, 80, 78}, "ce5930")),
    CLICK(s.d(new byte[]{85, 14, 93, 83, 90}, "6b401a")),
    CLOSE,
    SKIP,
    POPUP_WINDOW_VIEW,
    POPUP_WINDOW_QUIT,
    POPUP_WINDOW_CONTINUE,
    END_PAGE_VIEW,
    WIN,
    LOSS,
    TYPE_DOWNLOAD_SOURCE_MIMO_SDK_NATIVE,
    MIMO_SDK_DOWNLOAD_CANCEL,
    MIMO_SDK_DOWNLOAD_PAUSE,
    MIMO_SDK_DOWNLOAD_CONTINUE,
    VIDEO_START,
    VIDEO_Q1,
    VIDEO_Q2,
    VIDEO_Q3,
    VIDEO_PAUSE,
    VIDEO_RESUME,
    VIDEO_FINISH,
    PIC_START,
    PIC_FINISH,
    APP_LAUNCH_START_PACKAGENAME,
    APP_LAUNCH_SUCCESS_PACKAGENAME,
    APP_LAUNCH_FAIL_PACKAGENAME,
    APP_LAUNCH_START_DEEPLINK,
    APP_LAUNCH_SUCCESS_DEEPLINK,
    APP_LAUNCH_FAIL_DEEPLINK,
    APP_H5_LAUNCH_START,
    APP_H5_LAUNCH_SUCCESS,
    APP_H5_LAUNCH_FAIL,
    REWARD_SUCCESS,
    CONFIRM_POPUP_WINDOW_VIEW,
    CONFIRM_POPUP_WINDOW_QUIT,
    CUSTOM_POPUP_WINDOW_VIEW,
    CUSTOM_POPUP_WINDOW_CANCEL;

    private String customName;

    AdEvent(String str) {
        this.customName = str;
    }

    public String getName() {
        String str = this.customName;
        return str != null ? str : name();
    }
}
