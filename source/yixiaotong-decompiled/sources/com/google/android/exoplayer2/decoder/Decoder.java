package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.DecoderException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface Decoder<I, O, E extends DecoderException> {
    I dequeueInputBuffer() throws DecoderException;

    O dequeueOutputBuffer() throws DecoderException;

    void flush();

    String getName();

    void queueInputBuffer(I i) throws DecoderException;

    void release();
}
