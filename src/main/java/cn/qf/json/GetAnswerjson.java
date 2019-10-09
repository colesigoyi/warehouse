package cn.qf.json;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-10-08 19:30
 * @ desc:
 **/

public class GetAnswerjson extends UDF {
    public String evaluate(String json) {
        if(json.equals("{}"))return "";
        JSONObject jsonObject = JSONObject.parseObject(json);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        String js = "";
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            JSONObject jsonObject1 = JSONObject.parseObject(String.valueOf(next.getValue()));
            Object score = jsonObject1.get("score");
            if ("".equals(score)) {
                score = 0;
            }
            js =js + next.getKey()+ ":" + score + ",";
        }
        String substring = js.substring(0, js.length()-1);
        return substring;
    }
    @Test
    public void test(){
        System.out.println(evaluate("{\"842\":{\"useranswer\":\"3407|3408|3410\",\"score\":0},\"84" +
                "6\":{\"useranswer\":\"3411\",\"score\":2},\"847\":{\"useranswer\":\"3499\",\"score\":2" +
                "},\"848\":{\"useranswer\":\"3419\",\"score\":2},\"849\":{\"useranswer\":\"3423\",\"sco" +
                "re\":2},\"850\":{\"useranswer\":\"3505\",\"score\":2},\"851\":{\"useranswer\":\"3433\"," +
                "\"score\":2},\"854\":{\"useranswer\":\"3444\",\"score\":0},\"855\":{\"useranswer\":\"34" +
                "49\",\"score\":0},\"856\":{\"useranswer\":\"3451|3453\",\"score\":0},\"857\":{\"userans" +
                "wer\":\"3455|3456|3457\",\"score\":2},\"858\":{\"useranswer\":\"3459|3460|3461\",\"scor" +
                "e\":0},\"859\":{\"useranswer\":\"3463|3464\",\"score\":0},\"861\":{\"useranswer\":\"347" +
                "|3472|3473\",\"score\":0},\"862\":{\"useranswer\":\"3477\",\"score\":2},\"866\":{\"usera" +
                "nswer\":\"gulp.task()\",\"score\":0},\"867\":{\"useranswer\":\"gulp.src()\",\"score\":0}" +
                ",\"872\":{\"useranswer\":\"add .\",\"score\":0},\"873\":{\"useranswer\":\"clone（）\",\"" +
                "core\":0},\"875\":{\"useranswer\":\"touch\",\"score\":0}}"));
    }
}
