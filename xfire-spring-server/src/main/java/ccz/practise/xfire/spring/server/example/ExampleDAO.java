package ccz.practise.xfire.spring.server.example;

import ccz.practise.xfire.spring.server.util.PagationHelper;

import java.util.List;

/**
 * Created by 46043 on 2016/7/20.
 */
public interface ExampleDAO {
    List<Example> selectExample(Integer id, String msg, PagationHelper pagationHelper);
}
