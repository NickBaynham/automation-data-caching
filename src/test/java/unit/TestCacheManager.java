package unit;

import autodiscoverheal.cache.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCacheManager {

    @Test
    public void verifyGetInstanceOfCacheFromCacheManager() {
        Cache cache = CacheManager.getInstance("CacheManager");
        assertEquals(cache.getId(), "CacheManager");
    }
}
