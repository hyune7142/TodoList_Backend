package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfig implements CommandLineRunner {
	
	@Autowired CacheManager cacheManager;
	
	@Bean
    public EhCacheManagerFactoryBean ehCache(){
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factoryBean.setShared(true);
        return  factoryBean;
    }

    @Bean
    public CacheManager cacheManager(EhCacheManagerFactoryBean ehCache){
        return new EhCacheCacheManager(ehCache.getObject());
    }
    
    
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================");
    }
}
