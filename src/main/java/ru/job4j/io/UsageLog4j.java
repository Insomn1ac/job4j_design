package ru.job4j.io;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        byte b = 12;
        short s = 110;
        int i = 432;
        long l = 123456;
        float f = 0.2f;
        double d = 43.1d;
        char c = 'a';
        boolean bool = true;
        LOG.info("byte : {}, short : {}, int : {}, long : {}, float : {}"
                + ", double : {}, char : {}, boolean : {}", b, s, i, l, f, d, c, bool);
    }
}