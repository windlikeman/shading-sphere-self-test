/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.example.type;

public enum ShardingType {

    /**
     * 分库
     */
    SHARDING_DATABASES,
    /**
     * 分表
     */
    SHARDING_TABLES,
    /**
     * 分库分表
     */
    SHARDING_DATABASES_AND_TABLES,
    /**
     * 主从
     */
    MASTER_SLAVE,
    /**
     * 主从分片
     */
    SHARDING_MASTER_SLAVE
}
