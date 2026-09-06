package org.repackage.com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class ValueData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9725a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i) {
        this.f9725a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f9725a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
