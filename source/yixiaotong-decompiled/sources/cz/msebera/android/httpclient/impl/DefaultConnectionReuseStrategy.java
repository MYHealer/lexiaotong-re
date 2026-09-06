package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.TokenIterator;
import cz.msebera.android.httpclient.message.BasicTokenIterator;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (java.lang.Integer.parseInt(r0[0].getValue()) < 0) goto L14;
     */
    @Override // cz.msebera.android.httpclient.ConnectionReuseStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
        Header firstHeader = httpResponse.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            if (!HTTP.CHUNK_CODING.equalsIgnoreCase(firstHeader.getValue())) {
                return false;
            }
        } else if (canResponseHaveBody(httpResponse)) {
            Header[] headers = httpResponse.getHeaders("Content-Length");
            if (headers.length == 1) {
            }
            return false;
        }
        HeaderIterator headerIterator = httpResponse.headerIterator("Connection");
        if (!headerIterator.hasNext()) {
            headerIterator = httpResponse.headerIterator("Proxy-Connection");
        }
        if (headerIterator.hasNext()) {
            try {
                TokenIterator tokenIteratorCreateTokenIterator = createTokenIterator(headerIterator);
                boolean z = false;
                while (tokenIteratorCreateTokenIterator.hasNext()) {
                    String strNextToken = tokenIteratorCreateTokenIterator.nextToken();
                    if (HTTP.CONN_CLOSE.equalsIgnoreCase(strNextToken)) {
                        return false;
                    }
                    if ("Keep-Alive".equalsIgnoreCase(strNextToken)) {
                        z = true;
                    }
                }
                if (z) {
                    return true;
                }
            } catch (ParseException unused) {
                return false;
            }
        }
        return !protocolVersion.lessEquals(HttpVersion.HTTP_1_0);
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    private boolean canResponseHaveBody(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }
}
