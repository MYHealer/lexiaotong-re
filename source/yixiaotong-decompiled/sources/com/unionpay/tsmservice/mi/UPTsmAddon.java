package com.unionpay.tsmservice.mi;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.hv.TTDownloadField;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import com.unionpay.tsmservice.mi.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.mi.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.mi.request.CancelPayRequestParams;
import com.unionpay.tsmservice.mi.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.mi.request.ClearEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.mi.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.HideSafetyKeyboardRequestParams;
import com.unionpay.tsmservice.mi.request.InitRequestParams;
import com.unionpay.tsmservice.mi.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.mi.request.PayResultNotifyRequestParams;
import com.unionpay.tsmservice.mi.request.PinRequestRequestParams;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.RequestParams;
import com.unionpay.tsmservice.mi.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.mi.result.AcquireSeAppListResult;
import com.unionpay.tsmservice.mi.result.AddCardResult;
import com.unionpay.tsmservice.mi.result.EncryptDataResult;
import com.unionpay.tsmservice.mi.result.GetEncryptDataResult;
import com.unionpay.tsmservice.mi.result.GetSeIdResult;
import com.unionpay.tsmservice.mi.result.InitResult;
import com.unionpay.tsmservice.mi.result.MessageDetailsResult;
import com.unionpay.tsmservice.mi.result.OnlinePaymentVerifyResult;
import com.unionpay.tsmservice.mi.result.PayResultNotifyResult;
import com.unionpay.tsmservice.mi.result.PinRequestResult;
import com.unionpay.tsmservice.mi.result.TransactionDetailsResult;
import com.unionpay.tsmservice.mi.result.VendorPayStatusResult;
import com.unionpay.tsmservice.mi.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UPTsmAddon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UPTsmAddon f9355a;
    private static CopyOnWriteArrayList b;
    private Context c;
    private ServiceConnection d = null;
    private ITsmService e = null;
    private boolean f = false;
    private HashMap g = new HashMap();
    private HashMap h = new HashMap();
    private HashMap i = new HashMap();
    private HashMap j = new HashMap();
    private HashMap k = new HashMap();
    private HashMap l = new HashMap();
    private HashMap m = new HashMap();
    private HashMap n = new HashMap();
    private HashMap o = new HashMap();
    private HashMap p = new HashMap();
    private HashMap q = new HashMap();
    private HashMap r = new HashMap();
    private HashMap s = new HashMap();
    private HashMap t = new HashMap();
    private HashMap u = new HashMap();
    private HashMap v = new HashMap();
    private int[] w;
    private final Handler.Callback x;
    private final Handler y;

    public interface UPTsmConnectionListener {
        void onTsmConnected();

        void onTsmDisconnected();
    }

    public final class a extends ITsmActivityCallback.Stub {
        private int b = 1000;

        public a() {
        }

        @Override // com.unionpay.tsmservice.mi.ITsmActivityCallback
        public final void startActivity(String str, String str2, int i, Bundle bundle) {
            UPTsmAddon.a((ITsmActivityCallback) UPTsmAddon.b(UPTsmAddon.this, this.b).get(UPTsmAddon.c(UPTsmAddon.this)), str, str2, i, bundle);
            UPTsmAddon.b(UPTsmAddon.this, this.b).remove(UPTsmAddon.c(UPTsmAddon.this));
        }
    }

    final class b extends ITsmCallback.Stub {
        private int b;
        private int c;

        private b(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        /* synthetic */ b(UPTsmAddon uPTsmAddon, int i, int i2, byte b) {
            this(i, i2);
        }

        @Override // com.unionpay.tsmservice.mi.ITsmCallback
        public final void onError(String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("errorCode", str);
            bundle.putString("errorDesc", str2);
            UPTsmAddon.a((ITsmCallback) UPTsmAddon.a(UPTsmAddon.this, this.b).get(String.valueOf(this.c)), bundle);
            UPTsmAddon.a(UPTsmAddon.this, this.b).remove(String.valueOf(this.c));
            if (UPTsmAddon.a(UPTsmAddon.this, this.b).isEmpty()) {
                UPTsmAddon.this.w[this.b] = 0;
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0047  */
        /* JADX WARN: Code duplicated, block: B:14:0x004c  */
        /* JADX WARN: Code duplicated, block: B:15:0x005a  */
        /* JADX WARN: Code duplicated, block: B:16:0x0068  */
        /* JADX WARN: Code duplicated, block: B:17:0x0076  */
        /* JADX WARN: Code duplicated, block: B:18:0x0083  */
        /* JADX WARN: Code duplicated, block: B:19:0x0090  */
        /* JADX WARN: Code duplicated, block: B:20:0x009d  */
        /* JADX WARN: Code duplicated, block: B:21:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:22:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:23:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:24:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:25:0x00de  */
        @Override // com.unionpay.tsmservice.mi.ITsmCallback
        public final void onResult(Bundle bundle) {
            Parcelable parcelable;
            new Bundle();
            int i = this.b;
            Bundle bundle2 = new Bundle();
            Parcel parcelObtain = Parcel.obtain();
            String string = bundle.getString("errorCode");
            String string2 = bundle.getString("result");
            bundle2.putString("errorCode", string);
            if (TextUtils.isEmpty(string2)) {
                switch (i) {
                    case 0:
                        parcelable = (InitResult) parcelObtain.readParcelable(InitResult.class.getClassLoader());
                        break;
                    case 1:
                        parcelable = (EncryptDataResult) parcelObtain.readParcelable(EncryptDataResult.class.getClassLoader());
                        break;
                    case 2:
                        parcelable = (GetEncryptDataResult) parcelObtain.readParcelable(GetEncryptDataResult.class.getClassLoader());
                        break;
                    case 6:
                        parcelable = (AcquireSeAppListResult) parcelObtain.readParcelable(AcquireSeAppListResult.class.getClassLoader());
                        break;
                    case 8:
                    case 9:
                    case 14:
                        parcelable = (VendorPayStatusResult) parcelObtain.readParcelable(VendorPayStatusResult.class.getClassLoader());
                        break;
                    case 10:
                        parcelable = (OnlinePaymentVerifyResult) parcelObtain.readParcelable(OnlinePaymentVerifyResult.class.getClassLoader());
                        break;
                    case 11:
                        parcelable = (PinRequestResult) parcelObtain.readParcelable(PinRequestResult.class.getClassLoader());
                        break;
                    case 12:
                        parcelable = (PayResultNotifyResult) parcelObtain.readParcelable(PinRequestResult.class.getClassLoader());
                        break;
                    case 15:
                        parcelable = (GetSeIdResult) parcelObtain.readParcelable(GetSeIdResult.class.getClassLoader());
                        break;
                    case 16:
                        parcelable = (AddCardResult) parcelObtain.readParcelable(AddCardResult.class.getClassLoader());
                        break;
                    case 17:
                        parcelable = (TransactionDetailsResult) parcelObtain.readParcelable(TransactionDetailsResult.class.getClassLoader());
                        break;
                    case 18:
                        parcelable = (MessageDetailsResult) parcelObtain.readParcelable(MessageDetailsResult.class.getClassLoader());
                        break;
                }
                bundle2.putParcelable("result", parcelable);
                bundle = bundle2;
            } else {
                byte[] bArrDecode = Base64.decode(UPTsmAddon.d(string2), 0);
                if (bArrDecode != null && bArrDecode.length != 0) {
                    parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                    parcelObtain.setDataPosition(0);
                }
                if (parcelObtain.dataSize() == 0) {
                    bundle2.putString("errorCode", "010035");
                } else {
                    switch (i) {
                        case 0:
                            parcelable = (InitResult) parcelObtain.readParcelable(InitResult.class.getClassLoader());
                            break;
                        case 1:
                            parcelable = (EncryptDataResult) parcelObtain.readParcelable(EncryptDataResult.class.getClassLoader());
                            break;
                        case 2:
                            parcelable = (GetEncryptDataResult) parcelObtain.readParcelable(GetEncryptDataResult.class.getClassLoader());
                            break;
                        case 6:
                            parcelable = (AcquireSeAppListResult) parcelObtain.readParcelable(AcquireSeAppListResult.class.getClassLoader());
                            break;
                        case 8:
                        case 9:
                        case 14:
                            parcelable = (VendorPayStatusResult) parcelObtain.readParcelable(VendorPayStatusResult.class.getClassLoader());
                            break;
                        case 10:
                            parcelable = (OnlinePaymentVerifyResult) parcelObtain.readParcelable(OnlinePaymentVerifyResult.class.getClassLoader());
                            break;
                        case 11:
                            parcelable = (PinRequestResult) parcelObtain.readParcelable(PinRequestResult.class.getClassLoader());
                            break;
                        case 12:
                            parcelable = (PayResultNotifyResult) parcelObtain.readParcelable(PinRequestResult.class.getClassLoader());
                            break;
                        case 15:
                            parcelable = (GetSeIdResult) parcelObtain.readParcelable(GetSeIdResult.class.getClassLoader());
                            break;
                        case 16:
                            parcelable = (AddCardResult) parcelObtain.readParcelable(AddCardResult.class.getClassLoader());
                            break;
                        case 17:
                            parcelable = (TransactionDetailsResult) parcelObtain.readParcelable(TransactionDetailsResult.class.getClassLoader());
                            break;
                        case 18:
                            parcelable = (MessageDetailsResult) parcelObtain.readParcelable(MessageDetailsResult.class.getClassLoader());
                            break;
                    }
                    bundle2.putParcelable("result", parcelable);
                }
                bundle = bundle2;
            }
            parcelObtain.recycle();
            UPTsmAddon.a((ITsmCallback) UPTsmAddon.a(UPTsmAddon.this, this.b).get(String.valueOf(this.c)), bundle);
            UPTsmAddon.a(UPTsmAddon.this, this.b).remove(String.valueOf(this.c));
            if (UPTsmAddon.a(UPTsmAddon.this, this.b).isEmpty()) {
                UPTsmAddon.this.w[this.b] = 0;
            }
        }
    }

    static {
        try {
            System.loadLibrary("uptsmaddon");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        f9355a = null;
        b = null;
    }

    private UPTsmAddon(Context context) {
        this.c = null;
        Handler.Callback callback = new Handler.Callback() { // from class: com.unionpay.tsmservice.mi.UPTsmAddon.1
            @Override // android.os.Handler.Callback
            public final synchronized boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    UPTsmAddon.a();
                    return true;
                }
                if (i != 1) {
                    return false;
                }
                UPTsmAddon.b();
                return true;
            }
        };
        this.x = callback;
        this.y = new Handler(Looper.getMainLooper(), callback);
        this.c = context;
        this.w = new int[19];
        if (!a(context)) {
            throw new RuntimeException();
        }
    }

    private static int a(int i, RequestParams requestParams, ITsmCallback iTsmCallback) {
        return new SessionKeyReExchange(f9355a, i, requestParams, iTsmCallback).reExchangeKey();
    }

    private static int a(int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        return new SessionKeyReExchange(f9355a, i, safetyKeyboardRequestParams, i2, onSafetyKeyboardCallback, context).reExchangeKey();
    }

    private static int a(RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        return new SessionKeyReExchange(f9355a, 16, requestParams, iTsmCallback, iTsmProgressCallback).reExchangeKey();
    }

    private static String a(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        String strC = (bArrMarshall == null || bArrMarshall.length == 0) ? "" : c(Base64.encodeToString(bArrMarshall, 0));
        parcelObtain.recycle();
        return strC;
    }

    static /* synthetic */ HashMap a(UPTsmAddon uPTsmAddon, int i) {
        switch (i) {
            case 0:
                return uPTsmAddon.g;
            case 1:
                return uPTsmAddon.h;
            case 2:
                return uPTsmAddon.i;
            case 3:
            case 4:
            case 5:
            case 13:
            default:
                return null;
            case 6:
                return uPTsmAddon.k;
            case 7:
                return uPTsmAddon.l;
            case 8:
                return uPTsmAddon.m;
            case 9:
                return uPTsmAddon.n;
            case 10:
                return uPTsmAddon.o;
            case 11:
                return uPTsmAddon.p;
            case 12:
                return uPTsmAddon.q;
            case 14:
                return uPTsmAddon.r;
            case 15:
                return uPTsmAddon.s;
            case 16:
                return uPTsmAddon.t;
            case 17:
                return uPTsmAddon.u;
            case 18:
                return uPTsmAddon.v;
        }
    }

    static /* synthetic */ void a() {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (UPTsmConnectionListener uPTsmConnectionListener : b) {
            if (uPTsmConnectionListener != null) {
                uPTsmConnectionListener.onTsmConnected();
            }
        }
    }

    static /* synthetic */ void a(ITsmActivityCallback iTsmActivityCallback, String str, String str2, int i, Bundle bundle) {
        if (iTsmActivityCallback != null) {
            try {
                iTsmActivityCallback.startActivity(str, str2, i, bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(ITsmCallback iTsmCallback, Bundle bundle) {
        if (iTsmCallback != null) {
            try {
                String string = bundle.getString("errorCode");
                if ("10000".equals(string)) {
                    iTsmCallback.onResult(bundle);
                } else {
                    iTsmCallback.onError(string, bundle.getString("errorDesc"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(Context context) {
        try {
            return IUPJniInterface.iJE(context);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ HashMap b(UPTsmAddon uPTsmAddon, int i) {
        if (i != 1000) {
            return null;
        }
        return uPTsmAddon.j;
    }

    static /* synthetic */ void b() {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (UPTsmConnectionListener uPTsmConnectionListener : b) {
            if (uPTsmConnectionListener != null) {
                uPTsmConnectionListener.onTsmDisconnected();
            }
        }
    }

    private static boolean b(String str) {
        try {
            return IUPJniInterface.cSKV(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ String c(UPTsmAddon uPTsmAddon) {
        return uPTsmAddon.c.getPackageName();
    }

    private static String c(String str) {
        try {
            return IUPJniInterface.eMG(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean c() {
        String strF = f("com.unionpay.tsmservice.mi");
        return strF != null && strF.compareTo(Constant.APK_VERSION_010002) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        try {
            return IUPJniInterface.dMG(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean e(String str) {
        String strF = f("com.unionpay.tsmservice.mi");
        return strF != null && strF.compareTo(str) >= 0;
    }

    private String f(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = this.c.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    private static String g(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("jarVersionCode", 19);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static synchronized UPTsmAddon getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (f9355a == null) {
            f9355a = new UPTsmAddon(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (b == null) {
            b = new CopyOnWriteArrayList();
        }
        return f9355a;
    }

    private String h(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("packageName", this.c.getPackageName());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static boolean isAppRunInBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (TextUtils.equals(runningAppProcessInfo.processName, context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                return false;
            }
        }
        return true;
    }

    public synchronized int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.08")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 6;
        if (!b(this.c.getPackageName())) {
            return a(6, acquireSEAppListRequestParams, iTsmCallback);
        }
        AcquireSEAppListRequestParams acquireSEAppListRequestParams2 = new AcquireSEAppListRequestParams();
        String reserve = "";
        if (acquireSEAppListRequestParams != null) {
            reserve = acquireSEAppListRequestParams.getReserve();
            Bundle params = acquireSEAppListRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                acquireSEAppListRequestParams2.setParams(bundle);
            }
        }
        acquireSEAppListRequestParams2.setReserve(c(h(g(reserve))));
        this.k.put(String.valueOf(this.w[6]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[6];
            iArr[6] = i2 + 1;
            int iAcquireSEAppList = iTsmService.acquireSEAppList(acquireSEAppListRequestParams2, new b(this, i, i2, (byte) 0));
            if (iAcquireSEAppList != 0) {
                HashMap map = this.k;
                int[] iArr2 = this.w;
                int i3 = iArr2[6] - 1;
                iArr2[6] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iAcquireSEAppList) {
                return iAcquireSEAppList;
            }
            return a(6, acquireSEAppListRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        if (addCardToVendorPayRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!e(com.unionpay.tsmservice.data.Constant.SUPPORTED_MIN_APK_VERSION)) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!b(this.c.getPackageName())) {
            return a(addCardToVendorPayRequestParams, iTsmCallback, iTsmProgressCallback);
        }
        AddCardToVendorPayRequestParams addCardToVendorPayRequestParams2 = new AddCardToVendorPayRequestParams();
        Bundle params = addCardToVendorPayRequestParams.getParams();
        if (params != null) {
            Bundle bundle = new Bundle();
            bundle.putString("encryptData", a(params));
            addCardToVendorPayRequestParams2.setParams(bundle);
        }
        addCardToVendorPayRequestParams2.setReserve(c(h(g(addCardToVendorPayRequestParams.getReserve()))));
        int i = 16;
        this.t.put(String.valueOf(this.w[16]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[16];
            iArr[16] = i2 + 1;
            int iAddCardToVendorPay = iTsmService.addCardToVendorPay(addCardToVendorPayRequestParams2, new b(this, i, i2, (byte) 0), iTsmProgressCallback);
            if (iAddCardToVendorPay != 0) {
                HashMap map = this.t;
                int[] iArr2 = this.w;
                int i3 = iArr2[16] - 1;
                iArr2[16] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iAddCardToVendorPay) {
                return iAddCardToVendorPay;
            }
            return a(addCardToVendorPayRequestParams, iTsmCallback, iTsmProgressCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized void addConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            b.add(uPTsmConnectionListener);
        }
    }

    public boolean bind() {
        if (this.d == null) {
            this.d = new ServiceConnection() { // from class: com.unionpay.tsmservice.mi.UPTsmAddon.2
                @Override // android.content.ServiceConnection
                public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    UPTsmAddon.this.f = true;
                    UPTsmAddon.this.e = ITsmService.Stub.asInterface(iBinder);
                    UPTsmAddon.this.y.sendEmptyMessage(0);
                }

                @Override // android.content.ServiceConnection
                public final synchronized void onServiceDisconnected(ComponentName componentName) {
                    UPTsmAddon.this.f = false;
                    UPTsmAddon.this.e = null;
                    UPTsmAddon.this.y.sendEmptyMessage(1);
                }
            };
        }
        if (this.f) {
            return true;
        }
        Intent intent = new Intent("com.unionpay.tsmservice.mi.UPTsmService");
        intent.setPackage("com.unionpay.tsmservice.mi");
        return this.c.bindService(intent, this.d, 1);
    }

    public synchronized int cancelPay() {
        if (!e("01.00.08")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!b(this.c.getPackageName())) {
            return a(13, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
        }
        CancelPayRequestParams cancelPayRequestParams = new CancelPayRequestParams();
        cancelPayRequestParams.setReserve(c(h(g(""))));
        try {
            int iCancelPay = this.e.cancelPay(cancelPayRequestParams);
            if (-2 != iCancelPay) {
                return iCancelPay;
            }
            return a(13, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.08")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 7;
        if (!b(this.c.getPackageName())) {
            return a(7, cardListStatusChangedRequestParams, iTsmCallback);
        }
        CardListStatusChangedRequestParams cardListStatusChangedRequestParams2 = new CardListStatusChangedRequestParams();
        cardListStatusChangedRequestParams2.setReserve(c(h(g(cardListStatusChangedRequestParams != null ? cardListStatusChangedRequestParams.getReserve() : ""))));
        this.l.put(String.valueOf(this.w[7]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[7];
            iArr[7] = i2 + 1;
            int iCardListStatusChanged = iTsmService.cardListStatusChanged(cardListStatusChangedRequestParams2, new b(this, i, i2, (byte) 0));
            if (iCardListStatusChanged != 0) {
                HashMap map = this.l;
                int[] iArr2 = this.w;
                int i3 = iArr2[7] - 1;
                iArr2[7] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == iCardListStatusChanged) {
                return a(7, cardListStatusChangedRequestParams, iTsmCallback);
            }
            return iCardListStatusChanged;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052 A[Catch: all -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:8:0x000a, B:10:0x000e, B:12:0x001c, B:14:0x0022, B:15:0x0038, B:23:0x0052, B:18:0x0040, B:19:0x0048, B:20:0x0049, B:29:0x005b, B:30:0x0063, B:31:0x0064), top: B:47:0x000a, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0058 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x0058, please report this as an issue */
    public synchronized int clearEncryptData(int i) {
        int iClearEncryptData;
        if (i < 2000 || i > 2002) {
            return -3;
        }
        if (this.e == null) {
            return -1;
        }
        if (!b(this.c.getPackageName())) {
            return a(4, (SafetyKeyboardRequestParams) null, i, (OnSafetyKeyboardCallback) null, (Context) null);
        }
        if (!c()) {
            try {
                iClearEncryptData = this.e.clearEncryptData(i);
                if (-2 == iClearEncryptData) {
                    return iClearEncryptData;
                }
                return a(4, (SafetyKeyboardRequestParams) null, i, (OnSafetyKeyboardCallback) null, (Context) null);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        ClearEncryptDataRequestParams clearEncryptDataRequestParams = new ClearEncryptDataRequestParams();
        clearEncryptDataRequestParams.setReserve(c(h(g(""))));
        try {
            iClearEncryptData = this.e.clearKeyboardEncryptData(clearEncryptDataRequestParams, i);
            if (-2 == iClearEncryptData) {
                return iClearEncryptData;
            }
            return a(4, (SafetyKeyboardRequestParams) null, i, (OnSafetyKeyboardCallback) null, (Context) null);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RemoteException();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public synchronized int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) {
        if (encryptDataRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 1;
        if (!b(this.c.getPackageName())) {
            return a(1, encryptDataRequestParams, iTsmCallback);
        }
        EncryptDataRequestParams encryptDataRequestParams2 = new EncryptDataRequestParams();
        String reserve = encryptDataRequestParams.getReserve();
        if (c()) {
            reserve = h(g(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            encryptDataRequestParams2.setReserve(c(reserve));
        }
        ArrayList arrayList = (ArrayList) encryptDataRequestParams.getData();
        byte b2 = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            if (size == 0) {
                return -3;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                String str = (String) arrayList.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    arrayList2.add(c(str));
                }
            }
            encryptDataRequestParams2.setData(arrayList2);
        }
        this.h.put(String.valueOf(this.w[1]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i3 = iArr[1];
            iArr[1] = i3 + 1;
            int iEncryptData = iTsmService.encryptData(encryptDataRequestParams2, new b(this, i, i3, b2));
            if (iEncryptData != 0) {
                HashMap map = this.h;
                int[] iArr2 = this.w;
                int i4 = iArr2[1] - 1;
                iArr2[1] = i4;
                map.remove(String.valueOf(i4));
            }
            if (-2 != iEncryptData) {
                return iEncryptData;
            }
            return a(1, encryptDataRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public int exchangeKey(String str, String[] strArr) throws RemoteException {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return -3;
        }
        ITsmService iTsmService = this.e;
        if (iTsmService == null) {
            return -1;
        }
        try {
            return iTsmService.exchangeKey(str, strArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public Context getContext() {
        return this.c;
    }

    public synchronized int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null || getEncryptDataRequestParams == null) {
            return -3;
        }
        int type = getEncryptDataRequestParams.getType();
        String pan = getEncryptDataRequestParams.getPan();
        if (type >= 2000 && type <= 2001) {
            if (type == 2000 && TextUtils.isEmpty(pan)) {
                return -3;
            }
            if (this.e == null) {
                return -1;
            }
            int i = 2;
            if (!b(this.c.getPackageName())) {
                return a(2, getEncryptDataRequestParams, iTsmCallback);
            }
            GetEncryptDataRequestParams getEncryptDataRequestParams2 = new GetEncryptDataRequestParams();
            if (type == 2000) {
                getEncryptDataRequestParams2.setPan(c(pan));
            }
            getEncryptDataRequestParams2.setType(type);
            String reserve = getEncryptDataRequestParams.getReserve();
            if (c()) {
                reserve = h(g(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                getEncryptDataRequestParams2.setReserve(c(reserve));
            }
            this.i.put(String.valueOf(this.w[2]), iTsmCallback);
            try {
                ITsmService iTsmService = this.e;
                int[] iArr = this.w;
                int i2 = iArr[2];
                iArr[2] = i2 + 1;
                int encryptData = iTsmService.getEncryptData(getEncryptDataRequestParams2, new b(this, i, i2, (byte) 0));
                if (encryptData != 0) {
                    HashMap map = this.i;
                    int[] iArr2 = this.w;
                    int i3 = iArr2[2] - 1;
                    iArr2[2] = i3;
                    map.remove(String.valueOf(i3));
                }
                if (-2 != encryptData) {
                    return encryptData;
                }
                return a(2, getEncryptDataRequestParams, iTsmCallback);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        return -3;
    }

    public synchronized int getListenerCount() {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList == null) {
            return 0;
        }
        return copyOnWriteArrayList.size();
    }

    public synchronized int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e(com.unionpay.tsmservice.data.Constant.APK_VERSION_010017)) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 18;
        if (!b(this.c.getPackageName())) {
            return a(18, getMessageDetailsRequestParams, iTsmCallback);
        }
        GetMessageDetailsRequestParams getMessageDetailsRequestParams2 = new GetMessageDetailsRequestParams();
        String reserve = "";
        if (getMessageDetailsRequestParams != null) {
            reserve = getMessageDetailsRequestParams.getReserve();
            Bundle params = getMessageDetailsRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                getMessageDetailsRequestParams2.setParams(bundle);
            }
        }
        getMessageDetailsRequestParams2.setReserve(c(h(g(reserve))));
        this.v.put(String.valueOf(this.w[18]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[18];
            iArr[18] = i2 + 1;
            int messageDetails = iTsmService.getMessageDetails(getMessageDetailsRequestParams2, new b(this, i, i2, (byte) 0));
            if (messageDetails != 0) {
                HashMap map = this.v;
                int[] iArr2 = this.w;
                int i3 = iArr2[18] - 1;
                iArr2[18] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != messageDetails) {
                return messageDetails;
            }
            return a(18, getMessageDetailsRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public int getPubKey(int i, String[] strArr) throws RemoteException {
        if (strArr == null || strArr.length == 0) {
            return -3;
        }
        ITsmService iTsmService = this.e;
        if (iTsmService == null) {
            return -1;
        }
        try {
            return iTsmService.getPubKey(i, strArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getSeId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.10")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 15;
        if (!b(this.c.getPackageName())) {
            return a(15, getSeIdRequestParams, iTsmCallback);
        }
        GetSeIdRequestParams getSeIdRequestParams2 = new GetSeIdRequestParams();
        getSeIdRequestParams2.setReserve(c(h(g(getSeIdRequestParams != null ? getSeIdRequestParams.getReserve() : ""))));
        this.s.put(String.valueOf(this.w[15]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[15];
            iArr[15] = i2 + 1;
            int sEId = iTsmService.getSEId(getSeIdRequestParams2, new b(this, i, i2, (byte) 0));
            if (sEId != 0) {
                HashMap map = this.s;
                int[] iArr2 = this.w;
                int i3 = iArr2[15] - 1;
                iArr2[15] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == sEId) {
                return a(15, getSeIdRequestParams, iTsmCallback);
            }
            return sEId;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e(com.unionpay.tsmservice.data.Constant.APK_VERSION_010017)) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 17;
        if (!b(this.c.getPackageName())) {
            return a(17, getTransactionDetailsRequestParams, iTsmCallback);
        }
        GetTransactionDetailsRequestParams getTransactionDetailsRequestParams2 = new GetTransactionDetailsRequestParams();
        String reserve = "";
        if (getTransactionDetailsRequestParams != null) {
            reserve = getTransactionDetailsRequestParams.getReserve();
            Bundle params = getTransactionDetailsRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                getTransactionDetailsRequestParams2.setParams(bundle);
            }
        }
        getTransactionDetailsRequestParams2.setReserve(c(h(g(reserve))));
        this.u.put(String.valueOf(this.w[17]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[17];
            iArr[17] = i2 + 1;
            int transactionDetails = iTsmService.getTransactionDetails(getTransactionDetailsRequestParams2, new b(this, i, i2, (byte) 0));
            if (transactionDetails != 0) {
                HashMap map = this.u;
                int[] iArr2 = this.w;
                int i3 = iArr2[17] - 1;
                iArr2[17] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != transactionDetails) {
                return transactionDetails;
            }
            return a(17, getTransactionDetailsRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.08")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 9;
        if (!b(this.c.getPackageName())) {
            return a(9, getVendorPayStatusRequestParams, iTsmCallback);
        }
        GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = new GetVendorPayStatusRequestParams();
        getVendorPayStatusRequestParams2.setReserve(c(h(g(getVendorPayStatusRequestParams != null ? getVendorPayStatusRequestParams.getReserve() : ""))));
        this.n.put(String.valueOf(this.w[9]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[9];
            iArr[9] = i2 + 1;
            int vendorPayStatus = iTsmService.getVendorPayStatus(getVendorPayStatusRequestParams2, new b(this, i, i2, (byte) 0));
            if (vendorPayStatus != 0) {
                HashMap map = this.n;
                int[] iArr2 = this.w;
                int i3 = iArr2[9] - 1;
                iArr2[9] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == vendorPayStatus) {
                return a(9, getVendorPayStatusRequestParams, iTsmCallback);
            }
            return vendorPayStatus;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getVendorPayStatusForBankApp(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.09")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 14;
        if (!b(this.c.getPackageName())) {
            return a(14, getVendorPayStatusRequestParams, iTsmCallback);
        }
        GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = new GetVendorPayStatusRequestParams();
        getVendorPayStatusRequestParams2.setReserve(c(h(g(getVendorPayStatusRequestParams != null ? getVendorPayStatusRequestParams.getReserve() : ""))));
        this.r.put(String.valueOf(this.w[14]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[14];
            iArr[14] = i2 + 1;
            int vendorPayStatusForBankApp = iTsmService.getVendorPayStatusForBankApp(getVendorPayStatusRequestParams2, new b(this, i, i2, (byte) 0));
            if (vendorPayStatusForBankApp != 0) {
                HashMap map = this.r;
                int[] iArr2 = this.w;
                int i3 = iArr2[14] - 1;
                iArr2[14] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == vendorPayStatusForBankApp) {
                return a(14, getVendorPayStatusRequestParams, iTsmCallback);
            }
            return vendorPayStatusForBankApp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004a A[Catch: all -> 0x0065, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0014, B:9:0x001a, B:10:0x0030, B:18:0x004a, B:13:0x0038, B:14:0x0040, B:15:0x0041, B:24:0x0053, B:25:0x005b, B:26:0x005c), top: B:35:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0050 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0050, please report this as an issue */
    public synchronized int hideKeyboard() {
        int iHideKeyboard;
        if (this.e == null) {
            return -1;
        }
        if (!b(this.c.getPackageName())) {
            return a(5, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
        }
        if (!c()) {
            try {
                iHideKeyboard = this.e.hideKeyboard();
                if (-2 == iHideKeyboard) {
                    return iHideKeyboard;
                }
                return a(5, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams = new HideSafetyKeyboardRequestParams();
        hideSafetyKeyboardRequestParams.setReserve(c(h(g(""))));
        try {
            iHideKeyboard = this.e.hideSafetyKeyboard(hideSafetyKeyboardRequestParams);
            if (-2 == iHideKeyboard) {
                return iHideKeyboard;
            }
            return a(5, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (this.e == null) {
            return -1;
        }
        byte b2 = 0;
        if (!b(this.c.getPackageName())) {
            return a(0, initRequestParams, iTsmCallback);
        }
        InitRequestParams initRequestParams2 = new InitRequestParams();
        String strH = "";
        if (initRequestParams != null) {
            strH = initRequestParams.getReserve();
            String signature = initRequestParams.getSignature();
            if (!TextUtils.isEmpty(signature)) {
                initRequestParams2.setSignature(c(signature));
            }
        }
        if (c()) {
            strH = h(g(strH));
        }
        if (!TextUtils.isEmpty(strH)) {
            initRequestParams2.setReserve(c(strH));
        }
        this.g.put(String.valueOf(this.w[0]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i = iArr[0];
            iArr[0] = i + 1;
            int iInit = iTsmService.init(initRequestParams2, new b(this, b2, i, b2));
            if (iInit != 0) {
                HashMap map = this.g;
                int[] iArr2 = this.w;
                int i2 = iArr2[0] - 1;
                iArr2[0] = i2;
                map.remove(String.valueOf(i2));
            }
            if (-2 != iInit) {
                return iInit;
            }
            return a(0, initRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public boolean isConnected() {
        return this.f;
    }

    public synchronized int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback) {
        if (onlinePaymentVerifyRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.08")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 10;
        if (!b(this.c.getPackageName())) {
            return a(10, onlinePaymentVerifyRequestParams, iTsmCallback);
        }
        OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams2 = new OnlinePaymentVerifyRequestParams();
        Bundle params = onlinePaymentVerifyRequestParams.getParams();
        if (params != null) {
            Bundle bundle = new Bundle();
            bundle.putString("encryptData", a(params));
            onlinePaymentVerifyRequestParams2.setParams(bundle);
        }
        onlinePaymentVerifyRequestParams2.setReserve(c(h(g(onlinePaymentVerifyRequestParams.getReserve()))));
        this.o.put(String.valueOf(this.w[10]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[10];
            iArr[10] = i2 + 1;
            int iOnlinePaymentVerify = iTsmService.onlinePaymentVerify(onlinePaymentVerifyRequestParams2, new b(this, i, i2, (byte) 0));
            if (iOnlinePaymentVerify != 0) {
                HashMap map = this.o;
                int[] iArr2 = this.w;
                int i3 = iArr2[10] - 1;
                iArr2[10] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iOnlinePaymentVerify) {
                return iOnlinePaymentVerify;
            }
            return a(10, onlinePaymentVerifyRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int payResultNotify(PayResultNotifyRequestParams payResultNotifyRequestParams, ITsmCallback iTsmCallback) {
        if (payResultNotifyRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.08")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 12;
        if (!b(this.c.getPackageName())) {
            return a(12, payResultNotifyRequestParams, iTsmCallback);
        }
        PayResultNotifyRequestParams payResultNotifyRequestParams2 = new PayResultNotifyRequestParams();
        Bundle params = payResultNotifyRequestParams.getParams();
        if (params != null) {
            Bundle bundle = new Bundle();
            bundle.putString("encryptData", a(params));
            payResultNotifyRequestParams2.setParams(bundle);
        }
        payResultNotifyRequestParams2.setReserve(c(h(g(payResultNotifyRequestParams.getReserve()))));
        this.q.put(String.valueOf(this.w[12]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[12];
            iArr[12] = i2 + 1;
            int iPayResultNotify = iTsmService.payResultNotify(payResultNotifyRequestParams2, new b(this, i, i2, (byte) 0));
            if (iPayResultNotify != 0) {
                HashMap map = this.q;
                int[] iArr2 = this.w;
                int i3 = iArr2[12] - 1;
                iArr2[12] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iPayResultNotify) {
                return iPayResultNotify;
            }
            return a(12, payResultNotifyRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int pinRequest(PinRequestRequestParams pinRequestRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.08")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 11;
        if (!b(this.c.getPackageName())) {
            return a(11, pinRequestRequestParams, iTsmCallback);
        }
        PinRequestRequestParams pinRequestRequestParams2 = new PinRequestRequestParams();
        String reserve = "";
        if (pinRequestRequestParams != null) {
            reserve = pinRequestRequestParams.getReserve();
            Bundle params = pinRequestRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                pinRequestRequestParams2.setParams(bundle);
            }
        }
        pinRequestRequestParams2.setReserve(c(h(g(reserve))));
        this.p.put(String.valueOf(this.w[11]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[11];
            iArr[11] = i2 + 1;
            int iPinRequest = iTsmService.pinRequest(pinRequestRequestParams2, new b(this, i, i2, (byte) 0));
            if (iPinRequest != 0) {
                HashMap map = this.p;
                int[] iArr2 = this.w;
                int i3 = iArr2[11] - 1;
                iArr2[11] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iPinRequest) {
                return iPinRequest;
            }
            return a(11, pinRequestRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!e("01.00.07")) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 8;
        if (!b(this.c.getPackageName())) {
            return a(8, queryVendorPayStatusRequestParams, iTsmCallback);
        }
        QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams2 = new QueryVendorPayStatusRequestParams();
        queryVendorPayStatusRequestParams2.setReserve(c(h(g(queryVendorPayStatusRequestParams != null ? queryVendorPayStatusRequestParams.getReserve() : ""))));
        this.m.put(String.valueOf(this.w[8]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.w;
            int i2 = iArr[8];
            iArr[8] = i2 + 1;
            int iQueryVendorPayStatus = iTsmService.queryVendorPayStatus(queryVendorPayStatusRequestParams2, new b(this, i, i2, (byte) 0));
            if (iQueryVendorPayStatus != 0) {
                HashMap map = this.m;
                int[] iArr2 = this.w;
                int i3 = iArr2[8] - 1;
                iArr2[8] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == iQueryVendorPayStatus) {
                return a(8, queryVendorPayStatusRequestParams, iTsmCallback);
            }
            return iQueryVendorPayStatus;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized void removeConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            b.remove(uPTsmConnectionListener);
        }
    }

    public synchronized int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) {
        if (safetyKeyboardRequestParams == null) {
            return -3;
        }
        if (this.e == null) {
            return -1;
        }
        if (!b(this.c.getPackageName())) {
            return a(3, safetyKeyboardRequestParams, (ITsmCallback) null);
        }
        String reserve = safetyKeyboardRequestParams.getReserve();
        if (c()) {
            reserve = h(g(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            safetyKeyboardRequestParams.setReserve(c(reserve));
        }
        try {
            int safetyKeyboardBitmap = this.e.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            if (-2 != safetyKeyboardBitmap) {
                return safetyKeyboardBitmap;
            }
            return a(3, safetyKeyboardRequestParams, (ITsmCallback) null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        if (safetyKeyboardRequestParams == null || i < 2000 || i > 2002) {
            return -3;
        }
        if (this.e == null) {
            return -1;
        }
        if (!b(this.c.getPackageName())) {
            return a(1000, safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, context);
        }
        this.j.put(this.c.getPackageName(), new com.unionpay.tsmservice.mi.a(context));
        String reserve = safetyKeyboardRequestParams.getReserve();
        if (c()) {
            reserve = h(g(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            safetyKeyboardRequestParams.setReserve(c(reserve));
        }
        try {
            int iShowSafetyKeyboard = this.e.showSafetyKeyboard(safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, new a());
            if (iShowSafetyKeyboard != 0) {
                this.j.remove(this.c.getPackageName());
            }
            if (-2 != iShowSafetyKeyboard) {
                return iShowSafetyKeyboard;
            }
            return a(1000, safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, context);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public void unbind() {
        ServiceConnection serviceConnection = this.d;
        if (serviceConnection == null || !this.f) {
            return;
        }
        this.c.unbindService(serviceConnection);
        this.f = false;
    }
}
