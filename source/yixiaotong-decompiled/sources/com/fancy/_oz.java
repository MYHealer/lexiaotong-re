package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.utils.TextUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _oz implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        JSONArray jSONArrayOptJSONArray;
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
        List<String> mediaInstalledPackages = ptgCustomController != null ? ptgCustomController.getMediaInstalledPackages() : null;
        if (TextUtil.isEmpty(mediaInstalledPackages) || TextUtil.isNotEmpty(_p2._f)) {
            return;
        }
        try {
            String detectRule = PtgAdSdk.getConfig().getDetectRule();
            if (TextUtils.isEmpty(detectRule)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(detectRule);
            int iMin = Math.min(jSONArray.length(), 100);
            for (int i = 0; i < iMin; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString("tagId");
                if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("packageName")) != null) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String string = jSONArrayOptJSONArray.getString(i2);
                        if (!TextUtils.isEmpty(string) && mediaInstalledPackages.contains(string)) {
                            _p2._f.add(strOptString);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
