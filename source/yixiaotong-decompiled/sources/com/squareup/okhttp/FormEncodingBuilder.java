package com.squareup.okhttp;

import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import java.io.EOFException;
import okio.Buffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class FormEncodingBuilder {
    private static final MediaType CONTENT_TYPE = MediaType.parse(URLEncodedUtils.CONTENT_TYPE);
    private final Buffer content = new Buffer();

    public FormEncodingBuilder add(String str, String str2) throws EOFException {
        if (this.content.size() > 0) {
            this.content.writeByte(38);
        }
        HttpUrl.canonicalize(this.content, str, 0, str.length(), okhttp3.HttpUrl.FORM_ENCODE_SET, false, true, true);
        this.content.writeByte(61);
        HttpUrl.canonicalize(this.content, str2, 0, str2.length(), okhttp3.HttpUrl.FORM_ENCODE_SET, false, true, true);
        return this;
    }

    public FormEncodingBuilder addEncoded(String str, String str2) throws EOFException {
        if (this.content.size() > 0) {
            this.content.writeByte(38);
        }
        HttpUrl.canonicalize(this.content, str, 0, str.length(), okhttp3.HttpUrl.FORM_ENCODE_SET, true, true, true);
        this.content.writeByte(61);
        HttpUrl.canonicalize(this.content, str2, 0, str2.length(), okhttp3.HttpUrl.FORM_ENCODE_SET, true, true, true);
        return this;
    }

    public RequestBody build() {
        return RequestBody.create(CONTENT_TYPE, this.content.snapshot());
    }
}
