package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ThreadLocalCache;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SerialWriterStringEncoder {
    private final CharsetEncoder encoder;

    private static int scale(int i, float f) {
        return (int) (((double) i) * ((double) f));
    }

    public CharsetEncoder getEncoder() {
        return this.encoder;
    }

    public SerialWriterStringEncoder(Charset charset) {
        this(charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    public SerialWriterStringEncoder(CharsetEncoder charsetEncoder) {
        this.encoder = charsetEncoder;
    }

    public byte[] encode(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        this.encoder.reset();
        return encode(cArr, i, i2, ThreadLocalCache.getBytes(scale(i2, this.encoder.maxBytesPerChar())));
    }

    public byte[] encode(char[] cArr, int i, int i2, byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        try {
            CoderResult coderResultEncode = this.encoder.encode(CharBuffer.wrap(cArr, i, i2), byteBufferWrap, true);
            if (!coderResultEncode.isUnderflow()) {
                coderResultEncode.throwException();
            }
            CoderResult coderResultFlush = this.encoder.flush(byteBufferWrap);
            if (!coderResultFlush.isUnderflow()) {
                coderResultFlush.throwException();
            }
            int iPosition = byteBufferWrap.position();
            byte[] bArr2 = new byte[iPosition];
            System.arraycopy(bArr, 0, bArr2, 0, iPosition);
            return bArr2;
        } catch (CharacterCodingException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }
}
