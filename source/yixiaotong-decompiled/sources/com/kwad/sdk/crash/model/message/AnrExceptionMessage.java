package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class AnrExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = 2116476830162477947L;
    public String mReason = "";
    public String mMessageQueueDetail = "";
    public String mThreadDetail = "";
    public String mThreadStatus = "";
    public String mShowAnrDialog = "Unknown";
    public String mAnrForeground = "Unknown";
    public String mAnrShowBackground = "Unknown";
    public String mAnrHideErrorDialogs = "Unknown";
    public String mAnrInputMethodExists = "Unknown";
    public int mIndex = -1;

    public final String getAnrForeground() {
        return this.mAnrForeground;
    }

    public final String getAnrHideErrorDialogs() {
        return this.mAnrHideErrorDialogs;
    }

    public final String getAnrInputMethodExists() {
        return this.mAnrInputMethodExists;
    }

    public final String getAnrShowBackground() {
        return this.mAnrShowBackground;
    }

    public final String getShowAnrDialog() {
        return this.mShowAnrDialog;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected final String getTypePrefix() {
        return "ANR_";
    }

    public final void setAnrForeground(String str) {
        this.mAnrForeground = str;
    }

    public final void setAnrHideErrorDialogs(String str) {
        this.mAnrHideErrorDialogs = str;
    }

    public final void setAnrInputMethodExists(String str) {
        this.mAnrInputMethodExists = str;
    }

    public final void setAnrShowBackground(String str) {
        this.mAnrShowBackground = str;
    }

    public final void setShowAnrDialog(String str) {
        this.mShowAnrDialog = str;
    }

    public AnrExceptionMessage() {
        this.mExceptionType = 3;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        try {
            if (!TextUtils.isEmpty(this.mReason)) {
                sb.append("ANR 原因:\n").append(this.mReason).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (!TextUtils.isEmpty(this.mThreadStatus)) {
                sb.append("线程状态: \n").append(this.mThreadStatus).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (!TextUtils.isEmpty(this.mThreadDetail)) {
                sb.append("线程状态: \n").append(this.mThreadDetail).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (!TextUtils.isEmpty(this.mMessageQueueDetail)) {
                sb.append("消息队列: \n").append(this.mMessageQueueDetail).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return sb.substring(0);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mReason = jSONObject.optString("mReason");
        this.mMessageQueueDetail = jSONObject.optString("mMessageQueueDetail");
        this.mThreadDetail = jSONObject.optString("mThreadDetail");
        this.mThreadStatus = jSONObject.optString("mThreadStatus");
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        ac.putValue(json, "mReason", this.mReason);
        ac.putValue(json, "mMessageQueueDetail", this.mMessageQueueDetail);
        ac.putValue(json, "mThreadDetail", this.mThreadDetail);
        ac.putValue(json, "mThreadStatus", this.mThreadStatus);
        return json;
    }
}
