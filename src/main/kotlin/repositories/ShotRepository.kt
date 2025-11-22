package repositories

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import entities.Shot
import jakarta.inject.Singleton

@Singleton
@Transactional
class ShotRepository {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    fun save(shot: Shot): Shot {
        entityManager.persist(shot)
        return shot
    }

    fun findAll(): List<Shot> {
        val query = entityManager.createQuery(
            "SELECT shot FROM Shot shot",
            Shot::class.java
        )
        return query.resultList
    }

    fun findById(id: Long): Shot? {
        return entityManager.find(
            Shot::class.java,
            id
        )
    }

    fun delete(id: Long) {
        val shot = entityManager.find(
            Shot::class.java,
            id
        )
        if (shot != null) {
            entityManager.remove(shot)
        }
    }
}
