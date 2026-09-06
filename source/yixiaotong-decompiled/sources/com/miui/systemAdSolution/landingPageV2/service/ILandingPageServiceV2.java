package com.miui.systemAdSolution.landingPageV2.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener;
import com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener;
import com.miui.systemAdSolution.landingPageV2.listener.IInstallListener;
import com.miui.zeus.mimo.sdk.a;
import ijiami_1011.s.s.s;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ILandingPageServiceV2 extends IInterface {

    public static class Default implements ILandingPageServiceV2 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean cancelDeeplink(String str, String str2) {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean cancelDownload(String str) {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public void cancelTask(String str) {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean downloadViaMarket(IDownloadListener iDownloadListener, String str, String str2) {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean downloadViaMsa(IDownloadListener iDownloadListener, String str, String str2, String str3, int i, String str4) {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public void executeTask(List<a> list, IActionTaskResultListener iActionTaskResultListener) {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public long getNativeDownloadId(String str) {
            return 0L;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public int getPackageDownloadStatus(String str) {
            return 0;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public int getServiceVersion() {
            return 0;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public int getServiceVersionCode() {
            return 0;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean handleDeeplinkViaMsa(String str, String str2, String str3) {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean handleDeeplinkViaMsa2(int i, String str, String str2, String str3) {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean installSilently(String str, String str2, IInstallListener iInstallListener) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ILandingPageServiceV2 {
        private static final String DESCRIPTOR = s.d(new byte[]{83, 90, 9, 76, 14, 11, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 68, 80, 9, 35, 7, 49, 14, 8, 19, Ascii.SYN, 88, 10, 94, Ascii.ESC, 8, 3, 13, 6, 8, 10, 1, 50, 80, 2, 85, 99, 86, 76, 16, 7, 19, Ascii.DC2, 15, 1, 84, 75, 121, 121, 5, 12, 7, 11, 15, 3, 54, 3, 86, 0, 99, 80, Ascii.SYN, Ascii.DC4, 10, 1, 4, 50, 84}, "05dbcb");
        public static final int TRANSACTION_cancelDeeplink = 11;
        public static final int TRANSACTION_cancelDownload = 9;
        public static final int TRANSACTION_cancelTask = 3;
        public static final int TRANSACTION_downloadViaMarket = 10;
        public static final int TRANSACTION_downloadViaMsa = 8;
        public static final int TRANSACTION_executeTask = 2;
        public static final int TRANSACTION_getNativeDownloadId = 5;
        public static final int TRANSACTION_getPackageDownloadStatus = 4;
        public static final int TRANSACTION_getServiceVersion = 1;
        public static final int TRANSACTION_getServiceVersionCode = 13;
        public static final int TRANSACTION_handleDeeplinkViaMsa = 7;
        public static final int TRANSACTION_handleDeeplinkViaMsa2 = 12;
        public static final int TRANSACTION_installSilently = 6;

        public static class Proxy implements ILandingPageServiceV2 {
            public static ILandingPageServiceV2 sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean cancelDeeplink(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{90, 91, 8, Ascii.FS, 90, 93, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 77, 81, 8, 115, 83, 103, 14, 8, 19, Ascii.SYN, 88, 10, 87, 26, 9, 83, 89, 80, 8, 10, 1, 50, 80, 2, 92, 98, 87, Ascii.FS, 68, 81, 19, Ascii.DC2, 15, 1, 84, 75, 112, 120, 4, 92, 83, 93, 15, 3, 54, 3, 86, 0, 106, 81, Ascii.ETB, 68, 94, 87, 4, 50, 84}, "94e274"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancelDeeplink(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean cancelDownload(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{87, 86, 8, Ascii.FS, 9, 10, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 92, 8, 115, 0, 48, 14, 8, 19, Ascii.SYN, 88, 10, 90, Ascii.ETB, 9, 83, 10, 7, 8, 10, 1, 50, 80, 2, 81, 111, 87, Ascii.FS, Ascii.ETB, 6, 19, Ascii.DC2, 15, 1, 84, 75, 125, 117, 4, 92, 0, 10, 15, 3, 54, 3, 86, 0, 103, 92, Ascii.ETB, 68, 13, 0, 4, 50, 84}, "49e2dc"));
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancelDownload(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public void cancelTask(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{85, 92, 84, Ascii.SYN, 91, 95, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 66, 86, 84, 121, 82, 101, 14, 8, 19, Ascii.SYN, 88, 10, 88, Ascii.GS, 85, 89, 88, 82, 8, 10, 1, 50, 80, 2, 83, 101, 11, Ascii.SYN, 69, 83, 19, Ascii.DC2, 15, 1, 84, 75, 127, 127, 88, 86, 82, 95, 15, 3, 54, 3, 86, 0, 101, 86, 75, 78, 95, 85, 4, 50, 84}, "639866"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelTask(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean downloadViaMarket(IDownloadListener iDownloadListener, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{81, 11, 8, 74, 89, 81, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 70, 1, 8, 37, 80, 107, 14, 8, 19, Ascii.SYN, 88, 10, 92, 74, 9, 5, 90, 92, 8, 10, 1, 50, 80, 2, 87, 50, 87, 74, 71, 93, 19, Ascii.DC2, 15, 1, 84, 75, 123, 40, 4, 10, 80, 81, 15, 3, 54, 3, 86, 0, 97, 1, Ascii.ETB, Ascii.DC2, 93, 91, 4, 50, 84}, "2ded48"));
                    parcelObtain.writeStrongBinder(iDownloadListener != null ? iDownloadListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().downloadViaMarket(iDownloadListener, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean downloadViaMsa(IDownloadListener iDownloadListener, String str, String str2, String str3, int i, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{87, 89, 90, Ascii.FS, 84, 8, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 83, 90, 115, 93, 50, 14, 8, 19, Ascii.SYN, 88, 10, 90, Ascii.CAN, 91, 83, 87, 5, 8, 10, 1, 50, 80, 2, 81, 96, 5, Ascii.FS, 74, 4, 19, Ascii.DC2, 15, 1, 84, 75, 125, 122, 86, 92, 93, 8, 15, 3, 54, 3, 86, 0, 103, 83, 69, 68, 80, 2, 4, 50, 84}, "46729a"));
                    parcelObtain.writeStrongBinder(iDownloadListener != null ? iDownloadListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str4);
                    try {
                        if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zDownloadViaMsa = Stub.getDefaultImpl().downloadViaMsa(iDownloadListener, str, str2, str3, i, str4);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zDownloadViaMsa;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public void executeTask(List<a> list, IActionTaskResultListener iActionTaskResultListener) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{0, 89, 93, 26, 9, 89, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.ETB, 83, 93, 117, 0, 99, 14, 8, 19, Ascii.SYN, 88, 10, 13, Ascii.CAN, 92, 85, 10, 84, 8, 10, 1, 50, 80, 2, 6, 96, 2, 26, Ascii.ETB, 85, 19, Ascii.DC2, 15, 1, 84, 75, 42, 122, 81, 90, 0, 89, 15, 3, 54, 3, 86, 0, 48, 83, 66, 66, 13, 83, 4, 50, 84}, "c604d0"));
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iActionTaskResultListener != null ? iActionTaskResultListener.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().executeTask(list, iActionTaskResultListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{87, 12, 8, Ascii.FS, 91, 88, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 6, 8, 115, 82, 98, 14, 8, 19, Ascii.SYN, 88, 10, 90, 77, 9, 83, 88, 85, 8, 10, 1, 50, 80, 2, 81, 53, 87, Ascii.FS, 69, 84, 19, Ascii.DC2, 15, 1, 84, 75, 125, 47, 4, 92, 82, 88, 15, 3, 54, 3, 86, 0, 103, 6, Ascii.ETB, 68, 95, 82, 4, 50, 84}, "4ce261");
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public long getNativeDownloadId(String str) {
                long nativeDownloadId;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{81, 91, 93, Ascii.ETB, 85, 88, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 70, 81, 93, 120, 92, 98, 14, 8, 19, Ascii.SYN, 88, 10, 92, 26, 92, 88, 86, 85, 8, 10, 1, 50, 80, 2, 87, 98, 2, Ascii.ETB, 75, 84, 19, Ascii.DC2, 15, 1, 84, 75, 123, 120, 81, 87, 92, 88, 15, 3, 54, 3, 86, 0, 97, 81, 66, 79, 81, 82, 4, 50, 84}, "240981"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        nativeDownloadId = parcelObtain2.readLong();
                    } else {
                        nativeDownloadId = Stub.getDefaultImpl().getNativeDownloadId(str);
                    }
                    return nativeDownloadId;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public int getPackageDownloadStatus(String str) {
                int packageDownloadStatus;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{91, 93, 88, Ascii.US, 84, 91, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 76, 87, 88, 112, 93, 97, 14, 8, 19, Ascii.SYN, 88, 10, 86, Ascii.FS, 89, 80, 87, 86, 8, 10, 1, 50, 80, 2, 93, 100, 7, Ascii.US, 74, 87, 19, Ascii.DC2, 15, 1, 84, 75, 113, 126, 84, 95, 93, 91, 15, 3, 54, 3, 86, 0, 107, 87, 71, 71, 80, 81, 4, 50, 84}, "825192"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        packageDownloadStatus = parcelObtain2.readInt();
                    } else {
                        packageDownloadStatus = Stub.getDefaultImpl().getPackageDownloadStatus(str);
                    }
                    return packageDownloadStatus;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public int getServiceVersion() {
                int serviceVersion;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{90, 89, 91, 72, 14, 80, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 77, 83, 91, 39, 7, 106, 14, 8, 19, Ascii.SYN, 88, 10, 87, Ascii.CAN, 90, 7, 13, 93, 8, 10, 1, 50, 80, 2, 92, 96, 4, 72, 16, 92, 19, Ascii.DC2, 15, 1, 84, 75, 112, 122, 87, 8, 7, 80, 15, 3, 54, 3, 86, 0, 106, 83, 68, 16, 10, 90, 4, 50, 84}, "966fc9"));
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        serviceVersion = parcelObtain2.readInt();
                    } else {
                        serviceVersion = Stub.getDefaultImpl().getServiceVersion();
                    }
                    return serviceVersion;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public int getServiceVersionCode() {
                int serviceVersionCode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{87, 13, 88, 26, 85, 13, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 7, 88, 117, 92, 55, 14, 8, 19, Ascii.SYN, 88, 10, 90, 76, 89, 85, 86, 0, 8, 10, 1, 50, 80, 2, 81, 52, 7, 26, 75, 1, 19, Ascii.DC2, 15, 1, 84, 75, 125, 46, 84, 90, 92, 13, 15, 3, 54, 3, 86, 0, 103, 7, 71, 66, 81, 7, 4, 50, 84}, "4b548d"));
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        serviceVersionCode = parcelObtain2.readInt();
                    } else {
                        serviceVersionCode = Stub.getDefaultImpl().getServiceVersionCode();
                    }
                    return serviceVersionCode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean handleDeeplinkViaMsa(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{5, 90, 9, Ascii.ETB, 95, 8, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.DC2, 80, 9, 120, 86, 50, 14, 8, 19, Ascii.SYN, 88, 10, 8, Ascii.ESC, 8, 88, 92, 5, 8, 10, 1, 50, 80, 2, 3, 99, 86, Ascii.ETB, 65, 4, 19, Ascii.DC2, 15, 1, 84, 75, 47, 121, 5, 87, 86, 8, 15, 3, 54, 3, 86, 0, 53, 80, Ascii.SYN, 79, 91, 2, 4, 50, 84}, "f5d92a"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().handleDeeplinkViaMsa(str, str2, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean handleDeeplinkViaMsa2(int i, String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{80, 11, 12, Ascii.RS, 89, 11, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 71, 1, 12, 113, 80, 49, 14, 8, 19, Ascii.SYN, 88, 10, 93, 74, 13, 81, 90, 6, 8, 10, 1, 50, 80, 2, 86, 50, 83, Ascii.RS, 71, 7, 19, Ascii.DC2, 15, 1, 84, 75, 122, 40, 0, 94, 80, 11, 15, 3, 54, 3, 86, 0, 96, 1, 19, 70, 93, 1, 4, 50, 84}, "3da04b"));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().handleDeeplinkViaMsa2(i, str, str2, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean installSilently(String str, String str2, IInstallListener iInstallListener) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 12, 91, 79, 14, 95, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 67, 6, 91, 32, 7, 101, 14, 8, 19, Ascii.SYN, 88, 10, 89, 77, 90, 0, 13, 82, 8, 10, 1, 50, 80, 2, 82, 53, 4, 79, 16, 83, 19, Ascii.DC2, 15, 1, 84, 75, 126, 47, 87, 15, 7, 95, 15, 3, 54, 3, 86, 0, 100, 6, 68, Ascii.ETB, 10, 85, 4, 50, 84}, "7c6ac6"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iInstallListener != null ? iInstallListener.asBinder() : null);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().installSilently(str, str2, iInstallListener);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{7, 11, 84, Ascii.EM, 93, 88, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 16, 1, 84, 118, 84, 98, 14, 8, 19, Ascii.SYN, 88, 10, 10, 74, 85, 86, 94, 85, 8, 10, 1, 50, 80, 2, 1, 50, 11, Ascii.EM, 67, 84, 19, Ascii.DC2, 15, 1, 84, 75, 45, 40, 88, 89, 84, 88, 15, 3, 54, 3, 86, 0, 55, 1, 75, 65, 89, 82, 4, 50, 84}, "dd9701"));
        }

        public static ILandingPageServiceV2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILandingPageServiceV2)) ? new Proxy(iBinder) : (ILandingPageServiceV2) iInterfaceQueryLocalInterface;
        }

        public static ILandingPageServiceV2 getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ILandingPageServiceV2 iLandingPageServiceV2) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{75, 4, 77, 125, 82, 81, 0, 17, 10, Ascii.SYN, 120, 8, 72, 13, 17, 16, Ascii.ETB, 84, 0, 8, 10, 7, 85, 69, 76, Ascii.SYN, 80, 90, 82}, "8a9977"));
            }
            if (iLandingPageServiceV2 == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLandingPageServiceV2;
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
                    int serviceVersion = getServiceVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(serviceVersion);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    executeTask(parcel.createTypedArrayList(a.CREATOR), IActionTaskResultListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    cancelTask(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    int packageDownloadStatus = getPackageDownloadStatus(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageDownloadStatus);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    long nativeDownloadId = getNativeDownloadId(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeLong(nativeDownloadId);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    boolean zInstallSilently = installSilently(parcel.readString(), parcel.readString(), IInstallListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zInstallSilently ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(str);
                    boolean zHandleDeeplinkViaMsa = handleDeeplinkViaMsa(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zHandleDeeplinkViaMsa ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(str);
                    boolean zDownloadViaMsa = downloadViaMsa(IDownloadListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDownloadViaMsa ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(str);
                    boolean zCancelDownload = cancelDownload(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancelDownload ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface(str);
                    boolean zDownloadViaMarket = downloadViaMarket(IDownloadListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDownloadViaMarket ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(str);
                    boolean zCancelDeeplink = cancelDeeplink(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancelDeeplink ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(str);
                    boolean zHandleDeeplinkViaMsa2 = handleDeeplinkViaMsa2(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zHandleDeeplinkViaMsa2 ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface(str);
                    int serviceVersionCode = getServiceVersionCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(serviceVersionCode);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean cancelDeeplink(String str, String str2);

    boolean cancelDownload(String str);

    void cancelTask(String str);

    boolean downloadViaMarket(IDownloadListener iDownloadListener, String str, String str2);

    boolean downloadViaMsa(IDownloadListener iDownloadListener, String str, String str2, String str3, int i, String str4);

    void executeTask(List<a> list, IActionTaskResultListener iActionTaskResultListener);

    long getNativeDownloadId(String str);

    int getPackageDownloadStatus(String str);

    int getServiceVersion();

    int getServiceVersionCode();

    boolean handleDeeplinkViaMsa(String str, String str2, String str3);

    boolean handleDeeplinkViaMsa2(int i, String str, String str2, String str3);

    boolean installSilently(String str, String str2, IInstallListener iInstallListener);
}
