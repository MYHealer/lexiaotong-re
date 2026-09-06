package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ParseContext {
    private final Object fieldName;
    private Object object;
    private final ParseContext parent;
    private Type type;

    public Object getObject() {
        return this.object;
    }

    public ParseContext getParentContext() {
        return this.parent;
    }

    public Type getType() {
        return this.type;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ParseContext(ParseContext parseContext, Object obj, Object obj2) {
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
    }

    public String getPath() {
        if (this.parent == null) {
            return "$";
        }
        if (this.fieldName instanceof Integer) {
            return this.parent.getPath() + "[" + this.fieldName + "]";
        }
        return this.parent.getPath() + "." + this.fieldName;
    }

    public String toString() {
        return getPath();
    }
}
