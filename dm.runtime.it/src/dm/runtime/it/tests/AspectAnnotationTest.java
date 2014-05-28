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
import dm.runtime.it.components.AspectAnnotation.ServiceAspect1;
import dm.runtime.it.components.AspectAnnotation.ServiceAspect2;
import dm.runtime.it.components.AspectAnnotation.ServiceAspect3;
import dm.runtime.it.components.AspectAnnotation.ServiceConsumer;
import dm.runtime.it.components.AspectAnnotation.ServiceProvider;

/**
 * Use case: Verify Aspect Annotations usage.
 */
public class AspectAnnotationTest extends TestBase {
 
    public AspectAnnotationTest() { 
        super(false); /* don't autoclear managers when one test is done */ 
    }

    public void testAspectChain() throws Throwable {
        Ensure e = new Ensure();
        // Activate service consumer
        ServiceRegistration scSequencer = register(e, ServiceConsumer.ENSURE);
        // Activate service provider
        ServiceRegistration spSequencer = register(e, ServiceProvider.ENSURE);
        // Activate service aspect 2
        ServiceRegistration sa2Sequencer = register(e, ServiceAspect2.ENSURE);
        // Activate service aspect 3
        ServiceRegistration sa3Sequencer = register(e, ServiceAspect3.ENSURE);
        // Activate service aspect 1
        ServiceRegistration sa1Sequencer = register(e, ServiceAspect1.ENSURE);

        e.step();
        e.waitForStep(6, 10000);

        // Deactivate service provider
        spSequencer.unregister();
        // Make sure that service aspect 1 has been called in ts removed and stop callbacks 
        e.waitForStep(8, 10000);
        e.ensure();

        scSequencer.unregister();
        sa1Sequencer.unregister();
        sa2Sequencer.unregister();
        sa3Sequencer.unregister();
    }
}
