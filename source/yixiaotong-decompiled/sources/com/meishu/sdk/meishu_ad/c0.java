package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import java.io.IOException;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c0 implements com.meishu.sdk.core.utils.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a f5006a;
    public final /* synthetic */ v b;

    public c0(v vVar, com.meishu.sdk.meishu_ad.splash.a aVar) {
        this.b = vVar;
        this.f5006a = aVar;
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        if (httpResponse == null || !httpResponse.isSuccessful()) {
            this.b.w = 2;
            if (this.b.u == 2 && this.b.v == 2) {
                this.b.a(this.f5006a, "def isnull", ErrorCodeUtil.RES_LOAD_ERROR);
                return;
            }
            return;
        }
        byte[] responseBody = httpResponse.getResponseBody();
        if (responseBody != null) {
            this.b.w = 1;
            this.b.x = responseBody;
        }
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
        this.b.w = 2;
        if (this.b.u == 2 && this.b.v == 2) {
            this.b.a(this.f5006a, "def isnull", ErrorCodeUtil.RES_LOAD_ERROR);
        }
    }
}
