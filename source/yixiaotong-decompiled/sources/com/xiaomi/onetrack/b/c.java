package com.xiaomi.onetrack.b;

import android.os.Message;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f9450a;
    public final /* synthetic */ a b;

    public c(a aVar, JSONObject jSONObject) {
        this.b = aVar;
        this.f9450a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        p.a(s.d(new byte[]{37, 67, 71, 122, 12, 87, 7, 13, 1, 55, 65, 1, 5, 71, 82, 75}, "d379c9"), s.d(new byte[]{82, 13, 82, 80, 91, 37, 17, Ascii.DC4, 37, 13, 95, 3, 88, 2, 97, 86, 66, Ascii.ETB, 8, 11, 8, 66, 66, 17, 80, Ascii.ETB, 67}, "1e730d"));
        JSONArray jSONArrayOptJSONArray = this.f9450a.optJSONArray(s.d(new byte[]{82, 86, 12, 94, 10, 85}, "19b8c2"));
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject == null ? "" : jSONObjectOptJSONObject.optString(s.d(new byte[]{82, 19, 69, 40, 82}, "3c5a61"));
                p.a(s.d(new byte[]{121, Ascii.DC2, 17, 39, 90, 8, 7, 13, 1, 55, 65, 1, 89, Ascii.SYN, 4, Ascii.SYN}, "8bad5f"), s.d(new byte[]{83, 65, Ascii.SYN, 40, 93, 95, 65}, "21fa9e") + strOptString);
                if (!TextUtils.isEmpty(strOptString)) {
                    int iOptInt = jSONObjectOptJSONObject == null ? 0 : jSONObjectOptJSONObject.optInt(s.d(new byte[]{16, 83, 19, Ascii.NAK, 88, 95, 15}, "f6af10"));
                    int iE = h.a().e(strOptString);
                    boolean zH = a.h(strOptString);
                    boolean z = a.A.containsKey(strOptString) && ((Boolean) a.A.get(strOptString)).booleanValue();
                    p.a(s.d(new byte[]{112, 70, 17, 117, 94, 89, 7, 13, 1, 55, 65, 1, 80, 66, 4, 68}, "16a617"), s.d(new byte[]{84, 93, 90, 3, 8, Ascii.SYN, Ascii.ETB, 1, Ascii.DC4, 17, 88, 10, 86, 8, Ascii.EM}, "829bd6") + iE + s.d(new byte[]{Ascii.FS, Ascii.DC2, Ascii.DC2, 87, 65, 68, 4, Ascii.SYN, 70, Ascii.DC4, 84, Ascii.ETB, 67, 91, 14, 92, 9, Ascii.DC2}, "02a232") + iOptInt + s.d(new byte[]{Ascii.CAN, Ascii.ETB, 84, 83, 91, 108, 17, 0, 7, Ascii.SYN, 84, 95, Ascii.DC4}, "477259") + zH + s.d(new byte[]{Ascii.RS, 67, 11, SignedBytes.MAX_POWER_OF_TWO, 99, 82, 9, 1, 2, Ascii.ETB, 93, 12, 92, 4, 88, 19}, "2cb301") + z);
                    if (iOptInt > 0 && iOptInt > iE && zH && !z) {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 0;
                        messageObtain.obj = strOptString;
                        long jRandom = (long) (Math.random() * 1800000.0d);
                        p.a(s.d(new byte[]{34, Ascii.SYN, 65, 32, 9, 10, 7, 13, 1, 55, 65, 1, 2, Ascii.DC2, 84, 17}, "cf1cfd"), s.d(new byte[]{69, 80, 85, 65, 92, 83, Ascii.DC2, Ascii.ETB, 7, 5, 84, 69, 70, 81, 92, 13, 17, 84, 4, 68, 14, 3, 95, 1, 93, 93, 84, 65, 80, 80, Ascii.NAK, 1, Ascii.DC4, 66}, "180a16") + jRandom + s.d(new byte[]{Ascii.SYN, 85, 71}, "6840a5"));
                        a.y.sendMessageDelayed(messageObtain, jRandom);
                        a.A.put(strOptString, Boolean.TRUE);
                    }
                }
            }
        }
    }
}
