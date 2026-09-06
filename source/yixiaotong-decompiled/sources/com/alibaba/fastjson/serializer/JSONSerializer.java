package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONSerializer {
    private List<AfterFilter> afterFilters;
    private List<BeforeFilter> beforeFilters;
    private final SerializeConfig config;
    private SerialContext context;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private String indent;
    private int indentCount;
    private List<NameFilter> nameFilters;
    private final SerializeWriter out;
    private List<PropertyFilter> propertyFilters;
    private List<PropertyPreFilter> propertyPreFilters;
    private IdentityHashMap<Object, SerialContext> references;
    private List<ValueFilter> valueFilters;

    public void decrementIdent() {
        this.indentCount--;
    }

    public List<AfterFilter> getAfterFiltersDirect() {
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFiltersDirect() {
        return this.beforeFilters;
    }

    public SerialContext getContext() {
        return this.context;
    }

    public int getIndentCount() {
        return this.indentCount;
    }

    public SerializeConfig getMapping() {
        return this.config;
    }

    public List<NameFilter> getNameFiltersDirect() {
        return this.nameFilters;
    }

    public List<PropertyFilter> getPropertyFiltersDirect() {
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFiltersDirect() {
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFiltersDirect() {
        return this.valueFilters;
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void setContext(SerialContext serialContext) {
        this.context = serialContext;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(SerializeWriter serializeWriter) {
        this(serializeWriter, SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(SerializeConfig serializeConfig) {
        this(new SerializeWriter(), serializeConfig);
    }

    @Deprecated
    public JSONSerializer(JSONSerializerMap jSONSerializerMap) {
        this(new SerializeWriter(), jSONSerializerMap);
    }

    public JSONSerializer(SerializeWriter serializeWriter, SerializeConfig serializeConfig) {
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.indentCount = 0;
        this.indent = "\t";
        this.references = null;
        this.out = serializeWriter;
        this.config = serializeConfig;
    }

    public String getDateFormatPattern() {
        DateFormat dateFormat = this.dateFormat;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null && this.dateFormatPattern != null) {
            this.dateFormat = new SimpleDateFormat(this.dateFormatPattern);
        }
        return this.dateFormat;
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i) {
        setContext(serialContext, obj, obj2, i, 0);
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i, int i2) {
        if (isEnabled(SerializerFeature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = new SerialContext(serialContext, obj, obj2, i, i2);
        if (this.references == null) {
            this.references = new IdentityHashMap<>();
        }
        this.references.put(obj, this.context);
    }

    public void setContext(Object obj, Object obj2) {
        setContext(this.context, obj, obj2, 0);
    }

    public void popContext() {
        SerialContext serialContext = this.context;
        if (serialContext != null) {
            this.context = serialContext.getParent();
        }
    }

    public final boolean isWriteClassName(Type type, Object obj) {
        if (this.out.isEnabled(SerializerFeature.WriteClassName)) {
            return (type == null && isEnabled(SerializerFeature.NotWriteRootClassName) && this.context.getParent() == null) ? false : true;
        }
        return false;
    }

    public SerialContext getSerialContext(Object obj) {
        IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
        if (identityHashMap == null) {
            return null;
        }
        return identityHashMap.get(obj);
    }

    public boolean containsReference(Object obj) {
        IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
        if (identityHashMap == null) {
            return false;
        }
        return identityHashMap.containsKey(obj);
    }

    public void writeReference(Object obj) {
        SerialContext context = getContext();
        if (obj == context.getObject()) {
            this.out.write("{\"$ref\":\"@\"}");
            return;
        }
        SerialContext parent = context.getParent();
        if (parent != null && obj == parent.getObject()) {
            this.out.write("{\"$ref\":\"..\"}");
            return;
        }
        while (context.getParent() != null) {
            context = context.getParent();
        }
        if (obj == context.getObject()) {
            this.out.write("{\"$ref\":\"$\"}");
            return;
        }
        String path = getSerialContext(obj).getPath();
        this.out.write("{\"$ref\":\"");
        this.out.write(path);
        this.out.write("\"}");
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
        }
        return this.valueFilters;
    }

    public void println() {
        this.out.write('\n');
        for (int i = 0; i < this.indentCount; i++) {
            this.out.write(this.indent);
        }
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
        }
        return this.beforeFilters;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
        }
        return this.afterFilters;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
        }
        return this.nameFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
        }
        return this.propertyPreFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
        }
        return this.propertyFilters;
    }

    public String toString() {
        return this.out.toString();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.out.config(serializerFeature, z);
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return this.out.isEnabled(serializerFeature);
    }

    public void writeNull() {
        this.out.writeNull();
    }

    public static final void write(Writer writer, Object obj) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            try {
                new JSONSerializer(serializeWriter).write(obj);
                serializeWriter.writeTo(writer);
                serializeWriter.close();
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static final void write(SerializeWriter serializeWriter, Object obj) {
        new JSONSerializer(serializeWriter).write(obj);
    }

    public final void write(Object obj) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(obj.getClass()).write(this, obj, null, null, 0);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFieldName(Object obj, Object obj2) {
        writeWithFieldName(obj, obj2, null, 0);
    }

    protected final void writeKeyValue(char c, String str, Object obj) {
        if (c != 0) {
            this.out.write(c);
        }
        this.out.writeFieldName(str);
        write(obj);
    }

    public final void writeWithFieldName(Object obj, Object obj2, Type type, int i) {
        try {
            if (obj == null) {
                this.out.writeNull();
            } else {
                getObjectWriter(obj.getClass()).write(this, obj, obj2, type, i);
            }
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFormat(Object obj, String str) {
        if (obj instanceof Date) {
            DateFormat dateFormat = getDateFormat();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat(str);
            }
            this.out.writeString(dateFormat.format((Date) obj));
            return;
        }
        write(obj);
    }

    public final void write(String str) {
        StringCodec.instance.write(this, str);
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return this.config.getObjectWriter(cls);
    }

    public void close() {
        this.out.close();
    }
}
