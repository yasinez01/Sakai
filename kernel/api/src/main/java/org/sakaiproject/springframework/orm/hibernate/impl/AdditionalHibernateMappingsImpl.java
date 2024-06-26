/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/master/trunk/header.java $
 * $Id: header.java 9220 2006-05-09 23:09:28Z ggolden@umich.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.springframework.orm.hibernate.impl;

import java.io.File;
import java.io.IOException;

import org.sakaiproject.springframework.orm.hibernate.AdditionalHibernateMappings;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdditionalHibernateMappingsImpl implements AdditionalHibernateMappings {

    @Setter private Class<?>[] annotatedClasses;
    @Setter private String[] annotatedPackages;
    @Setter private Resource[] cacheableMappingLocations;
    @Setter private Resource[] mappingDirectoryLocations;
    @Setter private Resource[] mappingJarLocations;
    @Setter private Resource[] mappingLocations;
    @Setter private String[] mappingResources;
    @Setter private String[] packagesToScan;
    @Getter @Setter private Integer sortOrder = Integer.MAX_VALUE;

    @Override
    public void processAdditionalMappings(LocalSessionFactoryBuilder sfb) throws IOException {

        if (annotatedClasses != null) {
            for (Class<?> clazz : annotatedClasses) {
                log.info("Hibernate add annotated class [{}]", clazz.getCanonicalName());
                sfb.addAnnotatedClass(clazz);
            }
        }

        if (annotatedPackages != null) {
            for (String aPackage : annotatedPackages) {
                log.info("Hibernate add annotated package [{}]", aPackage.trim());
                sfb.addPackage(aPackage);
            }
        }

        if (cacheableMappingLocations != null) {
            for (Resource resource : cacheableMappingLocations) {
                log.info("Hibernate add cacheable mapping location [{}]", resource.getFilename());
                sfb.addCacheableFile(resource.getFile());
            }
        }

        if (mappingDirectoryLocations != null) {
            for (Resource resource : mappingDirectoryLocations) {
                log.info("Hibernate add mapping directory location [{}]", resource.getFilename());
                File file = resource.getFile();
                if (!file.isDirectory()) {
                    log.error("Hibernate mapping directory location [{}] does not denote a directory", resource);
                }
                sfb.addDirectory(file);
            }
        }

        if (mappingJarLocations != null) {
            for (Resource resource : mappingJarLocations) {
                log.info("Hibernate add mapping jar location [{}]", resource.getFilename());
                sfb.addJar(resource.getFile());
            }
        }

        if (mappingLocations != null) {
            for (Resource resource : mappingLocations) {
                log.info("Hibernate add mapping location [{}]", resource.getFilename());
                sfb.addInputStream(resource.getInputStream());
            }
        }

        if (mappingResources != null) {
            for (String resource : mappingResources) {
                Resource mr = new ClassPathResource(resource.trim(), getClass().getClassLoader());
                log.info("Hibernate add mapping resource [{}]", resource.trim());
                sfb.addInputStream(mr.getInputStream());
            }
        }

        if (packagesToScan != null) {
            for (String scanPackage : packagesToScan) {
                log.info("Hibernate add package [{}]", scanPackage.trim());
                sfb.addPackage(scanPackage);
            }
        }
    }

    @Override
    public void processAdditionalUnit(MutablePersistenceUnitInfo pui) {
        if (annotatedClasses != null) {
            for (Class<?> clazz : annotatedClasses) {
                pui.addManagedClassName(clazz.getName());
                log.info("Add annotated class [{}]", clazz.getCanonicalName());
            }
        }
        if (annotatedPackages != null) {
            for (String aPackage : annotatedPackages) {
                pui.addManagedPackage(aPackage);
                log.info("Add annotated package [{}]", aPackage.trim());
            }
        }

        if (cacheableMappingLocations != null) {
            for (Resource resource : cacheableMappingLocations) {
                try {
                    pui.addMappingFileName(resource.getURL().toString());
                    log.info("Add cacheable mapping location [{}]", resource.getFilename());
                } catch (IOException e) {
                    log.error("Invalid mapping location [{}]", resource, e);
                }
            }
        }

        if (mappingDirectoryLocations != null) {
            for (Resource resource : mappingDirectoryLocations) {
                try {
                    pui.addMappingFileName(resource.getURL().toString());
                    log.info("Add mapping directory location [{}]", resource.getFilename());
                } catch (IOException e) {
                    log.error("Invalid mapping directory location [{}]", resource, e);
                }
            }
        }

        if (mappingJarLocations != null) {
            for (Resource resource : mappingJarLocations) {
                try {
                    pui.addJarFileUrl(resource.getURL());
                    log.info("Add mapping jar location [{}]", resource.getFilename());
                } catch (IOException e) {
                    log.error("Invalid mapping jar location [{}]", resource, e);
                }
            }
        }

        if (mappingLocations != null) {
            for (Resource resource : mappingLocations) {
                pui.addMappingFileName(resource.getFilename());
                log.info("Add mapping location [{}]", resource.getFilename());
            }
        }

        if (mappingResources != null) {
            for (String resource : mappingResources) {
                Resource r = new ClassPathResource(resource.trim(), this.getClass().getClassLoader());
                try {
                    pui.addMappingFileName(r.getURL().toString());
                    log.info("Add mapping resource [{}]", resource.trim());
                } catch (IOException e) {
                    log.error("Invalid mapping resource [{}]", resource);
                }
            }
        }

        if (packagesToScan != null) {
            for (String scanPackage : packagesToScan) {
                log.info("Add package [{}]", scanPackage.trim());
                pui.addManagedPackage(scanPackage);
            }
        }
    }

    @Override
    public int compareTo(AdditionalHibernateMappings o) {
        return getSortOrder().compareTo(o.getSortOrder());
    }
}
