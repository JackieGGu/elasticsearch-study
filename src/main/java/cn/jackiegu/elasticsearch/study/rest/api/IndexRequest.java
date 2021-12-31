package cn.jackiegu.elasticsearch.study.rest.api;

import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;
import cn.jackiegu.elasticsearch.study.util.LoggerUtil;
import org.junit.Test;

/**
 * 索引CRUD
 *
 * @author JackieGu
 * @date 2021/12/27
 */
public class IndexRequest extends BaseRequest {

    /**
     * 创建索引
     * 备注：
     *   1. 从ES7开始，移除了类型(Type)概念，即一个索引(Index)中只有一个默认的类型(Type)，名为：_doc
     *   2. 从ES7开始，移除了index.mapper.dynamic配置，动态映射配置修改为mappings中的dynamic: true(默认)、false、strict
     *   3. 从ES5开始，移除了核心字段类型中的string
     *   4. 从ES7开始，新增了核心字段字符串类型：keyword和text；其中keyword适合简短、结构化字段，text适合需要被全文检索的字段
     */
    @Test
    public void create() {
        // 索引名称
        String name = "index_study";
        String url = MASTER_NODE_ADDRESS + "/" + name + "?pretty";
        LoggerUtil.info("URL:");
        System.out.println(url + "\n");
        LoggerUtil.info("Method:");
        System.out.println(Method.PUT + "\n");
        /*
         * ES7常用字段类型
         *   核心字段类型
         *     - 字符串: keyword, text
         *     - 数值型: long, integer, short, byte, double(双精度浮点类型), float(单精度浮点类型), half_float(半精度浮点类型), scaled_float(缩放浮点类型)
         *     - 布尔型: boolean
         *     - 日期型: date, date_nanos(纳秒级时间)
         *     - 二进制: binary
         *     - 范围型: long_range, integer_range, double_range, float_range, date_range, ip_range
         *   复合字段类型
         *     - 对象类型: object(单个JSON对象)
         *     - 嵌套类型: nested(多个JSON对象数组)
         *   地理字段类型
         *     - 地理坐标类型: geo_point(可存储经纬度坐标对)
         *     - 地理形状类型: geo_shape
         *   特殊字段类型
         *     - IP: ip
         *     - Completion: completion(提供自动补全建议)
         *     - Token count: token_count(统计字符串分词后的词项个数)
         *     - ......
         */
        String body = "{" +
            "  \"mappings\": {" +
            "    \"dynamic\": \"strict\"," +
            "    \"properties\": {" +
            "      \"name\": {" +
            "        \"type\": \"keyword\"" +
            "      }," +
            "      \"age\": {" +
            "        \"type\": \"integer\"" +
            "      }," +
            "      \"man\": {" +
            "        \"type\": \"boolean\"" +
            "      }," +
            "      \"birthday\": {" +
            "        \"type\": \"date\"" +
            "      }," +
            "      \"resume\": {" +
            "        \"type\": \"text\"" +
            "      }" +
            "    }" +
            "  }," +
            "  \"settings\": {" +
            "    \"index\": {" +
            "      \"number_of_shards\": 1," +
            "      \"number_of_replicas\": 0" +
            "    }" +
            "  }" +
            "}";
        LoggerUtil.info("Body:");
        System.out.println(JSONUtil.parse(body).toStringPretty() + "\n");
        String response = HttpUtil.createRequest(Method.PUT, url).body(body).execute().body();
        LoggerUtil.info("Response:");
        System.out.println(response);
    }

    /**
     * 删除索引
     */
    @Test
    public void delete() {
        // 索引名称
        String name = "index_study";
        String url = MASTER_NODE_ADDRESS + "/" + name + "?pretty";
        LoggerUtil.info("URL:");
        System.out.println(url + "\n");
        LoggerUtil.info("Method:");
        System.out.println(Method.DELETE + "\n");
        String response = HttpUtil.createRequest(Method.DELETE, url).execute().body();
        LoggerUtil.info("Response:");
        System.out.println(response);
    }

    /**
     * 修改索引
     */
    @Test
    public void update() {
        // 索引名称
        String name = "index_study";
        String url = MASTER_NODE_ADDRESS + "/" + name + "/_mapping?pretty";
        LoggerUtil.info("URL:");
        System.out.println(url + "\n");
        LoggerUtil.info("Method:");
        System.out.println(Method.PUT + "\n");
        String body = "{" +
            "  \"properties\": {" +
            "    \"family\": {" +
            "      \"type\": \"nested\"" +
            "    }" +
            "  }" +
            "}";
        LoggerUtil.info("Body:");
        System.out.println(JSONUtil.parse(body).toStringPretty() + "\n");
        String response = HttpUtil.createRequest(Method.PUT, url).body(body).execute().body();
        LoggerUtil.info("Response:");
        System.out.println(response);
    }

    /**
     * 查询索引
     */
    @Test
    public void get() {
        // 索引名称
        String name = "index_study";
        String url = MASTER_NODE_ADDRESS + "/" + name + "?pretty";
        LoggerUtil.info("URL:");
        System.out.println(url + "\n");
        LoggerUtil.info("Method:");
        System.out.println(Method.GET + "\n");
        String response = HttpUtil.get(url);
        LoggerUtil.info("Response:");
        System.out.println(response);
    }

    /**
     * 关闭索引
     */
    @Test
    public void close() {
        // 索引名称
        String name = "index_study";
        String url = MASTER_NODE_ADDRESS + "/" + name + "/_close?pretty";
        LoggerUtil.info("URL:");
        System.out.println(url + "\n");
        LoggerUtil.info("Method:");
        System.out.println(Method.POST + "\n");
        String response = HttpUtil.createRequest(Method.POST, url).execute().body();
        LoggerUtil.info("Response:");
        System.out.println(response);
    }

    /**
     * 打开索引
     */
    @Test
    public void open() {
        // 索引名称
        String name = "index_study";
        String url = MASTER_NODE_ADDRESS + "/" + name + "/_open?pretty";
        LoggerUtil.info("URL:");
        System.out.println(url + "\n");
        LoggerUtil.info("Method:");
        System.out.println(Method.POST + "\n");
        String response = HttpUtil.createRequest(Method.POST, url).execute().body();
        LoggerUtil.info("Response:");
        System.out.println(response);
    }
}
