package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class FloatType extends FloatObjectType {
    private static final FloatType singleTon = new FloatType();

    public static FloatType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    private FloatType() {
        super(SqlType.FLOAT, new Class[]{Float.TYPE});
    }

    protected FloatType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
