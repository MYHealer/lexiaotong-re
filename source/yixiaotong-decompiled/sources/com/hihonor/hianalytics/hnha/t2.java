package com.hihonor.hianalytics.hnha;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.hihonor.hianalytics.util.SystemUtils;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class t2 {
    private static final int k = com.hihonor.hianalytics.util.b.a(2000, 6000);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s3 f3685a = new s3(new Runnable() { // from class: com.hihonor.hianalytics.hnha.t2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.b();
        }
    });
    private final List<n0> b = new LinkedList();
    private volatile long c = 0;
    private final Map<p0, Integer> d = new HashMap();
    private final Map<String, List<p0>> e = new HashMap();
    private volatile long f = 0;
    private int g = 0;
    private volatile String h = null;
    private volatile int i = 0;
    private volatile int j = 0;

    private synchronized Pair<Integer, Boolean> a(List<n0> list) {
        for (n0 n0Var : list) {
            if (n0Var != null) {
                this.b.add(n0Var);
            }
        }
        return Pair.create(Integer.valueOf(this.b.size()), Boolean.valueOf(c()));
    }

    private synchronized void a(int i) {
        long j = ((long) k) - SystemUtils.j();
        this.g++;
        j2.a("EventManager", "checkReportTask interval=" + j + ",reportType=" + i + ",addInterval=" + this.g);
        t3.a(this.f3685a);
        if (j <= 0 && this.g >= 3) {
            j = -1;
        } else if (j <= 0 || i == 2) {
            j = 200;
        }
        if (j > 0) {
            t3.a(this.f3685a, j);
        } else {
            b();
        }
    }

    private void a(String str, int i, String str2, int i2, int i3, Throwable th) {
        if (a()) {
            p2.g().a(str, i, str2, i2, i3, th);
        }
    }

    private void a(String str, int i, String str2, long j, String str3, int i2, int i3, Throwable th) {
        if (a()) {
            p2.g().a(str, i, str2, j, str3, i2, i3, th);
        }
    }

    private synchronized boolean a(p0 p0Var, int i) {
        if (i != 2) {
            return false;
        }
        try {
            int iC = p2.b().c(p0Var.b);
            if (iC == -1) {
                j2.a("EventManager", "checkCloudReportConfig config is null");
                return false;
            }
            List<p0> list = this.e.get(p0Var.b);
            if (list != null) {
                if (list.contains(p0Var)) {
                    return true;
                }
                list.add(p0Var);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(p0Var);
            this.e.put(p0Var.b, arrayList);
            t3.a(new s3(new v2(arrayList, i)), iC);
            return true;
        } catch (Throwable th) {
            j2.g("EventManager", "checkNeedDelayReportByCloudConfig reportType=" + i + ",failE=" + SystemUtils.getDesensitizedException(th));
            return false;
        }
    }

    private boolean a(String str, String str2) {
        return p2.d().a(str, str2);
    }

    private boolean a(String str, String str2, int i, int i2) {
        try {
            if (!a()) {
                return false;
            }
            boolean zB = p2.b().b(str);
            if (zB) {
                a(str2, i, str, i2, 10008, (Throwable) null);
            }
            return zB;
        } catch (Throwable th) {
            j2.g("EventManager", "checkIsBlackEvent eventId=" + str + " failE=" + SystemUtils.getDesensitizedException(th));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.g = 0;
        if (this.f <= 0 || jElapsedRealtime - this.f > 30000) {
            this.f = jElapsedRealtime;
            StringBuilder sbAppend = new StringBuilder().append(Process.myPid()).append("_cache_");
            int i = this.i + 1;
            this.i = i;
            this.h = sbAppend.append(i).toString();
            j2.a("EventManager", "checkToAddReportTask reportTaskId=" + this.h + ",millis=" + this.f);
            t3.b(new b3(this.h));
        }
    }

    private void c(List<n0> list) {
        if (a()) {
            p2.g().e(list);
        }
    }

    private boolean c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.c > 0 && jElapsedRealtime - this.c <= 5000) {
            return false;
        }
        this.c = jElapsedRealtime;
        t3.f(e());
        return true;
    }

    private void d() {
        try {
            if (this.e.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, List<p0>>> it = this.e.entrySet().iterator();
            while (it.hasNext()) {
                List<p0> value = it.next().getValue();
                if (value != null) {
                    value.clear();
                }
                it.remove();
            }
        } catch (Throwable th) {
            j2.g("EventManager", "clearDelayReportEvent failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    protected synchronized Pair<Integer, Boolean> a(n0 n0Var) {
        this.b.add(n0Var);
        return Pair.create(Integer.valueOf(this.b.size()), Boolean.valueOf(c()));
    }

    public synchronized List<n0> a(boolean z) {
        ArrayList arrayList;
        arrayList = new ArrayList(this.b);
        this.b.clear();
        if (z) {
            this.c = 0L;
        }
        return arrayList;
    }

    public synchronized void a(String str) {
        int size = this.d.size();
        if (Objects.equals(str, this.h)) {
            j2.a("EventManager", "notifyReportHandleEnd sameReportTaskId=" + str + ",millis=" + this.f + ",cacheSize=" + size);
            this.f = 0L;
        } else {
            j2.c("EventManager", "notifyReportHandleEnd notSameReportTaskId=" + str + ",nowTaskId=" + this.h + ",millis=" + this.f + ",cacheSize=" + size);
        }
        if (size > 0) {
            t3.a(this.f3685a);
            b();
        }
    }

    public synchronized void a(String str, int i, int i2) {
        String strA = p2.e().a(i2 == 2);
        if (!TextUtils.isEmpty(strA) && !"2G".equals(strA)) {
            j2.c("EventManager", "onReport tag=" + str + ",type=" + i + ",reportType=" + i2 + ",netWorkType=" + strA + ",isEncrypt=" + SystemUtils.m() + ",name=" + Thread.currentThread().getName() + ",initTime=" + k);
            p2.g().a(str, i, i2, MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND);
            Iterator<p0> it = this.d.keySet().iterator();
            do {
                if (!it.hasNext()) {
                    if (!TextUtils.isEmpty(str) && i < 0) {
                        boolean z = false;
                        for (int i3 = 0; i3 <= 3; i3++) {
                            z0 z0VarC = h.c(str, i3);
                            if (z0VarC != null && !TextUtils.isEmpty(z0VarC.d())) {
                                p0 p0VarA = j.a(str, i3);
                                if (a(p0VarA, i2)) {
                                    z = true;
                                } else {
                                    this.d.put(p0VarA, Integer.valueOf(i2));
                                }
                            }
                        }
                        if (!z) {
                            break;
                        } else {
                            return;
                        }
                    }
                    p0 p0VarA2 = j.a(str, i);
                    if (p0VarA2.e()) {
                        this.d.clear();
                        d();
                    } else if (a(p0VarA2, i2)) {
                        return;
                    }
                    this.d.put(p0VarA2, Integer.valueOf(i2));
                    break;
                }
            } while (!it.next().e());
            a(i2);
            return;
        }
        j2.e("EventManager", "onReportWithNetwork is bad,tag=" + str + ",type=" + i + ",reportType=" + i2 + ",netWorkType=" + strA + ",isEncrypt=" + SystemUtils.m() + ",name=" + Thread.currentThread().getName() + ",initTime=" + k);
        this.d.clear();
        t3.a(this.f3685a);
        p2.g().a(str, i, i2, 40002);
    }

    public void a(String str, int i, String str2, Map<String, String> map) {
        String str3;
        String str4;
        Map<String, String> linkedHashMap;
        int iA = com.hihonor.hianalytics.util.o.a("eventId", str2, 256);
        if (iA != 0) {
            int iD = com.hihonor.hianalytics.util.q.d(iA);
            j2.e("EventManager", "onEvent newTag2=" + str + ",type=" + i + ",code=" + iA + ",statType=" + iD + ",illegalEventId=" + str2);
            a(str, i, str2, 12, iD, (Throwable) null);
            return;
        }
        int iA2 = com.hihonor.hianalytics.util.o.a(str, i, h.c(str, i));
        if (iA2 != 0) {
            int iA3 = com.hihonor.hianalytics.util.q.a(iA2);
            j2.e("EventManager", "onEvent newTag2=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iA2 + ",statType=" + iA3 + ",illegalConfig");
            a(str, i, str2, 12, iA3, (Throwable) null);
            return;
        }
        if (a(str2, str, i, 12)) {
            j2.c("EventManager", "onEvent newTag2=" + str + ",type=" + i + ",eventId=" + str2 + " in blackEvent");
            return;
        }
        long jB = com.hihonor.hianalytics.util.r.b();
        if (2 == i) {
            jB = y1.a("yyyy-MM-dd", jB);
        }
        long j = jB;
        String strE = com.hihonor.hianalytics.util.r.e();
        int iD2 = com.hihonor.hianalytics.util.o.d(map);
        if (iD2 != 0) {
            int iB = com.hihonor.hianalytics.util.q.b(iD2);
            j2.e("EventManager", "onEvent newTag2=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iD2 + ",statType=" + iB + " with illegalMapValue");
            str3 = "onEvent newTag2=";
            a(str, i, str2, j, strE, 12, iB, null);
            linkedHashMap = null;
            str4 = ",eventId=";
        } else {
            str3 = "onEvent newTag2=";
            str4 = ",eventId=";
            j2.a("EventManager", str3 + str + ",type=" + i + str4 + str2 + " with normalValue");
            linkedHashMap = map;
        }
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put("ha_add_app_version", g.d());
        JSONObject jSONObjectA = com.hihonor.hianalytics.util.l.a(linkedHashMap);
        p2.f().a(str, i, str2, j, jSONObjectA);
        String string = jSONObjectA.toString();
        Pair<Integer, Boolean> pairA = a(new n0(str, i, str2, 12, j, strE, string));
        j2.c("EventManager", str3 + str + str4 + str2 + ",type=" + i + ",nowSize=" + pairA.first + ",isAddTask=" + pairA.second + ",size=" + jSONObjectA.length() + ",length=" + (string == null ? 0 : string.length()) + ",isEncrypt=" + SystemUtils.m());
        a(str, i, str2, j, strE, 12, 10000, null);
    }

    public void a(String str, int i, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        String str3;
        String str4;
        Map<String, String> linkedHashMap;
        int iA = com.hihonor.hianalytics.util.o.a("eventId", str2, 256);
        if (iA != 0) {
            int iD = com.hihonor.hianalytics.util.q.d(iA);
            j2.e("EventManager", "onEvent newTag3=" + str + ",type=" + i + ",code=" + iA + ",statType=" + iD + ",illegalEventId=" + str2);
            a(str, i, str2, 13, iD, (Throwable) null);
            return;
        }
        int iA2 = com.hihonor.hianalytics.util.o.a(str, i, h.c(str, i));
        if (iA2 != 0) {
            int iA3 = com.hihonor.hianalytics.util.q.a(iA2);
            j2.e("EventManager", "onEvent newTag3=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iA2 + ",statType=" + iA3 + ",illegalConfig");
            a(str, i, str2, 13, iA3, (Throwable) null);
            return;
        }
        if (a(str2, str, i, 13)) {
            j2.c("EventManager", "onEvent newTag3=" + str + ",type=" + i + ",eventId=" + str2 + " in blackEvent");
            return;
        }
        long jB = com.hihonor.hianalytics.util.r.b();
        if (2 == i) {
            jB = y1.a("yyyy-MM-dd", jB);
        }
        long j = jB;
        String strE = com.hihonor.hianalytics.util.r.e();
        Map<String, String> mapA = com.hihonor.hianalytics.util.o.a(map2);
        Map<String, String> mapA2 = com.hihonor.hianalytics.util.o.a(map3);
        int iD2 = com.hihonor.hianalytics.util.o.d(map);
        if (iD2 != 0) {
            int iB = com.hihonor.hianalytics.util.q.b(iD2);
            j2.e("EventManager", "onEvent newTag3=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iD2 + ",statType=" + iB + " with illegalMapValue");
            str3 = "onEvent newTag3=";
            a(str, i, str2, j, strE, 13, iB, null);
            linkedHashMap = null;
            str4 = ",eventId=";
        } else {
            str3 = "onEvent newTag3=";
            str4 = ",eventId=";
            j2.a("EventManager", str3 + str + ",type=" + i + str4 + str2 + " with normalMapValue");
            linkedHashMap = map;
        }
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put("ha_add_app_version", g.d());
        JSONObject jSONObjectA = com.hihonor.hianalytics.util.l.a(linkedHashMap);
        p2.f().a(str, i, str2, j, jSONObjectA);
        String string = jSONObjectA.toString();
        Pair<Integer, Boolean> pairA = a(new n0(str, i, str2, 13, j, strE, string, mapA, mapA2));
        j2.c("EventManager", str3 + str + str4 + str2 + ",type=" + i + ",nowSize=" + pairA.first + ",isAddTask=" + pairA.second + ",size=" + jSONObjectA.length() + ",length=" + (string == null ? 0 : string.length()) + ",isEncrypt=" + SystemUtils.m());
        a(str, i, str2, j, strE, 13, 10000, null);
    }

    public void a(String str, int i, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = ",eventId=";
        if (a(str2, str, i, 12)) {
            j2.c("EventManager", "onEvent newTag4=" + str + ",type=" + i + ",eventId=" + str2 + " in blackEvent");
            return;
        }
        long jB = com.hihonor.hianalytics.util.r.b();
        if (2 == i) {
            jB = y1.a("yyyy-MM-dd", jB);
        }
        long j = jB;
        String strE = com.hihonor.hianalytics.util.r.e();
        try {
            jSONObject.put("ha_add_app_version", g.d());
            p2.f().a(str, i, str2, j, jSONObject);
            String string = jSONObject.toString();
            str5 = ",type=";
            try {
                Pair<Integer, Boolean> pairA = a(new n0(str, i, str2, 12, j, strE, string));
                try {
                    try {
                        j2.c("EventManager", "onEvent newTag4=" + str + ",eventId=" + str2 + str5 + i + ",nowSize=" + pairA.first + ",isAddTask=" + pairA.second + ",size=" + jSONObject.length() + ",length=" + (string == null ? 0 : string.length()) + ",isEncrypt=" + SystemUtils.m());
                        str4 = "EventManager";
                        str3 = "onEvent newTag4=";
                        str6 = ",eventId=";
                        try {
                            a(str, i, str2, j, strE, 12, 10000, null);
                        } catch (JSONException e) {
                            e = e;
                            j2.g(str4, str3 + str + str6 + str2 + str5 + i + ",contentObj not json");
                            a(str, i, str2, j, strE, 12, 10007, e);
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        str4 = "EventManager";
                        str3 = "onEvent newTag4=";
                        str6 = ",eventId=";
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str3 = "onEvent newTag4=";
                    str4 = "EventManager";
                    j2.g(str4, str3 + str + str6 + str2 + str5 + i + ",contentObj not json");
                    a(str, i, str2, j, strE, 12, 10007, e);
                }
            } catch (JSONException e4) {
                e = e4;
                str3 = "onEvent newTag4=";
            }
        } catch (JSONException e5) {
            e = e5;
            str3 = "onEvent newTag4=";
            str6 = ",eventId=";
            str4 = "EventManager";
            str5 = ",type=";
        }
    }

    public void a(String str, String str2, String str3) {
        String str4;
        String str5;
        int iA = com.hihonor.hianalytics.util.o.a("eventId", str2, 256);
        if (iA != 0) {
            int iD = com.hihonor.hianalytics.util.q.d(iA);
            j2.e("EventManager", "onEvent newTag=" + str + ",code=" + iA + ",statType=" + iD + ",illegalEventId=" + str2);
            a(str, 0, str2, 11, iD, (Throwable) null);
            return;
        }
        int iA2 = com.hihonor.hianalytics.util.o.a(str, 0, h.c(str, 0));
        if (iA2 != 0) {
            int iA3 = com.hihonor.hianalytics.util.q.a(iA2);
            j2.e("EventManager", "onEvent newTag=" + str + ",eventId=" + str2 + ",code=" + iA2 + ",statType=" + iA3 + ",illegalConfig");
            a(str, 0, str2, 11, iA3, (Throwable) null);
            return;
        }
        if (a(str2, str, 0, 11)) {
            j2.c("EventManager", "onEvent newTag=" + str + ",eventId=" + str2 + " in blackEvent");
            return;
        }
        long jB = com.hihonor.hianalytics.util.r.b();
        String strE = com.hihonor.hianalytics.util.r.e();
        int iA4 = com.hihonor.hianalytics.util.o.a(oOOOoo00.OooOo0o, str3, 65536);
        if (iA4 != 0) {
            int iC = com.hihonor.hianalytics.util.q.c(iA4);
            j2.e("EventManager", "onEvent newTag=" + str + ",eventId=" + str2 + ",code=" + iA4 + ",statType=" + iC + " with overLenValue");
            str4 = ",eventId=";
            a(str, 0, str2, jB, strE, 11, iC, null);
            str5 = "";
        } else {
            str4 = ",eventId=";
            j2.a("EventManager", "onEvent newTag=" + str + str4 + str2 + " with normalValue");
            str5 = str3;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str5);
            jSONObject.put("ha_add_app_version", g.d());
            p2.f().a(str, 0, str2, jB, jSONObject);
            String string = jSONObject.toString();
            Pair<Integer, Boolean> pairA = a(new n0(str, 0, str2, 11, jB, strE, string));
            j2.c("EventManager", "onEvent newTag=" + str + str4 + str2 + ",nowSize=" + pairA.first + ",isAddTask=" + pairA.second + ",size=" + jSONObject.length() + ",length=" + (string == null ? 0 : string.length()) + ",isEncrypt=" + SystemUtils.m());
            a(str, 0, str2, jB, strE, 11, 10000, null);
        } catch (JSONException e) {
            j2.g("EventManager", "onEvent newTag=" + str + str4 + str2 + ",JSON structure Exception");
            a(str, 0, str2, jB, strE, 11, 10007, e);
        }
    }

    public synchronized void a(List<p0> list, int i) {
        if (list != null) {
            if (!list.isEmpty()) {
                for (p0 p0Var : list) {
                    if (p0Var != null) {
                        this.e.remove(p0Var.b);
                        this.d.put(p0Var, Integer.valueOf(i));
                    }
                }
                a(i);
                return;
            }
        }
        j2.a("EventManager", "delay list is null");
    }

    protected boolean a() {
        return true;
    }

    public boolean a(String str, int i) {
        int iA = k.a().a(j.a(str, i));
        j2.c("EventManager", "hasCachedData tag=" + str + ",type=" + i + ",eventCount=" + iA);
        return iA > 0;
    }

    public void b(String str, int i, String str2, Map<String, String> map) {
        String str3;
        String str4;
        Map<String, String> linkedHashMap;
        int iA = com.hihonor.hianalytics.util.o.a("eventId", str2, 256);
        if (iA != 0) {
            int iD = com.hihonor.hianalytics.util.q.d(iA);
            j2.e("EventManager", "onStreamEvent newTag=" + str + ",type=" + i + ",code=" + iA + ",statType=" + iD + ",illegalEventId=" + str2);
            a(str, i, str2, 1, iD, (Throwable) null);
            return;
        }
        int iA2 = com.hihonor.hianalytics.util.o.a(str, i, h.c(str, i));
        if (iA2 != 0) {
            int iA3 = com.hihonor.hianalytics.util.q.a(iA2);
            j2.e("EventManager", "onStreamEvent newTag=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iA2 + ",statType=" + iA3 + ",illegalConfig");
            a(str, i, str2, 1, iA3, (Throwable) null);
            return;
        }
        if (a(str2, str, i, 1)) {
            j2.c("EventManager", "onStreamEvent newTag=" + str + ",type=" + i + ",eventId=" + str2 + " in blackEvent");
            return;
        }
        long jB = com.hihonor.hianalytics.util.r.b();
        String strE = com.hihonor.hianalytics.util.r.e();
        int iD2 = com.hihonor.hianalytics.util.o.d(map);
        if (iD2 != 0) {
            int iB = com.hihonor.hianalytics.util.q.b(iD2);
            j2.e("EventManager", "onStreamEvent newTag=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iD2 + ",statType=" + iB + " with illegalMapValue");
            str3 = "onStreamEvent newTag=";
            a(str, i, str2, jB, strE, 1, iB, null);
            linkedHashMap = null;
            str4 = ",eventId=";
        } else {
            str3 = "onStreamEvent newTag=";
            str4 = ",eventId=";
            j2.a("EventManager", str3 + str + ",type=" + i + str4 + str2 + " with normalMapValue");
            linkedHashMap = map;
        }
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put("ha_add_app_version", g.d());
        JSONObject jSONObjectA = com.hihonor.hianalytics.util.l.a(linkedHashMap);
        p2.f().a(str, i, str2, jB, jSONObjectA);
        String string = jSONObjectA.toString();
        n0 n0Var = new n0(str, i, str2, 1, jB, strE, string);
        String str5 = str3;
        if (a(n0Var.d(), n0Var.l())) {
            j2.c("EventManager", str5 + str + ",type=" + i + str4 + str2 + ",isSuccess=" + b(n0Var) + ",size=" + jSONObjectA.length() + ",length=" + (string == null ? 0 : string.length()));
            a(str, i, str2, jB, strE, 1, 10000, null);
        } else {
            b(Collections.singletonList(n0Var));
            j2.c("EventManager", str5 + str + ",type=" + i + ",appId=" + n0Var.d() + " not allow report");
        }
    }

    public void b(String str, int i, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        String str3;
        String str4;
        Map<String, String> linkedHashMap;
        int iA = com.hihonor.hianalytics.util.o.a("eventId", str2, 256);
        if (iA != 0) {
            int iD = com.hihonor.hianalytics.util.q.d(iA);
            j2.e("EventManager", "onStreamEvent newTag2=" + str + ",type=" + i + ",code=" + iA + ",statType=" + iD + ",illegalEventId=" + str2);
            a(str, i, str2, 2, iD, (Throwable) null);
            return;
        }
        int iA2 = com.hihonor.hianalytics.util.o.a(str, i, h.c(str, i));
        if (iA2 != 0) {
            int iA3 = com.hihonor.hianalytics.util.q.a(iA2);
            j2.e("EventManager", "onStreamEvent newTag2=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iA2 + ",statType=" + iA3 + ",illegalConfig");
            a(str, i, str2, 2, iA3, (Throwable) null);
            return;
        }
        if (a(str2, str, i, 2)) {
            j2.c("EventManager", "onStreamEvent newTag2=" + str + ",type=" + i + ",eventId=" + str2 + " in blackEvent");
            return;
        }
        long jB = com.hihonor.hianalytics.util.r.b();
        String strE = com.hihonor.hianalytics.util.r.e();
        Map<String, String> mapA = com.hihonor.hianalytics.util.o.a(map2);
        Map<String, String> mapA2 = com.hihonor.hianalytics.util.o.a(map3);
        int iD2 = com.hihonor.hianalytics.util.o.d(map);
        if (iD2 != 0) {
            int iB = com.hihonor.hianalytics.util.q.b(iD2);
            j2.e("EventManager", "onStreamEvent newTag2=" + str + ",type=" + i + ",eventId=" + str2 + ",code=" + iD2 + ",statType=" + iB + " with illegalMapValue");
            str3 = "onStreamEvent newTag2=";
            a(str, i, str2, jB, strE, 2, iB, null);
            linkedHashMap = null;
            str4 = ",eventId=";
        } else {
            str3 = "onStreamEvent newTag2=";
            str4 = ",eventId=";
            j2.a("EventManager", str3 + str + ",type=" + i + str4 + str2 + " with normalMapValue");
            linkedHashMap = map;
        }
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put("ha_add_app_version", g.d());
        JSONObject jSONObjectA = com.hihonor.hianalytics.util.l.a(linkedHashMap);
        p2.f().a(str, i, str2, jB, jSONObjectA);
        String string = jSONObjectA.toString();
        n0 n0Var = new n0(str, i, str2, 2, jB, strE, string, mapA, mapA2);
        String str5 = str3;
        if (a(n0Var.d(), n0Var.l())) {
            j2.c("EventManager", str5 + str + ",type=" + i + str4 + str2 + ",isSuccess=" + b(n0Var) + ",size=" + jSONObjectA.length() + ",length=" + (string == null ? 0 : string.length()));
            a(str, i, str2, jB, strE, 2, 10000, null);
        } else {
            b(Collections.singletonList(n0Var));
            j2.c("EventManager", str5 + str + ",type=" + i + ",appId=" + n0Var.d() + " not allow report");
        }
    }

    public void b(List<n0> list) {
        int size = list == null ? 0 : list.size();
        Pair<Integer, Boolean> pairA = size > 0 ? a(list) : Pair.create(Integer.valueOf(this.b.size()), Boolean.FALSE);
        if (size > 0) {
            c(list);
        }
        j2.c("EventManager", "onEventList eventSize=" + size + ",nowSize=" + pairA.first + ",isAddTask=" + pairA.second + ",isEncrypt=" + SystemUtils.m());
    }

    protected boolean b(n0 n0Var) {
        n0Var.z();
        if (!n0Var.y()) {
            return false;
        }
        synchronized (this) {
            StringBuilder sbAppend = new StringBuilder().append(Process.myPid()).append("_stream_");
            int i = this.j + 1;
            this.j = i;
            t3.f(new c3(sbAppend.append(i).toString(), n0Var, 1));
        }
        return true;
    }

    protected r3 e() {
        return new a3();
    }

    public synchronized Map<p0, Integer> f() {
        HashMap map;
        map = new HashMap(this.d);
        this.d.clear();
        return map;
    }
}
