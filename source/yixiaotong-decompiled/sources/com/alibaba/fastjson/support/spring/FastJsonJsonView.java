package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FastJsonJsonView extends AbstractView {
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private Set<String> renderedAttributes;
    private Charset charset = UTF8;
    private SerializerFeature[] serializerFeatures = new SerializerFeature[0];
    private boolean disableCaching = true;
    private boolean updateContentLength = false;
    private boolean extractValueFromSingleKeyModel = false;

    public Charset getCharset() {
        return this.charset;
    }

    public SerializerFeature[] getFeatures() {
        return this.serializerFeatures;
    }

    public boolean isExtractValueFromSingleKeyModel() {
        return this.extractValueFromSingleKeyModel;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setDisableCaching(boolean z) {
        this.disableCaching = z;
    }

    public void setExtractValueFromSingleKeyModel(boolean z) {
        this.extractValueFromSingleKeyModel = z;
    }

    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
    }

    public void setRenderedAttributes(Set<String> set) {
        this.renderedAttributes = set;
    }

    public void setUpdateContentLength(boolean z) {
        this.updateContentLength = z;
    }

    public FastJsonJsonView() {
        setContentType("application/json");
        setExposePathVariables(false);
    }

    @Deprecated
    public void setSerializerFeature(SerializerFeature... serializerFeatureArr) {
        setFeatures(serializerFeatureArr);
    }

    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] bytes = JSON.toJSONString(filterModel(map), this.serializerFeatures).getBytes(this.charset);
        ByteArrayOutputStream byteArrayOutputStreamCreateTemporaryOutputStream = this.updateContentLength ? createTemporaryOutputStream() : httpServletResponse.getOutputStream();
        byteArrayOutputStreamCreateTemporaryOutputStream.write(bytes);
        if (this.updateContentLength) {
            writeToResponse(httpServletResponse, byteArrayOutputStreamCreateTemporaryOutputStream);
        }
    }

    protected void prepareResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        setResponseContentType(httpServletRequest, httpServletResponse);
        httpServletResponse.setCharacterEncoding(UTF8.name());
        if (this.disableCaching) {
            httpServletResponse.addHeader("Pragma", HeaderConstants.CACHE_CONTROL_NO_CACHE);
            httpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
            httpServletResponse.addDateHeader("Expires", 1L);
        }
    }

    protected Object filterModel(Map<String, Object> map) {
        HashMap map2 = new HashMap(map.size());
        Set<String> setKeySet = !CollectionUtils.isEmpty(this.renderedAttributes) ? this.renderedAttributes : map.keySet();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!(entry.getValue() instanceof BindingResult) && setKeySet.contains(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        if (this.extractValueFromSingleKeyModel && map2.size() == 1) {
            Iterator it = map2.entrySet().iterator();
            if (it.hasNext()) {
                return ((Map.Entry) it.next()).getValue();
            }
        }
        return map2;
    }
}
