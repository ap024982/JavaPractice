package mongo;

import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;


public class TestMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] password={'p','a','s','s','w','o','r','d'};
		MongoCredential credential = MongoCredential.createCredential("admin","admin",password);
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost",8082),Arrays.asList(credential));
		DB database = mongoClient.getDB("mydb");
		DBCollection collection=database.getCollection("test");
		DBCursor cursor = collection.find();
	    while(cursor.hasNext())
	    {
	        System.out.println(cursor.next());
	    }

	}

}
