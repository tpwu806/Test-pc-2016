package test2015up.com.day02.table4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.*;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class TableModel extends AbstractTableModel{

	
	private Vector rowData,columnName,row;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private ResultSetMetaData rsmd;
	
	
	public boolean UpdateModel(String sql,String []params)
	{ 
		SqlConTest hp=new SqlConTest();
		return hp.updateExecete(sql,params);
	}
	
	//显示表
	public void query(String sql,String[]params)
		{
			//初始化
			
		columnName=new Vector<String>();
			rowData=new Vector<Vector>();

			SqlConTest hp=new SqlConTest();
			rs=hp.queryExecute(sql, params);
			//Array[] list=new Array[];
			try {
				rsmd=rs.getMetaData();
				for(int i=0;i<rsmd.getColumnCount();i++)
				{
					this.columnName.add(rsmd.getColumnName(i+1));	
				}	
				while(rs.next())
				{
					row=new Vector<String>();
					for(int i=0;i<rsmd.getColumnCount();i++)
					{
						row.add(rs.getString(i+1));
					}
					rowData.add(row);
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			finally
			{
				hp.close();
			}
		}
	
	

	
	
	//得到列名
	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return (String)this.columnName.get(arg0);
	}
	//得到共有多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnName.size();
	}
    //多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	// 得到某行某列数据
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}

}
