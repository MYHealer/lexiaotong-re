package com.fancy;

import android.util.Pair;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ly {
    public static final ConcurrentHashMap _a = new ConcurrentHashMap();
    public static final _b _b = new _b(TimeUnit.SECONDS, new ArrayBlockingQueue(30), new _a(), new ThreadPoolExecutor.DiscardOldestPolicy());

    public class _a implements ThreadFactory {
        public final AtomicInteger _a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, _ie._a("ClassRegular-").append(this._a.getAndIncrement()).toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public class _b extends ThreadPoolExecutor {
        public _b(TimeUnit timeUnit, ArrayBlockingQueue arrayBlockingQueue, _a _aVar, ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy) {
            super(4, 8, 30L, timeUnit, arrayBlockingQueue, _aVar, discardOldestPolicy);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            allowCoreThreadTimeOut(true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00af  */
    public static Pair _a(HashMap map, String str, _p _pVar, int i) {
        String strGroup;
        Matcher matcher;
        Pattern patternCompile;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            List<String> list = (List) entry.getValue();
            if (list != null) {
                for (String str3 : list) {
                    if (str == null || str.isEmpty() || str3 == null || str3.isEmpty()) {
                        strGroup = "";
                    } else {
                        try {
                            String str_c = com.fancy.adsdk.lib.utils._a._c(str);
                            ConcurrentHashMap concurrentHashMap = _a;
                            Pattern pattern = (Pattern) concurrentHashMap.get(str_c);
                            if (pattern == null) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                try {
                                    String str_c2 = com.fancy.adsdk.lib.utils._a._c(str);
                                    if (concurrentHashMap.containsKey(str_c2)) {
                                        pattern = null;
                                    } else {
                                        patternCompile = Pattern.compile(str);
                                        if (patternCompile != null) {
                                            try {
                                                concurrentHashMap.put(str_c2, patternCompile);
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                            }
                                        }
                                        pattern = patternCompile;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    patternCompile = null;
                                }
                                Logger.e("miss Pattern, cost parse rule time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                            }
                            if (pattern == null || (matcher = pattern.matcher(str3)) == null || !matcher.find()) {
                                strGroup = "";
                            } else {
                                strGroup = matcher.group(1);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            Logger.e(e3.getMessage());
                        }
                    }
                    if (strGroup != null && strGroup.length() > 0) {
                        if (2 == i) {
                            _pVar._q = str2;
                            _pVar._r = strGroup;
                        } else if (1 == i) {
                            _pVar._s = strGroup;
                        }
                        return new Pair(str2, list);
                    }
                }
            }
        }
        return null;
    }
}
