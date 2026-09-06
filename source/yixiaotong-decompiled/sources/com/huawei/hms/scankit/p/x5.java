package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.util.SparseArray;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class x5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x5[] f4375a = {new j2(), new w3(), new i6(), new a6(), new f7(), new y(), new z6(), new a7(), new d3(), new w6(), new z3(), new w(), new c(), new r3(), new l5(), new d2()};
    private static final SparseArray<Integer> b;
    private static final Pattern c;
    private static final Pattern d;
    private static final Pattern e;
    static final String[] f;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        b = sparseArray;
        sparseArray.put(BarcodeFormat.AZTEC.ordinal(), Integer.valueOf(HmsScanBase.AZTEC_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODABAR.ordinal(), Integer.valueOf(HmsScanBase.CODABAR_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_39.ordinal(), Integer.valueOf(HmsScanBase.CODE39_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_93.ordinal(), Integer.valueOf(HmsScanBase.CODE93_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_128.ordinal(), Integer.valueOf(HmsScanBase.CODE128_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.DATA_MATRIX.ordinal(), Integer.valueOf(HmsScanBase.DATAMATRIX_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_8.ordinal(), Integer.valueOf(HmsScanBase.EAN8_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_13.ordinal(), Integer.valueOf(HmsScanBase.EAN13_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.ITF.ordinal(), Integer.valueOf(HmsScanBase.ITF14_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.PDF_417.ordinal(), Integer.valueOf(HmsScanBase.PDF417_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.QR_CODE.ordinal(), Integer.valueOf(HmsScanBase.QRCODE_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_A.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_A_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_E.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_E_SCAN_TYPE));
        c = Pattern.compile("\\d+");
        d = Pattern.compile("&");
        e = Pattern.compile("=");
        f = new String[0];
    }

    protected static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return c2 - '7';
    }

    protected static int a(BarcodeFormat barcodeFormat) {
        if (barcodeFormat == null) {
            return HmsScanBase.FORMAT_UNKNOWN;
        }
        Integer num = b.get(barcodeFormat.ordinal());
        return num == null ? HmsScanBase.FORMAT_UNKNOWN : num.intValue();
    }

    protected static String b(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z || cCharAt != '\\') {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    public static HmsScan c(w5 w5Var) {
        if (w5Var == null) {
            return null;
        }
        for (x5 x5Var : f4375a) {
            HmsScan hmsScanB = x5Var.b(w5Var);
            if (hmsScanB != null) {
                return hmsScanB;
            }
        }
        return new HmsScan(w5Var.k(), a(w5Var.c()), w5Var.k(), HmsScan.PURE_TEXT_FORM, w5Var.i(), a(w5Var.j()), null, null).setZoomValue(w5Var.l());
    }

    public abstract HmsScan b(w5 w5Var);

    protected static Point[] a(y5[] y5VarArr) {
        if (y5VarArr == null || y5VarArr.length <= 0) {
            return new Point[0];
        }
        Point[] pointArr = new Point[y5VarArr.length];
        for (int i = 0; i < y5VarArr.length; i++) {
            if (y5VarArr[i] != null) {
                pointArr[i] = new Point((int) y5VarArr[i].b(), (int) y5VarArr[i].c());
            }
        }
        return pointArr;
    }

    protected static String a(w5 w5Var) {
        String strK = w5Var.k();
        if (strK == null) {
            return "";
        }
        return strK.startsWith(AsyncHttpResponseHandler.UTF8_BOM) ? strK.substring(1) : strK;
    }

    public static HmsScan[] a(w5[] w5VarArr) {
        if (w5VarArr == null || w5VarArr.length <= 0) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArr = new HmsScan[w5VarArr.length];
        for (int i = 0; i < w5VarArr.length; i++) {
            w5 w5Var = w5VarArr[i];
            if (w5Var == null) {
                hmsScanArr[i] = null;
            } else {
                hmsScanArr[i] = c(w5Var);
            }
        }
        return hmsScanArr;
    }

    protected static boolean b(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && c.matcher(charSequence).matches();
    }

    static String b(String str, String str2, char c2, boolean z) {
        String str3;
        String[] strArrA = a(str, str2, c2, z);
        return (strArrA == null || strArrA.length == 0 || (str3 = strArrA[0]) == null) ? "" : str3;
    }

    static String[] a(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i = 0;
        while (i < length) {
            int iIndexOf = str2.indexOf(str, i);
            if (iIndexOf < 0) {
                break;
            }
            int length2 = iIndexOf + str.length();
            boolean z2 = true;
            ArrayList arrayList2 = arrayList;
            int length3 = length2;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c2, length3);
                if (iIndexOf2 < 0) {
                    length3 = str2.length();
                } else if (a(str2, iIndexOf2) % 2 != 0) {
                    length3 = iIndexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String strB = b(str2.substring(length2, iIndexOf2));
                    if (z) {
                        strB = strB.trim();
                    }
                    arrayList2.add(strB);
                    length3 = iIndexOf2 + 1;
                }
                z2 = false;
            }
            i = length3;
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(f);
    }

    private static int a(CharSequence charSequence, int i) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    protected static String a(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < str.length() ? str.substring(0, length) : str;
    }
}
