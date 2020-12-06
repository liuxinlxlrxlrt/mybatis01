import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GaneratorSqlMap {
    public static void main(String[] args) throws Exception{
        generator();

    }

    public static void generator() throws Exception{
        try {
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            File file = new File("D:\\javaCode\\21_ProjectStorageFolder\\TestNG\\spring\\spring_mybatis_xml\\src\\main\\resources\\mybatis-generator.xml");
            ConfigurationParser configurationParser = new ConfigurationParser(warnings);
            Configuration  configuration = configurationParser.parseConfiguration(file);
            DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,shellCallback,warnings);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
