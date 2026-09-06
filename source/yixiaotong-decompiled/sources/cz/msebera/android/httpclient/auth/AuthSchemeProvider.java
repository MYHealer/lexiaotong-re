package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface AuthSchemeProvider {
    AuthScheme create(HttpContext httpContext);
}
