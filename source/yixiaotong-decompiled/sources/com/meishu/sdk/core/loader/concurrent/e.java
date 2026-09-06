package com.meishu.sdk.core.loader.concurrent;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.google.gson.Gson;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.domain.SdkMonitor;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.loader.cache.CacheManager;
import com.meishu.sdk.core.loader.serverbidding.S2SBManager;
import com.meishu.sdk.core.loader.serverbidding.S2sbCacheEntity;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.PackageBean;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.s;
import com.meishu.sdk.core.utils.z;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.IBidding;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConCurrentManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4812a;
    public MeishuAdInfo b;
    public Map<String, Object> c;
    public com.meishu.sdk.core.loader.strategy.a d;
    public com.meishu.sdk.core.loader.c e;
    public com.meishu.sdk.core.loader.d f;
    public boolean g;
    public long h;
    public boolean j;
    public boolean m;
    public Handler i = new Handler(Looper.getMainLooper());
    public List<com.meishu.sdk.core.loader.cache.a> k = new LinkedList();
    public List<com.meishu.sdk.core.loader.loadbean.a> l = new ArrayList();

    /* JADX INFO: compiled from: ConCurrentManager.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4814a;

        static {
            int[] iArr = new int[AdType.values().length];
            f4814a = iArr;
            try {
                iArr[AdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4814a[AdType.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4814a[AdType.REWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4814a[AdType.FEED_MIX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4814a[AdType.INTERSTITIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4814a[AdType.FULL_SCREEN_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public e(Context context, com.meishu.sdk.core.loader.c cVar, MeishuAdInfo meishuAdInfo, Map<String, Object> map) {
        this.f4812a = context;
        this.b = meishuAdInfo;
        this.c = map;
        this.e = cVar;
    }

    public final void a(com.meishu.sdk.core.loader.cache.a aVar) {
        try {
            Object obj = aVar.d;
            SdkAdInfo sdkAdInfo = aVar.b;
            if (MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                if ("bidding".equals(sdkAdInfo.getOtype())) {
                    if (obj instanceof com.meishu.sdk.core.ad.a) {
                        Object sdkAd = ((com.meishu.sdk.core.ad.a) obj).getSdkAd();
                        if ((sdkAd instanceof IBidding) && sdkAdInfo.getCodPrice() > 0 && sdkAdInfo.getEcpm() > sdkAdInfo.getCodPrice()) {
                            HashMap map = new HashMap();
                            map.put("expectCostPrice", Integer.valueOf(sdkAdInfo.getOriginEcpm()));
                            map.put("highestLossPrice", Integer.valueOf(Math.min(sdkAdInfo.getPrice(), sdkAdInfo.getOriginEcpm())));
                            ((IBidding) sdkAd).sendWinNotification(map);
                        }
                    }
                } else if (!TextUtils.isEmpty(sdkAdInfo.getS2sb())) {
                    ArrayList arrayList = (ArrayList) a(sdkAdInfo.getCodPrice());
                    if (arrayList.size() > 0) {
                        a(sdkAdInfo, ((Integer) arrayList.get(0)).intValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean b(SdkAdInfo[] sdkAdInfoArr, MeishuAdInfo meishuAdInfo) {
        String cacheKey = meishuAdInfo.getCacheKey();
        if (meishuAdInfo.getCache() > 0) {
            CacheManager cacheManager = CacheManager.INSTANCE;
            if (cacheManager.getFirstEntity(cacheKey) != null) {
                cacheManager.getFirstEntity(cacheKey);
            }
            while (true) {
                CacheManager cacheManager2 = CacheManager.INSTANCE;
                if (cacheManager2.getCacheListByKey(cacheKey) == null || cacheManager2.getCacheListByKey(cacheKey).size() <= 0) {
                    break;
                }
                com.meishu.sdk.core.loader.cache.a firstEntity = cacheManager2.getFirstEntity(cacheKey);
                if (firstEntity != null && firstEntity.a()) {
                    if (this.f != null && firstEntity.c <= meishuAdInfo.getCacheScore()) {
                        this.g = true;
                        meishuAdInfo.setUsed(true);
                        a(false);
                        return true;
                    }
                    cacheManager2.removeFirstEntity(cacheKey);
                    try {
                        this.g = true;
                        this.j = true;
                        Object obj = firstEntity.d;
                        a(firstEntity);
                        new com.meishu.sdk.core.loader.cache.b().a(this.f4812a, firstEntity, this.b.getReq_id(), this.e.startLoadTime, this.b.getSdk_monitor());
                        if (this.e.getLoaderListener() != null) {
                            this.e.getLoaderListener().onAdLoaded(obj);
                            this.e.getLoaderListener().onAdReady(obj);
                            if (obj instanceof com.meishu.sdk.core.ad.a) {
                                ((com.meishu.sdk.core.ad.a) obj).setCacheAdListener(new com.meishu.sdk.core.loader.concurrent.a(this, firstEntity));
                            }
                            this.i.post(new com.meishu.sdk.core.loader.concurrent.b(this, obj));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.g = false;
                        this.j = false;
                    }
                    if (sdkAdInfoArr != null) {
                        break;
                    }
                    a(true);
                    return true;
                }
            }
        } else {
            CacheManager.INSTANCE.remove(cacheKey);
        }
        return false;
    }

    /* JADX INFO: compiled from: ConCurrentManager.java */
    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4813a;
        public final /* synthetic */ boolean[] b;

        public a(boolean z, boolean[] zArr) {
            this.f4813a = z;
            this.b = zArr;
        }

        @Override // com.meishu.sdk.core.loader.concurrent.f
        public void onAdExposure() {
            boolean[] zArr = this.b;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            try {
                s.a(e.this.b.getBakUrls(), e.this.f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.core.loader.concurrent.f
        public void a(AdPlatformError adPlatformError, int i) {
            if (this.f4813a || e.this.e.getLoaderListener() == null) {
                return;
            }
            LogUtil.e("ConCurrentManager", "Meishu___onAdError");
            e.this.e.getLoaderListener().onAdError();
        }

        @Override // com.meishu.sdk.core.loader.concurrent.f
        public void b(Object obj, int i) {
            if (this.f4813a || e.this.e.getLoaderListener() == null) {
                return;
            }
            e.this.e.getLoaderListener().onAdLoaded(obj);
        }

        @Override // com.meishu.sdk.core.loader.concurrent.f
        public void a(Object obj, int i) {
            if (this.f4813a) {
                String cacheKey = e.this.b.getCacheKey();
                e.this.k.clear();
                com.meishu.sdk.core.loader.cache.a aVar = new com.meishu.sdk.core.loader.cache.a();
                MeishuAdInfo meishuAdInfo = e.this.b;
                aVar.h = meishuAdInfo;
                aVar.d = obj;
                aVar.f4807a = cacheKey;
                aVar.e = true;
                aVar.f = meishuAdInfo.getLoadedTime();
                aVar.g = e.this.b.getExpire_timestamp();
                SdkAdInfo sdkAdInfo = new SdkAdInfo();
                sdkAdInfo.setSdk("MS");
                aVar.b = sdkAdInfo;
                aVar.c = e.this.b.getCacheScore();
                e.this.k.add(aVar);
                CacheManager cacheManager = CacheManager.INSTANCE;
                e eVar = e.this;
                cacheManager.handleCurrentList(cacheKey, eVar.k, eVar.b.getCache());
                return;
            }
            e eVar2 = e.this;
            if (eVar2.j) {
                return;
            }
            eVar2.j = true;
            e eVar3 = e.this;
            com.meishu.sdk.core.loader.strategy.a aVar2 = eVar3.d;
            if (aVar2 != null) {
                ((com.meishu.sdk.core.loader.strategy.e) aVar2).r = true;
            }
            if (eVar3.e.getLoaderListener() != null) {
                e.this.e.getLoaderListener().onAdReady(obj);
            }
            e.a(e.this, obj);
        }

        @Override // com.meishu.sdk.core.loader.concurrent.f
        public void a(String str, int i, int i2) {
            if (this.f4813a) {
                return;
            }
            if (e.this.e.getAdType() != AdType.SPLASH) {
                try {
                    o1.b(e.this.b.getEventUrl(), i, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.e.getLoaderListener() != null) {
                e.this.e.getLoaderListener().onAdRenderFail(str, i);
            }
        }
    }

    public static void a(e eVar, Object obj) {
        eVar.getClass();
        if ((obj instanceof com.meishu.sdk.core.ad.splash.c) && ((Boolean) eVar.c.get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue()) {
            com.meishu.sdk.core.loader.c cVar = eVar.e;
            if (cVar instanceof SplashAdLoader) {
                ((com.meishu.sdk.core.ad.splash.c) obj).showAd(((SplashAdLoader) cVar).getAdContainer());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0193 A[Catch: all -> 0x01aa, TryCatch #2 {all -> 0x01aa, blocks: (B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4), top: B:231:0x0176, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x01fc A[Catch: all -> 0x030a, TryCatch #1 {all -> 0x030a, blocks: (B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6), top: B:229:0x01da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x023b A[Catch: all -> 0x030a, TryCatch #1 {all -> 0x030a, blocks: (B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6), top: B:229:0x01da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0247 A[Catch: all -> 0x030a, TryCatch #1 {all -> 0x030a, blocks: (B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6), top: B:229:0x01da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02ae A[Catch: all -> 0x030a, TryCatch #1 {all -> 0x030a, blocks: (B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6), top: B:229:0x01da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x02ba A[Catch: all -> 0x030a, TryCatch #1 {all -> 0x030a, blocks: (B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6), top: B:229:0x01da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x030e A[Catch: all -> 0x0555, TryCatch #12 {, blocks: (B:4:0x0003, B:29:0x004e, B:30:0x0057, B:32:0x005e, B:108:0x01ae, B:139:0x030e, B:141:0x0314, B:143:0x031a, B:144:0x0322, B:145:0x0325, B:150:0x03b3, B:178:0x047d, B:177:0x047a, B:149:0x03b0, B:138:0x030b, B:107:0x01ab, B:95:0x0173, B:75:0x011b, B:59:0x00d6, B:40:0x008b, B:179:0x0499, B:180:0x049c, B:217:0x054f, B:221:0x0553, B:222:0x0554, B:28:0x004b, B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6, B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4, B:33:0x0065, B:35:0x006f, B:37:0x0082, B:146:0x034f, B:5:0x0009, B:11:0x0018, B:13:0x001e, B:26:0x0045, B:10:0x0013, B:181:0x049d, B:183:0x04ac, B:184:0x04ae, B:216:0x0542, B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c, B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c, B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf, B:151:0x03ba, B:153:0x03c6, B:155:0x03cc, B:157:0x03da, B:159:0x03e0, B:160:0x03e5, B:161:0x03e9, B:163:0x03ef, B:165:0x0403, B:167:0x0411, B:168:0x0415, B:170:0x0423, B:173:0x0441, B:174:0x0446, B:171:0x0439, B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:250:0x0003, inners: #1, #2, #3, #6, #7, #8, #9, #11, #13, #14 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0314 A[Catch: all -> 0x0555, TryCatch #12 {, blocks: (B:4:0x0003, B:29:0x004e, B:30:0x0057, B:32:0x005e, B:108:0x01ae, B:139:0x030e, B:141:0x0314, B:143:0x031a, B:144:0x0322, B:145:0x0325, B:150:0x03b3, B:178:0x047d, B:177:0x047a, B:149:0x03b0, B:138:0x030b, B:107:0x01ab, B:95:0x0173, B:75:0x011b, B:59:0x00d6, B:40:0x008b, B:179:0x0499, B:180:0x049c, B:217:0x054f, B:221:0x0553, B:222:0x0554, B:28:0x004b, B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6, B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4, B:33:0x0065, B:35:0x006f, B:37:0x0082, B:146:0x034f, B:5:0x0009, B:11:0x0018, B:13:0x001e, B:26:0x0045, B:10:0x0013, B:181:0x049d, B:183:0x04ac, B:184:0x04ae, B:216:0x0542, B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c, B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c, B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf, B:151:0x03ba, B:153:0x03c6, B:155:0x03cc, B:157:0x03da, B:159:0x03e0, B:160:0x03e5, B:161:0x03e9, B:163:0x03ef, B:165:0x0403, B:167:0x0411, B:168:0x0415, B:170:0x0423, B:173:0x0441, B:174:0x0446, B:171:0x0439, B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:250:0x0003, inners: #1, #2, #3, #6, #7, #8, #9, #11, #13, #14 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x031a A[Catch: all -> 0x0555, TryCatch #12 {, blocks: (B:4:0x0003, B:29:0x004e, B:30:0x0057, B:32:0x005e, B:108:0x01ae, B:139:0x030e, B:141:0x0314, B:143:0x031a, B:144:0x0322, B:145:0x0325, B:150:0x03b3, B:178:0x047d, B:177:0x047a, B:149:0x03b0, B:138:0x030b, B:107:0x01ab, B:95:0x0173, B:75:0x011b, B:59:0x00d6, B:40:0x008b, B:179:0x0499, B:180:0x049c, B:217:0x054f, B:221:0x0553, B:222:0x0554, B:28:0x004b, B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6, B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4, B:33:0x0065, B:35:0x006f, B:37:0x0082, B:146:0x034f, B:5:0x0009, B:11:0x0018, B:13:0x001e, B:26:0x0045, B:10:0x0013, B:181:0x049d, B:183:0x04ac, B:184:0x04ae, B:216:0x0542, B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c, B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c, B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf, B:151:0x03ba, B:153:0x03c6, B:155:0x03cc, B:157:0x03da, B:159:0x03e0, B:160:0x03e5, B:161:0x03e9, B:163:0x03ef, B:165:0x0403, B:167:0x0411, B:168:0x0415, B:170:0x0423, B:173:0x0441, B:174:0x0446, B:171:0x0439, B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:250:0x0003, inners: #1, #2, #3, #6, #7, #8, #9, #11, #13, #14 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0322 A[Catch: all -> 0x0555, TryCatch #12 {, blocks: (B:4:0x0003, B:29:0x004e, B:30:0x0057, B:32:0x005e, B:108:0x01ae, B:139:0x030e, B:141:0x0314, B:143:0x031a, B:144:0x0322, B:145:0x0325, B:150:0x03b3, B:178:0x047d, B:177:0x047a, B:149:0x03b0, B:138:0x030b, B:107:0x01ab, B:95:0x0173, B:75:0x011b, B:59:0x00d6, B:40:0x008b, B:179:0x0499, B:180:0x049c, B:217:0x054f, B:221:0x0553, B:222:0x0554, B:28:0x004b, B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6, B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4, B:33:0x0065, B:35:0x006f, B:37:0x0082, B:146:0x034f, B:5:0x0009, B:11:0x0018, B:13:0x001e, B:26:0x0045, B:10:0x0013, B:181:0x049d, B:183:0x04ac, B:184:0x04ae, B:216:0x0542, B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c, B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c, B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf, B:151:0x03ba, B:153:0x03c6, B:155:0x03cc, B:157:0x03da, B:159:0x03e0, B:160:0x03e5, B:161:0x03e9, B:163:0x03ef, B:165:0x0403, B:167:0x0411, B:168:0x0415, B:170:0x0423, B:173:0x0441, B:174:0x0446, B:171:0x0439, B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:250:0x0003, inners: #1, #2, #3, #6, #7, #8, #9, #11, #13, #14 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x03c6 A[Catch: all -> 0x0479, TryCatch #13 {all -> 0x0479, blocks: (B:151:0x03ba, B:153:0x03c6, B:155:0x03cc, B:157:0x03da, B:159:0x03e0, B:160:0x03e5, B:161:0x03e9, B:163:0x03ef, B:165:0x0403, B:167:0x0411, B:168:0x0415, B:170:0x0423, B:173:0x0441, B:174:0x0446, B:171:0x0439), top: B:251:0x03ba, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x04ac A[Catch: all -> 0x0552, TryCatch #8 {, blocks: (B:181:0x049d, B:183:0x04ac, B:184:0x04ae, B:216:0x0542, B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c), top: B:242:0x049d, outer: #12, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:188:0x04d1 A[Catch: all -> 0x0541, TryCatch #0 {all -> 0x0541, blocks: (B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c), top: B:227:0x04b6, outer: #8, inners: #4, #10 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x04d9 A[Catch: all -> 0x0541, TryCatch #0 {all -> 0x0541, blocks: (B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c), top: B:227:0x04b6, outer: #8, inners: #4, #10 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x04f4 A[Catch: all -> 0x0541, TryCatch #0 {all -> 0x0541, blocks: (B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c), top: B:227:0x04b6, outer: #8, inners: #4, #10 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:198:0x0500 A[Catch: all -> 0x0541, TryCatch #0 {all -> 0x0541, blocks: (B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c), top: B:227:0x04b6, outer: #8, inners: #4, #10 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x0514 A[Catch: Exception -> 0x051b, all -> 0x0541, TRY_LEAVE, TryCatch #10 {Exception -> 0x051b, blocks: (B:200:0x0508, B:202:0x0514), top: B:246:0x0508, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x053b A[Catch: all -> 0x0541, TRY_LEAVE, TryCatch #0 {all -> 0x0541, blocks: (B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c), top: B:227:0x04b6, outer: #8, inners: #4, #10 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x049d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x047d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x004e A[Catch: all -> 0x0555, TryCatch #12 {, blocks: (B:4:0x0003, B:29:0x004e, B:30:0x0057, B:32:0x005e, B:108:0x01ae, B:139:0x030e, B:141:0x0314, B:143:0x031a, B:144:0x0322, B:145:0x0325, B:150:0x03b3, B:178:0x047d, B:177:0x047a, B:149:0x03b0, B:138:0x030b, B:107:0x01ab, B:95:0x0173, B:75:0x011b, B:59:0x00d6, B:40:0x008b, B:179:0x0499, B:180:0x049c, B:217:0x054f, B:221:0x0553, B:222:0x0554, B:28:0x004b, B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6, B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4, B:33:0x0065, B:35:0x006f, B:37:0x0082, B:146:0x034f, B:5:0x0009, B:11:0x0018, B:13:0x001e, B:26:0x0045, B:10:0x0013, B:181:0x049d, B:183:0x04ac, B:184:0x04ae, B:216:0x0542, B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c, B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c, B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf, B:151:0x03ba, B:153:0x03c6, B:155:0x03cc, B:157:0x03da, B:159:0x03e0, B:160:0x03e5, B:161:0x03e9, B:163:0x03ef, B:165:0x0403, B:167:0x0411, B:168:0x0415, B:170:0x0423, B:173:0x0441, B:174:0x0446, B:171:0x0439, B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:250:0x0003, inners: #1, #2, #3, #6, #7, #8, #9, #11, #13, #14 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x005e A[Catch: all -> 0x0555, TRY_LEAVE, TryCatch #12 {, blocks: (B:4:0x0003, B:29:0x004e, B:30:0x0057, B:32:0x005e, B:108:0x01ae, B:139:0x030e, B:141:0x0314, B:143:0x031a, B:144:0x0322, B:145:0x0325, B:150:0x03b3, B:178:0x047d, B:177:0x047a, B:149:0x03b0, B:138:0x030b, B:107:0x01ab, B:95:0x0173, B:75:0x011b, B:59:0x00d6, B:40:0x008b, B:179:0x0499, B:180:0x049c, B:217:0x054f, B:221:0x0553, B:222:0x0554, B:28:0x004b, B:110:0x01da, B:112:0x01fc, B:114:0x0208, B:115:0x0233, B:117:0x023b, B:119:0x0247, B:121:0x0253, B:123:0x025f, B:125:0x026b, B:127:0x0277, B:130:0x0282, B:131:0x02ae, B:133:0x02ba, B:135:0x02e6, B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4, B:33:0x0065, B:35:0x006f, B:37:0x0082, B:146:0x034f, B:5:0x0009, B:11:0x0018, B:13:0x001e, B:26:0x0045, B:10:0x0013, B:181:0x049d, B:183:0x04ac, B:184:0x04ae, B:216:0x0542, B:185:0x04b6, B:188:0x04d1, B:190:0x04d9, B:192:0x04e1, B:193:0x04e4, B:195:0x04f4, B:199:0x0506, B:198:0x0500, B:200:0x0508, B:202:0x0514, B:206:0x051f, B:211:0x0537, B:213:0x053b, B:209:0x0533, B:205:0x051c, B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c, B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf, B:151:0x03ba, B:153:0x03c6, B:155:0x03cc, B:157:0x03da, B:159:0x03e0, B:160:0x03e5, B:161:0x03e9, B:163:0x03ef, B:165:0x0403, B:167:0x0411, B:168:0x0415, B:170:0x0423, B:173:0x0441, B:174:0x0446, B:171:0x0439, B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:250:0x0003, inners: #1, #2, #3, #6, #7, #8, #9, #11, #13, #14 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x006f A[Catch: all -> 0x008a, TryCatch #3 {all -> 0x008a, blocks: (B:33:0x0065, B:35:0x006f, B:37:0x0082), top: B:233:0x0065, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    /* JADX WARN: Code duplicated, block: B:44:0x009d A[Catch: all -> 0x00d5, TryCatch #11 {all -> 0x00d5, blocks: (B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf), top: B:248:0x0091, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b7 A[Catch: all -> 0x00d5, TryCatch #11 {all -> 0x00d5, blocks: (B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf), top: B:248:0x0091, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00bd A[Catch: all -> 0x00d5, TryCatch #11 {all -> 0x00d5, blocks: (B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf), top: B:248:0x0091, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00c3 A[Catch: all -> 0x00d5, TryCatch #11 {all -> 0x00d5, blocks: (B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf), top: B:248:0x0091, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00c9 A[Catch: all -> 0x00d5, TryCatch #11 {all -> 0x00d5, blocks: (B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf), top: B:248:0x0091, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00cf A[Catch: all -> 0x00d5, TRY_LEAVE, TryCatch #11 {all -> 0x00d5, blocks: (B:42:0x0091, B:44:0x009d, B:52:0x00b7, B:53:0x00bd, B:54:0x00c3, B:55:0x00c9, B:56:0x00cf), top: B:248:0x0091, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00e6 A[Catch: all -> 0x011a, TryCatch #14 {all -> 0x011a, blocks: (B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:253:0x00da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x0101  */
    /* JADX WARN: Code duplicated, block: B:69:0x0102 A[Catch: all -> 0x011a, TryCatch #14 {all -> 0x011a, blocks: (B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:253:0x00da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0108 A[Catch: all -> 0x011a, TryCatch #14 {all -> 0x011a, blocks: (B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:253:0x00da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x010e A[Catch: all -> 0x011a, TryCatch #14 {all -> 0x011a, blocks: (B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:253:0x00da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0114 A[Catch: all -> 0x011a, TRY_LEAVE, TryCatch #14 {all -> 0x011a, blocks: (B:61:0x00da, B:63:0x00e6, B:69:0x0102, B:70:0x0108, B:71:0x010e, B:72:0x0114), top: B:253:0x00da, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x012a A[Catch: all -> 0x0172, TryCatch #9 {all -> 0x0172, blocks: (B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c), top: B:244:0x011e, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x013b A[Catch: all -> 0x0172, TryCatch #9 {all -> 0x0172, blocks: (B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c), top: B:244:0x011e, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x014b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x014f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0151 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0153  */
    /* JADX WARN: Code duplicated, block: B:88:0x0154 A[Catch: all -> 0x0172, TryCatch #9 {all -> 0x0172, blocks: (B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c), top: B:244:0x011e, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x015a A[Catch: all -> 0x0172, TryCatch #9 {all -> 0x0172, blocks: (B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c), top: B:244:0x011e, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0160 A[Catch: all -> 0x0172, TryCatch #9 {all -> 0x0172, blocks: (B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c), top: B:244:0x011e, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0166 A[Catch: all -> 0x0172, TryCatch #9 {all -> 0x0172, blocks: (B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c), top: B:244:0x011e, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x016c A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #9 {all -> 0x0172, blocks: (B:76:0x011e, B:78:0x012a, B:79:0x012f, B:81:0x013b, B:88:0x0154, B:89:0x015a, B:90:0x0160, B:91:0x0166, B:92:0x016c), top: B:244:0x011e, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0182 A[Catch: all -> 0x01aa, TryCatch #2 {all -> 0x01aa, blocks: (B:96:0x0176, B:98:0x0182, B:99:0x0187, B:101:0x0193, B:104:0x01a4), top: B:231:0x0176, outer: #12 }] */
    public synchronized void a(SdkAdInfo[] sdkAdInfoArr, MeishuAdInfo meishuAdInfo) {
        long all_timeout;
        List listAsList;
        SdkMonitor sdk_monitor;
        int i;
        com.meishu.sdk.core.loader.strategy.e eVar;
        List<com.meishu.sdk.core.loader.loadbean.a> list;
        long j;
        MeishuAdInfo meishuAdInfo2;
        long all_timeout2;
        int i2;
        long all_timeout3;
        SdkAdInfo sdkAdInfo;
        String imp;
        String strReplace;
        List<S2sbCacheEntity.S2SBDataBean> arrayList;
        int i3;
        int i4;
        int i5;
        SdkAdInfo.GeneralExt generalExt;
        int to;
        this.h = SystemClock.uptimeMillis();
        try {
            try {
                all_timeout = this.b.getAll_timeout();
            } catch (Exception e) {
                e.printStackTrace();
                all_timeout = 0;
            }
            com.meishu.sdk.core.loader.c cVar = this.e;
            if (cVar instanceof SplashAdLoader) {
                int fetchDelay = ((SplashAdLoader) cVar).getFetchDelay();
                int i6 = 500;
                try {
                    PackageBean.AdBean adBean = q0.m;
                    if (adBean != null && adBean.getSplash() != null && (to = q0.m.getSplash().getTo()) >= 0) {
                        i6 = to;
                    }
                } catch (Throwable unused) {
                }
                int i7 = fetchDelay + i6;
                if (i7 >= 0) {
                    long j2 = i7;
                    if (j2 < all_timeout) {
                        this.b.setAll_timeout(j2);
                        listAsList = Arrays.asList(sdkAdInfoArr);
                        sdk_monitor = meishuAdInfo.getSdk_monitor();
                        for (i = 0; i < listAsList.size(); i++) {
                            sdkAdInfo = (SdkAdInfo) listAsList.get(i);
                            try {
                                if (TextUtils.isEmpty(sdkAdInfo.getGeneral_ext()) && (generalExt = (SdkAdInfo.GeneralExt) new Gson().fromJson(sdkAdInfo.getGeneral_ext(), SdkAdInfo.GeneralExt.class)) != null) {
                                    sdkAdInfo.setApp_key(generalExt.getApp_key());
                                    if ("SGM".equals(sdkAdInfo.getSdk())) {
                                        i5 = b.f4814a[this.e.getAdType().ordinal()];
                                        if (i5 != 1) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                                        } else if (i5 != 3) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                                        } else if (i5 != 4) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                                        } else if (i5 != 5) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                                        } else if (i5 != 6) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                                        }
                                    }
                                    if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                                        sdkAdInfo.setSdk("CUSTOM");
                                        i4 = b.f4814a[this.e.getAdType().ordinal()];
                                        if (i4 != 2) {
                                            sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                                        } else if (i4 != 3) {
                                            sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                                        } else if (i4 != 4) {
                                            sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                                        } else if (i4 != 5) {
                                            sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                                        }
                                    }
                                    if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                                        sdkAdInfo.setSdk("PANGLE");
                                    }
                                    if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                                        i3 = b.f4814a[this.e.getAdType().ordinal()];
                                        if (i3 != 1) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                                        } else if (i3 != 2) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                                        } else if (i3 != 3) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                                        } else if (i3 != 4) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                                        } else if (i3 != 5) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                                        }
                                    }
                                    if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                                        sdkAdInfo.setSdk("DM");
                                    }
                                    if ("DM".equals(sdkAdInfo.getSdk())) {
                                        sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                                    }
                                    sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                                    sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                                    sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                                    if (sdk_monitor != null) {
                                        sdkAdInfo.getAccept_id();
                                        sdkAdInfo.getStrategy_dealid();
                                        String clk = sdk_monitor.getClk();
                                        String err = sdk_monitor.getErr();
                                        imp = sdk_monitor.getImp();
                                        String req = sdk_monitor.getReq();
                                        String rsp = sdk_monitor.getRsp();
                                        if (imp.contains("__PRE__")) {
                                            imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                        }
                                        if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                            if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk())) {
                                                if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                                    strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                                    imp = strReplace;
                                                }
                                            } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                                strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                                imp = strReplace;
                                            }
                                        }
                                        sdkAdInfo.setClk(a(sdkAdInfo, clk));
                                        sdkAdInfo.setErr(a(sdkAdInfo, err));
                                        sdkAdInfo.setImp(a(sdkAdInfo, imp));
                                        sdkAdInfo.setReq(a(sdkAdInfo, req));
                                        sdkAdInfo.setRsp(a(sdkAdInfo, rsp));
                                        if (sdkAdInfo.getAct_type() == 0) {
                                            if (meishuAdInfo.getAct_type() > 0) {
                                                sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                            } else {
                                                sdkAdInfo.setAct_type(2);
                                            }
                                        }
                                        sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                        sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                        sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                        sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                        sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                        sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                        sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                        if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                        }
                                        com.meishu.sdk.core.loader.loadbean.a aVar = new com.meishu.sdk.core.loader.loadbean.a();
                                        aVar.f4815a = sdkAdInfo;
                                        aVar.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                        this.l.add(aVar);
                                    } else {
                                        if (sdkAdInfo.getAct_type() == 0) {
                                            if (meishuAdInfo.getAct_type() > 0) {
                                                sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                            } else {
                                                sdkAdInfo.setAct_type(2);
                                            }
                                        }
                                        sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                        sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                        sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                        sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                        sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                        sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                        sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                        if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                        }
                                        com.meishu.sdk.core.loader.loadbean.a aVar2 = new com.meishu.sdk.core.loader.loadbean.a();
                                        aVar2.f4815a = sdkAdInfo;
                                        aVar2.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                        this.l.add(aVar2);
                                    }
                                } else {
                                    try {
                                        if ("SGM".equals(sdkAdInfo.getSdk())) {
                                            i5 = b.f4814a[this.e.getAdType().ordinal()];
                                            if (i5 != 1) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                                            } else if (i5 != 3) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                                            } else if (i5 != 4) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                                            } else if (i5 != 5) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                                            } else if (i5 != 6) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                    try {
                                        if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                                            sdkAdInfo.setSdk("CUSTOM");
                                            i4 = b.f4814a[this.e.getAdType().ordinal()];
                                            if (i4 != 2) {
                                                sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                                            } else if (i4 != 3) {
                                                sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                                            } else if (i4 != 4) {
                                                sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                                            } else if (i4 != 5) {
                                                sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                    try {
                                        if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                                            sdkAdInfo.setSdk("PANGLE");
                                        }
                                        if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                                            i3 = b.f4814a[this.e.getAdType().ordinal()];
                                            if (i3 != 1) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                                            } else if (i3 != 2) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                                            } else if (i3 != 3) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                                            } else if (i3 != 4) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                                            } else if (i3 != 5) {
                                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th3.printStackTrace();
                                    }
                                    try {
                                        if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                                            sdkAdInfo.setSdk("DM");
                                        }
                                        if ("DM".equals(sdkAdInfo.getSdk()) && b.f4814a[this.e.getAdType().ordinal()] == 1) {
                                            sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                                        }
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                    }
                                    sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                                    sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                                    sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                                    if (sdk_monitor != null) {
                                        try {
                                            sdkAdInfo.getAccept_id();
                                            sdkAdInfo.getStrategy_dealid();
                                            String clk2 = sdk_monitor.getClk();
                                            String err2 = sdk_monitor.getErr();
                                            imp = sdk_monitor.getImp();
                                            String req2 = sdk_monitor.getReq();
                                            String rsp2 = sdk_monitor.getRsp();
                                            if (imp.contains("__PRE__") && !"bidding".equals(sdkAdInfo.getOtype())) {
                                                imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                            }
                                            if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                                if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk()) && !"JD".equals(sdkAdInfo.getSdk()) && !MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk()) && !"KS".equals(sdkAdInfo.getSdk()) && !"HW".equals(sdkAdInfo.getSdk()) && TextUtils.isEmpty(sdkAdInfo.getCls())) {
                                                    strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                                } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                                    strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                                }
                                                imp = strReplace;
                                            }
                                            sdkAdInfo.setClk(a(sdkAdInfo, clk2));
                                            sdkAdInfo.setErr(a(sdkAdInfo, err2));
                                            sdkAdInfo.setImp(a(sdkAdInfo, imp));
                                            sdkAdInfo.setReq(a(sdkAdInfo, req2));
                                            sdkAdInfo.setRsp(a(sdkAdInfo, rsp2));
                                        } catch (Throwable th5) {
                                            th5.printStackTrace();
                                        }
                                        if (sdkAdInfo.getAct_type() == 0) {
                                            if (meishuAdInfo.getAct_type() > 0) {
                                                sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                            } else {
                                                sdkAdInfo.setAct_type(2);
                                            }
                                        }
                                        sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                        sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                        sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                        sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                        sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                        sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                        try {
                                            sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                            sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                            sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                            sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                            sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                        } catch (Throwable th6) {
                                            th6.printStackTrace();
                                        }
                                        sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                        try {
                                            if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk()) && sdkAdInfo.getS2sb() != null) {
                                                S2sbCacheEntity adByPid = S2SBManager.getAdByPid(this.f4812a, this.b.getPid());
                                                if (adByPid != null) {
                                                    arrayList = adByPid.getS2sbList();
                                                    if (arrayList == null) {
                                                        arrayList = new ArrayList<>();
                                                    }
                                                    Iterator<S2sbCacheEntity.S2SBDataBean> it = arrayList.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            S2sbCacheEntity.S2SBDataBean next = it.next();
                                                            if (sdkAdInfo.getSdk().equals(next.getPlatform()) && !sdkAdInfo.getApp_id().equals(next.getAppId())) {
                                                                it.remove();
                                                            } else if (next.getPid().equals(sdkAdInfo.getPid())) {
                                                                next.setUpdateTime(System.currentTimeMillis());
                                                                adByPid.setS2sbList(arrayList);
                                                                S2SBManager.putAdByPid(this.f4812a, this.b.getPid(), adByPid);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    adByPid = new S2sbCacheEntity();
                                                    arrayList = null;
                                                }
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList<>();
                                                }
                                                S2sbCacheEntity.S2SBDataBean s2SBDataBean = new S2sbCacheEntity.S2SBDataBean();
                                                s2SBDataBean.setAppId(sdkAdInfo.getApp_id());
                                                s2SBDataBean.setPid(sdkAdInfo.getPid());
                                                s2SBDataBean.setPlatform(sdkAdInfo.getSdk());
                                                s2SBDataBean.setUpdateTime(System.currentTimeMillis());
                                                arrayList.add(s2SBDataBean);
                                                adByPid.setS2sbList(arrayList);
                                                S2SBManager.putAdByPid(this.f4812a, this.b.getPid(), adByPid);
                                            }
                                        } catch (Throwable th7) {
                                            th7.printStackTrace();
                                        }
                                        com.meishu.sdk.core.loader.loadbean.a aVar3 = new com.meishu.sdk.core.loader.loadbean.a();
                                        aVar3.f4815a = sdkAdInfo;
                                        aVar3.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                        this.l.add(aVar3);
                                    } else {
                                        if (sdkAdInfo.getAct_type() == 0) {
                                            if (meishuAdInfo.getAct_type() > 0) {
                                                sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                            } else {
                                                sdkAdInfo.setAct_type(2);
                                            }
                                        }
                                        sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                        sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                        sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                        sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                        sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                        sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                        sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                        sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                        if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                        }
                                        com.meishu.sdk.core.loader.loadbean.a aVar4 = new com.meishu.sdk.core.loader.loadbean.a();
                                        aVar4.f4815a = sdkAdInfo;
                                        aVar4.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                        this.l.add(aVar4);
                                    }
                                }
                            } catch (Throwable th8) {
                                th8.printStackTrace();
                            }
                        }
                        b(sdkAdInfoArr, meishuAdInfo);
                        synchronized (this) {
                            eVar = new com.meishu.sdk.core.loader.strategy.e(this.e, this.b);
                            this.d = eVar;
                            if (this.j) {
                                eVar.r = true;
                            }
                            eVar.k = this;
                            list = this.l;
                            Map<String, Object> map = this.c;
                            j = this.h;
                            try {
                                eVar.g = list;
                                eVar.h.clear();
                                eVar.h.addAll(list);
                                eVar.i = map;
                                eVar.c.clear();
                                if (list.size() != 0) {
                                    if (eVar.b.isHasMeishuAd() && !eVar.b.isUsed()) {
                                        eVar.b();
                                    }
                                    eVar.y = eVar.b.getBf_num();
                                    eVar.m = j;
                                    meishuAdInfo2 = eVar.b;
                                    all_timeout2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                                    if (meishuAdInfo2 != null) {
                                        if (meishuAdInfo2.getAll_timeout() <= 0) {
                                            all_timeout3 = 10000;
                                        } else {
                                            all_timeout3 = eVar.b.getAll_timeout();
                                        }
                                        eVar.s = all_timeout3;
                                    }
                                    try {
                                        if (eVar.b.getAll_timeout() > 0) {
                                            all_timeout2 = eVar.b.getAll_timeout();
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    try {
                                        eVar.l.postDelayed(new com.meishu.sdk.core.loader.strategy.b(eVar), all_timeout2 - (SystemClock.uptimeMillis() - eVar.m));
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                    for (i2 = 0; i2 < eVar.y; i2++) {
                                        eVar.h();
                                    }
                                }
                            } catch (Throwable th9) {
                                eVar.j = true;
                                eVar.p.clear();
                                eVar.e();
                                th9.printStackTrace();
                            }
                        }
                    }
                    listAsList = Arrays.asList(sdkAdInfoArr);
                    sdk_monitor = meishuAdInfo.getSdk_monitor();
                    while (i < listAsList.size()) {
                        sdkAdInfo = (SdkAdInfo) listAsList.get(i);
                        if (TextUtils.isEmpty(sdkAdInfo.getGeneral_ext())) {
                            if ("SGM".equals(sdkAdInfo.getSdk())) {
                                i5 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i5 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                                } else if (i5 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                                } else if (i5 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                                } else if (i5 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                                } else if (i5 != 6) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                                }
                            }
                            if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setSdk("CUSTOM");
                                i4 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i4 != 2) {
                                    sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                                } else if (i4 != 3) {
                                    sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                                } else if (i4 != 4) {
                                    sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                                } else if (i4 != 5) {
                                    sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                                sdkAdInfo.setSdk("PANGLE");
                            }
                            if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                                i3 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i3 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                                } else if (i3 != 2) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                                } else if (i3 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                                } else if (i3 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                                } else if (i3 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                                sdkAdInfo.setSdk("DM");
                            }
                            if ("DM".equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                            }
                            sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk3 = sdk_monitor.getClk();
                                String err3 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req3 = sdk_monitor.getReq();
                                String rsp3 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                    if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                            imp = strReplace;
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                        imp = strReplace;
                                    }
                                }
                                sdkAdInfo.setClk(a(sdkAdInfo, clk3));
                                sdkAdInfo.setErr(a(sdkAdInfo, err3));
                                sdkAdInfo.setImp(a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(a(sdkAdInfo, req3));
                                sdkAdInfo.setRsp(a(sdkAdInfo, rsp3));
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar5 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar5.f4815a = sdkAdInfo;
                                aVar5.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar5);
                            } else {
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar6 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar6.f4815a = sdkAdInfo;
                                aVar6.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar6);
                            }
                        } else {
                            if ("SGM".equals(sdkAdInfo.getSdk())) {
                                i5 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i5 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                                } else if (i5 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                                } else if (i5 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                                } else if (i5 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                                } else if (i5 != 6) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                                }
                            }
                            if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setSdk("CUSTOM");
                                i4 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i4 != 2) {
                                    sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                                } else if (i4 != 3) {
                                    sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                                } else if (i4 != 4) {
                                    sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                                } else if (i4 != 5) {
                                    sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                                sdkAdInfo.setSdk("PANGLE");
                            }
                            if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                                i3 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i3 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                                } else if (i3 != 2) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                                } else if (i3 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                                } else if (i3 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                                } else if (i3 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                                sdkAdInfo.setSdk("DM");
                            }
                            if ("DM".equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                            }
                            sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk4 = sdk_monitor.getClk();
                                String err4 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req4 = sdk_monitor.getReq();
                                String rsp4 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                    if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                            imp = strReplace;
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                        imp = strReplace;
                                    }
                                }
                                sdkAdInfo.setClk(a(sdkAdInfo, clk4));
                                sdkAdInfo.setErr(a(sdkAdInfo, err4));
                                sdkAdInfo.setImp(a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(a(sdkAdInfo, req4));
                                sdkAdInfo.setRsp(a(sdkAdInfo, rsp4));
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar7 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar7.f4815a = sdkAdInfo;
                                aVar7.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar7);
                            } else {
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar8 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar8.f4815a = sdkAdInfo;
                                aVar8.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar8);
                            }
                        }
                    }
                    b(sdkAdInfoArr, meishuAdInfo);
                    synchronized (this) {
                        eVar = new com.meishu.sdk.core.loader.strategy.e(this.e, this.b);
                        this.d = eVar;
                        if (this.j) {
                            eVar.r = true;
                        }
                        eVar.k = this;
                        list = this.l;
                        Map<String, Object> map2 = this.c;
                        j = this.h;
                        eVar.g = list;
                        eVar.h.clear();
                        eVar.h.addAll(list);
                        eVar.i = map2;
                        eVar.c.clear();
                        if (list.size() != 0) {
                            if (eVar.b.isHasMeishuAd()) {
                                eVar.b();
                            }
                            eVar.y = eVar.b.getBf_num();
                            eVar.m = j;
                            meishuAdInfo2 = eVar.b;
                            all_timeout2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                            if (meishuAdInfo2 != null) {
                                if (meishuAdInfo2.getAll_timeout() <= 0) {
                                    all_timeout3 = 10000;
                                } else {
                                    all_timeout3 = eVar.b.getAll_timeout();
                                }
                                eVar.s = all_timeout3;
                            }
                            if (eVar.b.getAll_timeout() > 0) {
                                all_timeout2 = eVar.b.getAll_timeout();
                            }
                            eVar.l.postDelayed(new com.meishu.sdk.core.loader.strategy.b(eVar), all_timeout2 - (SystemClock.uptimeMillis() - eVar.m));
                            while (i2 < eVar.y) {
                                eVar.h();
                            }
                        }
                    }
                } else {
                    listAsList = Arrays.asList(sdkAdInfoArr);
                    sdk_monitor = meishuAdInfo.getSdk_monitor();
                    while (i < listAsList.size()) {
                        sdkAdInfo = (SdkAdInfo) listAsList.get(i);
                        if (TextUtils.isEmpty(sdkAdInfo.getGeneral_ext())) {
                            if ("SGM".equals(sdkAdInfo.getSdk())) {
                                i5 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i5 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                                } else if (i5 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                                } else if (i5 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                                } else if (i5 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                                } else if (i5 != 6) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                                }
                            }
                            if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setSdk("CUSTOM");
                                i4 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i4 != 2) {
                                    sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                                } else if (i4 != 3) {
                                    sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                                } else if (i4 != 4) {
                                    sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                                } else if (i4 != 5) {
                                    sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                                sdkAdInfo.setSdk("PANGLE");
                            }
                            if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                                i3 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i3 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                                } else if (i3 != 2) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                                } else if (i3 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                                } else if (i3 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                                } else if (i3 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                                sdkAdInfo.setSdk("DM");
                            }
                            if ("DM".equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                            }
                            sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk5 = sdk_monitor.getClk();
                                String err5 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req5 = sdk_monitor.getReq();
                                String rsp5 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                    if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                            imp = strReplace;
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                        imp = strReplace;
                                    }
                                }
                                sdkAdInfo.setClk(a(sdkAdInfo, clk5));
                                sdkAdInfo.setErr(a(sdkAdInfo, err5));
                                sdkAdInfo.setImp(a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(a(sdkAdInfo, req5));
                                sdkAdInfo.setRsp(a(sdkAdInfo, rsp5));
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar9 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar9.f4815a = sdkAdInfo;
                                aVar9.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar9);
                            } else {
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar10 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar10.f4815a = sdkAdInfo;
                                aVar10.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar10);
                            }
                        } else {
                            if ("SGM".equals(sdkAdInfo.getSdk())) {
                                i5 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i5 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                                } else if (i5 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                                } else if (i5 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                                } else if (i5 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                                } else if (i5 != 6) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                                }
                            }
                            if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setSdk("CUSTOM");
                                i4 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i4 != 2) {
                                    sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                                } else if (i4 != 3) {
                                    sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                                } else if (i4 != 4) {
                                    sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                                } else if (i4 != 5) {
                                    sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                                sdkAdInfo.setSdk("PANGLE");
                            }
                            if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                                i3 = b.f4814a[this.e.getAdType().ordinal()];
                                if (i3 != 1) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                                } else if (i3 != 2) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                                } else if (i3 != 3) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                                } else if (i3 != 4) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                                } else if (i3 != 5) {
                                    sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                                }
                            }
                            if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                                sdkAdInfo.setSdk("DM");
                            }
                            if ("DM".equals(sdkAdInfo.getSdk())) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                            }
                            sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk6 = sdk_monitor.getClk();
                                String err6 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req6 = sdk_monitor.getReq();
                                String rsp6 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                    if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                            imp = strReplace;
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                        imp = strReplace;
                                    }
                                }
                                sdkAdInfo.setClk(a(sdkAdInfo, clk6));
                                sdkAdInfo.setErr(a(sdkAdInfo, err6));
                                sdkAdInfo.setImp(a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(a(sdkAdInfo, req6));
                                sdkAdInfo.setRsp(a(sdkAdInfo, rsp6));
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar11 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar11.f4815a = sdkAdInfo;
                                aVar11.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar11);
                            } else {
                                if (sdkAdInfo.getAct_type() == 0) {
                                    if (meishuAdInfo.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                                sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                                sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                                sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                                sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                                sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                                }
                                com.meishu.sdk.core.loader.loadbean.a aVar12 = new com.meishu.sdk.core.loader.loadbean.a();
                                aVar12.f4815a = sdkAdInfo;
                                aVar12.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                this.l.add(aVar12);
                            }
                        }
                    }
                    b(sdkAdInfoArr, meishuAdInfo);
                    synchronized (this) {
                        eVar = new com.meishu.sdk.core.loader.strategy.e(this.e, this.b);
                        this.d = eVar;
                        if (this.j) {
                            eVar.r = true;
                        }
                        eVar.k = this;
                        list = this.l;
                        Map<String, Object> map3 = this.c;
                        j = this.h;
                        eVar.g = list;
                        eVar.h.clear();
                        eVar.h.addAll(list);
                        eVar.i = map3;
                        eVar.c.clear();
                        if (list.size() != 0) {
                            if (eVar.b.isHasMeishuAd()) {
                                eVar.b();
                            }
                            eVar.y = eVar.b.getBf_num();
                            eVar.m = j;
                            meishuAdInfo2 = eVar.b;
                            all_timeout2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                            if (meishuAdInfo2 != null) {
                                if (meishuAdInfo2.getAll_timeout() <= 0) {
                                    all_timeout3 = 10000;
                                } else {
                                    all_timeout3 = eVar.b.getAll_timeout();
                                }
                                eVar.s = all_timeout3;
                            }
                            if (eVar.b.getAll_timeout() > 0) {
                                all_timeout2 = eVar.b.getAll_timeout();
                            }
                            eVar.l.postDelayed(new com.meishu.sdk.core.loader.strategy.b(eVar), all_timeout2 - (SystemClock.uptimeMillis() - eVar.m));
                            while (i2 < eVar.y) {
                                eVar.h();
                            }
                        }
                    }
                }
            } else {
                listAsList = Arrays.asList(sdkAdInfoArr);
                sdk_monitor = meishuAdInfo.getSdk_monitor();
                while (i < listAsList.size()) {
                    sdkAdInfo = (SdkAdInfo) listAsList.get(i);
                    if (TextUtils.isEmpty(sdkAdInfo.getGeneral_ext())) {
                        if ("SGM".equals(sdkAdInfo.getSdk())) {
                            i5 = b.f4814a[this.e.getAdType().ordinal()];
                            if (i5 != 1) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                            } else if (i5 != 3) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                            } else if (i5 != 4) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                            } else if (i5 != 5) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                            } else if (i5 != 6) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                            }
                        }
                        if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                            sdkAdInfo.setSdk("CUSTOM");
                            i4 = b.f4814a[this.e.getAdType().ordinal()];
                            if (i4 != 2) {
                                sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                            } else if (i4 != 3) {
                                sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                            } else if (i4 != 4) {
                                sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                            } else if (i4 != 5) {
                                sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                            }
                        }
                        if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                            sdkAdInfo.setSdk("PANGLE");
                        }
                        if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                            i3 = b.f4814a[this.e.getAdType().ordinal()];
                            if (i3 != 1) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                            } else if (i3 != 2) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                            } else if (i3 != 3) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                            } else if (i3 != 4) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                            } else if (i3 != 5) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                            }
                        }
                        if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                            sdkAdInfo.setSdk("DM");
                        }
                        if ("DM".equals(sdkAdInfo.getSdk())) {
                            sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                        }
                        sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                        sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                        sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                        if (sdk_monitor != null) {
                            sdkAdInfo.getAccept_id();
                            sdkAdInfo.getStrategy_dealid();
                            String clk7 = sdk_monitor.getClk();
                            String err7 = sdk_monitor.getErr();
                            imp = sdk_monitor.getImp();
                            String req7 = sdk_monitor.getReq();
                            String rsp7 = sdk_monitor.getRsp();
                            if (imp.contains("__PRE__")) {
                                imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                            }
                            if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk())) {
                                    if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                        imp = strReplace;
                                    }
                                } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                    strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                    imp = strReplace;
                                }
                            }
                            sdkAdInfo.setClk(a(sdkAdInfo, clk7));
                            sdkAdInfo.setErr(a(sdkAdInfo, err7));
                            sdkAdInfo.setImp(a(sdkAdInfo, imp));
                            sdkAdInfo.setReq(a(sdkAdInfo, req7));
                            sdkAdInfo.setRsp(a(sdkAdInfo, rsp7));
                            if (sdkAdInfo.getAct_type() == 0) {
                                if (meishuAdInfo.getAct_type() > 0) {
                                    sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                } else {
                                    sdkAdInfo.setAct_type(2);
                                }
                            }
                            sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                            sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                            sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                            sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                            sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                            sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                            sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                            if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                            }
                            com.meishu.sdk.core.loader.loadbean.a aVar13 = new com.meishu.sdk.core.loader.loadbean.a();
                            aVar13.f4815a = sdkAdInfo;
                            aVar13.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                            this.l.add(aVar13);
                        } else {
                            if (sdkAdInfo.getAct_type() == 0) {
                                if (meishuAdInfo.getAct_type() > 0) {
                                    sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                } else {
                                    sdkAdInfo.setAct_type(2);
                                }
                            }
                            sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                            sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                            sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                            sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                            sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                            sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                            sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                            if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                            }
                            com.meishu.sdk.core.loader.loadbean.a aVar14 = new com.meishu.sdk.core.loader.loadbean.a();
                            aVar14.f4815a = sdkAdInfo;
                            aVar14.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                            this.l.add(aVar14);
                        }
                    } else {
                        if ("SGM".equals(sdkAdInfo.getSdk())) {
                            i5 = b.f4814a[this.e.getAdType().ordinal()];
                            if (i5 != 1) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter");
                            } else if (i5 != 3) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.reward.SigmobCustomRewardAdapter");
                            } else if (i5 != 4) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter");
                            } else if (i5 != 5) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter");
                            } else if (i5 != 6) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter");
                            }
                        }
                        if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                            sdkAdInfo.setSdk("CUSTOM");
                            i4 = b.f4814a[this.e.getAdType().ordinal()];
                            if (i4 != 2) {
                                sdkAdInfo.setCls("com.meishu.admob.banner.AdmobBannerAdWrapper");
                            } else if (i4 != 3) {
                                sdkAdInfo.setCls("com.meishu.admob.reward.AdmobRewardAdWrapper");
                            } else if (i4 != 4) {
                                sdkAdInfo.setCls("com.meishu.admob.feed.AdmobFeedAdWrapper");
                            } else if (i4 != 5) {
                                sdkAdInfo.setCls("com.meishu.admob.interstitial.AdmobIntertitialAdWrapper");
                            }
                        }
                        if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.pangle")) {
                            sdkAdInfo.setSdk("PANGLE");
                        }
                        if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                            i3 = b.f4814a[this.e.getAdType().ordinal()];
                            if (i3 != 1) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.splash.PangleSplashAdapter");
                            } else if (i3 != 2) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.banner.PangleBannerAdapter");
                            } else if (i3 != 3) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.reward.PangleRewardAdapter");
                            } else if (i3 != 4) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.feed.PangleNativeAdapter");
                            } else if (i3 != 5) {
                                sdkAdInfo.setCls("com.meishu.sdk.platform.pangle.interstitial.PangleInterstitialAdapter");
                            }
                        }
                        if (sdkAdInfo.getCls().contains("com.meishu.sdk.platform.duomeng")) {
                            sdkAdInfo.setSdk("DM");
                        }
                        if ("DM".equals(sdkAdInfo.getSdk())) {
                            sdkAdInfo.setCls("com.meishu.sdk.platform.duomeng.splash.DMSplashAdapter");
                        }
                        sdkAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                        sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                        sdkAdInfo.setReq_id(meishuAdInfo.getReq_id());
                        if (sdk_monitor != null) {
                            sdkAdInfo.getAccept_id();
                            sdkAdInfo.getStrategy_dealid();
                            String clk8 = sdk_monitor.getClk();
                            String err8 = sdk_monitor.getErr();
                            imp = sdk_monitor.getImp();
                            String req8 = sdk_monitor.getReq();
                            String rsp8 = sdk_monitor.getRsp();
                            if (imp.contains("__PRE__")) {
                                imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                            }
                            if (imp.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsv)) {
                                if (MSAdConfig.PLATFORM_BD.equals(sdkAdInfo.getSdk())) {
                                    if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                        imp = strReplace;
                                    }
                                } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                    strReplace = imp.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getPrice() * 10).getBytes(), 2));
                                    imp = strReplace;
                                }
                            }
                            sdkAdInfo.setClk(a(sdkAdInfo, clk8));
                            sdkAdInfo.setErr(a(sdkAdInfo, err8));
                            sdkAdInfo.setImp(a(sdkAdInfo, imp));
                            sdkAdInfo.setReq(a(sdkAdInfo, req8));
                            sdkAdInfo.setRsp(a(sdkAdInfo, rsp8));
                            if (sdkAdInfo.getAct_type() == 0) {
                                if (meishuAdInfo.getAct_type() > 0) {
                                    sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                } else {
                                    sdkAdInfo.setAct_type(2);
                                }
                            }
                            sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                            sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                            sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                            sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                            sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                            sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                            sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                            if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                            }
                            com.meishu.sdk.core.loader.loadbean.a aVar15 = new com.meishu.sdk.core.loader.loadbean.a();
                            aVar15.f4815a = sdkAdInfo;
                            aVar15.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                            this.l.add(aVar15);
                        } else {
                            if (sdkAdInfo.getAct_type() == 0) {
                                if (meishuAdInfo.getAct_type() > 0) {
                                    sdkAdInfo.setAct_type(meishuAdInfo.getAct_type());
                                } else {
                                    sdkAdInfo.setAct_type(2);
                                }
                            }
                            sdkAdInfo.setCache_req(sdkAdInfo.getReq());
                            sdkAdInfo.setCache_clk(sdkAdInfo.getClk());
                            sdkAdInfo.setCache_err(sdkAdInfo.getErr());
                            sdkAdInfo.setCache_imp(sdkAdInfo.getImp());
                            sdkAdInfo.setCache_rsp(sdkAdInfo.getRsp());
                            sdkAdInfo.setMsLoadedTime(meishuAdInfo.getLoadedTime());
                            sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", this.b.getReq_id()));
                            sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                            if (!MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                            }
                            com.meishu.sdk.core.loader.loadbean.a aVar16 = new com.meishu.sdk.core.loader.loadbean.a();
                            aVar16.f4815a = sdkAdInfo;
                            aVar16.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                            this.l.add(aVar16);
                        }
                    }
                }
                b(sdkAdInfoArr, meishuAdInfo);
                synchronized (this) {
                    eVar = new com.meishu.sdk.core.loader.strategy.e(this.e, this.b);
                    this.d = eVar;
                    if (this.j) {
                        eVar.r = true;
                    }
                    eVar.k = this;
                    list = this.l;
                    Map<String, Object> map4 = this.c;
                    j = this.h;
                    eVar.g = list;
                    eVar.h.clear();
                    eVar.h.addAll(list);
                    eVar.i = map4;
                    eVar.c.clear();
                    if (list.size() != 0) {
                        if (eVar.b.isHasMeishuAd()) {
                            eVar.b();
                        }
                        eVar.y = eVar.b.getBf_num();
                        eVar.m = j;
                        meishuAdInfo2 = eVar.b;
                        all_timeout2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                        if (meishuAdInfo2 != null) {
                            if (meishuAdInfo2.getAll_timeout() <= 0) {
                                all_timeout3 = 10000;
                            } else {
                                all_timeout3 = eVar.b.getAll_timeout();
                            }
                            eVar.s = all_timeout3;
                        }
                        if (eVar.b.getAll_timeout() > 0) {
                            all_timeout2 = eVar.b.getAll_timeout();
                        }
                        eVar.l.postDelayed(new com.meishu.sdk.core.loader.strategy.b(eVar), all_timeout2 - (SystemClock.uptimeMillis() - eVar.m));
                        while (i2 < eVar.y) {
                            eVar.h();
                        }
                    }
                }
            }
        } catch (Throwable th10) {
            th10.printStackTrace();
        }
        throw th;
    }

    public final List<Integer> a(int i) {
        List<WeakReference<com.meishu.sdk.core.loader.cache.a>> cacheListByKey;
        ArrayList arrayList = new ArrayList();
        String cacheKey = this.b.getCacheKey();
        try {
            if (this.b.getCache() > 0 && (cacheListByKey = CacheManager.INSTANCE.getCacheListByKey(cacheKey)) != null && cacheListByKey.size() > 0) {
                Iterator<WeakReference<com.meishu.sdk.core.loader.cache.a>> it = cacheListByKey.iterator();
                while (it.hasNext()) {
                    com.meishu.sdk.core.loader.cache.a aVar = it.next().get();
                    if (aVar.a()) {
                        SdkAdInfo sdkAdInfo = aVar.b;
                        int ecpm = sdkAdInfo.getEcpm();
                        if (ecpm < i && ecpm > 0) {
                            arrayList.add(Integer.valueOf(sdkAdInfo.getOriginEcpm()));
                        }
                        int codPrice = sdkAdInfo.getCodPrice();
                        if (codPrice < i && codPrice > 0) {
                            arrayList.add(Integer.valueOf(sdkAdInfo.getPrice()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final void a(SdkAdInfo sdkAdInfo, int i) {
        S2sbResultBean s2sbResultBean;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getS2sb()) || (s2sbResultBean = (S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)) == null) {
                return;
            }
            z.a(this.e.getContext(), s2sbResultBean.getNurl().replace("AUCTION_PRICE", String.valueOf(sdkAdInfo.getPrice())).replace("HIGHEST_LOSS_PRICE", String.valueOf(Math.min(i, sdkAdInfo.getPrice()))), new i());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final String a(SdkAdInfo sdkAdInfo, String str) {
        try {
            String[] strArr = {"__ACCEPT_ID__", "__STRATEGY_DEALID__", "__ACCEPT_APPID__", "__ACCEPT_PID__", "__SDK__", "__GROUP_ID__", "__P__"};
            String[] strArr2 = new String[7];
            strArr2[0] = sdkAdInfo.getAccept_id() == null ? "" : sdkAdInfo.getAccept_id();
            strArr2[1] = sdkAdInfo.getStrategy_dealid() == null ? "" : sdkAdInfo.getStrategy_dealid();
            strArr2[2] = sdkAdInfo.getApp_id() == null ? "" : sdkAdInfo.getApp_id();
            strArr2[3] = sdkAdInfo.getPid() == null ? "" : sdkAdInfo.getPid();
            strArr2[4] = sdkAdInfo.getSdk() == null ? "" : sdkAdInfo.getSdk();
            strArr2[5] = sdkAdInfo.getGroup_id() == null ? "" : sdkAdInfo.getGroup_id();
            strArr2[6] = String.valueOf(sdkAdInfo.getPrice());
            return TextUtils.replace(str, strArr, strArr2).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final void a(boolean z) {
        LogUtil.d("ConCurrentManager", com.meishu.sdk.activity.a.a("handleLoadMeshu + isAdFinish=").append(this.g).append(",needCache=").append(z).toString());
        if (this.f != null) {
            String[] responUrl = this.b.getResponUrl();
            if (!z && responUrl != null && responUrl.length > 0) {
                LogUtil.d("ConCurrentManager", "send onAdLoaded");
                for (String str : responUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        com.meishu.sdk.core.loader.a.a(this.f4812a, h0.a(h0.a(str, System.currentTimeMillis() - this.e.startLoadTime)));
                    }
                }
            }
            this.f.setLocalParams(this.c);
            this.f.setConCurrentLoadListener(new a(z, new boolean[1]));
            this.f.loadAd();
            return;
        }
        if (this.e.getLoaderListener() == null || z || this.m) {
            return;
        }
        this.m = true;
        LogUtil.e("ConCurrentManager", "no MS ad,load error");
        this.e.getLoaderListener().onAdError();
    }
}
