package pl.mareklangiewicz.recyclerui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.mareklangiewicz.sandboxui.sandbox
import splitties.views.dsl.core.*
import splitties.views.padding

data class Title(val title: String) : WithId {
    override val id = title.hashCode().toLong()
}

class SomeItemUi(override val ctx: Context) : ItemUi<Title> {
    override fun render(item: Title) { root.text = item.title }
    override val root = button()
}

private val someTitles = listOf(
    Title("Mad Item"),
    Title("Dirty Widget"),
    Title("Views Terminator"),
    Title("Compose Fiction")
)

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val ui1 = RecyclerUi(this, ::SomeItemUi)
        val ui2 = RecyclerUi(this, ::SomeItemUi)
        val ui3 = RecyclerUi(this, ::SomeItemUi)

        val box = sandbox("RecyclerUi playground") {
            + ui1.root.apply { padding = 16 }
            + ui2.root.apply { padding = 16 }
            + ui3.root.apply { padding = 16 }
            action("populate 1") { ui1.items += someTitles }
            action("populate 2") { ui2.items += someTitles }
            action("populate 3") { ui3.items += someTitles }
        }

        setContentView(box)
    }
}

