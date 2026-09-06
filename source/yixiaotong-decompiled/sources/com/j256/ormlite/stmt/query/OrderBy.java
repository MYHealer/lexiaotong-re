package com.j256.ormlite.stmt.query;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class OrderBy {
    private final boolean ascending;
    private final String columnName;

    public String getColumnName() {
        return this.columnName;
    }

    public boolean isAscending() {
        return this.ascending;
    }

    public OrderBy(String str, boolean z) {
        this.columnName = str;
        this.ascending = z;
    }
}
