/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.routing.fixture;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.ListShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.NoneKeyDatabaseShardingAlgorithm;

import java.util.Collection;

public class OrderDatabaseShardingAlgorithm implements NoneKeyDatabaseShardingAlgorithm<Integer> {
    
    // TODO need refactor NoneKeyShardingAlgorithm
    @Override
    public String doSharding(final Collection<String> availableTargetNames, final ShardingValue shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith(String.valueOf((int) ((ListShardingValue) shardingValue).getValues().iterator().next() % 2))) {
                return each;
            }
        }
        return null;
    }
}
