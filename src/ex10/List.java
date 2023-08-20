package ex10;

public class List {
    private ListNode head;

    //1.添加头节点
    public void addHeadNode(int data){
        head=new ListNode(data,head);
    }

    //2.插入一个节点到链表尾部
    public void addNode(int data){
        //判断链表是否为空
        if(head==null){
            head=new ListNode(data,head);
        }else{
            ListNode p=head;
            while(p.link!=null){//寻找尾节点
                p=p.link;
            }
            //此时p为尾节点
            p.link=new ListNode(data,p.link);
        }
    }

    //3.指定位置插入,插入后为n号结点，找n-1号结点(链表位置从0开始 0为头节点）
    public void insertNode(int n,int data){
        int length=0;
        ListNode p=head;
        while(p!=null){
            length++;
            p=p.link;
        }
        //判断插入位置是否合法
        if(n<0||n>length){
            System.out.println("Error!");
            return;
        }
        //判断是否在头节点插入
        if(n==0){
            head=new ListNode(data,head);
        }
        //判断是否为链表尾部插入
        else if(n==length){
            p=head;
            while(p.link!=null){
                p=p.link;
            }
            p.link=new ListNode(data,p.link);
        }else {
                p=head;
                for(int i=0;i<n-1;i++){//p从0走n-1步,到n-1号位置
                    p=p.link;
                }
                p.link=new ListNode(data,p.link);
            }
        }


    //4.删除指定位置n的节点(链表位置从0开始 0为头节点）
    public void deleteNodeByN(int n){
        int length=0;
        ListNode p=head;
        while(p!=null){
            p=p.link;
            length++;
        }
        if(n<0||n>=length){
            System.out.println("Error!");
            return;
        }
        //判断是否为删除头节点
        if(n==0){
            head=head.link;
        }else{
            p=head;
            for(int i=0;i<n-1;i++){
                p=p.link;
            }
            p.link=p.link.link;
        }
    }

    //5.删除data为data的所有节点
    public void deleteAllNodeByData(int data){
        //判断链表是否为空
        if(head==null){
            System.out.println("Error!");
            return;
        }
        //判断是否为头节点删除
        if(head.data==data){
            head=head.link;
        }
        ListNode p=head;
        //未到达链表尾部就继续找
        while(p.link!=null){
            if(p.link.data==data){
                p.link=p.link.link;
            }
            if(p.link!=null){
                p=p.link;
            }
        }
    }

    //6.删除data为data的第一个节点
    public void deleteNodeByData(int data){
        //判断链表是否为空
        if(head==null){
            System.out.println("Error!");
            return;
        }
        //判断是否为头节点删除
        if(head.data==data){
            head=head.link;
        }
        ListNode p=head;
        //未到达链表尾部且下一个值为目标值
        while(p.link!=null&&p.link.data!=data){
            p=p.link;
        }
        if(p.link==null){//说明链表到达尾部仍未找到目标节点
            return;
        }else{
            p.link=p.link.link;
        }
    }

    //7.对链表节点排序（从小到大）并返回排序后的头节点（采用选择排序）
    public ListNode linkSort(){
        ListNode p=head;
        int temp;
        while(p.link!=null){
            ListNode next=p.link;
            while(next!=null){
                if(next.data<p.data){
                    temp=p.data;
                    p.data=next.data;
                    next.data=temp;
                }
                next=next.link;
            }
            p=p.link;
        }
        return head;
    }


    //8.获取链表长度
    public int length(){
        int length=0;
        ListNode p=head;
        while(p!=null){
            length++;
            p=p.link;
        }
        return length;
    }

    //9.打印节点
    public void printNode() {
        if(head==null){
            System.out.print("");
        }else{
            ListNode p=head;
            while(p!=null){
                System.out.print(p.data+" ");
                p=p.link;
            }
        }
    }

    //10.查找正数第k个元素(从1开始,头节点算是第一个）
    public ListNode findNode(int k){
        ListNode p=head;
        //判断插入位置是否合法
        int length=0;
        while(p!=null){
            length++;
            p=p.link;
        }
        if(k<=0||k>length){
            System.out.println("Error!");
            return null;
        }
        p=head;
        for(int i=0;i<k-1;i++){
            p=p.link;
        }
        return p;
    }

    //11.查找倒数第k个元素----法一：转化为正数第length-k+1个  法二：如下
    public ListNode findReverNode(int k){
        ListNode p=head;
        //判断插入位置是否合法
        int length=0;
        while(p!=null){
            length++;
            p=p.link;
        }
        if(k<=0||k>length){
            System.out.println("Error!");
            return null;
        }
        ListNode first=head;
        ListNode second=head;
        //first到达正数第k处
        for(int i=0;i<k;i++){
            first=first.link;
        }
        //first从正数第k处到链表尾节点相当于second从头节点开始到倒数第k处
        while(first!=null){
            second=second.link;
            first=first.link;
        }
        return  second;
    }

    //12.反转链表
    public void reserveLink(){
        ListNode prev=null;//指向前一个节点
        ListNode curr=head;
        ListNode next;
        while(curr!=null){//从头节点到尾节点
            next=curr.link;//先保存下一个节点
            curr.link=prev;//使当前节点指向前一个结点
            prev=curr;//前一个结点右移
            curr=next;//当前节点移向下一个节点
        }
        head=prev;//更新头节点
    }
    //13.寻找单链表的中间节点
    /*
    方法一：先求出链表的长度，再遍历1/2链表长度，寻找出链表的中间结点
    方法二：
        用两个指针遍历链表，一个快指针、一个慢指针，
        快指针每次向前移动2个结点，慢指针一次向前移动一个结点，
        当快指针移动到链表的末尾，慢指针所在的位置即为中间结点所在的位置
     */
    //假设链表长度为奇数
    public ListNode findMiddleNode(){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.link!=null){
            fast=fast.link.link;
            slow=slow.link;
        }
        return slow;
    }

    //14.返回尾节点
    public ListNode findLastNode(){
        ListNode p=head;
        while(p.link!=null){
            p=p.link;
        }
        return p;
    }

    //15.在不知道头结点的情况下删除指定节点
    /*
    删除结点的重点在于找出其前结点，使其前结点的指针指向其后结点，即跳过待删除结点n.link=n.link.link;
    1、如果待删除的结点是尾结点，由于单链表不知道其前结点，没有办法删除
    2、如果删除的结点不是尾结点，则将其该结点的值(n.data)与下一结点交换(n.link.data)，然后该结点的指针指向下一结点的后续结点(即删除n.link)
    （将目标节点转化为目标节点的前节点）
     */
    public void deleteSpecialNode(ListNode n){
        //n为尾节点
        if(n.link==null){
            System.out.println("Error!");
        }else{
            n.data=n.link.data;
            n.link=n.link.link;
        }
    }

    //16.两个有序链表排序（从小到大）
    //n1 n2 为两个链表的头结点
    public ListNode mergeTwoLists(ListNode n1,ListNode n2){
        if(n1==null){
            return n2;
        }else if(n2==null){
            return n1;
        }else{
            //先确定头结点
            if(n1.data>n2.data){
                head=n2;
                n2=n2.link;
            }else{
                head=n1;
                n1=n1.link;
            }
            ListNode p=head;
            //n1和n2都没有到达尾节点
            while(n1!=null&&n2!=null){
                if(n1.data>n2.data){
                    p.link=n2;
                    n2=n2.link;
                }else{
                    p.link=n1;
                    n1=n1.link;
                }
                p=p.link;
            }
            if(n1==null){
                p.link=n2;
            }else{
                p.link=n1;
            }
            return head;
        }
    }

    //17.去重
    public void removeRep(){
        ListNode one=head;//one作为标杆，寻找并删除和one的data相同的节点
        ListNode prev;//指向two的前一个节点
        ListNode two;
        //one从头节点到尾节点
        while(one!=null){
            prev=one;
            two=one.link;
            //two从此one指向节点的下一个节点开始遍历寻找是否有重复节点，有则删除
            while(two!=null){
                if(one.data==two.data){
                    //或者：
                    //prev.link=two.link;
                    //two=two.link;
                    two=two.link;
                    prev.link=two;
                }else{
                    two=two.link;
                    prev=prev.link;
                }
            }
            one=one.link;
        }
    }

    //18.取模（取余） 以对2022取模为例
    public int sumMod2022(){
        ListNode p=head;
        int answer=0;
        if(p==null){
            return 0;
        }else if(p.link==null){
            return p.data;
        }else{
            while (p != null) {
                answer=(answer*10+p.data)%2022;
                p=p.link;
            }
        }
        return answer;
    }

    //19.寻找一个链表的节点中第一个 data 数值等于 value 的节点，并在此节点之前插入一个新的节点，
    //其 data 的数值为 newData。如找不到这样的节点，则链表维持不变。额外空间复杂度为 O(1)
    public void insertNodeAtBefore(int value,int newData){
        //是否为空链表
        if(head==null){
            return;
        }
        //头节点前插入
        if(head.data==value){
            head=new ListNode(newData,head);
            return;
        }
        ListNode p=head;
        while(p.link!=null&&p.link.data!=value){
            p=p.link;
        }
        if(p.link==null){
            return;
        }else{
            p.link=new ListNode(newData,p.link);
        }
    }

    //20.删除头结点
    public void deleteHead(){
        head=head.link;
    }

}

