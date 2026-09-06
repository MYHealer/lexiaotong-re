package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1819a;
    private String b;

    public int a() {
        return this.f1819a;
    }

    public String b() {
        return this.b;
    }

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    n nVarA = a(jSONArray.getJSONObject(i));
                    if (nVarA != null) {
                        arrayList.add(new CpuChannelResponse(nVarA));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static n a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("id", -1);
        String strOptString = jSONObject.optString("name", "");
        if (iOptInt == -1 || TextUtils.isEmpty(strOptString)) {
            return null;
        }
        n nVar = new n();
        nVar.f1819a = iOptInt;
        nVar.b = strOptString;
        return nVar;
    }
}
