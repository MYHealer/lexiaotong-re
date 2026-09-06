package com.ubixnow.ooooo;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oOo000Oo {
    private static volatile OooO0OO OooO00o = new OooO0O0(null);

    public static /* synthetic */ class OooO00o {
    }

    public static class OooO0O0 implements OooO0OO {
        private OooO0O0() {
        }

        public /* synthetic */ OooO0O0(OooO00o oooO00o) {
            this();
        }

        @Override // com.ubixnow.ooooo.oOo000Oo.OooO0OO
        public <K, V> Map<K, V> OooO00o(Map<K, V> map) {
            return map == null ? new HashMap() : map;
        }
    }

    public interface OooO0OO {
        <K, V> Map<K, V> OooO00o(Map<K, V> map);
    }

    private oOo000Oo() {
    }

    public static OooO0OO OooO00o() {
        return OooO00o;
    }

    public static void OooO00o(OooO0OO oooO0OO) {
        OooO00o = oooO0OO;
    }
}
