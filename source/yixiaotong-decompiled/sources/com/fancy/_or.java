package com.fancy;

import androidx.core.app.NotificationCompat;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.huawei.openalliance.ad.constant.x;
import com.ubixnow.ooooo.o0OO000o;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _or {
    public JSONObject _a;
    public Error _b;

    public _or() {
        JSONObject jSONObject = new JSONObject();
        this._a = jSONObject;
        try {
            synchronized (jSONObject) {
                this._a.put(NotificationCompat.CATEGORY_ERROR, 0);
                this._a.put("env", com.fancy.adsdk.lib.utils._a._b());
                this._a.put("support", PtgAdSdk.getConfig().isSupport());
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage()));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public _or(int i) {
        this();
        _ot _otVar = _ot._a;
        this._b = _otVar;
    }

    public final String _a(String str) {
        try {
            synchronized (this._a) {
                JSONObject jSONObject = this._a;
                if (jSONObject == null) {
                    return "";
                }
                Object objOpt = jSONObject.opt(str);
                return objOpt == null ? "" : objOpt.toString();
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public final void _a(Object obj, String str) {
        try {
            synchronized (this._a) {
                try {
                    if (TextUtil.isNotEmpty(str)) {
                        this._a.put(str, obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(String str) {
        try {
            synchronized (this._a) {
                this._a.put("appVersionCode", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _c(String str) {
        try {
            synchronized (this._a) {
                this._a.put("appVersion", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _d(String str) {
        try {
            synchronized (this._a) {
                this._a.put("bidLossReason", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _e(String str) {
        try {
            synchronized (this._a) {
                this._a.put("consumerSlotId", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _f(String str) {
        try {
            synchronized (this._a) {
                this._a.put("consumerType", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _g(String str) {
        try {
            synchronized (this._a) {
                this._a.put("errorMessage", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _h(String str) {
        try {
            synchronized (this._a) {
                this._a.put("filterMessage", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _i(String str) {
        try {
            synchronized (this._a) {
                try {
                    this._a.put("mediaId", Long.valueOf(str).longValue());
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _j(String str) {
        try {
            synchronized (this._a) {
                this._a.put("policyVersion", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _k(String str) {
        try {
            synchronized (this._a) {
                this._a.put("sdkVersion", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _l(String str) {
        try {
            synchronized (this._a) {
                this._a.put("sdkVersionName", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _m(String str) {
        try {
            synchronized (this._a) {
                this._a.put("slotId", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _n(String str) {
        try {
            synchronized (this._a) {
                this._a.put(o0OO000o.o00O00oO, str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _a(int i) {
        try {
            synchronized (this._a) {
                this._a.put(x.cy, i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(long j) {
        try {
            synchronized (this._a) {
                this._a.put("consumerPrice", j);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _c(int i) {
        try {
            synchronized (this._a) {
                this._a.put("layer", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _d(int i) {
        try {
            synchronized (this._a) {
                this._a.put("priority", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _e(int i) {
        try {
            synchronized (this._a) {
                this._a.put(NotificationCompat.CATEGORY_ERROR, i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _f(int i) {
        try {
            synchronized (this._a) {
                this._a.put("errorType", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _g(int i) {
        try {
            synchronized (this._a) {
                this._a.put("filterCode", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _h(int i) {
        try {
            synchronized (this._a) {
                this._a.put("successType", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _a(long j) {
        try {
            synchronized (this._a) {
                this._a.put("consumerOrgPrice", j);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(int i) {
        try {
            synchronized (this._a) {
                this._a.put("ct", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _a(double d) {
        try {
            synchronized (this._a) {
                this._a.put("costPrice", d);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(double d) {
        try {
            synchronized (this._a) {
                this._a.put("secondPrice", d);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
            }
        }
    }
}
