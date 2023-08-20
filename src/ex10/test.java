package ex10;

public class test {
    public static void main(String[] args){
        List list=new List();
        //list添加
        list.addNode(19);
        list.addNode(1);
        list.addNode(3);
        list.addNode(4);
        list.addNode(9);
        list.addNode(7);
        list.insertNode(6,3);
        list.deleteNodeByN(6);
        //list.deleteHead();
        //list.deleteAllNodeByData(3);
        //list.deleteNodeByData(3);
        //System.out.println(list.linkSort().data);
        //System.out.println(list.findNode(5).data);
        //System.out.println(list.findReverNode(3).data);
        list.reserveLink();
        //list.removeRep();
        //list.insertNodeAtBefore(4,1000);
        list.printNode();
        System.out.println();
        //System.out.println(1913497%2022);
        //System.out.println(list.sumMod2022());

    }
}
