package com.cyrusinnovation.mockitogroovysupport.creation;

import com.cyrusinnovation.mockitogroovysupport.util.*;
import groovy.lang.*;
import org.mockito.cglib.proxy.*;
import org.mockito.internal.*;
import org.mockito.internal.creation.*;

import java.lang.reflect.*;

public class MethodInterceptorForGroovyFilter extends MethodInterceptorFilter {

    private ObjectMethodsGroovyGuru objectMethodsGuru = new ObjectMethodsGroovyGuru();

    public MethodInterceptorForGroovyFilter(InternalMockHandler handler, MockSettingsImpl mockSettings) {
        super(handler, mockSettings);
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (objectMethodsGuru.isGetMetaClass(method)) {
            return GroovySystem.getMetaClassRegistry().getMetaClass(method.getDeclaringClass());
        }

        return super.intercept(proxy, method, args, methodProxy);
    }
}
