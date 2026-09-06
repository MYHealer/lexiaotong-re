package com.byazt.ds;

import android.content.Context;
import com.umeng.analytics.pro.am;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 67})
public class u extends ve {
    public final Context n;

    public u(Context context) {
        super(true, true);
        this.n = context;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        i.c(jSONObject, am.Q, com.byazt.yv.n.c(this.n));
        return true;
    }
}
