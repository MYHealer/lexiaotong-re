package com.xiaomi.market;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public interface IAppDownloadManager extends IInterface {

    public static class Default implements IAppDownloadManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public boolean cancel(String str, String str2) {
            return false;
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void download(Bundle bundle) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void downloadByUri(Uri uri) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void downloadByUriV2(Uri uri, String str) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void launchDirectPostPage(Uri uri, String str) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void lifecycleChanged(String str, int i) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public boolean pause(String str, String str2) {
            return false;
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void pauseByUri(Uri uri) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void pauseByUriV2(Uri uri, String str) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public boolean resume(String str, String str2) {
            return false;
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void resumeByUri(Uri uri) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void resumeByUriV2(Uri uri, String str) {
        }

        @Override // com.xiaomi.market.IAppDownloadManager
        public void trackMarketSdkEvent(Bundle bundle) {
        }
    }

    public static abstract class Stub extends Binder implements IAppDownloadManager {
        private static final String DESCRIPTOR = s.d(new byte[]{1, 10, 85, 26, Ascii.GS, 15, 0, 11, 11, 11, Ascii.US, 8, 3, Ascii.ETB, 83, 81, 17, 72, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, Ascii.NAK, 11, 84, 91, 4, 2, 44, 5, 8, 3, 86, 0, 16}, "be84ef");
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_download = 1;
        public static final int TRANSACTION_downloadByUri = 5;
        public static final int TRANSACTION_downloadByUriV2 = 9;
        public static final int TRANSACTION_launchDirectPostPage = 12;
        public static final int TRANSACTION_lifecycleChanged = 8;
        public static final int TRANSACTION_pause = 3;
        public static final int TRANSACTION_pauseByUri = 6;
        public static final int TRANSACTION_pauseByUriV2 = 10;
        public static final int TRANSACTION_resume = 4;
        public static final int TRANSACTION_resumeByUri = 7;
        public static final int TRANSACTION_resumeByUriV2 = 11;
        public static final int TRANSACTION_trackMarketSdkEvent = 13;

        public static class Proxy implements IAppDownloadManager {
            public static IAppDownloadManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public boolean cancel(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{5, 13, 89, Ascii.FS, Ascii.GS, 10, 0, 11, 11, 11, Ascii.US, 8, 7, 16, 95, 87, 17, 77, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 17, 12, 88, 93, 4, 7, 44, 5, 8, 3, 86, 0, Ascii.DC4}, "fb42ec"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancel(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void download(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{80, 87, 9, Ascii.ETB, 74, 90, 0, 11, 11, 11, Ascii.US, 8, 82, 74, 15, 92, 70, Ascii.GS, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 68, 86, 8, 86, 83, 87, 44, 5, 8, 3, 86, 0, 65}, "38d923"));
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().download(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void downloadByUri(Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 88, 84, 74, Ascii.EM, 80, 0, 11, 11, 11, Ascii.US, 8, 86, 69, 82, 1, Ascii.NAK, Ascii.ETB, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, SignedBytes.MAX_POWER_OF_TWO, 89, 85, 11, 0, 93, 44, 5, 8, 3, 86, 0, 69}, "779da9"));
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().downloadByUri(uri);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void downloadByUriV2(Uri uri, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{0, 86, 85, Ascii.EM, 72, 88, 0, 11, 11, 11, Ascii.US, 8, 2, 75, 83, 82, 68, Ascii.US, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, Ascii.DC4, 87, 84, 88, 81, 85, 44, 5, 8, 3, 86, 0, 17}, "c98701"));
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().downloadByUriV2(uri, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{81, 90, 11, 76, Ascii.ESC, 93, 0, 11, 11, 11, Ascii.US, 8, 83, 71, 13, 7, Ascii.ETB, 26, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 69, 91, 10, 13, 2, 80, 44, 5, 8, 3, 86, 0, SignedBytes.MAX_POWER_OF_TWO}, "25fbc4");
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void launchDirectPostPage(Uri uri, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{86, 89, 11, Ascii.RS, SignedBytes.MAX_POWER_OF_TWO, 12, 0, 11, 11, 11, Ascii.US, 8, 84, 68, 13, 85, 76, 75, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 66, 88, 10, 95, 89, 1, 44, 5, 8, 3, 86, 0, 71}, "56f08e"));
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().launchDirectPostPage(uri, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void lifecycleChanged(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{90, 91, 93, Ascii.ETB, 79, 15, 0, 11, 11, 11, Ascii.US, 8, 88, 70, 91, 92, 67, 72, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 78, 90, 92, 86, 86, 2, 44, 5, 8, 3, 86, 0, 75}, "94097f"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().lifecycleChanged(str, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public boolean pause(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{6, 11, 11, Ascii.US, Ascii.GS, 91, 0, 11, 11, 11, Ascii.US, 8, 4, Ascii.SYN, 13, 84, 17, Ascii.FS, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, Ascii.DC2, 10, 10, 94, 4, 86, 44, 5, 8, 3, 86, 0, Ascii.ETB}, "edf1e2"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().pause(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void pauseByUri(Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{0, 13, 95, Ascii.RS, 74, 15, 0, 11, 11, 11, Ascii.US, 8, 2, 16, 89, 85, 70, 72, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, Ascii.DC4, 12, 94, 95, 83, 2, 44, 5, 8, 3, 86, 0, 17}, "cb202f"));
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseByUri(uri);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void pauseByUriV2(Uri uri, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{81, 13, 15, Ascii.EM, 72, 89, 0, 11, 11, 11, Ascii.US, 8, 83, 16, 9, 82, 68, Ascii.RS, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 69, 12, 14, 88, 81, 84, 44, 5, 8, 3, 86, 0, SignedBytes.MAX_POWER_OF_TWO}, "2bb700"));
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseByUriV2(uri, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public boolean resume(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{6, 95, 95, Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 93, 0, 11, 11, 11, Ascii.US, 8, 4, 66, 89, 86, 76, 26, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, Ascii.DC2, 94, 94, 92, 89, 80, 44, 5, 8, 3, 86, 0, Ascii.ETB}, "e02384"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().resume(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void resumeByUri(Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{83, 11, 11, Ascii.ESC, 72, 94, 0, 11, 11, 11, Ascii.US, 8, 81, Ascii.SYN, 13, 80, 68, Ascii.EM, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 71, 10, 10, 90, 81, 83, 44, 5, 8, 3, 86, 0, 66}, "0df507"));
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resumeByUri(uri);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void resumeByUriV2(Uri uri, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{90, 12, 95, Ascii.EM, SignedBytes.MAX_POWER_OF_TWO, 89, 0, 11, 11, 11, Ascii.US, 8, 88, 17, 89, 82, 76, Ascii.RS, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 78, 13, 94, 88, 89, 84, 44, 5, 8, 3, 86, 0, 75}, "9c2780"));
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resumeByUriV2(uri, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.market.IAppDownloadManager
            public void trackMarketSdkEvent(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{87, 14, 94, 75, Ascii.ESC, 80, 0, 11, 11, 11, Ascii.US, 8, 85, 19, 88, 0, Ascii.ETB, Ascii.ETB, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 67, 15, 95, 10, 2, 93, 44, 5, 8, 3, 86, 0, 70}, "4a3ec9"));
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().trackMarketSdkEvent(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{5, 12, 14, 72, 76, 10, 0, 11, 11, 11, Ascii.US, 8, 7, 17, 8, 3, SignedBytes.MAX_POWER_OF_TWO, 77, 40, 37, Ascii.SYN, Ascii.DC2, 117, 10, 17, 13, 15, 9, 85, 7, 44, 5, 8, 3, 86, 0, Ascii.DC4}, "fccf4c"));
        }

        public static IAppDownloadManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAppDownloadManager)) ? new Proxy(iBinder) : (IAppDownloadManager) iInterfaceQueryLocalInterface;
        }

        public static IAppDownloadManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAppDownloadManager iAppDownloadManager) {
            if (Proxy.sDefaultImpl != null || iAppDownloadManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAppDownloadManager;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = DESCRIPTOR;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(str);
                    download(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    boolean zCancel = cancel(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancel ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    boolean zPause = pause(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPause ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    boolean zResume = resume(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zResume ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    downloadByUri(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    pauseByUri(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(str);
                    resumeByUri(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(str);
                    lifecycleChanged(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(str);
                    downloadByUriV2(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(str);
                    pauseByUriV2(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(str);
                    resumeByUriV2(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(str);
                    launchDirectPostPage(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(str);
                    trackMarketSdkEvent(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean cancel(String str, String str2);

    void download(Bundle bundle);

    void downloadByUri(Uri uri);

    void downloadByUriV2(Uri uri, String str);

    void launchDirectPostPage(Uri uri, String str);

    void lifecycleChanged(String str, int i);

    boolean pause(String str, String str2);

    void pauseByUri(Uri uri);

    void pauseByUriV2(Uri uri, String str);

    boolean resume(String str, String str2);

    void resumeByUri(Uri uri);

    void resumeByUriV2(Uri uri, String str);

    void trackMarketSdkEvent(Bundle bundle);
}
