package client.android.yixiaotong.util.retrofit.client;

import client.android.yixiaotong.util.retrofit.mime.TypedOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class Request {
    private final TypedOutput body;
    private final List<Header> headers;
    private final String method;
    private final String tag;
    private final String url;

    public TypedOutput getBody() {
        return this.body;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getTag() {
        return this.tag;
    }

    public String getUrl() {
        return this.url;
    }

    public Request(String str, String str2, String str3, List<Header> list, TypedOutput typedOutput) {
        if (str == null) {
            throw new NullPointerException("Method must not be null.");
        }
        if (str2 == null) {
            throw new NullPointerException("URL must not be null.");
        }
        this.method = str;
        this.url = str2;
        this.tag = str3;
        if (list == null) {
            this.headers = Collections.emptyList();
        } else {
            this.headers = Collections.unmodifiableList(new ArrayList(list));
        }
        this.body = typedOutput;
    }
}
