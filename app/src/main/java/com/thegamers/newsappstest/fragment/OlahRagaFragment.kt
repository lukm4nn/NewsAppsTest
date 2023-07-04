package com.thegamers.newsappstest.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapters.CustomAdapter
import com.thegamers.newsappstest.MainActivity
import com.thegamers.newsappstest.R
import com.thegamers.newsappstest.entity.NewsModel
import com.thegamers.newsappstest.readnews.ReadNewsActivity
import com.thegamers.newsappstest.utils.Constants


class OlahRagaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_olah_raga, container, false)
        val newsData: MutableList<NewsModel> = MainActivity.scienceNews
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = CustomAdapter(newsData)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {

                val intent = Intent(context, ReadNewsActivity::class.java).apply {
                    putExtra(Constants.NEWS_URL, newsData[position].url)
                    putExtra(Constants.NEWS_TITLE, newsData[position].headLine)
                    putExtra(Constants.NEWS_IMAGE_URL, newsData[position].image)
                    putExtra(Constants.NEWS_DESCRIPTION, newsData[position].description)
                    putExtra(Constants.NEWS_SOURCE, newsData[position].source)
                    putExtra(Constants.NEWS_PUBLICATION_TIME, newsData[position].time)
                    putExtra(Constants.NEWS_CONTENT, newsData[position].content)
                }

                startActivity(intent)
            }
        })

        // Ignore
        adapter.setOnItemLongClickListener(object : CustomAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int) = Unit
        })

        return view
    }


}