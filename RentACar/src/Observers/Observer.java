package Observers;

import Client.Client;

/**
 * Created by Devene on 5/12/2016.
 */
public abstract class Observer {
    protected Client subject;
    public abstract void update();
}
