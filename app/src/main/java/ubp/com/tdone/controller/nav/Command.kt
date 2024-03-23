package ubp.com.tdone.controller.nav

import android.content.Intent

interface Command {

    public fun execute(): Intent

}