package com.unionpay;

import java.util.Comparator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class e implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f9319a;

    e(String str) {
        this.f9319a = str;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        long jOptLong = ((JSONObject) obj).optLong(this.f9319a);
        long jOptLong2 = ((JSONObject) obj2).optLong(this.f9319a);
        if (jOptLong < jOptLong2) {
            return -1;
        }
        return jOptLong > jOptLong2 ? 1 : 0;
    }
}
