package com.alibaba.fastjson.support.odps.udf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.aliyun.odps.udf.UDF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONArrayAdd extends UDF {
    public JSONArrayAdd() {
        SerializeConfig.getGlobalInstance().setAsmEnable(false);
        ParserConfig.getGlobalInstance().setAsmEnable(false);
    }

    public String evaluate(String str, String str2, String... strArr) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.arrayAdd(obj, str2, strArr);
        return JSON.toJSONString(obj);
    }

    public String evaluate(String str, String str2, Long... lArr) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.arrayAdd(obj, str2, lArr);
        return JSON.toJSONString(obj);
    }

    public String evaluate(String str, String str2, Boolean... boolArr) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.arrayAdd(obj, str2, boolArr);
        return JSON.toJSONString(obj);
    }

    public String evaluate(String str, String str2, Double... dArr) throws Exception {
        Object obj = JSON.parse(str);
        JSONPath.arrayAdd(obj, str2, dArr);
        return JSON.toJSONString(obj);
    }
}
