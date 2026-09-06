package com.unionpay.tsmservice;

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
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Amount;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.request.ActivateVendorPayRequestParams;
import com.unionpay.tsmservice.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.ClearEncryptDataRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.HideSafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.PreDownloadRequestParams;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SendCustomDataRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.request.UniteRequestParams;
import com.unionpay.tsmservice.result.AcquireSeAppListResult;
import com.unionpay.tsmservice.result.AddCardResult;
import com.unionpay.tsmservice.result.CheckSSamsungPayResult;
import com.unionpay.tsmservice.result.EncryptDataResult;
import com.unionpay.tsmservice.result.GetCardInfoBySpayResult;
import com.unionpay.tsmservice.result.GetEncryptDataResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.GetSeIdResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.MessageDetailsResult;
import com.unionpay.tsmservice.result.OnlinePaymentVerifyResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;
import com.unionpay.tsmservice.result.SendCustomDataResult;
import com.unionpay.tsmservice.result.TransactionDetailsResult;
import com.unionpay.tsmservice.result.UniteResult;
import com.unionpay.tsmservice.result.VendorPayStatusResult;
import com.unionpay.tsmservice.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UPTsmAddon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UPTsmAddon f9342a;
    private static CopyOnWriteArrayList b;
    private int[] Z;
    private final Handler.Callback aa;
    private final Handler ab;
    private Context c;
    private ServiceConnection d = null;
    private ITsmService e = null;
    private boolean f = false;
    private int g = 1;
    private boolean h = false;
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
    private HashMap w = new HashMap();
    private HashMap x = new HashMap();
    private HashMap y = new HashMap();
    private HashMap z = new HashMap();
    private HashMap A = new HashMap();
    private HashMap B = new HashMap();
    private HashMap C = new HashMap();
    private HashMap D = new HashMap();
    private HashMap E = new HashMap();
    private HashMap F = new HashMap();
    private HashMap G = new HashMap();
    private HashMap H = new HashMap();
    private HashMap I = new HashMap();
    private HashMap J = new HashMap();
    private HashMap K = new HashMap();
    private HashMap L = new HashMap();
    private HashMap M = new HashMap();
    private HashMap N = new HashMap();
    private HashMap O = new HashMap();
    private HashMap P = new HashMap();
    private HashMap Q = new HashMap();
    private HashMap R = new HashMap();
    private HashMap S = new HashMap();
    private HashMap T = new HashMap();
    private HashMap U = new HashMap();
    private HashMap V = new HashMap();
    private HashMap W = new HashMap();
    private HashMap X = new HashMap();
    private HashMap Y = new HashMap();

    public interface UPTsmConnectionListener {
        void onTsmConnected();

        void onTsmDisconnected();
    }

    public final class a extends ITsmActivityCallback.Stub {
        private int b = 1000;

        public a() {
        }

        @Override // com.unionpay.tsmservice.ITsmActivityCallback
        public final void startActivity(String str, String str2, int i, Bundle bundle) {
            UPTsmAddon.a((ITsmActivityCallback) UPTsmAddon.b(UPTsmAddon.this, this.b).get(UPTsmAddon.e(UPTsmAddon.this)), str, str2, i, bundle);
            UPTsmAddon.b(UPTsmAddon.this, this.b).remove(UPTsmAddon.e(UPTsmAddon.this));
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

        @Override // com.unionpay.tsmservice.ITsmCallback
        public final void onError(String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("errorCode", str);
            bundle.putString("errorDesc", str2);
            UPTsmAddon.a((ITsmCallback) UPTsmAddon.a(UPTsmAddon.this, this.b).get(String.valueOf(this.c)), bundle);
            UPTsmAddon.a(UPTsmAddon.this, this.b).remove(String.valueOf(this.c));
            if (UPTsmAddon.a(UPTsmAddon.this, this.b).isEmpty()) {
                UPTsmAddon.this.Z[this.b] = 0;
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0049 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:13:0x004b  */
        /* JADX WARN: Code duplicated, block: B:15:0x004e  */
        /* JADX WARN: Code duplicated, block: B:17:0x0052  */
        /* JADX WARN: Code duplicated, block: B:19:0x0056  */
        /* JADX WARN: Code duplicated, block: B:21:0x005a  */
        /* JADX WARN: Code duplicated, block: B:23:0x005e  */
        /* JADX WARN: Code duplicated, block: B:25:0x0062  */
        /* JADX WARN: Code duplicated, block: B:27:0x0066  */
        /* JADX WARN: Code duplicated, block: B:29:0x006a  */
        /* JADX WARN: Code duplicated, block: B:31:0x006e  */
        /* JADX WARN: Code duplicated, block: B:33:0x0072  */
        /* JADX WARN: Code duplicated, block: B:35:0x0076  */
        /* JADX WARN: Code duplicated, block: B:37:0x007b  */
        /* JADX WARN: Code duplicated, block: B:38:0x0089  */
        /* JADX WARN: Code duplicated, block: B:39:0x0097  */
        /* JADX WARN: Code duplicated, block: B:40:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:44:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:45:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:47:0x0105  */
        /* JADX WARN: Code duplicated, block: B:48:0x0112  */
        /* JADX WARN: Code duplicated, block: B:49:0x011f  */
        /* JADX WARN: Code duplicated, block: B:50:0x012c  */
        /* JADX WARN: Code duplicated, block: B:51:0x0139  */
        /* JADX WARN: Code duplicated, block: B:52:0x0146  */
        /* JADX WARN: Code duplicated, block: B:53:0x0153  */
        @Override // com.unionpay.tsmservice.ITsmCallback
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
                if (i != 0) {
                    parcelable = (InitResult) parcelObtain.readParcelable(InitResult.class.getClassLoader());
                } else if (i != 3) {
                    parcelable = (GetSeAppListResult) parcelObtain.readParcelable(GetSeAppListResult.class.getClassLoader());
                } else if (i != 12) {
                    parcelable = (GetSeIdResult) parcelObtain.readParcelable(GetSeIdResult.class.getClassLoader());
                } else if (i != 20) {
                    parcelable = (OpenChannelResult) parcelObtain.readParcelable(OpenChannelResult.class.getClassLoader());
                } else if (i != 31) {
                    parcelable = (GetEncryptDataResult) parcelObtain.readParcelable(GetEncryptDataResult.class.getClassLoader());
                } else if (i == 36) {
                    parcelable = (VendorPayStatusResult) parcelObtain.readParcelable(VendorPayStatusResult.class.getClassLoader());
                } else if (i != 22) {
                    parcelable = (SendApduResult) parcelObtain.readParcelable(SendApduResult.class.getClassLoader());
                } else if (i != 23) {
                    parcelable = (EncryptDataResult) parcelObtain.readParcelable(EncryptDataResult.class.getClassLoader());
                } else if (i != 28) {
                    parcelable = (GetCardInfoBySpayResult) parcelObtain.readParcelable(GetCardInfoBySpayResult.class.getClassLoader());
                } else if (i != 29) {
                    parcelable = (CheckSSamsungPayResult) parcelObtain.readParcelable(CheckSSamsungPayResult.class.getClassLoader());
                } else if (i != 38) {
                    parcelable = (AddCardResult) parcelObtain.readParcelable(AddCardResult.class.getClassLoader());
                } else if (i != 39) {
                    switch (i) {
                        case 41:
                            parcelable = (VendorPayStatusResult) parcelObtain.readParcelable(VendorPayStatusResult.class.getClassLoader());
                            break;
                        case 42:
                            parcelable = (AcquireSeAppListResult) parcelObtain.readParcelable(AcquireSeAppListResult.class.getClassLoader());
                            break;
                        case 43:
                            parcelable = (TransactionDetailsResult) parcelObtain.readParcelable(TransactionDetailsResult.class.getClassLoader());
                            break;
                        case 44:
                            parcelable = (MessageDetailsResult) parcelObtain.readParcelable(MessageDetailsResult.class.getClassLoader());
                            break;
                        case 45:
                            parcelable = (SendCustomDataResult) parcelObtain.readParcelable(SendCustomDataResult.class.getClassLoader());
                            break;
                        case 46:
                            parcelable = (UniteResult) parcelObtain.readParcelable(UniteResult.class.getClassLoader());
                            break;
                    }
                } else {
                    parcelable = (OnlinePaymentVerifyResult) parcelObtain.readParcelable(OnlinePaymentVerifyResult.class.getClassLoader());
                }
                bundle2.putParcelable("result", parcelable);
                bundle = bundle2;
            } else {
                byte[] bArrDecode = Base64.decode(UPTsmAddon.this.c(string2), 0);
                if (bArrDecode != null && bArrDecode.length != 0) {
                    parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                    parcelObtain.setDataPosition(0);
                }
                if (parcelObtain.dataSize() == 0) {
                    bundle2.putString("errorCode", "010035");
                } else {
                    if (i != 0) {
                        parcelable = (InitResult) parcelObtain.readParcelable(InitResult.class.getClassLoader());
                    } else if (i != 3) {
                        parcelable = (GetSeAppListResult) parcelObtain.readParcelable(GetSeAppListResult.class.getClassLoader());
                    } else if (i != 12) {
                        parcelable = (GetSeIdResult) parcelObtain.readParcelable(GetSeIdResult.class.getClassLoader());
                    } else if (i != 20) {
                        parcelable = (OpenChannelResult) parcelObtain.readParcelable(OpenChannelResult.class.getClassLoader());
                    } else if (i != 31) {
                        parcelable = (GetEncryptDataResult) parcelObtain.readParcelable(GetEncryptDataResult.class.getClassLoader());
                    } else if (i == 36) {
                        parcelable = (VendorPayStatusResult) parcelObtain.readParcelable(VendorPayStatusResult.class.getClassLoader());
                    } else if (i != 22) {
                        parcelable = (SendApduResult) parcelObtain.readParcelable(SendApduResult.class.getClassLoader());
                    } else if (i != 23) {
                        parcelable = (EncryptDataResult) parcelObtain.readParcelable(EncryptDataResult.class.getClassLoader());
                    } else if (i != 28) {
                        parcelable = (GetCardInfoBySpayResult) parcelObtain.readParcelable(GetCardInfoBySpayResult.class.getClassLoader());
                    } else if (i != 29) {
                        parcelable = (CheckSSamsungPayResult) parcelObtain.readParcelable(CheckSSamsungPayResult.class.getClassLoader());
                    } else if (i != 38) {
                        parcelable = (AddCardResult) parcelObtain.readParcelable(AddCardResult.class.getClassLoader());
                    } else if (i != 39) {
                        switch (i) {
                            case 41:
                                parcelable = (VendorPayStatusResult) parcelObtain.readParcelable(VendorPayStatusResult.class.getClassLoader());
                                break;
                            case 42:
                                parcelable = (AcquireSeAppListResult) parcelObtain.readParcelable(AcquireSeAppListResult.class.getClassLoader());
                                break;
                            case 43:
                                parcelable = (TransactionDetailsResult) parcelObtain.readParcelable(TransactionDetailsResult.class.getClassLoader());
                                break;
                            case 44:
                                parcelable = (MessageDetailsResult) parcelObtain.readParcelable(MessageDetailsResult.class.getClassLoader());
                                break;
                            case 45:
                                parcelable = (SendCustomDataResult) parcelObtain.readParcelable(SendCustomDataResult.class.getClassLoader());
                                break;
                            case 46:
                                parcelable = (UniteResult) parcelObtain.readParcelable(UniteResult.class.getClassLoader());
                                break;
                        }
                    } else {
                        parcelable = (OnlinePaymentVerifyResult) parcelObtain.readParcelable(OnlinePaymentVerifyResult.class.getClassLoader());
                    }
                    bundle2.putParcelable("result", parcelable);
                }
                bundle = bundle2;
            }
            parcelObtain.recycle();
            UPTsmAddon.a((ITsmCallback) UPTsmAddon.a(UPTsmAddon.this, this.b).get(String.valueOf(this.c)), bundle);
            UPTsmAddon.a(UPTsmAddon.this, this.b).remove(String.valueOf(this.c));
            if (UPTsmAddon.a(UPTsmAddon.this, this.b).isEmpty()) {
                UPTsmAddon.this.Z[this.b] = 0;
            }
        }
    }

    static {
        try {
            System.loadLibrary("uptsmaddon");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        f9342a = null;
        b = null;
    }

    private UPTsmAddon(Context context) {
        this.c = null;
        Handler.Callback callback = new Handler.Callback() { // from class: com.unionpay.tsmservice.UPTsmAddon.1
            @Override // android.os.Handler.Callback
            public final synchronized boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    UPTsmAddon.this.a();
                    return true;
                }
                if (i != 1) {
                    return false;
                }
                UPTsmAddon.this.b();
                return true;
            }
        };
        this.aa = callback;
        this.ab = new Handler(Looper.getMainLooper(), callback);
        this.c = context;
        this.Z = new int[47];
        if (!a(context)) {
            throw new RuntimeException();
        }
    }

    private static int a(int i, RequestParams requestParams, ITsmCallback iTsmCallback) {
        return new SessionKeyReExchange(f9342a, i, requestParams, iTsmCallback).reExchangeKey();
    }

    private static int a(int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        return new SessionKeyReExchange(f9342a, i, requestParams, iTsmCallback, iTsmProgressCallback).reExchangeKey();
    }

    private static int a(int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        return new SessionKeyReExchange(f9342a, i, safetyKeyboardRequestParams, i2, onSafetyKeyboardCallback, context).reExchangeKey();
    }

    private String a(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        String strB = (bArrMarshall == null || bArrMarshall.length == 0) ? "" : b(Base64.encodeToString(bArrMarshall, 0));
        parcelObtain.recycle();
        return strB;
    }

    static /* synthetic */ HashMap a(UPTsmAddon uPTsmAddon, int i) {
        switch (i) {
            case 0:
                return uPTsmAddon.i;
            case 1:
                return uPTsmAddon.j;
            case 2:
                return uPTsmAddon.l;
            case 3:
                return uPTsmAddon.k;
            case 4:
                return uPTsmAddon.n;
            case 5:
                return uPTsmAddon.m;
            case 6:
                return uPTsmAddon.A;
            case 7:
                return uPTsmAddon.u;
            case 8:
                return uPTsmAddon.v;
            case 9:
                return uPTsmAddon.o;
            case 10:
                return uPTsmAddon.t;
            case 11:
                return uPTsmAddon.r;
            case 12:
                return uPTsmAddon.z;
            case 13:
                return uPTsmAddon.y;
            case 14:
                return uPTsmAddon.E;
            case 15:
                return uPTsmAddon.p;
            case 16:
                return uPTsmAddon.C;
            case 17:
                return uPTsmAddon.D;
            case 18:
                return uPTsmAddon.q;
            case 19:
                return uPTsmAddon.s;
            case 20:
                return uPTsmAddon.w;
            case 21:
                return uPTsmAddon.F;
            case 22:
                return uPTsmAddon.x;
            case 23:
                return uPTsmAddon.B;
            case 24:
                return uPTsmAddon.G;
            case 25:
                return uPTsmAddon.H;
            case 26:
            case 27:
            case 32:
            case 33:
            case 34:
            default:
                return null;
            case 28:
                return uPTsmAddon.I;
            case 29:
                return uPTsmAddon.J;
            case 30:
                return uPTsmAddon.K;
            case 31:
                return uPTsmAddon.L;
            case 35:
                return uPTsmAddon.M;
            case 36:
                return uPTsmAddon.N;
            case 37:
                return uPTsmAddon.O;
            case 38:
                return uPTsmAddon.P;
            case 39:
                return uPTsmAddon.Q;
            case 40:
                return uPTsmAddon.R;
            case 41:
                return uPTsmAddon.S;
            case 42:
                return uPTsmAddon.T;
            case 43:
                return uPTsmAddon.U;
            case 44:
                return uPTsmAddon.V;
            case 45:
                return uPTsmAddon.W;
            case 46:
                return uPTsmAddon.X;
        }
    }

    private static HashMap a(HashMap map) {
        String str;
        if (map == null) {
            return new HashMap();
        }
        HashMap map2 = new HashMap();
        for (String str2 : map.keySet()) {
            if (str2 != null && (str = (String) map.get(str2)) != null) {
                map2.put(new String(str2), new String(str));
            }
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            for (UPTsmConnectionListener uPTsmConnectionListener : b) {
                if (uPTsmConnectionListener != null) {
                    uPTsmConnectionListener.onTsmConnected();
                }
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

    private static boolean a(String str) {
        try {
            return IUPJniInterface.cSKV(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    private String b(String str) {
        try {
            return IUPJniInterface.eMG(str, this.g);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    static /* synthetic */ HashMap b(UPTsmAddon uPTsmAddon, int i) {
        if (i != 1000) {
            return null;
        }
        return uPTsmAddon.Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            for (UPTsmConnectionListener uPTsmConnectionListener : b) {
                if (uPTsmConnectionListener != null) {
                    uPTsmConnectionListener.onTsmDisconnected();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        try {
            return IUPJniInterface.dMG(str, this.g);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean c() {
        String strE = e("com.unionpay.tsmservice");
        if (strE == null || strE.compareTo(Constant.SUPPORTED_MIN_APK_VERSION) < 0) {
            return false;
        }
        if (strE.compareTo(Constant.APK_VERSION_010018) >= 0) {
            this.g = 1;
            this.h = true;
            return true;
        }
        if (strE.compareTo(Constant.APK_VERSION_010012) >= 0 && strE.compareTo(Constant.APK_VERSION_010016) <= 0) {
            this.g = 2;
            this.h = false;
            return true;
        }
        if (strE.compareTo(Constant.APK_VERSION_010017) != 0 && strE.compareTo(Constant.SUPPORTED_MIN_APK_VERSION) != 0) {
            return false;
        }
        this.g = 1;
        this.h = false;
        return true;
    }

    private boolean d(String str) {
        String strE = e("com.unionpay.tsmservice");
        return strE != null && strE.compareTo(str) >= 0;
    }

    static /* synthetic */ String e(UPTsmAddon uPTsmAddon) {
        return uPTsmAddon.c.getPackageName();
    }

    private String e(String str) {
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

    private static String f(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("jarVersionCode", 52);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    private String g(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("packageName", this.c.getPackageName());
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
        if (f9342a == null) {
            f9342a = new UPTsmAddon(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (b == null) {
            b = new CopyOnWriteArrayList();
        }
        return f9342a;
    }

    public synchronized int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.28")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 42;
        if (!a(this.c.getPackageName())) {
            return a(42, acquireSEAppListRequestParams, iTsmCallback);
        }
        AcquireSEAppListRequestParams acquireSEAppListRequestParams2 = new AcquireSEAppListRequestParams();
        String strG = "";
        if (acquireSEAppListRequestParams != null) {
            strG = acquireSEAppListRequestParams.getReserve();
            Bundle params = acquireSEAppListRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                acquireSEAppListRequestParams2.setParams(bundle);
            }
        }
        if (this.h) {
            strG = g(f(strG));
        }
        if (!TextUtils.isEmpty(strG)) {
            acquireSEAppListRequestParams2.setReserve(b(strG));
        }
        this.T.put(String.valueOf(this.Z[42]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[42];
            iArr[42] = i2 + 1;
            int iAcquireSEAppList = iTsmService.acquireSEAppList(acquireSEAppListRequestParams2, new b(this, i, i2, (byte) 0));
            if (iAcquireSEAppList != 0) {
                HashMap map = this.T;
                int[] iArr2 = this.Z;
                int i3 = iArr2[42] - 1;
                iArr2[42] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iAcquireSEAppList) {
                return iAcquireSEAppList;
            }
            return a(42, acquireSEAppListRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int activateVendorPay(ActivateVendorPayRequestParams activateVendorPayRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.20")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 37;
        if (!a(this.c.getPackageName())) {
            return a(37, activateVendorPayRequestParams, iTsmCallback);
        }
        ActivateVendorPayRequestParams activateVendorPayRequestParams2 = new ActivateVendorPayRequestParams();
        String reserve = activateVendorPayRequestParams != null ? activateVendorPayRequestParams.getReserve() : "";
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            activateVendorPayRequestParams2.setReserve(b(reserve));
        }
        this.O.put(String.valueOf(this.Z[37]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[37];
            iArr[37] = i2 + 1;
            int iActivateVendorPay = iTsmService.activateVendorPay(activateVendorPayRequestParams2, new b(this, i, i2, (byte) 0));
            if (iActivateVendorPay != 0) {
                HashMap map = this.O;
                int[] iArr2 = this.Z;
                int i3 = iArr2[37] - 1;
                iArr2[37] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == iActivateVendorPay) {
                return a(37, activateVendorPayRequestParams, iTsmCallback);
            }
            return iActivateVendorPay;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        if (addCardToVendorPayRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.20")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 38;
        if (!a(this.c.getPackageName())) {
            return a(38, addCardToVendorPayRequestParams, iTsmCallback);
        }
        AddCardToVendorPayRequestParams addCardToVendorPayRequestParams2 = new AddCardToVendorPayRequestParams();
        Bundle params = addCardToVendorPayRequestParams.getParams();
        if (params != null) {
            Bundle bundle = new Bundle();
            bundle.putString("encryptData", a(params));
            addCardToVendorPayRequestParams2.setParams(bundle);
        }
        String reserve = addCardToVendorPayRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            addCardToVendorPayRequestParams2.setReserve(b(reserve));
        }
        this.P.put(String.valueOf(this.Z[38]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[38];
            iArr[38] = i2 + 1;
            int iAddCardToVendorPay = iTsmService.addCardToVendorPay(addCardToVendorPayRequestParams2, new b(this, i, i2, (byte) 0), iTsmProgressCallback);
            if (iAddCardToVendorPay != 0) {
                HashMap map = this.P;
                int[] iArr2 = this.Z;
                int i3 = iArr2[38] - 1;
                iArr2[38] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iAddCardToVendorPay) {
                return iAddCardToVendorPay;
            }
            return a(38, addCardToVendorPayRequestParams, iTsmCallback, iTsmProgressCallback);
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

    @Deprecated
    public synchronized int appDataUpdate(AppDataUpdateRequestParams appDataUpdateRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        if (appDataUpdateRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 18;
        if (!a(this.c.getPackageName())) {
            return a(18, appDataUpdateRequestParams, iTsmCallback, iTsmProgressCallback);
        }
        AppDataUpdateRequestParams appDataUpdateRequestParams2 = new AppDataUpdateRequestParams();
        String reserve = appDataUpdateRequestParams.getReserve();
        AppID appID = appDataUpdateRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            appDataUpdateRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                appDataUpdateRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        try {
            int iAppDataUpdate = this.e.appDataUpdate(appDataUpdateRequestParams2, new b(this, i, this.Z[18], (byte) 0), iTsmProgressCallback);
            if (-2 == iAppDataUpdate) {
                return a(18, appDataUpdateRequestParams, iTsmCallback, iTsmProgressCallback);
            }
            if (iAppDataUpdate == 0) {
                HashMap map = this.q;
                int[] iArr = this.Z;
                int i2 = iArr[18];
                iArr[18] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return iAppDataUpdate;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int appDelete(AppDeleteRequestParams appDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        if (appDeleteRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 17;
        if (!a(this.c.getPackageName())) {
            return a(17, appDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
        }
        AppDeleteRequestParams appDeleteRequestParams2 = new AppDeleteRequestParams();
        String reserve = appDeleteRequestParams.getReserve();
        AppID appID = appDeleteRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            appDeleteRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                appDeleteRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        HashMap map = (HashMap) appDeleteRequestParams.getParams();
        byte b2 = 0;
        if (map == null) {
            try {
                int iAppDelete = this.e.appDelete(appDeleteRequestParams2, new b(this, i, this.Z[17], b2), iTsmProgressCallback);
                if (-2 == iAppDelete) {
                    return a(17, appDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
                }
                if (iAppDelete == 0) {
                    HashMap map2 = this.D;
                    int[] iArr = this.Z;
                    int i2 = iArr[17];
                    iArr[17] = i2 + 1;
                    map2.put(String.valueOf(i2), iTsmCallback);
                }
                return iAppDelete;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        HashMap mapA = a(map);
        String str = (String) mapA.get(Constant.KEY_CARD_HOLDER_NAME);
        String str2 = (String) mapA.get(Constant.KEY_ID_TYPE);
        String str3 = (String) mapA.get(Constant.KEY_ID_NO);
        String str4 = (String) mapA.get(Constant.KEY_PAN);
        String str5 = (String) mapA.get(Constant.KEY_PIN);
        String str6 = (String) mapA.get(Constant.KEY_EXPIRY_DATE);
        String str7 = (String) mapA.get(Constant.KEY_CVN2);
        String str8 = (String) mapA.get(Constant.KEY_PHONE_NUMBER);
        String str9 = (String) mapA.get(Constant.KEY_SMS_AUTH_CODE);
        String str10 = (String) mapA.get(Constant.KEY_BALANCE);
        String str11 = (String) mapA.get("cardType");
        if (!TextUtils.isEmpty(str)) {
            mapA.put(Constant.KEY_CARD_HOLDER_NAME, b(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            mapA.put(Constant.KEY_ID_TYPE, b(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            mapA.put(Constant.KEY_ID_NO, b(str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            mapA.put(Constant.KEY_PAN, b(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
            mapA.put(Constant.KEY_PIN, str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            mapA.put(Constant.KEY_EXPIRY_DATE, b(str6));
        }
        if (!TextUtils.isEmpty(str7)) {
            mapA.put(Constant.KEY_CVN2, b(str7));
        }
        if (!TextUtils.isEmpty(str8)) {
            mapA.put(Constant.KEY_PHONE_NUMBER, b(str8));
        }
        if (!TextUtils.isEmpty(str9)) {
            mapA.put(Constant.KEY_SMS_AUTH_CODE, b(str9));
        }
        if (!TextUtils.isEmpty(str10)) {
            mapA.put(Constant.KEY_BALANCE, b(str10));
        }
        if (!TextUtils.isEmpty(str11)) {
            mapA.put("cardType", b(str11));
        }
        appDeleteRequestParams2.setParams(mapA);
        try {
            int iAppDelete2 = this.e.appDelete(appDeleteRequestParams2, new b(this, 17, this.Z[17], (byte) 0), iTsmProgressCallback);
            if (-2 == iAppDelete2) {
                return a(17, appDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
            }
            if (iAppDelete2 == 0) {
                HashMap map3 = this.D;
                int[] iArr2 = this.Z;
                int i3 = iArr2[17];
                iArr2[17] = i3 + 1;
                map3.put(String.valueOf(i3), iTsmCallback);
            }
            return iAppDelete2;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RemoteException();
        }
        throw th;
    }

    @Deprecated
    public synchronized int appDownload(AppDownloadRequestParams appDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        if (appDownloadRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 16;
        if (!a(this.c.getPackageName())) {
            return a(16, appDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
        }
        AppDownloadRequestParams appDownloadRequestParams2 = new AppDownloadRequestParams();
        String reserve = appDownloadRequestParams.getReserve();
        AppID appID = appDownloadRequestParams.getAppID();
        String appName = appDownloadRequestParams.getAppName();
        if (!TextUtils.isEmpty(reserve)) {
            appDownloadRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                appDownloadRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        if (!TextUtils.isEmpty(appName)) {
            appDownloadRequestParams2.setAppName(b(appName));
        }
        try {
            int iAppDownload = this.e.appDownload(appDownloadRequestParams2, new b(this, i, this.Z[16], (byte) 0), iTsmProgressCallback);
            if (-2 == iAppDownload) {
                return a(16, appDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
            }
            if (iAppDownload == 0) {
                HashMap map = this.C;
                int[] iArr = this.Z;
                int i2 = iArr[16];
                iArr[16] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return iAppDownload;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int appDownloadApply(AppDownloadApplyRequestParams appDownloadApplyRequestParams, ITsmCallback iTsmCallback) {
        if (appDownloadApplyRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 15;
        if (!a(this.c.getPackageName())) {
            return a(15, appDownloadApplyRequestParams, iTsmCallback);
        }
        AppDownloadApplyRequestParams appDownloadApplyRequestParams2 = new AppDownloadApplyRequestParams();
        String reserve = appDownloadApplyRequestParams.getReserve();
        AppID appID = appDownloadApplyRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            appDownloadApplyRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                appDownloadApplyRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        HashMap map = (HashMap) appDownloadApplyRequestParams.getParams();
        byte b2 = 0;
        if (map == null) {
            try {
                int iAppDownloadApply = this.e.appDownloadApply(appDownloadApplyRequestParams2, new b(this, i, this.Z[15], b2));
                if (-2 == iAppDownloadApply) {
                    return a(15, appDownloadApplyRequestParams, iTsmCallback);
                }
                if (iAppDownloadApply == 0) {
                    HashMap map2 = this.p;
                    int[] iArr = this.Z;
                    int i2 = iArr[15];
                    iArr[15] = i2 + 1;
                    map2.put(String.valueOf(i2), iTsmCallback);
                }
                return iAppDownloadApply;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        HashMap mapA = a(map);
        String str = (String) mapA.get(Constant.KEY_ACCOUNT_LIMIT);
        String str2 = (String) mapA.get(Constant.KEY_ACCOUNT_TYPE);
        String str3 = (String) mapA.get(Constant.KEY_CARD_HOLDER_NAME);
        String str4 = (String) mapA.get(Constant.KEY_ID_TYPE);
        String str5 = (String) mapA.get(Constant.KEY_ID_NO);
        String str6 = (String) mapA.get(Constant.KEY_PAN);
        String str7 = (String) mapA.get(Constant.KEY_PIN);
        String str8 = (String) mapA.get(Constant.KEY_EXPIRY_DATE);
        String str9 = (String) mapA.get(Constant.KEY_CVN2);
        String str10 = (String) mapA.get(Constant.KEY_PHONE_NUMBER);
        String str11 = (String) mapA.get(Constant.KEY_SMS_AUTH_CODE);
        String str12 = (String) mapA.get("cardType");
        if (!TextUtils.isEmpty(str)) {
            mapA.put(Constant.KEY_ACCOUNT_LIMIT, b(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            mapA.put(Constant.KEY_ACCOUNT_TYPE, b(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            mapA.put(Constant.KEY_CARD_HOLDER_NAME, b(str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            mapA.put(Constant.KEY_ID_TYPE, b(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
            mapA.put(Constant.KEY_ID_NO, b(str5));
        }
        if (!TextUtils.isEmpty(str6)) {
            mapA.put(Constant.KEY_PAN, b(str6));
        }
        if (!TextUtils.isEmpty(str7)) {
            mapA.put(Constant.KEY_PIN, str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            mapA.put(Constant.KEY_EXPIRY_DATE, b(str8));
        }
        if (!TextUtils.isEmpty(str9)) {
            mapA.put(Constant.KEY_CVN2, b(str9));
        }
        if (!TextUtils.isEmpty(str10)) {
            mapA.put(Constant.KEY_PHONE_NUMBER, b(str10));
        }
        if (!TextUtils.isEmpty(str11)) {
            mapA.put(Constant.KEY_SMS_AUTH_CODE, b(str11));
        }
        if (!TextUtils.isEmpty(str12)) {
            mapA.put("cardType", b(str12));
        }
        appDownloadApplyRequestParams2.setParams(mapA);
        try {
            int iAppDownloadApply2 = this.e.appDownloadApply(appDownloadApplyRequestParams2, new b(this, 15, this.Z[15], (byte) 0));
            if (-2 == iAppDownloadApply2) {
                return a(15, appDownloadApplyRequestParams, iTsmCallback);
            }
            if (iAppDownloadApply2 == 0) {
                HashMap map3 = this.p;
                int[] iArr2 = this.Z;
                int i3 = iArr2[15];
                iArr2[15] = i3 + 1;
                map3.put(String.valueOf(i3), iTsmCallback);
            }
            return iAppDownloadApply2;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RemoteException();
        }
        throw th;
    }

    @Deprecated
    public synchronized int appLock(AppLockRequestParams appLockRequestParams, ITsmCallback iTsmCallback) {
        if (appLockRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!a(this.c.getPackageName())) {
            return a(26, appLockRequestParams, iTsmCallback);
        }
        AppLockRequestParams appLockRequestParams2 = new AppLockRequestParams();
        String reserve = appLockRequestParams.getReserve();
        AppID appID = appLockRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            appLockRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                appLockRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        try {
            int iAppLock = this.e.appLock(appLockRequestParams2, iTsmCallback);
            if (-2 != iAppLock) {
                return iAppLock;
            }
            return a(26, appLockRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int appUnlock(AppUnlockRequestParams appUnlockRequestParams, ITsmCallback iTsmCallback) {
        if (appUnlockRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!a(this.c.getPackageName())) {
            return a(27, appUnlockRequestParams, iTsmCallback);
        }
        AppUnlockRequestParams appUnlockRequestParams2 = new AppUnlockRequestParams();
        String reserve = appUnlockRequestParams.getReserve();
        AppID appID = appUnlockRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            appUnlockRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                appUnlockRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        try {
            int iAppUnlock = this.e.appUnlock(appUnlockRequestParams2, iTsmCallback);
            if (-2 != iAppUnlock) {
                return iAppUnlock;
            }
            return a(27, appUnlockRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public boolean bind() {
        try {
            if (this.d == null) {
                this.d = new ServiceConnection() { // from class: com.unionpay.tsmservice.UPTsmAddon.2
                    @Override // android.content.ServiceConnection
                    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        UPTsmAddon.this.f = true;
                        UPTsmAddon.this.e = ITsmService.Stub.asInterface(iBinder);
                        UPTsmAddon.this.ab.sendEmptyMessage(0);
                    }

                    @Override // android.content.ServiceConnection
                    public final synchronized void onServiceDisconnected(ComponentName componentName) {
                        UPTsmAddon.this.f = false;
                        UPTsmAddon.this.e = null;
                        UPTsmAddon.this.ab.sendEmptyMessage(1);
                    }
                };
            }
            if (this.f) {
                return true;
            }
            Intent intent = new Intent("com.unionpay.tsmservice.UPTsmService");
            intent.setPackage("com.unionpay.tsmservice");
            return this.c.bindService(intent, this.d, 1);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public synchronized int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.14")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 35;
        if (!a(this.c.getPackageName())) {
            return a(35, cardListStatusChangedRequestParams, iTsmCallback);
        }
        CardListStatusChangedRequestParams cardListStatusChangedRequestParams2 = new CardListStatusChangedRequestParams();
        String reserve = cardListStatusChangedRequestParams != null ? cardListStatusChangedRequestParams.getReserve() : "";
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            cardListStatusChangedRequestParams2.setReserve(b(reserve));
        }
        this.M.put(String.valueOf(this.Z[35]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[35];
            iArr[35] = i2 + 1;
            int iCardListStatusChanged = iTsmService.cardListStatusChanged(cardListStatusChangedRequestParams2, new b(this, i, i2, (byte) 0));
            if (iCardListStatusChanged != 0) {
                HashMap map = this.M;
                int[] iArr2 = this.Z;
                int i3 = iArr2[35] - 1;
                iArr2[35] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == iCardListStatusChanged) {
                return a(35, cardListStatusChangedRequestParams, iTsmCallback);
            }
            return iCardListStatusChanged;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int checkSSamsungPay(CheckSSamsungPayRequestParams checkSSamsungPayRequestParams, ITsmCallback iTsmCallback) {
        if (checkSSamsungPayRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 29;
        if (!a(this.c.getPackageName())) {
            return a(29, checkSSamsungPayRequestParams, iTsmCallback);
        }
        CheckSSamsungPayRequestParams checkSSamsungPayRequestParams2 = new CheckSSamsungPayRequestParams();
        String reserve = checkSSamsungPayRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            checkSSamsungPayRequestParams2.setReserve(b(reserve));
        }
        this.J.put(String.valueOf(this.Z[29]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[29];
            iArr[29] = i2 + 1;
            int iCheckSSamsungPay = iTsmService.checkSSamsungPay(checkSSamsungPayRequestParams2, new b(this, i, i2, (byte) 0));
            if (iCheckSSamsungPay != 0) {
                HashMap map = this.J;
                int[] iArr2 = this.Z;
                int i3 = iArr2[29] - 1;
                iArr2[29] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iCheckSSamsungPay) {
                return iCheckSSamsungPay;
            }
            return a(29, checkSSamsungPayRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0069 A[Catch: all -> 0x0084, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x000b, B:13:0x0014, B:15:0x0018, B:17:0x0027, B:19:0x002f, B:21:0x003a, B:22:0x0042, B:24:0x0048, B:25:0x004f, B:33:0x0069, B:28:0x0057, B:29:0x005f, B:30:0x0060, B:39:0x0072, B:40:0x007a, B:41:0x007b), top: B:53:0x000b, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x006f A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x006f, please report this as an issue */
    public synchronized int clearEncryptData(int i) {
        int iClearEncryptData;
        if (i < 2000 || i > 2001) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!a(this.c.getPackageName())) {
            return a(33, (SafetyKeyboardRequestParams) null, i, (OnSafetyKeyboardCallback) null, (Context) null);
        }
        if (!d("01.00.24")) {
            try {
                iClearEncryptData = this.e.clearEncryptData(i);
                if (-2 == iClearEncryptData) {
                    return a(33, (SafetyKeyboardRequestParams) null, i, (OnSafetyKeyboardCallback) null, (Context) null);
                }
                return iClearEncryptData;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        ClearEncryptDataRequestParams clearEncryptDataRequestParams = new ClearEncryptDataRequestParams();
        String strG = this.h ? g(f("")) : "";
        if (!TextUtils.isEmpty(strG)) {
            clearEncryptDataRequestParams.setReserve(b(strG));
        }
        try {
            iClearEncryptData = this.e.clearKeyboardEncryptData(clearEncryptDataRequestParams, i);
            if (-2 == iClearEncryptData) {
                return a(33, (SafetyKeyboardRequestParams) null, i, (OnSafetyKeyboardCallback) null, (Context) null);
            }
            return iClearEncryptData;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int closeChannel(CloseChannelRequestParams closeChannelRequestParams, ITsmCallback iTsmCallback) {
        if (closeChannelRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String channel = closeChannelRequestParams.getChannel();
        if (TextUtils.isEmpty(channel)) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 21;
        if (!a(this.c.getPackageName())) {
            return a(21, closeChannelRequestParams, iTsmCallback);
        }
        String strB = b(channel);
        CloseChannelRequestParams closeChannelRequestParams2 = new CloseChannelRequestParams();
        closeChannelRequestParams2.setChannel(strB);
        String reserve = closeChannelRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            closeChannelRequestParams2.setReserve(b(reserve));
        }
        this.F.put(String.valueOf(this.Z[21]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[21];
            iArr[21] = i2 + 1;
            int iCloseChannel = iTsmService.closeChannel(closeChannelRequestParams2, new b(this, i, i2, (byte) 0));
            if (iCloseChannel != 0) {
                HashMap map = this.F;
                int[] iArr2 = this.Z;
                int i3 = iArr2[21] - 1;
                iArr2[21] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iCloseChannel) {
                return iCloseChannel;
            }
            return a(21, closeChannelRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int createSSD(UniteRequestParams uniteRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.38")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 46;
        if (!a(this.c.getPackageName())) {
            return a(46, uniteRequestParams, iTsmCallback);
        }
        UniteRequestParams uniteRequestParams2 = new UniteRequestParams();
        if (uniteRequestParams == null) {
            uniteRequestParams = new UniteRequestParams();
        }
        Bundle params = uniteRequestParams.getParams();
        if (params != null) {
            Bundle bundle = new Bundle();
            bundle.putString("encryptData", a(params));
            uniteRequestParams2.setParams(bundle);
        }
        String reserve = uniteRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            uniteRequestParams2.setReserve(b(reserve));
        }
        this.X.put(String.valueOf(this.Z[46]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[46];
            iArr[46] = i2 + 1;
            int iCreateSSD = iTsmService.createSSD(uniteRequestParams2, new b(this, i, i2, (byte) 0));
            if (iCreateSSD != 0) {
                HashMap map = this.X;
                int[] iArr2 = this.Z;
                int i3 = iArr2[46] - 1;
                iArr2[46] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iCreateSSD) {
                return iCreateSSD;
            }
            return a(46, uniteRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int eCashTopUp(ECashTopUpRequestParams eCashTopUpRequestParams, ITsmCallback iTsmCallback) {
        if (eCashTopUpRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 19;
        if (!a(this.c.getPackageName())) {
            return a(19, eCashTopUpRequestParams, iTsmCallback);
        }
        ECashTopUpRequestParams eCashTopUpRequestParams2 = new ECashTopUpRequestParams();
        String reserve = eCashTopUpRequestParams.getReserve();
        AppID appID = eCashTopUpRequestParams.getAppID();
        String type = eCashTopUpRequestParams.getType();
        String amount = eCashTopUpRequestParams.getAmount();
        if (!TextUtils.isEmpty(reserve)) {
            eCashTopUpRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                eCashTopUpRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        String encrpytPin = eCashTopUpRequestParams.getEncrpytPin();
        if (!TextUtils.isEmpty(encrpytPin)) {
            eCashTopUpRequestParams2.setEncrpytPin(encrpytPin);
        }
        if (!TextUtils.isEmpty(type)) {
            eCashTopUpRequestParams2.setType(b(type));
        }
        if (!TextUtils.isEmpty(amount)) {
            eCashTopUpRequestParams2.setAmount(b(amount));
        }
        try {
            int iECashTopUp = this.e.eCashTopUp(eCashTopUpRequestParams2, new b(this, i, this.Z[19], (byte) 0));
            if (-2 == iECashTopUp) {
                return a(19, eCashTopUpRequestParams, iTsmCallback);
            }
            if (iECashTopUp == 0) {
                HashMap map = this.s;
                int[] iArr = this.Z;
                int i2 = iArr[19];
                iArr[19] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return iECashTopUp;
        } catch (Exception e) {
            e.printStackTrace();
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
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 23;
        if (!a(this.c.getPackageName())) {
            return a(23, encryptDataRequestParams, iTsmCallback);
        }
        EncryptDataRequestParams encryptDataRequestParams2 = new EncryptDataRequestParams();
        String reserve = encryptDataRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            encryptDataRequestParams2.setReserve(b(reserve));
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
                    arrayList2.add(b(str));
                }
            }
            encryptDataRequestParams2.setData(arrayList2);
        }
        this.B.put(String.valueOf(this.Z[23]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i3 = iArr[23];
            iArr[23] = i3 + 1;
            int iEncryptData = iTsmService.encryptData(encryptDataRequestParams2, new b(this, i, i3, b2));
            if (iEncryptData != 0) {
                HashMap map = this.B;
                int[] iArr2 = this.Z;
                int i4 = iArr2[23] - 1;
                iArr2[23] = i4;
                map.remove(String.valueOf(i4));
            }
            if (-2 != iEncryptData) {
                return iEncryptData;
            }
            return a(23, encryptDataRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public int exchangeKey(String str, String[] strArr) throws RemoteException {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return -3;
        }
        if (!c()) {
            return -8;
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

    public synchronized int executeCmd(ExecuteCmdRequestParams executeCmdRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        if (executeCmdRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 25;
        if (!a(this.c.getPackageName())) {
            return a(25, executeCmdRequestParams, iTsmCallback, iTsmProgressCallback);
        }
        ExecuteCmdRequestParams executeCmdRequestParams2 = new ExecuteCmdRequestParams();
        String reserve = executeCmdRequestParams.getReserve();
        String ssid = executeCmdRequestParams.getSsid();
        String sign = executeCmdRequestParams.getSign();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            executeCmdRequestParams2.setReserve(b(reserve));
        }
        if (!TextUtils.isEmpty(ssid)) {
            executeCmdRequestParams2.setSsid(b(ssid));
        }
        if (!TextUtils.isEmpty(sign)) {
            executeCmdRequestParams2.setSign(b(sign));
        }
        this.H.put(String.valueOf(this.Z[25]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[25];
            iArr[25] = i2 + 1;
            int iExecuteCmd = iTsmService.executeCmd(executeCmdRequestParams2, new b(this, i, i2, (byte) 0), iTsmProgressCallback);
            if (iExecuteCmd != 0) {
                HashMap map = this.H;
                int[] iArr2 = this.Z;
                int i3 = iArr2[25] - 1;
                iArr2[25] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iExecuteCmd) {
                return iExecuteCmd;
            }
            return a(25, executeCmdRequestParams, iTsmCallback, iTsmProgressCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getAccountBalance(GetAccountBalanceRequestParams getAccountBalanceRequestParams, ITsmCallback iTsmCallback) {
        if (getAccountBalanceRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 8;
        if (!a(this.c.getPackageName())) {
            return a(8, getAccountBalanceRequestParams, iTsmCallback);
        }
        GetAccountBalanceRequestParams getAccountBalanceRequestParams2 = new GetAccountBalanceRequestParams();
        String reserve = getAccountBalanceRequestParams.getReserve();
        AppID appID = getAccountBalanceRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            getAccountBalanceRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                getAccountBalanceRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        String encryptPin = getAccountBalanceRequestParams.getEncryptPin();
        if (!TextUtils.isEmpty(encryptPin)) {
            getAccountBalanceRequestParams2.setEncryptPin(encryptPin);
        }
        try {
            int accountBalance = this.e.getAccountBalance(getAccountBalanceRequestParams2, new b(this, i, this.Z[8], (byte) 0));
            if (-2 == accountBalance) {
                return a(8, getAccountBalanceRequestParams, iTsmCallback);
            }
            if (accountBalance == 0) {
                HashMap map = this.v;
                int[] iArr = this.Z;
                int i2 = iArr[8];
                iArr[8] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return accountBalance;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getAccountInfo(GetAccountInfoRequestParams getAccountInfoRequestParams, ITsmCallback iTsmCallback) {
        if (getAccountInfoRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 7;
        if (!a(this.c.getPackageName())) {
            return a(7, getAccountInfoRequestParams, iTsmCallback);
        }
        GetAccountInfoRequestParams getAccountInfoRequestParams2 = new GetAccountInfoRequestParams();
        String reserve = getAccountInfoRequestParams.getReserve();
        AppID appID = getAccountInfoRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            getAccountInfoRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                getAccountInfoRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        try {
            int accountInfo = this.e.getAccountInfo(getAccountInfoRequestParams2, new b(this, i, this.Z[7], (byte) 0));
            if (-2 == accountInfo) {
                return a(7, getAccountInfoRequestParams, iTsmCallback);
            }
            if (accountInfo == 0) {
                HashMap map = this.u;
                int[] iArr = this.Z;
                int i2 = iArr[7];
                iArr[7] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return accountInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getAppDetail(GetAppDetailRequestParams getAppDetailRequestParams, ITsmCallback iTsmCallback) {
        if (getAppDetailRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 4;
        if (!a(this.c.getPackageName())) {
            return a(4, getAppDetailRequestParams, iTsmCallback);
        }
        GetAppDetailRequestParams getAppDetailRequestParams2 = new GetAppDetailRequestParams();
        String reserve = getAppDetailRequestParams.getReserve();
        AppID appID = getAppDetailRequestParams.getAppID();
        String transType = getAppDetailRequestParams.getTransType();
        if (!TextUtils.isEmpty(reserve)) {
            getAppDetailRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                getAppDetailRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        if (!TextUtils.isEmpty(transType)) {
            getAppDetailRequestParams2.setTransType(b(transType));
        }
        try {
            int appDetail = this.e.getAppDetail(getAppDetailRequestParams2, new b(this, i, this.Z[4], (byte) 0));
            if (-2 == appDetail) {
                return a(4, getAppDetailRequestParams, iTsmCallback);
            }
            if (appDetail == 0) {
                HashMap map = this.n;
                int[] iArr = this.Z;
                int i2 = iArr[4];
                iArr[4] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return appDetail;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getAppList(GetAppListRequestParams getAppListRequestParams, ITsmCallback iTsmCallback) {
        if (getAppListRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 2;
        if (!a(this.c.getPackageName())) {
            return a(2, getAppListRequestParams, iTsmCallback);
        }
        GetAppListRequestParams getAppListRequestParams2 = new GetAppListRequestParams();
        String reserve = getAppListRequestParams.getReserve();
        String keyword = getAppListRequestParams.getKeyword();
        String[] status = getAppListRequestParams.getStatus();
        if (!TextUtils.isEmpty(reserve)) {
            getAppListRequestParams2.setReserve(b(reserve));
        }
        if (!TextUtils.isEmpty(keyword)) {
            getAppListRequestParams2.setKeyword(b(keyword));
        }
        byte b2 = 0;
        if (status != null) {
            int length = status.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                if (!TextUtils.isEmpty(status[i2])) {
                    strArr[i2] = b(status[i2]);
                }
            }
            getAppListRequestParams2.setStatus(strArr);
        }
        try {
            int appList = this.e.getAppList(getAppListRequestParams2, new b(this, i, this.Z[2], b2));
            if (-2 == appList) {
                return a(2, getAppListRequestParams, iTsmCallback);
            }
            if (appList == 0) {
                HashMap map = this.l;
                int[] iArr = this.Z;
                int i3 = iArr[2];
                iArr[2] = i3 + 1;
                map.put(String.valueOf(i3), iTsmCallback);
            }
            return appList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getAppStatus(GetAppStatusRequestParams getAppStatusRequestParams, ITsmCallback iTsmCallback) {
        if (getAppStatusRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 5;
        if (!a(this.c.getPackageName())) {
            return a(5, getAppStatusRequestParams, iTsmCallback);
        }
        GetAppStatusRequestParams getAppStatusRequestParams2 = new GetAppStatusRequestParams();
        String reserve = getAppStatusRequestParams.getReserve();
        AppID appID = getAppStatusRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            getAppStatusRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                getAppStatusRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        try {
            int appStatus = this.e.getAppStatus(getAppStatusRequestParams2, new b(this, i, this.Z[5], (byte) 0));
            if (-2 == appStatus) {
                return a(5, getAppStatusRequestParams, iTsmCallback);
            }
            if (appStatus == 0) {
                HashMap map = this.m;
                int[] iArr = this.Z;
                int i2 = iArr[5];
                iArr[5] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return appStatus;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getAssociatedApp(GetAssociatedAppRequestParams getAssociatedAppRequestParams, ITsmCallback iTsmCallback) {
        if (getAssociatedAppRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String encryptPan = getAssociatedAppRequestParams.getEncryptPan();
        if (TextUtils.isEmpty(encryptPan)) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 1;
        if (!a(this.c.getPackageName())) {
            return a(1, getAssociatedAppRequestParams, iTsmCallback);
        }
        GetAssociatedAppRequestParams getAssociatedAppRequestParams2 = new GetAssociatedAppRequestParams();
        String reserve = getAssociatedAppRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            getAssociatedAppRequestParams2.setReserve(b(reserve));
        }
        getAssociatedAppRequestParams2.setEncryptPan(b(encryptPan));
        try {
            int associatedApp = this.e.getAssociatedApp(getAssociatedAppRequestParams2, new b(this, i, this.Z[1], (byte) 0));
            if (-2 == associatedApp) {
                return a(1, getAssociatedAppRequestParams, iTsmCallback);
            }
            if (associatedApp == 0) {
                HashMap map = this.j;
                int[] iArr = this.Z;
                int i2 = iArr[1];
                iArr[1] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return associatedApp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getCardInfo(GetCardInfoRequestParams getCardInfoRequestParams, ITsmCallback iTsmCallback) {
        if (getCardInfoRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String[] appAID = getCardInfoRequestParams.getAppAID();
        int length = appAID.length;
        if (appAID != null && length != 0) {
            byte b2 = 0;
            int i = 0;
            while (i < length && appAID[i] == null) {
                i++;
            }
            if (i == length) {
                return -3;
            }
            if (!c()) {
                return -8;
            }
            if (this.e == null) {
                return -1;
            }
            int i2 = 6;
            if (!a(this.c.getPackageName())) {
                return a(6, getCardInfoRequestParams, iTsmCallback);
            }
            String[] strArr = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                String str = appAID[i3];
                if (str == null) {
                    strArr[i3] = str;
                } else {
                    strArr[i3] = b(str);
                }
            }
            GetCardInfoRequestParams getCardInfoRequestParams2 = new GetCardInfoRequestParams();
            getCardInfoRequestParams2.setAppAID(strArr);
            String reserve = getCardInfoRequestParams.getReserve();
            if (this.h) {
                reserve = g(f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                getCardInfoRequestParams2.setReserve(b(reserve));
            }
            try {
                int cardInfo = this.e.getCardInfo(getCardInfoRequestParams2, new b(this, i2, this.Z[6], b2));
                if (-2 == cardInfo) {
                    return a(6, getCardInfoRequestParams, iTsmCallback);
                }
                if (cardInfo == 0) {
                    HashMap map = this.A;
                    int[] iArr = this.Z;
                    int i4 = iArr[6];
                    iArr[6] = i4 + 1;
                    map.put(String.valueOf(i4), iTsmCallback);
                }
                return cardInfo;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        return -3;
    }

    public synchronized int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams, ITsmCallback iTsmCallback) {
        if (getCardInfoBySpayRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 28;
        if (!a(this.c.getPackageName())) {
            return a(28, getCardInfoBySpayRequestParams, iTsmCallback);
        }
        GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams2 = new GetCardInfoBySpayRequestParams();
        String reserve = getCardInfoBySpayRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            getCardInfoBySpayRequestParams2.setReserve(b(reserve));
        }
        Amount amount = getCardInfoBySpayRequestParams.getAmount();
        if (amount != null) {
            String currencyType = amount.getCurrencyType();
            String productPrice = amount.getProductPrice();
            Amount amount2 = new Amount();
            if (!TextUtils.isEmpty(currencyType)) {
                amount2.setCurrencyType(b(currencyType));
            }
            if (!TextUtils.isEmpty(productPrice)) {
                amount2.setProductPrice(b(productPrice));
            }
            getCardInfoBySpayRequestParams2.setAmount(amount2);
        }
        this.I.put(String.valueOf(this.Z[28]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[28];
            iArr[28] = i2 + 1;
            int cardInfoBySamsungPay = iTsmService.getCardInfoBySamsungPay(getCardInfoBySpayRequestParams2, new b(this, i, i2, (byte) 0));
            if (cardInfoBySamsungPay != 0) {
                HashMap map = this.I;
                int[] iArr2 = this.Z;
                int i3 = iArr2[28] - 1;
                iArr2[28] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != cardInfoBySamsungPay) {
                return cardInfoBySamsungPay;
            }
            return a(28, getCardInfoBySpayRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public Context getContext() {
        return this.c;
    }

    public int getCryptType() {
        return this.g;
    }

    @Deprecated
    public synchronized int getDefaultCard(GetDefaultCardRequestParams getDefaultCardRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 13;
        if (!a(this.c.getPackageName())) {
            return a(13, getDefaultCardRequestParams, iTsmCallback);
        }
        GetDefaultCardRequestParams getDefaultCardRequestParams2 = new GetDefaultCardRequestParams();
        if (getDefaultCardRequestParams != null) {
            String reserve = getDefaultCardRequestParams.getReserve();
            if (!TextUtils.isEmpty(reserve)) {
                getDefaultCardRequestParams2.setReserve(b(reserve));
            }
        }
        try {
            int defaultCard = this.e.getDefaultCard(getDefaultCardRequestParams2, new b(this, i, this.Z[13], (byte) 0));
            if (-2 == defaultCard) {
                return a(13, getDefaultCardRequestParams, iTsmCallback);
            }
            if (defaultCard == 0) {
                HashMap map = this.y;
                int[] iArr = this.Z;
                int i2 = iArr[13];
                iArr[13] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return defaultCard;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
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
            if (!c()) {
                return -8;
            }
            if (this.e == null) {
                return -1;
            }
            int i = 31;
            if (!a(this.c.getPackageName())) {
                return a(31, getEncryptDataRequestParams, iTsmCallback);
            }
            GetEncryptDataRequestParams getEncryptDataRequestParams2 = new GetEncryptDataRequestParams();
            if (type == 2000) {
                getEncryptDataRequestParams2.setPan(b(pan));
            }
            getEncryptDataRequestParams2.setType(type);
            String reserve = getEncryptDataRequestParams.getReserve();
            if (this.h) {
                reserve = g(f(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                getEncryptDataRequestParams2.setReserve(b(reserve));
            }
            this.L.put(String.valueOf(this.Z[31]), iTsmCallback);
            try {
                ITsmService iTsmService = this.e;
                int[] iArr = this.Z;
                int i2 = iArr[31];
                iArr[31] = i2 + 1;
                int encryptData = iTsmService.getEncryptData(getEncryptDataRequestParams2, new b(this, i, i2, (byte) 0));
                if (encryptData != 0) {
                    HashMap map = this.L;
                    int[] iArr2 = this.Z;
                    int i3 = iArr2[31] - 1;
                    iArr2[31] = i3;
                    map.remove(String.valueOf(i3));
                }
                if (-2 != encryptData) {
                    return encryptData;
                }
                return a(31, getEncryptDataRequestParams, iTsmCallback);
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
        if (!d("01.00.35")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 44;
        if (!a(this.c.getPackageName())) {
            return a(44, getMessageDetailsRequestParams, iTsmCallback);
        }
        GetMessageDetailsRequestParams getMessageDetailsRequestParams2 = new GetMessageDetailsRequestParams();
        String strG = "";
        if (getMessageDetailsRequestParams != null) {
            strG = getMessageDetailsRequestParams.getReserve();
            Bundle params = getMessageDetailsRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                getMessageDetailsRequestParams2.setParams(bundle);
            }
        }
        if (this.h) {
            strG = g(f(strG));
        }
        if (!TextUtils.isEmpty(strG)) {
            getMessageDetailsRequestParams2.setReserve(b(strG));
        }
        this.V.put(String.valueOf(this.Z[44]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[44];
            iArr[44] = i2 + 1;
            int messageDetails = iTsmService.getMessageDetails(getMessageDetailsRequestParams2, new b(this, i, i2, (byte) 0));
            if (messageDetails != 0) {
                HashMap map = this.V;
                int[] iArr2 = this.Z;
                int i3 = iArr2[44] - 1;
                iArr2[44] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != messageDetails) {
                return messageDetails;
            }
            return a(44, getMessageDetailsRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public int getPubKey(int i, String[] strArr) throws RemoteException {
        if (strArr == null || strArr.length == 0) {
            return -3;
        }
        if (!c()) {
            return -8;
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

    @Deprecated
    public synchronized int getSEAppList(GetSeAppListRequestParams getSeAppListRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 3;
        if (!a(this.c.getPackageName())) {
            return a(3, getSeAppListRequestParams, iTsmCallback);
        }
        GetSeAppListRequestParams getSeAppListRequestParams2 = new GetSeAppListRequestParams();
        String reserve = getSeAppListRequestParams != null ? getSeAppListRequestParams.getReserve() : "";
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            getSeAppListRequestParams2.setReserve(b(reserve));
        }
        this.k.put(String.valueOf(this.Z[3]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[3];
            iArr[3] = i2 + 1;
            int sEAppList = iTsmService.getSEAppList(getSeAppListRequestParams2, new b(this, i, i2, (byte) 0));
            if (sEAppList != 0) {
                HashMap map = this.k;
                int[] iArr2 = this.Z;
                int i3 = iArr2[3] - 1;
                iArr2[3] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == sEAppList) {
                return a(3, getSeAppListRequestParams, iTsmCallback);
            }
            return sEAppList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getSMSAuthCode(GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams, ITsmCallback iTsmCallback) {
        if (getSMSAuthCodeRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 11;
        if (!a(this.c.getPackageName())) {
            return a(11, getSMSAuthCodeRequestParams, iTsmCallback);
        }
        GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams2 = new GetSMSAuthCodeRequestParams();
        String reserve = getSMSAuthCodeRequestParams.getReserve();
        AppID appID = getSMSAuthCodeRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            getSMSAuthCodeRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                getSMSAuthCodeRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        String pan = getSMSAuthCodeRequestParams.getPan();
        String msisdn = getSMSAuthCodeRequestParams.getMsisdn();
        if (!TextUtils.isEmpty(pan)) {
            getSMSAuthCodeRequestParams2.setPan(b(pan));
        }
        if (!TextUtils.isEmpty(msisdn)) {
            getSMSAuthCodeRequestParams2.setMsisdn(b(msisdn));
        }
        try {
            int sMSAuthCode = this.e.getSMSAuthCode(getSMSAuthCodeRequestParams2, new b(this, i, this.Z[11], (byte) 0));
            if (-2 == sMSAuthCode) {
                return a(11, getSMSAuthCodeRequestParams, iTsmCallback);
            }
            if (sMSAuthCode == 0) {
                HashMap map = this.r;
                int[] iArr = this.Z;
                int i2 = iArr[11];
                iArr[11] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return sMSAuthCode;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getSeId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 12;
        if (!a(this.c.getPackageName())) {
            return a(12, getSeIdRequestParams, iTsmCallback);
        }
        GetSeIdRequestParams getSeIdRequestParams2 = new GetSeIdRequestParams();
        String reserve = getSeIdRequestParams != null ? getSeIdRequestParams.getReserve() : "";
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            getSeIdRequestParams2.setReserve(b(reserve));
        }
        this.z.put(String.valueOf(this.Z[12]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[12];
            iArr[12] = i2 + 1;
            int sEId = iTsmService.getSEId(getSeIdRequestParams2, new b(this, i, i2, (byte) 0));
            if (sEId != 0) {
                HashMap map = this.z;
                int[] iArr2 = this.Z;
                int i3 = iArr2[12] - 1;
                iArr2[12] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == sEId) {
                return a(12, getSeIdRequestParams, iTsmCallback);
            }
            return sEId;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getTransElements(GetTransElementsRequestParams getTransElementsRequestParams, ITsmCallback iTsmCallback) {
        if (getTransElementsRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 9;
        if (!a(this.c.getPackageName())) {
            return a(9, getTransElementsRequestParams, iTsmCallback);
        }
        GetTransElementsRequestParams getTransElementsRequestParams2 = new GetTransElementsRequestParams();
        String reserve = getTransElementsRequestParams.getReserve();
        AppID appID = getTransElementsRequestParams.getAppID();
        String transType = getTransElementsRequestParams.getTransType();
        if (!TextUtils.isEmpty(reserve)) {
            getTransElementsRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                getTransElementsRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        if (!TextUtils.isEmpty(transType)) {
            getTransElementsRequestParams2.setTransType(b(transType));
        }
        try {
            int transElements = this.e.getTransElements(getTransElementsRequestParams2, new b(this, i, this.Z[9], (byte) 0));
            if (-2 == transElements) {
                return a(9, getTransElementsRequestParams, iTsmCallback);
            }
            if (transElements == 0) {
                HashMap map = this.o;
                int[] iArr = this.Z;
                int i2 = iArr[9];
                iArr[9] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return transElements;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int getTransRecord(GetTransRecordRequestParams getTransRecordRequestParams, ITsmCallback iTsmCallback) {
        if (getTransRecordRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 10;
        if (!a(this.c.getPackageName())) {
            return a(10, getTransRecordRequestParams, iTsmCallback);
        }
        GetTransRecordRequestParams getTransRecordRequestParams2 = new GetTransRecordRequestParams();
        String reserve = getTransRecordRequestParams.getReserve();
        AppID appID = getTransRecordRequestParams.getAppID();
        if (!TextUtils.isEmpty(reserve)) {
            getTransRecordRequestParams2.setReserve(b(reserve));
        }
        if (appID != null) {
            String appAid = appID.getAppAid();
            String appVersion = appID.getAppVersion();
            if (!TextUtils.isEmpty(appAid) && !TextUtils.isEmpty(appVersion)) {
                getTransRecordRequestParams2.setAppID(new AppID(b(appAid), b(appVersion)));
            }
        }
        try {
            int transRecord = this.e.getTransRecord(getTransRecordRequestParams2, new b(this, i, this.Z[10], (byte) 0));
            if (-2 == transRecord) {
                return a(10, getTransRecordRequestParams, iTsmCallback);
            }
            if (transRecord == 0) {
                HashMap map = this.t;
                int[] iArr = this.Z;
                int i2 = iArr[10];
                iArr[10] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return transRecord;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.35")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 43;
        if (!a(this.c.getPackageName())) {
            return a(43, getTransactionDetailsRequestParams, iTsmCallback);
        }
        GetTransactionDetailsRequestParams getTransactionDetailsRequestParams2 = new GetTransactionDetailsRequestParams();
        String strG = "";
        if (getTransactionDetailsRequestParams != null) {
            strG = getTransactionDetailsRequestParams.getReserve();
            Bundle params = getTransactionDetailsRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                getTransactionDetailsRequestParams2.setParams(bundle);
            }
        }
        if (this.h) {
            strG = g(f(strG));
        }
        if (!TextUtils.isEmpty(strG)) {
            getTransactionDetailsRequestParams2.setReserve(b(strG));
        }
        this.U.put(String.valueOf(this.Z[43]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[43];
            iArr[43] = i2 + 1;
            int transactionDetails = iTsmService.getTransactionDetails(getTransactionDetailsRequestParams2, new b(this, i, i2, (byte) 0));
            if (transactionDetails != 0) {
                HashMap map = this.U;
                int[] iArr2 = this.Z;
                int i3 = iArr2[43] - 1;
                iArr2[43] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != transactionDetails) {
                return transactionDetails;
            }
            return a(43, getTransactionDetailsRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.20")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 36;
        if (!a(this.c.getPackageName())) {
            return a(36, getVendorPayStatusRequestParams, iTsmCallback);
        }
        GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = new GetVendorPayStatusRequestParams();
        String reserve = getVendorPayStatusRequestParams != null ? getVendorPayStatusRequestParams.getReserve() : "";
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            getVendorPayStatusRequestParams2.setReserve(b(reserve));
        }
        this.N.put(String.valueOf(this.Z[36]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[36];
            iArr[36] = i2 + 1;
            int vendorPayStatus = iTsmService.getVendorPayStatus(getVendorPayStatusRequestParams2, new b(this, i, i2, (byte) 0));
            if (vendorPayStatus != 0) {
                HashMap map = this.N;
                int[] iArr2 = this.Z;
                int i3 = iArr2[36] - 1;
                iArr2[36] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == vendorPayStatus) {
                return a(36, getVendorPayStatusRequestParams, iTsmCallback);
            }
            return vendorPayStatus;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int hideAppApply(HideAppApplyRequestParams hideAppApplyRequestParams, ITsmCallback iTsmCallback) {
        if (hideAppApplyRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String applyId = hideAppApplyRequestParams.getApplyId();
        if (TextUtils.isEmpty(applyId)) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 24;
        if (!a(this.c.getPackageName())) {
            return a(24, hideAppApplyRequestParams, iTsmCallback);
        }
        String strB = b(applyId);
        HideAppApplyRequestParams hideAppApplyRequestParams2 = new HideAppApplyRequestParams();
        hideAppApplyRequestParams2.setApplyId(strB);
        String reserve = hideAppApplyRequestParams.getReserve();
        if (!TextUtils.isEmpty(reserve)) {
            hideAppApplyRequestParams2.setReserve(b(reserve));
        }
        try {
            int iHideAppApply = this.e.hideAppApply(hideAppApplyRequestParams2, new b(this, i, this.Z[24], (byte) 0));
            if (-2 == iHideAppApply) {
                return a(24, hideAppApplyRequestParams, iTsmCallback);
            }
            if (iHideAppApply == 0) {
                HashMap map = this.G;
                int[] iArr = this.Z;
                int i2 = iArr[24];
                iArr[24] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return iHideAppApply;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0060 A[Catch: all -> 0x007b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x000e, B:12:0x001e, B:14:0x0026, B:16:0x0031, B:17:0x0039, B:19:0x003f, B:20:0x0046, B:28:0x0060, B:23:0x004e, B:24:0x0056, B:25:0x0057, B:34:0x0069, B:35:0x0071, B:36:0x0072), top: B:49:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0066 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x0066, please report this as an issue */
    public synchronized int hideKeyboard() {
        int iHideKeyboard;
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!a(this.c.getPackageName())) {
            return a(34, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
        }
        if (!d("01.00.24")) {
            try {
                iHideKeyboard = this.e.hideKeyboard();
                if (-2 == iHideKeyboard) {
                    return a(34, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
                }
                return iHideKeyboard;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        }
        HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams = new HideSafetyKeyboardRequestParams();
        String strG = this.h ? g(f("")) : "";
        if (!TextUtils.isEmpty(strG)) {
            hideSafetyKeyboardRequestParams.setReserve(b(strG));
        }
        try {
            iHideKeyboard = this.e.hideSafetyKeyboard(hideSafetyKeyboardRequestParams);
            if (-2 == iHideKeyboard) {
                return a(34, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
            }
            return iHideKeyboard;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        byte b2 = 0;
        if (!a(this.c.getPackageName())) {
            return a(0, initRequestParams, iTsmCallback);
        }
        InitRequestParams initRequestParams2 = new InitRequestParams();
        String strG = "";
        if (initRequestParams != null) {
            strG = initRequestParams.getReserve();
            String signature = initRequestParams.getSignature();
            if (!TextUtils.isEmpty(signature)) {
                initRequestParams2.setSignature(b(signature));
            }
        }
        if (this.h) {
            strG = g(f(strG));
        }
        if (!TextUtils.isEmpty(strG)) {
            initRequestParams2.setReserve(b(strG));
        }
        this.i.put(String.valueOf(this.Z[0]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i = iArr[0];
            iArr[0] = i + 1;
            int iInit = iTsmService.init(initRequestParams2, new b(this, b2, i, b2));
            if (iInit != 0) {
                HashMap map = this.i;
                int[] iArr2 = this.Z;
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
        if (!d("01.00.21")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 39;
        if (!a(this.c.getPackageName())) {
            return a(39, onlinePaymentVerifyRequestParams, iTsmCallback);
        }
        OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams2 = new OnlinePaymentVerifyRequestParams();
        Bundle resource = onlinePaymentVerifyRequestParams.getResource();
        if (resource != null) {
            Bundle bundle = new Bundle();
            bundle.putString("encryptData", a(resource));
            onlinePaymentVerifyRequestParams2.setResource(bundle);
        }
        String orderNumber = onlinePaymentVerifyRequestParams.getOrderNumber();
        String aId = onlinePaymentVerifyRequestParams.getAId();
        if (!TextUtils.isEmpty(orderNumber)) {
            onlinePaymentVerifyRequestParams2.setOrderNumber(b(orderNumber));
        }
        if (!TextUtils.isEmpty(aId)) {
            onlinePaymentVerifyRequestParams2.setAId(b(aId));
        }
        String reserve = onlinePaymentVerifyRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            onlinePaymentVerifyRequestParams2.setReserve(b(reserve));
        }
        this.Q.put(String.valueOf(this.Z[39]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[39];
            iArr[39] = i2 + 1;
            int iOnlinePaymentVerify = iTsmService.onlinePaymentVerify(onlinePaymentVerifyRequestParams2, new b(this, i, i2, (byte) 0));
            if (iOnlinePaymentVerify != 0) {
                HashMap map = this.Q;
                int[] iArr2 = this.Z;
                int i3 = iArr2[39] - 1;
                iArr2[39] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iOnlinePaymentVerify) {
                return iOnlinePaymentVerify;
            }
            return a(39, onlinePaymentVerifyRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int openChannel(OpenChannelRequestParams openChannelRequestParams, ITsmCallback iTsmCallback) {
        if (openChannelRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String appAID = openChannelRequestParams.getAppAID();
        if (TextUtils.isEmpty(appAID)) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 20;
        if (!a(this.c.getPackageName())) {
            return a(20, openChannelRequestParams, iTsmCallback);
        }
        String strB = b(appAID);
        OpenChannelRequestParams openChannelRequestParams2 = new OpenChannelRequestParams();
        openChannelRequestParams2.setAppAID(strB);
        String reserve = openChannelRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            openChannelRequestParams2.setReserve(b(reserve));
        }
        this.w.put(String.valueOf(this.Z[20]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[20];
            iArr[20] = i2 + 1;
            int iOpenChannel = iTsmService.openChannel(openChannelRequestParams2, new b(this, i, i2, (byte) 0));
            if (iOpenChannel != 0) {
                HashMap map = this.w;
                int[] iArr2 = this.Z;
                int i3 = iArr2[20] - 1;
                iArr2[20] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iOpenChannel) {
                return iOpenChannel;
            }
            return a(20, openChannelRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int preDownload(PreDownloadRequestParams preDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.26")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 40;
        if (!a(this.c.getPackageName())) {
            return a(40, preDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
        }
        PreDownloadRequestParams preDownloadRequestParams2 = new PreDownloadRequestParams();
        String strG = "";
        if (preDownloadRequestParams != null) {
            strG = preDownloadRequestParams.getReserve();
            Bundle params = preDownloadRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                preDownloadRequestParams2.setParams(bundle);
            }
        }
        if (this.h) {
            strG = g(f(strG));
        }
        if (!TextUtils.isEmpty(strG)) {
            preDownloadRequestParams2.setReserve(b(strG));
        }
        this.R.put(String.valueOf(this.Z[40]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[40];
            iArr[40] = i2 + 1;
            int iPreDownload = iTsmService.preDownload(preDownloadRequestParams2, new b(this, i, i2, (byte) 0), iTsmProgressCallback);
            if (iPreDownload != 0) {
                HashMap map = this.R;
                int[] iArr2 = this.Z;
                int i3 = iArr2[40] - 1;
                iArr2[40] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iPreDownload) {
                return iPreDownload;
            }
            return a(40, preDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.27")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 41;
        if (!a(this.c.getPackageName())) {
            return a(41, queryVendorPayStatusRequestParams, iTsmCallback);
        }
        QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams2 = new QueryVendorPayStatusRequestParams();
        String reserve = queryVendorPayStatusRequestParams != null ? queryVendorPayStatusRequestParams.getReserve() : "";
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            queryVendorPayStatusRequestParams2.setReserve(b(reserve));
        }
        this.S.put(String.valueOf(this.Z[41]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[41];
            iArr[41] = i2 + 1;
            int iQueryVendorPayStatus = iTsmService.queryVendorPayStatus(queryVendorPayStatusRequestParams2, new b(this, i, i2, (byte) 0));
            if (iQueryVendorPayStatus != 0) {
                HashMap map = this.S;
                int[] iArr2 = this.Z;
                int i3 = iArr2[41] - 1;
                iArr2[41] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 == iQueryVendorPayStatus) {
                return a(41, queryVendorPayStatusRequestParams, iTsmCallback);
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

    public synchronized int sendApdu(SendApduRequestParams sendApduRequestParams, ITsmCallback iTsmCallback) {
        if (sendApduRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 22;
        if (!a(this.c.getPackageName())) {
            return a(22, sendApduRequestParams, iTsmCallback);
        }
        SendApduRequestParams sendApduRequestParams2 = new SendApduRequestParams();
        String reserve = sendApduRequestParams.getReserve();
        String channel = sendApduRequestParams.getChannel();
        String hexApdu = sendApduRequestParams.getHexApdu();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            sendApduRequestParams2.setReserve(b(reserve));
        }
        if (!TextUtils.isEmpty(channel)) {
            sendApduRequestParams2.setChannel(b(channel));
        }
        if (!TextUtils.isEmpty(hexApdu)) {
            sendApduRequestParams2.setHexApdu(b(hexApdu));
        }
        this.x.put(String.valueOf(this.Z[22]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[22];
            iArr[22] = i2 + 1;
            int iSendApdu = iTsmService.sendApdu(sendApduRequestParams2, new b(this, i, i2, (byte) 0));
            if (iSendApdu != 0) {
                HashMap map = this.x;
                int[] iArr2 = this.Z;
                int i3 = iArr2[22] - 1;
                iArr2[22] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iSendApdu) {
                return iSendApdu;
            }
            return a(22, sendApduRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int sendCustomData(SendCustomDataRequestParams sendCustomDataRequestParams, ITsmCallback iTsmCallback) {
        if (sendCustomDataRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (!d("01.00.37")) {
            return -8;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 45;
        if (!a(this.c.getPackageName())) {
            return a(45, sendCustomDataRequestParams, iTsmCallback);
        }
        SendCustomDataRequestParams sendCustomDataRequestParams2 = new SendCustomDataRequestParams();
        Bundle params = sendCustomDataRequestParams.getParams();
        if (params != null) {
            Bundle bundle = new Bundle();
            bundle.putString("encryptData", a(params));
            sendCustomDataRequestParams2.setParams(bundle);
        }
        String reserve = sendCustomDataRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            sendCustomDataRequestParams2.setReserve(b(reserve));
        }
        this.W.put(String.valueOf(this.Z[45]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[45];
            iArr[45] = i2 + 1;
            int iSendCustomData = iTsmService.sendCustomData(sendCustomDataRequestParams2, new b(this, i, i2, (byte) 0));
            if (iSendCustomData != 0) {
                HashMap map = this.W;
                int[] iArr2 = this.Z;
                int i3 = iArr2[45] - 1;
                iArr2[45] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != iSendCustomData) {
                return iSendCustomData;
            }
            return a(45, sendCustomDataRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    @Deprecated
    public synchronized int setDefaultCard(SetDefaultCardRequestParams setDefaultCardRequestParams, ITsmCallback iTsmCallback) {
        if (setDefaultCardRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        String appAID = setDefaultCardRequestParams.getAppAID();
        if (TextUtils.isEmpty(appAID)) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 14;
        if (!a(this.c.getPackageName())) {
            return a(14, setDefaultCardRequestParams, iTsmCallback);
        }
        String strB = b(appAID);
        SetDefaultCardRequestParams setDefaultCardRequestParams2 = new SetDefaultCardRequestParams();
        setDefaultCardRequestParams2.setAppAID(strB);
        String reserve = setDefaultCardRequestParams.getReserve();
        if (!TextUtils.isEmpty(reserve)) {
            setDefaultCardRequestParams2.setReserve(b(reserve));
        }
        try {
            int defaultCard = this.e.setDefaultCard(setDefaultCardRequestParams2, new b(this, i, this.Z[14], (byte) 0));
            if (-2 == defaultCard) {
                return a(14, setDefaultCardRequestParams, iTsmCallback);
            }
            if (defaultCard == 0) {
                HashMap map = this.E;
                int[] iArr = this.Z;
                int i2 = iArr[14];
                iArr[14] = i2 + 1;
                map.put(String.valueOf(i2), iTsmCallback);
            }
            return defaultCard;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) {
        if (safetyKeyboardRequestParams == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!a(this.c.getPackageName())) {
            return a(32, safetyKeyboardRequestParams, null);
        }
        String reserve = safetyKeyboardRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            safetyKeyboardRequestParams.setReserve(b(reserve));
        }
        try {
            int safetyKeyboardBitmap = this.e.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            if (-2 != safetyKeyboardBitmap) {
                return safetyKeyboardBitmap;
            }
            return a(32, safetyKeyboardRequestParams, null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        int i = 30;
        if (!a(this.c.getPackageName())) {
            return a(30, setSamsungDefWalletRequestParams, iTsmCallback);
        }
        SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams2 = new SetSamsungDefWalletRequestParams();
        if (setSamsungDefWalletRequestParams != null) {
            String reserve = setSamsungDefWalletRequestParams.getReserve();
            if (!TextUtils.isEmpty(reserve)) {
                setSamsungDefWalletRequestParams2.setReserve(b(reserve));
            }
        }
        this.K.put(String.valueOf(this.Z[30]), iTsmCallback);
        try {
            ITsmService iTsmService = this.e;
            int[] iArr = this.Z;
            int i2 = iArr[30];
            iArr[30] = i2 + 1;
            int samsungDefaultWallet = iTsmService.setSamsungDefaultWallet(setSamsungDefWalletRequestParams2, new b(this, i, i2, (byte) 0));
            if (samsungDefaultWallet != 0) {
                HashMap map = this.K;
                int[] iArr2 = this.Z;
                int i3 = iArr2[30] - 1;
                iArr2[30] = i3;
                map.remove(String.valueOf(i3));
            }
            if (-2 != samsungDefaultWallet) {
                return samsungDefaultWallet;
            }
            return a(30, setSamsungDefWalletRequestParams, iTsmCallback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        if (safetyKeyboardRequestParams == null || i < 2000 || i > 2001) {
            return -3;
        }
        if (!c()) {
            return -8;
        }
        if (this.e == null) {
            return -1;
        }
        if (!a(this.c.getPackageName())) {
            return a(1000, safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, context);
        }
        this.Y.put(this.c.getPackageName(), new com.unionpay.tsmservice.a(context));
        String reserve = safetyKeyboardRequestParams.getReserve();
        if (this.h) {
            reserve = g(f(reserve));
        }
        if (!TextUtils.isEmpty(reserve)) {
            safetyKeyboardRequestParams.setReserve(b(reserve));
        }
        try {
            int iShowSafetyKeyboard = this.e.showSafetyKeyboard(safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, new a());
            if (iShowSafetyKeyboard != 0) {
                this.Y.remove(this.c.getPackageName());
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
