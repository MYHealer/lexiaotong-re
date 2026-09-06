package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.common.XiaomiVideoPlayerCache;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f5459a;
    public final /* synthetic */ XiaomiVideoPlayerCache b;

    public i4(XiaomiVideoPlayerCache xiaomiVideoPlayerCache, File file) {
        this.b = xiaomiVideoPlayerCache;
        this.f5459a = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.b(this.f5459a)) {
            m.d(ijiami_1011.s.s.s.d(new byte[]{107, 93, 5, 93, 84, 13, 55, 13, 2, 7, 94, 53, 95, 85, Ascii.GS, 87, 75, 39, 0, 7, 14, 7}, "34d29d"), ijiami_1011.s.s.s.d(new byte[]{98, 92, 2, 80, Ascii.ESC, 19, 0, 8, 10, 66, 66, 10, 16, 95, 10, 88, 7, 19, Ascii.DC2, 17, 5, 1, 84, Ascii.SYN, 67}, "09c4b3"));
        } else {
            m.a(ijiami_1011.s.s.s.d(new byte[]{59, 90, 81, 87, 88, 15, 55, 13, 2, 7, 94, 53, 15, 82, 73, 93, 71, 37, 0, 7, 14, 7}, "c3085f"), ijiami_1011.s.s.s.d(new byte[]{48, 3, 81, 6, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, Ascii.DC2, 11, 70, 4, 88, 9, 7, 70, 86, 3, 80, 90}, "bf0b96"));
        }
    }
}
