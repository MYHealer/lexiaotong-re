package client.android.yixiaotong.sdk.bluetooth.spp;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BluetoothReceiver extends BroadcastReceiver {
    String pin = "1234";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("action1=", action);
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if ("android.bluetooth.device.action.FOUND".equals(action)) {
            Log.e("发现设备:", "[" + bluetoothDevice.getName() + "]:" + bluetoothDevice.getAddress());
            if (bluetoothDevice.getBondState() == 10) {
                Log.e("ywq", "attemp to bond:[" + bluetoothDevice.getName() + "]");
                try {
                    ClsUtils.createBond(bluetoothDevice.getClass(), bluetoothDevice);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
            Log.e("action2=", action);
            try {
                ClsUtils.setPairingConfirmation(bluetoothDevice.getClass(), bluetoothDevice, true);
                Log.e("order...", "isOrderedBroadcast:" + isOrderedBroadcast() + ",isInitialStickyBroadcast:" + isInitialStickyBroadcast());
                abortBroadcast();
                ClsUtils.setPin(bluetoothDevice.getClass(), bluetoothDevice, this.pin);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
