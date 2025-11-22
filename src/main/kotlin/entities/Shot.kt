package entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Timestamp

@Entity
@Table(name = "shots")
class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(name = "x", nullable = false)
    var x: Int? = null

    @Column(name = "y", nullable = false)
    var y: Float? = null

    @Column(name = "r", nullable = false)
    var r: Int? = null

    @Column(name = "is_hit", nullable = false)
    var isHit: Boolean? = null

    @Column(name = "hit_time", nullable = false)
    var hitTime: Timestamp? = null
}