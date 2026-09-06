package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dg f1812a;
    private String b;

    public interface a {
        void a();

        void a(int i, String str, NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i);

        void a(List<NativeResponse> list);

        void b();

        void b(int i, String str, NativeResponse nativeResponse);

        void b(NativeResponse nativeResponse);

        void c();
    }

    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public void b(String str) {
        this.b = str;
    }

    public g(Context context, String str, a aVar, boolean z, int i) {
        this(context, aVar, new dg(context, str, "feed", z, i));
    }

    public g(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i) {
        dg dgVar = new dg(context, str, "feed", z, i);
        this.f1812a = dgVar;
        dgVar.a(expressAdListener);
        this.f1812a.a(1);
    }

    public g(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i) {
        dg dgVar = new dg(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z, i);
        this.f1812a = dgVar;
        dgVar.a(entryAdListener);
    }

    public g(Context context, String str, a aVar, boolean z, int i, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f1812a = new dg(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f1812a = new dg(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f1812a = new dg(context, str, "video", z, i);
            } else {
                this.f1812a = new dg(context, str, "feed", z, i);
            }
        }
        this.f1812a.a(aVar);
    }

    public g(Context context, a aVar, dg dgVar) {
        this.f1812a = dgVar;
        dgVar.a(aVar);
    }

    public void a() {
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.p();
        }
    }

    public void a(b bVar) {
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.a(bVar);
        }
    }

    public void a(boolean z) {
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.c(z);
        }
    }

    public void b(boolean z) {
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.d(z);
        }
    }

    public void a(int i) {
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.r = i;
        }
    }

    public void c(boolean z) {
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.b(z);
        }
    }

    public String a(RequestParameters requestParameters) {
        if (this.f1812a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.f1812a.h(this.b);
        this.f1812a.a(requestParameters);
        return this.f1812a.l();
    }

    public void a(String str) {
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.b(str);
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dg dgVar = this.f1812a;
        if (dgVar != null) {
            dgVar.h(this.b);
        }
        this.f1812a.a(requestParameters);
        this.f1812a.a();
    }
}
