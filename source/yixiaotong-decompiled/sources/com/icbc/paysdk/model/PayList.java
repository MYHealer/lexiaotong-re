package com.icbc.paysdk.model;

import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PayList {
    Date checkDate = null;
    ArrayList<Integer> payList = new ArrayList<>();

    public Date getCheckDate() {
        return this.checkDate;
    }

    public ArrayList<Integer> getPayList() {
        return this.payList;
    }

    public void setCheckDate(Date date) {
        this.checkDate = date;
    }

    public void setPayList(ArrayList<Integer> arrayList) {
        this.payList = arrayList;
    }
}
