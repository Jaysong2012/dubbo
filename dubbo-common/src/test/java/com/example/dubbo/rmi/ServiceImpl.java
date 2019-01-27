package com.example.dubbo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/27
 * @since 1.0
 */
public class ServiceImpl implements Service{

    @Override
    public void sayHello(String name) {
        System.out.println("hello "+name);
    }
}
