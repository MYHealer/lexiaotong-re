package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class TiffUtil {
    private static final Class<?> TAG = TiffUtil.class;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    /* JADX INFO: renamed from: com.facebook.imageutils.TiffUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    TiffUtil() {
    }

    public static int getAutoRotateAngleFromOrientation(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 3) {
            return 180;
        }
        if (i == 6) {
            return 90;
        }
        if (i == 8) {
            return 270;
        }
        FLog.i(TAG, "Unsupported orientation");
        return 0;
    }

    public static int readOrientationFromTIFF(InputStream inputStream, int i) throws IOException {
        TiffHeader tiffHeader = new TiffHeader(null);
        int tiffHeader2 = readTiffHeader(inputStream, i, tiffHeader);
        int i2 = tiffHeader.firstIfdOffset - 8;
        if (tiffHeader2 == 0 || i2 > tiffHeader2) {
            return 0;
        }
        inputStream.skip(i2);
        return getOrientationFromTiffEntry(inputStream, moveToTiffEntryWithTag(inputStream, tiffHeader2 - i2, tiffHeader.isLittleEndian, 274), tiffHeader.isLittleEndian);
    }

    private static class TiffHeader {
        int byteOrder;
        int firstIfdOffset;
        boolean isLittleEndian;

        private TiffHeader() {
        }

        /* synthetic */ TiffHeader(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static int readTiffHeader(InputStream inputStream, int i, TiffHeader tiffHeader) throws IOException {
        if (i <= 8) {
            return 0;
        }
        tiffHeader.byteOrder = StreamProcessor.readPackedInt(inputStream, 4, false);
        if (tiffHeader.byteOrder != 1229531648 && tiffHeader.byteOrder != 1296891946) {
            FLog.e(TAG, "Invalid TIFF header");
            return 0;
        }
        tiffHeader.isLittleEndian = tiffHeader.byteOrder == 1229531648;
        tiffHeader.firstIfdOffset = StreamProcessor.readPackedInt(inputStream, 4, tiffHeader.isLittleEndian);
        int i2 = i - 8;
        if (tiffHeader.firstIfdOffset >= 8 && tiffHeader.firstIfdOffset - 8 <= i2) {
            return i2;
        }
        FLog.e(TAG, "Invalid offset");
        return 0;
    }

    private static int moveToTiffEntryWithTag(InputStream inputStream, int i, boolean z, int i2) throws IOException {
        if (i < 14) {
            return 0;
        }
        int packedInt = StreamProcessor.readPackedInt(inputStream, 2, z);
        int i3 = i - 2;
        while (true) {
            int i4 = packedInt - 1;
            if (packedInt <= 0 || i3 < 12) {
                break;
            }
            int i5 = i3 - 2;
            if (StreamProcessor.readPackedInt(inputStream, 2, z) == i2) {
                return i5;
            }
            inputStream.skip(10L);
            i3 -= 12;
            packedInt = i4;
        }
        return 0;
    }

    private static int getOrientationFromTiffEntry(InputStream inputStream, int i, boolean z) throws IOException {
        if (i < 10 || StreamProcessor.readPackedInt(inputStream, 2, z) != 3 || StreamProcessor.readPackedInt(inputStream, 4, z) != 1) {
            return 0;
        }
        int packedInt = StreamProcessor.readPackedInt(inputStream, 2, z);
        StreamProcessor.readPackedInt(inputStream, 2, z);
        return packedInt;
    }
}
