package pl.mg6maciej.funthingsyoucandoinkotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class MyAdapter(private val data: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun appendData(data: List<String>) {
        throw UnsupportedOperationException()
    }

    override fun getItemCount(): Int {
        throw UnsupportedOperationException()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        throw UnsupportedOperationException()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        throw UnsupportedOperationException()
    }
}
