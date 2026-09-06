package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONWriter implements Closeable, Flushable {
    private JSONStreamContext context;
    private JSONSerializer serializer;
    private SerializeWriter writer;

    public JSONWriter(Writer writer) {
        this.writer = new SerializeWriter(writer);
        this.serializer = new JSONSerializer(this.writer);
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.writer.config(serializerFeature, z);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, 1001);
        this.writer.write('{');
    }

    public void endObject() {
        this.writer.write('}');
        endStructure();
    }

    public void writeKey(String str) {
        writeObject(str);
    }

    public void writeValue(Object obj) {
        writeObject(obj);
    }

    public void writeObject(String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWriter();
    }

    public void writeObject(Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWriter();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, 1004);
        this.writer.write('[');
    }

    private void beginStructure() {
        int state = this.context.getState();
        switch (state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.writer.write(':');
                return;
            case 1003:
            default:
                throw new JSONException("illegal state : " + state);
            case 1005:
                this.writer.write(',');
                return;
        }
    }

    public void endArray() {
        this.writer.write(']');
        endStructure();
    }

    private void endStructure() {
        JSONStreamContext parent = this.context.getParent();
        this.context = parent;
        if (parent == null) {
            return;
        }
        int state = parent.getState();
        int i = 1002;
        if (state != 1001) {
            if (state != 1002) {
                i = state != 1004 ? -1 : 1005;
            } else {
                i = 1003;
            }
        }
        if (i != -1) {
            this.context.setState(i);
        }
    }

    private void beforeWrite() {
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        int state = jSONStreamContext.getState();
        if (state == 1002) {
            this.writer.write(':');
        } else if (state == 1003) {
            this.writer.write(',');
        } else {
            if (state != 1005) {
                return;
            }
            this.writer.write(',');
        }
    }

    private void afterWriter() {
        int i;
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.getState()) {
            case 1001:
            case 1003:
                i = 1002;
                break;
            case 1002:
                i = 1003;
                break;
            case 1004:
                i = 1005;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            this.context.setState(i);
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    @Deprecated
    public void writeStartObject() {
        startObject();
    }

    @Deprecated
    public void writeEndObject() {
        endObject();
    }

    @Deprecated
    public void writeStartArray() {
        startArray();
    }

    @Deprecated
    public void writeEndArray() {
        endArray();
    }
}
