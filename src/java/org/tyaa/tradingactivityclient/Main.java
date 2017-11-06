/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivityclient;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.tyaa.tradingactivity.entity.Sale;
import org.tyaa.tradingactivity.rmi.RMISessionBeanRemote;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        
        //клиент
        InitialContext initialContext = new InitialContext();
        RMISessionBeanRemote remoteServiceRemote
            = (RMISessionBeanRemote) initialContext.lookup("rmi/remote_service");
        System.out.println(((Sale)remoteServiceRemote.getAllSales().get(0)).getSecurityName());
        
        Sale newSale = new Sale();
        newSale.setPrice(4100);
        newSale.setQuantity(200);
        newSale.setSecurityName("ORCL");
        remoteServiceRemote.addSale(newSale, 1, 2);
    }
    
}
