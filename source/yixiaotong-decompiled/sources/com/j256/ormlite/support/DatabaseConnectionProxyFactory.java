package com.j256.ormlite.support;

import java.sql.SQLException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface DatabaseConnectionProxyFactory {
    DatabaseConnection createProxy(DatabaseConnection databaseConnection) throws SQLException;
}
