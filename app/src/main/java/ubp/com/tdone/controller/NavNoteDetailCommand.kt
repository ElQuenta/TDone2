package ubp.com.tdone.controller

import android.content.Intent
import ubp.com.tdone.model.dataclases.Note

class NavNoteDetailCommand(private val note: Note, private val navigator: Navigator) : Command {
    override fun execute(): Intent = navigator.navToNoteDetail(note)

}