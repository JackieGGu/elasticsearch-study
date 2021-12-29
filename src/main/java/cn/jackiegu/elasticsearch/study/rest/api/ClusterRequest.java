package cn.jackiegu.elasticsearch.study.rest.api;

import cn.hutool.http.HttpUtil;
import org.junit.Test;

/**
 * 集群Info
 *
 * @author JackieGu
 * @date 2021/12/28
 */
public class ClusterRequest extends BaseRequest {

    /**
     * 查询集群节点
     * Cat这组API是特列, 将返回Table格式内容
     */
    @Test
    public void getNodes() {
        String url = MASTER_NODE_ADDRESS + "/_cat/nodes?v";
        String result = HttpUtil.get(url);
        System.out.println(result);
    }

    /**
     * 查询集群健康
     */
    @Test
    public void getHealth() {
        String url = MASTER_NODE_ADDRESS + "/_cat/health?v";
        String result = HttpUtil.get(url);
        System.out.println(result);
    }

    /**
     * 查询集群索引
     */
    @Test
    public void getIndices() {
        String url = MASTER_NODE_ADDRESS + "/_cat/indices?v";
        String result = HttpUtil.get(url);
        System.out.println(result);
    }

    /**
     * 查询集群统计信息
     */
    @Test
    public void getState() {
        String url = MASTER_NODE_ADDRESS + "/_cluster/state?pretty";
        String result = HttpUtil.get(url);
        System.out.println(result);
    }
}
