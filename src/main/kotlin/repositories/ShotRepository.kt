package repositories

import entities.Shot
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import java.io.Serializable

@ApplicationScoped
@Transactional
class ShotRepository: Serializable {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    fun save(shot: Shot): Shot? {
        try {
            entityManager.persist(shot)
            entityManager.flush()
            return shot
        } catch (e: Exception) {
            println(e.message)
            return null
        }
    }

    fun getAll(): List<Shot>? {
        try {
            val query = entityManager.createQuery("SELECT s FROM Shot s", Shot::class.java)
            return query.resultList
        } catch (_: Exception) {
            return null
        }
    }
}
