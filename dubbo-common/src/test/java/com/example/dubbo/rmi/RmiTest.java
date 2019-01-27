package com.example.dubbo.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/27
 * @since 1.0
 */
public class RmiTest {


    public static void main(String[] args){

        try {
            register();
            find();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    private static void register() throws RemoteException{
        Service service = new ServiceImpl(); // #1
        Service stub = (Service) UnicastRemoteObject.exportObject(service, 19898); // #2
        Registry registry = LocateRegistry.createRegistry(1099); // #3
        registry.rebind("service", stub); // #4
    }

    private static void find() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099); // #1
        Service stub = (Service) registry.lookup("service"); // #2
        stub.sayHello("jaysong"); // #3
    }

}
