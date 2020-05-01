package com.basic.mvp.login;

import com.basic.mvp.base.BaseModel;
import com.basic.mvp.base.BasePresenter;
import com.basic.mvp.bean.UserInfo;


// 接收到P层交给它的需求
public class LoginModel extends BaseModel<LoginPresenter,LoginContract.Model> {


    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void excuteLogin(String username, String password) throws Exception {



                p.getContract().responseResult(new UserInfo("mvp","123"));
            }
        };
    }



}


