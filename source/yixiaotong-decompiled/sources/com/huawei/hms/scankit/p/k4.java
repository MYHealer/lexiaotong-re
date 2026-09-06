package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatWriter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class k4 implements g7 {

    /* JADX INFO: compiled from: MultiFormatWriter.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4294a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f4294a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4294a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4294a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4294a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4294a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4294a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4294a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4294a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4294a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4294a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4294a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4294a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4294a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.huawei.hms.scankit.p.g7
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<k2, ?> map) throws WriterException {
        g7 h2Var;
        switch (a.f4294a[barcodeFormat.ordinal()]) {
            case 1:
                h2Var = new h2();
                break;
            case 2:
                h2Var = new v6();
                break;
            case 3:
                h2Var = new f2();
                break;
            case 4:
                h2Var = new o6();
                break;
            case 5:
                h2Var = new p5();
                break;
            case 6:
                h2Var = new r0();
                break;
            case 7:
                h2Var = new t0();
                break;
            case 8:
                h2Var = new p0();
                break;
            case 9:
                h2Var = new t3();
                break;
            case 10:
                h2Var = new a5();
                break;
            case 11:
                h2Var = new n0();
                break;
            case 12:
                h2Var = new d1();
                break;
            case 13:
                h2Var = new i();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return h2Var.a(str, barcodeFormat, i, i2, map);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x01f6 A[Catch: Exception -> 0x0288, IllegalArgumentException -> 0x028a, OutOfMemoryError -> 0x02b8, TryCatch #1 {OutOfMemoryError -> 0x02b8, blocks: (B:104:0x0126, B:107:0x012c, B:109:0x0130, B:111:0x014e, B:114:0x0155, B:118:0x01a8, B:120:0x01ac, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:131:0x01d9, B:127:0x01c8, B:129:0x01ce, B:130:0x01d4, B:132:0x01dc, B:133:0x01df, B:134:0x01f6, B:137:0x020a, B:141:0x021c, B:143:0x0222, B:145:0x022d, B:144:0x0228, B:146:0x0230, B:147:0x0233, B:155:0x0265, B:157:0x026d, B:158:0x0274), top: B:184:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0209 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:137:0x020a A[Catch: Exception -> 0x0288, IllegalArgumentException -> 0x028a, OutOfMemoryError -> 0x02b8, TryCatch #1 {OutOfMemoryError -> 0x02b8, blocks: (B:104:0x0126, B:107:0x012c, B:109:0x0130, B:111:0x014e, B:114:0x0155, B:118:0x01a8, B:120:0x01ac, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:131:0x01d9, B:127:0x01c8, B:129:0x01ce, B:130:0x01d4, B:132:0x01dc, B:133:0x01df, B:134:0x01f6, B:137:0x020a, B:141:0x021c, B:143:0x0222, B:145:0x022d, B:144:0x0228, B:146:0x0230, B:147:0x0233, B:155:0x0265, B:157:0x026d, B:158:0x0274), top: B:184:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0219  */
    /* JADX WARN: Code duplicated, block: B:141:0x021c A[Catch: Exception -> 0x0288, IllegalArgumentException -> 0x028a, OutOfMemoryError -> 0x02b8, TryCatch #1 {OutOfMemoryError -> 0x02b8, blocks: (B:104:0x0126, B:107:0x012c, B:109:0x0130, B:111:0x014e, B:114:0x0155, B:118:0x01a8, B:120:0x01ac, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:131:0x01d9, B:127:0x01c8, B:129:0x01ce, B:130:0x01d4, B:132:0x01dc, B:133:0x01df, B:134:0x01f6, B:137:0x020a, B:141:0x021c, B:143:0x0222, B:145:0x022d, B:144:0x0228, B:146:0x0230, B:147:0x0233, B:155:0x0265, B:157:0x026d, B:158:0x0274), top: B:184:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0222 A[Catch: Exception -> 0x0288, IllegalArgumentException -> 0x028a, OutOfMemoryError -> 0x02b8, TryCatch #1 {OutOfMemoryError -> 0x02b8, blocks: (B:104:0x0126, B:107:0x012c, B:109:0x0130, B:111:0x014e, B:114:0x0155, B:118:0x01a8, B:120:0x01ac, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:131:0x01d9, B:127:0x01c8, B:129:0x01ce, B:130:0x01d4, B:132:0x01dc, B:133:0x01df, B:134:0x01f6, B:137:0x020a, B:141:0x021c, B:143:0x0222, B:145:0x022d, B:144:0x0228, B:146:0x0230, B:147:0x0233, B:155:0x0265, B:157:0x026d, B:158:0x0274), top: B:184:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0228 A[Catch: Exception -> 0x0288, IllegalArgumentException -> 0x028a, OutOfMemoryError -> 0x02b8, TryCatch #1 {OutOfMemoryError -> 0x02b8, blocks: (B:104:0x0126, B:107:0x012c, B:109:0x0130, B:111:0x014e, B:114:0x0155, B:118:0x01a8, B:120:0x01ac, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:131:0x01d9, B:127:0x01c8, B:129:0x01ce, B:130:0x01d4, B:132:0x01dc, B:133:0x01df, B:134:0x01f6, B:137:0x020a, B:141:0x021c, B:143:0x0222, B:145:0x022d, B:144:0x0228, B:146:0x0230, B:147:0x0233, B:155:0x0265, B:157:0x026d, B:158:0x0274), top: B:184:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x025a  */
    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Code duplicated, block: B:158:0x0274 A[Catch: Exception -> 0x0288, IllegalArgumentException -> 0x028a, OutOfMemoryError -> 0x02b8, TRY_LEAVE, TryCatch #1 {OutOfMemoryError -> 0x02b8, blocks: (B:104:0x0126, B:107:0x012c, B:109:0x0130, B:111:0x014e, B:114:0x0155, B:118:0x01a8, B:120:0x01ac, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:131:0x01d9, B:127:0x01c8, B:129:0x01ce, B:130:0x01d4, B:132:0x01dc, B:133:0x01df, B:134:0x01f6, B:137:0x020a, B:141:0x021c, B:143:0x0222, B:145:0x022d, B:144:0x0228, B:146:0x0230, B:147:0x0233, B:155:0x0265, B:157:0x026d, B:158:0x0274), top: B:184:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x027d  */
    /* JADX WARN: Code duplicated, block: B:161:0x0282  */
    public Bitmap a(String str, int i, int i2, int i3, HmsBuildBitmapOption hmsBuildBitmapOption) throws WriterException {
        int i4;
        BarcodeFormat barcodeFormat;
        BarcodeFormat barcodeFormat2;
        BarcodeFormat barcodeFormat3;
        boolean z;
        BarcodeFormat barcodeFormat4;
        BarcodeFormat barcodeFormat5;
        s sVarA;
        int iE;
        int iC;
        int[] iArr;
        int i5;
        Bitmap bitmapCreateBitmap;
        float f;
        Bitmap bitmapA;
        int i6;
        Bundle bundleA = com.huawei.hms.hmsscankit.e.a(str, i, i2, i3, hmsBuildBitmapOption);
        if (i2 > 0 && i3 > 0 && i2 <= 5120 && i3 <= 5120) {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() <= 2953) {
                    int i7 = HmsScanBase.QRCODE_SCAN_TYPE;
                    if (i == i7) {
                        i4 = 1;
                    } else if (i == HmsScanBase.PDF417_SCAN_TYPE) {
                        i4 = i2 / 30;
                    } else if (i == HmsScanBase.EAN13_SCAN_TYPE || i == HmsScanBase.EAN8_SCAN_TYPE || i == HmsScanBase.CODE39_SCAN_TYPE || i == HmsScanBase.CODE93_SCAN_TYPE || i == HmsScanBase.CODE128_SCAN_TYPE || i == HmsScanBase.CODABAR_SCAN_TYPE || i == HmsScanBase.ITF14_SCAN_TYPE || i == HmsScanBase.UPCCODE_A_SCAN_TYPE || i == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
                        i4 = 6;
                    } else {
                        i4 = 1;
                    }
                    r2 r2Var = r2.L;
                    String string = r2Var.toString();
                    int i8 = -16777216;
                    int i9 = -197381;
                    if (hmsBuildBitmapOption != null) {
                        int i10 = hmsBuildBitmapOption.margin;
                        if (i10 != 1) {
                            i4 = i10;
                        }
                        int i11 = hmsBuildBitmapOption.bimapColor;
                        i8 = i11 != -1 ? i11 : -16777216;
                        int i12 = hmsBuildBitmapOption.bitmapBackgroundColor;
                        i9 = i12 != -1 ? i12 : -197381;
                        HmsBuildBitmapOption.ErrorCorrectionLevel errorCorrectionLevel = hmsBuildBitmapOption.QRErrorCorrection;
                        string = errorCorrectionLevel == null ? r2Var.toString() : errorCorrectionLevel.value;
                    }
                    int i13 = i9;
                    int i14 = i8;
                    int i15 = i4;
                    Hashtable hashtable = new Hashtable();
                    hashtable.put(k2.CHARACTER_SET, "utf-8");
                    hashtable.put(k2.MARGIN, Integer.valueOf(i15));
                    try {
                        try {
                            try {
                                if (i == HmsScanBase.AZTEC_SCAN_TYPE) {
                                    barcodeFormat = BarcodeFormat.AZTEC;
                                } else if (i == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
                                    barcodeFormat = BarcodeFormat.DATA_MATRIX;
                                } else {
                                    if (i == HmsScanBase.PDF417_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.PDF_417;
                                        hashtable.put(k2.ERROR_CORRECTION, 2);
                                    } else if (i == i7) {
                                        barcodeFormat = BarcodeFormat.QR_CODE;
                                        hashtable.put(k2.ERROR_CORRECTION, string);
                                    } else if (i == HmsScanBase.CODABAR_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.CODABAR;
                                    } else if (i == HmsScanBase.CODE39_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.CODE_39;
                                    } else if (i == HmsScanBase.CODE93_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.CODE_93;
                                    } else if (i == HmsScanBase.CODE128_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.CODE_128;
                                    } else if (i == HmsScanBase.EAN8_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.EAN_8;
                                    } else if (i == HmsScanBase.EAN13_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.EAN_13;
                                    } else if (i == HmsScanBase.ITF14_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.ITF;
                                    } else if (i == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.UPC_A;
                                    } else if (i == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
                                        barcodeFormat2 = BarcodeFormat.UPC_E;
                                    } else {
                                        barcodeFormat = BarcodeFormat.QR_CODE;
                                        hashtable.put(k2.ERROR_CORRECTION, string);
                                    }
                                    barcodeFormat3 = barcodeFormat2;
                                    z = true;
                                    if (hmsBuildBitmapOption == null && hmsBuildBitmapOption.logoBitmap != null && barcodeFormat3 != BarcodeFormat.QR_CODE) {
                                        throw new WriterException("Non-QR code should not contains logos");
                                    }
                                    if (barcodeFormat3 != BarcodeFormat.QR_CODE && hmsBuildBitmapOption != null && hmsBuildBitmapOption.logoBitmap != null) {
                                        hashtable.put(k2.ERROR_CORRECTION, r2.H.toString());
                                        hashtable.put(k2.LOGO, Boolean.TRUE);
                                        s sVarA2 = a(str, barcodeFormat3, i2, i3, hashtable);
                                        if (sVarA2 == null) {
                                            return null;
                                        }
                                        int iE2 = (sVarA2.e() - (i15 * 2)) / 8;
                                        int iE3 = sVarA2.e() / 2;
                                        int iC2 = sVarA2.c() / 2;
                                        Matrix matrix = new Matrix();
                                        float f2 = iE2 * 2.0f;
                                        matrix.setScale(f2 / hmsBuildBitmapOption.logoBitmap.getWidth(), f2 / hmsBuildBitmapOption.logoBitmap.getHeight());
                                        Bitmap bitmap = hmsBuildBitmapOption.logoBitmap;
                                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), hmsBuildBitmapOption.logoBitmap.getHeight(), matrix, false);
                                        int[] iArr2 = new int[i2 * i2];
                                        for (int i16 = 0; i16 < i2; i16++) {
                                            for (int i17 = 0; i17 < i2; i17++) {
                                                if (i17 > iE3 - iE2 && i17 < iE3 + iE2 && i16 > iC2 - iE2 && i16 < iC2 + iE2) {
                                                    iArr2[(i16 * i2) + i17] = bitmapCreateBitmap2.getPixel((i17 - iE3) + iE2, (i16 - iC2) + iE2);
                                                } else if (sVarA2.b(i17, i16)) {
                                                    iArr2[(i16 * i2) + i17] = i14;
                                                } else {
                                                    iArr2[(i16 * i2) + i17] = i13;
                                                }
                                            }
                                        }
                                        bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
                                        bitmapCreateBitmap.setPixels(iArr2, 0, i2, 0, 0, i2, i2);
                                    } else {
                                        sVarA = a(str, barcodeFormat3, i2, i3, hashtable);
                                        if (sVarA == null) {
                                            return null;
                                        }
                                        iE = sVarA.e();
                                        iC = sVarA.c();
                                        iArr = new int[iE * iC];
                                        for (i5 = 0; i5 < iC; i5++) {
                                            for (i6 = 0; i6 < iE; i6++) {
                                                if (sVarA.b(i6, i5)) {
                                                    iArr[(i5 * iE) + i6] = i14;
                                                } else {
                                                    iArr[(i5 * iE) + i6] = i13;
                                                }
                                            }
                                        }
                                        bitmapCreateBitmap = Bitmap.createBitmap(iE, iC, Bitmap.Config.ARGB_8888);
                                        bitmapCreateBitmap.setPixels(iArr, 0, iE, 0, 0, iE, iC);
                                        float f3 = iE;
                                        f = f3 / i2;
                                        float f4 = iC;
                                        float f5 = f4 / i3;
                                        if (f == 1.0f && f5 != 1.0f && z) {
                                            if (f > f5) {
                                                bitmapA = y6.a(bitmapCreateBitmap, i2, (int) (f4 / f));
                                            } else {
                                                bitmapA = y6.a(bitmapCreateBitmap, (int) (f3 / f5), i3);
                                            }
                                            bitmapCreateBitmap = bitmapA;
                                        } else {
                                            x3.a("MultiFormatWriter", "wMultiple == 1f || hMultiple == 1f || !reFormFlag");
                                        }
                                    }
                                    if (bitmapCreateBitmap != null) {
                                        com.huawei.hms.hmsscankit.e.a(0, bitmapCreateBitmap, bundleA);
                                    } else {
                                        com.huawei.hms.hmsscankit.e.a(-1015, bitmapCreateBitmap, bundleA);
                                    }
                                    return bitmapCreateBitmap;
                                }
                                if (barcodeFormat3 != BarcodeFormat.QR_CODE) {
                                    sVarA = a(str, barcodeFormat3, i2, i3, hashtable);
                                    if (sVarA == null) {
                                        return null;
                                    }
                                    iE = sVarA.e();
                                    iC = sVarA.c();
                                    iArr = new int[iE * iC];
                                    while (i5 < iC) {
                                        while (i6 < iE) {
                                            if (sVarA.b(i6, i5)) {
                                                iArr[(i5 * iE) + i6] = i14;
                                            } else {
                                                iArr[(i5 * iE) + i6] = i13;
                                            }
                                        }
                                    }
                                    bitmapCreateBitmap = Bitmap.createBitmap(iE, iC, Bitmap.Config.ARGB_8888);
                                    bitmapCreateBitmap.setPixels(iArr, 0, iE, 0, 0, iE, iC);
                                    float f6 = iE;
                                    f = f6 / i2;
                                    float f7 = iC;
                                    float f8 = f7 / i3;
                                    if (f == 1.0f) {
                                        x3.a("MultiFormatWriter", "wMultiple == 1f || hMultiple == 1f || !reFormFlag");
                                    } else {
                                        x3.a("MultiFormatWriter", "wMultiple == 1f || hMultiple == 1f || !reFormFlag");
                                    }
                                } else {
                                    sVarA = a(str, barcodeFormat3, i2, i3, hashtable);
                                    if (sVarA == null) {
                                        return null;
                                    }
                                    iE = sVarA.e();
                                    iC = sVarA.c();
                                    iArr = new int[iE * iC];
                                    while (i5 < iC) {
                                        while (i6 < iE) {
                                            if (sVarA.b(i6, i5)) {
                                                iArr[(i5 * iE) + i6] = i14;
                                            } else {
                                                iArr[(i5 * iE) + i6] = i13;
                                            }
                                        }
                                    }
                                    bitmapCreateBitmap = Bitmap.createBitmap(iE, iC, Bitmap.Config.ARGB_8888);
                                    bitmapCreateBitmap.setPixels(iArr, 0, iE, 0, 0, iE, iC);
                                    float f9 = iE;
                                    f = f9 / i2;
                                    float f10 = iC;
                                    float f11 = f10 / i3;
                                    if (f == 1.0f) {
                                        x3.a("MultiFormatWriter", "wMultiple == 1f || hMultiple == 1f || !reFormFlag");
                                    } else {
                                        x3.a("MultiFormatWriter", "wMultiple == 1f || hMultiple == 1f || !reFormFlag");
                                    }
                                }
                                if (bitmapCreateBitmap != null) {
                                    com.huawei.hms.hmsscankit.e.a(0, bitmapCreateBitmap, bundleA);
                                } else {
                                    com.huawei.hms.hmsscankit.e.a(-1015, bitmapCreateBitmap, bundleA);
                                }
                                return bitmapCreateBitmap;
                            } catch (IllegalArgumentException e) {
                                e = e;
                                com.huawei.hms.hmsscankit.e.a(-1016, (Bitmap) null, bundleA);
                                throw new WriterException(e.getMessage(), barcodeFormat5.toString());
                            } catch (Exception e2) {
                                e = e2;
                                com.huawei.hms.hmsscankit.e.a(-1013, (Bitmap) null, bundleA);
                                throw new WriterException(e.getMessage(), barcodeFormat4.toString());
                            }
                        } catch (OutOfMemoryError e3) {
                            com.huawei.hms.hmsscankit.e.a(-1014, (Bitmap) null, bundleA);
                            throw new WriterException(e3.getMessage());
                        }
                    } catch (IllegalArgumentException e4) {
                        e = e4;
                        barcodeFormat5 = barcodeFormat3;
                    } catch (Exception e5) {
                        e = e5;
                        barcodeFormat4 = barcodeFormat3;
                    }
                    barcodeFormat3 = barcodeFormat;
                    z = false;
                    if (hmsBuildBitmapOption == null) {
                    }
                } else {
                    com.huawei.hms.hmsscankit.e.a(-1012, (Bitmap) null, bundleA);
                    throw new WriterException("IllegalArgumentException:contents.length > 2953");
                }
            } else {
                com.huawei.hms.hmsscankit.e.a(-1011, (Bitmap) null, bundleA);
                throw new WriterException("Content is empty");
            }
        } else {
            com.huawei.hms.hmsscankit.e.a(-1010, (Bitmap) null, bundleA);
            throw new WriterException("IllegalArgumentException:width & height should >0 & <5120");
        }
    }
}
