package com.e.vilinks.ui.listTopics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.vilinks.model.LinksTopics
import com.e.vilinks.R
import kotlinx.android.synthetic.main.item_topic_viewholder.view.*


class TitleTopicsAdapter(private val titleListTopics: ArrayList<LinksTopics>, val clickListener: linksTopicListener) : RecyclerView.Adapter<TitleTopicsAdapter.LinkViewHolder>() {

    interface linksTopicListener {
        fun onTitleTopicClick(list: LinksTopics)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topic_viewholder, parent, false)
        return LinkViewHolder(view)
    }

    override fun getItemCount() = titleListTopics.size

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        holder.topicPosition.text = (position + 1).toString()
        holder.topicName.text = titleListTopics[position].name
        holder.itemView.setOnClickListener {
            clickListener.onTitleTopicClick(titleListTopics[position])
        }
    }

    fun addList(item: LinksTopics){
        titleListTopics.add(item)
        notifyItemInserted(titleListTopics.size - 1)
    }

    class LinkViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var topicPosition = itemView.itemNumber
        var topicName = itemView.itemTopic

    }
}