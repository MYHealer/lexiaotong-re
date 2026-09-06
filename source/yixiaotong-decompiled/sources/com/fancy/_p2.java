package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.TextUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _p2 {
    public static ScheduledFuture<?> _d;
    public static final AtomicBoolean _a = new AtomicBoolean(true);
    public static final AtomicBoolean _b = new AtomicBoolean(false);
    public static final ScheduledExecutorService _c = Executors.newScheduledThreadPool(1);
    public static final CopyOnWriteArraySet _e = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet _f = new CopyOnWriteArraySet();
    public static final ConcurrentHashMap<String, String> _g = new ConcurrentHashMap<>(4);

    public static boolean _a(boolean z) {
        if (!z) {
            return false;
        }
        long detectRuleInterval = PtgAdSdk.getConfig().getDetectRuleInterval();
        if (detectRuleInterval < 1) {
            detectRuleInterval = 60;
        }
        long j_b = _kr._b(PtgAdSdk.getContext(), "ru_la_bu_ti");
        if (j_b <= 0) {
            j_b = System.currentTimeMillis();
            _kr._a(PtgAdSdk.getContext(), "ru_la_bu_ti", j_b);
        }
        return System.currentTimeMillis() - j_b >= detectRuleInterval * 60000;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    public static void _b(boolean z) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList;
        if (_a.compareAndSet(true, false)) {
            ArrayList arrayList2 = null;
            if (_e.isEmpty()) {
                String str_d = _kr._d(PtgAdSdk.getContext(), "ru_hi_de_to");
                if (TextUtils.isEmpty(str_d)) {
                    arrayList = null;
                } else {
                    String[] strArrSplit = str_d.split(_ie._a("(?<!\\\\)").append(Pattern.quote("@")).toString());
                    if (strArrSplit.length > 0) {
                        arrayList = new ArrayList();
                        for (String str : strArrSplit) {
                            if (!str.isEmpty()) {
                                arrayList.add(str.replace("\\@", "@"));
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    _e.addAll(arrayList);
                }
            }
            if (_f.isEmpty()) {
                String str_d2 = _kr._d(PtgAdSdk.getContext(), "ru_hi_de_li");
                if (!TextUtils.isEmpty(str_d2)) {
                    String[] strArrSplit2 = str_d2.split(_ie._a("(?<!\\\\)").append(Pattern.quote("@")).toString());
                    if (strArrSplit2.length > 0) {
                        arrayList2 = new ArrayList();
                        for (String str2 : strArrSplit2) {
                            if (!str2.isEmpty()) {
                                arrayList2.add(str2.replace("\\@", "@"));
                            }
                        }
                    }
                }
                if (TextUtil.isNotEmpty(arrayList2)) {
                    _f.addAll(arrayList2);
                }
            }
        }
        if (z) {
            _e.clear();
            _kr._a(PtgAdSdk.getContext(), "ru_la_bu_ti", System.currentTimeMillis());
        }
        try {
            String detectRule = PtgAdSdk.getConfig().getDetectRule();
            if (!TextUtils.isEmpty(detectRule)) {
                JSONArray jSONArray = new JSONArray(detectRule);
                int iMin = Math.min(jSONArray.length(), 100);
                for (int i = 0; i < iMin; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject.optString("tagId");
                    if (!TextUtils.isEmpty(strOptString) && !_e.contains(strOptString) && !_g.containsValue(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("packageName")) != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            String string = jSONArrayOptJSONArray.getString(i2);
                            if (!TextUtils.isEmpty(string)) {
                                _g.put(string, strOptString);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (PtgAdSdk.getConfig().getFdRule() != 2) {
            try {
                if (_b.compareAndSet(false, true)) {
                    ScheduledFuture<?> scheduledFuture = _d;
                    if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                        _d.cancel(false);
                    }
                    if (_g.isEmpty()) {
                        return;
                    }
                    _d = _c.scheduleWithFixedDelay(new _p1(new CopyOnWriteArraySet(), z), 0L, 1000L, TimeUnit.MILLISECONDS);
                    return;
                }
                return;
            } catch (Exception e) {
                Logger.e(_ie._a("ru_err: ").append(e.getMessage()).toString());
                return;
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap = _g;
        if (!TextUtil.isEmpty(concurrentHashMap) && _b.compareAndSet(false, true)) {
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            try {
                for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtil.isEmpty(key) && !TextUtil.isEmpty(value)) {
                        _e.add(value);
                        if (_c9._a(PtgAdSdk.getContext(), key)) {
                            copyOnWriteArraySet.add(value);
                        }
                    }
                }
                if (z) {
                    _f.clear();
                }
                _f.addAll(copyOnWriteArraySet);
                _a();
                StringBuilder sb = new StringBuilder();
                for (String str3 : _e) {
                    if (!TextUtils.isEmpty(str3)) {
                        sb.append(str3).append("@");
                    }
                }
                _kr._a(PtgAdSdk.getContext(), "ru_hi_de_to", sb.toString());
            } catch (Exception unused2) {
            } finally {
                _b.set(false);
                _g.clear();
                copyOnWriteArraySet.clear();
            }
        }
    }

    public static void _a() {
        StringBuilder sb = new StringBuilder();
        for (String str : _f) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str).append("@");
            }
        }
        _kr._a(PtgAdSdk.getContext(), "ru_hi_de_li", sb.toString());
    }
}
