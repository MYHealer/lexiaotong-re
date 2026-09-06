package com.google.zxing.oned;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            if (map != null && map.containsKey(DecodeHintType.TRY_HARDER) && binaryBitmap.isRotateSupported()) {
                BinaryBitmap binaryBitmapRotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
                Result resultDoDecode = doDecode(binaryBitmapRotateCounterClockwise, map);
                Map<ResultMetadataType, Object> resultMetadata = resultDoDecode.getResultMetadata();
                int iIntValue = 270;
                if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                    iIntValue = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
                }
                resultDoDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
                ResultPoint[] resultPoints = resultDoDecode.getResultPoints();
                if (resultPoints != null) {
                    int height = binaryBitmapRotateCounterClockwise.getHeight();
                    for (int i = 0; i < resultPoints.length; i++) {
                        resultPoints[i] = new ResultPoint((height - resultPoints[i].getY()) - 1.0f, resultPoints[i].getX());
                    }
                }
                return resultDoDecode;
            }
            throw e;
        }
    }

    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        int i2;
        Map<DecodeHintType, ?> map2;
        int i3;
        int i4;
        Map<DecodeHintType, ?> map3 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i5 = height >> 1;
        int i6 = 0;
        int i7 = 1;
        boolean z = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, height >> (z ? 8 : 5));
        int i8 = z ? height : 15;
        int i9 = 0;
        while (i9 < i8) {
            int i10 = i9 + 1;
            int i11 = i10 / 2;
            if ((i9 & 1) != 0) {
                i11 = -i11;
            }
            int i12 = (i11 * iMax) + i5;
            if (i12 < 0 || i12 >= height) {
                break;
            }
            try {
                BitArray blackRow = binaryBitmap.getBlackRow(i12, bitArray);
                int i13 = i6;
                while (i13 < 2) {
                    if (i13 == i7) {
                        blackRow.reverse();
                        if (map3 != null && map3.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap = new EnumMap(DecodeHintType.class);
                            enumMap.putAll(map3);
                            enumMap.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        Result resultDecodeRow = decodeRow(i12, blackRow, map3);
                        if (i13 == i7) {
                            try {
                                resultDecodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = resultDecodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    map2 = map3;
                                    float f = width;
                                    try {
                                        i3 = width;
                                        try {
                                            resultPoints[0] = new ResultPoint((f - resultPoints[i6].getX()) - 1.0f, resultPoints[i6].getY());
                                            i4 = 1;
                                            try {
                                                resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                            } catch (ReaderException unused) {
                                                continue;
                                                i13++;
                                                i7 = i4;
                                                map3 = map2;
                                                width = i3;
                                                i6 = 0;
                                            }
                                        } catch (ReaderException unused2) {
                                            i4 = 1;
                                            i13++;
                                            i7 = i4;
                                            map3 = map2;
                                            width = i3;
                                            i6 = 0;
                                        }
                                    } catch (ReaderException unused3) {
                                        i3 = width;
                                        i4 = 1;
                                        i13++;
                                        i7 = i4;
                                        map3 = map2;
                                        width = i3;
                                        i6 = 0;
                                    }
                                }
                            } catch (ReaderException unused4) {
                                map2 = map3;
                            }
                        }
                        return resultDecodeRow;
                    } catch (ReaderException unused5) {
                        map2 = map3;
                        i3 = width;
                        i4 = i7;
                    }
                }
                i = width;
                i2 = i7;
                bitArray = blackRow;
            } catch (NotFoundException unused6) {
                i = width;
                i2 = i7;
            }
            i9 = i10;
            i7 = i2;
            width = i;
            i6 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !bitArray.get(i);
        while (i < size) {
            if (bitArray.get(i) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
