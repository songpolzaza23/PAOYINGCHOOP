package buu.informatics.s59160092.paoyingchoop

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160092.paoyingchoop.database.History

class HistoryAdapter : RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<History>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent , false) as TextView
        return  TextItemViewHolder(view)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.namePlayer1 + " VS " + item.namePlayer2 + " SCORE " + item.scorePlayer1 + " : " + item.scorePlayer2
    }
}