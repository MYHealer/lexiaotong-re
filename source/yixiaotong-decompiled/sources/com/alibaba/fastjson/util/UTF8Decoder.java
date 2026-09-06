package com.alibaba.fastjson.util;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    private static final boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    private static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static final boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i2);
            }
        }
        return CoderResult.malformedForLength(i);
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i) {
        int i2 = 1;
        if (i == 1) {
            byte b = byteBuffer.get();
            if ((b >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            }
            if ((b >> 1) == -2) {
                if (byteBuffer.remaining() < 5) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 6);
            }
            return CoderResult.malformedForLength(1);
        }
        if (i == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i == 3) {
            byte b2 = byteBuffer.get();
            byte b3 = byteBuffer.get();
            if ((b2 != -32 || (b3 & 224) != 128) && !isNotContinuation(b3)) {
                i2 = 2;
            }
            return CoderResult.malformedForLength(i2);
        }
        if (i == 4) {
            int i3 = byteBuffer.get() & 255;
            byte b4 = byteBuffer.get();
            int i4 = b4 & 255;
            if (i3 > 244 || ((i3 == 240 && (i4 < 144 || i4 > 191)) || ((i3 == 244 && (b4 & 240) != 128) || isNotContinuation(i4)))) {
                return CoderResult.malformedForLength(1);
            }
            return isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
        }
        throw new IllegalStateException();
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        CoderResult coderResultMalformedN = malformedN(byteBuffer, i3);
        updatePositions(byteBuffer, i, charBuffer, i2);
        return coderResultMalformedN;
    }

    private static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        updatePositions(buffer, i, buffer2, i3);
        return (i4 == 0 || i2 - i < i4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iArrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] cArrArray = charBuffer.array();
        int iArrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int iArrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int iMin = Math.min(iArrayOffset2 - iArrayOffset, iArrayOffset4 - iArrayOffset3) + iArrayOffset3;
        while (iArrayOffset3 < iMin) {
            byte b = bArrArray[iArrayOffset];
            if (b < 0) {
                break;
            }
            iArrayOffset++;
            cArrArray[iArrayOffset3] = (char) b;
            iArrayOffset3++;
        }
        int i2 = iArrayOffset;
        while (true) {
            int i3 = iArrayOffset3;
            while (i2 < iArrayOffset2) {
                byte b2 = bArrArray[i2];
                if (b2 < 0) {
                    if ((b2 >> 5) == -2) {
                        if (iArrayOffset2 - i2 < 2 || i3 >= iArrayOffset4) {
                            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 2);
                        }
                        byte b3 = bArrArray[i2 + 1];
                        if (isMalformed2(b2, b3)) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 2);
                        }
                        i = i3 + 1;
                        cArrArray[i3] = (char) (((b2 << 6) ^ b3) ^ Utf8.MASK_2BYTES);
                        i2 += 2;
                    } else if ((b2 >> 4) == -2) {
                        if (iArrayOffset2 - i2 < 3 || i3 >= iArrayOffset4) {
                            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 3);
                        }
                        byte b4 = bArrArray[i2 + 1];
                        byte b5 = bArrArray[i2 + 2];
                        if (isMalformed3(b2, b4, b5)) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 3);
                        }
                        i = i3 + 1;
                        cArrArray[i3] = (char) ((((b2 << 12) ^ (b4 << 6)) ^ b5) ^ 8064);
                        i2 += 3;
                    } else {
                        if ((b2 >> 3) != -2) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 1);
                        }
                        if (iArrayOffset2 - i2 < 4 || iArrayOffset4 - i3 < 2) {
                            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 4);
                        }
                        byte b6 = bArrArray[i2 + 1];
                        byte b7 = bArrArray[i2 + 2];
                        byte b8 = bArrArray[i2 + 3];
                        int i4 = ((b2 & 7) << 18) | ((b6 & Utf8.REPLACEMENT_BYTE) << 12) | ((b7 & Utf8.REPLACEMENT_BYTE) << 6) | (b8 & Utf8.REPLACEMENT_BYTE);
                        if (isMalformed4(b6, b7, b8) || !Surrogate.neededFor(i4)) {
                            return malformed(byteBuffer, i2, charBuffer, i3, 4);
                        }
                        int i5 = i3 + 1;
                        cArrArray[i3] = Surrogate.high(i4);
                        i3 += 2;
                        cArrArray[i5] = Surrogate.low(i4);
                        i2 += 4;
                    }
                    i3 = i;
                } else {
                    if (i3 >= iArrayOffset4) {
                        return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 1);
                    }
                    iArrayOffset3 = i3 + 1;
                    cArrArray[i3] = (char) b2;
                    i2++;
                }
            }
            return xflow(byteBuffer, i2, iArrayOffset2, charBuffer, i3, 0);
        }
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }

    static final void updatePositions(Buffer buffer, int i, Buffer buffer2, int i2) {
        buffer.position(i);
        buffer2.position(i2);
    }

    private static class Surrogate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int UCS4_MAX = 1114111;
        public static final int UCS4_MIN = 65536;

        public static char high(int i) {
            return (char) ((((i - 65536) >> 10) & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | 55296);
        }

        public static char low(int i) {
            return (char) (((i - 65536) & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | Utf8.LOG_SURROGATE_HEADER);
        }

        public static boolean neededFor(int i) {
            return i >= 65536 && i <= 1114111;
        }

        private Surrogate() {
        }
    }
}
