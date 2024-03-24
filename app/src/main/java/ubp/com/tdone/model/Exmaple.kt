package ubp.com.tdone.model

import com.google.firebase.Timestamp
import ubp.com.tdone.R
import ubp.com.tdone.model.dataclases.Cover
import ubp.com.tdone.model.dataclases.Note
import ubp.com.tdone.model.dataclases.Tag
import ubp.com.tdone.model.dataclases.Task
import java.util.GregorianCalendar

public val noteListExample: List<Note>
    get() = listOf(
        Note(
            id = "nota1",
            userId = "userExample",
            title = "nota 1",
            body = "Finalizar el informe de ventas para el trimestre.\n" +
                    "Preparar la presentación para la reunión del cliente el viernes.\n" +
                    "Programar una llamada de seguimiento con el equipo de desarrollo para discutir los problemas de rendimiento.",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            cover = coverListExample[0],
            background = R.color.note_background_1,
        ),
        Note(
            id = "nota2",
            userId = "userExample",
            title = "nota 2",
            body = "Finalizar el informe de ventas para el trimestre.\n" +
                    "Preparar la presentación para la reunión del cliente el viernes.\n" +
                    "Programar una llamada de seguimiento con el equipo de desarrollo para discutir los problemas de rendimiento.",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            tags = listOf(
                tagListExample[0]
            ),
            background = R.color.note_background_12,
        ),
        Note(
            id = "nota3",
            userId = "userExample",
            title = "nota 3",
            body = "Durante la sesión de lluvia de ideas, se propusieron varias ideas creativas para mejorar la experiencia del usuario en nuestra aplicación móvil. Algunos de los conceptos incluyen la implementación de un nuevo sistema de navegación y la introducción de características de gamificación para aumentar la participación del usuario.",
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
            userId = "userExample",
            title = "nota 4",
            body = "Discutimos los requisitos del proyecto y confirmamos los plazos.\n" +
                    "Se acordaron las próximas etapas y se asignaron responsabilidades.\n" +
                    "Se programó una reunión de seguimiento para revisar el progreso.",
            createdAt = Timestamp.now(),
            updatedAt = Timestamp.now(),
            cover = coverListExample[1],
            background = R.color.note_background_10,
        ),
        Note(
            id = "nota5",
            userId = "userExample",
            title = "nota 5",
            body = "Durante la revisión de rendimiento trimestral, se identificaron áreas de mejora para el equipo de ventas, como la necesidad de mejorar la tasa de conversión y la calidad de las interacciones con los clientes. Se acordó proporcionar capacitación adicional y establecer metas claras para el próximo trimestre.",
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
            userId = "userExample",
            title = "nota 6",
            body = "Resumen de la llamada con el cliente:\n" +
                    "\n" +
                    "Discutimos los requisitos del proyecto y confirmamos los plazos.\n" +
                    "Se acordaron las próximas etapas y se asignaron responsabilidades.\n" +
                    "Se programó una reunión de seguimiento para revisar el progreso.",
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
            userId = "userExample",
            title = "nota 7",
            body = "Acciones a seguir:\n" +
                    "\n" +
                    "Investigar soluciones alternativas para el problema de rendimiento del servidor.\n" +
                    "Coordinar con el equipo de marketing para desarrollar una estrategia de lanzamiento.\n" +
                    "Programar una demostración del producto para el equipo ejecutivo la próxima semana.",
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
            userId = "userExample",
            title = "nota 8",
            body = "El cliente expresó su satisfacción con la implementación de las nuevas características en la aplicación y sugirió algunas mejoras adicionales, como la integración con plataformas de redes sociales y la optimización del rendimiento. Se comprometió a seguir proporcionando comentarios para ayudar a mejorar aún más el producto.",
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
            userId = "userExample",
            title = "Tarea nro1",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
            tag = listOf(
                tagListExample[0]
            )
        ),
        Task(
            id = "tarea_2",
            userId = "userExample",
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
            userId = "userExample",
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
            userId = "userExample",
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
            userId = "userExample",
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
            userId = "userExample",
            title = "Tarea nro6",
            description = "esta es una tarea de prueba",
            endDate = GregorianCalendar(2023, 2, 22).time,
        ),
        Task(
            id = "tarea_7",
            userId = "userExample",
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

val tagListExample: List<Tag> = listOf(
    Tag(id = "tag1", name = "Importante", color = R.color.color_tag_1, userId = "userExample"),
    Tag(id = "tag2", name = "Urgente", color = R.color.color_tag_2, userId = "userExample"),
    Tag(id = "tag3", name = "Meh", color = R.color.color_tag_3, userId = "userExample"),
    Tag(id = "tag4", name = "Trivial", color = R.color.color_tag_4, userId = "userExample"),
)

private val coverListExample: List<Cover> = listOf(
    Cover(
        id = "image1",
        userId = "userExample",
        src = R.drawable.ic_launcher_foreground,
        srcImage = true
    ),
    Cover(
        id = "image2",
        userId = "userExample",
        src = R.drawable.ic_launcher_background,
        srcImage = true
    )
)