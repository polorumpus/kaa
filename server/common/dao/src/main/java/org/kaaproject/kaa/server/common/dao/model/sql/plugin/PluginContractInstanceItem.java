/*
 * Copyright 2014-2015 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaaproject.kaa.server.common.dao.model.sql.plugin;

import org.kaaproject.kaa.common.dto.plugin.PluginContractInstanceItemDto;
import org.kaaproject.kaa.server.common.dao.DaoConstants;
import org.kaaproject.kaa.server.common.dao.model.sql.GenericModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_CONF_DATA;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_JOIN_TABLE_IN_PLUGIN_INSTANCE_CONTRACT_ITEM_ID;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_JOIN_TABLE_OUT_PLUGIN_INSTANCE_CONTRACT_ITEM_ID;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_PARENT_PLUGIN_CONTRACT_ITEM_FK;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_INSTANCE_FK;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_INSTANCE_ID;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_ITEM_FK;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_ITEM_ID;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_ITEM_PARENT_ID;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_TABLE_NAME;

@Entity
@Table(name = PLUGIN_CONTRACT_INSTANCE_ITEM_TABLE_NAME)
public class PluginContractInstanceItem extends GenericModel<PluginContractInstanceItemDto> implements Serializable {

    private static final long serialVersionUID = -9145339406077995951L;

    @Column(name = PLUGIN_CONTRACT_INSTANCE_ITEM_CONF_DATA)
    private String confData;

    @ManyToOne
    @JoinColumn(name = PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_INSTANCE_ID,
            foreignKey = @ForeignKey(name = PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_INSTANCE_FK))
    private PluginContractInstance pluginContractInstance;

    @ManyToOne
    @JoinColumn(name = PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_ITEM_ID,
            foreignKey = @ForeignKey(name = PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_ITEM_FK))
    private PluginContractItem pluginContractItem;

    @ManyToOne
    @JoinColumn(name = PLUGIN_CONTRACT_INSTANCE_ITEM_PLUGIN_CONTRACT_ITEM_PARENT_ID,
            foreignKey = @ForeignKey(name = PLUGIN_CONTRACT_INSTANCE_ITEM_PARENT_PLUGIN_CONTRACT_ITEM_FK))
    private PluginContractItem parentPluginContractItem;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_JOIN_TABLE_NAME,
            joinColumns = {@JoinColumn(name = PLUGIN_CONTRACT_INSTANCE_ITEM_JOIN_TABLE_IN_PLUGIN_INSTANCE_CONTRACT_ITEM_ID,
                    foreignKey = @ForeignKey(name = DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_JOIN_TABLE_IN_PLUGIN_INSTANCE_CONTRACT_ITEM_FK))},
            inverseJoinColumns = {@JoinColumn(name = PLUGIN_CONTRACT_INSTANCE_ITEM_JOIN_TABLE_OUT_PLUGIN_INSTANCE_CONTRACT_ITEM_ID,
                    foreignKey = @ForeignKey(name = DaoConstants.PLUGIN_CONTRACT_INSTANCE_ITEM_JOIN_TABLE_OUT_PLUGIN_INSTANCE_CONTRACT_ITEM_FK))})
    private Set<PluginContractInstanceItem> pluginContractItems;

    // TODO: reference schema model
    @Transient
    private String inMessageSchema;

    // TODO: reference schema model
    @Transient
    private String outMessageSchema;

    public PluginContractInstanceItem() {
    }

    public PluginContractInstanceItem(PluginContractInstanceItemDto dto) {
    }

    public String getConfData() {
        return confData;
    }

    public void setConfData(String confData) {
        this.confData = confData;
    }

    public PluginContractInstance getPluginContractInstance() {
        return pluginContractInstance;
    }

    public void setPluginContractInstance(PluginContractInstance pluginContractInstance) {
        this.pluginContractInstance = pluginContractInstance;
    }

    public PluginContractItem getPluginContractItem() {
        return pluginContractItem;
    }

    public void setPluginContractItem(PluginContractItem pluginContractItem) {
        this.pluginContractItem = pluginContractItem;
    }

    public PluginContractItem getParentPluginContractItem() {
        return parentPluginContractItem;
    }

    public void setParentPluginContractItem(PluginContractItem parentPluginContractItem) {
        this.parentPluginContractItem = parentPluginContractItem;
    }

    public Set<PluginContractInstanceItem> getPluginContractItems() {
        return pluginContractItems;
    }

    public void setPluginContractItems(Set<PluginContractInstanceItem> pluginContractItems) {
        this.pluginContractItems = pluginContractItems;
    }

    @Override
    protected PluginContractInstanceItemDto createDto() {
        return new PluginContractInstanceItemDto();
    }

    // TODO: implement
    @Override
    public PluginContractInstanceItemDto toDto() {
        return null;
    }
}
