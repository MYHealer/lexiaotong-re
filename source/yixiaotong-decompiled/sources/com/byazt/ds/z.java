package com.byazt.ds;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2118a;
    public final Context n;

    public z(Context context, x xVar) {
        super(false, false);
        this.n = context;
        this.f2118a = xVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002b -> B:14:0x002c). Please report as a decompilation issue!!! */
    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        String strHd;
        try {
            x xVar = this.f2118a;
            if (xVar == null) {
                strHd = null;
            } else if (xVar.ic()) {
                strHd = Settings.Secure.getString(this.n.getContentResolver(), "android_id");
            } else {
                strHd = this.f2118a.hd();
                if (TextUtils.isEmpty(strHd)) {
                    strHd = null;
                }
            }
        } catch (Exception e) {
            com.byazt.yv.da.ve("", e);
        }
        if (!i.c(strHd) || "9774d56d682e549c".equals(strHd)) {
            SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt(this.n, "snssdk_openudid", 0);
            String strTt = a.tt(sharedPreferencesTt.getString("custom_b", null));
            String string = TextUtils.isEmpty(strTt) ? sharedPreferencesTt.getString("openudid", null) : strTt;
            if (!i.c(string)) {
                string = new BigInteger(64, new SecureRandom()).toString(16);
                if (string.charAt(0) == '-') {
                    string = string.substring(1);
                }
                int length = 13 - string.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string);
                    string = sb.toString();
                }
                try {
                    string = c("openudid.dat", string);
                } catch (Exception unused) {
                }
                String strC = a.c(string);
                SharedPreferences.Editor editorEdit = sharedPreferencesTt.edit();
                editorEdit.putString("custom_b", strC);
                editorEdit.apply();
            }
            strHd = string;
        }
        jSONObject.put("openudid", strHd);
        return true;
    }
}
