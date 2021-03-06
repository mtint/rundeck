/*
 * Copyright 2019 Rundeck, Inc. (http://rundeck.com)
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
package org.rundeck.core.projects;

import com.dtolabs.rundeck.core.authorization.UserAndRolesAuthContext;
import com.dtolabs.rundeck.core.plugins.configuration.Property;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * importer of project archive data
 */
public interface ProjectDataImporter {

    /**
     * Import content from a project archive
     *
     * @param authContext   auth context
     * @param project       project name
     * @param importFiles   map of file names and files that were matched by import patterns
     * @param importOptions options map
     * @return Errors encountered during the import process that should be reported to the user
     */
    default List<String> doImport(
            UserAndRolesAuthContext authContext,
            String project,
            Map<String, File> importFiles,
            Map<String, String> importOptions
    )
    {
        return null;
    }

    /**
     * @return authorization action names to test, any match will be allowed
     */
    default List<String> getImportAuthRequiredActions() {
        return null;
    }

    /**
     * @return list of input properties for import process
     */
    default List<Property> getImportProperties(){
        return null;
    }

    /**
     * @return list of ZipReader file patterns
     */
    default List<String> getImportFilePatterns(){
        return null;
    }

    /**
     * @return list of component names to run before
     */
    default List<String> getImportMustRunBefore() {
        return null;
    }

    /**
     * @return list of component names to run after
     */
    default List<String> getImportMustRunAfter() {
        return null;
    }
}
