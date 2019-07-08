package net.lzzy.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
//--------

public class SimpleMap  {
    int vertexCount;
    List<Edge>edges=new ArrayList<>();
    List<Integer>vidited;
    public SimpleMap(int v){
        vertexCount=v;
    }
    public void  addEdge(int source,int target,double distance){
        edges.add(new Edge(source,target,distance));
    }
    public void addTwoWayEdge(int v1,int v2,double d1){
        addEdge(v1,v2,d1);
        addEdge(v2,v1,d1);
    }
    List<Edge>getConnectedEdges(int source){
        List<Edge>result=new ArrayList<>();
        for (Edge e:edges){
            if (e.getSource()==source){
                result.add(e);
            }
        }
        return result;
    }
    private void iterateDepth(int v){
        if (!vidited.contains(v)){
            vidited.add(v);
        }
        if (vidited.size()==vertexCount){
            return;
        }
        List<Edge>vEdges=getConnectedEdges(v);
        for (Edge edge:vEdges){
            if (vidited.contains(edge.getTarget())){
                continue;
            }
            iterateDepth(edge.getTarget());
        }
    }
    public  String iterateDEpthFirst(){
        vidited=new ArrayList<>();
        iterateDepth(0);
        StringBuilder result=new StringBuilder();
        for (int v:vidited){
            result.append(v).append(",");
        }
        return  result.toString();
    }

    public  String iterateRangeFirst(){
//        return "012354";
        StringBuilder result=new StringBuilder();
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(0);
        int head=0,tail=1;
        while (head<tail){
            Integer cursor=queue.poll();
            if (cursor==null){
                break;
            }
            result.append(cursor).append(",");
            List<Edge>vEdges=getConnectedEdges(cursor);
            for (Edge edge:vEdges){
                if (!queue.contains(edge.getTarget())){
                    queue.offer(edge.getTarget());
                    tail++;
                }
                if (tail>vertexCount){
                    break;
                }
            }
            head++;
        }
        while (queue.size()>0){
            result.append(queue.poll()).append(",");
        }
        return  result.toString();

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