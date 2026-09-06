package com.jd.ad.sdk.mdt.service;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADTouchService {
    int onUserCancelJdJump(Context context, String str);

    int onViewClicked(Context context, View view, String str, OnUserCancelJdJumpCallback onUserCancelJdJumpCallback);

    void onViewTouch(View view, MotionEvent motionEvent, String str);

    void registerTouchView(String str);

    void unregisterTouchView(String str);
}
