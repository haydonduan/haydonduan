import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;




public class Test {
    /*public static void main(String a[]) {
        List<? super A> list1 = new ArrayList<A>();
        list1.add(new Mydate());
        A a1 = (A) list1.get(0);
        System.out.println();
        System.out.println("? extends A length:"+list1.size());
        
        
        
        List<? extends A> list = new ArrayList<A>();
        System.out.println("? extends A length:"+list.size());
    }*/
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<Student> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            Student s = new Student();
            s.setId(i);
            s.setName("wang" + i);
            list.add(s);
        }
        System.out.println("以下为生成的json：");
        System.out.println(gson.toJson(list));
        
        
        List<Student> ps = gson.fromJson(gson.toJson(list), new TypeToken<List<Student>>(){}.getType());
        System.out.println("以下为反序列结果：");
        for(Student stu : ps){
            System.out.println("id:"+stu.getId()+",name:"+stu.getName());
        }
        System.out.println();
    }
}

