package com.byazt.ouz;

import android.graphics.Color;
import android.text.TextUtils;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 15})
public class uj {
    public static void c(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject2 == null || (jSONObjectOptJSONObject = jSONObject2.optJSONObject("xAppInfo")) == null || jSONObjectOptJSONObject.optInt("themeStatus") != 1) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = (jSONObject2.optJSONObject("xSetting") == null || ((JSONObject) Objects.requireNonNull(jSONObject2.optJSONObject("xSetting"))).optJSONObject("dark_mode_config") == null) ? null : ((JSONObject) Objects.requireNonNull(jSONObject2.optJSONObject("xSetting"))).optJSONObject("dark_mode_config");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        }
        int iC = c(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObjectOptJSONObject2);
        if (iC == 1) {
            jSONObject.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, uj(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObjectOptJSONObject2));
        } else if (iC == 2) {
            jSONObject.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, tt(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObjectOptJSONObject2));
        }
        if (c(jSONObject.optString("textColor"), jSONObjectOptJSONObject2) == 1) {
            jSONObject.put("textColor", ve(jSONObject.optString("textColor"), jSONObjectOptJSONObject2));
        }
    }

    private static int c(String str, JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("luminance_upper", 90);
            int iOptInt2 = jSONObject.optInt("luminance_lower", 40);
            int iOptInt3 = jSONObject.optInt("gray_threshold", 20);
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int iC = com.byazt.cd.c.c(str);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = (iMax + iMin) / 2;
            int i2 = iMax - iMin;
            if (i > iOptInt && i2 < iOptInt3) {
                return 2;
            }
            if (i < iOptInt2 && i2 < iOptInt3) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private static String c(int i, int i2, int i3, int i4) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private static String tt(String str, JSONObject jSONObject) {
        int iC = com.byazt.cd.c.c(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("dark_gray_threshold", 30);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iAlpha = Color.alpha(iC);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = 255 - iRed;
            int i2 = 255 - iGreen;
            int i3 = 255 - iBlue;
            if (iMax - iMin < iOptInt) {
                return c(iAlpha, i, i2, i3);
            }
            return c(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception unused) {
            return str;
        }
    }

    private static String ve(String str, JSONObject jSONObject) {
        int iC = com.byazt.cd.c.c(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("light_gray_threshold", JfifUtil.MARKER_APP1);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iAlpha = Color.alpha(iC);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = 255 - iRed;
            int i2 = 255 - iGreen;
            int i3 = 255 - iBlue;
            if (iMax - iMin < iOptInt) {
                return c(iAlpha, i, i2, i3);
            }
            return c(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception unused) {
            return str;
        }
    }

    private static String uj(String str, JSONObject jSONObject) {
        int iC = com.byazt.cd.c.c(str);
        try {
            int iOptInt = jSONObject.optInt("black_bright_offset", 20);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iAlpha = Color.alpha(iC);
            int iMax = Math.max(0, Math.min(100, iOptInt));
            return c(iAlpha, Math.min(255, iRed + ((255 - iRed) * (iMax / 100))), Math.min(255, iGreen + ((255 - iGreen) * (iMax / 100))), Math.min(255, iBlue + ((255 - iBlue) * (iMax / 100))));
        } catch (Exception unused) {
            return str;
        }
    }
}
