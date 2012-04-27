/*(C) 2007-2012 Alibaba Group Holding Limited.	

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import com.taobao.tddl.common.GroupDataSourceRouteHelper;
import com.taobao.tddl.jdbc.group.TGroupDataSource;

/**
 * Comment for GroupSampleCase
 * <p/>
 * Author By: zhuoxue.yll
 * Created Date: 2012-2-29 ����02:28:32 
 */
public class GroupSampleCase extends BaseSampleCase {

	protected static JdbcTemplate tddlJT;
	protected static TGroupDataSource tds;

	@BeforeClass
	public static void setUp() throws Exception {
		tddlJT = getJT(GROUP_KEY);
	}

	@Before
	public void init() throws Exception {
		// �����ݷ�ֹ����
		String sql = "delete from normaltbl_0001 where pk=?";
		GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(0);
		clearData(tddlJT, sql, new Object[] { RANDOM_ID });
		GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(1);
		clearData(tddlJT, sql, new Object[] { RANDOM_ID });
		GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(2);
		clearData(tddlJT, sql, new Object[] { RANDOM_ID });
	}

	@After
	public void destroy() {
		// �����ݷ�ֹ����
		String sql = "delete from normaltbl_0001 where pk=?";
		GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(0);
		clearData(tddlJT, sql, new Object[] { RANDOM_ID });
		GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(1);
		clearData(tddlJT, sql, new Object[] { RANDOM_ID });
		GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(2);
		clearData(tddlJT, sql, new Object[] { RANDOM_ID });
	}

	protected static JdbcTemplate getJT(String dbGroupKey) {
		tds = new TGroupDataSource();
		tds.setAppName(APPNAME);
		tds.setDbGroupKey(dbGroupKey);
		tds.init();
		return new JdbcTemplate(tds);
	}

}