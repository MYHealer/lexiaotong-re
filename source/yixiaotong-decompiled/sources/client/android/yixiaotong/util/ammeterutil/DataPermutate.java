package client.android.yixiaotong.util.ammeterutil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DataPermutate {
    static short[] PermutationTable = {61, 33, 79, 38, 4, 76, 49, 14, 42, 48, 74, 40, 66, 9, 1, 25, 72, 16, 7, 23, 67, 70, 39, 59, 19, 21, 78, 35, 2, 55, 22, 69, 44, 0, 5, 15, 51, 43, 57, 27, 37, 63, 28, 41, 52, 3, 50, 13, 54, 6, 17, 24, 58, 30, 34, 10, 11, 45, 64, 53, 68, 46, 12, 20, 32, 36, 29, 65, 31, 26, 47, 77, 73, 60, 56, 8, 75, 18, 62, 71};
    static short[] InversePermutationTable = {33, 14, 28, 45, 4, 34, 49, 18, 75, 13, 55, 56, 62, 47, 7, 35, 17, 50, 77, 24, 63, 25, 30, 19, 51, 15, 69, 39, 42, 66, 53, 68, 64, 1, 54, 27, 65, 40, 3, 22, 11, 43, 8, 37, 32, 57, 61, 70, 9, 6, 46, 36, 44, 59, 48, 29, 74, 38, 52, 23, 73, 0, 78, 41, 58, 67, 12, 20, 60, 31, 21, 79, 16, 72, 10, 76, 5, 71, 26, 2};

    static boolean GetTableBit(byte[] bArr, short s) {
        return ((bArr[s >> 3] >> (7 - (s & 7))) & 1) != 0;
    }

    static void SetTableBit(byte[] bArr, short s, boolean z) {
        if (z) {
            int i = s >> 3;
            bArr[i] = (byte) ((1 << (7 - (s & 7))) | bArr[i]);
        } else {
            int i2 = s >> 3;
            bArr[i2] = (byte) ((~(1 << (7 - (s & 7)))) & bArr[i2]);
        }
    }

    public static byte[] DataPermutate_10(byte[] bArr) {
        byte[] bArr2 = new byte[10];
        byte[] bArr3 = new byte[10];
        for (short s = 0; s < 80; s = (short) (s + 1)) {
            SetTableBit(bArr3, s, GetTableBit(bArr, PermutationTable[s]));
        }
        for (short s2 = 0; s2 < 10; s2 = (short) (s2 + 1)) {
            bArr2[s2] = bArr3[s2];
        }
        return bArr2;
    }

    public static byte[] DataInversePermutate_10(byte[] bArr) {
        byte[] bArr2 = new byte[10];
        byte[] bArr3 = new byte[10];
        for (short s = 0; s < 80; s = (short) (s + 1)) {
            SetTableBit(bArr3, s, GetTableBit(bArr, InversePermutationTable[s]));
        }
        for (short s2 = 0; s2 < 10; s2 = (short) (s2 + 1)) {
            bArr2[s2] = bArr3[s2];
        }
        return bArr2;
    }
}
