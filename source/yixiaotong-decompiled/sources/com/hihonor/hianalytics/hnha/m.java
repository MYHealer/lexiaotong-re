package com.hihonor.hianalytics.hnha;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3658a;
    public final Map<String, String> b;
    public final int c;
    public final byte[] d;

    public m(String str, Map<String, String> map, int i, byte[] bArr) {
        this.f3658a = str;
        this.b = map;
        this.c = i;
        this.d = bArr;
    }

    public String toString() {
        return "NetPostReqBean#" + hashCode() + "{type='" + this.c + ",headerSize=" + this.b.size() + ",dataSize=" + this.d.length + ",url=" + this.f3658a + '}';
    }
}
