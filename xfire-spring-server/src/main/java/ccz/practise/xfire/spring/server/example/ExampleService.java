package ccz.practise.xfire.spring.server.example;

import ccz.practise.xfire.spring.server.util.PagationHelper;

import java.util.List;

/**
 * Created by 46043 on 2016/7/26.
 */
public interface ExampleService {
    List<Example> getExample(Integer id, String msg, PagationHelper pagationHelper);
}
