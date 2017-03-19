package ccz.practise.xfire.spring.server.example;

import ccz.practise.xfire.spring.server.util.PagationHelper;

import java.util.List;

/**
 * Created by 46043 on 2016/7/26.
 */
public class ExampleServiceImpl implements ExampleService {
    private ExampleDAO exampleDAO;

    public ExampleDAO getExampleDAO() {
        return exampleDAO;
    }

    public void setExampleDAO(ExampleDAO exampleDAO) {
        this.exampleDAO = exampleDAO;
    }

    @Override
    public List<Example> getExample(Integer id, String msg, PagationHelper pagationHelper) {
        return exampleDAO.selectExample(id, msg, pagationHelper);
    }
}
