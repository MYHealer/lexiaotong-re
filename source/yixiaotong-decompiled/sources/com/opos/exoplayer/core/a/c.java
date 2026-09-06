package com.opos.exoplayer.core.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6238a = new c(new int[]{2}, 2);
    private final int[] b;
    private final int c;

    c(int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.b = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.b = new int[0];
        }
        this.c = i;
    }

    public static c a(Context context) {
        return a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static c a(Intent intent) {
        return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f6238a : new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    public boolean a(int i) {
        return Arrays.binarySearch(this.b, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.b, cVar.b) && this.c == cVar.c;
    }

    public int hashCode() {
        return this.c + (Arrays.hashCode(this.b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.c + ", supportedEncodings=" + Arrays.toString(this.b) + "]";
    }
}
