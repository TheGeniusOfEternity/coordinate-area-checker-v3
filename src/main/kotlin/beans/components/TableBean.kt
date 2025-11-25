package beans.components

import entities.Shot
import jakarta.annotation.PostConstruct
import jakarta.faces.view.ViewScoped
import jakarta.inject.Inject
import jakarta.inject.Named
import repositories.ShotRepository
import java.io.Serializable

@Named("tableBean")
@ViewScoped
class TableBean: Serializable {
    @Inject
    private lateinit var shotRepository: ShotRepository

    private var shots: List<Shot> = listOf()

    @PostConstruct
    fun init() {
        shots = shotRepository.getAll()
    }

    fun getShots(): List<Shot> {
        return shots
    }
}