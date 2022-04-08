/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenfirebase;

import implement.UserImpl;
import interfaces.UserInterf;

/**
 *
 * @author Ody
 */
public class MainFirebase {

    private static UserInterf interf;
    
    
    
    public static UserInterf getConnFirebase() {
        if (interf == null) {
            interf = new UserImpl();
        }
        return interf;
    }
}
