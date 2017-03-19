package ccz.practise.xfire.spring.server.example;

import javax.jws.WebService;

/**
 * Created by 46043 on 2016/8/8.
 */

public class ExampleWSImpl implements ExampleWS {

    private ExampleService exampleService;

    public ExampleService getExampleService() {
        return exampleService;
    }

    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @Override
    public ExampleResponse getExample(ExampleRequest request) {
        exampleService.getExample(null, null, null);
        ExampleResponse exampleResponse = new ExampleResponse();
        exampleResponse.setResponseMsg("recieve");
        return exampleResponse;
    }



}
