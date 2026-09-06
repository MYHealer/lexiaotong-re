package com.kwad.components.core.offline.b.a;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class u implements IVibratorUtil {
    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void vibrate(Context context, Vibrator vibrator, long j) {
        by.vibrate(context, vibrator, j);
    }

    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void cancelVibrate(Context context, Vibrator vibrator) {
        by.b(context, vibrator);
    }
}
