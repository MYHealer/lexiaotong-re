package com.jd.ad.sdk.dl.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADExtra implements IJADExtra {
    private double price = 0.0d;

    @Override // com.jd.ad.sdk.dl.model.IJADExtra
    public int getPrice() {
        return (int) Math.round(this.price);
    }

    public void setPrice(double d) {
        this.price = d;
    }
}
