package entities

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "shots")
class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shots_seq")
    @SequenceGenerator(name = "shots_seq", sequenceName = "shots_SEQ", allocationSize = 50)
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "x", nullable = false)
    var x: Int = 0

    @Column(name = "y", nullable = false)
    var y: Float = 0f

    @Column(name = "r", nullable = false)
    var r: Int = 0

    @Column(name = "is_hit", nullable = false)
    var isHit: Boolean = false

    @Column(name = "hit_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var hitTime: Timestamp = Timestamp(System.currentTimeMillis())

    // Конструктор без аргументов (требуется Hibernate)
    constructor()

    // Конструктор с параметрами (для удобства)
    constructor(x: Int, y: Float, r: Int, isHit: Boolean) {
        this.x = x
        this.y = y
        this.r = r
        this.isHit = isHit
        this.hitTime = Timestamp(System.currentTimeMillis())
    }
}
