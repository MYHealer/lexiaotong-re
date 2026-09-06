package com.masget.base.volley;

import android.text.TextUtils;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String mBoundary;
    private final String NEW_LINE_STR = IOUtils.LINE_SEPARATOR_WINDOWS;
    private final String CONTENT_TYPE = "Content-Type: ";
    private final String CONTENT_DISPOSITION = "Content-Disposition: ";
    private final String TYPE_TEXT_CHARSET = "text/plain; charset=UTF-8";
    private final String TYPE_OCTET_STREAM = "application/octet-stream";
    private final byte[] BINARY_ENCODING = "Content-Transfer-Encoding: binary\r\n\r\n".getBytes();
    private final byte[] BIT_ENCODING = "Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes();
    ByteArrayOutputStream mOutputStream = new ByteArrayOutputStream();

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public MultipartEntity() {
        this.mBoundary = null;
        this.mBoundary = generateBoundary();
    }

    private String generateBoundary() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = MULTIPART_CHARS;
            stringBuffer.append(cArr[random.nextInt(cArr.length)]);
        }
        return stringBuffer.toString();
    }

    private void writeFirstBoundary() throws IOException {
        this.mOutputStream.write(("--" + this.mBoundary + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
    }

    public void addStringPart(String str, String str2) {
        writeToOutputStream(str, str2.getBytes(), "text/plain; charset=UTF-8", this.BIT_ENCODING, "");
    }

    private void writeToOutputStream(String str, byte[] bArr, String str2, byte[] bArr2, String str3) {
        try {
            writeFirstBoundary();
            this.mOutputStream.write(("Content-Type: " + str2 + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
            this.mOutputStream.write(getContentDispositionBytes(str, str3));
            this.mOutputStream.write(bArr2);
            this.mOutputStream.write(bArr);
            this.mOutputStream.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBinaryPart(String str, byte[] bArr) {
        writeToOutputStream(str, bArr, "application/octet-stream", this.BINARY_ENCODING, "no-file");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.masget.base.volley.MultipartEntity] */
    public void addFilePart(String str, File file) throws Throwable {
        ?? r0 = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    writeFirstBoundary();
                    this.mOutputStream.write(getContentDispositionBytes(str, file.getName()));
                    this.mOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes());
                    this.mOutputStream.write(this.BINARY_ENCODING);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        r0 = -1;
                        if (i == -1) {
                            break;
                        } else {
                            this.mOutputStream.write(bArr, 0, i);
                        }
                    }
                    this.mOutputStream.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                    this.mOutputStream.flush();
                    closeSilently(fileInputStream2);
                } catch (IOException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    closeSilently(fileInputStream);
                    r0 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                    r0 = fileInputStream2;
                    closeSilently(r0);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] getContentDispositionBytes(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("; filename=\"" + str2 + "\"");
        }
        return sb.append(IOUtils.LINE_SEPARATOR_WINDOWS).toString().getBytes();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.mOutputStream.toByteArray().length;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.mBoundary);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.mOutputStream.write(("--" + this.mBoundary + "--\r\n").getBytes());
        outputStream.write(this.mOutputStream.toByteArray());
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() throws UnsupportedOperationException, IOException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.mOutputStream.toByteArray());
    }
}
