package com.fancy;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ac {
    public static Bitmap _a(Bitmap bitmap) {
        float f = 10;
        int iRound = Math.round(bitmap.getWidth() / f);
        int iRound2 = Math.round(bitmap.getHeight() / f);
        try {
            return ThumbnailUtils.extractThumbnail(_b(ThumbnailUtils.extractThumbnail(bitmap, iRound, iRound2)), iRound * 2, iRound2 * 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap _b(Bitmap bitmap) {
        int i;
        Bitmap bitmap2;
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[173056];
        int i5 = 0;
        for (int i6 = 0; i6 < 173056; i6++) {
            iArr6[i6] = i6 / 676;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 51, 3);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i = 25;
            if (i7 >= height) {
                break;
            }
            int i10 = i5;
            int i11 = i10;
            int i12 = i11;
            int i13 = i12;
            int i14 = i13;
            int i15 = i14;
            int i16 = i15;
            int i17 = i16;
            int i18 = -25;
            int i19 = i17;
            while (true) {
                bitmap2 = bitmapCopy;
                if (i18 > 25) {
                    break;
                }
                int i20 = iArr[Math.min(i3, Math.max(i18, i5)) + i8];
                int[] iArr8 = iArr7[i18 + 25];
                iArr8[i5] = (i20 & 16711680) >> 16;
                iArr8[1] = (i20 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i20 & 255;
                int iAbs = 26 - Math.abs(i18);
                int i21 = iArr8[i5];
                i10 = (i21 * iAbs) + i10;
                int i22 = iArr8[1];
                i19 = (i22 * iAbs) + i19;
                int i23 = iArr8[2];
                i11 = (iAbs * i23) + i11;
                if (i18 > 0) {
                    i17 += i21;
                    i16 += i22;
                    i15 += i23;
                } else {
                    i14 += i21;
                    i13 += i22;
                    i12 += i23;
                }
                i18++;
                bitmapCopy = bitmap2;
            }
            int i24 = i5;
            int i25 = i10;
            int i26 = 25;
            while (i24 < width) {
                iArr2[i8] = iArr6[i25];
                iArr3[i8] = iArr6[i19];
                iArr4[i8] = iArr6[i11];
                int[] iArr9 = iArr7[(i26 + 26) % 51];
                int i27 = iArr9[i5];
                int i28 = iArr9[1];
                int i29 = iArr9[2];
                if (i7 == 0) {
                    iArr5[i24] = Math.min(i24 + 26, i3);
                }
                int i30 = iArr[iArr5[i24] + i9];
                int i31 = (i30 & 16711680) >> 16;
                iArr9[0] = i31;
                int i32 = (i30 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[1] = i32;
                int i33 = i30 & 255;
                iArr9[2] = i33;
                int i34 = i17 + i31;
                int i35 = i16 + i32;
                int i36 = i33 + i15;
                i26 = (i26 + 1) % 51;
                int[] iArr10 = iArr7[i26 % 51];
                int i37 = iArr10[0];
                int i38 = iArr10[1];
                int i39 = iArr10[2];
                i11 = (i11 - i12) + i36;
                i19 = (i19 - i13) + i35;
                i25 = (i25 - i14) + i34;
                i8++;
                i24++;
                i15 = i36 - i39;
                i14 = (i14 - i27) + i37;
                i13 = (i13 - i28) + i38;
                i12 = (i12 - i29) + i39;
                i5 = 0;
                i17 = i34 - i37;
                i16 = i35 - i38;
            }
            i9 += width;
            i7++;
            bitmapCopy = bitmap2;
        }
        int i40 = i5;
        while (i40 < width) {
            int i41 = width * (-25);
            int i42 = i5;
            int i43 = i42;
            int i44 = i43;
            int i45 = i44;
            int i46 = i45;
            int i47 = i46;
            int i48 = i47;
            int i49 = i48;
            int i50 = i49;
            for (int i51 = -25; i51 <= i; i51++) {
                int iMax = Math.max(i5, i41) + i40;
                int[] iArr11 = iArr7[i51 + 25];
                iArr11[i5] = iArr2[iMax];
                iArr11[1] = iArr3[iMax];
                iArr11[2] = iArr4[iMax];
                int iAbs2 = 26 - Math.abs(i51);
                i42 = (iArr2[iMax] * iAbs2) + i42;
                i43 = (iArr3[iMax] * iAbs2) + i43;
                i44 = (iArr4[iMax] * iAbs2) + i44;
                if (i51 > 0) {
                    i50 += iArr11[i5];
                    i49 += iArr11[1];
                    i48 += iArr11[2];
                } else {
                    i47 += iArr11[i5];
                    i46 += iArr11[1];
                    i45 += iArr11[2];
                }
                if (i51 < i4) {
                    i41 += width;
                }
            }
            int i52 = i40;
            int i53 = i5;
            int i54 = i;
            while (i53 < height) {
                iArr[i52] = (iArr[i52] & (-16777216)) | (iArr6[i42] << 16) | (iArr6[i43] << 8) | iArr6[i44];
                int[] iArr12 = iArr7[(i54 + 26) % 51];
                int i55 = iArr12[i5];
                int i56 = iArr12[1];
                int i57 = iArr12[2];
                if (i40 == 0) {
                    iArr5[i53] = Math.min(i53 + 26, i4) * width;
                }
                int i58 = iArr5[i53] + i40;
                int i59 = iArr2[i58];
                iArr12[i5] = i59;
                int i60 = iArr3[i58];
                iArr12[1] = i60;
                int i61 = iArr4[i58];
                iArr12[2] = i61;
                int i62 = i50 + i59;
                int i63 = i49 + i60;
                int i64 = i48 + i61;
                i42 = (i42 - i47) + i62;
                i43 = (i43 - i46) + i63;
                i54 = (i54 + 1) % 51;
                int[] iArr13 = iArr7[i54];
                int i65 = iArr13[i5];
                i47 = (i47 - i55) + i65;
                int i66 = iArr13[1];
                i46 = (i46 - i56) + i66;
                int i67 = iArr13[2];
                i50 = i62 - i65;
                i52 += width;
                i53++;
                i44 = (i44 - i45) + i64;
                i49 = i63 - i66;
                i48 = i64 - i67;
                i45 = (i45 - i57) + i67;
            }
            i40++;
            i = 25;
        }
        bitmapCopy.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCopy;
    }
}
