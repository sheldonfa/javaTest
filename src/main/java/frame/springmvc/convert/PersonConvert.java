package frame.springmvc.convert;

import com.alibaba.druid.support.json.JSONUtils;
import frame.pojo.Person;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2016/11/21.
 */
public class PersonConvert implements Converter<String,Person>{
    @Override
    public Person convert(String s) {

        System.out.println(s);

        return null;
    }
}
