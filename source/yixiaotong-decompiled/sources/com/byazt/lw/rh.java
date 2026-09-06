package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 115})
public class rh extends nu {
    public static final ThreadLocal<StringBuilder> uj = new ThreadLocal<StringBuilder>() { // from class: com.byazt.lw.rh.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public rh() {
        super(com.byazt.zg.ve.PLUS);
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        Object objC;
        Object objC2 = this.c.c(map);
        if (objC2 == null || (objC = this.tt.c(map)) == null) {
            return null;
        }
        if ((objC2 instanceof String) || (objC instanceof String)) {
            StringBuilder sb = uj.get();
            sb.append(objC2).append(objC);
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        return com.byazt.kq.x.c((Number) objC2, (Number) objC);
    }
}
