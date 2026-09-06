package com.masget.base.bean;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ResultData<T> {
    List<T> rows;
    int total;

    public List<T> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setRows(List<T> list) {
        this.rows = list;
    }

    public void setTotal(int i) {
        this.total = i;
    }
}
