package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3618a;
    private List<b> b;
    private a c;
    private List<c> d;

    public static class a {
        private Boolean d;
        private Boolean g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3619a = -1;
        private int b = -1;
        private int c = -1;
        private int e = -1;
        private int f = -1;

        public Boolean a() {
            return this.g;
        }

        public void a(int i) {
            this.f3619a = i;
        }

        public void a(Boolean bool) {
            this.g = bool;
        }

        public Boolean b() {
            return this.d;
        }

        public void b(int i) {
            this.c = i;
        }

        public void b(Boolean bool) {
            this.d = bool;
        }

        public int c() {
            return this.f3619a;
        }

        public void c(int i) {
            this.b = i;
        }

        public int d() {
            return this.c;
        }

        public void d(int i) {
            this.f = i;
        }

        public int e() {
            return this.b;
        }

        public void e(int i) {
            this.e = i;
        }

        public int f() {
            return this.f;
        }

        public int g() {
            return this.e;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f3620a;
        private long b = -1;
        private long c = -1;

        public List<String> a() {
            return this.f3620a;
        }

        public void a(long j) {
            this.c = j;
        }

        public void a(List<String> list) {
            this.f3620a = list;
        }

        public long b() {
            return this.c;
        }

        public void b(long j) {
            this.b = j;
        }

        public long c() {
            return this.b;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3621a;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private int e = -1;

        public int a() {
            return this.d;
        }

        public void a(int i) {
            this.d = i;
        }

        public void a(String str) {
            this.f3621a = str;
        }

        public int b() {
            return this.e;
        }

        public void b(int i) {
            this.e = i;
        }

        public int c() {
            return this.b;
        }

        public void c(int i) {
            this.b = i;
        }

        public int d() {
            return this.c;
        }

        public void d(int i) {
            this.c = i;
        }

        public String e() {
            return this.f3621a;
        }
    }

    public static a1 a(String str) {
        a1 a1Var = new a1();
        if (TextUtils.isEmpty(str)) {
            return a1Var;
        }
        JSONObject jSONObject = new JSONObject(str);
        a1Var.a(jSONObject.optInt("configVersion"));
        if (!jSONObject.isNull("eventConfig")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("eventConfig");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    b bVar = new b();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("blackEvents");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            int length2 = jSONArrayOptJSONArray2.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                            }
                            bVar.a(arrayList2);
                        }
                        if (!jSONObjectOptJSONObject.isNull("disableStartTime")) {
                            bVar.b(jSONObjectOptJSONObject.optLong("disableStartTime"));
                        }
                        if (!jSONObjectOptJSONObject.isNull("disableEndTime")) {
                            bVar.a(jSONObjectOptJSONObject.optLong("disableEndTime"));
                        }
                        arrayList.add(bVar);
                    }
                }
            }
            a1Var.a(arrayList);
        }
        if (!jSONObject.isNull("appConfig")) {
            a aVar = new a();
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("appConfig");
            if (jSONObjectOptJSONObject2 != null) {
                if (!jSONObjectOptJSONObject2.isNull("maxTotalStorage")) {
                    aVar.a(jSONObjectOptJSONObject2.optInt("maxTotalStorage"));
                }
                if (!jSONObjectOptJSONObject2.isNull("periodReportTime")) {
                    aVar.c(jSONObjectOptJSONObject2.optInt("periodReportTime"));
                }
                if (!jSONObjectOptJSONObject2.isNull("periodReportRandomTime")) {
                    aVar.b(jSONObjectOptJSONObject2.optInt("periodReportRandomTime"));
                }
                if (!jSONObjectOptJSONObject2.isNull("backgroundReportSwitch")) {
                    aVar.b(Boolean.valueOf(jSONObjectOptJSONObject2.optBoolean("backgroundReportSwitch")));
                }
                if (!jSONObjectOptJSONObject2.isNull("saveEventDelayMillis")) {
                    aVar.e(jSONObjectOptJSONObject2.optInt("saveEventDelayMillis"));
                }
                if (!jSONObjectOptJSONObject2.isNull("realtimeErrorReport")) {
                    aVar.d(jSONObjectOptJSONObject2.optInt("realtimeErrorReport"));
                }
                if (!jSONObjectOptJSONObject2.isNull("isAutoEventOpen")) {
                    aVar.a(Boolean.valueOf(jSONObjectOptJSONObject2.optBoolean("isAutoEventOpen")));
                }
                a1Var.a(aVar);
            }
        }
        if (!jSONObject.isNull("tagConfig")) {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("tagConfig");
            ArrayList arrayList3 = new ArrayList();
            if (jSONArrayOptJSONArray3 != null) {
                int length3 = jSONArrayOptJSONArray3.length();
                for (int i3 = 0; i3 < length3; i3++) {
                    c cVar = new c();
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    if (jSONObjectOptJSONObject3 != null) {
                        if (!jSONObjectOptJSONObject3.isNull("tag")) {
                            cVar.a(jSONObjectOptJSONObject3.optString("tag"));
                        }
                        if (!jSONObjectOptJSONObject3.isNull("singleReportEventNum")) {
                            cVar.c(jSONObjectOptJSONObject3.optInt("singleReportEventNum"));
                        }
                        if (!jSONObjectOptJSONObject3.isNull("singleReportStorage")) {
                            cVar.d(jSONObjectOptJSONObject3.optInt("singleReportStorage"));
                        }
                        if (!jSONObjectOptJSONObject3.isNull("activeReportLimitPeriod")) {
                            cVar.a(jSONObjectOptJSONObject3.optInt("activeReportLimitPeriod"));
                        }
                        if (!jSONObjectOptJSONObject3.isNull("monitorReportLimitPeriod")) {
                            cVar.b(jSONObjectOptJSONObject3.optInt("monitorReportLimitPeriod"));
                        }
                        arrayList3.add(cVar);
                    }
                }
            }
            a1Var.b(arrayList3);
        }
        return a1Var;
    }

    public a a() {
        return this.c;
    }

    public void a(int i) {
        this.f3618a = i;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(List<b> list) {
        this.b = list;
    }

    public int b() {
        return this.f3618a;
    }

    public void b(List<c> list) {
        this.d = list;
    }

    public List<b> c() {
        return this.b;
    }

    public List<c> d() {
        return this.d;
    }
}
