package com.byazt.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.br;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 34, 54})
public class ve extends c {
    public final JSONObject uj;

    public ve(Context context, com.byazt.k.c cVar, String str, JSONObject jSONObject) {
        super(context, cVar, str);
        this.uj = jSONObject;
    }

    @Override // com.byazt.a.n
    public Intent tt() {
        String strOptString = this.uj.optString("action");
        String strOptString2 = this.uj.optString(com.huawei.openalliance.ad.constant.x.cy);
        int iOptInt = this.uj.optInt(br.f.z, 1342210048);
        String strOptString3 = this.uj.optString("path_extra_key");
        String strOptString4 = this.uj.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.uj.optJSONObject("extra");
        JSONObject jSONObjectOptJSONObject2 = this.uj.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.ve)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.ve);
        }
        c(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void c(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                c(jSONObject, next, strOptString, intent);
            }
        }
    }

    private static void c(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}
