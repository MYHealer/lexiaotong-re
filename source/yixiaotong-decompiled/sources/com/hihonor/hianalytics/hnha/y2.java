package com.hihonor.hianalytics.hnha;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.hihonor.hianalytics.support.HaHelpUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class y2 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n0> f3698a = new LinkedList();
    private final List<n0> b = new LinkedList();
    private final Map<n0, Pair<JSONObject, JSONObject>> c = new HashMap();
    private n0 d = null;
    private n0 e = null;
    private final Set<p0> f = new HashSet();

    private void a() {
        try {
            Iterator<n0> it = this.f3698a.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            j2.c("NewEventDirectBootRecordTask", "handleEvent success");
        } catch (Throwable th) {
            j2.g("NewEventDirectBootRecordTask", "handleEvent failE=" + HaHelpUtils.getDesensitizedException(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(n0 n0Var) {
        n0Var.a(true).z();
    }

    private void a(StringBuilder sb) {
        boolean z;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        do {
            try {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                z = true;
                i++;
                if (jElapsedRealtime2 - jElapsedRealtime > -1 || i > 50) {
                    z = false;
                }
                List<n0> listA = p2.c().a(!z);
                long jElapsedRealtime3 = 20;
                if (!listA.isEmpty()) {
                    sb.append(listA.size()).append(",");
                    this.f3698a.addAll(listA);
                    for (final n0 n0Var : listA) {
                        t3.d(new r3() { // from class: com.hihonor.hianalytics.hnha.y2$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                y2.a(n0Var);
                            }
                        });
                    }
                    jElapsedRealtime3 = 20 - (SystemClock.elapsedRealtime() - jElapsedRealtime2);
                }
                if (z) {
                    if (jElapsedRealtime3 <= 0) {
                        jElapsedRealtime3 = 1;
                    }
                    com.hihonor.hianalytics.util.k.a(jElapsedRealtime3);
                }
            } catch (Throwable th) {
                j2.g("NewEventDirectBootRecordTask", "readCacheEvent failE=" + HaHelpUtils.getDesensitizedException(th));
                return;
            }
        } while (z);
        sb.append(")");
    }

    private void b() {
        try {
            for (int size = this.f3698a.size() - 1; size >= 0; size--) {
                n0 n0Var = this.f3698a.get(size);
                try {
                    JSONObject jSONObjectK = n0Var.j().k();
                    if (jSONObjectK != null) {
                        jSONObjectK = new JSONObject(jSONObjectK.toString());
                    }
                    JSONObject jSONObjectF = n0Var.j().f();
                    if (jSONObjectF != null) {
                        jSONObjectF = new JSONObject(jSONObjectF.toString());
                    }
                    this.c.put(n0Var, Pair.create(jSONObjectK, jSONObjectF));
                } catch (JSONException e) {
                    j2.g("NewEventDirectBootRecordTask", "preDealEvent json failE=" + HaHelpUtils.getDesensitizedException(e));
                }
                n0Var.a(true).z();
                int iR = n0Var.r();
                if (iR != 0) {
                    j2.g("NewEventDirectBootRecordTask", "preDealEvent illegal legalState=" + iR + ",event=" + n0Var);
                    this.f3698a.remove(size);
                    this.b.add(n0Var);
                } else {
                    c(n0Var);
                }
            }
        } catch (Throwable th) {
            j2.g("NewEventDirectBootRecordTask", "preDealEvent failE=" + HaHelpUtils.getDesensitizedException(th));
        }
    }

    private boolean b(n0 n0Var) {
        JSONArray jSONArray;
        String str;
        String string;
        if (com.hihonor.hianalytics.util.e.a() >= ((long) g.t()) * 1048576) {
            j2.g("NewEventDirectBootRecordTask", "recordEvent over limit size");
            return false;
        }
        String strL = n0Var.l();
        String strI = n0Var.i();
        int iO = n0Var.o();
        String strA = com.hihonor.hianalytics.util.e.a(strL, iO);
        String strA2 = u.a("sp_name_direct_boot_event", true, strA, "");
        int iLastIndexOf = strA2 != null ? strA2.lastIndexOf(93) : -1;
        if (TextUtils.isEmpty(strA2)) {
            j2.a("NewEventDirectBootRecordTask", "saveEvent eventsEmptyWithEventTag=" + strL + ",isNewMode=,eventId=" + strI + ",eventDataType=" + iO);
            jSONArray = new JSONArray();
        } else if (iLastIndexOf < 0) {
            try {
                jSONArray = new JSONArray(strA2);
            } catch (JSONException unused) {
                j2.g("NewEventDirectBootRecordTask", "saveEvent eventsNotJsonWithEventTag=" + strL + ",isNewMode=,eventId=" + strI + ",eventDataType=" + iO);
                jSONArray = new JSONArray();
            }
        } else {
            jSONArray = null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, strI);
            jSONObject.put("event_migration_content", n0Var.e());
            try {
                jSONObject.put("eventtime", n0Var.m());
                jSONObject.put("type", iO);
                jSONObject.put("event_session_name", n0Var.t());
                jSONObject.put("event_migration_session_state", n0Var.u());
                try {
                    Pair<JSONObject, JSONObject> pair = this.c.get(n0Var);
                    if (pair != null) {
                        jSONObject.put("headerEx", pair.first);
                        jSONObject.put("commonEx", pair.second);
                    }
                    if (jSONArray != null) {
                        jSONArray.put(jSONObject);
                        string = jSONArray.toString();
                    } else {
                        string = strA2.substring(0, iLastIndexOf) + "," + jSONObject + "]";
                    }
                    u.a("sp_name_direct_boot_event", true, strA, string);
                    String str2 = "saveEvent finish=" + strL + ",eventId=" + strI + ",eventDataType=" + iO;
                    str = "NewEventDirectBootRecordTask";
                    try {
                        j2.a(str, str2);
                        return false;
                    } catch (Exception e) {
                        e = e;
                        j2.b(str, "saveEvent:" + HaHelpUtils.getDesensitizedException(e));
                        return false;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = "NewEventDirectBootRecordTask";
                    j2.b(str, "saveEvent:" + HaHelpUtils.getDesensitizedException(e));
                    return false;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            str = "NewEventDirectBootRecordTask";
        }
    }

    private void c(n0 n0Var) {
        n0 n0Var2 = this.d;
        if (n0Var2 == null || n0Var2.m() < n0Var.m()) {
            this.d = n0Var;
        }
        n0 n0Var3 = this.e;
        if (n0Var3 == null || n0Var3.m() > n0Var.m()) {
            this.e = n0Var;
        }
        this.f.add(n0Var.x());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.hihonor.hianalytics.util.r.a();
            a(new StringBuilder().append("("));
            com.hihonor.hianalytics.util.r.a();
            b();
            com.hihonor.hianalytics.util.r.a();
            if (this.f3698a.isEmpty()) {
                j2.b("NewEventDirectBootRecordTask", "doneEventList is empty");
            } else {
                a();
            }
        } catch (Throwable th) {
            j2.e("NewEventDirectBootRecordTask", "recordEvent failE=" + HaHelpUtils.getDesensitizedException(th));
        }
    }
}
