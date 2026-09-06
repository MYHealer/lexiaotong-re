package com.icbc.paysdk.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.httpclient.ListHttpAPI;
import com.icbc.paysdk.model.PayList;
import com.icbc.paysdk.model.PayReq;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ICBCLaunchAppServices {
    boolean httpsuccess = false;
    private String jsonPayListFromServer = "";

    public boolean checkIsInstall(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 1);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static int getInstallPackageVerCode(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            Log.i("", e.getMessage());
            return 1;
        }
    }

    public boolean checkOrderData(PayReq payReq) {
        return (payReq.getInterfaceName().equals("") || payReq.getInterfaceVersion().equals("") || payReq.getTranData().equals("") || payReq.getMerSignMsg().equals("")) ? false : true;
    }

    public ArrayList<Integer> getInstallList(Context context) {
        Log.i(Constants.LogFlag, "getInstallList(Context context) -- context = " + context);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (checkIsInstall(context, Constants.ICBCPackage.ebank)) {
            arrayList.add(1);
        }
        if (checkIsInstall(context, Constants.ICBCPackage.ebuy)) {
            arrayList.add(2);
        }
        if (checkIsInstall(context, Constants.ICBCPackage.echat)) {
            arrayList.add(3);
        }
        if (checkIsInstall(context, "")) {
            arrayList.add(4);
        }
        return arrayList;
    }

    public ArrayList<Integer> getPayList(Context context) {
        String file;
        boolean z;
        Log.i(Constants.LogFlag, "getPayList(Context context)");
        FileUtil fileUtil = new FileUtil();
        try {
            file = fileUtil.readFile(context, Constants.payPackageFile);
            try {
                Log.i(Constants.LogFlag, "payListJsonFromLocal = " + file);
                z = false;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                z = true;
            }
        } catch (Exception e2) {
            e = e2;
            file = "";
        }
        if (file.equals("")) {
            z = true;
        } else if (IsLocalJsonOutDate(file)) {
            Log.i(Constants.LogFlag, "时间戳早于当前时间。");
            z = true;
        }
        ArrayList<Integer> payList = null;
        if (z) {
            byte[] bArrPost = new ListHttpAPI().post(null);
            if (bArrPost != null && bArrPost.length > 0) {
                Log.i(Constants.LogFlag, "httpResponse != null");
                this.httpsuccess = true;
                this.jsonPayListFromServer = new String(bArrPost);
            }
            Log.i(Constants.LogFlag, "jsonPayListFromServer = " + this.jsonPayListFromServer);
            if (!this.httpsuccess) {
                Log.i(Constants.LogFlag, "请求失败。");
            }
            if (this.httpsuccess) {
                Log.i(Constants.LogFlag, "请求成功。");
                try {
                    Log.i(Constants.LogFlag, "jsonPayListFromServer = " + this.jsonPayListFromServer);
                    fileUtil.writeFile(context, Constants.payPackageFile, this.jsonPayListFromServer, 0);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                PayList payList2 = JsonParse.parsePayList(this.jsonPayListFromServer);
                Log.i(Constants.LogFlag, "FromServer PayList.checkDate =" + payList2.getCheckDate() + "  PayList.paylist = " + payList2.getPayList().toString());
                payList = payList2.getPayList();
            }
        }
        if (z) {
            return payList;
        }
        PayList payList3 = JsonParse.parsePayList(file);
        Log.i(Constants.LogFlag, "FromLocal PayList.checkDate =" + payList3.getCheckDate() + "  PayList.paylist = " + payList3.getPayList().toString());
        return payList3.getPayList();
    }

    public String getPayPackageName(Context context) {
        ArrayList<Integer> installList = getInstallList(context);
        Log.i(Constants.LogFlag, "----intallList = " + installList.toString());
        ArrayList<Integer> payList = getPayList(context);
        if (payList == null || installList == null) {
            return null;
        }
        boolean z = false;
        int iIntValue = 0;
        for (Integer num : payList) {
            if (z) {
                break;
            }
            Iterator<Integer> it = installList.iterator();
            while (it.hasNext()) {
                if (num.equals(it.next())) {
                    iIntValue = num.intValue();
                    z = true;
                    break;
                }
            }
        }
        Log.i(Constants.LogFlag, "----packageNum = " + iIntValue);
        if (iIntValue == 0) {
            return null;
        }
        if (iIntValue == 1) {
            return Constants.ICBCPackage.ebank;
        }
        if (iIntValue != 2) {
            return iIntValue != 3 ? "" : Constants.ICBCPackage.echat;
        }
        return Constants.ICBCPackage.ebuy;
    }

    private boolean IsLocalJsonOutDate(String str) {
        try {
            PayList payList = JsonParse.parsePayList(str);
            new SimpleDateFormat("yyyy-MM-dd");
            return payList.getCheckDate().before(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
