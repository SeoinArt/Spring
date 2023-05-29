package com.ex;

// import static (static메서드, static 변수 앞에 클래스명을 생략하고 사용 가능)
import static com.mongodb.client.model.Filters.eq;
import static java.lang.System.out;
import static com.mongodb.client.model.Updates.*;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

public class MongojavaTest {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String db = "mdb";
		MongoClient mongoClient = null;
		MongoDatabase mongodb;
		MongoCollection<Document> collection = null;
		String collectionName = "posts"; // author, title, kind

		mongoClient = MongoClients.create("mongodb://localhost:27017");
		mongodb = mongoClient.getDatabase(db); // use mdb
		// dp.createCollection('post')
		// dp.posts.find()...
		collection = mongodb.getCollection(collectionName);

		//	insertOne(collection); insertOne
		//	select(collection); find()
		select(collection);
		//	find(collection);
		//	deleteOne(collection);
		//	deleteOne(collection);
		//	delete(collection);
		update(collection);
		out.println("수정 후 ==================");
		select(collection);
		mongoClient.close();

	}

	private static void update(MongoCollection<Document> col) {
		out.println("수정할 글의 author: ");
		String author = sc.nextLine();
		
		out.println("수정할 게시판 종류(Kind): ");
		String kind = sc.nextLine();
		
		out.println("수정할 Title: ");
		String title = sc.nextLine();
		
		out.println(author+", "+kind+", "+title);
		System.out.println("===============================");
		
		Bson filter = eq("author",author);
		//Bson edit = Updates.combine(set("title", title),set("kind", kind));
		Bson edit = combine(set("title",title),set("kind",kind));
		
		//UpdateResult res = col.updateOne(filter, edit);
		UpdateResult res = col.updateMany(filter, edit);
		long cnt = res.getModifiedCount();
		out.println(cnt+"개의 posts컬렉션의 도큐먼트 수정됨");
		
	}

	private static void delete(MongoCollection<Document> col) {
		out.println("삭제할 글의 author: ");
		String author = sc.nextLine();
		DeleteResult res = col.deleteMany(eq("author", author));
		long cnt = res.getDeletedCount();
		out.println(cnt + "개의 posts 컬렉션의 도큐먼트 삭제함");
		
	}// ~delete()

	private static void deleteOne(MongoCollection<Document> col) {
		out.println("삭제할 글의 author: ");
		String author = sc.nextLine();
		DeleteResult res = col.deleteOne(eq("author", author));
		long cnt = res.getDeletedCount();
		out.println(cnt + "개의 posts 컬렉션의 도큐먼트 삭제함");
		// 글은 3개이지만 가장 처음 만나는 도큐먼트를 삭제한다.
	}// ~deleteOne()

	private static void find(MongoCollection<Document> col) {
		System.out.println("검색할 author: ");

		String author = sc.nextLine();

		Bson filter = Filters.eq("author", author);

		FindIterable<Document> cursor = col.find(filter);

		MongoCursor<Document> mc = cursor.iterator();
		while (mc.hasNext()) {
			Document doc = mc.next();
			String kind = doc.getString("kind");
			String title = doc.getString("title");
			String author2 = (String) doc.get("author");

			Object id = doc.get("_id");
			Object oid = doc.getObjectId("_id");

			System.out.println(kind + "\t\t" + title + "\t\t\t" + author2 + "\t" + oid);
		}
	}

	private static void select(MongoCollection<Document> col) {
		FindIterable<Document> cursor = col.find();
		/*
		 * for(Document doc:cursor) { System.out.println(doc.toJson()); }
		 */
		MongoCursor<Document> mc = cursor.iterator();
		while (mc.hasNext()) {
			Document doc = mc.next();
			String kind = doc.getString("kind");
			String title = doc.getString("title");
			String author = (String) doc.get("author");

			Object id = doc.get("_id");
			Object oid = doc.getObjectId("_id");

			System.out.println(kind + "\t\t" + title + "\t\t\t" + author + "\t" + oid);
		}
		mc.close();
		System.out.println("=== 몽고DB 컬렉션 조회 성공 ===");
	}

	public static void insertOne(MongoCollection<Document> col) {
		System.out.println("Kind: ");
		String kind = sc.nextLine();

		System.out.println("author: ");
		String author = sc.nextLine();

		System.out.println("Title: ");
		String title = sc.nextLine();

		System.out.println(kind + ", " + author + ", " + title);

		Document doc = new Document("kind", kind).append("author", author).append("title", title);
		// key(필드명), value(데이터)

		InsertOneResult res = col.insertOne(doc);
		System.out.println(res.getInsertedId() + "id로 post컬렉션 저장함");

	}
}
