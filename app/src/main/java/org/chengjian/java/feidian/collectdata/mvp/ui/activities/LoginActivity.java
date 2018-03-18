package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.databinding.ActivityLoginBinding;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.BaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.dialog.ProgressDialogGenerator;
import org.chengjian.java.feidian.collectdata.network.HttpMethod;
import org.chengjian.java.feidian.collectdata.network.HttpResult;
import org.chengjian.java.feidian.collectdata.network.RequestCallback;
import org.chengjian.java.feidian.collectdata.shared.AppTool;
import org.chengjian.java.feidian.collectdata.shared.ConfigUtils;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getName();
    protected ProgressDialogGenerator submitDialogGenerator;
    ProgressBar pbLogin;
    private ActivityLoginBinding binding;
    Button btnLogin;
    Toolbar loginBar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    protected void initVariables() {

    }

    protected void initViews() {
        setSupportActionBar(loginBar);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imei = AppTool.getIMEI(LoginActivity.this);
                if (imei == null) {
//                     没有获取 IMEI 的权限
                    ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, 100);
                    return;
                }
                login(imei);
            }
        });

        if (ConfigUtils.getInstance().isUserLogin()) {
            enterMainPage();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initVariables();
        initViews();
    }

    // 登录服务器代码
    private void login(String imei) {
        ConfigUtils.getInstance().setUserLogin();
        enterMainPage();
        // 暂时屏蔽一下登录
//        HttpMethod.getInstance().login(imei, new RequestCallback<HttpResult<Void>>() {
//            @Override
//            public void beforeRequest() {
//                showProgress();
//            }
//
//            @Override
//            public void onError(String errorMsg) {
//                Toast.makeText(LoginActivity.this, errorMsg, Toast.LENGTH_LONG).show();
//                hideProgress();
//            }
//
//            @Override
//            public void success(HttpResult<Void> data) {
//                if (data.getResultCode() == Constants.USER_LOGIN_FAILED) {
////                     登录失败
//                    hideProgress();
//                    Toast.makeText(LoginActivity.this, data.getResultMessage(), Toast.LENGTH_LONG).show();
//                    return;
//                } else if (data.getResultCode() == Constants.USER_LOGIN_SUCCESS) {
////                     登录成功，并且在组内，保存用户数据
//                    ConfigUtils.getInstance().setUserLogin();
//                    enterMainPage();
//                }
//            }
//        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == 100) {
            // 请求获取IMEI码权限
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                login(AppTool.getIMEI(this));
            } else {
                // 请求被拒绝
                Toast.makeText(LoginActivity.this, "由于无法获得手机的IEEE码，你无法使用本软件功能", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        submitDialogGenerator = new ProgressDialogGenerator(this);
        super.onStart();
    }

    private void hideProgress() {
        submitDialogGenerator.cancel();
    }

    private void showProgress() {
        submitDialogGenerator.title(getResources().getString(R.string.logining));
        submitDialogGenerator.content(getResources().getString(R.string.please_waiting));
        submitDialogGenerator.circularProgress();
        submitDialogGenerator.cancelable(false);
        submitDialogGenerator.show();
    }

    private void enterMainPage() {
        Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
        startActivity(intent);
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onLogin(String msg) {
        // 这个函数其实没有什么作用，
        // 加在这个地方是因为 ... 不加就会报错
        // 主要原因还是在于 EventBus 这个库
    }

    public void register(View view) {
    }
}
