package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class e extends b {
    private int c;
    private Object d;

    public e(int i, String str, Object obj) {
        super(str, obj);
        this.c = i;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        this.d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.d != null) {
                arrayList.add(new BasicNameValuePair("extParam", com.alipay.a.a.f.a(this.d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f1569a));
            arrayList.add(new BasicNameValuePair("id", new StringBuilder().append(this.c).toString()));
            new StringBuilder("mParams is:").append(this.b);
            arrayList.add(new BasicNameValuePair("requestData", this.b == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : com.alipay.a.a.f.a(this.b)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e) {
            throw new RpcException(9, new StringBuilder("request  =").append(this.b).append(x.bQ).append(e).toString() == null ? "" : e.getMessage(), e);
        }
    }
}
