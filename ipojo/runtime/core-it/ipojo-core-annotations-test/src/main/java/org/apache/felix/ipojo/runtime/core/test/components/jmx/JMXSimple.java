/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.felix.ipojo.runtime.core.test.components.jmx;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.handlers.jmx.Config;
import org.apache.felix.ipojo.handlers.jmx.JMXMethod;
import org.apache.felix.ipojo.handlers.jmx.JMXProperty;

@Component
@Config(domain="my-domain", usesMOSGi=false)
public class JMXSimple {

    @JMXProperty(name="prop", notification=true, rights="w")
    String m_foo;

    @JMXMethod(description="set the foo prop")
    public void setFoo(String mes) {
        System.out.println("Set foo to " + mes);
        m_foo = mes;
    }

    @JMXMethod(description="get the foo prop")
    public String getFoo() {
        return m_foo;
    }
}
