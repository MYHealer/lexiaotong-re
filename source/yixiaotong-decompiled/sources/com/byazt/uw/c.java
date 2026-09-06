package com.byazt.uw;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.byazt.ou.u;
import com.byazt.su.DownloadModel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1715, 20})
public class c implements u {
    @Override // com.byazt.ou.u
    public void c(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.byazt.ou.u
    public Dialog tt(com.byazt.e.tt ttVar) {
        return c(ttVar);
    }

    private static Dialog c(final com.byazt.e.tt ttVar) {
        if (ttVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(ttVar.c).setTitle(ttVar.tt).setMessage(ttVar.ve).setPositiveButton(ttVar.uj, new DialogInterface.OnClickListener() { // from class: com.byazt.uw.c.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (ttVar.x != null) {
                    ttVar.x.c(dialogInterface);
                }
            }
        }).setNegativeButton(ttVar.n, new DialogInterface.OnClickListener() { // from class: com.byazt.uw.c.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (ttVar.x != null) {
                    ttVar.x.tt(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(ttVar.f2124a);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.uw.c.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (ttVar.x != null) {
                    ttVar.x.ve(dialogInterface);
                }
            }
        });
        if (ttVar.sp != null) {
            alertDialogShow.setIcon(ttVar.sp);
        }
        return alertDialogShow;
    }
}
