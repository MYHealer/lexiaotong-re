package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.utils.MimoSdkInitHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k4 f5518a;
    public final Map<String, List<m4>> b = new LinkedHashMap();
    public final Map<String, List<m4>> c = new LinkedHashMap();
    public boolean d;
    public boolean e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l4 f5519a = new l4();
    }

    public final String a(List<m4> list) {
        DiagnosisStep diagnosisStep;
        String errorReason;
        if (list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (m4 m4Var : list) {
            if (m4Var != null && (diagnosisStep = m4Var.f5528a) != null) {
                i++;
                if (i > 1) {
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-48, -21, -87, -47, -93, -106}, "5e6486") + i + ijiami_1011.s.s.s.d(new byte[]{10, 110}, "0d8c77"));
                int reasonLevel = diagnosisStep.getReasonLevel();
                if (reasonLevel == 1) {
                    sb.append(diagnosisStep.getThrowableReason(m4Var.b));
                } else {
                    if (reasonLevel == 2) {
                        errorReason = diagnosisStep.getErrorReason(m4Var.c, m4Var.d);
                    } else if (reasonLevel == 3) {
                        errorReason = diagnosisStep.getErrorReason();
                    }
                    sb.append(errorReason);
                }
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-44, -125, -39, -47, -104, -56}, "18c96f") + i + ijiami_1011.s.s.s.d(new byte[]{14, Base64.padSymbol}, "47dad0"));
                sb.append(reasonLevel == 2 ? diagnosisStep.getSuggest(m4Var.c) : diagnosisStep.getSuggest());
            }
        }
        return sb.toString();
    }

    public final List<String> a(Map<String, List<m4>> map) {
        List<m4> value;
        if (map == null || map.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<m4>> entry : map.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null && !value.isEmpty()) {
                    arrayList.add(key);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x006b  */
    public void b() {
        String string;
        String strD;
        String strD2;
        String strD3;
        if (a()) {
            StringBuilder sb = new StringBuilder(" \n");
            sb.append(ijiami_1011.s.s.s.d(new byte[]{13, 10, 91, 11, 4, 88, 92, 89, 91, 95, 12, 88, 13, 10, 91, 11, 4, 88, 92, 89, 91, 95, 12, 88, 13, 10, -127, -121, -118, -126, -6, -5, 53, 38, 122, 69, 102}, "07f69e") + MimoSdkInitHolder.getVersionName() + ijiami_1011.s.s.s.d(new byte[]{-114, -53, -65, -123, -89, -104, -121, -18, -61, -121, -96, -17, 91, 89, 8, 94, 12, 8, 92, 89, 91, 95, 12, 88, 91, 89, 8, 94, 12, 8, 92, 89, 91, 95, 12, 88, 91, 89}, "fd5c15"));
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(ijiami_1011.s.s.s.d(new byte[]{-122, -116, -72, -115, -39, -85, -124, -20, -5, -121, -106, -18, -121, -72, -82}, "b48be1"));
            String string2 = null;
            if (this.f5518a == null) {
                string = null;
            } else {
                StringBuilder sb2 = new StringBuilder();
                DiagnosisStep diagnosisStep = this.f5518a.f5508a;
                if (diagnosisStep == null) {
                    string = null;
                } else {
                    sb2.append(ijiami_1011.s.s.s.d(new byte[]{-35, -65, -81, -43, -88, -107, 91, 110}, "810035"));
                    m4 m4Var = this.f5518a.b;
                    if (diagnosisStep.getReasonLevel() == 1) {
                        sb2.append(diagnosisStep.getThrowableReason(m4Var.b));
                    }
                    sb2.append(IOUtils.LINE_SEPARATOR_UNIX);
                    sb2.append(ijiami_1011.s.s.s.d(new byte[]{-43, -113, -126, -117, -104, -52, 91, 110}, "048c6b"));
                    sb2.append(diagnosisStep.getSuggest());
                    sb2.append(IOUtils.LINE_SEPARATOR_UNIX);
                    string = sb2.toString();
                }
            }
            if (string == null) {
                strD = ijiami_1011.s.s.s.d(new byte[]{-124, -69, -89, -128, -69, -85, 107}, "b37e14");
            } else {
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-124, -57, -127, -40, -46, -58, 107}, "ac00fc"));
                sb.append(string);
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-39, -7, -81, -36, -115, -115, -120, -27, -15, -124, -73, -37, -33, -40, -67, -35, -115, -113, -123, -34, -32, -124, -77, -51, -41, -2, -75, -36, -116, -118, -124, -11, -20, -121, -66, -54, -44, -33, -108, -33, -104, -106, -124, -36, -34, -121, -128, -16, -41, -64, -117, -47, -102, -126, -124, -44, -37, -121, -114, -50, -44, -37, -97, -36, -111, -72, -123, -33, -61, -122, -119, -17, -39, -13, -97, -48, -105, -83, -124, -9, -7, -115, -115, -28, 58}, "0d1955"));
                strD = ijiami_1011.s.s.s.d(new byte[]{9, 12, 88, 10, 94, 8, 92, 89, 91, 95, 12, 88, 9, 12, 88, 10, 94, 8, 92, 89, 91, 95, 12, 88, 9, 12, 88, 10, 94, 8, 92, 89, 91, 95, 12, 88, 9, 12, 88, 10, 94, 8, 92, 89, 91, 95, 12, 88, 9, 12, 88, 10, 94, 8, 92, 89, 91, 95, 12, 88, 9, 12, 88, 10, 94, 8, 92, 89, 91, 95, 12, 88, 62}, "41e7c5");
            }
            sb.append(strD);
            if (string != null) {
                Log.e(ijiami_1011.s.s.s.d(new byte[]{120, 11, 12, 10, Ascii.RS, 115, 8, 5, 1, 12, 94, Ascii.SYN, 92, 17}, "5bae37"), sb.toString());
                a(false);
                return;
            }
            if (!this.d && !this.e) {
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-39, -8, -1, -47, -114, -113, -121, -57, -12, -115, -115, -23, -42, -25, -55, -45, -84, -77, -124, -21, -55, -122, -118, -64, -43, -39, -31, -47, -111, -68, -124, -44, -5, -118, -98, -16, -43, -17, -63, -36, -117, -118, -124, -35, -39, -121, -96, -17, -44, -33, -25, 62}, "0ea467"));
                sb.append(ijiami_1011.s.s.s.d(new byte[]{89, 10, 94, 8, 15, 92, 92, 89, 91, 95, 12, 88, 89, 10, 94, 8, 15, 92, 92, 89, 91, 95, 12, 88, 89, 10, 94, 8, 15, 92, 92, 89, 91, 95, 12, 88, 89, 10, 94, 8, 15, 92, 92, 89, 91, 95, 12, 88, 89, 10, 94, 8, 15, 92, 92, 89, 91, 95, 12, 88, 89, 10, 94, 8, 15, 92, 92, 89, 91, 95, 12, 88, 110}, "d7c52a"));
                Log.e(ijiami_1011.s.s.s.d(new byte[]{125, 91, 14, 14, 72, 114, 8, 5, 1, 12, 94, Ascii.SYN, 89, 65}, "02cae6"), sb.toString());
                a(true);
                return;
            }
            sb.append(ijiami_1011.s.s.s.d(new byte[]{-128, -126, -24, -34, -119, -94, -124, -18, -58, -118, -116, -40, -127, -127, -37, -44, -92, -78}, "d8d158"));
            List<String> listA = a(this.b);
            List<String> listA2 = a(this.c);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) listA;
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(listA);
                for (String str : (ArrayList) listA2) {
                    if (!TextUtils.isEmpty(str)) {
                        Iterator it = arrayList2.iterator();
                        do {
                            if (!it.hasNext()) {
                                arrayList.add(str);
                                break;
                            }
                        } while (!TextUtils.equals((String) it.next(), str));
                    }
                }
            } else {
                arrayList.addAll(listA2);
            }
            if (!arrayList.isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                int i = 0;
                while (i < arrayList.size()) {
                    String str2 = (String) arrayList.get(i);
                    sb3.append(IOUtils.LINE_SEPARATOR_UNIX);
                    i++;
                    sb3.append(i + ijiami_1011.s.s.s.d(new byte[]{-41, -80, -28, -48, -117, -80, -124, -36, -34, -121, -120, -38, -47, -95, -17, 15, Ascii.ETB}, "40e572") + str2 + IOUtils.LINE_SEPARATOR_UNIX);
                    List<m4> list = this.b.get(str2);
                    if (list == null || list.isEmpty()) {
                        sb3.append(ijiami_1011.s.s.s.d(new byte[]{-127, -92, -32, Ascii.SYN, 90, 9, 0, 0, 39, 6, 17, -125, -21, -87, -124, -68, -87, 72, 107}, "c9a66f"));
                        List<m4> list2 = this.c.get(str2);
                        if (list2 == null || list2.isEmpty()) {
                            strD3 = ijiami_1011.s.s.s.d(new byte[]{-47, -2, -78, 65, 71, 81, 14, 19, 39, 6, 17, -125, -69, -13, -42, -21, -85, Ascii.ETB, 107}, "3c3a49");
                        } else {
                            sb3.append(ijiami_1011.s.s.s.d(new byte[]{-43, -92, -25, 70, 69, 92, 14, 19, 39, 6, 17, -128, -109, -120, -114, -46, -109, Ascii.DC4, 107}, "79ff64"));
                            strD3 = a(list2);
                        }
                    } else {
                        sb3.append(ijiami_1011.s.s.s.d(new byte[]{-125, -8, -79, 67, 94, 9, 0, 0, 39, 6, 17, -128, -59, -44, -40, -41, -105, 70, 107}, "ae0c2f"));
                        strD3 = a(list);
                    }
                    sb3.append(strD3);
                }
                string2 = sb3.toString();
            }
            if (string2 == null) {
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-45, -21, -88, -42, -65, -87}, "5c8356"));
                sb.append("\n\n");
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-34, -1, -87, -47, -119, -38, -121, -57, -12, -115, -115, -23, -47, -32, -97, -45, -85, -26, -124, -35, -39, -121, -96, -17, -46, -19, -104, -48, -118, -57, -121, -55, -59, -121, -119, -35, -46, -24, -105, -36, -116, -33, -123, -34, -32, 104}, "7b741b"));
                strD2 = ijiami_1011.s.s.s.d(new byte[]{94, 13, 88, 95, 5, 12, 92, 89, 91, 95, 12, 88, 94, 13, 88, 95, 5, 12, 92, 89, 91, 95, 12, 88, 94, 13, 88, 95, 5, 12, 92, 89, 91, 95, 12, 88, 94, 13, 88, 95, 5, 12, 92, 89, 91, 95, 12, 88, 94, 13, 88, 95, 5, 12, 92, 89, 91, 95, 12, 88, 94, 13, 88, 95, 5, 12, 92, 89, 91, 95, 12, 88, 105}, "c0eb81");
            } else {
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-47, -105, -124, -34, -41, -58, -114, -40, -22, -122, -119, -27, -47, -74, -124, -45, -57, -46, -119, -48, -61, -122, -117, -29}, "4356cc") + arrayList.size() + ijiami_1011.s.s.s.d(new byte[]{-42, -4, -62, 74, Ascii.ETB, -38, -50, -62, -128, -31, -76, -128, -106, -29, -121, -34, -68, -35, -35, -2, 108}, "0acf72"));
                sb.append(string2);
                sb.append("\n\n");
                sb.append(ijiami_1011.s.s.s.d(new byte[]{-39, -84, -8, -46, -116, -120, -120, -27, -15, -124, -73, -37, -33, -115, -22, -45, -116, -118, -123, -34, -32, -124, -77, -51, -41, -85, -30, -46, -115, -113, -124, -11, -20, -121, -66, -54, -44, -118, -61, -47, -103, -109, -124, -36, -34, -121, -128, -16, -41, -107, -36, -33, -101, -121, -124, -44, -37, -121, -114, -50, -44, -114, -56, -46, -112, -67, -123, -33, -61, -122, -119, -17, -39, -90, -56, -34, -106, -88, -124, -9, -7, -115, -115, -28, 58}, "01f740"));
                strD2 = ijiami_1011.s.s.s.d(new byte[]{4, 91, 9, 11, 92, 91, 92, 89, 91, 95, 12, 88, 4, 91, 9, 11, 92, 91, 92, 89, 91, 95, 12, 88, 4, 91, 9, 11, 92, 91, 92, 89, 91, 95, 12, 88, 4, 91, 9, 11, 92, 91, 92, 89, 91, 95, 12, 88, 4, 91, 9, 11, 92, 91, 92, 89, 91, 95, 12, 88, 4, 91, 9, 11, 92, 91, 92, 89, 91, 95, 12, 88, 51}, "9f46af");
            }
            sb.append(strD2);
            Log.e(ijiami_1011.s.s.s.d(new byte[]{125, 94, 88, 89, Ascii.ESC, 118, 8, 5, 1, 12, 94, Ascii.SYN, 89, 68}, "075662"), sb.toString());
            a(string2 == null);
        }
    }

    public final <T extends m4> int a(List<T> list, T t) {
        for (int i = 0; i < list.size(); i++) {
            T t2 = list.get(i);
            if (t2 != null && t2.f5528a == t.f5528a) {
                return i;
            }
        }
        return -1;
    }

    public boolean a() {
        return y8.f5752a != null && MimoSdkInitHolder.isDebugOn();
    }

    public final void a(boolean z) {
        String strD = ijiami_1011.s.s.s.d(new byte[]{34, 120, 32, 127, 123, 122, 50, 45, 53}, "f1a855");
        String strD2 = z ? ijiami_1011.s.s.s.d(new byte[]{1, 90, 87, 4, 12, 12, Ascii.DC2, 13, Ascii.NAK, Base64.padSymbol, 66, 16, 6, 80, 83, 16, 17}, "e36cbc") : ijiami_1011.s.s.s.d(new byte[]{87, 13, 82, 5, 93, 89, Ascii.DC2, 13, Ascii.NAK, Base64.padSymbol, 84, Ascii.ETB, 65, 11, 65}, "3d3b36");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (y8.f5752a == null) {
            return;
        }
        b.a(null, null, null, strD, strD2, null, jCurrentTimeMillis, null, null);
    }
}
