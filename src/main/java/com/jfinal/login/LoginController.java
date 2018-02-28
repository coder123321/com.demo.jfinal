package com.jfinal.login;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
    public void index(){
        render("login.html");
    }
}
