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
package dm.runtime.it.tests;

import org.osgi.framework.ServiceRegistration;

import dm.it.Ensure;
import dm.it.TestBase;
import dm.runtime.it.components.PropagateAnnotation;

/**
 * Use case: Verify that dependency "propagate" option is properly propagating properties to provided service.
 */
public class PropagateAnnotationTest extends TestBase {
    
    public PropagateAnnotationTest() { 
        super(false); /* don't autoclear managers when one test is done */ 
    }

    public void testServiceDependencyPropagate() {
        Ensure e = new Ensure();
        ServiceRegistration sr = register(e, PropagateAnnotation.ENSURE);
        e.waitForStep(3, 10000);
        sr.unregister();
    }
}
