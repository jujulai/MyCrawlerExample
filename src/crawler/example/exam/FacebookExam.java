package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6/"
				+ "crazyck101/feed?fields=id,message,likes.limit(0).summary(total_count),reactions.limit(0).summary(total_count)"
				+ "&access_token=EAACEdEose0cBAEm8cf9HPTFbGOsQKaVhD4lcP5ZBlPsy0u4xaumME74rVaU1aUeJsKNZBA57xBcuUWyvmGnt3EJLr62GO97HG0UInQkOU4GH5HsOvzFmy9FcJuQiU0BAM4O8xGe0TwfZA2MCZCTHkXnc0e6w9VYQsH2I6ZBB8I4iXRgoBwOGWWbCThUZCfneIZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions,likes";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String reactions = data.select("reactions").text();

			String likes = data.select("likes").text();

			output += id + "," + reactions + ","+ likes +"\n";
		}

		System.out.println( output );
	} 
}
