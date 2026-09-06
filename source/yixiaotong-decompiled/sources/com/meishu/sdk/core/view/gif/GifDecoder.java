package com.meishu.sdk.core.view.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.meishu.sdk.activity.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
class GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    public static final int LOOP_FOREVER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    private static final int WORK_BUFFER_SIZE = 16384;
    private int[] act;
    private BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private boolean isFirstFrameTransparent;
    private int loopIndex;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private byte[] workBuffer;
    private int workBufferPosition;
    private int workBufferSize;

    public interface BitmapProvider {
        Bitmap obtain(int i, int i2, Bitmap.Config config);

        byte[] obtainByteArray(int i);

        int[] obtainIntArray(int i);

        void release(Bitmap bitmap);

        void release(byte[] bArr);

        void release(int[] iArr);
    }

    public GifDecoder(BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.sampleSize + i; i9++) {
            byte[] bArr = this.mainPixels;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.act[bArr[i9] & 255];
            if (i10 != 0) {
                i7 += (i10 >> 24) & 255;
                i6 += (i10 >> 16) & 255;
                i5 += (i10 >> 8) & 255;
                i4 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.sampleSize + i11; i12++) {
            byte[] bArr2 = this.mainPixels;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.act[bArr2[i12] & 255];
            if (i13 != 0) {
                i7 += (i13 >> 24) & 255;
                i6 += (i13 >> 16) & 255;
                i5 += (i13 >> 8) & 255;
                i4 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i7 / i8) << 24) | ((i6 / i8) << 16) | ((i5 / i8) << 8) | (i4 / i8);
    }

    private void fillRect(int[] iArr, GifFrame gifFrame, int i) {
        int i2 = gifFrame.ih;
        int i3 = this.sampleSize;
        int i4 = i2 / i3;
        int i5 = gifFrame.iy / i3;
        int i6 = gifFrame.iw / i3;
        int i7 = gifFrame.ix / i3;
        int i8 = this.downsampledWidth;
        int i9 = (i5 * i8) + i7;
        int i10 = (i4 * i8) + i9;
        while (i9 < i10) {
            int i11 = i9 + i6;
            for (int i12 = i9; i12 < i11; i12++) {
                iArr[i12] = i;
            }
            i9 += this.downsampledWidth;
        }
    }

    private Bitmap getNextBitmap() {
        Bitmap bitmapObtain = null;
        try {
            bitmapObtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, Bitmap.Config.ARGB_8888);
            if (bitmapObtain != null) {
                setAlpha(bitmapObtain);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bitmapObtain;
    }

    private int readBlock() {
        int i = readByte();
        if (i > 0) {
            try {
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                int i2 = this.workBufferSize;
                int i3 = this.workBufferPosition;
                int i4 = i2 - i3;
                if (i4 >= i) {
                    System.arraycopy(this.workBuffer, i3, this.block, 0, i);
                    this.workBufferPosition += i;
                } else if (this.rawData.remaining() + i4 >= i) {
                    System.arraycopy(this.workBuffer, this.workBufferPosition, this.block, 0, i4);
                    this.workBufferPosition = this.workBufferSize;
                    readChunkIfNeeded();
                    int i5 = i - i4;
                    System.arraycopy(this.workBuffer, 0, this.block, i4, i5);
                    this.workBufferPosition += i5;
                } else {
                    this.status = 1;
                }
            } catch (Exception e) {
                Log.w(TAG, "Error Reading Block", e);
                this.status = 1;
            }
        }
        return i;
    }

    private int readByte() {
        try {
            readChunkIfNeeded();
            byte[] bArr = this.workBuffer;
            int i = this.workBufferPosition;
            this.workBufferPosition = i + 1;
            return bArr[i] & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }

    public boolean advance() {
        if (this.header.frameCount <= 0) {
            return false;
        }
        if (this.framePointer == getFrameCount() - 1) {
            this.loopIndex++;
        }
        GifHeader gifHeader = this.header;
        int i = gifHeader.loopCount;
        if (i != -1 && this.loopIndex > i) {
            return false;
        }
        this.framePointer = (this.framePointer + 1) % gifHeader.frameCount;
        return true;
    }

    public int getByteSize() {
        return (this.mainScratch.length * 4) + this.rawData.limit() + this.mainPixels.length;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.header;
            if (i < gifHeader.frameCount) {
                return gifHeader.frames.get(i).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    public int getLoopCount() {
        return this.header.loopCount;
    }

    public int getLoopIndex() {
        return this.loopIndex;
    }

    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, a.a("unable to decode frame, frameCount=").append(this.header.frameCount).append(" framePointer=").append(this.framePointer).toString());
            }
            this.status = 1;
        }
        int i = this.status;
        if (i != 1 && i != 2) {
            this.status = 0;
            GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i2 = this.framePointer - 1;
            GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
            int[] iArr = gifFrame.lct;
            if (iArr == null) {
                iArr = this.header.gct;
            }
            this.act = iArr;
            if (iArr == null) {
                String str2 = TAG;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, a.a("No Valid Color Table for frame #").append(this.framePointer).toString());
                }
                this.status = 1;
                return null;
            }
            if (gifFrame.transparency) {
                System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                int[] iArr2 = this.pct;
                this.act = iArr2;
                iArr2[gifFrame.transIndex] = 0;
            }
            return setPixels(gifFrame, gifFrame2);
        }
        String str3 = TAG;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, a.a("Unable to decode frame, status=").append(this.status).toString());
        }
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 16384);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                byteArrayOutputStream.flush();
                read(2, byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void resetLoopIndex() {
        this.loopIndex = 0;
    }

    public synchronized void setData(GifHeader gifHeader, byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    public boolean setFrameIndex(int i) {
        if (i < -1 || i >= getFrameCount()) {
            return false;
        }
        this.framePointer = i;
        return true;
    }

    public GifDecoder(BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private static void setAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    public synchronized void setData(GifHeader gifHeader, ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 2);
    }

    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = false;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
        byte[] bArr3 = this.workBuffer;
        if (bArr3 != null) {
            this.bitmapProvider.release(bArr3);
        }
    }

    public synchronized void setData(GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        try {
            if (i > 0) {
                int iHighestOneBit = Integer.highestOneBit(i);
                this.status = 0;
                this.header = gifHeader;
                this.isFirstFrameTransparent = false;
                this.framePointer = -1;
                resetLoopIndex();
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.rawData = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                Iterator<GifFrame> it = gifHeader.frames.iterator();
                while (it.hasNext()) {
                    if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                }
                this.sampleSize = iHighestOneBit;
                int i2 = gifHeader.width;
                this.downsampledWidth = i2 / iHighestOneBit;
                int i3 = gifHeader.height;
                this.downsampledHeight = i3 / iHighestOneBit;
                this.mainPixels = this.bitmapProvider.obtainByteArray(i2 * i3);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.workBufferSize = 0;
        this.workBufferPosition = 0;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v18, types: [short] */
    /* JADX WARN: Type inference failed for: r4v20 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        short s;
        this.workBufferSize = 0;
        this.workBufferPosition = 0;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = this.header;
            i = gifHeader.width;
            i2 = gifHeader.height;
        } else {
            i = gifFrame.iw;
            i2 = gifFrame.ih;
        }
        int i4 = i * i2;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i4) {
            this.mainPixels = this.bitmapProvider.obtainByteArray(i4);
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int i5 = readByte();
        int i6 = 1;
        int i7 = 1 << i5;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = i5 + 1;
        int i11 = (1 << i10) - 1;
        for (int i12 = 0; i12 < i7; i12++) {
            this.prefix[i12] = 0;
            this.suffix[i12] = (byte) i12;
        }
        int i13 = -1;
        int i14 = i10;
        int i15 = 0;
        int block = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = i9;
        int i23 = i11;
        int i24 = -1;
        while (i15 < i4) {
            if (block == 0) {
                block = readBlock();
                if (block <= 0) {
                    this.status = 3;
                    break;
                }
                i16 = 0;
            }
            i18 += (this.block[i16] & 255) << i17;
            i17 += 8;
            i16 += i6;
            block += i13;
            i19 = i19;
            i24 = i24;
            i22 = i22;
            i14 = i14;
            while (true) {
                if (i17 < i14) {
                    i6 = 1;
                    i13 = -1;
                    break;
                }
                int i25 = i10;
                int i26 = i18 & i23;
                i18 >>= i14;
                i17 -= i14;
                if (i26 != i7) {
                    if (i26 > i22) {
                        i3 = i9;
                        this.status = 3;
                    } else {
                        i3 = i9;
                        if (i26 != i8) {
                            if (i24 == -1) {
                                this.pixelStack[i20] = this.suffix[i26];
                                i19 = i26;
                                i20++;
                                i9 = i3;
                                i24 = i19;
                                i10 = i25;
                            } else {
                                if (i26 >= i22) {
                                    this.pixelStack[i20] = (byte) i19;
                                    s = i24;
                                    i20++;
                                } else {
                                    s = i26;
                                }
                                while (s >= i7) {
                                    this.pixelStack[i20] = this.suffix[s];
                                    s = this.prefix[s];
                                    i20++;
                                    i26 = i26;
                                }
                                int i27 = i26;
                                byte[] bArr2 = this.suffix;
                                i19 = bArr2[s] & 255;
                                int i28 = i20 + 1;
                                int i29 = i7;
                                byte b = (byte) i19;
                                this.pixelStack[i20] = b;
                                if (i22 < 4096) {
                                    this.prefix[i22] = (short) i24;
                                    bArr2[i22] = b;
                                    i22++;
                                    if ((i22 & i23) == 0 && i22 < 4096) {
                                        i14++;
                                        i23 += i22;
                                    }
                                }
                                i20 = i28;
                                while (i20 > 0) {
                                    i20--;
                                    this.mainPixels[i21] = this.pixelStack[i20];
                                    i15++;
                                    i21++;
                                }
                                i10 = i25;
                                i9 = i3;
                                i24 = i27;
                                i7 = i29;
                            }
                        }
                    }
                    i10 = i25;
                    i9 = i3;
                    i6 = 1;
                    i13 = -1;
                    break;
                }
                i22 = i9;
                i23 = i11;
                i10 = i25;
                i14 = i10;
                i24 = -1;
            }
        }
        for (int i30 = i21; i30 < i4; i30++) {
            this.mainPixels[i30] = 0;
        }
    }

    private void readChunkIfNeeded() {
        if (this.workBufferSize > this.workBufferPosition) {
            return;
        }
        if (this.workBuffer == null) {
            this.workBuffer = this.bitmapProvider.obtainByteArray(16384);
        }
        this.workBufferPosition = 0;
        int iMin = Math.min(this.rawData.remaining(), 16384);
        this.workBufferSize = iMin;
        this.rawData.get(this.workBuffer, 0, iMin);
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2;
        int iAverageColorsNear;
        int i3;
        int i4;
        int[] iArr = this.mainScratch;
        int i5 = 0;
        if (gifFrame2 == null) {
            Arrays.fill(iArr, 0);
        }
        int i6 = 3;
        int i7 = 2;
        int i8 = 1;
        if (gifFrame2 != null && (i3 = gifFrame2.dispose) > 0) {
            if (i3 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    i4 = gifHeader.bgColor;
                    if (gifFrame.lct != null && gifHeader.bgIndex == gifFrame.transIndex) {
                    }
                    fillRect(iArr, gifFrame2, i4);
                } else if (this.framePointer == 0) {
                    this.isFirstFrameTransparent = true;
                }
                i4 = 0;
                fillRect(iArr, gifFrame2, i4);
            } else if (i3 == 3) {
                Bitmap bitmap = this.previousImage;
                if (bitmap == null) {
                    fillRect(iArr, gifFrame2, 0);
                } else {
                    int i9 = gifFrame2.ih;
                    int i10 = this.sampleSize;
                    int i11 = i9 / i10;
                    int i12 = gifFrame2.iy / i10;
                    int i13 = gifFrame2.iw / i10;
                    int i14 = gifFrame2.ix / i10;
                    int i15 = this.downsampledWidth;
                    bitmap.getPixels(iArr, (i12 * i15) + i14, i15, i14, i12, i13, i11);
                }
            }
        }
        decodeBitmapData(gifFrame);
        int i16 = gifFrame.ih;
        int i17 = this.sampleSize;
        int i18 = i16 / i17;
        int i19 = gifFrame.iy / i17;
        int i20 = gifFrame.iw / i17;
        int i21 = gifFrame.ix / i17;
        boolean z = this.framePointer == 0;
        int i22 = 8;
        int i23 = 0;
        int i24 = 1;
        while (i5 < i18) {
            if (gifFrame.interlace) {
                if (i23 >= i18) {
                    i24++;
                    if (i24 == i7) {
                        i23 = 4;
                    } else if (i24 == i6) {
                        i23 = i7;
                        i22 = 4;
                    } else if (i24 == 4) {
                        i22 = i7;
                        i23 = i8;
                    }
                }
                i2 = i23 + i22;
            } else {
                i2 = i23;
                i23 = i5;
            }
            int i25 = i23 + i19;
            if (i25 < this.downsampledHeight) {
                int i26 = this.downsampledWidth;
                int i27 = i25 * i26;
                int i28 = i27 + i21;
                int i29 = i28 + i20;
                int i30 = i27 + i26;
                if (i30 < i29) {
                    i29 = i30;
                }
                int i31 = this.sampleSize;
                int i32 = i5 * i31 * gifFrame.iw;
                int i33 = ((i29 - i28) * i31) + i32;
                int i34 = i28;
                while (i34 < i29) {
                    int i35 = i18;
                    int i36 = i19;
                    if (this.sampleSize == 1) {
                        iAverageColorsNear = this.act[this.mainPixels[i32] & 255];
                    } else {
                        iAverageColorsNear = averageColorsNear(i32, i33, gifFrame.iw);
                    }
                    if (iAverageColorsNear != 0) {
                        iArr[i34] = iAverageColorsNear;
                    } else if (!this.isFirstFrameTransparent && z) {
                        this.isFirstFrameTransparent = true;
                    }
                    i32 += this.sampleSize;
                    i34++;
                    i18 = i35;
                    i19 = i36;
                }
            }
            i5++;
            i18 = i18;
            i23 = i2;
            i19 = i19;
            i6 = 3;
            i7 = 2;
            i8 = 1;
        }
        if (this.savePrevious && ((i = gifFrame.dispose) == 0 || i == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                int i37 = this.downsampledWidth;
                bitmap2.setPixels(iArr, 0, i37, 0, 0, i37, this.downsampledHeight);
            }
        }
        Bitmap nextBitmap = getNextBitmap();
        if (nextBitmap != null) {
            int i38 = this.downsampledWidth;
            nextBitmap.setPixels(iArr, 0, i38, 0, 0, i38, this.downsampledHeight);
        }
        return nextBitmap;
    }

    public synchronized int read(int i, byte[] bArr) {
        GifHeader header = getHeaderParser().setData(bArr).parseHeader();
        this.header = header;
        if (bArr != null) {
            setData(header, ByteBuffer.wrap(bArr), i);
        }
        return this.status;
    }

    public GifDecoder() {
        this(new SimpleBitmapProvider());
    }
}
