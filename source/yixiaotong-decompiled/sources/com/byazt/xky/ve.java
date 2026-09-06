package com.byazt.xky;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import com.byazt.yj.or;
import com.byazt.yj.t;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, Opcodes.RET, 54})
public class ve implements or {
    public static int c;
    public String n;
    public long tt = 0;
    public boolean uj;
    public long ve;

    public ve() {
        c++;
        this.n = "image_request_" + c;
    }

    @Override // com.byazt.yj.or
    public void onStepStart(String str, t tVar) {
        if (!this.uj) {
            tVar.getUrl();
            tVar.getWidth();
            tVar.getHeight();
            this.uj = true;
        }
        this.tt = System.currentTimeMillis();
        c(str, tVar);
    }

    @Override // com.byazt.yj.or
    public void onStepEnd(String str, t tVar) {
        this.ve += System.currentTimeMillis() - this.tt;
        c(str, tVar);
    }

    private String c(String str, t tVar) {
        com.byazt.oz.c cVarT;
        if (str == null) {
            return str;
        }
        str.hashCode();
        switch (str) {
            case "success":
                return OauthResult.RESULT_MSG_SUCCESS;
            case "raw_cache":
                return "查询RAW内存缓存";
            case "image_type":
                return "判断图片类型：";
            case "disk_cache":
                return "查询文件缓存";
            case "decode":
                return "解码";
            case "failed":
                if (!(tVar instanceof com.byazt.oz.ve) || (cVarT = ((com.byazt.oz.ve) tVar).t()) == null) {
                    return "失败";
                }
                Throwable thVe = cVarT.ve();
                return "失败：code:" + cVarT.c() + ", msg:" + cVarT.tt() + ", exception:" + (thVe != null ? thVe.getMessage() : "null \r\n");
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + tVar.getMemoryCacheKey();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }
}
