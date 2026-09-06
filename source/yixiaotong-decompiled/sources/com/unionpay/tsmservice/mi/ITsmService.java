package com.unionpay.tsmservice.mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
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
import com.unionpay.tsmservice.mi.request.SafetyKeyboardRequestParams;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface ITsmService extends IInterface {

    public abstract class Stub extends Binder implements ITsmService {

        final class a implements ITsmService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9352a;

            a(IBinder iBinder) {
                this.f9352a = iBinder;
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (acquireSEAppListRequestParams != null) {
                        parcelObtain.writeInt(1);
                        acquireSEAppListRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (addCardToVendorPayRequestParams != null) {
                        parcelObtain.writeInt(1);
                        addCardToVendorPayRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    parcelObtain.writeStrongBinder(iTsmProgressCallback != null ? iTsmProgressCallback.asBinder() : null);
                    this.f9352a.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9352a;
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int cancelPay(CancelPayRequestParams cancelPayRequestParams) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (cancelPayRequestParams != null) {
                        parcelObtain.writeInt(1);
                        cancelPayRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f9352a.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (cardListStatusChangedRequestParams != null) {
                        parcelObtain.writeInt(1);
                        cardListStatusChangedRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int clearEncryptData(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    parcelObtain.writeInt(i);
                    this.f9352a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int clearKeyboardEncryptData(ClearEncryptDataRequestParams clearEncryptDataRequestParams, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (clearEncryptDataRequestParams != null) {
                        parcelObtain.writeInt(1);
                        clearEncryptDataRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    this.f9352a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (encryptDataRequestParams != null) {
                        parcelObtain.writeInt(1);
                        encryptDataRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int exchangeKey(String str, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    parcelObtain.writeString(str);
                    if (strArr == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(strArr.length);
                    }
                    this.f9352a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i = parcelObtain2.readInt();
                    parcelObtain2.readStringArray(strArr);
                    return i;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getEncryptDataRequestParams != null) {
                        parcelObtain.writeInt(1);
                        getEncryptDataRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getMessageDetailsRequestParams != null) {
                        parcelObtain.writeInt(1);
                        getMessageDetailsRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getPubKey(int i, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    parcelObtain.writeInt(i);
                    if (strArr == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(strArr.length);
                    }
                    this.f9352a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i2 = parcelObtain2.readInt();
                    parcelObtain2.readStringArray(strArr);
                    return i2;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getSEId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getSeIdRequestParams != null) {
                        parcelObtain.writeInt(1);
                        getSeIdRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getTransactionDetailsRequestParams != null) {
                        parcelObtain.writeInt(1);
                        getTransactionDetailsRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getVendorPayStatusRequestParams != null) {
                        parcelObtain.writeInt(1);
                        getVendorPayStatusRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getVendorPayStatusForBankApp(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getVendorPayStatusRequestParams != null) {
                        parcelObtain.writeInt(1);
                        getVendorPayStatusRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int hideKeyboard() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    this.f9352a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int hideSafetyKeyboard(HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (hideSafetyKeyboardRequestParams != null) {
                        parcelObtain.writeInt(1);
                        hideSafetyKeyboardRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f9352a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (initRequestParams != null) {
                        parcelObtain.writeInt(1);
                        initRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (onlinePaymentVerifyRequestParams != null) {
                        parcelObtain.writeInt(1);
                        onlinePaymentVerifyRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int payResultNotify(PayResultNotifyRequestParams payResultNotifyRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (payResultNotifyRequestParams != null) {
                        parcelObtain.writeInt(1);
                        payResultNotifyRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int pinRequest(PinRequestRequestParams pinRequestRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (pinRequestRequestParams != null) {
                        parcelObtain.writeInt(1);
                        pinRequestRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (queryVendorPayStatusRequestParams != null) {
                        parcelObtain.writeInt(1);
                        queryVendorPayStatusRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f9352a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (safetyKeyboardRequestParams != null) {
                        parcelObtain.writeInt(1);
                        safetyKeyboardRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f9352a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (safetyKeyboardRequestParams != null) {
                        parcelObtain.writeInt(1);
                        safetyKeyboardRequestParams.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(onSafetyKeyboardCallback != null ? onSafetyKeyboardCallback.asBinder() : null);
                    parcelObtain.writeStrongBinder(iTsmActivityCallback != null ? iTsmActivityCallback.asBinder() : null);
                    this.f9352a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.ITsmService");
        }

        public static ITsmService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.ITsmService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITsmService)) ? new a(iBinder) : (ITsmService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.unionpay.tsmservice.mi.ITsmService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iInit = init(parcel.readInt() != 0 ? (InitRequestParams) InitRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iInit);
                    return true;
                case 2:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int i3 = parcel.readInt();
                    int i4 = parcel.readInt();
                    String[] strArr = i4 >= 0 ? new String[i4] : null;
                    int pubKey = getPubKey(i3, strArr);
                    parcel2.writeNoException();
                    parcel2.writeInt(pubKey);
                    parcel2.writeStringArray(strArr);
                    return true;
                case 3:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    String string = parcel.readString();
                    int i5 = parcel.readInt();
                    String[] strArr2 = i5 >= 0 ? new String[i5] : null;
                    int iExchangeKey = exchangeKey(string, strArr2);
                    parcel2.writeNoException();
                    parcel2.writeInt(iExchangeKey);
                    parcel2.writeStringArray(strArr2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iEncryptData = encryptData(parcel.readInt() != 0 ? (EncryptDataRequestParams) EncryptDataRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iEncryptData);
                    return true;
                case 5:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iShowSafetyKeyboard = showSafetyKeyboard(parcel.readInt() != 0 ? (SafetyKeyboardRequestParams) SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), OnSafetyKeyboardCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmActivityCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iShowSafetyKeyboard);
                    return true;
                case 6:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int safetyKeyboardBitmap = setSafetyKeyboardBitmap(parcel.readInt() != 0 ? (SafetyKeyboardRequestParams) SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(safetyKeyboardBitmap);
                    return true;
                case 7:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int encryptData = getEncryptData(parcel.readInt() != 0 ? (GetEncryptDataRequestParams) GetEncryptDataRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(encryptData);
                    return true;
                case 8:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iClearEncryptData = clearEncryptData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iClearEncryptData);
                    return true;
                case 9:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iHideKeyboard = hideKeyboard();
                    parcel2.writeNoException();
                    parcel2.writeInt(iHideKeyboard);
                    return true;
                case 10:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iClearKeyboardEncryptData = clearKeyboardEncryptData(parcel.readInt() != 0 ? (ClearEncryptDataRequestParams) ClearEncryptDataRequestParams.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iClearKeyboardEncryptData);
                    return true;
                case 11:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iHideSafetyKeyboard = hideSafetyKeyboard(parcel.readInt() != 0 ? (HideSafetyKeyboardRequestParams) HideSafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(iHideSafetyKeyboard);
                    return true;
                case 12:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iAcquireSEAppList = acquireSEAppList(parcel.readInt() != 0 ? (AcquireSEAppListRequestParams) AcquireSEAppListRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iAcquireSEAppList);
                    return true;
                case 13:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iCardListStatusChanged = cardListStatusChanged(parcel.readInt() != 0 ? (CardListStatusChangedRequestParams) CardListStatusChangedRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iCardListStatusChanged);
                    return true;
                case 14:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iQueryVendorPayStatus = queryVendorPayStatus(parcel.readInt() != 0 ? (QueryVendorPayStatusRequestParams) QueryVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iQueryVendorPayStatus);
                    return true;
                case 15:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int vendorPayStatus = getVendorPayStatus(parcel.readInt() != 0 ? (GetVendorPayStatusRequestParams) GetVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(vendorPayStatus);
                    return true;
                case 16:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iOnlinePaymentVerify = onlinePaymentVerify(parcel.readInt() != 0 ? (OnlinePaymentVerifyRequestParams) OnlinePaymentVerifyRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iOnlinePaymentVerify);
                    return true;
                case 17:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iPinRequest = pinRequest(parcel.readInt() != 0 ? (PinRequestRequestParams) PinRequestRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iPinRequest);
                    return true;
                case 18:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iCancelPay = cancelPay(parcel.readInt() != 0 ? (CancelPayRequestParams) CancelPayRequestParams.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(iCancelPay);
                    return true;
                case 19:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iPayResultNotify = payResultNotify(parcel.readInt() != 0 ? (PayResultNotifyRequestParams) PayResultNotifyRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iPayResultNotify);
                    return true;
                case 20:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int vendorPayStatusForBankApp = getVendorPayStatusForBankApp(parcel.readInt() != 0 ? (GetVendorPayStatusRequestParams) GetVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(vendorPayStatusForBankApp);
                    return true;
                case 21:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int sEId = getSEId(parcel.readInt() != 0 ? (GetSeIdRequestParams) GetSeIdRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(sEId);
                    return true;
                case 22:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int iAddCardToVendorPay = addCardToVendorPay(parcel.readInt() != 0 ? (AddCardToVendorPayRequestParams) AddCardToVendorPayRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iAddCardToVendorPay);
                    return true;
                case 23:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int transactionDetails = getTransactionDetails(parcel.readInt() != 0 ? (GetTransactionDetailsRequestParams) GetTransactionDetailsRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(transactionDetails);
                    return true;
                case 24:
                    parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                    int messageDetails = getMessageDetails(parcel.readInt() != 0 ? (GetMessageDetailsRequestParams) GetMessageDetailsRequestParams.CREATOR.createFromParcel(parcel) : null, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(messageDetails);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback);

    int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback);

    int cancelPay(CancelPayRequestParams cancelPayRequestParams);

    int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback);

    int clearEncryptData(int i);

    int clearKeyboardEncryptData(ClearEncryptDataRequestParams clearEncryptDataRequestParams, int i);

    int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback);

    int exchangeKey(String str, String[] strArr);

    int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback);

    int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback);

    int getPubKey(int i, String[] strArr);

    int getSEId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback);

    int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback);

    int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback);

    int getVendorPayStatusForBankApp(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback);

    int hideKeyboard();

    int hideSafetyKeyboard(HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams);

    int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback);

    int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback);

    int payResultNotify(PayResultNotifyRequestParams payResultNotifyRequestParams, ITsmCallback iTsmCallback);

    int pinRequest(PinRequestRequestParams pinRequestRequestParams, ITsmCallback iTsmCallback);

    int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback);

    int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams);

    int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback);
}
