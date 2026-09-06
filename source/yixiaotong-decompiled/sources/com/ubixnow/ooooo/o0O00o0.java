package com.ubixnow.ooooo;

import android.content.Context;
import android.util.Log;
import androidx.core.text.util.LocalePreferences;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o0O00o0 extends o0oOO {
    public o0 OooO;
    public WeakReference<Context> OooO0o;
    public o0O0000O OooO0oO;
    public o0oOOo OooO0oo;
    public o00O0 OooOO0;
    private int OooOO0O;
    private int OooOO0o;
    private boolean OooOOO;
    private int OooOOO0;
    private o00O00OO.OooO0OO OooOOOO;
    private final String OooO0o0 = o0oOO.OooO00o;
    private final o0O0o OooOOOo = new OooO00o();
    private final o0O0o OooOOo0 = new OooO0O0();
    private final o0O0o OooOOo = new OooO0OO();

    public class OooO00o extends o0O0o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void getTokenFail(ErrorInfo errorInfo) {
            o0O00o0.this.OooOOOO.OooO00o(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void getTokenSucc(oo00o oo00oVar) {
            o0O00o0.this.OooOOOO.onSucc(oo00oVar.requestToken);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0O00o0.this.OooOOO0 = 2;
            o0O00o0.this.OooO00o(o0oOO.OooO00o, "server bidding 加载成功");
            o0O00o0 o0o00o0 = o0O00o0.this;
            o0o00o0.OooO00o(o0o00o0.OooOO0, (ErrorInfo) null, false);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o0O00o0.this.OooOOO0 = 3;
            o0O00o0.this.OooO00o(o0oOO.OooO00o, "server bidding 加载失败");
            o0O00o0 o0o00o0 = o0O00o0.this;
            o0o00o0.OooO00o(o0o00o0.OooOO0, errorInfo, false);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public class OooO0O0 extends o0O0o {
        public OooO0O0() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0O00o0.this.OooOO0O = 2;
            o0O00o0.this.OooO00o(o0oOO.OooO00o, ooooO000.OooO0OO("h8"));
            o0O00o0 o0o00o0 = o0O00o0.this;
            o0o00o0.OooO00o(o0o00o0.OooOO0, (ErrorInfo) null, false);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o0O00o0.this.OooOO0O = 3;
            o0O00o0.this.OooO00o(o0oOO.OooO00o, ooooO000.OooO0OO("h9"));
            o0O00o0 o0o00o0 = o0O00o0.this;
            o0o00o0.OooO00o(o0o00o0.OooOO0, errorInfo, false);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public class OooO0OO extends o0O0o {
        public OooO0OO() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0O00o0.this.OooOO0o = 2;
            o0O00o0.this.OooO00o(o0oOO.OooO00o, ooooO000.OooO0OO("h10"));
            o0O00o0 o0o00o0 = o0O00o0.this;
            o0o00o0.OooO00o(o0o00o0.OooOO0, (ErrorInfo) null, false);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o0O00o0.this.OooOO0o = 3;
            o0O00o0.this.OooO00o(o0oOO.OooO00o, ooooO000.OooO0OO(LocalePreferences.HourCycle.H11));
            o0O00o0 o0o00o0 = o0O00o0.this;
            o0o00o0.OooO00o(o0o00o0.OooOO0, errorInfo, false);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public o0O00o0(Context context) {
        this.OooO0o = new WeakReference<>(context);
        this.OooO0oO = new o0O0000O(context, this);
        this.OooO0oo = new o0oOOo(context, this);
        this.OooO = new o0(context, this);
    }

    private Object OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
        ErrorInfo errorInfo2;
        String str = "errorInfo:";
        try {
            o0OO000.OooO00o(o00o0);
            o00O00O o00o00o = o00o0.OooO0OO;
            o00o00o.OooOO0 = false;
            ConcurrentHashMap<String, o00OOO0O> concurrentHashMap = o00o00o.OooO0oo;
            ooooO000.OooO0O0(o0oOO.OooO00o, ooooO000.OooO0OO("h2") + concurrentHashMap.size());
            if (ooooO000.OooO00o) {
                for (o00OOO0O o00ooo0o : concurrentHashMap.values()) {
                    String str2 = str;
                    try {
                        str = str2;
                        ooooO000.OooO0O0(o0oOO.OooO00o, ooooO000.OooO0OO("h3") + OooO00o(o00ooo0o.OooO0OO) + "   广告类型：" + o00ooo0o.OooO0O0.getUbixInfo().adType + "   price:" + o00ooo0o.OooO00o + "   广告源:" + o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o.OooO0OO + "   cacheKey:" + o00ooo0o.OooO0oo + "   uid:" + o00ooo0o.OooO0oO + "   requestId:" + o00ooo0o.OooO);
                    } catch (Exception e) {
                        e = e;
                        str = str2;
                        ErrorInfo errorInfo3 = new ErrorInfo(o0OO000o.o0000Oo, "获取异常：" + e.getMessage());
                        Log.e(ooooO000.OooO0O0, e.getMessage());
                        errorInfo2 = errorInfo3;
                        ooooO000.OooO0O0(o0oOO.OooO00o, str + errorInfo2);
                        return errorInfo2;
                    }
                }
            }
            o0o0Oo.OooO00o(o00o0, concurrentHashMap);
            OooO0O0(concurrentHashMap);
            if (concurrentHashMap.size() <= 0) {
                Log.e(ooooO000.OooO0O0, str + errorInfo);
                return errorInfo == null ? new ErrorInfo(o0OO000o.o0000Oo, o0OO000o.o0000OoO) : errorInfo;
            }
            String strOooO00o = OooO00o(concurrentHashMap);
            o00OOO0O o00ooo0o2 = concurrentHashMap.get(strOooO00o);
            if (o00ooo0o2 == null) {
                errorInfo2 = new ErrorInfo(o0OO000o.o0000Oo, "获取异常：没有拿到返回结果");
                ooooO000.OooO0O0(o0oOO.OooO00o, str + errorInfo2);
                return errorInfo2;
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0(o0oOO.OooO00o, ooooO000.OooO0OO("h4") + concurrentHashMap.size());
                ooooO000.OooO0O0(o0oOO.OooO00o, ooooO000.OooO0OO("h5") + OooO00o(o00ooo0o2.OooO0OO) + "广告类型：" + o00ooo0o2.OooO0O0.getUbixInfo().adType + "   price:" + o00ooo0o2.OooO00o + "   广告源:" + o00ooo0o2.OooO0O0.mBaseAdConfig.OooO00o.OooO0OO + "   cacheKey:" + o00ooo0o2.OooO0oo + "   uid:" + o00ooo0o2.OooO0oO + "   requestId:" + o00ooo0o2.OooO);
            }
            concurrentHashMap.remove(strOooO00o);
            OooO00o(o00o0, concurrentHashMap, o00ooo0o2);
            ooooO000.OooO0O0(o0oOO.OooO00o, ooooO000.OooO0OO("h6") + concurrentHashMap.size());
            oo0O.OooO00o(o00o0, o00ooo0o2, concurrentHashMap, new o00OO0OO());
            o0o0Oo.OooO00o(o00o0, (Map<String, o00OOO0O>) concurrentHashMap);
            ooooO000.OooO0O0(o0oOO.OooO00o, "resultBean:" + o00ooo0o2);
            return o00ooo0o2;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String OooO00o(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(j));
    }

    private String OooO00o(ConcurrentHashMap<String, o00OOO0O> concurrentHashMap) {
        String key = "";
        long j = 0;
        long j2 = 0;
        for (Map.Entry<String, o00OOO0O> entry : concurrentHashMap.entrySet()) {
            if (j < entry.getValue().OooO00o || (j == entry.getValue().OooO00o && j2 < entry.getValue().OooO0OO)) {
                j = entry.getValue().OooO00o;
                key = entry.getKey();
                j2 = entry.getValue().OooO0OO;
            }
        }
        return key;
    }

    private String OooO00o(ConcurrentHashMap<String, o00OOO0O> concurrentHashMap, int i) {
        String str;
        String key = "";
        if (System.currentTimeMillis() - oOO000o.OooO0Oo(BaseUtils.getContext(), oO00000o.o00000O0.Oooo0 + this.OooOO0.OooO0Oo.OooO00o.slotId) < this.OooOO0.OooO0OO.OooOOOO.OooOO0.OooO0o) {
            OooO00o(o0oOO.OooO00o, "ds:时间尚未达到");
            return "";
        }
        long j = 0;
        long j2 = 0;
        for (Map.Entry<String, o00OOO0O> entry : concurrentHashMap.entrySet()) {
            if (entry.getValue().OooO0O0.mBaseAdConfig.OooO00o.OooO0OO == i) {
                str = "ds:过滤1";
            } else if (entry.getValue().OooO0O0.originType != 2) {
                str = "ds:过滤2";
            } else if (j < entry.getValue().OooO00o || (j == entry.getValue().OooO00o && j2 < entry.getValue().OooO0OO)) {
                j = entry.getValue().OooO00o;
                key = entry.getKey();
                j2 = entry.getValue().OooO0OO;
            }
            OooO00o(o0oOO.OooO00o, str);
        }
        return key;
    }

    private void OooO00o(o00O0 o00o0, ConcurrentHashMap<String, o00OOO0O> concurrentHashMap, o00OOO0O o00ooo0o) {
        if (!o00o0.OooO0OO.OooOOOO.OooOO0.OooO0o0) {
            ooooO000.OooO0OO(o0oOO.OooO00o, "handleRecycleAd e:false");
            return;
        }
        ooooO000.OooO0OO(o0oOO.OooO00o, "handleRecycleAd e:true");
        String strOooO00o = OooO00o(concurrentHashMap, o00ooo0o.OooO0O0.mBaseAdConfig.OooO00o.OooO0OO);
        o00OOO0O o00ooo0o2 = concurrentHashMap.get(strOooO00o);
        if (o00o0.OooOOOo == null || o00ooo0o2 == null) {
            return;
        }
        concurrentHashMap.remove(strOooO00o);
        oo00o ubixInfo = o00ooo0o2.OooO0O0.getUbixInfo();
        ubixInfo.dsInfo.OooO00o = true;
        o00o0.OooOOOo.onMoreAdSucc(ubixInfo);
    }

    private void OooO0O0(ConcurrentHashMap<String, o00OOO0O> concurrentHashMap) {
        try {
            Iterator<Map.Entry<String, o00OOO0O>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, o00OOO0O> next = it.next();
                if (!next.getValue().OooO0O0.isValid()) {
                    ooooO000.OooO0O0(o0oOO.OooO00o, "ad invalid，destroy");
                    next.getValue().OooO0O0.destory();
                    OooO00o(this.OooOO0, next.getValue().OooO0O0.getUbixInfo(), o0OO000o.o000000o, "isReady false");
                    it.remove();
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001b A[Catch: all -> 0x0088, Exception -> 0x008a, TRY_LEAVE, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x001f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0032 A[Catch: all -> 0x0088, Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0036 A[Catch: all -> 0x0088, Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0052 A[Catch: all -> 0x0088, Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x005b A[Catch: all -> 0x0088, Exception -> 0x008a, TRY_ENTER, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0061 A[Catch: all -> 0x0088, Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x006b A[Catch: all -> 0x0088, Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0079 A[Catch: all -> 0x0088, Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x000e, B:12:0x0012, B:14:0x0016, B:16:0x001b, B:19:0x0021, B:21:0x0032, B:23:0x0036, B:25:0x0044, B:27:0x0048, B:29:0x0052, B:30:0x0057, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:41:0x0084, B:40:0x0079), top: B:54:0x0006, outer: #1 }] */
    public synchronized oo00o OooO00o(o00O0 o00o0, ErrorInfo errorInfo, boolean z) {
        Object objOooO00o;
        o00O00o0 o00o00o0;
        ErrorInfo errorInfo2;
        oo00o ubixInfo;
        o00O00O o00o00o;
        o0O0OOO0 o0o0ooo0;
        if (!z) {
            try {
                if ((this.OooOO0O != 0 && this.OooOO0o != 0 && o00o0.OooOOO == 1) || (this.OooOOO0 != 0 && o00o0.OooOOO == 2)) {
                    if (!this.OooOOO) {
                        OooO00o(o0oOO.OooO00o, ooooO000.OooO0OO("h7"));
                        this.OooOOO = true;
                        objOooO00o = OooO00o(o00o0, errorInfo);
                        if (objOooO00o != null) {
                            if (objOooO00o instanceof o00OOO0O) {
                                ubixInfo = ((o00OOO0O) objOooO00o).OooO0O0.getUbixInfo();
                                o00o0.OooOO0 = ubixInfo;
                                o00o00o = o00o0.OooO0OO;
                                if (o00o00o != null && (o0o0ooo0 = o00o00o.OooOOOO) != null) {
                                    ubixInfo.isRepeatClick = o0o0ooo0.OooO0o;
                                    ubixInfo.isCf = o0o0ooo0.OooO0oO;
                                }
                                if (!z) {
                                    o00o0.OooOOOo.onCallbackAdLoaded(ubixInfo);
                                }
                                return o00o0.OooOO0;
                            }
                            if (objOooO00o instanceof ErrorInfo) {
                                if (!z) {
                                    o00o0.OooOOOo.onCallbackNoAdError((ErrorInfo) objOooO00o);
                                }
                            } else if (!z) {
                                o00o00o0 = o00o0.OooOOOo;
                                errorInfo2 = new ErrorInfo(o0OO000o.o0000Oo, "发生未知异常.");
                                o00o00o0.onCallbackNoAdError(errorInfo2);
                            }
                        } else if (!z) {
                            o00o00o0 = o00o0.OooOOOo;
                            errorInfo2 = new ErrorInfo(o0OO000o.o0000Oo, "发生未知异常..");
                            o00o00o0.onCallbackNoAdError(errorInfo2);
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(ooooO000.OooO0O0, "获取异常" + e.getMessage());
                if (!z) {
                    o00o0.OooOOOo.onCallbackNoAdError(new ErrorInfo(o0OO000o.o0000Oo, "发生未知异常..."));
                }
            }
        } else if (!this.OooOOO) {
            OooO00o(o0oOO.OooO00o, ooooO000.OooO0OO("h7"));
            this.OooOOO = true;
            objOooO00o = OooO00o(o00o0, errorInfo);
            if (objOooO00o != null) {
                if (objOooO00o instanceof o00OOO0O) {
                    ubixInfo = ((o00OOO0O) objOooO00o).OooO0O0.getUbixInfo();
                    o00o0.OooOO0 = ubixInfo;
                    o00o00o = o00o0.OooO0OO;
                    if (o00o00o != null) {
                        ubixInfo.isRepeatClick = o0o0ooo0.OooO0o;
                        ubixInfo.isCf = o0o0ooo0.OooO0oO;
                    }
                    if (!z) {
                        o00o0.OooOOOo.onCallbackAdLoaded(ubixInfo);
                    }
                    return o00o0.OooOO0;
                }
                if (objOooO00o instanceof ErrorInfo) {
                    if (!z) {
                        o00o0.OooOOOo.onCallbackNoAdError((ErrorInfo) objOooO00o);
                    }
                } else if (!z) {
                    o00o00o0 = o00o0.OooOOOo;
                    errorInfo2 = new ErrorInfo(o0OO000o.o0000Oo, "发生未知异常.");
                    o00o00o0.onCallbackNoAdError(errorInfo2);
                }
            } else if (!z) {
                o00o00o0 = o00o0.OooOOOo;
                errorInfo2 = new ErrorInfo(o0OO000o.o0000Oo, "发生未知异常..");
                o00o00o0.onCallbackNoAdError(errorInfo2);
            }
        }
        return null;
    }

    public void OooO00o(o00O0 o00o0, o00O00OO.OooO0OO oooO0OO) {
        this.OooOO0 = o00o0;
        if (OooO00o(o00o0)) {
            return;
        }
        OooO00o(o0oOO.OooO00o, "开始获取广告源的token");
        this.OooOOOO = oooO0OO;
        this.OooO.OooO00o(o00o0, this.OooOOOo);
    }

    public void OooO0O0(o00O0 o00o0) {
        this.OooOO0 = o00o0;
        if (OooO00o(o00o0)) {
            return;
        }
        OooO00o(o0oOO.OooO00o, ooooO000.OooO0OO("h1"));
        int i = o00o0.OooO0oo;
        if (i == 0) {
            this.OooOOO0 = 1;
        }
        if (o00o0.OooO0oO == 0) {
            this.OooOO0O = 1;
        }
        if (o00o0.OooO == 0) {
            this.OooOO0o = 1;
        }
        if (i > 0) {
            this.OooO.OooO0O0(o00o0, this.OooOOOo);
        }
        if (o00o0.OooO0oO > 0) {
            this.OooO0oo.OooO00o(o00o0, this.OooOOo0);
        }
        if (o00o0.OooO > 0) {
            this.OooO0oO.OooO00o(o00o0, this.OooOOo);
        }
    }
}
