package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.FileEntity;
import cz.msebera.android.httpclient.entity.InputStreamEntity;
import cz.msebera.android.httpclient.entity.SerializableEntity;
import cz.msebera.android.httpclient.entity.StringEntity;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List<NameValuePair> parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    private ContentType getContentOrDefault(ContentType contentType) {
        ContentType contentType2 = this.contentType;
        return contentType2 != null ? contentType2 : contentType;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public File getFile() {
        return this.file;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters;
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder setContentEncoding(String str) {
        this.contentEncoding = str;
        return this;
    }

    public EntityBuilder setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    EntityBuilder() {
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    public EntityBuilder setText(String str) {
        clearContent();
        this.text = str;
        return this;
    }

    public EntityBuilder setBinary(byte[] bArr) {
        clearContent();
        this.binary = bArr;
        return this;
    }

    public EntityBuilder setStream(InputStream inputStream) {
        clearContent();
        this.stream = inputStream;
        return this;
    }

    public EntityBuilder setParameters(List<NameValuePair> list) {
        clearContent();
        this.parameters = list;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair... nameValuePairArr) {
        return setParameters(Arrays.asList(nameValuePairArr));
    }

    public EntityBuilder setSerializable(Serializable serializable) {
        clearContent();
        this.serializable = serializable;
        return this;
    }

    public EntityBuilder setFile(File file) {
        clearContent();
        this.file = file;
        return this;
    }

    public HttpEntity build() {
        AbstractHttpEntity basicHttpEntity;
        ContentType contentType;
        if (this.text != null) {
            basicHttpEntity = new StringEntity(this.text, getContentOrDefault(ContentType.DEFAULT_TEXT));
        } else if (this.binary != null) {
            basicHttpEntity = new ByteArrayEntity(this.binary, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else if (this.stream != null) {
            basicHttpEntity = new InputStreamEntity(this.stream, 1L, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else if (this.parameters != null) {
            List<NameValuePair> list = this.parameters;
            ContentType contentType2 = this.contentType;
            basicHttpEntity = new UrlEncodedFormEntity(list, contentType2 != null ? contentType2.getCharset() : null);
        } else if (this.serializable != null) {
            basicHttpEntity = new SerializableEntity(this.serializable);
            basicHttpEntity.setContentType(ContentType.DEFAULT_BINARY.toString());
        } else if (this.file != null) {
            basicHttpEntity = new FileEntity(this.file, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else {
            basicHttpEntity = new BasicHttpEntity();
        }
        if (basicHttpEntity.getContentType() != null && (contentType = this.contentType) != null) {
            basicHttpEntity.setContentType(contentType.toString());
        }
        basicHttpEntity.setContentEncoding(this.contentEncoding);
        basicHttpEntity.setChunked(this.chunked);
        return this.gzipCompress ? new GzipCompressingEntity(basicHttpEntity) : basicHttpEntity;
    }
}
