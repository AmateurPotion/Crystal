package crystal.io;

import java.util.concurrent.CountDownLatch;

import arc.Core;
import arc.Net;
import arc.struct.*;
import arc.func.Cons;
import arc.util.*;

public class BlockingHTTP {
    private final CountDownLatch reqLatch = new CountDownLatch (1);
    private volatile HttpResponse resp;
    
    /** Sends a basic HTTP GET request.*/
    public HttpResponse httpGet(String url) {
        synchronized(this) {
            Core.net.httpGet(url, res -> {
                    resp = res;
                    reqLatch.countDown();
                } , error -> {});
                reqLatch.await();
        }
        return resp;
    }

    /** Sends a basic HTTP POST request.*/
    public HttpResponse httpPost(String url, String content){
        synchronized(this) {
            Core.net.httpPost(url, content, res -> {
                    resp = res;
                    reqLatch.countDown();
                } , error -> {});
                reqLatch.await();
        }
        return resp;
    }
}
