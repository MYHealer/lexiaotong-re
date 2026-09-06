package com.hihonor.dlinstall.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface n extends IInterface {

    public static abstract class a extends Binder implements n {
        public a() {
            attachInterface(this, "com.hihonor.dlinstall.ipc.IDownloadInstallListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str;
            StringBuilder sb;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.hihonor.dlinstall.ipc.IDownloadInstallListener");
                return true;
            }
            parcel.enforceInterface("com.hihonor.dlinstall.ipc.IDownloadInstallListener");
            int i3 = parcel.readInt();
            Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
            com.hihonor.dlinstall.ipc.a aVar = (com.hihonor.dlinstall.ipc.a) this;
            m mVar = aVar.b;
            if (mVar != null) {
                mVar.b("onEvent " + i3);
            }
            if (bundle != null) {
                switch (i3) {
                    case 1:
                    case 7:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA = aVar.a("onDownloadFail", bundle);
                            if (c0475aA != null) {
                                int i4 = bundle.getInt("key_error_code", -1);
                                String string = bundle.getString("key_error_message");
                                str = TextUtils.isEmpty(string) ? "unknown" : string;
                                int i5 = bundle.getInt("key_task_type", 0);
                                com.hihonor.dlinstall.page.a.c("BnDlInstallListener", "onDownloadFail: errorCode is " + i4 + ",errorMessage is " + str);
                                aVar.f3591a.onDownloadFail(c0475aA.f3592a, c0475aA.b, i4, str, i5);
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onDownloadFail: mCallbackManager is null");
                        }
                        break;
                    case 2:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA2 = aVar.a("onDownloadWaiting", bundle);
                            if (c0475aA2 != null) {
                                aVar.f3591a.onDownloadWaiting(c0475aA2.f3592a, c0475aA2.b, bundle.getLong("key_current_size", -1L), bundle.getLong("key_total_size", -1L), bundle.getInt("key_download_waiting_state", 0), bundle.getInt("key_task_type", 0));
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onDownloadWaiting: mCallbackManager is null");
                        }
                        break;
                    case 3:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA3 = aVar.a("onDownloadStart", bundle);
                            if (c0475aA3 != null) {
                                aVar.f3591a.onDownloadStart(c0475aA3.f3592a, c0475aA3.b, bundle.getLong("key_current_size", -1L), bundle.getLong("key_total_size", -1L), bundle.getInt("key_task_type", 0));
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onDownloadStart: mCallbackManager is null");
                        }
                        break;
                    case 4:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA4 = aVar.a("onDownloadPause", bundle);
                            if (c0475aA4 != null) {
                                long j = bundle.getLong("key_current_size", -1L);
                                long j2 = bundle.getLong("key_total_size", -1L);
                                String str2 = "onDownloadPause: currSize is " + j + ",totalSize is " + j2;
                                aVar.f3591a.onDownloadPause(c0475aA4.f3592a, c0475aA4.b, j, j2, bundle.getInt("key_task_type", 0));
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onDownloadPause: mCallbackManager is null");
                        }
                        break;
                    case 5:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA5 = aVar.a("onDownloadProgress", bundle);
                            if (c0475aA5 != null) {
                                long j3 = bundle.getLong("key_current_size", -1L);
                                long j4 = bundle.getLong("key_total_size", -1L);
                                float f = bundle.getFloat("key_speed", -1.0f);
                                String str3 = "onDownloadProgress: currSize is " + j3 + ",totalSize is " + j4 + ",speed is " + f;
                                aVar.f3591a.onDownloadProgress(c0475aA5.f3592a, c0475aA5.b, j3, j4, f, bundle.getInt("key_task_type", 0));
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onDownloadProgress: mCallbackManager is null");
                        }
                        break;
                    case 6:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA6 = aVar.a("onDownloadSuccess", bundle);
                            if (c0475aA6 != null) {
                                aVar.f3591a.onDownloadSuccess(c0475aA6.f3592a, c0475aA6.b, bundle.getInt("key_task_type", 0));
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onDownloadSuccess: mCallbackManager is null");
                        }
                        break;
                    case 8:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA7 = aVar.a("onInstallStart", bundle);
                            if (c0475aA7 != null) {
                                aVar.f3591a.onInstallStart(c0475aA7.f3592a, c0475aA7.b);
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onInstallStart: mCallbackManager is null");
                        }
                        break;
                    case 9:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA8 = aVar.a("onInstallSuccess", bundle);
                            if (c0475aA8 != null) {
                                aVar.f3591a.onInstallSuccess(c0475aA8.f3592a, c0475aA8.b);
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onInstallSuccess: mCallbackManager is null");
                        }
                        break;
                    case 10:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA9 = aVar.a("onInstallFail", bundle);
                            if (c0475aA9 != null) {
                                int i6 = bundle.getInt("key_error_code", -1);
                                String string2 = bundle.getString("key_error_message");
                                str = TextUtils.isEmpty(string2) ? "unknown" : string2;
                                com.hihonor.dlinstall.page.a.c("BnDlInstallListener", "onInstallFail: errorCode is " + i6 + ",errorMessage is " + str);
                                aVar.f3591a.onInstallFail(c0475aA9.f3592a, c0475aA9.b, i6, str);
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onInstallFail: mCallbackManager is null");
                        }
                        break;
                    case 11:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA10 = aVar.a("onTrafficDownload", bundle);
                            if (c0475aA10 != null) {
                                aVar.f3591a.onTrafficDownload(c0475aA10.f3592a, c0475aA10.b);
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onTrafficDownload: mCallbackManager is null");
                        }
                        break;
                    case 12:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA11 = aVar.a("onOpenApp", bundle);
                            if (c0475aA11 != null) {
                                aVar.f3591a.onOpenApp(c0475aA11.b, c0475aA11.f3592a, bundle.getBoolean("key_open_page_success", false));
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onOpenApp: mCallbackManager is null");
                        }
                        break;
                    case 13:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA12 = aVar.a("onClickDownloadInstallBtn", bundle);
                            if (c0475aA12 != null) {
                                aVar.f3591a.onClickDownloadInstallBtn(c0475aA12.b, c0475aA12.f3592a, bundle.getInt("key_click_download_install_btn"));
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onClickDownloadInstallBtn: mCallbackManager is null");
                        }
                        break;
                    case 14:
                        if (aVar.f3591a != null) {
                            com.hihonor.dlinstall.ipc.a.C0475a c0475aA13 = aVar.a("onFailResult", bundle);
                            if (c0475aA13 != null) {
                                int i7 = bundle.getInt("key_error_code", -1);
                                String string3 = bundle.getString("key_error_message");
                                str = TextUtils.isEmpty(string3) ? "unknown" : string3;
                                com.hihonor.dlinstall.page.a.c("BnDlInstallListener", "onFailResult: errorCode is " + i7 + ",errorMessage is " + str);
                                aVar.f3591a.onFailResult(c0475aA13.f3592a, c0475aA13.b, i7, str);
                            }
                        } else {
                            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "onFailResult: mCallbackManager is null");
                        }
                        break;
                    default:
                        sb = new StringBuilder("onEvent: unsupported event is ");
                        break;
                }
                parcel2.writeNoException();
                return true;
            }
            sb = new StringBuilder("onEvent: data is null, event is ");
            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", sb.append(i3).toString());
            parcel2.writeNoException();
            return true;
        }
    }
}
