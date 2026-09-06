package com.alibaba.fastjson.support.odps.udf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.aliyun.odps.udf.UDF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONContainsValue extends UDF {
    public JSONContainsValue() {
        SerializeConfig.getGlobalInstance().setAsmEnable(false);
    }

    public Boolean evaluate(String str, String str2, String str3) throws Exception {
        return Boolean.valueOf(JSONPath.containsValue(JSON.parse(str), str2, str3));
    }

    public Boolean evaluate(String str, String str2, Long l) throws Exception {
        return Boolean.valueOf(JSONPath.containsValue(JSON.parse(str), str2, l));
    }

    public Boolean evaluate(String str, String str2, Boolean bool) throws Exception {
        return Boolean.valueOf(JSONPath.containsValue(JSON.parse(str), str2, bool));
    }

    public Boolean evaluate(String str, String str2, Double d) throws Exception {
        return Boolean.valueOf(JSONPath.containsValue(JSON.parse(str), str2, d));
    }
}
