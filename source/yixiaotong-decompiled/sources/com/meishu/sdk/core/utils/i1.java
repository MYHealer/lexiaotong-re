package com.meishu.sdk.core.utils;

import android.graphics.Bitmap;
import com.meishu.sdk.core.domain.HttpResponse;
import java.io.IOException;

/* JADX INFO: compiled from: SplashLoadImageUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i1 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f4911a;

    public i1(j1 j1Var) {
        this.f4911a = j1Var;
    }

    @Override // com.meishu.sdk.core.utils.w
    public void onFailure(IOException iOException) {
        j1.a(this.f4911a, iOException);
    }

    @Override // com.meishu.sdk.core.utils.w
    public void a(HttpResponse<byte[]> httpResponse, Bitmap bitmap, Bitmap bitmap2) throws IOException {
        j1 j1Var = this.f4911a;
        j1Var.getClass();
        try {
            synchronized (j1Var.b) {
                try {
                    w wVar = j1Var.f4915a;
                    if (wVar != null) {
                        wVar.a(httpResponse, bitmap, bitmap2);
                        j1Var.f4915a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
