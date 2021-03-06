/*
 * Copyright 2016 SimplifyOps, Inc. (http://simplifyops.com)
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

package com.dtolabs.rundeck.app.internal.framework

import com.dtolabs.rundeck.core.common.FilesystemFramework
import com.dtolabs.rundeck.core.utils.IPropertyLookup
import com.dtolabs.rundeck.core.utils.PropertyLookup

/**
 * Created by greg on 2/20/15.
 */
class FrameworkPropertyLookupFactory {
    String baseDir
    public IPropertyLookup create(){
        File baseDir = new File(baseDir);

        if (!baseDir.exists()) {
            throw new IllegalArgumentException("rdeck_base directory does not exist. " + baseDir);
        }

        //framework lookup property file
        File propertyFile = FilesystemFramework.getPropertyFile(FilesystemFramework.getConfigDir(baseDir));

        PropertyLookup lookup1 = PropertyLookup.createDeferred(propertyFile);
        lookup1.expand();
        println lookup1.getPropertiesMap()
        return lookup1;
    }
}
