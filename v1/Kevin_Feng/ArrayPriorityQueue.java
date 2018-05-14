/*
Team Arrrrr - Calvin Aw and Kevin Feng
APCS2 pd08
HW 46 -- Arrr, There Be Priorities Here Matey
2018 - 05 - 09
*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{
    private ArrayList<String> ArrPQ;
    private String Al_data;

    public ArrayPriorityQueue(){
	ArrPQ = new ArrayList<String>();
    }

    public void add(String x){
	for (int i = 0; i < ArrPQ.size(); i++){
	    Al_data = ArrPQ.get(i);
	    if (Al_data.compareTo(x) >= 0){
		ArrPQ.add(i, x);
		break;
	    }
	}
	ArrPQ.add(x);
    }
    public boolean isEmpty(){
	return ArrPQ.size() == 0;
    }
    public String peekMin(){
	return ArrPQ.get(0);
    }
    public String removeMin(){
	return ArrPQ.remove(0);
    }

    public static void main(String[] args){
	ArrayPriorityQueue fun = new ArrayPriorityQueue();
	System.out.println("Is fun empty? " + fun.isEmpty());
	
	fun.add("foo");
	fun.add("goo");
	fun.add("hoo");
	fun.add("doo");

	System.out.println("min of fun: " + fun.peekMin());
	fun.removeMin();
	System.out.println("new min of fun: " + fun.peekMin());
    }
}
