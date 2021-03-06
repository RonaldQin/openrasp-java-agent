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

package com.baidu.openrasp.plugin.checker.policy;

import com.baidu.openrasp.plugin.checker.AbstractChecker;

/**
 * Created by tyy on 17-11-14.
 *
 * 用于检测安全基线类型hook点
 */
public abstract class PolicyChecker extends AbstractChecker {

    public PolicyChecker() {
        super();
        addCheckEventListener(new PolicyCheckListener());
    }

    public PolicyChecker(boolean canBlock) {
        super(canBlock);
        addCheckEventListener(new PolicyCheckListener());
    }

}
