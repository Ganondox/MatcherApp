package sample;

import java.net.http.HttpClient;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Client {

    public PublicKey pub2 = null;
    public PrivateKey pri = null;
    public String key = null;
    HttpClient client = null;
    UserRecord workingUser = null;


}

/*
    public getIndex(scheme component) throws Exception{
        int index = 0;
        switch (component){
            case HOURS:
                index++;
                break;
            default:
                throw new Exception();
        }
    }
}

enum scheme{HOURS};

*/