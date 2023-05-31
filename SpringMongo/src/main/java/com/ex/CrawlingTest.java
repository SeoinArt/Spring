package com.ex;

import java.io.IOException;
import java.util.Iterator;

/*
 * 파이썬 BeautifulSoup을 이용해 크롤링
 * Java에서는 Jsoup을 이용
 *
 * 라이브러리 다운로드: http://jsoup.org/download
 *
 * pom.xml에 Jsoup 라이브러리 등록 
 *    
  <!-- https://mvnrepository.com/artifact/org.jsoup/jsoup -->
  <dependency>
      <groupId>org.jsoup</groupId>
      <artifactId>jsoup</artifactId>
      <version>1.15.3</version>
  </dependency>
 
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.common.CommonUtil;

public class CrawlingTest {

	public static void main(String[] args) {

		// CGV 영화 순위를 가져오자
		String url = "http://www.cgv.co.kr/movies/?";
		// https://www.melon.com/chart/index.htm
		Document doc = null;

		try {
			// http 프로토콜만 가능. https 프로토콜은 보안상 안 된다
			doc = Jsoup.connect(url).get();

			// 해당 URL의 웹 이지의 전체 소스를 Document에 담아 반환
			//System.out.println(doc);
			

			// 이중에서 우리가 필요한 데이터만 추출해야 함
			Elements element = doc.select("div.sect-movie-chart");

			Elements rankEle = element.select("strong.rank");

			Iterator<Element> movie_rank = element.select("strong.rank").iterator();

			// 영화 제목
			Iterator<Element> movie_name = element.select("strong.title").iterator();

			// 영화 예매율
			Iterator<Element> movie_reserve = element.select("strong.percent span").iterator();

			// 영화 점수(eggs)
			Iterator<Element> movie_score = element.select("span.percent").iterator();

			// 개봉일
			Iterator<Element> open_day = element.select("span.txt-info strong").iterator();
			// System.out.println(open_day.next().toString());
			
			Iterator<Element> movie_img = element.select("span.thumb-image img").iterator();
			
			int cnt=1;
			while(movie_rank.hasNext()) {
				MovieVO vo = new MovieVO();
				vo.setMovie_rank(movie_rank.next().text());
				vo.setMovie_no(cnt++);
				vo.setMovie_name(movie_name.next().text());
				vo.setMovie_reserve(movie_reserve.next().text());
				vo.setMovie_score(movie_score.next().text());
				vo.setOpen_day(open_day.next().text().substring(0,10));
				vo.setRank_checkTime(CommonUtil.getDateTime("yyyy-MM-dd HH:mm:ss"));
				String imgUrl = movie_img.next().attr("src"); // 영화 이미지 경로
				vo.setMovie_image(imgUrl);
				//System.out.println("vo : "+vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}