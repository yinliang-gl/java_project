package BigDataDemo.parquet;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.column.ParquetProperties;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.simple.SimpleGroup;
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
import org.apache.parquet.format.converter.ParquetMetadataConverter;
import org.apache.parquet.hadoop.ParquetFileReader;
import org.apache.parquet.hadoop.ParquetFileWriter;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.ExampleParquetWriter;
import org.apache.parquet.hadoop.example.GroupReadSupport;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.hadoop.metadata.ParquetMetadata;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;


/**
 * @author meter
 * 文件名：TestParquetReaderAndWriter
 * @描述：
 */
public class TestParquetReaderAndWriter {
    private static String parquet_file_path = "test.parq";

    private static String schemaStr = "message schema {" + "optional int64 log_id;"
            + "optional binary idc_id;" + "optional int64 house_id;"
            + "optional int64 src_ip_long;" + "optional int64 dest_ip_long;"
            + "optional int64 src_port;" + "optional int64 dest_port;"
            + "optional int32 protocol_type;" + "optional binary url64;"
            + "optional binary access_time;}";
    static MessageType schema = MessageTypeParser.parseMessageType(schemaStr);

    /**
     * 创建时间：2017-8-3
     * 创建者：meter
     * 返回值类型：void
     *
     * @描述：输出MessageType
     */
    public static void testParseSchema() {
        System.out.println(schema.toString());
    }

    /**
     * 创建时间：2017-8-3
     * 创建者：meter
     * 返回值类型：void
     *
     * @throws Exception
     * @描述：获取parquet的Schema
     */
    public static void testGetSchema() throws Exception {
        Configuration configuration = new Configuration();
//        // windows 下测试入库impala需要这个配置
//        System.setProperty("hadoop.home.dir",
//                "E:\\mvtech\\software\\hadoop-common-2.2.0-bin-master");
        ParquetMetadata readFooter = null;
        Path parquetFilePath = new Path(parquet_file_path);
        readFooter = ParquetFileReader.readFooter(configuration,
                parquetFilePath, ParquetMetadataConverter.NO_FILTER);
        MessageType schema = readFooter.getFileMetaData().getSchema();
        System.out.println(schema.toString());
    }

    /**
     * 创建时间：2017-8-3
     * 创建者：meter
     * 返回值类型：void
     *
     * @throws IOException
     * @描述：测试写parquet文件
     */
    private static void testParquetWriter() throws IOException {
        Path file = new Path(parquet_file_path);
        ExampleParquetWriter.Builder builder = ExampleParquetWriter
                .builder(file).withWriteMode(ParquetFileWriter.Mode.CREATE)
                .withWriterVersion(ParquetProperties.WriterVersion.PARQUET_2_0)
                .withCompressionCodec(CompressionCodecName.SNAPPY)
                //.withConf(configuration)
                .withType(schema);
        /*
         * file, new GroupWriteSupport(), CompressionCodecName.SNAPPY, 256 *
         * 1024 * 1024, 1 * 1024 * 1024, 512, true, false,
         * ParquetProperties.WriterVersion.PARQUET_1_0, conf
         */
        ParquetWriter<Group> writer = builder.build();
        SimpleGroupFactory groupFactory = new SimpleGroupFactory(schema);
        String[] access_log = {"111111", "22222", "33333", "44444", "55555",
                "666666", "777777", "888888", "999999", "101010"};
        for (int i = 0; i < 1000; i++) {
            Group group = groupFactory.newGroup()
                    .append("log_id", Long.parseLong(access_log[0]) + i)
                    .append("idc_id", access_log[1])
                    .append("house_id", Long.parseLong(access_log[2]))
                    .append("src_ip_long", Long.parseLong(access_log[3]))
                    .append("dest_ip_long", Long.parseLong(access_log[4]))
                    .append("src_port", Long.parseLong(access_log[5]))
                    .append("dest_port", Long.parseLong(access_log[6]))
                    .append("protocol_type", Integer.parseInt(access_log[7]))
                    .append("url64", access_log[8])
                    .append("access_time", access_log[9]);
            writer.write(group);
        }
        writer.close();
    }

    /**
     * 创建时间：2017-8-3
     * 创建者：meter
     * 返回值类型：void
     *
     * @throws IOException
     * @描述：测试读parquet文件
     */
    private static void testParquetReader() throws IOException {
        Path file = new Path(parquet_file_path);
        ParquetReader.Builder<Group> builder = ParquetReader.builder(new GroupReadSupport(), file);

        ParquetReader<Group> reader = builder.build();
        SimpleGroup group;
        while ((group = (SimpleGroup) reader.read()) != null) {
//            System.out.println(group.toString());
//            System.out.println("schema:" + group.getType().toString());
            System.out.println("log_id:" + group.getLong(0, 0));
        }
    }

    /**
     * 创建时间：2017-8-2 创建者：meter 返回值类型：void
     *
     * @param args
     * @throws Exception
     * @描述：
     */
    public static void main(String[] args) throws Exception {
        testParquetWriter();
//        testGetSchema();
//        testParseSchema();

//        testParquetReader();
    }

}

