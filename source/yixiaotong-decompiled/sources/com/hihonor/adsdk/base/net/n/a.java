package com.hihonor.adsdk.base.net.n;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.c;
import com.hihonor.adsdk.base.j.e;
import com.hihonor.adsdk.base.net.o.b;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements Interceptor {
    private static final String hnadsa = "UserAgentInterceptor";
    private static final String hnadsb = "User-Agent";
    private static final String hnadsc = "{\"code\": 30143,\"message\": chain is null.}";

    private boolean hnadsa(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(c.h2.hnadsc);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody responseBodyCreate = ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), hnadsc);
        try {
            if (!Objects.nonNull(chain)) {
                return new Response.Builder().protocol(Protocol.HTTP_1_1).code(ErrorCode.AD_HTTP_EXCEPTION_chain_NULL).request(chain.request()).body(responseBodyCreate).message("call chain proceed exception.").build();
            }
            Request requestBuild = chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", e.hnadsb().hnadsj()).build();
            if (!Objects.nonNull(requestBuild) || !Objects.nonNull(requestBuild.url()) || !Objects.nonNull(requestBuild.url().url()) || !hnadsa(requestBuild.url().url().getPath())) {
                return chain.proceed(requestBuild);
            }
            String strHeader = requestBuild.header(c.m0.hnadsg);
            b.hnadsa().hnadsa(strHeader, 20);
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("intercept request sta." + strHeader));
            Response responseProceed = chain.proceed(requestBuild);
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("intercept request end." + strHeader));
            b.hnadsa().hnadsa(strHeader, 21);
            return responseProceed;
        } catch (Exception e) {
            String str = "call chain proceed exception." + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, str, new Object[0]);
            return new Response.Builder().protocol(Protocol.HTTP_1_1).code(ErrorCode.AD_HTTP_EXCEPTION_chain_NULL).request(chain.request()).body(responseBodyCreate).message(str).build();
        }
    }
}
