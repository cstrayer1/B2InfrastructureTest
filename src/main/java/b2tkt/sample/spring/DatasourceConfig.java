package b2tkt.sample.spring;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import blackboard.db.impl.BbDatabaseDataSource;
import blackboard.platform.db.JdbcServiceFactory;
import blackboard.util.StringUtil;;

/**
 * @author jarias
 * @since Aug 19, 2010 2:36:08 PM
 */
@Configuration
public class DatasourceConfig {
   private static final Logger logger= LoggerFactory.getLogger(DatasourceConfig.class);

   @Value("${bb.datasource.key}")
   private String bbDatasourceKey;

   @Bean(name = "dataSource")
   public DataSource getDataSource() {
      try {
        logger.debug( "Default dataSourceKey value from properties is: "+bbDatasourceKey );
        String dbKey = null;
        
        try{
          dbKey = JdbcServiceFactory.getInstance().getDefaultDatabase().getDescriptor().getKey();
          logger.debug( "Data description key from properties is: "+bbDatasourceKey );
        }catch(Exception e){
          logger.warn( "Exception raised trying to retrieve DB Instance name through JdbcServiceFactory",e );
        }
        if(!StringUtil.isEmpty( dbKey )){
          bbDatasourceKey = dbKey;
          logger.debug( "Updated bbDatasourceKey variable with value extracted from Blackboard." );
        }
        return new BbDatabaseDataSource(bbDatasourceKey);
      } catch (Exception e) {
         logger.error("Couldn't get datasource", e);
      }
      return null;
   }
}
