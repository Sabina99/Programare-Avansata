package com.company.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    public void giveRow(Integer input) throws RemoteException;
    public void giveColumn(Integer input) throws RemoteException;
    public String getResult() throws RemoteException;
    public String processCommand(String command) throws RemoteException;
    public String createGame() throws RemoteException;
    public String createPlayer() throws RemoteException;
    public Integer getPlayer()  throws RemoteException;
}