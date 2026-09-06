package client.android.yixiaotong.util.retrofit.client;

import client.android.yixiaotong.util.retrofit.mime.TypedInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class Response {
    private final TypedInput body;
    private final List<Header> headers;
    private final String reason;
    private final int status;
    private final String url;

    public TypedInput getBody() {
        return this.body;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public Response(String str, int i, String str2, List<Header> list, TypedInput typedInput) {
        if (str == null) {
            throw new IllegalArgumentException("url == null");
        }
        if (i < 200) {
            throw new IllegalArgumentException("Invalid status code: " + i);
        }
        if (str2 == null) {
            throw new IllegalArgumentException("reason == null");
        }
        if (list == null) {
            throw new IllegalArgumentException("headers == null");
        }
        this.url = str;
        this.status = i;
        this.reason = str2;
        this.headers = Collections.unmodifiableList(new ArrayList(list));
        this.body = typedInput;
    }
}
