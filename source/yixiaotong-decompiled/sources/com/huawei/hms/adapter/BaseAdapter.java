package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import com.stub.StubApp;
import com.ubixnow.ooooo.o0OO000o;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<ApiClient> f3798a;
    private WeakReference<Activity> b;
    private BaseCallBack c;
    private String d;
    private String e;
    private Parcelable f;
    private BaseCallBack g;
    private String h;
    private Context i;
    private RequestHeader j = new RequestHeader();
    private ResponseHeader k = new ResponseHeader();
    private SystemObserver l;

    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AtomicBoolean f3800a = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        private void a(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i) {
            if (!CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                if (!"installHMS".equals(str)) {
                    b(baseCallBack, coreBaseResponse);
                    return;
                } else {
                    HMSLog.i("BaseAdapter", "has resolutin: installHMS");
                    a(baseCallBack, coreBaseResponse);
                    return;
                }
            }
            Activity activityC = BaseAdapter.this.c();
            HMSLog.i("BaseAdapter", "activity is: " + activityC);
            if (activityC == null || activityC.isFinishing()) {
                HMSLog.e("BaseAdapter", "activity null");
                b(baseCallBack, coreBaseResponse);
                return;
            }
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.i)) {
                    BaseAdapter.this.a(activityC, pendingIntent);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.b(-9));
                    return;
                }
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.i)) {
                    BaseAdapter.this.a(activityC, intent);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.b(-9));
                    return;
                }
            }
            if (i == 2) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseCallBack.onError(baseAdapter.b(baseAdapter.k.getErrorCode()));
            } else {
                HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                baseCallBack.onError(BaseAdapter.this.b(-4));
            }
        }

        private void b(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
                return;
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intent);
            } else {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            BaseCallBack baseCallBackB = BaseAdapter.this.b();
            if (baseCallBackB == null) {
                HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                return;
            }
            if (resolveResult == null) {
                HMSLog.e("BaseAdapter", "result null");
                baseCallBackB.onError(BaseAdapter.this.b(-1));
                return;
            }
            CoreBaseResponse value = resolveResult.getValue();
            if (value == null) {
                HMSLog.e("BaseAdapter", "response null");
                baseCallBackB.onError(BaseAdapter.this.b(-1));
                return;
            }
            if (TextUtils.isEmpty(value.getJsonHeader())) {
                HMSLog.e("BaseAdapter", "jsonHeader null");
                baseCallBackB.onError(BaseAdapter.this.b(-1));
                return;
            }
            JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.k);
            if (this.f3800a.compareAndSet(true, false)) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseAdapter.a(baseAdapter.i, BaseAdapter.this.k);
            }
            String resolution = BaseAdapter.this.k.getResolution();
            int statusCode = BaseAdapter.this.k.getStatusCode();
            HMSLog.i("BaseAdapter", "api is: " + BaseAdapter.this.k.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
            a(resolution, baseCallBackB, value, statusCode);
        }

        private void a(final BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            if (Util.isAvailableLibExist(BaseAdapter.this.i)) {
                Activity activityC = BaseAdapter.this.c();
                if (activityC != null && !activityC.isFinishing()) {
                    HMSLog.i("BaseAdapter", "start handleSolutionForHMS");
                    AvailableAdapter availableAdapter = new AvailableAdapter(10000000);
                    availableAdapter.setCalledBySolutionInstallHms(true);
                    availableAdapter.startResolution(activityC, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1
                        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                        public void onComplete(int i) {
                            HMSLog.i("BaseAdapter", "complete handleSolutionForHMS, result: " + i);
                            if (i != 0) {
                                BaseAdapter baseAdapter = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter.a(i, baseAdapter.a(i)).toJson());
                            } else {
                                HMSPackageManager.getInstance(BaseAdapter.this.i).resetMultiServiceState();
                                BaseAdapter baseAdapter2 = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter2.a(11, baseAdapter2.a(11)).toJson());
                                BaseAdapter.this.i();
                            }
                        }
                    });
                    return;
                }
                HMSLog.e("BaseAdapter", "activity is null");
                try {
                    if (BaseAdapter.this.i != null && AvailableUtil.isInstallerLibExist(BaseAdapter.this.i)) {
                        HMSLog.i("BaseAdapter", "pass installHMS intent");
                        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(BaseAdapter.this.i, UpdateAdapter.class.getName());
                        intentStartBridgeActivity.putExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.UPDATE_VERSION, 10000000);
                        intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                        coreBaseResponse.setIntent(intentStartBridgeActivity);
                        b(baseCallBack, coreBaseResponse);
                    } else {
                        HMSLog.i("BaseAdapter", "pass ACTIVITY_NULL error");
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.a(-3, baseAdapter.a(-3)).toJson());
                    }
                    return;
                } catch (RuntimeException unused) {
                    HMSLog.e("BaseAdapter", "handleSolutionForHms pass result failed");
                    return;
                }
            }
            HMSLog.i("BaseAdapter", "handleSolutionForHms: no Available lib exist");
            baseCallBack.onError(BaseAdapter.this.b(-9));
        }
    }

    private static class MPendingResultImpl extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public MPendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.f3798a = new WeakReference<>(apiClient);
        this.i = StubApp.getOrigApplicationContext(apiClient.getContext().getApplicationContext());
        HMSLog.i("BaseAdapter", "In constructor, WeakReference is " + this.f3798a);
    }

    private BaseCallBack a() {
        return this.g;
    }

    private void a(Parcelable parcelable) {
        this.f = parcelable;
    }

    private void a(BaseCallBack baseCallBack) {
        this.g = baseCallBack;
    }

    private void a(String str) {
        this.d = str;
    }

    private void b(String str) {
        this.e = str;
    }

    private String d() {
        return this.d;
    }

    private String e() {
        return this.e;
    }

    private Parcelable f() {
        return this.f;
    }

    private void g() {
        this.l = new SystemObserver() { // from class: com.huawei.hms.adapter.BaseAdapter.1
            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
                    BaseCallBack baseCallBackB = BaseAdapter.this.b();
                    if (baseCallBackB == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
                        return true;
                    }
                    baseCallBackB.onError(BaseAdapter.this.b(-6));
                    return true;
                }
                if (!str.equals(BaseAdapter.this.h)) {
                    return false;
                }
                HMSLog.i("BaseAdapter", "onSolutionResult + id is :" + str);
                BaseCallBack baseCallBackB2 = BaseAdapter.this.b();
                if (baseCallBackB2 == null) {
                    HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                    return true;
                }
                if (intent == null) {
                    HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
                    String strB = BaseAdapter.this.b(-7);
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.a(baseAdapter.i, BaseAdapter.this.k, 0L);
                    baseCallBackB2.onError(strB);
                    return true;
                }
                if (BaseAdapter.this.b(intent, baseCallBackB2) || BaseAdapter.this.a(intent, baseCallBackB2)) {
                    return true;
                }
                HMSLog.e("BaseAdapter", "onComplete for on activity result");
                BaseAdapter.this.c(intent, baseCallBackB2);
                return true;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i) {
                return false;
            }
        };
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str, str2, parcelable, baseCallBack);
        if (this.f3798a == null) {
            HMSLog.e("BaseAdapter", "client is null");
            baseCallBack.onError(b(-2));
            return;
        }
        this.c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.e("BaseAdapter", "get uri null");
            baseCallBack.onError(b(-5));
            return;
        }
        String transactionId = this.j.getTransactionId();
        this.h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.e("BaseAdapter", "get transactionId null");
            baseCallBack.onError(b(-6));
        } else {
            HMSLog.i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.h);
            a(this.i, this.j);
            a(this.f3798a.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.i == null) {
            HMSLog.e("BaseAdapter", "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.action.SESSION_INVALID");
        intent.setPackage(this.i.getPackageName());
        this.i.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity c() {
        if (this.b == null) {
            HMSLog.i("BaseAdapter", "activityWeakReference is " + this.b);
            return null;
        }
        ApiClient apiClient = this.f3798a.get();
        if (apiClient == null) {
            HMSLog.i("BaseAdapter", "tmpApi is null");
            return null;
        }
        HMSLog.i("BaseAdapter", "activityWeakReference has " + this.b.get());
        return Util.getActiveActivity(this.b.get(), apiClient.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseCallBack b() {
        BaseCallBack baseCallBack = this.c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.e("BaseAdapter", "callback null");
        return null;
    }

    private void h() {
        if (this.d == null || this.g == null) {
            return;
        }
        this.k = null;
        this.k = new ResponseHeader();
        baseRequest(d(), e(), f(), a());
    }

    private void b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new MPendingResultImpl(apiClient, str, coreBaseRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Parcelable parcelable) {
        HMSLog.i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.j;
        if (requestHeader != null) {
            b(this.i, requestHeader);
        }
        if (this.l == null) {
            g();
        }
        SystemManager.getSystemNotifier().registerObserver(this.l);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID, this.h);
        activity.startActivity(intentStartBridgeActivity);
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.f3798a = new WeakReference<>(apiClient);
        this.b = new WeakReference<>(activity);
        this.i = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        HMSLog.i("BaseAdapter", "In constructor, activityWeakReference is " + this.b + ", activity is " + this.b.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i) {
        c(i);
        return this.k.toJson();
    }

    private void c(int i) {
        this.k.setTransactionId(this.j.getTransactionId());
        this.k.setAppID(this.j.getAppID());
        this.k.setApiName(this.j.getApiName());
        this.k.setSrvName(this.j.getSrvName());
        this.k.setPkgName(this.j.getPkgName());
        this.k.setStatusCode(1);
        this.k.setErrorCode(i);
        this.k.setErrorReason("Core error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.i("BaseAdapter", "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.e("BaseAdapter", "kit update success,replay request");
            h();
        } else {
            HMSLog.e("BaseAdapter", "kit update failed");
            baseCallBack.onError(a(-10, a(intExtra)).toJson());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0035  */
    public void c(Intent intent, BaseCallBack baseCallBack) {
        long jLongValue;
        String stringExtra = intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.JSON_HEADER);
        String stringExtra2 = intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.JSON_BODY);
        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, o0OO000o.o000o0oo);
        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
        if (intent.hasExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
            if (infoFromJsonobject3 instanceof Long) {
                jLongValue = ((Long) infoFromJsonobject3).longValue();
            } else {
                jLongValue = 0;
            }
        } else {
            jLongValue = 0;
        }
        if ((infoFromJsonobject instanceof Integer) && (infoFromJsonobject2 instanceof Integer)) {
            int iIntValue = ((Integer) infoFromJsonobject).intValue();
            b(((Integer) infoFromJsonobject2).intValue());
            this.k.setStatusCode(iIntValue);
            a(this.i, this.k, jLongValue);
        } else {
            b(-8);
            a(this.i, this.k, jLongValue);
        }
        baseCallBack.onComplete(stringExtra, stringExtra2, null);
    }

    private void a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader, long j) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResponseWrap a(int i, String str) {
        c(i);
        ResponseWrap responseWrap = new ResponseWrap(this.k);
        responseWrap.setBody(str);
        return responseWrap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i);
        } catch (JSONException e) {
            HMSLog.e("BaseAdapter", "buildBodyStr failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    private void a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str);
        b(str2);
        a(parcelable);
        a(baseCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        if (intent.getIntExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001) == 1001) {
            HMSLog.i("BaseAdapter", "privacy_statement_confirm_result agreed, replay request");
            h();
            return true;
        }
        HMSLog.i("BaseAdapter", "privacy_statement_confirm_result rejected");
        baseCallBack.onError(a(com.huawei.hms.adapter.internal.CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, a(com.huawei.hms.adapter.internal.CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }
}
