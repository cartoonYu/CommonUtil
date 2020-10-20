package org.eureka.consumer.util.visit;

public interface VisitService {

    <T> T visit(String url, String interfaceName, String version, String data, Class<T> returnClass) throws Exception;
}
