package com.yx.cacher;

import com.yx.model.Person;
import org.msgpack.MessagePack;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * User: LiWenC
 * Date: 16-11-21
 */
@Repository
public class PersonCache {
    @Resource
    private StringRedisTemplate redsTemplate;

    private static final MessagePack msgPack = new MessagePack();

    public static final String PREFIX = "PERSON_";
    public static final String Z_PREFIX = "Z_PERSON_";

    public boolean addPerson(final Person person) {
        boolean result = redsTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    connection.set(msgPack.write(PREFIX + person.getId()), msgPack.write(person));
                    connection.zAdd(msgPack.write(Z_PREFIX), person.getId(), msgPack.write(person.getId()));
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        return result;
    }

    public Person queryPersonById(final long id) {
        Person person = redsTemplate.execute(new RedisCallback<Person>() {
            public Person doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    byte[] person = connection.get(msgPack.write(PREFIX + id));
                    if (person != null) {
                        return msgPack.read(person, Person.class);
                    }
                } catch (Exception e) {
                    return null;
                }
                return null;
            }
        });
        return person;
    }
}
