package com.heytap.msp.ipc.a;

import com.heytap.msp.ipc.annotation.IPCType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {

    /* JADX INFO: renamed from: com.heytap.msp.ipc.a.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3405a;

        static {
            int[] iArr = new int[IPCType.values().length];
            f3405a = iArr;
            try {
                iArr[IPCType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3405a[IPCType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3405a[IPCType.PROVIDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static List<l> a(com.heytap.msp.ipc.annotation.b bVar) {
        ArrayList arrayList = new ArrayList();
        if (bVar != null) {
            int i = AnonymousClass1.f3405a[bVar.a().ordinal()];
            int i2 = 0;
            if (i == 1 || i == 2) {
                String[] strArrD = bVar.d();
                int length = strArrD.length;
                while (i2 < length) {
                    l lVarB = l.b(bVar.e(), null, strArrD[i2], bVar.b());
                    if (lVarB != null) {
                        arrayList.add(lVarB);
                    }
                    i2++;
                }
            } else if (i == 3) {
                String[] strArrD2 = bVar.d();
                int length2 = strArrD2.length;
                while (i2 < length2) {
                    l lVarA = l.a(bVar.e(), null, strArrD2[i2], bVar.b());
                    if (lVarA != null) {
                        arrayList.add(lVarA);
                    }
                    i2++;
                }
            }
        }
        return arrayList;
    }
}
