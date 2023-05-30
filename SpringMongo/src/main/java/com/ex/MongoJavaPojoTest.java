package com.ex;


///////////////////////////////////////////////////////////////////////////////
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.not;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
///////////////////////////////////////////////////////////////////////////////
// static import
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
public class MongoJavaPojoTest {
	static Scanner sc = new Scanner(System.in);
	
	String db ="mdb";
	String colName = "posts";
	MongoClient mClient;
	MongoDatabase mdb;
	MongoCollection<PostsVO> collection;
	
	public MongoJavaPojoTest() {
		mappingPojo();
	}
	
	/** 코덱 레지스토리를 사용해서 Bson Document를 Java Pojo로 매핑하는 메서드 
	 * 	Bson데이터를 자바 POJO객체로 인코딩, 디코딩하는 기능을 하도록 설정하는 메서드
	 * */
	
	public void mappingPojo() {
		ConnectionString conStr = new ConnectionString("mongodb://localhost:27017");
		CodecRegistry pojoCodecResgstry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),pojoCodecResgstry);
		
		MongoClientSettings clientSettings = MongoClientSettings.builder()
				.applyConnectionString(conStr)
				.codecRegistry(codecRegistry)
				.build();
		mClient = MongoClients.create(clientSettings);
		
		mdb = mClient.getDatabase(db); // mdb
	}
	
	private List<PostsVO> makeList(FindIterable<PostsVO> cursor) {
		List<PostsVO> arr = new ArrayList<>();
		if(cursor!=null) {
			MongoCursor<PostsVO> mc = cursor.iterator();
			while(mc.hasNext()) {
				PostsVO vo = mc.next();
				arr.add(vo);
			}
		}
		return arr;
	}
	
	
	public List<PostsVO> selectAll() {
		collection = mdb.getCollection(colName,PostsVO.class);
		FindIterable<PostsVO> cursor = collection.find();
		List<PostsVO> arr = makeList(cursor);
		return arr;
	}
	
	
	private void insertOne() {
		collection =  mdb.getCollection(colName,PostsVO.class);
		
		System.out.println("Kind: ");
		String kind = sc.nextLine();

		System.out.println("author: ");
		String author = sc.nextLine();

		System.out.println("Title: ");
		String title = sc.nextLine();

		PostsVO vo = new PostsVO(null, author, kind , title	);
		
		InsertOneResult res =collection.insertOne(vo);
		
		System.out.println(res.getInsertedId()+"Insert OK!!");
	}
	
	private void insertMany() {
		collection = mdb.getCollection(colName,PostsVO.class);
		List<PostsVO> posts = Arrays.asList(
				new PostsVO(null,"김작가","자유게시판", "자유롭게 글을 씁니다"),
				new PostsVO(null,"이미나","자유게시판", "Have a nice day!!"),
				new PostsVO(null,"홍길동","자유게시판", "저도 자유롭게 글을 씁니다")
				);
		InsertManyResult res = collection.insertMany(posts);
		System.out.println(res.getInsertedIds()+"InsertMany OK!!");
	}
	private void deleteOne() {
		System.out.println("삭제할 글의 author를 입력하세요");
		String author = sc.nextLine();
		Bson filter = eq("author", author);
		
		collection = mdb.getCollection(colName,PostsVO.class);
		DeleteResult res = collection.deleteOne(filter);
		System.out.println(res.getDeletedCount()+"개의 posts글을 삭제했어요");
	}
	
	private void deleteMany() {
		System.out.println("삭제할 글의 author를 입력하세요");
		String author = sc.nextLine();
		
		collection = mdb.getCollection(colName,PostsVO.class);
		DeleteResult res = collection.deleteMany(eq("author", author));
		System.out.println(res.getDeletedCount()+"개의 posts 글을 삭제했어요");
	}
	
	private void updateOne() {
		System.out.println("수정할 글의 Author: ");
		String author = sc.nextLine();
		
		System.out.println("수정할 글의 Title: ");
		String title = sc.nextLine();
		
		System.out.println("수정할 글의 Kind: ");
		String kind = sc.nextLine();
		
		collection = mdb.getCollection(colName,PostsVO.class);
		UpdateResult res = collection.updateOne(eq("author",author), combine(set("title",title),set("kind",kind)));
		System.out.println(res.getModifiedCount()+"개의 글을 수정했어요");
	}// ~updateOne()
	
	
	
	// kind가 아닌 자유게시판이 아닌 posts글의 kind를 QnA로 수정하세요
	private void updateMany() {	
		collection = mdb.getCollection(colName,PostsVO.class);
		long cnt = collection.updateMany(not(eq("kind","자유게시판")), set("kind","QnA")).getModifiedCount();
		System.out.println(cnt+"개의 글을 수정했어요");
	}// ~updateMany()
	
	
	private void updateReplace() {
		System.out.println("수정할 글의 Author: ");
		String author = sc.nextLine();
		
		System.out.println("수정할 글의 Title: ");
		String title = sc.nextLine();
		
		System.out.println("수정할 글의 Kind: ");
		String kind = sc.nextLine();
		
		PostsVO vo = new PostsVO(null,author,kind,title);
		
		collection = mdb.getCollection(colName,PostsVO.class);
		long cnt = collection.replaceOne(eq("author",author), vo).getModifiedCount();
		System.out.println(cnt+"개의 posts 글을 수정했습니다.");
		
	}// ~updateReplace()
	
	public void printPosts(List<PostsVO> arr) {
		System.out.println("======================================================================================================");
		for(PostsVO vo : arr) {
			System.out.println(vo);
		}
		System.out.println("======================================================================================================");
	}
	
	public static void main(String[] args) {
		MongoJavaPojoTest app = new MongoJavaPojoTest();
		List<PostsVO> arr = app.selectAll();
		app.printPosts(arr);
		//app.insertOne();
		//app.insertMany();
		//app.deleteOne();
		//app.deleteMany();
		//System.out.println("::: 삭제 후 ::: ");
		//arr =app.selectAll();
		//System.out.println(arr);
		//app.updateOne();
		//app.updateReplace();
		//app.updateMany();
		/*
		 * List<PostsVO> arr2 = app.selectAll(); app.printPosts(arr2);
		 */
		app.searchMany();
	}

	private void searchMany() {
		System.out.println("검색어를 입력하세요");
		String key = sc.nextLine();
		collection = mdb.getCollection(colName,PostsVO.class);
		Pattern pattern = Pattern.compile(key,Pattern.CASE_INSENSITIVE);
		
		Bson filter = Filters.regex("title", pattern);
		
		FindIterable<PostsVO> cursor =collection.find(filter);
		List<PostsVO> arr = makeList(cursor);
		
		printPosts(arr);
	}
}
