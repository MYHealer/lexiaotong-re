package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DoubleType extends DoubleObjectType {
    private static final DoubleType singleTon = new DoubleType();

    public static DoubleType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    private DoubleType() {
        super(SqlType.DOUBLE, new Class[]{Double.TYPE});
    }

    protected DoubleType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
