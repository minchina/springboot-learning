package org.ncmao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncmao.domain.Person;
import org.ncmao.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchQueryTest {

    @Autowired
    private TransportClient transportClient;

    @Test
    public void shouldIndexInfoSuccess() throws JsonProcessingException {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "Test");
        hashMap.put("age", "11");
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        IndexRequest execute = transportClient.prepareIndex("info", "person", "3").setSource(hashMap).request();
        BulkResponse bulkItemResponses = bulkRequestBuilder.add(execute).execute().actionGet();
        int successfulCount = bulkItemResponses.getItems()[0].getResponse().getShardInfo().getSuccessful();
        assertThat(successfulCount, is(1));
    }

    @Test
    public void shouldFindTheIndexedPerson() throws IOException {
        ObjectMapper mapper = ObjectMapperUtil.getInstance();
        GetResponse response = transportClient.prepareGet("info", "person", "3").get();
        String name = (String) response.getSource().get("name");
        String age = (String) response.getSource().get("age");
        Person person = mapper.readValue(response.getSourceAsString(), Person.class);
        assertThat(name, is("Test"));
        assertThat(age, is("11"));
    }
}
