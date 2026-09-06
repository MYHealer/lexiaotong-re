package com.hihonor.cloudservice.android.mms.ppskit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IPPSChannelInfoService extends IInterface {

    public static class Default implements IPPSChannelInfoService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService
        public String getChannelInfo(int i) throws RemoteException {
            return null;
        }

        @Override // com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService
        public String getChannelInfoByPkgName(String str) throws RemoteException {
            return null;
        }

        @Override // com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService
        public int setChannelInfo(String str, String str2, String str3) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IPPSChannelInfoService {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService";
        static final int TRANSACTION_getChannelInfo = 2;
        static final int TRANSACTION_getChannelInfoByPkgName = 3;
        static final int TRANSACTION_setChannelInfo = 1;

        private static class Proxy implements IPPSChannelInfoService {
            public static IPPSChannelInfoService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService
            public String getChannelInfo(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getChannelInfo(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService
            public String getChannelInfoByPkgName(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getChannelInfoByPkgName(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.hihonor.cloudservice.android.mms.ppskit.IPPSChannelInfoService
            public int setChannelInfo(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setChannelInfo(str, str2, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPPSChannelInfoService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPPSChannelInfoService)) ? new Proxy(iBinder) : (IPPSChannelInfoService) iInterfaceQueryLocalInterface;
        }

        public static IPPSChannelInfoService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPPSChannelInfoService iPPSChannelInfoService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPPSChannelInfoService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPPSChannelInfoService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int channelInfo = setChannelInfo(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(channelInfo);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String channelInfo2 = getChannelInfo(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(channelInfo2);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String channelInfoByPkgName = getChannelInfoByPkgName(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(channelInfoByPkgName);
            return true;
        }
    }

    String getChannelInfo(int i) throws RemoteException;

    String getChannelInfoByPkgName(String str) throws RemoteException;

    int setChannelInfo(String str, String str2, String str3) throws RemoteException;
}
