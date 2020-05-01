package com.basic.mvp;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basic.mvp.base.BaseView;
import com.basic.mvp.bean.BaseEntity;
import com.basic.mvp.bean.UserInfo;
import com.basic.mvp.login.LoginContract;
import com.basic.mvp.login.LoginPresenter;

public class MainActivity extends BaseView<LoginPresenter, LoginContract.View> {

    private EditText nameEt;
    private EditText pwdEt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    // 初始化控件
    private void initView() {
        nameEt = findViewById(R.id.et_name);
        pwdEt = findViewById(R.id.et_pwd);
        btn = findViewById(R.id.bt_login);
    }

    //实例化p层
    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserInfo>() {
            @Override
            public void handlerResult(UserInfo baseEntity) {

                Log.e("111",baseEntity.getCompany()+baseEntity.getName());
            }
        };
    }


    public void doLoginAction(View view) {
        String name = nameEt.getText().toString();
        String pwd = pwdEt.getText().toString();

        // 发起需求，让Presenter处理
        p.getContract().requestLogin(name,pwd);
    }

    @Override
    public void error(Exception e) {
        super.error(e);
    }
}
