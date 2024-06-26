/**
 * Copyright (c) 2003-2015 The Apereo Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://opensource.org/licenses/ecl2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sakaiproject.content.api;

/**
 * This is a service that holds all the ContentFilters and allows streams to be filtered.
 * It's exposed as a service so that tools serving up thier own content can do it in the
 * same way as the kernel.
 * @see ContentFilter
 */
public interface ContentFilterService {

    /**
     * This applies all the filters defined to the supplied content resource.
     * @param resource The content resource to wrap cannot be <code>null</code>.
     * @return A new content resource wrapped up or if the original resource if no filters apply.
     */
    ContentResource wrap(ContentResource resource);

}
