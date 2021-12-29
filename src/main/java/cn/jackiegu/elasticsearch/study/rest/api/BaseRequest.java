package cn.jackiegu.elasticsearch.study.rest.api;

import cn.hutool.http.HttpUtil;

/**
 * Base
 *
 * @author JackieGu
 * @date 2021/12/27
 */
public class BaseRequest {

    protected static final String MASTER_NODE_ADDRESS = "http://vm007:9200";
    protected static final String SLAVE1_NODE_ADDRESS = "http://vm008:9200";

    public static void main(String[] args) {
        System.out.println("\033[94m主节点信息\033[0m");
        String master = HttpUtil.get(MASTER_NODE_ADDRESS);
        System.out.println(master);
        System.out.println("\033[94m从节点1信息\033[0m");
        String slave = HttpUtil.get(SLAVE1_NODE_ADDRESS);
        System.out.println(slave);
    }
}
