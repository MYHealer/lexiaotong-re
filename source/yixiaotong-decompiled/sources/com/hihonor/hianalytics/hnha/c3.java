package com.hihonor.hianalytics.hnha;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.hianalytics.util.SystemUtils;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.opos.acs.st.utils.ErrorContants;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class c3 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3631a;
    private final List<n0> b;
    private final Set<n0> c;
    private final Set<n0> d;
    private final Map<Integer, Set<n0>> e;
    private final boolean f;
    private List<h3> g;
    private final int h;
    private String i;
    private String j;
    private int k;
    private String l;
    private String m;
    private int n;
    private int o;
    private final List<String> p;
    private final List<n0> q;
    private final List<h3> r;
    private int s;
    private boolean t;

    public c3(String str, n0 n0Var, int i) {
        LinkedList linkedList = new LinkedList();
        this.b = linkedList;
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashMap();
        this.p = new LinkedList();
        this.q = new LinkedList();
        this.r = new LinkedList();
        this.s = 0;
        this.t = true;
        this.f3631a = str;
        linkedList.add(n0Var);
        this.h = i;
        this.f = false;
        i();
    }

    public c3(String str, List<n0> list, int i) {
        this.b = new LinkedList();
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashMap();
        this.p = new LinkedList();
        this.q = new LinkedList();
        this.r = new LinkedList();
        this.s = 0;
        this.t = true;
        this.f3631a = str;
        for (n0 n0Var : list) {
            if (n0Var != null) {
                this.b.add(n0Var);
            }
        }
        this.h = i;
        this.f = false;
        i();
    }

    public c3(String str, List<n0> list, List<h3> list2, int i) {
        this.b = new LinkedList();
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashMap();
        this.p = new LinkedList();
        this.q = new LinkedList();
        this.r = new LinkedList();
        this.s = 0;
        this.t = true;
        this.f3631a = str;
        for (n0 n0Var : list) {
            if (n0Var != null) {
                this.b.add(n0Var);
            }
        }
        this.g = list2;
        this.h = i;
        this.f = true;
        i();
    }

    private Map<j0, Map<String, Map<String, List<n0>>>> a() {
        Map map;
        HashMap map2 = new HashMap();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            n0 n0Var = this.b.get(i);
            j0 j0VarJ = n0Var.j();
            String strS = n0Var.s();
            if (strS == null || strS.isEmpty()) {
                strS = "requestIdMapDefault";
            }
            Map map3 = (Map) map2.get(j0VarJ);
            String str = j0VarJ.o().e.c;
            List linkedList = null;
            if (map3 == null) {
                map3 = new HashMap();
                map2.put(j0VarJ, map3);
                map = null;
            } else {
                map = (Map) map3.get(str);
            }
            if (map == null) {
                map = new HashMap();
                map3.put(str, map);
            } else {
                linkedList = (List) map.get(strS);
            }
            if (linkedList == null) {
                linkedList = new LinkedList();
                map.put(strS, linkedList);
            }
            linkedList.add(n0Var);
        }
        return map2;
    }

    private void a(int i, List<n0> list, boolean z) {
        if (list.isEmpty()) {
            return;
        }
        Set<n0> hashSet = this.e.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.e.put(Integer.valueOf(i), hashSet);
        }
        hashSet.addAll(list);
        if (z) {
            for (Map.Entry<Integer, Set<n0>> entry : this.e.entrySet()) {
                if (entry.getKey().intValue() != i) {
                    Set<n0> value = entry.getValue();
                    Iterator<n0> it = list.iterator();
                    while (it.hasNext()) {
                        value.remove(it.next());
                    }
                }
            }
        }
    }

    private void a(n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.c)) {
            return;
        }
        String str = nVar.c;
        j2.a("NewEventSendTask", "response.content:" + str);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull("configVersion")) {
                if (p2.b().a(jSONObjectOptJSONObject.toString())) {
                    u.a("analyticsCloudConfigInfo", jSONObjectOptJSONObject.toString());
                    Intent intent = new Intent();
                    intent.setAction("com.hihonor.hianalytics.config.action.DATA_CHANGED");
                    intent.setPackage(g.p());
                    com.hihonor.hianalytics.receiver.a.a(SystemUtils.getApp(), intent);
                    p2.b().n();
                    this.t = p2.d().i();
                    return;
                }
                return;
            }
            j2.a("NewEventSendTask", "checkResponseData ，dataObject is null");
        } catch (Exception e) {
            j2.b("NewEventSendTask", "checkResponseData e:" + SystemUtils.getDesensitizedException(e));
        }
    }

    private void a(JSONObject jSONObject, j0 j0Var, String str, String str2, List<n0> list) throws JSONException {
        String str3;
        byte[] bArrA;
        List<n0> listSingletonList;
        int i;
        JSONObject jSONObject2 = jSONObject.getJSONObject("header");
        JSONObject jSONObject3 = jSONObject.getJSONObject("events_common");
        jSONObject.remove("events_common");
        p0 p0VarO = j0Var.o();
        String str4 = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "") + com.huawei.openalliance.ad.constant.x.A + this.h + com.huawei.openalliance.ad.constant.x.A + p0VarO.b + com.huawei.openalliance.ad.constant.x.A + p0VarO.c + com.huawei.openalliance.ad.constant.x.A + list.size();
        String str5 = !"requestIdMapDefault".equals(str2) ? str2 : str4 + ErrorContants.NET_NO_CALLBACK;
        Pair<String, String> pairB = k.c().b(this.i, str5);
        if (pairB != null) {
            str3 = (String) pairB.first;
            jSONObject2.put("protocol_version", "2");
            jSONObject2.put("deviceinfo_hash", pairB.second);
        } else {
            Pair<String, String> pairD = k.c().d();
            String str6 = (String) pairD.first;
            if ("requestIdMapDefault".equals(str2)) {
                str5 = str4 + "-1";
            }
            jSONObject2.put("protocol_version", "1");
            jSONObject2.put("chifer", pairD.second);
            str3 = str6;
        }
        if (this.f) {
            jSONObject2.put("appid", this.i);
            jSONObject2.put("servicetag", "hianalytics_sdk_tag");
        }
        this.p.add(str5);
        jSONObject2.put("requestid", str5);
        Pair<Long, String> pairA = k.c().a(this.i, jSONObject3.optString(Constant.MAP_KEY_UUID, ""));
        if (pairA != null) {
            jSONObject2.put(com.alipay.sdk.tid.b.f, String.valueOf(pairA.first));
            jSONObject2.put("hmac", pairA.second);
        }
        jSONObject3.put("processName", str);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("events_common", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        Iterator<n0> it = list.iterator();
        while (it.hasNext()) {
            n0 next = it.next();
            if ("requestIdMapDefault".equals(str2)) {
                this.q.add(next);
            }
            next.e(str5);
            JSONObject jSONObject5 = new JSONObject();
            Iterator<n0> it2 = it;
            try {
                jSONObject5.put("type", this.l);
                jSONObject5.put("eventtime", String.valueOf(next.m()));
                jSONObject5.put("eventtimezone", next.n());
                jSONObject5.put(NotificationCompat.CATEGORY_EVENT, next.i());
                jSONObject5.put("event_session_name", next.t());
                jSONObject5.put("first_session_event", next.v());
                try {
                    try {
                        jSONObject5.put("properties", new JSONObject(next.h()));
                        jSONArray.put(jSONObject5);
                    } catch (Throwable th) {
                        j2.g("NewEventSendTask", "fillBodyAttrs errorEvent=" + next + ",e=" + SystemUtils.getDesensitizedException(th));
                        listSingletonList = Collections.singletonList(next);
                        i = 34001;
                        a(i, listSingletonList, false);
                        this.d.add(next);
                    }
                } catch (Throwable th2) {
                    j2.g("NewEventSendTask", "fillBodyAttrs errorEvent=" + next + ",contentJsonFormatFailE=" + SystemUtils.getDesensitizedException(th2));
                    listSingletonList = Collections.singletonList(next);
                    i = 34000;
                }
            } catch (Throwable th3) {
                j2.g("NewEventSendTask", "fillBodyAttrs errorEvent=" + next + ",jsonPutFailE=" + SystemUtils.getDesensitizedException(th3));
                listSingletonList = Collections.singletonList(next);
                i = 34002;
            }
            it = it2;
        }
        if (jSONArray.length() <= 0) {
            throw new JSONException("eventData empty");
        }
        if (this.f && this.g != null && "requestIdMapDefault".equals(str2)) {
            for (h3 h3Var : this.g) {
                if ("requestIdMapDefault".equals(h3Var.d())) {
                    h3Var.b(str5);
                    this.r.add(h3Var);
                }
            }
        }
        jSONObject4.put("events", jSONArray);
        String strA = null;
        try {
            bArrA = com.hihonor.hianalytics.util.k.a(jSONObject4.toString().getBytes(i.f3644a));
        } catch (Throwable th4) {
            j2.g("NewEventSendTask", "fillBodyAttrs zipDataFailE=" + SystemUtils.getDesensitizedException(th4));
            bArrA = null;
        }
        if (bArrA == null || bArrA.length == 0) {
            a(34003, list, true);
            throw new JSONException("eventData zipFail");
        }
        try {
            strA = k.c().a(bArrA, str3);
        } catch (Throwable th5) {
            j2.g("NewEventSendTask", "fillBodyAttrs encryptNetDataFailE=" + SystemUtils.getDesensitizedException(th5));
        }
        if (TextUtils.isEmpty(strA)) {
            a(str5.endsWith("2") ? 34005 : 34004, list, true);
            throw new JSONException("eventData null");
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, strA);
    }

    private void a(boolean z) {
        int iB = k.a().b(this.b, z);
        this.s = iB;
        if (iB <= 0 || !z) {
            com.hihonor.hianalytics.util.h.e();
            com.hihonor.hianalytics.util.h.b();
        } else {
            g();
            com.hihonor.hianalytics.util.h.f(this.b.size());
            com.hihonor.hianalytics.util.h.b(this.d.size());
        }
    }

    private void a(boolean z, n nVar) {
        if (this.f) {
            b(z);
        } else if (this.h == 1) {
            c(z);
        } else {
            a(z);
        }
        b(nVar);
        a(nVar);
    }

    private String b() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.b.size()).append(",").append(this.s).append(",").append(this.f).append(",").append(e()).append(",").append(this.d.size());
        if (!this.c.isEmpty()) {
            sb.append(",sendEventRegion=").append(com.hihonor.hianalytics.util.g.a(new LinkedList(this.c)));
        }
        if (!this.d.isEmpty()) {
            sb.append(",errorEventRegion=").append(com.hihonor.hianalytics.util.g.a(new LinkedList(this.d)));
        }
        sb.append(",idsValue=(").append(this.i).append(",").append(this.f3631a);
        return sb.append(")").toString();
    }

    private void b(n nVar) {
        if (nVar == null || !nVar.c()) {
            return;
        }
        p2.d().a(this.i, nVar.b());
    }

    private void b(boolean z) {
        com.hihonor.hianalytics.util.h.e();
        com.hihonor.hianalytics.util.h.b();
        if (h()) {
            this.s = k.a().c(this.g, z);
        }
    }

    private Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("App-Id", this.i);
        map.put("App-Ver", g.d());
        map.put("Sdk-Name", "hianalytics");
        map.put("Sdk-Ver", "1.0.5.300");
        map.put("Device-Type", Build.MODEL);
        if (SystemUtils.o()) {
            map.put("isEncrypt", ez.V);
        }
        map.put("Request-Id", this.m);
        map.put("Data-Ver", "1");
        map.put("Pkg-Name", g.p());
        map.put("Config-Ver", this.n + "");
        map.put("Device-Group", String.valueOf(this.o));
        j2.a("NewEventSendTask", "headerMap:" + map);
        return map;
    }

    private void c(boolean z) {
        int i;
        com.hihonor.hianalytics.util.h.e();
        com.hihonor.hianalytics.util.h.b();
        if (z) {
            g();
            return;
        }
        for (n0 n0Var : this.b) {
            int iW = n0Var.w();
            if (iW == 1) {
                i = 12;
            } else if (iW == 2) {
                i = 13;
            }
            n0Var.a(i);
        }
        p2.c().b(this.b);
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        int size = this.p.size();
        sb.append(size + 1).append("(").append(this.m).append(",");
        int i = 0;
        while (i < size) {
            sb.append(this.p.get(i));
            sb.append(i == size + (-1) ? ")" : ",");
            i++;
        }
        return sb.toString();
    }

    private int e() {
        List<h3> list = this.g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private String f() {
        if (TextUtils.isEmpty(this.j)) {
            return "(none)";
        }
        try {
            Uri uri = Uri.parse(this.j);
            String scheme = uri.getScheme();
            int port = uri.getPort();
            String str = "";
            if ("https".equalsIgnoreCase(scheme)) {
                StringBuilder sbAppend = new StringBuilder("(ssss,").append(uri.getHost());
                if (port != 443) {
                    str = "," + port;
                }
                return sbAppend.append(str).append(")").toString();
            }
            if ("http".equalsIgnoreCase(scheme)) {
                StringBuilder sbAppend2 = new StringBuilder("(nsss,").append(uri.getHost());
                if (port != 443) {
                    str = "," + port;
                }
                return sbAppend2.append(str).append(")").toString();
            }
            StringBuilder sbAppend3 = new StringBuilder("(").append(scheme).append(",").append(uri.getHost());
            if (port != 443) {
                str = "," + port;
            }
            return sbAppend3.append(str).append(")").toString();
        } catch (Throwable th) {
            j2.a("NewEventSendTask", "getUrlDesc failE=" + SystemUtils.getDesensitizedException(th));
            return "(fail)";
        }
    }

    private void g() {
        if (this.f) {
            return;
        }
        this.c.removeAll(this.d);
        p2.g().a(new LinkedList(this.c), KSImageLoader.InnerImageLoadingListener.MAX_DURATION, null);
        if (this.d.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet(this.d);
        for (Map.Entry<Integer, Set<n0>> entry : this.e.entrySet()) {
            Set<n0> value = entry.getValue();
            if (!value.isEmpty()) {
                p2.g().a(new LinkedList(value), entry.getKey().intValue(), null);
                Iterator<n0> it = value.iterator();
                while (it.hasNext()) {
                    hashSet.remove(it.next());
                }
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        p2.g().a(new LinkedList(hashSet), ErrorCode.AD_SLOT_ID_EMPTY, null);
    }

    private boolean h() {
        return e() > 0;
    }

    private void i() {
        if (this.b.isEmpty()) {
            j2.a("NewEventSendTask", "initUnifyParams eventList is empty");
            return;
        }
        n0 n0Var = this.b.get(0);
        j0 j0VarJ = n0Var.j();
        this.i = j0VarJ.c();
        this.j = j0VarJ.p();
        int iO = n0Var.o();
        this.k = iO;
        this.l = com.hihonor.hianalytics.util.g.a(iO);
    }

    private void j() {
        if (this.f) {
            k.a().e(this.r);
        } else {
            k.a().d(this.q);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        int iA;
        boolean z;
        n nVar;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Set<n0> set;
        String str10 = ",configVersion=";
        String str11 = ",eventDesc=";
        String str12 = ",reportType=";
        String str13 = ",type=";
        String str14 = ",reportableState=";
        String str15 = ",isAutoEventReport=";
        String str16 = ",collectUrl=";
        String str17 = "NewEventSendTask";
        String str18 = ",";
        long jA = 0;
        try {
            jA = com.hihonor.hianalytics.util.r.a();
            try {
                this.t = p2.d().i();
                str = ",groupNum=";
                try {
                    iA = p2.d().a(this.i);
                    boolean z2 = iA >= 0 && iA <= 3;
                    try {
                        if (this.k == 2 && z2) {
                            try {
                                if (g.q().length == 0) {
                                    new q1(SystemUtils.getContext()).a();
                                }
                            } catch (Throwable th) {
                                th = th;
                                str2 = "NewEventSendTask";
                                str12 = ",reportType=";
                                str13 = ",type=";
                                str = str;
                                str10 = str10;
                                str11 = ",eventDesc=";
                                z = false;
                                nVar = null;
                                str16 = ",collectUrl=";
                                jA = jA;
                                jA = jA;
                                a(z, nVar);
                                j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                            }
                        }
                        try {
                            jA = com.hihonor.hianalytics.util.r.a() - jA;
                            com.hihonor.hianalytics.util.h.c();
                            com.hihonor.hianalytics.util.h.d();
                            com.hihonor.hianalytics.util.h.a();
                            if (!z2) {
                                a(false, null);
                                j2.e("NewEventSendTask", "data send result=failBySwitch,time=(" + com.hihonor.hianalytics.util.r.b(jA) + "," + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),eventDesc=" + b() + ",collectUrl=" + f() + ",isAutoEventReport=" + this.t + ",reportableState=" + iA + ",type=" + this.k + ",reportType=" + this.h);
                                return;
                            }
                            if (this.b.isEmpty()) {
                                z = false;
                                try {
                                    a(false, null);
                                    j2.a("NewEventSendTask", "data send result=failByNoStat,time=(" + com.hihonor.hianalytics.util.r.b(jA) + "," + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),eventDesc=" + b() + ",collectUrl=" + f() + ",isAutoEventReport=" + this.t + ",reportableState=" + iA + ",type=" + this.k + ",reportType=" + this.h);
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    str2 = "NewEventSendTask";
                                    str12 = ",reportType=";
                                    str13 = ",type=";
                                    str15 = ",isAutoEventReport=";
                                    str = str;
                                    str11 = ",eventDesc=";
                                    nVar = null;
                                    str16 = ",collectUrl=";
                                    str14 = ",reportableState=";
                                    jA = jA;
                                    jA = jA;
                                    str10 = str10;
                                }
                            } else {
                                Map<j0, Map<String, Map<String, List<n0>>>> mapA = a();
                                this.m = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "") + com.huawei.openalliance.ad.constant.x.A + com.hihonor.hianalytics.util.r.a("yyyyMMddHHmmss") + com.huawei.openalliance.ad.constant.x.A + this.h;
                                this.n = p2.b().d();
                                this.o = p2.d().d();
                                Map<String, String> mapC = c();
                                JSONObject jSONObject = new JSONObject();
                                JSONArray jSONArray = new JSONArray();
                                jSONObject.put("data", jSONArray);
                                for (Map.Entry<j0, Map<String, Map<String, List<n0>>>> entry : mapA.entrySet()) {
                                    try {
                                        j0 key = entry.getKey();
                                        for (Map.Entry<String, Map<String, List<n0>>> entry2 : entry.getValue().entrySet()) {
                                            for (Map.Entry<String, List<n0>> entry3 : entry2.getValue().entrySet()) {
                                                List<n0> value = entry3.getValue();
                                                try {
                                                    try {
                                                        JSONObject jSONObject2 = new JSONObject(key.g());
                                                        try {
                                                            mapC = mapC;
                                                            jSONArray = jSONArray;
                                                            jSONObject = jSONObject;
                                                            str12 = str12;
                                                            str18 = str18;
                                                            str17 = str17;
                                                            str13 = str13;
                                                            str16 = str16;
                                                            try {
                                                                a(jSONObject2, key, entry2.getKey(), entry3.getKey(), value);
                                                                jSONArray.put(jSONObject2);
                                                                value = value;
                                                                try {
                                                                    this.c.addAll(value);
                                                                } catch (Throwable th3) {
                                                                    th = th3;
                                                                    try {
                                                                        j2.g(str17, "data send otherFailE=" + SystemUtils.getDesensitizedException(th));
                                                                        set = this.d;
                                                                        set.addAll(value);
                                                                    } catch (Throwable th4) {
                                                                        th = th4;
                                                                        str2 = str17;
                                                                        str14 = ",reportableState=";
                                                                        str15 = ",isAutoEventReport=";
                                                                        jA = jA;
                                                                        jA = jA;
                                                                        str = str;
                                                                        str10 = str10;
                                                                        str11 = ",eventDesc=";
                                                                        str13 = str13;
                                                                        str18 = str18;
                                                                    }
                                                                }
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                value = value;
                                                            }
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            jSONObject = jSONObject;
                                                            str18 = str18;
                                                            str12 = str12;
                                                            str13 = str13;
                                                            value = value;
                                                            str17 = str17;
                                                            str16 = str16;
                                                            mapC = mapC;
                                                            jSONArray = jSONArray;
                                                        }
                                                    } catch (JSONException e) {
                                                        e = e;
                                                        value = value;
                                                        j2.g(str17, "data send idsJsonFailE=" + SystemUtils.getDesensitizedException(e));
                                                        a(34006, value, true);
                                                        set = this.d;
                                                        set.addAll(value);
                                                        jSONArray = jSONArray;
                                                        str17 = str17;
                                                        str16 = str16;
                                                        jSONObject = jSONObject;
                                                        mapC = mapC;
                                                        str13 = str13;
                                                        str12 = str12;
                                                        str18 = str18;
                                                    }
                                                } catch (JSONException e2) {
                                                    e = e2;
                                                }
                                                jSONArray = jSONArray;
                                                str17 = str17;
                                                str16 = str16;
                                                jSONObject = jSONObject;
                                                mapC = mapC;
                                                str13 = str13;
                                                str12 = str12;
                                                str18 = str18;
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        str12 = str12;
                                        str5 = str13;
                                        str16 = str16;
                                        str2 = str17;
                                        str14 = ",reportableState=";
                                        str15 = ",isAutoEventReport=";
                                        str = str;
                                        str10 = str10;
                                        str11 = ",eventDesc=";
                                        str13 = str5;
                                    }
                                }
                                JSONObject jSONObject3 = jSONObject;
                                String str19 = str18;
                                Map<String, String> map = mapC;
                                str12 = str12;
                                String str20 = str13;
                                str4 = str17;
                                str16 = str16;
                                try {
                                    if (this.c.isEmpty()) {
                                        try {
                                            a(false, null);
                                            str18 = str19;
                                            try {
                                                str11 = ",eventDesc=";
                                                try {
                                                    str10 = str10;
                                                    try {
                                                        str8 = str;
                                                        try {
                                                            str9 = str20;
                                                            try {
                                                                try {
                                                                    j2.e(str4, "data send result=failByEmpty,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str8 + this.o + ",isAutoEventReport=" + this.t + ",reportableState=" + iA + str9 + this.k + str12 + this.h);
                                                                    return;
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    str12 = str12;
                                                                    str2 = str4;
                                                                    z = false;
                                                                    nVar = null;
                                                                    str = str8;
                                                                    str13 = str9;
                                                                    jA = jA;
                                                                    jA = jA;
                                                                    a(z, nVar);
                                                                    j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                }
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                str2 = str4;
                                                                z = false;
                                                                nVar = null;
                                                                str = str8;
                                                                str13 = str9;
                                                                jA = jA;
                                                                jA = jA;
                                                                a(z, nVar);
                                                                j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                            }
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            str9 = str20;
                                                            str2 = str4;
                                                            z = false;
                                                            nVar = null;
                                                            str = str8;
                                                            str13 = str9;
                                                            jA = jA;
                                                            jA = jA;
                                                            a(z, nVar);
                                                            j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                        }
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        str8 = str;
                                                    }
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    str8 = str;
                                                    str10 = str10;
                                                }
                                            } catch (Throwable th13) {
                                                th = th13;
                                                str8 = str;
                                                str10 = str10;
                                                str11 = ",eventDesc=";
                                            }
                                        } catch (Throwable th14) {
                                            th = th14;
                                            str8 = str;
                                            str10 = str10;
                                            str11 = ",eventDesc=";
                                            str9 = str20;
                                            str18 = str19;
                                        }
                                    } else {
                                        String str21 = str;
                                        str10 = str10;
                                        str11 = ",eventDesc=";
                                        str18 = str19;
                                        try {
                                            long jA2 = (com.hihonor.hianalytics.util.r.a() - jA) - jA;
                                            byte[] bytes = jSONObject3.toString().getBytes(i.f3644a);
                                            byte[] bArrA = com.hihonor.hianalytics.util.k.a(bytes);
                                            long jA3 = ((com.hihonor.hianalytics.util.r.a() - jA) - jA) - jA2;
                                            j();
                                            str2 = str4;
                                            try {
                                                str12 = str12;
                                                try {
                                                    str5 = str20;
                                                    try {
                                                        try {
                                                            n nVarA = k.b().a(new m(this.j, map, this.k, bArrA));
                                                            long jA4 = (((com.hihonor.hianalytics.util.r.a() - jA) - jA) - jA2) - jA3;
                                                            if (this.f) {
                                                                str21 = str21;
                                                                str6 = ",reportableState=";
                                                                str7 = ",isAutoEventReport=";
                                                            } else {
                                                                try {
                                                                    str6 = ",reportableState=";
                                                                    try {
                                                                        str7 = ",isAutoEventReport=";
                                                                        try {
                                                                            str21 = str21;
                                                                            try {
                                                                                p2.g().a(this.i, this.j, this.k, this.h, nVarA.d, com.hihonor.hianalytics.util.r.c(jA4));
                                                                            } catch (Throwable th15) {
                                                                                th = th15;
                                                                                iA = iA;
                                                                                str14 = str6;
                                                                                str15 = str7;
                                                                                str = str21;
                                                                                str13 = str5;
                                                                                z = false;
                                                                                nVar = null;
                                                                                a(z, nVar);
                                                                                j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                            }
                                                                        } catch (Throwable th16) {
                                                                            th = th16;
                                                                            str21 = str21;
                                                                        }
                                                                    } catch (Throwable th17) {
                                                                        th = th17;
                                                                        str7 = ",isAutoEventReport=";
                                                                        iA = iA;
                                                                        str14 = str6;
                                                                        str15 = str7;
                                                                        str = str21;
                                                                        str13 = str5;
                                                                        z = false;
                                                                        nVar = null;
                                                                        a(z, nVar);
                                                                        j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                    }
                                                                } catch (Throwable th18) {
                                                                    th = th18;
                                                                    str6 = ",reportableState=";
                                                                }
                                                            }
                                                            try {
                                                                a(nVarA.d(), nVarA);
                                                                StringBuilder sbAppend = new StringBuilder().append("data send result=").append(nVarA.d()).append(",time=(").append(com.hihonor.hianalytics.util.r.b(jA)).append(str18).append(com.hihonor.hianalytics.util.r.b(jA2)).append(str18).append(com.hihonor.hianalytics.util.r.b(jA3)).append(str18).append(com.hihonor.hianalytics.util.r.b(jA4)).append(str18).append(com.hihonor.hianalytics.util.r.b(((((com.hihonor.hianalytics.util.r.a() - jA) - jA) - jA2) - jA3) - jA4)).append("),reqID=").append(d()).append(str11).append(b()).append(",srcDataLen=").append(bytes.length).append(",compressDataLen=").append(bArrA.length).append(",response=").append(nVarA).append(str16).append(f()).append(str10).append(this.n);
                                                                str = str21;
                                                                try {
                                                                    str15 = str7;
                                                                    try {
                                                                        str14 = str6;
                                                                        try {
                                                                            iA = iA;
                                                                            try {
                                                                                str13 = str5;
                                                                                try {
                                                                                    str3 = str12;
                                                                                    try {
                                                                                        str4 = str2;
                                                                                        try {
                                                                                            j2.e(str4, sbAppend.append(str).append(this.o).append(str15).append(this.t).append(str14).append(iA).append(str13).append(this.k).append(str3).append(this.h).toString());
                                                                                            return;
                                                                                        } catch (Throwable th19) {
                                                                                            th = th19;
                                                                                        }
                                                                                    } catch (Throwable th20) {
                                                                                        th = th20;
                                                                                        str12 = str3;
                                                                                        jA = jA;
                                                                                        jA = jA;
                                                                                        z = false;
                                                                                        nVar = null;
                                                                                        a(z, nVar);
                                                                                        j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                                    }
                                                                                } catch (Throwable th21) {
                                                                                    th = th21;
                                                                                    jA = jA;
                                                                                    jA = jA;
                                                                                    z = false;
                                                                                    nVar = null;
                                                                                    a(z, nVar);
                                                                                    j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                                }
                                                                            } catch (Throwable th22) {
                                                                                th = th22;
                                                                                str13 = str5;
                                                                                jA = jA;
                                                                                jA = jA;
                                                                                z = false;
                                                                                nVar = null;
                                                                                a(z, nVar);
                                                                                j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                            }
                                                                        } catch (Throwable th23) {
                                                                            th = th23;
                                                                            iA = iA;
                                                                            str13 = str5;
                                                                            jA = jA;
                                                                            jA = jA;
                                                                            z = false;
                                                                            nVar = null;
                                                                            a(z, nVar);
                                                                            j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                        }
                                                                    } catch (Throwable th24) {
                                                                        th = th24;
                                                                        iA = iA;
                                                                        str14 = str6;
                                                                        str13 = str5;
                                                                        jA = jA;
                                                                        jA = jA;
                                                                        z = false;
                                                                        nVar = null;
                                                                        a(z, nVar);
                                                                        j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
                                                                    }
                                                                } catch (Throwable th25) {
                                                                    th = th25;
                                                                    iA = iA;
                                                                    str14 = str6;
                                                                    str15 = str7;
                                                                }
                                                            } catch (Throwable th26) {
                                                                th = th26;
                                                                iA = iA;
                                                                str14 = str6;
                                                                str15 = str7;
                                                                str = str21;
                                                            }
                                                        } catch (Throwable th27) {
                                                            th = th27;
                                                            str = str21;
                                                            str14 = ",reportableState=";
                                                            str15 = ",isAutoEventReport=";
                                                        }
                                                    } catch (Throwable th28) {
                                                        th = th28;
                                                        str = str21;
                                                        str14 = ",reportableState=";
                                                        str15 = ",isAutoEventReport=";
                                                    }
                                                } catch (Throwable th29) {
                                                    th = th29;
                                                    str = str21;
                                                    str13 = str20;
                                                    str14 = ",reportableState=";
                                                    str15 = ",isAutoEventReport=";
                                                }
                                            } catch (Throwable th30) {
                                                th = th30;
                                                str = str21;
                                                str3 = str12;
                                                str15 = ",isAutoEventReport=";
                                                str13 = str20;
                                                str14 = ",reportableState=";
                                            }
                                        } catch (Throwable th31) {
                                            th = th31;
                                            str = str21;
                                            str3 = str12;
                                            str15 = ",isAutoEventReport=";
                                            str13 = str20;
                                            str14 = ",reportableState=";
                                        }
                                    }
                                } catch (Throwable th32) {
                                    th = th32;
                                    str14 = ",reportableState=";
                                    str15 = ",isAutoEventReport=";
                                    str = str;
                                    str10 = str10;
                                    str11 = ",eventDesc=";
                                    str13 = str20;
                                    str18 = str19;
                                    str2 = str4;
                                }
                            }
                        } catch (Throwable th33) {
                            th = th33;
                            str3 = str12;
                            str13 = str13;
                            str11 = ",eventDesc=";
                            str4 = str17;
                            str16 = str16;
                            str14 = ",reportableState=";
                            str15 = ",isAutoEventReport=";
                        }
                    } catch (Throwable th34) {
                        th = th34;
                        str11 = ",eventDesc=";
                        str3 = ",reportType=";
                        str13 = ",type=";
                    }
                    str12 = str3;
                    str2 = str4;
                    jA = jA;
                    jA = jA;
                } catch (Throwable th35) {
                    th = th35;
                    str = str;
                    str12 = ",reportType=";
                    str2 = "NewEventSendTask";
                    jA = jA;
                    iA = 0;
                }
            } catch (Throwable th36) {
                th = th36;
                str = ",groupNum=";
            }
        } catch (Throwable th37) {
            th = th37;
            str = ",groupNum=";
            str10 = ",configVersion=";
            str11 = ",eventDesc=";
            str13 = ",type=";
            str12 = ",reportType=";
            str2 = "NewEventSendTask";
        }
        z = false;
        nVar = null;
        a(z, nVar);
        j2.e(str2, "data send result=failByError,time=(" + com.hihonor.hianalytics.util.r.b(jA) + str18 + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA) + "),reqID=" + d() + str11 + b() + str16 + f() + str10 + this.n + str + this.o + str15 + this.t + str14 + iA + str13 + this.k + str12 + this.h + ",e=" + SystemUtils.getDesensitizedException(th));
    }
}
