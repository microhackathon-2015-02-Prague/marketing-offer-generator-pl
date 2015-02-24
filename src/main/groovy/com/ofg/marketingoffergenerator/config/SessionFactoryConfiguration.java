package com.ofg.marketingoffergenerator.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.hibernate.SingletonEhCacheRegionFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@EnableTransactionManagement
@Configuration
class SessionFactoryConfiguration {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setCheckoutTimeout(10000);
        dataSource.setAutoCommitOnClose(false);
        dataSource.setInitialPoolSize(1);
        dataSource.setMinPoolSize(1);
        dataSource.setDriverClass("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;MVCC=true");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        dataSource.setPreferredTestQuery("select 1");
        dataSource.setTestConnectionOnCheckout(true);

        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {

        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.show_sql", false);

        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.jdbc.fetch_size", 0);
        properties.put("hibernate.order_updates", true);
        properties.put("hibernate.cache.use_second_level_cache", false);
        properties.put("hibernate.cache.use_query_cache", false);
        properties.put("hibernate.cache.region.factory_class", SingletonEhCacheRegionFactory.class.getName());
//        properties.put("org.hibernate.envers.audit_table_prefix", "AUDIT_");
//        properties.put("org.hibernate.envers.audit_table_suffix", "");

        return properties;
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource, @Qualifier("hibernateProperties") Properties properties) throws Exception {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("com.ofg.marketingoffergenerator");
        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.afterPropertiesSet();
        SessionFactory sessionFactory = sessionFactoryBean.getObject();
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public CacheManager cacheManager() throws Exception {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.afterPropertiesSet();
        return cacheManagerFactoryBean.getObject();
    }

}
