package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.server.api.AdRequest;
import com.miui.zeus.mimo.sdk.server.api.AdResponse;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r4 {
    public static final String c = ijiami_1011.s.s.s.d(new byte[]{17, 80}, "cdce72");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<AdRequest> f5582a = new ArrayDeque();
    public final Deque<AdRequest> b = new ArrayDeque();

    public static List a(r4 r4Var, s3 s3Var, AdResponse adResponse) {
        r4Var.getClass();
        ArrayList arrayList = new ArrayList();
        if (adResponse != null && adResponse.a()) {
            List<MimoAdInfo> list = (adResponse.f5529a == 0 && adResponse.a()) ? adResponse.f : null;
            JSONObject jSONObject = adResponse.d;
            for (int i = 0; i < list.size(); i++) {
                try {
                    MimoAdInfo mimoAdInfo = list.get(i);
                    mimoAdInfo.e0 = null;
                    if (jSONObject != null) {
                        try {
                            long jOptLong = jSONObject.optLong(ijiami_1011.s.s.s.d(new byte[]{71, 93, 3, 19, 82, 70, 9, 45, 8, Ascii.SYN, 84, Ascii.ETB, 67, 89, 9}, "58ea75"));
                            int iOptInt = jSONObject.optInt(ijiami_1011.s.s.s.d(new byte[]{85, 3, 68, 88, 66, 69, 4, 8, 42, 11, 92, 12, 66}, "6b6776"));
                            mimoAdInfo.f5381a = jOptLong;
                            mimoAdInfo.b = iOptInt;
                        } catch (Exception e) {
                            m.b(c, ijiami_1011.s.s.s.d(new byte[]{81, 81, 5, 120, 80, 96, 5, 15, 47, 12, 87, 10, 16, 80, 65, 3, Ascii.DC4}, "05a943"), e);
                        }
                    }
                    arrayList.add(mimoAdInfo);
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public static String a(r4 r4Var, String str, String str2) {
        StringBuilder sbAppend;
        String strD;
        r4Var.getClass();
        if (TextUtils.equals(str2, String.valueOf(0))) {
            sbAppend = new StringBuilder().append(ijiami_1011.s.s.s.d(new byte[]{119, 77, SignedBytes.MAX_POWER_OF_TWO, 67, 93, 11, Ascii.NAK, 8, Ascii.US, 66, 68, Ascii.SYN, 81, 92, Ascii.DC2, 68, 72, 44, 5, 94, 70}, "48218e")).append(str);
            strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 10, 13, 69, Ascii.EM, 80, 65, 16, 3, 15, 65, 9, 85, 16, 7, 17, 77, 72, 17, 1, 70, 3, 85, 73, Ascii.DC4, Ascii.DC4, 14, 84, 88, 66, 4, 68, 19, 17, 84, 69, SignedBytes.MAX_POWER_OF_TWO, 12, 7, 17, 90, 94, 19, Ascii.SYN, 3, 1, 69, 69, 85, 7, 1, 84, 74, 66, 65, 9, 3, Ascii.SYN, 89, 10, 80}, "4db191");
        } else {
            if (!TextUtils.equals(str2, String.valueOf(1))) {
                return ijiami_1011.s.s.s.d(new byte[]{101, 85, 87, 3, 68, 87, 65, 17, Ascii.NAK, 7, 17, 17, 93, 92, Ascii.DC2, 1, 88, SignedBytes.MAX_POWER_OF_TWO, 19, 1, 5, Ascii.SYN, 17, 4, 86, 90, 87, 17, 68, Ascii.DC2, 12, 1, Ascii.DC2, 10, 94, 1}, "592b72");
            }
            sbAppend = new StringBuilder().append(ijiami_1011.s.s.s.d(new byte[]{116, 17, 74, 75, 82, 91, Ascii.NAK, 8, Ascii.US, 66, 68, Ascii.SYN, 82, 0, Ascii.CAN, 76, 71, 124, 5, 94, 70}, "7d8975")).append(str);
            strD = ijiami_1011.s.s.s.d(new byte[]{17, 94, 87, 65, Ascii.EM, 0, 65, 10, 7, Ascii.SYN, 88, 19, 84, 16, 76, 76, 73, 4, 65, 5, 2, 78, 17, Ascii.NAK, 93, 85, 89, 70, 92, 65, Ascii.DC4, Ascii.ETB, 3, 66, 69, 13, 84, 16, 91, 90, 75, 19, 4, 7, Ascii.DC2, 66, 80, 6, 82, 85, 75, 70, Ascii.EM, 12, 4, 16, 14, 13, 85}, "10859a");
        }
        return sbAppend.append(strD).toString();
    }

    public static void a(r4 r4Var, AdRequest adRequest) {
        AdRequest adRequestPoll;
        synchronized (r4Var) {
            if (adRequest != null) {
                r4Var.b.remove(adRequest);
                if (!r4Var.f5582a.isEmpty() && (adRequestPoll = r4Var.f5582a.poll()) != null) {
                    r4Var.b.add(adRequestPoll);
                    x8.i.execute(new q4(r4Var, adRequestPoll));
                }
            }
        }
    }

    public final void a(AdRequest adRequest, l5<AdResponse> l5Var) {
        String strB;
        m4 m4Var;
        i5 i5Var = l5Var.c;
        if (i5Var == null) {
            return;
        }
        try {
            int i = i5Var.e;
            if (i == 0) {
                strB = adRequest.b();
                DiagnosisStep diagnosisStep = i5Var.f5460a;
                m4Var = new m4();
                m4Var.f5528a = diagnosisStep;
            } else {
                if (i == 1) {
                    b.a(adRequest.b(), m4.a(i5Var.f5460a, i5Var.c()));
                    return;
                }
                if (i != 2) {
                    return;
                }
                strB = adRequest.b();
                DiagnosisStep diagnosisStep2 = i5Var.f5460a;
                int iA = i5Var.a();
                String strB2 = i5Var.b();
                m4 m4Var2 = new m4();
                m4Var2.f5528a = diagnosisStep2;
                m4Var2.c = iA;
                m4Var2.d = strB2;
                m4Var = m4Var2;
            }
            b.a(strB, m4Var);
        } catch (Exception unused) {
        }
    }

    public void a(AdRequest adRequest, l5<AdResponse> l5Var, boolean z) {
        try {
            if (z) {
                m.a(c, ijiami_1011.s.s.s.d(new byte[]{75, 93, 68, 70, 93, 17, Ascii.NAK, 68, 7, 6, 17, 77, 76, 72, 124, 87, Ascii.CAN, 95, 65}, "98538b") + adRequest.b() + ijiami_1011.s.s.s.d(new byte[]{72, Ascii.DC4, 16, 77, 85, 80, 4, Ascii.ETB, Ascii.NAK, 78, 17, 16, Ascii.DC2, 81, 67, 76, 95, 94, 4, 68}, "a4c863") + (System.currentTimeMillis() - adRequest.g) + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 92, 66}, "9110c0"));
                String strB = adRequest.b();
                adRequest.a();
                b.a(strB, null, ijiami_1011.s.s.s.d(new byte[]{49, 38, 105, 54, 32, 107, 53}, "cc8ce8"), ijiami_1011.s.s.s.d(new byte[]{17, 92, 69, 68, 6, 75, Ascii.NAK, 59, Ascii.NAK, Ascii.ETB, 82, 6, 6, 74, 71}, "c941c8"), adRequest.g, ijiami_1011.s.s.s.d(new byte[]{7}, "7f3e78"), ijiami_1011.s.s.s.d(new byte[]{-33, -22, -15, -41, -70, -90}, "9ba209"));
                return;
            }
            m.b(c, ijiami_1011.s.s.s.d(new byte[]{19, 3, 68, 76, 86, 74, Ascii.NAK, 68, 7, 6, 17, 77, Ascii.DC4, Ascii.SYN, 124, 93, 19, 4, 65}, "af5939") + adRequest.b() + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 70, 0, 89, 15, 9, 77, 68}, "0ff8fe") + l5Var.a());
            a(adRequest, l5Var);
            String strB2 = adRequest.b();
            adRequest.a();
            String strD = ijiami_1011.s.s.s.d(new byte[]{99, 118, 104, 101, 39, 48, 53}, "1390bc");
            i5 i5Var = l5Var.c;
            b.a(strB2, null, strD, i5Var != null ? i5Var.f5460a.name() : null, adRequest.g, l5.a(l5Var.c), l5.b(l5Var.c));
        } catch (Exception unused) {
        }
    }
}
