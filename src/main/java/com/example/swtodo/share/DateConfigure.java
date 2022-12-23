package com.example.swtodo.share;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class DateConfigure {
    
    public String getToday(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        return sdf.format(c.getTime());
    }

    public int getDayDiff(Calendar endDay, Calendar startDay){
        long diffsec = (endDay.getTimeInMillis()-startDay.getTimeInMillis())/1000;
        return (int)(diffsec/24/60/60);
    }
    public boolean[] getIsDows(int freq){
        String bin = Integer.toBinaryString(freq);
        boolean[] result = new boolean[7];
        while(bin.length()<7){
            bin="0"+bin;
        }
        for (int i = 0; i < 7; i++) {
            char c = bin.charAt(i);
            if(c=='1') result[i] = true;
            else result[i] = false;
        }
        System.out.println(bin);
        for (boolean b : result) {
            System.out.println(b);
        }
        return result;

    }

}
