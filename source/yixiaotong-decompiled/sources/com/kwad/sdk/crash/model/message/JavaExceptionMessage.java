package com.kwad.sdk.crash.model.message;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JavaExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -2410125079234148135L;

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected String getTypePrefix() {
        return "";
    }

    public JavaExceptionMessage() {
        this.mExceptionType = 1;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return super.toJson();
    }
}
