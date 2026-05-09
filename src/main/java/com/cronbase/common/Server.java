package com.cronbase.common;

import static spark.Spark.port;
import static spark.Spark.useVirtualThread;

public final class Server {
    public static void init() {
        port(8080);
        useVirtualThread(true);
    }
}
