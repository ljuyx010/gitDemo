package net.dpwl.hellospringboot.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import net.dpwl.hellospringboot.entity.User;
import org.springframework.boot.jackson.JacksonComponent;

import java.io.IOException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/9 14:11
 */
@JacksonComponent
public class UserJsonCustom {
    public static class Serializer extends JsonSerializer<User> {
        // 自定义对User对象进行序列化
        @Override
        public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeObjectField("id", user.getId());  // 序列化id为user对象的getId()的值
            jsonGenerator.writeObjectField("name", "其他表的查询结果"); // 可以根据业务需求自定义pojo对象的值，比如其他数据库的查询结果
            /*jsonGenerator.writeFieldName("password"); 单独写key
            jsonGenerator.writeObject(user.getPassword()); 单独写value
            */
            // 1. 一次查不出完整的数据返回给客户端，需要根据需求去做一些个性化调整
            // 2. 根据不同的权限给他返回不同的序列化数据
        }
    }

    public static class Deserializer extends JsonDeserializer<User> {
        // 对Json数据进行反序列化为User对象
        @Override
        public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
            User user = new User();
            // 这里可以编写自定义的反序列化逻辑
            JsonNode node = jsonParser.getCodec().readTree(jsonParser); // 获取json数据的数据节点
            user.setId(node.findValue("id").asInt()); //从数据节点中找到id，并转成Int，赋值给user对象的id
            return user;
        }
    }
}
