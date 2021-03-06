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

package org.apache.felix.ipojo.runtime.core.components;

import org.apache.felix.ipojo.runtime.core.services.FooService;

import java.util.Properties;

public class NullCheckServiceProvider implements FooService {
    
    private String prop1;
    private String prop2;
    
    public NullCheckServiceProvider() {
      if (prop1 == null) {
          prop2= "0";
      }
    }
    

    public boolean foo() {
        if (prop1 == null  && prop2 != null) {
            prop1 = "0";
            prop2 = null;
            return true;
        }
        if (prop2 == null  && prop1 != null) {
            prop1 = null;
            prop2 = "0";
            return true;
        }
        return false;
    }

    public Properties fooProps() {
        return null;
    }

    public boolean getBoolean() {
        return false;
    }

    public double getDouble() {
        return 0;
    }

    public int getInt() {
        return 0;
    }

    public long getLong() {
        return 0;
    }

    public Boolean getObject() {
        return null;
    }

}
