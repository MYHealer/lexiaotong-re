package com.ubix.ssp.ad.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f8618a;
    private b b;
    private ConcurrentHashMap<String, JSONObject> c = new ConcurrentHashMap<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8619a = 1;
        public long b;
    }

    static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ConcurrentHashMap<String, JSONObject> f8620a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String string = new JSONObject(b.this.f8620a).toString();
                u.e("save result=" + string);
                v.b(com.ubix.ssp.ad.e.a0.c.e(), "ubix_sp_store", "reqInfo", string);
            }
        }

        public b(ConcurrentHashMap<String, JSONObject> concurrentHashMap) {
            super(Looper.getMainLooper());
            new ConcurrentHashMap();
            this.f8620a = concurrentHashMap;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                com.ubix.ssp.ad.e.a0.c.y();
                com.ubix.ssp.ad.e.a0.c.d.execute(new a());
            }
        }
    }

    private k() {
        if (com.ubix.ssp.ad.e.b.a("slot_req_info")) {
            String strD = v.d(com.ubix.ssp.ad.e.a0.c.e(), "ubix_sp_store", "reqInfo");
            if (!TextUtils.isEmpty(strD)) {
                try {
                    JSONObject jSONObject = new JSONObject(strD);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        this.c.put(next, jSONObject.getJSONObject(next));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.b = new b(this.c);
        }
    }

    public static synchronized k a() {
        if (f8618a == null) {
            f8618a = new k();
        }
        return f8618a;
    }

    public a a(String str) {
        String str2;
        try {
            a aVar = new a();
            if (!com.ubix.ssp.ad.e.b.a("slot_req_info")) {
                aVar.f8619a = 0;
                aVar.b = 0L;
                return aVar;
            }
            if (!this.c.containsKey(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    aVar.f8619a = 1;
                    aVar.b = 0L;
                    jSONObject.put("lt", System.currentTimeMillis());
                    jSONObject.put("rq", 1);
                    this.c.put(str, jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return aVar;
            }
            JSONObject jSONObject2 = this.c.get(str);
            if (jSONObject2 == null) {
                return null;
            }
            long jOptLong = jSONObject2.optLong("lt", 0L);
            if (jOptLong != 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(jOptLong);
                str2 = calendar.get(1) + "/" + calendar.get(2) + "/" + calendar.get(5);
                aVar.b = System.currentTimeMillis() - jOptLong;
            } else {
                aVar.b = 0L;
                str2 = "";
            }
            String str3 = Calendar.getInstance().get(1) + "/" + Calendar.getInstance().get(2) + "/" + Calendar.getInstance().get(5);
            u.e("lastDate=" + str2 + ";currentDate=" + str3);
            if (!str2.equals(str3)) {
                try {
                    jSONObject2.put("lt", System.currentTimeMillis());
                    jSONObject2.put("rq", 1);
                    aVar.f8619a = 1;
                    this.c.put(str, jSONObject2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return aVar;
            }
            int iOptInt = jSONObject2.optInt("rq", 0) + 1;
            try {
                jSONObject2.put("rq", iOptInt);
                jSONObject2.put("lt", System.currentTimeMillis());
                aVar.f8619a = iOptInt;
                this.c.put(str, jSONObject2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return aVar;
            th.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized void b() {
        b bVar = this.b;
        if (bVar == null) {
            return;
        }
        if (!bVar.hasMessages(1)) {
            this.b.sendEmptyMessageDelayed(1, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }
}
