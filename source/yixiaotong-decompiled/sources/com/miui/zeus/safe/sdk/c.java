package com.miui.zeus.safe.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.openalliance.ad.views.PPSLabelView;
import ijiami_1011.s.s.s;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static final String[] b = {s.d(new byte[]{Ascii.SYN, 71, 76, 75, 65, 83, 12, 75, 7, Ascii.DC2, 65, 74, 106, 65, 69, 93, 71, 67, Ascii.DC2, 1, Ascii.DC4, 76, 80, Ascii.NAK, 82}, "945856"), s.d(new byte[]{Ascii.RS, Ascii.NAK, 7, 91, 89, Ascii.GS, Ascii.DC2, 17}, "1fe272"), s.d(new byte[]{75, 67, 76, Ascii.DC2, 68, 93, 12, 75, 4, 11, 95, 74, Ascii.ETB, 69}, "d05a08"), s.d(new byte[]{77, Ascii.DC2, 75, Ascii.ETB, 16, 4, 12, 75, Ascii.RS, 0, 88, 11, 77, Ascii.DC2, 71}, "ba2dda"), s.d(new byte[]{Ascii.SYN, 82, 2, 68, 2, 74, 13, 11, 5, 3, 93, 74, 65, 84, 10, 94, 76, Ascii.SYN, Ascii.DC4}, "96c0ce"), s.d(new byte[]{76, 1, 0, SignedBytes.MAX_POWER_OF_TWO, 3, Ascii.ESC, 13, 11, 5, 3, 93, 74, 1, 12, 15, Ascii.ESC, 17, 65}, "cea4b4"), s.d(new byte[]{78, 17, 65, 17, Ascii.SYN, 6, 12, 75, Ascii.NAK, 6, Ascii.RS, Ascii.GS, 3, 11, 86, 77, 17, Ascii.SYN}, "ab8bbc"), s.d(new byte[]{Ascii.US, 70, 79, 71, 68, 87, 12, 75, 4, 11, 95, 74, 86, 84, 95, 88, 67, 83, 7, 1, 73, 17, 68}, "056402"), s.d(new byte[]{Ascii.CAN, 7, 88, 66, 84, Ascii.CAN, 13, 11, 5, 3, 93, 74, 68, Ascii.SYN}, "7c9657"), s.d(new byte[]{Ascii.GS, Ascii.DC2, Ascii.ETB, Ascii.ETB, 6, 13, 15, 75, Ascii.NAK, Ascii.ETB}, "2ab8dd")};
    public static final String[] c = {s.d(new byte[]{80, 89, 8, 75, 12, 9, Ascii.DC2, 12, 19, 4, 94, 16, Ascii.GS, 87, 11, 1, 16, 9, 8, 0, 72, 17, 68}, "36eebf"), s.d(new byte[]{1, 13, 84, Ascii.US, 92, 91, Ascii.DC2, 12, 19, 4, 94, 16, 76, 3, 87, 85, SignedBytes.MAX_POWER_OF_TWO, 91, 8, 0, 72, 17, 68, 75, 7, 14, 80, 69, 87}, "bb9124"), s.d(new byte[]{7, 17, Ascii.FS, 81, 88, 83, 8, 10, 0, 11, 67, 0, 76, Ascii.ETB, 71, 66, 85, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 17}, "bd2202"), s.d(new byte[]{2, 9, 11, Ascii.FS, 13, 86, Ascii.DC4, Ascii.ETB, 14, 11, 90, 1, Ascii.DC4, Ascii.DC2, Ascii.DC2, 83, 72, 74, Ascii.DC4, Ascii.DC4, 3, 16, 68, Ascii.SYN, 4, Ascii.DC4}, "aff2f9"), s.d(new byte[]{6, 89, 14, Ascii.US, 65, 89, 8, Ascii.SYN, 2, Ascii.DC2, 80, Ascii.ETB, 17, 79, 77, 66, SignedBytes.MAX_POWER_OF_TWO, 65, 4, Ascii.SYN, 19, 17, 84, Ascii.ETB}, "e6c151"), s.d(new byte[]{81, 93, 12, 76, 77, 93, 13, 8, 9, Ascii.NAK, 84, Ascii.SYN, Ascii.FS, 65, Ascii.DC4}, "22ab48")};
    public static final String[] d = {s.d(new byte[]{81, 86, 14, Ascii.SYN, 95, 10, Ascii.DC4, Ascii.ETB, 14, 11, 90, 1, 71, 77, Ascii.ETB, 89, 26, Ascii.ETB, 14, 9, 11, 3, 95, 4, 85, 92, 17}, "29c84e"), s.d(new byte[]{86, 90, 8, Ascii.ETB, 86, 13, 12, 11, 8, Ascii.DC4, 88, 1, 80, 90, 75, 85, 71, 7, 10, Ascii.GS, Ascii.SYN, 3, 69, 6, 93, 80, Ascii.ETB}, "55e92d"), s.d(new byte[]{82, 91, 84, 75, 83, 92, 4, 8, Ascii.SYN, Ascii.ETB, 66, 75, 93, 85, 90, 14, 73, 68, 0, 16, 5, 10}, "149e04"), s.d(new byte[]{2, 11, 91, Ascii.ETB, 69, 82, 12, 0, Ascii.DC4, 13, 88, 1, 79, 5, 70, 73, 70, 70, 0, Ascii.SYN, 7, 12, 69, 12, 15, 1}, "ad6973")};
    public static final String[] e = {s.d(new byte[]{91, 12, 95, Ascii.GS, 85, 85, Ascii.ETB, 5, 2, Ascii.DC4, 80, 11, 91, 6, Ascii.FS, 65, 94, 95, Ascii.NAK, 7, 10, 13, 80, 14}, "8c2310"), s.d(new byte[]{84, 83, 77, 71, 10, 84, Ascii.ETB, 74, 7, 12, 85, Ascii.ETB, 95, 95, 7, Ascii.ESC, Ascii.GS, 70, 14, Ascii.ETB, 3, 6, Ascii.US, 12, 94, 69, Ascii.ETB, 84, 9, 90, 4, Ascii.SYN}, "06c5e6"), s.d(new byte[]{5, 92, 92, 79, 74, 7, Ascii.DC4, Ascii.SYN, 15, 9, Ascii.US, Ascii.SYN, 19, 81, 66, Ascii.NAK, 75, 7, Ascii.NAK, 1}, "f31a9f"), s.d(new byte[]{86, 13, 93, 76, 82, 83, Ascii.ETB, 5, 2, Ascii.DC4, 80, 11, 86, 7, Ascii.RS, 16, 89, 89, Ascii.NAK, 7, 10, 13, 80, 14, 69, 14, 69, 17}, "5b0b66"), s.d(new byte[]{1, 95, 95, Ascii.FS, Ascii.RS, 87, 2, 12, Ascii.NAK, Ascii.DC2, 94, 11, 5, Ascii.RS, 70, 87, 9, 70, 19, 11, 9, Ascii.SYN, 67, 0, 15, 95, 68, 87, 14, 84}, "b022d6"), s.d(new byte[]{81, 89, 85, Ascii.EM, 80, 93, 17, 12, 9, 16, 80, Ascii.SYN, Ascii.FS, 94, 81, 83, 84, 93, Ascii.CAN, Ascii.SYN, 9, 13, 69}, "268710"), s.d(new byte[]{91, 87, 14, 75, 87, 87, 19, 9, Ascii.US, 10, 92, 75, 80, 81, 7, 0, 67, 87, 14, 16}, "88ce18")};
    public static final String[] f = {s.d(new byte[]{Ascii.SYN, 70, 65, 66, Ascii.ETB, 93, 12}, "9581c8"), s.d(new byte[]{74, 65, 73, 16, 65, 4, 12, 75, 4, 11, 95}, "e20c5a"), s.d(new byte[]{Ascii.ETB, Ascii.ETB, 76, 71, 17, 87, 12, 75, Ascii.NAK, 0, 88, 11}, "8d54e2"), s.d(new byte[]{76, SignedBytes.MAX_POWER_OF_TWO, Ascii.FS, 75, 66, 81, 12, 75, Ascii.RS, 0, 88, 11}, "c3e864"), s.d(new byte[]{Ascii.FS, 79, 80, 89, 6, 12, 19, 75, 4, 11, 95}, "3957bc"), s.d(new byte[]{Ascii.ESC, Ascii.ETB, 4, 94, 89}, "4df77e"), s.d(new byte[]{Ascii.ESC, 6, 16, 7}, "4cdd84")};
    public static final Map<String, String> g = new HashMap();
    public static volatile c h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5768a;

    public c() {
        this.f5768a = ((ArrayList) b()).size() > 0 || ((ArrayList) a(a.a())).size() > 0 || ((ArrayList) a()).size() > 0 || ((ArrayList) c()).size() > 0;
    }

    public final List<String> a() {
        InputStream inputStream;
        Map<String, String> map = g;
        map.put(s.d(new byte[]{111, 69, 12, Ascii.US, 2, 6, 3, 17, 1, 5, 80, 7, 88, 82, 62}, "47c1fc"), s.d(new byte[]{104, 84, 59}, "3ef538"));
        map.put(s.d(new byte[]{106, 69, 90, Ascii.CAN, 75, 3, 2, 17, Ascii.DC4, 7, 108}, "17568f"), s.d(new byte[]{58, 8, 104}, "a85eab"));
        String[] strArrSplit = null;
        try {
            inputStream = Runtime.getRuntime().exec(s.d(new byte[]{86, 80, Ascii.SYN, 66, SignedBytes.MAX_POWER_OF_TWO, 14, 17}, "15b22a")).getInputStream();
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream != null) {
            String next = "";
            try {
                next = new Scanner(inputStream).useDelimiter(s.d(new byte[]{101, 37}, "9d0172")).next();
            } catch (NoSuchElementException unused2) {
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            strArrSplit = next.split(IOUtils.LINE_SEPARATOR_UNIX);
        }
        ArrayList arrayList = new ArrayList();
        if (strArrSplit == null) {
            return arrayList;
        }
        for (String str : strArrSplit) {
            for (String str2 : g.keySet()) {
                if (str.contains(str2) && str.contains(g.get(str2))) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public final List<String> a(Context context) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(c));
        arrayList.addAll(Arrays.asList(d));
        arrayList.addAll(Arrays.asList(e));
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            try {
                packageManager.getPackageInfo(str, 0);
                arrayList2.add(str);
            } catch (Exception unused) {
            }
        }
        return arrayList2;
    }

    public final List<String> b() {
        InputStream inputStream;
        String[] strArrSplit = null;
        try {
            inputStream = Runtime.getRuntime().exec(s.d(new byte[]{15, 12, 70, 11, 71}, "bc3e38")).getInputStream();
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream != null) {
            String next = "";
            try {
                next = new Scanner(inputStream).useDelimiter(s.d(new byte[]{62, 39}, "bf899c")).next();
            } catch (NoSuchElementException unused2) {
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            strArrSplit = next.split(IOUtils.LINE_SEPARATOR_UNIX);
        }
        ArrayList arrayList = new ArrayList();
        if (strArrSplit == null) {
            return arrayList;
        }
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split(PPSLabelView.Code);
            if (strArrSplit2.length >= 4) {
                String str2 = strArrSplit2[1];
                String str3 = strArrSplit2[3];
                int i = 0;
                while (true) {
                    String[] strArr = f;
                    if (i < strArr.length) {
                        String str4 = strArr[i];
                        if (str2.equalsIgnoreCase(str4)) {
                            for (String str5 : str3.split(s.d(new byte[]{26}, "685da6"))) {
                                if (s.d(new byte[]{17, 68}, "c3ecc5").equalsIgnoreCase(str5)) {
                                    arrayList.add(str4);
                                    break;
                                }
                            }
                        }
                        i++;
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<String> c() {
        ArrayList arrayList = new ArrayList();
        int length = b.length;
        for (int i = 0; i < length; i++) {
            String str = b[i];
            if (new File(str).exists()) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
