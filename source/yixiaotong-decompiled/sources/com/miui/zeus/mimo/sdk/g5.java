package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.c5.a;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.server.cache.MsaDiskLruCacheProxyService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<b> f5439a = new CopyOnWriteArraySet<>();
    public final List<String> b = new CopyOnWriteArrayList();
    public a5 c;
    public d5 d;
    public b5 e;

    public class a implements b5 {
        public a() {
        }
    }

    public interface b {
        void a(String str);

        void b(String str);
    }

    public g5(d5 d5Var, a5 a5Var) {
        a aVar = new a();
        this.e = aVar;
        this.d = d5Var;
        this.c = a5Var;
        if (a5Var != null) {
            a5Var.a(aVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:19:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x00d3 A[SYNTHETIC] */
    public static void a(g5 g5Var, String str, e5 e5Var, long j, i5 i5Var) {
        String str2;
        m4 m4Var;
        g5Var.getClass();
        m.b(ijiami_1011.s.s.s.d(new byte[]{39, 14, 69, 93, 15, 87, 0, 0, 3, 16}, "ca23c8"), ijiami_1011.s.s.s.d(new byte[]{116, 10, 19, 87, 90, 14, 0, 0, 70, 16, 84, Ascii.SYN, 95, 16, Ascii.SYN, 90, 83, 65, 7, 5, 15, 14, Ascii.GS, 69, 69, Ascii.ETB, 8, Ascii.EM, 11, 65}, "0ed96a") + str + ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 66, 65, SignedBytes.MAX_POWER_OF_TWO, 45, 5, 65, 89, 70}, "1b40da") + e5Var.f5415a + ijiami_1011.s.s.s.d(new byte[]{73, 19}, "e322f8") + i5Var.d());
        int i = i5Var.e;
        if (i != 0) {
            if (i == 1) {
                com.miui.zeus.mimo.sdk.b.a(e5Var.f5415a, m4.a(i5Var.f5460a, i5Var.c()));
            } else if (i == 2) {
                str2 = e5Var.f5415a;
                DiagnosisStep diagnosisStep = i5Var.f5460a;
                int iA = i5Var.a();
                String strB = i5Var.b();
                m4 m4Var2 = new m4();
                m4Var2.f5528a = diagnosisStep;
                m4Var2.c = iA;
                m4Var2.d = strB;
                m4Var = m4Var2;
            }
            com.miui.zeus.mimo.sdk.b.a(e5Var.f5415a, null, e5Var.c, ijiami_1011.s.s.s.d(new byte[]{32, 123, 96, 122, 46, 120, 32, 32}, "d474b7"), i5Var.f5460a.name(), str, j, l5.a(i5Var), l5.b(i5Var));
            for (b bVar : g5Var.f5439a) {
                if (bVar != null) {
                    bVar.a(str);
                }
            }
        }
        str2 = e5Var.f5415a;
        DiagnosisStep diagnosisStep2 = i5Var.f5460a;
        m4Var = new m4();
        m4Var.f5528a = diagnosisStep2;
        com.miui.zeus.mimo.sdk.b.a(str2, m4Var);
        com.miui.zeus.mimo.sdk.b.a(e5Var.f5415a, null, e5Var.c, ijiami_1011.s.s.s.d(new byte[]{32, 123, 96, 122, 46, 120, 32, 32}, "d474b7"), i5Var.f5460a.name(), str, j, l5.a(i5Var), l5.b(i5Var));
        while (r0.hasNext()) {
            if (bVar != null) {
                bVar.a(str);
            }
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f5439a.add(bVar);
        }
    }

    public boolean b(String str, boolean z) {
        s4<Boolean> s4VarA = a(str, z);
        Boolean bool = s4VarA.f5594a;
        if (bool != null && s4VarA.b == null && s4VarA.c == null) {
            return bool.booleanValue();
        }
        return false;
    }

    public String c(String str, boolean z) {
        d5 d5Var;
        if (TextUtils.isEmpty(str) || (d5Var = this.d) == null) {
            return null;
        }
        String strB = ((f5) d5Var).b(str);
        if (strB != null) {
            m.d(ijiami_1011.s.s.s.d(new byte[]{38, 10, 68, 87, 93, 12, 0, 0, 3, 16}, "be391c"), ijiami_1011.s.s.s.d(new byte[]{49, 1, 80, 92, 65, 88, 14, 7, 7, 14, 17, 6, 2, 7, 89, 93, 65, 70, 4, Ascii.ETB, 9, Ascii.ETB, 67, 6, 6, 68, 66, 77, 2, 87, 4, Ascii.ETB, Ascii.NAK}, "cd18a4"));
            return strB;
        }
        if (z) {
            try {
                MsaDiskLruCacheProxyService msaDiskLruCacheProxyService = new MsaDiskLruCacheProxyService(y8.f5752a);
                ((f5) this.d).getClass();
                int iB = msaDiskLruCacheProxyService.b(z8.a(str) + ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 86}, "3f0acb"));
                if (iB == 0) {
                    m.d(ijiami_1011.s.s.s.d(new byte[]{115, 10, 79, 15, 10, 9, 0, 0, 3, 16}, "7e8aff"), ijiami_1011.s.s.s.d(new byte[]{118, 88, 71, Ascii.CAN, 69, 0, 0, 7, 14, 7, 17, Ascii.ETB, 80, 68, 88, Ascii.DC4, Ascii.ETB, 0, 4, 68, 0, 16, 94, 8, Ascii.NAK, 90, 68, 0, 69, 16, Ascii.DC4, 7, 5, 7, 66, Ascii.SYN}, "577aec"));
                    d5 d5Var2 = this.d;
                    if (d5Var2 != null) {
                        ((f5) d5Var2).a(str);
                    }
                    b(str, true);
                } else {
                    m.d(ijiami_1011.s.s.s.d(new byte[]{115, 10, 17, 87, 89, 91, 0, 0, 3, 16}, "7ef954"), ijiami_1011.s.s.s.d(new byte[]{113, 13, Ascii.SYN, 73, Ascii.ETB, 81, 0, 7, 14, 7, 17, Ascii.ETB, 87, 17, 9, 69, 69, 81, 4, 68, 0, 16, 94, 8, Ascii.DC2, 15, Ascii.NAK, 81, Ascii.ETB, 84, 0, 13, 10, 78, 17}, "2bf072") + iB);
                }
            } catch (Throwable th) {
                m.d(ijiami_1011.s.s.s.d(new byte[]{124, 12, SignedBytes.MAX_POWER_OF_TWO, 94, 9, 12, 0, 0, 3, 16}, "8c70ec"), ijiami_1011.s.s.s.d(new byte[]{123, 12, Ascii.DC4, Ascii.GS, Ascii.DC4, 83, 0, 7, 14, 7, 17, Ascii.ETB, 93, 16, 11, 17, 70, 83, 4, 68, 0, 16, 94, 8, Ascii.CAN, 14, Ascii.ETB, 5, Ascii.DC4, 86, 0, 13, 10, 78, 17}, "8cdd40") + th.getMessage());
            }
        }
        return ((f5) this.d).b(str);
    }

    public final s4<Boolean> a(String str, boolean z) {
        d5 d5Var = this.d;
        if (d5Var == null) {
            return new s4<>(DiagnosisStep.KEY_FAIL_WHEN_DOWNLOAD_COMMIT_FILE_CACHE, ijiami_1011.s.s.s.d(new byte[]{85, 91, 68, 88, 41, Ascii.ETB, Ascii.DC4, 39, 7, 1, 89, 0, 17, 91, 68, 19, 11, 16, 13, 8}, "1273ee"));
        }
        f5 f5Var = (f5) d5Var;
        u4.b bVar = f5Var.f5425a.get(str);
        f5Var.f5425a.remove(str);
        if (bVar != null) {
            try {
                if (z) {
                    u4.a(u4.this, bVar, true);
                } else {
                    bVar.a();
                }
                u4 u4Var = f5Var.b;
                if (u4Var == null) {
                    return new s4<>(DiagnosisStep.KEY_FAIL_WHEN_DOWNLOAD_COMMIT_FILE_CACHE, ijiami_1011.s.s.s.d(new byte[]{87, 89, 67, 8, 121, 16, Ascii.DC4, 39, 7, 1, 89, 0, 19, 89, 67, 67, 91, Ascii.ETB, 13, 8}, "300c5b"));
                }
                synchronized (u4Var) {
                    u4Var.a();
                    u4Var.f();
                    u4Var.l.flush();
                }
            } catch (Exception e) {
                return new s4<>(DiagnosisStep.KEY_FAIL_WHEN_DOWNLOAD_COMMIT_FILE_CACHE, ijiami_1011.s.s.s.d(new byte[]{1, 12, 14, 84, 95, Ascii.DC2, 65, 2, 15, 14, 84, 69, 1, 2, 0, 81, 83, 70, 4, Ascii.FS, 5, 7, 65, 17, 11, 12, 13, Ascii.EM, 12, 70}, "bcc96f") + e.getMessage());
            }
        }
        return new s4<>(Boolean.TRUE);
    }

    public void a(String str, e5 e5Var) {
        if (TextUtils.isEmpty(str) || this.b.contains(str)) {
            return;
        }
        m.a(ijiami_1011.s.s.s.d(new byte[]{113, 10, 66, 12, 92, 11, 0, 0, 3, 16}, "5e5b0d"), ijiami_1011.s.s.s.d(new byte[]{97, 68, 85, Ascii.SYN, 67, 16, Ascii.NAK, 11, 70, 6, 94, Ascii.DC2, 92, 92, 91, 5, 83, 16, 19, 1, Ascii.NAK, 13, 68, Ascii.ETB, 81, 85, Ascii.CAN, 68, 66, 66, 13, 68, 91, 66}, "204d70") + str + ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, Ascii.SYN, 66, 73, 120, 5, 65, 89, 70}, "26791a") + e5Var.f5415a);
        this.b.add(str);
        a5 a5Var = this.c;
        if (a5Var != null) {
            String strA = ((f5) this.d).a(str);
            c5 c5Var = (c5) a5Var;
            if (c5Var.b.contains(str) || TextUtils.isEmpty(strA)) {
                return;
            }
            c5Var.b.add(str);
            c5Var.c.execute(c5Var.new a(str, strA, e5Var));
        }
    }
}
