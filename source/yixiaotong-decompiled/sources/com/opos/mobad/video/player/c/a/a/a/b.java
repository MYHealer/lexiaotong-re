package com.opos.mobad.video.player.c.a.a.a;

import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    private static String e = "TTNativeMessage";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8347a;
    public String b;
    public String c;
    public a d;
    private JSONObject f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8348a = 1;
        public JSONObject b;
        private JSONObject c;

        public JSONObject a() {
            if (this.c == null) {
                this.c = new JSONObject();
            }
            try {
                this.c.put("code", this.f8348a);
                JSONObject jSONObject = this.c;
                JSONObject jSONObject2 = this.b;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject.put("__data", jSONObject2);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d(b.e, "toJson error", th);
            }
            return this.c;
        }

        public String toString() {
            return "TTNativeMessageParam{mCode=" + this.f8348a + ", mData=" + this.b + '}';
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a.a.a.b$b, reason: collision with other inner class name */
    public static class C1037b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8349a;
        public long b;
        private JSONObject c;

        public C1037b(int i, long j) {
            this.f8349a = i;
            this.b = j;
        }

        public JSONObject a() {
            if (this.c == null) {
                this.c = new JSONObject();
            }
            try {
                this.c.put("state", this.f8349a);
                this.c.put(CrashHianalyticsData.TIME, this.b);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d(b.e, "toJson error", th);
            }
            return this.c;
        }

        public String toString() {
            return "VideoStateParam{mState=" + this.f8349a + ", mTime=" + this.b + '}';
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8350a;
        private JSONObject b;

        public c(int i) {
            this.f8350a = i;
        }

        public JSONObject a() {
            if (this.b == null) {
                this.b = new JSONObject();
            }
            try {
                this.b.put("state", this.f8350a);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d(b.e, "toJson error", th);
            }
            return this.b;
        }

        public String toString() {
            return "VisibilityStateParams{mVisibleState=" + this.f8350a + '}';
        }
    }

    public b(com.opos.mobad.video.player.c.a.a.a.a aVar) {
        this.f8347a = NotificationCompat.CATEGORY_CALL;
        this.f8347a = aVar != null ? aVar.d : NotificationCompat.CATEGORY_EVENT;
        this.b = aVar != null ? aVar.e : "";
    }

    public JSONObject a() {
        if (this.f == null) {
            this.f = new JSONObject();
        }
        try {
            this.f.put("__msg_type", this.f8347a);
            JSONObject jSONObject = this.f;
            a aVar = this.d;
            jSONObject.put("__params", aVar != null ? aVar.a() : new JSONObject());
            this.f.put("__callback_id", this.b);
            this.f.put("__event_id", this.c);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d(e, "toJson error", th);
        }
        return this.f;
    }

    public String toString() {
        return "TTNativeMessage{mMsgType='" + this.f8347a + "', mCallbackId='" + this.b + "', mEventId='" + this.c + "', mParam=" + this.d + '}';
    }
}
