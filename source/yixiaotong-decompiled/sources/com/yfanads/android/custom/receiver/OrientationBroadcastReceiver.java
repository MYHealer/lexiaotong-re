package com.yfanads.android.custom.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class OrientationBroadcastReceiver extends BroadcastReceiver {
    private final OrientationCallback callback;
    private int oldOrientation;

    public interface OrientationCallback {
        void onOrientationChanged(boolean z);
    }

    public OrientationBroadcastReceiver(OrientationCallback orientationCallback) {
        this.callback = orientationCallback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
            return;
        }
        Configuration configuration = context.getResources().getConfiguration();
        YFLog.high("onReceive old:" + this.oldOrientation + "|new:" + configuration.orientation);
        int i = configuration.orientation;
        if (i != this.oldOrientation) {
            this.oldOrientation = i;
            boolean z = i == 2;
            OrientationCallback orientationCallback = this.callback;
            if (orientationCallback != null) {
                orientationCallback.onOrientationChanged(z);
            }
        }
    }
}
