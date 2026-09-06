package com.miui.zeus.mimo.sdk.common;

import cz.msebera.android.httpclient.HttpStatus;
import ijiami_1011.NCall;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class XiaomiVideoPlayerCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f5398a = null;
    public static volatile XiaomiVideoPlayerCache b;

    static {
        NCall.IV(new Object[]{Integer.valueOf(HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE)});
    }

    private XiaomiVideoPlayerCache() {
    }

    public static XiaomiVideoPlayerCache a() {
        return (XiaomiVideoPlayerCache) NCall.IL(new Object[]{420});
    }

    public final boolean a(File file) {
        return NCall.IZ(new Object[]{421, this, file});
    }

    public final boolean b(File file) {
        return NCall.IZ(new Object[]{422, this, file});
    }
}
