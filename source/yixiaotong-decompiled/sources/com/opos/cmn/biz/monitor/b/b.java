package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5990a;
    private String b;
    private Map<String, String> c;
    private byte[] d;

    /* JADX INFO: renamed from: com.opos.cmn.biz.monitor.b.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5991a;
        private String b = "GET";
        private Map<String, String> c = new HashMap();
        private byte[] d = null;

        public a(String str) {
            this.f5991a = str;
        }

        public a a(Map<String, String> map) {
            this.c = map;
            return this;
        }

        public b a() {
            return new b(this.f5991a, this.b, this.c, this.d, null);
        }
    }

    private b(String str, String str2, Map<String, String> map, byte[] bArr) {
        this.f5990a = str;
        this.b = str2;
        this.c = map;
        this.d = bArr;
    }

    /* synthetic */ b(String str, String str2, Map map, byte[] bArr, AnonymousClass1 anonymousClass1) {
        this(str, str2, map, bArr);
    }

    public String a() {
        return this.f5990a;
    }

    public String b() {
        return this.b;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public byte[] d() {
        return this.d;
    }
}
