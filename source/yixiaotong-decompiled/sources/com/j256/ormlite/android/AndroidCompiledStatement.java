package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.j256.ormlite.android.compat.ApiCompatibility;
import com.j256.ormlite.android.compat.ApiCompatibilityUtils;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AndroidCompiledStatement implements CompiledStatement {
    private List<Object> args;
    private final boolean cancelQueriesEnabled;
    private ApiCompatibility.CancellationHook cancellationHook;
    private Cursor cursor;
    private final SQLiteDatabase db;
    private Integer max;
    private final String sql;
    private final StatementBuilder.StatementType type;
    private static Logger logger = LoggerFactory.getLogger((Class<?>) AndroidCompiledStatement.class);
    private static final String[] NO_STRING_ARGS = new String[0];
    private static final ApiCompatibility apiCompatibility = ApiCompatibilityUtils.getCompatibility();

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setQueryTimeout(long j) {
    }

    public AndroidCompiledStatement(String str, SQLiteDatabase sQLiteDatabase, StatementBuilder.StatementType statementType, boolean z) {
        this.sql = str;
        this.db = sQLiteDatabase;
        this.type = statementType;
        this.cancelQueriesEnabled = z;
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int getColumnCount() throws SQLException {
        return getCursor().getColumnCount();
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public String getColumnName(int i) throws SQLException {
        return getCursor().getColumnName(i);
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public DatabaseResults runQuery(ObjectCache objectCache) throws SQLException {
        if (!this.type.isOkForQuery()) {
            throw new IllegalArgumentException("Cannot call query on a " + this.type + " statement");
        }
        return new AndroidDatabaseResults(getCursor(), objectCache);
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runUpdate() throws SQLException {
        if (!this.type.isOkForUpdate()) {
            throw new IllegalArgumentException("Cannot call update on a " + this.type + " statement");
        }
        return execSql(this.db, "runUpdate", this.max == null ? this.sql : this.sql + PPSLabelView.Code + this.max, getArgArray());
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runExecute() throws SQLException {
        if (!this.type.isOkForExecute()) {
            throw new IllegalArgumentException("Cannot call execute on a " + this.type + " statement");
        }
        return execSql(this.db, "runExecute", this.sql, getArgArray());
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void close() throws SQLException {
        Cursor cursor = this.cursor;
        if (cursor != null) {
            try {
                cursor.close();
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("Problems closing Android cursor", e);
            }
        }
        this.cancellationHook = null;
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void cancel() {
        ApiCompatibility.CancellationHook cancellationHook = this.cancellationHook;
        if (cancellationHook != null) {
            cancellationHook.cancel();
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setObject(int i, Object obj, SqlType sqlType) throws SQLException {
        isInPrep();
        if (this.args == null) {
            this.args = new ArrayList();
        }
        if (obj == null) {
            this.args.add(i, null);
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                this.args.add(i, obj.toString());
                return;
            case 12:
            case 13:
                this.args.add(i, obj);
                return;
            case 14:
            case 15:
                throw new SQLException("Invalid Android type: " + sqlType);
            default:
                throw new SQLException("Unknown sql argument type: " + sqlType);
        }
    }

    /* JADX INFO: renamed from: com.j256.ormlite.android.AndroidCompiledStatement$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setMaxRows(int i) throws SQLException {
        isInPrep();
        this.max = Integer.valueOf(i);
    }

    public Cursor getCursor() throws SQLException {
        if (this.cursor == null) {
            String str = null;
            try {
                str = this.max == null ? this.sql : this.sql + PPSLabelView.Code + this.max;
                if (this.cancelQueriesEnabled) {
                    this.cancellationHook = apiCompatibility.createCancellationHook();
                }
                Cursor cursorRawQuery = apiCompatibility.rawQuery(this.db, str, getStringArray(), this.cancellationHook);
                this.cursor = cursorRawQuery;
                cursorRawQuery.moveToFirst();
                logger.trace("{}: started rawQuery cursor for: {}", this, str);
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("Problems executing Android query: " + str, e);
            }
        }
        return this.cursor;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    static int execSql(SQLiteDatabase sQLiteDatabase, String str, String str2, Object[] objArr) throws SQLException {
        int iSimpleQueryForLong;
        try {
            sQLiteDatabase.execSQL(str2, objArr);
            SQLiteStatement sQLiteStatementCompileStatement = null;
            try {
                sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("SELECT CHANGES()");
                iSimpleQueryForLong = (int) sQLiteStatementCompileStatement.simpleQueryForLong();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
            } catch (android.database.SQLException unused) {
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                iSimpleQueryForLong = 1;
            } catch (Throwable th) {
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                throw th;
            }
            logger.trace("executing statement {} changed {} rows: {}", str, Integer.valueOf(iSimpleQueryForLong), str2);
            return iSimpleQueryForLong;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("Problems executing " + str + " Android statement: " + str2, e);
        }
    }

    private void isInPrep() throws SQLException {
        if (this.cursor != null) {
            throw new SQLException("Query already run. Cannot add argument values.");
        }
    }

    private Object[] getArgArray() {
        List<Object> list = this.args;
        return list == null ? NO_STRING_ARGS : list.toArray(new Object[list.size()]);
    }

    private String[] getStringArray() {
        List<Object> list = this.args;
        return list == null ? NO_STRING_ARGS : (String[]) list.toArray(new String[list.size()]);
    }
}
