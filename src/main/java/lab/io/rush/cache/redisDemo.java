package lab.io.rush.cache;

import redis.clients.jedis.Jedis;

public class redisDemo {
	public static void main(String []args){
	 Jedis jedis = new Jedis("localhost");
     System.out.println("Connection to server sucessfully");
     //查看服务是否运行
     System.out.println("Server is running: "+jedis.ping());
     	
	
	}
}