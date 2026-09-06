package com.miui.zeus.comp.videoplayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PlayException extends Exception {
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_TIMEOUT = 5;
    public static final int TYPE_UNEXPECTED = 2;
    public final Throwable cause;
    public final int type;

    private PlayException(int i, Throwable th) {
        super(th);
        this.type = i;
        this.cause = th;
    }

    public static PlayException createForOutOfMemoryError(Throwable th) {
        return new PlayException(4, th);
    }

    public static PlayException createForRemote(Throwable th) {
        return new PlayException(3, th);
    }

    public static PlayException createForRenderer(Throwable th) {
        return new PlayException(1, th);
    }

    public static PlayException createForSource(Throwable th) {
        return new PlayException(0, th);
    }

    public static PlayException createForTimeout(Throwable th) {
        return new PlayException(5, th);
    }

    public static PlayException createForUnexpected(Throwable th) {
        return new PlayException(2, th);
    }
}
