package cn.substation.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        Set<String> set=new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        set.add("10");
        set.add("11");
        set.add("12");




            if (set.contains(args[0])) {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(new Date());

//        calendar.add(Calendar.YEAR,-1);
                calendar.add(Calendar.MONTH,1);
                Date date=calendar.getTime();


                String sout = EncryptUtil.DESencode(sdf.format(date), "1234567890");
                System.out.println(sout);
                String ss = EncryptUtil.DESdecode(sout, "1234567890");
                System.out.println(ss);

            }





    }
}
