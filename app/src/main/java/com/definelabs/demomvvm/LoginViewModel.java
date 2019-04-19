package com.definelabs.demomvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Patterns;

public class LoginViewModel extends BaseObservable {

    private User user;
    private String loginMessage="login successful";
    private String errorMessage="login failure";
    @Bindable
    private String toastMessage="null";

    public LoginViewModel() {
        user=new User();
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

   @Bindable
    public String getUserEmail(){
        return user.getEmail();
   }
   @Bindable
    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);

   }
   @Bindable
    public String getUserPassword(){
        return user.getPassword();
   }
   @Bindable
    public void setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
   }
   public void onLoginClicked(){
        if(isInputDataValid())
            setToastMessage(loginMessage);
        else setToastMessage(errorMessage);
   }

   public boolean isInputDataValid() {

       return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;

   }

}
