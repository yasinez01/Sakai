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
package org.sakaiproject.elfinder;

/**
 * This is a ToolFsVolume that's aware of the site it's in.
 */
public interface ToolFsVolume extends SakaiFsVolume {

    /**
     * The SiteId that this FsVolume is for.
     * @return A String site ID.
     */
    String getSiteId();

    /**
     * The ToolFsVolumeFactory that created this ToolFsVolume.
     * This is mainly used to discover the prefix.
     * @return The SiteVolumeFactory.
     */
    ToolFsVolumeFactory getToolVolumeFactory();

    /**
     * Is the item writeable by the current user.
     * @param item The FsItem.
     * @return <code>true</code> if the passed item is writeable by the current user.
     */
    boolean isWriteable(SakaiFsItem item);

}
