package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private Encoder() {
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        BitArray bitArrayStuffBits;
        int i4;
        int i5;
        int i6;
        BitArray bitArrayEncode = new HighLevelEncoder(bArr).encode();
        int size = ((bitArrayEncode.getSize() * i) / 100) + 11;
        int size2 = bitArrayEncode.getSize() + size;
        int i7 = 4;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            int iAbs = Math.abs(i2);
            if (iAbs > (z2 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
            i4 = totalBitsInLayer(iAbs, z2);
            i5 = WORD_SIZE[iAbs];
            int i8 = i4 - (i4 % i5);
            bitArrayStuffBits = stuffBits(bitArrayEncode, i5);
            if (bitArrayStuffBits.getSize() + size > i8) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z2 && bitArrayStuffBits.getSize() > i5 * 64) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            z = z2;
            i3 = iAbs;
        } else {
            BitArray bitArrayStuffBits2 = null;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i9 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                z = i9 <= 3;
                i3 = z ? i9 + 1 : i9;
                int i11 = totalBitsInLayer(i3, z);
                if (size2 <= i11) {
                    int i12 = WORD_SIZE[i3];
                    if (i10 != i12) {
                        bitArrayStuffBits2 = stuffBits(bitArrayEncode, i12);
                    } else {
                        i12 = i10;
                    }
                    int i13 = i11 - (i11 % i12);
                    if ((!z || bitArrayStuffBits2.getSize() <= i12 * 64) && bitArrayStuffBits2.getSize() + size <= i13) {
                        bitArrayStuffBits = bitArrayStuffBits2;
                        i4 = i11;
                        i5 = i12;
                        break;
                    }
                    i10 = i12;
                }
                i9++;
                i7 = 4;
            }
        }
        BitArray bitArrayGenerateCheckWords = generateCheckWords(bitArrayStuffBits, i4, i5);
        int size3 = bitArrayStuffBits.getSize() / i5;
        BitArray bitArrayGenerateModeMessage = generateModeMessage(z, i3, size3);
        int i14 = i3 * 4;
        int i15 = z ? i14 + 11 : i14 + 14;
        int[] iArr = new int[i15];
        int i16 = 2;
        if (z) {
            for (int i17 = 0; i17 < i15; i17++) {
                iArr[i17] = i17;
            }
            i6 = i15;
        } else {
            int i18 = i15 / 2;
            int i19 = i15 + 1 + (((i18 - 1) / 15) * 2);
            int i20 = i19 / 2;
            int i21 = 0;
            while (i21 < i18) {
                int i22 = (i21 / 15) + i21;
                iArr[(i18 - i21) - 1] = (i20 - i22) - 1;
                iArr[i18 + i21] = i20 + i22 + 1;
                i21++;
                i16 = 2;
                i7 = 4;
            }
            i6 = i19;
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i23 = 0;
        for (int i24 = 0; i24 < i3; i24++) {
            int i25 = (i3 - i24) * i7;
            int i26 = z ? i25 + 9 : i25 + 12;
            int i27 = 0;
            while (i27 < i26) {
                int i28 = i27 * 2;
                int i29 = 0;
                while (i29 < i16) {
                    if (bitArrayGenerateCheckWords.get(i23 + i28 + i29)) {
                        int i30 = i24 * 2;
                        bitMatrix.set(iArr[i30 + i29], iArr[i30 + i27]);
                    }
                    if (bitArrayGenerateCheckWords.get(i23 + (i26 * 2) + i28 + i29)) {
                        int i31 = i24 * 2;
                        bitMatrix.set(iArr[i31 + i27], iArr[((i15 - 1) - i31) - i29]);
                    }
                    if (bitArrayGenerateCheckWords.get(i23 + (i26 * 4) + i28 + i29)) {
                        int i32 = (i15 - 1) - (i24 * 2);
                        bitMatrix.set(iArr[i32 - i29], iArr[i32 - i27]);
                    }
                    if (bitArrayGenerateCheckWords.get(i23 + (i26 * 6) + i28 + i29)) {
                        int i33 = i24 * 2;
                        bitMatrix.set(iArr[((i15 - 1) - i33) - i27], iArr[i33 + i29]);
                    }
                    i29++;
                    i16 = 2;
                }
                i27++;
                i7 = 4;
            }
            i23 += i26 * 8;
        }
        drawModeMessage(bitMatrix, z, i6, bitArrayGenerateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            int i34 = i6 / 2;
            drawBullsEye(bitMatrix, i34, 7);
            int i35 = 0;
            int i36 = 0;
            while (i35 < (i15 / 2) - 1) {
                for (int i37 = i34 & 1; i37 < i6; i37 += 2) {
                    int i38 = i34 - i36;
                    bitMatrix.set(i38, i37);
                    int i39 = i34 + i36;
                    bitMatrix.set(i39, i37);
                    bitMatrix.set(i37, i38);
                    bitMatrix.set(i37, i39);
                }
                i35 += 15;
                i36 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i3);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bitMatrix.set(i5, i4);
                bitMatrix.set(i5, i6);
                bitMatrix.set(i4, i5);
                bitMatrix.set(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int size = bitArray.getSize() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] iArrBitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(iArrBitsToWords, i3 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i4 : iArrBitsToWords) {
            bitArray2.appendBits(i4, i2);
        }
        return bitArray2;
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static GenericGF getGF(int i) {
        if (i == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i != 12) {
            return null;
        }
        return GenericGF.AZTEC_DATA_12;
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else {
                if (i7 == 0) {
                    bitArray2.appendBits(i4 | 1, i);
                } else {
                    bitArray2.appendBits(i4, i);
                }
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }
}
