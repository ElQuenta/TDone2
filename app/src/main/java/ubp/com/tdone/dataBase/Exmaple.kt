package ubp.com.tdone.dataBase

import com.google.firebase.Timestamp
import ubp.com.tdone.R
import ubp.com.tdone.dataBase.dataclases.Cover
import ubp.com.tdone.dataBase.dataclases.Note
import ubp.com.tdone.dataBase.dataclases.Tag
import ubp.com.tdone.dataBase.dataclases.Task
import java.util.GregorianCalendar

public val noteListExample: List<Note>
    get() = listOf(
        Note(
            id = "nota1",
            title = "nota 1",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            cover = coverListExample[0],
            background = R.color.note_background_1,
        ),
        Note(
            id = "nota2",
            title = "nota 2",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            tags = listOf(
                tagListExample[0]
            ),
            background = R.color.note_background_12,
        ),
        Note(
            id = "nota3",
            title = "nota 3",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            tags = listOf(
                tagListExample[0],
                tagListExample[1]
            ),
            background = R.color.note_background_3,
        ),
        Note(
            id = "nota4",
            title = "nota 4",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            cover = coverListExample[1],
            background = R.color.note_background_10,
        ),
        Note(
            id = "nota5",
            title = "nota 5",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            tags = listOf(
                tagListExample[0],
                tagListExample[3]
            ),
            background = R.color.note_background_5,
        ),
        Note(
            id = "nota6",
            title = "nota 6",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            tags = listOf(
                tagListExample[2],
                tagListExample[3]
            ),
            background = R.color.note_background_6,
        ),
        Note(
            id = "nota7",
            title = "nota 7",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            tags = listOf(
                tagListExample[0],
                tagListExample[3]
            ),
            background = R.color.note_background_7,
        ),
        Note(
            id = "nota8",
            title = "nota 8",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            cover = coverListExample[0],
            tags = listOf(
                tagListExample[0],
                tagListExample[1]
            ),
            background = R.color.note_background_8,
        ),

        )
public val taskListExample: List<Task>
    get() = listOf(
        Task(
            id = "tarea_1",
            title = "Tarea nro1",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
            tag = listOf(
                tagListExample[0]
            )
        ),
        Task(
            id = "tarea_2",
            title = "Tarea nro2",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
            tag = listOf(
                tagListExample[0],
                tagListExample[1],
                tagListExample[2],

            )
        ),
        Task(
            id = "tarea_3",
            title = "Tarea nro3",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
            tag = listOf(
                tagListExample[0],
                tagListExample[3],

            )
        ),
        Task(
            id = "tarea_4",
            title = "Tarea nro4",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
            tag = listOf(
                tagListExample[1],
                tagListExample[2],
            )
        ),
        Task(
            id = "tarea_5",
            title = "Tarea nro5",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
            tag = listOf(
                tagListExample[1],
                tagListExample[3],
            )
        ),
        Task(
            id = "tarea_6",
            title = "Tarea nro6",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
        ),
        Task(
            id = "tarea_7",
            title = "Tarea nro7",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
            tag = listOf(
                tagListExample[0],
                tagListExample[1],
                tagListExample[2],
                tagListExample[3],
            )
        ),

        )

private val tagListExample: List<Tag> = listOf(
    Tag(name = "Importante", color = R.color.color_tag_1),
    Tag(name = "Urgente", color = R.color.color_tag_2),
    Tag(name = "Meh", color = R.color.color_tag_3),
    Tag(name = "Trivial", color = R.color.color_tag_4),
)

private val coverListExample: List<Cover> = listOf(
    Cover(src = R.drawable.ic_launcher_foreground, srcImage = true),
    Cover(src = R.drawable.ic_launcher_background, srcImage = true)
)