package com.masget.base.volley;

import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MultipartRequest extends Request<String> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    Map<String, String> mHeaders;
    private Response.Listener<String> mListener;
    MultipartEntity mMultiPartEntity;
    private MultipartProgressListener progressListener;

    public interface MultipartProgressListener {
        void transferred(long j, int i);
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.mHeaders;
    }

    public MultipartEntity getMultiPartEntity() {
        return this.mMultiPartEntity;
    }

    public MultipartRequest(String str, Response.Listener<String> listener) {
        this(str, listener, null);
    }

    public MultipartRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(1, str, errorListener);
        this.mMultiPartEntity = new MultipartEntity();
        this.mHeaders = new HashMap();
        this.mListener = listener;
    }

    public MultipartRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener, MultipartProgressListener multipartProgressListener) {
        super(1, str, errorListener);
        this.mMultiPartEntity = new MultipartEntity();
        this.mHeaders = new HashMap();
        this.progressListener = multipartProgressListener;
        this.mListener = listener;
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return this.mMultiPartEntity.getContentType().getValue();
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.mMultiPartEntity.writeTo(new CountingOutputStream(byteArrayOutputStream, this.mMultiPartEntity.getContentLength(), this.progressListener));
        } catch (IOException unused) {
            Log.e("", "IOException writing to ByteArrayOutputStream");
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.android.volley.Request
    protected Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, PROTOCOL_CHARSET));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(String str) {
        Response.Listener<String> listener = this.mListener;
        if (listener != null) {
            listener.onResponse(str);
        }
    }

    public static class CountingOutputStream extends FilterOutputStream {
        private long fileLength;
        private final MultipartProgressListener progressListener;
        private long transferred;

        public CountingOutputStream(OutputStream outputStream, long j, MultipartProgressListener multipartProgressListener) {
            super(outputStream);
            this.fileLength = j;
            this.progressListener = multipartProgressListener;
            this.transferred = 0L;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.out.write(bArr, i, i2);
            MultipartProgressListener multipartProgressListener = this.progressListener;
            if (multipartProgressListener != null) {
                long j = this.transferred + ((long) i2);
                this.transferred = j;
                multipartProgressListener.transferred(j, (int) ((100 * j) / this.fileLength));
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.out.write(i);
            MultipartProgressListener multipartProgressListener = this.progressListener;
            if (multipartProgressListener != null) {
                long j = this.transferred + 1;
                this.transferred = j;
                multipartProgressListener.transferred(j, (int) ((100 * j) / this.fileLength));
            }
        }
    }
}
