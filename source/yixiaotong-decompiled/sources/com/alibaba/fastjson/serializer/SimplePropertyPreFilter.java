package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> excludes;
    private final Set<String> includes;

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Set<String> getExcludes() {
        return this.excludes;
    }

    public Set<String> getIncludes() {
        return this.includes;
    }

    public SimplePropertyPreFilter(String... strArr) {
        this(null, strArr);
    }

    public SimplePropertyPreFilter(Class<?> cls, String... strArr) {
        this.includes = new HashSet();
        this.excludes = new HashSet();
        this.clazz = cls;
        for (String str : strArr) {
            if (str != null) {
                this.includes.add(str);
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.PropertyPreFilter
    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str) {
        if (obj == null) {
            return true;
        }
        Class<?> cls = this.clazz;
        if (cls != null && !cls.isInstance(obj)) {
            return true;
        }
        if (this.excludes.contains(str)) {
            return false;
        }
        return this.includes.size() == 0 || this.includes.contains(str);
    }
}
