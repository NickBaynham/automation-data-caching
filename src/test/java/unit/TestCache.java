package unit;

import autodiscoverheal.cache.Cache;
import autodiscoverheal.cache.ItemNotInCacheException;
import autodiscoverheal.cache.NoCacheException;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCache {

    @Test
    public void instantiateCache() {
        Cache cache = new Cache("unitTest");
        assertEquals(cache.getId(), "unitTest");
    }

    @Test
    public void addRetrieveFromCache() throws ItemNotInCacheException {
        Cache cache = new Cache("unitTest");

        // Add an item to the cache and retrieve it
        cache.add("item", "value");
        try {
            assertEquals(cache.get("item"), "value");
        } catch (ItemNotInCacheException e) {
            throw new ItemNotInCacheException("item");
        }
    }

    @Test
    public void deSerializeCacheWhenNotSerialized() {
        Cache cache = new Cache("deserialize");
        try {
            cache.deSerialize();
        } catch (NoCacheException e) {
            assertEquals(e.getMessage(), "deserialize");
        }
    }

    @Test
    public void verifyInvalidKey() {
        Cache cache = new Cache("invalidKey");
        try {
            cache.get("invalid");
        } catch (ItemNotInCacheException e) {
            assertEquals(e.getMessage(), "invalid");
        }
    }

    @Test
    public void verifySerializeDeserialize() throws NoCacheException {
        Cache cache = new Cache("locators");
        cache.serializeCache();
        cache.deSerialize();
    }
}
