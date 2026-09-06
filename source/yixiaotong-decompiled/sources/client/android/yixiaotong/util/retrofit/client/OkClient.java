package client.android.yixiaotong.util.retrofit.client;

import android.text.TextUtils;
import client.android.yixiaotong.util.retrofit.mime.TypedInput;
import client.android.yixiaotong.util.retrofit.mime.TypedOutput;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OkClient implements Client {

    /* JADX INFO: renamed from: client, reason: collision with root package name */
    private final OkHttpClient f964client;

    private static OkHttpClient generateDefaultOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        okHttpClient.setProxy(Proxy.NO_PROXY);
        return okHttpClient;
    }

    public OkClient() {
        this(generateDefaultOkHttp());
    }

    public OkClient(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            throw new NullPointerException("client == null");
        }
        this.f964client = okHttpClient;
    }

    @Override // client.android.yixiaotong.util.retrofit.client.Client
    public Response execute(Request request) throws IOException {
        return parseResponse(this.f964client.newCall(createRequest(request)).execute());
    }

    static com.squareup.okhttp.Request createRequest(Request request) {
        com.squareup.okhttp.Request.Builder builderMethod = new com.squareup.okhttp.Request.Builder().url(request.getUrl()).method(request.getMethod(), createRequestBody(request.getBody()));
        if (!TextUtils.isEmpty(request.getTag())) {
            builderMethod.tag(request.getTag());
        }
        List<Header> headers = request.getHeaders();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            Header header = headers.get(i);
            String value = header.getValue();
            if (value == null) {
                value = "";
            }
            builderMethod.addHeader(header.getName(), value);
        }
        return builderMethod.build();
    }

    static Response parseResponse(com.squareup.okhttp.Response response) {
        return new Response(response.request().urlString(), response.code(), response.message(), createHeaders(response.headers()), createResponseBody(response.body()));
    }

    private static RequestBody createRequestBody(final TypedOutput typedOutput) {
        if (typedOutput == null) {
            return null;
        }
        final MediaType mediaType = MediaType.parse(typedOutput.mimeType());
        return new RequestBody() { // from class: client.android.yixiaotong.util.retrofit.client.OkClient.1
            @Override // com.squareup.okhttp.RequestBody
            public MediaType contentType() {
                return mediaType;
            }

            @Override // com.squareup.okhttp.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                typedOutput.writeTo(bufferedSink.outputStream());
            }

            @Override // com.squareup.okhttp.RequestBody
            public long contentLength() {
                return typedOutput.length();
            }
        };
    }

    private static TypedInput createResponseBody(final ResponseBody responseBody) {
        try {
            if (responseBody.contentLength() == 0) {
                return null;
            }
            return new TypedInput() { // from class: client.android.yixiaotong.util.retrofit.client.OkClient.2
                @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
                public String mimeType() {
                    MediaType mediaTypeContentType = responseBody.contentType();
                    if (mediaTypeContentType == null) {
                        return null;
                    }
                    return mediaTypeContentType.toString();
                }

                @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
                public long length() {
                    try {
                        return responseBody.contentLength();
                    } catch (IOException unused) {
                        return 0L;
                    }
                }

                @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
                public InputStream in() throws IOException {
                    return responseBody.byteStream();
                }
            };
        } catch (IOException unused) {
            return null;
        }
    }

    private static List<Header> createHeaders(Headers headers) {
        int size = headers.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new Header(headers.name(i), headers.value(i)));
        }
        return arrayList;
    }
}
