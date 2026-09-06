package com.kwad.sdk.utils.a;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class g implements c.b<Set<String>> {
    static final g bsE = new g();

    @Override // com.kwad.sdk.utils.a.c.b
    public final String XD() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> f(byte[] bArr, int i, int i2) {
        return g(bArr, i, i2);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] u(Set<String> set) {
        return e(set);
    }

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int iGh = 0;
        int i = 0;
        for (String str : set) {
            if (str == null) {
                iGh += 5;
                iArr[i] = -1;
            } else {
                int iIu = b.iu(str);
                strArr[i] = str;
                iArr[i] = iIu;
                iGh += b.gh(iIu) + iIu;
            }
            i++;
        }
        b bVar = new b(iGh);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = iArr[i2];
            bVar.gg(i3);
            if (i3 >= 0) {
                bVar.it(strArr[i2]);
            }
        }
        return bVar.brM;
    }

    private static Set<String> g(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i3 = i + i2;
            while (bVar.position < i3) {
                linkedHashSet.add(bVar.getString(bVar.Xj()));
            }
            if (bVar.position != i3) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
