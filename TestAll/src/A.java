import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
    /*test method*/
    public static void test1(String regex,String... input){
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        for(int i=0;i < input.length;i++){
            matcher = pattern.matcher(input[i]);
            while(matcher.find()){
                System.out.println("result:"+matcher.group());
            }
        }
    }
    
    /*main method*/
    public static void main(String[] args) {
        //test1("^\\d{2,3}$","2222");
        //test1("\\bt","t dt");
        //test1("\\bt+","attttt");
        //test1("\\d{2}-\\d{3}","212-1231"); // 待处理
        //test1("\\b\\\\*","tdadf"); // 待处理
        //test1("18\\d{3}","18111");
        //(010)88886666，或022-22334455， 或02912345678
        //test1("\\(?0\\d{2}\\)?\\d{2}","(010)-11");
        //test1("\\S+","dddd cccc "); //匹配不包含空白符的字符串
        //test1("<a href='\\w*'>\\w*</a>","<a href='dddds'>d1D</a>"); //匹配a 标签
        //test1("\\W","d*u)a^n#");
        
        /*String[] a = {"(012)21","0123-2","01234-2"};
        test1("\\(0\\d{1,2}\\)[-]?\\d{2}|0\\d{3}-\\d{1}",a);*/
        
        //test1("(\\d{2}){2}","121212");
        
       // test1("\\d+[.]?\\d+\\sx\\s\\d+[.]?\\d+\\s+(cm|m)","12.0 x 12 cm");
        //test1("\\b(?<name>\\d{2}\\w?)\\w?\\k<name>\\b","12.0 x 12 cm");
        test1("\\s*\\S*\\/\\s*\\S*","dfdsf//asd");
        test1("\\s*\\S*\\/\\s*\\S*","dfdsf//asdddddddd");
    }
}
