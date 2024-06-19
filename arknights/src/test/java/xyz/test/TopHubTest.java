package xyz.test;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangpeng
 * @since 2024年01月11日 09:32
 */
public class TopHubTest {

    public static void main(String[] args) throws JsonProcessingException {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "7890");

        Map<String, Object> params = new HashMap<>();
        params.put("c", "hot");
        params.put("t", "daily");
        String content = HttpUtil.post("https://tophub.today/do", params);
        JsonNode node = new ObjectMapper().readTree(content);;
        System.out.println(node);
        StringBuilder res = new StringBuilder();

//        List<Map<String, String>> map = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JsonNode item = node.get("data").get(i);
//            Map<String, String> itemMap = new HashMap<>();
//            itemMap.put(i + "、" + item.get("title\n"), item.get("description").asText() + "\n\n");
            res.append(i + 1).append("、").append(item.get("title")).append("\n");
            if (StringUtils.hasLength(item.get("description").asText())) {
                res.append(item.get("description").asText()).append("\n");
            }
            if (StringUtils.hasLength(item.get("url").asText())) {
                res.append(item.get("url").asText()).append("\n");
            }
            res.append("\n");
        }

        System.out.println(res);
    }
}
