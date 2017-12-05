package com.bloodcrown.step1_7.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public abstract class BasePersenter<V extends IBaseView> {

    protected V mIBaseView;

    protected void getProxyView() {
        mIBaseView = (V) Proxy.newProxyInstance(mIBaseView.getClass().getClassLoader(), mIBaseView.getClass().getInterfaces(), new NotNullnvocationHandler(mIBaseView));
    }

    public void attachView(V baseViewa) {
        this.mIBaseView = baseViewa;
        getProxyView();
    }

    public V getView() {
        return mIBaseView;
    }

    public void detachView() {
        this.mIBaseView = null;
    }

    public class NotNullnvocationHandler implements InvocationHandler {

        protected V v;

        public NotNullnvocationHandler(V v){
            this.v = v;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (mIBaseView == null) {
                return null;
            }
            return method.invoke(v, args);
        }
    }

}
