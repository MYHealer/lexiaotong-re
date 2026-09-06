package com.gnete.upbc.cashier;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class GnetePayRequest implements Serializable {
    public String chnlUrl;
    public GnetePayChannel payChannel = GnetePayChannel.CASHIER;
}
