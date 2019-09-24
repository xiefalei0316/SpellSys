package seckill.utils;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @Author Lei
 * @Date 2019-9-20 22:16
 */
@Component
public class StrTimeSecond {

    public long getSecond(String time1,String time2){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime s1 = LocalDateTime.parse(time1,formatter);
        LocalDateTime s2 = LocalDateTime.parse(time2,formatter);


        Duration duration = Duration.between(s1,s2);

        return duration.getSeconds();

    }
}
