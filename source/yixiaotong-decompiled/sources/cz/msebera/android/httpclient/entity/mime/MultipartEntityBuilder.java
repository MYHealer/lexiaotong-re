package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.ByteArrayBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.entity.mime.content.FileBody;
import cz.msebera.android.httpclient.entity.mime.content.InputStreamBody;
import cz.msebera.android.httpclient.entity.mime.content.StringBody;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MultipartEntityBuilder {
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String subType = DEFAULT_SUBTYPE;
    private HttpMultipartMode mode = HttpMultipartMode.STRICT;
    private String boundary = null;
    private Charset charset = null;
    private List<FormBodyPart> bodyParts = null;

    public MultipartEntityBuilder setBoundary(String str) {
        this.boundary = str;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode httpMultipartMode) {
        this.mode = httpMultipartMode;
        return this;
    }

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    MultipartEntityBuilder() {
    }

    public MultipartEntityBuilder setLaxMode() {
        this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
        return this;
    }

    public MultipartEntityBuilder setStrictMode() {
        this.mode = HttpMultipartMode.STRICT;
        return this;
    }

    MultipartEntityBuilder addPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return this;
        }
        if (this.bodyParts == null) {
            this.bodyParts = new ArrayList();
        }
        this.bodyParts.add(formBodyPart);
        return this;
    }

    public MultipartEntityBuilder addPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Content body");
        return addPart(new FormBodyPart(str, contentBody));
    }

    public MultipartEntityBuilder addTextBody(String str, String str2, ContentType contentType) {
        return addPart(str, new StringBody(str2, contentType));
    }

    public MultipartEntityBuilder addTextBody(String str, String str2) {
        return addTextBody(str, str2, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr, ContentType contentType, String str2) {
        return addPart(str, new ByteArrayBody(bArr, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr) {
        return addBinaryBody(str, bArr, ContentType.DEFAULT_BINARY, (String) null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file, ContentType contentType, String str2) {
        return addPart(str, new FileBody(file, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file) {
        return addBinaryBody(str, file, ContentType.DEFAULT_BINARY, file != null ? file.getName() : null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream, ContentType contentType, String str2) {
        return addPart(str, new InputStreamBody(inputStream, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream) {
        return addBinaryBody(str, inputStream, ContentType.DEFAULT_BINARY, (String) null);
    }

    private String generateContentType(String str, Charset charset) {
        StringBuilder sb = new StringBuilder("multipart/form-data; boundary=");
        sb.append(str);
        if (charset != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(charset.name());
        }
        return sb.toString();
    }

    private String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int iNextInt = random.nextInt(11) + 30;
        for (int i = 0; i < iNextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    MultipartFormEntity buildEntity() {
        List listEmptyList;
        AbstractMultipartForm httpBrowserCompatibleMultipart;
        String str = this.subType;
        if (str == null) {
            str = DEFAULT_SUBTYPE;
        }
        Charset charset = this.charset;
        String strGenerateBoundary = this.boundary;
        if (strGenerateBoundary == null) {
            strGenerateBoundary = generateBoundary();
        }
        if (this.bodyParts != null) {
            listEmptyList = new ArrayList(this.bodyParts);
        } else {
            listEmptyList = Collections.emptyList();
        }
        HttpMultipartMode httpMultipartMode = this.mode;
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.STRICT;
        }
        int i = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode[httpMultipartMode.ordinal()];
        if (i == 1) {
            httpBrowserCompatibleMultipart = new HttpBrowserCompatibleMultipart(str, charset, strGenerateBoundary, listEmptyList);
        } else if (i == 2) {
            httpBrowserCompatibleMultipart = new HttpRFC6532Multipart(str, charset, strGenerateBoundary, listEmptyList);
        } else {
            httpBrowserCompatibleMultipart = new HttpStrictMultipart(str, charset, strGenerateBoundary, listEmptyList);
        }
        return new MultipartFormEntity(httpBrowserCompatibleMultipart, generateContentType(strGenerateBoundary, charset), httpBrowserCompatibleMultipart.getTotalLength());
    }

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.entity.mime.MultipartEntityBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode;

        static {
            int[] iArr = new int[HttpMultipartMode.values().length];
            $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode = iArr;
            try {
                iArr[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode[HttpMultipartMode.RFC6532.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HttpEntity build() {
        return buildEntity();
    }
}
