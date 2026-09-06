package com.byazt.vx;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 145})
public class my extends HashMap<String, Object> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (MediationConstant.KEY_GM_USB.equals(obj)) {
            com.byazt.bp.c.t().c(true);
            if (!com.byazt.bp.tt.tt().lr()) {
                return "接口获取无权限，请联系商务开通";
            }
        } else if (MediationConstant.KEY_GM_POLICY.equals(obj)) {
            if (!com.byazt.bp.tt.tt().l()) {
                return "接口获取无权限，请联系商务开通";
            }
            Object obj2 = get(MediationConstant.KEY_GM_PRIME_RIT);
            if (obj2 instanceof String) {
                String str = (String) obj2;
                com.byazt.bg.tt ttVarPu = com.byazt.bp.tt.tt().pu();
                if (ttVarPu != null) {
                    return ttVarPu.c(str, this);
                }
            }
        }
        return super.get(obj);
    }

    @Override // java.util.HashMap, java.util.Map
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        if (MediationConstant.KEY_GM_USB.equals(str)) {
            return !com.byazt.bp.tt.tt().lr() ? super.put(str, "接口获取无权限，请联系商务开通") : super.put(str, obj);
        }
        if (MediationConstant.KEY_USE_POLICY.equals(str) && com.byazt.bp.tt.tt().l() && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!com.byazt.bp.c.t().uj().containsKey(next)) {
                    com.byazt.eu.tt.uj("TTMediationSDK", "KEY_USE_POLICY的adLoad参数中存在不合法key：" + next + "，该key将被移除，如需要自定义key 请通过 KEY_USE_POLICY 中的 KEY_USE_POLICY_OBJ_CUSTOM 实现");
                } else {
                    Object objOpt = jSONObject.opt(next);
                    if (objOpt != null && !c(String.valueOf(objOpt))) {
                        com.byazt.nr.m.uj("TTMediationSDK", "adLoad参数中key为 " + next + " 字段的值，" + objOpt + " 存在不合法输入");
                    }
                }
            }
        }
        return super.put(str, obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
