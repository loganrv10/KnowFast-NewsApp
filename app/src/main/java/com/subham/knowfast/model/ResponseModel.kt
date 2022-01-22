package com.subham.knowfast.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseModel(

	@field:SerializedName("totalResults")
	var totalResults: Int? = null,

	@field:SerializedName("articles")
	var articles: List<ArticlesItem?>? = null,

	@field:SerializedName("status")
	var status: String? = null
)

@Entity(tableName = "article")
data class ArticlesItem(

	@field:SerializedName("publishedAt")
	var publishedAt: String? = null,

	@field:SerializedName("author")
	var author: String? = null,

	@field:SerializedName("urlToImage")
	var urlToImage: String? = null,

	@field:SerializedName("description")
	var description: String? = null,

      @Embedded
	@field:SerializedName("source")
	var source: Source? = null,

	@field:SerializedName("title")
	var title: String? = null,

	@field:SerializedName("url")
	var url: String? = null,

	@field:SerializedName("content")
	var content: String? = null
):Serializable {
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "primaryKey")
	var primaryKey:Int? = null
}


data class Source(

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("id")
	var id: String? = null
):Serializable


@BindingAdapter("android:loadImage")                   // Q3 why binding here
fun loadImage(imageView: ImageView, url: String?) {
	if (url != null) {
		Glide.with(imageView).load(url).into(imageView)
	}            // why Gliding here
}
