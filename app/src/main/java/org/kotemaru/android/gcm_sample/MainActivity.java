package org.kotemaru.android.gcm_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * クライアントアプリ本体。
 *
 * @author @kotemaru.org
 */
public class MainActivity extends Activity {
    // https://console.developers.google.comのProject Number。
    public static final String SENDER_ID = "99999999999";
    // アプリサーバーのURL。
    public static final String SERVER_URL = "http://192.168.0.9:8888/";
    // アプリのユーザID。本来はログイン中のユーザとかになるはず。
    public static final String USER_ID = "TarouYamada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String regId = GCMRegister.getRegistrationId(this);
        if (regId == null || regId.isEmpty()) {
            // GCMへ端末登録。
            Intent intent = new Intent(this, GCMRegisterService.class);
            startService(intent);
        }
    }

    @Override
    protected void onDestroy() {
        GCMRegister.onDestroy(this);
        super.onDestroy();
    }
}
