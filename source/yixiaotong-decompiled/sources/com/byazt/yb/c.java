package com.byazt.yb;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.sq.uj;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 894, 20})
public class c {
    public final com.byazt.ue.c c = new com.byazt.ue.c(new com.byazt.xm.c("csj_mediation"));
    public uj.c tt;

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        uj.c cVarC = c(uri);
        if (cVarC != null) {
            return cVarC.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public String getType(Uri uri) {
        uj.c cVarC = c(uri);
        if (cVarC != null) {
            return cVarC.getType(uri);
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        uj.c cVarC = c(uri);
        if (cVarC != null) {
            return cVarC.insert(uri, contentValues);
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        uj.c cVarC = c(uri);
        if (cVarC != null) {
            return cVarC.delete(uri, str, strArr);
        }
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        uj.c cVarC = c(uri);
        if (cVarC != null) {
            return cVarC.update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private uj.c c(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            com.byazt.eu.tt.c("TTMediationSDK", "uri is error2");
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            com.byazt.eu.tt.c("TTMediationSDK", "uri is error3");
            return null;
        }
        if (this.tt == null) {
            ve veVar = new ve();
            this.tt = veVar;
            veVar.init();
        }
        if (str.equals(this.tt.getTableName())) {
            return this.tt;
        }
        if (str.equals(this.c.getTableName())) {
            return this.c;
        }
        com.byazt.eu.tt.c("TTMediationSDK", "uri is error4");
        return null;
    }
}
