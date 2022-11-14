package com.example.checkloginmvp;

public class Presenter {

    Interface anInterface;

    public Presenter(Interface anInterface) {
        this.anInterface = anInterface;
    }

    public void login(User user){
        if (user.KiemtraEmail()&&user.KiemtraPassword()){
            //nếu email và pass đúng định dạng thì trả về hàm thành công
            anInterface.loginThanhCong();
        }else{
            //nếu email và pass đúng định dạng thì trả về hàm thất bại

            anInterface.loginThatBai();
        }
    }
}
