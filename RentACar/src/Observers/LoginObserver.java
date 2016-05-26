package Observers;

import Client.Client;

/**
 * Created by Devene on 5/12/2016.
 */
public class LoginObserver extends Observer{
    public LoginObserver(Client subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update(){

    }
}
