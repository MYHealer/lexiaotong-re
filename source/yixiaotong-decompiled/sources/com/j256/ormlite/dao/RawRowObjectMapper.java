package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import java.sql.SQLException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface RawRowObjectMapper<T> {
    T mapRow(String[] strArr, DataType[] dataTypeArr, Object[] objArr) throws SQLException;
}
