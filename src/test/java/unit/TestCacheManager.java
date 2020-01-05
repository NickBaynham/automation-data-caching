package unit;

import autodiscoverheal.cache.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCacheManager {

    @Test
    public void testCacheManager() {
        Cache cache = CacheManager.getInstance("cacheExample");
        assertEquals(cache.getId(), "cacheExample");

        // TODO: add an item to the cache
        cache.add("item1", "value1");

        // TODO: Retrive an item from the cache

        // TODO: Remove an item from the cache

        // TODO: Clear Cache

        // TODO: Retrieve Usage Report on Cache
    }
}
