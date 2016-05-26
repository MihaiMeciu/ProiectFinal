package Observers;

import Client.Client;

/**
 * Created by Devene on 5/12/2016.
 */
public class CautaObserver extends Observer{
    public CautaObserver(Client subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update(){

    }
}
