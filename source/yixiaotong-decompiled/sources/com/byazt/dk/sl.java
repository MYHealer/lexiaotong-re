package com.byazt.dk;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 158})
public class sl {
    private static AlertDialog c(Activity activity, final com.byazt.dk.c cVar) {
        return new com.byazt.sgn.da(activity).c(cVar.c).tt(cVar.tt).ve(cVar.ve).uj(cVar.uj).c(cVar.n).c(new com.byazt.sgn.da.c() { // from class: com.byazt.dk.sl.2
            @Override // com.byazt.sgn.da.c
            public void c(Dialog dialog) {
                if (cVar.f2095a != null) {
                    cVar.f2095a.c(dialog);
                }
            }

            @Override // com.byazt.sgn.da.c
            public void tt(Dialog dialog) {
                if (cVar.f2095a != null) {
                    cVar.f2095a.tt(dialog);
                }
            }
        }).c(new DialogInterface.OnCancelListener() { // from class: com.byazt.dk.sl.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.f2095a != null) {
                    cVar.f2095a.ve(dialogInterface);
                }
            }
        });
    }

    public static void c(WeakReference<Context> weakReference, boolean z, final com.byazt.dk.c cVar) {
        com.byazt.aas.n.c cVar2 = new com.byazt.aas.n.c() { // from class: com.byazt.dk.sl.3
            @Override // com.byazt.aas.n.c
            public void c() {
                if (cVar.f2095a != null) {
                    cVar.f2095a.c(new c());
                }
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
                if (cVar.f2095a != null) {
                    cVar.f2095a.tt(new c());
                }
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                if (cVar.f2095a != null) {
                    cVar.f2095a.ve(new c());
                }
            }
        };
        if (z) {
            com.byazt.aas.n.c(weakReference.get(), String.valueOf(cVar.hashCode()), cVar.c, cVar.tt, cVar.ve, cVar.uj, cVar2);
        } else {
            com.byazt.aas.n.c(weakReference.get(), String.valueOf(cVar.hashCode()), cVar.c, cVar.tt, cVar2);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION})
    private static class c implements DialogInterface {
        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }

        private c() {
        }
    }

    public static AlertDialog c(Activity activity, boolean z, com.byazt.dk.c cVar) {
        if (z) {
            AlertDialog alertDialogC = c(activity, cVar);
            if (activity != null && !activity.isFinishing()) {
                alertDialogC.show();
            }
            return alertDialogC;
        }
        return c(activity, R.style.Theme.DeviceDefault.Light.Dialog, cVar);
    }

    private static AlertDialog c(Activity activity, int i, final com.byazt.dk.c cVar) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(cVar.c).setMessage(cVar.tt).setPositiveButton(cVar.ve, new DialogInterface.OnClickListener() { // from class: com.byazt.dk.sl.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (cVar.f2095a != null) {
                    cVar.f2095a.c(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.uj, new DialogInterface.OnClickListener() { // from class: com.byazt.dk.sl.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (cVar.f2095a != null) {
                    cVar.f2095a.tt(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.dk.sl.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.f2095a != null) {
                    cVar.f2095a.ve(dialogInterface);
                }
            }
        });
        if (cVar.n != null) {
            onCancelListener.setIcon(cVar.n);
        }
        AlertDialog alertDialogCreate = onCancelListener.create();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }
}
