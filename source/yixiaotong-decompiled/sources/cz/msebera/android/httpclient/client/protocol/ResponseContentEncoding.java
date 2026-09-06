package cz.msebera.android.httpclient.client.protocol;

import com.loopj.android.http.AsyncHttpClient;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.entity.DeflateDecompressingEntity;
import cz.msebera.android.httpclient.client.entity.GzipDecompressingEntity;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null || entity.getContentLength() == 0 || (contentEncoding = entity.getContentEncoding()) == null) {
            return;
        }
        HeaderElement[] elements = contentEncoding.getElements();
        if (elements.length > 0) {
            HeaderElement headerElement = elements[0];
            String lowerCase = headerElement.getName().toLowerCase(Locale.ENGLISH);
            if (AsyncHttpClient.ENCODING_GZIP.equals(lowerCase) || "x-gzip".equals(lowerCase)) {
                httpResponse.setEntity(new GzipDecompressingEntity(httpResponse.getEntity()));
            } else if ("deflate".equals(lowerCase)) {
                httpResponse.setEntity(new DeflateDecompressingEntity(httpResponse.getEntity()));
            } else {
                if (!HTTP.IDENTITY_CODING.equals(lowerCase)) {
                    throw new HttpException("Unsupported Content-Coding: " + headerElement.getName());
                }
                return;
            }
            httpResponse.removeHeaders("Content-Length");
            httpResponse.removeHeaders("Content-Encoding");
            httpResponse.removeHeaders("Content-MD5");
        }
    }
}
