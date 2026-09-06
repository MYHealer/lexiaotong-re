package com.bytedance.msdk.adapter.ks.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.huawei.hms.ads.ez;
import com.umeng.analytics.pro.o;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class MediationAdLoaderBaseFunction extends AdnAdapterBaseFunction implements Bridge {
    public static final String TAG = "TTMediationSDK";
    public Function<SparseArray<Object>, Object> mGmAdLoader;
    public MediationAdSlotValueSet mSlotValueSet;

    private Object a(Object obj, String str) {
        Field fieldA = a(obj.getClass(), str);
        if (fieldA != null) {
            return a(fieldA, obj);
        }
        return null;
    }

    private Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    private Field a(Class<?> cls, String str) {
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8241) {
            load((Context) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold), Context.class, null), AdnAdapterValueSetBuilder.converToSparseArray(MediationValueUtil.objectValue(sparseArray.get(8424), Object.class, null)));
        }
        return (T) callFunction(i, sparseArray, cls);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public <T> T callFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    public String getAdm() {
        if (this.mGmAdLoader == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8137);
        sparseArray.put(-99999985, String.class);
        return (String) this.mGmAdLoader.apply(sparseArray);
    }

    public String getAdnId() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getADNId();
        }
        return null;
    }

    public int getBiddingType() {
        if (this.mGmAdLoader == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8226);
        sparseArray.put(-99999985, Integer.class);
        Integer num = (Integer) this.mGmAdLoader.apply(sparseArray);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Function<SparseArray<Object>, Object> getGMBridge() {
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8127);
        sparseArray.put(-99999985, Object.class);
        return AdnAdapterBridgeWrapper.covertToFunction(this.mGmAdLoader.apply(sparseArray));
    }

    public int getLoadTimeOut() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getAdLoadTimeOut();
        }
        return 3000;
    }

    public Activity getOriginActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (Activity) a(activity, "mOriginActivity");
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getOriginType() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getOriginType();
        }
        return 0;
    }

    public String getRitId() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRitId();
        }
        return null;
    }

    public boolean getSplashShakeButton() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isSplashShakeButton();
        }
        return false;
    }

    public boolean hasNotifyFail() {
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(o.a.z));
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isClientBidding() {
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8110);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isMultiBidding() {
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8141);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isServerBidding() {
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8136);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isSplashPreLoad() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isSplashPreLoad();
        }
        return false;
    }

    public final void load(Context context, SparseArray<Object> sparseArray) {
        MediationAdSlotValueSet mediationAdSlotValueSetCreate = MediationAdSlotValueSet.create(sparseArray);
        this.mSlotValueSet = mediationAdSlotValueSetCreate;
        this.mGmAdLoader = AdnAdapterBridgeWrapper.covertToFunction(mediationAdSlotValueSetCreate.getAdLoaderCallback());
        Map<String, Object> extraObject = mediationAdSlotValueSetCreate.getExtraObject();
        if (!TextUtils.equals((extraObject == null || !(extraObject.get("bidding_token") instanceof String)) ? "" : (String) extraObject.get("bidding_token"), ez.Code)) {
            realLoader(context, mediationAdSlotValueSetCreate);
            return;
        }
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(-99999987, 8138);
            sparseArray2.put(-99999985, null);
            sparseArray2.put(8043, this);
            this.mGmAdLoader.apply(sparseArray2);
        }
    }

    public void notifyAdCache(Function function, int i, String str) {
        Object bridge;
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8112);
            sparseArray.put(-99999985, Void.class);
            if (function instanceof AdnAdapterBridgeWrapper) {
                bridge = function;
                bridge = ((AdnAdapterBridgeWrapper) function).getBridge();
            }
            bridge = function;
            sparseArray.put(8303, bridge);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public void notifyAdFailed(int i, String str) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8108);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public void notifyAdSuccess(List<Object> list) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, Object.class);
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (Object bridge : list) {
                    if (bridge instanceof AdnAdapterBridgeWrapper) {
                        bridge = ((AdnAdapterBridgeWrapper) bridge).getBridge();
                    }
                    arrayList.add(bridge);
                }
            }
            sparseArray.put(8303, arrayList);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public void notifyAdSuccess(Function function, Function function2) {
        Object bridge;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 8128);
        sparseArray.put(-99999985, Void.class);
        boolean z = function instanceof AdnAdapterBridgeWrapper;
        Object bridge2 = function;
        if (z) {
            bridge2 = ((AdnAdapterBridgeWrapper) function).getBridge();
        }
        sparseArray.put(8035, bridge2);
        function2.apply(sparseArray);
        if (this.mGmAdLoader != null) {
            ArrayList arrayList = new ArrayList();
            if (function2 instanceof AdnAdapterBridgeWrapper) {
                bridge = function2;
                bridge = ((AdnAdapterBridgeWrapper) function2).getBridge();
            }
            bridge = function2;
            arrayList.add(bridge);
            notifyAdSuccess(arrayList);
        }
    }

    public abstract void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet);

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
