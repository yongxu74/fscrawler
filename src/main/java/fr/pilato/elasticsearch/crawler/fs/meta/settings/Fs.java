/*
 * Licensed to David Pilato (the "Author") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Author licenses this
 * file to you under the Apache License, Version 2.0 (the
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

package fr.pilato.elasticsearch.crawler.fs.meta.settings;

import java.util.ArrayList;
import java.util.List;

public class Fs {
    private String url;
    private TimeValue updateRate;
    private List<String> includes;
    private List<String> excludes;
    private boolean jsonSupport;
    private boolean filenameAsId;
    private boolean addFilesize;
    private boolean removeDeleted;
    private boolean storeSource;
    private boolean indexContent;
    private Percentage indexedChars;
    private boolean attributesSupport;

    public static Builder builder() {
        return new Builder();
    }

    public static final String DEFAULT_DIR = "/tmp/es";
    public static final Fs DEFAULT = Fs.builder().setUrl(DEFAULT_DIR).build();

    public static class Builder {
        private String url;
        private TimeValue updateRate = TimeValue.timeValueMinutes(15);
        private List<String> includes = null;
        private List<String> excludes = null;
        private boolean jsonSupport = false;
        private boolean filenameAsId = false;
        private boolean addFilesize = true;
        private boolean removeDeleted = true;
        private boolean storeSource = false;
        private boolean indexContent = true;
        private Percentage indexedChars = null;
        private boolean attributesSupport = false;

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setUpdateRate(TimeValue updateRate) {
            this.updateRate = updateRate;
            return this;
        }

        public Builder setIncludes(List<String> includes) {
            this.includes = includes;
            return this;
        }

        public Builder addInclude(String include) {
            if (this.includes == null) {
                this.includes = new ArrayList<>();
            }

            // We refuse to add duplicates
            if (!this.includes.contains(include)) {
                this.includes.add(include);
            }

            return this;
        }

        public Builder setExcludes(List<String> excludes) {
            this.excludes = excludes;
            return this;
        }

        public Builder addExclude(String exclude) {
            if (this.excludes == null) {
                this.excludes = new ArrayList<>();
            }

            // We refuse to add duplicates
            if (!this.excludes.contains(exclude)) {
                this.excludes.add(exclude);
            }

            return this;
        }

        public Builder setJsonSupport(boolean jsonSupport) {
            this.jsonSupport = jsonSupport;
            return this;
        }

        public Builder setFilenameAsId(boolean filenameAsId) {
            this.filenameAsId = filenameAsId;
            return this;
        }

        public Builder setAddFilesize(boolean addFilesize) {
            this.addFilesize = addFilesize;
            return this;
        }

        public Builder setRemoveDeleted(boolean removeDeleted) {
            this.removeDeleted = removeDeleted;
            return this;
        }

        public Builder setStoreSource(boolean storeSource) {
            this.storeSource = storeSource;
            return this;
        }

        public Builder setIndexedChars(Percentage indexedChars) {
            this.indexedChars = indexedChars;
            return this;
        }

        public Builder setIndexContent(boolean indexContent) {
            this.indexContent = indexContent;
            return this;
        }

        public Builder setAttributesSupport(boolean attributesSupport) {
            this.attributesSupport = attributesSupport;
            return this;
        }

        public Fs build() {
            return new Fs(url, updateRate, includes, excludes, jsonSupport, filenameAsId, addFilesize,
                    removeDeleted, storeSource, indexedChars, indexContent, attributesSupport);
        }
    }

    public Fs() {

    }

    Fs(String url, TimeValue updateRate, List<String> includes, List<String> excludes, boolean jsonSupport,
       boolean filenameAsId, boolean addFilesize, boolean removeDeleted, boolean storeSource, Percentage indexedChars,
       boolean indexContent, boolean attributesSupport) {
        this.url = url;
        this.updateRate = updateRate;
        this.includes = includes;
        this.excludes = excludes;
        this.jsonSupport = jsonSupport;
        this.filenameAsId = filenameAsId;
        this.addFilesize = addFilesize;
        this.removeDeleted = removeDeleted;
        this.storeSource = storeSource;
        this.indexedChars = indexedChars;
        this.indexContent = indexContent;
        this.attributesSupport = attributesSupport;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TimeValue getUpdateRate() {
        return updateRate;
    }

    public void setUpdateRate(TimeValue updateRate) {
        this.updateRate = updateRate;
    }

    public List<String> getIncludes() {
        return includes;
    }

    public void setIncludes(List<String> includes) {
        this.includes = includes;
    }

    public List<String> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }

    public boolean isJsonSupport() {
        return jsonSupport;
    }

    public void setJsonSupport(boolean jsonSupport) {
        this.jsonSupport = jsonSupport;
    }

    public boolean isFilenameAsId() {
        return filenameAsId;
    }

    public void setFilenameAsId(boolean filenameAsId) {
        this.filenameAsId = filenameAsId;
    }

    public boolean isAddFilesize() {
        return addFilesize;
    }

    public void setAddFilesize(boolean addFilesize) {
        this.addFilesize = addFilesize;
    }

    public boolean isRemoveDeleted() {
        return removeDeleted;
    }

    public void setRemoveDeleted(boolean removeDeleted) {
        this.removeDeleted = removeDeleted;
    }

    public boolean isStoreSource() {
        return storeSource;
    }

    public void setStoreSource(boolean storeSource) {
        this.storeSource = storeSource;
    }

    public Percentage getIndexedChars() {
        return indexedChars;
    }

    public void setIndexedChars(Percentage indexedChars) {
        this.indexedChars = indexedChars;
    }

    public boolean isIndexContent() {
        return indexContent;
    }

    public void setIndexContent(boolean indexContent) {
        this.indexContent = indexContent;
    }

    public boolean isAttributesSupport() {
        return attributesSupport;
    }

    public void setAttributesSupport(boolean attributesSupport) {
        this.attributesSupport = attributesSupport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fs fs = (Fs) o;

        if (jsonSupport != fs.jsonSupport) return false;
        if (filenameAsId != fs.filenameAsId) return false;
        if (addFilesize != fs.addFilesize) return false;
        if (removeDeleted != fs.removeDeleted) return false;
        if (storeSource != fs.storeSource) return false;
        if (indexContent != fs.indexContent) return false;
        if (attributesSupport != fs.attributesSupport) return false;
        if (url != null ? !url.equals(fs.url) : fs.url != null) return false;
        if (updateRate != null ? !updateRate.equals(fs.updateRate) : fs.updateRate != null) return false;
        if (includes != null ? !includes.equals(fs.includes) : fs.includes != null) return false;
        if (excludes != null ? !excludes.equals(fs.excludes) : fs.excludes != null) return false;
        return !(indexedChars != null ? !indexedChars.equals(fs.indexedChars) : fs.indexedChars != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (updateRate != null ? updateRate.hashCode() : 0);
        result = 31 * result + (includes != null ? includes.hashCode() : 0);
        result = 31 * result + (excludes != null ? excludes.hashCode() : 0);
        result = 31 * result + (jsonSupport ? 1 : 0);
        result = 31 * result + (filenameAsId ? 1 : 0);
        result = 31 * result + (addFilesize ? 1 : 0);
        result = 31 * result + (removeDeleted ? 1 : 0);
        result = 31 * result + (storeSource ? 1 : 0);
        result = 31 * result + (indexContent ? 1 : 0);
        result = 31 * result + (indexedChars != null ? indexedChars.hashCode() : 0);
        result = 31 * result + (attributesSupport ? 1 : 0);
        return result;
    }
}
