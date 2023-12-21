package org.example.app.dal.repositories.implementation;

import lombok.RequiredArgsConstructor;
import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.repositories.interfaces.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class BaseRepository<T, U> implements Repository<T, U> {
    private final EntityManagerUtil entityManagerUtil;

    @Override
    public void save(T obj) {
        Objects.requireNonNull(obj);
        entityManagerUtil.performWithinTx(entityManager -> entityManager.persist(obj));
    }

    @Override
    public Optional<T> findById(U id) {
        Class<T> actualTypeArgument = getActualTypeArgument();
        return entityManagerUtil.performReturningWithinTx(
                entityManager -> Optional.ofNullable(entityManager.find(actualTypeArgument, id)));
    }

    @Override
    public Optional<T> findByPredicate(Predicate<T> predicate) {
        Class<T> actualTypeArgument = getActualTypeArgument();
        return entityManagerUtil.performReturningWithinTx(
                entityManager -> entityManager.createQuery("from " + actualTypeArgument.getName(), actualTypeArgument)
                        .getResultList()
                        .stream()
                        .filter(predicate)
                        .findFirst());
    }

    @Override
    public List<T> findAll() {
        Class<T> actualTypeArgument = getActualTypeArgument();
        return entityManagerUtil.performReturningWithinTx(
                entityManager -> entityManager.createQuery("from " + actualTypeArgument.getName()).getResultList());
    }

    @Override
    public void update(T obj) {
        entityManagerUtil.performWithinTx(entityManager -> entityManager.merge(obj));
    }

    @Override
    public void delete(T obj) {
        entityManagerUtil.performWithinTx(entityManager -> entityManager.remove(obj));
    }

    private Class<T> getActualTypeArgument() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
