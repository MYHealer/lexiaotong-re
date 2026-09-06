package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y4 {
    public String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<g5.b> f5748a = new CopyOnWriteArraySet();
    public boolean c = false;

    public class a implements g5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f5749a;
        public final /* synthetic */ AtomicInteger b;
        public final /* synthetic */ b c;
        public final /* synthetic */ MimoAdInfo d;
        public final /* synthetic */ e5 e;
        public final /* synthetic */ AtomicInteger f;
        public final /* synthetic */ int g;

        public a(List list, AtomicInteger atomicInteger, b bVar, MimoAdInfo mimoAdInfo, e5 e5Var, AtomicInteger atomicInteger2, int i) {
            this.f5749a = list;
            this.b = atomicInteger;
            this.c = bVar;
            this.d = mimoAdInfo;
            this.e = e5Var;
            this.f = atomicInteger2;
            this.g = i;
        }

        @Override // com.miui.zeus.mimo.sdk.g5.b
        public void a(String str) {
            if (!y4.this.c && this.f5749a.contains(str) && this.f.incrementAndGet() == this.g) {
                y4.a(y4.this, this);
                b bVar = this.c;
                if (bVar != null) {
                    ((q3) bVar).a(this.d, new a7(MimoAdError.ERROR_3000));
                }
            }
        }

        @Override // com.miui.zeus.mimo.sdk.g5.b
        public void b(String str) {
            if (y4.this.c || !this.f5749a.contains(str)) {
                return;
            }
            if (this.b.incrementAndGet() == 1) {
                y4.a(y4.this, this);
                b bVar = this.c;
                if (bVar != null) {
                    ((q3) bVar).f5570a.a();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (com.miui.zeus.mimo.sdk.b.h(this.d.A)) {
                arrayList.add(this.d.A);
            }
            if (!this.d.c().isEmpty()) {
                arrayList.addAll(this.d.c());
            }
            if (arrayList.isEmpty()) {
                return;
            }
            y4.this.a(arrayList, this.d.F0, this.e, (g5.b) null);
        }
    }

    public interface b {
    }

    public static void a(y4 y4Var, g5.b bVar) {
        y4Var.getClass();
        try {
            y4Var.f5748a.remove(bVar);
            t4 t4VarA = t4.a();
            t4VarA.getClass();
            t4VarA.f5439a.remove(bVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(List<String> list, boolean z, e5 e5Var, g5.b bVar) {
        if (this.c) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str : list) {
            if (!com.miui.zeus.mimo.sdk.b.h(t4.a().c(str, z))) {
                arrayList.add(str);
            } else if (bVar != null) {
                bVar.b(str);
            }
        }
        for (String str2 : arrayList) {
            t4.a().a(bVar);
            t4.a().a(str2, e5Var);
        }
    }

    public static void a(y4 y4Var, MimoAdInfo mimoAdInfo, File file) throws Throwable {
        y4Var.getClass();
        try {
            String strB = com.miui.zeus.mimo.sdk.b.b(file);
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            Matcher matcher = Pattern.compile(ijiami_1011.s.s.s.d(new byte[]{9, 13, 15, 91, 90, 26, 75, 91, 14, 16, 84, 3, 8, 58, 68, Ascii.DC2, 108, 11, 73, Utf8.REPLACEMENT_BYTE, 56, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 57, 70, 95, 59, Ascii.RS, Ascii.CAN, 111, 67, 67, 59, 93, Ascii.US, 79, 10, 95}, "5af514")).matcher(strB);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (strGroup.endsWith(ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 2, Ascii.ETB, Ascii.NAK}, "1adf6f")) || strGroup.endsWith(ijiami_1011.s.s.s.d(new byte[]{72, 82, 17}, "f8b7a1"))) {
                    hashSet.add(strGroup);
                }
            }
            arrayList.addAll(hashSet);
            arrayList.addAll(com.miui.zeus.mimo.sdk.b.i(strB));
            y4Var.a((List<String>) arrayList, false, e5.a(mimoAdInfo), (g5.b) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(MimoAdInfo mimoAdInfo, e5 e5Var, b bVar) {
        if (this.c) {
            return;
        }
        List<String> listJ = mimoAdInfo.j();
        ArrayList arrayList = (ArrayList) listJ;
        if (arrayList.isEmpty() && bVar != null) {
            a7 a7Var = new a7(MimoAdError.ERROR_2008);
            BaseAdImpl baseAdImpl = ((q3) bVar).f5570a;
            String str = BaseAdImpl.l;
            baseAdImpl.a(a7Var);
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        int size = arrayList.size();
        m.a(ijiami_1011.s.s.s.d(new byte[]{39, 88, 69, 89, 88, 10, 0, 0, 34, 11, 66, Ascii.NAK, 2, 67, 81, 95, 81, Ascii.ETB}, "c7274e"), ijiami_1011.s.s.s.d(new byte[]{0, 9, Ascii.DC4, 89, 85, 9, 0, 0, 39, 17, 66, 0, 16, 47, 14, 86, 94, 3, 39, 13, Ascii.DC4, 17, 69, 95, 13, 11, 2, 80, 92, Ascii.NAK, 79, Ascii.ETB, 15, Ascii.CAN, 84, 88}, "dfc79f") + arrayList.size());
        a aVar = new a(listJ, atomicInteger, bVar, mimoAdInfo, e5Var, atomicInteger2, size);
        this.f5748a.add(aVar);
        a(listJ, mimoAdInfo.F0, e5Var, aVar);
    }

    public void a(int i, MimoAdInfo mimoAdInfo, e5 e5Var, b bVar) {
        if (mimoAdInfo == null) {
            return;
        }
        this.c = false;
        if (i == 1) {
            if (!mimoAdInfo.E() || !com.miui.zeus.mimo.sdk.b.h(mimoAdInfo.B)) {
                a(mimoAdInfo, e5Var, bVar);
                return;
            }
            String strC = t4.a().c(mimoAdInfo.B, mimoAdInfo.F0);
            ArrayList arrayList = new ArrayList(mimoAdInfo.j());
            arrayList.add(mimoAdInfo.A);
            arrayList.addAll(mimoAdInfo.c());
            if (com.miui.zeus.mimo.sdk.b.h(strC)) {
                if (bVar != null) {
                    ((q3) bVar).f5570a.a();
                }
                a(arrayList, mimoAdInfo.F0, e5Var, (g5.b) null);
                return;
            } else {
                e5Var.getClass();
                t4.a().a(mimoAdInfo.B, e5Var);
                v4 v4Var = new v4(this, mimoAdInfo, bVar, e5Var, arrayList);
                this.f5748a.add(v4Var);
                t4.a().a(v4Var);
                return;
            }
        }
        if (i == 2) {
            a(mimoAdInfo, e5Var, bVar);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            if (com.miui.zeus.mimo.sdk.b.g(mimoAdInfo.A) && bVar != null) {
                a7 a7Var = new a7(MimoAdError.ERROR_2010);
                BaseAdImpl baseAdImpl = ((q3) bVar).f5570a;
                String str = BaseAdImpl.l;
                baseAdImpl.a(a7Var);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(mimoAdInfo.A);
            g5.b w4Var = new w4(this, mimoAdInfo, bVar);
            this.f5748a.add(w4Var);
            a(arrayList2, mimoAdInfo.F0, e5Var, w4Var);
            return;
        }
        ArrayList arrayList3 = new ArrayList(mimoAdInfo.c());
        if (arrayList3.isEmpty() && com.miui.zeus.mimo.sdk.b.g(mimoAdInfo.f()) && bVar != null) {
            a7 a7Var2 = new a7(MimoAdError.ERROR_2010);
            BaseAdImpl baseAdImpl2 = ((q3) bVar).f5570a;
            String str2 = BaseAdImpl.l;
            baseAdImpl2.a(a7Var2);
            return;
        }
        arrayList3.add(mimoAdInfo.f());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        int size = arrayList3.size();
        m.a(ijiami_1011.s.s.s.d(new byte[]{38, 12, SignedBytes.MAX_POWER_OF_TWO, 88, 92, 95, 0, 0, 34, 11, 66, Ascii.NAK, 3, Ascii.ETB, 84, 94, 85, 66}, "bc7600"), ijiami_1011.s.s.s.d(new byte[]{80, 10, Ascii.DC2, 13, 89, 13, 0, 0, 39, Ascii.DC2, 65, 54, 87, Ascii.ETB, 0, 6, 91, 17, 9, 11, Ascii.DC2, 36, 88, Ascii.ETB, 71, 17, 95, 10, 88, 3, 6, 1, Ascii.NAK, 76, 66, 12, 78, 0, 88}, "4eec5b") + arrayList3.size());
        g5.b x4Var = new x4(this, arrayList3, size, atomicInteger, bVar, mimoAdInfo, e5Var, atomicInteger2);
        this.f5748a.add(x4Var);
        a(arrayList3, mimoAdInfo.F0, e5Var, x4Var);
    }
}
