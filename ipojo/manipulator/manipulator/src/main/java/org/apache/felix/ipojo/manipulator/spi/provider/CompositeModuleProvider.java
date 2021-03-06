/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.felix.ipojo.manipulator.spi.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.felix.ipojo.manipulator.spi.ModuleProvider;
import org.apache.felix.ipojo.manipulator.spi.Module;

/**
 * Encapsulate other ModuleProviders in a single instance.
 * @since 1.11.2
 * @author <a href="mailto:dev@felix.apache.org">Felix Project Team</a>
 */
public class CompositeModuleProvider implements ModuleProvider {

    private final Iterable<ModuleProvider> providers;

    public CompositeModuleProvider(ModuleProvider... providers) {
        this(Arrays.asList(providers));
    }

    public CompositeModuleProvider(final Iterable<ModuleProvider> providers) {
        this.providers = providers;
    }

    public Iterable<Module> findModules() {
        List<Module> modules = new ArrayList<Module>();
        for (ModuleProvider provider : providers) {
            for (Module module : provider.findModules()) {
                modules.add(module);
            }
        }
        return modules;
    }
}
