package net.lzzy.algorithm;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class BusMap extends SimpleMap {
    private SparseArray<String>vertexes;
    private double minDistance;
    private int start,target;
    public BusMap(int v) {
        super(v);
        vertexes=new SparseArray<>();
        for (int i=0;i<v;i++){
            vertexes.append(i,String.valueOf(i));
        }
    }
    public void setStart(int start) {
        this.start = start;
    }

    public void setTarget(int target) {
        this.target = target;
    }
    public  void rename(int i,String name){
        vertexes.setValueAt(i,name);
    }
    //todo 1.深度优先的方法尝试从当前节点到目的地，记录路径长度
    private  void tryWay(int curVertex,double distance){
        if (minDistance>0 && distance>minDistance){
            return;
        }
        if (curVertex==target){
            if (minDistance==0||minDistance>distance){
                minDistance=distance;
            }
            return;
        }
        List<Edge>vEdges=getConnectedEdges(curVertex);
        for (Edge edge:vEdges){
            if (vidited.contains(edge.getTarget())){
                continue;
            }
            vidited.add(edge.getTarget());
            tryWay(edge.getTarget(),distance+edge.getDistance());
            vidited.remove(edge.getTarget());
        }
    }

    //todo 2.Floyo算法求最短路径（多源最短路径）
    private  double[][]floyd(){
        double[][]distances=new double[vertexCount][vertexCount];
        for (int i=0;i<vertexCount;i++){
            for (int j=0;j<vertexCount;j++){
                distances[i][j]=999999;
            }
        }
        for (Edge edge:edges){
            distances[edge.getSource()][edge.getTarget()]=edge.getDistance();
        }
        for (int k=0;k<vertexCount;k++){
            for (int i=0;i<vertexCount;i++){
                for (int j=0;i<vertexCount;j++){
                    if (distances[i][j]>distances[i][k]+distances[k][j]){
                        distances[i][j]=distances[i][k]+distances[k][j];
                    }
                }
            }
        }
        return  distances;
    }
    //todo 3.Dijkstra算法求最短路径（单源）
    private  double[]dikstra(int source){
        double[]distance=new double[vertexCount];
        for (int i=0;i<vertexCount;i++){
            distance[i]=999999;
        }
        distance[source]=0;
        List<Edge>vEdges=getConnectedEdges(source);
        for (Edge edge:vEdges){
            distance[edge.getTarget()]=edge.getDistance();
        }
        vidited.add(source);
        int shortVertex=source;
        for (int i=1;i<vertexCount;i++){
            double shortDistance=999999;
            for (int j=0;j<vertexCount;j++){
                if (vidited.contains(j)||distance[j]>=shortDistance){
                    continue;
                }
                shortDistance=distance[j];
                shortVertex=j;

            }
            vidited.add(shortVertex);
            List<Edge>shortVertexEdes=getConnectedEdges(shortVertex);
            for (Edge edge:shortVertexEdes){
                if (distance[edge.getTarget()]>distance[shortVertex]+edge.getDistance()){
                    distance[edge.getTarget()]=distance[shortVertex]+edge.getDistance();
                }
            }

        }
        return distance;

    }
    public  String getMinDistance(int key){
        vidited=new ArrayList<>();
        switch (key){
            case 0:
                tryWay(start,0);
                break;
            case 1:
                minDistance=floyd()[start][target];
                break;
            case 2:
                minDistance=dikstra(start)[target];
                break;
        }
        return  "从"+start+"到"+target+"的最短距离为"+minDistance;
    }



}