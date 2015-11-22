package org.kotemaru.android.gcm_sample;

        import android.content.Intent;

        import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * RegistrationId の更新タイミングを受け取るだけのサービス。
 *
 * @author kotemaru@kotemaru.org
 */
public class TokenRefreshService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, GCMRegisterService.class);
        startService(intent);
    }
}
