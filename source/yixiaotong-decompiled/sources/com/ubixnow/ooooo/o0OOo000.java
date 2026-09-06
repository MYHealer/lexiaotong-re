package com.ubixnow.ooooo;

import java.net.HttpURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OOo000 extends a1 {
    private final String OooO0o;
    private final String OooO0oO;

    public o0OOo000(String str, String str2) {
        super(a1.OooO0O0.Post);
        this.OooO0o = str;
        this.OooO0oO = str2;
    }

    @Override // com.ubixnow.ooooo.e1
    public e1.OooO00o OooO00o() {
        return e1.OooO00o.ADD_NEW;
    }

    @Override // com.ubixnow.ooooo.a1
    public void OooO0O0(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
    }

    @Override // com.ubixnow.ooooo.a1
    public byte[] OooO0OO() {
        return this.OooO0o.getBytes();
    }

    @Override // com.ubixnow.ooooo.a1
    public String OooO0Oo() throws Exception {
        return this.OooO0oO;
    }

    @Override // com.ubixnow.ooooo.e1
    public String getName() {
        return getClass().getSimpleName();
    }
}
