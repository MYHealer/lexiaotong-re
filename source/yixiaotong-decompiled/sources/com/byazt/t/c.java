package com.byazt.t;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.c.a;
import com.byazt.c.d;
import com.byazt.c.da;
import com.byazt.c.i;
import com.byazt.c.m;
import com.byazt.c.or;
import com.byazt.c.rl;
import com.byazt.c.sp;
import com.byazt.c.t;
import com.byazt.c.x;
import com.byazt.c.zm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface c extends IInterface {
    a a() throws RemoteException;

    int c(int i) throws RemoteException;

    i c(int i, int i2) throws RemoteException;

    DownloadInfo c() throws RemoteException;

    da da() throws RemoteException;

    m i() throws RemoteException;

    x n() throws RemoteException;

    sp sl() throws RemoteException;

    rl sp() throws RemoteException;

    int t() throws RemoteException;

    i tt(int i) throws RemoteException;

    com.byazt.c.n tt() throws RemoteException;

    d uj() throws RemoteException;

    t ve(int i) throws RemoteException;

    zm ve() throws RemoteException;

    or x() throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.t.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 66, 44})
    public static abstract class AbstractBinderC0277c extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0277c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static c c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
                return (c) iInterfaceQueryLocalInterface;
            }
            return new C0278c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    DownloadInfo downloadInfoC = c();
                    parcel2.writeNoException();
                    if (downloadInfoC != null) {
                        parcel2.writeInt(1);
                        downloadInfoC.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.byazt.c.n nVarTt = tt();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nVarTt != null ? nVarTt.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iC = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iC);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    i iVarC = c(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iVarC != null ? iVarC.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    i iVarTt = tt(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iVarTt != null ? iVarTt.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    zm zmVarVe = ve();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zmVarVe != null ? zmVarVe.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    d dVarUj = uj();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(dVarUj != null ? dVarUj.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    x xVarN = n();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(xVarN != null ? xVarN.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    a aVarA = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aVarA != null ? aVarA.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    rl rlVarSp = sp();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(rlVarSp != null ? rlVarSp.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    or orVarX = x();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(orVarX != null ? orVarX.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    m mVarI = i();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mVarI != null ? mVarI.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    da daVarDa = da();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(daVarDa != null ? daVarDa.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    sp spVarSl = sl();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(spVarSl != null ? spVarSl.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iT = t();
                    parcel2.writeNoException();
                    parcel2.writeInt(iT);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    t tVarVe = ve(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(tVarVe != null ? tVarVe.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.t.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 66, 810})
        private static class C0278c implements c {
            public static c c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0278c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.t.c
            public DownloadInfo c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public com.byazt.c.n tt() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().tt();
                    }
                    parcelObtain2.readException();
                    return com.byazt.c.n.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public int c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.tt.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().c(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public i c(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.tt.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().c(i, i2);
                    }
                    parcelObtain2.readException();
                    return i.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public i tt(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.tt.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().tt(i);
                    }
                    parcelObtain2.readException();
                    return i.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public zm ve() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().ve();
                    }
                    parcelObtain2.readException();
                    return zm.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public d uj() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().uj();
                    }
                    parcelObtain2.readException();
                    return d.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public x n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().n();
                    }
                    parcelObtain2.readException();
                    return x.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public a a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().a();
                    }
                    parcelObtain2.readException();
                    return a.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public rl sp() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().sp();
                    }
                    parcelObtain2.readException();
                    return rl.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public or x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().x();
                    }
                    parcelObtain2.readException();
                    return or.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public m i() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().i();
                    }
                    parcelObtain2.readException();
                    return m.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public da da() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().da();
                    }
                    parcelObtain2.readException();
                    return da.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public sp sl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().sl();
                    }
                    parcelObtain2.readException();
                    return sp.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public int t() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.tt.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().t();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.t.c
            public t ve(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.tt.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0277c.u() != null) {
                        return AbstractBinderC0277c.u().ve(i);
                    }
                    parcelObtain2.readException();
                    return t.c.c(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static c u() {
            return C0278c.c;
        }
    }
}
