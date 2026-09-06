package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class TipsConfigItem extends b<TipConfigData> {
    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            TipConfigData tipConfigData = new TipConfigData();
            tipConfigData.parseJson(jSONObjectOptJSONObject);
            setValue(tipConfigData);
            return;
        }
        setValue(Lc());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putInt("tipsSwitch", getValue().getTipShowSwitch());
        if (getValue().getTipInfoData() != null) {
            editor.putString("tipsInfo", getValue().getTipInfoData());
        } else {
            editor.putString("tipsInfo", "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        TipConfigData value = getValue();
        if (value == null) {
            value = new TipConfigData();
        }
        value.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
        value.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
        setValue(value);
    }

    public static class TipConfigData implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 268961350883157950L;
        private String tipInfo;
        private transient Map<String, String> tipMap = new HashMap();
        private int tipShowSwitch;

        public String getTipInfoData() {
            return this.tipInfo;
        }

        public int getTipShowSwitch() {
            return this.tipShowSwitch;
        }

        public boolean isShowTips() {
            return this.tipShowSwitch == 0;
        }

        public void setTipShowSwitch(int i) {
            this.tipShowSwitch = i;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            setTipInfoData(jSONObject.optString("tipInfo"));
            this.tipShowSwitch = jSONObject.optInt("tipShowSwitch", 0);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "tipShowSwitch", this.tipShowSwitch);
            ac.putValue(jSONObject, "tipInfo", this.tipInfo);
            return jSONObject;
        }

        public String getTips(String str) {
            return this.tipMap.get(str);
        }

        public void setTipInfoData(String str) {
            this.tipInfo = str;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
                return;
            }
            try {
                genTipMap(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }

        private void genTipMap(JSONObject jSONObject) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                this.tipMap.put(next, jSONObject.optString(next, ""));
            }
        }
    }
}
