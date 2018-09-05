package batch_address;

import java.sql.SQLException;
import java.util.List;

public interface AddrListDAO  {

	public int insertAddList (List<List<String>> list) throws SQLException;
}
