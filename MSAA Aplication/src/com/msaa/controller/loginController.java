/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.controller;

import com.msaa.model.dao.implementLogin;
import com.msaa.model.dao.loginDAO;
import com.msaa.view.FormLogin;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author qoheng
 */
public class loginController {
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private FormLogin loginpanel;
    private static implementLogin implenetlogin;
    
    public loginController(FormLogin loginpanel){
        this.loginpanel = loginpanel;
        implenetlogin = new loginDAO();
        lokasiform();
    }
    
        public void lokasiform(){
        int x = layar.width / 2  -loginpanel.getSize().width / 2;
        int y = layar.height / 2 - loginpanel.getSize().height / 2;
        loginpanel.setLocation(x, y);
    }
        
        public void masuk(){
           
        }
    
}
