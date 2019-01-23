import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;


//"publish" class is pubsub class; ignore the name

public class PubSub {

    public static HashMap <String, ArrayList<Integer>> hmap2 = new HashMap<String, ArrayList<Integer>>();
    public class Publisher{
    	public void publish(){
    		HashMap <Integer, ArrayList<String>> hmap = new HashMap<Integer, ArrayList<String>>();
    			ArrayList<Integer> id = new ArrayList<Integer>();
    			
    			int _id = 0;
    			@SuppressWarnings("resource")
    			Scanner s = new Scanner(System.in);
    			String check="";
    			String feed="";
    			ArrayList<Integer> subscribers = new ArrayList<Integer>();
    			int i=0;
    			for (i=0; i<1; i++)
    			{
    				System.out.println("Enter Publisher ID: ");
    				_id = s.nextInt();
    				id.add(_id);
    				//boolean b = true;
    				String topic = "";
    				do
    				{
    					// Code added by Arsalan:
    					System.out.println("Enter Publisher's topic: ");
    					topic=s.next();
    					System.out.println("Enter the feed: ");
    					s.nextLine();
    					feed = s.nextLine();
    					subscribers = Matcher.match(topic);
    					if(subscribers!=null) {
    						Notifier.notify(subscribers,feed,_id);
    					}
    					// ---------
    					System.out.println("Do you want to publish another topic? [Y] or [N] : ");
    					check=s.next();
    				} while(check.equals("Y"));
    											
    				
    			}
    			System.out.println(hmap);		
    	
    	}
    }
	
	public class Subscriber{
		
		public void subscribe(){
			
			ArrayList<Integer> existing = new ArrayList<Integer>();
			int _id2 = 0;
			@SuppressWarnings("resource")
			Scanner s2 = new Scanner(System.in);
			String check2="";
			int i2=0;
			for (i2=0; i2<1; i2++)
			{
				System.out.println("Enter Subscriber ID: ");
				_id2 = s2.nextInt();
				
				String topic = "";
				do
				{
					System.out.println("Enter Subscriber's topic of choice: ");
					topic=s2.next();
					if(hmap2.containsKey(topic))
					{
						existing = hmap2.get(topic);
						existing.add(_id2);
						hmap2.put(topic, existing);
					}
					else
					{
						existing = new ArrayList<Integer>();
						existing.add(_id2);
						hmap2.put(topic,existing);
					}				
					System.out.println("Do you want to subscribe to another topic? [Y] or [N] : ");
					check2=s2.next();
					
				} while(check2.equals("Y"));
							
			}
		
			System.out.println(hmap2);	
		}
	}

	 public static class Notifier{
		 	//notify class
			public static void notify(ArrayList<Integer> subscribers, String feed, int id) 
			{
				
				System.out.println("Feed available for subscribers:" + subscribers);
					
				System.out.println("Publisher : "+id);
				System.out.println("Feed : "+feed);
			}
	 }
	
	public static class Matcher{
		public static ArrayList<Integer> match(String topic) {		
			return(hmap2.get(topic));	
		}	
	}


	
	public static void main(String[] args) {	
		PubSub ps = new PubSub();
		Subscriber subscriber =  ps.new Subscriber();
		Publisher publisher = ps.new Publisher();
		int choice;
		int loop=1;
		Scanner s3 = new Scanner(System.in);
		while(loop!=0) {
			System.out.println("Do you want to [1]Publish or [2]Subscribe");
			choice = s3.nextInt();
			if(choice==1) {
				publisher.publish();
			}
			if(choice==2) {
				subscriber.subscribe();
			}
			System.out.println("Do you want to continue: [0] No [1] Yes");
			loop = s3.nextInt();
		}

	}

}