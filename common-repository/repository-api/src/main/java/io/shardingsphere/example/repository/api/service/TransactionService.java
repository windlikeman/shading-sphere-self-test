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

package io.shardingsphere.example.repository.api.service;

public interface TransactionService extends CommonService {

    /**
     * 事务类别
     * 本地事务
     * 完全支持非跨库事务，例如：仅分表，或分库但是路由的结果在单库中。
     * 完全支持因逻辑异常导致的跨库事务。例如：同一事务中，跨两个库更新。更新完毕后，抛出空指针，则两个库的内容都能回滚。
     * 不支持因网络、硬件异常导致的跨库事务。例如：同一事务中，跨两个库更新，更新完毕后、未提交之前，第一个库宕机，则只有第二个库数据提交。
     */
    void processFailureWithLocal();

    /**
     * 分布式事务（强一致性事务）
     * 完全支持跨库事务。
     * 默认使用Atomikos，支持使用SPI的方式加载其他XA事务管理器。
     */
    void processFailureWithXa();

    /**
     * 柔性事务
     * 预计4.0.0支持
     */
    void processFailureWithBase();

    /**
     * 打印事务类别
     */
    void printTransactionType();
}
