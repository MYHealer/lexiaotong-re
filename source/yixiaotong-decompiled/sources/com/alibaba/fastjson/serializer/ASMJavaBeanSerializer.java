package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ASMJavaBeanSerializer implements ObjectSerializer {
    protected JavaBeanSerializer nature;

    public JavaBeanSerializer getJavaBeanSerializer() {
        return this.nature;
    }

    public ASMJavaBeanSerializer(Class<?> cls) {
        this.nature = new JavaBeanSerializer(cls);
    }
}
