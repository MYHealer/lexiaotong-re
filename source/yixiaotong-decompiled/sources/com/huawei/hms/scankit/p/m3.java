package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: compiled from: HighLevelEncoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m3 {
    private static char a(char c, int i) {
        int i2 = c + ((i * Opcodes.FCMPL) % MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT) + 1;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    static boolean b(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean c(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean d(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean e(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean f(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    private static boolean g(char c) {
        return i(c) || c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean h(char c) {
        return false;
    }

    private static boolean i(char c) {
        return c == '\r' || c == '*' || c == '>';
    }

    public static String a(String str, h6 h6Var, b2 b2Var, b2 b2Var2) {
        int iE = 0;
        l2[] l2VarArr = {new b(), new b0(), new j6(), new h7(), new i2(), new n()};
        o2 o2Var = new o2(str);
        o2Var.a(h6Var);
        o2Var.a(b2Var, b2Var2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            o2Var.a((char) 236);
            o2Var.a(2);
            o2Var.f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            o2Var.a((char) 237);
            o2Var.a(2);
            o2Var.f += 7;
        }
        while (o2Var.i()) {
            if (iE >= 0 && iE < 6) {
                l2VarArr[iE].a(o2Var);
            }
            if (o2Var.e() >= 0) {
                iE = o2Var.e();
                o2Var.j();
            }
        }
        int iA = o2Var.a();
        o2Var.l();
        int iA2 = o2Var.g().a();
        if (iA < iA2 && iE != 0 && iE != 5 && iE != 4) {
            o2Var.a((char) 254);
        }
        StringBuilder sbB = o2Var.b();
        if (sbB.length() < iA2) {
            sbB.append((char) 129);
        }
        while (sbB.length() < iA2) {
            sbB.append(a((char) 129, sbB.length() + 1));
        }
        return o2Var.b().toString();
    }

    static int a(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        if (i >= charSequence.length()) {
            return i2;
        }
        int i3 = 6;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[i3];
                int[] iArr = new int[i3];
                int iA = a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int iA2 = a(bArr);
                if (y6.a(iArr, 0) && iArr[0] == iA) {
                    return 0;
                }
                if (iA2 == 1 && y6.a(bArr, 5) && bArr[5] > 0) {
                    return 5;
                }
                if (iA2 == 1 && y6.a(bArr, 4) && bArr[4] > 0) {
                    return 4;
                }
                if (iA2 == 1 && y6.a(bArr, 2) && bArr[2] > 0) {
                    return 2;
                }
                return (iA2 == 1 && y6.a(bArr, 3) && bArr[3] > 0) ? 3 : 1;
            }
            char cCharAt = charSequence.charAt(i5);
            i4++;
            if (b(cCharAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (c(cCharAt)) {
                float fCeil = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil;
                fArr[0] = fCeil + 2.0f;
            } else {
                float fCeil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil2;
                fArr[0] = fCeil2 + 1.0f;
            }
            if (1 < fArr.length) {
                if (d(cCharAt)) {
                    fArr[1] = fArr[1] + 0.6666667f;
                } else if (c(cCharAt)) {
                    fArr[1] = fArr[1] + 2.6666667f;
                } else {
                    fArr[1] = fArr[1] + 1.3333334f;
                }
            }
            if (2 < fArr.length) {
                if (f(cCharAt)) {
                    fArr[2] = fArr[2] + 0.6666667f;
                } else if (c(cCharAt)) {
                    fArr[2] = fArr[2] + 2.6666667f;
                } else {
                    fArr[2] = fArr[2] + 1.3333334f;
                }
            }
            if (3 < fArr.length) {
                if (g(cCharAt)) {
                    fArr[3] = fArr[3] + 0.6666667f;
                } else if (c(cCharAt)) {
                    fArr[3] = fArr[3] + 4.3333335f;
                } else {
                    fArr[3] = fArr[3] + 3.3333333f;
                }
            }
            if (4 < fArr.length) {
                if (e(cCharAt)) {
                    fArr[4] = fArr[4] + 0.75f;
                } else if (c(cCharAt)) {
                    fArr[4] = fArr[4] + 4.25f;
                } else {
                    fArr[4] = fArr[4] + 3.25f;
                }
            }
            if (5 < fArr.length) {
                if (h(cCharAt)) {
                    fArr[5] = fArr[5] + 4.0f;
                } else {
                    fArr[5] = fArr[5] + 1.0f;
                }
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[i3];
                byte[] bArr2 = new byte[i3];
                a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int iA3 = a(bArr2);
                int i6 = iArr2[0];
                int i7 = iArr2[5];
                if (i6 < i7 && i6 < iArr2[1] && i6 < iArr2[2] && i6 < iArr2[3] && i6 < iArr2[4]) {
                    return 0;
                }
                if (i7 < i6) {
                    return 5;
                }
                byte b = bArr2[1];
                byte b2 = bArr2[2];
                byte b3 = bArr2[3];
                byte b4 = bArr2[4];
                if (b + b2 + b3 + b4 == 0) {
                    return 5;
                }
                if (iA3 == 1 && b4 > 0) {
                    return 4;
                }
                if (iA3 == 1 && b2 > 0) {
                    return 2;
                }
                if (iA3 == 1 && b3 > 0) {
                    return 3;
                }
                int i8 = iArr2[1];
                if (i8 + 1 < i6 && i8 + 1 < i7 && i8 + 1 < iArr2[4] && i8 + 1 < iArr2[2]) {
                    int i9 = iArr2[3];
                    if (i8 < i9) {
                        return 1;
                    }
                    if (i8 == i9) {
                        for (int i10 = i + i4 + 1; i10 < charSequence.length(); i10++) {
                            char cCharAt2 = charSequence.charAt(i10);
                            if (i(cCharAt2)) {
                                return 3;
                            }
                            if (!g(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
            i3 = 6;
        }
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i2 = 0; i2 < 6; i2++) {
            int iCeil = (int) Math.ceil(fArr[i2]);
            iArr[i2] = iCeil;
            if (i > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i = iCeil;
            }
            if (i == iCeil) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    private static int a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    public static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char cCharAt = charSequence.charAt(i);
            while (b(cCharAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    cCharAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    static void a(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
