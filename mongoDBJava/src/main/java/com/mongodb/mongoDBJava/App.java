package com.mongodb.mongoDBJava;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

public class App 
{
    @SuppressWarnings("deprecation")
    public static void main( String[] args ) throws UnknownHostException, MongoException{
        MongoURI mu = new MongoURI("mongodb://127.0.0.1:20144");
        Mongo mongo = new Mongo(mu);
        DB db =  mongo.getDB("fenpian");
        DBCollection collection =  db.getCollection("person");
        //insert(collection);
        queryLimit(collection);
        //delete(collection);
        //update(collection);
        //query option 
        //queryOption(collection);
    }
    public static void delete(DBCollection collection){
        DBObject dbObject = new BasicDBObject();
        dbObject.put("name", "段海庆");
        System.out.println(collection.remove(dbObject).getN());
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void queryLimit(DBCollection collection){
        //不显示_id行,只显示name行
        Map map = new HashMap<String, Boolean>();
        map.put("_id", false);
        map.put("name", true);
        //使用大于小于   find(new BasicDBObject("age", new BasicDBObject("$lte", 24)))
        //使用in find(new BasicDBObject("age", new BasicDBObject(QueryOperators.IN, new int[] { 25, 26, 27 })))
        
        //方法1
        DBCursor dc = collection.find(null,new BasicDBObject(map)).sort(new BasicDBObject().append("name", true)).limit(4);
        while(dc.hasNext()){
            System.out.println(dc.next().get("name"));
        }
        
       /* //方法2
        List<DBObject> list = collection.find(null,new BasicDBObject(map)).limit(4).toArray();
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i).get("name"));
        }*/
    }
    public static void insert(DBCollection collection){
        DBObject dbObject = new BasicDBObject();
        dbObject.put("name", "段海庆");
        System.out.println("影响行数:" + collection.insert(dbObject).getN());  //注意 insert 和 save 
    }
    public static void update(DBCollection collection){
        //System.out.println("修改：" + collection.update(new BasicDBObject("_id", new ObjectId("4dde25d06be7c53ffbd70906")), new BasicDBObject("age", 99)).getN());
       for(int i=1;i<100;i++){
           System.out.println("gengxin:"+collection.update(
                   new BasicDBObject("name", "my name is "+i), 
                   new BasicDBObject("age", i),
                   true,//如果数据库不存在，是否添加
                   false//多条修改
                   ).getN());
       }
       System.out.println("end");
       /* System.out.println("修改：" + collection.update(
                new BasicDBObject("name", "haha"), 
                new BasicDBObject("name", "dingding"),
                true,//如果数据库不存在，是否添加
                true//false只修改第一天，true如果有多条就不修改
                ).getN());*/
        //当数据库不存在就不修改、不添加数据，当多条数据就不修改
        //System.out.println("修改多条：" + coll.updateMulti(new BasicDBObject("_id", new ObjectId("4dde23616be7c19df07db42c")), new BasicDBObject("name", "199")));
    }
    public static void queryOption(DBCollection collection){
        System.out.println("查询age in 25/26/27：" + collection.find(new BasicDBObject("age", new BasicDBObject("$ne", 25))).toArray());
    }
}
