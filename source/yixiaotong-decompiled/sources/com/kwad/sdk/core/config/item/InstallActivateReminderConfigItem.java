package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class InstallActivateReminderConfigItem extends b<InstallActivateReminderConfig> {

    public static class InstallActivateReminderConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6457271849826128465L;
        public int noticeTotalCount = 3;
        public int perAppNoticeCount = 2;
        public int noticeAppearTime = 15000;
        public int noticeContinueTime = 15000;
    }

    public InstallActivateReminderConfigItem() {
        super("installActivateReminderConfig", new InstallActivateReminderConfig());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
            installActivateReminderConfig.parseJson(jSONObjectOptJSONObject);
            setValue(installActivateReminderConfig);
            return;
        }
        setValue(Lc());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), getValue().toJson().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        InstallActivateReminderConfig value = getValue();
        if (value == null) {
            value = new InstallActivateReminderConfig();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            jSONObject = null;
        }
        if (jSONObject != null) {
            value.parseJson(jSONObject);
        }
        setValue(value);
    }
}
