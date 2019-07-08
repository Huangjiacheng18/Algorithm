package net.lzzy.algorithm.algorlib;

import java.util.ArrayList;
import java.util.List;



public class SimplrMap  {
    int vertexCount;
    List<Edge>edges=new ArrayList<>();
    public SimplrMap(int v){
        vertexCount=v;
    }
    public void  addEdge(int source,int target,double distance){
        edges.add(new Edge(source,target,distance));
    }
    public void addTwoWayEdge(int v1,int v2,double d1){
        addEdge(v1,v2,d1);
        addEdge(v2,v1,d1);

    }

}
class Edge{
    private int source;
    private int target;
    private double distance;
    Edge(int source,int target,double distance){
        this.distance=distance;
        this.source=source;
        this.target=target;
    }
    public int getSource(){
        return source;
    }
    public double getDistance(){
        return distance;
    }
    public int getTarget(){
        return target;
    }

}