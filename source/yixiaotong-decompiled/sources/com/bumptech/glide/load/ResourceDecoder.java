package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t, int i, int i2, Options options) throws IOException;

    boolean handles(T t, Options options) throws IOException;
}
