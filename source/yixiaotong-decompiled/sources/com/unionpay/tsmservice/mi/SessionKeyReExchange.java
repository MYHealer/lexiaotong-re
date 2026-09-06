package com.unionpay.tsmservice.mi;

import android.content.Context;
import android.os.RemoteException;
import com.unionpay.tsmservice.mi.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.mi.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.mi.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.mi.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.mi.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.InitRequestParams;
import com.unionpay.tsmservice.mi.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.mi.request.PayResultNotifyRequestParams;
import com.unionpay.tsmservice.mi.request.PinRequestRequestParams;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.RequestParams;
import com.unionpay.tsmservice.mi.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.mi.utils.IUPJniInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class SessionKeyReExchange {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UPTsmAddon f9354a;
    private int b;
    private RequestParams c;
    private ITsmCallback d;
    private ITsmProgressCallback e;
    private int f;
    private OnSafetyKeyboardCallback g;
    private Context h;
    private int i;

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, null, iTsmCallback);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, int i2) {
        this.f9354a = uPTsmAddon;
        this.b = i;
        this.c = requestParams;
        this.d = iTsmCallback;
        this.f = i2;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, iTsmProgressCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback, int i2) {
        this.f9354a = uPTsmAddon;
        this.b = i;
        this.c = requestParams;
        this.d = iTsmCallback;
        this.e = iTsmProgressCallback;
        this.f = i2;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        this.f = 1000;
        this.f9354a = uPTsmAddon;
        this.b = i;
        this.i = i2;
        this.c = safetyKeyboardRequestParams;
        this.g = onSafetyKeyboardCallback;
        this.h = context;
    }

    public int reExchangeKey() throws RemoteException {
        String[] strArr = new String[1];
        int pubKey = this.f9354a.getPubKey(1000, strArr);
        if (pubKey != 0) {
            return pubKey;
        }
        int iExchangeKey = this.f9354a.exchangeKey(IUPJniInterface.rER(strArr[0], IUPJniInterface.mSK()), strArr);
        if (iExchangeKey != 0) {
            return iExchangeKey;
        }
        String strDMG = IUPJniInterface.dMG(strArr[0]);
        IUPJniInterface.sSK(strDMG);
        Context context = this.f9354a.getContext();
        if (context != null) {
            IUPJniInterface.uSKT(context.getPackageName(), strDMG);
        }
        int i = this.b;
        if (i == 1000) {
            return this.f9354a.showSafetyKeyboard((SafetyKeyboardRequestParams) this.c, this.i, this.g, this.h);
        }
        switch (i) {
            case 0:
                return this.f9354a.init((InitRequestParams) this.c, this.d);
            case 1:
                return this.f9354a.encryptData((EncryptDataRequestParams) this.c, this.d);
            case 2:
                return this.f9354a.getEncryptData((GetEncryptDataRequestParams) this.c, this.d);
            case 3:
                return this.f9354a.setSafetyKeyboardBitmap((SafetyKeyboardRequestParams) this.c);
            case 4:
                return this.f9354a.clearEncryptData(this.i);
            case 5:
                return this.f9354a.hideKeyboard();
            case 6:
                return this.f9354a.acquireSEAppList((AcquireSEAppListRequestParams) this.c, this.d);
            case 7:
                return this.f9354a.cardListStatusChanged((CardListStatusChangedRequestParams) this.c, this.d);
            case 8:
                return this.f9354a.queryVendorPayStatus((QueryVendorPayStatusRequestParams) this.c, this.d);
            case 9:
                return this.f9354a.getVendorPayStatus((GetVendorPayStatusRequestParams) this.c, this.d);
            case 10:
                return this.f9354a.onlinePaymentVerify((OnlinePaymentVerifyRequestParams) this.c, this.d);
            case 11:
                return this.f9354a.pinRequest((PinRequestRequestParams) this.c, this.d);
            case 12:
                return this.f9354a.payResultNotify((PayResultNotifyRequestParams) this.c, this.d);
            case 13:
                return this.f9354a.cancelPay();
            case 14:
                return this.f9354a.getVendorPayStatusForBankApp((GetVendorPayStatusRequestParams) this.c, this.d);
            case 15:
                return this.f9354a.getSeId((GetSeIdRequestParams) this.c, this.d);
            case 16:
                return this.f9354a.addCardToVendorPay((AddCardToVendorPayRequestParams) this.c, this.d, this.e);
            case 17:
                return this.f9354a.getTransactionDetails((GetTransactionDetailsRequestParams) this.c, this.d);
            case 18:
                return this.f9354a.getMessageDetails((GetMessageDetailsRequestParams) this.c, this.d);
            default:
                return 0;
        }
    }
}
