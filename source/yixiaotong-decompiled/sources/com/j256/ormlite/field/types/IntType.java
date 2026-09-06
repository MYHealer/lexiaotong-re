package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class IntType extends IntegerObjectType {
    private static final IntType singleTon = new IntType();

    public static IntType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    private IntType() {
        super(SqlType.INTEGER, new Class[]{Integer.TYPE});
    }

    protected IntType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
