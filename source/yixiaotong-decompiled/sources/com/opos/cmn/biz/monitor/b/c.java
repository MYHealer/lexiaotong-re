package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5992a;
    private Map<String, String> b;
    private byte[] c;

    /* JADX INFO: renamed from: com.opos.cmn.biz.monitor.b.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5993a;
        private Map<String, String> b = new HashMap();
        private byte[] c = null;

        public a(int i) {
            this.f5993a = i;
        }

        public a a(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.b = map;
            return this;
        }

        public a a(byte[] bArr) {
            this.c = bArr;
            return this;
        }

        public c a() {
            return new c(this.f5993a, this.b, this.c, null);
        }
    }

    private c(int i, Map<String, String> map, byte[] bArr) {
        this.f5992a = i;
        this.b = map;
        this.c = bArr;
    }

    /* synthetic */ c(int i, Map map, byte[] bArr, AnonymousClass1 anonymousClass1) {
        this(i, map, bArr);
    }

    public int a() {
        return this.f5992a;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }
}
