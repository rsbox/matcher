package osrs.rsbox.matcher.gui.controller

import javafx.scene.control.ListView
import osrs.rsbox.matcher.core.api.asm.Class
import osrs.rsbox.matcher.core.api.asm.Method
import tornadofx.Controller
import tornadofx.singleAssign

class EntryListController : Controller() {

    /**
     * The class list entry list view object
     */
    var classList: ListView<Class> by singleAssign()

    /**
     * The method list entry list view object
     */
    var methodList: ListView<Method> by singleAssign()
}