package by.chekun.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory


@Configuration
@EntityScan(basePackages = ["by.chekun.model"])
@EnableJpaRepositories(basePackages = ["by.chekun"])
@EnableTransactionManagement
class RepositoryConfig {

    private var entityManagerFactory: EntityManagerFactory? = null

    @Autowired
    fun setEntityManagerFactory(factory: EntityManagerFactory?) {
        entityManagerFactory = factory
    }

    @Bean(name = ["transactionManager"])
    fun platformTransactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory
        return transactionManager
    }
}