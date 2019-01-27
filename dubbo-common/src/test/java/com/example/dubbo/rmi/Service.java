package com.example.dubbo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/27
 * @since 1.0
 */
public interface Service extends Remote {

    void sayHello(String name) throws RemoteException;

}
