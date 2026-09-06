package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.android.exoplayer2.util.MimeTypes;
import com.masget.base.AppConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private Charset charset;
    private SerializerFeature[] features;

    public Charset getCharset() {
        return this.charset;
    }

    public SerializerFeature[] getFeatures() {
        return this.features;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.features = serializerFeatureArr;
    }

    protected boolean supports(Class<?> cls) {
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FastJsonHttpMessageConverter() {
        Charset charset = UTF8;
        super(new MediaType[]{new MediaType(MimeTypes.BASE_TYPE_APPLICATION, AppConfig.FORMAT, charset), new MediaType(MimeTypes.BASE_TYPE_APPLICATION, "*+json", charset)});
        this.charset = charset;
        this.features = new SerializerFeature[0];
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream body = httpInputMessage.getBody();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = body.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return JSON.parseObject(byteArray, 0, byteArray.length, this.charset.newDecoder(), cls, new Feature[0]);
            }
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            }
        }
    }

    protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        httpOutputMessage.getBody().write(JSON.toJSONString(obj, this.features).getBytes(this.charset));
    }
}
