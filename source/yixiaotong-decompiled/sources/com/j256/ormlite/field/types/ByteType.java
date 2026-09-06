package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ByteType extends ByteObjectType {
    private static final ByteType singleTon = new ByteType();

    public static ByteType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    private ByteType() {
        super(SqlType.BYTE, new Class[]{Byte.TYPE});
    }

    protected ByteType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
