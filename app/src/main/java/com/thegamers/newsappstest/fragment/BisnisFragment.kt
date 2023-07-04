package com.thegamers.newsappstest.fragment

import android.annotation.SuppressLint
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
import com.thegamers.newsappstest.utils.Constants.NEWS_CONTENT
import com.thegamers.newsappstest.utils.Constants.NEWS_DESCRIPTION
import com.thegamers.newsappstest.utils.Constants.NEWS_IMAGE_URL
import com.thegamers.newsappstest.utils.Constants.NEWS_PUBLICATION_TIME
import com.thegamers.newsappstest.utils.Constants.NEWS_SOURCE
import com.thegamers.newsappstest.utils.Constants.NEWS_TITLE
import com.thegamers.newsappstest.utils.Constants.NEWS_URL


class BisnisFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bisnis, container, false)
        val newsData: MutableList<NewsModel> = MainActivity.businessNews
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = CustomAdapter(newsData)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val intent = Intent(context, ReadNewsActivity::class.java).apply {
                    putExtra(NEWS_URL, newsData[position].url)
                    putExtra(NEWS_TITLE, newsData[position].headLine)
                    putExtra(NEWS_IMAGE_URL, newsData[position].image)
                    putExtra(NEWS_DESCRIPTION, newsData[position].description)
                    putExtra(NEWS_SOURCE, newsData[position].source)
                    putExtra(NEWS_PUBLICATION_TIME, newsData[position].time)
                    putExtra(NEWS_CONTENT, newsData[position].content)
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