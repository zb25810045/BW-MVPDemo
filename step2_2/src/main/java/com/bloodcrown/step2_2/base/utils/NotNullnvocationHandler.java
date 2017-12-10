package com.bloodcrown.step2_2.base.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NotNullnvocationHandler implements InvocationHandler {

    protected Object v;

    public NotNullnvocationHandler(Object v) {
        this.v = v;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (v == null) {
            return null;
        }
        return method.invoke(v, args);
    }
}