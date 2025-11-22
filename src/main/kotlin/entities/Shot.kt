package entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.sql.Timestamp

@Entity
@Table(name = "shots")
class Shot(
    @Column(name = "x", nullable = false) var x: Int,
    @Column(name = "y", nullable = false) var y: Float,
    @Column(name = "r", nullable = false) var r: Int,
    @Column(name = "is_hit", nullable = false) var isHit: Boolean,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(name = "hit_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var hitTime: Timestamp = Timestamp(
        System.currentTimeMillis()
    )
}