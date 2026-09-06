package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Code128Reader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class o0 extends o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f4316a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static boolean a(r rVar, int i, int i2) {
        return rVar.a(i, i2, false, false);
    }

    private int[] c(StringBuilder sb, int[] iArr) throws a {
        int i = iArr[0];
        int i2 = iArr[1] == 1 ? 1 : 0;
        int i3 = iArr[2] == 1 ? 1 : 0;
        int i4 = iArr[3] == 1 ? 1 : 0;
        int i5 = iArr[4];
        int i6 = iArr[5] == 1 ? 1 : 0;
        int i7 = iArr[6] == 1 ? 1 : 0;
        if (i < 100) {
            if (i < 10) {
                sb.append('0');
            }
            sb.append(i);
        } else {
            if (i != 106) {
                i4 = 0;
            }
            if (i != 106) {
                switch (i) {
                    case 100:
                        i5 = 100;
                        break;
                    case 101:
                        i5 = 101;
                        break;
                    case 102:
                        break;
                    default:
                        throw a.a();
                }
            } else {
                i7 = 1;
            }
        }
        return new int[]{i, i2, i3, i4, i5, i6, i7};
    }

    private static int[] a(r rVar) throws a {
        int iE = rVar.e();
        int iC = rVar.c(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i = 0;
        int i2 = iC;
        while (iC < iE) {
            if (rVar.b(iC) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i == 5) {
                    int i3 = -1;
                    float f = 0.25f;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float fA = o4.a(iArr, f4316a[i4], 0.7f);
                        if (fA < f) {
                            i3 = i4;
                            f = fA;
                        }
                    }
                    if (i3 >= 0) {
                        return new int[]{i2, iC, i3};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i] = 0;
                    i--;
                } else {
                    i++;
                }
                iArr[i] = 1;
                z = !z;
            }
            iC++;
        }
        throw a.a();
    }

    private static float b(r rVar, int[] iArr, int i) {
        int[] iArr2 = new int[7];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        for (int i2 : iArr) {
            i += i2;
        }
        boolean z = true;
        int i3 = 0;
        while (z && i < rVar.e()) {
            if (rVar.b(i)) {
                i3++;
                i++;
            } else {
                iArr2[6] = i3;
                z = false;
            }
        }
        int[][] iArr3 = f4316a;
        return o4.a(iArr2, iArr3[iArr3.length - 1], 0.7f);
    }

    private int[] b(StringBuilder sb, int[] iArr) throws a {
        int i = iArr[0];
        int i2 = iArr[1] == 1 ? 1 : 0;
        int i3 = iArr[2] == 1 ? 1 : 0;
        int i4 = iArr[3] == 1 ? 1 : 0;
        int i5 = iArr[4];
        int i6 = iArr[5] == 1 ? 1 : 0;
        int i7 = iArr[6] == 1 ? 1 : 0;
        if (i < 96) {
            if (i2 == i3) {
                sb.append((char) (i + 32));
            } else {
                sb.append((char) (i + 160));
            }
            i2 = 0;
        } else {
            if (i != 106) {
                i4 = 0;
            }
            if (i != 106) {
                switch (i) {
                    case 96:
                    case 97:
                    case 102:
                        break;
                    case 98:
                        i5 = 101;
                        i6 = 1;
                        break;
                    case com.huawei.openalliance.ad.constant.z.k /* 99 */:
                        i5 = 99;
                        break;
                    case 100:
                        if (i3 == 0 && i2 != 0) {
                            i2 = 0;
                            i3 = 1;
                        } else if (i3 == 0 || i2 == 0) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                            i3 = 0;
                        }
                        break;
                    case 101:
                        i5 = 101;
                        break;
                    default:
                        throw a.a();
                }
            } else {
                i7 = 1;
            }
        }
        return new int[]{i, i2, i3, i4, i5, i6, i7};
    }

    private static int a(r rVar, int[] iArr, int i) throws a {
        float fA;
        o4.a(rVar, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = f4316a;
            if (i3 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i3];
            if (i3 == iArr2.length - 1) {
                fA = b(rVar, iArr, i);
            } else {
                fA = o4.a(iArr, iArr3, 0.7f);
            }
            if (fA < f) {
                i2 = i3;
                f = fA;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        int i2;
        int[] iArrA = a(rVar);
        int i3 = iArrA[0];
        int i4 = i3 - (((iArrA[1] - i3) / 11) * 10);
        if (i4 > 0 && i4 < i3) {
            if (!a(rVar, i4, i3)) {
                throw a.a();
            }
        }
        int i5 = iArrA[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i5));
        if (i5 == 103) {
            i2 = 101;
        } else if (i5 == 104) {
            i2 = 100;
        } else {
            i2 = i5 == 105 ? 99 : 0;
        }
        if (i2 != 0) {
            StringBuilder sb = new StringBuilder(20);
            int[] iArr = new int[7];
            iArr[6] = i2;
            a(sb, iArrA, iArr, i5, rVar, arrayList);
            int i6 = iArr[0];
            int i7 = iArr[1];
            int i8 = iArr[2];
            int i9 = iArr[3];
            int i10 = iArr[4];
            boolean z = iArr[5] == 1;
            int i11 = iArr[6];
            int i12 = i7 - i6;
            if ((i9 - (i10 * i8)) % 103 == i8) {
                int length = sb.length();
                if (length != 0) {
                    if (length > 0 && z) {
                        if (i11 == 99) {
                            sb.delete(length - 2, length);
                        } else {
                            sb.delete(length - 1, length);
                        }
                    }
                    float f = iArrA[0];
                    float f2 = i6 + ((i12 * 13) / 11);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i13 = 0; i13 < size; i13++) {
                        bArr[i13] = arrayList.get(i13).byteValue();
                    }
                    float f3 = i;
                    return new w5(sb.toString(), bArr, new y5[]{new y5(f, f3), new y5(f2, f3)}, BarcodeFormat.CODE_128);
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private void a(StringBuilder sb, int[] iArr, int[] iArr2, int i, r rVar, List<Byte> list) throws a {
        boolean z = false;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int[] iArr3 = new int[6];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 1;
        int i11 = iArr2[6];
        int i12 = i3;
        int i13 = i2;
        int i14 = i;
        while (i4 == 0) {
            int iA = a(rVar, iArr3, i12);
            list.add(Byte.valueOf((byte) iA));
            if (iA != 106) {
                i6++;
                i14 += i6 * iA;
                i10 = 1;
            }
            int i15 = i12;
            for (int i16 = 0; i16 < 6; i16++) {
                i15 += iArr3[i16];
            }
            if (iA != 105) {
                int[] iArrC = {iA, i7, i8, i10, i11, 0, i4};
                if (i11 == 101) {
                    iArrC = a(sb, iArrC);
                } else if (i11 == 100) {
                    iArrC = b(sb, iArrC);
                } else if (i11 == 99) {
                    iArrC = c(sb, iArrC);
                }
                int i17 = iArrC[0];
                i7 = iArrC[1] == 1 ? 1 : 0;
                i8 = iArrC[2] == 1 ? 1 : 0;
                int i18 = iArrC[3] == 1 ? 1 : 0;
                boolean z3 = iArrC[5] == 1;
                int i19 = iArrC[6] == 1 ? 1 : 0;
                if (z2) {
                    i11 = iArrC[4] == 101 ? 100 : 101;
                } else {
                    i11 = iArrC[4];
                }
                z2 = z3;
                i5 = i9;
                z = false;
                i4 = i19;
                i9 = i17;
                i10 = i18;
                i13 = i12;
                i12 = i15;
            } else {
                throw a.a();
            }
        }
        iArr2[z ? 1 : 0] = i13;
        iArr2[1] = i12;
        iArr2[2] = i5;
        iArr2[3] = i14;
        iArr2[4] = i6;
        iArr2[5] = i10;
        iArr2[6] = i11;
    }

    private int[] a(StringBuilder sb, int[] iArr) throws a {
        int i = iArr[0];
        int i2 = iArr[1] == 1 ? 1 : 0;
        int i3 = iArr[2] == 1 ? 1 : 0;
        int i4 = iArr[3] == 1 ? 1 : 0;
        int i5 = iArr[4];
        int i6 = iArr[5] == 1 ? 1 : 0;
        int i7 = iArr[6] == 1 ? 1 : 0;
        if (i >= 64) {
            if (i >= 96) {
                if (i != 106) {
                    i4 = 0;
                }
                if (i != 106) {
                    switch (i) {
                        case 96:
                        case 97:
                        case 102:
                            break;
                        case 98:
                            i5 = 100;
                            i6 = 1;
                            break;
                        case com.huawei.openalliance.ad.constant.z.k /* 99 */:
                            i5 = 99;
                            break;
                        case 100:
                            i5 = 100;
                            break;
                        case 101:
                            if (i3 == 0 && i2 != 0) {
                                i2 = 0;
                                i3 = 1;
                            } else if (i3 == 0 || i2 == 0) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                                i3 = 0;
                            }
                            break;
                        default:
                            throw a.a();
                    }
                } else {
                    i7 = 1;
                }
            } else if (i2 == i3) {
                sb.append((char) (i - 64));
            } else {
                sb.append((char) (i + 64));
            }
            return new int[]{i, i2, i3, i4, i5, i6, i7};
        }
        if (i2 == i3) {
            sb.append((char) (i + 32));
        } else {
            sb.append((char) (i + 160));
        }
        i2 = 0;
        return new int[]{i, i2, i3, i4, i5, i6, i7};
    }
}
