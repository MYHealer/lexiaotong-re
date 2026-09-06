package com.hihonor.adsdk.base.net;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static void hnadsa(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('\t');
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:21:0x0045  */
    public static String hnadsb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strHnadsa = hnadsa(str);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < strHnadsa.length()) {
            char cCharAt = strHnadsa.charAt(i);
            if (cCharAt == ',') {
                sb.append(cCharAt);
                if (c != '\\') {
                    sb.append('\n');
                    hnadsa(sb, i2);
                }
            } else if (cCharAt == '[') {
                sb.append(cCharAt).append('\n');
                i2++;
                hnadsa(sb, i2);
            } else if (cCharAt == ']') {
                sb.append('\n');
                i2--;
                hnadsa(sb, i2);
                sb.append(cCharAt);
            } else if (cCharAt == '{') {
                sb.append(cCharAt).append('\n');
                i2++;
                hnadsa(sb, i2);
            } else if (cCharAt != '}') {
                sb.append(cCharAt);
            } else {
                sb.append('\n');
                i2--;
                hnadsa(sb, i2);
                sb.append(cCharAt);
            }
            i++;
            c = cCharAt;
        }
        return sb.toString();
    }

    private static String hnadsa(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt == '\\') {
                i += 2;
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 == 'u') {
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < 4) {
                        int i5 = i + 1;
                        char cCharAt3 = str.charAt(i);
                        switch (cCharAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = ((i4 << 4) + cCharAt3) - 48;
                                break;
                            default:
                                switch (cCharAt3) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i4 = (((i4 << 4) + 10) + cCharAt3) - 65;
                                        break;
                                    default:
                                        switch (cCharAt3) {
                                            case 'a':
                                            case 'b':
                                            case z.k /* 99 */:
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i4 = (((i4 << 4) + 10) + cCharAt3) - 97;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
                                        }
                                        break;
                                }
                                break;
                        }
                        i3++;
                        i = i5;
                    }
                    sb.append((char) i4);
                } else {
                    if (cCharAt2 == 't') {
                        cCharAt2 = '\t';
                    } else if (cCharAt2 == 'r') {
                        cCharAt2 = '\r';
                    } else if (cCharAt2 == 'n') {
                        cCharAt2 = '\n';
                    } else if (cCharAt2 == 'f') {
                        cCharAt2 = '\f';
                    }
                    sb.append(cCharAt2);
                }
            } else {
                sb.append(cCharAt);
                i = i2;
            }
        }
        return sb.toString();
    }
}
