package com.byazt.te;

import android.content.Context;
import com.byazt.sm.UGTextView;
import com.hihonor.adsdk.base.g.j.e.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 14, 54})
public class ve extends com.byazt.sm.tt {
    public String cf;
    public String kz;
    public String mq;
    public String vi;
    public String vp;

    public ve(Context context) {
        super(context);
    }

    @Override // com.byazt.sm.tt, com.byazt.xj.ve
    public void tt() {
        super.tt();
        sl(this.c);
        ((UGTextView) this.n).setGravity(17);
    }

    public void c(int i, int i2, int i3, boolean z, boolean z2) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remain", i);
            jSONObject.put(a.L0, i2);
            jSONObject.put(a.Q0, i3);
            boolean z3 = i2 == 1;
            if (z) {
                str = z3 ? this.vi : this.mq;
            } else {
                str = z2 ? this.kz : this.vp;
            }
            Matcher matcher = Pattern.compile("\\$\\{([^}]+)\\}").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(matcher.group(1), "")));
            }
            matcher.appendTail(stringBuffer);
            String string = stringBuffer.toString();
            this.cf = string;
            sl(string);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void sl(String str) {
        ((UGTextView) this.n).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.n).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                uj((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.sm.tt, com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.vp = str2;
                break;
            case "text2":
                this.kz = str2;
                break;
            case "text3":
                this.vi = str2;
                break;
            case "text4":
                this.mq = str2;
                break;
        }
    }
}
