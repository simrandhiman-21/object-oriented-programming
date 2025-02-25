public class CopyConstructor {

    String name;
    int age;
    

    CopyConstructor(String name,int age){
        this.name=name;
        this.age=age;
    }


    CopyConstructor(CopyConstructor other){
        this.name=other.name;
        this.age=other.age;
    }

    public void print(){
        System.out.println("Name -> "+name+" age -> "+age);
    }

    public static void main(String[] args) {

        CopyConstructor obj=new CopyConstructor("java",31);
        obj.print();

        CopyConstructor obj2=new CopyConstructor(obj);
        obj2.print();

        
        
    }
    
}
