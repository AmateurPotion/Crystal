package crystal.io;

import java.util.concurrent.CountDownLatch;

import arc.Core;
import arc.Net;

public class BlockingHTTP {
    private final CountDownLatch reqLatch = new CountDownLatch (1);
    private volatile Net.HttpResponse resp;
    
    /** Sends a basic HTTP GET request.*/
    public Net.HttpResponse httpGet(String url) throws InterruptedException {
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
    public Net.HttpResponse httpPost(String url, String content) throws InterruptedException {
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
