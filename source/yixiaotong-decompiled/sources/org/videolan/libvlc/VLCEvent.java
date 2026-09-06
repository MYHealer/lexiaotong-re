package org.videolan.libvlc;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class VLCEvent {
    public final long arg1;
    public final long arg2;
    public final long arg3;
    public final long arg4;
    public final float argf1;
    public final String argstr;
    public final int type;

    public interface Listener<T extends VLCEvent> {
        void onEvent(T t);
    }

    public VLCEvent(int i) {
        this.type = i;
        this.arg1 = 0L;
        this.arg2 = 0L;
        this.arg3 = 0L;
        this.arg4 = 0L;
        this.argf1 = 0.0f;
        this.argstr = null;
    }

    public VLCEvent(int i, float f) {
        this.type = i;
        this.arg1 = 0L;
        this.arg2 = 0L;
        this.arg3 = 0L;
        this.arg4 = 0L;
        this.argf1 = f;
        this.argstr = null;
    }

    public VLCEvent(int i, long j) {
        this.type = i;
        this.arg1 = j;
        this.arg2 = 0L;
        this.arg3 = 0L;
        this.arg4 = 0L;
        this.argf1 = 0.0f;
        this.argstr = null;
    }

    public VLCEvent(int i, long j, long j2) {
        this.type = i;
        this.arg1 = j;
        this.arg2 = j2;
        this.arg3 = 0L;
        this.arg4 = 0L;
        this.argf1 = 0.0f;
        this.argstr = null;
    }

    public VLCEvent(int i, long j, long j2, long j3, long j4) {
        this.type = i;
        this.arg1 = j;
        this.arg2 = j2;
        this.arg3 = j3;
        this.arg4 = j4;
        this.argf1 = 0.0f;
        this.argstr = null;
    }

    public VLCEvent(int i, long j, long j2, String str) {
        this.type = i;
        this.arg1 = j;
        this.arg2 = j2;
        this.arg3 = 0L;
        this.arg4 = 0L;
        this.argf1 = 0.0f;
        this.argstr = str;
    }

    public void release() {
    }
}
