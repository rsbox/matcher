package osrs.rsbox.matcher.gui.controller

import javafx.scene.control.ListView
import osrs.rsbox.matcher.core.api.asm.Class
import tornadofx.Controller
import tornadofx.singleAssign

class EntryListController : Controller() {

    /**
     * The class list entry list view object
     */
    var classList: ListView<Class> by singleAssign()
}