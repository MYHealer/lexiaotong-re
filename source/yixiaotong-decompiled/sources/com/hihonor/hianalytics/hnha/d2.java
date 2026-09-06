package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class d2 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<h2> f3632a = new LinkedList<>();

    private void a(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (string != null && b(string)) {
                c(string);
            }
        }
    }

    private boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.split(",").length == 3;
        }
        j2.c("HianalyticsSDK", "event data is empty");
        return false;
    }

    private void c(String str) {
        String[] strArrSplit = str.split(",");
        String strReplace = strArrSplit[0].replace("^", ",");
        String strReplace2 = strArrSplit[1].replace("^", ",");
        Long lA = f2.a(strArrSplit[2]);
        if (TextUtils.isEmpty(strReplace) || lA.longValue() == -1) {
            return;
        }
        this.f3632a.add(new h2(strReplace, strReplace2, lA.longValue()));
    }

    @Override // com.hihonor.hianalytics.hnha.b2
    public void a(String str) {
        j2.c("V1EventsAdapter", "onReport: will report " + this.f3632a.size() + " events.");
        LinkedList linkedList = new LinkedList();
        Iterator<h2> it = this.f3632a.iterator();
        while (it.hasNext()) {
            n0 n0VarA = a2.a(it.next(), str);
            if (n0VarA != null) {
                linkedList.add(n0VarA);
            }
        }
        p2.c().b(linkedList);
        a2.b(str);
        this.f3632a.clear();
    }

    @Override // com.hihonor.hianalytics.hnha.b2
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.isNull("termination") ? new JSONArray() : jSONObject.getJSONArray("termination");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("e")) {
                    a(jSONObjectOptJSONObject.optJSONArray("e"));
                }
            }
        } catch (JSONException unused) {
            j2.b("V1EventsAdapter", "Exception occurred in parsing file data.");
        }
    }

    @Override // com.hihonor.hianalytics.hnha.b2
    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str3 : str.split(";")) {
            if (b(str3)) {
                c(str3);
            }
        }
    }
}
