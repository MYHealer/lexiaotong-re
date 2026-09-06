package com.opos.exoplayer.core.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class ab implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f6499a;

    public ab(Handler handler) {
        this.f6499a = handler;
    }

    @Override // com.opos.exoplayer.core.i.j
    public Looper a() {
        return this.f6499a.getLooper();
    }

    @Override // com.opos.exoplayer.core.i.j
    public Message a(int i, int i2, int i3) {
        return this.f6499a.obtainMessage(i, i2, i3);
    }

    @Override // com.opos.exoplayer.core.i.j
    public Message a(int i, int i2, int i3, Object obj) {
        return this.f6499a.obtainMessage(i, i2, i3, obj);
    }

    @Override // com.opos.exoplayer.core.i.j
    public Message a(int i, Object obj) {
        return this.f6499a.obtainMessage(i, obj);
    }

    @Override // com.opos.exoplayer.core.i.j
    public boolean a(int i) {
        return this.f6499a.sendEmptyMessage(i);
    }

    @Override // com.opos.exoplayer.core.i.j
    public boolean a(int i, long j) {
        return this.f6499a.sendEmptyMessageAtTime(i, j);
    }

    @Override // com.opos.exoplayer.core.i.j
    public void b(int i) {
        this.f6499a.removeMessages(i);
    }
}
