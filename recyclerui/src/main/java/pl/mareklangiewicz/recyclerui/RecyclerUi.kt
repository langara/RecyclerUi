package pl.mareklangiewicz.recyclerui

import android.annotation.SuppressLint
import android.content.Context
import splitties.views.dsl.core.Ui
import splitties.views.dsl.core.textView

@SuppressLint("SetTextI18n")
class RecyclerUi(override val ctx: Context) : Ui {
    override val root = textView { text = "TODO" }
}

