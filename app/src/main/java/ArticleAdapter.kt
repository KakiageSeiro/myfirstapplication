import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.Article
import com.example.myfirstapplication.R

class ArticleAdapter(private val inflater: LayoutInflater) : ListAdapter<Article, ArticleAdapter.ViewHolder>(ArticleAdapter.diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(
            R.layout.item_article, parent, false
        )
        return ViewHolder(view)

    }

    //position 上から何番目のホルダーかを指定
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //データを取ってくる
        val article = getItem(position)
        //データの中身をViewにセットする
        holder.apply {
            titleText.text = article.title
            bodyText.text = article.body
        }
    }


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val titleText = item.findViewById<TextView>(R.id.text_title)
        val bodyText = item.findViewById<TextView>(R.id.text_body)
    }
}
