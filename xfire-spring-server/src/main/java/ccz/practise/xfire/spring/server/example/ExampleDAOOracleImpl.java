package ccz.practise.xfire.spring.server.example;

import ccz.practise.xfire.spring.server.util.PagationHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 46043 on 2016/7/20.
 */
public class ExampleDAOOracleImpl implements ExampleDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Example> selectExample(Integer id, String msg, PagationHelper pagationHelper) {
        final HashMap<String, Object> paramMap = new HashMap<String, Object>();
        final List paramList = new ArrayList();

        StringBuilder whereSql = new StringBuilder();
        if(id != null) {
            whereSql.append(" and id = ? ");
            paramList.add(id);
        }
        if(StringUtils.isNotBlank(msg)) {
            whereSql.append(" and msg like ? ");
            paramList.add("%" + msg + "%");
        }

        StringBuilder baseSql = new StringBuilder();
        baseSql.append(" select * from EXAMPLE WHERE 1 = 1 ").append(whereSql);

        StringBuilder totalCountSql = new StringBuilder();
        totalCountSql.append(" select count(*) from EXAMPLE WHERE 1 = 1 ").append(whereSql);
        final Integer totalCount = jdbcTemplate.queryForInt(totalCountSql.toString(), paramList.toArray());
        pagationHelper.setTotalCount(totalCount);


        int firstIndex = (pagationHelper.getPageIndex() * pagationHelper.getPageSize()) + 1;
        int lastIndex = firstIndex + pagationHelper.getPageSize();
        StringBuilder pagationSql = new StringBuilder();
        pagationSql.append(" select * from(                  ")
           .append("    select o.*, ROWNUM rn from( ")
           .append(baseSql)
           .append("    ) o                          ")
           .append("    where ROWNUM < ?    ")
           .append(" )                              ")
           .append(" where rn >= ?       ");


        paramList.add(firstIndex);
        paramList.add(lastIndex);

        return jdbcTemplate.query(pagationSql.toString(), paramList.toArray(), new RowMapper() {
            @Override
            public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
                Example example = new Example();
                example.setId(rs.getInt("id"));
                example.setMsg(rs.getString("msg"));
                return example;
            }
        });
    }
}
