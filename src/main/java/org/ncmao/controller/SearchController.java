package org.ncmao.controller;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/restful/search")
public class SearchController {

    @Autowired
    private TransportClient transportClient;


    @RequestMapping(value = "/")
    public String get(){
        return "success";
    }

    @RequestMapping(value = "/client/{articleId}")
    public BulkResponse test(@PathVariable String articleId) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "Test");
        hashMap.put("age", "11");
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        IndexRequest execute = transportClient.prepareIndex("info", "person", "1").setSource(hashMap).request();
        BulkResponse bulkItemResponses = bulkRequestBuilder.add(execute).execute().actionGet();
        transportClient.close();
        return bulkItemResponses;
    }
}
