package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.os.Vibrator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IVibratorUtil {
    void cancelVibrate(Context context, Vibrator vibrator);

    void vibrate(Context context, Vibrator vibrator, long j);
}
