package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        float f;
        int i4;
        if (i3 > 4) {
            return;
        }
        try {
            Result resultDecode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    list.add(translateResultPoints(resultDecode, i, i2));
                    break;
                }
            } while (!it.next().getText().equals(resultDecode.getText()));
            ResultPoint[] resultPoints = resultDecode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f2 = width;
            int length = resultPoints.length;
            float f3 = 0.0f;
            float f4 = height;
            float f5 = 0.0f;
            int i5 = 0;
            while (i5 < length) {
                float f6 = f5;
                float f7 = f3;
                float f8 = f4;
                ResultPoint resultPoint = resultPoints[i5];
                if (resultPoint != null) {
                    float x = resultPoint.getX();
                    float y = resultPoint.getY();
                    if (x < f2) {
                        f2 = x;
                    }
                    if (y < f8) {
                        f8 = y;
                    }
                    if (x > f7) {
                        f7 = x;
                    }
                    if (y > f6) {
                        f6 = y;
                    }
                }
                f3 = f7;
                f4 = f8;
                i5++;
                f5 = f6;
            }
            if (f2 > 100.0f) {
                f = f5;
                i4 = 0;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f2, height), map, list, i, i2, i3 + 1);
            } else {
                f = f5;
                i4 = 0;
            }
            if (f4 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(i4, i4, width, (int) f4), map, list, i, i2, i3 + 1);
            }
            if (f3 < width - 100) {
                int i6 = (int) f3;
                doDecodeMultiple(binaryBitmap.crop(i6, i4, width - i6, height), map, list, i + i6, i2, i3 + 1);
            }
            if (f < height - 100) {
                int i7 = (int) f;
                doDecodeMultiple(binaryBitmap.crop(i4, i7, width, height - i7), map, list, i, i2 + i7, i3 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), resultPointArr, result.getBarcodeFormat());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
}
