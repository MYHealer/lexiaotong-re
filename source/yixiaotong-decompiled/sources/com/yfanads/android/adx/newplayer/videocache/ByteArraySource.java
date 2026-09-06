package com.yfanads.android.adx.newplayer.videocache;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ByteArraySource implements Source {
    private ByteArrayInputStream arrayInputStream;
    private final byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Source
    public void close() {
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Source
    public long length() {
        return this.data.length;
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Source
    public void open(long j) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
        this.arrayInputStream = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Source
    public int read(byte[] bArr) {
        return this.arrayInputStream.read(bArr, 0, bArr.length);
    }
}
