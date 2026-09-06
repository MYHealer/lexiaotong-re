package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.core.bean.UMNAdsMaterialInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O00oO0 {

    public static class OooO00o {
        private UMNAdsMaterialInfo OooO00o;

        public OooO00o OooO00o(o0O0o0 o0o0o0) {
            if (o0o0o0 != null) {
                o0o0o0.OooO00o();
                this.OooO00o = o0o0o0.OooO0OO;
            }
            return this;
        }

        public HashMap<String, Object> OooO00o() {
            HashMap<String, Object> map = new HashMap<>();
            UMNAdsMaterialInfo uMNAdsMaterialInfo = this.OooO00o;
            if (uMNAdsMaterialInfo != null) {
                map.put("a_m_i", uMNAdsMaterialInfo);
            }
            return map;
        }
    }

    public static class OooO0O0 {
        private String OooO00o = "";
        private String OooO0O0 = "";

        public OooO0O0 OooO00o(String str) {
            this.OooO00o = str;
            return this;
        }

        public HashMap<String, String> OooO00o() {
            HashMap<String, String> map = new HashMap<>();
            if (!TextUtils.isEmpty(this.OooO00o)) {
                map.put("platform_name", this.OooO00o);
            }
            if (!TextUtils.isEmpty(this.OooO0O0)) {
                map.put("platform_slot_id", this.OooO0O0);
            }
            return map;
        }

        public OooO0O0 OooO0O0(String str) {
            this.OooO0O0 = str;
            return this;
        }
    }
}
