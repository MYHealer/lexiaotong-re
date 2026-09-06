package com.alibaba.fastjson.support.odps.udf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.aliyun.odps.udf.UDF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONSet extends UDF {
    public JSONSet() {
        SerializeConfig.getGlobalInstance().setAsmEnable(false);
        ParserConfig.getGlobalInstance().setAsmEnable(false);
    }

    public String evaluate(String str, String str2, String str3) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.set(obj, str2, str3);
        return JSON.toJSONString(obj);
    }

    public String evaluate(String str, String str2, Long l) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.set(obj, str2, l);
        return JSON.toJSONString(obj);
    }

    public String evaluate(String str, String str2, Boolean bool) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.set(obj, str2, bool);
        return JSON.toJSONString(obj);
    }

    public String evaluate(String str, String str2, Double d) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.set(obj, str2, d);
        return JSON.toJSONString(obj);
    }
}
