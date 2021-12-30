package cn.jackiegu.elasticsearch.study.rest.api;

import cn.hutool.http.HttpUtil;
import cn.jackiegu.elasticsearch.study.util.LoggerUtil;

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
        LoggerUtil.info("主节点信息:");
        String master = HttpUtil.get(MASTER_NODE_ADDRESS);
        System.out.println(master);
        LoggerUtil.info("从节点信息:");
        String slave = HttpUtil.get(SLAVE1_NODE_ADDRESS);
        System.out.println(slave);
    }
}
