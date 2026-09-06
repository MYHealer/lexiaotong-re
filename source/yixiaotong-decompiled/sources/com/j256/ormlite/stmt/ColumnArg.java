package com.j256.ormlite.stmt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ColumnArg {
    private final String columnName;
    private final String tableName;

    public String getColumnName() {
        return this.columnName;
    }

    public String getTableName() {
        return this.tableName;
    }

    public ColumnArg(String str) {
        this.tableName = null;
        this.columnName = str;
    }

    public ColumnArg(String str, String str2) {
        this.tableName = str;
        this.columnName = str2;
    }
}
