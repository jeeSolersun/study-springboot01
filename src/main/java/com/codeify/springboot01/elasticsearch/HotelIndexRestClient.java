package com.codeify.springboot01.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.codeify.springboot01.entity.TbHotel;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.List;

/**
 * @author codeify
 * @since 2023/10/10 00:13
 */
public class HotelIndexRestClient {
    static RestHighLevelClient client = null;
    static {
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://localhost:9200")
        ));
    }
    private static void bulkInsertHotelToEs(List<TbHotel> hotelDtoList) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        IndexRequest indexRequest = new IndexRequest();
        for (TbHotel hotelDto : hotelDtoList) {
            indexRequest.source(JSON.toJSONString(hotelDto), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        client.bulk(bulkRequest, RequestOptions.DEFAULT);
    }
}
