package com.codeify.springboot01.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.codeify.springboot01.entity.EsStudent;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author codeify
 * @since 2023/09/03 17:07
 */
public class StudentIndexRestClient {
    public static final RestHighLevelClient client;
    private static String createStudentIndexTemplate = "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"info\": {\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },\n" +
            "      \"email\": {\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"name\": {\n" +
            "        \"type\": \"object\",\n" +
            "        \"properties\": {\n" +
            "          \"firstName\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "          },\n" +
            "          \"lastName\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";

    static {
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://localhost:9200")
        ));
    }

    public static final String INDEX_STUDENT = "student";


    public static void main(String[] args) throws IOException {
//        testCreateIndex();
//        testDeleteIndex();
//        createDocument();
    }



    private static void createDocument() throws IOException {
        IndexRequest indexRequest = Requests.indexRequest(INDEX_STUDENT);
        EsStudent esStudent = getStudent();
        indexRequest.source(JSON.toJSONString(esStudent), XContentType.JSON);
        //
        indexRequest.id("1");
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("indexResponse.getResult() = " + indexResponse.getResult());
    }

    private static EsStudent getStudent() {
        EsStudent esStudent = new EsStudent();
        EsStudent.Name name = new EsStudent.Name();
        name.setFirstName("hanbing");
        name.setLastName("sun");
        esStudent.setName(name);
        esStudent.setInfo("codefiy");
        esStudent.setEmail("codeify@163.com");
        return esStudent;
    }


    private static void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(INDEX_STUDENT);
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println("delete.isAcknowledged() = " + delete.isAcknowledged());
        System.out.println("delete = " + delete);
    }

    private static void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("student");
        request.source(createStudentIndexTemplate, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

}
