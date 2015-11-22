package org.kotemaru.android.gcm_sample;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * GCM のメッセージを受け取るサービス。
 *
 * @author kotemaru@kotemaru.org
 */
public class GCMReceiverService extends GcmListenerService {
    private static final String TAG = GCMReceiverService.class.getSimpleName();

    @Override
    public void onMessageReceived(String from, Bundle data) {
        String msg = data.getString("msg");
        Log.d(TAG, "onMessageReceived: from=" + from + "  message=" + msg);
    }

    @Override
    public void onDeletedMessages() {
        Log.d(TAG, "onDeletedMessages:");
    }

    @Override
    public void onMessageSent(String msgId) {
        Log.d(TAG, "onMessageSent:" + msgId);
    }

    @Override
    public void onSendError(String msgId, String error) {
        Log.d(TAG, "onSendError:" + msgId + "," + error);
    }
}
