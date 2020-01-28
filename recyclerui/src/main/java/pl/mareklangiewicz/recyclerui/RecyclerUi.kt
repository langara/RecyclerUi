package pl.mareklangiewicz.recyclerui

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import splitties.views.dsl.core.Ui
import splitties.views.dsl.recyclerview.recyclerView
import splitties.views.dsl.recyclerview.verticalListLayoutParams
import splitties.views.onClick
import splitties.views.recyclerview.verticalLayoutManager

interface WithId { val id: Long }
// TODO: do not force items to implement WithId
//   if they don't then just setHasStableIds(false) and make getItemId return NO_ID

interface ItemUi<in Item: WithId> : Ui {
    fun render(item: Item)
}

// TODO: add support for optional item decorations (without putting it into actual items data)
@Suppress("EXPERIMENTAL_API_USAGE")
class RecyclerUi<Item: WithId>(
    override val ctx: Context,
    private val newItemUi: (Context) -> ItemUi<Item>,
    private val onItemClick: (id: Long) -> Unit = {}
) : Ui {

    var items = emptyList<Item>()
        set(value) {
            field = value
            root.adapter?.notifyDataSetChanged()
        }

    override val root = recyclerView {
        adapter = Adapter()
        layoutManager = verticalLayoutManager()
    }

    private inner class Adapter : RecyclerView.Adapter<Holder>() {
        init { setHasStableIds(true) }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(newItemUi(ctx))
        override fun onBindViewHolder(holder: Holder, position: Int) = holder.ui.render(items[position])
        override fun getItemCount() = items.size
        override fun getItemId(position: Int) = items[position].id
    }

    private inner class Holder(val ui: ItemUi<Item>) : RecyclerView.ViewHolder(ui.root) {
        init {
            ui.root.layoutParams = root.layoutManager?.verticalListLayoutParams()
            ui.root.onClick { onItemClick(itemId) }
        }
    }
}

