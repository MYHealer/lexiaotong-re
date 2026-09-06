package com.meishu.sdk.core.cache;

import android.graphics.Bitmap;
import com.meishu.sdk.core.bquery.g;

/* JADX INFO: compiled from: ImageSourceHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4777a;

    public b(String str) {
        this.f4777a = str;
    }

    @Override // com.meishu.sdk.core.cache.d
    public void a() {
    }

    @Override // com.meishu.sdk.core.cache.d
    public void a(int i) {
        try {
            c.f4778a.remove(g.b(this.f4777a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        try {
            c.f4778a.remove(g.b(this.f4777a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
