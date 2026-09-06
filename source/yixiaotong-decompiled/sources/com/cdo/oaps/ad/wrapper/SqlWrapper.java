package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SqlWrapper extends BaseWrapper {
    public static final String KEY_DATA = "bkd";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3133a = "bkd_md5";
    private static final String c = "sql_rs";

    protected SqlWrapper(Map<String, Object> map) {
        super(map);
    }

    public static SqlWrapper wrapper(Map<String, Object> map) {
        return new SqlWrapper(map);
    }

    public byte[] getData() {
        try {
            return (byte[]) get(KEY_DATA);
        } catch (ag unused) {
            return null;
        }
    }

    public String getDataMd5() {
        try {
            return (String) get(f3133a);
        } catch (ag unused) {
            return "";
        }
    }

    public String getResult() {
        try {
            return (String) get(c);
        } catch (ag unused) {
            return "";
        }
    }

    public SqlWrapper setData(byte[] bArr) {
        return (SqlWrapper) set(KEY_DATA, bArr);
    }

    public SqlWrapper setDataMd5(String str) {
        return (SqlWrapper) set(f3133a, str);
    }

    public SqlWrapper setResult(String str) {
        return (SqlWrapper) set(c, str);
    }
}
