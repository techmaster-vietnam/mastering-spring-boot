package vn.techmaster.jpa.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.SharedEntityManagerCreator;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@AllArgsConstructor
public class AppJpaRepositoryFactory {
    private final AppJpaTransactionManagerFactory appJpaTransactionManagerFactory;

    public <T, I, R extends JpaRepository> R createJpaRepository(
        String datasourceId,
        Class jpaRepositoryClass,
        JpaTransactionManager jpaTransactionManager
    ) {
        final JpaTransactionManager actualJpaTransactionManager =
            jpaTransactionManager == null
                ? jpaTransactionManager
                : appJpaTransactionManagerFactory.createJpaTransactionManager(datasourceId);
        final EntityManagerFactory entityManagerFactory =
            actualJpaTransactionManager.getEntityManagerFactory();
        assert entityManagerFactory != null;
        final EntityManager entityManager =
            SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory);
        final JpaRepositoryFactory jpaRepositoryFactory = new JpaRepositoryFactory(entityManager);
        final TransactionInterceptor transactionInterceptor = new TransactionInterceptor(
            (TransactionManager) actualJpaTransactionManager,
            new AnnotationTransactionAttributeSource()
        );
        jpaRepositoryFactory.addRepositoryProxyPostProcessor((factory, repositoryInformation) ->
            factory.addAdvice(transactionInterceptor)
        );
        return (R) jpaRepositoryFactory.getRepository(jpaRepositoryClass);
    }
}
