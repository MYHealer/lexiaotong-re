package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cr implements da {
    private static final String I = "BaseDeviceImpl";
    protected Context Code;
    protected com.huawei.openalliance.ad.utils.at V;

    protected cr(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Code = origApplicationContext;
        this.V = com.huawei.openalliance.ad.utils.at.Code(origApplicationContext);
    }

    @Override // com.huawei.hms.ads.da
    public boolean B() {
        return false;
    }

    @Override // com.huawei.hms.ads.da
    public String C() {
        return null;
    }

    @Override // com.huawei.hms.ads.da
    public int Code(View view) {
        return 0;
    }

    @Override // com.huawei.hms.ads.da
    public boolean Code() {
        return true;
    }

    @Override // com.huawei.hms.ads.da
    public boolean Code(Context context) {
        return false;
    }

    @Override // com.huawei.hms.ads.da
    public boolean Code(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            fh.I(I, "check widget available error");
            return false;
        }
    }

    @Override // com.huawei.hms.ads.da
    public boolean I() {
        return true;
    }

    @Override // com.huawei.hms.ads.da
    public boolean S() {
        return false;
    }

    @Override // com.huawei.hms.ads.da
    public boolean V() {
        return true;
    }

    @Override // com.huawei.hms.ads.da
    public String Z() {
        return null;
    }
}
