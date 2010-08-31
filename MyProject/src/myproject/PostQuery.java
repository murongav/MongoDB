package myproject;

import com.mongodb.*;

import java.util.*;

/**
 *
 * @author murongav
 */
public class PostQuery {
    public static void main(String []args)throws Exception {

    // connect to the local database server
        Mongo m = new Mongo();

   // switch to the database that you would like to use
        DB db = m.getDB ("MyProject");

  // Get a list of collections in this database and print them out

        Set<String> colls = db.getCollectionNames();
       for (String s : colls){
            System.out.println(s);
        }

        //get the "blog" collection to work with
        DBCollection coll = db.getCollection("blog_dbms");
       
//1. View all the posts wrtten by a given author
    BasicDBObject  query = new BasicDBObject();
    query.put("author.firstname","veiko");
    DBCursor cur = coll.find(query);
    while (cur.hasNext()){
     System.out.println(cur.next());
    }

 //2. View all the tags attached to a post
       query = new BasicDBObject();
       query.put("blog-id",1);
       cur =  coll.find(query);
       DBObject db_obj=null;
       while (cur.hasNext()){
       db_obj=cur.next();
       System.out.println("post"+db_obj.get("post"));
       System.out.println("tags"+db_obj.get("tags"));
      
        }

//3. View all the comments readers submitted to a post
       query = new BasicDBObject();
       query.put("blog-id",1);
       cur =  coll.find(query);
       db_obj=null;
       while (cur.hasNext()){
       db_obj=cur.next();
       System.out.println("post"+db_obj.get("post"));
       System.out.println("comments"+db_obj.get("comments"));

        }

//4. Add new comments to a post
      DBObject blog1 = coll.findOne();
      System.out.println(blog1.get("_id"));


      DBObject blogid = BasicDBObjectBuilder.start()
            .add("4c14c691cd480000000033f2",blog1.get("4c14c691cd480000000033f2")).get();
       DBObject comment = BasicDBObjectBuilder.start()
            .push("commentator4")
            .append("firstname","danny")
            .append("lastname","greco")
            .append("address","78,sando road,WHK")
            .pop()
            .append("comment","Everyone is affected by MongoDB").get();

       DBObject addComment = new BasicDBObject("$push",new BasicDBObject("comments",comment));
       coll.update(blogid, addComment);


        //5. add new tags to a post
           DBObject blogid1 = BasicDBObjectBuilder.start()
           .add("4c14c691cd480000000033f2",blog1.get("4c14c691cd480000000033f2")).get();
           DBObject addTag = new BasicDBObject("$push",new BasicDBObject("tags","DBList"));
           coll.update(blogid1, addTag);

    }

}
