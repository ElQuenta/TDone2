package ubp.com.tdone.controller

import android.content.Intent

interface Command {

    public fun execute(): Intent

}