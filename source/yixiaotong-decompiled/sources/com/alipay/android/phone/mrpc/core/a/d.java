package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.sdk.util.l;
import com.huawei.openalliance.ad.constant.x;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        try {
            String str = new String(this.b);
            Thread.currentThread().getId();
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt(l.f1664a);
            if (i == 1000) {
                return this.f1568a == String.class ? jSONObject.optString("result") : com.alipay.a.a.e.a(jSONObject.optString("result"), this.f1568a);
            }
            throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (Exception e) {
            throw new RpcException((Integer) 10, new StringBuilder("response  =").append(new String(this.b)).append(x.bQ).append(e).toString() == null ? "" : e.getMessage());
        }
    }
}
