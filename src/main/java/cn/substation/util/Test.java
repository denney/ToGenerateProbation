package cn.substation.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {


        for (int i = 0; i <1 ; i++) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


            Calendar calendar=Calendar.getInstance();
            calendar.setTime(new Date());

        calendar.add(Calendar.YEAR,10);
//            calendar.add(Calendar.MONTH,i);
            Date date=calendar.getTime();


            String sout = EncryptUtil.DESencode(sdf.format(date), "1234567890");


            System.out.println(sout);
            String ss = EncryptUtil.DESdecode(sout, "1234567890");
            System.out.println(ss);

        }

    }
}

