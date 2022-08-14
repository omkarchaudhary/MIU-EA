package com.miu.ea.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDestroy implements BeanPostProcessor, DisposableBean, BeanFactoryAware {
    private BeanFactory beanFactory;
    List<Object> prototypeBean = new ArrayList<>();

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        if(beanFactory.isPrototype(beanName)){
            prototypeBean.add(bean);
        }
        return bean;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Prototype bean has been destroyed");
        if(prototypeBean instanceof DisposableBean){
            for(Object object : prototypeBean ){
                DisposableBean disposableBean = (DisposableBean) object;
                disposableBean.destroy();
            }
        }
        prototypeBean.clear();
    }
}
