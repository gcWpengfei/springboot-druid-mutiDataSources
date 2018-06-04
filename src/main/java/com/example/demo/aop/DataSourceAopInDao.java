package com.example.demo.aop;

import com.example.demo.conf.DataSourceContextHolder;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 在dao层决定数据源(注：如果用这方式，service层不能使用事务，否则出问题，因为打开事务打开时，就会觉得数据库源了）
 * @author Jfei
 *
 */
//@Aspect
//@Component
public class DataSourceAopInDao {

	private static Logger log = LoggerFactory.getLogger(DataSourceAopInDao.class);
	
	@Before("execution(* com.example.demo.dao..*.find*(..)) "
			+ " or execution(* com.example.demo.dao..*.get*(..)) "
			+ " or execution(* com.example.demo.dao..*.query*(..))")
    public void setReadDataSourceType() {DataSourceContextHolder.setRead();}

    @Before("execution(* com.example.demo.dao..*.insert*(..)) "
    		+ " or execution(* com.example.demo.dao..*.update*(..))"
    		+ " or execution(* com.example.demo.dao..*.add*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }
    
    
/*    @Before("execution(* com.wpf.springboot.druidwriteread.dao..*.*(..)) "
			+ " and @annotation(com.wpf.springboot.druidwriteread.annotation.ReadDataSource) ")
	public void setReadDataSourceType() {
		//如果已经开启写事务了，那之后的所有读都从写库读
		if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
			DataSourceContextHolder.setRead();
		}
	    
	}
	
	@Before("execution(* com.wpf.springboot.druidwriteread.dao..*.*(..)) "
			+ " and @annotation(com.wpf.springboot.druidwriteread.annotation.WriteDataSource) ")
	public void setWriteDataSourceType() {
	    DataSourceContextHolder.setWrite();
	}*/
}
