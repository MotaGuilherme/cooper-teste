package br.com.jj.coop.cooptest.config;


import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@EnableCaching
@RequiredArgsConstructor
public class CacheConfiguration {

    @Bean
    public Config configure() {
        return new Config().setInstanceName("coop-instance")
                .addMapConfig(initializeDefaultMapConfig());
    }

    private MapConfig initializeDefaultMapConfig() {
        MapConfig mapConfig = new MapConfig("default");
        mapConfig.setName("useCache");
        mapConfig.setBackupCount(1);
        mapConfig.getEvictionConfig().setEvictionPolicy(EvictionPolicy.LRU);
        mapConfig.getEvictionConfig().setMaxSizePolicy(MaxSizePolicy.USED_HEAP_SIZE);
        return mapConfig;
    }
}
