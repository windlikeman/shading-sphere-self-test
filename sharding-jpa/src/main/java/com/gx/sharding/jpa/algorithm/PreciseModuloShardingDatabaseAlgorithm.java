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

package com.gx.sharding.jpa.algorithm;

import com.gx.sharding.jpa.config.ConstantConfig;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 取模
 * @author liyongfei
 */
public class PreciseModuloShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {

    private static final Logger logger = LoggerFactory.getLogger(PreciseModuloShardingDatabaseAlgorithm.class);

    @Override
    public String doSharding(final Collection<String> databaseNames, final PreciseShardingValue<Integer> shardingValue) {

        if (databaseNames.contains(ConstantConfig.DEFAULT_DATABASE)){
            logger.info("本次分库路由：{}",ConstantConfig.DEFAULT_DATABASE);
            return ConstantConfig.DEFAULT_DATABASE;
        }
        if (shardingValue.getValue() < ConstantConfig.DEFAULT_MOD ){
            logger.error("取模参数从{}开始，请重新设置小区编号",ConstantConfig.DEFAULT_MOD);
        }
        //取模
        for (String each : databaseNames) {
            if (each.endsWith(shardingValue.getValue() % ConstantConfig.DEFAULT_MOD + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
