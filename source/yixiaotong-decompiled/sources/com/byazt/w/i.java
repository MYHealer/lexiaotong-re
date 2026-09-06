package com.byazt.w;

import kotlin.text.Typography;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1017, 42})
public class i {
    public static StringBuilder c(StringBuilder sb, String str) {
        sb.append(Typography.quote).append(str).append(Typography.quote);
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, String str, String str2) {
        sb.append(str).append(".\"").append(str2).append(Typography.quote);
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(Typography.quote).append(strArr[i]).append(Typography.quote);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder tt(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            c(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            c(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String c(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(Typography.quote).append(str2).append("\" (");
        c(sb, strArr);
        sb.append(") VALUES (");
        c(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String c(String str, String[] strArr) {
        String str2 = "\"" + str + Typography.quote;
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            c(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String c(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + Typography.quote;
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2).append(" SET ");
        tt(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            c(sb, str2, strArr2);
        }
        return sb.toString();
    }

    public static String tt(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + Typography.quote).append(" (");
        c(sb, strArr);
        sb.append(") VALUES (");
        c(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }
}
