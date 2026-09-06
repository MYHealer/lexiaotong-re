package com.gnete.upbc.cashier;

import android.content.Context;
import com.gnete.upbc.cashier.b.c;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class GnetePayConfig {
    private static final GnetePayConfig payConfig = new GnetePayConfig();
    private final c configData = new c();

    private GnetePayConfig() {
    }

    public static GnetePayConfig builder() {
        return payConfig;
    }

    public GnetePayConfig appScheme(String str) {
        this.configData.a(str);
        return this;
    }

    public GnetePayConfig createWXAPI(Context context, String str) {
        this.configData.a(WXAPIFactory.createWXAPI(context, str));
        return this;
    }

    public GnetePayConfig customWXMiniPath(String str) {
        this.configData.b(str);
        return this;
    }

    public GnetePayConfig env(GneteEnv gneteEnv) {
        this.configData.a(gneteEnv);
        return this;
    }

    public GnetePayConfig filter(GnetePayChannel... gnetePayChannelArr) {
        if (gnetePayChannelArr != null) {
            this.configData.d().addAll(Arrays.asList(gnetePayChannelArr));
        }
        return this;
    }

    c getConfigData() {
        return this.configData;
    }

    public GnetePayConfig monitor(boolean z) {
        this.configData.a(z);
        return this;
    }

    public GnetePayConfig monitorCrash(boolean z) {
        this.configData.b(z);
        return this;
    }

    public GnetePayConfig monitorLog(boolean z) {
        this.configData.c(z);
        return this;
    }
}
