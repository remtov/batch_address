package batch_address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



public class AddrListDAOImpl implements AddrListDAO{

	public int insertAddList (List<List<String>> list) throws SQLException {
		
	long s = System.currentTimeMillis();
	Connection con = DBCon.getCon();
	PreparedStatement ps = null;
	int rCnt = 0;
	String sql= "insert into addr_list values(seq_alnum.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
	try {
		ps=con.prepareStatement(sql);
		for(int j=0;j<list.size();j++) {
			List<String> strList = list.get(j);
			for(int i =0;i<strList.size();i++) {
				ps.setString(i+1, strList.get(i));
				
			}
			ps.addBatch();
			ps.clearParameters();
			if(j+1%1000==0 || j+1==list.size()) {
				rCnt += ps.executeBatch().length;
			}
		}
		DBCon.commit();
	}catch(SQLException e) {
		DBCon.rollback();
		e.printStackTrace();
	}finally{
		DBCon.close();
		
			}
	System.out.println("총 수행시간 : " +(System.currentTimeMillis()));
	return rCnt;
		
		
	}
	
	

}
