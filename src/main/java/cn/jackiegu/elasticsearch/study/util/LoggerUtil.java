package cn.jackiegu.elasticsearch.study.util;

/**
 * 日志工具类
 *
 * @author JackieGu
 * @date 2021/4/2
 */
public class LoggerUtil {

    /**
     * 日志打印
     */
    public static void info(String str) {
        System.out.println("\033[94m" + str + "\033[0m");
    }

    /**
     * 返回线程名称
     */
    public static String threadName() {
        return "\033[92m" + Thread.currentThread().getName() + "\033[0m";
    }
}
