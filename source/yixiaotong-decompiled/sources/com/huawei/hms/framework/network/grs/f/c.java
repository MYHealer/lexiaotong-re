package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.ads.ld;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c extends a {
    public c(Context context, boolean z) {
        this.e = z;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.d = true;
        }
    }

    private List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString(ld.L));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add((String) jSONArray.get(i));
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return new ArrayList();
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int a(String str) {
        this.f4044a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(MimeTypes.BASE_TYPE_APPLICATION);
            String string = jSONObject.getString("name");
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f4044a.b(string);
            this.f4044a.a(j);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        JSONObject jSONObject;
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() == 0) {
                return 0;
            }
            this.b.addAll(a(jSONObject));
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x010a A[Catch: JSONException -> 0x011d, TryCatch #0 {JSONException -> 0x011d, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0024, B:8:0x003a, B:10:0x0043, B:11:0x0056, B:13:0x005c, B:15:0x006d, B:21:0x0084, B:22:0x009a, B:24:0x00a0, B:26:0x00b4, B:28:0x00ba, B:30:0x00cb, B:16:0x0072, B:18:0x0078, B:19:0x007d, B:31:0x00df, B:33:0x00ea, B:37:0x00f9, B:39:0x0103, B:41:0x010a, B:42:0x0111, B:34:0x00ef, B:36:0x00f5, B:38:0x00fe), top: B:48:0x000c }] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    public int e(String str) {
        JSONObject jSONObject;
        String string;
        String str2 = "countryGroup";
        String str3 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject("services");
            Iterator<String> itKeys = jSONObject2.keys();
            while (true) {
                int i = 0;
                if (!itKeys.hasNext()) {
                    return 0;
                }
                String next = itKeys.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(next);
                if (!this.f.contains(next)) {
                    this.f.add(next);
                    if (this.e) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        cVar.c(jSONObject3.getString("routeBy"));
                        JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                        while (i < jSONArray.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray.get(i);
                            com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                            if (jSONObject4.has(str3)) {
                                string = jSONObject4.getString(str3);
                            } else if (jSONObject4.has(str2)) {
                                string = jSONObject4.getString(str2);
                            } else {
                                Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                string = "no-country";
                            }
                            dVar.a(string);
                            JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                            String str4 = str2;
                            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                            Iterator<String> itKeys2 = jSONObject5.keys();
                            while (itKeys2.hasNext()) {
                                itKeys2 = itKeys2;
                                String next2 = itKeys2.next();
                                String string2 = jSONObject5.getString(next2);
                                if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(string2)) {
                                    concurrentHashMap.put(next2, jSONObject5.getString(next2));
                                    str3 = str3;
                                }
                            }
                            dVar.a(concurrentHashMap);
                            cVar.a(dVar.b(), dVar);
                            i++;
                            str2 = str4;
                            str3 = str3;
                        }
                        String str5 = str2;
                        String str6 = str3;
                        List<com.huawei.hms.framework.network.grs.local.model.b> listA = null;
                        if (jSONObject3.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                        } else {
                            if (jSONObject3.has("countryGroups")) {
                                jSONObject = jSONObject3.getJSONObject("countryGroups");
                            } else {
                                Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                            }
                            cVar.a(listA);
                            if (this.f4044a == null) {
                                this.f4044a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.f4044a.a(next, cVar);
                            str2 = str5;
                            str3 = str6;
                        }
                        listA = a((JSONArray) null, jSONObject);
                        cVar.a(listA);
                        if (this.f4044a == null) {
                            this.f4044a = new com.huawei.hms.framework.network.grs.local.model.a();
                        }
                        this.f4044a.a(next, cVar);
                        str2 = str5;
                        str3 = str6;
                    }
                }
            }
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }
}
