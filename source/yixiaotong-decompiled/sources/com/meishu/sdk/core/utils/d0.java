package com.meishu.sdk.core.utils;

import android.os.Looper;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: compiled from: HttpUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d0 implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f4895a;

    /* JADX INFO: compiled from: HttpUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IOException f4896a;

        public a(IOException iOException) {
            this.f4896a = iOException;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            d0.this.f4895a.getClass();
            String[] strArr = ErrorCodeUtil.ERROR_REPORT_URL;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            z.a(strArr[0], ErrorCodeUtil.NETWORK_ERROR, this.f4896a.toString());
        }
    }

    /* JADX INFO: compiled from: HttpUtil.java */
    public class b extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpResponse f4897a;

        public b(HttpResponse httpResponse) {
            this.f4897a = httpResponse;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                i iVar = d0.this.f4895a;
                HttpResponse httpResponse = this.f4897a;
                iVar.getClass();
                LogUtil.d("DefaultHttpGetWithNoHandlerCallback", "onResponse: " + httpResponse.getErrorCode());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public d0(i iVar) {
        this.f4895a = iVar;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z.c.post(new a(iOException));
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        if (response.isSuccessful()) {
            httpResponse.setSuccessful(true);
            response.body();
        } else {
            httpResponse.setSuccessful(false);
            httpResponse.setErrorCode(response.code());
            httpResponse.setErrorDescription(response.message());
        }
        response.close();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z.c.post(new b(httpResponse));
            return;
        }
        try {
            this.f4895a.getClass();
            LogUtil.d("DefaultHttpGetWithNoHandlerCallback", "onResponse: " + httpResponse.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
