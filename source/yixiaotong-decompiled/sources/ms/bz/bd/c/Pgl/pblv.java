package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class pblv {
    public static final int CLIENT_TYPE_BUSINESS = 1;
    public static final int CLIENT_TYPE_INHOUSE = 0;
    public static final int CLIENT_TYPE_UNKNOWN = -1;
    public static final int COLLECT_MODE_DEFAULT = 99999;
    public static final int COLLECT_MODE_ML_MINIMIZE = 290;
    public static final int COLLECT_MODE_ML_PGL_AL = 810;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f9703a = "";
    protected String b = "";
    protected String c = "";
    protected String d = "";
    protected String e = "";
    protected String f = "";
    protected String g = "";
    protected String h = "";
    protected String i = "";
    protected String j = null;
    protected int k = -1;
    protected int l = -1;
    protected int m = COLLECT_MODE_DEFAULT;
    protected Map<String, String> n = new HashMap();
    protected HashMap o = new HashMap();
    protected HashSet p = new HashSet();

    public interface pblb {
    }

    public static abstract class pgla<T extends pblb> extends pblv implements pblb {
        public pgla(String str, String str2, int i) {
            this.f9703a = str;
            this.i = str2;
            this.m = i;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("appID or license must be set.");
            }
            if (i != 99999 && i != 290 && i != 810) {
                throw new IllegalArgumentException("COLLECT_MODE is error ");
            }
        }

        public pgla(String str, String str2, String str3, int i) {
            this.g = str;
            this.h = str2;
            this.i = str3;
            this.m = i;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        protected final pgla a() {
            this.k = 1;
            return this;
        }

        public T addAdvanceInfo0(String str, String str2) {
            this.o.put(str, str2);
            return this;
        }

        public T addDataObserver(PglITokenObserver pglITokenObserver) {
            if (pglITokenObserver != null) {
                this.p.add(pglITokenObserver);
            }
            return this;
        }

        public T setBDDeviceID0(String str) {
            this.d = str;
            return this;
        }

        public T setChannel0(String str) {
            this.b = str;
            return this;
        }

        public T setClientType0(int i) {
            this.k = i;
            return this;
        }

        public T setCustomInfo0(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            this.n = map;
            return this;
        }

        public T setDeviceID0(String str) {
            this.c = str;
            return this;
        }

        public T setInstallID0(String str) {
            this.e = str;
            return this;
        }

        public T setOVRegionType0(int i) {
            this.l = i;
            return this;
        }

        public T setOaid0(String str) {
            if (!str.equals("timeout") && !str.equals("error")) {
                if (!str.isEmpty()) {
                    this.o.put("kOA1", "1");
                }
                return this;
            }
            this.o.put("kOA1", "1");
            str = null;
            this.j = str;
            return this;
        }

        public T setSecssionID0(String str) {
            this.f = str;
            return this;
        }
    }

    protected pblv() {
    }

    static String a(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }
}
