/*
 * Copyright 2017-2021 Baidu Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.openrasp.hook.server.wildfly;

import com.baidu.openrasp.hook.server.ServerOutputCloseHook;
import com.baidu.openrasp.tool.annotation.HookAnnotation;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * Created by izpz on 18-10-26.
 * <p>
 * undertow 输出流关闭 hook 点
 */
@HookAnnotation
public class UndertowOutputHook extends ServerOutputCloseHook {

    /**
     * 用于判断类名与当前需要hook的类是否相同
     *
     * @param className 用于匹配的类名
     * @return 是否匹配
     */
    @Override
    public boolean isClassMatched(String className) {
        return "io/undertow/servlet/spec/ServletPrintWriter".equals(className);
    }

    /**
     * hook 方法
     *
     * @param ctClass hook 点所在的类
     * @param src     加入 hook点的代码
     */
    @Override
    protected void hookMethod(CtClass ctClass, String src) throws NotFoundException, CannotCompileException {
        insertBefore(ctClass, "close", "()V", src);
    }
}
