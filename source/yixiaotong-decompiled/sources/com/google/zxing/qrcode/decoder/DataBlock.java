package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    byte[] getCodewords() {
        return this.codewords;
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int count = 0;
        for (Version.ECB ecb : eCBlocks) {
            count += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[count];
        int i = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i2 = 0;
            while (i2 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i2++;
                i++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        int i3 = count - 1;
        while (i3 >= 0 && dataBlockArr[i3].codewords.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i5 = 0;
        for (int i6 = 0; i6 < eCCodewordsPerBlock; i6++) {
            int i7 = 0;
            while (i7 < i) {
                dataBlockArr[i7].codewords[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            dataBlockArr[i8].codewords[eCCodewordsPerBlock] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        for (int i9 = eCCodewordsPerBlock; i9 < length2; i9++) {
            int i10 = 0;
            while (i10 < i) {
                dataBlockArr[i10].codewords[i10 < i4 ? i9 : i9 + 1] = bArr[i5];
                i10++;
                i5++;
            }
        }
        return dataBlockArr;
    }
}
