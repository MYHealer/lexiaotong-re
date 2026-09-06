package com.yfanads.android.libs.thirdpart.transformations.internal;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FastBlur {
    public static Bitmap blur(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2;
        int i2;
        int i3;
        int[] iArr;
        int i4 = i;
        Bitmap bitmapCopy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i4 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i5 = width * height;
        int[] iArr2 = new int[i5];
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i6 = width - 1;
        int i7 = height - 1;
        int i8 = i4 + i4;
        int i9 = i8 + 1;
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[i5];
        int[] iArr6 = new int[Math.max(width, height)];
        int i10 = (i8 + 2) >> 1;
        int i11 = i10 * i10;
        int i12 = i11 * 256;
        int[] iArr7 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr7[i13] = i13 / i11;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i9, 3);
        int i14 = i4 + 1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            bitmap2 = bitmapCopy;
            if (i15 >= height) {
                break;
            }
            int i18 = height;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = -i4;
            int i28 = 0;
            while (true) {
                i3 = i7;
                iArr = iArr6;
                if (i27 > i4) {
                    break;
                }
                int i29 = iArr2[Math.min(i6, Math.max(i27, 0)) + i16];
                int[] iArr9 = iArr8[i27 + i4];
                iArr9[0] = (i29 & 16711680) >> 16;
                iArr9[1] = (i29 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i29 & 255;
                int iAbs = i14 - Math.abs(i27);
                int i30 = iArr9[0];
                i28 += i30 * iAbs;
                int i31 = iArr9[1];
                i19 = (i31 * iAbs) + i19;
                int i32 = iArr9[2];
                i20 = (iAbs * i32) + i20;
                if (i27 > 0) {
                    i26 += i30;
                    i25 += i31;
                    i24 += i32;
                } else {
                    i23 += i30;
                    i22 += i31;
                    i21 += i32;
                }
                i27++;
                i7 = i3;
                iArr6 = iArr;
            }
            int i33 = i4;
            int i34 = i28;
            int i35 = 0;
            while (i35 < width) {
                iArr3[i16] = iArr7[i34];
                iArr4[i16] = iArr7[i19];
                iArr5[i16] = iArr7[i20];
                int i36 = i34 - i23;
                int i37 = i19 - i22;
                int i38 = i20 - i21;
                int[] iArr10 = iArr8[((i33 - i4) + i9) % i9];
                int i39 = i23 - iArr10[0];
                int i40 = i22 - iArr10[1];
                int i41 = i21 - iArr10[2];
                if (i15 == 0) {
                    iArr[i35] = Math.min(i35 + i4 + 1, i6);
                }
                int i42 = iArr2[i17 + iArr[i35]];
                int i43 = (i42 & 16711680) >> 16;
                iArr10[0] = i43;
                int i44 = (i42 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[1] = i44;
                int i45 = i42 & 255;
                iArr10[2] = i45;
                int i46 = i26 + i43;
                int i47 = i25 + i44;
                int i48 = i24 + i45;
                i34 = i36 + i46;
                i19 = i37 + i47;
                i20 = i38 + i48;
                i33 = (i33 + 1) % i9;
                int[] iArr11 = iArr8[i33 % i9];
                int i49 = iArr11[0];
                i23 = i39 + i49;
                int i50 = iArr11[1];
                i22 = i40 + i50;
                int i51 = iArr11[2];
                i21 = i41 + i51;
                i26 = i46 - i49;
                i25 = i47 - i50;
                i24 = i48 - i51;
                i16++;
                i35++;
                iArr7 = iArr7;
            }
            i17 += width;
            i15++;
            bitmapCopy = bitmap2;
            height = i18;
            i7 = i3;
            iArr6 = iArr;
        }
        int i52 = i7;
        int[] iArr12 = iArr6;
        int i53 = height;
        int[] iArr13 = iArr7;
        int i54 = 0;
        while (i54 < width) {
            int i55 = -i4;
            int i56 = i9;
            int[] iArr14 = iArr2;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = i55;
            int i65 = i55 * width;
            int i66 = 0;
            int i67 = 0;
            while (true) {
                i2 = width;
                if (i64 > i4) {
                    break;
                }
                int iMax = Math.max(0, i65) + i54;
                int[] iArr15 = iArr8[i64 + i4];
                iArr15[0] = iArr3[iMax];
                iArr15[1] = iArr4[iMax];
                iArr15[2] = iArr5[iMax];
                int iAbs2 = i14 - Math.abs(i64);
                i66 = (iArr3[iMax] * iAbs2) + i66;
                i67 = (iArr4[iMax] * iAbs2) + i67;
                i57 = (iArr5[iMax] * iAbs2) + i57;
                if (i64 > 0) {
                    i63 += iArr15[0];
                    i62 += iArr15[1];
                    i61 += iArr15[2];
                } else {
                    i60 += iArr15[0];
                    i59 += iArr15[1];
                    i58 += iArr15[2];
                }
                int i68 = i52;
                if (i64 < i68) {
                    i65 += i2;
                }
                i64++;
                i52 = i68;
                width = i2;
            }
            int i69 = i52;
            int i70 = i4;
            int i71 = i54;
            int i72 = i53;
            int i73 = 0;
            while (i73 < i72) {
                iArr14[i71] = (iArr14[i71] & (-16777216)) | (iArr13[i66] << 16) | (iArr13[i67] << 8) | iArr13[i57];
                int i74 = i66 - i60;
                int i75 = i67 - i59;
                int i76 = i57 - i58;
                int[] iArr16 = iArr8[((i70 - i4) + i56) % i56];
                int i77 = i60 - iArr16[0];
                int i78 = i59 - iArr16[1];
                int i79 = i58 - iArr16[2];
                if (i54 == 0) {
                    iArr12[i73] = Math.min(i73 + i14, i69) * i2;
                }
                int i80 = iArr12[i73] + i54;
                int i81 = iArr3[i80];
                iArr16[0] = i81;
                int i82 = iArr4[i80];
                iArr16[1] = i82;
                int i83 = iArr5[i80];
                iArr16[2] = i83;
                int i84 = i63 + i81;
                int i85 = i62 + i82;
                int i86 = i61 + i83;
                i66 = i74 + i84;
                i67 = i75 + i85;
                i57 = i76 + i86;
                i70 = (i70 + 1) % i56;
                int[] iArr17 = iArr8[i70];
                int i87 = iArr17[0];
                i60 = i77 + i87;
                int i88 = iArr17[1];
                i59 = i78 + i88;
                int i89 = iArr17[2];
                i58 = i79 + i89;
                i63 = i84 - i87;
                i62 = i85 - i88;
                i61 = i86 - i89;
                i71 += i2;
                i73++;
                i4 = i;
            }
            i54++;
            i4 = i;
            i52 = i69;
            i53 = i72;
            i9 = i56;
            iArr2 = iArr14;
            width = i2;
        }
        int i90 = width;
        bitmap2.setPixels(iArr2, 0, i90, 0, 0, i90, i53);
        return bitmap2;
    }
}
