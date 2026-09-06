package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TimeStampType extends DateType {
    private static final TimeStampType singleTon = new TimeStampType();

    public static TimeStampType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return obj;
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return obj;
    }

    private TimeStampType() {
        super(SqlType.DATE, new Class[]{Timestamp.class});
    }

    protected TimeStampType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType() == Timestamp.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return new Timestamp(jCurrentTimeMillis);
        }
        if (jCurrentTimeMillis == ((Timestamp) obj).getTime()) {
            return new Timestamp(jCurrentTimeMillis + 1);
        }
        return new Timestamp(jCurrentTimeMillis);
    }
}
