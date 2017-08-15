package org.ncmao.config;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticsearchConfiguration implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchConfiguration.class);

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;

    private TransportClient transportClient;
    private PreBuiltXPackTransportClient preBuiltXPackTransportClient;


    @Override
    public void destroy() throws Exception {
        try {
            logger.info("Closing elasticsearch client");
            if (transportClient != null) {
                transportClient.close();
            }
        } catch (final Exception e) {
            logger.error("Error closing Elasticsearch client: ", e);
        }
    }

    @Override
    public TransportClient getObject() throws Exception {
        return transportClient;
    }

    @Override
    public Class<?> getObjectType() {
        return TransportClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        buildClient();
    }

    protected void buildClient() {
        try {
            preBuiltXPackTransportClient = new PreBuiltXPackTransportClient(settings());
            String InetSocket[] = clusterNodes.split(":");
            String address = InetSocket[0];
            Integer port = Integer.valueOf(InetSocket[1]);
            transportClient = preBuiltXPackTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(address), port));

        } catch (UnknownHostException e) {
            logger.error(e.getMessage());
        }
    }

    private Settings settings() {
        return Settings.builder().put("cluster.name", "coffee-log")
                .put("xpack.security.user", "elastic:changeme")
                .build();
    }
}
