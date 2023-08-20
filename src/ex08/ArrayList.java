package ex08;

public class ArrayList {
    private Object[] arrayList;
    private int count;
    public ArrayList(){
        count=0;
        arrayList=new Object[4];
    }

    public void reflexive(){
        ArrayList result;
        Object[] temp=new Object[arrayList.length];
        if(!(count==0||count==1)){
            if(count%2==0){
                for(int i=0;i<=count-1;i++){
                    temp[i]=arrayList[count-1-i];
                }
            }else{
                for(int i=0;i<=(count/2)-1;i++){
                    temp[i]=arrayList[count-1-i];
                }
                temp[count/2]=arrayList[count/2];
                for(int i=(count/2)+1;i<=count-1;i++){
                    temp[i]=arrayList[count-1-i];
                }
            }
        }
        arrayList=temp;
    }

    public void swap(ArrayList list){
        Object[] a=new Object[arrayList.length];
        ArrayList b=new ArrayList();
        for(int i=0;i<arrayList.length;i++){
            a[i]=arrayList[i];
        }
        for(int i=0;i<list.getLength();i++){
            b.set(i,list.get(i));
        }
        arrayList=a;
        list=b;
    }

    public void set(int idx,Object obj){
        arrayList[idx]=obj;
    }

    public boolean equals(ArrayList list){
        if(arrayList.length!=list.getLength()){
            return false;
        }
        if(count!= list.getCount()){
            return false;
        }
        for(int i=0;i<=count-1;i++){
            if(arrayList[i]!=list.get(i)){
                return false;
            }
        }
        return true;
    }

    public int getLength(){
        return arrayList.length;
    }
    public int getCount(){
        return count;
    }
    public boolean checkIndex(int idx){
        if(idx<0||idx>=arrayList.length) {
            return false;
        }else{
            return true;
        }
    }

    public Object get(int idx){
        if(idx<0||idx>=arrayList.length){
            return false;
        }else{
            return arrayList[idx];
        }
    }

    public void delete(int idx){
        Object[] temp=new Object[arrayList.length-1];
        for(int i=0;i<idx;i++){
            temp[i]=arrayList[i];
        }
        for(int i=idx;i<arrayList.length;i++){
            temp[i]=arrayList[i+1];
        }
        arrayList=temp;
        count--;
    }

    public void append(Object obj){
        if(count==arrayList.length){
            increaseSize();
        }
        arrayList[count]=obj;
        count++;
    }

    public void update(Object obj,int idx){
        arrayList[idx]=obj;
    }

    public void swapPosition(int idx,int idx2){
        Object a=arrayList[idx];
        arrayList[idx]=arrayList[idx2];
        arrayList[idx2]=a;
    }

    public void insert(Object obj,int idx){
        if(count==arrayList.length){
            increaseSize();
        }
        Object[] temp=new Object[arrayList.length+1];
        for(int i=0;i<idx;i++){
            temp[i]=arrayList[i];
        }
        temp[idx]=obj;
        for(int i=idx+1;i<=count;i++){
            temp[i+1]=arrayList[i];
        }
        arrayList=temp;
        count++;
    }

    public void increaseSize(){
        Object[] temp=new Object[arrayList.length*2];
        for(int i=0;i<arrayList.length;i++){
            temp[i]=arrayList[i];
        }
        arrayList=temp;
    }

}

//1、如果两个对象equals相等，那么这两个对象的HashCode一定也相同

//2、如果两个对象的HashCode相同，不代表两个对象就相同，只能说明这两个对象在散列存储结构中，存放于同一个位置
