package com.basic.mvp.login;

import com.basic.mvp.MainActivity;
import com.basic.mvp.base.BasePresenter;

import com.basic.mvp.bean.UserInfo;

public class LoginPresenter extends BasePresenter<MainActivity,LoginModel,LoginContract.Presenter> {

    @Override
    public LoginContract.Presenter getContract() {
        // 既要履行View给它的需求，又要分配工作给Model去完成这个需求
        return new LoginContract.Presenter<UserInfo>() {
            @Override
            public void requestLogin(String name, String pwd) {
                try {

                    // 三种风格（P层很极端，要么不做事只做转发，要么就是拼命一个人干活）
                    m.getContract().excuteLogin(name,pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseResult(UserInfo baseEntity) {

                // 不管谁完成需求，有结果就告知View层
                getView().getContract().handlerResult(baseEntity);

            }
        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}
